package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.FilmActor;

public interface FilmActorDao {

    @SqlUpdate("INSERT INTO film_actor (actor_id, film_id) VALUES (:actorId, :filmId)")
    public void insert(@Bind("actorId") int actorId, @Bind("filmId") int filmId);

    @SqlQuery("SELECT * FROM film_actor WHERE actor_id = :actorId AND film_id = :filmId")
    public FilmActor findByActorAndFilm(@Bind("actorId") int actorId, @Bind("filmId") int filmId);

    @SqlQuery("SELECT * FROM film_actor WHERE actor_id = :actorId")
    public List<FilmActor> findByActorId(@Bind("actorId") int actorId);

    @SqlQuery("SELECT * FROM film_actor WHERE film_id = :filmId")
    public List<FilmActor> findByFilmId(@Bind("filmId") int filmId);

    @SqlUpdate("DELETE FROM film_actor WHERE actor_id = :actorId AND film_id = :filmId")
    public void delete(@Bind("actorId") int actorId, @Bind("filmId") int filmId);
}
