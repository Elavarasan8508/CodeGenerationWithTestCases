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
import com.bsit.codegeneration.entity.BatchJobExecutionContext;

public interface BatchJobExecutionContextDao {

    /**
     * Inserts a new BatchJobExecutionContext and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO BATCH_JOB_EXECUTION_CONTEXT (JOB_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT) VALUES (:jobExecutionId, :shortContext, :serializedContext)")
    public int insert(@Bind("jobExecutionId") int jobExecutionId, @Bind("shortContext") String shortContext, @Bind("serializedContext") String serializedContext);

    /**
     * Finds a BatchJobExecutionContext by its ID.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_CONTEXT WHERE JOB_EXECUTION_ID = :id")
    @RegisterBeanMapper(BatchJobExecutionContext.class)
    public Optional<BatchJobExecutionContext> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_CONTEXT")
    @RegisterBeanMapper(BatchJobExecutionContext.class)
    public List<BatchJobExecutionContext> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_CONTEXT ORDER BY JOB_EXECUTION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(BatchJobExecutionContext.class)
    public List<BatchJobExecutionContext> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a BatchJobExecutionContext and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE BATCH_JOB_EXECUTION_CONTEXT SET SHORT_CONTEXT = :shortContext, SERIALIZED_CONTEXT = :serializedContext WHERE JOB_EXECUTION_ID = :jobExecutionId")
    public int update(@BindBean BatchJobExecutionContext batchjobexecutioncontext);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_JOB_EXECUTION_CONTEXT WHERE JOB_EXECUTION_ID = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM BATCH_JOB_EXECUTION_CONTEXT")
    public long countAll();

    /**
     * Bulk insert multiple BatchJobExecutionContext entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BATCH_JOB_EXECUTION_CONTEXT (JOB_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT) VALUES (:jobExecutionId, :shortContext, :serializedContext)")
    public int[] bulkInsert(@BindBean List<BatchJobExecutionContext> batchjobexecutioncontexts);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BATCH_JOB_EXECUTION_CONTEXT (JOB_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT) VALUES (:jobExecutionId, :shortContext, :serializedContext)")
    public int[] bulkInsertParams(@Bind("jobExecutionId") List<Integer> jobExecutionIds, @Bind("shortContext") List<String> shortContexts, @Bind("serializedContext") List<String> serializedContexts);

    /**
     * Bulk update multiple BatchJobExecutionContext entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BATCH_JOB_EXECUTION_CONTEXT SET SHORT_CONTEXT = :shortContext, SERIALIZED_CONTEXT = :serializedContext WHERE JOB_EXECUTION_ID = :jobExecutionId")
    public int[] bulkUpdate(@BindBean List<BatchJobExecutionContext> batchjobexecutioncontexts);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BATCH_JOB_EXECUTION_CONTEXT SET SHORT_CONTEXT = :shortContext, SERIALIZED_CONTEXT = :serializedContext WHERE JOB_EXECUTION_ID = :jobExecutionId")
    public int[] bulkUpdateParams(@Bind("shortContext") List<String> shortContexts, @Bind("serializedContext") List<String> serializedContexts, @Bind("jobExecutionId") List<Integer> jobExecutionIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_JOB_EXECUTION_CONTEXT WHERE JOB_EXECUTION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM BATCH_JOB_EXECUTION_CONTEXT WHERE JOB_EXECUTION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple BatchJobExecutionContext records by their IDs.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_CONTEXT WHERE JOB_EXECUTION_ID IN (<ids>)")
    @RegisterBeanMapper(BatchJobExecutionContext.class)
    public List<BatchJobExecutionContext> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all BatchJobExecutionContext records by jobExecutionId.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_CONTEXT WHERE JOB_EXECUTION_ID = :jobExecutionId")
    @RegisterBeanMapper(BatchJobExecutionContext.class)
    public List<BatchJobExecutionContext> findByJobExecutionId(@Bind("jobExecutionId") int jobExecutionId);
}
