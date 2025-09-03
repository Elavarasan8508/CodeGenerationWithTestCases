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
import com.bsit.codegeneration.entity.FgActHiCaseactinst;

public interface FgActHiCaseactinstDao {

    /**
     * Inserts a new FgActHiCaseactinst and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_CASEACTINST (ID_, PARENT_ACT_INST_ID_, CASE_DEF_ID_, CASE_INST_ID_, CASE_ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, CALL_CASE_INST_ID_, CASE_ACT_NAME_, CASE_ACT_TYPE_, CREATE_TIME_, END_TIME_, DURATION_, STATE_, REQUIRED_, TENANT_ID_) VALUES (:id, :parentActInstId, :caseDefId, :caseInstId, :caseActId, :taskId, :callProcInstId, :callCaseInstId, :caseActName, :caseActType, :createTime, :endTime, :duration, :state, :required, :tenantId)")
    public int insert(@BindBean FgActHiCaseactinst fgacthicaseactinst);

    /**
     * Finds a FgActHiCaseactinst by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEACTINST WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiCaseactinst.class)
    public Optional<FgActHiCaseactinst> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEACTINST")
    @RegisterBeanMapper(FgActHiCaseactinst.class)
    public List<FgActHiCaseactinst> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEACTINST ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiCaseactinst.class)
    public List<FgActHiCaseactinst> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiCaseactinst and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_CASEACTINST SET PARENT_ACT_INST_ID_ = :parentActInstId, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, CASE_ACT_ID_ = :caseActId, TASK_ID_ = :taskId, CALL_PROC_INST_ID_ = :callProcInstId, CALL_CASE_INST_ID_ = :callCaseInstId, CASE_ACT_NAME_ = :caseActName, CASE_ACT_TYPE_ = :caseActType, CREATE_TIME_ = :createTime, END_TIME_ = :endTime, DURATION_ = :duration, STATE_ = :state, REQUIRED_ = :required, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int update(@BindBean FgActHiCaseactinst fgacthicaseactinst);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_CASEACTINST WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_CASEACTINST")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiCaseactinst entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_CASEACTINST (ID_, PARENT_ACT_INST_ID_, CASE_DEF_ID_, CASE_INST_ID_, CASE_ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, CALL_CASE_INST_ID_, CASE_ACT_NAME_, CASE_ACT_TYPE_, CREATE_TIME_, END_TIME_, DURATION_, STATE_, REQUIRED_, TENANT_ID_) VALUES (:id, :parentActInstId, :caseDefId, :caseInstId, :caseActId, :taskId, :callProcInstId, :callCaseInstId, :caseActName, :caseActType, :createTime, :endTime, :duration, :state, :required, :tenantId)")
    public int[] bulkInsert(@BindBean List<FgActHiCaseactinst> fgacthicaseactinsts);

    /**
     * Bulk update multiple FgActHiCaseactinst entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_CASEACTINST SET PARENT_ACT_INST_ID_ = :parentActInstId, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, CASE_ACT_ID_ = :caseActId, TASK_ID_ = :taskId, CALL_PROC_INST_ID_ = :callProcInstId, CALL_CASE_INST_ID_ = :callCaseInstId, CASE_ACT_NAME_ = :caseActName, CASE_ACT_TYPE_ = :caseActType, CREATE_TIME_ = :createTime, END_TIME_ = :endTime, DURATION_ = :duration, STATE_ = :state, REQUIRED_ = :required, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiCaseactinst> fgacthicaseactinsts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_CASEACTINST WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_CASEACTINST WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiCaseactinst records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEACTINST WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiCaseactinst.class)
    public List<FgActHiCaseactinst> findByIds(@BindList("ids") Collection<String> ids);
}
