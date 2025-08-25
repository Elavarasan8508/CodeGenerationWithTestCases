package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class AddressDao {

    private static final String INSERT_SQL = "INSERT INTO address (address, address2, district, city_id, postal_code, phone, last_update) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM address WHERE address_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM address ORDER BY address_id";

    private static final String SELECT_BY_CITY_ID_SQL = "SELECT * FROM address WHERE city_id = ?";

    private static final String UPDATE_SQL = "UPDATE address SET address = ?, address2 = ?, district = ?, city_id = ?, postal_code = ?, phone = ?, last_update = ? WHERE address_id = ?";

    private static final String DELETE_SQL = "DELETE FROM address WHERE address_id = ?";

    public int insert(Connection conn, AddressDTO addressdto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, addressdto.getAddress());
            ps.setString(2, addressdto.getAddress2());
            ps.setString(3, addressdto.getDistrict());
            if (addressdto.getCity() != null && addressdto.getCity().getCityID() > 0) {
                ps.setInt(4, addressdto.getCity().getCityID());
            } else {
                ps.setNull(4, Types.INTEGER);
            }
            ps.setString(5, addressdto.getPostalCode());
            ps.setString(6, addressdto.getPhone());
            ps.setTimestamp(7, Timestamp.valueOf(addressdto.getLastUpdate() != null ? addressdto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    addressdto.setAddressID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public AddressDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<AddressDTO> findAll(Connection conn) throws SQLException {
        List<AddressDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, AddressDTO addressdto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, addressdto.getAddress());
            ps.setString(2, addressdto.getAddress2());
            ps.setString(3, addressdto.getDistrict());
            if (addressdto.getCity() != null && addressdto.getCity().getCityID() > 0) {
                ps.setInt(4, addressdto.getCity().getCityID());
            } else {
                ps.setNull(4, Types.INTEGER);
            }
            ps.setString(5, addressdto.getPostalCode());
            ps.setString(6, addressdto.getPhone());
            ps.setTimestamp(7, Timestamp.valueOf(addressdto.getLastUpdate() != null ? addressdto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(8, addressdto.getAddressID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<AddressDTO> findByCityID(Connection conn, int cityID) throws SQLException {
        List<AddressDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CITY_ID_SQL)) {
            ps.setInt(1, cityID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    private AddressDTO extract(ResultSet rs) throws SQLException {
        AddressDTO addressdto = new AddressDTO();
        Integer address_id = rs.getObject("address_id", Integer.class);
        addressdto.setAddressID(address_id);
        addressdto.setAddress(rs.getString("address"));
        addressdto.setAddress2(rs.getString("address2"));
        addressdto.setDistrict(rs.getString("district"));
        Integer city_id = rs.getObject("city_id", Integer.class);
        addressdto.setCityID(city_id);
        if (city_id != null && city_id > 0) {
            CityDTO city = new CityDTO();
            city.setCityID(city_id);
            addressdto.setCity(city);
        }
        addressdto.setPostalCode(rs.getString("postal_code"));
        addressdto.setPhone(rs.getString("phone"));
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            addressdto.setLastUpdate(last_update.toLocalDateTime());
        return addressdto;
    }
}
