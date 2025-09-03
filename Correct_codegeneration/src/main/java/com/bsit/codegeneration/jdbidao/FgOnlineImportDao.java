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
import com.bsit.codegeneration.entity.FgOnlineImport;

public interface FgOnlineImportDao {

    /**
     * Inserts a new FgOnlineImport and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ONLINE_IMPORT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FINAL_INV_AMOUNT, FINAL_INV_NO, FINAL_INV_DATE, CUSTOMS_INV_NO, CUSTOMS_INV_DATE, SHIPPING_BILL_NO, SHIPPING_BILL_DATE, PORT_CODE, PORT_LOAD, DECLARED_DEDUCTED, BILL_DUE_DATE, IEC_CODE, INVOICE_CURRENCY, EXPORT_COUNTRY_SAP, INV_QUANTITY, INVOICE_VALUE, CUSTOMER_DESCRIPTION, COUNTRY_SOLD_TO_PART, COUNTRY_CODE_SOLD_TO, B_L_AWB_NO, BILL_OF_LANDING_AWB, MATERIAL_NO, PRODUCT_DESCRIPTION, UPLOAD_REF_ID, LINE_NO, HS_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :finalInvAmount, :finalInvNo, :finalInvDate, :customsInvNo, :customsInvDate, :shippingBillNo, :shippingBillDate, :portCode, :portLoad, :declaredDeducted, :billDueDate, :iecCode, :invoiceCurrency, :exportCountrySap, :invQuantity, :invoiceValue, :customerDescription, :countrySoldToPart, :countryCodeSoldTo, :bLAwbNo, :billOfLandingAwb, :materialNo, :productDescription, :uploadRefId, :lineNo, :hsCode, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :fileName)")
    public int insert(@BindBean FgOnlineImport fgonlineimport);

    /**
     * Finds a FgOnlineImport by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ONLINE_IMPORT WHERE ID = :id")
    @RegisterBeanMapper(FgOnlineImport.class)
    public Optional<FgOnlineImport> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ONLINE_IMPORT")
    @RegisterBeanMapper(FgOnlineImport.class)
    public List<FgOnlineImport> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ONLINE_IMPORT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgOnlineImport.class)
    public List<FgOnlineImport> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgOnlineImport and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ONLINE_IMPORT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, FINAL_INV_AMOUNT = :finalInvAmount, FINAL_INV_NO = :finalInvNo, FINAL_INV_DATE = :finalInvDate, CUSTOMS_INV_NO = :customsInvNo, CUSTOMS_INV_DATE = :customsInvDate, SHIPPING_BILL_NO = :shippingBillNo, SHIPPING_BILL_DATE = :shippingBillDate, PORT_CODE = :portCode, PORT_LOAD = :portLoad, DECLARED_DEDUCTED = :declaredDeducted, BILL_DUE_DATE = :billDueDate, IEC_CODE = :iecCode, INVOICE_CURRENCY = :invoiceCurrency, EXPORT_COUNTRY_SAP = :exportCountrySap, INV_QUANTITY = :invQuantity, INVOICE_VALUE = :invoiceValue, CUSTOMER_DESCRIPTION = :customerDescription, COUNTRY_SOLD_TO_PART = :countrySoldToPart, COUNTRY_CODE_SOLD_TO = :countryCodeSoldTo, B_L_AWB_NO = :bLAwbNo, BILL_OF_LANDING_AWB = :billOfLandingAwb, MATERIAL_NO = :materialNo, PRODUCT_DESCRIPTION = :productDescription, UPLOAD_REF_ID = :uploadRefId, LINE_NO = :lineNo, HS_CODE = :hsCode, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FILE_NAME = :fileName WHERE ID = :id")
    public int update(@BindBean FgOnlineImport fgonlineimport);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ONLINE_IMPORT WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ONLINE_IMPORT")
    public long countAll();

    /**
     * Bulk insert multiple FgOnlineImport entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ONLINE_IMPORT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, FINAL_INV_AMOUNT, FINAL_INV_NO, FINAL_INV_DATE, CUSTOMS_INV_NO, CUSTOMS_INV_DATE, SHIPPING_BILL_NO, SHIPPING_BILL_DATE, PORT_CODE, PORT_LOAD, DECLARED_DEDUCTED, BILL_DUE_DATE, IEC_CODE, INVOICE_CURRENCY, EXPORT_COUNTRY_SAP, INV_QUANTITY, INVOICE_VALUE, CUSTOMER_DESCRIPTION, COUNTRY_SOLD_TO_PART, COUNTRY_CODE_SOLD_TO, B_L_AWB_NO, BILL_OF_LANDING_AWB, MATERIAL_NO, PRODUCT_DESCRIPTION, UPLOAD_REF_ID, LINE_NO, HS_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :finalInvAmount, :finalInvNo, :finalInvDate, :customsInvNo, :customsInvDate, :shippingBillNo, :shippingBillDate, :portCode, :portLoad, :declaredDeducted, :billDueDate, :iecCode, :invoiceCurrency, :exportCountrySap, :invQuantity, :invoiceValue, :customerDescription, :countrySoldToPart, :countryCodeSoldTo, :bLAwbNo, :billOfLandingAwb, :materialNo, :productDescription, :uploadRefId, :lineNo, :hsCode, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :fileName)")
    public int[] bulkInsert(@BindBean List<FgOnlineImport> fgonlineimports);

    /**
     * Bulk update multiple FgOnlineImport entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ONLINE_IMPORT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, FINAL_INV_AMOUNT = :finalInvAmount, FINAL_INV_NO = :finalInvNo, FINAL_INV_DATE = :finalInvDate, CUSTOMS_INV_NO = :customsInvNo, CUSTOMS_INV_DATE = :customsInvDate, SHIPPING_BILL_NO = :shippingBillNo, SHIPPING_BILL_DATE = :shippingBillDate, PORT_CODE = :portCode, PORT_LOAD = :portLoad, DECLARED_DEDUCTED = :declaredDeducted, BILL_DUE_DATE = :billDueDate, IEC_CODE = :iecCode, INVOICE_CURRENCY = :invoiceCurrency, EXPORT_COUNTRY_SAP = :exportCountrySap, INV_QUANTITY = :invQuantity, INVOICE_VALUE = :invoiceValue, CUSTOMER_DESCRIPTION = :customerDescription, COUNTRY_SOLD_TO_PART = :countrySoldToPart, COUNTRY_CODE_SOLD_TO = :countryCodeSoldTo, B_L_AWB_NO = :bLAwbNo, BILL_OF_LANDING_AWB = :billOfLandingAwb, MATERIAL_NO = :materialNo, PRODUCT_DESCRIPTION = :productDescription, UPLOAD_REF_ID = :uploadRefId, LINE_NO = :lineNo, HS_CODE = :hsCode, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FILE_NAME = :fileName WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgOnlineImport> fgonlineimports);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ONLINE_IMPORT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ONLINE_IMPORT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgOnlineImport records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ONLINE_IMPORT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgOnlineImport.class)
    public List<FgOnlineImport> findByIds(@BindList("ids") Collection<String> ids);
}
