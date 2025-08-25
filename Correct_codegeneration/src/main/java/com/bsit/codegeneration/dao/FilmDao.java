package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class FilmDao {

    private static final String INSERT_SQL = "INSERT INTO film (title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM film WHERE film_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM film ORDER BY film_id";

    private static final String SELECT_BY_LANGUAGE_ID_SQL = "SELECT * FROM film WHERE language_id = ?";

    private static final String SELECT_BY_ORIGINAL_LANGUAGE_ID_SQL = "SELECT * FROM film WHERE original_language_id = ?";

    private static final String UPDATE_SQL = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, original_language_id = ?, rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, special_features = ?, last_update = ? WHERE film_id = ?";

    private static final String DELETE_SQL = "DELETE FROM film WHERE film_id = ?";

    public int insert(Connection conn, FilmDTO filmdto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, filmdto.getTitle());
            ps.setString(2, filmdto.getDescription());
            ps.setString(3, filmdto.getReleaseYear());
            if (filmdto.getLanguage() != null && filmdto.getLanguage().getLanguageID() > 0) {
                ps.setInt(4, filmdto.getLanguage().getLanguageID());
            } else {
                ps.setNull(4, Types.INTEGER);
            }
            if (filmdto.getOriginalLanguage() != null && filmdto.getOriginalLanguage().getLanguageID() > 0) {
                ps.setInt(5, filmdto.getOriginalLanguage().getLanguageID());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            ps.setString(6, filmdto.getRentalDuration());
            Float val7 = filmdto.getRentalRate();
            if (val7 != null) {
                ps.setFloat(7, val7);
            } else {
                ps.setNull(7, Types.FLOAT);
            }
            ps.setString(8, filmdto.getLength());
            Float val9 = filmdto.getReplacementCost();
            if (val9 != null) {
                ps.setFloat(9, val9);
            } else {
                ps.setNull(9, Types.FLOAT);
            }
            ps.setString(10, filmdto.getRating());
            ps.setString(11, filmdto.getSpecialFeatures());
            ps.setTimestamp(12, Timestamp.valueOf(filmdto.getLastUpdate() != null ? filmdto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    filmdto.setFilmID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public FilmDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FilmDTO> findAll(Connection conn) throws SQLException {
        List<FilmDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, FilmDTO filmdto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, filmdto.getTitle());
            ps.setString(2, filmdto.getDescription());
            ps.setString(3, filmdto.getReleaseYear());
            if (filmdto.getLanguage() != null && filmdto.getLanguage().getLanguageID() > 0) {
                ps.setInt(4, filmdto.getLanguage().getLanguageID());
            } else {
                ps.setNull(4, Types.INTEGER);
            }
            if (filmdto.getOriginalLanguage() != null && filmdto.getOriginalLanguage().getLanguageID() > 0) {
                ps.setInt(5, filmdto.getOriginalLanguage().getLanguageID());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            ps.setString(6, filmdto.getRentalDuration());
            Float val7 = filmdto.getRentalRate();
            if (val7 != null) {
                ps.setFloat(7, val7);
            } else {
                ps.setNull(7, Types.FLOAT);
            }
            ps.setString(8, filmdto.getLength());
            Float val9 = filmdto.getReplacementCost();
            if (val9 != null) {
                ps.setFloat(9, val9);
            } else {
                ps.setNull(9, Types.FLOAT);
            }
            ps.setString(10, filmdto.getRating());
            ps.setString(11, filmdto.getSpecialFeatures());
            ps.setTimestamp(12, Timestamp.valueOf(filmdto.getLastUpdate() != null ? filmdto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(13, filmdto.getFilmID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<FilmDTO> findByLanguageID(Connection conn, int languageID) throws SQLException {
        List<FilmDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_LANGUAGE_ID_SQL)) {
            ps.setInt(1, languageID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    public List<FilmDTO> findByOriginalLanguageID(Connection conn, int originalLanguageID) throws SQLException {
        List<FilmDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ORIGINAL_LANGUAGE_ID_SQL)) {
            ps.setInt(1, originalLanguageID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    private FilmDTO extract(ResultSet rs) throws SQLException {
        FilmDTO filmdto = new FilmDTO();
        Integer film_id = rs.getObject("film_id", Integer.class);
        filmdto.setFilmID(film_id);
        filmdto.setTitle(rs.getString("title"));
        filmdto.setDescription(rs.getString("description"));
        filmdto.setReleaseYear(rs.getString("release_year"));
        Integer language_id = rs.getObject("language_id", Integer.class);
        filmdto.setLanguageID(language_id);
        if (language_id != null && language_id > 0) {
            LanguageDTO language = new LanguageDTO();
            language.setLanguageID(language_id);
            filmdto.setLanguage(language);
        }
        Integer original_language_id = rs.getObject("original_language_id", Integer.class);
        filmdto.setOriginalLanguageID(original_language_id);
        if (original_language_id != null && original_language_id > 0) {
            LanguageDTO originalLanguage = new LanguageDTO();
            originalLanguage.setLanguageID(original_language_id);
            filmdto.setOriginalLanguage(originalLanguage);
        }
        filmdto.setRentalDuration(rs.getString("rental_duration"));
        Float rental_rate = rs.getObject("rental_rate", Float.class);
        filmdto.setRentalRate(rental_rate);
        filmdto.setLength(rs.getString("length"));
        Float replacement_cost = rs.getObject("replacement_cost", Float.class);
        filmdto.setReplacementCost(replacement_cost);
        filmdto.setRating(rs.getString("rating"));
        filmdto.setSpecialFeatures(rs.getString("special_features"));
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            filmdto.setLastUpdate(last_update.toLocalDateTime());
        return filmdto;
    }
}
