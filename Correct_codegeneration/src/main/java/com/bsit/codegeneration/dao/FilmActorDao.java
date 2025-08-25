package com.bsit.codegeneration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.bsit.codegeneration.dto.*;

public class FilmActorDao {

    private static final String INSERT_SQL = "INSERT INTO film_actor (actor_id, film_id, last_update) VALUES (?, ?, ?)";

    private static final String SELECT_BY_ID_SQL = "SELECT * FROM film_actor WHERE actor_id = ?";

    private static final String SELECT_ALL_SQL = "SELECT * FROM film_actor ORDER BY actor_id";

    private static final String SELECT_BY_ACTOR_ID_SQL = "SELECT * FROM film_actor WHERE actor_id = ?";

    private static final String SELECT_BY_FILM_ID_SQL = "SELECT * FROM film_actor WHERE film_id = ?";

    private static final String UPDATE_SQL = "UPDATE film_actor SET film_id = ?, last_update = ? WHERE actor_id = ?";

    private static final String DELETE_SQL = "DELETE FROM film_actor WHERE actor_id = ?";

    public int insert(Connection conn, FilmActorDTO filmactordto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            if (filmactordto.getActor() != null && filmactordto.getActor().getActorID() > 0) {
                ps.setInt(1, filmactordto.getActor().getActorID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            if (filmactordto.getFilm() != null && filmactordto.getFilm().getFilmID() > 0) {
                ps.setInt(2, filmactordto.getFilm().getFilmID());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setTimestamp(3, Timestamp.valueOf(filmactordto.getLastUpdate() != null ? filmactordto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.executeUpdate();
        }
        return filmactordto.getActorID();
    }

    public FilmActorDTO findById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? extract(rs) : null;
            }
        }
    }

    public List<FilmActorDTO> findAll(Connection conn) throws SQLException {
        List<FilmActorDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(extract(rs));
            }
        }
        return list;
    }

    public boolean update(Connection conn, FilmActorDTO filmactordto) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            if (filmactordto.getFilm() != null && filmactordto.getFilm().getFilmID() > 0) {
                ps.setInt(1, filmactordto.getFilm().getFilmID());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            ps.setTimestamp(2, Timestamp.valueOf(filmactordto.getLastUpdate() != null ? filmactordto.getLastUpdate() : java.time.LocalDateTime.now()));
            ps.setInt(3, filmactordto.getActorID());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteById(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<FilmActorDTO> findByActorID(Connection conn, int actorID) throws SQLException {
        List<FilmActorDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ACTOR_ID_SQL)) {
            ps.setInt(1, actorID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    public List<FilmActorDTO> findByFilmID(Connection conn, int filmID) throws SQLException {
        List<FilmActorDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_FILM_ID_SQL)) {
            ps.setInt(1, filmID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(extract(rs));
            }
        }
        return list;
    }

    private FilmActorDTO extract(ResultSet rs) throws SQLException {
        FilmActorDTO filmactordto = new FilmActorDTO();
        Integer actor_id = rs.getObject("actor_id", Integer.class);
        filmactordto.setActorID(actor_id);
        if (actor_id != null && actor_id > 0) {
            ActorDTO actor = new ActorDTO();
            actor.setActorID(actor_id);
            filmactordto.setActor(actor);
        }
        Integer film_id = rs.getObject("film_id", Integer.class);
        filmactordto.setFilmID(film_id);
        if (film_id != null && film_id > 0) {
            FilmDTO film = new FilmDTO();
            film.setFilmID(film_id);
            filmactordto.setFilm(film);
        }
        Timestamp last_update = rs.getTimestamp("last_update");
        if (last_update != null)
            filmactordto.setLastUpdate(last_update.toLocalDateTime());
        return filmactordto;
    }
}
