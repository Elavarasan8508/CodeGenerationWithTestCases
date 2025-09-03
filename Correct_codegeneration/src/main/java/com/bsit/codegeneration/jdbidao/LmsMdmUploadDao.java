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
import com.bsit.codegeneration.entity.LmsMdmUpload;

public interface LmsMdmUploadDao {

    /**
     * Inserts a new LmsMdmUpload and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LMS_MDM_UPLOAD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_NAME, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, TASK_REASON, FILE_NAME, DISPLAY_STATUS, UPLOAD_REF_ID, ENTITY_NAME, TNX_TYPE_CODE, REVERSE_FILE_STATUS, SEGMENT_TEAMS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :layoutTemplateId, :dmsEventId, :totalCount, :successCount, :errorCount, :totalAmount, :totalSuccessAmount, :totalFailedAmount, :partyRoleCode, :entityTypeCode, :entitySubTypeCode, :fileStatus, :taskReasonCode, :taskReasonText, :warningCount, :layoutName, :layoutTemplateVersionId, :authLevelCode, :taskReason, :fileName, :displayStatus, :uploadRefId, :entityName, :tnxTypeCode, :reverseFileStatus, :segmentTeams)")
    public int insert(@BindBean LmsMdmUpload lmsmdmupload);

    /**
     * Finds a LmsMdmUpload by its ID.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_UPLOAD WHERE ID = :id")
    @RegisterBeanMapper(LmsMdmUpload.class)
    public Optional<LmsMdmUpload> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_UPLOAD")
    @RegisterBeanMapper(LmsMdmUpload.class)
    public List<LmsMdmUpload> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_UPLOAD ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LmsMdmUpload.class)
    public List<LmsMdmUpload> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LmsMdmUpload and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LMS_MDM_UPLOAD SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, LAYOUT_TEMPLATE_ID = :layoutTemplateId, DMS_EVENT_ID = :dmsEventId, TOTAL_COUNT = :totalCount, SUCCESS_COUNT = :successCount, ERROR_COUNT = :errorCount, TOTAL_AMOUNT = :totalAmount, TOTAL_SUCCESS_AMOUNT = :totalSuccessAmount, TOTAL_FAILED_AMOUNT = :totalFailedAmount, PARTY_ROLE_CODE = :partyRoleCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, FILE_STATUS = :fileStatus, TASK_REASON_CODE = :taskReasonCode, TASK_REASON_TEXT = :taskReasonText, WARNING_COUNT = :warningCount, LAYOUT_NAME = :layoutName, LAYOUT_TEMPLATE_VERSION_ID = :layoutTemplateVersionId, AUTH_LEVEL_CODE = :authLevelCode, TASK_REASON = :taskReason, FILE_NAME = :fileName, DISPLAY_STATUS = :displayStatus, UPLOAD_REF_ID = :uploadRefId, ENTITY_NAME = :entityName, TNX_TYPE_CODE = :tnxTypeCode, REVERSE_FILE_STATUS = :reverseFileStatus, SEGMENT_TEAMS = :segmentTeams WHERE ID = :id")
    public int update(@BindBean LmsMdmUpload lmsmdmupload);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_UPLOAD WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LMS_MDM_UPLOAD")
    public long countAll();

    /**
     * Bulk insert multiple LmsMdmUpload entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LMS_MDM_UPLOAD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_NAME, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, TASK_REASON, FILE_NAME, DISPLAY_STATUS, UPLOAD_REF_ID, ENTITY_NAME, TNX_TYPE_CODE, REVERSE_FILE_STATUS, SEGMENT_TEAMS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :layoutTemplateId, :dmsEventId, :totalCount, :successCount, :errorCount, :totalAmount, :totalSuccessAmount, :totalFailedAmount, :partyRoleCode, :entityTypeCode, :entitySubTypeCode, :fileStatus, :taskReasonCode, :taskReasonText, :warningCount, :layoutName, :layoutTemplateVersionId, :authLevelCode, :taskReason, :fileName, :displayStatus, :uploadRefId, :entityName, :tnxTypeCode, :reverseFileStatus, :segmentTeams)")
    public int[] bulkInsert(@BindBean List<LmsMdmUpload> lmsmdmuploads);

    /**
     * Bulk update multiple LmsMdmUpload entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LMS_MDM_UPLOAD SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, LAYOUT_TEMPLATE_ID = :layoutTemplateId, DMS_EVENT_ID = :dmsEventId, TOTAL_COUNT = :totalCount, SUCCESS_COUNT = :successCount, ERROR_COUNT = :errorCount, TOTAL_AMOUNT = :totalAmount, TOTAL_SUCCESS_AMOUNT = :totalSuccessAmount, TOTAL_FAILED_AMOUNT = :totalFailedAmount, PARTY_ROLE_CODE = :partyRoleCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, FILE_STATUS = :fileStatus, TASK_REASON_CODE = :taskReasonCode, TASK_REASON_TEXT = :taskReasonText, WARNING_COUNT = :warningCount, LAYOUT_NAME = :layoutName, LAYOUT_TEMPLATE_VERSION_ID = :layoutTemplateVersionId, AUTH_LEVEL_CODE = :authLevelCode, TASK_REASON = :taskReason, FILE_NAME = :fileName, DISPLAY_STATUS = :displayStatus, UPLOAD_REF_ID = :uploadRefId, ENTITY_NAME = :entityName, TNX_TYPE_CODE = :tnxTypeCode, REVERSE_FILE_STATUS = :reverseFileStatus, SEGMENT_TEAMS = :segmentTeams WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<LmsMdmUpload> lmsmdmuploads);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_UPLOAD WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LMS_MDM_UPLOAD WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple LmsMdmUpload records by their IDs.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_UPLOAD WHERE ID IN (<ids>)")
    @RegisterBeanMapper(LmsMdmUpload.class)
    public List<LmsMdmUpload> findByIds(@BindList("ids") Collection<String> ids);
}
