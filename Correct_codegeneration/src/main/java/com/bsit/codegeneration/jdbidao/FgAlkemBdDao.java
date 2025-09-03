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
import com.bsit.codegeneration.entity.FgAlkemBd;

public interface FgAlkemBdDao {

    /**
     * Inserts a new FgAlkemBd and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ALKEM_BD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INVOICE_CURRENCY, EXPORT_COUNTRY_SAP, CUSTOMER_DESCRIPTION, COUNTRY_SOLD_TO_PART, COUNTRY_CODE_SOLD_TO, B_L_AWB_NO, BILL_OF_LANDING_AWB, MATERIAL_NO, PRODUCT_DESCRIPTION, FINAL_INV_NO, FINAL_INV_DATE, CUSTOMS_INV_NO, CUSTOMS_INV_DATE, SHIPPING_BILL_NO, SHIPPING_BILL_DATE, PORT_CODE, PORT_LOAD, BILL_DUE_DATE, UPLOAD_REF_ID, IEC_CODE, FINAL_INV_AMOUNT, INVOICE_VALUE, INVOICE_QUANTITY, DECLARED_DEDUCTED, LINE_NO, HS_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME, BANK_REF_NO, BASE_DATE, BILL_AMOUNT, BILL_CCY, BUYER_COUNTRY1, BUYER_COUNTRY2, BUYER_ID, BUYER_NAME, CHARGES_DBT_ACC_NO, COLLECTING_BANK, CUSTOMER_CRN, DEST_PORT_CODE, GOODS_CODE, GOODS_DESC, HSN_CODE, INCOTERMS, INV_DATE, INV_NO, PORD_CODE_FOR_LOADING, SHIPPING_BILL_AMOUNT, SHIPPING_BILL_CCY, SOFTEX_NUMBER, TENOR_IN_DAYS, THIRD_PARTY, THIRD_PARTY_ADD, THIRD_PARTY_COUNTRY, THIRD_PARTY_NAME, VESSEL_O_FLIGHT_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :invoiceCurrency, :exportCountrySap, :customerDescription, :countrySoldToPart, :countryCodeSoldTo, :bLAwbNo, :billOfLandingAwb, :materialNo, :productDescription, :finalInvNo, :finalInvDate, :customsInvNo, :customsInvDate, :shippingBillNo, :shippingBillDate, :portCode, :portLoad, :billDueDate, :uploadRefId, :iecCode, :finalInvAmount, :invoiceValue, :invoiceQuantity, :declaredDeducted, :lineNo, :hsCode, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :fileName, :bankRefNo, :baseDate, :billAmount, :billCcy, :buyerCountry1, :buyerCountry2, :buyerId, :buyerName, :chargesDbtAccNo, :collectingBank, :customerCrn, :destPortCode, :goodsCode, :goodsDesc, :hsnCode, :incoterms, :invDate, :invNo, :pordCodeForLoading, :shippingBillAmount, :shippingBillCcy, :softexNumber, :tenorInDays, :thirdParty, :thirdPartyAdd, :thirdPartyCountry, :thirdPartyName, :vesselOFlightName)")
    public int insert(@BindBean FgAlkemBd fgalkembd);

    /**
     * Finds a FgAlkemBd by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ALKEM_BD WHERE FG_ALKEM_BD_id = :id")
    @RegisterBeanMapper(FgAlkemBd.class)
    public Optional<FgAlkemBd> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ALKEM_BD")
    @RegisterBeanMapper(FgAlkemBd.class)
    public List<FgAlkemBd> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ALKEM_BD ORDER BY FG_ALKEM_BD_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAlkemBd.class)
    public List<FgAlkemBd> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAlkemBd and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ALKEM_BD SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, INVOICE_CURRENCY = :invoiceCurrency, EXPORT_COUNTRY_SAP = :exportCountrySap, CUSTOMER_DESCRIPTION = :customerDescription, COUNTRY_SOLD_TO_PART = :countrySoldToPart, COUNTRY_CODE_SOLD_TO = :countryCodeSoldTo, B_L_AWB_NO = :bLAwbNo, BILL_OF_LANDING_AWB = :billOfLandingAwb, MATERIAL_NO = :materialNo, PRODUCT_DESCRIPTION = :productDescription, FINAL_INV_NO = :finalInvNo, FINAL_INV_DATE = :finalInvDate, CUSTOMS_INV_NO = :customsInvNo, CUSTOMS_INV_DATE = :customsInvDate, SHIPPING_BILL_NO = :shippingBillNo, SHIPPING_BILL_DATE = :shippingBillDate, PORT_CODE = :portCode, PORT_LOAD = :portLoad, BILL_DUE_DATE = :billDueDate, UPLOAD_REF_ID = :uploadRefId, IEC_CODE = :iecCode, FINAL_INV_AMOUNT = :finalInvAmount, INVOICE_VALUE = :invoiceValue, INVOICE_QUANTITY = :invoiceQuantity, DECLARED_DEDUCTED = :declaredDeducted, LINE_NO = :lineNo, HS_CODE = :hsCode, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FILE_NAME = :fileName, BANK_REF_NO = :bankRefNo, BASE_DATE = :baseDate, BILL_AMOUNT = :billAmount, BILL_CCY = :billCcy, BUYER_COUNTRY1 = :buyerCountry1, BUYER_COUNTRY2 = :buyerCountry2, BUYER_ID = :buyerId, BUYER_NAME = :buyerName, CHARGES_DBT_ACC_NO = :chargesDbtAccNo, COLLECTING_BANK = :collectingBank, CUSTOMER_CRN = :customerCrn, DEST_PORT_CODE = :destPortCode, GOODS_CODE = :goodsCode, GOODS_DESC = :goodsDesc, HSN_CODE = :hsnCode, INCOTERMS = :incoterms, INV_DATE = :invDate, INV_NO = :invNo, PORD_CODE_FOR_LOADING = :pordCodeForLoading, SHIPPING_BILL_AMOUNT = :shippingBillAmount, SHIPPING_BILL_CCY = :shippingBillCcy, SOFTEX_NUMBER = :softexNumber, TENOR_IN_DAYS = :tenorInDays, THIRD_PARTY = :thirdParty, THIRD_PARTY_ADD = :thirdPartyAdd, THIRD_PARTY_COUNTRY = :thirdPartyCountry, THIRD_PARTY_NAME = :thirdPartyName, VESSEL_O_FLIGHT_NAME = :vesselOFlightName WHERE FG_ALKEM_BD_id = :fgAlkemBdId")
    public int update(@BindBean FgAlkemBd fgalkembd);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALKEM_BD WHERE FG_ALKEM_BD_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ALKEM_BD")
    public long countAll();

    /**
     * Bulk insert multiple FgAlkemBd entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ALKEM_BD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INVOICE_CURRENCY, EXPORT_COUNTRY_SAP, CUSTOMER_DESCRIPTION, COUNTRY_SOLD_TO_PART, COUNTRY_CODE_SOLD_TO, B_L_AWB_NO, BILL_OF_LANDING_AWB, MATERIAL_NO, PRODUCT_DESCRIPTION, FINAL_INV_NO, FINAL_INV_DATE, CUSTOMS_INV_NO, CUSTOMS_INV_DATE, SHIPPING_BILL_NO, SHIPPING_BILL_DATE, PORT_CODE, PORT_LOAD, BILL_DUE_DATE, UPLOAD_REF_ID, IEC_CODE, FINAL_INV_AMOUNT, INVOICE_VALUE, INVOICE_QUANTITY, DECLARED_DEDUCTED, LINE_NO, HS_CODE, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_AMOUNT, DISPLAY_CURRENCY, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME, BANK_REF_NO, BASE_DATE, BILL_AMOUNT, BILL_CCY, BUYER_COUNTRY1, BUYER_COUNTRY2, BUYER_ID, BUYER_NAME, CHARGES_DBT_ACC_NO, COLLECTING_BANK, CUSTOMER_CRN, DEST_PORT_CODE, GOODS_CODE, GOODS_DESC, HSN_CODE, INCOTERMS, INV_DATE, INV_NO, PORD_CODE_FOR_LOADING, SHIPPING_BILL_AMOUNT, SHIPPING_BILL_CCY, SOFTEX_NUMBER, TENOR_IN_DAYS, THIRD_PARTY, THIRD_PARTY_ADD, THIRD_PARTY_COUNTRY, THIRD_PARTY_NAME, VESSEL_O_FLIGHT_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :invoiceCurrency, :exportCountrySap, :customerDescription, :countrySoldToPart, :countryCodeSoldTo, :bLAwbNo, :billOfLandingAwb, :materialNo, :productDescription, :finalInvNo, :finalInvDate, :customsInvNo, :customsInvDate, :shippingBillNo, :shippingBillDate, :portCode, :portLoad, :billDueDate, :uploadRefId, :iecCode, :finalInvAmount, :invoiceValue, :invoiceQuantity, :declaredDeducted, :lineNo, :hsCode, :equivalentAmount, :equivalentCurrency, :displayAmount, :displayCurrency, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :fileName, :bankRefNo, :baseDate, :billAmount, :billCcy, :buyerCountry1, :buyerCountry2, :buyerId, :buyerName, :chargesDbtAccNo, :collectingBank, :customerCrn, :destPortCode, :goodsCode, :goodsDesc, :hsnCode, :incoterms, :invDate, :invNo, :pordCodeForLoading, :shippingBillAmount, :shippingBillCcy, :softexNumber, :tenorInDays, :thirdParty, :thirdPartyAdd, :thirdPartyCountry, :thirdPartyName, :vesselOFlightName)")
    public int[] bulkInsert(@BindBean List<FgAlkemBd> fgalkembds);

    /**
     * Bulk update multiple FgAlkemBd entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ALKEM_BD SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, INVOICE_CURRENCY = :invoiceCurrency, EXPORT_COUNTRY_SAP = :exportCountrySap, CUSTOMER_DESCRIPTION = :customerDescription, COUNTRY_SOLD_TO_PART = :countrySoldToPart, COUNTRY_CODE_SOLD_TO = :countryCodeSoldTo, B_L_AWB_NO = :bLAwbNo, BILL_OF_LANDING_AWB = :billOfLandingAwb, MATERIAL_NO = :materialNo, PRODUCT_DESCRIPTION = :productDescription, FINAL_INV_NO = :finalInvNo, FINAL_INV_DATE = :finalInvDate, CUSTOMS_INV_NO = :customsInvNo, CUSTOMS_INV_DATE = :customsInvDate, SHIPPING_BILL_NO = :shippingBillNo, SHIPPING_BILL_DATE = :shippingBillDate, PORT_CODE = :portCode, PORT_LOAD = :portLoad, BILL_DUE_DATE = :billDueDate, UPLOAD_REF_ID = :uploadRefId, IEC_CODE = :iecCode, FINAL_INV_AMOUNT = :finalInvAmount, INVOICE_VALUE = :invoiceValue, INVOICE_QUANTITY = :invoiceQuantity, DECLARED_DEDUCTED = :declaredDeducted, LINE_NO = :lineNo, HS_CODE = :hsCode, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_AMOUNT = :displayAmount, DISPLAY_CURRENCY = :displayCurrency, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FILE_NAME = :fileName, BANK_REF_NO = :bankRefNo, BASE_DATE = :baseDate, BILL_AMOUNT = :billAmount, BILL_CCY = :billCcy, BUYER_COUNTRY1 = :buyerCountry1, BUYER_COUNTRY2 = :buyerCountry2, BUYER_ID = :buyerId, BUYER_NAME = :buyerName, CHARGES_DBT_ACC_NO = :chargesDbtAccNo, COLLECTING_BANK = :collectingBank, CUSTOMER_CRN = :customerCrn, DEST_PORT_CODE = :destPortCode, GOODS_CODE = :goodsCode, GOODS_DESC = :goodsDesc, HSN_CODE = :hsnCode, INCOTERMS = :incoterms, INV_DATE = :invDate, INV_NO = :invNo, PORD_CODE_FOR_LOADING = :pordCodeForLoading, SHIPPING_BILL_AMOUNT = :shippingBillAmount, SHIPPING_BILL_CCY = :shippingBillCcy, SOFTEX_NUMBER = :softexNumber, TENOR_IN_DAYS = :tenorInDays, THIRD_PARTY = :thirdParty, THIRD_PARTY_ADD = :thirdPartyAdd, THIRD_PARTY_COUNTRY = :thirdPartyCountry, THIRD_PARTY_NAME = :thirdPartyName, VESSEL_O_FLIGHT_NAME = :vesselOFlightName WHERE FG_ALKEM_BD_id = :fgAlkemBdId")
    public int[] bulkUpdate(@BindBean List<FgAlkemBd> fgalkembds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALKEM_BD WHERE FG_ALKEM_BD_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ALKEM_BD WHERE FG_ALKEM_BD_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgAlkemBd records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ALKEM_BD WHERE FG_ALKEM_BD_id IN (<ids>)")
    @RegisterBeanMapper(FgAlkemBd.class)
    public List<FgAlkemBd> findByIds(@BindList("ids") Collection<Integer> ids);
}
