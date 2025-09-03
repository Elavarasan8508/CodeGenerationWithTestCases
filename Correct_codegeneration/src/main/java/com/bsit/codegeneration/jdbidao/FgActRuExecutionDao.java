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
import com.bsit.codegeneration.entity.FgActRuExecution;

public interface FgActRuExecutionDao {

    /**
     * Inserts a new FgActRuExecution and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_EXECUTION (ID_, REV_, PROC_INST_ID_, BUSINESS_KEY_, PARENT_ID_, PROC_DEF_ID_, SUPER_EXEC_, SUPER_CASE_EXEC_, CASE_INST_ID_, ACT_ID_, ACT_INST_ID_, IS_ACTIVE_, IS_CONCURRENT_, IS_SCOPE_, IS_EVENT_SCOPE_, SUSPENSION_STATE_, CACHED_ENT_STATE_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_) VALUES (:id, :rev, :procInstId, :businessKey, :parentId, :procDefId, :superExec, :superCaseExec, :caseInstId, :actId, :actInstId, :isActive, :isConcurrent, :isScope, :isEventScope, :suspensionState, :cachedEntState, :sequenceCounter, :tenantId, :rootProcInstId)")
    public int insert(@BindBean FgActRuExecution fgactruexecution);

    /**
     * Finds a FgActRuExecution by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EXECUTION WHERE FG_ACT_RU_EXECUTION_id = :id")
    @RegisterBeanMapper(FgActRuExecution.class)
    public Optional<FgActRuExecution> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EXECUTION")
    @RegisterBeanMapper(FgActRuExecution.class)
    public List<FgActRuExecution> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EXECUTION ORDER BY FG_ACT_RU_EXECUTION_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuExecution.class)
    public List<FgActRuExecution> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuExecution and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_EXECUTION SET ID_ = :id, REV_ = :rev, PROC_INST_ID_ = :procInstId, BUSINESS_KEY_ = :businessKey, PARENT_ID_ = :parentId, PROC_DEF_ID_ = :procDefId, SUPER_EXEC_ = :superExec, SUPER_CASE_EXEC_ = :superCaseExec, CASE_INST_ID_ = :caseInstId, ACT_ID_ = :actId, ACT_INST_ID_ = :actInstId, IS_ACTIVE_ = :isActive, IS_CONCURRENT_ = :isConcurrent, IS_SCOPE_ = :isScope, IS_EVENT_SCOPE_ = :isEventScope, SUSPENSION_STATE_ = :suspensionState, CACHED_ENT_STATE_ = :cachedEntState, SEQUENCE_COUNTER_ = :sequenceCounter, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId WHERE FG_ACT_RU_EXECUTION_id = :fgActRuExecutionId")
    public int update(@BindBean FgActRuExecution fgactruexecution);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_EXECUTION WHERE FG_ACT_RU_EXECUTION_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_EXECUTION")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuExecution entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_EXECUTION (ID_, REV_, PROC_INST_ID_, BUSINESS_KEY_, PARENT_ID_, PROC_DEF_ID_, SUPER_EXEC_, SUPER_CASE_EXEC_, CASE_INST_ID_, ACT_ID_, ACT_INST_ID_, IS_ACTIVE_, IS_CONCURRENT_, IS_SCOPE_, IS_EVENT_SCOPE_, SUSPENSION_STATE_, CACHED_ENT_STATE_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_) VALUES (:id, :rev, :procInstId, :businessKey, :parentId, :procDefId, :superExec, :superCaseExec, :caseInstId, :actId, :actInstId, :isActive, :isConcurrent, :isScope, :isEventScope, :suspensionState, :cachedEntState, :sequenceCounter, :tenantId, :rootProcInstId)")
    public int[] bulkInsert(@BindBean List<FgActRuExecution> fgactruexecutions);

    /**
     * Bulk update multiple FgActRuExecution entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_EXECUTION SET ID_ = :id, REV_ = :rev, PROC_INST_ID_ = :procInstId, BUSINESS_KEY_ = :businessKey, PARENT_ID_ = :parentId, PROC_DEF_ID_ = :procDefId, SUPER_EXEC_ = :superExec, SUPER_CASE_EXEC_ = :superCaseExec, CASE_INST_ID_ = :caseInstId, ACT_ID_ = :actId, ACT_INST_ID_ = :actInstId, IS_ACTIVE_ = :isActive, IS_CONCURRENT_ = :isConcurrent, IS_SCOPE_ = :isScope, IS_EVENT_SCOPE_ = :isEventScope, SUSPENSION_STATE_ = :suspensionState, CACHED_ENT_STATE_ = :cachedEntState, SEQUENCE_COUNTER_ = :sequenceCounter, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId WHERE FG_ACT_RU_EXECUTION_id = :fgActRuExecutionId")
    public int[] bulkUpdate(@BindBean List<FgActRuExecution> fgactruexecutions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_EXECUTION WHERE FG_ACT_RU_EXECUTION_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_EXECUTION WHERE FG_ACT_RU_EXECUTION_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgActRuExecution records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EXECUTION WHERE FG_ACT_RU_EXECUTION_id IN (<ids>)")
    @RegisterBeanMapper(FgActRuExecution.class)
    public List<FgActRuExecution> findByIds(@BindList("ids") Collection<Integer> ids);
}
