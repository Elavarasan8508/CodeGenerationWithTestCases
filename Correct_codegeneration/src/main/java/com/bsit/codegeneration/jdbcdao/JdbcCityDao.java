package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcCityDao {

    private static final String TABLE = "city";

    private static final String COL_CITY_ID = "city_id";

    private static final String COL_CITY = "city";

    private static final String COL_COUNTRY_ID = "country_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?) RETURNING %s
        """.formatted(TABLE, COL_CITY, COL_COUNTRY_ID, COL_LAST_UPDATE, COL_CITY_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CITY_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_CITY_ID);

    private static final String SELECT_BY_COUNTRY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_COUNTRY_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CITY, COL_COUNTRY_ID, COL_LAST_UPDATE, COL_CITY_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CITY_ID);

    public int insert(Connection conn, City city) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setCityParams(ps, city);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    city.setCityID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<City> citys) throws SQLException {
        if (citys == null || citys.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < citys.size(); i++) {
            if (citys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            results = new int[citys.size()];
            for (int i = 0; i < citys.size(); i++) {
                City item = citys.get(i);
                setCityParams(ps, item);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        item.setCityID(rs.getInt(1));
                        results[i] = 1;
                    }
                }
            }
        }
        return results;
    }

    public City findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<City> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<City> list = new ArrayList<>();
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

    public boolean update(Connection conn, City city) throws SQLException {
        if (city.getCityID() == 0)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCityParams(ps, city);
            ps.setInt(4, city.getCityID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<City> citys) throws SQLException {
        if (citys == null || citys.isEmpty())
            return new int[0];
        for (City city : citys) {
            if (city == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (city.getCityID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (City city : citys) {
                setCityParams(ps, city);
                ps.setInt(4, city.getCityID());
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

    public List<City> findByCountryID(Connection conn, int countryID) throws SQLException {
        List<City> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_COUNTRY_ID_SQL)) {
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
        ps.setString(1, city.getCity());
        if (city.getCountry() != null && city.getCountry().getCountryID() > 0) {
            ps.setInt(2, city.getCountry().getCountryID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        LocalDateTime updateTime3 = Objects.requireNonNullElse(city.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(3, Timestamp.valueOf(updateTime3));
    }

    private City extract(ResultSet rs) throws SQLException {
        City city = new City();
        Integer city_id = rs.getObject(COL_CITY_ID, Integer.class);
        city.setCityID(city_id);
        city.setCity(rs.getString(COL_CITY));
        Integer country_id = rs.getObject(COL_COUNTRY_ID, Integer.class);
        city.setCountryID(country_id);
        if (country_id != null && country_id > 0) {
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
