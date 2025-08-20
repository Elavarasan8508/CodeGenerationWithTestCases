package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.StoreDTO;

public class StoreJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public StoreJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public StoreDTO findById(Integer storeID) throws SQLException {
        String sql = "SELECT * FROM store WHERE store_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, storeID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new StoreDTO(null, null, rs.getInt("store_id"), rs.getInt("manager_staff_i_d"), rs.getInt("address_i_d"), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(StoreDTO entity) throws SQLException {
        String sql = "INSERT INTO store (manager_staff_id, address_id, last_update) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, entity.getManagerStaffID());
            ps.setInt(2, entity.getAddressID());
            ps.setTimestamp(3, toTimestamp(entity.getLastUpdate()));
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

    public int update(StoreDTO entity) throws SQLException {
        String sql = "UPDATE store SET manager_staff_id = ?, address_id = ?, last_update = ? WHERE store_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getManagerStaffID());
            ps.setInt(2, entity.getAddressID());
            ps.setTimestamp(3, toTimestamp(entity.getLastUpdate()));
            ps.setInt(4, entity.getStoreID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer storeID) throws SQLException {
        String sql = "DELETE FROM store WHERE store_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, storeID);
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
