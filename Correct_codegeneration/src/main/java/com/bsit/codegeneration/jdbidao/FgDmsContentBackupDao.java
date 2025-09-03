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
import com.bsit.codegeneration.entity.FgDmsContentBackup;

public interface FgDmsContentBackupDao {

    /**
     * Inserts a new FgDmsContentBackup and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_DMS_CONTENT_BACKUP (ID, DMS_DOC_PATH, DMS_DOC_REFERENCE_ID, FILE_CONTENT, FILE_NAME, FILE_SIZE, FILE_TYPE, TITLE, DMS_EVENT_ID, DESCRIPTION, FILE_PURPOSE_CODE, DMS_REFERENCE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :dmsDocPath, :dmsDocReferenceId, :fileContent, :fileName, :fileSize, :fileType, :title, :dmsEventId, :description, :filePurposeCode, :dmsReference, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgDmsContentBackup fgdmscontentbackup);

    /**
     * Finds a FgDmsContentBackup by its ID.
     */
    @SqlQuery("SELECT * FROM FG_DMS_CONTENT_BACKUP WHERE FG_DMS_CONTENT_BACKUP_id = :id")
    @RegisterBeanMapper(FgDmsContentBackup.class)
    public Optional<FgDmsContentBackup> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_DMS_CONTENT_BACKUP")
    @RegisterBeanMapper(FgDmsContentBackup.class)
    public List<FgDmsContentBackup> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_DMS_CONTENT_BACKUP ORDER BY FG_DMS_CONTENT_BACKUP_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgDmsContentBackup.class)
    public List<FgDmsContentBackup> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgDmsContentBackup and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_DMS_CONTENT_BACKUP SET ID = :id, DMS_DOC_PATH = :dmsDocPath, DMS_DOC_REFERENCE_ID = :dmsDocReferenceId, FILE_CONTENT = :fileContent, FILE_NAME = :fileName, FILE_SIZE = :fileSize, FILE_TYPE = :fileType, TITLE = :title, DMS_EVENT_ID = :dmsEventId, DESCRIPTION = :description, FILE_PURPOSE_CODE = :filePurposeCode, DMS_REFERENCE = :dmsReference, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_DMS_CONTENT_BACKUP_id = :fgDmsContentBackupId")
    public int update(@BindBean FgDmsContentBackup fgdmscontentbackup);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DMS_CONTENT_BACKUP WHERE FG_DMS_CONTENT_BACKUP_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_DMS_CONTENT_BACKUP")
    public long countAll();

    /**
     * Bulk insert multiple FgDmsContentBackup entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_DMS_CONTENT_BACKUP (ID, DMS_DOC_PATH, DMS_DOC_REFERENCE_ID, FILE_CONTENT, FILE_NAME, FILE_SIZE, FILE_TYPE, TITLE, DMS_EVENT_ID, DESCRIPTION, FILE_PURPOSE_CODE, DMS_REFERENCE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :dmsDocPath, :dmsDocReferenceId, :fileContent, :fileName, :fileSize, :fileType, :title, :dmsEventId, :description, :filePurposeCode, :dmsReference, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgDmsContentBackup> fgdmscontentbackups);

    /**
     * Bulk update multiple FgDmsContentBackup entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_DMS_CONTENT_BACKUP SET ID = :id, DMS_DOC_PATH = :dmsDocPath, DMS_DOC_REFERENCE_ID = :dmsDocReferenceId, FILE_CONTENT = :fileContent, FILE_NAME = :fileName, FILE_SIZE = :fileSize, FILE_TYPE = :fileType, TITLE = :title, DMS_EVENT_ID = :dmsEventId, DESCRIPTION = :description, FILE_PURPOSE_CODE = :filePurposeCode, DMS_REFERENCE = :dmsReference, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_DMS_CONTENT_BACKUP_id = :fgDmsContentBackupId")
    public int[] bulkUpdate(@BindBean List<FgDmsContentBackup> fgdmscontentbackups);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DMS_CONTENT_BACKUP WHERE FG_DMS_CONTENT_BACKUP_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_DMS_CONTENT_BACKUP WHERE FG_DMS_CONTENT_BACKUP_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgDmsContentBackup records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_DMS_CONTENT_BACKUP WHERE FG_DMS_CONTENT_BACKUP_id IN (<ids>)")
    @RegisterBeanMapper(FgDmsContentBackup.class)
    public List<FgDmsContentBackup> findByIds(@BindList("ids") Collection<Integer> ids);
}
