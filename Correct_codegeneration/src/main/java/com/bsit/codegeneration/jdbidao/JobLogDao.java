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
import com.bsit.codegeneration.entity.JobLog;

public interface JobLogDao {

    /**
     * Inserts a new JobLog and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO JOB_LOG (LOG_TIME, MESSAGE) VALUES (:logTime, :message)")
    public int insert(@Bind("logTime") String logTime, @Bind("message") String message);

    /**
     * Finds a JobLog by its ID.
     */
    @SqlQuery("SELECT * FROM JOB_LOG WHERE JOB_LOG_id = :id")
    @RegisterBeanMapper(JobLog.class)
    public Optional<JobLog> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM JOB_LOG")
    @RegisterBeanMapper(JobLog.class)
    public List<JobLog> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM JOB_LOG ORDER BY JOB_LOG_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(JobLog.class)
    public List<JobLog> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a JobLog and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE JOB_LOG SET LOG_TIME = :logTime, MESSAGE = :message WHERE JOB_LOG_id = :jobLogId")
    public int update(@BindBean JobLog joblog);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM JOB_LOG WHERE JOB_LOG_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM JOB_LOG")
    public long countAll();

    /**
     * Bulk insert multiple JobLog entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO JOB_LOG (LOG_TIME, MESSAGE) VALUES (:logTime, :message)")
    public int[] bulkInsert(@BindBean List<JobLog> joblogs);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO JOB_LOG (LOG_TIME, MESSAGE) VALUES (:logTime, :message)")
    public int[] bulkInsertParams(@Bind("logTime") List<String> logTimes, @Bind("message") List<String> messages);

    /**
     * Bulk update multiple JobLog entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE JOB_LOG SET LOG_TIME = :logTime, MESSAGE = :message WHERE JOB_LOG_id = :jobLogId")
    public int[] bulkUpdate(@BindBean List<JobLog> joblogs);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE JOB_LOG SET LOG_TIME = :logTime, MESSAGE = :message WHERE JOB_LOG_id = :jobLogId")
    public int[] bulkUpdateParams(@Bind("logTime") List<String> logTimes, @Bind("message") List<String> messages, @Bind("jobLogId") List<Integer> jobLogIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM JOB_LOG WHERE JOB_LOG_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM JOB_LOG WHERE JOB_LOG_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple JobLog records by their IDs.
     */
    @SqlQuery("SELECT * FROM JOB_LOG WHERE JOB_LOG_id IN (<ids>)")
    @RegisterBeanMapper(JobLog.class)
    public List<JobLog> findByIds(@BindList("ids") Collection<Integer> ids);
}
