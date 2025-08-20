package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.AddressDTO;

public class AddressJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public AddressJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public AddressDTO findById(Integer addressID) throws SQLException {
        String sql = "SELECT * FROM address WHERE address_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, addressID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new AddressDTO(null, null, null, rs.getInt("address_id"), rs.getString("address2"), rs.getString("district"), rs.getInt("city_i_d"), rs.getString("postal_code"), rs.getString("phone"), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(AddressDTO entity) throws SQLException {
        String sql = "INSERT INTO address (address, address2, district, city_id, postal_code, phone, last_update) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getAddress());
            ps.setString(2, entity.getAddress2());
            ps.setString(3, entity.getDistrict());
            ps.setInt(4, entity.getCityID());
            ps.setString(5, entity.getPostalCode());
            ps.setString(6, entity.getPhone());
            ps.setTimestamp(7, toTimestamp(entity.getLastUpdate()));
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

    public int update(AddressDTO entity) throws SQLException {
        String sql = "UPDATE address SET address = ?, address2 = ?, district = ?, city_id = ?, postal_code = ?, phone = ?, last_update = ? WHERE address_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getAddress());
            ps.setString(2, entity.getAddress2());
            ps.setString(3, entity.getDistrict());
            ps.setInt(4, entity.getCityID());
            ps.setString(5, entity.getPostalCode());
            ps.setString(6, entity.getPhone());
            ps.setTimestamp(7, toTimestamp(entity.getLastUpdate()));
            ps.setInt(8, entity.getAddressID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer addressID) throws SQLException {
        String sql = "DELETE FROM address WHERE address_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, addressID);
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
