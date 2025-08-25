package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class CountryDao {

    private static final String INSERT_SQL = "INSERT INTO country (country, last_update) VALUES (?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM country WHERE country_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM country ORDER BY country_id";

    private static final String UPDATE_SQL = "UPDATE country SET country = ?, last_update = ? WHERE country_id = ?";

    private static final String DELETE_SQL = "DELETE FROM country WHERE country_id = ?";

    public int insert(Connection conn, CountryDTO countrydto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, countrydto.getCountry());
            ps.setTimestamp(2, Timestamp.valueOf(countrydto.getLastUpdate() != null ? countrydto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    countrydto.setCountryID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public CountryDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<CountryDTO> findAll(Connection conn) throws SQLException {
        List<CountryDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, CountryDTO countrydto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, countrydto.getCountry());
            ps.setTimestamp(2, Timestamp.valueOf(countrydto.getLastUpdate() != null ? countrydto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(3, countrydto.getCountryID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    private CountryDTO extract(ResultSet rs) throws SQLException {
        CountryDTO countrydto = new CountryDTO();
        Integer country_id = rs.getObject("country_id", Integer.class);
        countrydto.setCountryID(country_id);
        countrydto.setCountry(rs.getString("country"));
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            countrydto.setLastUpdate(last_update.toLocalDateTime());
        return countrydto;
    }
}
