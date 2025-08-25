package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class CityDao {

    private static final String INSERT_SQL = "INSERT INTO city (city, country_id, last_update) VALUES (?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM city WHERE city_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM city ORDER BY city_id";

    private static final String SELECT_BY_COUNTRY_ID_SQL = "SELECT * FROM city WHERE country_id = ?";

    private static final String UPDATE_SQL = "UPDATE city SET city = ?, country_id = ?, last_update = ? WHERE city_id = ?";

    private static final String DELETE_SQL = "DELETE FROM city WHERE city_id = ?";

    public int insert(Connection conn, CityDTO citydto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, citydto.getCity());
            if (citydto.getCountry() != null && citydto.getCountry().getCountryID() > 0) {
                ps.setInt(2, citydto.getCountry().getCountryID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setTimestamp(3, Timestamp.valueOf(citydto.getLastUpdate() != null ? citydto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    citydto.setCityID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public CityDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<CityDTO> findAll(Connection conn) throws SQLException {
        List<CityDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, CityDTO citydto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, citydto.getCity());
            if (citydto.getCountry() != null && citydto.getCountry().getCountryID() > 0) {
                ps.setInt(2, citydto.getCountry().getCountryID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setTimestamp(3, Timestamp.valueOf(citydto.getLastUpdate() != null ? citydto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(4, citydto.getCityID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<CityDTO> findByCountryID(Connection conn, int countryID) throws SQLException {
        List<CityDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_COUNTRY_ID_SQL)) {
            ps.setInt(1, countryID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    private CityDTO extract(ResultSet rs) throws SQLException {
        CityDTO citydto = new CityDTO();
        Integer city_id = rs.getObject("city_id", Integer.class);
        citydto.setCityID(city_id);
        citydto.setCity(rs.getString("city"));
        Integer country_id = rs.getObject("country_id", Integer.class);
        citydto.setCountryID(country_id);
        if (country_id != null && country_id > 0) {
            CountryDTO country = new CountryDTO();
            country.setCountryID(country_id);
            citydto.setCountry(country);
        }
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            citydto.setLastUpdate(last_update.toLocalDateTime());
        return citydto;
    }
}
