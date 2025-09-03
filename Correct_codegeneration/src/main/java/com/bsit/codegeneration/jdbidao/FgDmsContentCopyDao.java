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
import com.bsit.codegeneration.entity.FgDmsContentCopy;

public interface FgDmsContentCopyDao {

    /**
     * Inserts a new FgDmsContentCopy and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_DMS_CONTENT_COPY (ID, DMS_DOC_PATH, DMS_DOC_REFERENCE_ID, FILE_CONTENT, FILE_NAME, FILE_SIZE, FILE_TYPE, TITLE, DMS_EVENT_ID, DESCRIPTION, FILE_PURPOSE_CODE, DMS_REFERENCE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :dmsDocPath, :dmsDocReferenceId, :fileContent, :fileName, :fileSize, :fileType, :title, :dmsEventId, :description, :filePurposeCode, :dmsReference, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgDmsContentCopy fgdmscontentcopy);

    /**
     * Finds a FgDmsContentCopy by its ID.
     */
    @SqlQuery("SELECT * FROM FG_DMS_CONTENT_COPY WHERE FG_DMS_CONTENT_COPY_id = :id")
    @RegisterBeanMapper(FgDmsContentCopy.class)
    public Optional<FgDmsContentCopy> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_DMS_CONTENT_COPY")
    @RegisterBeanMapper(FgDmsContentCopy.class)
    public List<FgDmsContentCopy> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_DMS_CONTENT_COPY ORDER BY FG_DMS_CONTENT_COPY_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgDmsContentCopy.class)
    public List<FgDmsContentCopy> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgDmsContentCopy and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_DMS_CONTENT_COPY SET ID = :id, DMS_DOC_PATH = :dmsDocPath, DMS_DOC_REFERENCE_ID = :dmsDocReferenceId, FILE_CONTENT = :fileContent, FILE_NAME = :fileName, FILE_SIZE = :fileSize, FILE_TYPE = :fileType, TITLE = :title, DMS_EVENT_ID = :dmsEventId, DESCRIPTION = :description, FILE_PURPOSE_CODE = :filePurposeCode, DMS_REFERENCE = :dmsReference, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_DMS_CONTENT_COPY_id = :fgDmsContentCopyId")
    public int update(@BindBean FgDmsContentCopy fgdmscontentcopy);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DMS_CONTENT_COPY WHERE FG_DMS_CONTENT_COPY_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_DMS_CONTENT_COPY")
    public long countAll();

    /**
     * Bulk insert multiple FgDmsContentCopy entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_DMS_CONTENT_COPY (ID, DMS_DOC_PATH, DMS_DOC_REFERENCE_ID, FILE_CONTENT, FILE_NAME, FILE_SIZE, FILE_TYPE, TITLE, DMS_EVENT_ID, DESCRIPTION, FILE_PURPOSE_CODE, DMS_REFERENCE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :dmsDocPath, :dmsDocReferenceId, :fileContent, :fileName, :fileSize, :fileType, :title, :dmsEventId, :description, :filePurposeCode, :dmsReference, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgDmsContentCopy> fgdmscontentcopys);

    /**
     * Bulk update multiple FgDmsContentCopy entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_DMS_CONTENT_COPY SET ID = :id, DMS_DOC_PATH = :dmsDocPath, DMS_DOC_REFERENCE_ID = :dmsDocReferenceId, FILE_CONTENT = :fileContent, FILE_NAME = :fileName, FILE_SIZE = :fileSize, FILE_TYPE = :fileType, TITLE = :title, DMS_EVENT_ID = :dmsEventId, DESCRIPTION = :description, FILE_PURPOSE_CODE = :filePurposeCode, DMS_REFERENCE = :dmsReference, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_DMS_CONTENT_COPY_id = :fgDmsContentCopyId")
    public int[] bulkUpdate(@BindBean List<FgDmsContentCopy> fgdmscontentcopys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DMS_CONTENT_COPY WHERE FG_DMS_CONTENT_COPY_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_DMS_CONTENT_COPY WHERE FG_DMS_CONTENT_COPY_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgDmsContentCopy records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_DMS_CONTENT_COPY WHERE FG_DMS_CONTENT_COPY_id IN (<ids>)")
    @RegisterBeanMapper(FgDmsContentCopy.class)
    public List<FgDmsContentCopy> findByIds(@BindList("ids") Collection<Integer> ids);
}
