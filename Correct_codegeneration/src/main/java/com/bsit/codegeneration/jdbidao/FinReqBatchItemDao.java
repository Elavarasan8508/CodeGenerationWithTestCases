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
import com.bsit.codegeneration.entity.FinReqBatchItem;

public interface FinReqBatchItemDao {

    /**
     * Inserts a new FinReqBatchItem and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FIN_REQ_BATCH_ITEM (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, BATCH_REF_NUM, UPLOAD_REF_ID, INSTRUMENT_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, INVOICE_AMOUNT, FILE_CONTENT, CUSTOMER_CRN, TNX_REF_ID, FINANCE_AMOUNT, FINANCING_AMOUNT, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, CONTRACT_PERIOD, PARENT_REF_ID, INV_NO, INV_DATE, INV_AMT, MATURITY_DATE, REMOVE_BATCH_ITEM, TXN_TYPE_CODE, TXN_SUB_TYPE_CODE, PARENT_VERSION_ID, LAYOUT_ID, CP_CODE, FILE_NAME, TNX_DISPLAY_REMARKS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_STATUS, PAYMENT_MODE, INTEREST_RATE, ANCHOR_NAME, COUNTER_PARTY_CRN, COUNTER_PARTY_NAME, INPUT_BRANCH, BEHALF_OF_BRANCH, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SPREAD_RATE, MARGIN_RATE, PENALTY_PERCENT, INTEREST_TYPE, RATE_TYPE, BASE_CODE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE1, LIMIT_NODE2, BENE_BRANCH, BENE_ACC_NO, SELLER_ID_CRN, BUYER_ID_CRN, CP_ROLE, BENE_LEI, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, UTR_DATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :batchRefNum, :uploadRefId, :instrumentId, :loanDueDate, :requestAmount, :invoiceAmount, :fileContent, :customerCrn, :tnxRefId, :financeAmount, :financingAmount, :tenorInDays, :intPeriodInDays, :contractPeriod, :parentRefId, :invNo, :invDate, :invAmt, :maturityDate, :removeBatchItem, :txnTypeCode, :txnSubTypeCode, :parentVersionId, :layoutId, :cpCode, :fileName, :tnxDisplayRemarks, :tnxDisplayBatchId, :tnxDisplayStatus, :paymentMode, :interestRate, :anchorName, :counterPartyCrn, :counterPartyName, :inputBranch, :behalfOfBranch, :debitPartyCrn, :creditPartyCrn, :creditPartyName, :spreadRate, :marginRate, :penaltyPercent, :interestType, :rateType, :baseCode, :productType, :gracePeriod, :limitNode1, :limitNode2, :beneBranch, :beneAccNo, :sellerIdCrn, :buyerIdCrn, :cpRole, :beneLei, :advanceInterest, :netPayment, :valueDate, :utrNumber, :charges, :utrDate)")
    public int insert(@BindBean FinReqBatchItem finreqbatchitem);

    /**
     * Finds a FinReqBatchItem by its ID.
     */
    @SqlQuery("SELECT * FROM FIN_REQ_BATCH_ITEM WHERE ID = :id")
    @RegisterBeanMapper(FinReqBatchItem.class)
    public Optional<FinReqBatchItem> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FIN_REQ_BATCH_ITEM")
    @RegisterBeanMapper(FinReqBatchItem.class)
    public List<FinReqBatchItem> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FIN_REQ_BATCH_ITEM ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FinReqBatchItem.class)
    public List<FinReqBatchItem> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FinReqBatchItem and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FIN_REQ_BATCH_ITEM SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, BATCH_REF_NUM = :batchRefNum, UPLOAD_REF_ID = :uploadRefId, INSTRUMENT_ID = :instrumentId, LOAN_DUE_DATE = :loanDueDate, REQUEST_AMOUNT = :requestAmount, INVOICE_AMOUNT = :invoiceAmount, FILE_CONTENT = :fileContent, CUSTOMER_CRN = :customerCrn, TNX_REF_ID = :tnxRefId, FINANCE_AMOUNT = :financeAmount, FINANCING_AMOUNT = :financingAmount, TENOR_IN_DAYS = :tenorInDays, INT_PERIOD_IN_DAYS = :intPeriodInDays, CONTRACT_PERIOD = :contractPeriod, PARENT_REF_ID = :parentRefId, INV_NO = :invNo, INV_DATE = :invDate, INV_AMT = :invAmt, MATURITY_DATE = :maturityDate, REMOVE_BATCH_ITEM = :removeBatchItem, TXN_TYPE_CODE = :txnTypeCode, TXN_SUB_TYPE_CODE = :txnSubTypeCode, PARENT_VERSION_ID = :parentVersionId, LAYOUT_ID = :layoutId, CP_CODE = :cpCode, FILE_NAME = :fileName, TNX_DISPLAY_REMARKS = :tnxDisplayRemarks, TNX_DISPLAY_BATCH_ID = :tnxDisplayBatchId, TNX_DISPLAY_STATUS = :tnxDisplayStatus, PAYMENT_MODE = :paymentMode, INTEREST_RATE = :interestRate, ANCHOR_NAME = :anchorName, COUNTER_PARTY_CRN = :counterPartyCrn, COUNTER_PARTY_NAME = :counterPartyName, INPUT_BRANCH = :inputBranch, BEHALF_OF_BRANCH = :behalfOfBranch, DEBIT_PARTY_CRN = :debitPartyCrn, CREDIT_PARTY_CRN = :creditPartyCrn, CREDIT_PARTY_NAME = :creditPartyName, SPREAD_RATE = :spreadRate, MARGIN_RATE = :marginRate, PENALTY_PERCENT = :penaltyPercent, INTEREST_TYPE = :interestType, RATE_TYPE = :rateType, BASE_CODE = :baseCode, PRODUCT_TYPE = :productType, GRACE_PERIOD = :gracePeriod, LIMIT_NODE1 = :limitNode1, LIMIT_NODE2 = :limitNode2, BENE_BRANCH = :beneBranch, BENE_ACC_NO = :beneAccNo, SELLER_ID_CRN = :sellerIdCrn, BUYER_ID_CRN = :buyerIdCrn, CP_ROLE = :cpRole, BENE_LEI = :beneLei, ADVANCE_INTEREST = :advanceInterest, NET_PAYMENT = :netPayment, VALUE_DATE = :valueDate, UTR_NUMBER = :utrNumber, CHARGES = :charges, UTR_DATE = :utrDate WHERE ID = :id")
    public int update(@BindBean FinReqBatchItem finreqbatchitem);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FIN_REQ_BATCH_ITEM WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FIN_REQ_BATCH_ITEM")
    public long countAll();

    /**
     * Bulk insert multiple FinReqBatchItem entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FIN_REQ_BATCH_ITEM (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, BATCH_REF_NUM, UPLOAD_REF_ID, INSTRUMENT_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, INVOICE_AMOUNT, FILE_CONTENT, CUSTOMER_CRN, TNX_REF_ID, FINANCE_AMOUNT, FINANCING_AMOUNT, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, CONTRACT_PERIOD, PARENT_REF_ID, INV_NO, INV_DATE, INV_AMT, MATURITY_DATE, REMOVE_BATCH_ITEM, TXN_TYPE_CODE, TXN_SUB_TYPE_CODE, PARENT_VERSION_ID, LAYOUT_ID, CP_CODE, FILE_NAME, TNX_DISPLAY_REMARKS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_STATUS, PAYMENT_MODE, INTEREST_RATE, ANCHOR_NAME, COUNTER_PARTY_CRN, COUNTER_PARTY_NAME, INPUT_BRANCH, BEHALF_OF_BRANCH, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SPREAD_RATE, MARGIN_RATE, PENALTY_PERCENT, INTEREST_TYPE, RATE_TYPE, BASE_CODE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE1, LIMIT_NODE2, BENE_BRANCH, BENE_ACC_NO, SELLER_ID_CRN, BUYER_ID_CRN, CP_ROLE, BENE_LEI, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, UTR_DATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :batchRefNum, :uploadRefId, :instrumentId, :loanDueDate, :requestAmount, :invoiceAmount, :fileContent, :customerCrn, :tnxRefId, :financeAmount, :financingAmount, :tenorInDays, :intPeriodInDays, :contractPeriod, :parentRefId, :invNo, :invDate, :invAmt, :maturityDate, :removeBatchItem, :txnTypeCode, :txnSubTypeCode, :parentVersionId, :layoutId, :cpCode, :fileName, :tnxDisplayRemarks, :tnxDisplayBatchId, :tnxDisplayStatus, :paymentMode, :interestRate, :anchorName, :counterPartyCrn, :counterPartyName, :inputBranch, :behalfOfBranch, :debitPartyCrn, :creditPartyCrn, :creditPartyName, :spreadRate, :marginRate, :penaltyPercent, :interestType, :rateType, :baseCode, :productType, :gracePeriod, :limitNode1, :limitNode2, :beneBranch, :beneAccNo, :sellerIdCrn, :buyerIdCrn, :cpRole, :beneLei, :advanceInterest, :netPayment, :valueDate, :utrNumber, :charges, :utrDate)")
    public int[] bulkInsert(@BindBean List<FinReqBatchItem> finreqbatchitems);

    /**
     * Bulk update multiple FinReqBatchItem entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FIN_REQ_BATCH_ITEM SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, BATCH_REF_NUM = :batchRefNum, UPLOAD_REF_ID = :uploadRefId, INSTRUMENT_ID = :instrumentId, LOAN_DUE_DATE = :loanDueDate, REQUEST_AMOUNT = :requestAmount, INVOICE_AMOUNT = :invoiceAmount, FILE_CONTENT = :fileContent, CUSTOMER_CRN = :customerCrn, TNX_REF_ID = :tnxRefId, FINANCE_AMOUNT = :financeAmount, FINANCING_AMOUNT = :financingAmount, TENOR_IN_DAYS = :tenorInDays, INT_PERIOD_IN_DAYS = :intPeriodInDays, CONTRACT_PERIOD = :contractPeriod, PARENT_REF_ID = :parentRefId, INV_NO = :invNo, INV_DATE = :invDate, INV_AMT = :invAmt, MATURITY_DATE = :maturityDate, REMOVE_BATCH_ITEM = :removeBatchItem, TXN_TYPE_CODE = :txnTypeCode, TXN_SUB_TYPE_CODE = :txnSubTypeCode, PARENT_VERSION_ID = :parentVersionId, LAYOUT_ID = :layoutId, CP_CODE = :cpCode, FILE_NAME = :fileName, TNX_DISPLAY_REMARKS = :tnxDisplayRemarks, TNX_DISPLAY_BATCH_ID = :tnxDisplayBatchId, TNX_DISPLAY_STATUS = :tnxDisplayStatus, PAYMENT_MODE = :paymentMode, INTEREST_RATE = :interestRate, ANCHOR_NAME = :anchorName, COUNTER_PARTY_CRN = :counterPartyCrn, COUNTER_PARTY_NAME = :counterPartyName, INPUT_BRANCH = :inputBranch, BEHALF_OF_BRANCH = :behalfOfBranch, DEBIT_PARTY_CRN = :debitPartyCrn, CREDIT_PARTY_CRN = :creditPartyCrn, CREDIT_PARTY_NAME = :creditPartyName, SPREAD_RATE = :spreadRate, MARGIN_RATE = :marginRate, PENALTY_PERCENT = :penaltyPercent, INTEREST_TYPE = :interestType, RATE_TYPE = :rateType, BASE_CODE = :baseCode, PRODUCT_TYPE = :productType, GRACE_PERIOD = :gracePeriod, LIMIT_NODE1 = :limitNode1, LIMIT_NODE2 = :limitNode2, BENE_BRANCH = :beneBranch, BENE_ACC_NO = :beneAccNo, SELLER_ID_CRN = :sellerIdCrn, BUYER_ID_CRN = :buyerIdCrn, CP_ROLE = :cpRole, BENE_LEI = :beneLei, ADVANCE_INTEREST = :advanceInterest, NET_PAYMENT = :netPayment, VALUE_DATE = :valueDate, UTR_NUMBER = :utrNumber, CHARGES = :charges, UTR_DATE = :utrDate WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FinReqBatchItem> finreqbatchitems);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FIN_REQ_BATCH_ITEM WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FIN_REQ_BATCH_ITEM WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FinReqBatchItem records by their IDs.
     */
    @SqlQuery("SELECT * FROM FIN_REQ_BATCH_ITEM WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FinReqBatchItem.class)
    public List<FinReqBatchItem> findByIds(@BindList("ids") Collection<String> ids);
}
