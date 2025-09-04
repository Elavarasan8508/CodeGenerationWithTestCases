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

public class JdbcFilmCategoryDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcFilmCategoryDao.class);

    private static final String TABLE = "film_category";

    private static final String COL_FILM_ID = "film_id";

    private static final String COL_CATEGORY_ID = "category_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_FILM_ID, COL_CATEGORY_ID, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("film_id, category_id, last_update", TABLE, COL_FILM_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("film_id, category_id, last_update", TABLE, COL_FILM_ID);

    private static final String SELECT_BY_CATEGORY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("film_id, category_id, last_update", TABLE, COL_CATEGORY_ID);

    private static final String SELECT_BY_FILM_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("film_id, category_id, last_update", TABLE, COL_FILM_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CATEGORY_ID, COL_LAST_UPDATE, COL_FILM_ID);

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

    public int insert(Connection conn, FilmCategory filmcategory) throws SQLException {
        logger.debug("Inserting filmcategory: {}", filmcategory);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFilmCategoryParams(ps, filmcategory);
            ps.executeUpdate();
            return filmcategory.getFilmID();
        }
    }

    public int[] insertAll(Connection conn, List<FilmCategory> filmcategorys) throws SQLException {
        if (filmcategorys == null || filmcategorys.isEmpty())
            return new int[0];
        for (int i = 0; i < filmcategorys.size(); i++) {
            if (filmcategorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        int batchSize = 500;
        List<List<FilmCategory>> batches = chunkList(filmcategorys, batchSize);
        int[] totalResults = new int[filmcategorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<FilmCategory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
                    for (FilmCategory filmcategory : batch) {
                        setFilmCategoryParams(ps, filmcategory);
                        ps.addBatch();
                    }
                    int[] results = ps.executeBatch();
                    System.arraycopy(results, 0, totalResults, resultIndex, results.length);
                    resultIndex += results.length;
                    logger.debug("Inserted {} rows in batch", results.length);
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

    public FilmCategory findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FilmCategory> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<FilmCategory> list = new ArrayList<>();
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

    public boolean update(Connection conn, FilmCategory filmcategory) throws SQLException {
        if (filmcategory.getFilmID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFilmCategoryParams(ps, filmcategory);
            ps.setInt(3, filmcategory.getFilmID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FilmCategory> filmcategorys) throws SQLException {
        if (filmcategorys == null || filmcategorys.isEmpty())
            return new int[0];
        for (FilmCategory filmcategory : filmcategorys) {
            if (filmcategory == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (filmcategory.getFilmID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        int batchSize = 500;
        List<List<FilmCategory>> batches = chunkList(filmcategorys, batchSize);
        int[] totalResults = new int[filmcategorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<FilmCategory> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (FilmCategory filmcategory : batch) {
                        setFilmCategoryParams(ps, filmcategory);
                        ps.setInt(3, filmcategory.getFilmID());
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

    public List<FilmCategory> findByCategoryID(Connection conn, int categoryID) throws SQLException {
        List<FilmCategory> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CATEGORY_ID_SQL)) {
            ps.setInt(1, categoryID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FilmCategory> findByFilmID(Connection conn, int filmID) throws SQLException {
        List<FilmCategory> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_FILM_ID_SQL)) {
            ps.setInt(1, filmID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setFilmCategoryParams(PreparedStatement ps, FilmCategory filmcategory) throws SQLException {
        if (filmcategory.getFilm() != null) {
            ps.setObject(1, filmcategory.getFilm().getFilmID(), Types.INTEGER);
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (filmcategory.getCategory() != null) {
            ps.setObject(2, filmcategory.getCategory().getCategoryID(), Types.INTEGER);
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        java.time.LocalDateTime val3 = filmcategory.getLastUpdate();
        if (val3 != null) {
            ps.setObject(3, java.sql.Timestamp.valueOf(val3), Types.TIMESTAMP);
        } else {
            ps.setNull(3, Types.TIMESTAMP);
        }
    }

    private FilmCategory extract(ResultSet rs) throws SQLException {
        FilmCategory filmcategory = new FilmCategory();
        Integer film_id = rs.getObject(COL_FILM_ID, Integer.class);
        filmcategory.setFilmID(film_id);
        if (film_id != null) {
            Film film = new Film();
            film.setFilmID(film_id);
            filmcategory.setFilm(film);
        }
        Integer category_id = rs.getObject(COL_CATEGORY_ID, Integer.class);
        filmcategory.setCategoryID(category_id);
        if (category_id != null) {
            Category category = new Category();
            category.setCategoryID(category_id);
            filmcategory.setCategory(category);
        }
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            filmcategory.setLastUpdate(last_update.toLocalDateTime());
        return filmcategory;
    }
}
