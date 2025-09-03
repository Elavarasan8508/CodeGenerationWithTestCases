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
import com.bsit.codegeneration.entity.FgActHiOpLog;

public interface FgActHiOpLogDao {

    /**
     * Inserts a new FgActHiOpLog and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_OP_LOG (ID_, DEPLOYMENT_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, JOB_ID_, JOB_DEF_ID_, BATCH_ID_, USER_ID_, TIMESTAMP_, OPERATION_TYPE_, OPERATION_ID_, ENTITY_TYPE_, PROPERTY_, ORG_VALUE_, NEW_VALUE_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, CATEGORY_, EXTERNAL_TASK_ID_, ANNOTATION_) VALUES (:id, :deploymentId, :procDefId, :procDefKey, :procInstId, :executionId, :caseDefId, :caseInstId, :caseExecutionId, :taskId, :jobId, :jobDefId, :batchId, :userId, :timestamp, :operationType, :operationId, :entityType, :property, :orgValue, :newValue, :tenantId, :rootProcInstId, :removalTime, :category, :externalTaskId, :annotation)")
    public int insert(@BindBean FgActHiOpLog fgacthioplog);

    /**
     * Finds a FgActHiOpLog by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_OP_LOG WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiOpLog.class)
    public Optional<FgActHiOpLog> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_OP_LOG")
    @RegisterBeanMapper(FgActHiOpLog.class)
    public List<FgActHiOpLog> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_OP_LOG ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiOpLog.class)
    public List<FgActHiOpLog> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiOpLog and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_OP_LOG SET DEPLOYMENT_ID_ = :deploymentId, PROC_DEF_ID_ = :procDefId, PROC_DEF_KEY_ = :procDefKey, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, CASE_EXECUTION_ID_ = :caseExecutionId, TASK_ID_ = :taskId, JOB_ID_ = :jobId, JOB_DEF_ID_ = :jobDefId, BATCH_ID_ = :batchId, USER_ID_ = :userId, TIMESTAMP_ = :timestamp, OPERATION_TYPE_ = :operationType, OPERATION_ID_ = :operationId, ENTITY_TYPE_ = :entityType, PROPERTY_ = :property, ORG_VALUE_ = :orgValue, NEW_VALUE_ = :newValue, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime, CATEGORY_ = :category, EXTERNAL_TASK_ID_ = :externalTaskId, ANNOTATION_ = :annotation WHERE ID_ = :id")
    public int update(@BindBean FgActHiOpLog fgacthioplog);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_OP_LOG WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_OP_LOG")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiOpLog entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_OP_LOG (ID_, DEPLOYMENT_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, JOB_ID_, JOB_DEF_ID_, BATCH_ID_, USER_ID_, TIMESTAMP_, OPERATION_TYPE_, OPERATION_ID_, ENTITY_TYPE_, PROPERTY_, ORG_VALUE_, NEW_VALUE_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, CATEGORY_, EXTERNAL_TASK_ID_, ANNOTATION_) VALUES (:id, :deploymentId, :procDefId, :procDefKey, :procInstId, :executionId, :caseDefId, :caseInstId, :caseExecutionId, :taskId, :jobId, :jobDefId, :batchId, :userId, :timestamp, :operationType, :operationId, :entityType, :property, :orgValue, :newValue, :tenantId, :rootProcInstId, :removalTime, :category, :externalTaskId, :annotation)")
    public int[] bulkInsert(@BindBean List<FgActHiOpLog> fgacthioplogs);

    /**
     * Bulk update multiple FgActHiOpLog entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_OP_LOG SET DEPLOYMENT_ID_ = :deploymentId, PROC_DEF_ID_ = :procDefId, PROC_DEF_KEY_ = :procDefKey, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, CASE_EXECUTION_ID_ = :caseExecutionId, TASK_ID_ = :taskId, JOB_ID_ = :jobId, JOB_DEF_ID_ = :jobDefId, BATCH_ID_ = :batchId, USER_ID_ = :userId, TIMESTAMP_ = :timestamp, OPERATION_TYPE_ = :operationType, OPERATION_ID_ = :operationId, ENTITY_TYPE_ = :entityType, PROPERTY_ = :property, ORG_VALUE_ = :orgValue, NEW_VALUE_ = :newValue, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime, CATEGORY_ = :category, EXTERNAL_TASK_ID_ = :externalTaskId, ANNOTATION_ = :annotation WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiOpLog> fgacthioplogs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_OP_LOG WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_OP_LOG WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiOpLog records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_OP_LOG WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiOpLog.class)
    public List<FgActHiOpLog> findByIds(@BindList("ids") Collection<String> ids);
}
