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
import com.bsit.codegeneration.entity.FgActHiTaskinst;

public interface FgActHiTaskinstDao {

    /**
     * Inserts a new FgActHiTaskinst and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_TASKINST (ID_, TASK_DEF_KEY_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, ACT_INST_ID_, PARENT_TASK_ID_, NAME_, DESCRIPTION_, OWNER_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, DELETE_REASON_, PRIORITY_, DUE_DATE_, FOLLOW_UP_DATE_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :taskDefKey, :procDefKey, :procDefId, :procInstId, :executionId, :caseDefKey, :caseDefId, :caseInstId, :caseExecutionId, :actInstId, :parentTaskId, :name, :description, :owner, :assignee, :startTime, :endTime, :duration, :deleteReason, :priority, :dueDate, :followUpDate, :tenantId, :rootProcInstId, :removalTime)")
    public int insert(@BindBean FgActHiTaskinst fgacthitaskinst);

    /**
     * Finds a FgActHiTaskinst by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_TASKINST WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiTaskinst.class)
    public Optional<FgActHiTaskinst> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_TASKINST")
    @RegisterBeanMapper(FgActHiTaskinst.class)
    public List<FgActHiTaskinst> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_TASKINST ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiTaskinst.class)
    public List<FgActHiTaskinst> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiTaskinst and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_TASKINST SET TASK_DEF_KEY_ = :taskDefKey, PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, CASE_DEF_KEY_ = :caseDefKey, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, CASE_EXECUTION_ID_ = :caseExecutionId, ACT_INST_ID_ = :actInstId, PARENT_TASK_ID_ = :parentTaskId, NAME_ = :name, DESCRIPTION_ = :description, OWNER_ = :owner, ASSIGNEE_ = :assignee, START_TIME_ = :startTime, END_TIME_ = :endTime, DURATION_ = :duration, DELETE_REASON_ = :deleteReason, PRIORITY_ = :priority, DUE_DATE_ = :dueDate, FOLLOW_UP_DATE_ = :followUpDate, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActHiTaskinst fgacthitaskinst);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_TASKINST WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_TASKINST")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiTaskinst entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_TASKINST (ID_, TASK_DEF_KEY_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, ACT_INST_ID_, PARENT_TASK_ID_, NAME_, DESCRIPTION_, OWNER_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, DELETE_REASON_, PRIORITY_, DUE_DATE_, FOLLOW_UP_DATE_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :taskDefKey, :procDefKey, :procDefId, :procInstId, :executionId, :caseDefKey, :caseDefId, :caseInstId, :caseExecutionId, :actInstId, :parentTaskId, :name, :description, :owner, :assignee, :startTime, :endTime, :duration, :deleteReason, :priority, :dueDate, :followUpDate, :tenantId, :rootProcInstId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActHiTaskinst> fgacthitaskinsts);

    /**
     * Bulk update multiple FgActHiTaskinst entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_TASKINST SET TASK_DEF_KEY_ = :taskDefKey, PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, CASE_DEF_KEY_ = :caseDefKey, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, CASE_EXECUTION_ID_ = :caseExecutionId, ACT_INST_ID_ = :actInstId, PARENT_TASK_ID_ = :parentTaskId, NAME_ = :name, DESCRIPTION_ = :description, OWNER_ = :owner, ASSIGNEE_ = :assignee, START_TIME_ = :startTime, END_TIME_ = :endTime, DURATION_ = :duration, DELETE_REASON_ = :deleteReason, PRIORITY_ = :priority, DUE_DATE_ = :dueDate, FOLLOW_UP_DATE_ = :followUpDate, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiTaskinst> fgacthitaskinsts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_TASKINST WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_TASKINST WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiTaskinst records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_TASKINST WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiTaskinst.class)
    public List<FgActHiTaskinst> findByIds(@BindList("ids") Collection<String> ids);
}
