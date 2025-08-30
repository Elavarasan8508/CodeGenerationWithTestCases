package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcPaymentDao {

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
        VALUES (?, ?, ?, ?, ?, ?) RETURNING %s
        """.formatted(TABLE, COL_CUSTOMER_ID, COL_STAFF_ID, COL_RENTAL_ID, COL_AMOUNT, COL_PAYMENT_DATE, COL_LAST_UPDATE, COL_PAYMENT_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_PAYMENT_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_PAYMENT_ID);

    private static final String SELECT_BY_CUSTOMER_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CUSTOMER_ID);

    private static final String SELECT_BY_RENTAL_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_RENTAL_ID);

    private static final String SELECT_BY_STAFF_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STAFF_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CUSTOMER_ID, COL_STAFF_ID, COL_RENTAL_ID, COL_AMOUNT, COL_PAYMENT_DATE, COL_LAST_UPDATE, COL_PAYMENT_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_PAYMENT_ID);

    public int insert(Connection conn, Payment payment) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setPaymentParams(ps, payment);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    payment.setPaymentID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Payment> payments) throws SQLException {
        if (payments == null || payments.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < payments.size(); i++) {
            if (payments.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            results = new int[payments.size()];
            for (int i = 0; i < payments.size(); i++) {
                Payment item = payments.get(i);
                setPaymentParams(ps, item);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        item.setPaymentID(rs.getInt(1));
                        results[i] = 1;
                    }
                }
            }
        }
        return results;
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
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Payment> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL)) {
            ps.setInt(1, pageSize);
            ps.setInt(2, (page - 1) * pageSize);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public boolean update(Connection conn, Payment payment) throws SQLException {
        if (payment.getPaymentID() == 0)
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
            if (payment.getPaymentID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Payment payment : payments) {
                setPaymentParams(ps, payment);
                ps.setInt(7, payment.getPaymentID());
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            return results;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            for (Integer id : ids) {
                ps.setInt(1, id);
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            return results;
        }
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
        if (payment.getCustomer() != null && payment.getCustomer().getCustomerID() > 0) {
            ps.setInt(1, payment.getCustomer().getCustomerID());
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (payment.getStaff() != null && payment.getStaff().getStaffID() > 0) {
            ps.setInt(2, payment.getStaff().getStaffID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        if (payment.getRental() != null && payment.getRental().getRentalID() > 0) {
            ps.setInt(3, payment.getRental().getRentalID());
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        java.math.BigDecimal val4 = payment.getAmount();
        if (val4 != null) {
            ps.setBigDecimal(4, val4);
        } else {
            ps.setNull(4, Types.DECIMAL);
        }
        LocalDateTime updateTime5 = Objects.requireNonNullElse(payment.getPaymentDate(), LocalDateTime.now());
        ps.setTimestamp(5, Timestamp.valueOf(updateTime5));
        LocalDateTime updateTime6 = Objects.requireNonNullElse(payment.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(6, Timestamp.valueOf(updateTime6));
    }

    private Payment extract(ResultSet rs) throws SQLException {
        Payment payment = new Payment();
        Integer payment_id = rs.getObject(COL_PAYMENT_ID, Integer.class);
        payment.setPaymentID(payment_id);
        Integer customer_id = rs.getObject(COL_CUSTOMER_ID, Integer.class);
        payment.setCustomerID(customer_id);
        if (customer_id != null && customer_id > 0) {
            Customer customer = new Customer();
            customer.setCustomerID(customer_id);
            payment.setCustomer(customer);
        }
        Integer staff_id = rs.getObject(COL_STAFF_ID, Integer.class);
        payment.setStaffID(staff_id);
        if (staff_id != null && staff_id > 0) {
            Staff staff = new Staff();
            staff.setStaffID(staff_id);
            payment.setStaff(staff);
        }
        Integer rental_id = rs.getObject(COL_RENTAL_ID, Integer.class);
        payment.setRentalID(rental_id);
        if (rental_id != null && rental_id > 0) {
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
