package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class PaymentDao {

    private static final String INSERT_SQL = "INSERT INTO payment (customer_id, staff_id, rental_id, amount, payment_date, last_update) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM payment WHERE payment_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM payment ORDER BY payment_id";

    private static final String SELECT_BY_CUSTOMER_ID_SQL = "SELECT * FROM payment WHERE customer_id = ?";

    private static final String SELECT_BY_RENTAL_ID_SQL = "SELECT * FROM payment WHERE rental_id = ?";

    private static final String SELECT_BY_STAFF_ID_SQL = "SELECT * FROM payment WHERE staff_id = ?";

    private static final String UPDATE_SQL = "UPDATE payment SET customer_id = ?, staff_id = ?, rental_id = ?, amount = ?, payment_date = ?, last_update = ? WHERE payment_id = ?";

    private static final String DELETE_SQL = "DELETE FROM payment WHERE payment_id = ?";

    public int insert(Connection conn, PaymentDTO paymentdto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            if (paymentdto.getCustomer() != null && paymentdto.getCustomer().getCustomerID() > 0) {
                ps.setInt(1, paymentdto.getCustomer().getCustomerID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            if (paymentdto.getStaff() != null && paymentdto.getStaff().getStaffID() > 0) {
                ps.setInt(2, paymentdto.getStaff().getStaffID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            if (paymentdto.getRental() != null && paymentdto.getRental().getRentalID() > 0) {
                ps.setInt(3, paymentdto.getRental().getRentalID());
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            Float val4 = paymentdto.getAmount();
            if (val4 != null) {
                ps.setFloat(4, val4);
            } else {
                ps.setNull(4, Types.FLOAT);
            }
            ps.setTimestamp(5, Timestamp.valueOf(paymentdto.getPaymentDate() != null ? paymentdto.getPaymentDate() : java.time.LocalDateTime.now()));
            ps.setTimestamp(6, Timestamp.valueOf(paymentdto.getLastUpdate() != null ? paymentdto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    paymentdto.setPaymentID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public PaymentDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<PaymentDTO> findAll(Connection conn) throws SQLException {
        List<PaymentDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, PaymentDTO paymentdto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            if (paymentdto.getCustomer() != null && paymentdto.getCustomer().getCustomerID() > 0) {
                ps.setInt(1, paymentdto.getCustomer().getCustomerID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            if (paymentdto.getStaff() != null && paymentdto.getStaff().getStaffID() > 0) {
                ps.setInt(2, paymentdto.getStaff().getStaffID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            if (paymentdto.getRental() != null && paymentdto.getRental().getRentalID() > 0) {
                ps.setInt(3, paymentdto.getRental().getRentalID());
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            Float val4 = paymentdto.getAmount();
            if (val4 != null) {
                ps.setFloat(4, val4);
            } else {
                ps.setNull(4, Types.FLOAT);
            }
            ps.setTimestamp(5, Timestamp.valueOf(paymentdto.getPaymentDate() != null ? paymentdto.getPaymentDate() : java.time.LocalDateTime.now()));
            ps.setTimestamp(6, Timestamp.valueOf(paymentdto.getLastUpdate() != null ? paymentdto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(7, paymentdto.getPaymentID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<PaymentDTO> findByCustomerID(Connection conn, int customerID) throws SQLException {
        List<PaymentDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CUSTOMER_ID_SQL)) {
            ps.setInt(1, customerID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    public List<PaymentDTO> findByRentalID(Connection conn, int rentalID) throws SQLException {
        List<PaymentDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_RENTAL_ID_SQL)) {
            ps.setInt(1, rentalID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    public List<PaymentDTO> findByStaffID(Connection conn, int staffID) throws SQLException {
        List<PaymentDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_STAFF_ID_SQL)) {
            ps.setInt(1, staffID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    private PaymentDTO extract(ResultSet rs) throws SQLException {
        PaymentDTO paymentdto = new PaymentDTO();
        Integer payment_id = rs.getObject("payment_id", Integer.class);
        paymentdto.setPaymentID(payment_id);
        Integer customer_id = rs.getObject("customer_id", Integer.class);
        paymentdto.setCustomerID(customer_id);
        if (customer_id != null && customer_id > 0) {
            CustomerDTO customer = new CustomerDTO();
            customer.setCustomerID(customer_id);
            paymentdto.setCustomer(customer);
        }
        Integer staff_id = rs.getObject("staff_id", Integer.class);
        paymentdto.setStaffID(staff_id);
        if (staff_id != null && staff_id > 0) {
            StaffDTO staff = new StaffDTO();
            staff.setStaffID(staff_id);
            paymentdto.setStaff(staff);
        }
        Integer rental_id = rs.getObject("rental_id", Integer.class);
        paymentdto.setRentalID(rental_id);
        if (rental_id != null && rental_id > 0) {
            RentalDTO rental = new RentalDTO();
            rental.setRentalID(rental_id);
            paymentdto.setRental(rental);
        }
        Float amount = rs.getObject("amount", Float.class);
        paymentdto.setAmount(amount);
        Timestamp payment_date = rs.getTimestamp("payment_date");
        if (payment_date != null)
            paymentdto.setPaymentDate(payment_date.toLocalDateTime());
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            paymentdto.setLastUpdate(last_update.toLocalDateTime());
        return paymentdto;
    }
}
