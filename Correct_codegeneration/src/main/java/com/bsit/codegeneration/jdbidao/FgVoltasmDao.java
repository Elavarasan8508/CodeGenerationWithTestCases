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
import com.bsit.codegeneration.entity.FgVoltasm;

public interface FgVoltasmDao {

    /**
     * Inserts a new FgVoltasm and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_VOLTASM (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CLIENT_CODE, PRODUCT_CODE, PAYMENT_TYPE, PAYMENT_REF_NO, PAYMENT_DATE, INSTRUMENT_DATE, AMOUNT, BANK_CODE_INDICATOR, BENEFICIARY_CODE, BENEFICIARY_NAME, BENEFICIARY_BANK, BENEFICIARY_BRANCH, LOCATION, PRINT_LOCATION, INSTRUMENT_NO, BENEFICIARY_ADDRESS_1, BENEFICIARY_ADDRESS_2, BENEFICIARY_ADDRESS_3, BENEFICIARY_ADDRESS_4, BENEFICIARY_EMAIL, BENEFICIARY_MOBILE, DEBIT_NARRATION, CREDIT_NARRATION, PAYMENT_DETAILS_1, PAYMENT_DETAILS_2, PAYMENT_DETAILS_3, PAYMENT_DETAILS_4, SR_NO, DOCUMENT_NO, INV_REF_NO, INV_DATE, INV_AMOUNT, OTHER_DEDUCTIONS, TDS_AMOUNT, TOTAL_DEDUCTED_AMOUNT, NET_AMOUNT_PAYABLE, UPLOAD_REF_ID, LINE_NO, UPLOAD_LAYOUT_UUID, BENEFICIARY_ACC_NO, DR_AC_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :clientCode, :productCode, :paymentType, :paymentRefNo, :paymentDate, :instrumentDate, :amount, :bankCodeIndicator, :beneficiaryCode, :beneficiaryName, :beneficiaryBank, :beneficiaryBranch, :location, :printLocation, :instrumentNo, :beneficiaryAddress1, :beneficiaryAddress2, :beneficiaryAddress3, :beneficiaryAddress4, :beneficiaryEmail, :beneficiaryMobile, :debitNarration, :creditNarration, :paymentDetails1, :paymentDetails2, :paymentDetails3, :paymentDetails4, :srNo, :documentNo, :invRefNo, :invDate, :invAmount, :otherDeductions, :tdsAmount, :totalDeductedAmount, :netAmountPayable, :uploadRefId, :lineNo, :uploadLayoutUuid, :beneficiaryAccNo, :drAcNo, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :fileName)")
    public int insert(@BindBean FgVoltasm fgvoltasm);

    /**
     * Finds a FgVoltasm by its ID.
     */
    @SqlQuery("SELECT * FROM FG_VOLTASM WHERE ID = :id")
    @RegisterBeanMapper(FgVoltasm.class)
    public Optional<FgVoltasm> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_VOLTASM")
    @RegisterBeanMapper(FgVoltasm.class)
    public List<FgVoltasm> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_VOLTASM ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgVoltasm.class)
    public List<FgVoltasm> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgVoltasm and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_VOLTASM SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CLIENT_CODE = :clientCode, PRODUCT_CODE = :productCode, PAYMENT_TYPE = :paymentType, PAYMENT_REF_NO = :paymentRefNo, PAYMENT_DATE = :paymentDate, INSTRUMENT_DATE = :instrumentDate, AMOUNT = :amount, BANK_CODE_INDICATOR = :bankCodeIndicator, BENEFICIARY_CODE = :beneficiaryCode, BENEFICIARY_NAME = :beneficiaryName, BENEFICIARY_BANK = :beneficiaryBank, BENEFICIARY_BRANCH = :beneficiaryBranch, LOCATION = :location, PRINT_LOCATION = :printLocation, INSTRUMENT_NO = :instrumentNo, BENEFICIARY_ADDRESS_1 = :beneficiaryAddress1, BENEFICIARY_ADDRESS_2 = :beneficiaryAddress2, BENEFICIARY_ADDRESS_3 = :beneficiaryAddress3, BENEFICIARY_ADDRESS_4 = :beneficiaryAddress4, BENEFICIARY_EMAIL = :beneficiaryEmail, BENEFICIARY_MOBILE = :beneficiaryMobile, DEBIT_NARRATION = :debitNarration, CREDIT_NARRATION = :creditNarration, PAYMENT_DETAILS_1 = :paymentDetails1, PAYMENT_DETAILS_2 = :paymentDetails2, PAYMENT_DETAILS_3 = :paymentDetails3, PAYMENT_DETAILS_4 = :paymentDetails4, SR_NO = :srNo, DOCUMENT_NO = :documentNo, INV_REF_NO = :invRefNo, INV_DATE = :invDate, INV_AMOUNT = :invAmount, OTHER_DEDUCTIONS = :otherDeductions, TDS_AMOUNT = :tdsAmount, TOTAL_DEDUCTED_AMOUNT = :totalDeductedAmount, NET_AMOUNT_PAYABLE = :netAmountPayable, UPLOAD_REF_ID = :uploadRefId, LINE_NO = :lineNo, UPLOAD_LAYOUT_UUID = :uploadLayoutUuid, BENEFICIARY_ACC_NO = :beneficiaryAccNo, DR_AC_NO = :drAcNo, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FILE_NAME = :fileName WHERE ID = :id")
    public int update(@BindBean FgVoltasm fgvoltasm);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_VOLTASM WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_VOLTASM")
    public long countAll();

    /**
     * Bulk insert multiple FgVoltasm entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_VOLTASM (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CLIENT_CODE, PRODUCT_CODE, PAYMENT_TYPE, PAYMENT_REF_NO, PAYMENT_DATE, INSTRUMENT_DATE, AMOUNT, BANK_CODE_INDICATOR, BENEFICIARY_CODE, BENEFICIARY_NAME, BENEFICIARY_BANK, BENEFICIARY_BRANCH, LOCATION, PRINT_LOCATION, INSTRUMENT_NO, BENEFICIARY_ADDRESS_1, BENEFICIARY_ADDRESS_2, BENEFICIARY_ADDRESS_3, BENEFICIARY_ADDRESS_4, BENEFICIARY_EMAIL, BENEFICIARY_MOBILE, DEBIT_NARRATION, CREDIT_NARRATION, PAYMENT_DETAILS_1, PAYMENT_DETAILS_2, PAYMENT_DETAILS_3, PAYMENT_DETAILS_4, SR_NO, DOCUMENT_NO, INV_REF_NO, INV_DATE, INV_AMOUNT, OTHER_DEDUCTIONS, TDS_AMOUNT, TOTAL_DEDUCTED_AMOUNT, NET_AMOUNT_PAYABLE, UPLOAD_REF_ID, LINE_NO, UPLOAD_LAYOUT_UUID, BENEFICIARY_ACC_NO, DR_AC_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :clientCode, :productCode, :paymentType, :paymentRefNo, :paymentDate, :instrumentDate, :amount, :bankCodeIndicator, :beneficiaryCode, :beneficiaryName, :beneficiaryBank, :beneficiaryBranch, :location, :printLocation, :instrumentNo, :beneficiaryAddress1, :beneficiaryAddress2, :beneficiaryAddress3, :beneficiaryAddress4, :beneficiaryEmail, :beneficiaryMobile, :debitNarration, :creditNarration, :paymentDetails1, :paymentDetails2, :paymentDetails3, :paymentDetails4, :srNo, :documentNo, :invRefNo, :invDate, :invAmount, :otherDeductions, :tdsAmount, :totalDeductedAmount, :netAmountPayable, :uploadRefId, :lineNo, :uploadLayoutUuid, :beneficiaryAccNo, :drAcNo, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :fileName)")
    public int[] bulkInsert(@BindBean List<FgVoltasm> fgvoltasms);

    /**
     * Bulk update multiple FgVoltasm entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_VOLTASM SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CLIENT_CODE = :clientCode, PRODUCT_CODE = :productCode, PAYMENT_TYPE = :paymentType, PAYMENT_REF_NO = :paymentRefNo, PAYMENT_DATE = :paymentDate, INSTRUMENT_DATE = :instrumentDate, AMOUNT = :amount, BANK_CODE_INDICATOR = :bankCodeIndicator, BENEFICIARY_CODE = :beneficiaryCode, BENEFICIARY_NAME = :beneficiaryName, BENEFICIARY_BANK = :beneficiaryBank, BENEFICIARY_BRANCH = :beneficiaryBranch, LOCATION = :location, PRINT_LOCATION = :printLocation, INSTRUMENT_NO = :instrumentNo, BENEFICIARY_ADDRESS_1 = :beneficiaryAddress1, BENEFICIARY_ADDRESS_2 = :beneficiaryAddress2, BENEFICIARY_ADDRESS_3 = :beneficiaryAddress3, BENEFICIARY_ADDRESS_4 = :beneficiaryAddress4, BENEFICIARY_EMAIL = :beneficiaryEmail, BENEFICIARY_MOBILE = :beneficiaryMobile, DEBIT_NARRATION = :debitNarration, CREDIT_NARRATION = :creditNarration, PAYMENT_DETAILS_1 = :paymentDetails1, PAYMENT_DETAILS_2 = :paymentDetails2, PAYMENT_DETAILS_3 = :paymentDetails3, PAYMENT_DETAILS_4 = :paymentDetails4, SR_NO = :srNo, DOCUMENT_NO = :documentNo, INV_REF_NO = :invRefNo, INV_DATE = :invDate, INV_AMOUNT = :invAmount, OTHER_DEDUCTIONS = :otherDeductions, TDS_AMOUNT = :tdsAmount, TOTAL_DEDUCTED_AMOUNT = :totalDeductedAmount, NET_AMOUNT_PAYABLE = :netAmountPayable, UPLOAD_REF_ID = :uploadRefId, LINE_NO = :lineNo, UPLOAD_LAYOUT_UUID = :uploadLayoutUuid, BENEFICIARY_ACC_NO = :beneficiaryAccNo, DR_AC_NO = :drAcNo, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FILE_NAME = :fileName WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgVoltasm> fgvoltasms);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_VOLTASM WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_VOLTASM WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgVoltasm records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_VOLTASM WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgVoltasm.class)
    public List<FgVoltasm> findByIds(@BindList("ids") Collection<String> ids);
}
