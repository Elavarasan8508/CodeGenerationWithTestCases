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
import com.bsit.codegeneration.entity.FgActHiJobLog;

public interface FgActHiJobLogDao {

    /**
     * Inserts a new FgActHiJobLog and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_JOB_LOG (ID_, TIMESTAMP_, JOB_ID_, JOB_DUEDATE_, JOB_RETRIES_, JOB_PRIORITY_, JOB_EXCEPTION_MSG_, JOB_EXCEPTION_STACK_ID_, JOB_STATE_, JOB_DEF_ID_, JOB_DEF_TYPE_, JOB_DEF_CONFIGURATION_, ACT_ID_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, DEPLOYMENT_ID_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, HOSTNAME_, FAILED_ACT_ID_) VALUES (:id, :timestamp, :jobId, :jobDuedate, :jobRetries, :jobPriority, :jobExceptionMsg, :jobExceptionStackId, :jobState, :jobDefId, :jobDefType, :jobDefConfiguration, :actId, :executionId, :processInstanceId, :processDefId, :processDefKey, :deploymentId, :sequenceCounter, :tenantId, :rootProcInstId, :removalTime, :hostname, :failedActId)")
    public int insert(@BindBean FgActHiJobLog fgacthijoblog);

    /**
     * Finds a FgActHiJobLog by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_JOB_LOG WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiJobLog.class)
    public Optional<FgActHiJobLog> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_JOB_LOG")
    @RegisterBeanMapper(FgActHiJobLog.class)
    public List<FgActHiJobLog> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_JOB_LOG ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiJobLog.class)
    public List<FgActHiJobLog> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiJobLog and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_JOB_LOG SET TIMESTAMP_ = :timestamp, JOB_ID_ = :jobId, JOB_DUEDATE_ = :jobDuedate, JOB_RETRIES_ = :jobRetries, JOB_PRIORITY_ = :jobPriority, JOB_EXCEPTION_MSG_ = :jobExceptionMsg, JOB_EXCEPTION_STACK_ID_ = :jobExceptionStackId, JOB_STATE_ = :jobState, JOB_DEF_ID_ = :jobDefId, JOB_DEF_TYPE_ = :jobDefType, JOB_DEF_CONFIGURATION_ = :jobDefConfiguration, ACT_ID_ = :actId, EXECUTION_ID_ = :executionId, PROCESS_INSTANCE_ID_ = :processInstanceId, PROCESS_DEF_ID_ = :processDefId, PROCESS_DEF_KEY_ = :processDefKey, DEPLOYMENT_ID_ = :deploymentId, SEQUENCE_COUNTER_ = :sequenceCounter, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime, HOSTNAME_ = :hostname, FAILED_ACT_ID_ = :failedActId WHERE ID_ = :id")
    public int update(@BindBean FgActHiJobLog fgacthijoblog);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_JOB_LOG WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_JOB_LOG")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiJobLog entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_JOB_LOG (ID_, TIMESTAMP_, JOB_ID_, JOB_DUEDATE_, JOB_RETRIES_, JOB_PRIORITY_, JOB_EXCEPTION_MSG_, JOB_EXCEPTION_STACK_ID_, JOB_STATE_, JOB_DEF_ID_, JOB_DEF_TYPE_, JOB_DEF_CONFIGURATION_, ACT_ID_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, DEPLOYMENT_ID_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, HOSTNAME_, FAILED_ACT_ID_) VALUES (:id, :timestamp, :jobId, :jobDuedate, :jobRetries, :jobPriority, :jobExceptionMsg, :jobExceptionStackId, :jobState, :jobDefId, :jobDefType, :jobDefConfiguration, :actId, :executionId, :processInstanceId, :processDefId, :processDefKey, :deploymentId, :sequenceCounter, :tenantId, :rootProcInstId, :removalTime, :hostname, :failedActId)")
    public int[] bulkInsert(@BindBean List<FgActHiJobLog> fgacthijoblogs);

    /**
     * Bulk update multiple FgActHiJobLog entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_JOB_LOG SET TIMESTAMP_ = :timestamp, JOB_ID_ = :jobId, JOB_DUEDATE_ = :jobDuedate, JOB_RETRIES_ = :jobRetries, JOB_PRIORITY_ = :jobPriority, JOB_EXCEPTION_MSG_ = :jobExceptionMsg, JOB_EXCEPTION_STACK_ID_ = :jobExceptionStackId, JOB_STATE_ = :jobState, JOB_DEF_ID_ = :jobDefId, JOB_DEF_TYPE_ = :jobDefType, JOB_DEF_CONFIGURATION_ = :jobDefConfiguration, ACT_ID_ = :actId, EXECUTION_ID_ = :executionId, PROCESS_INSTANCE_ID_ = :processInstanceId, PROCESS_DEF_ID_ = :processDefId, PROCESS_DEF_KEY_ = :processDefKey, DEPLOYMENT_ID_ = :deploymentId, SEQUENCE_COUNTER_ = :sequenceCounter, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime, HOSTNAME_ = :hostname, FAILED_ACT_ID_ = :failedActId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiJobLog> fgacthijoblogs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_JOB_LOG WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_JOB_LOG WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiJobLog records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_JOB_LOG WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiJobLog.class)
    public List<FgActHiJobLog> findByIds(@BindList("ids") Collection<String> ids);
}
