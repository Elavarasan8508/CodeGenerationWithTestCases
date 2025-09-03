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
import com.bsit.codegeneration.entity.APIOutstandingBoeDetail;

public interface APIOutstandingBoeDetailDao {

    /**
     * Inserts a new APIOutstandingBoeDetail and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO API_OUTSTANDING_BOE_DETAIL (BOE_NUMBER, BOE_DATE, DISCHARGE_PORT, IMPORT_AGENCY, IE_CODE, INVOICE_SERIAL_NUMBER, INVOICE_NUMBER, INVOICE_TERM, SUPPLIER_NAME, SUPPLIER_ADDRESS, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDRESS, SELLER_COUNTRY, FOB_CURRENCY, FOB_VALUE, UTILIZED_FOB_VALUE, REFERENCE_ID) VALUES (:boeNumber, :boeDate, :dischargePort, :importAgency, :ieCode, :invoiceSerialNumber, :invoiceNumber, :invoiceTerm, :supplierName, :supplierAddress, :supplierCountry, :sellerName, :sellerAddress, :sellerCountry, :fobCurrency, :fobValue, :utilizedFobValue, :referenceId)")
    public int insert(@BindBean APIOutstandingBoeDetail apioutstandingboedetail);

    /**
     * Finds a APIOutstandingBoeDetail by its ID.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_BOE_DETAIL WHERE API_OUTSTANDING_BOE_DETAIL_id = :id")
    @RegisterBeanMapper(APIOutstandingBoeDetail.class)
    public Optional<APIOutstandingBoeDetail> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_BOE_DETAIL")
    @RegisterBeanMapper(APIOutstandingBoeDetail.class)
    public List<APIOutstandingBoeDetail> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_BOE_DETAIL ORDER BY API_OUTSTANDING_BOE_DETAIL_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(APIOutstandingBoeDetail.class)
    public List<APIOutstandingBoeDetail> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a APIOutstandingBoeDetail and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE API_OUTSTANDING_BOE_DETAIL SET BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, DISCHARGE_PORT = :dischargePort, IMPORT_AGENCY = :importAgency, IE_CODE = :ieCode, INVOICE_SERIAL_NUMBER = :invoiceSerialNumber, INVOICE_NUMBER = :invoiceNumber, INVOICE_TERM = :invoiceTerm, SUPPLIER_NAME = :supplierName, SUPPLIER_ADDRESS = :supplierAddress, SUPPLIER_COUNTRY = :supplierCountry, SELLER_NAME = :sellerName, SELLER_ADDRESS = :sellerAddress, SELLER_COUNTRY = :sellerCountry, FOB_CURRENCY = :fobCurrency, FOB_VALUE = :fobValue, UTILIZED_FOB_VALUE = :utilizedFobValue, REFERENCE_ID = :referenceId WHERE API_OUTSTANDING_BOE_DETAIL_id = :APIOutstandingBoeDetailId")
    public int update(@BindBean APIOutstandingBoeDetail apioutstandingboedetail);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM API_OUTSTANDING_BOE_DETAIL WHERE API_OUTSTANDING_BOE_DETAIL_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM API_OUTSTANDING_BOE_DETAIL")
    public long countAll();

    /**
     * Bulk insert multiple APIOutstandingBoeDetail entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO API_OUTSTANDING_BOE_DETAIL (BOE_NUMBER, BOE_DATE, DISCHARGE_PORT, IMPORT_AGENCY, IE_CODE, INVOICE_SERIAL_NUMBER, INVOICE_NUMBER, INVOICE_TERM, SUPPLIER_NAME, SUPPLIER_ADDRESS, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDRESS, SELLER_COUNTRY, FOB_CURRENCY, FOB_VALUE, UTILIZED_FOB_VALUE, REFERENCE_ID) VALUES (:boeNumber, :boeDate, :dischargePort, :importAgency, :ieCode, :invoiceSerialNumber, :invoiceNumber, :invoiceTerm, :supplierName, :supplierAddress, :supplierCountry, :sellerName, :sellerAddress, :sellerCountry, :fobCurrency, :fobValue, :utilizedFobValue, :referenceId)")
    public int[] bulkInsert(@BindBean List<APIOutstandingBoeDetail> apioutstandingboedetails);

    /**
     * Bulk update multiple APIOutstandingBoeDetail entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE API_OUTSTANDING_BOE_DETAIL SET BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, DISCHARGE_PORT = :dischargePort, IMPORT_AGENCY = :importAgency, IE_CODE = :ieCode, INVOICE_SERIAL_NUMBER = :invoiceSerialNumber, INVOICE_NUMBER = :invoiceNumber, INVOICE_TERM = :invoiceTerm, SUPPLIER_NAME = :supplierName, SUPPLIER_ADDRESS = :supplierAddress, SUPPLIER_COUNTRY = :supplierCountry, SELLER_NAME = :sellerName, SELLER_ADDRESS = :sellerAddress, SELLER_COUNTRY = :sellerCountry, FOB_CURRENCY = :fobCurrency, FOB_VALUE = :fobValue, UTILIZED_FOB_VALUE = :utilizedFobValue, REFERENCE_ID = :referenceId WHERE API_OUTSTANDING_BOE_DETAIL_id = :APIOutstandingBoeDetailId")
    public int[] bulkUpdate(@BindBean List<APIOutstandingBoeDetail> apioutstandingboedetails);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM API_OUTSTANDING_BOE_DETAIL WHERE API_OUTSTANDING_BOE_DETAIL_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM API_OUTSTANDING_BOE_DETAIL WHERE API_OUTSTANDING_BOE_DETAIL_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple APIOutstandingBoeDetail records by their IDs.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_BOE_DETAIL WHERE API_OUTSTANDING_BOE_DETAIL_id IN (<ids>)")
    @RegisterBeanMapper(APIOutstandingBoeDetail.class)
    public List<APIOutstandingBoeDetail> findByIds(@BindList("ids") Collection<Integer> ids);
}
