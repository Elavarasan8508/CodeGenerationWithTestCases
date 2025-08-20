package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import com.bsit.codegeneration.dto.FilmActorDTO;

public class FilmActorJdbcDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USER = "";

    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public FilmActorJdbcDao() throws SQLException {
        this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public FilmActorDTO findById(Integer actorID) throws SQLException {
        String sql = "SELECT * FROM film_actor WHERE actor_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, actorID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new FilmActorDTO(null, null, rs.getInt("actor_id"), rs.getInt("film_i_d"), toLocalDateTime(rs.getTimestamp("last_update")));
                }
                return null;
            }
        }
    }

    public Integer insert(FilmActorDTO entity) throws SQLException {
        String sql = "INSERT INTO film_actor (actor_id, film_id, last_update) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getActorID());
            ps.setInt(2, entity.getFilmID());
            ps.setTimestamp(3, toTimestamp(entity.getLastUpdate()));
            int rows = ps.executeUpdate();
            return entity.getActorID();
        }
    }

    public int update(FilmActorDTO entity) throws SQLException {
        String sql = "UPDATE film_actor SET film_id = ?, last_update = ? WHERE actor_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getFilmID());
            ps.setTimestamp(2, toTimestamp(entity.getLastUpdate()));
            ps.setInt(3, entity.getActorID());
            return ps.executeUpdate();
        }
    }

    public int delete(Integer actorID) throws SQLException {
        String sql = "DELETE FROM film_actor WHERE actor_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, actorID);
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
