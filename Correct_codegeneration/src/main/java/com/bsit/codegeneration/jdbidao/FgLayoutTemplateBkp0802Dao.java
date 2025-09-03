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
import com.bsit.codegeneration.entity.FgLayoutTemplateBkp0802;

public interface FgLayoutTemplateBkp0802Dao {

    /**
     * Inserts a new FgLayoutTemplateBkp0802 and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LAYOUT_TEMPLATE_BKP0802 (ID, FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, CATEGORY, CONTENT, UUID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE, DEVICE_TYPE, VERSION_NO, MASTER_CONTENT_HASH, TEMPLATE_HASH, MASTER_TEMPLATE) VALUES (:id, :fileExtension, :fileType, :name, :template, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :referenceId, :category, :content, :uuid, :categoryType, :categorySubType, :tags, :versionId, :isMasterVersion, :stageCode, :applicantPartyCode, :deviceType, :versionNo, :masterContentHash, :templateHash, :masterTemplate)")
    public int insert(@BindBean FgLayoutTemplateBkp0802 fglayouttemplatebkp0802);

    /**
     * Finds a FgLayoutTemplateBkp0802 by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_BKP0802 WHERE FG_LAYOUT_TEMPLATE_BKP0802_id = :id")
    @RegisterBeanMapper(FgLayoutTemplateBkp0802.class)
    public Optional<FgLayoutTemplateBkp0802> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_BKP0802")
    @RegisterBeanMapper(FgLayoutTemplateBkp0802.class)
    public List<FgLayoutTemplateBkp0802> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_BKP0802 ORDER BY FG_LAYOUT_TEMPLATE_BKP0802_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLayoutTemplateBkp0802.class)
    public List<FgLayoutTemplateBkp0802> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLayoutTemplateBkp0802 and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LAYOUT_TEMPLATE_BKP0802 SET ID = :id, FILE_EXTENSION = :fileExtension, FILE_TYPE = :fileType, NAME = :name, TEMPLATE = :template, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, REFERENCE_ID = :referenceId, CATEGORY = :category, CONTENT = :content, UUID = :uuid, CATEGORY_TYPE = :categoryType, CATEGORY_SUB_TYPE = :categorySubType, TAGS = :tags, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, STAGE_CODE = :stageCode, APPLICANT_PARTY_CODE = :applicantPartyCode, DEVICE_TYPE = :deviceType, VERSION_NO = :versionNo, MASTER_CONTENT_HASH = :masterContentHash, TEMPLATE_HASH = :templateHash, MASTER_TEMPLATE = :masterTemplate WHERE FG_LAYOUT_TEMPLATE_BKP0802_id = :fgLayoutTemplateBkp0802Id")
    public int update(@BindBean FgLayoutTemplateBkp0802 fglayouttemplatebkp0802);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_TEMPLATE_BKP0802 WHERE FG_LAYOUT_TEMPLATE_BKP0802_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LAYOUT_TEMPLATE_BKP0802")
    public long countAll();

    /**
     * Bulk insert multiple FgLayoutTemplateBkp0802 entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LAYOUT_TEMPLATE_BKP0802 (ID, FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, CATEGORY, CONTENT, UUID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE, DEVICE_TYPE, VERSION_NO, MASTER_CONTENT_HASH, TEMPLATE_HASH, MASTER_TEMPLATE) VALUES (:id, :fileExtension, :fileType, :name, :template, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :referenceId, :category, :content, :uuid, :categoryType, :categorySubType, :tags, :versionId, :isMasterVersion, :stageCode, :applicantPartyCode, :deviceType, :versionNo, :masterContentHash, :templateHash, :masterTemplate)")
    public int[] bulkInsert(@BindBean List<FgLayoutTemplateBkp0802> fglayouttemplatebkp0802s);

    /**
     * Bulk update multiple FgLayoutTemplateBkp0802 entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LAYOUT_TEMPLATE_BKP0802 SET ID = :id, FILE_EXTENSION = :fileExtension, FILE_TYPE = :fileType, NAME = :name, TEMPLATE = :template, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, REFERENCE_ID = :referenceId, CATEGORY = :category, CONTENT = :content, UUID = :uuid, CATEGORY_TYPE = :categoryType, CATEGORY_SUB_TYPE = :categorySubType, TAGS = :tags, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, STAGE_CODE = :stageCode, APPLICANT_PARTY_CODE = :applicantPartyCode, DEVICE_TYPE = :deviceType, VERSION_NO = :versionNo, MASTER_CONTENT_HASH = :masterContentHash, TEMPLATE_HASH = :templateHash, MASTER_TEMPLATE = :masterTemplate WHERE FG_LAYOUT_TEMPLATE_BKP0802_id = :fgLayoutTemplateBkp0802Id")
    public int[] bulkUpdate(@BindBean List<FgLayoutTemplateBkp0802> fglayouttemplatebkp0802s);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_TEMPLATE_BKP0802 WHERE FG_LAYOUT_TEMPLATE_BKP0802_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LAYOUT_TEMPLATE_BKP0802 WHERE FG_LAYOUT_TEMPLATE_BKP0802_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgLayoutTemplateBkp0802 records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_BKP0802 WHERE FG_LAYOUT_TEMPLATE_BKP0802_id IN (<ids>)")
    @RegisterBeanMapper(FgLayoutTemplateBkp0802.class)
    public List<FgLayoutTemplateBkp0802> findByIds(@BindList("ids") Collection<Integer> ids);
}
