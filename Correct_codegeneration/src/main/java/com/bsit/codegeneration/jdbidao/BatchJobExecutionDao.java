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
import com.bsit.codegeneration.entity.BatchJobExecution;

public interface BatchJobExecutionDao {

    /**
     * Inserts a new BatchJobExecution and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO BATCH_JOB_EXECUTION (JOB_EXECUTION_ID, VERSION, JOB_INSTANCE_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, EXIT_CODE, EXIT_MESSAGE, JOB_CONFIGURATION_LOCATION) VALUES (:jobExecutionId, :version, :jobInstanceId, :createTime, :startTime, :endTime, :status, :exitCode, :exitMessage, :jobConfigurationLocation)")
    public int insert(@BindBean BatchJobExecution batchjobexecution);

    /**
     * Finds a BatchJobExecution by its ID.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION WHERE JOB_EXECUTION_ID = :id")
    @RegisterBeanMapper(BatchJobExecution.class)
    public Optional<BatchJobExecution> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION")
    @RegisterBeanMapper(BatchJobExecution.class)
    public List<BatchJobExecution> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION ORDER BY JOB_EXECUTION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(BatchJobExecution.class)
    public List<BatchJobExecution> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a BatchJobExecution and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE BATCH_JOB_EXECUTION SET VERSION = :version, JOB_INSTANCE_ID = :jobInstanceId, CREATE_TIME = :createTime, START_TIME = :startTime, END_TIME = :endTime, STATUS = :status, EXIT_CODE = :exitCode, EXIT_MESSAGE = :exitMessage, JOB_CONFIGURATION_LOCATION = :jobConfigurationLocation WHERE JOB_EXECUTION_ID = :jobExecutionId")
    public int update(@BindBean BatchJobExecution batchjobexecution);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_JOB_EXECUTION WHERE JOB_EXECUTION_ID = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM BATCH_JOB_EXECUTION")
    public long countAll();

    /**
     * Bulk insert multiple BatchJobExecution entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BATCH_JOB_EXECUTION (JOB_EXECUTION_ID, VERSION, JOB_INSTANCE_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, EXIT_CODE, EXIT_MESSAGE, JOB_CONFIGURATION_LOCATION) VALUES (:jobExecutionId, :version, :jobInstanceId, :createTime, :startTime, :endTime, :status, :exitCode, :exitMessage, :jobConfigurationLocation)")
    public int[] bulkInsert(@BindBean List<BatchJobExecution> batchjobexecutions);

    /**
     * Bulk update multiple BatchJobExecution entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BATCH_JOB_EXECUTION SET VERSION = :version, JOB_INSTANCE_ID = :jobInstanceId, CREATE_TIME = :createTime, START_TIME = :startTime, END_TIME = :endTime, STATUS = :status, EXIT_CODE = :exitCode, EXIT_MESSAGE = :exitMessage, JOB_CONFIGURATION_LOCATION = :jobConfigurationLocation WHERE JOB_EXECUTION_ID = :jobExecutionId")
    public int[] bulkUpdate(@BindBean List<BatchJobExecution> batchjobexecutions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_JOB_EXECUTION WHERE JOB_EXECUTION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM BATCH_JOB_EXECUTION WHERE JOB_EXECUTION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple BatchJobExecution records by their IDs.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION WHERE JOB_EXECUTION_ID IN (<ids>)")
    @RegisterBeanMapper(BatchJobExecution.class)
    public List<BatchJobExecution> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all BatchJobExecution records by jobInstanceId.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION WHERE JOB_INSTANCE_ID = :jobInstanceId")
    @RegisterBeanMapper(BatchJobExecution.class)
    public List<BatchJobExecution> findByJobInstanceId(@Bind("jobInstanceId") int jobInstanceId);
}
