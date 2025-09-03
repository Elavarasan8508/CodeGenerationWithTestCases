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
import com.bsit.codegeneration.entity.FgActRuJob;

public interface FgActRuJobDao {

    /**
     * Inserts a new FgActRuJob and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_JOB (ID_, REV_, TYPE_, LOCK_EXP_TIME_, LOCK_OWNER_, EXCLUSIVE_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, RETRIES_, EXCEPTION_STACK_ID_, EXCEPTION_MSG_, DUEDATE_, REPEAT_, HANDLER_TYPE_, HANDLER_CFG_, DEPLOYMENT_ID_, SUSPENSION_STATE_, JOB_DEF_ID_, PRIORITY_, SEQUENCE_COUNTER_, TENANT_ID_, CREATE_TIME_, REPEAT_OFFSET_, FAILED_ACT_ID_) VALUES (:id, :rev, :type, :lockExpTime, :lockOwner, :exclusive, :executionId, :processInstanceId, :processDefId, :processDefKey, :retries, :exceptionStackId, :exceptionMsg, :duedate, :repeat, :handlerType, :handlerCfg, :deploymentId, :suspensionState, :jobDefId, :priority, :sequenceCounter, :tenantId, :createTime, :repeatOffset, :failedActId)")
    public int insert(@BindBean FgActRuJob fgactrujob);

    /**
     * Finds a FgActRuJob by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_JOB WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuJob.class)
    public Optional<FgActRuJob> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_JOB")
    @RegisterBeanMapper(FgActRuJob.class)
    public List<FgActRuJob> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_JOB ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuJob.class)
    public List<FgActRuJob> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuJob and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_JOB SET REV_ = :rev, TYPE_ = :type, LOCK_EXP_TIME_ = :lockExpTime, LOCK_OWNER_ = :lockOwner, EXCLUSIVE_ = :exclusive, EXECUTION_ID_ = :executionId, PROCESS_INSTANCE_ID_ = :processInstanceId, PROCESS_DEF_ID_ = :processDefId, PROCESS_DEF_KEY_ = :processDefKey, RETRIES_ = :retries, EXCEPTION_STACK_ID_ = :exceptionStackId, EXCEPTION_MSG_ = :exceptionMsg, DUEDATE_ = :duedate, REPEAT_ = :repeat, HANDLER_TYPE_ = :handlerType, HANDLER_CFG_ = :handlerCfg, DEPLOYMENT_ID_ = :deploymentId, SUSPENSION_STATE_ = :suspensionState, JOB_DEF_ID_ = :jobDefId, PRIORITY_ = :priority, SEQUENCE_COUNTER_ = :sequenceCounter, TENANT_ID_ = :tenantId, CREATE_TIME_ = :createTime, REPEAT_OFFSET_ = :repeatOffset, FAILED_ACT_ID_ = :failedActId WHERE ID_ = :id")
    public int update(@BindBean FgActRuJob fgactrujob);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_JOB WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_JOB")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuJob entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_JOB (ID_, REV_, TYPE_, LOCK_EXP_TIME_, LOCK_OWNER_, EXCLUSIVE_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, RETRIES_, EXCEPTION_STACK_ID_, EXCEPTION_MSG_, DUEDATE_, REPEAT_, HANDLER_TYPE_, HANDLER_CFG_, DEPLOYMENT_ID_, SUSPENSION_STATE_, JOB_DEF_ID_, PRIORITY_, SEQUENCE_COUNTER_, TENANT_ID_, CREATE_TIME_, REPEAT_OFFSET_, FAILED_ACT_ID_) VALUES (:id, :rev, :type, :lockExpTime, :lockOwner, :exclusive, :executionId, :processInstanceId, :processDefId, :processDefKey, :retries, :exceptionStackId, :exceptionMsg, :duedate, :repeat, :handlerType, :handlerCfg, :deploymentId, :suspensionState, :jobDefId, :priority, :sequenceCounter, :tenantId, :createTime, :repeatOffset, :failedActId)")
    public int[] bulkInsert(@BindBean List<FgActRuJob> fgactrujobs);

    /**
     * Bulk update multiple FgActRuJob entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_JOB SET REV_ = :rev, TYPE_ = :type, LOCK_EXP_TIME_ = :lockExpTime, LOCK_OWNER_ = :lockOwner, EXCLUSIVE_ = :exclusive, EXECUTION_ID_ = :executionId, PROCESS_INSTANCE_ID_ = :processInstanceId, PROCESS_DEF_ID_ = :processDefId, PROCESS_DEF_KEY_ = :processDefKey, RETRIES_ = :retries, EXCEPTION_STACK_ID_ = :exceptionStackId, EXCEPTION_MSG_ = :exceptionMsg, DUEDATE_ = :duedate, REPEAT_ = :repeat, HANDLER_TYPE_ = :handlerType, HANDLER_CFG_ = :handlerCfg, DEPLOYMENT_ID_ = :deploymentId, SUSPENSION_STATE_ = :suspensionState, JOB_DEF_ID_ = :jobDefId, PRIORITY_ = :priority, SEQUENCE_COUNTER_ = :sequenceCounter, TENANT_ID_ = :tenantId, CREATE_TIME_ = :createTime, REPEAT_OFFSET_ = :repeatOffset, FAILED_ACT_ID_ = :failedActId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuJob> fgactrujobs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_JOB WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_JOB WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuJob records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_JOB WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuJob.class)
    public List<FgActRuJob> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActRuJob records by exceptionStackId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_JOB WHERE EXCEPTION_STACK_ID_ = :exceptionStackId")
    @RegisterBeanMapper(FgActRuJob.class)
    public List<FgActRuJob> findByExceptionStackId(@Bind("exceptionStackId") int exceptionStackId);
}
