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
import com.bsit.codegeneration.entity.LosLoanReqEvent;

public interface LosLoanReqEventDao {

    /**
     * Inserts a new LosLoanReqEvent and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LOS_LOAN_REQ_EVENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, EVENT_COMMENTS, EVENT_DUE_DATE, EVENT_RESPONDED_ON, EVENT_COMPLETED_OM, EVENT_EXPIRED_ON, UPLOAD_REF_ID, REJECTION_REASON_CODE, REJECTION_COMMENTS, EVENT_CATEGORY_CODE, EVENT_TYPE_CODE, EVENT_OCCURRED_ON, EVENT_TRIGGER_ROLE, ACTION_COMMENTS, ACTION_REQUIRED_FLAG, ACTION_TYPE_CODE, ACTION_STATUS_CODE, ACTION_PERFORMER_ROLE, LOAN_REQUEST_REFERENCE, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE, VERSION_ID, IS_MASTER_VERSION, EVENT_SUBJECT, PRODUCT_STATUS_CODE, ACCEPTANCE_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :eventComments, :eventDueDate, :eventRespondedOn, :eventCompletedOm, :eventExpiredOn, :uploadRefId, :rejectionReasonCode, :rejectionComments, :eventCategoryCode, :eventTypeCode, :eventOccurredOn, :eventTriggerRole, :actionComments, :actionRequiredFlag, :actionTypeCode, :actionStatusCode, :actionPerformerRole, :loanRequestReference, :productCode, :subProductCode, :segmentCode, :versionId, :isMasterVersion, :eventSubject, :productStatusCode, :acceptanceParty)")
    public int insert(@BindBean LosLoanReqEvent losloanreqevent);

    /**
     * Finds a LosLoanReqEvent by its ID.
     */
    @SqlQuery("SELECT * FROM LOS_LOAN_REQ_EVENT WHERE VERSION_ID = :id")
    @RegisterBeanMapper(LosLoanReqEvent.class)
    public Optional<LosLoanReqEvent> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LOS_LOAN_REQ_EVENT")
    @RegisterBeanMapper(LosLoanReqEvent.class)
    public List<LosLoanReqEvent> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LOS_LOAN_REQ_EVENT ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LosLoanReqEvent.class)
    public List<LosLoanReqEvent> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LosLoanReqEvent and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LOS_LOAN_REQ_EVENT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, EVENT_COMMENTS = :eventComments, EVENT_DUE_DATE = :eventDueDate, EVENT_RESPONDED_ON = :eventRespondedOn, EVENT_COMPLETED_OM = :eventCompletedOm, EVENT_EXPIRED_ON = :eventExpiredOn, UPLOAD_REF_ID = :uploadRefId, REJECTION_REASON_CODE = :rejectionReasonCode, REJECTION_COMMENTS = :rejectionComments, EVENT_CATEGORY_CODE = :eventCategoryCode, EVENT_TYPE_CODE = :eventTypeCode, EVENT_OCCURRED_ON = :eventOccurredOn, EVENT_TRIGGER_ROLE = :eventTriggerRole, ACTION_COMMENTS = :actionComments, ACTION_REQUIRED_FLAG = :actionRequiredFlag, ACTION_TYPE_CODE = :actionTypeCode, ACTION_STATUS_CODE = :actionStatusCode, ACTION_PERFORMER_ROLE = :actionPerformerRole, LOAN_REQUEST_REFERENCE = :loanRequestReference, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode, SEGMENT_CODE = :segmentCode, IS_MASTER_VERSION = :isMasterVersion, EVENT_SUBJECT = :eventSubject, PRODUCT_STATUS_CODE = :productStatusCode, ACCEPTANCE_PARTY = :acceptanceParty WHERE VERSION_ID = :versionId")
    public int update(@BindBean LosLoanReqEvent losloanreqevent);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LOS_LOAN_REQ_EVENT WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LOS_LOAN_REQ_EVENT")
    public long countAll();

    /**
     * Bulk insert multiple LosLoanReqEvent entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LOS_LOAN_REQ_EVENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, EVENT_COMMENTS, EVENT_DUE_DATE, EVENT_RESPONDED_ON, EVENT_COMPLETED_OM, EVENT_EXPIRED_ON, UPLOAD_REF_ID, REJECTION_REASON_CODE, REJECTION_COMMENTS, EVENT_CATEGORY_CODE, EVENT_TYPE_CODE, EVENT_OCCURRED_ON, EVENT_TRIGGER_ROLE, ACTION_COMMENTS, ACTION_REQUIRED_FLAG, ACTION_TYPE_CODE, ACTION_STATUS_CODE, ACTION_PERFORMER_ROLE, LOAN_REQUEST_REFERENCE, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE, VERSION_ID, IS_MASTER_VERSION, EVENT_SUBJECT, PRODUCT_STATUS_CODE, ACCEPTANCE_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :eventComments, :eventDueDate, :eventRespondedOn, :eventCompletedOm, :eventExpiredOn, :uploadRefId, :rejectionReasonCode, :rejectionComments, :eventCategoryCode, :eventTypeCode, :eventOccurredOn, :eventTriggerRole, :actionComments, :actionRequiredFlag, :actionTypeCode, :actionStatusCode, :actionPerformerRole, :loanRequestReference, :productCode, :subProductCode, :segmentCode, :versionId, :isMasterVersion, :eventSubject, :productStatusCode, :acceptanceParty)")
    public int[] bulkInsert(@BindBean List<LosLoanReqEvent> losloanreqevents);

    /**
     * Bulk update multiple LosLoanReqEvent entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LOS_LOAN_REQ_EVENT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, EVENT_COMMENTS = :eventComments, EVENT_DUE_DATE = :eventDueDate, EVENT_RESPONDED_ON = :eventRespondedOn, EVENT_COMPLETED_OM = :eventCompletedOm, EVENT_EXPIRED_ON = :eventExpiredOn, UPLOAD_REF_ID = :uploadRefId, REJECTION_REASON_CODE = :rejectionReasonCode, REJECTION_COMMENTS = :rejectionComments, EVENT_CATEGORY_CODE = :eventCategoryCode, EVENT_TYPE_CODE = :eventTypeCode, EVENT_OCCURRED_ON = :eventOccurredOn, EVENT_TRIGGER_ROLE = :eventTriggerRole, ACTION_COMMENTS = :actionComments, ACTION_REQUIRED_FLAG = :actionRequiredFlag, ACTION_TYPE_CODE = :actionTypeCode, ACTION_STATUS_CODE = :actionStatusCode, ACTION_PERFORMER_ROLE = :actionPerformerRole, LOAN_REQUEST_REFERENCE = :loanRequestReference, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode, SEGMENT_CODE = :segmentCode, IS_MASTER_VERSION = :isMasterVersion, EVENT_SUBJECT = :eventSubject, PRODUCT_STATUS_CODE = :productStatusCode, ACCEPTANCE_PARTY = :acceptanceParty WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<LosLoanReqEvent> losloanreqevents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LOS_LOAN_REQ_EVENT WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LOS_LOAN_REQ_EVENT WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple LosLoanReqEvent records by their IDs.
     */
    @SqlQuery("SELECT * FROM LOS_LOAN_REQ_EVENT WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(LosLoanReqEvent.class)
    public List<LosLoanReqEvent> findByIds(@BindList("ids") Collection<String> ids);
}
