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
import com.bsit.codegeneration.entity.QrtzTriggers;

public interface QrtzTriggersDao {

    /**
     * Inserts a new QrtzTriggers and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA) VALUES (:schedName, :triggerName, :triggerGroup, :jobName, :jobGroup, :description, :nextFireTime, :prevFireTime, :priority, :triggerState, :triggerType, :startTime, :endTime, :calendarName, :misfireInstr, :jobData)")
    public int insert(@BindBean QrtzTriggers qrtztriggers);

    /**
     * Finds a QrtzTriggers by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_TRIGGERS WHERE SCHED_NAME = :id")
    @RegisterBeanMapper(QrtzTriggers.class)
    public Optional<QrtzTriggers> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_TRIGGERS")
    @RegisterBeanMapper(QrtzTriggers.class)
    public List<QrtzTriggers> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_TRIGGERS ORDER BY SCHED_NAME LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzTriggers.class)
    public List<QrtzTriggers> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a QrtzTriggers and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE QRTZ_TRIGGERS SET JOB_NAME = :jobName, JOB_GROUP = :jobGroup, DESCRIPTION = :description, NEXT_FIRE_TIME = :nextFireTime, PREV_FIRE_TIME = :prevFireTime, PRIORITY = :priority, TRIGGER_STATE = :triggerState, TRIGGER_TYPE = :triggerType, START_TIME = :startTime, END_TIME = :endTime, CALENDAR_NAME = :calendarName, MISFIRE_INSTR = :misfireInstr, JOB_DATA = :jobData WHERE SCHED_NAME = :schedName")
    public int update(@BindBean QrtzTriggers qrtztriggers);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_TRIGGERS WHERE SCHED_NAME = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_TRIGGERS")
    public long countAll();

    /**
     * Bulk insert multiple QrtzTriggers entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA) VALUES (:schedName, :triggerName, :triggerGroup, :jobName, :jobGroup, :description, :nextFireTime, :prevFireTime, :priority, :triggerState, :triggerType, :startTime, :endTime, :calendarName, :misfireInstr, :jobData)")
    public int[] bulkInsert(@BindBean List<QrtzTriggers> qrtztriggerss);

    /**
     * Bulk update multiple QrtzTriggers entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_TRIGGERS SET JOB_NAME = :jobName, JOB_GROUP = :jobGroup, DESCRIPTION = :description, NEXT_FIRE_TIME = :nextFireTime, PREV_FIRE_TIME = :prevFireTime, PRIORITY = :priority, TRIGGER_STATE = :triggerState, TRIGGER_TYPE = :triggerType, START_TIME = :startTime, END_TIME = :endTime, CALENDAR_NAME = :calendarName, MISFIRE_INSTR = :misfireInstr, JOB_DATA = :jobData WHERE SCHED_NAME = :schedName")
    public int[] bulkUpdate(@BindBean List<QrtzTriggers> qrtztriggerss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_TRIGGERS WHERE SCHED_NAME IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_TRIGGERS WHERE SCHED_NAME = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple QrtzTriggers records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_TRIGGERS WHERE SCHED_NAME IN (<ids>)")
    @RegisterBeanMapper(QrtzTriggers.class)
    public List<QrtzTriggers> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all QrtzTriggers records by jobGroup.
     */
    @SqlQuery("SELECT * FROM QRTZ_TRIGGERS WHERE JOB_GROUP = :jobGroup")
    @RegisterBeanMapper(QrtzTriggers.class)
    public List<QrtzTriggers> findByJobGroup(@Bind("jobGroup") int jobGroup);

    /**
     * Finds all QrtzTriggers records by schedName.
     */
    @SqlQuery("SELECT * FROM QRTZ_TRIGGERS WHERE SCHED_NAME = :schedName")
    @RegisterBeanMapper(QrtzTriggers.class)
    public List<QrtzTriggers> findBySchedName(@Bind("schedName") int schedName);

    /**
     * Finds all QrtzTriggers records by jobName.
     */
    @SqlQuery("SELECT * FROM QRTZ_TRIGGERS WHERE JOB_NAME = :jobName")
    @RegisterBeanMapper(QrtzTriggers.class)
    public List<QrtzTriggers> findByJobName(@Bind("jobName") int jobName);
}
