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
import com.bsit.codegeneration.entity.FgInvoiceData;

public interface FgInvoiceDataDao {

    /**
     * Inserts a new FgInvoiceData and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_INVOICE_DATA (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INVOICE_NUMBER, DATE, COMPANY_NAME, CONTACT_NO, SERVICE_FEE, COMPANY_ADDR) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :invoiceNumber, :date, :companyName, :contactNo, :serviceFee, :companyAddr)")
    public int insert(@BindBean FgInvoiceData fginvoicedata);

    /**
     * Finds a FgInvoiceData by its ID.
     */
    @SqlQuery("SELECT * FROM FG_INVOICE_DATA WHERE FG_INVOICE_DATA_id = :id")
    @RegisterBeanMapper(FgInvoiceData.class)
    public Optional<FgInvoiceData> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_INVOICE_DATA")
    @RegisterBeanMapper(FgInvoiceData.class)
    public List<FgInvoiceData> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_INVOICE_DATA ORDER BY FG_INVOICE_DATA_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgInvoiceData.class)
    public List<FgInvoiceData> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgInvoiceData and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_INVOICE_DATA SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, INVOICE_NUMBER = :invoiceNumber, DATE = :date, COMPANY_NAME = :companyName, CONTACT_NO = :contactNo, SERVICE_FEE = :serviceFee, COMPANY_ADDR = :companyAddr WHERE FG_INVOICE_DATA_id = :fgInvoiceDataId")
    public int update(@BindBean FgInvoiceData fginvoicedata);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_INVOICE_DATA WHERE FG_INVOICE_DATA_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_INVOICE_DATA")
    public long countAll();

    /**
     * Bulk insert multiple FgInvoiceData entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_INVOICE_DATA (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INVOICE_NUMBER, DATE, COMPANY_NAME, CONTACT_NO, SERVICE_FEE, COMPANY_ADDR) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :invoiceNumber, :date, :companyName, :contactNo, :serviceFee, :companyAddr)")
    public int[] bulkInsert(@BindBean List<FgInvoiceData> fginvoicedatas);

    /**
     * Bulk update multiple FgInvoiceData entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_INVOICE_DATA SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, INVOICE_NUMBER = :invoiceNumber, DATE = :date, COMPANY_NAME = :companyName, CONTACT_NO = :contactNo, SERVICE_FEE = :serviceFee, COMPANY_ADDR = :companyAddr WHERE FG_INVOICE_DATA_id = :fgInvoiceDataId")
    public int[] bulkUpdate(@BindBean List<FgInvoiceData> fginvoicedatas);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_INVOICE_DATA WHERE FG_INVOICE_DATA_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_INVOICE_DATA WHERE FG_INVOICE_DATA_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgInvoiceData records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_INVOICE_DATA WHERE FG_INVOICE_DATA_id IN (<ids>)")
    @RegisterBeanMapper(FgInvoiceData.class)
    public List<FgInvoiceData> findByIds(@BindList("ids") Collection<Integer> ids);
}
