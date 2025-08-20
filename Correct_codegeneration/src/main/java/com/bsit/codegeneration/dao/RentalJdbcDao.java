package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.RentalDTO;

public class RentalJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public RentalJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public RentalDTO findById(Integer rentalID) throws SQLException {
        String sql = "SELECT * FROM rental WHERE rental_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, rentalID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new RentalDTO(null, null, null, rs.getInt("rental_id"), toLocalDateTime(rs.getTimestamp("rental_date")), rs.getInt("inventory_i_d"), rs.getInt("customer_i_d"), toLocalDateTime(rs.getTimestamp("return_date")), rs.getInt("staff_i_d"), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(RentalDTO entity) throws SQLException {
        String sql = "INSERT INTO rental (rental_date, inventory_id, customer_id, return_date, staff_id, last_update) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setTimestamp(1, toTimestamp(entity.getRentalDate()));
            ps.setInt(2, entity.getInventoryID());
            ps.setInt(3, entity.getCustomerID());
            ps.setTimestamp(4, toTimestamp(entity.getReturnDate()));
            ps.setInt(5, entity.getStaffID());
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

    public int update(RentalDTO entity) throws SQLException {
        String sql = "UPDATE rental SET rental_date = ?, inventory_id = ?, customer_id = ?, return_date = ?, staff_id = ?, last_update = ? WHERE rental_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, toTimestamp(entity.getRentalDate()));
            ps.setInt(2, entity.getInventoryID());
            ps.setInt(3, entity.getCustomerID());
            ps.setTimestamp(4, toTimestamp(entity.getReturnDate()));
            ps.setInt(5, entity.getStaffID());
            ps.setTimestamp(6, toTimestamp(entity.getLastUpdate()));
            ps.setInt(7, entity.getRentalID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer rentalID) throws SQLException {
        String sql = "DELETE FROM rental WHERE rental_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, rentalID);
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
