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
import com.bsit.codegeneration.entity.IntLock;

public interface IntLockDao {

    /**
     * Inserts a new IntLock and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO INT_LOCK (LOCK_KEY, REGION, CLIENT_ID) VALUES (:lockKey, :region, :clientId)")
    public int insert(@Bind("lockKey") String lockKey, @Bind("region") String region, @Bind("clientId") int clientId);

    /**
     * Finds a IntLock by its ID.
     */
    @SqlQuery("SELECT * FROM INT_LOCK WHERE LOCK_KEY = :id")
    @RegisterBeanMapper(IntLock.class)
    public Optional<IntLock> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM INT_LOCK")
    @RegisterBeanMapper(IntLock.class)
    public List<IntLock> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM INT_LOCK ORDER BY LOCK_KEY LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(IntLock.class)
    public List<IntLock> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a IntLock and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE INT_LOCK SET REGION = :region, CLIENT_ID = :clientId WHERE LOCK_KEY = :lockKey")
    public int update(@BindBean IntLock intlock);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM INT_LOCK WHERE LOCK_KEY = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM INT_LOCK")
    public long countAll();

    /**
     * Bulk insert multiple IntLock entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO INT_LOCK (LOCK_KEY, REGION, CLIENT_ID) VALUES (:lockKey, :region, :clientId)")
    public int[] bulkInsert(@BindBean List<IntLock> intlocks);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO INT_LOCK (LOCK_KEY, REGION, CLIENT_ID) VALUES (:lockKey, :region, :clientId)")
    public int[] bulkInsertParams(@Bind("lockKey") List<String> lockKeys, @Bind("region") List<String> regions, @Bind("clientId") List<Integer> clientIds);

    /**
     * Bulk update multiple IntLock entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE INT_LOCK SET REGION = :region, CLIENT_ID = :clientId WHERE LOCK_KEY = :lockKey")
    public int[] bulkUpdate(@BindBean List<IntLock> intlocks);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE INT_LOCK SET REGION = :region, CLIENT_ID = :clientId WHERE LOCK_KEY = :lockKey")
    public int[] bulkUpdateParams(@Bind("region") List<String> regions, @Bind("clientId") List<Integer> clientIds, @Bind("lockKey") List<String> lockKeys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM INT_LOCK WHERE LOCK_KEY IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM INT_LOCK WHERE LOCK_KEY = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple IntLock records by their IDs.
     */
    @SqlQuery("SELECT * FROM INT_LOCK WHERE LOCK_KEY IN (<ids>)")
    @RegisterBeanMapper(IntLock.class)
    public List<IntLock> findByIds(@BindList("ids") Collection<String> ids);
}
