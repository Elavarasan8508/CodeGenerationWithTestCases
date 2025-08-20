package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.FilmDTO;

public class FilmJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public FilmJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public FilmDTO findById(Integer filmID) throws SQLException {
        String sql = "SELECT * FROM film WHERE film_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, filmID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new FilmDTO(null, null, null, null, null, rs.getInt("film_id"), rs.getString("title"), rs.getString("description"), rs.getString("release_year"), rs.getInt("language_i_d"), rs.getInt("original_language_i_d"), rs.getString("rental_duration"), rs.getFloat("rental_rate"), rs.getString("length"), rs.getFloat("replacement_cost"), rs.getString("rating"), rs.getString("special_features"), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(FilmDTO entity) throws SQLException {
        String sql = "INSERT INTO film (title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getDescription());
            ps.setString(3, entity.getReleaseYear());
            ps.setInt(4, entity.getLanguageID());
            ps.setInt(5, entity.getOriginalLanguageID());
            ps.setString(6, entity.getRentalDuration());
            ps.setFloat(7, entity.getRentalRate());
            ps.setString(8, entity.getLength());
            ps.setFloat(9, entity.getReplacementCost());
            ps.setString(10, entity.getRating());
            ps.setString(11, entity.getSpecialFeatures());
            ps.setTimestamp(12, toTimestamp(entity.getLastUpdate()));
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

    public int update(FilmDTO entity) throws SQLException {
        String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, original_language_id = ?, rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, special_features = ?, last_update = ? WHERE film_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getDescription());
            ps.setString(3, entity.getReleaseYear());
            ps.setInt(4, entity.getLanguageID());
            ps.setInt(5, entity.getOriginalLanguageID());
            ps.setString(6, entity.getRentalDuration());
            ps.setFloat(7, entity.getRentalRate());
            ps.setString(8, entity.getLength());
            ps.setFloat(9, entity.getReplacementCost());
            ps.setString(10, entity.getRating());
            ps.setString(11, entity.getSpecialFeatures());
            ps.setTimestamp(12, toTimestamp(entity.getLastUpdate()));
            ps.setInt(13, entity.getFilmID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer filmID) throws SQLException {
        String sql = "DELETE FROM film WHERE film_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, filmID);
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
