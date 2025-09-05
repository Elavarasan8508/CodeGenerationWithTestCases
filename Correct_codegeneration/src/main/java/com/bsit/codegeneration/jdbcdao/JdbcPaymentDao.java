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
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.Payment;
import com.bsit.codegeneration.pojo.Rental;
import com.bsit.codegeneration.pojo.Staff;
import com.bsit.codegeneration.pojo.Customer;

public class JdbcPaymentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcPaymentDao.class);

    private static final String TABLE = "payment";

    private static final String COL_PAYMENT_ID = "payment_id";

    private static final String COL_CUSTOMER_ID = "customer_id";

    private static final String COL_STAFF_ID = "staff_id";

    private static final String COL_RENTAL_ID = "rental_id";

    private static final String COL_AMOUNT = "amount";

    private static final String COL_PAYMENT_DATE = "payment_date";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String SELECT_COLUMNS = "payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_CUSTOMER_ID, COL_STAFF_ID, COL_RENTAL_ID, COL_AMOUNT, COL_PAYMENT_DATE, COL_LAST_UPDATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted(SELECT_COLUMNS, TABLE, COL_PAYMENT_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CUSTOMER_ID, COL_STAFF_ID, COL_RENTAL_ID, COL_AMOUNT, COL_PAYMENT_DATE, COL_LAST_UPDATE, COL_PAYMENT_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_PAYMENT_ID);

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

    public int insert(Connection conn, Payment payment) throws SQLException {
        LOGGER.debug("Inserting payment: {}", payment);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setPaymentParams(ps, payment);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    payment.setPaymentID(id);
                    return id;
                } else {
                    LOGGER.error("Failed to retrieve generated ID for inserted payment");
                    throw new SQLException("Failed to retrieve generated ID for inserted payment");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Payment> payments) throws SQLException {
        if (isInvalidPaymentList(payments)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Payment>> batches = chunkList(payments, batchSize);
        int[] totalResults = new int[payments.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Payment> batch : batches) {
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

    private boolean isInvalidPaymentList(List<Payment> payments) {
        if (payments == null || payments.isEmpty()) {
            return true;
        }
        for (int i = 0; i < payments.size(); i++) {
            if (payments.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        return false;
    }

    private int[] processBatch(Connection conn, List<Payment> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Payment payment : batch) {
                setPaymentParams(ps, payment);
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
                    batch.get(i).setPaymentID(keys.get(i));
                }
            }
            return results;
        }
    }

    public Payment findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_PAYMENT_ID))) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Payment> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Payment> list = new ArrayList<>();
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

    public boolean update(Connection conn, Payment payment) throws SQLException {
        if (payment.getPaymentID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setPaymentParams(ps, payment);
            ps.setInt(7, payment.getPaymentID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Payment> payments) throws SQLException {
        if (isInvalidUpdatePaymentList(payments)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Payment>> batches = chunkList(payments, batchSize);
        int[] totalResults = new int[payments.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Payment> batch : batches) {
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

    private boolean isInvalidUpdatePaymentList(List<Payment> payments) {
        if (payments == null || payments.isEmpty()) {
            return true;
        }
        for (Payment payment : payments) {
            if (payment == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (payment.getPaymentID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        return false;
    }

    private int[] processUpdateBatch(Connection conn, List<Payment> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Payment payment : batch) {
                setPaymentParams(ps, payment);
                ps.setInt(7, payment.getPaymentID());
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
        String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_PAYMENT_ID, placeholders);
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

    public List<Payment> findByCustomerID(Connection conn, int customerID) throws SQLException {
        List<Payment> list = new ArrayList<>();
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

    public List<Payment> findByRentalID(Connection conn, int rentalID) throws SQLException {
        List<Payment> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_RENTAL_ID))) {
            ps.setInt(1, rentalID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<Payment> findByStaffID(Connection conn, int staffID) throws SQLException {
        List<Payment> list = new ArrayList<>();
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

    private void setPaymentParams(PreparedStatement ps, Payment payment) throws SQLException {
        setNullable(ps, 1, payment.getCustomer() != null ? payment.getCustomer().getCustomerID() : null, Types.INTEGER);
        setNullable(ps, 2, payment.getStaff() != null ? payment.getStaff().getStaffID() : null, Types.INTEGER);
        setNullable(ps, 3, payment.getRental() != null ? payment.getRental().getRentalID() : null, Types.INTEGER);
        setNullable(ps, 4, payment.getAmount(), Types.NUMERIC);
        setNullable(ps, 5, payment.getPaymentDate() != null ? java.sql.Timestamp.valueOf(payment.getPaymentDate()) : null, Types.TIMESTAMP);
        setNullable(ps, 6, payment.getLastUpdate() != null ? java.sql.Timestamp.valueOf(payment.getLastUpdate()) : null, Types.TIMESTAMP);
    }

    private Payment extract(ResultSet rs) throws SQLException {
        Payment payment = new Payment();
        Integer payment_id = rs.getObject(COL_PAYMENT_ID, Integer.class);
        payment.setPaymentID(payment_id);
        Integer customer_id = rs.getObject(COL_CUSTOMER_ID, Integer.class);
        payment.setCustomerID(customer_id);
        if (customer_id != null) {
            Customer customer = new Customer();
            customer.setCustomerID(customer_id);
            payment.setCustomer(customer);
        }
        Integer staff_id = rs.getObject(COL_STAFF_ID, Integer.class);
        payment.setStaffID(staff_id);
        if (staff_id != null) {
            Staff staff = new Staff();
            staff.setStaffID(staff_id);
            payment.setStaff(staff);
        }
        Integer rental_id = rs.getObject(COL_RENTAL_ID, Integer.class);
        payment.setRentalID(rental_id);
        if (rental_id != null) {
            Rental rental = new Rental();
            rental.setRentalID(rental_id);
            payment.setRental(rental);
        }
        java.math.BigDecimal amount = rs.getObject(COL_AMOUNT, java.math.BigDecimal.class);
        payment.setAmount(amount);
        Timestamp payment_date = rs.getTimestamp(COL_PAYMENT_DATE);
        if (payment_date != null)
            payment.setPaymentDate(payment_date.toLocalDateTime());
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            payment.setLastUpdate(last_update.toLocalDateTime());
        return payment;
    }
}
