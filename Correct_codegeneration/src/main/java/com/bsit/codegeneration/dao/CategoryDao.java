package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class CategoryDao {

    private static final String INSERT_SQL = "INSERT INTO category (name, last_update) VALUES (?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM category WHERE category_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM category ORDER BY category_id";

    private static final String UPDATE_SQL = "UPDATE category SET name = ?, last_update = ? WHERE category_id = ?";

    private static final String DELETE_SQL = "DELETE FROM category WHERE category_id = ?";

    public int insert(Connection conn, CategoryDTO categorydto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, categorydto.getName());
            ps.setTimestamp(2, Timestamp.valueOf(categorydto.getLastUpdate() != null ? categorydto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    categorydto.setCategoryID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public CategoryDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<CategoryDTO> findAll(Connection conn) throws SQLException {
        List<CategoryDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, CategoryDTO categorydto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, categorydto.getName());
            ps.setTimestamp(2, Timestamp.valueOf(categorydto.getLastUpdate() != null ? categorydto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(3, categorydto.getCategoryID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    private CategoryDTO extract(ResultSet rs) throws SQLException {
        CategoryDTO categorydto = new CategoryDTO();
        Integer category_id = rs.getObject("category_id", Integer.class);
        categorydto.setCategoryID(category_id);
        categorydto.setName(rs.getString("name"));
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            categorydto.setLastUpdate(last_update.toLocalDateTime());
        return categorydto;
    }
}
