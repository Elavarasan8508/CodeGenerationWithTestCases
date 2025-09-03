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
import com.bsit.codegeneration.entity.FgGodrejBoyce;

public interface FgGodrejBoyceDao {

    /**
     * Inserts a new FgGodrejBoyce and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_GODREJ_BOYCE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SELLER_ID, SUPPLIER_NAME, BUYER_ID, INVOICE_DATE, INVOICE_NO, INVOICE_AMOUNT, CURRENCY, DUE_DATE, REFERENCE_NO, UPLOAD_REF_ID, REMARKS, LINE_NO, SR_NO, TEST1, TEST2, TEST3, TEST4, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, APPLICANT_PARTY, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, FREE_TEXT_1, FREE_TEXT_2, FREE_TEXT_3, PROGRAM_TYPE, CUSTOM_MATURITY_DATE, LAYOUT_ID, LAYOUT_UUID, LOAN_REQUEST_TYPE, PORTAL_BATCH_REF_ID, FINANCE_PARTY, FINANCE_REQUEST_STATUS, FINANCE_REQUESTED) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :sellerId, :supplierName, :buyerId, :invoiceDate, :invoiceNo, :invoiceAmount, :currency, :dueDate, :referenceNo, :uploadRefId, :remarks, :lineNo, :srNo, :test1, :test2, :test3, :test4, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :equivalentAmount, :equivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :applicantParty, :layoutTemplateId, :layoutName, :fileName, :batchStatus, :batchRefId, :batchRemarks, :tiStatus, :tiBatchRefId, :tiRemarks, :tnxDisplayStatus, :tnxDisplayBatchId, :tnxDisplayRemarks, :advanceInterest, :netPayment, :valueDate, :utrNumber, :charges, :freeText1, :freeText2, :freeText3, :programType, :customMaturityDate, :layoutId, :layoutUuid, :loanRequestType, :portalBatchRefId, :financeParty, :financeRequestStatus, :financeRequested)")
    public int insert(@BindBean FgGodrejBoyce fggodrejboyce);

    /**
     * Finds a FgGodrejBoyce by its ID.
     */
    @SqlQuery("SELECT * FROM FG_GODREJ_BOYCE WHERE ID = :id")
    @RegisterBeanMapper(FgGodrejBoyce.class)
    public Optional<FgGodrejBoyce> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_GODREJ_BOYCE")
    @RegisterBeanMapper(FgGodrejBoyce.class)
    public List<FgGodrejBoyce> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_GODREJ_BOYCE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgGodrejBoyce.class)
    public List<FgGodrejBoyce> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgGodrejBoyce and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_GODREJ_BOYCE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SELLER_ID = :sellerId, SUPPLIER_NAME = :supplierName, BUYER_ID = :buyerId, INVOICE_DATE = :invoiceDate, INVOICE_NO = :invoiceNo, INVOICE_AMOUNT = :invoiceAmount, CURRENCY = :currency, DUE_DATE = :dueDate, REFERENCE_NO = :referenceNo, UPLOAD_REF_ID = :uploadRefId, REMARKS = :remarks, LINE_NO = :lineNo, SR_NO = :srNo, TEST1 = :test1, TEST2 = :test2, TEST3 = :test3, TEST4 = :test4, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, APPLICANT_PARTY = :applicantParty, LAYOUT_TEMPLATE_ID = :layoutTemplateId, LAYOUT_NAME = :layoutName, FILE_NAME = :fileName, BATCH_STATUS = :batchStatus, BATCH_REF_ID = :batchRefId, BATCH_REMARKS = :batchRemarks, TI_STATUS = :tiStatus, TI_BATCH_REF_ID = :tiBatchRefId, TI_REMARKS = :tiRemarks, TNX_DISPLAY_STATUS = :tnxDisplayStatus, TNX_DISPLAY_BATCH_ID = :tnxDisplayBatchId, TNX_DISPLAY_REMARKS = :tnxDisplayRemarks, ADVANCE_INTEREST = :advanceInterest, NET_PAYMENT = :netPayment, VALUE_DATE = :valueDate, UTR_NUMBER = :utrNumber, CHARGES = :charges, FREE_TEXT_1 = :freeText1, FREE_TEXT_2 = :freeText2, FREE_TEXT_3 = :freeText3, PROGRAM_TYPE = :programType, CUSTOM_MATURITY_DATE = :customMaturityDate, LAYOUT_ID = :layoutId, LAYOUT_UUID = :layoutUuid, LOAN_REQUEST_TYPE = :loanRequestType, PORTAL_BATCH_REF_ID = :portalBatchRefId, FINANCE_PARTY = :financeParty, FINANCE_REQUEST_STATUS = :financeRequestStatus, FINANCE_REQUESTED = :financeRequested WHERE ID = :id")
    public int update(@BindBean FgGodrejBoyce fggodrejboyce);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_GODREJ_BOYCE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_GODREJ_BOYCE")
    public long countAll();

    /**
     * Bulk insert multiple FgGodrejBoyce entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_GODREJ_BOYCE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SELLER_ID, SUPPLIER_NAME, BUYER_ID, INVOICE_DATE, INVOICE_NO, INVOICE_AMOUNT, CURRENCY, DUE_DATE, REFERENCE_NO, UPLOAD_REF_ID, REMARKS, LINE_NO, SR_NO, TEST1, TEST2, TEST3, TEST4, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, APPLICANT_PARTY, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, FREE_TEXT_1, FREE_TEXT_2, FREE_TEXT_3, PROGRAM_TYPE, CUSTOM_MATURITY_DATE, LAYOUT_ID, LAYOUT_UUID, LOAN_REQUEST_TYPE, PORTAL_BATCH_REF_ID, FINANCE_PARTY, FINANCE_REQUEST_STATUS, FINANCE_REQUESTED) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :sellerId, :supplierName, :buyerId, :invoiceDate, :invoiceNo, :invoiceAmount, :currency, :dueDate, :referenceNo, :uploadRefId, :remarks, :lineNo, :srNo, :test1, :test2, :test3, :test4, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :equivalentAmount, :equivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :applicantParty, :layoutTemplateId, :layoutName, :fileName, :batchStatus, :batchRefId, :batchRemarks, :tiStatus, :tiBatchRefId, :tiRemarks, :tnxDisplayStatus, :tnxDisplayBatchId, :tnxDisplayRemarks, :advanceInterest, :netPayment, :valueDate, :utrNumber, :charges, :freeText1, :freeText2, :freeText3, :programType, :customMaturityDate, :layoutId, :layoutUuid, :loanRequestType, :portalBatchRefId, :financeParty, :financeRequestStatus, :financeRequested)")
    public int[] bulkInsert(@BindBean List<FgGodrejBoyce> fggodrejboyces);

    /**
     * Bulk update multiple FgGodrejBoyce entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_GODREJ_BOYCE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SELLER_ID = :sellerId, SUPPLIER_NAME = :supplierName, BUYER_ID = :buyerId, INVOICE_DATE = :invoiceDate, INVOICE_NO = :invoiceNo, INVOICE_AMOUNT = :invoiceAmount, CURRENCY = :currency, DUE_DATE = :dueDate, REFERENCE_NO = :referenceNo, UPLOAD_REF_ID = :uploadRefId, REMARKS = :remarks, LINE_NO = :lineNo, SR_NO = :srNo, TEST1 = :test1, TEST2 = :test2, TEST3 = :test3, TEST4 = :test4, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, APPLICANT_PARTY = :applicantParty, LAYOUT_TEMPLATE_ID = :layoutTemplateId, LAYOUT_NAME = :layoutName, FILE_NAME = :fileName, BATCH_STATUS = :batchStatus, BATCH_REF_ID = :batchRefId, BATCH_REMARKS = :batchRemarks, TI_STATUS = :tiStatus, TI_BATCH_REF_ID = :tiBatchRefId, TI_REMARKS = :tiRemarks, TNX_DISPLAY_STATUS = :tnxDisplayStatus, TNX_DISPLAY_BATCH_ID = :tnxDisplayBatchId, TNX_DISPLAY_REMARKS = :tnxDisplayRemarks, ADVANCE_INTEREST = :advanceInterest, NET_PAYMENT = :netPayment, VALUE_DATE = :valueDate, UTR_NUMBER = :utrNumber, CHARGES = :charges, FREE_TEXT_1 = :freeText1, FREE_TEXT_2 = :freeText2, FREE_TEXT_3 = :freeText3, PROGRAM_TYPE = :programType, CUSTOM_MATURITY_DATE = :customMaturityDate, LAYOUT_ID = :layoutId, LAYOUT_UUID = :layoutUuid, LOAN_REQUEST_TYPE = :loanRequestType, PORTAL_BATCH_REF_ID = :portalBatchRefId, FINANCE_PARTY = :financeParty, FINANCE_REQUEST_STATUS = :financeRequestStatus, FINANCE_REQUESTED = :financeRequested WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgGodrejBoyce> fggodrejboyces);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_GODREJ_BOYCE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_GODREJ_BOYCE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgGodrejBoyce records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_GODREJ_BOYCE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgGodrejBoyce.class)
    public List<FgGodrejBoyce> findByIds(@BindList("ids") Collection<String> ids);
}
