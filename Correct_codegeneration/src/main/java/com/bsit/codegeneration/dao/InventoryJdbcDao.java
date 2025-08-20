package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.InventoryDTO;

public class InventoryJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public InventoryJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public InventoryDTO findById(Integer inventoryID) throws SQLException {
        String sql = "SELECT * FROM inventory WHERE inventory_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, inventoryID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new InventoryDTO(null, null, null, rs.getInt("inventory_id"), rs.getInt("film_i_d"), rs.getInt("store_i_d"), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(InventoryDTO entity) throws SQLException {
        String sql = "INSERT INTO inventory (film_id, store_id, last_update) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, entity.getFilmID());
            ps.setInt(2, entity.getStoreID());
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

    public int update(InventoryDTO entity) throws SQLException {
        String sql = "UPDATE inventory SET film_id = ?, store_id = ?, last_update = ? WHERE inventory_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getFilmID());
            ps.setInt(2, entity.getStoreID());
            ps.setTimestamp(3, toTimestamp(entity.getLastUpdate()));
            ps.setInt(4, entity.getInventoryID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer inventoryID) throws SQLException {
        String sql = "DELETE FROM inventory WHERE inventory_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, inventoryID);
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
