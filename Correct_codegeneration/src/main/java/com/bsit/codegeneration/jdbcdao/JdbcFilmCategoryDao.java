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
import com.bsit.codegeneration.pojo.FilmCategory;
import com.bsit.codegeneration.pojo.Film;
import com.bsit.codegeneration.pojo.Category;

public class JdbcFilmCategoryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcFilmCategoryDao.class);

    private static final String TABLE = "film_category";

    private static final String COL_FILM_ID = "film_id";

    private static final String COL_CATEGORY_ID = "category_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String SELECT_COLUMNS = "film_id, category_id, last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_FILM_ID, COL_CATEGORY_ID, COL_LAST_UPDATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted(SELECT_COLUMNS, TABLE, COL_FILM_ID);

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

    public int insert(Connection conn, FilmCategory filmcategory) throws SQLException {
        LOGGER.debug("Inserting filmcategory: {}", filmcategory);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFilmCategoryParams(ps, filmcategory);
            ps.executeUpdate();
            return filmcategory.getFilmID();
        }
    }

    public int[] insertAll(Connection conn, List<FilmCategory> filmcategorys) throws SQLException {
        if (isInvalidFilmCategoryList(filmcategorys)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<FilmCategory>> batches = chunkList(filmcategorys, batchSize);
        int[] totalResults = new int[filmcategorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<FilmCategory> batch : batches) {
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

    private boolean isInvalidFilmCategoryList(List<FilmCategory> filmcategorys) {
        if (filmcategorys == null || filmcategorys.isEmpty()) {
            return true;
        }
        for (int i = 0; i < filmcategorys.size(); i++) {
            if (filmcategorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        return false;
    }

    private int[] processBatch(Connection conn, List<FilmCategory> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            for (FilmCategory filmcategory : batch) {
                setFilmCategoryParams(ps, filmcategory);
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            LOGGER.debug("Inserted {} rows in batch", results.length);
            return results;
        }
    }

    public FilmCategory findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_FILM_ID))) {
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
        if (isInvalidUpdateFilmCategoryList(filmcategorys)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<FilmCategory>> batches = chunkList(filmcategorys, batchSize);
        int[] totalResults = new int[filmcategorys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<FilmCategory> batch : batches) {
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

    private boolean isInvalidUpdateFilmCategoryList(List<FilmCategory> filmcategorys) {
        if (filmcategorys == null || filmcategorys.isEmpty()) {
            return true;
        }
        for (FilmCategory filmcategory : filmcategorys) {
            if (filmcategory == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (filmcategory.getFilmID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        return false;
    }

    private int[] processUpdateBatch(Connection conn, List<FilmCategory> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (FilmCategory filmcategory : batch) {
                setFilmCategoryParams(ps, filmcategory);
                ps.setInt(3, filmcategory.getFilmID());
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

    public List<FilmCategory> findByCategoryID(Connection conn, int categoryID) throws SQLException {
        List<FilmCategory> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_CATEGORY_ID))) {
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
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_FILM_ID))) {
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
        setNullable(ps, 1, filmcategory.getFilm() != null ? filmcategory.getFilm().getFilmID() : null, Types.INTEGER);
        setNullable(ps, 2, filmcategory.getCategory() != null ? filmcategory.getCategory().getCategoryID() : null, Types.INTEGER);
        setNullable(ps, 3, filmcategory.getLastUpdate() != null ? java.sql.Timestamp.valueOf(filmcategory.getLastUpdate()) : null, Types.TIMESTAMP);
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
