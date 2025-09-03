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
import com.bsit.codegeneration.entity.CashCreditOffer;

public interface CashCreditOfferDao {

    /**
     * Inserts a new CashCreditOffer and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO CASH_CREDIT_OFFER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, OFFER_ID, NAME, DESCRIPTION, OFFER_TYPE_CODE, OFFER_START_DATE, OFFER_END_DATE, INTEREST_TYPE_CODE, RATE_OF_INTEREST, BENCHMARK_CODE, RESET_FREQUENCY_PERIOD_CODE, TENOR_UOM, TENOR_MIN, TENOR_MAX, PROCESSING_MODE_CODE, OFFER_SPREAD_PERCENTAGE, FTP_CODE, VERSION_ID, IS_MASTER_VERSION, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :offerId, :name, :description, :offerTypeCode, :offerStartDate, :offerEndDate, :interestTypeCode, :rateOfInterest, :benchmarkCode, :resetFrequencyPeriodCode, :tenorUom, :tenorMin, :tenorMax, :processingModeCode, :offerSpreadPercentage, :ftpCode, :versionId, :isMasterVersion, :productCode, :subProductCode, :segmentCode)")
    public int insert(@BindBean CashCreditOffer cashcreditoffer);

    /**
     * Finds a CashCreditOffer by its ID.
     */
    @SqlQuery("SELECT * FROM CASH_CREDIT_OFFER WHERE VERSION_ID = :id")
    @RegisterBeanMapper(CashCreditOffer.class)
    public Optional<CashCreditOffer> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM CASH_CREDIT_OFFER")
    @RegisterBeanMapper(CashCreditOffer.class)
    public List<CashCreditOffer> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM CASH_CREDIT_OFFER ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(CashCreditOffer.class)
    public List<CashCreditOffer> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a CashCreditOffer and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE CASH_CREDIT_OFFER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, OFFER_ID = :offerId, NAME = :name, DESCRIPTION = :description, OFFER_TYPE_CODE = :offerTypeCode, OFFER_START_DATE = :offerStartDate, OFFER_END_DATE = :offerEndDate, INTEREST_TYPE_CODE = :interestTypeCode, RATE_OF_INTEREST = :rateOfInterest, BENCHMARK_CODE = :benchmarkCode, RESET_FREQUENCY_PERIOD_CODE = :resetFrequencyPeriodCode, TENOR_UOM = :tenorUom, TENOR_MIN = :tenorMin, TENOR_MAX = :tenorMax, PROCESSING_MODE_CODE = :processingModeCode, OFFER_SPREAD_PERCENTAGE = :offerSpreadPercentage, FTP_CODE = :ftpCode, IS_MASTER_VERSION = :isMasterVersion, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode, SEGMENT_CODE = :segmentCode WHERE VERSION_ID = :versionId")
    public int update(@BindBean CashCreditOffer cashcreditoffer);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM CASH_CREDIT_OFFER WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM CASH_CREDIT_OFFER")
    public long countAll();

    /**
     * Bulk insert multiple CashCreditOffer entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO CASH_CREDIT_OFFER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, OFFER_ID, NAME, DESCRIPTION, OFFER_TYPE_CODE, OFFER_START_DATE, OFFER_END_DATE, INTEREST_TYPE_CODE, RATE_OF_INTEREST, BENCHMARK_CODE, RESET_FREQUENCY_PERIOD_CODE, TENOR_UOM, TENOR_MIN, TENOR_MAX, PROCESSING_MODE_CODE, OFFER_SPREAD_PERCENTAGE, FTP_CODE, VERSION_ID, IS_MASTER_VERSION, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :offerId, :name, :description, :offerTypeCode, :offerStartDate, :offerEndDate, :interestTypeCode, :rateOfInterest, :benchmarkCode, :resetFrequencyPeriodCode, :tenorUom, :tenorMin, :tenorMax, :processingModeCode, :offerSpreadPercentage, :ftpCode, :versionId, :isMasterVersion, :productCode, :subProductCode, :segmentCode)")
    public int[] bulkInsert(@BindBean List<CashCreditOffer> cashcreditoffers);

    /**
     * Bulk update multiple CashCreditOffer entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE CASH_CREDIT_OFFER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, OFFER_ID = :offerId, NAME = :name, DESCRIPTION = :description, OFFER_TYPE_CODE = :offerTypeCode, OFFER_START_DATE = :offerStartDate, OFFER_END_DATE = :offerEndDate, INTEREST_TYPE_CODE = :interestTypeCode, RATE_OF_INTEREST = :rateOfInterest, BENCHMARK_CODE = :benchmarkCode, RESET_FREQUENCY_PERIOD_CODE = :resetFrequencyPeriodCode, TENOR_UOM = :tenorUom, TENOR_MIN = :tenorMin, TENOR_MAX = :tenorMax, PROCESSING_MODE_CODE = :processingModeCode, OFFER_SPREAD_PERCENTAGE = :offerSpreadPercentage, FTP_CODE = :ftpCode, IS_MASTER_VERSION = :isMasterVersion, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode, SEGMENT_CODE = :segmentCode WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<CashCreditOffer> cashcreditoffers);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM CASH_CREDIT_OFFER WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM CASH_CREDIT_OFFER WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple CashCreditOffer records by their IDs.
     */
    @SqlQuery("SELECT * FROM CASH_CREDIT_OFFER WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(CashCreditOffer.class)
    public List<CashCreditOffer> findByIds(@BindList("ids") Collection<String> ids);
}
