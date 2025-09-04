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

public class JdbcCountryDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcCountryDao.class);

    private static final String TABLE = "country";

    private static final String COL_COUNTRY_ID = "country_id";

    private static final String COL_COUNTRY = "country";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s)
        VALUES (?, ?)
        """.formatted(TABLE, COL_COUNTRY, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT %s FROM %s WHERE %s = ?
        """.formatted("country_id, country, last_update", TABLE, COL_COUNTRY_ID);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted("country_id, country, last_update", TABLE, COL_COUNTRY_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_COUNTRY, COL_LAST_UPDATE, COL_COUNTRY_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_COUNTRY_ID);

    private static <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }

    public int insert(Connection conn, Country country) throws SQLException {
        logger.debug("Inserting country: {}", country);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setCountryParams(ps, country);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    country.setCountryID(id);
                    return id;
                } else {
                    logger.error("Failed to retrieve generated ID for inserted country");
                    throw new SQLException("Failed to retrieve generated ID for inserted country");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Country> countrys) throws SQLException {
        if (countrys == null || countrys.isEmpty())
            return new int[0];
        for (int i = 0; i < countrys.size(); i++) {
            if (countrys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        int batchSize = 500;
        List<List<Country>> batches = chunkList(countrys, batchSize);
        int[] totalResults = new int[countrys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Country> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                    for (Country country : batch) {
                        setCountryParams(ps, country);
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
                            batch.get(i).setCountryID(keys.get(i));
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

    public Country findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Country> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Country> list = new ArrayList<>();
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

    public boolean update(Connection conn, Country country) throws SQLException {
        if (country.getCountryID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCountryParams(ps, country);
            ps.setInt(3, country.getCountryID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Country> countrys) throws SQLException {
        if (countrys == null || countrys.isEmpty())
            return new int[0];
        for (Country country : countrys) {
            if (country == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (country.getCountryID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        int batchSize = 500;
        List<List<Country>> batches = chunkList(countrys, batchSize);
        int[] totalResults = new int[countrys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Country> batch : batches) {
                try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
                    for (Country country : batch) {
                        setCountryParams(ps, country);
                        ps.setInt(3, country.getCountryID());
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
                String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_COUNTRY_ID, placeholders);
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

    private void setCountryParams(PreparedStatement ps, Country country) throws SQLException {
        ps.setObject(1, country.getCountry(), Types.VARCHAR);
        java.time.LocalDateTime val2 = country.getLastUpdate();
        if (val2 != null) {
            ps.setObject(2, java.sql.Timestamp.valueOf(val2), Types.TIMESTAMP);
        } else {
            ps.setNull(2, Types.TIMESTAMP);
        }
    }

    private Country extract(ResultSet rs) throws SQLException {
        Country country = new Country();
        Integer country_id = rs.getObject(COL_COUNTRY_ID, Integer.class);
        country.setCountryID(country_id);
        country.setCountry(rs.getString(COL_COUNTRY));
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            country.setLastUpdate(last_update.toLocalDateTime());
        return country;
    }
}
