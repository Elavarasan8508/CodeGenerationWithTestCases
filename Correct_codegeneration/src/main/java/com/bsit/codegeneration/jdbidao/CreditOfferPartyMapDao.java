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
import com.bsit.codegeneration.entity.CreditOfferPartyMap;

public interface CreditOfferPartyMapDao {

    /**
     * Inserts a new CreditOfferPartyMap and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO CREDIT_OFFER_PARTY_MAP (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, OFFER_ID, MAPPING_STATUS, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID, USAGE_LIMIT, CUSTOMER_ID, CRN_BOR, ACC_NO, ROI, PROC_FEE, OVERALL_LIMIT, PORTFOLIO, PRODUCT_CODE, VALID_FROM, VALID_TO, DECLARATION_TYPE, BRANCH_ADDRESS, BRANCH_LOCATION, SOLID, FINANCIAL_YEAR, GSTIN_NUM, TYP_OF_PROC_FEE, MIN_LOAN_AMT, MAX_LOAN_AMT, MIN_TENURE_DAYS, MAX_TENURE_DAYS, ADHOC_TYPE, EXISTING_FAC, AVAILABLE_LOAN_LIMIT, SANC_LOAN_LIMIT, UTL_LOAN_DEM, GST, SPREAD_OF_ROI, ROI_NEXT_YR, SANC_LTR_REFNO, ROI_BENCHMARK, BENCHMARK, ADMIN_CHRGS, TECHNICAL_FEES, REMARKS, GST_NEXT_YR, PROC_FEES_NEXT_YR, ROI_TYPE, MSME_STATUS, PSL_STATUS, NATURE_OF_BUSINESS, SCHEME_CODE, LIMIT_ID, SUBSECTOR_CODE, BRANCH_CODE, OPERATION_TYPE, USER_ID, UPLOADED_DATE, SUB_PRODUCT_CODE, SEGMENT_CODE, SEGMENT_TEAMS, LINE_NO) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :offerId, :mappingStatus, :versionId, :isMasterVersion, :uploadRefId, :usageLimit, :customerId, :crnBor, :accNo, :roi, :procFee, :overallLimit, :portfolio, :productCode, :validFrom, :validTo, :declarationType, :branchAddress, :branchLocation, :solid, :financialYear, :gstinNum, :typOfProcFee, :minLoanAmt, :maxLoanAmt, :minTenureDays, :maxTenureDays, :adhocType, :existingFac, :availableLoanLimit, :sancLoanLimit, :utlLoanDem, :gst, :spreadOfRoi, :roiNextYr, :sancLtrRefno, :roiBenchmark, :benchmark, :adminChrgs, :technicalFees, :remarks, :gstNextYr, :procFeesNextYr, :roiType, :msmeStatus, :pslStatus, :natureOfBusiness, :schemeCode, :limitId, :subsectorCode, :branchCode, :operationType, :userId, :uploadedDate, :subProductCode, :segmentCode, :segmentTeams, :lineNo)")
    public int insert(@BindBean CreditOfferPartyMap creditofferpartymap);

    /**
     * Finds a CreditOfferPartyMap by its ID.
     */
    @SqlQuery("SELECT * FROM CREDIT_OFFER_PARTY_MAP WHERE VERSION_ID = :id")
    @RegisterBeanMapper(CreditOfferPartyMap.class)
    public Optional<CreditOfferPartyMap> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM CREDIT_OFFER_PARTY_MAP")
    @RegisterBeanMapper(CreditOfferPartyMap.class)
    public List<CreditOfferPartyMap> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM CREDIT_OFFER_PARTY_MAP ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(CreditOfferPartyMap.class)
    public List<CreditOfferPartyMap> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a CreditOfferPartyMap and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE CREDIT_OFFER_PARTY_MAP SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, OFFER_ID = :offerId, MAPPING_STATUS = :mappingStatus, IS_MASTER_VERSION = :isMasterVersion, UPLOAD_REF_ID = :uploadRefId, USAGE_LIMIT = :usageLimit, CUSTOMER_ID = :customerId, CRN_BOR = :crnBor, ACC_NO = :accNo, ROI = :roi, PROC_FEE = :procFee, OVERALL_LIMIT = :overallLimit, PORTFOLIO = :portfolio, PRODUCT_CODE = :productCode, VALID_FROM = :validFrom, VALID_TO = :validTo, DECLARATION_TYPE = :declarationType, BRANCH_ADDRESS = :branchAddress, BRANCH_LOCATION = :branchLocation, SOLID = :solid, FINANCIAL_YEAR = :financialYear, GSTIN_NUM = :gstinNum, TYP_OF_PROC_FEE = :typOfProcFee, MIN_LOAN_AMT = :minLoanAmt, MAX_LOAN_AMT = :maxLoanAmt, MIN_TENURE_DAYS = :minTenureDays, MAX_TENURE_DAYS = :maxTenureDays, ADHOC_TYPE = :adhocType, EXISTING_FAC = :existingFac, AVAILABLE_LOAN_LIMIT = :availableLoanLimit, SANC_LOAN_LIMIT = :sancLoanLimit, UTL_LOAN_DEM = :utlLoanDem, GST = :gst, SPREAD_OF_ROI = :spreadOfRoi, ROI_NEXT_YR = :roiNextYr, SANC_LTR_REFNO = :sancLtrRefno, ROI_BENCHMARK = :roiBenchmark, BENCHMARK = :benchmark, ADMIN_CHRGS = :adminChrgs, TECHNICAL_FEES = :technicalFees, REMARKS = :remarks, GST_NEXT_YR = :gstNextYr, PROC_FEES_NEXT_YR = :procFeesNextYr, ROI_TYPE = :roiType, MSME_STATUS = :msmeStatus, PSL_STATUS = :pslStatus, NATURE_OF_BUSINESS = :natureOfBusiness, SCHEME_CODE = :schemeCode, LIMIT_ID = :limitId, SUBSECTOR_CODE = :subsectorCode, BRANCH_CODE = :branchCode, OPERATION_TYPE = :operationType, USER_ID = :userId, UPLOADED_DATE = :uploadedDate, SUB_PRODUCT_CODE = :subProductCode, SEGMENT_CODE = :segmentCode, SEGMENT_TEAMS = :segmentTeams, LINE_NO = :lineNo WHERE VERSION_ID = :versionId")
    public int update(@BindBean CreditOfferPartyMap creditofferpartymap);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM CREDIT_OFFER_PARTY_MAP WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM CREDIT_OFFER_PARTY_MAP")
    public long countAll();

    /**
     * Bulk insert multiple CreditOfferPartyMap entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO CREDIT_OFFER_PARTY_MAP (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, OFFER_ID, MAPPING_STATUS, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID, USAGE_LIMIT, CUSTOMER_ID, CRN_BOR, ACC_NO, ROI, PROC_FEE, OVERALL_LIMIT, PORTFOLIO, PRODUCT_CODE, VALID_FROM, VALID_TO, DECLARATION_TYPE, BRANCH_ADDRESS, BRANCH_LOCATION, SOLID, FINANCIAL_YEAR, GSTIN_NUM, TYP_OF_PROC_FEE, MIN_LOAN_AMT, MAX_LOAN_AMT, MIN_TENURE_DAYS, MAX_TENURE_DAYS, ADHOC_TYPE, EXISTING_FAC, AVAILABLE_LOAN_LIMIT, SANC_LOAN_LIMIT, UTL_LOAN_DEM, GST, SPREAD_OF_ROI, ROI_NEXT_YR, SANC_LTR_REFNO, ROI_BENCHMARK, BENCHMARK, ADMIN_CHRGS, TECHNICAL_FEES, REMARKS, GST_NEXT_YR, PROC_FEES_NEXT_YR, ROI_TYPE, MSME_STATUS, PSL_STATUS, NATURE_OF_BUSINESS, SCHEME_CODE, LIMIT_ID, SUBSECTOR_CODE, BRANCH_CODE, OPERATION_TYPE, USER_ID, UPLOADED_DATE, SUB_PRODUCT_CODE, SEGMENT_CODE, SEGMENT_TEAMS, LINE_NO) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :offerId, :mappingStatus, :versionId, :isMasterVersion, :uploadRefId, :usageLimit, :customerId, :crnBor, :accNo, :roi, :procFee, :overallLimit, :portfolio, :productCode, :validFrom, :validTo, :declarationType, :branchAddress, :branchLocation, :solid, :financialYear, :gstinNum, :typOfProcFee, :minLoanAmt, :maxLoanAmt, :minTenureDays, :maxTenureDays, :adhocType, :existingFac, :availableLoanLimit, :sancLoanLimit, :utlLoanDem, :gst, :spreadOfRoi, :roiNextYr, :sancLtrRefno, :roiBenchmark, :benchmark, :adminChrgs, :technicalFees, :remarks, :gstNextYr, :procFeesNextYr, :roiType, :msmeStatus, :pslStatus, :natureOfBusiness, :schemeCode, :limitId, :subsectorCode, :branchCode, :operationType, :userId, :uploadedDate, :subProductCode, :segmentCode, :segmentTeams, :lineNo)")
    public int[] bulkInsert(@BindBean List<CreditOfferPartyMap> creditofferpartymaps);

    /**
     * Bulk update multiple CreditOfferPartyMap entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE CREDIT_OFFER_PARTY_MAP SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, OFFER_ID = :offerId, MAPPING_STATUS = :mappingStatus, IS_MASTER_VERSION = :isMasterVersion, UPLOAD_REF_ID = :uploadRefId, USAGE_LIMIT = :usageLimit, CUSTOMER_ID = :customerId, CRN_BOR = :crnBor, ACC_NO = :accNo, ROI = :roi, PROC_FEE = :procFee, OVERALL_LIMIT = :overallLimit, PORTFOLIO = :portfolio, PRODUCT_CODE = :productCode, VALID_FROM = :validFrom, VALID_TO = :validTo, DECLARATION_TYPE = :declarationType, BRANCH_ADDRESS = :branchAddress, BRANCH_LOCATION = :branchLocation, SOLID = :solid, FINANCIAL_YEAR = :financialYear, GSTIN_NUM = :gstinNum, TYP_OF_PROC_FEE = :typOfProcFee, MIN_LOAN_AMT = :minLoanAmt, MAX_LOAN_AMT = :maxLoanAmt, MIN_TENURE_DAYS = :minTenureDays, MAX_TENURE_DAYS = :maxTenureDays, ADHOC_TYPE = :adhocType, EXISTING_FAC = :existingFac, AVAILABLE_LOAN_LIMIT = :availableLoanLimit, SANC_LOAN_LIMIT = :sancLoanLimit, UTL_LOAN_DEM = :utlLoanDem, GST = :gst, SPREAD_OF_ROI = :spreadOfRoi, ROI_NEXT_YR = :roiNextYr, SANC_LTR_REFNO = :sancLtrRefno, ROI_BENCHMARK = :roiBenchmark, BENCHMARK = :benchmark, ADMIN_CHRGS = :adminChrgs, TECHNICAL_FEES = :technicalFees, REMARKS = :remarks, GST_NEXT_YR = :gstNextYr, PROC_FEES_NEXT_YR = :procFeesNextYr, ROI_TYPE = :roiType, MSME_STATUS = :msmeStatus, PSL_STATUS = :pslStatus, NATURE_OF_BUSINESS = :natureOfBusiness, SCHEME_CODE = :schemeCode, LIMIT_ID = :limitId, SUBSECTOR_CODE = :subsectorCode, BRANCH_CODE = :branchCode, OPERATION_TYPE = :operationType, USER_ID = :userId, UPLOADED_DATE = :uploadedDate, SUB_PRODUCT_CODE = :subProductCode, SEGMENT_CODE = :segmentCode, SEGMENT_TEAMS = :segmentTeams, LINE_NO = :lineNo WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<CreditOfferPartyMap> creditofferpartymaps);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM CREDIT_OFFER_PARTY_MAP WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM CREDIT_OFFER_PARTY_MAP WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple CreditOfferPartyMap records by their IDs.
     */
    @SqlQuery("SELECT * FROM CREDIT_OFFER_PARTY_MAP WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(CreditOfferPartyMap.class)
    public List<CreditOfferPartyMap> findByIds(@BindList("ids") Collection<String> ids);
}
