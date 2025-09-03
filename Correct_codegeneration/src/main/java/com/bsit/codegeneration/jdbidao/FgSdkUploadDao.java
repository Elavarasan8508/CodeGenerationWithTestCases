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
import com.bsit.codegeneration.entity.FgSdkUpload;

public interface FgSdkUploadDao {

    /**
     * Inserts a new FgSdkUpload and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SDK_UPLOAD (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, FINANCE_TYPE_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_NAME, PROGRAM_CODE, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_ID) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :layoutTemplateId, :dmsEventId, :totalCount, :successCount, :errorCount, :totalAmount, :totalSuccessAmount, :totalFailedAmount, :financeTypeCode, :financeDisplayStatus, :programName, :programCode, :partyRoleCode, :entityTypeCode, :entitySubTypeCode, :fileStatus, :taskReasonCode, :taskReasonText, :warningCount, :layoutId)")
    public int insert(@BindBean FgSdkUpload fgsdkupload);

    /**
     * Finds a FgSdkUpload by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD WHERE FG_SDK_UPLOAD_id = :id")
    @RegisterBeanMapper(FgSdkUpload.class)
    public Optional<FgSdkUpload> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD")
    @RegisterBeanMapper(FgSdkUpload.class)
    public List<FgSdkUpload> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD ORDER BY FG_SDK_UPLOAD_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSdkUpload.class)
    public List<FgSdkUpload> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSdkUpload and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SDK_UPLOAD SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, LAYOUT_TEMPLATE_ID = :layoutTemplateId, DMS_EVENT_ID = :dmsEventId, TOTAL_COUNT = :totalCount, SUCCESS_COUNT = :successCount, ERROR_COUNT = :errorCount, TOTAL_AMOUNT = :totalAmount, TOTAL_SUCCESS_AMOUNT = :totalSuccessAmount, TOTAL_FAILED_AMOUNT = :totalFailedAmount, FINANCE_TYPE_CODE = :financeTypeCode, FINANCE_DISPLAY_STATUS = :financeDisplayStatus, PROGRAM_NAME = :programName, PROGRAM_CODE = :programCode, PARTY_ROLE_CODE = :partyRoleCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, FILE_STATUS = :fileStatus, TASK_REASON_CODE = :taskReasonCode, TASK_REASON_TEXT = :taskReasonText, WARNING_COUNT = :warningCount, LAYOUT_ID = :layoutId WHERE FG_SDK_UPLOAD_id = :fgSdkUploadId")
    public int update(@BindBean FgSdkUpload fgsdkupload);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_UPLOAD WHERE FG_SDK_UPLOAD_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SDK_UPLOAD")
    public long countAll();

    /**
     * Bulk insert multiple FgSdkUpload entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SDK_UPLOAD (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, FINANCE_TYPE_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_NAME, PROGRAM_CODE, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_ID) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :layoutTemplateId, :dmsEventId, :totalCount, :successCount, :errorCount, :totalAmount, :totalSuccessAmount, :totalFailedAmount, :financeTypeCode, :financeDisplayStatus, :programName, :programCode, :partyRoleCode, :entityTypeCode, :entitySubTypeCode, :fileStatus, :taskReasonCode, :taskReasonText, :warningCount, :layoutId)")
    public int[] bulkInsert(@BindBean List<FgSdkUpload> fgsdkuploads);

    /**
     * Bulk update multiple FgSdkUpload entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SDK_UPLOAD SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, LAYOUT_TEMPLATE_ID = :layoutTemplateId, DMS_EVENT_ID = :dmsEventId, TOTAL_COUNT = :totalCount, SUCCESS_COUNT = :successCount, ERROR_COUNT = :errorCount, TOTAL_AMOUNT = :totalAmount, TOTAL_SUCCESS_AMOUNT = :totalSuccessAmount, TOTAL_FAILED_AMOUNT = :totalFailedAmount, FINANCE_TYPE_CODE = :financeTypeCode, FINANCE_DISPLAY_STATUS = :financeDisplayStatus, PROGRAM_NAME = :programName, PROGRAM_CODE = :programCode, PARTY_ROLE_CODE = :partyRoleCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, FILE_STATUS = :fileStatus, TASK_REASON_CODE = :taskReasonCode, TASK_REASON_TEXT = :taskReasonText, WARNING_COUNT = :warningCount, LAYOUT_ID = :layoutId WHERE FG_SDK_UPLOAD_id = :fgSdkUploadId")
    public int[] bulkUpdate(@BindBean List<FgSdkUpload> fgsdkuploads);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_UPLOAD WHERE FG_SDK_UPLOAD_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SDK_UPLOAD WHERE FG_SDK_UPLOAD_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgSdkUpload records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD WHERE FG_SDK_UPLOAD_id IN (<ids>)")
    @RegisterBeanMapper(FgSdkUpload.class)
    public List<FgSdkUpload> findByIds(@BindList("ids") Collection<Integer> ids);
}
