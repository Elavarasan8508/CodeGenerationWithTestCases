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
import com.bsit.codegeneration.entity.FgUploadAdvice;

public interface FgUploadAdviceDao {

    /**
     * Inserts a new FgUploadAdvice and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_UPLOAD_ADVICE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VENDOR_CODE, INVOICE_NUMBER, INVOICE_DATE, BILL_DUE_DATE, CURRENCY, INVOICE_AMOUNT, INVOICE_REF, SERIAL_NO, DOCUMENT_NO, OTHER_DEDUCTIONS, TOTAL_DEDUCTED_AMOUNT, NET_AMOUNT_PAYABLE, BOE_DATE, PAYMENT_DETAILS_6, PAYMENT_DETAILS_7, PAYMENT_DETAILS_8, PAYMENT_DETAILS_9, PAYMENT_DETAILS_10, CLIENT_REF_NO, INVOICE_DR_NOTE_DATE, INVOICE_DR_NOTE_NO, TENURE, INTEREST_RATE, AMOUNT_A, AMOUNT_B, AMOUNT_C, INVOICE_DEBIT_NOTE_AMOUNT, NARRATION, BILL_NO, NET_AMOUNT, BILL_DATE, HUNDI_NUMBER, LINE_NO_OF_ADVICE, ANNEXURE_TEXT_CONTENT, INVOICE_DATE_SOMANY, PARENT_REF_ID, PARENT_VERSION_ID, DISCOUNT_RATE, GROSS_AMOUNT, TDS_AMOUNT, BANK_CHARGES, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :vendorCode, :invoiceNumber, :invoiceDate, :billDueDate, :currency, :invoiceAmount, :invoiceRef, :serialNo, :documentNo, :otherDeductions, :totalDeductedAmount, :netAmountPayable, :boeDate, :paymentDetails6, :paymentDetails7, :paymentDetails8, :paymentDetails9, :paymentDetails10, :clientRefNo, :invoiceDrNoteDate, :invoiceDrNoteNo, :tenure, :interestRate, :amountA, :amountB, :amountC, :invoiceDebitNoteAmount, :narration, :billNo, :netAmount, :billDate, :hundiNumber, :lineNoOfAdvice, :annexureTextContent, :invoiceDateSomany, :parentRefId, :parentVersionId, :discountRate, :grossAmount, :tdsAmount, :bankCharges, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate)")
    public int insert(@BindBean FgUploadAdvice fguploadadvice);

    /**
     * Finds a FgUploadAdvice by its ID.
     */
    @SqlQuery("SELECT * FROM FG_UPLOAD_ADVICE WHERE ID = :id")
    @RegisterBeanMapper(FgUploadAdvice.class)
    public Optional<FgUploadAdvice> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_UPLOAD_ADVICE")
    @RegisterBeanMapper(FgUploadAdvice.class)
    public List<FgUploadAdvice> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_UPLOAD_ADVICE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgUploadAdvice.class)
    public List<FgUploadAdvice> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgUploadAdvice and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_UPLOAD_ADVICE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, VENDOR_CODE = :vendorCode, INVOICE_NUMBER = :invoiceNumber, INVOICE_DATE = :invoiceDate, BILL_DUE_DATE = :billDueDate, CURRENCY = :currency, INVOICE_AMOUNT = :invoiceAmount, INVOICE_REF = :invoiceRef, SERIAL_NO = :serialNo, DOCUMENT_NO = :documentNo, OTHER_DEDUCTIONS = :otherDeductions, TOTAL_DEDUCTED_AMOUNT = :totalDeductedAmount, NET_AMOUNT_PAYABLE = :netAmountPayable, BOE_DATE = :boeDate, PAYMENT_DETAILS_6 = :paymentDetails6, PAYMENT_DETAILS_7 = :paymentDetails7, PAYMENT_DETAILS_8 = :paymentDetails8, PAYMENT_DETAILS_9 = :paymentDetails9, PAYMENT_DETAILS_10 = :paymentDetails10, CLIENT_REF_NO = :clientRefNo, INVOICE_DR_NOTE_DATE = :invoiceDrNoteDate, INVOICE_DR_NOTE_NO = :invoiceDrNoteNo, TENURE = :tenure, INTEREST_RATE = :interestRate, AMOUNT_A = :amountA, AMOUNT_B = :amountB, AMOUNT_C = :amountC, INVOICE_DEBIT_NOTE_AMOUNT = :invoiceDebitNoteAmount, NARRATION = :narration, BILL_NO = :billNo, NET_AMOUNT = :netAmount, BILL_DATE = :billDate, HUNDI_NUMBER = :hundiNumber, LINE_NO_OF_ADVICE = :lineNoOfAdvice, ANNEXURE_TEXT_CONTENT = :annexureTextContent, INVOICE_DATE_SOMANY = :invoiceDateSomany, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, DISCOUNT_RATE = :discountRate, GROSS_AMOUNT = :grossAmount, TDS_AMOUNT = :tdsAmount, BANK_CHARGES = :bankCharges, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate WHERE ID = :id")
    public int update(@BindBean FgUploadAdvice fguploadadvice);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_UPLOAD_ADVICE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_UPLOAD_ADVICE")
    public long countAll();

    /**
     * Bulk insert multiple FgUploadAdvice entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_UPLOAD_ADVICE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VENDOR_CODE, INVOICE_NUMBER, INVOICE_DATE, BILL_DUE_DATE, CURRENCY, INVOICE_AMOUNT, INVOICE_REF, SERIAL_NO, DOCUMENT_NO, OTHER_DEDUCTIONS, TOTAL_DEDUCTED_AMOUNT, NET_AMOUNT_PAYABLE, BOE_DATE, PAYMENT_DETAILS_6, PAYMENT_DETAILS_7, PAYMENT_DETAILS_8, PAYMENT_DETAILS_9, PAYMENT_DETAILS_10, CLIENT_REF_NO, INVOICE_DR_NOTE_DATE, INVOICE_DR_NOTE_NO, TENURE, INTEREST_RATE, AMOUNT_A, AMOUNT_B, AMOUNT_C, INVOICE_DEBIT_NOTE_AMOUNT, NARRATION, BILL_NO, NET_AMOUNT, BILL_DATE, HUNDI_NUMBER, LINE_NO_OF_ADVICE, ANNEXURE_TEXT_CONTENT, INVOICE_DATE_SOMANY, PARENT_REF_ID, PARENT_VERSION_ID, DISCOUNT_RATE, GROSS_AMOUNT, TDS_AMOUNT, BANK_CHARGES, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :vendorCode, :invoiceNumber, :invoiceDate, :billDueDate, :currency, :invoiceAmount, :invoiceRef, :serialNo, :documentNo, :otherDeductions, :totalDeductedAmount, :netAmountPayable, :boeDate, :paymentDetails6, :paymentDetails7, :paymentDetails8, :paymentDetails9, :paymentDetails10, :clientRefNo, :invoiceDrNoteDate, :invoiceDrNoteNo, :tenure, :interestRate, :amountA, :amountB, :amountC, :invoiceDebitNoteAmount, :narration, :billNo, :netAmount, :billDate, :hundiNumber, :lineNoOfAdvice, :annexureTextContent, :invoiceDateSomany, :parentRefId, :parentVersionId, :discountRate, :grossAmount, :tdsAmount, :bankCharges, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate)")
    public int[] bulkInsert(@BindBean List<FgUploadAdvice> fguploadadvices);

    /**
     * Bulk update multiple FgUploadAdvice entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_UPLOAD_ADVICE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, VENDOR_CODE = :vendorCode, INVOICE_NUMBER = :invoiceNumber, INVOICE_DATE = :invoiceDate, BILL_DUE_DATE = :billDueDate, CURRENCY = :currency, INVOICE_AMOUNT = :invoiceAmount, INVOICE_REF = :invoiceRef, SERIAL_NO = :serialNo, DOCUMENT_NO = :documentNo, OTHER_DEDUCTIONS = :otherDeductions, TOTAL_DEDUCTED_AMOUNT = :totalDeductedAmount, NET_AMOUNT_PAYABLE = :netAmountPayable, BOE_DATE = :boeDate, PAYMENT_DETAILS_6 = :paymentDetails6, PAYMENT_DETAILS_7 = :paymentDetails7, PAYMENT_DETAILS_8 = :paymentDetails8, PAYMENT_DETAILS_9 = :paymentDetails9, PAYMENT_DETAILS_10 = :paymentDetails10, CLIENT_REF_NO = :clientRefNo, INVOICE_DR_NOTE_DATE = :invoiceDrNoteDate, INVOICE_DR_NOTE_NO = :invoiceDrNoteNo, TENURE = :tenure, INTEREST_RATE = :interestRate, AMOUNT_A = :amountA, AMOUNT_B = :amountB, AMOUNT_C = :amountC, INVOICE_DEBIT_NOTE_AMOUNT = :invoiceDebitNoteAmount, NARRATION = :narration, BILL_NO = :billNo, NET_AMOUNT = :netAmount, BILL_DATE = :billDate, HUNDI_NUMBER = :hundiNumber, LINE_NO_OF_ADVICE = :lineNoOfAdvice, ANNEXURE_TEXT_CONTENT = :annexureTextContent, INVOICE_DATE_SOMANY = :invoiceDateSomany, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, DISCOUNT_RATE = :discountRate, GROSS_AMOUNT = :grossAmount, TDS_AMOUNT = :tdsAmount, BANK_CHARGES = :bankCharges, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgUploadAdvice> fguploadadvices);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_UPLOAD_ADVICE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_UPLOAD_ADVICE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgUploadAdvice records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_UPLOAD_ADVICE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgUploadAdvice.class)
    public List<FgUploadAdvice> findByIds(@BindList("ids") Collection<String> ids);
}
