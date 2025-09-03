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
import com.bsit.codegeneration.entity.FgActHiVarinst;

public interface FgActHiVarinstDao {

    /**
     * Inserts a new FgActHiVarinst and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_VARINST (ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, ACT_INST_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, NAME_, VAR_TYPE_, REV_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, TENANT_ID_, STATE_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :procDefKey, :procDefId, :procInstId, :executionId, :actInstId, :caseDefKey, :caseDefId, :caseInstId, :caseExecutionId, :taskId, :name, :varType, :rev, :bytearrayId, :double, :long, :text, :text2, :tenantId, :state, :createTime, :rootProcInstId, :removalTime)")
    public int insert(@BindBean FgActHiVarinst fgacthivarinst);

    /**
     * Finds a FgActHiVarinst by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_VARINST WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiVarinst.class)
    public Optional<FgActHiVarinst> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_VARINST")
    @RegisterBeanMapper(FgActHiVarinst.class)
    public List<FgActHiVarinst> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_VARINST ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiVarinst.class)
    public List<FgActHiVarinst> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiVarinst and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_VARINST SET PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, ACT_INST_ID_ = :actInstId, CASE_DEF_KEY_ = :caseDefKey, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, CASE_EXECUTION_ID_ = :caseExecutionId, TASK_ID_ = :taskId, NAME_ = :name, VAR_TYPE_ = :varType, REV_ = :rev, BYTEARRAY_ID_ = :bytearrayId, DOUBLE_ = :double, LONG_ = :long, TEXT_ = :text, TEXT2_ = :text2, TENANT_ID_ = :tenantId, STATE_ = :state, CREATE_TIME_ = :createTime, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActHiVarinst fgacthivarinst);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_VARINST WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_VARINST")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiVarinst entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_VARINST (ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, ACT_INST_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, NAME_, VAR_TYPE_, REV_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, TENANT_ID_, STATE_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :procDefKey, :procDefId, :procInstId, :executionId, :actInstId, :caseDefKey, :caseDefId, :caseInstId, :caseExecutionId, :taskId, :name, :varType, :rev, :bytearrayId, :double, :long, :text, :text2, :tenantId, :state, :createTime, :rootProcInstId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActHiVarinst> fgacthivarinsts);

    /**
     * Bulk update multiple FgActHiVarinst entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_VARINST SET PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, ACT_INST_ID_ = :actInstId, CASE_DEF_KEY_ = :caseDefKey, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, CASE_EXECUTION_ID_ = :caseExecutionId, TASK_ID_ = :taskId, NAME_ = :name, VAR_TYPE_ = :varType, REV_ = :rev, BYTEARRAY_ID_ = :bytearrayId, DOUBLE_ = :double, LONG_ = :long, TEXT_ = :text, TEXT2_ = :text2, TENANT_ID_ = :tenantId, STATE_ = :state, CREATE_TIME_ = :createTime, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiVarinst> fgacthivarinsts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_VARINST WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_VARINST WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiVarinst records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_VARINST WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiVarinst.class)
    public List<FgActHiVarinst> findByIds(@BindList("ids") Collection<String> ids);
}
