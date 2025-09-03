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
import com.bsit.codegeneration.entity.QrtzSchedulerState;

public interface QrtzSchedulerStateDao {

    /**
     * Inserts a new QrtzSchedulerState and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_SCHEDULER_STATE (SCHED_NAME, INSTANCE_NAME, LAST_CHECKIN_TIME, CHECKIN_INTERVAL) VALUES (:schedName, :instanceName, :lastCheckinTime, :checkinInterval)")
    public int insert(@BindBean QrtzSchedulerState qrtzschedulerstate);

    /**
     * Finds a QrtzSchedulerState by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_SCHEDULER_STATE WHERE QRTZ_SCHEDULER_STATE_id = :id")
    @RegisterBeanMapper(QrtzSchedulerState.class)
    public Optional<QrtzSchedulerState> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_SCHEDULER_STATE")
    @RegisterBeanMapper(QrtzSchedulerState.class)
    public List<QrtzSchedulerState> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_SCHEDULER_STATE ORDER BY QRTZ_SCHEDULER_STATE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzSchedulerState.class)
    public List<QrtzSchedulerState> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a QrtzSchedulerState and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE QRTZ_SCHEDULER_STATE SET SCHED_NAME = :schedName, INSTANCE_NAME = :instanceName, LAST_CHECKIN_TIME = :lastCheckinTime, CHECKIN_INTERVAL = :checkinInterval WHERE QRTZ_SCHEDULER_STATE_id = :qrtzSchedulerStateId")
    public int update(@BindBean QrtzSchedulerState qrtzschedulerstate);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_SCHEDULER_STATE WHERE QRTZ_SCHEDULER_STATE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_SCHEDULER_STATE")
    public long countAll();

    /**
     * Bulk insert multiple QrtzSchedulerState entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_SCHEDULER_STATE (SCHED_NAME, INSTANCE_NAME, LAST_CHECKIN_TIME, CHECKIN_INTERVAL) VALUES (:schedName, :instanceName, :lastCheckinTime, :checkinInterval)")
    public int[] bulkInsert(@BindBean List<QrtzSchedulerState> qrtzschedulerstates);

    /**
     * Bulk update multiple QrtzSchedulerState entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_SCHEDULER_STATE SET SCHED_NAME = :schedName, INSTANCE_NAME = :instanceName, LAST_CHECKIN_TIME = :lastCheckinTime, CHECKIN_INTERVAL = :checkinInterval WHERE QRTZ_SCHEDULER_STATE_id = :qrtzSchedulerStateId")
    public int[] bulkUpdate(@BindBean List<QrtzSchedulerState> qrtzschedulerstates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_SCHEDULER_STATE WHERE QRTZ_SCHEDULER_STATE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_SCHEDULER_STATE WHERE QRTZ_SCHEDULER_STATE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple QrtzSchedulerState records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_SCHEDULER_STATE WHERE QRTZ_SCHEDULER_STATE_id IN (<ids>)")
    @RegisterBeanMapper(QrtzSchedulerState.class)
    public List<QrtzSchedulerState> findByIds(@BindList("ids") Collection<Integer> ids);
}
