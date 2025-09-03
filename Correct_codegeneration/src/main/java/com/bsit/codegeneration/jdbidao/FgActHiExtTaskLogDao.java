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
import com.bsit.codegeneration.entity.FgActHiExtTaskLog;

public interface FgActHiExtTaskLogDao {

    /**
     * Inserts a new FgActHiExtTaskLog and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_EXT_TASK_LOG (ID_, TIMESTAMP_, EXT_TASK_ID_, RETRIES_, TOPIC_NAME_, WORKER_ID_, PRIORITY_, ERROR_MSG_, ERROR_DETAILS_ID_, ACT_ID_, ACT_INST_ID_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, TENANT_ID_, STATE_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :timestamp, :extTaskId, :retries, :topicName, :workerId, :priority, :errorMsg, :errorDetailsId, :actId, :actInstId, :executionId, :procInstId, :procDefId, :procDefKey, :tenantId, :state, :rootProcInstId, :removalTime)")
    public int insert(@BindBean FgActHiExtTaskLog fgacthiexttasklog);

    /**
     * Finds a FgActHiExtTaskLog by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_EXT_TASK_LOG WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiExtTaskLog.class)
    public Optional<FgActHiExtTaskLog> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_EXT_TASK_LOG")
    @RegisterBeanMapper(FgActHiExtTaskLog.class)
    public List<FgActHiExtTaskLog> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_EXT_TASK_LOG ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiExtTaskLog.class)
    public List<FgActHiExtTaskLog> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiExtTaskLog and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_EXT_TASK_LOG SET TIMESTAMP_ = :timestamp, EXT_TASK_ID_ = :extTaskId, RETRIES_ = :retries, TOPIC_NAME_ = :topicName, WORKER_ID_ = :workerId, PRIORITY_ = :priority, ERROR_MSG_ = :errorMsg, ERROR_DETAILS_ID_ = :errorDetailsId, ACT_ID_ = :actId, ACT_INST_ID_ = :actInstId, EXECUTION_ID_ = :executionId, PROC_INST_ID_ = :procInstId, PROC_DEF_ID_ = :procDefId, PROC_DEF_KEY_ = :procDefKey, TENANT_ID_ = :tenantId, STATE_ = :state, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActHiExtTaskLog fgacthiexttasklog);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_EXT_TASK_LOG WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_EXT_TASK_LOG")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiExtTaskLog entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_EXT_TASK_LOG (ID_, TIMESTAMP_, EXT_TASK_ID_, RETRIES_, TOPIC_NAME_, WORKER_ID_, PRIORITY_, ERROR_MSG_, ERROR_DETAILS_ID_, ACT_ID_, ACT_INST_ID_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, TENANT_ID_, STATE_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :timestamp, :extTaskId, :retries, :topicName, :workerId, :priority, :errorMsg, :errorDetailsId, :actId, :actInstId, :executionId, :procInstId, :procDefId, :procDefKey, :tenantId, :state, :rootProcInstId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActHiExtTaskLog> fgacthiexttasklogs);

    /**
     * Bulk update multiple FgActHiExtTaskLog entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_EXT_TASK_LOG SET TIMESTAMP_ = :timestamp, EXT_TASK_ID_ = :extTaskId, RETRIES_ = :retries, TOPIC_NAME_ = :topicName, WORKER_ID_ = :workerId, PRIORITY_ = :priority, ERROR_MSG_ = :errorMsg, ERROR_DETAILS_ID_ = :errorDetailsId, ACT_ID_ = :actId, ACT_INST_ID_ = :actInstId, EXECUTION_ID_ = :executionId, PROC_INST_ID_ = :procInstId, PROC_DEF_ID_ = :procDefId, PROC_DEF_KEY_ = :procDefKey, TENANT_ID_ = :tenantId, STATE_ = :state, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiExtTaskLog> fgacthiexttasklogs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_EXT_TASK_LOG WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_EXT_TASK_LOG WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiExtTaskLog records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_EXT_TASK_LOG WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiExtTaskLog.class)
    public List<FgActHiExtTaskLog> findByIds(@BindList("ids") Collection<String> ids);
}
