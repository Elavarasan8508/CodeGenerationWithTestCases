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
import com.bsit.codegeneration.entity.FgScfTransactions;

public interface FgScfTransactionsDao {

    /**
     * Inserts a new FgScfTransactions and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SCF_TRANSACTIONS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INVOICE_NO, VENDOR_CODE, INVOICE_AMOUNT, INVOICE_DATE, DUE_DATE, UPLOAD_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :invoiceNo, :vendorCode, :invoiceAmount, :invoiceDate, :dueDate, :uploadRefId)")
    public int insert(@BindBean FgScfTransactions fgscftransactions);

    /**
     * Finds a FgScfTransactions by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SCF_TRANSACTIONS WHERE ID = :id")
    @RegisterBeanMapper(FgScfTransactions.class)
    public Optional<FgScfTransactions> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SCF_TRANSACTIONS")
    @RegisterBeanMapper(FgScfTransactions.class)
    public List<FgScfTransactions> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SCF_TRANSACTIONS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgScfTransactions.class)
    public List<FgScfTransactions> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgScfTransactions and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SCF_TRANSACTIONS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, INVOICE_NO = :invoiceNo, VENDOR_CODE = :vendorCode, INVOICE_AMOUNT = :invoiceAmount, INVOICE_DATE = :invoiceDate, DUE_DATE = :dueDate, UPLOAD_REF_ID = :uploadRefId WHERE ID = :id")
    public int update(@BindBean FgScfTransactions fgscftransactions);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SCF_TRANSACTIONS WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SCF_TRANSACTIONS")
    public long countAll();

    /**
     * Bulk insert multiple FgScfTransactions entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SCF_TRANSACTIONS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, INVOICE_NO, VENDOR_CODE, INVOICE_AMOUNT, INVOICE_DATE, DUE_DATE, UPLOAD_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :invoiceNo, :vendorCode, :invoiceAmount, :invoiceDate, :dueDate, :uploadRefId)")
    public int[] bulkInsert(@BindBean List<FgScfTransactions> fgscftransactionss);

    /**
     * Bulk update multiple FgScfTransactions entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SCF_TRANSACTIONS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, INVOICE_NO = :invoiceNo, VENDOR_CODE = :vendorCode, INVOICE_AMOUNT = :invoiceAmount, INVOICE_DATE = :invoiceDate, DUE_DATE = :dueDate, UPLOAD_REF_ID = :uploadRefId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgScfTransactions> fgscftransactionss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SCF_TRANSACTIONS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SCF_TRANSACTIONS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgScfTransactions records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SCF_TRANSACTIONS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgScfTransactions.class)
    public List<FgScfTransactions> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
