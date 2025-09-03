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
import com.bsit.codegeneration.entity.FgMandml;

public interface FgMandmlDao {

    /**
     * Inserts a new FgMandml and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MANDML (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, RECORD_INDICATOR, VENDOR_NAME, PAYEE_NAME, ADDRESS_1, ADDRESS_2, ADDRESS_3, CITY, PAYEE_TYPE, PAYEE_ACCOUNT, IFSC, INVOICE_NUMBER, CURRENCY_CODE, AMOUNT, START_DATE, END_DATE, TRANS_ID, INTEREST_RATE, EMAIL, UPLOAD_REF_ID, LINE_NO, CLIENT_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, ISSUING_PARTY_CODE, APPLICANT_PARTY_CODE, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, LAYOUT_NAME, CUSTOM_MATURITY_DATE, LAYOUT_UUID, LOAN_REQUEST_TYPE, FINANCE_PARTY, FINANCE_REQUEST_STATUS, LAYOUT_TEMPLATE_ID, FINANCE_REQUESTED) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :recordIndicator, :vendorName, :payeeName, :address1, :address2, :address3, :city, :payeeType, :payeeAccount, :ifsc, :invoiceNumber, :currencyCode, :amount, :startDate, :endDate, :transId, :interestRate, :email, :uploadRefId, :lineNo, :clientCode, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :issuingPartyCode, :applicantPartyCode, :fileName, :batchStatus, :batchRefId, :batchRemarks, :tiStatus, :tiBatchRefId, :tiRemarks, :tnxDisplayStatus, :tnxDisplayBatchId, :tnxDisplayRemarks, :advanceInterest, :netPayment, :valueDate, :utrNumber, :charges, :layoutName, :customMaturityDate, :layoutUuid, :loanRequestType, :financeParty, :financeRequestStatus, :layoutTemplateId, :financeRequested)")
    public int insert(@BindBean FgMandml fgmandml);

    /**
     * Finds a FgMandml by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MANDML WHERE ID = :id")
    @RegisterBeanMapper(FgMandml.class)
    public Optional<FgMandml> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MANDML")
    @RegisterBeanMapper(FgMandml.class)
    public List<FgMandml> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MANDML ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgMandml.class)
    public List<FgMandml> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgMandml and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MANDML SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, RECORD_INDICATOR = :recordIndicator, VENDOR_NAME = :vendorName, PAYEE_NAME = :payeeName, ADDRESS_1 = :address1, ADDRESS_2 = :address2, ADDRESS_3 = :address3, CITY = :city, PAYEE_TYPE = :payeeType, PAYEE_ACCOUNT = :payeeAccount, IFSC = :ifsc, INVOICE_NUMBER = :invoiceNumber, CURRENCY_CODE = :currencyCode, AMOUNT = :amount, START_DATE = :startDate, END_DATE = :endDate, TRANS_ID = :transId, INTEREST_RATE = :interestRate, EMAIL = :email, UPLOAD_REF_ID = :uploadRefId, LINE_NO = :lineNo, CLIENT_CODE = :clientCode, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, ISSUING_PARTY_CODE = :issuingPartyCode, APPLICANT_PARTY_CODE = :applicantPartyCode, FILE_NAME = :fileName, BATCH_STATUS = :batchStatus, BATCH_REF_ID = :batchRefId, BATCH_REMARKS = :batchRemarks, TI_STATUS = :tiStatus, TI_BATCH_REF_ID = :tiBatchRefId, TI_REMARKS = :tiRemarks, TNX_DISPLAY_STATUS = :tnxDisplayStatus, TNX_DISPLAY_BATCH_ID = :tnxDisplayBatchId, TNX_DISPLAY_REMARKS = :tnxDisplayRemarks, ADVANCE_INTEREST = :advanceInterest, NET_PAYMENT = :netPayment, VALUE_DATE = :valueDate, UTR_NUMBER = :utrNumber, CHARGES = :charges, LAYOUT_NAME = :layoutName, CUSTOM_MATURITY_DATE = :customMaturityDate, LAYOUT_UUID = :layoutUuid, LOAN_REQUEST_TYPE = :loanRequestType, FINANCE_PARTY = :financeParty, FINANCE_REQUEST_STATUS = :financeRequestStatus, LAYOUT_TEMPLATE_ID = :layoutTemplateId, FINANCE_REQUESTED = :financeRequested WHERE ID = :id")
    public int update(@BindBean FgMandml fgmandml);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MANDML WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MANDML")
    public long countAll();

    /**
     * Bulk insert multiple FgMandml entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MANDML (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, RECORD_INDICATOR, VENDOR_NAME, PAYEE_NAME, ADDRESS_1, ADDRESS_2, ADDRESS_3, CITY, PAYEE_TYPE, PAYEE_ACCOUNT, IFSC, INVOICE_NUMBER, CURRENCY_CODE, AMOUNT, START_DATE, END_DATE, TRANS_ID, INTEREST_RATE, EMAIL, UPLOAD_REF_ID, LINE_NO, CLIENT_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, ISSUING_PARTY_CODE, APPLICANT_PARTY_CODE, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, LAYOUT_NAME, CUSTOM_MATURITY_DATE, LAYOUT_UUID, LOAN_REQUEST_TYPE, FINANCE_PARTY, FINANCE_REQUEST_STATUS, LAYOUT_TEMPLATE_ID, FINANCE_REQUESTED) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :recordIndicator, :vendorName, :payeeName, :address1, :address2, :address3, :city, :payeeType, :payeeAccount, :ifsc, :invoiceNumber, :currencyCode, :amount, :startDate, :endDate, :transId, :interestRate, :email, :uploadRefId, :lineNo, :clientCode, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :issuingPartyCode, :applicantPartyCode, :fileName, :batchStatus, :batchRefId, :batchRemarks, :tiStatus, :tiBatchRefId, :tiRemarks, :tnxDisplayStatus, :tnxDisplayBatchId, :tnxDisplayRemarks, :advanceInterest, :netPayment, :valueDate, :utrNumber, :charges, :layoutName, :customMaturityDate, :layoutUuid, :loanRequestType, :financeParty, :financeRequestStatus, :layoutTemplateId, :financeRequested)")
    public int[] bulkInsert(@BindBean List<FgMandml> fgmandmls);

    /**
     * Bulk update multiple FgMandml entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MANDML SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, RECORD_INDICATOR = :recordIndicator, VENDOR_NAME = :vendorName, PAYEE_NAME = :payeeName, ADDRESS_1 = :address1, ADDRESS_2 = :address2, ADDRESS_3 = :address3, CITY = :city, PAYEE_TYPE = :payeeType, PAYEE_ACCOUNT = :payeeAccount, IFSC = :ifsc, INVOICE_NUMBER = :invoiceNumber, CURRENCY_CODE = :currencyCode, AMOUNT = :amount, START_DATE = :startDate, END_DATE = :endDate, TRANS_ID = :transId, INTEREST_RATE = :interestRate, EMAIL = :email, UPLOAD_REF_ID = :uploadRefId, LINE_NO = :lineNo, CLIENT_CODE = :clientCode, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, ISSUING_PARTY_CODE = :issuingPartyCode, APPLICANT_PARTY_CODE = :applicantPartyCode, FILE_NAME = :fileName, BATCH_STATUS = :batchStatus, BATCH_REF_ID = :batchRefId, BATCH_REMARKS = :batchRemarks, TI_STATUS = :tiStatus, TI_BATCH_REF_ID = :tiBatchRefId, TI_REMARKS = :tiRemarks, TNX_DISPLAY_STATUS = :tnxDisplayStatus, TNX_DISPLAY_BATCH_ID = :tnxDisplayBatchId, TNX_DISPLAY_REMARKS = :tnxDisplayRemarks, ADVANCE_INTEREST = :advanceInterest, NET_PAYMENT = :netPayment, VALUE_DATE = :valueDate, UTR_NUMBER = :utrNumber, CHARGES = :charges, LAYOUT_NAME = :layoutName, CUSTOM_MATURITY_DATE = :customMaturityDate, LAYOUT_UUID = :layoutUuid, LOAN_REQUEST_TYPE = :loanRequestType, FINANCE_PARTY = :financeParty, FINANCE_REQUEST_STATUS = :financeRequestStatus, LAYOUT_TEMPLATE_ID = :layoutTemplateId, FINANCE_REQUESTED = :financeRequested WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgMandml> fgmandmls);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MANDML WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MANDML WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgMandml records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MANDML WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgMandml.class)
    public List<FgMandml> findByIds(@BindList("ids") Collection<String> ids);
}
