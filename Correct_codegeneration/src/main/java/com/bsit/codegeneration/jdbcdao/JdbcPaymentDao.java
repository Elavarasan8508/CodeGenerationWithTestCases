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
import java.math.BigDecimal;

public class JdbcPaymentDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcPaymentDao.class);

    private static final String TABLE = "payment";

    private static final String COL_PAYMENT_ID = "payment_id";

    private static final String COL_CUSTOMER_ID = "customer_id";

    private static final String COL_STAFF_ID = "staff_id";

    private static final String COL_RENTAL_ID = "rental_id";

    private static final String COL_AMOUNT = "amount";

    private static final String COL_PAYMENT_DATE = "payment_date";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_CUSTOMER_ID, COL_STAFF_ID, COL_RENTAL_ID, COL_AMOUNT, COL_PAYMENT_DATE, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update", TABLE, COL_PAYMENT_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update", TABLE, COL_PAYMENT_ID);

    private static final String SELECT_BY_CUSTOMER_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update", TABLE, COL_CUSTOMER_ID);

    private static final String SELECT_BY_RENTAL_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update", TABLE, COL_RENTAL_ID);

    private static final String SELECT_BY_STAFF_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update", TABLE, COL_STAFF_ID);

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

    public int insert(Connection conn, Payment payment) throws SQLException {
        logger.debug("Inserting payment: {}", payment);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setPaymentParams(ps, payment);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    payment.setPaymentID(id);
                    return id;
                } else {
                    logger.error("Failed to retrieve generated ID for inserted payment");
                    throw new SQLException("Failed to retrieve generated ID for inserted payment");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Payment> payments) throws SQLException {
        if (payments == null || payments.isEmpty())
            return new int[0];
        for (int i = 0; i < payments.size(); i++) {
            if (payments.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        int batchSize = 500;
        List<List<Payment>> batches = chunkList(payments, batchSize);
        int[] totalResults = new int[payments.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Payment> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                    for (Payment payment : batch) {
                        setPaymentParams(ps, payment);
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
                            batch.get(i).setPaymentID(keys.get(i));
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

    public Payment findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
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
        if (payments == null || payments.isEmpty())
            return new int[0];
        for (Payment payment : payments) {
            if (payment == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (payment.getPaymentID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        int batchSize = 500;
        List<List<Payment>> batches = chunkList(payments, batchSize);
        int[] totalResults = new int[payments.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Payment> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Payment payment : batch) {
                        setPaymentParams(ps, payment);
                        ps.setInt(7, payment.getPaymentID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_PAYMENT_ID, placeholders);
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

    public List<Payment> findByCustomerID(Connection conn, int customerID) throws SQLException {
        List<Payment> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CUSTOMER_ID_SQL)) {
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
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_RENTAL_ID_SQL)) {
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
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_STAFF_ID_SQL)) {
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
        if (payment.getCustomer() != null) {
            ps.setObject(1, payment.getCustomer().getCustomerID(), Types.INTEGER);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (payment.getStaff() != null) {
            ps.setObject(2, payment.getStaff().getStaffID(), Types.INTEGER);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        if (payment.getRental() != null) {
            ps.setObject(3, payment.getRental().getRentalID(), Types.INTEGER);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        java.math.BigDecimal val4 = payment.getAmount();
        if (val4 != null) {
            ps.setObject(4, val4, Types.NUMERIC);
        } else {
            ps.setNull(4, Types.NUMERIC);
        }
        java.time.LocalDateTime val5 = payment.getPaymentDate();
        if (val5 != null) {
            ps.setObject(5, java.sql.Timestamp.valueOf(val5), Types.TIMESTAMP);
        } else {
            ps.setNull(5, Types.TIMESTAMP);
        }
        java.time.LocalDateTime val6 = payment.getLastUpdate();
        if (val6 != null) {
            ps.setObject(6, java.sql.Timestamp.valueOf(val6), Types.TIMESTAMP);
        } else {
            ps.setNull(6, Types.TIMESTAMP);
        }
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
