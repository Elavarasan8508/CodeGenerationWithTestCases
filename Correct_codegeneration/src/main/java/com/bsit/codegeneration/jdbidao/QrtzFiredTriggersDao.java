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
import com.bsit.codegeneration.entity.QrtzFiredTriggers;

public interface QrtzFiredTriggersDao {

    /**
     * Inserts a new QrtzFiredTriggers and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_FIRED_TRIGGERS (SCHED_NAME, ENTRY_ID, TRIGGER_NAME, TRIGGER_GROUP, INSTANCE_NAME, FIRED_TIME, SCHED_TIME, PRIORITY, STATE, JOB_NAME, JOB_GROUP, IS_NONCONCURRENT, REQUESTS_RECOVERY) VALUES (:schedName, :entryId, :triggerName, :triggerGroup, :instanceName, :firedTime, :schedTime, :priority, :state, :jobName, :jobGroup, :isNonconcurrent, :requestsRecovery)")
    public int insert(@BindBean QrtzFiredTriggers qrtzfiredtriggers);

    /**
     * Finds a QrtzFiredTriggers by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_FIRED_TRIGGERS WHERE ENTRY_ID = :id")
    @RegisterBeanMapper(QrtzFiredTriggers.class)
    public Optional<QrtzFiredTriggers> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_FIRED_TRIGGERS")
    @RegisterBeanMapper(QrtzFiredTriggers.class)
    public List<QrtzFiredTriggers> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_FIRED_TRIGGERS ORDER BY ENTRY_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzFiredTriggers.class)
    public List<QrtzFiredTriggers> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a QrtzFiredTriggers and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE QRTZ_FIRED_TRIGGERS SET TRIGGER_NAME = :triggerName, TRIGGER_GROUP = :triggerGroup, INSTANCE_NAME = :instanceName, FIRED_TIME = :firedTime, SCHED_TIME = :schedTime, PRIORITY = :priority, STATE = :state, JOB_NAME = :jobName, JOB_GROUP = :jobGroup, IS_NONCONCURRENT = :isNonconcurrent, REQUESTS_RECOVERY = :requestsRecovery WHERE ENTRY_ID = :entryId")
    public int update(@BindBean QrtzFiredTriggers qrtzfiredtriggers);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_FIRED_TRIGGERS WHERE ENTRY_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_FIRED_TRIGGERS")
    public long countAll();

    /**
     * Bulk insert multiple QrtzFiredTriggers entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_FIRED_TRIGGERS (SCHED_NAME, ENTRY_ID, TRIGGER_NAME, TRIGGER_GROUP, INSTANCE_NAME, FIRED_TIME, SCHED_TIME, PRIORITY, STATE, JOB_NAME, JOB_GROUP, IS_NONCONCURRENT, REQUESTS_RECOVERY) VALUES (:schedName, :entryId, :triggerName, :triggerGroup, :instanceName, :firedTime, :schedTime, :priority, :state, :jobName, :jobGroup, :isNonconcurrent, :requestsRecovery)")
    public int[] bulkInsert(@BindBean List<QrtzFiredTriggers> qrtzfiredtriggerss);

    /**
     * Bulk update multiple QrtzFiredTriggers entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_FIRED_TRIGGERS SET TRIGGER_NAME = :triggerName, TRIGGER_GROUP = :triggerGroup, INSTANCE_NAME = :instanceName, FIRED_TIME = :firedTime, SCHED_TIME = :schedTime, PRIORITY = :priority, STATE = :state, JOB_NAME = :jobName, JOB_GROUP = :jobGroup, IS_NONCONCURRENT = :isNonconcurrent, REQUESTS_RECOVERY = :requestsRecovery WHERE ENTRY_ID = :entryId")
    public int[] bulkUpdate(@BindBean List<QrtzFiredTriggers> qrtzfiredtriggerss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_FIRED_TRIGGERS WHERE ENTRY_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_FIRED_TRIGGERS WHERE ENTRY_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple QrtzFiredTriggers records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_FIRED_TRIGGERS WHERE ENTRY_ID IN (<ids>)")
    @RegisterBeanMapper(QrtzFiredTriggers.class)
    public List<QrtzFiredTriggers> findByIds(@BindList("ids") Collection<String> ids);
}
