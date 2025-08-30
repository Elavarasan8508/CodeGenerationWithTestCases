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

public interface ActorDao {

    /**
     * Inserts a new Actor and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO actor (first_name, last_name) VALUES (:firstName, :lastName)")
    @GetGeneratedKeys
    public int insert(@Bind("firstName") String firstName, @Bind("lastName") String lastName);

    /**
     * Finds a Actor by its ID.
     */
    @SqlQuery("SELECT * FROM actor WHERE actor_id = :id")
    @RegisterBeanMapper(Actor.class)
    public Optional<Actor> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM actor")
    @RegisterBeanMapper(Actor.class)
    public List<Actor> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM actor ORDER BY actor_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Actor.class)
    public List<Actor> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Actor and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE actor SET first_name = :firstName, last_name = :lastName WHERE actor_id = :actorId")
    public int update(@BindBean Actor actor);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM actor WHERE actor_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM actor")
    public long countAll();

    /**
     * Bulk insert multiple Actor entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO actor (first_name, last_name) VALUES (:firstName, :lastName)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Actor> actors);

    /**
     * Bulk insert with individual parameter lists and returns generated IDs.
     */
    @SqlBatch("INSERT INTO actor (first_name, last_name) VALUES (:firstName, :lastName)")
    @GetGeneratedKeys
    public int[] bulkInsertParams(@Bind("firstName") List<String> firstNames, @Bind("lastName") List<String> lastNames);

    /**
     * Bulk update multiple Actor entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE actor SET first_name = :firstName, last_name = :lastName WHERE actor_id = :actorId")
    public int[] bulkUpdate(@BindBean List<Actor> actors);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE actor SET first_name = :firstName, last_name = :lastName WHERE actor_id = :actorId")
    public int[] bulkUpdateParams(@Bind("firstName") List<String> firstNames, @Bind("lastName") List<String> lastNames, @Bind("actorId") List<Integer> actorIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM actor WHERE actor_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM actor WHERE actor_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Actor records by their IDs.
     */
    @SqlQuery("SELECT * FROM actor WHERE actor_id IN (<ids>)")
    @RegisterBeanMapper(Actor.class)
    public List<Actor> findByIds(@Bind("ids") Collection<Integer> ids);
}
