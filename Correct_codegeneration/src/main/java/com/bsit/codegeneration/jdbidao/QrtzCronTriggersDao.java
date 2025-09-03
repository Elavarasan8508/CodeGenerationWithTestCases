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
import com.bsit.codegeneration.entity.QrtzCronTriggers;

public interface QrtzCronTriggersDao {

    /**
     * Inserts a new QrtzCronTriggers and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_CRON_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID) VALUES (:schedName, :triggerName, :triggerGroup, :cronExpression, :timeZoneId)")
    public int insert(@BindBean QrtzCronTriggers qrtzcrontriggers);

    /**
     * Finds a QrtzCronTriggers by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_CRON_TRIGGERS WHERE SCHED_NAME = :id")
    @RegisterBeanMapper(QrtzCronTriggers.class)
    public Optional<QrtzCronTriggers> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_CRON_TRIGGERS")
    @RegisterBeanMapper(QrtzCronTriggers.class)
    public List<QrtzCronTriggers> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_CRON_TRIGGERS ORDER BY SCHED_NAME LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzCronTriggers.class)
    public List<QrtzCronTriggers> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a QrtzCronTriggers and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE QRTZ_CRON_TRIGGERS SET CRON_EXPRESSION = :cronExpression, TIME_ZONE_ID = :timeZoneId WHERE SCHED_NAME = :schedName")
    public int update(@BindBean QrtzCronTriggers qrtzcrontriggers);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_CRON_TRIGGERS WHERE SCHED_NAME = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_CRON_TRIGGERS")
    public long countAll();

    /**
     * Bulk insert multiple QrtzCronTriggers entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_CRON_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID) VALUES (:schedName, :triggerName, :triggerGroup, :cronExpression, :timeZoneId)")
    public int[] bulkInsert(@BindBean List<QrtzCronTriggers> qrtzcrontriggerss);

    /**
     * Bulk update multiple QrtzCronTriggers entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_CRON_TRIGGERS SET CRON_EXPRESSION = :cronExpression, TIME_ZONE_ID = :timeZoneId WHERE SCHED_NAME = :schedName")
    public int[] bulkUpdate(@BindBean List<QrtzCronTriggers> qrtzcrontriggerss);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_CRON_TRIGGERS SET CRON_EXPRESSION = :cronExpression, TIME_ZONE_ID = :timeZoneId WHERE SCHED_NAME = :schedName")
    public int[] bulkUpdateParams(@Bind("cronExpression") List<String> cronExpressions, @Bind("timeZoneId") List<Integer> timeZoneIds, @Bind("schedName") List<Integer> schedNames);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_CRON_TRIGGERS WHERE SCHED_NAME IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_CRON_TRIGGERS WHERE SCHED_NAME = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple QrtzCronTriggers records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_CRON_TRIGGERS WHERE SCHED_NAME IN (<ids>)")
    @RegisterBeanMapper(QrtzCronTriggers.class)
    public List<QrtzCronTriggers> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all QrtzCronTriggers records by schedName.
     */
    @SqlQuery("SELECT * FROM QRTZ_CRON_TRIGGERS WHERE SCHED_NAME = :schedName")
    @RegisterBeanMapper(QrtzCronTriggers.class)
    public List<QrtzCronTriggers> findBySchedName(@Bind("schedName") int schedName);

    /**
     * Finds all QrtzCronTriggers records by triggerName.
     */
    @SqlQuery("SELECT * FROM QRTZ_CRON_TRIGGERS WHERE TRIGGER_NAME = :triggerName")
    @RegisterBeanMapper(QrtzCronTriggers.class)
    public List<QrtzCronTriggers> findByTriggerName(@Bind("triggerName") int triggerName);

    /**
     * Finds all QrtzCronTriggers records by triggerGroup.
     */
    @SqlQuery("SELECT * FROM QRTZ_CRON_TRIGGERS WHERE TRIGGER_GROUP = :triggerGroup")
    @RegisterBeanMapper(QrtzCronTriggers.class)
    public List<QrtzCronTriggers> findByTriggerGroup(@Bind("triggerGroup") int triggerGroup);
}
