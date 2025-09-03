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
import com.bsit.codegeneration.entity.FgActRuExtTask;

public interface FgActRuExtTaskDao {

    /**
     * Inserts a new FgActRuExtTask and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_EXT_TASK (ID_, REV_, WORKER_ID_, TOPIC_NAME_, RETRIES_, ERROR_MSG_, ERROR_DETAILS_ID_, LOCK_EXP_TIME_, SUSPENSION_STATE_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, ACT_INST_ID_, TENANT_ID_, PRIORITY_) VALUES (:id, :rev, :workerId, :topicName, :retries, :errorMsg, :errorDetailsId, :lockExpTime, :suspensionState, :executionId, :procInstId, :procDefId, :procDefKey, :actId, :actInstId, :tenantId, :priority)")
    public int insert(@BindBean FgActRuExtTask fgactruexttask);

    /**
     * Finds a FgActRuExtTask by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EXT_TASK WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuExtTask.class)
    public Optional<FgActRuExtTask> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EXT_TASK")
    @RegisterBeanMapper(FgActRuExtTask.class)
    public List<FgActRuExtTask> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EXT_TASK ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuExtTask.class)
    public List<FgActRuExtTask> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuExtTask and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_EXT_TASK SET REV_ = :rev, WORKER_ID_ = :workerId, TOPIC_NAME_ = :topicName, RETRIES_ = :retries, ERROR_MSG_ = :errorMsg, ERROR_DETAILS_ID_ = :errorDetailsId, LOCK_EXP_TIME_ = :lockExpTime, SUSPENSION_STATE_ = :suspensionState, EXECUTION_ID_ = :executionId, PROC_INST_ID_ = :procInstId, PROC_DEF_ID_ = :procDefId, PROC_DEF_KEY_ = :procDefKey, ACT_ID_ = :actId, ACT_INST_ID_ = :actInstId, TENANT_ID_ = :tenantId, PRIORITY_ = :priority WHERE ID_ = :id")
    public int update(@BindBean FgActRuExtTask fgactruexttask);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_EXT_TASK WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_EXT_TASK")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuExtTask entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_EXT_TASK (ID_, REV_, WORKER_ID_, TOPIC_NAME_, RETRIES_, ERROR_MSG_, ERROR_DETAILS_ID_, LOCK_EXP_TIME_, SUSPENSION_STATE_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, ACT_INST_ID_, TENANT_ID_, PRIORITY_) VALUES (:id, :rev, :workerId, :topicName, :retries, :errorMsg, :errorDetailsId, :lockExpTime, :suspensionState, :executionId, :procInstId, :procDefId, :procDefKey, :actId, :actInstId, :tenantId, :priority)")
    public int[] bulkInsert(@BindBean List<FgActRuExtTask> fgactruexttasks);

    /**
     * Bulk update multiple FgActRuExtTask entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_EXT_TASK SET REV_ = :rev, WORKER_ID_ = :workerId, TOPIC_NAME_ = :topicName, RETRIES_ = :retries, ERROR_MSG_ = :errorMsg, ERROR_DETAILS_ID_ = :errorDetailsId, LOCK_EXP_TIME_ = :lockExpTime, SUSPENSION_STATE_ = :suspensionState, EXECUTION_ID_ = :executionId, PROC_INST_ID_ = :procInstId, PROC_DEF_ID_ = :procDefId, PROC_DEF_KEY_ = :procDefKey, ACT_ID_ = :actId, ACT_INST_ID_ = :actInstId, TENANT_ID_ = :tenantId, PRIORITY_ = :priority WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuExtTask> fgactruexttasks);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_EXT_TASK WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_EXT_TASK WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuExtTask records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EXT_TASK WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuExtTask.class)
    public List<FgActRuExtTask> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActRuExtTask records by errorDetailsId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EXT_TASK WHERE ERROR_DETAILS_ID_ = :errorDetailsId")
    @RegisterBeanMapper(FgActRuExtTask.class)
    public List<FgActRuExtTask> findByErrorDetailsId(@Bind("errorDetailsId") int errorDetailsId);
}
