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
import com.bsit.codegeneration.entity.FgActRuTask;

public interface FgActRuTaskDao {

    /**
     * Inserts a new FgActRuTask and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_TASK (ID_, REV_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, CASE_DEF_ID_, NAME_, PARENT_TASK_ID_, DESCRIPTION_, TASK_DEF_KEY_, OWNER_, ASSIGNEE_, DELEGATION_, PRIORITY_, CREATE_TIME_, DUE_DATE_, FOLLOW_UP_DATE_, SUSPENSION_STATE_, TENANT_ID_) VALUES (:id, :rev, :executionId, :procInstId, :procDefId, :caseExecutionId, :caseInstId, :caseDefId, :name, :parentTaskId, :description, :taskDefKey, :owner, :assignee, :delegation, :priority, :createTime, :dueDate, :followUpDate, :suspensionState, :tenantId)")
    public int insert(@BindBean FgActRuTask fgactrutask);

    /**
     * Finds a FgActRuTask by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_TASK WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuTask.class)
    public Optional<FgActRuTask> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_TASK")
    @RegisterBeanMapper(FgActRuTask.class)
    public List<FgActRuTask> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_TASK ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuTask.class)
    public List<FgActRuTask> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuTask and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_TASK SET REV_ = :rev, EXECUTION_ID_ = :executionId, PROC_INST_ID_ = :procInstId, PROC_DEF_ID_ = :procDefId, CASE_EXECUTION_ID_ = :caseExecutionId, CASE_INST_ID_ = :caseInstId, CASE_DEF_ID_ = :caseDefId, NAME_ = :name, PARENT_TASK_ID_ = :parentTaskId, DESCRIPTION_ = :description, TASK_DEF_KEY_ = :taskDefKey, OWNER_ = :owner, ASSIGNEE_ = :assignee, DELEGATION_ = :delegation, PRIORITY_ = :priority, CREATE_TIME_ = :createTime, DUE_DATE_ = :dueDate, FOLLOW_UP_DATE_ = :followUpDate, SUSPENSION_STATE_ = :suspensionState, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int update(@BindBean FgActRuTask fgactrutask);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_TASK WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_TASK")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuTask entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_TASK (ID_, REV_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, CASE_DEF_ID_, NAME_, PARENT_TASK_ID_, DESCRIPTION_, TASK_DEF_KEY_, OWNER_, ASSIGNEE_, DELEGATION_, PRIORITY_, CREATE_TIME_, DUE_DATE_, FOLLOW_UP_DATE_, SUSPENSION_STATE_, TENANT_ID_) VALUES (:id, :rev, :executionId, :procInstId, :procDefId, :caseExecutionId, :caseInstId, :caseDefId, :name, :parentTaskId, :description, :taskDefKey, :owner, :assignee, :delegation, :priority, :createTime, :dueDate, :followUpDate, :suspensionState, :tenantId)")
    public int[] bulkInsert(@BindBean List<FgActRuTask> fgactrutasks);

    /**
     * Bulk update multiple FgActRuTask entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_TASK SET REV_ = :rev, EXECUTION_ID_ = :executionId, PROC_INST_ID_ = :procInstId, PROC_DEF_ID_ = :procDefId, CASE_EXECUTION_ID_ = :caseExecutionId, CASE_INST_ID_ = :caseInstId, CASE_DEF_ID_ = :caseDefId, NAME_ = :name, PARENT_TASK_ID_ = :parentTaskId, DESCRIPTION_ = :description, TASK_DEF_KEY_ = :taskDefKey, OWNER_ = :owner, ASSIGNEE_ = :assignee, DELEGATION_ = :delegation, PRIORITY_ = :priority, CREATE_TIME_ = :createTime, DUE_DATE_ = :dueDate, FOLLOW_UP_DATE_ = :followUpDate, SUSPENSION_STATE_ = :suspensionState, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuTask> fgactrutasks);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_TASK WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_TASK WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuTask records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_TASK WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuTask.class)
    public List<FgActRuTask> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActRuTask records by caseDefId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_TASK WHERE CASE_DEF_ID_ = :caseDefId")
    @RegisterBeanMapper(FgActRuTask.class)
    public List<FgActRuTask> findByCaseDefId(@Bind("caseDefId") int caseDefId);

    /**
     * Finds all FgActRuTask records by caseExecutionId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_TASK WHERE CASE_EXECUTION_ID_ = :caseExecutionId")
    @RegisterBeanMapper(FgActRuTask.class)
    public List<FgActRuTask> findByCaseExecutionId(@Bind("caseExecutionId") int caseExecutionId);
}
