package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcCountryDao {

    private static final String TABLE = "country";

    private static final String COL_COUNTRY_ID = "country_id";

    private static final String COL_COUNTRY = "country";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s)
        VALUES (?, ?) RETURNING %s
        """.formatted(TABLE, COL_COUNTRY, COL_LAST_UPDATE, COL_COUNTRY_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_COUNTRY_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_COUNTRY_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_COUNTRY, COL_LAST_UPDATE, COL_COUNTRY_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_COUNTRY_ID);

    public int insert(Connection conn, Country country) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setCountryParams(ps, country);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    country.setCountryID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Country> countrys) throws SQLException {
        if (countrys == null || countrys.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < countrys.size(); i++) {
            if (countrys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            results = new int[countrys.size()];
            for (int i = 0; i < countrys.size(); i++) {
                Country item = countrys.get(i);
                setCountryParams(ps, item);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        item.setCountryID(rs.getInt(1));
                        results[i] = 1;
                    }
                }
            }
        }
        return results;
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
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Country> list = new ArrayList<>();
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

    public boolean update(Connection conn, Country country) throws SQLException {
        if (country.getCountryID() == 0)
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
            if (country.getCountryID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Country country : countrys) {
                setCountryParams(ps, country);
                ps.setInt(3, country.getCountryID());
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

    private void setCountryParams(PreparedStatement ps, Country country) throws SQLException {
        ps.setString(1, country.getCountry());
        LocalDateTime updateTime2 = Objects.requireNonNullElse(country.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(2, Timestamp.valueOf(updateTime2));
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
