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
import com.bsit.codegeneration.entity.FgScfMaTransactions;

public interface FgScfMaTransactionsDao {

    /**
     * Inserts a new FgScfMaTransactions and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SCF_MA_TRANSACTIONS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, REF_ID, INVOICE_NO, INVOICE_DATE, VENDOR_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :refId, :invoiceNo, :invoiceDate, :vendorCode)")
    public int insert(@BindBean FgScfMaTransactions fgscfmatransactions);

    /**
     * Finds a FgScfMaTransactions by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SCF_MA_TRANSACTIONS WHERE ID = :id")
    @RegisterBeanMapper(FgScfMaTransactions.class)
    public Optional<FgScfMaTransactions> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SCF_MA_TRANSACTIONS")
    @RegisterBeanMapper(FgScfMaTransactions.class)
    public List<FgScfMaTransactions> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SCF_MA_TRANSACTIONS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgScfMaTransactions.class)
    public List<FgScfMaTransactions> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgScfMaTransactions and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SCF_MA_TRANSACTIONS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, REF_ID = :refId, INVOICE_NO = :invoiceNo, INVOICE_DATE = :invoiceDate, VENDOR_CODE = :vendorCode WHERE ID = :id")
    public int update(@BindBean FgScfMaTransactions fgscfmatransactions);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SCF_MA_TRANSACTIONS WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SCF_MA_TRANSACTIONS")
    public long countAll();

    /**
     * Bulk insert multiple FgScfMaTransactions entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SCF_MA_TRANSACTIONS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, REF_ID, INVOICE_NO, INVOICE_DATE, VENDOR_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :refId, :invoiceNo, :invoiceDate, :vendorCode)")
    public int[] bulkInsert(@BindBean List<FgScfMaTransactions> fgscfmatransactionss);

    /**
     * Bulk update multiple FgScfMaTransactions entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SCF_MA_TRANSACTIONS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, REF_ID = :refId, INVOICE_NO = :invoiceNo, INVOICE_DATE = :invoiceDate, VENDOR_CODE = :vendorCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgScfMaTransactions> fgscfmatransactionss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SCF_MA_TRANSACTIONS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SCF_MA_TRANSACTIONS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgScfMaTransactions records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SCF_MA_TRANSACTIONS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgScfMaTransactions.class)
    public List<FgScfMaTransactions> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
