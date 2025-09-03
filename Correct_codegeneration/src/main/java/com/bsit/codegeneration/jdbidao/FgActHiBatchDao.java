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
import com.bsit.codegeneration.entity.FgActHiBatch;

public interface FgActHiBatchDao {

    /**
     * Inserts a new FgActHiBatch and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_BATCH (ID_, TYPE_, TOTAL_JOBS_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, TENANT_ID_, START_TIME_, END_TIME_, CREATE_USER_ID_, REMOVAL_TIME_) VALUES (:id, :type, :totalJobs, :jobsPerSeed, :invocationsPerJob, :seedJobDefId, :monitorJobDefId, :batchJobDefId, :tenantId, :startTime, :endTime, :createUserId, :removalTime)")
    public int insert(@BindBean FgActHiBatch fgacthibatch);

    /**
     * Finds a FgActHiBatch by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_BATCH WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiBatch.class)
    public Optional<FgActHiBatch> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_BATCH")
    @RegisterBeanMapper(FgActHiBatch.class)
    public List<FgActHiBatch> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_BATCH ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiBatch.class)
    public List<FgActHiBatch> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiBatch and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_BATCH SET TYPE_ = :type, TOTAL_JOBS_ = :totalJobs, JOBS_PER_SEED_ = :jobsPerSeed, INVOCATIONS_PER_JOB_ = :invocationsPerJob, SEED_JOB_DEF_ID_ = :seedJobDefId, MONITOR_JOB_DEF_ID_ = :monitorJobDefId, BATCH_JOB_DEF_ID_ = :batchJobDefId, TENANT_ID_ = :tenantId, START_TIME_ = :startTime, END_TIME_ = :endTime, CREATE_USER_ID_ = :createUserId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActHiBatch fgacthibatch);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_BATCH WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_BATCH")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiBatch entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_BATCH (ID_, TYPE_, TOTAL_JOBS_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, TENANT_ID_, START_TIME_, END_TIME_, CREATE_USER_ID_, REMOVAL_TIME_) VALUES (:id, :type, :totalJobs, :jobsPerSeed, :invocationsPerJob, :seedJobDefId, :monitorJobDefId, :batchJobDefId, :tenantId, :startTime, :endTime, :createUserId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActHiBatch> fgacthibatchs);

    /**
     * Bulk update multiple FgActHiBatch entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_BATCH SET TYPE_ = :type, TOTAL_JOBS_ = :totalJobs, JOBS_PER_SEED_ = :jobsPerSeed, INVOCATIONS_PER_JOB_ = :invocationsPerJob, SEED_JOB_DEF_ID_ = :seedJobDefId, MONITOR_JOB_DEF_ID_ = :monitorJobDefId, BATCH_JOB_DEF_ID_ = :batchJobDefId, TENANT_ID_ = :tenantId, START_TIME_ = :startTime, END_TIME_ = :endTime, CREATE_USER_ID_ = :createUserId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiBatch> fgacthibatchs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_BATCH WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_BATCH WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiBatch records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_BATCH WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiBatch.class)
    public List<FgActHiBatch> findByIds(@BindList("ids") Collection<String> ids);
}
