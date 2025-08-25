package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class InventoryDao {

    private static final String INSERT_SQL = "INSERT INTO inventory (film_id, store_id, last_update) VALUES (?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM inventory WHERE inventory_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM inventory ORDER BY inventory_id";

    private static final String SELECT_BY_FILM_ID_SQL = "SELECT * FROM inventory WHERE film_id = ?";

    private static final String SELECT_BY_STORE_ID_SQL = "SELECT * FROM inventory WHERE store_id = ?";

    private static final String UPDATE_SQL = "UPDATE inventory SET film_id = ?, store_id = ?, last_update = ? WHERE inventory_id = ?";

    private static final String DELETE_SQL = "DELETE FROM inventory WHERE inventory_id = ?";

    public int insert(Connection conn, InventoryDTO inventorydto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            if (inventorydto.getFilm() != null && inventorydto.getFilm().getFilmID() > 0) {
                ps.setInt(1, inventorydto.getFilm().getFilmID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            if (inventorydto.getStore() != null && inventorydto.getStore().getStoreID() > 0) {
                ps.setInt(2, inventorydto.getStore().getStoreID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setTimestamp(3, Timestamp.valueOf(inventorydto.getLastUpdate() != null ? inventorydto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    inventorydto.setInventoryID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public InventoryDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<InventoryDTO> findAll(Connection conn) throws SQLException {
        List<InventoryDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, InventoryDTO inventorydto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            if (inventorydto.getFilm() != null && inventorydto.getFilm().getFilmID() > 0) {
                ps.setInt(1, inventorydto.getFilm().getFilmID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            if (inventorydto.getStore() != null && inventorydto.getStore().getStoreID() > 0) {
                ps.setInt(2, inventorydto.getStore().getStoreID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setTimestamp(3, Timestamp.valueOf(inventorydto.getLastUpdate() != null ? inventorydto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(4, inventorydto.getInventoryID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<InventoryDTO> findByFilmID(Connection conn, int filmID) throws SQLException {
        List<InventoryDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_FILM_ID_SQL)) {
            ps.setInt(1, filmID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    public List<InventoryDTO> findByStoreID(Connection conn, int storeID) throws SQLException {
        List<InventoryDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_STORE_ID_SQL)) {
            ps.setInt(1, storeID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    private InventoryDTO extract(ResultSet rs) throws SQLException {
        InventoryDTO inventorydto = new InventoryDTO();
        Integer inventory_id = rs.getObject("inventory_id", Integer.class);
        inventorydto.setInventoryID(inventory_id);
        Integer film_id = rs.getObject("film_id", Integer.class);
        inventorydto.setFilmID(film_id);
        if (film_id != null && film_id > 0) {
            FilmDTO film = new FilmDTO();
            film.setFilmID(film_id);
            inventorydto.setFilm(film);
        }
        Integer store_id = rs.getObject("store_id", Integer.class);
        inventorydto.setStoreID(store_id);
        if (store_id != null && store_id > 0) {
            StoreDTO store = new StoreDTO();
            store.setStoreID(store_id);
            inventorydto.setStore(store);
        }
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            inventorydto.setLastUpdate(last_update.toLocalDateTime());
        return inventorydto;
    }
}
