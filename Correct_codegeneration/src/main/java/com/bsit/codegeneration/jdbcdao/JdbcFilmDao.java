package com.bsit.codegeneration.jdbcdao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.Film;
import com.bsit.codegeneration.pojo.Language;

public class JdbcFilmDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcFilmDao.class);

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

    private static final String SELECT_COLUMNS = "film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features, last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_TITLE, COL_DESCRIPTION, COL_RELEASE_YEAR, COL_LANGUAGE_ID, COL_ORIGINAL_LANGUAGE_ID, COL_RENTAL_DURATION, COL_RENTAL_RATE, COL_LENGTH, COL_REPLACEMENT_COST, COL_RATING, COL_SPECIAL_FEATURES, COL_LAST_UPDATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted(SELECT_COLUMNS, TABLE, COL_FILM_ID);

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

    private static String getSelectByColumnSql(String column) {
        return """
            SELECT %s FROM %s WHERE %s = ?
            """.formatted(SELECT_COLUMNS, TABLE, column);
    }

    private static void setNullable(PreparedStatement ps, int index, Object value, int sqlType) throws SQLException {
        if (value != null)
            ps.setObject(index, value, sqlType);
        else
            ps.setNull(index, sqlType);
    }

    public int insert(Connection conn, Film film) throws SQLException {
        LOGGER.debug("Inserting film: {}", film);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setFilmParams(ps, film);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    film.setFilmID(id);
                    return id;
                } else {
                    LOGGER.error("Failed to retrieve generated ID for inserted film");
                    throw new SQLException("Failed to retrieve generated ID for inserted film");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Film> films) throws SQLException {
        if (isInvalidFilmList(films)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Film>> batches = chunkList(films, batchSize);
        int[] totalResults = new int[films.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Film> batch : batches) {
                int[] results = processBatch(conn, batch);
                System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                resultIndex += results.length;
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            LOGGER.error("Batch insert failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    private boolean isInvalidFilmList(List<Film> films) {
        if (films == null || films.isEmpty()) {
            return true;
        }
        for (int i = 0; i < films.size(); i++) {
            if (films.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        return false;
    }

    private int[] processBatch(Connection conn, List<Film> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Film film : batch) {
                setFilmParams(ps, film);
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            LOGGER.debug("Inserted {} rows in batch", results.length);
            try (ResultSet rs = ps.getGeneratedKeys()) {
                List<Integer> keys = new ArrayList<>();
                while (rs.next()) {
                    keys.add(rs.getInt(1));
                }
                for (int i = 0; i < batch.size() && i < keys.size(); i++) {
                    batch.get(i).setFilmID(keys.get(i));
                }
            }
            return results;
        }
    }

    public Film findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_FILM_ID))) {
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
        if (isInvalidUpdateFilmList(films)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Film>> batches = chunkList(films, batchSize);
        int[] totalResults = new int[films.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Film> batch : batches) {
                int[] results = processUpdateBatch(conn, batch);
                System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                resultIndex += results.length;
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            LOGGER.error("Batch update failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalResults;
    }

    private boolean isInvalidUpdateFilmList(List<Film> films) {
        if (films == null || films.isEmpty()) {
            return true;
        }
        for (Film film : films) {
            if (film == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (film.getFilmID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        return false;
    }

    private int[] processUpdateBatch(Connection conn, List<Film> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Film film : batch) {
                setFilmParams(ps, film);
                ps.setInt(13, film.getFilmID());
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            LOGGER.debug("Updated {} rows in batch", results.length);
            return results;
        } catch (SQLException e) {
            LOGGER.error("Batch update failed", e);
            throw e;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public int deleteAllByIds(Connection conn, List<Integer> ids) throws SQLException {
        if (isInvalidIdsList(ids)) {
            return 0;
        }
        int chunkSize = 1000;
        List<List<Integer>> chunks = chunkList(ids, chunkSize);
        int totalDeleted = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Integer> chunk : chunks) {
                int affected = processDeleteChunk(conn, chunk);
                totalDeleted += affected;
            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            LOGGER.error("Batch delete failed, rolled back", e);
            throw e;
        } finally {
            conn.setAutoCommit(autoCommit);
        }
        return totalDeleted;
    }

    private boolean isInvalidIdsList(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return true;
        }
        for (Integer id : ids) {
            if (id == null)
                throw new IllegalArgumentException("Null ID in batch delete");
        }
        return false;
    }

    private int processDeleteChunk(Connection conn, List<Integer> chunk) throws SQLException {
        String placeholders = String.join(", ", java.util.Collections.nCopies(chunk.size(), "?"));
        String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_FILM_ID, placeholders);
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < chunk.size(); i++) {
                ps.setInt(i + 1, chunk.get(i));
            }
            int affected = ps.executeUpdate();
            LOGGER.debug("Deleted {} rows in batch", affected);
            return affected;
        } catch (SQLException e) {
            LOGGER.error("Batch delete failed", e);
            throw e;
        }
    }

    public List<Film> findByLanguageID(Connection conn, int languageID) throws SQLException {
        List<Film> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_LANGUAGE_ID))) {
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
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_ORIGINAL_LANGUAGE_ID))) {
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
        setNullable(ps, 1, film.getTitle(), Types.VARCHAR);
        setNullable(ps, 2, film.getDescription(), Types.VARCHAR);
        setNullable(ps, 3, film.getReleaseYear(), Types.INTEGER);
        setNullable(ps, 4, film.getLanguage() != null ? film.getLanguage().getLanguageID() : null, Types.INTEGER);
        setNullable(ps, 5, film.getOriginalLanguage() != null ? film.getOriginalLanguage().getLanguageID() : null, Types.INTEGER);
        setNullable(ps, 6, film.getRentalDuration(), Types.INTEGER);
        setNullable(ps, 7, film.getRentalRate(), Types.NUMERIC);
        setNullable(ps, 8, film.getLength(), Types.INTEGER);
        setNullable(ps, 9, film.getReplacementCost(), Types.NUMERIC);
        setNullable(ps, 10, film.getRating(), Types.VARCHAR);
        setNullable(ps, 11, film.getSpecialFeatures(), Types.VARCHAR);
        setNullable(ps, 12, film.getLastUpdate() != null ? java.sql.Timestamp.valueOf(film.getLastUpdate()) : null, Types.TIMESTAMP);
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
