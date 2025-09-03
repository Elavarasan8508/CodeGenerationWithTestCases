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
import com.bsit.codegeneration.entity.FgCpUpload;

public interface FgCpUploadDao {

    /**
     * Inserts a new FgCpUpload and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_CP_UPLOAD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, UUID, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, FILE_NAME, CATEGORY_SUB_TYPE, TASK_REASON, UPLOAD_REF_ID, FORMAT_NAME, DISPLAY_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantPartyCode, :issuingPartyCode, :isTemplate, :uuid, :layoutTemplateId, :dmsEventId, :totalCount, :successCount, :errorCount, :entityTypeCode, :entitySubTypeCode, :layoutTemplateVersionId, :authLevelCode, :fileName, :categorySubType, :taskReason, :uploadRefId, :formatName, :displayStatus)")
    public int insert(@BindBean FgCpUpload fgcpupload);

    /**
     * Finds a FgCpUpload by its ID.
     */
    @SqlQuery("SELECT * FROM FG_CP_UPLOAD WHERE ID = :id")
    @RegisterBeanMapper(FgCpUpload.class)
    public Optional<FgCpUpload> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_CP_UPLOAD")
    @RegisterBeanMapper(FgCpUpload.class)
    public List<FgCpUpload> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_CP_UPLOAD ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgCpUpload.class)
    public List<FgCpUpload> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgCpUpload and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_CP_UPLOAD SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, IS_TEMPLATE = :isTemplate, UUID = :uuid, LAYOUT_TEMPLATE_ID = :layoutTemplateId, DMS_EVENT_ID = :dmsEventId, TOTAL_COUNT = :totalCount, SUCCESS_COUNT = :successCount, ERROR_COUNT = :errorCount, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, LAYOUT_TEMPLATE_VERSION_ID = :layoutTemplateVersionId, AUTH_LEVEL_CODE = :authLevelCode, FILE_NAME = :fileName, CATEGORY_SUB_TYPE = :categorySubType, TASK_REASON = :taskReason, UPLOAD_REF_ID = :uploadRefId, FORMAT_NAME = :formatName, DISPLAY_STATUS = :displayStatus WHERE ID = :id")
    public int update(@BindBean FgCpUpload fgcpupload);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CP_UPLOAD WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_CP_UPLOAD")
    public long countAll();

    /**
     * Bulk insert multiple FgCpUpload entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_CP_UPLOAD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, UUID, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, FILE_NAME, CATEGORY_SUB_TYPE, TASK_REASON, UPLOAD_REF_ID, FORMAT_NAME, DISPLAY_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantPartyCode, :issuingPartyCode, :isTemplate, :uuid, :layoutTemplateId, :dmsEventId, :totalCount, :successCount, :errorCount, :entityTypeCode, :entitySubTypeCode, :layoutTemplateVersionId, :authLevelCode, :fileName, :categorySubType, :taskReason, :uploadRefId, :formatName, :displayStatus)")
    public int[] bulkInsert(@BindBean List<FgCpUpload> fgcpuploads);

    /**
     * Bulk update multiple FgCpUpload entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_CP_UPLOAD SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, IS_TEMPLATE = :isTemplate, UUID = :uuid, LAYOUT_TEMPLATE_ID = :layoutTemplateId, DMS_EVENT_ID = :dmsEventId, TOTAL_COUNT = :totalCount, SUCCESS_COUNT = :successCount, ERROR_COUNT = :errorCount, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, LAYOUT_TEMPLATE_VERSION_ID = :layoutTemplateVersionId, AUTH_LEVEL_CODE = :authLevelCode, FILE_NAME = :fileName, CATEGORY_SUB_TYPE = :categorySubType, TASK_REASON = :taskReason, UPLOAD_REF_ID = :uploadRefId, FORMAT_NAME = :formatName, DISPLAY_STATUS = :displayStatus WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgCpUpload> fgcpuploads);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CP_UPLOAD WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_CP_UPLOAD WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgCpUpload records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_CP_UPLOAD WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgCpUpload.class)
    public List<FgCpUpload> findByIds(@BindList("ids") Collection<String> ids);
}
