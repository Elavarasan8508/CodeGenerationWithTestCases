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
import com.bsit.codegeneration.entity.BatchJobInstance;

public interface BatchJobInstanceDao {

    /**
     * Inserts a new BatchJobInstance and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO BATCH_JOB_INSTANCE (JOB_INSTANCE_ID, VERSION, JOB_NAME, JOB_KEY) VALUES (:jobInstanceId, :version, :jobName, :jobKey)")
    public int insert(@BindBean BatchJobInstance batchjobinstance);

    /**
     * Finds a BatchJobInstance by its ID.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_INSTANCE WHERE JOB_INSTANCE_ID = :id")
    @RegisterBeanMapper(BatchJobInstance.class)
    public Optional<BatchJobInstance> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_INSTANCE")
    @RegisterBeanMapper(BatchJobInstance.class)
    public List<BatchJobInstance> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_INSTANCE ORDER BY JOB_INSTANCE_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(BatchJobInstance.class)
    public List<BatchJobInstance> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a BatchJobInstance and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE BATCH_JOB_INSTANCE SET VERSION = :version, JOB_NAME = :jobName, JOB_KEY = :jobKey WHERE JOB_INSTANCE_ID = :jobInstanceId")
    public int update(@BindBean BatchJobInstance batchjobinstance);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_JOB_INSTANCE WHERE JOB_INSTANCE_ID = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM BATCH_JOB_INSTANCE")
    public long countAll();

    /**
     * Bulk insert multiple BatchJobInstance entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BATCH_JOB_INSTANCE (JOB_INSTANCE_ID, VERSION, JOB_NAME, JOB_KEY) VALUES (:jobInstanceId, :version, :jobName, :jobKey)")
    public int[] bulkInsert(@BindBean List<BatchJobInstance> batchjobinstances);

    /**
     * Bulk update multiple BatchJobInstance entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BATCH_JOB_INSTANCE SET VERSION = :version, JOB_NAME = :jobName, JOB_KEY = :jobKey WHERE JOB_INSTANCE_ID = :jobInstanceId")
    public int[] bulkUpdate(@BindBean List<BatchJobInstance> batchjobinstances);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BATCH_JOB_INSTANCE SET VERSION = :version, JOB_NAME = :jobName, JOB_KEY = :jobKey WHERE JOB_INSTANCE_ID = :jobInstanceId")
    public int[] bulkUpdateParams(@Bind("version") List<java.math.BigDecimal> versions, @Bind("jobName") List<String> jobNames, @Bind("jobKey") List<String> jobKeys, @Bind("jobInstanceId") List<Integer> jobInstanceIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM BATCH_JOB_INSTANCE WHERE JOB_INSTANCE_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM BATCH_JOB_INSTANCE WHERE JOB_INSTANCE_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple BatchJobInstance records by their IDs.
     */
    @SqlQuery("SELECT * FROM BATCH_JOB_INSTANCE WHERE JOB_INSTANCE_ID IN (<ids>)")
    @RegisterBeanMapper(BatchJobInstance.class)
    public List<BatchJobInstance> findByIds(@BindList("ids") Collection<Integer> ids);
}
