package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Actor;

public interface ActorDao {

    @SqlUpdate("INSERT INTO actor (first_name, last_name) VALUES (:firstName, :lastName)")
    @GetGeneratedKeys
    public int insert(@Bind("firstName") String firstName, @Bind("lastName") String lastName);

    @SqlQuery("SELECT * FROM actor WHERE actor_id = :id")
    public Actor findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM actor")
    public List<Actor> findAll();

    @SqlUpdate("UPDATE actor SET first_name = :firstName, last_name = :lastName WHERE actor_id = :actorId")
    public void update(@BindBean Actor actor);

    @SqlUpdate("DELETE FROM actor WHERE actor_id = :id")
    public void deleteById(@Bind("id") int id);
}
