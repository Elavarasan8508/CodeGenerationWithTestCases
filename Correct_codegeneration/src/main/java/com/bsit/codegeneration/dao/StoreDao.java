package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class StoreDao {

    private static final String INSERT_SQL = "INSERT INTO store (manager_staff_id, address_id, last_update) VALUES (?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM store WHERE store_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM store ORDER BY store_id";

    private static final String SELECT_BY_ADDRESS_ID_SQL = "SELECT * FROM store WHERE address_id = ?";

    private static final String SELECT_BY_MANAGER_STAFF_ID_SQL = "SELECT * FROM store WHERE manager_staff_id = ?";

    private static final String UPDATE_SQL = "UPDATE store SET manager_staff_id = ?, address_id = ?, last_update = ? WHERE store_id = ?";

    private static final String DELETE_SQL = "DELETE FROM store WHERE store_id = ?";

    public int insert(Connection conn, StoreDTO storedto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            if (storedto.getManagerStaff() != null && storedto.getManagerStaff().getStaffID() > 0) {
                ps.setInt(1, storedto.getManagerStaff().getStaffID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            if (storedto.getAddress() != null && storedto.getAddress().getAddressID() > 0) {
                ps.setInt(2, storedto.getAddress().getAddressID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setTimestamp(3, Timestamp.valueOf(storedto.getLastUpdate() != null ? storedto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    storedto.setStoreID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public StoreDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<StoreDTO> findAll(Connection conn) throws SQLException {
        List<StoreDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, StoreDTO storedto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            if (storedto.getManagerStaff() != null && storedto.getManagerStaff().getStaffID() > 0) {
                ps.setInt(1, storedto.getManagerStaff().getStaffID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            if (storedto.getAddress() != null && storedto.getAddress().getAddressID() > 0) {
                ps.setInt(2, storedto.getAddress().getAddressID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setTimestamp(3, Timestamp.valueOf(storedto.getLastUpdate() != null ? storedto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(4, storedto.getStoreID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<StoreDTO> findByAddressID(Connection conn, int addressID) throws SQLException {
        List<StoreDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ADDRESS_ID_SQL)) {
            ps.setInt(1, addressID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    public List<StoreDTO> findByManagerStaffID(Connection conn, int managerStaffID) throws SQLException {
        List<StoreDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_MANAGER_STAFF_ID_SQL)) {
            ps.setInt(1, managerStaffID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    private StoreDTO extract(ResultSet rs) throws SQLException {
        StoreDTO storedto = new StoreDTO();
        Integer store_id = rs.getObject("store_id", Integer.class);
        storedto.setStoreID(store_id);
        Integer manager_staff_id = rs.getObject("manager_staff_id", Integer.class);
        storedto.setManagerStaffID(manager_staff_id);
        if (manager_staff_id != null && manager_staff_id > 0) {
            StaffDTO managerStaff = new StaffDTO();
            managerStaff.setStaffID(manager_staff_id);
            storedto.setManagerStaff(managerStaff);
        }
        Integer address_id = rs.getObject("address_id", Integer.class);
        storedto.setAddressID(address_id);
        if (address_id != null && address_id > 0) {
            AddressDTO address = new AddressDTO();
            address.setAddressID(address_id);
            storedto.setAddress(address);
        }
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            storedto.setLastUpdate(last_update.toLocalDateTime());
        return storedto;
    }
}
