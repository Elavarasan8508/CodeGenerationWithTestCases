package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcFilmDao {

    private static final String TABLE = "film";

    private static final String COL_FILM_ID = "film_id";

    private static final String COL_TITLE = "title";

    private static final String COL_DESCRIPTION = "description";

    private static final String COL_RELEASE_YEAR = "release_year";

    private static final String COL_LANGUAGE_ID = "language_id";

    private static final String COL_ORIGINAL_LANGUAGE_ID = "original_language_id";

    private static final String COL_RENTAL_DURATION = "rental_duration";

    private static final String COL_RENTAL_RATE = "rental_rate";

    private static final String COL_LENGTH = "length";

    private static final String COL_REPLACEMENT_COST = "replacement_cost";

    private static final String COL_RATING = "rating";

    private static final String COL_SPECIAL_FEATURES = "special_features";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING %s
        """.formatted(TABLE, COL_TITLE, COL_DESCRIPTION, COL_RELEASE_YEAR, COL_LANGUAGE_ID, COL_ORIGINAL_LANGUAGE_ID, COL_RENTAL_DURATION, COL_RENTAL_RATE, COL_LENGTH, COL_REPLACEMENT_COST, COL_RATING, COL_SPECIAL_FEATURES, COL_LAST_UPDATE, COL_FILM_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_FILM_ID);

    private static final String SELECT_BY_LANGUAGE_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_LANGUAGE_ID);

    private static final String SELECT_BY_ORIGINAL_LANGUAGE_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ORIGINAL_LANGUAGE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TITLE, COL_DESCRIPTION, COL_RELEASE_YEAR, COL_LANGUAGE_ID, COL_ORIGINAL_LANGUAGE_ID, COL_RENTAL_DURATION, COL_RENTAL_RATE, COL_LENGTH, COL_REPLACEMENT_COST, COL_RATING, COL_SPECIAL_FEATURES, COL_LAST_UPDATE, COL_FILM_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID);

    public int insert(Connection conn, Film film) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFilmParams(ps, film);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    film.setFilmID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Film> films) throws SQLException {
        if (films == null || films.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < films.size(); i++) {
            if (films.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            results = new int[films.size()];
            for (int i = 0; i < films.size(); i++) {
                Film item = films.get(i);
                setFilmParams(ps, item);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        item.setFilmID(rs.getInt(1));
                        results[i] = 1;
                    }
                }
            }
        }
        return results;
    }

    public Film findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Film> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Film> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL)) {
            ps.setInt(1, pageSize);
            ps.setInt(2, (page - 1) * pageSize);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public boolean update(Connection conn, Film film) throws SQLException {
        if (film.getFilmID() == 0)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFilmParams(ps, film);
            ps.setInt(13, film.getFilmID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Film> films) throws SQLException {
        if (films == null || films.isEmpty())
            return new int[0];
        for (Film film : films) {
            if (film == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (film.getFilmID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Film film : films) {
                setFilmParams(ps, film);
                ps.setInt(13, film.getFilmID());
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            return results;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int[] deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return new int[0];
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            for (Integer id : ids) {
                ps.setInt(1, id);
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            return results;
        }
    }

    public List<Film> findByLanguageID(Connection conn, int languageID) throws SQLException {
        List<Film> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_LANGUAGE_ID_SQL)) {
            ps.setInt(1, languageID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<Film> findByOriginalLanguageID(Connection conn, int originalLanguageID) throws SQLException {
        List<Film> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ORIGINAL_LANGUAGE_ID_SQL)) {
            ps.setInt(1, originalLanguageID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFilmParams(PreparedStatement ps, Film film) throws SQLException {
        ps.setString(1, film.getTitle());
        ps.setString(2, film.getDescription());
        Integer val3 = film.getReleaseYear();
        if (val3 != null) {
            ps.setInt(3, val3);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        if (film.getLanguage() != null && film.getLanguage().getLanguageID() > 0) {
            ps.setInt(4, film.getLanguage().getLanguageID());
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        if (film.getOriginalLanguage() != null && film.getOriginalLanguage().getLanguageID() > 0) {
            ps.setInt(5, film.getOriginalLanguage().getLanguageID());
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        Integer val6 = film.getRentalDuration();
        if (val6 != null) {
            ps.setInt(6, val6);
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        java.math.BigDecimal val7 = film.getRentalRate();
        if (val7 != null) {
            ps.setBigDecimal(7, val7);
        } else {
            ps.setNull(7, Types.DECIMAL);
        }
        Integer val8 = film.getLength();
        if (val8 != null) {
            ps.setInt(8, val8);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        java.math.BigDecimal val9 = film.getReplacementCost();
        if (val9 != null) {
            ps.setBigDecimal(9, val9);
        } else {
            ps.setNull(9, Types.DECIMAL);
        }
        ps.setString(10, film.getRating());
        ps.setString(11, film.getSpecialFeatures());
        LocalDateTime updateTime12 = Objects.requireNonNullElse(film.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(12, Timestamp.valueOf(updateTime12));
    }

    private Film extract(ResultSet rs) throws SQLException {
        Film film = new Film();
        Integer film_id = rs.getObject(COL_FILM_ID, Integer.class);
        film.setFilmID(film_id);
        film.setTitle(rs.getString(COL_TITLE));
        film.setDescription(rs.getString(COL_DESCRIPTION));
        Integer release_year = rs.getObject(COL_RELEASE_YEAR, Integer.class);
        film.setReleaseYear(release_year);
        Integer language_id = rs.getObject(COL_LANGUAGE_ID, Integer.class);
        film.setLanguageID(language_id);
        if (language_id != null && language_id > 0) {
            Language language = new Language();
            language.setLanguageID(language_id);
            film.setLanguage(language);
        }
        Integer original_language_id = rs.getObject(COL_ORIGINAL_LANGUAGE_ID, Integer.class);
        film.setOriginalLanguageID(original_language_id);
        if (original_language_id != null && original_language_id > 0) {
            Language originalLanguage = new Language();
            originalLanguage.setLanguageID(original_language_id);
            film.setOriginalLanguage(originalLanguage);
        }
        Integer rental_duration = rs.getObject(COL_RENTAL_DURATION, Integer.class);
        film.setRentalDuration(rental_duration);
        java.math.BigDecimal rental_rate = rs.getObject(COL_RENTAL_RATE, java.math.BigDecimal.class);
        film.setRentalRate(rental_rate);
        Integer length = rs.getObject(COL_LENGTH, Integer.class);
        film.setLength(length);
        java.math.BigDecimal replacement_cost = rs.getObject(COL_REPLACEMENT_COST, java.math.BigDecimal.class);
        film.setReplacementCost(replacement_cost);
        film.setRating(rs.getString(COL_RATING));
        film.setSpecialFeatures(rs.getString(COL_SPECIAL_FEATURES));
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            film.setLastUpdate(last_update.toLocalDateTime());
        return film;
    }
}
