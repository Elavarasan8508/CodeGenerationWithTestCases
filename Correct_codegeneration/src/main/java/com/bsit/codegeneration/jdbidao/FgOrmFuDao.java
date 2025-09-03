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
import com.bsit.codegeneration.entity.FgOrmFu;

public interface FgOrmFuDao {

    /**
     * Inserts a new FgOrmFu and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ORM_FU (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, REMITTANCE_TYPE, PURPOSE_CODE, PURPOSE_OF_REM, REGULARATORY_REPORT, CAPITAL_GOODS, TRANSPORT_DOC_NO, COUNTRY_PROVIDING, TRANSFER_REF, CUSTOMER_REF, ENTITY, BENE_COUNTRY, BENE_ACCT, CHARGE_INSTRUCTION, EXECUTION_DATE, PAYMENT_INSTRUCTION, ISSUING_BANK, ISSUERS_REF, INTER_BANK_SWIFT, INTER_BANK_NAME, INTER_BANK_ADDR_1, INTER_BANK_ADDR_2, INTER_BANK_ADDR_3, CHARGE_ACCT, ATTACHMENTS, PORT_DISCHARGE, DUPLICATE_CHECK, OTHERS, DEBIT_ACCTNO, TRASACTION_CCY, TRASACTION_AMT, SUPPLIER_NAME, SUPPLIER_ACCTNO, SUPPLIER_ADDR_1, SUPPLIER_ADDR_2, SUPPLIER_ADDR_3, NOTIFY_PARTIES, ORIGIN_OF_GOODS, THIRD_PARTY_NAME, THIRD_PARTY_ADDR1, THIRD_PARTY_ADDR2, THIRD_PARTY_ADDR3, CONSIGNOR_NAME, CONSIGNOR_ADDR1, CONSIGNOR_ADDR2, CONSIGNOR_ADDR3, CONSIGNEE_NAME, CONSIGNEE_ADDR1, CONSIGNEE_ADDR2, CONSIGNEE_ADDR3, BOE_DATE, SUPPLIER_BANK_SWIFT, FX_DEAL_REF, GOODS_DESC, PURPOSE_OF_PAYMENT, GSTIN, CHARGE_ACCTNO, SUPPLIER_INSTRUCTION, UPLOAD_REF_ID, DISPLAY_STATUS, BOE_NUMBER, FCC_STATUS, FCC_STAGE, FCC_COMMENTS, BENE_CURRENCY, ISSUING_BANK_NAME, TXN_STATUS, TXN_REFERENCE, FILE_NAME, API_ERROR_DESC, LINE_NO, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, RATE_DETAILS, DEAL_TYPE, BENE_BAN_SWIFT, BANK_ABBV_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :remittanceType, :purposeCode, :purposeOfRem, :regularatoryReport, :capitalGoods, :transportDocNo, :countryProviding, :transferRef, :customerRef, :entity, :beneCountry, :beneAcct, :chargeInstruction, :executionDate, :paymentInstruction, :issuingBank, :issuersRef, :interBankSwift, :interBankName, :interBankAddr1, :interBankAddr2, :interBankAddr3, :chargeAcct, :attachments, :portDischarge, :duplicateCheck, :others, :debitAcctno, :trasactionCcy, :trasactionAmt, :supplierName, :supplierAcctno, :supplierAddr1, :supplierAddr2, :supplierAddr3, :notifyParties, :originOfGoods, :thirdPartyName, :thirdPartyAddr1, :thirdPartyAddr2, :thirdPartyAddr3, :consignorName, :consignorAddr1, :consignorAddr2, :consignorAddr3, :consigneeName, :consigneeAddr1, :consigneeAddr2, :consigneeAddr3, :boeDate, :supplierBankSwift, :fxDealRef, :goodsDesc, :purposeOfPayment, :gstin, :chargeAcctno, :supplierInstruction, :uploadRefId, :displayStatus, :boeNumber, :fccStatus, :fccStage, :fccComments, :beneCurrency, :issuingBankName, :txnStatus, :txnReference, :fileName, :APIErrorDesc, :lineNo, :applicantPartyCode, :issuingPartyCode, :rateDetails, :dealType, :beneBanSwift, :bankAbbvName)")
    public int insert(@BindBean FgOrmFu fgormfu);

    /**
     * Finds a FgOrmFu by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ORM_FU WHERE ID = :id")
    @RegisterBeanMapper(FgOrmFu.class)
    public Optional<FgOrmFu> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ORM_FU")
    @RegisterBeanMapper(FgOrmFu.class)
    public List<FgOrmFu> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ORM_FU ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgOrmFu.class)
    public List<FgOrmFu> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgOrmFu and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ORM_FU SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, REMITTANCE_TYPE = :remittanceType, PURPOSE_CODE = :purposeCode, PURPOSE_OF_REM = :purposeOfRem, REGULARATORY_REPORT = :regularatoryReport, CAPITAL_GOODS = :capitalGoods, TRANSPORT_DOC_NO = :transportDocNo, COUNTRY_PROVIDING = :countryProviding, TRANSFER_REF = :transferRef, CUSTOMER_REF = :customerRef, ENTITY = :entity, BENE_COUNTRY = :beneCountry, BENE_ACCT = :beneAcct, CHARGE_INSTRUCTION = :chargeInstruction, EXECUTION_DATE = :executionDate, PAYMENT_INSTRUCTION = :paymentInstruction, ISSUING_BANK = :issuingBank, ISSUERS_REF = :issuersRef, INTER_BANK_SWIFT = :interBankSwift, INTER_BANK_NAME = :interBankName, INTER_BANK_ADDR_1 = :interBankAddr1, INTER_BANK_ADDR_2 = :interBankAddr2, INTER_BANK_ADDR_3 = :interBankAddr3, CHARGE_ACCT = :chargeAcct, ATTACHMENTS = :attachments, PORT_DISCHARGE = :portDischarge, DUPLICATE_CHECK = :duplicateCheck, OTHERS = :others, DEBIT_ACCTNO = :debitAcctno, TRASACTION_CCY = :trasactionCcy, TRASACTION_AMT = :trasactionAmt, SUPPLIER_NAME = :supplierName, SUPPLIER_ACCTNO = :supplierAcctno, SUPPLIER_ADDR_1 = :supplierAddr1, SUPPLIER_ADDR_2 = :supplierAddr2, SUPPLIER_ADDR_3 = :supplierAddr3, NOTIFY_PARTIES = :notifyParties, ORIGIN_OF_GOODS = :originOfGoods, THIRD_PARTY_NAME = :thirdPartyName, THIRD_PARTY_ADDR1 = :thirdPartyAddr1, THIRD_PARTY_ADDR2 = :thirdPartyAddr2, THIRD_PARTY_ADDR3 = :thirdPartyAddr3, CONSIGNOR_NAME = :consignorName, CONSIGNOR_ADDR1 = :consignorAddr1, CONSIGNOR_ADDR2 = :consignorAddr2, CONSIGNOR_ADDR3 = :consignorAddr3, CONSIGNEE_NAME = :consigneeName, CONSIGNEE_ADDR1 = :consigneeAddr1, CONSIGNEE_ADDR2 = :consigneeAddr2, CONSIGNEE_ADDR3 = :consigneeAddr3, BOE_DATE = :boeDate, SUPPLIER_BANK_SWIFT = :supplierBankSwift, FX_DEAL_REF = :fxDealRef, GOODS_DESC = :goodsDesc, PURPOSE_OF_PAYMENT = :purposeOfPayment, GSTIN = :gstin, CHARGE_ACCTNO = :chargeAcctno, SUPPLIER_INSTRUCTION = :supplierInstruction, UPLOAD_REF_ID = :uploadRefId, DISPLAY_STATUS = :displayStatus, BOE_NUMBER = :boeNumber, FCC_STATUS = :fccStatus, FCC_STAGE = :fccStage, FCC_COMMENTS = :fccComments, BENE_CURRENCY = :beneCurrency, ISSUING_BANK_NAME = :issuingBankName, TXN_STATUS = :txnStatus, TXN_REFERENCE = :txnReference, FILE_NAME = :fileName, API_ERROR_DESC = :APIErrorDesc, LINE_NO = :lineNo, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, RATE_DETAILS = :rateDetails, DEAL_TYPE = :dealType, BENE_BAN_SWIFT = :beneBanSwift, BANK_ABBV_NAME = :bankAbbvName WHERE ID = :id")
    public int update(@BindBean FgOrmFu fgormfu);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ORM_FU WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ORM_FU")
    public long countAll();

    /**
     * Bulk insert multiple FgOrmFu entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ORM_FU (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, REMITTANCE_TYPE, PURPOSE_CODE, PURPOSE_OF_REM, REGULARATORY_REPORT, CAPITAL_GOODS, TRANSPORT_DOC_NO, COUNTRY_PROVIDING, TRANSFER_REF, CUSTOMER_REF, ENTITY, BENE_COUNTRY, BENE_ACCT, CHARGE_INSTRUCTION, EXECUTION_DATE, PAYMENT_INSTRUCTION, ISSUING_BANK, ISSUERS_REF, INTER_BANK_SWIFT, INTER_BANK_NAME, INTER_BANK_ADDR_1, INTER_BANK_ADDR_2, INTER_BANK_ADDR_3, CHARGE_ACCT, ATTACHMENTS, PORT_DISCHARGE, DUPLICATE_CHECK, OTHERS, DEBIT_ACCTNO, TRASACTION_CCY, TRASACTION_AMT, SUPPLIER_NAME, SUPPLIER_ACCTNO, SUPPLIER_ADDR_1, SUPPLIER_ADDR_2, SUPPLIER_ADDR_3, NOTIFY_PARTIES, ORIGIN_OF_GOODS, THIRD_PARTY_NAME, THIRD_PARTY_ADDR1, THIRD_PARTY_ADDR2, THIRD_PARTY_ADDR3, CONSIGNOR_NAME, CONSIGNOR_ADDR1, CONSIGNOR_ADDR2, CONSIGNOR_ADDR3, CONSIGNEE_NAME, CONSIGNEE_ADDR1, CONSIGNEE_ADDR2, CONSIGNEE_ADDR3, BOE_DATE, SUPPLIER_BANK_SWIFT, FX_DEAL_REF, GOODS_DESC, PURPOSE_OF_PAYMENT, GSTIN, CHARGE_ACCTNO, SUPPLIER_INSTRUCTION, UPLOAD_REF_ID, DISPLAY_STATUS, BOE_NUMBER, FCC_STATUS, FCC_STAGE, FCC_COMMENTS, BENE_CURRENCY, ISSUING_BANK_NAME, TXN_STATUS, TXN_REFERENCE, FILE_NAME, API_ERROR_DESC, LINE_NO, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, RATE_DETAILS, DEAL_TYPE, BENE_BAN_SWIFT, BANK_ABBV_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :remittanceType, :purposeCode, :purposeOfRem, :regularatoryReport, :capitalGoods, :transportDocNo, :countryProviding, :transferRef, :customerRef, :entity, :beneCountry, :beneAcct, :chargeInstruction, :executionDate, :paymentInstruction, :issuingBank, :issuersRef, :interBankSwift, :interBankName, :interBankAddr1, :interBankAddr2, :interBankAddr3, :chargeAcct, :attachments, :portDischarge, :duplicateCheck, :others, :debitAcctno, :trasactionCcy, :trasactionAmt, :supplierName, :supplierAcctno, :supplierAddr1, :supplierAddr2, :supplierAddr3, :notifyParties, :originOfGoods, :thirdPartyName, :thirdPartyAddr1, :thirdPartyAddr2, :thirdPartyAddr3, :consignorName, :consignorAddr1, :consignorAddr2, :consignorAddr3, :consigneeName, :consigneeAddr1, :consigneeAddr2, :consigneeAddr3, :boeDate, :supplierBankSwift, :fxDealRef, :goodsDesc, :purposeOfPayment, :gstin, :chargeAcctno, :supplierInstruction, :uploadRefId, :displayStatus, :boeNumber, :fccStatus, :fccStage, :fccComments, :beneCurrency, :issuingBankName, :txnStatus, :txnReference, :fileName, :APIErrorDesc, :lineNo, :applicantPartyCode, :issuingPartyCode, :rateDetails, :dealType, :beneBanSwift, :bankAbbvName)")
    public int[] bulkInsert(@BindBean List<FgOrmFu> fgormfus);

    /**
     * Bulk update multiple FgOrmFu entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ORM_FU SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, REMITTANCE_TYPE = :remittanceType, PURPOSE_CODE = :purposeCode, PURPOSE_OF_REM = :purposeOfRem, REGULARATORY_REPORT = :regularatoryReport, CAPITAL_GOODS = :capitalGoods, TRANSPORT_DOC_NO = :transportDocNo, COUNTRY_PROVIDING = :countryProviding, TRANSFER_REF = :transferRef, CUSTOMER_REF = :customerRef, ENTITY = :entity, BENE_COUNTRY = :beneCountry, BENE_ACCT = :beneAcct, CHARGE_INSTRUCTION = :chargeInstruction, EXECUTION_DATE = :executionDate, PAYMENT_INSTRUCTION = :paymentInstruction, ISSUING_BANK = :issuingBank, ISSUERS_REF = :issuersRef, INTER_BANK_SWIFT = :interBankSwift, INTER_BANK_NAME = :interBankName, INTER_BANK_ADDR_1 = :interBankAddr1, INTER_BANK_ADDR_2 = :interBankAddr2, INTER_BANK_ADDR_3 = :interBankAddr3, CHARGE_ACCT = :chargeAcct, ATTACHMENTS = :attachments, PORT_DISCHARGE = :portDischarge, DUPLICATE_CHECK = :duplicateCheck, OTHERS = :others, DEBIT_ACCTNO = :debitAcctno, TRASACTION_CCY = :trasactionCcy, TRASACTION_AMT = :trasactionAmt, SUPPLIER_NAME = :supplierName, SUPPLIER_ACCTNO = :supplierAcctno, SUPPLIER_ADDR_1 = :supplierAddr1, SUPPLIER_ADDR_2 = :supplierAddr2, SUPPLIER_ADDR_3 = :supplierAddr3, NOTIFY_PARTIES = :notifyParties, ORIGIN_OF_GOODS = :originOfGoods, THIRD_PARTY_NAME = :thirdPartyName, THIRD_PARTY_ADDR1 = :thirdPartyAddr1, THIRD_PARTY_ADDR2 = :thirdPartyAddr2, THIRD_PARTY_ADDR3 = :thirdPartyAddr3, CONSIGNOR_NAME = :consignorName, CONSIGNOR_ADDR1 = :consignorAddr1, CONSIGNOR_ADDR2 = :consignorAddr2, CONSIGNOR_ADDR3 = :consignorAddr3, CONSIGNEE_NAME = :consigneeName, CONSIGNEE_ADDR1 = :consigneeAddr1, CONSIGNEE_ADDR2 = :consigneeAddr2, CONSIGNEE_ADDR3 = :consigneeAddr3, BOE_DATE = :boeDate, SUPPLIER_BANK_SWIFT = :supplierBankSwift, FX_DEAL_REF = :fxDealRef, GOODS_DESC = :goodsDesc, PURPOSE_OF_PAYMENT = :purposeOfPayment, GSTIN = :gstin, CHARGE_ACCTNO = :chargeAcctno, SUPPLIER_INSTRUCTION = :supplierInstruction, UPLOAD_REF_ID = :uploadRefId, DISPLAY_STATUS = :displayStatus, BOE_NUMBER = :boeNumber, FCC_STATUS = :fccStatus, FCC_STAGE = :fccStage, FCC_COMMENTS = :fccComments, BENE_CURRENCY = :beneCurrency, ISSUING_BANK_NAME = :issuingBankName, TXN_STATUS = :txnStatus, TXN_REFERENCE = :txnReference, FILE_NAME = :fileName, API_ERROR_DESC = :APIErrorDesc, LINE_NO = :lineNo, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, RATE_DETAILS = :rateDetails, DEAL_TYPE = :dealType, BENE_BAN_SWIFT = :beneBanSwift, BANK_ABBV_NAME = :bankAbbvName WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgOrmFu> fgormfus);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ORM_FU WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ORM_FU WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgOrmFu records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ORM_FU WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgOrmFu.class)
    public List<FgOrmFu> findByIds(@BindList("ids") Collection<String> ids);
}
