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
import com.bsit.codegeneration.entity.QrtzSimpropTriggers;

public interface QrtzSimpropTriggersDao {

    /**
     * Inserts a new QrtzSimpropTriggers and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_SIMPROP_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, STR_PROP_1, STR_PROP_2, STR_PROP_3, INT_PROP_1, INT_PROP_2, LONG_PROP_1, LONG_PROP_2, DEC_PROP_1, DEC_PROP_2, BOOL_PROP_1, BOOL_PROP_2, TIME_ZONE_ID) VALUES (:schedName, :triggerName, :triggerGroup, :strProp1, :strProp2, :strProp3, :intProp1, :intProp2, :longProp1, :longProp2, :decProp1, :decProp2, :boolProp1, :boolProp2, :timeZoneId)")
    public int insert(@BindBean QrtzSimpropTriggers qrtzsimproptriggers);

    /**
     * Finds a QrtzSimpropTriggers by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPROP_TRIGGERS WHERE SCHED_NAME = :id")
    @RegisterBeanMapper(QrtzSimpropTriggers.class)
    public Optional<QrtzSimpropTriggers> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPROP_TRIGGERS")
    @RegisterBeanMapper(QrtzSimpropTriggers.class)
    public List<QrtzSimpropTriggers> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPROP_TRIGGERS ORDER BY SCHED_NAME LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzSimpropTriggers.class)
    public List<QrtzSimpropTriggers> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a QrtzSimpropTriggers and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE QRTZ_SIMPROP_TRIGGERS SET STR_PROP_1 = :strProp1, STR_PROP_2 = :strProp2, STR_PROP_3 = :strProp3, INT_PROP_1 = :intProp1, INT_PROP_2 = :intProp2, LONG_PROP_1 = :longProp1, LONG_PROP_2 = :longProp2, DEC_PROP_1 = :decProp1, DEC_PROP_2 = :decProp2, BOOL_PROP_1 = :boolProp1, BOOL_PROP_2 = :boolProp2, TIME_ZONE_ID = :timeZoneId WHERE SCHED_NAME = :schedName")
    public int update(@BindBean QrtzSimpropTriggers qrtzsimproptriggers);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_SIMPROP_TRIGGERS WHERE SCHED_NAME = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_SIMPROP_TRIGGERS")
    public long countAll();

    /**
     * Bulk insert multiple QrtzSimpropTriggers entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_SIMPROP_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, STR_PROP_1, STR_PROP_2, STR_PROP_3, INT_PROP_1, INT_PROP_2, LONG_PROP_1, LONG_PROP_2, DEC_PROP_1, DEC_PROP_2, BOOL_PROP_1, BOOL_PROP_2, TIME_ZONE_ID) VALUES (:schedName, :triggerName, :triggerGroup, :strProp1, :strProp2, :strProp3, :intProp1, :intProp2, :longProp1, :longProp2, :decProp1, :decProp2, :boolProp1, :boolProp2, :timeZoneId)")
    public int[] bulkInsert(@BindBean List<QrtzSimpropTriggers> qrtzsimproptriggerss);

    /**
     * Bulk update multiple QrtzSimpropTriggers entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_SIMPROP_TRIGGERS SET STR_PROP_1 = :strProp1, STR_PROP_2 = :strProp2, STR_PROP_3 = :strProp3, INT_PROP_1 = :intProp1, INT_PROP_2 = :intProp2, LONG_PROP_1 = :longProp1, LONG_PROP_2 = :longProp2, DEC_PROP_1 = :decProp1, DEC_PROP_2 = :decProp2, BOOL_PROP_1 = :boolProp1, BOOL_PROP_2 = :boolProp2, TIME_ZONE_ID = :timeZoneId WHERE SCHED_NAME = :schedName")
    public int[] bulkUpdate(@BindBean List<QrtzSimpropTriggers> qrtzsimproptriggerss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_SIMPROP_TRIGGERS WHERE SCHED_NAME IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_SIMPROP_TRIGGERS WHERE SCHED_NAME = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple QrtzSimpropTriggers records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPROP_TRIGGERS WHERE SCHED_NAME IN (<ids>)")
    @RegisterBeanMapper(QrtzSimpropTriggers.class)
    public List<QrtzSimpropTriggers> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all QrtzSimpropTriggers records by schedName.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPROP_TRIGGERS WHERE SCHED_NAME = :schedName")
    @RegisterBeanMapper(QrtzSimpropTriggers.class)
    public List<QrtzSimpropTriggers> findBySchedName(@Bind("schedName") int schedName);

    /**
     * Finds all QrtzSimpropTriggers records by triggerName.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPROP_TRIGGERS WHERE TRIGGER_NAME = :triggerName")
    @RegisterBeanMapper(QrtzSimpropTriggers.class)
    public List<QrtzSimpropTriggers> findByTriggerName(@Bind("triggerName") int triggerName);

    /**
     * Finds all QrtzSimpropTriggers records by triggerGroup.
     */
    @SqlQuery("SELECT * FROM QRTZ_SIMPROP_TRIGGERS WHERE TRIGGER_GROUP = :triggerGroup")
    @RegisterBeanMapper(QrtzSimpropTriggers.class)
    public List<QrtzSimpropTriggers> findByTriggerGroup(@Bind("triggerGroup") int triggerGroup);
}
