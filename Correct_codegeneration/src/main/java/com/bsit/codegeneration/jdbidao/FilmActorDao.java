package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.batch.SqlBatch;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import com.bsit.codegeneration.pojo.*;

public interface FilmActorDao {

    /**
     * Inserts a new join record and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO film_actor (actor_id, film_id) VALUES (:actorId, :filmId)")
    public int insert(@Bind("actorId") int actorId, @Bind("filmId") int filmId);

    /**
     * Finds join records by actorId.
     */
    @SqlQuery("SELECT * FROM film_actor WHERE actor_id = :actorId")
    @RegisterBeanMapper(FilmActor.class)
    public List<FilmActor> findByActorId(@Bind("actorId") int actorId);

    /**
     * Finds join records by filmId.
     */
    @SqlQuery("SELECT * FROM film_actor WHERE film_id = :filmId")
    @RegisterBeanMapper(FilmActor.class)
    public List<FilmActor> findByFilmId(@Bind("filmId") int filmId);

    /**
     * Deletes a join record and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM film_actor WHERE actor_id = :actorId AND film_id = :filmId")
    public int delete(@Bind("actorId") int actorId, @Bind("filmId") int filmId);

    /**
     * Bulk insert join records and returns affected row counts for each.
     */
    @SqlBatch("INSERT INTO film_actor (actor_id, film_id) VALUES (:actorId, :filmId)")
    public int[] bulkInsert(@Bind("actorId") List<Integer> actorIds, @Bind("filmId") List<Integer> filmIds);

    /**
     * Bulk delete join records and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM film_actor WHERE actor_id = :actorId AND film_id = :filmId")
    public int[] bulkDelete(@Bind("actorId") List<Integer> actorIds, @Bind("filmId") List<Integer> filmIds);
}
