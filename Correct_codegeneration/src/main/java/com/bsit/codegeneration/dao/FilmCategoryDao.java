package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class FilmCategoryDao {

    private static final String INSERT_SQL = "INSERT INTO film_category (film_id, category_id, last_update) VALUES (?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM film_category WHERE film_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM film_category ORDER BY film_id";

    private static final String SELECT_BY_CATEGORY_ID_SQL = "SELECT * FROM film_category WHERE category_id = ?";

    private static final String SELECT_BY_FILM_ID_SQL = "SELECT * FROM film_category WHERE film_id = ?";

    private static final String UPDATE_SQL = "UPDATE film_category SET category_id = ?, last_update = ? WHERE film_id = ?";

    private static final String DELETE_SQL = "DELETE FROM film_category WHERE film_id = ?";

    public int insert(Connection conn, FilmCategoryDTO filmcategorydto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            if (filmcategorydto.getFilm() != null && filmcategorydto.getFilm().getFilmID() > 0) {
                ps.setInt(1, filmcategorydto.getFilm().getFilmID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            if (filmcategorydto.getCategory() != null && filmcategorydto.getCategory().getCategoryID() > 0) {
                ps.setInt(2, filmcategorydto.getCategory().getCategoryID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setTimestamp(3, Timestamp.valueOf(filmcategorydto.getLastUpdate() != null ? filmcategorydto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
        }
        return filmcategorydto.getFilm().getFilmID();
    }

    public FilmCategoryDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FilmCategoryDTO> findAll(Connection conn) throws SQLException {
        List<FilmCategoryDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, FilmCategoryDTO filmcategorydto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            if (filmcategorydto.getCategory() != null && filmcategorydto.getCategory().getCategoryID() > 0) {
                ps.setInt(1, filmcategorydto.getCategory().getCategoryID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            ps.setTimestamp(2, Timestamp.valueOf(filmcategorydto.getLastUpdate() != null ? filmcategorydto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(3, filmcategorydto.getFilmID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<FilmCategoryDTO> findByCategoryID(Connection conn, int categoryID) throws SQLException {
        List<FilmCategoryDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CATEGORY_ID_SQL)) {
            ps.setInt(1, categoryID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    public List<FilmCategoryDTO> findByFilmID(Connection conn, int filmID) throws SQLException {
        List<FilmCategoryDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_FILM_ID_SQL)) {
            ps.setInt(1, filmID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    private FilmCategoryDTO extract(ResultSet rs) throws SQLException {
        FilmCategoryDTO filmcategorydto = new FilmCategoryDTO();
        Integer film_id = rs.getObject("film_id", Integer.class);
        filmcategorydto.setFilmID(film_id);
        if (film_id != null && film_id > 0) {
            FilmDTO film = new FilmDTO();
            film.setFilmID(film_id);
            filmcategorydto.setFilm(film);
        }
        Integer category_id = rs.getObject("category_id", Integer.class);
        filmcategorydto.setCategoryID(category_id);
        if (category_id != null && category_id > 0) {
            CategoryDTO category = new CategoryDTO();
            category.setCategoryID(category_id);
            filmcategorydto.setCategory(category);
        }
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            filmcategorydto.setLastUpdate(last_update.toLocalDateTime());
        return filmcategorydto;
    }
}
