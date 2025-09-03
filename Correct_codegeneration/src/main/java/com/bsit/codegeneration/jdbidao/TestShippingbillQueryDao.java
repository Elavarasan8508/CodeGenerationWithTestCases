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
import com.bsit.codegeneration.entity.TestShippingbillQuery;

public interface TestShippingbillQueryDao {

    /**
     * Inserts a new TestShippingbillQuery and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO TEST_SHIPPINGBILL_QUERY (BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, SHIPPINGBILL_NO, FORM_NO, SHIPPINGBILL_DATE, LEO_DATE, AD_CODE, PORT_OF_LOADING, EXPORT_AGENCY, EXPORT_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INVOICE_NO, INVOICE_DATE, INVOICE_SERIAL_NO, FOB_CURRENCY, FRIEGHT_CURRENCY, INSURANCE_CURRENCY, FOB_AMOUNT, UTILIZED_FOB_AMOUNT, FREIGHT_AMOUNT, UTILIZED_FREIGHT_AMOUNT, INSURANCE_AMOUNT, UTILIZED_INSURANCE_AMOUNT) VALUES (:billId, :invoiceId, :shippingBillStatus, :shippingbillNo, :formNo, :shippingbillDate, :leoDate, :adCode, :portOfLoading, :exportAgency, :exportType, :ieCode, :adBillNumber, :invoiceStatus, :invoiceNo, :invoiceDate, :invoiceSerialNo, :fobCurrency, :frieghtCurrency, :insuranceCurrency, :fobAmount, :utilizedFobAmount, :freightAmount, :utilizedFreightAmount, :insuranceAmount, :utilizedInsuranceAmount)")
    public int insert(@BindBean TestShippingbillQuery testshippingbillquery);

    /**
     * Finds a TestShippingbillQuery by its ID.
     */
    @SqlQuery("SELECT * FROM TEST_SHIPPINGBILL_QUERY WHERE TEST_SHIPPINGBILL_QUERY_id = :id")
    @RegisterBeanMapper(TestShippingbillQuery.class)
    public Optional<TestShippingbillQuery> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM TEST_SHIPPINGBILL_QUERY")
    @RegisterBeanMapper(TestShippingbillQuery.class)
    public List<TestShippingbillQuery> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM TEST_SHIPPINGBILL_QUERY ORDER BY TEST_SHIPPINGBILL_QUERY_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(TestShippingbillQuery.class)
    public List<TestShippingbillQuery> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a TestShippingbillQuery and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE TEST_SHIPPINGBILL_QUERY SET BILL_ID = :billId, INVOICE_ID = :invoiceId, SHIPPING_BILL_STATUS = :shippingBillStatus, SHIPPINGBILL_NO = :shippingbillNo, FORM_NO = :formNo, SHIPPINGBILL_DATE = :shippingbillDate, LEO_DATE = :leoDate, AD_CODE = :adCode, PORT_OF_LOADING = :portOfLoading, EXPORT_AGENCY = :exportAgency, EXPORT_TYPE = :exportType, IE_CODE = :ieCode, AD_BILL_NUMBER = :adBillNumber, INVOICE_STATUS = :invoiceStatus, INVOICE_NO = :invoiceNo, INVOICE_DATE = :invoiceDate, INVOICE_SERIAL_NO = :invoiceSerialNo, FOB_CURRENCY = :fobCurrency, FRIEGHT_CURRENCY = :frieghtCurrency, INSURANCE_CURRENCY = :insuranceCurrency, FOB_AMOUNT = :fobAmount, UTILIZED_FOB_AMOUNT = :utilizedFobAmount, FREIGHT_AMOUNT = :freightAmount, UTILIZED_FREIGHT_AMOUNT = :utilizedFreightAmount, INSURANCE_AMOUNT = :insuranceAmount, UTILIZED_INSURANCE_AMOUNT = :utilizedInsuranceAmount WHERE TEST_SHIPPINGBILL_QUERY_id = :testShippingbillQueryId")
    public int update(@BindBean TestShippingbillQuery testshippingbillquery);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM TEST_SHIPPINGBILL_QUERY WHERE TEST_SHIPPINGBILL_QUERY_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM TEST_SHIPPINGBILL_QUERY")
    public long countAll();

    /**
     * Bulk insert multiple TestShippingbillQuery entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO TEST_SHIPPINGBILL_QUERY (BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, SHIPPINGBILL_NO, FORM_NO, SHIPPINGBILL_DATE, LEO_DATE, AD_CODE, PORT_OF_LOADING, EXPORT_AGENCY, EXPORT_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INVOICE_NO, INVOICE_DATE, INVOICE_SERIAL_NO, FOB_CURRENCY, FRIEGHT_CURRENCY, INSURANCE_CURRENCY, FOB_AMOUNT, UTILIZED_FOB_AMOUNT, FREIGHT_AMOUNT, UTILIZED_FREIGHT_AMOUNT, INSURANCE_AMOUNT, UTILIZED_INSURANCE_AMOUNT) VALUES (:billId, :invoiceId, :shippingBillStatus, :shippingbillNo, :formNo, :shippingbillDate, :leoDate, :adCode, :portOfLoading, :exportAgency, :exportType, :ieCode, :adBillNumber, :invoiceStatus, :invoiceNo, :invoiceDate, :invoiceSerialNo, :fobCurrency, :frieghtCurrency, :insuranceCurrency, :fobAmount, :utilizedFobAmount, :freightAmount, :utilizedFreightAmount, :insuranceAmount, :utilizedInsuranceAmount)")
    public int[] bulkInsert(@BindBean List<TestShippingbillQuery> testshippingbillquerys);

    /**
     * Bulk update multiple TestShippingbillQuery entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE TEST_SHIPPINGBILL_QUERY SET BILL_ID = :billId, INVOICE_ID = :invoiceId, SHIPPING_BILL_STATUS = :shippingBillStatus, SHIPPINGBILL_NO = :shippingbillNo, FORM_NO = :formNo, SHIPPINGBILL_DATE = :shippingbillDate, LEO_DATE = :leoDate, AD_CODE = :adCode, PORT_OF_LOADING = :portOfLoading, EXPORT_AGENCY = :exportAgency, EXPORT_TYPE = :exportType, IE_CODE = :ieCode, AD_BILL_NUMBER = :adBillNumber, INVOICE_STATUS = :invoiceStatus, INVOICE_NO = :invoiceNo, INVOICE_DATE = :invoiceDate, INVOICE_SERIAL_NO = :invoiceSerialNo, FOB_CURRENCY = :fobCurrency, FRIEGHT_CURRENCY = :frieghtCurrency, INSURANCE_CURRENCY = :insuranceCurrency, FOB_AMOUNT = :fobAmount, UTILIZED_FOB_AMOUNT = :utilizedFobAmount, FREIGHT_AMOUNT = :freightAmount, UTILIZED_FREIGHT_AMOUNT = :utilizedFreightAmount, INSURANCE_AMOUNT = :insuranceAmount, UTILIZED_INSURANCE_AMOUNT = :utilizedInsuranceAmount WHERE TEST_SHIPPINGBILL_QUERY_id = :testShippingbillQueryId")
    public int[] bulkUpdate(@BindBean List<TestShippingbillQuery> testshippingbillquerys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM TEST_SHIPPINGBILL_QUERY WHERE TEST_SHIPPINGBILL_QUERY_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM TEST_SHIPPINGBILL_QUERY WHERE TEST_SHIPPINGBILL_QUERY_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple TestShippingbillQuery records by their IDs.
     */
    @SqlQuery("SELECT * FROM TEST_SHIPPINGBILL_QUERY WHERE TEST_SHIPPINGBILL_QUERY_id IN (<ids>)")
    @RegisterBeanMapper(TestShippingbillQuery.class)
    public List<TestShippingbillQuery> findByIds(@BindList("ids") Collection<Integer> ids);
}
