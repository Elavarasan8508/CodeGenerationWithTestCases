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

public class JdbcLanguageDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcLanguageDao.class);

    private static final String TABLE = "language";

    private static final String COL_LANGUAGE_ID = "language_id";

    private static final String COL_NAME = "name";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s)
        VALUES (?, ?)
        """.formatted(TABLE, COL_NAME, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("language_id, name, last_update", TABLE, COL_LANGUAGE_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("language_id, name, last_update", TABLE, COL_LANGUAGE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_NAME, COL_LAST_UPDATE, COL_LANGUAGE_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_LANGUAGE_ID);

    private static <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }

    public int insert(Connection conn, Language language) throws SQLException {
        logger.debug("Inserting language: {}", language);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setLanguageParams(ps, language);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    language.setLanguageID(id);
                    return id;
                } else {
                    logger.error("Failed to retrieve generated ID for inserted language");
                    throw new SQLException("Failed to retrieve generated ID for inserted language");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Language> languages) throws SQLException {
        if (languages == null || languages.isEmpty())
            return new int[0];
        for (int i = 0; i < languages.size(); i++) {
            if (languages.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        int batchSize = 500;
        List<List<Language>> batches = chunkList(languages, batchSize);
        int[] totalResults = new int[languages.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Language> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                    for (Language language : batch) {
                        setLanguageParams(ps, language);
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
                            batch.get(i).setLanguageID(keys.get(i));
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

    public Language findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Language> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Language> list = new ArrayList<>();
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

    public boolean update(Connection conn, Language language) throws SQLException {
        if (language.getLanguageID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLanguageParams(ps, language);
            ps.setInt(3, language.getLanguageID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Language> languages) throws SQLException {
        if (languages == null || languages.isEmpty())
            return new int[0];
        for (Language language : languages) {
            if (language == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (language.getLanguageID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        int batchSize = 500;
        List<List<Language>> batches = chunkList(languages, batchSize);
        int[] totalResults = new int[languages.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Language> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Language language : batch) {
                        setLanguageParams(ps, language);
                        ps.setInt(3, language.getLanguageID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_LANGUAGE_ID, placeholders);
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

    private void setLanguageParams(PreparedStatement ps, Language language) throws SQLException {
        ps.setObject(1, language.getName(), Types.VARCHAR);
        java.time.LocalDateTime val2 = language.getLastUpdate();
        if (val2 != null) {
            ps.setObject(2, java.sql.Timestamp.valueOf(val2), Types.TIMESTAMP);
        } else {
            ps.setNull(2, Types.TIMESTAMP);
        }
    }

    private Language extract(ResultSet rs) throws SQLException {
        Language language = new Language();
        Integer language_id = rs.getObject(COL_LANGUAGE_ID, Integer.class);
        language.setLanguageID(language_id);
        language.setName(rs.getString(COL_NAME));
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            language.setLastUpdate(last_update.toLocalDateTime());
        return language;
    }
}
