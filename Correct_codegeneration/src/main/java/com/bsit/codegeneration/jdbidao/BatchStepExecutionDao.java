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
import com.bsit.codegeneration.entity.BatchStepExecution;

public interface BatchStepExecutionDao {

    /**
     * Inserts a new BatchStepExecution and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO BATCH_STEP_EXECUTION (STEP_EXECUTION_ID, VERSION, STEP_NAME, JOB_EXECUTION_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, COMMIT_COUNT, READ_COUNT, FILTER_COUNT, WRITE_COUNT, READ_SKIP_COUNT, WRITE_SKIP_COUNT, PROCESS_SKIP_COUNT, ROLLBACK_COUNT, EXIT_CODE, EXIT_MESSAGE) VALUES (:stepExecutionId, :version, :stepName, :jobExecutionId, :createTime, :startTime, :endTime, :status, :commitCount, :readCount, :filterCount, :writeCount, :readSkipCount, :writeSkipCount, :processSkipCount, :rollbackCount, :exitCode, :exitMessage)")
    public int insert(@BindBean BatchStepExecution batchstepexecution);

    /**
     * Finds a BatchStepExecution by its ID.
     */
    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION WHERE STEP_EXECUTION_ID = :id")
    @RegisterBeanMapper(BatchStepExecution.class)
    public Optional<BatchStepExecution> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION")
    @RegisterBeanMapper(BatchStepExecution.class)
    public List<BatchStepExecution> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION ORDER BY STEP_EXECUTION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(BatchStepExecution.class)
    public List<BatchStepExecution> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a BatchStepExecution and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE BATCH_STEP_EXECUTION SET VERSION = :version, STEP_NAME = :stepName, JOB_EXECUTION_ID = :jobExecutionId, CREATE_TIME = :createTime, START_TIME = :startTime, END_TIME = :endTime, STATUS = :status, COMMIT_COUNT = :commitCount, READ_COUNT = :readCount, FILTER_COUNT = :filterCount, WRITE_COUNT = :writeCount, READ_SKIP_COUNT = :readSkipCount, WRITE_SKIP_COUNT = :writeSkipCount, PROCESS_SKIP_COUNT = :processSkipCount, ROLLBACK_COUNT = :rollbackCount, EXIT_CODE = :exitCode, EXIT_MESSAGE = :exitMessage WHERE STEP_EXECUTION_ID = :stepExecutionId")
    public int update(@BindBean BatchStepExecution batchstepexecution);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_STEP_EXECUTION WHERE STEP_EXECUTION_ID = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM BATCH_STEP_EXECUTION")
    public long countAll();

    /**
     * Bulk insert multiple BatchStepExecution entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BATCH_STEP_EXECUTION (STEP_EXECUTION_ID, VERSION, STEP_NAME, JOB_EXECUTION_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, COMMIT_COUNT, READ_COUNT, FILTER_COUNT, WRITE_COUNT, READ_SKIP_COUNT, WRITE_SKIP_COUNT, PROCESS_SKIP_COUNT, ROLLBACK_COUNT, EXIT_CODE, EXIT_MESSAGE) VALUES (:stepExecutionId, :version, :stepName, :jobExecutionId, :createTime, :startTime, :endTime, :status, :commitCount, :readCount, :filterCount, :writeCount, :readSkipCount, :writeSkipCount, :processSkipCount, :rollbackCount, :exitCode, :exitMessage)")
    public int[] bulkInsert(@BindBean List<BatchStepExecution> batchstepexecutions);

    /**
     * Bulk update multiple BatchStepExecution entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BATCH_STEP_EXECUTION SET VERSION = :version, STEP_NAME = :stepName, JOB_EXECUTION_ID = :jobExecutionId, CREATE_TIME = :createTime, START_TIME = :startTime, END_TIME = :endTime, STATUS = :status, COMMIT_COUNT = :commitCount, READ_COUNT = :readCount, FILTER_COUNT = :filterCount, WRITE_COUNT = :writeCount, READ_SKIP_COUNT = :readSkipCount, WRITE_SKIP_COUNT = :writeSkipCount, PROCESS_SKIP_COUNT = :processSkipCount, ROLLBACK_COUNT = :rollbackCount, EXIT_CODE = :exitCode, EXIT_MESSAGE = :exitMessage WHERE STEP_EXECUTION_ID = :stepExecutionId")
    public int[] bulkUpdate(@BindBean List<BatchStepExecution> batchstepexecutions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_STEP_EXECUTION WHERE STEP_EXECUTION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM BATCH_STEP_EXECUTION WHERE STEP_EXECUTION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple BatchStepExecution records by their IDs.
     */
    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION WHERE STEP_EXECUTION_ID IN (<ids>)")
    @RegisterBeanMapper(BatchStepExecution.class)
    public List<BatchStepExecution> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all BatchStepExecution records by jobExecutionId.
     */
    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION WHERE JOB_EXECUTION_ID = :jobExecutionId")
    @RegisterBeanMapper(BatchStepExecution.class)
    public List<BatchStepExecution> findByJobExecutionId(@Bind("jobExecutionId") int jobExecutionId);
}
