package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcCategoryDao {

    private static final String TABLE = "category";

    private static final String COL_CATEGORY_ID = "category_id";

    private static final String COL_NAME = "name";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s)
        VALUES (?, ?)
        """.formatted(TABLE, COL_NAME, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CATEGORY_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_CATEGORY_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_NAME, COL_LAST_UPDATE, COL_CATEGORY_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CATEGORY_ID);

    public int insert(Connection conn, Category category) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            setCategoryParams(ps, category);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    category.setCategoryID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Category> categorys) throws SQLException {
        if (categorys == null || categorys.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < categorys.size(); i++) {
            if (categorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            for (Category category : categorys) {
                setCategoryParams(ps, category);
                ps.addBatch();
            }
            results = ps.executeBatch();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                int index = 0;
                while (rs.next() && index < categorys.size()) {
                    try {
                        categorys.get(index).setCategoryID(rs.getInt(1));
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

    public Category findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Category> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Category> list = new ArrayList<>();
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

    public boolean update(Connection conn, Category category) throws SQLException {
        if (category.getCategoryID() == null)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setCategoryParams(ps, category);
            ps.setInt(3, category.getCategoryID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Category> categorys) throws SQLException {
        if (categorys == null || categorys.isEmpty())
            return new int[0];
        for (Category category : categorys) {
            if (category == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (category.getCategoryID() == null)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Category category : categorys) {
                setCategoryParams(ps, category);
                ps.setInt(3, category.getCategoryID());
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

    private void setCategoryParams(PreparedStatement ps, Category category) throws SQLException {
        ps.setString(1, category.getName());
        LocalDateTime updateTime2 = Objects.requireNonNullElse(category.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(2, Timestamp.valueOf(updateTime2));
    }

    private Category extract(ResultSet rs) throws SQLException {
        Category category = new Category();
        Integer category_id = rs.getObject(COL_CATEGORY_ID, Integer.class);
        category.setCategoryID(category_id);
        category.setName(rs.getString(COL_NAME));
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            category.setLastUpdate(last_update.toLocalDateTime());
        return category;
    }
}
