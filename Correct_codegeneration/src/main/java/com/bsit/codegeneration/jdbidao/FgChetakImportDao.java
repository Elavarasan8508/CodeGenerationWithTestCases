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
import com.bsit.codegeneration.entity.FgChetakImport;

public interface FgChetakImportDao {

    /**
     * Inserts a new FgChetakImport and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_CHETAK_IMPORT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, THEIR_REF, COLLECTING_BANK, BEHALF_OF_BRANCH, DRAWER, DRAWEE_CUSTOMER_ID, DRAWEE_NAME_ADDRESS, DRAWEE_COUNTRY, CHARGE_DEBIT_ACC_NO, COLLECTION_AMOUNT, COLLECTION_CURRENCY, SHIPMENT_TO_COUNTRY, SHIPMENT_FROM_COUNTRY, HS_CODE, GOODS_CODE, GOODS_DESCRIPTION, INCOTERMS, PORT_OF_DESTINATION, PORT_OF_LOADING, TRANSPORT_DOC_NUMBER, TRANSPORT_DOC_DATE, INVOICE_NO, INVOICE_DATE, FORM_TYPE, SHIPPING_BILL_NO, BILL_DATE, PORT_CODE, FORM_NO, SHIPPING_AMOUNT, SHIPPING_CURRENCY, REASON_SHORT_SHP_AMT, SHORT_SHP_AMT, REPAYMENT_AMOUNT, SHORT_COLLECTION_AMT, REMITTANCE_NO, FIRC_NO, REMITTANCE_AMT, UTILIZATION_AMT, REMITTANCE_AD_CODE, REMITERS_NAME, REMITERS_DATE, REMITER_COUNTRY, CIF_NO, LEO_DATE, EXPORT_AGENCY, EXPORT_TYPE, DESTINATION_COUNTRY, IE_CODE, AD_CODE, CUSTOMS_NO, SHIPPING_INV_SR_NO, SHIPPING_INV_NO, SHIPPING_INV_DATE, FOB_AMOUNT, FRIGHT_AMOUNT, INS_AMT, COMMISSION_AMT, DISCOUNT_AMT, DEDUCTION_AMT, PACKAGE_AMT, UPLOAD_REF_ID, LINE_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_CURRENCY, DISPLAY_AMOUNT, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :theirRef, :collectingBank, :behalfOfBranch, :drawer, :draweeCustomerId, :draweeNameAddress, :draweeCountry, :chargeDebitAccNo, :collectionAmount, :collectionCurrency, :shipmentToCountry, :shipmentFromCountry, :hsCode, :goodsCode, :goodsDescription, :incoterms, :portOfDestination, :portOfLoading, :transportDocNumber, :transportDocDate, :invoiceNo, :invoiceDate, :formType, :shippingBillNo, :billDate, :portCode, :formNo, :shippingAmount, :shippingCurrency, :reasonShortShpAmt, :shortShpAmt, :repaymentAmount, :shortCollectionAmt, :remittanceNo, :fircNo, :remittanceAmt, :utilizationAmt, :remittanceAdCode, :remitersName, :remitersDate, :remiterCountry, :cifNo, :leoDate, :exportAgency, :exportType, :destinationCountry, :ieCode, :adCode, :customsNo, :shippingInvSrNo, :shippingInvNo, :shippingInvDate, :fobAmount, :frightAmount, :insAmt, :commissionAmt, :discountAmt, :deductionAmt, :packageAmt, :uploadRefId, :lineNo, :equivalentAmount, :equivalentCurrency, :displayCurrency, :displayAmount, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :fileName)")
    public int insert(@BindBean FgChetakImport fgchetakimport);

    /**
     * Finds a FgChetakImport by its ID.
     */
    @SqlQuery("SELECT * FROM FG_CHETAK_IMPORT WHERE FG_CHETAK_IMPORT_id = :id")
    @RegisterBeanMapper(FgChetakImport.class)
    public Optional<FgChetakImport> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_CHETAK_IMPORT")
    @RegisterBeanMapper(FgChetakImport.class)
    public List<FgChetakImport> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_CHETAK_IMPORT ORDER BY FG_CHETAK_IMPORT_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgChetakImport.class)
    public List<FgChetakImport> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgChetakImport and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_CHETAK_IMPORT SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, THEIR_REF = :theirRef, COLLECTING_BANK = :collectingBank, BEHALF_OF_BRANCH = :behalfOfBranch, DRAWER = :drawer, DRAWEE_CUSTOMER_ID = :draweeCustomerId, DRAWEE_NAME_ADDRESS = :draweeNameAddress, DRAWEE_COUNTRY = :draweeCountry, CHARGE_DEBIT_ACC_NO = :chargeDebitAccNo, COLLECTION_AMOUNT = :collectionAmount, COLLECTION_CURRENCY = :collectionCurrency, SHIPMENT_TO_COUNTRY = :shipmentToCountry, SHIPMENT_FROM_COUNTRY = :shipmentFromCountry, HS_CODE = :hsCode, GOODS_CODE = :goodsCode, GOODS_DESCRIPTION = :goodsDescription, INCOTERMS = :incoterms, PORT_OF_DESTINATION = :portOfDestination, PORT_OF_LOADING = :portOfLoading, TRANSPORT_DOC_NUMBER = :transportDocNumber, TRANSPORT_DOC_DATE = :transportDocDate, INVOICE_NO = :invoiceNo, INVOICE_DATE = :invoiceDate, FORM_TYPE = :formType, SHIPPING_BILL_NO = :shippingBillNo, BILL_DATE = :billDate, PORT_CODE = :portCode, FORM_NO = :formNo, SHIPPING_AMOUNT = :shippingAmount, SHIPPING_CURRENCY = :shippingCurrency, REASON_SHORT_SHP_AMT = :reasonShortShpAmt, SHORT_SHP_AMT = :shortShpAmt, REPAYMENT_AMOUNT = :repaymentAmount, SHORT_COLLECTION_AMT = :shortCollectionAmt, REMITTANCE_NO = :remittanceNo, FIRC_NO = :fircNo, REMITTANCE_AMT = :remittanceAmt, UTILIZATION_AMT = :utilizationAmt, REMITTANCE_AD_CODE = :remittanceAdCode, REMITERS_NAME = :remitersName, REMITERS_DATE = :remitersDate, REMITER_COUNTRY = :remiterCountry, CIF_NO = :cifNo, LEO_DATE = :leoDate, EXPORT_AGENCY = :exportAgency, EXPORT_TYPE = :exportType, DESTINATION_COUNTRY = :destinationCountry, IE_CODE = :ieCode, AD_CODE = :adCode, CUSTOMS_NO = :customsNo, SHIPPING_INV_SR_NO = :shippingInvSrNo, SHIPPING_INV_NO = :shippingInvNo, SHIPPING_INV_DATE = :shippingInvDate, FOB_AMOUNT = :fobAmount, FRIGHT_AMOUNT = :frightAmount, INS_AMT = :insAmt, COMMISSION_AMT = :commissionAmt, DISCOUNT_AMT = :discountAmt, DEDUCTION_AMT = :deductionAmt, PACKAGE_AMT = :packageAmt, UPLOAD_REF_ID = :uploadRefId, LINE_NO = :lineNo, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_CURRENCY = :displayCurrency, DISPLAY_AMOUNT = :displayAmount, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FILE_NAME = :fileName WHERE FG_CHETAK_IMPORT_id = :fgChetakImportId")
    public int update(@BindBean FgChetakImport fgchetakimport);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CHETAK_IMPORT WHERE FG_CHETAK_IMPORT_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_CHETAK_IMPORT")
    public long countAll();

    /**
     * Bulk insert multiple FgChetakImport entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_CHETAK_IMPORT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, THEIR_REF, COLLECTING_BANK, BEHALF_OF_BRANCH, DRAWER, DRAWEE_CUSTOMER_ID, DRAWEE_NAME_ADDRESS, DRAWEE_COUNTRY, CHARGE_DEBIT_ACC_NO, COLLECTION_AMOUNT, COLLECTION_CURRENCY, SHIPMENT_TO_COUNTRY, SHIPMENT_FROM_COUNTRY, HS_CODE, GOODS_CODE, GOODS_DESCRIPTION, INCOTERMS, PORT_OF_DESTINATION, PORT_OF_LOADING, TRANSPORT_DOC_NUMBER, TRANSPORT_DOC_DATE, INVOICE_NO, INVOICE_DATE, FORM_TYPE, SHIPPING_BILL_NO, BILL_DATE, PORT_CODE, FORM_NO, SHIPPING_AMOUNT, SHIPPING_CURRENCY, REASON_SHORT_SHP_AMT, SHORT_SHP_AMT, REPAYMENT_AMOUNT, SHORT_COLLECTION_AMT, REMITTANCE_NO, FIRC_NO, REMITTANCE_AMT, UTILIZATION_AMT, REMITTANCE_AD_CODE, REMITERS_NAME, REMITERS_DATE, REMITER_COUNTRY, CIF_NO, LEO_DATE, EXPORT_AGENCY, EXPORT_TYPE, DESTINATION_COUNTRY, IE_CODE, AD_CODE, CUSTOMS_NO, SHIPPING_INV_SR_NO, SHIPPING_INV_NO, SHIPPING_INV_DATE, FOB_AMOUNT, FRIGHT_AMOUNT, INS_AMT, COMMISSION_AMT, DISCOUNT_AMT, DEDUCTION_AMT, PACKAGE_AMT, UPLOAD_REF_ID, LINE_NO, EQUIVALENT_AMOUNT, EQUIVALENT_CURRENCY, DISPLAY_CURRENCY, DISPLAY_AMOUNT, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :theirRef, :collectingBank, :behalfOfBranch, :drawer, :draweeCustomerId, :draweeNameAddress, :draweeCountry, :chargeDebitAccNo, :collectionAmount, :collectionCurrency, :shipmentToCountry, :shipmentFromCountry, :hsCode, :goodsCode, :goodsDescription, :incoterms, :portOfDestination, :portOfLoading, :transportDocNumber, :transportDocDate, :invoiceNo, :invoiceDate, :formType, :shippingBillNo, :billDate, :portCode, :formNo, :shippingAmount, :shippingCurrency, :reasonShortShpAmt, :shortShpAmt, :repaymentAmount, :shortCollectionAmt, :remittanceNo, :fircNo, :remittanceAmt, :utilizationAmt, :remittanceAdCode, :remitersName, :remitersDate, :remiterCountry, :cifNo, :leoDate, :exportAgency, :exportType, :destinationCountry, :ieCode, :adCode, :customsNo, :shippingInvSrNo, :shippingInvNo, :shippingInvDate, :fobAmount, :frightAmount, :insAmt, :commissionAmt, :discountAmt, :deductionAmt, :packageAmt, :uploadRefId, :lineNo, :equivalentAmount, :equivalentCurrency, :displayCurrency, :displayAmount, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :fileName)")
    public int[] bulkInsert(@BindBean List<FgChetakImport> fgchetakimports);

    /**
     * Bulk update multiple FgChetakImport entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_CHETAK_IMPORT SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, THEIR_REF = :theirRef, COLLECTING_BANK = :collectingBank, BEHALF_OF_BRANCH = :behalfOfBranch, DRAWER = :drawer, DRAWEE_CUSTOMER_ID = :draweeCustomerId, DRAWEE_NAME_ADDRESS = :draweeNameAddress, DRAWEE_COUNTRY = :draweeCountry, CHARGE_DEBIT_ACC_NO = :chargeDebitAccNo, COLLECTION_AMOUNT = :collectionAmount, COLLECTION_CURRENCY = :collectionCurrency, SHIPMENT_TO_COUNTRY = :shipmentToCountry, SHIPMENT_FROM_COUNTRY = :shipmentFromCountry, HS_CODE = :hsCode, GOODS_CODE = :goodsCode, GOODS_DESCRIPTION = :goodsDescription, INCOTERMS = :incoterms, PORT_OF_DESTINATION = :portOfDestination, PORT_OF_LOADING = :portOfLoading, TRANSPORT_DOC_NUMBER = :transportDocNumber, TRANSPORT_DOC_DATE = :transportDocDate, INVOICE_NO = :invoiceNo, INVOICE_DATE = :invoiceDate, FORM_TYPE = :formType, SHIPPING_BILL_NO = :shippingBillNo, BILL_DATE = :billDate, PORT_CODE = :portCode, FORM_NO = :formNo, SHIPPING_AMOUNT = :shippingAmount, SHIPPING_CURRENCY = :shippingCurrency, REASON_SHORT_SHP_AMT = :reasonShortShpAmt, SHORT_SHP_AMT = :shortShpAmt, REPAYMENT_AMOUNT = :repaymentAmount, SHORT_COLLECTION_AMT = :shortCollectionAmt, REMITTANCE_NO = :remittanceNo, FIRC_NO = :fircNo, REMITTANCE_AMT = :remittanceAmt, UTILIZATION_AMT = :utilizationAmt, REMITTANCE_AD_CODE = :remittanceAdCode, REMITERS_NAME = :remitersName, REMITERS_DATE = :remitersDate, REMITER_COUNTRY = :remiterCountry, CIF_NO = :cifNo, LEO_DATE = :leoDate, EXPORT_AGENCY = :exportAgency, EXPORT_TYPE = :exportType, DESTINATION_COUNTRY = :destinationCountry, IE_CODE = :ieCode, AD_CODE = :adCode, CUSTOMS_NO = :customsNo, SHIPPING_INV_SR_NO = :shippingInvSrNo, SHIPPING_INV_NO = :shippingInvNo, SHIPPING_INV_DATE = :shippingInvDate, FOB_AMOUNT = :fobAmount, FRIGHT_AMOUNT = :frightAmount, INS_AMT = :insAmt, COMMISSION_AMT = :commissionAmt, DISCOUNT_AMT = :discountAmt, DEDUCTION_AMT = :deductionAmt, PACKAGE_AMT = :packageAmt, UPLOAD_REF_ID = :uploadRefId, LINE_NO = :lineNo, EQUIVALENT_AMOUNT = :equivalentAmount, EQUIVALENT_CURRENCY = :equivalentCurrency, DISPLAY_CURRENCY = :displayCurrency, DISPLAY_AMOUNT = :displayAmount, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FILE_NAME = :fileName WHERE FG_CHETAK_IMPORT_id = :fgChetakImportId")
    public int[] bulkUpdate(@BindBean List<FgChetakImport> fgchetakimports);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CHETAK_IMPORT WHERE FG_CHETAK_IMPORT_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_CHETAK_IMPORT WHERE FG_CHETAK_IMPORT_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgChetakImport records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_CHETAK_IMPORT WHERE FG_CHETAK_IMPORT_id IN (<ids>)")
    @RegisterBeanMapper(FgChetakImport.class)
    public List<FgChetakImport> findByIds(@BindList("ids") Collection<Integer> ids);
}
