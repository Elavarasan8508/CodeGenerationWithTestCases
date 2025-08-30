package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcFilmCategoryDao {

    private static final String TABLE = "film_category";

    private static final String COL_FILM_ID = "film_id";

    private static final String COL_CATEGORY_ID = "category_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_FILM_ID, COL_CATEGORY_ID, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_FILM_ID);

    private static final String SELECT_BY_CATEGORY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_CATEGORY_ID);

    private static final String SELECT_BY_FILM_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_CATEGORY_ID, COL_LAST_UPDATE, COL_FILM_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID);

    public int insert(Connection conn, FilmCategory filmcategory) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFilmCategoryParams(ps, filmcategory);
            ps.executeUpdate();
        }
        return filmcategory.getFilm().getFilmID();
    }

    public int[] insertAll(Connection conn, List<FilmCategory> filmcategorys) throws SQLException {
        if (filmcategorys == null || filmcategorys.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < filmcategorys.size(); i++) {
            if (filmcategorys.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            for (FilmCategory filmcategory : filmcategorys) {
                setFilmCategoryParams(ps, filmcategory);
                ps.addBatch();
            }
            results = ps.executeBatch();
        }
        return results;
    }

    public FilmCategory findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FilmCategory> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FilmCategory> list = new ArrayList<>();
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

    public boolean update(Connection conn, FilmCategory filmcategory) throws SQLException {
        if (filmcategory.getFilmID() == 0)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFilmCategoryParams(ps, filmcategory);
            ps.setInt(3, filmcategory.getFilmID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FilmCategory> filmcategorys) throws SQLException {
        if (filmcategorys == null || filmcategorys.isEmpty())
            return new int[0];
        for (FilmCategory filmcategory : filmcategorys) {
            if (filmcategory == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (filmcategory.getFilmID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (FilmCategory filmcategory : filmcategorys) {
                setFilmCategoryParams(ps, filmcategory);
                ps.setInt(3, filmcategory.getFilmID());
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

    public List<FilmCategory> findByCategoryID(Connection conn, int categoryID) throws SQLException {
        List<FilmCategory> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_CATEGORY_ID_SQL)) {
            ps.setInt(1, categoryID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FilmCategory> findByFilmID(Connection conn, int filmID) throws SQLException {
        List<FilmCategory> list = new ArrayList<>();
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

    private void setFilmCategoryParams(PreparedStatement ps, FilmCategory filmcategory) throws SQLException {
        if (filmcategory.getFilm() != null && filmcategory.getFilm().getFilmID() > 0) {
            ps.setInt(1, filmcategory.getFilm().getFilmID());
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (filmcategory.getCategory() != null && filmcategory.getCategory().getCategoryID() > 0) {
            ps.setInt(2, filmcategory.getCategory().getCategoryID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        LocalDateTime updateTime3 = Objects.requireNonNullElse(filmcategory.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(3, Timestamp.valueOf(updateTime3));
    }

    private FilmCategory extract(ResultSet rs) throws SQLException {
        FilmCategory filmcategory = new FilmCategory();
        Integer film_id = rs.getObject(COL_FILM_ID, Integer.class);
        filmcategory.setFilmID(film_id);
        if (film_id != null && film_id > 0) {
            Film film = new Film();
            film.setFilmID(film_id);
            filmcategory.setFilm(film);
        }
        Integer category_id = rs.getObject(COL_CATEGORY_ID, Integer.class);
        filmcategory.setCategoryID(category_id);
        if (category_id != null && category_id > 0) {
            Category category = new Category();
            category.setCategoryID(category_id);
            filmcategory.setCategory(category);
        }
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            filmcategory.setLastUpdate(last_update.toLocalDateTime());
        return filmcategory;
    }
}
