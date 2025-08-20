package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.CustomerDTO;

public class CustomerJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public CustomerJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public CustomerDTO findById(Integer customerID) throws SQLException {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customerID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new CustomerDTO(null, null, null, rs.getInt("customer_id"), rs.getInt("store_i_d"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getInt("address_i_d"), rs.getString("active"), toLocalDateTime(rs.getTimestamp("create_date")), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(CustomerDTO entity) throws SQLException {
        String sql = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date, last_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, entity.getStoreID());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getEmail());
            ps.setInt(5, entity.getAddressID());
            ps.setString(6, entity.getActive());
            ps.setTimestamp(7, toTimestamp(entity.getCreateDate()));
            ps.setTimestamp(8, toTimestamp(entity.getLastUpdate()));
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

    public int update(CustomerDTO entity) throws SQLException {
        String sql = "UPDATE customer SET store_id = ?, first_name = ?, last_name = ?, email = ?, address_id = ?, active = ?, create_date = ?, last_update = ? WHERE customer_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getStoreID());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getEmail());
            ps.setInt(5, entity.getAddressID());
            ps.setString(6, entity.getActive());
            ps.setTimestamp(7, toTimestamp(entity.getCreateDate()));
            ps.setTimestamp(8, toTimestamp(entity.getLastUpdate()));
            ps.setInt(9, entity.getCustomerID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer customerID) throws SQLException {
        String sql = "DELETE FROM customer WHERE customer_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customerID);
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
