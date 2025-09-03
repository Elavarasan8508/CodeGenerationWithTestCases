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
import com.bsit.codegeneration.entity.QrtzJobDetails;

public interface QrtzJobDetailsDao {

    /**
     * Inserts a new QrtzJobDetails and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_JOB_DETAILS (SCHED_NAME, JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_NONCONCURRENT, IS_UPDATE_DATA, REQUESTS_RECOVERY, JOB_DATA) VALUES (:schedName, :jobName, :jobGroup, :description, :jobClassName, :isDurable, :isNonconcurrent, :isUpdateData, :requestsRecovery, :jobData)")
    public int insert(@BindBean QrtzJobDetails qrtzjobdetails);

    /**
     * Finds a QrtzJobDetails by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_JOB_DETAILS WHERE JOB_GROUP = :id")
    @RegisterBeanMapper(QrtzJobDetails.class)
    public Optional<QrtzJobDetails> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_JOB_DETAILS")
    @RegisterBeanMapper(QrtzJobDetails.class)
    public List<QrtzJobDetails> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_JOB_DETAILS ORDER BY JOB_GROUP LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzJobDetails.class)
    public List<QrtzJobDetails> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a QrtzJobDetails and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE QRTZ_JOB_DETAILS SET DESCRIPTION = :description, JOB_CLASS_NAME = :jobClassName, IS_DURABLE = :isDurable, IS_NONCONCURRENT = :isNonconcurrent, IS_UPDATE_DATA = :isUpdateData, REQUESTS_RECOVERY = :requestsRecovery, JOB_DATA = :jobData WHERE JOB_GROUP = :jobGroup")
    public int update(@BindBean QrtzJobDetails qrtzjobdetails);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_JOB_DETAILS WHERE JOB_GROUP = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_JOB_DETAILS")
    public long countAll();

    /**
     * Bulk insert multiple QrtzJobDetails entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_JOB_DETAILS (SCHED_NAME, JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_NONCONCURRENT, IS_UPDATE_DATA, REQUESTS_RECOVERY, JOB_DATA) VALUES (:schedName, :jobName, :jobGroup, :description, :jobClassName, :isDurable, :isNonconcurrent, :isUpdateData, :requestsRecovery, :jobData)")
    public int[] bulkInsert(@BindBean List<QrtzJobDetails> qrtzjobdetailss);

    /**
     * Bulk update multiple QrtzJobDetails entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_JOB_DETAILS SET DESCRIPTION = :description, JOB_CLASS_NAME = :jobClassName, IS_DURABLE = :isDurable, IS_NONCONCURRENT = :isNonconcurrent, IS_UPDATE_DATA = :isUpdateData, REQUESTS_RECOVERY = :requestsRecovery, JOB_DATA = :jobData WHERE JOB_GROUP = :jobGroup")
    public int[] bulkUpdate(@BindBean List<QrtzJobDetails> qrtzjobdetailss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_JOB_DETAILS WHERE JOB_GROUP IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_JOB_DETAILS WHERE JOB_GROUP = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple QrtzJobDetails records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_JOB_DETAILS WHERE JOB_GROUP IN (<ids>)")
    @RegisterBeanMapper(QrtzJobDetails.class)
    public List<QrtzJobDetails> findByIds(@BindList("ids") Collection<String> ids);
}
