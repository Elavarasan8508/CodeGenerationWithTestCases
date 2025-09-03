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
import com.bsit.codegeneration.entity.BatchJobExecutionParams;

public interface BatchJobExecutionParamsDao {

    /**
     * Inserts a new BatchJobExecutionParams and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO BATCH_JOB_EXECUTION_PARAMS (JOB_EXECUTION_ID, PARAMETER_NAME, PARAMETER_TYPE, PARAMETER_VALUE, IDENTIFYING, DOUBLE_VAL, LONG_VAL, DATE_VAL, KEY_NAME, STRING_VAL, TYPE_CD) VALUES (:jobExecutionId, :parameterName, :parameterType, :parameterValue, :identifying, :doubleVal, :longVal, :dateVal, :keyName, :stringVal, :typeCd)")
    public int insert(@BindBean BatchJobExecutionParams batchjobexecutionparams);

    /**
     * Finds a BatchJobExecutionParams by its ID.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_PARAMS WHERE BATCH_JOB_EXECUTION_PARAMS_id = :id")
    @RegisterBeanMapper(BatchJobExecutionParams.class)
    public Optional<BatchJobExecutionParams> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_PARAMS")
    @RegisterBeanMapper(BatchJobExecutionParams.class)
    public List<BatchJobExecutionParams> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_PARAMS ORDER BY BATCH_JOB_EXECUTION_PARAMS_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(BatchJobExecutionParams.class)
    public List<BatchJobExecutionParams> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a BatchJobExecutionParams and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE BATCH_JOB_EXECUTION_PARAMS SET JOB_EXECUTION_ID = :jobExecutionId, PARAMETER_NAME = :parameterName, PARAMETER_TYPE = :parameterType, PARAMETER_VALUE = :parameterValue, IDENTIFYING = :identifying, DOUBLE_VAL = :doubleVal, LONG_VAL = :longVal, DATE_VAL = :dateVal, KEY_NAME = :keyName, STRING_VAL = :stringVal, TYPE_CD = :typeCd WHERE BATCH_JOB_EXECUTION_PARAMS_id = :batchJobExecutionParamsId")
    public int update(@BindBean BatchJobExecutionParams batchjobexecutionparams);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_JOB_EXECUTION_PARAMS WHERE BATCH_JOB_EXECUTION_PARAMS_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM BATCH_JOB_EXECUTION_PARAMS")
    public long countAll();

    /**
     * Bulk insert multiple BatchJobExecutionParams entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BATCH_JOB_EXECUTION_PARAMS (JOB_EXECUTION_ID, PARAMETER_NAME, PARAMETER_TYPE, PARAMETER_VALUE, IDENTIFYING, DOUBLE_VAL, LONG_VAL, DATE_VAL, KEY_NAME, STRING_VAL, TYPE_CD) VALUES (:jobExecutionId, :parameterName, :parameterType, :parameterValue, :identifying, :doubleVal, :longVal, :dateVal, :keyName, :stringVal, :typeCd)")
    public int[] bulkInsert(@BindBean List<BatchJobExecutionParams> batchjobexecutionparamss);

    /**
     * Bulk update multiple BatchJobExecutionParams entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BATCH_JOB_EXECUTION_PARAMS SET JOB_EXECUTION_ID = :jobExecutionId, PARAMETER_NAME = :parameterName, PARAMETER_TYPE = :parameterType, PARAMETER_VALUE = :parameterValue, IDENTIFYING = :identifying, DOUBLE_VAL = :doubleVal, LONG_VAL = :longVal, DATE_VAL = :dateVal, KEY_NAME = :keyName, STRING_VAL = :stringVal, TYPE_CD = :typeCd WHERE BATCH_JOB_EXECUTION_PARAMS_id = :batchJobExecutionParamsId")
    public int[] bulkUpdate(@BindBean List<BatchJobExecutionParams> batchjobexecutionparamss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_JOB_EXECUTION_PARAMS WHERE BATCH_JOB_EXECUTION_PARAMS_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM BATCH_JOB_EXECUTION_PARAMS WHERE BATCH_JOB_EXECUTION_PARAMS_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple BatchJobExecutionParams records by their IDs.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_PARAMS WHERE BATCH_JOB_EXECUTION_PARAMS_id IN (<ids>)")
    @RegisterBeanMapper(BatchJobExecutionParams.class)
    public List<BatchJobExecutionParams> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all BatchJobExecutionParams records by jobExecutionId.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_PARAMS WHERE JOB_EXECUTION_ID = :jobExecutionId")
    @RegisterBeanMapper(BatchJobExecutionParams.class)
    public List<BatchJobExecutionParams> findByJobExecutionId(@Bind("jobExecutionId") int jobExecutionId);
}
