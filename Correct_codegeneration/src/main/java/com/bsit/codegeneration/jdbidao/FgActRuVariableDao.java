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
import com.bsit.codegeneration.entity.FgActRuVariable;

public interface FgActRuVariableDao {

    /**
     * Inserts a new FgActRuVariable and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_VARIABLE (ID_, REV_, TYPE_, NAME_, EXECUTION_ID_, PROC_INST_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, TASK_ID_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, VAR_SCOPE_, SEQUENCE_COUNTER_, IS_CONCURRENT_LOCAL_, TENANT_ID_, PROC_DEF_ID_, BATCH_ID_) VALUES (:id, :rev, :type, :name, :executionId, :procInstId, :caseExecutionId, :caseInstId, :taskId, :bytearrayId, :double, :long, :text, :text2, :varScope, :sequenceCounter, :isConcurrentLocal, :tenantId, :procDefId, :batchId)")
    public int insert(@BindBean FgActRuVariable fgactruvariable);

    /**
     * Finds a FgActRuVariable by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_VARIABLE WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuVariable.class)
    public Optional<FgActRuVariable> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_VARIABLE")
    @RegisterBeanMapper(FgActRuVariable.class)
    public List<FgActRuVariable> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_VARIABLE ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuVariable.class)
    public List<FgActRuVariable> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuVariable and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_VARIABLE SET REV_ = :rev, TYPE_ = :type, NAME_ = :name, EXECUTION_ID_ = :executionId, PROC_INST_ID_ = :procInstId, CASE_EXECUTION_ID_ = :caseExecutionId, CASE_INST_ID_ = :caseInstId, TASK_ID_ = :taskId, BYTEARRAY_ID_ = :bytearrayId, DOUBLE_ = :double, LONG_ = :long, TEXT_ = :text, TEXT2_ = :text2, VAR_SCOPE_ = :varScope, SEQUENCE_COUNTER_ = :sequenceCounter, IS_CONCURRENT_LOCAL_ = :isConcurrentLocal, TENANT_ID_ = :tenantId, PROC_DEF_ID_ = :procDefId, BATCH_ID_ = :batchId WHERE ID_ = :id")
    public int update(@BindBean FgActRuVariable fgactruvariable);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_VARIABLE WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_VARIABLE")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuVariable entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_VARIABLE (ID_, REV_, TYPE_, NAME_, EXECUTION_ID_, PROC_INST_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, TASK_ID_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, VAR_SCOPE_, SEQUENCE_COUNTER_, IS_CONCURRENT_LOCAL_, TENANT_ID_, PROC_DEF_ID_, BATCH_ID_) VALUES (:id, :rev, :type, :name, :executionId, :procInstId, :caseExecutionId, :caseInstId, :taskId, :bytearrayId, :double, :long, :text, :text2, :varScope, :sequenceCounter, :isConcurrentLocal, :tenantId, :procDefId, :batchId)")
    public int[] bulkInsert(@BindBean List<FgActRuVariable> fgactruvariables);

    /**
     * Bulk update multiple FgActRuVariable entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_VARIABLE SET REV_ = :rev, TYPE_ = :type, NAME_ = :name, EXECUTION_ID_ = :executionId, PROC_INST_ID_ = :procInstId, CASE_EXECUTION_ID_ = :caseExecutionId, CASE_INST_ID_ = :caseInstId, TASK_ID_ = :taskId, BYTEARRAY_ID_ = :bytearrayId, DOUBLE_ = :double, LONG_ = :long, TEXT_ = :text, TEXT2_ = :text2, VAR_SCOPE_ = :varScope, SEQUENCE_COUNTER_ = :sequenceCounter, IS_CONCURRENT_LOCAL_ = :isConcurrentLocal, TENANT_ID_ = :tenantId, PROC_DEF_ID_ = :procDefId, BATCH_ID_ = :batchId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuVariable> fgactruvariables);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_VARIABLE WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_VARIABLE WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuVariable records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_VARIABLE WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuVariable.class)
    public List<FgActRuVariable> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActRuVariable records by bytearrayId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_VARIABLE WHERE BYTEARRAY_ID_ = :bytearrayId")
    @RegisterBeanMapper(FgActRuVariable.class)
    public List<FgActRuVariable> findByBytearrayId(@Bind("bytearrayId") int bytearrayId);

    /**
     * Finds all FgActRuVariable records by batchId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_VARIABLE WHERE BATCH_ID_ = :batchId")
    @RegisterBeanMapper(FgActRuVariable.class)
    public List<FgActRuVariable> findByBatchId(@Bind("batchId") int batchId);

    /**
     * Finds all FgActRuVariable records by caseInstId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_VARIABLE WHERE CASE_INST_ID_ = :caseInstId")
    @RegisterBeanMapper(FgActRuVariable.class)
    public List<FgActRuVariable> findByCaseInstId(@Bind("caseInstId") int caseInstId);

    /**
     * Finds all FgActRuVariable records by caseExecutionId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_VARIABLE WHERE CASE_EXECUTION_ID_ = :caseExecutionId")
    @RegisterBeanMapper(FgActRuVariable.class)
    public List<FgActRuVariable> findByCaseExecutionId(@Bind("caseExecutionId") int caseExecutionId);
}
