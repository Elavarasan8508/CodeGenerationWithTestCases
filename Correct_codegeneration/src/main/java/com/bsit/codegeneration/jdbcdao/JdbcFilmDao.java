package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import com.bsit.codegeneration.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.stream.Collectors;
import java.math.BigDecimal;

public class JdbcFilmDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFilmDao.class);

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
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_TITLE, COL_DESCRIPTION, COL_RELEASE_YEAR, COL_LANGUAGE_ID, COL_ORIGINAL_LANGUAGE_ID, COL_RENTAL_DURATION, COL_RENTAL_RATE, COL_LENGTH, COL_REPLACEMENT_COST, COL_RATING, COL_SPECIAL_FEATURES, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update", TABLE, COL_FILM_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update", TABLE, COL_FILM_ID);

    private static final String SELECT_BY_LANGUAGE_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update", TABLE, COL_LANGUAGE_ID);

    private static final String SELECT_BY_ORIGINAL_LANGUAGE_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update", TABLE, COL_ORIGINAL_LANGUAGE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_TITLE, COL_DESCRIPTION, COL_RELEASE_YEAR, COL_LANGUAGE_ID, COL_ORIGINAL_LANGUAGE_ID, COL_RENTAL_DURATION, COL_RENTAL_RATE, COL_LENGTH, COL_REPLACEMENT_COST, COL_RATING, COL_SPECIAL_FEATURES, COL_LAST_UPDATE, COL_FILM_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID);

    private static <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }

    public int insert(Connection conn, Film film) throws SQLException {
        logger.debug("Inserting film: {}", film);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setFilmParams(ps, film);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    film.setFilmID(id);
                    return id;
                } else {
                    logger.error("Failed to retrieve generated ID for inserted film");
                    throw new SQLException("Failed to retrieve generated ID for inserted film");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Film> films) throws SQLException {
        if (films == null || films.isEmpty())
            return new int[0];
        for (int i = 0; i < films.size(); i++) {
            if (films.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        int batchSize = 500;
        List<List<Film>> batches = chunkList(films, batchSize);
        int[] totalResults = new int[films.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Film> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                    for (Film film : batch) {
                        setFilmParams(ps, film);
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                    logger.debug("Inserted {} rows in batch", results.length);
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        List<Integer> keys = new ArrayList<>();
                        while (rs.next()) {
                            keys.add(rs.getInt(1));
                        }
                        for (int i = 0; i < batch.size() && i < keys.size(); i++) {
                            batch.get(i).setFilmID(keys.get(i));
                        }
                    }
                } catch (SQLException e) {
                }
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch insert failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
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
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Film> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, (page - 1) * pageSize);
            ps.setInt(2, pageSize);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public boolean update(Connection conn, Film film) throws SQLException {
        if (film.getFilmID() == null)
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
            if (film.getFilmID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        int batchSize = 500;
        List<List<Film>> batches = chunkList(films, batchSize);
        int[] totalResults = new int[films.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Film> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Film film : batch) {
                        setFilmParams(ps, film);
                        ps.setInt(13, film.getFilmID());
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                    logger.debug("Updated {} rows in batch", results.length);
                } catch (SQLException e) {
                }
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch update failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (ids == null || ids.isEmpty())
            return 0;
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        int chunkSize = 1000;
        List<List<Integer>> chunks = chunkList(ids, chunkSize);
        int totalDeleted = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Integer> chunk : chunks) {
                String placeholders = String.join(", ", java.util.Collections.nCopies(chunk.size(), "?"));
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_FILM_ID, placeholders);
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < chunk.size(); i++) {
                        ps.setInt(i + 1, chunk.get(i));
                    }
                    int affected = ps.executeUpdate();
                    totalDeleted += affected;
                    logger.debug("Deleted {} rows in batch", affected);
                } catch (SQLException e) {
                }
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            logger.error("Batch delete failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalDeleted;
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
        ps.setObject(1, film.getTitle(), Types.VARCHAR);
        ps.setObject(2, film.getDescription(), Types.VARCHAR);
        Integer val3 = film.getReleaseYear();
        if (val3 != null) {
            ps.setObject(3, val3, Types.INTEGER);
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        if (film.getLanguage() != null) {
            ps.setObject(4, film.getLanguage().getLanguageID(), Types.INTEGER);
        } else {
            ps.setNull(4, Types.INTEGER);
        }
        if (film.getOriginalLanguage() != null) {
            ps.setObject(5, film.getOriginalLanguage().getLanguageID(), Types.INTEGER);
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        Integer val6 = film.getRentalDuration();
        if (val6 != null) {
            ps.setObject(6, val6, Types.INTEGER);
        } else {
            ps.setNull(6, Types.INTEGER);
        }
        java.math.BigDecimal val7 = film.getRentalRate();
        if (val7 != null) {
            ps.setObject(7, val7, Types.NUMERIC);
        } else {
            ps.setNull(7, Types.NUMERIC);
        }
        Integer val8 = film.getLength();
        if (val8 != null) {
            ps.setObject(8, val8, Types.INTEGER);
        } else {
            ps.setNull(8, Types.INTEGER);
        }
        java.math.BigDecimal val9 = film.getReplacementCost();
        if (val9 != null) {
            ps.setObject(9, val9, Types.NUMERIC);
        } else {
            ps.setNull(9, Types.NUMERIC);
        }
        ps.setObject(10, film.getRating(), Types.VARCHAR);
        ps.setObject(11, film.getSpecialFeatures(), Types.VARCHAR);
        java.time.LocalDateTime val12 = film.getLastUpdate();
        if (val12 != null) {
            ps.setObject(12, java.sql.Timestamp.valueOf(val12), Types.TIMESTAMP);
        } else {
            ps.setNull(12, Types.TIMESTAMP);
        }
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
        if (language_id != null) {
            Language language = new Language();
            language.setLanguageID(language_id);
            film.setLanguage(language);
        }
        Integer original_language_id = rs.getObject(COL_ORIGINAL_LANGUAGE_ID, Integer.class);
        film.setOriginalLanguageID(original_language_id);
        if (original_language_id != null) {
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
