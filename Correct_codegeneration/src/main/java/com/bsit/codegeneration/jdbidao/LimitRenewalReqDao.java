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
import com.bsit.codegeneration.entity.LimitRenewalReq;

public interface LimitRenewalReqDao {

    /**
     * Inserts a new LimitRenewalReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LIMIT_RENEWAL_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CORP_CRN, CORP_CRN_NAME, USER_CRN, USER_CRN_NAME, NEXT_REVIEW_DATE, TECHNICAL_FEES, ADMIN_CHRGS, PROC_FEE, TOTAL_GST, REMARKS, OFFER_REFERENCE, PRODUCT_STATUS_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :corpCrn, :corpCrnName, :userCrn, :userCrnName, :nextReviewDate, :technicalFees, :adminChrgs, :procFee, :totalGst, :remarks, :offerReference, :productStatusCode)")
    public int insert(@BindBean LimitRenewalReq limitrenewalreq);

    /**
     * Finds a LimitRenewalReq by its ID.
     */
    @SqlQuery("SELECT * FROM LIMIT_RENEWAL_REQ WHERE ID = :id")
    @RegisterBeanMapper(LimitRenewalReq.class)
    public Optional<LimitRenewalReq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LIMIT_RENEWAL_REQ")
    @RegisterBeanMapper(LimitRenewalReq.class)
    public List<LimitRenewalReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LIMIT_RENEWAL_REQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LimitRenewalReq.class)
    public List<LimitRenewalReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LimitRenewalReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LIMIT_RENEWAL_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, CORP_CRN = :corpCrn, CORP_CRN_NAME = :corpCrnName, USER_CRN = :userCrn, USER_CRN_NAME = :userCrnName, NEXT_REVIEW_DATE = :nextReviewDate, TECHNICAL_FEES = :technicalFees, ADMIN_CHRGS = :adminChrgs, PROC_FEE = :procFee, TOTAL_GST = :totalGst, REMARKS = :remarks, OFFER_REFERENCE = :offerReference, PRODUCT_STATUS_CODE = :productStatusCode WHERE ID = :id")
    public int update(@BindBean LimitRenewalReq limitrenewalreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LIMIT_RENEWAL_REQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LIMIT_RENEWAL_REQ")
    public long countAll();

    /**
     * Bulk insert multiple LimitRenewalReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LIMIT_RENEWAL_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CORP_CRN, CORP_CRN_NAME, USER_CRN, USER_CRN_NAME, NEXT_REVIEW_DATE, TECHNICAL_FEES, ADMIN_CHRGS, PROC_FEE, TOTAL_GST, REMARKS, OFFER_REFERENCE, PRODUCT_STATUS_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :corpCrn, :corpCrnName, :userCrn, :userCrnName, :nextReviewDate, :technicalFees, :adminChrgs, :procFee, :totalGst, :remarks, :offerReference, :productStatusCode)")
    public int[] bulkInsert(@BindBean List<LimitRenewalReq> limitrenewalreqs);

    /**
     * Bulk update multiple LimitRenewalReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LIMIT_RENEWAL_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, CORP_CRN = :corpCrn, CORP_CRN_NAME = :corpCrnName, USER_CRN = :userCrn, USER_CRN_NAME = :userCrnName, NEXT_REVIEW_DATE = :nextReviewDate, TECHNICAL_FEES = :technicalFees, ADMIN_CHRGS = :adminChrgs, PROC_FEE = :procFee, TOTAL_GST = :totalGst, REMARKS = :remarks, OFFER_REFERENCE = :offerReference, PRODUCT_STATUS_CODE = :productStatusCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<LimitRenewalReq> limitrenewalreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LIMIT_RENEWAL_REQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LIMIT_RENEWAL_REQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple LimitRenewalReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM LIMIT_RENEWAL_REQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(LimitRenewalReq.class)
    public List<LimitRenewalReq> findByIds(@BindList("ids") Collection<String> ids);
}
