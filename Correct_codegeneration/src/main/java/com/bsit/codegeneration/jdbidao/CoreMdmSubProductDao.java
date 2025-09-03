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
import com.bsit.codegeneration.entity.CoreMdmSubProduct;

public interface CoreMdmSubProductDao {

    /**
     * Inserts a new CoreMdmSubProduct and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO CORE_MDM_SUB_PRODUCT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PRODUCT_CODE, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_GROUP_CODE, PRODUCT_SUBGROUP_CODE, ASSET_LIABILITY_APPLICABLE, CREDIT_LINE_APPLICABLE, AUTO_CLOSURE_APPLICABLE, RECOURSE_APPLICABLE, MIN_TENOR_ALLOWED, MAX_TENOR_ALLOWED, GRACE_DAYS, MAX_FINANCE_PERCENT, RECOURSE_PERCENT, HOLIDAY_TREATMENT, NO_OF_DAYS_FROM_GRACE_DAYS, MULTIPLE_DISBURSEMENT_ALLOWED, NO_OF_DISBURSEMENTS_ALLOWED, DISBURSEMENT_SCHEDULE, DISBURSEMENT_DAYS, PRE_PAYMENT_ALLOWED, PART_REPAYMENT_ALLOWED, AUTO_DEBIT_ALLOWED, ALLOWED_MODE, NO_OF_RETRIES, AUTO_DEBIT_TYPE, INTRA_DAY_DEBIT_FREQUENCY, TIME_OF_FIRST_DEBIT, PRE_CLOSURE_ALLOWED, ALLOW_DEBIT_CREDIT_ADJUSTMENTS, REPAYMENT_AMOUNT_ALLOCATION, ALLOCATION_RULE, APPROPRIATION_SEQUENCE, NPA_APPROPRIATION_SEQUENCE, PENALTY_CALCULATION_FROM, FEES_AND_CHARGES_SCHEME, ALERTS_NOTIFICATIONS_SCHEME, ADVICES_SCHEME, ASSET_SCHEME, LIMIT_AND_COLLATERAL_SCHEME, NPA_DELINQUENCY, PRODUCT_STATUS_CODE, SUFFIX_ID, SUFFIX_NAME, SUFFIX_DESCRIPTION, SOURCE_SYSTEM_CODE, BA_SHORT_NAME, CLASSIFICATION, SUB_PRODUCT_CODE, SUB_PRODUCT_DESCRIPTION, PRIMARY_PARTY, FINANCING_METHOD, ANCHOR_PARTY, BORROWER_PARTY, EXPOSURE_MAINTANANCE_REQ, INVOICE_BY, FINANCE_BY, INTEREST_CALCULATION, ACCRUAL_AMORTIZE, FINANCE_DEBIT_PARTY, FINANCE_TO_PARTY, SUB_PRODUCT_NAME, SEGMENT_CODE, CUTOFF_APPLICABLE, CHARGES_APPLICABLE, HOLIDAY_APPLICABLE, ALLOW_PAYMENT, ALLOW_COLLECTION, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :productCode, :productName, :productDescription, :productGroupCode, :productSubgroupCode, :assetLiabilityApplicable, :creditLineApplicable, :autoClosureApplicable, :recourseApplicable, :minTenorAllowed, :maxTenorAllowed, :graceDays, :maxFinancePercent, :recoursePercent, :holidayTreatment, :noOfDaysFromGraceDays, :multipleDisbursementAllowed, :noOfDisbursementsAllowed, :disbursementSchedule, :disbursementDays, :prePaymentAllowed, :partRepaymentAllowed, :autoDebitAllowed, :allowedMode, :noOfRetries, :autoDebitType, :intraDayDebitFrequency, :timeOfFirstDebit, :preClosureAllowed, :allowDebitCreditAdjustments, :repaymentAmountAllocation, :allocationRule, :appropriationSequence, :npaAppropriationSequence, :penaltyCalculationFrom, :feesAndChargesScheme, :alertsNotificationsScheme, :advicesScheme, :assetScheme, :limitAndCollateralScheme, :npaDelinquency, :productStatusCode, :suffixId, :suffixName, :suffixDescription, :sourceSystemCode, :baShortName, :classification, :subProductCode, :subProductDescription, :primaryParty, :financingMethod, :anchorParty, :borrowerParty, :exposureMaintananceReq, :invoiceBy, :financeBy, :interestCalculation, :accrualAmortize, :financeDebitParty, :financeToParty, :subProductName, :segmentCode, :cutoffApplicable, :chargesApplicable, :holidayApplicable, :allowPayment, :allowCollection, :versionId, :isMasterVersion, :uploadRefId)")
    public int insert(@BindBean CoreMdmSubProduct coremdmsubproduct);

    /**
     * Finds a CoreMdmSubProduct by its ID.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_SUB_PRODUCT WHERE VERSION_ID = :id")
    @RegisterBeanMapper(CoreMdmSubProduct.class)
    public Optional<CoreMdmSubProduct> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_SUB_PRODUCT")
    @RegisterBeanMapper(CoreMdmSubProduct.class)
    public List<CoreMdmSubProduct> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_SUB_PRODUCT ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(CoreMdmSubProduct.class)
    public List<CoreMdmSubProduct> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a CoreMdmSubProduct and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE CORE_MDM_SUB_PRODUCT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, PRODUCT_CODE = :productCode, PRODUCT_NAME = :productName, PRODUCT_DESCRIPTION = :productDescription, PRODUCT_GROUP_CODE = :productGroupCode, PRODUCT_SUBGROUP_CODE = :productSubgroupCode, ASSET_LIABILITY_APPLICABLE = :assetLiabilityApplicable, CREDIT_LINE_APPLICABLE = :creditLineApplicable, AUTO_CLOSURE_APPLICABLE = :autoClosureApplicable, RECOURSE_APPLICABLE = :recourseApplicable, MIN_TENOR_ALLOWED = :minTenorAllowed, MAX_TENOR_ALLOWED = :maxTenorAllowed, GRACE_DAYS = :graceDays, MAX_FINANCE_PERCENT = :maxFinancePercent, RECOURSE_PERCENT = :recoursePercent, HOLIDAY_TREATMENT = :holidayTreatment, NO_OF_DAYS_FROM_GRACE_DAYS = :noOfDaysFromGraceDays, MULTIPLE_DISBURSEMENT_ALLOWED = :multipleDisbursementAllowed, NO_OF_DISBURSEMENTS_ALLOWED = :noOfDisbursementsAllowed, DISBURSEMENT_SCHEDULE = :disbursementSchedule, DISBURSEMENT_DAYS = :disbursementDays, PRE_PAYMENT_ALLOWED = :prePaymentAllowed, PART_REPAYMENT_ALLOWED = :partRepaymentAllowed, AUTO_DEBIT_ALLOWED = :autoDebitAllowed, ALLOWED_MODE = :allowedMode, NO_OF_RETRIES = :noOfRetries, AUTO_DEBIT_TYPE = :autoDebitType, INTRA_DAY_DEBIT_FREQUENCY = :intraDayDebitFrequency, TIME_OF_FIRST_DEBIT = :timeOfFirstDebit, PRE_CLOSURE_ALLOWED = :preClosureAllowed, ALLOW_DEBIT_CREDIT_ADJUSTMENTS = :allowDebitCreditAdjustments, REPAYMENT_AMOUNT_ALLOCATION = :repaymentAmountAllocation, ALLOCATION_RULE = :allocationRule, APPROPRIATION_SEQUENCE = :appropriationSequence, NPA_APPROPRIATION_SEQUENCE = :npaAppropriationSequence, PENALTY_CALCULATION_FROM = :penaltyCalculationFrom, FEES_AND_CHARGES_SCHEME = :feesAndChargesScheme, ALERTS_NOTIFICATIONS_SCHEME = :alertsNotificationsScheme, ADVICES_SCHEME = :advicesScheme, ASSET_SCHEME = :assetScheme, LIMIT_AND_COLLATERAL_SCHEME = :limitAndCollateralScheme, NPA_DELINQUENCY = :npaDelinquency, PRODUCT_STATUS_CODE = :productStatusCode, SUFFIX_ID = :suffixId, SUFFIX_NAME = :suffixName, SUFFIX_DESCRIPTION = :suffixDescription, SOURCE_SYSTEM_CODE = :sourceSystemCode, BA_SHORT_NAME = :baShortName, CLASSIFICATION = :classification, SUB_PRODUCT_CODE = :subProductCode, SUB_PRODUCT_DESCRIPTION = :subProductDescription, PRIMARY_PARTY = :primaryParty, FINANCING_METHOD = :financingMethod, ANCHOR_PARTY = :anchorParty, BORROWER_PARTY = :borrowerParty, EXPOSURE_MAINTANANCE_REQ = :exposureMaintananceReq, INVOICE_BY = :invoiceBy, FINANCE_BY = :financeBy, INTEREST_CALCULATION = :interestCalculation, ACCRUAL_AMORTIZE = :accrualAmortize, FINANCE_DEBIT_PARTY = :financeDebitParty, FINANCE_TO_PARTY = :financeToParty, SUB_PRODUCT_NAME = :subProductName, SEGMENT_CODE = :segmentCode, CUTOFF_APPLICABLE = :cutoffApplicable, CHARGES_APPLICABLE = :chargesApplicable, HOLIDAY_APPLICABLE = :holidayApplicable, ALLOW_PAYMENT = :allowPayment, ALLOW_COLLECTION = :allowCollection, IS_MASTER_VERSION = :isMasterVersion, UPLOAD_REF_ID = :uploadRefId WHERE VERSION_ID = :versionId")
    public int update(@BindBean CoreMdmSubProduct coremdmsubproduct);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM CORE_MDM_SUB_PRODUCT WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM CORE_MDM_SUB_PRODUCT")
    public long countAll();

    /**
     * Bulk insert multiple CoreMdmSubProduct entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO CORE_MDM_SUB_PRODUCT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PRODUCT_CODE, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_GROUP_CODE, PRODUCT_SUBGROUP_CODE, ASSET_LIABILITY_APPLICABLE, CREDIT_LINE_APPLICABLE, AUTO_CLOSURE_APPLICABLE, RECOURSE_APPLICABLE, MIN_TENOR_ALLOWED, MAX_TENOR_ALLOWED, GRACE_DAYS, MAX_FINANCE_PERCENT, RECOURSE_PERCENT, HOLIDAY_TREATMENT, NO_OF_DAYS_FROM_GRACE_DAYS, MULTIPLE_DISBURSEMENT_ALLOWED, NO_OF_DISBURSEMENTS_ALLOWED, DISBURSEMENT_SCHEDULE, DISBURSEMENT_DAYS, PRE_PAYMENT_ALLOWED, PART_REPAYMENT_ALLOWED, AUTO_DEBIT_ALLOWED, ALLOWED_MODE, NO_OF_RETRIES, AUTO_DEBIT_TYPE, INTRA_DAY_DEBIT_FREQUENCY, TIME_OF_FIRST_DEBIT, PRE_CLOSURE_ALLOWED, ALLOW_DEBIT_CREDIT_ADJUSTMENTS, REPAYMENT_AMOUNT_ALLOCATION, ALLOCATION_RULE, APPROPRIATION_SEQUENCE, NPA_APPROPRIATION_SEQUENCE, PENALTY_CALCULATION_FROM, FEES_AND_CHARGES_SCHEME, ALERTS_NOTIFICATIONS_SCHEME, ADVICES_SCHEME, ASSET_SCHEME, LIMIT_AND_COLLATERAL_SCHEME, NPA_DELINQUENCY, PRODUCT_STATUS_CODE, SUFFIX_ID, SUFFIX_NAME, SUFFIX_DESCRIPTION, SOURCE_SYSTEM_CODE, BA_SHORT_NAME, CLASSIFICATION, SUB_PRODUCT_CODE, SUB_PRODUCT_DESCRIPTION, PRIMARY_PARTY, FINANCING_METHOD, ANCHOR_PARTY, BORROWER_PARTY, EXPOSURE_MAINTANANCE_REQ, INVOICE_BY, FINANCE_BY, INTEREST_CALCULATION, ACCRUAL_AMORTIZE, FINANCE_DEBIT_PARTY, FINANCE_TO_PARTY, SUB_PRODUCT_NAME, SEGMENT_CODE, CUTOFF_APPLICABLE, CHARGES_APPLICABLE, HOLIDAY_APPLICABLE, ALLOW_PAYMENT, ALLOW_COLLECTION, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :productCode, :productName, :productDescription, :productGroupCode, :productSubgroupCode, :assetLiabilityApplicable, :creditLineApplicable, :autoClosureApplicable, :recourseApplicable, :minTenorAllowed, :maxTenorAllowed, :graceDays, :maxFinancePercent, :recoursePercent, :holidayTreatment, :noOfDaysFromGraceDays, :multipleDisbursementAllowed, :noOfDisbursementsAllowed, :disbursementSchedule, :disbursementDays, :prePaymentAllowed, :partRepaymentAllowed, :autoDebitAllowed, :allowedMode, :noOfRetries, :autoDebitType, :intraDayDebitFrequency, :timeOfFirstDebit, :preClosureAllowed, :allowDebitCreditAdjustments, :repaymentAmountAllocation, :allocationRule, :appropriationSequence, :npaAppropriationSequence, :penaltyCalculationFrom, :feesAndChargesScheme, :alertsNotificationsScheme, :advicesScheme, :assetScheme, :limitAndCollateralScheme, :npaDelinquency, :productStatusCode, :suffixId, :suffixName, :suffixDescription, :sourceSystemCode, :baShortName, :classification, :subProductCode, :subProductDescription, :primaryParty, :financingMethod, :anchorParty, :borrowerParty, :exposureMaintananceReq, :invoiceBy, :financeBy, :interestCalculation, :accrualAmortize, :financeDebitParty, :financeToParty, :subProductName, :segmentCode, :cutoffApplicable, :chargesApplicable, :holidayApplicable, :allowPayment, :allowCollection, :versionId, :isMasterVersion, :uploadRefId)")
    public int[] bulkInsert(@BindBean List<CoreMdmSubProduct> coremdmsubproducts);

    /**
     * Bulk update multiple CoreMdmSubProduct entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE CORE_MDM_SUB_PRODUCT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, PRODUCT_CODE = :productCode, PRODUCT_NAME = :productName, PRODUCT_DESCRIPTION = :productDescription, PRODUCT_GROUP_CODE = :productGroupCode, PRODUCT_SUBGROUP_CODE = :productSubgroupCode, ASSET_LIABILITY_APPLICABLE = :assetLiabilityApplicable, CREDIT_LINE_APPLICABLE = :creditLineApplicable, AUTO_CLOSURE_APPLICABLE = :autoClosureApplicable, RECOURSE_APPLICABLE = :recourseApplicable, MIN_TENOR_ALLOWED = :minTenorAllowed, MAX_TENOR_ALLOWED = :maxTenorAllowed, GRACE_DAYS = :graceDays, MAX_FINANCE_PERCENT = :maxFinancePercent, RECOURSE_PERCENT = :recoursePercent, HOLIDAY_TREATMENT = :holidayTreatment, NO_OF_DAYS_FROM_GRACE_DAYS = :noOfDaysFromGraceDays, MULTIPLE_DISBURSEMENT_ALLOWED = :multipleDisbursementAllowed, NO_OF_DISBURSEMENTS_ALLOWED = :noOfDisbursementsAllowed, DISBURSEMENT_SCHEDULE = :disbursementSchedule, DISBURSEMENT_DAYS = :disbursementDays, PRE_PAYMENT_ALLOWED = :prePaymentAllowed, PART_REPAYMENT_ALLOWED = :partRepaymentAllowed, AUTO_DEBIT_ALLOWED = :autoDebitAllowed, ALLOWED_MODE = :allowedMode, NO_OF_RETRIES = :noOfRetries, AUTO_DEBIT_TYPE = :autoDebitType, INTRA_DAY_DEBIT_FREQUENCY = :intraDayDebitFrequency, TIME_OF_FIRST_DEBIT = :timeOfFirstDebit, PRE_CLOSURE_ALLOWED = :preClosureAllowed, ALLOW_DEBIT_CREDIT_ADJUSTMENTS = :allowDebitCreditAdjustments, REPAYMENT_AMOUNT_ALLOCATION = :repaymentAmountAllocation, ALLOCATION_RULE = :allocationRule, APPROPRIATION_SEQUENCE = :appropriationSequence, NPA_APPROPRIATION_SEQUENCE = :npaAppropriationSequence, PENALTY_CALCULATION_FROM = :penaltyCalculationFrom, FEES_AND_CHARGES_SCHEME = :feesAndChargesScheme, ALERTS_NOTIFICATIONS_SCHEME = :alertsNotificationsScheme, ADVICES_SCHEME = :advicesScheme, ASSET_SCHEME = :assetScheme, LIMIT_AND_COLLATERAL_SCHEME = :limitAndCollateralScheme, NPA_DELINQUENCY = :npaDelinquency, PRODUCT_STATUS_CODE = :productStatusCode, SUFFIX_ID = :suffixId, SUFFIX_NAME = :suffixName, SUFFIX_DESCRIPTION = :suffixDescription, SOURCE_SYSTEM_CODE = :sourceSystemCode, BA_SHORT_NAME = :baShortName, CLASSIFICATION = :classification, SUB_PRODUCT_CODE = :subProductCode, SUB_PRODUCT_DESCRIPTION = :subProductDescription, PRIMARY_PARTY = :primaryParty, FINANCING_METHOD = :financingMethod, ANCHOR_PARTY = :anchorParty, BORROWER_PARTY = :borrowerParty, EXPOSURE_MAINTANANCE_REQ = :exposureMaintananceReq, INVOICE_BY = :invoiceBy, FINANCE_BY = :financeBy, INTEREST_CALCULATION = :interestCalculation, ACCRUAL_AMORTIZE = :accrualAmortize, FINANCE_DEBIT_PARTY = :financeDebitParty, FINANCE_TO_PARTY = :financeToParty, SUB_PRODUCT_NAME = :subProductName, SEGMENT_CODE = :segmentCode, CUTOFF_APPLICABLE = :cutoffApplicable, CHARGES_APPLICABLE = :chargesApplicable, HOLIDAY_APPLICABLE = :holidayApplicable, ALLOW_PAYMENT = :allowPayment, ALLOW_COLLECTION = :allowCollection, IS_MASTER_VERSION = :isMasterVersion, UPLOAD_REF_ID = :uploadRefId WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<CoreMdmSubProduct> coremdmsubproducts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM CORE_MDM_SUB_PRODUCT WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM CORE_MDM_SUB_PRODUCT WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple CoreMdmSubProduct records by their IDs.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_SUB_PRODUCT WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(CoreMdmSubProduct.class)
    public List<CoreMdmSubProduct> findByIds(@BindList("ids") Collection<String> ids);
}
