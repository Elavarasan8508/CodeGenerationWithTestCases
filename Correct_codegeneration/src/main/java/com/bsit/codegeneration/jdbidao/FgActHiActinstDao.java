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
import com.bsit.codegeneration.entity.FgActHiActinst;

public interface FgActHiActinstDao {

    /**
     * Inserts a new FgActHiActinst and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_ACTINST (ID_, PARENT_ACT_INST_ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, CALL_CASE_INST_ID_, ACT_NAME_, ACT_TYPE_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, ACT_INST_STATE_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :parentActInstId, :procDefKey, :procDefId, :procInstId, :executionId, :actId, :taskId, :callProcInstId, :callCaseInstId, :actName, :actType, :assignee, :startTime, :endTime, :duration, :actInstState, :sequenceCounter, :tenantId, :rootProcInstId, :removalTime)")
    public int insert(@BindBean FgActHiActinst fgacthiactinst);

    /**
     * Finds a FgActHiActinst by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_ACTINST WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiActinst.class)
    public Optional<FgActHiActinst> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_ACTINST")
    @RegisterBeanMapper(FgActHiActinst.class)
    public List<FgActHiActinst> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_ACTINST ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiActinst.class)
    public List<FgActHiActinst> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiActinst and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_ACTINST SET PARENT_ACT_INST_ID_ = :parentActInstId, PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, ACT_ID_ = :actId, TASK_ID_ = :taskId, CALL_PROC_INST_ID_ = :callProcInstId, CALL_CASE_INST_ID_ = :callCaseInstId, ACT_NAME_ = :actName, ACT_TYPE_ = :actType, ASSIGNEE_ = :assignee, START_TIME_ = :startTime, END_TIME_ = :endTime, DURATION_ = :duration, ACT_INST_STATE_ = :actInstState, SEQUENCE_COUNTER_ = :sequenceCounter, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActHiActinst fgacthiactinst);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_ACTINST WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_ACTINST")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiActinst entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_ACTINST (ID_, PARENT_ACT_INST_ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, CALL_CASE_INST_ID_, ACT_NAME_, ACT_TYPE_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, ACT_INST_STATE_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :parentActInstId, :procDefKey, :procDefId, :procInstId, :executionId, :actId, :taskId, :callProcInstId, :callCaseInstId, :actName, :actType, :assignee, :startTime, :endTime, :duration, :actInstState, :sequenceCounter, :tenantId, :rootProcInstId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActHiActinst> fgacthiactinsts);

    /**
     * Bulk update multiple FgActHiActinst entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_ACTINST SET PARENT_ACT_INST_ID_ = :parentActInstId, PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, ACT_ID_ = :actId, TASK_ID_ = :taskId, CALL_PROC_INST_ID_ = :callProcInstId, CALL_CASE_INST_ID_ = :callCaseInstId, ACT_NAME_ = :actName, ACT_TYPE_ = :actType, ASSIGNEE_ = :assignee, START_TIME_ = :startTime, END_TIME_ = :endTime, DURATION_ = :duration, ACT_INST_STATE_ = :actInstState, SEQUENCE_COUNTER_ = :sequenceCounter, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiActinst> fgacthiactinsts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_ACTINST WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_ACTINST WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiActinst records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_ACTINST WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiActinst.class)
    public List<FgActHiActinst> findByIds(@BindList("ids") Collection<String> ids);
}
