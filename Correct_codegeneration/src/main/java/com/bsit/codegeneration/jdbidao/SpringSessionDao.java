package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.batch.SqlBatch;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindList;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import com.bsit.codegeneration.entity.SpringSession;

public interface SpringSessionDao {

    /**
     * Inserts a new SpringSession and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SPRING_SESSION (PRIMARY_ID, SESSION_ID, CREATION_TIME, LAST_ACCESS_TIME, MAX_INACTIVE_INTERVAL, EXPIRY_TIME, PRINCIPAL_NAME) VALUES (:primaryId, :sessionId, :creationTime, :lastAccessTime, :maxInactiveInterval, :expiryTime, :principalName)")
    public int insert(@BindBean SpringSession springsession);

    /**
     * Finds a SpringSession by its ID.
     */
    @SqlQuery("SELECT * FROM SPRING_SESSION WHERE PRIMARY_ID = :id")
    @RegisterBeanMapper(SpringSession.class)
    public Optional<SpringSession> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SPRING_SESSION")
    @RegisterBeanMapper(SpringSession.class)
    public List<SpringSession> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SPRING_SESSION ORDER BY PRIMARY_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(SpringSession.class)
    public List<SpringSession> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a SpringSession and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SPRING_SESSION SET SESSION_ID = :sessionId, CREATION_TIME = :creationTime, LAST_ACCESS_TIME = :lastAccessTime, MAX_INACTIVE_INTERVAL = :maxInactiveInterval, EXPIRY_TIME = :expiryTime, PRINCIPAL_NAME = :principalName WHERE PRIMARY_ID = :primaryId")
    public int update(@BindBean SpringSession springsession);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SPRING_SESSION WHERE PRIMARY_ID = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SPRING_SESSION")
    public long countAll();

    /**
     * Bulk insert multiple SpringSession entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SPRING_SESSION (PRIMARY_ID, SESSION_ID, CREATION_TIME, LAST_ACCESS_TIME, MAX_INACTIVE_INTERVAL, EXPIRY_TIME, PRINCIPAL_NAME) VALUES (:primaryId, :sessionId, :creationTime, :lastAccessTime, :maxInactiveInterval, :expiryTime, :principalName)")
    public int[] bulkInsert(@BindBean List<SpringSession> springsessions);

    /**
     * Bulk update multiple SpringSession entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SPRING_SESSION SET SESSION_ID = :sessionId, CREATION_TIME = :creationTime, LAST_ACCESS_TIME = :lastAccessTime, MAX_INACTIVE_INTERVAL = :maxInactiveInterval, EXPIRY_TIME = :expiryTime, PRINCIPAL_NAME = :principalName WHERE PRIMARY_ID = :primaryId")
    public int[] bulkUpdate(@BindBean List<SpringSession> springsessions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SPRING_SESSION WHERE PRIMARY_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SPRING_SESSION WHERE PRIMARY_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple SpringSession records by their IDs.
     */
    @SqlQuery("SELECT * FROM SPRING_SESSION WHERE PRIMARY_ID IN (<ids>)")
    @RegisterBeanMapper(SpringSession.class)
    public List<SpringSession> findByIds(@BindList("ids") Collection<Integer> ids);
}
