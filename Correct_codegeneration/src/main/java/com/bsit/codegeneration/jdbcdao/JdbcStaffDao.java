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
import com.bsit.codegeneration.pojo.Staff;
import com.bsit.codegeneration.pojo.Address;
import com.bsit.codegeneration.pojo.Store;

public class JdbcStaffDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcStaffDao.class);

    private static final String TABLE = "staff";

    private static final String COL_STAFF_ID = "staff_id";

    private static final String COL_FIRST_NAME = "first_name";

    private static final String COL_LAST_NAME = "last_name";

    private static final String COL_ADDRESS_ID = "address_id";

    private static final String COL_EMAIL = "email";

    private static final String COL_STORE_ID = "store_id";

    private static final String COL_ACTIVE = "active";

    private static final String COL_USERNAME = "username";

    private static final String COL_PASSWORD = "password";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String COL_PICTURE = "picture";

    private static final String SELECT_COLUMNS = "staff_id, first_name, last_name, address_id, email, store_id, active, username, password, last_update, picture";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_FIRST_NAME, COL_LAST_NAME, COL_ADDRESS_ID, COL_EMAIL, COL_STORE_ID, COL_ACTIVE, COL_USERNAME, COL_PASSWORD, COL_LAST_UPDATE, COL_PICTURE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted(SELECT_COLUMNS, TABLE, COL_STAFF_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_FIRST_NAME, COL_LAST_NAME, COL_ADDRESS_ID, COL_EMAIL, COL_STORE_ID, COL_ACTIVE, COL_USERNAME, COL_PASSWORD, COL_LAST_UPDATE, COL_PICTURE, COL_STAFF_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STAFF_ID);

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

    public int insert(Connection conn, Staff staff) throws SQLException {
        LOGGER.debug("Inserting staff: {}", staff);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setStaffParams(ps, staff);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    staff.setStaffID(id);
                    return id;
                } else {
                    LOGGER.error("Failed to retrieve generated ID for inserted staff");
                    throw new SQLException("Failed to retrieve generated ID for inserted staff");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Staff> staffs) throws SQLException {
        if (isInvalidStaffList(staffs)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Staff>> batches = chunkList(staffs, batchSize);
        int[] totalResults = new int[staffs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Staff> batch : batches) {
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

    private boolean isInvalidStaffList(List<Staff> staffs) {
        if (staffs == null || staffs.isEmpty()) {
            return true;
        }
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        return false;
    }

    private int[] processBatch(Connection conn, List<Staff> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Staff staff : batch) {
                setStaffParams(ps, staff);
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
                    batch.get(i).setStaffID(keys.get(i));
                }
            }
            return results;
        }
    }

    public Staff findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_STAFF_ID))) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Staff> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Staff> list = new ArrayList<>();
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

    public boolean update(Connection conn, Staff staff) throws SQLException {
        if (staff.getStaffID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setStaffParams(ps, staff);
            ps.setInt(11, staff.getStaffID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Staff> staffs) throws SQLException {
        if (isInvalidUpdateStaffList(staffs)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Staff>> batches = chunkList(staffs, batchSize);
        int[] totalResults = new int[staffs.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Staff> batch : batches) {
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

    private boolean isInvalidUpdateStaffList(List<Staff> staffs) {
        if (staffs == null || staffs.isEmpty()) {
            return true;
        }
        for (Staff staff : staffs) {
            if (staff == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (staff.getStaffID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        return false;
    }

    private int[] processUpdateBatch(Connection conn, List<Staff> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Staff staff : batch) {
                setStaffParams(ps, staff);
                ps.setInt(11, staff.getStaffID());
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
        String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_STAFF_ID, placeholders);
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

    public List<Staff> findByAddressID(Connection conn, int addressID) throws SQLException {
        List<Staff> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_ADDRESS_ID))) {
            ps.setInt(1, addressID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<Staff> findByStoreID(Connection conn, int storeID) throws SQLException {
        List<Staff> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_STORE_ID))) {
            ps.setInt(1, storeID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setStaffParams(PreparedStatement ps, Staff staff) throws SQLException {
        setNullable(ps, 1, staff.getFirstName(), Types.VARCHAR);
        setNullable(ps, 2, staff.getLastName(), Types.VARCHAR);
        setNullable(ps, 3, staff.getAddress() != null ? staff.getAddress().getAddressID() : null, Types.INTEGER);
        setNullable(ps, 4, staff.getEmail(), Types.VARCHAR);
        setNullable(ps, 5, staff.getStore() != null ? staff.getStore().getStoreID() : null, Types.INTEGER);
        setNullable(ps, 6, staff.getActive(), Types.BOOLEAN);
        setNullable(ps, 7, staff.getUsername(), Types.VARCHAR);
        setNullable(ps, 8, staff.getPassword(), Types.VARCHAR);
        setNullable(ps, 9, staff.getLastUpdate() != null ? java.sql.Timestamp.valueOf(staff.getLastUpdate()) : null, Types.TIMESTAMP);
        setNullable(ps, 10, staff.getPicture(), Types.VARCHAR);
    }

    private Staff extract(ResultSet rs) throws SQLException {
        Staff staff = new Staff();
        Integer staff_id = rs.getObject(COL_STAFF_ID, Integer.class);
        staff.setStaffID(staff_id);
        staff.setFirstName(rs.getString(COL_FIRST_NAME));
        staff.setLastName(rs.getString(COL_LAST_NAME));
        Integer address_id = rs.getObject(COL_ADDRESS_ID, Integer.class);
        staff.setAddressID(address_id);
        if (address_id != null) {
            Address address = new Address();
            address.setAddressID(address_id);
            staff.setAddress(address);
        }
        staff.setEmail(rs.getString(COL_EMAIL));
        Integer store_id = rs.getObject(COL_STORE_ID, Integer.class);
        staff.setStoreID(store_id);
        if (store_id != null) {
            Store store = new Store();
            store.setStoreID(store_id);
            staff.setStore(store);
        }
        Boolean active = rs.getObject(COL_ACTIVE, Boolean.class);
        staff.setActive(active);
        staff.setUsername(rs.getString(COL_USERNAME));
        staff.setPassword(rs.getString(COL_PASSWORD));
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            staff.setLastUpdate(last_update.toLocalDateTime());
        staff.setPicture(rs.getString(COL_PICTURE));
        return staff;
    }
}
