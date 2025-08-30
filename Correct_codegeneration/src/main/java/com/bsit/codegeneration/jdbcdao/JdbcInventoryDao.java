package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcInventoryDao {

    private static final String TABLE = "inventory";

    private static final String COL_INVENTORY_ID = "inventory_id";

    private static final String COL_FILM_ID = "film_id";

    private static final String COL_STORE_ID = "store_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?) RETURNING %s
        """.formatted(TABLE, COL_FILM_ID, COL_STORE_ID, COL_LAST_UPDATE, COL_INVENTORY_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_INVENTORY_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_INVENTORY_ID);

    private static final String SELECT_BY_FILM_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID);

    private static final String SELECT_BY_STORE_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_STORE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID, COL_STORE_ID, COL_LAST_UPDATE, COL_INVENTORY_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_INVENTORY_ID);

    public int insert(Connection conn, Inventory inventory) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setInventoryParams(ps, inventory);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    inventory.setInventoryID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Inventory> inventorys) throws SQLException {
        if (inventorys == null || inventorys.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < inventorys.size(); i++) {
            if (inventorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            results = new int[inventorys.size()];
            for (int i = 0; i < inventorys.size(); i++) {
                Inventory item = inventorys.get(i);
                setInventoryParams(ps, item);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        item.setInventoryID(rs.getInt(1));
                        results[i] = 1;
                    }
                }
            }
        }
        return results;
    }

    public Inventory findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Inventory> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Inventory> list = new ArrayList<>();
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

    public boolean update(Connection conn, Inventory inventory) throws SQLException {
        if (inventory.getInventoryID() == 0)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setInventoryParams(ps, inventory);
            ps.setInt(4, inventory.getInventoryID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Inventory> inventorys) throws SQLException {
        if (inventorys == null || inventorys.isEmpty())
            return new int[0];
        for (Inventory inventory : inventorys) {
            if (inventory == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (inventory.getInventoryID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Inventory inventory : inventorys) {
                setInventoryParams(ps, inventory);
                ps.setInt(4, inventory.getInventoryID());
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

    public List<Inventory> findByFilmID(Connection conn, int filmID) throws SQLException {
        List<Inventory> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_FILM_ID_SQL)) {
            ps.setInt(1, filmID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<Inventory> findByStoreID(Connection conn, int storeID) throws SQLException {
        List<Inventory> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_STORE_ID_SQL)) {
            ps.setInt(1, storeID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    private void setInventoryParams(PreparedStatement ps, Inventory inventory) throws SQLException {
        if (inventory.getFilm() != null && inventory.getFilm().getFilmID() > 0) {
            ps.setInt(1, inventory.getFilm().getFilmID());
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (inventory.getStore() != null && inventory.getStore().getStoreID() > 0) {
            ps.setInt(2, inventory.getStore().getStoreID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        LocalDateTime updateTime3 = Objects.requireNonNullElse(inventory.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(3, Timestamp.valueOf(updateTime3));
    }

    private Inventory extract(ResultSet rs) throws SQLException {
        Inventory inventory = new Inventory();
        Integer inventory_id = rs.getObject(COL_INVENTORY_ID, Integer.class);
        inventory.setInventoryID(inventory_id);
        Integer film_id = rs.getObject(COL_FILM_ID, Integer.class);
        inventory.setFilmID(film_id);
        if (film_id != null && film_id > 0) {
            Film film = new Film();
            film.setFilmID(film_id);
            inventory.setFilm(film);
        }
        Integer store_id = rs.getObject(COL_STORE_ID, Integer.class);
        inventory.setStoreID(store_id);
        if (store_id != null && store_id > 0) {
            Store store = new Store();
            store.setStoreID(store_id);
            inventory.setStore(store);
        }
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            inventory.setLastUpdate(last_update.toLocalDateTime());
        return inventory;
    }
}
