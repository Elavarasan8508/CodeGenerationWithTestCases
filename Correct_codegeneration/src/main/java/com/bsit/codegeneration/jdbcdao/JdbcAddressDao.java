package com.bsit.codegeneration.jdbcdao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import com.bsit.codegeneration.pojo.Address;
import com.bsit.codegeneration.pojo.City;

public class JdbcAddressDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcAddressDao.class);

    private static final String TABLE = "address";

    private static final String COL_ADDRESS_ID = "address_id";

    private static final String COL_ADDRESS = "address";

    private static final String COL_ADDRESS2 = "address2";

    private static final String COL_DISTRICT = "district";

    private static final String COL_CITY_ID = "city_id";

    private static final String COL_POSTAL_CODE = "postal_code";

    private static final String COL_PHONE = "phone";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String SELECT_COLUMNS = "address_id, address, address2, district, city_id, postal_code, phone, last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ADDRESS, COL_ADDRESS2, COL_DISTRICT, COL_CITY_ID, COL_POSTAL_CODE, COL_PHONE, COL_LAST_UPDATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted(SELECT_COLUMNS, TABLE, COL_ADDRESS_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_ADDRESS, COL_ADDRESS2, COL_DISTRICT, COL_CITY_ID, COL_POSTAL_CODE, COL_PHONE, COL_LAST_UPDATE, COL_ADDRESS_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ADDRESS_ID);

    private static <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }

    private static String getSelectByColumnSql(String column) {
        return """
            SELECT %s FROM %s WHERE %s = ?
            """.formatted(SELECT_COLUMNS, TABLE, column);
    }

    private static void setNullable(PreparedStatement ps, int index, Object value, int sqlType) throws SQLException {
        if (value != null)
            ps.setObject(index, value, sqlType);
        else
            ps.setNull(index, sqlType);
    }

    public int insert(Connection conn, Address address) throws SQLException {
        LOGGER.debug("Inserting address: {}", address);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setAddressParams(ps, address);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    address.setAddressID(id);
                    return id;
                } else {
                    LOGGER.error("Failed to retrieve generated ID for inserted address");
                    throw new SQLException("Failed to retrieve generated ID for inserted address");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Address> addresss) throws SQLException {
        if (isInvalidAddressList(addresss)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Address>> batches = chunkList(addresss, batchSize);
        int[] totalResults = new int[addresss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Address> batch : batches) {
                int[] results = processBatch(conn, batch);
                System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                resultIndex += results.length;
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            LOGGER.error("Batch insert failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    private boolean isInvalidAddressList(List<Address> addresss) {
        if (addresss == null || addresss.isEmpty()) {
            return true;
        }
        for (int i = 0; i < addresss.size(); i++) {
            if (addresss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        return false;
    }

    private int[] processBatch(Connection conn, List<Address> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Address address : batch) {
                setAddressParams(ps, address);
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            LOGGER.debug("Inserted {} rows in batch", results.length);
            try (ResultSet rs = ps.getGeneratedKeys()) {
                List<Integer> keys = new ArrayList<>();
                while (rs.next()) {
                    keys.add(rs.getInt(1));
                }
                for (int i = 0; i < batch.size() && i < keys.size(); i++) {
                    batch.get(i).setAddressID(keys.get(i));
                }
            }
            return results;
        }
    }

    public Address findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_ADDRESS_ID))) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Address> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Address> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, (page - 1) * pageSize);
            ps.setInt(2, pageSize);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public boolean update(Connection conn, Address address) throws SQLException {
        if (address.getAddressID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setAddressParams(ps, address);
            ps.setInt(8, address.getAddressID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Address> addresss) throws SQLException {
        if (isInvalidUpdateAddressList(addresss)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Address>> batches = chunkList(addresss, batchSize);
        int[] totalResults = new int[addresss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Address> batch : batches) {
                int[] results = processUpdateBatch(conn, batch);
                System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                resultIndex += results.length;
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            LOGGER.error("Batch update failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    private boolean isInvalidUpdateAddressList(List<Address> addresss) {
        if (addresss == null || addresss.isEmpty()) {
            return true;
        }
        for (Address address : addresss) {
            if (address == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (address.getAddressID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        return false;
    }

    private int[] processUpdateBatch(Connection conn, List<Address> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Address address : batch) {
                setAddressParams(ps, address);
                ps.setInt(8, address.getAddressID());
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            LOGGER.debug("Updated {} rows in batch", results.length);
            return results;
        } catch (SQLException e) {
            LOGGER.error("Batch update failed", e);
            throw e;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (isInvalidIdsList(ids)) {
            return 0;
        }
        int chunkSize = 1000;
        List<List<Integer>> chunks = chunkList(ids, chunkSize);
        int totalDeleted = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Integer> chunk : chunks) {
                int affected = processDeleteChunk(conn, chunk);
                totalDeleted += affected;
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            LOGGER.error("Batch delete failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalDeleted;
    }

    private boolean isInvalidIdsList(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return true;
        }
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        return false;
    }

    private int processDeleteChunk(Connection conn, List<Integer> chunk) throws SQLException {
        String placeholders = String.join(", ", java.util.Collections.nCopies(chunk.size(), "?"));
        String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ADDRESS_ID, placeholders);
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < chunk.size(); i++) {
                ps.setInt(i + 1, chunk.get(i));
            }
            int affected = ps.executeUpdate();
            LOGGER.debug("Deleted {} rows in batch", affected);
            return affected;
        } catch (SQLException e) {
            LOGGER.error("Batch delete failed", e);
            throw e;
        }
    }

    public List<Address> findByCityID(Connection conn, int cityID) throws SQLException {
        List<Address> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_CITY_ID))) {
            ps.setInt(1, cityID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setAddressParams(PreparedStatement ps, Address address) throws SQLException {
        setNullable(ps, 1, address.getAddress(), Types.VARCHAR);
        setNullable(ps, 2, address.getAddress2(), Types.VARCHAR);
        setNullable(ps, 3, address.getDistrict(), Types.VARCHAR);
        setNullable(ps, 4, address.getCity() != null ? address.getCity().getCityID() : null, Types.INTEGER);
        setNullable(ps, 5, address.getPostalCode(), Types.VARCHAR);
        setNullable(ps, 6, address.getPhone(), Types.VARCHAR);
        setNullable(ps, 7, address.getLastUpdate() != null ? java.sql.Timestamp.valueOf(address.getLastUpdate()) : null, Types.TIMESTAMP);
    }

    private Address extract(ResultSet rs) throws SQLException {
        Address address = new Address();
        Integer address_id = rs.getObject(COL_ADDRESS_ID, Integer.class);
        address.setAddressID(address_id);
        address.setAddress(rs.getString(COL_ADDRESS));
        address.setAddress2(rs.getString(COL_ADDRESS2));
        address.setDistrict(rs.getString(COL_DISTRICT));
        Integer city_id = rs.getObject(COL_CITY_ID, Integer.class);
        address.setCityID(city_id);
        if (city_id != null) {
            City city = new City();
            city.setCityID(city_id);
            address.setCity(city);
        }
        address.setPostalCode(rs.getString(COL_POSTAL_CODE));
        address.setPhone(rs.getString(COL_PHONE));
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            address.setLastUpdate(last_update.toLocalDateTime());
        return address;
    }
}
