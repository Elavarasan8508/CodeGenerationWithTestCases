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
import com.bsit.codegeneration.entity.QrtzPausedTriggerGrps;

public interface QrtzPausedTriggerGrpsDao {

    /**
     * Inserts a new QrtzPausedTriggerGrps and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_PAUSED_TRIGGER_GRPS (SCHED_NAME, TRIGGER_GROUP) VALUES (:schedName, :triggerGroup)")
    public int insert(@Bind("schedName") String schedName, @Bind("triggerGroup") String triggerGroup);

    /**
     * Finds a QrtzPausedTriggerGrps by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_PAUSED_TRIGGER_GRPS WHERE SCHED_NAME = :id")
    @RegisterBeanMapper(QrtzPausedTriggerGrps.class)
    public Optional<QrtzPausedTriggerGrps> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_PAUSED_TRIGGER_GRPS")
    @RegisterBeanMapper(QrtzPausedTriggerGrps.class)
    public List<QrtzPausedTriggerGrps> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_PAUSED_TRIGGER_GRPS ORDER BY SCHED_NAME LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzPausedTriggerGrps.class)
    public List<QrtzPausedTriggerGrps> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_PAUSED_TRIGGER_GRPS WHERE SCHED_NAME = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_PAUSED_TRIGGER_GRPS")
    public long countAll();

    /**
     * Bulk insert multiple QrtzPausedTriggerGrps entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_PAUSED_TRIGGER_GRPS (SCHED_NAME, TRIGGER_GROUP) VALUES (:schedName, :triggerGroup)")
    public int[] bulkInsert(@BindBean List<QrtzPausedTriggerGrps> qrtzpausedtriggergrpss);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_PAUSED_TRIGGER_GRPS (SCHED_NAME, TRIGGER_GROUP) VALUES (:schedName, :triggerGroup)")
    public int[] bulkInsertParams(@Bind("schedName") List<String> schedNames, @Bind("triggerGroup") List<String> triggerGroups);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_PAUSED_TRIGGER_GRPS WHERE SCHED_NAME IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_PAUSED_TRIGGER_GRPS WHERE SCHED_NAME = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple QrtzPausedTriggerGrps records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_PAUSED_TRIGGER_GRPS WHERE SCHED_NAME IN (<ids>)")
    @RegisterBeanMapper(QrtzPausedTriggerGrps.class)
    public List<QrtzPausedTriggerGrps> findByIds(@BindList("ids") Collection<String> ids);
}
