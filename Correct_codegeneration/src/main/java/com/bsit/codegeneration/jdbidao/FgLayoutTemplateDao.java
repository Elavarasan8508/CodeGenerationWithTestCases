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
import com.bsit.codegeneration.entity.FgLayoutTemplate;

public interface FgLayoutTemplateDao {

    /**
     * Inserts a new FgLayoutTemplate and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LAYOUT_TEMPLATE (ID, FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, CATEGORY, CONTENT, UUID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE, DEVICE_TYPE, VERSION_NO, MASTER_CONTENT_HASH, TEMPLATE_HASH, MASTER_TEMPLATE) VALUES (:id, :fileExtension, :fileType, :name, :template, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :referenceId, :category, :content, :uuid, :categoryType, :categorySubType, :tags, :versionId, :isMasterVersion, :stageCode, :applicantPartyCode, :deviceType, :versionNo, :masterContentHash, :templateHash, :masterTemplate)")
    public int insert(@BindBean FgLayoutTemplate fglayouttemplate);

    /**
     * Finds a FgLayoutTemplate by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgLayoutTemplate.class)
    public Optional<FgLayoutTemplate> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE")
    @RegisterBeanMapper(FgLayoutTemplate.class)
    public List<FgLayoutTemplate> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLayoutTemplate.class)
    public List<FgLayoutTemplate> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLayoutTemplate and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LAYOUT_TEMPLATE SET FILE_EXTENSION = :fileExtension, FILE_TYPE = :fileType, NAME = :name, TEMPLATE = :template, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, REFERENCE_ID = :referenceId, CATEGORY = :category, CONTENT = :content, UUID = :uuid, CATEGORY_TYPE = :categoryType, CATEGORY_SUB_TYPE = :categorySubType, TAGS = :tags, IS_MASTER_VERSION = :isMasterVersion, STAGE_CODE = :stageCode, APPLICANT_PARTY_CODE = :applicantPartyCode, DEVICE_TYPE = :deviceType, VERSION_NO = :versionNo, MASTER_CONTENT_HASH = :masterContentHash, TEMPLATE_HASH = :templateHash, MASTER_TEMPLATE = :masterTemplate WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgLayoutTemplate fglayouttemplate);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_TEMPLATE WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LAYOUT_TEMPLATE")
    public long countAll();

    /**
     * Bulk insert multiple FgLayoutTemplate entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LAYOUT_TEMPLATE (ID, FILE_EXTENSION, FILE_TYPE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, CATEGORY, CONTENT, UUID, CATEGORY_TYPE, CATEGORY_SUB_TYPE, TAGS, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE, DEVICE_TYPE, VERSION_NO, MASTER_CONTENT_HASH, TEMPLATE_HASH, MASTER_TEMPLATE) VALUES (:id, :fileExtension, :fileType, :name, :template, :typeCode, :subTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :referenceId, :category, :content, :uuid, :categoryType, :categorySubType, :tags, :versionId, :isMasterVersion, :stageCode, :applicantPartyCode, :deviceType, :versionNo, :masterContentHash, :templateHash, :masterTemplate)")
    public int[] bulkInsert(@BindBean List<FgLayoutTemplate> fglayouttemplates);

    /**
     * Bulk update multiple FgLayoutTemplate entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LAYOUT_TEMPLATE SET FILE_EXTENSION = :fileExtension, FILE_TYPE = :fileType, NAME = :name, TEMPLATE = :template, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, REFERENCE_ID = :referenceId, CATEGORY = :category, CONTENT = :content, UUID = :uuid, CATEGORY_TYPE = :categoryType, CATEGORY_SUB_TYPE = :categorySubType, TAGS = :tags, IS_MASTER_VERSION = :isMasterVersion, STAGE_CODE = :stageCode, APPLICANT_PARTY_CODE = :applicantPartyCode, DEVICE_TYPE = :deviceType, VERSION_NO = :versionNo, MASTER_CONTENT_HASH = :masterContentHash, TEMPLATE_HASH = :templateHash, MASTER_TEMPLATE = :masterTemplate WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgLayoutTemplate> fglayouttemplates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_TEMPLATE WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LAYOUT_TEMPLATE WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgLayoutTemplate records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgLayoutTemplate.class)
    public List<FgLayoutTemplate> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
