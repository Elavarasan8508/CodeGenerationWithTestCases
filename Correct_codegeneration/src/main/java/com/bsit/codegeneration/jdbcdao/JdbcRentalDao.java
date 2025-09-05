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
import com.bsit.codegeneration.pojo.Rental;
import com.bsit.codegeneration.pojo.Staff;
import com.bsit.codegeneration.pojo.Inventory;
import com.bsit.codegeneration.pojo.Customer;

public class JdbcRentalDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcRentalDao.class);

    private static final String TABLE = "rental";

    private static final String COL_RENTAL_ID = "rental_id";

    private static final String COL_RENTAL_DATE = "rental_date";

    private static final String COL_INVENTORY_ID = "inventory_id";

    private static final String COL_CUSTOMER_ID = "customer_id";

    private static final String COL_RETURN_DATE = "return_date";

    private static final String COL_STAFF_ID = "staff_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String SELECT_COLUMNS = "rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_RENTAL_DATE, COL_INVENTORY_ID, COL_CUSTOMER_ID, COL_RETURN_DATE, COL_STAFF_ID, COL_LAST_UPDATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted(SELECT_COLUMNS, TABLE, COL_RENTAL_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_RENTAL_DATE, COL_INVENTORY_ID, COL_CUSTOMER_ID, COL_RETURN_DATE, COL_STAFF_ID, COL_LAST_UPDATE, COL_RENTAL_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_RENTAL_ID);

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

    public int insert(Connection conn, Rental rental) throws SQLException {
        LOGGER.debug("Inserting rental: {}", rental);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setRentalParams(ps, rental);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    rental.setRentalID(id);
                    return id;
                } else {
                    LOGGER.error("Failed to retrieve generated ID for inserted rental");
                    throw new SQLException("Failed to retrieve generated ID for inserted rental");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Rental> rentals) throws SQLException {
        if (isInvalidRentalList(rentals)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Rental>> batches = chunkList(rentals, batchSize);
        int[] totalResults = new int[rentals.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Rental> batch : batches) {
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

    private boolean isInvalidRentalList(List<Rental> rentals) {
        if (rentals == null || rentals.isEmpty()) {
            return true;
        }
        for (int i = 0; i < rentals.size(); i++) {
            if (rentals.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        return false;
    }

    private int[] processBatch(Connection conn, List<Rental> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Rental rental : batch) {
                setRentalParams(ps, rental);
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
                    batch.get(i).setRentalID(keys.get(i));
                }
            }
            return results;
        }
    }

    public Rental findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_RENTAL_ID))) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Rental> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Rental> list = new ArrayList<>();
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

    public boolean update(Connection conn, Rental rental) throws SQLException {
        if (rental.getRentalID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setRentalParams(ps, rental);
            ps.setInt(7, rental.getRentalID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Rental> rentals) throws SQLException {
        if (isInvalidUpdateRentalList(rentals)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Rental>> batches = chunkList(rentals, batchSize);
        int[] totalResults = new int[rentals.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Rental> batch : batches) {
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

    private boolean isInvalidUpdateRentalList(List<Rental> rentals) {
        if (rentals == null || rentals.isEmpty()) {
            return true;
        }
        for (Rental rental : rentals) {
            if (rental == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (rental.getRentalID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        return false;
    }

    private int[] processUpdateBatch(Connection conn, List<Rental> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Rental rental : batch) {
                setRentalParams(ps, rental);
                ps.setInt(7, rental.getRentalID());
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
        String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_RENTAL_ID, placeholders);
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

    public List<Rental> findByCustomerID(Connection conn, int customerID) throws SQLException {
        List<Rental> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_CUSTOMER_ID))) {
            ps.setInt(1, customerID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<Rental> findByInventoryID(Connection conn, int inventoryID) throws SQLException {
        List<Rental> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_INVENTORY_ID))) {
            ps.setInt(1, inventoryID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<Rental> findByStaffID(Connection conn, int staffID) throws SQLException {
        List<Rental> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_STAFF_ID))) {
            ps.setInt(1, staffID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setRentalParams(PreparedStatement ps, Rental rental) throws SQLException {
        setNullable(ps, 1, rental.getRentalDate() != null ? java.sql.Timestamp.valueOf(rental.getRentalDate()) : null, Types.TIMESTAMP);
        setNullable(ps, 2, rental.getInventory() != null ? rental.getInventory().getInventoryID() : null, Types.INTEGER);
        setNullable(ps, 3, rental.getCustomer() != null ? rental.getCustomer().getCustomerID() : null, Types.INTEGER);
        setNullable(ps, 4, rental.getReturnDate() != null ? java.sql.Timestamp.valueOf(rental.getReturnDate()) : null, Types.TIMESTAMP);
        setNullable(ps, 5, rental.getStaff() != null ? rental.getStaff().getStaffID() : null, Types.INTEGER);
        setNullable(ps, 6, rental.getLastUpdate() != null ? java.sql.Timestamp.valueOf(rental.getLastUpdate()) : null, Types.TIMESTAMP);
    }

    private Rental extract(ResultSet rs) throws SQLException {
        Rental rental = new Rental();
        Integer rental_id = rs.getObject(COL_RENTAL_ID, Integer.class);
        rental.setRentalID(rental_id);
        Timestamp rental_date = rs.getTimestamp(COL_RENTAL_DATE);
        if (rental_date != null)
            rental.setRentalDate(rental_date.toLocalDateTime());
        Integer inventory_id = rs.getObject(COL_INVENTORY_ID, Integer.class);
        rental.setInventoryID(inventory_id);
        if (inventory_id != null) {
            Inventory inventory = new Inventory();
            inventory.setInventoryID(inventory_id);
            rental.setInventory(inventory);
        }
        Integer customer_id = rs.getObject(COL_CUSTOMER_ID, Integer.class);
        rental.setCustomerID(customer_id);
        if (customer_id != null) {
            Customer customer = new Customer();
            customer.setCustomerID(customer_id);
            rental.setCustomer(customer);
        }
        Timestamp return_date = rs.getTimestamp(COL_RETURN_DATE);
        if (return_date != null)
            rental.setReturnDate(return_date.toLocalDateTime());
        Integer staff_id = rs.getObject(COL_STAFF_ID, Integer.class);
        rental.setStaffID(staff_id);
        if (staff_id != null) {
            Staff staff = new Staff();
            staff.setStaffID(staff_id);
            rental.setStaff(staff);
        }
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            rental.setLastUpdate(last_update.toLocalDateTime());
        return rental;
    }
}
