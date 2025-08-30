package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcActorDao {

    private static final String TABLE = "actor";

    private static final String COL_ACTOR_ID = "actor_id";

    private static final String COL_FIRST_NAME = "first_name";

    private static final String COL_LAST_NAME = "last_name";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?) RETURNING %s
        """.formatted(TABLE, COL_FIRST_NAME, COL_LAST_NAME, COL_LAST_UPDATE, COL_ACTOR_ID);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ACTOR_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_ACTOR_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_FIRST_NAME, COL_LAST_NAME, COL_LAST_UPDATE, COL_ACTOR_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ACTOR_ID);

    public int insert(Connection conn, Actor actor) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setActorParams(ps, actor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    actor.setActorID(id);
                    return id;
                }
            }
        }
        return -1;
    }

    public int[] insertAll(Connection conn, List<Actor> actors) throws SQLException {
        if (actors == null || actors.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < actors.size(); i++) {
            if (actors.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            results = new int[actors.size()];
            for (int i = 0; i < actors.size(); i++) {
                Actor item = actors.get(i);
                setActorParams(ps, item);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        item.setActorID(rs.getInt(1));
                        results[i] = 1;
                    }
                }
            }
        }
        return results;
    }

    public Actor findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<Actor> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<Actor> list = new ArrayList<>();
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

    public boolean update(Connection conn, Actor actor) throws SQLException {
        if (actor.getActorID() == 0)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setActorParams(ps, actor);
            ps.setInt(4, actor.getActorID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<Actor> actors) throws SQLException {
        if (actors == null || actors.isEmpty())
            return new int[0];
        for (Actor actor : actors) {
            if (actor == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (actor.getActorID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (Actor actor : actors) {
                setActorParams(ps, actor);
                ps.setInt(4, actor.getActorID());
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

    private void setActorParams(PreparedStatement ps, Actor actor) throws SQLException {
        ps.setString(1, actor.getFirstName());
        ps.setString(2, actor.getLastName());
        LocalDateTime updateTime3 = Objects.requireNonNullElse(actor.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(3, Timestamp.valueOf(updateTime3));
    }

    private Actor extract(ResultSet rs) throws SQLException {
        Actor actor = new Actor();
        Integer actor_id = rs.getObject(COL_ACTOR_ID, Integer.class);
        actor.setActorID(actor_id);
        actor.setFirstName(rs.getString(COL_FIRST_NAME));
        actor.setLastName(rs.getString(COL_LAST_NAME));
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            actor.setLastUpdate(last_update.toLocalDateTime());
        return actor;
    }
}
