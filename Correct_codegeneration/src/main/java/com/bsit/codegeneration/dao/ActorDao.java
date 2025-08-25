package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class ActorDao {

    private static final String INSERT_SQL = "INSERT INTO actor (first_name, last_name, last_update) VALUES (?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM actor WHERE actor_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM actor ORDER BY actor_id";

    private static final String UPDATE_SQL = "UPDATE actor SET first_name = ?, last_name = ?, last_update = ? WHERE actor_id = ?";

    private static final String DELETE_SQL = "DELETE FROM actor WHERE actor_id = ?";

    public int insert(Connection conn, ActorDTO actordto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, actordto.getFirstName());
            ps.setString(2, actordto.getLastName());
            ps.setTimestamp(3, Timestamp.valueOf(actordto.getLastUpdate() != null ? actordto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    actordto.setActorID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public ActorDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<ActorDTO> findAll(Connection conn) throws SQLException {
        List<ActorDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, ActorDTO actordto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, actordto.getFirstName());
            ps.setString(2, actordto.getLastName());
            ps.setTimestamp(3, Timestamp.valueOf(actordto.getLastUpdate() != null ? actordto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(4, actordto.getActorID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    private ActorDTO extract(ResultSet rs) throws SQLException {
        ActorDTO actordto = new ActorDTO();
        Integer actor_id = rs.getObject("actor_id", Integer.class);
        actordto.setActorID(actor_id);
        actordto.setFirstName(rs.getString("first_name"));
        actordto.setLastName(rs.getString("last_name"));
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            actordto.setLastUpdate(last_update.toLocalDateTime());
        return actordto;
    }
}
