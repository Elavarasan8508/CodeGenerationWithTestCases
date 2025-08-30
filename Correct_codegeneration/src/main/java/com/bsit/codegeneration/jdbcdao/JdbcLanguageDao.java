package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcLanguageDao {

    private static final String TABLE = "language";

    private static final String COL_LANGUAGE_ID = "language_id";

    private static final String COL_NAME = "name";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s)
        VALUES (?, ?) RETURNING %s
        """.formatted(TABLE, COL_NAME, COL_LAST_UPDATE, COL_LANGUAGE_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_LANGUAGE_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_LANGUAGE_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_NAME, COL_LAST_UPDATE, COL_LANGUAGE_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_LANGUAGE_ID);

    public int insert(Connection conn, Language language) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setLanguageParams(ps, language);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    language.setLanguageID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Language> languages) throws SQLException {
        if (languages == null || languages.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < languages.size(); i++) {
            if (languages.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            results = new int[languages.size()];
            for (int i = 0; i < languages.size(); i++) {
                Language item = languages.get(i);
                setLanguageParams(ps, item);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        item.setLanguageID(rs.getInt(1));
                        results[i] = 1;
                    }
                }
            }
        }
        return results;
    }

    public Language findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Language> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Language> list = new ArrayList<>();
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

    public boolean update(Connection conn, Language language) throws SQLException {
        if (language.getLanguageID() == 0)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setLanguageParams(ps, language);
            ps.setInt(3, language.getLanguageID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Language> languages) throws SQLException {
        if (languages == null || languages.isEmpty())
            return new int[0];
        for (Language language : languages) {
            if (language == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (language.getLanguageID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Language language : languages) {
                setLanguageParams(ps, language);
                ps.setInt(3, language.getLanguageID());
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

    private void setLanguageParams(PreparedStatement ps, Language language) throws SQLException {
        ps.setString(1, language.getName());
        LocalDateTime updateTime2 = Objects.requireNonNullElse(language.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(2, Timestamp.valueOf(updateTime2));
    }

    private Language extract(ResultSet rs) throws SQLException {
        Language language = new Language();
        Integer language_id = rs.getObject(COL_LANGUAGE_ID, Integer.class);
        language.setLanguageID(language_id);
        language.setName(rs.getString(COL_NAME));
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            language.setLastUpdate(last_update.toLocalDateTime());
        return language;
    }
}
