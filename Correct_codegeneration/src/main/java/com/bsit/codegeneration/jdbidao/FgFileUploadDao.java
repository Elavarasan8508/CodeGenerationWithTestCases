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
import com.bsit.codegeneration.entity.FgFileUpload;

public interface FgFileUploadDao {

    /**
     * Inserts a new FgFileUpload and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_FILE_UPLOAD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FG_CLIENT_CODE, FG_FILLER_1, FG_FILLER_2, FG_FILLER_3, FG_FILE_NAME_HDR, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, FINANCE_TYPE_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_NAME, PROGRAM_CODE, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_NAME, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, PROCESS_ID, UPLOAD_REF_ID, IS_MASTER_VERSION, TASK_REASON, DISPLAY_STATUS, FG_SOURCE_CODE, FT_TOTAL_NO_OF_INSTRUCTIONS, FILE_NAME, FG_BATCH_REF_NUMBER, FG_PRODUCT_CODE, CATEGORY_SUB_TYPE, FG_INSTRUCTIONS_COUNT, FG_TOTAL_AMOUNT, FG_TOTAL_INSTRUMENTS, FT_TOTAL_INSTRUMENTS, FT_TOTAL_AMOUNT, FG_BATCH_DATE, FG_PAYMENT_DATE, UUID, ENTITY, ISSUERS_REF, EQU_CCY, EQU_AMOUNT, BLANKET_AMOUNT, TERMS, AUTH_EQU_CCY, AUTH_EQU_AMOUNT, AUTH_BLANKET_AMOUNT, DISPLAY_EQU_CCY, DISPLAY_EQU_AMOUNT, DISPLAY_BLANKET_AMOUNT, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, OPT_DECLARE, FILE_SOURCE, STREET_NAME, TOWN_NAME, COUNTRY_SUB_DIV, BANK_ABBV_NAME, OPTIONAL_DECLARATION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :fgClientCode, :fgFiller1, :fgFiller2, :fgFiller3, :fgFileNameHdr, :layoutTemplateId, :dmsEventId, :totalCount, :successCount, :errorCount, :totalAmount, :totalSuccessAmount, :totalFailedAmount, :financeTypeCode, :financeDisplayStatus, :programName, :programCode, :partyRoleCode, :entityTypeCode, :entitySubTypeCode, :fileStatus, :taskReasonCode, :taskReasonText, :warningCount, :layoutName, :layoutTemplateVersionId, :authLevelCode, :applicantRefId, :issuingPartyCode, :processId, :uploadRefId, :isMasterVersion, :taskReason, :displayStatus, :fgSourceCode, :ftTotalNoOfInstructions, :fileName, :fgBatchRefNumber, :fgProductCode, :categorySubType, :fgInstructionsCount, :fgTotalAmount, :fgTotalInstruments, :ftTotalInstruments, :ftTotalAmount, :fgBatchDate, :fgPaymentDate, :uuid, :entity, :issuersRef, :equCcy, :equAmount, :blanketAmount, :terms, :authEquCcy, :authEquAmount, :authBlanketAmount, :displayEquCcy, :displayEquAmount, :displayBlanketAmount, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :optDeclare, :fileSource, :streetName, :townName, :countrySubDiv, :bankAbbvName, :optionalDeclaration)")
    public int insert(@BindBean FgFileUpload fgfileupload);

    /**
     * Finds a FgFileUpload by its ID.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD WHERE ID = :id")
    @RegisterBeanMapper(FgFileUpload.class)
    public Optional<FgFileUpload> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD")
    @RegisterBeanMapper(FgFileUpload.class)
    public List<FgFileUpload> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgFileUpload.class)
    public List<FgFileUpload> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgFileUpload and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_FILE_UPLOAD SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, FG_CLIENT_CODE = :fgClientCode, FG_FILLER_1 = :fgFiller1, FG_FILLER_2 = :fgFiller2, FG_FILLER_3 = :fgFiller3, FG_FILE_NAME_HDR = :fgFileNameHdr, LAYOUT_TEMPLATE_ID = :layoutTemplateId, DMS_EVENT_ID = :dmsEventId, TOTAL_COUNT = :totalCount, SUCCESS_COUNT = :successCount, ERROR_COUNT = :errorCount, TOTAL_AMOUNT = :totalAmount, TOTAL_SUCCESS_AMOUNT = :totalSuccessAmount, TOTAL_FAILED_AMOUNT = :totalFailedAmount, FINANCE_TYPE_CODE = :financeTypeCode, FINANCE_DISPLAY_STATUS = :financeDisplayStatus, PROGRAM_NAME = :programName, PROGRAM_CODE = :programCode, PARTY_ROLE_CODE = :partyRoleCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, FILE_STATUS = :fileStatus, TASK_REASON_CODE = :taskReasonCode, TASK_REASON_TEXT = :taskReasonText, WARNING_COUNT = :warningCount, LAYOUT_NAME = :layoutName, LAYOUT_TEMPLATE_VERSION_ID = :layoutTemplateVersionId, AUTH_LEVEL_CODE = :authLevelCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, PROCESS_ID = :processId, UPLOAD_REF_ID = :uploadRefId, IS_MASTER_VERSION = :isMasterVersion, TASK_REASON = :taskReason, DISPLAY_STATUS = :displayStatus, FG_SOURCE_CODE = :fgSourceCode, FT_TOTAL_NO_OF_INSTRUCTIONS = :ftTotalNoOfInstructions, FILE_NAME = :fileName, FG_BATCH_REF_NUMBER = :fgBatchRefNumber, FG_PRODUCT_CODE = :fgProductCode, CATEGORY_SUB_TYPE = :categorySubType, FG_INSTRUCTIONS_COUNT = :fgInstructionsCount, FG_TOTAL_AMOUNT = :fgTotalAmount, FG_TOTAL_INSTRUMENTS = :fgTotalInstruments, FT_TOTAL_INSTRUMENTS = :ftTotalInstruments, FT_TOTAL_AMOUNT = :ftTotalAmount, FG_BATCH_DATE = :fgBatchDate, FG_PAYMENT_DATE = :fgPaymentDate, UUID = :uuid, ENTITY = :entity, ISSUERS_REF = :issuersRef, EQU_CCY = :equCcy, EQU_AMOUNT = :equAmount, BLANKET_AMOUNT = :blanketAmount, TERMS = :terms, AUTH_EQU_CCY = :authEquCcy, AUTH_EQU_AMOUNT = :authEquAmount, AUTH_BLANKET_AMOUNT = :authBlanketAmount, DISPLAY_EQU_CCY = :displayEquCcy, DISPLAY_EQU_AMOUNT = :displayEquAmount, DISPLAY_BLANKET_AMOUNT = :displayBlanketAmount, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, OPT_DECLARE = :optDeclare, FILE_SOURCE = :fileSource, STREET_NAME = :streetName, TOWN_NAME = :townName, COUNTRY_SUB_DIV = :countrySubDiv, BANK_ABBV_NAME = :bankAbbvName, OPTIONAL_DECLARATION = :optionalDeclaration WHERE ID = :id")
    public int update(@BindBean FgFileUpload fgfileupload);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FILE_UPLOAD WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_FILE_UPLOAD")
    public long countAll();

    /**
     * Bulk insert multiple FgFileUpload entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_FILE_UPLOAD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FG_CLIENT_CODE, FG_FILLER_1, FG_FILLER_2, FG_FILLER_3, FG_FILE_NAME_HDR, LAYOUT_TEMPLATE_ID, DMS_EVENT_ID, TOTAL_COUNT, SUCCESS_COUNT, ERROR_COUNT, TOTAL_AMOUNT, TOTAL_SUCCESS_AMOUNT, TOTAL_FAILED_AMOUNT, FINANCE_TYPE_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_NAME, PROGRAM_CODE, PARTY_ROLE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, FILE_STATUS, TASK_REASON_CODE, TASK_REASON_TEXT, WARNING_COUNT, LAYOUT_NAME, LAYOUT_TEMPLATE_VERSION_ID, AUTH_LEVEL_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, PROCESS_ID, UPLOAD_REF_ID, IS_MASTER_VERSION, TASK_REASON, DISPLAY_STATUS, FG_SOURCE_CODE, FT_TOTAL_NO_OF_INSTRUCTIONS, FILE_NAME, FG_BATCH_REF_NUMBER, FG_PRODUCT_CODE, CATEGORY_SUB_TYPE, FG_INSTRUCTIONS_COUNT, FG_TOTAL_AMOUNT, FG_TOTAL_INSTRUMENTS, FT_TOTAL_INSTRUMENTS, FT_TOTAL_AMOUNT, FG_BATCH_DATE, FG_PAYMENT_DATE, UUID, ENTITY, ISSUERS_REF, EQU_CCY, EQU_AMOUNT, BLANKET_AMOUNT, TERMS, AUTH_EQU_CCY, AUTH_EQU_AMOUNT, AUTH_BLANKET_AMOUNT, DISPLAY_EQU_CCY, DISPLAY_EQU_AMOUNT, DISPLAY_BLANKET_AMOUNT, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, OPT_DECLARE, FILE_SOURCE, STREET_NAME, TOWN_NAME, COUNTRY_SUB_DIV, BANK_ABBV_NAME, OPTIONAL_DECLARATION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :fgClientCode, :fgFiller1, :fgFiller2, :fgFiller3, :fgFileNameHdr, :layoutTemplateId, :dmsEventId, :totalCount, :successCount, :errorCount, :totalAmount, :totalSuccessAmount, :totalFailedAmount, :financeTypeCode, :financeDisplayStatus, :programName, :programCode, :partyRoleCode, :entityTypeCode, :entitySubTypeCode, :fileStatus, :taskReasonCode, :taskReasonText, :warningCount, :layoutName, :layoutTemplateVersionId, :authLevelCode, :applicantRefId, :issuingPartyCode, :processId, :uploadRefId, :isMasterVersion, :taskReason, :displayStatus, :fgSourceCode, :ftTotalNoOfInstructions, :fileName, :fgBatchRefNumber, :fgProductCode, :categorySubType, :fgInstructionsCount, :fgTotalAmount, :fgTotalInstruments, :ftTotalInstruments, :ftTotalAmount, :fgBatchDate, :fgPaymentDate, :uuid, :entity, :issuersRef, :equCcy, :equAmount, :blanketAmount, :terms, :authEquCcy, :authEquAmount, :authBlanketAmount, :displayEquCcy, :displayEquAmount, :displayBlanketAmount, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :optDeclare, :fileSource, :streetName, :townName, :countrySubDiv, :bankAbbvName, :optionalDeclaration)")
    public int[] bulkInsert(@BindBean List<FgFileUpload> fgfileuploads);

    /**
     * Bulk update multiple FgFileUpload entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_FILE_UPLOAD SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, FG_CLIENT_CODE = :fgClientCode, FG_FILLER_1 = :fgFiller1, FG_FILLER_2 = :fgFiller2, FG_FILLER_3 = :fgFiller3, FG_FILE_NAME_HDR = :fgFileNameHdr, LAYOUT_TEMPLATE_ID = :layoutTemplateId, DMS_EVENT_ID = :dmsEventId, TOTAL_COUNT = :totalCount, SUCCESS_COUNT = :successCount, ERROR_COUNT = :errorCount, TOTAL_AMOUNT = :totalAmount, TOTAL_SUCCESS_AMOUNT = :totalSuccessAmount, TOTAL_FAILED_AMOUNT = :totalFailedAmount, FINANCE_TYPE_CODE = :financeTypeCode, FINANCE_DISPLAY_STATUS = :financeDisplayStatus, PROGRAM_NAME = :programName, PROGRAM_CODE = :programCode, PARTY_ROLE_CODE = :partyRoleCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, FILE_STATUS = :fileStatus, TASK_REASON_CODE = :taskReasonCode, TASK_REASON_TEXT = :taskReasonText, WARNING_COUNT = :warningCount, LAYOUT_NAME = :layoutName, LAYOUT_TEMPLATE_VERSION_ID = :layoutTemplateVersionId, AUTH_LEVEL_CODE = :authLevelCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, PROCESS_ID = :processId, UPLOAD_REF_ID = :uploadRefId, IS_MASTER_VERSION = :isMasterVersion, TASK_REASON = :taskReason, DISPLAY_STATUS = :displayStatus, FG_SOURCE_CODE = :fgSourceCode, FT_TOTAL_NO_OF_INSTRUCTIONS = :ftTotalNoOfInstructions, FILE_NAME = :fileName, FG_BATCH_REF_NUMBER = :fgBatchRefNumber, FG_PRODUCT_CODE = :fgProductCode, CATEGORY_SUB_TYPE = :categorySubType, FG_INSTRUCTIONS_COUNT = :fgInstructionsCount, FG_TOTAL_AMOUNT = :fgTotalAmount, FG_TOTAL_INSTRUMENTS = :fgTotalInstruments, FT_TOTAL_INSTRUMENTS = :ftTotalInstruments, FT_TOTAL_AMOUNT = :ftTotalAmount, FG_BATCH_DATE = :fgBatchDate, FG_PAYMENT_DATE = :fgPaymentDate, UUID = :uuid, ENTITY = :entity, ISSUERS_REF = :issuersRef, EQU_CCY = :equCcy, EQU_AMOUNT = :equAmount, BLANKET_AMOUNT = :blanketAmount, TERMS = :terms, AUTH_EQU_CCY = :authEquCcy, AUTH_EQU_AMOUNT = :authEquAmount, AUTH_BLANKET_AMOUNT = :authBlanketAmount, DISPLAY_EQU_CCY = :displayEquCcy, DISPLAY_EQU_AMOUNT = :displayEquAmount, DISPLAY_BLANKET_AMOUNT = :displayBlanketAmount, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, OPT_DECLARE = :optDeclare, FILE_SOURCE = :fileSource, STREET_NAME = :streetName, TOWN_NAME = :townName, COUNTRY_SUB_DIV = :countrySubDiv, BANK_ABBV_NAME = :bankAbbvName, OPTIONAL_DECLARATION = :optionalDeclaration WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgFileUpload> fgfileuploads);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FILE_UPLOAD WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_FILE_UPLOAD WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgFileUpload records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgFileUpload.class)
    public List<FgFileUpload> findByIds(@BindList("ids") Collection<String> ids);
}
