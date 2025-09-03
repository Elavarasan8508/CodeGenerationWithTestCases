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
import com.bsit.codegeneration.entity.APIOutstandingBillDetail;

public interface APIOutstandingBillDetailDao {

    /**
     * Inserts a new APIOutstandingBillDetail and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO API_OUTSTANDING_BILL_DETAIL (INSURANCE_AMOUNT, UTILIZED_INSURANCE_AMOUNT, BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, SHIPPINGBILL_NO, FORM_NO, SHIPPINGBILL_DATE, LEO_DATE, AD_CODE, PORT_OF_LOADING, EXPORT_AGENCY, EXPORT_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INVOICE_NO, INVOICE_DATE, INVOICE_SERIAL_NO, FOB_CURRENCY, FRIEGHT_CURRENCY, INSURANCE_CURRENCY, FOB_AMOUNT, UTILIZED_FOB_AMOUNT, FREIGHT_AMOUNT, UTILIZED_FREIGHT_AMOUNT) VALUES (:insuranceAmount, :utilizedInsuranceAmount, :billId, :invoiceId, :shippingBillStatus, :shippingbillNo, :formNo, :shippingbillDate, :leoDate, :adCode, :portOfLoading, :exportAgency, :exportType, :ieCode, :adBillNumber, :invoiceStatus, :invoiceNo, :invoiceDate, :invoiceSerialNo, :fobCurrency, :frieghtCurrency, :insuranceCurrency, :fobAmount, :utilizedFobAmount, :freightAmount, :utilizedFreightAmount)")
    public int insert(@BindBean APIOutstandingBillDetail apioutstandingbilldetail);

    /**
     * Finds a APIOutstandingBillDetail by its ID.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_BILL_DETAIL WHERE API_OUTSTANDING_BILL_DETAIL_id = :id")
    @RegisterBeanMapper(APIOutstandingBillDetail.class)
    public Optional<APIOutstandingBillDetail> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_BILL_DETAIL")
    @RegisterBeanMapper(APIOutstandingBillDetail.class)
    public List<APIOutstandingBillDetail> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_BILL_DETAIL ORDER BY API_OUTSTANDING_BILL_DETAIL_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(APIOutstandingBillDetail.class)
    public List<APIOutstandingBillDetail> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a APIOutstandingBillDetail and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE API_OUTSTANDING_BILL_DETAIL SET INSURANCE_AMOUNT = :insuranceAmount, UTILIZED_INSURANCE_AMOUNT = :utilizedInsuranceAmount, BILL_ID = :billId, INVOICE_ID = :invoiceId, SHIPPING_BILL_STATUS = :shippingBillStatus, SHIPPINGBILL_NO = :shippingbillNo, FORM_NO = :formNo, SHIPPINGBILL_DATE = :shippingbillDate, LEO_DATE = :leoDate, AD_CODE = :adCode, PORT_OF_LOADING = :portOfLoading, EXPORT_AGENCY = :exportAgency, EXPORT_TYPE = :exportType, IE_CODE = :ieCode, AD_BILL_NUMBER = :adBillNumber, INVOICE_STATUS = :invoiceStatus, INVOICE_NO = :invoiceNo, INVOICE_DATE = :invoiceDate, INVOICE_SERIAL_NO = :invoiceSerialNo, FOB_CURRENCY = :fobCurrency, FRIEGHT_CURRENCY = :frieghtCurrency, INSURANCE_CURRENCY = :insuranceCurrency, FOB_AMOUNT = :fobAmount, UTILIZED_FOB_AMOUNT = :utilizedFobAmount, FREIGHT_AMOUNT = :freightAmount, UTILIZED_FREIGHT_AMOUNT = :utilizedFreightAmount WHERE API_OUTSTANDING_BILL_DETAIL_id = :APIOutstandingBillDetailId")
    public int update(@BindBean APIOutstandingBillDetail apioutstandingbilldetail);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM API_OUTSTANDING_BILL_DETAIL WHERE API_OUTSTANDING_BILL_DETAIL_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM API_OUTSTANDING_BILL_DETAIL")
    public long countAll();

    /**
     * Bulk insert multiple APIOutstandingBillDetail entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO API_OUTSTANDING_BILL_DETAIL (INSURANCE_AMOUNT, UTILIZED_INSURANCE_AMOUNT, BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, SHIPPINGBILL_NO, FORM_NO, SHIPPINGBILL_DATE, LEO_DATE, AD_CODE, PORT_OF_LOADING, EXPORT_AGENCY, EXPORT_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INVOICE_NO, INVOICE_DATE, INVOICE_SERIAL_NO, FOB_CURRENCY, FRIEGHT_CURRENCY, INSURANCE_CURRENCY, FOB_AMOUNT, UTILIZED_FOB_AMOUNT, FREIGHT_AMOUNT, UTILIZED_FREIGHT_AMOUNT) VALUES (:insuranceAmount, :utilizedInsuranceAmount, :billId, :invoiceId, :shippingBillStatus, :shippingbillNo, :formNo, :shippingbillDate, :leoDate, :adCode, :portOfLoading, :exportAgency, :exportType, :ieCode, :adBillNumber, :invoiceStatus, :invoiceNo, :invoiceDate, :invoiceSerialNo, :fobCurrency, :frieghtCurrency, :insuranceCurrency, :fobAmount, :utilizedFobAmount, :freightAmount, :utilizedFreightAmount)")
    public int[] bulkInsert(@BindBean List<APIOutstandingBillDetail> apioutstandingbilldetails);

    /**
     * Bulk update multiple APIOutstandingBillDetail entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE API_OUTSTANDING_BILL_DETAIL SET INSURANCE_AMOUNT = :insuranceAmount, UTILIZED_INSURANCE_AMOUNT = :utilizedInsuranceAmount, BILL_ID = :billId, INVOICE_ID = :invoiceId, SHIPPING_BILL_STATUS = :shippingBillStatus, SHIPPINGBILL_NO = :shippingbillNo, FORM_NO = :formNo, SHIPPINGBILL_DATE = :shippingbillDate, LEO_DATE = :leoDate, AD_CODE = :adCode, PORT_OF_LOADING = :portOfLoading, EXPORT_AGENCY = :exportAgency, EXPORT_TYPE = :exportType, IE_CODE = :ieCode, AD_BILL_NUMBER = :adBillNumber, INVOICE_STATUS = :invoiceStatus, INVOICE_NO = :invoiceNo, INVOICE_DATE = :invoiceDate, INVOICE_SERIAL_NO = :invoiceSerialNo, FOB_CURRENCY = :fobCurrency, FRIEGHT_CURRENCY = :frieghtCurrency, INSURANCE_CURRENCY = :insuranceCurrency, FOB_AMOUNT = :fobAmount, UTILIZED_FOB_AMOUNT = :utilizedFobAmount, FREIGHT_AMOUNT = :freightAmount, UTILIZED_FREIGHT_AMOUNT = :utilizedFreightAmount WHERE API_OUTSTANDING_BILL_DETAIL_id = :APIOutstandingBillDetailId")
    public int[] bulkUpdate(@BindBean List<APIOutstandingBillDetail> apioutstandingbilldetails);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM API_OUTSTANDING_BILL_DETAIL WHERE API_OUTSTANDING_BILL_DETAIL_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM API_OUTSTANDING_BILL_DETAIL WHERE API_OUTSTANDING_BILL_DETAIL_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple APIOutstandingBillDetail records by their IDs.
     */
    @SqlQuery("SELECT * FROM API_OUTSTANDING_BILL_DETAIL WHERE API_OUTSTANDING_BILL_DETAIL_id IN (<ids>)")
    @RegisterBeanMapper(APIOutstandingBillDetail.class)
    public List<APIOutstandingBillDetail> findByIds(@BindList("ids") Collection<Integer> ids);
}
