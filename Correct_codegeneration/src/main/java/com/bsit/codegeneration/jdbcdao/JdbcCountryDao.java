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
import com.bsit.codegeneration.pojo.Country;

public class JdbcCountryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcCountryDao.class);

    private static final String TABLE = "country";

    private static final String COL_COUNTRY_ID = "country_id";

    private static final String COL_COUNTRY = "country";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String SELECT_COLUMNS = "country_id, country, last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s)
        VALUES (?, ?)
        """.formatted(TABLE, COL_COUNTRY, COL_LAST_UPDATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted(SELECT_COLUMNS, TABLE, COL_COUNTRY_ID);

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

    public int insert(Connection conn, Country country) throws SQLException {
        LOGGER.debug("Inserting country: {}", country);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setCountryParams(ps, country);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    country.setCountryID(id);
                    return id;
                } else {
                    LOGGER.error("Failed to retrieve generated ID for inserted country");
                    throw new SQLException("Failed to retrieve generated ID for inserted country");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<Country> countrys) throws SQLException {
        if (isInvalidCountryList(countrys)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Country>> batches = chunkList(countrys, batchSize);
        int[] totalResults = new int[countrys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Country> batch : batches) {
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

    private boolean isInvalidCountryList(List<Country> countrys) {
        if (countrys == null || countrys.isEmpty()) {
            return true;
        }
        for (int i = 0; i < countrys.size(); i++) {
            if (countrys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        return false;
    }

    private int[] processBatch(Connection conn, List<Country> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Country country : batch) {
                setCountryParams(ps, country);
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
                    batch.get(i).setCountryID(keys.get(i));
                }
            }
            return results;
        }
    }

    public Country findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_COUNTRY_ID))) {
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
        if (isInvalidUpdateCountryList(countrys)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<Country>> batches = chunkList(countrys, batchSize);
        int[] totalResults = new int[countrys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<Country> batch : batches) {
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

    private boolean isInvalidUpdateCountryList(List<Country> countrys) {
        if (countrys == null || countrys.isEmpty()) {
            return true;
        }
        for (Country country : countrys) {
            if (country == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (country.getCountryID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        return false;
    }

    private int[] processUpdateBatch(Connection conn, List<Country> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Country country : batch) {
                setCountryParams(ps, country);
                ps.setInt(3, country.getCountryID());
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
        String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_COUNTRY_ID, placeholders);
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

    private void setCountryParams(PreparedStatement ps, Country country) throws SQLException {
        setNullable(ps, 1, country.getCountry(), Types.VARCHAR);
        setNullable(ps, 2, country.getLastUpdate() != null ? java.sql.Timestamp.valueOf(country.getLastUpdate()) : null, Types.TIMESTAMP);
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
