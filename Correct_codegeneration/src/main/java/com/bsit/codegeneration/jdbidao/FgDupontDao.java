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
import com.bsit.codegeneration.entity.FgDupont;

public interface FgDupontDao {

    /**
     * Inserts a new FgDupont and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_DUPONT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, RAISED_BY, UPLOAD_DATE, VENDOR_NAME, CRN, INVOICE_DATE, INVOICE_NUMBER, DUE_DATE_OF_INVOICE, CURRENCY, STATE, VENDOR_CODE, DISCOUNTING_DATE, UPLOAD_REF_ID, INVOICE_AMOUNT, FUNDING_AMOUNT, LINE_NO, CUSTOMER_AC_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, LAYOUT_NAME, CUSTOM_MATURITY_DATE, LAYOUT_UUID, LOAN_REQUEST_TYPE, FINANCE_PARTY, FINANCE_REQUEST_STATUS, FINANCE_REQUESTED, LAYOUT_TEMPLATE_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :raisedBy, :uploadDate, :vendorName, :crn, :invoiceDate, :invoiceNumber, :dueDateOfInvoice, :currency, :state, :vendorCode, :discountingDate, :uploadRefId, :invoiceAmount, :fundingAmount, :lineNo, :customerAcNo, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :fileName, :batchStatus, :batchRefId, :batchRemarks, :tiStatus, :tiBatchRefId, :tiRemarks, :tnxDisplayStatus, :tnxDisplayBatchId, :tnxDisplayRemarks, :applicantPartyCode, :issuingPartyCode, :advanceInterest, :netPayment, :valueDate, :utrNumber, :charges, :layoutName, :customMaturityDate, :layoutUuid, :loanRequestType, :financeParty, :financeRequestStatus, :financeRequested, :layoutTemplateId)")
    public int insert(@BindBean FgDupont fgdupont);

    /**
     * Finds a FgDupont by its ID.
     */
    @SqlQuery("SELECT * FROM FG_DUPONT WHERE FG_DUPONT_id = :id")
    @RegisterBeanMapper(FgDupont.class)
    public Optional<FgDupont> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_DUPONT")
    @RegisterBeanMapper(FgDupont.class)
    public List<FgDupont> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_DUPONT ORDER BY FG_DUPONT_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgDupont.class)
    public List<FgDupont> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgDupont and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_DUPONT SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, RAISED_BY = :raisedBy, UPLOAD_DATE = :uploadDate, VENDOR_NAME = :vendorName, CRN = :crn, INVOICE_DATE = :invoiceDate, INVOICE_NUMBER = :invoiceNumber, DUE_DATE_OF_INVOICE = :dueDateOfInvoice, CURRENCY = :currency, STATE = :state, VENDOR_CODE = :vendorCode, DISCOUNTING_DATE = :discountingDate, UPLOAD_REF_ID = :uploadRefId, INVOICE_AMOUNT = :invoiceAmount, FUNDING_AMOUNT = :fundingAmount, LINE_NO = :lineNo, CUSTOMER_AC_NO = :customerAcNo, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, FILE_NAME = :fileName, BATCH_STATUS = :batchStatus, BATCH_REF_ID = :batchRefId, BATCH_REMARKS = :batchRemarks, TI_STATUS = :tiStatus, TI_BATCH_REF_ID = :tiBatchRefId, TI_REMARKS = :tiRemarks, TNX_DISPLAY_STATUS = :tnxDisplayStatus, TNX_DISPLAY_BATCH_ID = :tnxDisplayBatchId, TNX_DISPLAY_REMARKS = :tnxDisplayRemarks, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, ADVANCE_INTEREST = :advanceInterest, NET_PAYMENT = :netPayment, VALUE_DATE = :valueDate, UTR_NUMBER = :utrNumber, CHARGES = :charges, LAYOUT_NAME = :layoutName, CUSTOM_MATURITY_DATE = :customMaturityDate, LAYOUT_UUID = :layoutUuid, LOAN_REQUEST_TYPE = :loanRequestType, FINANCE_PARTY = :financeParty, FINANCE_REQUEST_STATUS = :financeRequestStatus, FINANCE_REQUESTED = :financeRequested, LAYOUT_TEMPLATE_ID = :layoutTemplateId WHERE FG_DUPONT_id = :fgDupontId")
    public int update(@BindBean FgDupont fgdupont);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DUPONT WHERE FG_DUPONT_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_DUPONT")
    public long countAll();

    /**
     * Bulk insert multiple FgDupont entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_DUPONT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, RAISED_BY, UPLOAD_DATE, VENDOR_NAME, CRN, INVOICE_DATE, INVOICE_NUMBER, DUE_DATE_OF_INVOICE, CURRENCY, STATE, VENDOR_CODE, DISCOUNTING_DATE, UPLOAD_REF_ID, INVOICE_AMOUNT, FUNDING_AMOUNT, LINE_NO, CUSTOMER_AC_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, FILE_NAME, BATCH_STATUS, BATCH_REF_ID, BATCH_REMARKS, TI_STATUS, TI_BATCH_REF_ID, TI_REMARKS, TNX_DISPLAY_STATUS, TNX_DISPLAY_BATCH_ID, TNX_DISPLAY_REMARKS, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, ADVANCE_INTEREST, NET_PAYMENT, VALUE_DATE, UTR_NUMBER, CHARGES, LAYOUT_NAME, CUSTOM_MATURITY_DATE, LAYOUT_UUID, LOAN_REQUEST_TYPE, FINANCE_PARTY, FINANCE_REQUEST_STATUS, FINANCE_REQUESTED, LAYOUT_TEMPLATE_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :raisedBy, :uploadDate, :vendorName, :crn, :invoiceDate, :invoiceNumber, :dueDateOfInvoice, :currency, :state, :vendorCode, :discountingDate, :uploadRefId, :invoiceAmount, :fundingAmount, :lineNo, :customerAcNo, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :fileName, :batchStatus, :batchRefId, :batchRemarks, :tiStatus, :tiBatchRefId, :tiRemarks, :tnxDisplayStatus, :tnxDisplayBatchId, :tnxDisplayRemarks, :applicantPartyCode, :issuingPartyCode, :advanceInterest, :netPayment, :valueDate, :utrNumber, :charges, :layoutName, :customMaturityDate, :layoutUuid, :loanRequestType, :financeParty, :financeRequestStatus, :financeRequested, :layoutTemplateId)")
    public int[] bulkInsert(@BindBean List<FgDupont> fgduponts);

    /**
     * Bulk update multiple FgDupont entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_DUPONT SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, RAISED_BY = :raisedBy, UPLOAD_DATE = :uploadDate, VENDOR_NAME = :vendorName, CRN = :crn, INVOICE_DATE = :invoiceDate, INVOICE_NUMBER = :invoiceNumber, DUE_DATE_OF_INVOICE = :dueDateOfInvoice, CURRENCY = :currency, STATE = :state, VENDOR_CODE = :vendorCode, DISCOUNTING_DATE = :discountingDate, UPLOAD_REF_ID = :uploadRefId, INVOICE_AMOUNT = :invoiceAmount, FUNDING_AMOUNT = :fundingAmount, LINE_NO = :lineNo, CUSTOMER_AC_NO = :customerAcNo, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, FILE_NAME = :fileName, BATCH_STATUS = :batchStatus, BATCH_REF_ID = :batchRefId, BATCH_REMARKS = :batchRemarks, TI_STATUS = :tiStatus, TI_BATCH_REF_ID = :tiBatchRefId, TI_REMARKS = :tiRemarks, TNX_DISPLAY_STATUS = :tnxDisplayStatus, TNX_DISPLAY_BATCH_ID = :tnxDisplayBatchId, TNX_DISPLAY_REMARKS = :tnxDisplayRemarks, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, ADVANCE_INTEREST = :advanceInterest, NET_PAYMENT = :netPayment, VALUE_DATE = :valueDate, UTR_NUMBER = :utrNumber, CHARGES = :charges, LAYOUT_NAME = :layoutName, CUSTOM_MATURITY_DATE = :customMaturityDate, LAYOUT_UUID = :layoutUuid, LOAN_REQUEST_TYPE = :loanRequestType, FINANCE_PARTY = :financeParty, FINANCE_REQUEST_STATUS = :financeRequestStatus, FINANCE_REQUESTED = :financeRequested, LAYOUT_TEMPLATE_ID = :layoutTemplateId WHERE FG_DUPONT_id = :fgDupontId")
    public int[] bulkUpdate(@BindBean List<FgDupont> fgduponts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DUPONT WHERE FG_DUPONT_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_DUPONT WHERE FG_DUPONT_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgDupont records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_DUPONT WHERE FG_DUPONT_id IN (<ids>)")
    @RegisterBeanMapper(FgDupont.class)
    public List<FgDupont> findByIds(@BindList("ids") Collection<Integer> ids);
}
