package com.bsit.codegeneration.jdbcdao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.bsit.codegeneration.pojo.*;

public class JdbcFilmActorDao {

    private static final String TABLE = "film_actor";

    private static final String COL_ACTOR_ID = "actor_id";

    private static final String COL_FILM_ID = "film_id";

    private static final String COL_LAST_UPDATE = "last_update";

    private static final String INSERT_SQL = """
        INSERT INTO %s (%s, %s, %s)
        VALUES (?, ?, ?)
        """.formatted(TABLE, COL_ACTOR_ID, COL_FILM_ID, COL_LAST_UPDATE);

    private static final String SELECT_BY_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ACTOR_ID);

    private static final String SELECT_ALL_SQL = """
        SELECT * FROM %s ORDER BY %s LIMIT ? OFFSET ?
        """.formatted(TABLE, COL_ACTOR_ID);

    private static final String SELECT_BY_ACTOR_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ACTOR_ID);

    private static final String SELECT_BY_FILM_ID_SQL = """
        SELECT * FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID);

    private static final String UPDATE_SQL = """
        UPDATE %s
        SET %s = ?, %s = ?
        WHERE %s = ?
        """.formatted(TABLE, COL_FILM_ID, COL_LAST_UPDATE, COL_ACTOR_ID);

    private static final String DELETE_SQL = """
        DELETE FROM %s WHERE %s = ?
        """.formatted(TABLE, COL_ACTOR_ID);

    public int insert(Connection conn, FilmActor filmactor) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            setFilmActorParams(ps, filmactor);
            ps.executeUpdate();
        }
        return filmactor.getActor().getActorID();
    }

    public int[] insertAll(Connection conn, List<FilmActor> filmactors) throws SQLException {
        if (filmactors == null || filmactors.isEmpty())
            return new int[0];
        int[] results = new int[0];
        for (int i = 0; i < filmactors.size(); i++) {
            if (filmactors.get(i) == null)
                throw new IllegalArgumentException("Null DTO at index " + i + " in batch insert");
        }
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            for (FilmActor filmactor : filmactors) {
                setFilmActorParams(ps, filmactor);
                ps.addBatch();
            }
            results = ps.executeBatch();
        }
        return results;
    }

    public FilmActor findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FilmActor> findAll(Connection conn, int page, int pageSize) throws SQLException {
        if (page < 1)
            throw new IllegalArgumentException("Page must be at least 1");
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size must be at least 1");
        List<FilmActor> list = new ArrayList<>();
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

    public boolean update(Connection conn, FilmActor filmactor) throws SQLException {
        if (filmactor.getActorID() == 0)
            throw new IllegalArgumentException("Primary key cannot be null for update");
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            setFilmActorParams(ps, filmactor);
            ps.setInt(3, filmactor.getActorID());
            return ps.executeUpdate() > 0;
        }
    }

    public int[] updateAll(Connection conn, List<FilmActor> filmactors) throws SQLException {
        if (filmactors == null || filmactors.isEmpty())
            return new int[0];
        for (FilmActor filmactor : filmactors) {
            if (filmactor == null)
                throw new IllegalArgumentException("Null DTO in batch update");
            if (filmactor.getActorID() == 0)
                throw new IllegalArgumentException("Null primary key in batch update");
        }
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            for (FilmActor filmactor : filmactors) {
                setFilmActorParams(ps, filmactor);
                ps.setInt(3, filmactor.getActorID());
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

    public List<FilmActor> findByActorID(Connection conn, int actorID) throws SQLException {
        List<FilmActor> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ACTOR_ID_SQL)) {
            ps.setInt(1, actorID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }
        }
        return list;
    }

    public List<FilmActor> findByFilmID(Connection conn, int filmID) throws SQLException {
        List<FilmActor> list = new ArrayList<>();
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

    private void setFilmActorParams(PreparedStatement ps, FilmActor filmactor) throws SQLException {
        if (filmactor.getActor() != null && filmactor.getActor().getActorID() > 0) {
            ps.setInt(1, filmactor.getActor().getActorID());
        } else {
            ps.setNull(1, Types.INTEGER);
        }
        if (filmactor.getFilm() != null && filmactor.getFilm().getFilmID() > 0) {
            ps.setInt(2, filmactor.getFilm().getFilmID());
        } else {
            ps.setNull(2, Types.INTEGER);
        }
        LocalDateTime updateTime3 = Objects.requireNonNullElse(filmactor.getLastUpdate(), LocalDateTime.now());
        ps.setTimestamp(3, Timestamp.valueOf(updateTime3));
    }

    private FilmActor extract(ResultSet rs) throws SQLException {
        FilmActor filmactor = new FilmActor();
        Integer actor_id = rs.getObject(COL_ACTOR_ID, Integer.class);
        filmactor.setActorID(actor_id);
        if (actor_id != null && actor_id > 0) {
            Actor actor = new Actor();
            actor.setActorID(actor_id);
            filmactor.setActor(actor);
        }
        Integer film_id = rs.getObject(COL_FILM_ID, Integer.class);
        filmactor.setFilmID(film_id);
        if (film_id != null && film_id > 0) {
            Film film = new Film();
            film.setFilmID(film_id);
            filmactor.setFilm(film);
        }
        Timestamp last_update = rs.getTimestamp(COL_LAST_UPDATE);
        if (last_update != null)
            filmactor.setLastUpdate(last_update.toLocalDateTime());
        return filmactor;
    }
}
