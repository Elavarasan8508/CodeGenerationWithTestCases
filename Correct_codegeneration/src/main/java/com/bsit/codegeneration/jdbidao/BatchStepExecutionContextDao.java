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
import com.bsit.codegeneration.entity.BatchStepExecutionContext;

public interface BatchStepExecutionContextDao {

    /**
     * Inserts a new BatchStepExecutionContext and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO BATCH_STEP_EXECUTION_CONTEXT (STEP_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT) VALUES (:stepExecutionId, :shortContext, :serializedContext)")
    public int insert(@Bind("stepExecutionId") int stepExecutionId, @Bind("shortContext") String shortContext, @Bind("serializedContext") String serializedContext);

    /**
     * Finds a BatchStepExecutionContext by its ID.
     */
    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION_CONTEXT WHERE STEP_EXECUTION_ID = :id")
    @RegisterBeanMapper(BatchStepExecutionContext.class)
    public Optional<BatchStepExecutionContext> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION_CONTEXT")
    @RegisterBeanMapper(BatchStepExecutionContext.class)
    public List<BatchStepExecutionContext> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION_CONTEXT ORDER BY STEP_EXECUTION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(BatchStepExecutionContext.class)
    public List<BatchStepExecutionContext> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a BatchStepExecutionContext and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE BATCH_STEP_EXECUTION_CONTEXT SET SHORT_CONTEXT = :shortContext, SERIALIZED_CONTEXT = :serializedContext WHERE STEP_EXECUTION_ID = :stepExecutionId")
    public int update(@BindBean BatchStepExecutionContext batchstepexecutioncontext);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_STEP_EXECUTION_CONTEXT WHERE STEP_EXECUTION_ID = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM BATCH_STEP_EXECUTION_CONTEXT")
    public long countAll();

    /**
     * Bulk insert multiple BatchStepExecutionContext entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BATCH_STEP_EXECUTION_CONTEXT (STEP_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT) VALUES (:stepExecutionId, :shortContext, :serializedContext)")
    public int[] bulkInsert(@BindBean List<BatchStepExecutionContext> batchstepexecutioncontexts);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BATCH_STEP_EXECUTION_CONTEXT (STEP_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT) VALUES (:stepExecutionId, :shortContext, :serializedContext)")
    public int[] bulkInsertParams(@Bind("stepExecutionId") List<Integer> stepExecutionIds, @Bind("shortContext") List<String> shortContexts, @Bind("serializedContext") List<String> serializedContexts);

    /**
     * Bulk update multiple BatchStepExecutionContext entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BATCH_STEP_EXECUTION_CONTEXT SET SHORT_CONTEXT = :shortContext, SERIALIZED_CONTEXT = :serializedContext WHERE STEP_EXECUTION_ID = :stepExecutionId")
    public int[] bulkUpdate(@BindBean List<BatchStepExecutionContext> batchstepexecutioncontexts);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BATCH_STEP_EXECUTION_CONTEXT SET SHORT_CONTEXT = :shortContext, SERIALIZED_CONTEXT = :serializedContext WHERE STEP_EXECUTION_ID = :stepExecutionId")
    public int[] bulkUpdateParams(@Bind("shortContext") List<String> shortContexts, @Bind("serializedContext") List<String> serializedContexts, @Bind("stepExecutionId") List<Integer> stepExecutionIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_STEP_EXECUTION_CONTEXT WHERE STEP_EXECUTION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM BATCH_STEP_EXECUTION_CONTEXT WHERE STEP_EXECUTION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple BatchStepExecutionContext records by their IDs.
     */
    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION_CONTEXT WHERE STEP_EXECUTION_ID IN (<ids>)")
    @RegisterBeanMapper(BatchStepExecutionContext.class)
    public List<BatchStepExecutionContext> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all BatchStepExecutionContext records by stepExecutionId.
     */
    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION_CONTEXT WHERE STEP_EXECUTION_ID = :stepExecutionId")
    @RegisterBeanMapper(BatchStepExecutionContext.class)
    public List<BatchStepExecutionContext> findByStepExecutionId(@Bind("stepExecutionId") int stepExecutionId);
}
