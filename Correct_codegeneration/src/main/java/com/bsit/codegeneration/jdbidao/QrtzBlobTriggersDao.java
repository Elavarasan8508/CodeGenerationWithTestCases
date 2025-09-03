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
import com.bsit.codegeneration.entity.QrtzBlobTriggers;

public interface QrtzBlobTriggersDao {

    /**
     * Inserts a new QrtzBlobTriggers and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_BLOB_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, BLOB_DATA) VALUES (:schedName, :triggerName, :triggerGroup, :blobData)")
    public int insert(@BindBean QrtzBlobTriggers qrtzblobtriggers);

    /**
     * Finds a QrtzBlobTriggers by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_BLOB_TRIGGERS WHERE SCHED_NAME = :id")
    @RegisterBeanMapper(QrtzBlobTriggers.class)
    public Optional<QrtzBlobTriggers> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_BLOB_TRIGGERS")
    @RegisterBeanMapper(QrtzBlobTriggers.class)
    public List<QrtzBlobTriggers> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_BLOB_TRIGGERS ORDER BY SCHED_NAME LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzBlobTriggers.class)
    public List<QrtzBlobTriggers> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a QrtzBlobTriggers and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE QRTZ_BLOB_TRIGGERS SET BLOB_DATA = :blobData WHERE SCHED_NAME = :schedName")
    public int update(@BindBean QrtzBlobTriggers qrtzblobtriggers);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_BLOB_TRIGGERS WHERE SCHED_NAME = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_BLOB_TRIGGERS")
    public long countAll();

    /**
     * Bulk insert multiple QrtzBlobTriggers entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_BLOB_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, BLOB_DATA) VALUES (:schedName, :triggerName, :triggerGroup, :blobData)")
    public int[] bulkInsert(@BindBean List<QrtzBlobTriggers> qrtzblobtriggerss);

    /**
     * Bulk update multiple QrtzBlobTriggers entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_BLOB_TRIGGERS SET BLOB_DATA = :blobData WHERE SCHED_NAME = :schedName")
    public int[] bulkUpdate(@BindBean List<QrtzBlobTriggers> qrtzblobtriggerss);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE QRTZ_BLOB_TRIGGERS SET BLOB_DATA = :blobData WHERE SCHED_NAME = :schedName")
    public int[] bulkUpdateParams(@Bind("blobData") List<byte[]> blobDatas, @Bind("schedName") List<Integer> schedNames);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_BLOB_TRIGGERS WHERE SCHED_NAME IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_BLOB_TRIGGERS WHERE SCHED_NAME = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple QrtzBlobTriggers records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_BLOB_TRIGGERS WHERE SCHED_NAME IN (<ids>)")
    @RegisterBeanMapper(QrtzBlobTriggers.class)
    public List<QrtzBlobTriggers> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all QrtzBlobTriggers records by schedName.
     */
    @SqlQuery("SELECT * FROM QRTZ_BLOB_TRIGGERS WHERE SCHED_NAME = :schedName")
    @RegisterBeanMapper(QrtzBlobTriggers.class)
    public List<QrtzBlobTriggers> findBySchedName(@Bind("schedName") int schedName);

    /**
     * Finds all QrtzBlobTriggers records by triggerName.
     */
    @SqlQuery("SELECT * FROM QRTZ_BLOB_TRIGGERS WHERE TRIGGER_NAME = :triggerName")
    @RegisterBeanMapper(QrtzBlobTriggers.class)
    public List<QrtzBlobTriggers> findByTriggerName(@Bind("triggerName") int triggerName);

    /**
     * Finds all QrtzBlobTriggers records by triggerGroup.
     */
    @SqlQuery("SELECT * FROM QRTZ_BLOB_TRIGGERS WHERE TRIGGER_GROUP = :triggerGroup")
    @RegisterBeanMapper(QrtzBlobTriggers.class)
    public List<QrtzBlobTriggers> findByTriggerGroup(@Bind("triggerGroup") int triggerGroup);
}
