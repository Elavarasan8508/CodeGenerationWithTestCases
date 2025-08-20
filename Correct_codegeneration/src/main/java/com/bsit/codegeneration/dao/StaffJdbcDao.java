package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.StaffDTO;

public class StaffJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public StaffJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public StaffDTO findById(Integer staffID) throws SQLException {
        String sql = "SELECT * FROM staff WHERE staff_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, staffID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new StaffDTO(null, null, null, rs.getInt("staff_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("address_i_d"), rs.getString("email"), rs.getInt("store_i_d"), rs.getString("active"), rs.getString("username"), rs.getString("password"), toLocalDateTime(rs.getTimestamp("last_update")), rs.getString("picture"));
                }
                return null;
            }
        }
    }

    public Integer insert(StaffDTO entity) throws SQLException {
        String sql = "INSERT INTO staff (first_name, last_name, address_id, email, store_id, active, username, password, last_update, picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getAddressID());
            ps.setString(4, entity.getEmail());
            ps.setInt(5, entity.getStoreID());
            ps.setString(6, entity.getActive());
            ps.setString(7, entity.getUsername());
            ps.setString(8, entity.getPassword());
            ps.setTimestamp(9, toTimestamp(entity.getLastUpdate()));
            ps.setString(10, entity.getPicture());
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

    public int update(StaffDTO entity) throws SQLException {
        String sql = "UPDATE staff SET first_name = ?, last_name = ?, address_id = ?, email = ?, store_id = ?, active = ?, username = ?, password = ?, last_update = ?, picture = ? WHERE staff_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getAddressID());
            ps.setString(4, entity.getEmail());
            ps.setInt(5, entity.getStoreID());
            ps.setString(6, entity.getActive());
            ps.setString(7, entity.getUsername());
            ps.setString(8, entity.getPassword());
            ps.setTimestamp(9, toTimestamp(entity.getLastUpdate()));
            ps.setString(10, entity.getPicture());
            ps.setInt(11, entity.getStaffID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer staffID) throws SQLException {
        String sql = "DELETE FROM staff WHERE staff_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, staffID);
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
