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
import com.bsit.codegeneration.entity.FgFinanceTransactions;

public interface FgFinanceTransactionsDao {

    /**
     * Inserts a new FgFinanceTransactions and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_FINANCE_TRANSACTIONS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FILE_NAME, ANCHOR_CRN, INV_NO, INV_DATE, INV_AMT, COUNTER_PARTY_CRN, COUNTER_PARTY_NAME, INPUT_BRANCH, BEHALF_OF_BRANCH, DEBIT_PARTY_CRN, EFFECTIVE_DATE, FINANCING_AMOUNT, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SPREAD_RATE, INTEREST_RATE, MARGIN_RATE, MATURITY_DATE, PENALTY_PERCENT, INT_START_DATE, INTEREST_TYPE, RATE_TYPE, BASE_CODE, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, PRODUCT_TYPE, CONTRACT_PERIOD, GRACE_PERIOD, LIMIT_NODE1, LIMIT_NODE2, PAYMENT_MODE, BENE_BRANCH, BENE_ACC_NO, STATUS, BATCH_REF_ID, REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VAL_DATE, UTR_NUMBER, CHARGES, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, UPLOAD_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, FINANCE_FILE_GENERATED, ENTITY_REF_ID, FINANCE_REMARKS, SELLER_ID_CRN, BUYER_ID_CRN, CP_ROLE, BENE_LEI, FINANCE_AMOUNT, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, VALUE_DATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :fileName, :anchorCrn, :invNo, :invDate, :invAmt, :counterPartyCrn, :counterPartyName, :inputBranch, :behalfOfBranch, :debitPartyCrn, :effectiveDate, :financingAmount, :creditPartyCrn, :creditPartyName, :spreadRate, :interestRate, :marginRate, :maturityDate, :penaltyPercent, :intStartDate, :interestType, :rateType, :baseCode, :tenorInDays, :intPeriodInDays, :productType, :contractPeriod, :gracePeriod, :limitNode1, :limitNode2, :paymentMode, :beneBranch, :beneAccNo, :status, :batchRefId, :remarks, :advanceInterest, :netPayment, :valDate, :utrNumber, :charges, :tiStatus, :tiBatchRefId, :tiRemarks, :uploadRefId, :entitySubTypeCode, :entityTypeCode, :financeFileGenerated, :entityRefId, :financeRemarks, :sellerIdCrn, :buyerIdCrn, :cpRole, :beneLei, :financeAmount, :layoutTemplateId, :layoutName, :valueDate)")
    public int insert(@BindBean FgFinanceTransactions fgfinancetransactions);

    /**
     * Finds a FgFinanceTransactions by its ID.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_TRANSACTIONS WHERE ID = :id")
    @RegisterBeanMapper(FgFinanceTransactions.class)
    public Optional<FgFinanceTransactions> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_TRANSACTIONS")
    @RegisterBeanMapper(FgFinanceTransactions.class)
    public List<FgFinanceTransactions> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_TRANSACTIONS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgFinanceTransactions.class)
    public List<FgFinanceTransactions> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgFinanceTransactions and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_FINANCE_TRANSACTIONS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, FILE_NAME = :fileName, ANCHOR_CRN = :anchorCrn, INV_NO = :invNo, INV_DATE = :invDate, INV_AMT = :invAmt, COUNTER_PARTY_CRN = :counterPartyCrn, COUNTER_PARTY_NAME = :counterPartyName, INPUT_BRANCH = :inputBranch, BEHALF_OF_BRANCH = :behalfOfBranch, DEBIT_PARTY_CRN = :debitPartyCrn, EFFECTIVE_DATE = :effectiveDate, FINANCING_AMOUNT = :financingAmount, CREDIT_PARTY_CRN = :creditPartyCrn, CREDIT_PARTY_NAME = :creditPartyName, SPREAD_RATE = :spreadRate, INTEREST_RATE = :interestRate, MARGIN_RATE = :marginRate, MATURITY_DATE = :maturityDate, PENALTY_PERCENT = :penaltyPercent, INT_START_DATE = :intStartDate, INTEREST_TYPE = :interestType, RATE_TYPE = :rateType, BASE_CODE = :baseCode, TENOR_IN_DAYS = :tenorInDays, INT_PERIOD_IN_DAYS = :intPeriodInDays, PRODUCT_TYPE = :productType, CONTRACT_PERIOD = :contractPeriod, GRACE_PERIOD = :gracePeriod, LIMIT_NODE1 = :limitNode1, LIMIT_NODE2 = :limitNode2, PAYMENT_MODE = :paymentMode, BENE_BRANCH = :beneBranch, BENE_ACC_NO = :beneAccNo, STATUS = :status, BATCH_REF_ID = :batchRefId, REMARKS = :remarks, ADVANCE_INTEREST = :advanceInterest, NET_PAYMENT = :netPayment, VAL_DATE = :valDate, UTR_NUMBER = :utrNumber, CHARGES = :charges, TI_STATUS = :tiStatus, TI_BATCH_REF_ID = :tiBatchRefId, TI_REMARKS = :tiRemarks, UPLOAD_REF_ID = :uploadRefId, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, FINANCE_FILE_GENERATED = :financeFileGenerated, ENTITY_REF_ID = :entityRefId, FINANCE_REMARKS = :financeRemarks, SELLER_ID_CRN = :sellerIdCrn, BUYER_ID_CRN = :buyerIdCrn, CP_ROLE = :cpRole, BENE_LEI = :beneLei, FINANCE_AMOUNT = :financeAmount, LAYOUT_TEMPLATE_ID = :layoutTemplateId, LAYOUT_NAME = :layoutName, VALUE_DATE = :valueDate WHERE ID = :id")
    public int update(@BindBean FgFinanceTransactions fgfinancetransactions);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FINANCE_TRANSACTIONS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_FINANCE_TRANSACTIONS")
    public long countAll();

    /**
     * Bulk insert multiple FgFinanceTransactions entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_FINANCE_TRANSACTIONS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FILE_NAME, ANCHOR_CRN, INV_NO, INV_DATE, INV_AMT, COUNTER_PARTY_CRN, COUNTER_PARTY_NAME, INPUT_BRANCH, BEHALF_OF_BRANCH, DEBIT_PARTY_CRN, EFFECTIVE_DATE, FINANCING_AMOUNT, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SPREAD_RATE, INTEREST_RATE, MARGIN_RATE, MATURITY_DATE, PENALTY_PERCENT, INT_START_DATE, INTEREST_TYPE, RATE_TYPE, BASE_CODE, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, PRODUCT_TYPE, CONTRACT_PERIOD, GRACE_PERIOD, LIMIT_NODE1, LIMIT_NODE2, PAYMENT_MODE, BENE_BRANCH, BENE_ACC_NO, STATUS, BATCH_REF_ID, REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VAL_DATE, UTR_NUMBER, CHARGES, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, UPLOAD_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, FINANCE_FILE_GENERATED, ENTITY_REF_ID, FINANCE_REMARKS, SELLER_ID_CRN, BUYER_ID_CRN, CP_ROLE, BENE_LEI, FINANCE_AMOUNT, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, VALUE_DATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :fileName, :anchorCrn, :invNo, :invDate, :invAmt, :counterPartyCrn, :counterPartyName, :inputBranch, :behalfOfBranch, :debitPartyCrn, :effectiveDate, :financingAmount, :creditPartyCrn, :creditPartyName, :spreadRate, :interestRate, :marginRate, :maturityDate, :penaltyPercent, :intStartDate, :interestType, :rateType, :baseCode, :tenorInDays, :intPeriodInDays, :productType, :contractPeriod, :gracePeriod, :limitNode1, :limitNode2, :paymentMode, :beneBranch, :beneAccNo, :status, :batchRefId, :remarks, :advanceInterest, :netPayment, :valDate, :utrNumber, :charges, :tiStatus, :tiBatchRefId, :tiRemarks, :uploadRefId, :entitySubTypeCode, :entityTypeCode, :financeFileGenerated, :entityRefId, :financeRemarks, :sellerIdCrn, :buyerIdCrn, :cpRole, :beneLei, :financeAmount, :layoutTemplateId, :layoutName, :valueDate)")
    public int[] bulkInsert(@BindBean List<FgFinanceTransactions> fgfinancetransactionss);

    /**
     * Bulk update multiple FgFinanceTransactions entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_FINANCE_TRANSACTIONS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, FILE_NAME = :fileName, ANCHOR_CRN = :anchorCrn, INV_NO = :invNo, INV_DATE = :invDate, INV_AMT = :invAmt, COUNTER_PARTY_CRN = :counterPartyCrn, COUNTER_PARTY_NAME = :counterPartyName, INPUT_BRANCH = :inputBranch, BEHALF_OF_BRANCH = :behalfOfBranch, DEBIT_PARTY_CRN = :debitPartyCrn, EFFECTIVE_DATE = :effectiveDate, FINANCING_AMOUNT = :financingAmount, CREDIT_PARTY_CRN = :creditPartyCrn, CREDIT_PARTY_NAME = :creditPartyName, SPREAD_RATE = :spreadRate, INTEREST_RATE = :interestRate, MARGIN_RATE = :marginRate, MATURITY_DATE = :maturityDate, PENALTY_PERCENT = :penaltyPercent, INT_START_DATE = :intStartDate, INTEREST_TYPE = :interestType, RATE_TYPE = :rateType, BASE_CODE = :baseCode, TENOR_IN_DAYS = :tenorInDays, INT_PERIOD_IN_DAYS = :intPeriodInDays, PRODUCT_TYPE = :productType, CONTRACT_PERIOD = :contractPeriod, GRACE_PERIOD = :gracePeriod, LIMIT_NODE1 = :limitNode1, LIMIT_NODE2 = :limitNode2, PAYMENT_MODE = :paymentMode, BENE_BRANCH = :beneBranch, BENE_ACC_NO = :beneAccNo, STATUS = :status, BATCH_REF_ID = :batchRefId, REMARKS = :remarks, ADVANCE_INTEREST = :advanceInterest, NET_PAYMENT = :netPayment, VAL_DATE = :valDate, UTR_NUMBER = :utrNumber, CHARGES = :charges, TI_STATUS = :tiStatus, TI_BATCH_REF_ID = :tiBatchRefId, TI_REMARKS = :tiRemarks, UPLOAD_REF_ID = :uploadRefId, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, FINANCE_FILE_GENERATED = :financeFileGenerated, ENTITY_REF_ID = :entityRefId, FINANCE_REMARKS = :financeRemarks, SELLER_ID_CRN = :sellerIdCrn, BUYER_ID_CRN = :buyerIdCrn, CP_ROLE = :cpRole, BENE_LEI = :beneLei, FINANCE_AMOUNT = :financeAmount, LAYOUT_TEMPLATE_ID = :layoutTemplateId, LAYOUT_NAME = :layoutName, VALUE_DATE = :valueDate WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgFinanceTransactions> fgfinancetransactionss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FINANCE_TRANSACTIONS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_FINANCE_TRANSACTIONS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgFinanceTransactions records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_TRANSACTIONS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgFinanceTransactions.class)
    public List<FgFinanceTransactions> findByIds(@BindList("ids") Collection<String> ids);
}
