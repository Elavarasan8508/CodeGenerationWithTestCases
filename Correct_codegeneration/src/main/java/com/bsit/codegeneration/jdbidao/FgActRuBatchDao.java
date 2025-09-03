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
import com.bsit.codegeneration.entity.FgActRuBatch;

public interface FgActRuBatchDao {

    /**
     * Inserts a new FgActRuBatch and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_BATCH (ID_, REV_, TYPE_, TOTAL_JOBS_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, SUSPENSION_STATE_, CONFIGURATION_, TENANT_ID_, CREATE_USER_ID_) VALUES (:id, :rev, :type, :totalJobs, :jobsPerSeed, :invocationsPerJob, :seedJobDefId, :batchJobDefId, :monitorJobDefId, :suspensionState, :configuration, :tenantId, :createUserId)")
    public int insert(@BindBean FgActRuBatch fgactrubatch);

    /**
     * Finds a FgActRuBatch by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_BATCH WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuBatch.class)
    public Optional<FgActRuBatch> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_BATCH")
    @RegisterBeanMapper(FgActRuBatch.class)
    public List<FgActRuBatch> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_BATCH ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuBatch.class)
    public List<FgActRuBatch> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuBatch and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_BATCH SET REV_ = :rev, TYPE_ = :type, TOTAL_JOBS_ = :totalJobs, JOBS_PER_SEED_ = :jobsPerSeed, INVOCATIONS_PER_JOB_ = :invocationsPerJob, SEED_JOB_DEF_ID_ = :seedJobDefId, BATCH_JOB_DEF_ID_ = :batchJobDefId, MONITOR_JOB_DEF_ID_ = :monitorJobDefId, SUSPENSION_STATE_ = :suspensionState, CONFIGURATION_ = :configuration, TENANT_ID_ = :tenantId, CREATE_USER_ID_ = :createUserId WHERE ID_ = :id")
    public int update(@BindBean FgActRuBatch fgactrubatch);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_BATCH WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_BATCH")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuBatch entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_BATCH (ID_, REV_, TYPE_, TOTAL_JOBS_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, SUSPENSION_STATE_, CONFIGURATION_, TENANT_ID_, CREATE_USER_ID_) VALUES (:id, :rev, :type, :totalJobs, :jobsPerSeed, :invocationsPerJob, :seedJobDefId, :batchJobDefId, :monitorJobDefId, :suspensionState, :configuration, :tenantId, :createUserId)")
    public int[] bulkInsert(@BindBean List<FgActRuBatch> fgactrubatchs);

    /**
     * Bulk update multiple FgActRuBatch entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_BATCH SET REV_ = :rev, TYPE_ = :type, TOTAL_JOBS_ = :totalJobs, JOBS_PER_SEED_ = :jobsPerSeed, INVOCATIONS_PER_JOB_ = :invocationsPerJob, SEED_JOB_DEF_ID_ = :seedJobDefId, BATCH_JOB_DEF_ID_ = :batchJobDefId, MONITOR_JOB_DEF_ID_ = :monitorJobDefId, SUSPENSION_STATE_ = :suspensionState, CONFIGURATION_ = :configuration, TENANT_ID_ = :tenantId, CREATE_USER_ID_ = :createUserId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuBatch> fgactrubatchs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_BATCH WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_BATCH WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuBatch records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_BATCH WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuBatch.class)
    public List<FgActRuBatch> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActRuBatch records by monitorJobDefId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_BATCH WHERE MONITOR_JOB_DEF_ID_ = :monitorJobDefId")
    @RegisterBeanMapper(FgActRuBatch.class)
    public List<FgActRuBatch> findByMonitorJobDefId(@Bind("monitorJobDefId") int monitorJobDefId);

    /**
     * Finds all FgActRuBatch records by seedJobDefId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_BATCH WHERE SEED_JOB_DEF_ID_ = :seedJobDefId")
    @RegisterBeanMapper(FgActRuBatch.class)
    public List<FgActRuBatch> findBySeedJobDefId(@Bind("seedJobDefId") int seedJobDefId);

    /**
     * Finds all FgActRuBatch records by batchJobDefId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_BATCH WHERE BATCH_JOB_DEF_ID_ = :batchJobDefId")
    @RegisterBeanMapper(FgActRuBatch.class)
    public List<FgActRuBatch> findByBatchJobDefId(@Bind("batchJobDefId") int batchJobDefId);
}
