package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class LanguageDao {

    private static final String INSERT_SQL = "INSERT INTO language (name, last_update) VALUES (?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM language WHERE language_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM language ORDER BY language_id";

    private static final String UPDATE_SQL = "UPDATE language SET name = ?, last_update = ? WHERE language_id = ?";

    private static final String DELETE_SQL = "DELETE FROM language WHERE language_id = ?";

    public int insert(Connection conn, LanguageDTO languagedto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, languagedto.getName());
            ps.setTimestamp(2, Timestamp.valueOf(languagedto.getLastUpdate() != null ? languagedto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    languagedto.setLanguageID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public LanguageDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<LanguageDTO> findAll(Connection conn) throws SQLException {
        List<LanguageDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, LanguageDTO languagedto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, languagedto.getName());
            ps.setTimestamp(2, Timestamp.valueOf(languagedto.getLastUpdate() != null ? languagedto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(3, languagedto.getLanguageID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    private LanguageDTO extract(ResultSet rs) throws SQLException {
        LanguageDTO languagedto = new LanguageDTO();
        Integer language_id = rs.getObject("language_id", Integer.class);
        languagedto.setLanguageID(language_id);
        languagedto.setName(rs.getString("name"));
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            languagedto.setLastUpdate(last_update.toLocalDateTime());
        return languagedto;
    }
}
