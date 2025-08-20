package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.FilmCategoryDTO;

public class FilmCategoryJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public FilmCategoryJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public FilmCategoryDTO findById(Integer filmID) throws SQLException {
        String sql = "SELECT * FROM film_category WHERE film_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, filmID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new FilmCategoryDTO(null, null, rs.getInt("film_id"), rs.getInt("category_i_d"), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(FilmCategoryDTO entity) throws SQLException {
        String sql = "INSERT INTO film_category (film_id, category_id, last_update) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getFilmID());
            ps.setInt(2, entity.getCategoryID());
            ps.setTimestamp(3, toTimestamp(entity.getLastUpdate()));
            int rows = ps.executeUpdate();
            return entity.getFilmID();
        }
    }

    public int update(FilmCategoryDTO entity) throws SQLException {
        String sql = "UPDATE film_category SET category_id = ?, last_update = ? WHERE film_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getCategoryID());
            ps.setTimestamp(2, toTimestamp(entity.getLastUpdate()));
            ps.setInt(3, entity.getFilmID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer filmID) throws SQLException {
        String sql = "DELETE FROM film_category WHERE film_id = ?";
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
