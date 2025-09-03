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
import com.bsit.codegeneration.entity.FgTdOtpReq;

public interface FgTdOtpReqDao {

    /**
     * Inserts a new FgTdOtpReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_OTP_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, OTP_COUNT, OTP_RESENT, OTP_FAILED_COUNT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, USER_CRN, ENTITY_TYPE_CODE, MOBILE_MASKED, EMAIL_MASKED) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :otpCount, :otpResent, :otpFailedCount, :otpSentTime, :otpLockedTime, :otpUnlockTime, :userCrn, :entityTypeCode, :mobileMasked, :emailMasked)")
    public int insert(@BindBean FgTdOtpReq fgtdotpreq);

    /**
     * Finds a FgTdOtpReq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_OTP_REQ WHERE ID = :id")
    @RegisterBeanMapper(FgTdOtpReq.class)
    public Optional<FgTdOtpReq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_OTP_REQ")
    @RegisterBeanMapper(FgTdOtpReq.class)
    public List<FgTdOtpReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_OTP_REQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdOtpReq.class)
    public List<FgTdOtpReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdOtpReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_OTP_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, OTP_COUNT = :otpCount, OTP_RESENT = :otpResent, OTP_FAILED_COUNT = :otpFailedCount, OTP_SENT_TIME = :otpSentTime, OTP_LOCKED_TIME = :otpLockedTime, OTP_UNLOCK_TIME = :otpUnlockTime, USER_CRN = :userCrn, ENTITY_TYPE_CODE = :entityTypeCode, MOBILE_MASKED = :mobileMasked, EMAIL_MASKED = :emailMasked WHERE ID = :id")
    public int update(@BindBean FgTdOtpReq fgtdotpreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_OTP_REQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_OTP_REQ")
    public long countAll();

    /**
     * Bulk insert multiple FgTdOtpReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_OTP_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, OTP_COUNT, OTP_RESENT, OTP_FAILED_COUNT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, USER_CRN, ENTITY_TYPE_CODE, MOBILE_MASKED, EMAIL_MASKED) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :otpCount, :otpResent, :otpFailedCount, :otpSentTime, :otpLockedTime, :otpUnlockTime, :userCrn, :entityTypeCode, :mobileMasked, :emailMasked)")
    public int[] bulkInsert(@BindBean List<FgTdOtpReq> fgtdotpreqs);

    /**
     * Bulk update multiple FgTdOtpReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_OTP_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, OTP_COUNT = :otpCount, OTP_RESENT = :otpResent, OTP_FAILED_COUNT = :otpFailedCount, OTP_SENT_TIME = :otpSentTime, OTP_LOCKED_TIME = :otpLockedTime, OTP_UNLOCK_TIME = :otpUnlockTime, USER_CRN = :userCrn, ENTITY_TYPE_CODE = :entityTypeCode, MOBILE_MASKED = :mobileMasked, EMAIL_MASKED = :emailMasked WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTdOtpReq> fgtdotpreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_OTP_REQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_OTP_REQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTdOtpReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_OTP_REQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTdOtpReq.class)
    public List<FgTdOtpReq> findByIds(@BindList("ids") Collection<String> ids);
}
