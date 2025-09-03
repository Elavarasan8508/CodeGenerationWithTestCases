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
import com.bsit.codegeneration.entity.QrtzLocks;

public interface QrtzLocksDao {

    /**
     * Inserts a new QrtzLocks and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO QRTZ_LOCKS (SCHED_NAME, LOCK_NAME) VALUES (:schedName, :lockName)")
    public int insert(@Bind("schedName") String schedName, @Bind("lockName") String lockName);

    /**
     * Finds a QrtzLocks by its ID.
     */
    @SqlQuery("SELECT * FROM QRTZ_LOCKS WHERE LOCK_NAME = :id")
    @RegisterBeanMapper(QrtzLocks.class)
    public Optional<QrtzLocks> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM QRTZ_LOCKS")
    @RegisterBeanMapper(QrtzLocks.class)
    public List<QrtzLocks> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM QRTZ_LOCKS ORDER BY LOCK_NAME LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(QrtzLocks.class)
    public List<QrtzLocks> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_LOCKS WHERE LOCK_NAME = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM QRTZ_LOCKS")
    public long countAll();

    /**
     * Bulk insert multiple QrtzLocks entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_LOCKS (SCHED_NAME, LOCK_NAME) VALUES (:schedName, :lockName)")
    public int[] bulkInsert(@BindBean List<QrtzLocks> qrtzlockss);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO QRTZ_LOCKS (SCHED_NAME, LOCK_NAME) VALUES (:schedName, :lockName)")
    public int[] bulkInsertParams(@Bind("schedName") List<String> schedNames, @Bind("lockName") List<String> lockNames);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM QRTZ_LOCKS WHERE LOCK_NAME IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM QRTZ_LOCKS WHERE LOCK_NAME = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple QrtzLocks records by their IDs.
     */
    @SqlQuery("SELECT * FROM QRTZ_LOCKS WHERE LOCK_NAME IN (<ids>)")
    @RegisterBeanMapper(QrtzLocks.class)
    public List<QrtzLocks> findByIds(@BindList("ids") Collection<String> ids);
}
