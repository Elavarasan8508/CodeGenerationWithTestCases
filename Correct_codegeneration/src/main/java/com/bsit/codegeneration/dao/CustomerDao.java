package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class CustomerDao {

    private static final String INSERT_SQL = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date, last_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM customer WHERE customer_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM customer ORDER BY customer_id";

    private static final String SELECT_BY_ADDRESS_ID_SQL = "SELECT * FROM customer WHERE address_id = ?";

    private static final String SELECT_BY_STORE_ID_SQL = "SELECT * FROM customer WHERE store_id = ?";

    private static final String UPDATE_SQL = "UPDATE customer SET store_id = ?, first_name = ?, last_name = ?, email = ?, address_id = ?, active = ?, create_date = ?, last_update = ? WHERE customer_id = ?";

    private static final String DELETE_SQL = "DELETE FROM customer WHERE customer_id = ?";

    public int insert(Connection conn, CustomerDTO customerdto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            if (customerdto.getStore() != null && customerdto.getStore().getStoreID() > 0) {
                ps.setInt(1, customerdto.getStore().getStoreID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            ps.setString(2, customerdto.getFirstName());
            ps.setString(3, customerdto.getLastName());
            ps.setString(4, customerdto.getEmail());
            if (customerdto.getAddress() != null && customerdto.getAddress().getAddressID() > 0) {
                ps.setInt(5, customerdto.getAddress().getAddressID());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            ps.setString(6, customerdto.getActive());
            ps.setTimestamp(7, Timestamp.valueOf(customerdto.getCreateDate() != null ? customerdto.getCreateDate() : java.time.LocalDateTime.now()));
            ps.setTimestamp(8, Timestamp.valueOf(customerdto.getLastUpdate() != null ? customerdto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    customerdto.setCustomerID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public CustomerDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<CustomerDTO> findAll(Connection conn) throws SQLException {
        List<CustomerDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, CustomerDTO customerdto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            if (customerdto.getStore() != null && customerdto.getStore().getStoreID() > 0) {
                ps.setInt(1, customerdto.getStore().getStoreID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            ps.setString(2, customerdto.getFirstName());
            ps.setString(3, customerdto.getLastName());
            ps.setString(4, customerdto.getEmail());
            if (customerdto.getAddress() != null && customerdto.getAddress().getAddressID() > 0) {
                ps.setInt(5, customerdto.getAddress().getAddressID());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            ps.setString(6, customerdto.getActive());
            ps.setTimestamp(7, Timestamp.valueOf(customerdto.getCreateDate() != null ? customerdto.getCreateDate() : java.time.LocalDateTime.now()));
            ps.setTimestamp(8, Timestamp.valueOf(customerdto.getLastUpdate() != null ? customerdto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(9, customerdto.getCustomerID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<CustomerDTO> findByAddressID(Connection conn, int addressID) throws SQLException {
        List<CustomerDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ADDRESS_ID_SQL)) {
            ps.setInt(1, addressID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    public List<CustomerDTO> findByStoreID(Connection conn, int storeID) throws SQLException {
        List<CustomerDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_STORE_ID_SQL)) {
            ps.setInt(1, storeID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    private CustomerDTO extract(ResultSet rs) throws SQLException {
        CustomerDTO customerdto = new CustomerDTO();
        Integer customer_id = rs.getObject("customer_id", Integer.class);
        customerdto.setCustomerID(customer_id);
        Integer store_id = rs.getObject("store_id", Integer.class);
        customerdto.setStoreID(store_id);
        if (store_id != null && store_id > 0) {
            StoreDTO store = new StoreDTO();
            store.setStoreID(store_id);
            customerdto.setStore(store);
        }
        customerdto.setFirstName(rs.getString("first_name"));
        customerdto.setLastName(rs.getString("last_name"));
        customerdto.setEmail(rs.getString("email"));
        Integer address_id = rs.getObject("address_id", Integer.class);
        customerdto.setAddressID(address_id);
        if (address_id != null && address_id > 0) {
            AddressDTO address = new AddressDTO();
            address.setAddressID(address_id);
            customerdto.setAddress(address);
        }
        customerdto.setActive(rs.getString("active"));
        Timestamp create_date = rs.getTimestamp("create_date");
        if (create_date != null)
            customerdto.setCreateDate(create_date.toLocalDateTime());
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            customerdto.setLastUpdate(last_update.toLocalDateTime());
        return customerdto;
    }
}
