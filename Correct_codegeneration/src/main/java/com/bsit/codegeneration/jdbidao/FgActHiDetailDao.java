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
import com.bsit.codegeneration.entity.FgActHiDetail;

public interface FgActHiDetailDao {

    /**
     * Inserts a new FgActHiDetail and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_DETAIL (ID_, TYPE_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, ACT_INST_ID_, VAR_INST_ID_, NAME_, VAR_TYPE_, REV_, TIME_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, SEQUENCE_COUNTER_, TENANT_ID_, OPERATION_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, INITIAL_) VALUES (:id, :type, :procDefKey, :procDefId, :procInstId, :executionId, :caseDefKey, :caseDefId, :caseInstId, :caseExecutionId, :taskId, :actInstId, :varInstId, :name, :varType, :rev, :time, :bytearrayId, :double, :long, :text, :text2, :sequenceCounter, :tenantId, :operationId, :rootProcInstId, :removalTime, :initial)")
    public int insert(@BindBean FgActHiDetail fgacthidetail);

    /**
     * Finds a FgActHiDetail by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DETAIL WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiDetail.class)
    public Optional<FgActHiDetail> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DETAIL")
    @RegisterBeanMapper(FgActHiDetail.class)
    public List<FgActHiDetail> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DETAIL ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiDetail.class)
    public List<FgActHiDetail> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiDetail and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_DETAIL SET TYPE_ = :type, PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, CASE_DEF_KEY_ = :caseDefKey, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, CASE_EXECUTION_ID_ = :caseExecutionId, TASK_ID_ = :taskId, ACT_INST_ID_ = :actInstId, VAR_INST_ID_ = :varInstId, NAME_ = :name, VAR_TYPE_ = :varType, REV_ = :rev, TIME_ = :time, BYTEARRAY_ID_ = :bytearrayId, DOUBLE_ = :double, LONG_ = :long, TEXT_ = :text, TEXT2_ = :text2, SEQUENCE_COUNTER_ = :sequenceCounter, TENANT_ID_ = :tenantId, OPERATION_ID_ = :operationId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime, INITIAL_ = :initial WHERE ID_ = :id")
    public int update(@BindBean FgActHiDetail fgacthidetail);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_DETAIL WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_DETAIL")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiDetail entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_DETAIL (ID_, TYPE_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, ACT_INST_ID_, VAR_INST_ID_, NAME_, VAR_TYPE_, REV_, TIME_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, SEQUENCE_COUNTER_, TENANT_ID_, OPERATION_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, INITIAL_) VALUES (:id, :type, :procDefKey, :procDefId, :procInstId, :executionId, :caseDefKey, :caseDefId, :caseInstId, :caseExecutionId, :taskId, :actInstId, :varInstId, :name, :varType, :rev, :time, :bytearrayId, :double, :long, :text, :text2, :sequenceCounter, :tenantId, :operationId, :rootProcInstId, :removalTime, :initial)")
    public int[] bulkInsert(@BindBean List<FgActHiDetail> fgacthidetails);

    /**
     * Bulk update multiple FgActHiDetail entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_DETAIL SET TYPE_ = :type, PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, CASE_DEF_KEY_ = :caseDefKey, CASE_DEF_ID_ = :caseDefId, CASE_INST_ID_ = :caseInstId, CASE_EXECUTION_ID_ = :caseExecutionId, TASK_ID_ = :taskId, ACT_INST_ID_ = :actInstId, VAR_INST_ID_ = :varInstId, NAME_ = :name, VAR_TYPE_ = :varType, REV_ = :rev, TIME_ = :time, BYTEARRAY_ID_ = :bytearrayId, DOUBLE_ = :double, LONG_ = :long, TEXT_ = :text, TEXT2_ = :text2, SEQUENCE_COUNTER_ = :sequenceCounter, TENANT_ID_ = :tenantId, OPERATION_ID_ = :operationId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime, INITIAL_ = :initial WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiDetail> fgacthidetails);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_DETAIL WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_DETAIL WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiDetail records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_DETAIL WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiDetail.class)
    public List<FgActHiDetail> findByIds(@BindList("ids") Collection<String> ids);
}
