package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.PaymentDTO;

public class PaymentJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public PaymentJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public PaymentDTO findById(Integer paymentID) throws SQLException {
        String sql = "SELECT * FROM payment WHERE payment_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, paymentID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new PaymentDTO(null, null, null, rs.getInt("payment_id"), rs.getInt("customer_i_d"), rs.getInt("staff_i_d"), rs.getInt("rental_i_d"), rs.getFloat("amount"), toLocalDateTime(rs.getTimestamp("payment_date")), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(PaymentDTO entity) throws SQLException {
        String sql = "INSERT INTO payment (customer_id, staff_id, rental_id, amount, payment_date, last_update) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, entity.getCustomerID());
            ps.setInt(2, entity.getStaffID());
            ps.setInt(3, entity.getRentalID());
            ps.setFloat(4, entity.getAmount());
            ps.setTimestamp(5, toTimestamp(entity.getPaymentDate()));
            ps.setTimestamp(6, toTimestamp(entity.getLastUpdate()));
            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet genKeys = ps.getGeneratedKeys()) {
                    if (genKeys.next()) {
                        return genKeys.getInt(1);
                    }
                }
            }
            return null;
        }
    }

    public int update(PaymentDTO entity) throws SQLException {
        String sql = "UPDATE payment SET customer_id = ?, staff_id = ?, rental_id = ?, amount = ?, payment_date = ?, last_update = ? WHERE payment_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getCustomerID());
            ps.setInt(2, entity.getStaffID());
            ps.setInt(3, entity.getRentalID());
            ps.setFloat(4, entity.getAmount());
            ps.setTimestamp(5, toTimestamp(entity.getPaymentDate()));
            ps.setTimestamp(6, toTimestamp(entity.getLastUpdate()));
            ps.setInt(7, entity.getPaymentID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer paymentID) throws SQLException {
        String sql = "DELETE FROM payment WHERE payment_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, paymentID);
            return ps.executeUpdate();
        }
    }

    private static Timestamp toTimestamp(LocalDateTime localDateTime) {
        return localDateTime != null ? Timestamp.valueOf(localDateTime) : null;
    }

    private static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
