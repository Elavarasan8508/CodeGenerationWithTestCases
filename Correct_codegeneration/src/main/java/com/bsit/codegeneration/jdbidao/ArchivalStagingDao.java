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
import com.bsit.codegeneration.entity.ArchivalStaging;

public interface ArchivalStagingDao {

    /**
     * Inserts a new ArchivalStaging and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO ARCHIVAL_STAGING (ARCHIVE_ROWID, TABLE_NAME, PURGE_STATUS) VALUES (:archiveRowid, :tableName, :purgeStatus)")
    public int insert(@Bind("archiveRowid") String archiveRowid, @Bind("tableName") String tableName, @Bind("purgeStatus") String purgeStatus);

    /**
     * Finds a ArchivalStaging by its ID.
     */
    @SqlQuery("SELECT * FROM ARCHIVAL_STAGING WHERE ARCHIVAL_STAGING_id = :id")
    @RegisterBeanMapper(ArchivalStaging.class)
    public Optional<ArchivalStaging> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM ARCHIVAL_STAGING")
    @RegisterBeanMapper(ArchivalStaging.class)
    public List<ArchivalStaging> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM ARCHIVAL_STAGING ORDER BY ARCHIVAL_STAGING_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(ArchivalStaging.class)
    public List<ArchivalStaging> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a ArchivalStaging and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE ARCHIVAL_STAGING SET ARCHIVE_ROWID = :archiveRowid, TABLE_NAME = :tableName, PURGE_STATUS = :purgeStatus WHERE ARCHIVAL_STAGING_id = :archivalStagingId")
    public int update(@BindBean ArchivalStaging archivalstaging);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM ARCHIVAL_STAGING WHERE ARCHIVAL_STAGING_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM ARCHIVAL_STAGING")
    public long countAll();

    /**
     * Bulk insert multiple ArchivalStaging entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO ARCHIVAL_STAGING (ARCHIVE_ROWID, TABLE_NAME, PURGE_STATUS) VALUES (:archiveRowid, :tableName, :purgeStatus)")
    public int[] bulkInsert(@BindBean List<ArchivalStaging> archivalstagings);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO ARCHIVAL_STAGING (ARCHIVE_ROWID, TABLE_NAME, PURGE_STATUS) VALUES (:archiveRowid, :tableName, :purgeStatus)")
    public int[] bulkInsertParams(@Bind("archiveRowid") List<String> archiveRowids, @Bind("tableName") List<String> tableNames, @Bind("purgeStatus") List<String> purgeStatuss);

    /**
     * Bulk update multiple ArchivalStaging entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE ARCHIVAL_STAGING SET ARCHIVE_ROWID = :archiveRowid, TABLE_NAME = :tableName, PURGE_STATUS = :purgeStatus WHERE ARCHIVAL_STAGING_id = :archivalStagingId")
    public int[] bulkUpdate(@BindBean List<ArchivalStaging> archivalstagings);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE ARCHIVAL_STAGING SET ARCHIVE_ROWID = :archiveRowid, TABLE_NAME = :tableName, PURGE_STATUS = :purgeStatus WHERE ARCHIVAL_STAGING_id = :archivalStagingId")
    public int[] bulkUpdateParams(@Bind("archiveRowid") List<String> archiveRowids, @Bind("tableName") List<String> tableNames, @Bind("purgeStatus") List<String> purgeStatuss, @Bind("archivalStagingId") List<Integer> archivalStagingIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM ARCHIVAL_STAGING WHERE ARCHIVAL_STAGING_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM ARCHIVAL_STAGING WHERE ARCHIVAL_STAGING_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple ArchivalStaging records by their IDs.
     */
    @SqlQuery("SELECT * FROM ARCHIVAL_STAGING WHERE ARCHIVAL_STAGING_id IN (<ids>)")
    @RegisterBeanMapper(ArchivalStaging.class)
    public List<ArchivalStaging> findByIds(@BindList("ids") Collection<Integer> ids);
}
