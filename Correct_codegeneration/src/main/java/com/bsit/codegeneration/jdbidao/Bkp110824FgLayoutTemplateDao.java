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
import com.bsit.codegeneration.entity.Bkp110824FgLayoutTemplate;

public interface Bkp110824FgLayoutTemplateDao {

    /**
     * Inserts a new Bkp110824FgLayoutTemplate and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO BKP110824_FG_LAYOUT_TEMPLATE (ID, FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, CATEGORY, CONTENT, UUID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE, DEVICE_TYPE, VERSION_NO, MASTER_CONTENT_HASH, TEMPLATE_HASH) VALUES (:id, :fileExtension, :fileType, :name, :template, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :referenceId, :category, :content, :uuid, :categoryType, :categorySubType, :tags, :versionId, :isMasterVersion, :stageCode, :applicantPartyCode, :deviceType, :versionNo, :masterContentHash, :templateHash)")
    public int insert(@BindBean Bkp110824FgLayoutTemplate bkp110824fglayouttemplate);

    /**
     * Finds a Bkp110824FgLayoutTemplate by its ID.
     */
    @SqlQuery("SELECT * FROM BKP110824_FG_LAYOUT_TEMPLATE WHERE BKP110824_FG_LAYOUT_TEMPLATE_id = :id")
    @RegisterBeanMapper(Bkp110824FgLayoutTemplate.class)
    public Optional<Bkp110824FgLayoutTemplate> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM BKP110824_FG_LAYOUT_TEMPLATE")
    @RegisterBeanMapper(Bkp110824FgLayoutTemplate.class)
    public List<Bkp110824FgLayoutTemplate> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM BKP110824_FG_LAYOUT_TEMPLATE ORDER BY BKP110824_FG_LAYOUT_TEMPLATE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Bkp110824FgLayoutTemplate.class)
    public List<Bkp110824FgLayoutTemplate> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Bkp110824FgLayoutTemplate and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE BKP110824_FG_LAYOUT_TEMPLATE SET ID = :id, FILE_EXTENSION = :fileExtension, FILE_TYPE = :fileType, NAME = :name, TEMPLATE = :template, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, REFERENCE_ID = :referenceId, CATEGORY = :category, CONTENT = :content, UUID = :uuid, CATEGORY_TYPE = :categoryType, CATEGORY_SUB_TYPE = :categorySubType, TAGS = :tags, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, STAGE_CODE = :stageCode, APPLICANT_PARTY_CODE = :applicantPartyCode, DEVICE_TYPE = :deviceType, VERSION_NO = :versionNo, MASTER_CONTENT_HASH = :masterContentHash, TEMPLATE_HASH = :templateHash WHERE BKP110824_FG_LAYOUT_TEMPLATE_id = :bkp110824FgLayoutTemplateId")
    public int update(@BindBean Bkp110824FgLayoutTemplate bkp110824fglayouttemplate);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM BKP110824_FG_LAYOUT_TEMPLATE WHERE BKP110824_FG_LAYOUT_TEMPLATE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM BKP110824_FG_LAYOUT_TEMPLATE")
    public long countAll();

    /**
     * Bulk insert multiple Bkp110824FgLayoutTemplate entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO BKP110824_FG_LAYOUT_TEMPLATE (ID, FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, CATEGORY, CONTENT, UUID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE, DEVICE_TYPE, VERSION_NO, MASTER_CONTENT_HASH, TEMPLATE_HASH) VALUES (:id, :fileExtension, :fileType, :name, :template, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :referenceId, :category, :content, :uuid, :categoryType, :categorySubType, :tags, :versionId, :isMasterVersion, :stageCode, :applicantPartyCode, :deviceType, :versionNo, :masterContentHash, :templateHash)")
    public int[] bulkInsert(@BindBean List<Bkp110824FgLayoutTemplate> bkp110824fglayouttemplates);

    /**
     * Bulk update multiple Bkp110824FgLayoutTemplate entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE BKP110824_FG_LAYOUT_TEMPLATE SET ID = :id, FILE_EXTENSION = :fileExtension, FILE_TYPE = :fileType, NAME = :name, TEMPLATE = :template, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, REFERENCE_ID = :referenceId, CATEGORY = :category, CONTENT = :content, UUID = :uuid, CATEGORY_TYPE = :categoryType, CATEGORY_SUB_TYPE = :categorySubType, TAGS = :tags, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, STAGE_CODE = :stageCode, APPLICANT_PARTY_CODE = :applicantPartyCode, DEVICE_TYPE = :deviceType, VERSION_NO = :versionNo, MASTER_CONTENT_HASH = :masterContentHash, TEMPLATE_HASH = :templateHash WHERE BKP110824_FG_LAYOUT_TEMPLATE_id = :bkp110824FgLayoutTemplateId")
    public int[] bulkUpdate(@BindBean List<Bkp110824FgLayoutTemplate> bkp110824fglayouttemplates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM BKP110824_FG_LAYOUT_TEMPLATE WHERE BKP110824_FG_LAYOUT_TEMPLATE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM BKP110824_FG_LAYOUT_TEMPLATE WHERE BKP110824_FG_LAYOUT_TEMPLATE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Bkp110824FgLayoutTemplate records by their IDs.
     */
    @SqlQuery("SELECT * FROM BKP110824_FG_LAYOUT_TEMPLATE WHERE BKP110824_FG_LAYOUT_TEMPLATE_id IN (<ids>)")
    @RegisterBeanMapper(Bkp110824FgLayoutTemplate.class)
    public List<Bkp110824FgLayoutTemplate> findByIds(@BindList("ids") Collection<Integer> ids);
}
