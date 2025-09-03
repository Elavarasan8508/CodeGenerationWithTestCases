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
import com.bsit.codegeneration.entity.FgPartyContent;

public interface FgPartyContentDao {

    /**
     * Inserts a new FgPartyContent and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_CONTENT (ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE, PARTY_CODE, CONTENT_TYPE_CODE, CONTENT_SUB_TYPE_CODE, CONTENT_DOC_NO, CONTENT_FILE_NAME, CONTENT_STORAGE_CODE, CONTENT_ATTACHMENT_ID, CONTENT_DMS_ID, CONTENT_DMS_URL, CONTENT_TAGS, COMMENTS, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :partyId, :partyVersionId, :partySubType, :partyCode, :contentTypeCode, :contentSubTypeCode, :contentDocNo, :contentFileName, :contentStorageCode, :contentAttachmentId, :contentDmsId, :contentDmsURL, :contentTags, :comments, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgPartyContent fgpartycontent);

    /**
     * Finds a FgPartyContent by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CONTENT WHERE FG_PARTY_CONTENT_id = :id")
    @RegisterBeanMapper(FgPartyContent.class)
    public Optional<FgPartyContent> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CONTENT")
    @RegisterBeanMapper(FgPartyContent.class)
    public List<FgPartyContent> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CONTENT ORDER BY FG_PARTY_CONTENT_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyContent.class)
    public List<FgPartyContent> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyContent and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_CONTENT SET ID = :id, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, PARTY_SUB_TYPE = :partySubType, PARTY_CODE = :partyCode, CONTENT_TYPE_CODE = :contentTypeCode, CONTENT_SUB_TYPE_CODE = :contentSubTypeCode, CONTENT_DOC_NO = :contentDocNo, CONTENT_FILE_NAME = :contentFileName, CONTENT_STORAGE_CODE = :contentStorageCode, CONTENT_ATTACHMENT_ID = :contentAttachmentId, CONTENT_DMS_ID = :contentDmsId, CONTENT_DMS_URL = :contentDmsURL, CONTENT_TAGS = :contentTags, COMMENTS = :comments, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_PARTY_CONTENT_id = :fgPartyContentId")
    public int update(@BindBean FgPartyContent fgpartycontent);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_CONTENT WHERE FG_PARTY_CONTENT_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_CONTENT")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyContent entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_CONTENT (ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE, PARTY_CODE, CONTENT_TYPE_CODE, CONTENT_SUB_TYPE_CODE, CONTENT_DOC_NO, CONTENT_FILE_NAME, CONTENT_STORAGE_CODE, CONTENT_ATTACHMENT_ID, CONTENT_DMS_ID, CONTENT_DMS_URL, CONTENT_TAGS, COMMENTS, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :partyId, :partyVersionId, :partySubType, :partyCode, :contentTypeCode, :contentSubTypeCode, :contentDocNo, :contentFileName, :contentStorageCode, :contentAttachmentId, :contentDmsId, :contentDmsURL, :contentTags, :comments, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgPartyContent> fgpartycontents);

    /**
     * Bulk update multiple FgPartyContent entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_CONTENT SET ID = :id, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, PARTY_SUB_TYPE = :partySubType, PARTY_CODE = :partyCode, CONTENT_TYPE_CODE = :contentTypeCode, CONTENT_SUB_TYPE_CODE = :contentSubTypeCode, CONTENT_DOC_NO = :contentDocNo, CONTENT_FILE_NAME = :contentFileName, CONTENT_STORAGE_CODE = :contentStorageCode, CONTENT_ATTACHMENT_ID = :contentAttachmentId, CONTENT_DMS_ID = :contentDmsId, CONTENT_DMS_URL = :contentDmsURL, CONTENT_TAGS = :contentTags, COMMENTS = :comments, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_PARTY_CONTENT_id = :fgPartyContentId")
    public int[] bulkUpdate(@BindBean List<FgPartyContent> fgpartycontents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_CONTENT WHERE FG_PARTY_CONTENT_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_CONTENT WHERE FG_PARTY_CONTENT_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgPartyContent records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CONTENT WHERE FG_PARTY_CONTENT_id IN (<ids>)")
    @RegisterBeanMapper(FgPartyContent.class)
    public List<FgPartyContent> findByIds(@BindList("ids") Collection<Integer> ids);
}
