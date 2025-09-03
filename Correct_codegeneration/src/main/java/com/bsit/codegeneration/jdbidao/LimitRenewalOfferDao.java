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
import com.bsit.codegeneration.entity.LimitRenewalOffer;

public interface LimitRenewalOfferDao {

    /**
     * Inserts a new LimitRenewalOffer and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LIMIT_RENEWAL_OFFER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LOB, CRN_BOR, PROSPECT_ID, VALID_TO, PROC_FEE, PROC_FEE_GST, ALREADY_COLLECTED, ALREADY_COLLECTED_GST, BAL_COLLECTED, BAL_COLLECTED_GST, ADMIN_CHRGS, ADMIN_CHRGS_GST, TECHNICAL_FEES, TECHNICAL_FEES_GST, NEXT_REVIEW_DATE, LAST_REVIEW_DATE, VAR_LIMIT_APPLICABLE, GML_LIMIT_APPLICABLE, CGTMSE, REMARKS, TERM_LOAN, SIDBI, CCOD, SEASONAL_AD_HOC, CRN_NAME, VERSION_ID, IS_MASTER_VERSION, ADMIN_CHARGES, ADMIN_CHARGES_GST) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :lob, :crnBor, :prospectId, :validTo, :procFee, :procFeeGst, :alreadyCollected, :alreadyCollectedGst, :balCollected, :balCollectedGst, :adminChrgs, :adminChrgsGst, :technicalFees, :technicalFeesGst, :nextReviewDate, :lastReviewDate, :varLimitApplicable, :gmlLimitApplicable, :cgtmse, :remarks, :termLoan, :sidbi, :ccod, :seasonalAdHoc, :crnName, :versionId, :isMasterVersion, :adminCharges, :adminChargesGst)")
    public int insert(@BindBean LimitRenewalOffer limitrenewaloffer);

    /**
     * Finds a LimitRenewalOffer by its ID.
     */
    @SqlQuery("SELECT * FROM LIMIT_RENEWAL_OFFER WHERE ID = :id")
    @RegisterBeanMapper(LimitRenewalOffer.class)
    public Optional<LimitRenewalOffer> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LIMIT_RENEWAL_OFFER")
    @RegisterBeanMapper(LimitRenewalOffer.class)
    public List<LimitRenewalOffer> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LIMIT_RENEWAL_OFFER ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LimitRenewalOffer.class)
    public List<LimitRenewalOffer> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LimitRenewalOffer and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LIMIT_RENEWAL_OFFER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, LOB = :lob, CRN_BOR = :crnBor, PROSPECT_ID = :prospectId, VALID_TO = :validTo, PROC_FEE = :procFee, PROC_FEE_GST = :procFeeGst, ALREADY_COLLECTED = :alreadyCollected, ALREADY_COLLECTED_GST = :alreadyCollectedGst, BAL_COLLECTED = :balCollected, BAL_COLLECTED_GST = :balCollectedGst, ADMIN_CHRGS = :adminChrgs, ADMIN_CHRGS_GST = :adminChrgsGst, TECHNICAL_FEES = :technicalFees, TECHNICAL_FEES_GST = :technicalFeesGst, NEXT_REVIEW_DATE = :nextReviewDate, LAST_REVIEW_DATE = :lastReviewDate, VAR_LIMIT_APPLICABLE = :varLimitApplicable, GML_LIMIT_APPLICABLE = :gmlLimitApplicable, CGTMSE = :cgtmse, REMARKS = :remarks, TERM_LOAN = :termLoan, SIDBI = :sidbi, CCOD = :ccod, SEASONAL_AD_HOC = :seasonalAdHoc, CRN_NAME = :crnName, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, ADMIN_CHARGES = :adminCharges, ADMIN_CHARGES_GST = :adminChargesGst WHERE ID = :id")
    public int update(@BindBean LimitRenewalOffer limitrenewaloffer);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LIMIT_RENEWAL_OFFER WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LIMIT_RENEWAL_OFFER")
    public long countAll();

    /**
     * Bulk insert multiple LimitRenewalOffer entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LIMIT_RENEWAL_OFFER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LOB, CRN_BOR, PROSPECT_ID, VALID_TO, PROC_FEE, PROC_FEE_GST, ALREADY_COLLECTED, ALREADY_COLLECTED_GST, BAL_COLLECTED, BAL_COLLECTED_GST, ADMIN_CHRGS, ADMIN_CHRGS_GST, TECHNICAL_FEES, TECHNICAL_FEES_GST, NEXT_REVIEW_DATE, LAST_REVIEW_DATE, VAR_LIMIT_APPLICABLE, GML_LIMIT_APPLICABLE, CGTMSE, REMARKS, TERM_LOAN, SIDBI, CCOD, SEASONAL_AD_HOC, CRN_NAME, VERSION_ID, IS_MASTER_VERSION, ADMIN_CHARGES, ADMIN_CHARGES_GST) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :lob, :crnBor, :prospectId, :validTo, :procFee, :procFeeGst, :alreadyCollected, :alreadyCollectedGst, :balCollected, :balCollectedGst, :adminChrgs, :adminChrgsGst, :technicalFees, :technicalFeesGst, :nextReviewDate, :lastReviewDate, :varLimitApplicable, :gmlLimitApplicable, :cgtmse, :remarks, :termLoan, :sidbi, :ccod, :seasonalAdHoc, :crnName, :versionId, :isMasterVersion, :adminCharges, :adminChargesGst)")
    public int[] bulkInsert(@BindBean List<LimitRenewalOffer> limitrenewaloffers);

    /**
     * Bulk update multiple LimitRenewalOffer entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LIMIT_RENEWAL_OFFER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, LOB = :lob, CRN_BOR = :crnBor, PROSPECT_ID = :prospectId, VALID_TO = :validTo, PROC_FEE = :procFee, PROC_FEE_GST = :procFeeGst, ALREADY_COLLECTED = :alreadyCollected, ALREADY_COLLECTED_GST = :alreadyCollectedGst, BAL_COLLECTED = :balCollected, BAL_COLLECTED_GST = :balCollectedGst, ADMIN_CHRGS = :adminChrgs, ADMIN_CHRGS_GST = :adminChrgsGst, TECHNICAL_FEES = :technicalFees, TECHNICAL_FEES_GST = :technicalFeesGst, NEXT_REVIEW_DATE = :nextReviewDate, LAST_REVIEW_DATE = :lastReviewDate, VAR_LIMIT_APPLICABLE = :varLimitApplicable, GML_LIMIT_APPLICABLE = :gmlLimitApplicable, CGTMSE = :cgtmse, REMARKS = :remarks, TERM_LOAN = :termLoan, SIDBI = :sidbi, CCOD = :ccod, SEASONAL_AD_HOC = :seasonalAdHoc, CRN_NAME = :crnName, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, ADMIN_CHARGES = :adminCharges, ADMIN_CHARGES_GST = :adminChargesGst WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<LimitRenewalOffer> limitrenewaloffers);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LIMIT_RENEWAL_OFFER WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LIMIT_RENEWAL_OFFER WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple LimitRenewalOffer records by their IDs.
     */
    @SqlQuery("SELECT * FROM LIMIT_RENEWAL_OFFER WHERE ID IN (<ids>)")
    @RegisterBeanMapper(LimitRenewalOffer.class)
    public List<LimitRenewalOffer> findByIds(@BindList("ids") Collection<String> ids);
}
