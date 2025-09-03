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
import com.bsit.codegeneration.entity.FgClearanceInvoice;

public interface FgClearanceInvoiceDao {

    /**
     * Inserts a new FgClearanceInvoice and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_CLEARANCE_INVOICE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INVOICE_NO, INVOICE_DATE, INVOICE_AMOUNT, SHIPPER_NAME, SHIPPER_ADRS_1, SHIPPER_ADRS_2, RECEIVER_NAME, RECEIVER_ADRS_1, RECEIVER_ADRS_2) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :invoiceNo, :invoiceDate, :invoiceAmount, :shipperName, :shipperAdrs1, :shipperAdrs2, :receiverName, :receiverAdrs1, :receiverAdrs2)")
    public int insert(@BindBean FgClearanceInvoice fgclearanceinvoice);

    /**
     * Finds a FgClearanceInvoice by its ID.
     */
    @SqlQuery("SELECT * FROM FG_CLEARANCE_INVOICE WHERE ID = :id")
    @RegisterBeanMapper(FgClearanceInvoice.class)
    public Optional<FgClearanceInvoice> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_CLEARANCE_INVOICE")
    @RegisterBeanMapper(FgClearanceInvoice.class)
    public List<FgClearanceInvoice> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_CLEARANCE_INVOICE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgClearanceInvoice.class)
    public List<FgClearanceInvoice> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgClearanceInvoice and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_CLEARANCE_INVOICE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, INVOICE_NO = :invoiceNo, INVOICE_DATE = :invoiceDate, INVOICE_AMOUNT = :invoiceAmount, SHIPPER_NAME = :shipperName, SHIPPER_ADRS_1 = :shipperAdrs1, SHIPPER_ADRS_2 = :shipperAdrs2, RECEIVER_NAME = :receiverName, RECEIVER_ADRS_1 = :receiverAdrs1, RECEIVER_ADRS_2 = :receiverAdrs2 WHERE ID = :id")
    public int update(@BindBean FgClearanceInvoice fgclearanceinvoice);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CLEARANCE_INVOICE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_CLEARANCE_INVOICE")
    public long countAll();

    /**
     * Bulk insert multiple FgClearanceInvoice entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_CLEARANCE_INVOICE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INVOICE_NO, INVOICE_DATE, INVOICE_AMOUNT, SHIPPER_NAME, SHIPPER_ADRS_1, SHIPPER_ADRS_2, RECEIVER_NAME, RECEIVER_ADRS_1, RECEIVER_ADRS_2) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :invoiceNo, :invoiceDate, :invoiceAmount, :shipperName, :shipperAdrs1, :shipperAdrs2, :receiverName, :receiverAdrs1, :receiverAdrs2)")
    public int[] bulkInsert(@BindBean List<FgClearanceInvoice> fgclearanceinvoices);

    /**
     * Bulk update multiple FgClearanceInvoice entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_CLEARANCE_INVOICE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, INVOICE_NO = :invoiceNo, INVOICE_DATE = :invoiceDate, INVOICE_AMOUNT = :invoiceAmount, SHIPPER_NAME = :shipperName, SHIPPER_ADRS_1 = :shipperAdrs1, SHIPPER_ADRS_2 = :shipperAdrs2, RECEIVER_NAME = :receiverName, RECEIVER_ADRS_1 = :receiverAdrs1, RECEIVER_ADRS_2 = :receiverAdrs2 WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgClearanceInvoice> fgclearanceinvoices);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CLEARANCE_INVOICE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_CLEARANCE_INVOICE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgClearanceInvoice records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_CLEARANCE_INVOICE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgClearanceInvoice.class)
    public List<FgClearanceInvoice> findByIds(@BindList("ids") Collection<String> ids);
}
