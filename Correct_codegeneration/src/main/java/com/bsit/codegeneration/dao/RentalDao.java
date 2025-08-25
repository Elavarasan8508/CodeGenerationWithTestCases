package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class RentalDao {

    private static final String INSERT_SQL = "INSERT INTO rental (rental_date, inventory_id, customer_id, return_date, staff_id, last_update) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM rental WHERE rental_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM rental ORDER BY rental_id";

    private static final String SELECT_BY_CUSTOMER_ID_SQL = "SELECT * FROM rental WHERE customer_id = ?";

    private static final String SELECT_BY_INVENTORY_ID_SQL = "SELECT * FROM rental WHERE inventory_id = ?";

    private static final String SELECT_BY_STAFF_ID_SQL = "SELECT * FROM rental WHERE staff_id = ?";

    private static final String UPDATE_SQL = "UPDATE rental SET rental_date = ?, inventory_id = ?, customer_id = ?, return_date = ?, staff_id = ?, last_update = ? WHERE rental_id = ?";

    private static final String DELETE_SQL = "DELETE FROM rental WHERE rental_id = ?";

    public int insert(Connection conn, RentalDTO rentaldto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setTimestamp(1, Timestamp.valueOf(rentaldto.getRentalDate() != null ? rentaldto.getRentalDate() : java.time.LocalDateTime.now()));
            if (rentaldto.getInventory() != null && rentaldto.getInventory().getInventoryID() > 0) {
                ps.setInt(2, rentaldto.getInventory().getInventoryID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            if (rentaldto.getCustomer() != null && rentaldto.getCustomer().getCustomerID() > 0) {
                ps.setInt(3, rentaldto.getCustomer().getCustomerID());
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            ps.setTimestamp(4, Timestamp.valueOf(rentaldto.getReturnDate() != null ? rentaldto.getReturnDate() : java.time.LocalDateTime.now()));
            if (rentaldto.getStaff() != null && rentaldto.getStaff().getStaffID() > 0) {
                ps.setInt(5, rentaldto.getStaff().getStaffID());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            ps.setTimestamp(6, Timestamp.valueOf(rentaldto.getLastUpdate() != null ? rentaldto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    rentaldto.setRentalID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public RentalDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<RentalDTO> findAll(Connection conn) throws SQLException {
        List<RentalDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, RentalDTO rentaldto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setTimestamp(1, Timestamp.valueOf(rentaldto.getRentalDate() != null ? rentaldto.getRentalDate() : java.time.LocalDateTime.now()));
            if (rentaldto.getInventory() != null && rentaldto.getInventory().getInventoryID() > 0) {
                ps.setInt(2, rentaldto.getInventory().getInventoryID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            if (rentaldto.getCustomer() != null && rentaldto.getCustomer().getCustomerID() > 0) {
                ps.setInt(3, rentaldto.getCustomer().getCustomerID());
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            ps.setTimestamp(4, Timestamp.valueOf(rentaldto.getReturnDate() != null ? rentaldto.getReturnDate() : java.time.LocalDateTime.now()));
            if (rentaldto.getStaff() != null && rentaldto.getStaff().getStaffID() > 0) {
                ps.setInt(5, rentaldto.getStaff().getStaffID());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            ps.setTimestamp(6, Timestamp.valueOf(rentaldto.getLastUpdate() != null ? rentaldto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(7, rentaldto.getRentalID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<RentalDTO> findByCustomerID(Connection conn, int customerID) throws SQLException {
        List<RentalDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CUSTOMER_ID_SQL)) {
            ps.setInt(1, customerID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    public List<RentalDTO> findByInventoryID(Connection conn, int inventoryID) throws SQLException {
        List<RentalDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_INVENTORY_ID_SQL)) {
            ps.setInt(1, inventoryID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    public List<RentalDTO> findByStaffID(Connection conn, int staffID) throws SQLException {
        List<RentalDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_STAFF_ID_SQL)) {
            ps.setInt(1, staffID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    private RentalDTO extract(ResultSet rs) throws SQLException {
        RentalDTO rentaldto = new RentalDTO();
        Integer rental_id = rs.getObject("rental_id", Integer.class);
        rentaldto.setRentalID(rental_id);
        Timestamp rental_date = rs.getTimestamp("rental_date");
        if (rental_date != null)
            rentaldto.setRentalDate(rental_date.toLocalDateTime());
        Integer inventory_id = rs.getObject("inventory_id", Integer.class);
        rentaldto.setInventoryID(inventory_id);
        if (inventory_id != null && inventory_id > 0) {
            InventoryDTO inventory = new InventoryDTO();
            inventory.setInventoryID(inventory_id);
            rentaldto.setInventory(inventory);
        }
        Integer customer_id = rs.getObject("customer_id", Integer.class);
        rentaldto.setCustomerID(customer_id);
        if (customer_id != null && customer_id > 0) {
            CustomerDTO customer = new CustomerDTO();
            customer.setCustomerID(customer_id);
            rentaldto.setCustomer(customer);
        }
        Timestamp return_date = rs.getTimestamp("return_date");
        if (return_date != null)
            rentaldto.setReturnDate(return_date.toLocalDateTime());
        Integer staff_id = rs.getObject("staff_id", Integer.class);
        rentaldto.setStaffID(staff_id);
        if (staff_id != null && staff_id > 0) {
            StaffDTO staff = new StaffDTO();
            staff.setStaffID(staff_id);
            rentaldto.setStaff(staff);
        }
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            rentaldto.setLastUpdate(last_update.toLocalDateTime());
        return rentaldto;
    }
}
