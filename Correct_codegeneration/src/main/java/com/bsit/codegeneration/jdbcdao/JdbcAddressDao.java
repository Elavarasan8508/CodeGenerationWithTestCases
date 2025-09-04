package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.stream.Collectors;

public class JdbcAddressDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcAddressDao.class);

    private static final String TABLE = "address";

    private static final String COL_ADDRESS_ID = "address_id";

    private static final String COL_ADDRESS = "address";

    private static final String COL_ADDRESS2 = "address2";

    private static final String COL_DISTRICT = "district";

    private static final String COL_CITY_ID = "city_id";

    private static final String COL_POSTAL_CODE = "postal_code";

    private static final String COL_PHONE = "phone";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_ADDRESS, COL_ADDRESS2, COL_DISTRICT, COL_CITY_ID, COL_POSTAL_CODE, COL_PHONE, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("address_id, address, address2, district, city_id, postal_code, phone, last_update", TABLE, COL_ADDRESS_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("address_id, address, address2, district, city_id, postal_code, phone, last_update", TABLE, COL_ADDRESS_ID);

    private static final String SELECT_BY_CITY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("address_id, address, address2, district, city_id, postal_code, phone, last_update", TABLE, COL_CITY_ID);

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

    public int insert(Connection conn, Address address) throws SQLException {
        logger.debug("Inserting address: {}", address);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setAddressParams(ps, address);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    address.setAddressID(id);
                    return id;
                } else {
                    logger.error("Failed to retrieve generated ID for inserted address");
                    throw new SQLException("Failed to retrieve generated ID for inserted address");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Address> addresss) throws SQLException {
        if (addresss == null || addresss.isEmpty())
            return new int[0];
        for (int i = 0; i < addresss.size(); i++) {
            if (addresss.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        int batchSize = 500;
        List<List<Address>> batches = chunkList(addresss, batchSize);
        int[] totalResults = new int[addresss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Address> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                    for (Address address : batch) {
                        setAddressParams(ps, address);
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                    logger.debug("Inserted {} rows in batch", results.length);
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        List<Integer> keys = new ArrayList<>();
                        while (rs.next()) {
                            keys.add(rs.getInt(1));
                        }
                        for (int i = 0; i < batch.size() && i < keys.size(); i++) {
                            batch.get(i).setAddressID(keys.get(i));
                        }
                    }
                } catch (SQLException e) {
                }
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch insert failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    public Address findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
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
        if (addresss == null || addresss.isEmpty())
            return new int[0];
        for (Address address : addresss) {
            if (address == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (address.getAddressID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        int batchSize = 500;
        List<List<Address>> batches = chunkList(addresss, batchSize);
        int[] totalResults = new int[addresss.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Address> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Address address : batch) {
                        setAddressParams(ps, address);
                        ps.setInt(8, address.getAddressID());
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                    logger.debug("Updated {} rows in batch", results.length);
                } catch (SQLException e) {
                }
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch update failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return 0;
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        int chunkSize = 1000;
        List<List<Integer>> chunks = chunkList(ids, chunkSize);
        int totalDeleted = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Integer> chunk : chunks) {
                String placeholders = String.join(", ", java.util.Collections.nCopies(chunk.size(), "?"));
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_ADDRESS_ID, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setInt(i + 1, chunk.get(i));
                    }
                    int affected = ps.executeUpdate();
                    totalDeleted += affected;
                    logger.debug("Deleted {} rows in batch", affected);
                } catch (SQLException e) {
                }
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch delete failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalDeleted;
    }

    public List<Address> findByCityID(Connection conn, int cityID) throws SQLException {
        List<Address> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CITY_ID_SQL)) {
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
        ps.setObject(1, address.getAddress(), Types.VARCHAR);
        ps.setObject(2, address.getAddress2(), Types.VARCHAR);
        ps.setObject(3, address.getDistrict(), Types.VARCHAR);
        if (address.getCity() != null) {
            ps.setObject(4, address.getCity().getCityID(), Types.INTEGER);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        ps.setObject(5, address.getPostalCode(), Types.VARCHAR);
        ps.setObject(6, address.getPhone(), Types.VARCHAR);
        java.time.LocalDateTime val7 = address.getLastUpdate();
        if (val7 != null) {
            ps.setObject(7, java.sql.Timestamp.valueOf(val7), Types.TIMESTAMP);
        } else {
            ps.setNull(7, Types.TIMESTAMP);
        }
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
