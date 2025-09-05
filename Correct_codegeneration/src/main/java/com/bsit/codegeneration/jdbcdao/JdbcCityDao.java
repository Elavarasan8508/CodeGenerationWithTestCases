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
import com.bsit.codegeneration.pojo.City;
import com.bsit.codegeneration.pojo.Country;

public class JdbcCityDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcCityDao.class);

    private static final String TABLE = "city";

    private static final String COL_CITY_ID = "city_id";

    private static final String COL_CITY = "city";

    private static final String COL_COUNTRY_ID = "country_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String SELECT_COLUMNS = "city_id, city, country_id, last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_CITY, COL_COUNTRY_ID, COL_LAST_UPDATE);

    private static final String SELECT_ALL_BASE = """
        SELECT %s FROM %s ORDER BY %s
        """.formatted(SELECT_COLUMNS, TABLE, COL_CITY_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CITY, COL_COUNTRY_ID, COL_LAST_UPDATE, COL_CITY_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CITY_ID);

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

    public int insert(Connection conn, City city) throws SQLException {
        LOGGER.debug("Inserting city: {}", city);
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setCityParams(ps, city);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Integer id = rs.getInt(1);
                    city.setCityID(id);
                    return id;
                } else {
                    LOGGER.error("Failed to retrieve generated ID for inserted city");
                    throw new SQLException("Failed to retrieve generated ID for inserted city");
                }
            }
        }
    }

    public int[] insertAll(Connection conn, List<City> citys) throws SQLException {
        if (isInvalidCityList(citys)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<City>> batches = chunkList(citys, batchSize);
        int[] totalResults = new int[citys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<City> batch : batches) {
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

    private boolean isInvalidCityList(List<City> citys) {
        if (citys == null || citys.isEmpty()) {
            return true;
        }
        for (int i = 0; i < citys.size(); i++) {
            if (citys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        return false;
    }

    private int[] processBatch(Connection conn, List<City> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (City city : batch) {
                setCityParams(ps, city);
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
                    batch.get(i).setCityID(keys.get(i));
                }
            }
            return results;
        }
    }

    public City findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_CITY_ID))) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<City> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be >= 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be >= 1");
        String sql = SELECT_ALL_BASE + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<City> list = new ArrayList<>();
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

    public boolean update(Connection conn, City city) throws SQLException {
        if (city.getCityID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCityParams(ps, city);
            ps.setInt(4, city.getCityID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<City> citys) throws SQLException {
        if (isInvalidUpdateCityList(citys)) {
            return new int[0];
        }
        int batchSize = 500;
        List<List<City>> batches = chunkList(citys, batchSize);
        int[] totalResults = new int[citys.size()];
        int resultIndex = 0;
        boolean autoCommit = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            for (List<City> batch : batches) {
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

    private boolean isInvalidUpdateCityList(List<City> citys) {
        if (citys == null || citys.isEmpty()) {
            return true;
        }
        for (City city : citys) {
            if (city == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (city.getCityID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        return false;
    }

    private int[] processUpdateBatch(Connection conn, List<City> batch) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (City city : batch) {
                setCityParams(ps, city);
                ps.setInt(4, city.getCityID());
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
        String sql = String.format("DELETE FROM %s WHERE %s IN (%s)", TABLE, COL_CITY_ID, placeholders);
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

    public List<City> findByCountryID(Connection conn, int countryID) throws SQLException {
        List<City> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(getSelectByColumnSql(COL_COUNTRY_ID))) {
            ps.setInt(1, countryID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setCityParams(PreparedStatement ps, City city) throws SQLException {
        setNullable(ps, 1, city.getCity(), Types.VARCHAR);
        setNullable(ps, 2, city.getCountry() != null ? city.getCountry().getCountryID() : null, Types.INTEGER);
        setNullable(ps, 3, city.getLastUpdate() != null ? java.sql.Timestamp.valueOf(city.getLastUpdate()) : null, Types.TIMESTAMP);
    }

    private City extract(ResultSet rs) throws SQLException {
        City city = new City();
        Integer city_id = rs.getObject(COL_CITY_ID, Integer.class);
        city.setCityID(city_id);
        city.setCity(rs.getString(COL_CITY));
        Integer country_id = rs.getObject(COL_COUNTRY_ID, Integer.class);
        city.setCountryID(country_id);
        if (country_id != null) {
            Country country = new Country();
            country.setCountryID(country_id);
            city.setCountry(country);
        }
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            city.setLastUpdate(last_update.toLocalDateTime());
        return city;
    }
}
