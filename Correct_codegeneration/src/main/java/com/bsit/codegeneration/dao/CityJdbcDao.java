package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.CityDTO;

public class CityJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public CityJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public CityDTO findById(Integer cityID) throws SQLException {
        String sql = "SELECT * FROM city WHERE city_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cityID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new CityDTO(null, rs.getInt("city_id"), rs.getString("city"), rs.getInt("country_i_d"), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(CityDTO entity) throws SQLException {
        String sql = "INSERT INTO city (city, country_id, last_update) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getCity());
            ps.setInt(2, entity.getCountryID());
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

    public int update(CityDTO entity) throws SQLException {
        String sql = "UPDATE city SET city = ?, country_id = ?, last_update = ? WHERE city_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getCity());
            ps.setInt(2, entity.getCountryID());
            ps.setTimestamp(3, toTimestamp(entity.getLastUpdate()));
            ps.setInt(4, entity.getCityID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer cityID) throws SQLException {
        String sql = "DELETE FROM city WHERE city_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cityID);
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
