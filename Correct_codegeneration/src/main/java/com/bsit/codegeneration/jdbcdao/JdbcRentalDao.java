package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcRentalDao {

    private static final String TABLE = "rental";

    private static final String COL_RENTAL_ID = "rental_id";

    private static final String COL_RENTAL_DATE = "rental_date";

    private static final String COL_INVENTORY_ID = "inventory_id";

    private static final String COL_CUSTOMER_ID = "customer_id";

    private static final String COL_RETURN_DATE = "return_date";

    private static final String COL_STAFF_ID = "staff_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s, %s, %s, %s)
        VALUES (?, ?, ?, ?, ?, ?)
        """.formatted(TABLE, COL_RENTAL_DATE, COL_INVENTORY_ID, COL_CUSTOMER_ID, COL_RETURN_DATE, COL_STAFF_ID, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_RENTAL_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_RENTAL_ID);

    private static final String SELECT_BY_CUSTOMER_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CUSTOMER_ID);

    private static final String SELECT_BY_INVENTORY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_INVENTORY_ID);

    private static final String SELECT_BY_STAFF_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STAFF_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_RENTAL_DATE, COL_INVENTORY_ID, COL_CUSTOMER_ID, COL_RETURN_DATE, COL_STAFF_ID, COL_LAST_UPDATE, COL_RENTAL_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_RENTAL_ID);

    public int insert(Connection conn, Rental rental) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setRentalParams(ps, rental);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    rental.setRentalID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Rental> rentals) throws SQLException {
        if (rentals == null || rentals.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < rentals.size(); i++) {
            if (rentals.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Rental rental : rentals) {
                setRentalParams(ps, rental);
                ps.addBatch();
            }
            results = ps.executeBatch();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                int index = 0;
                while (rs.next() && index < rentals.size()) {
                    try {
                        rentals.get(index).setRentalID(rs.getInt(1));
                    } catch (Exception e) {
                        // if mapping the key fails, wrap to give context
                        throw new SQLException("Failed to set generated key for index " + index + ": " + e.getMessage(), e);
                    }
                    index++;
                }
            }
        }
        return results;
    }

    public Rental findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Rental> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Rental> list = new ArrayList<>();
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

    public boolean update(Connection conn, Rental rental) throws SQLException {
        if (rental.getRentalID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setRentalParams(ps, rental);
            ps.setInt(7, rental.getRentalID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Rental> rentals) throws SQLException {
        if (rentals == null || rentals.isEmpty())
            return new int[0];
        for (Rental rental : rentals) {
            if (rental == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (rental.getRentalID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Rental rental : rentals) {
                setRentalParams(ps, rental);
                ps.setInt(7, rental.getRentalID());
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

    public List<Rental> findByCustomerID(Connection conn, int customerID) throws SQLException {
        List<Rental> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CUSTOMER_ID_SQL)) {
            ps.setInt(1, customerID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<Rental> findByInventoryID(Connection conn, int inventoryID) throws SQLException {
        List<Rental> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_INVENTORY_ID_SQL)) {
            ps.setInt(1, inventoryID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<Rental> findByStaffID(Connection conn, int staffID) throws SQLException {
        List<Rental> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_STAFF_ID_SQL)) {
            ps.setInt(1, staffID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setRentalParams(PreparedStatement ps, Rental rental) throws SQLException {
        LocalDateTime updateTime1 = Objects.requireNonNullElse(rental.getRentalDate(), LocalDateTime.now());
        ps.setTimestamp(1, Timestamp.valueOf(updateTime1));
        if (rental.getInventory() != null && rental.getInventory().getInventoryID() > 0) {
            ps.setInt(2, rental.getInventory().getInventoryID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        if (rental.getCustomer() != null && rental.getCustomer().getCustomerID() > 0) {
            ps.setInt(3, rental.getCustomer().getCustomerID());
        } else {
            ps.setNull(3, Types.INTEGER);
        }
        LocalDateTime updateTime4 = Objects.requireNonNullElse(rental.getReturnDate(), LocalDateTime.now());
        ps.setTimestamp(4, Timestamp.valueOf(updateTime4));
        if (rental.getStaff() != null && rental.getStaff().getStaffID() > 0) {
            ps.setInt(5, rental.getStaff().getStaffID());
        } else {
            ps.setNull(5, Types.INTEGER);
        }
        LocalDateTime updateTime6 = Objects.requireNonNullElse(rental.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(6, Timestamp.valueOf(updateTime6));
    }

    private Rental extract(ResultSet rs) throws SQLException {
        Rental rental = new Rental();
        Integer rental_id = rs.getObject(COL_RENTAL_ID, Integer.class);
        rental.setRentalID(rental_id);
        Timestamp rental_date = rs.getTimestamp(COL_RENTAL_DATE);
        if (rental_date != null)
            rental.setRentalDate(rental_date.toLocalDateTime());
        Integer inventory_id = rs.getObject(COL_INVENTORY_ID, Integer.class);
        rental.setInventoryID(inventory_id);
        if (inventory_id != null && inventory_id > 0) {
            Inventory inventory = new Inventory();
            inventory.setInventoryID(inventory_id);
            rental.setInventory(inventory);
        }
        Integer customer_id = rs.getObject(COL_CUSTOMER_ID, Integer.class);
        rental.setCustomerID(customer_id);
        if (customer_id != null && customer_id > 0) {
            Customer customer = new Customer();
            customer.setCustomerID(customer_id);
            rental.setCustomer(customer);
        }
        Timestamp return_date = rs.getTimestamp(COL_RETURN_DATE);
        if (return_date != null)
            rental.setReturnDate(return_date.toLocalDateTime());
        Integer staff_id = rs.getObject(COL_STAFF_ID, Integer.class);
        rental.setStaffID(staff_id);
        if (staff_id != null && staff_id > 0) {
            Staff staff = new Staff();
            staff.setStaffID(staff_id);
            rental.setStaff(staff);
        }
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            rental.setLastUpdate(last_update.toLocalDateTime());
        return rental;
    }
}
