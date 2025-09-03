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
import com.bsit.codegeneration.entity.FgTrdImpRegRqVer;

public interface FgTrdImpRegRqVerDao {

    /**
     * Inserts a new FgTrdImpRegRqVer and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_IMP_REG_RQ_VER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, IE_CODE, INVOICE_NUMBER, PORT_CODE, PRODUCT_STATUS, REQ_TYPE, PROCESS_ID, APPLICANT_PARTY, ISSUING_PARTY, DMS_EVENT_ID, CHECKBOX, ACK_MESSAGE, ACK_STATUS, NAME_MATCH, GENERAL_DETAILS, ATTACHMENTS, PREVIEW, STEPPER_COMPLETION_PERCENTAGE, TASK_REASON, BANK_USER_ID, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :boeNumber, :boeDate, :ieCode, :invoiceNumber, :portCode, :productStatus, :reqType, :processId, :applicantParty, :issuingParty, :dmsEventId, :checkbox, :ackMessage, :ackStatus, :nameMatch, :generalDetails, :attachments, :preview, :stepperCompletionPercentage, :taskReason, :bankUserId, :versionId, :isMasterVersion)")
    public int insert(@BindBean FgTrdImpRegRqVer fgtrdimpregrqver);

    /**
     * Finds a FgTrdImpRegRqVer by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_IMP_REG_RQ_VER WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgTrdImpRegRqVer.class)
    public Optional<FgTrdImpRegRqVer> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_IMP_REG_RQ_VER")
    @RegisterBeanMapper(FgTrdImpRegRqVer.class)
    public List<FgTrdImpRegRqVer> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_IMP_REG_RQ_VER ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdImpRegRqVer.class)
    public List<FgTrdImpRegRqVer> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdImpRegRqVer and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_IMP_REG_RQ_VER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, IE_CODE = :ieCode, INVOICE_NUMBER = :invoiceNumber, PORT_CODE = :portCode, PRODUCT_STATUS = :productStatus, REQ_TYPE = :reqType, PROCESS_ID = :processId, APPLICANT_PARTY = :applicantParty, ISSUING_PARTY = :issuingParty, DMS_EVENT_ID = :dmsEventId, CHECKBOX = :checkbox, ACK_MESSAGE = :ackMessage, ACK_STATUS = :ackStatus, NAME_MATCH = :nameMatch, GENERAL_DETAILS = :generalDetails, ATTACHMENTS = :attachments, PREVIEW = :preview, STEPPER_COMPLETION_PERCENTAGE = :stepperCompletionPercentage, TASK_REASON = :taskReason, BANK_USER_ID = :bankUserId, IS_MASTER_VERSION = :isMasterVersion WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgTrdImpRegRqVer fgtrdimpregrqver);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_IMP_REG_RQ_VER WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_IMP_REG_RQ_VER")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdImpRegRqVer entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_IMP_REG_RQ_VER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, IE_CODE, INVOICE_NUMBER, PORT_CODE, PRODUCT_STATUS, REQ_TYPE, PROCESS_ID, APPLICANT_PARTY, ISSUING_PARTY, DMS_EVENT_ID, CHECKBOX, ACK_MESSAGE, ACK_STATUS, NAME_MATCH, GENERAL_DETAILS, ATTACHMENTS, PREVIEW, STEPPER_COMPLETION_PERCENTAGE, TASK_REASON, BANK_USER_ID, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :boeNumber, :boeDate, :ieCode, :invoiceNumber, :portCode, :productStatus, :reqType, :processId, :applicantParty, :issuingParty, :dmsEventId, :checkbox, :ackMessage, :ackStatus, :nameMatch, :generalDetails, :attachments, :preview, :stepperCompletionPercentage, :taskReason, :bankUserId, :versionId, :isMasterVersion)")
    public int[] bulkInsert(@BindBean List<FgTrdImpRegRqVer> fgtrdimpregrqvers);

    /**
     * Bulk update multiple FgTrdImpRegRqVer entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_IMP_REG_RQ_VER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, IE_CODE = :ieCode, INVOICE_NUMBER = :invoiceNumber, PORT_CODE = :portCode, PRODUCT_STATUS = :productStatus, REQ_TYPE = :reqType, PROCESS_ID = :processId, APPLICANT_PARTY = :applicantParty, ISSUING_PARTY = :issuingParty, DMS_EVENT_ID = :dmsEventId, CHECKBOX = :checkbox, ACK_MESSAGE = :ackMessage, ACK_STATUS = :ackStatus, NAME_MATCH = :nameMatch, GENERAL_DETAILS = :generalDetails, ATTACHMENTS = :attachments, PREVIEW = :preview, STEPPER_COMPLETION_PERCENTAGE = :stepperCompletionPercentage, TASK_REASON = :taskReason, BANK_USER_ID = :bankUserId, IS_MASTER_VERSION = :isMasterVersion WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgTrdImpRegRqVer> fgtrdimpregrqvers);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_IMP_REG_RQ_VER WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_IMP_REG_RQ_VER WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdImpRegRqVer records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_IMP_REG_RQ_VER WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdImpRegRqVer.class)
    public List<FgTrdImpRegRqVer> findByIds(@BindList("ids") Collection<String> ids);
}
