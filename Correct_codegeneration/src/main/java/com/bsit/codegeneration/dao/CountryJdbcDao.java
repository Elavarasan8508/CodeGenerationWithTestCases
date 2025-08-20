package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.CountryDTO;

public class CountryJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public CountryJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public CountryDTO findById(Integer countryID) throws SQLException {
        String sql = "SELECT * FROM country WHERE country_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, countryID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new CountryDTO(rs.getInt("country_id"), rs.getString("country"), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(CountryDTO entity) throws SQLException {
        String sql = "INSERT INTO country (country, last_update) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getCountry());
            ps.setTimestamp(2, toTimestamp(entity.getLastUpdate()));
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

    public int update(CountryDTO entity) throws SQLException {
        String sql = "UPDATE country SET country = ?, last_update = ? WHERE country_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getCountry());
            ps.setTimestamp(2, toTimestamp(entity.getLastUpdate()));
            ps.setInt(3, entity.getCountryID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer countryID) throws SQLException {
        String sql = "DELETE FROM country WHERE country_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, countryID);
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
