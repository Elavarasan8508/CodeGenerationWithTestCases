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
import com.bsit.codegeneration.entity.QrtzSimpleTriggers;

public interface QrtzSimpleTriggersDao {

    /**
     * Inserts a new QrtzSimpleTriggers and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_SIMPLE_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, REPEAT_COUNT, REPEAT_INTERVAL, TIMES_TRIGGERED) VALUES (:schedName, :triggerName, :triggerGroup, :repeatCount, :repeatInterval, :timesTriggered)")
    public int insert(@BindBean QrtzSimpleTriggers qrtzsimpletriggers);

    /**
     * Finds a QrtzSimpleTriggers by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPLE_TRIGGERS WHERE SCHED_NAME = :id")
    @RegisterBeanMapper(QrtzSimpleTriggers.class)
    public Optional<QrtzSimpleTriggers> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPLE_TRIGGERS")
    @RegisterBeanMapper(QrtzSimpleTriggers.class)
    public List<QrtzSimpleTriggers> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPLE_TRIGGERS ORDER BY SCHED_NAME LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzSimpleTriggers.class)
    public List<QrtzSimpleTriggers> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a QrtzSimpleTriggers and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE QRTZ_SIMPLE_TRIGGERS SET REPEAT_COUNT = :repeatCount, REPEAT_INTERVAL = :repeatInterval, TIMES_TRIGGERED = :timesTriggered WHERE SCHED_NAME = :schedName")
    public int update(@BindBean QrtzSimpleTriggers qrtzsimpletriggers);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_SIMPLE_TRIGGERS WHERE SCHED_NAME = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_SIMPLE_TRIGGERS")
    public long countAll();

    /**
     * Bulk insert multiple QrtzSimpleTriggers entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_SIMPLE_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, REPEAT_COUNT, REPEAT_INTERVAL, TIMES_TRIGGERED) VALUES (:schedName, :triggerName, :triggerGroup, :repeatCount, :repeatInterval, :timesTriggered)")
    public int[] bulkInsert(@BindBean List<QrtzSimpleTriggers> qrtzsimpletriggerss);

    /**
     * Bulk update multiple QrtzSimpleTriggers entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_SIMPLE_TRIGGERS SET REPEAT_COUNT = :repeatCount, REPEAT_INTERVAL = :repeatInterval, TIMES_TRIGGERED = :timesTriggered WHERE SCHED_NAME = :schedName")
    public int[] bulkUpdate(@BindBean List<QrtzSimpleTriggers> qrtzsimpletriggerss);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_SIMPLE_TRIGGERS SET REPEAT_COUNT = :repeatCount, REPEAT_INTERVAL = :repeatInterval, TIMES_TRIGGERED = :timesTriggered WHERE SCHED_NAME = :schedName")
    public int[] bulkUpdateParams(@Bind("repeatCount") List<java.math.BigDecimal> repeatCounts, @Bind("repeatInterval") List<java.math.BigDecimal> repeatIntervals, @Bind("timesTriggered") List<java.math.BigDecimal> timesTriggereds, @Bind("schedName") List<Integer> schedNames);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_SIMPLE_TRIGGERS WHERE SCHED_NAME IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_SIMPLE_TRIGGERS WHERE SCHED_NAME = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple QrtzSimpleTriggers records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPLE_TRIGGERS WHERE SCHED_NAME IN (<ids>)")
    @RegisterBeanMapper(QrtzSimpleTriggers.class)
    public List<QrtzSimpleTriggers> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all QrtzSimpleTriggers records by schedName.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPLE_TRIGGERS WHERE SCHED_NAME = :schedName")
    @RegisterBeanMapper(QrtzSimpleTriggers.class)
    public List<QrtzSimpleTriggers> findBySchedName(@Bind("schedName") int schedName);

    /**
     * Finds all QrtzSimpleTriggers records by triggerName.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPLE_TRIGGERS WHERE TRIGGER_NAME = :triggerName")
    @RegisterBeanMapper(QrtzSimpleTriggers.class)
    public List<QrtzSimpleTriggers> findByTriggerName(@Bind("triggerName") int triggerName);

    /**
     * Finds all QrtzSimpleTriggers records by triggerGroup.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPLE_TRIGGERS WHERE TRIGGER_GROUP = :triggerGroup")
    @RegisterBeanMapper(QrtzSimpleTriggers.class)
    public List<QrtzSimpleTriggers> findByTriggerGroup(@Bind("triggerGroup") int triggerGroup);
}
