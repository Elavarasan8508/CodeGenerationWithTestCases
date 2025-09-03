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
import com.bsit.codegeneration.entity.FgChetakKonet;

public interface FgChetakKonetDao {

    /**
     * Inserts a new FgChetakKonet and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_CHETAK_KONET (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CRN_NO, OPERATIVE_ACC, BUY_SUPLR_NAME, COMMR_INV_NO, COMMR_INV_CURRENCY, COMMR_INV_AMOUNT, MISC_FREIGHT_CHARGE, GOOD_DESCR, PAYMENT_TERM, COUNTRY_OF_ORIGIN, BOE_NO, AD_CODE, PORT_OF_DISCHARGE, PORT_OF_LOADING, BL_NUM, FLIGHT_NAME, CUST_REF_NO, PAYMENT_DETAILS, FX_CONTRACT_REF_NO, UPLOAD_REF_ID, LINE_NO, DUE_OR_VALUE_DATE, BL_DATE, SHIPMENT_DATE, COMMR_INV_DATE, BOE_DATE, HAWB_DATE, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :crnNo, :operativeAcc, :buySuplrName, :commrInvNo, :commrInvCurrency, :commrInvAmount, :miscFreightCharge, :goodDescr, :paymentTerm, :countryOfOrigin, :boeNo, :adCode, :portOfDischarge, :portOfLoading, :blNum, :flightName, :custRefNo, :paymentDetails, :fxContractRefNo, :uploadRefId, :lineNo, :dueOrValueDate, :blDate, :shipmentDate, :commrInvDate, :boeDate, :hawbDate, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :fileName)")
    public int insert(@BindBean FgChetakKonet fgchetakkonet);

    /**
     * Finds a FgChetakKonet by its ID.
     */
    @SqlQuery("SELECT * FROM FG_CHETAK_KONET WHERE ID = :id")
    @RegisterBeanMapper(FgChetakKonet.class)
    public Optional<FgChetakKonet> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_CHETAK_KONET")
    @RegisterBeanMapper(FgChetakKonet.class)
    public List<FgChetakKonet> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_CHETAK_KONET ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgChetakKonet.class)
    public List<FgChetakKonet> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgChetakKonet and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_CHETAK_KONET SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CRN_NO = :crnNo, OPERATIVE_ACC = :operativeAcc, BUY_SUPLR_NAME = :buySuplrName, COMMR_INV_NO = :commrInvNo, COMMR_INV_CURRENCY = :commrInvCurrency, COMMR_INV_AMOUNT = :commrInvAmount, MISC_FREIGHT_CHARGE = :miscFreightCharge, GOOD_DESCR = :goodDescr, PAYMENT_TERM = :paymentTerm, COUNTRY_OF_ORIGIN = :countryOfOrigin, BOE_NO = :boeNo, AD_CODE = :adCode, PORT_OF_DISCHARGE = :portOfDischarge, PORT_OF_LOADING = :portOfLoading, BL_NUM = :blNum, FLIGHT_NAME = :flightName, CUST_REF_NO = :custRefNo, PAYMENT_DETAILS = :paymentDetails, FX_CONTRACT_REF_NO = :fxContractRefNo, UPLOAD_REF_ID = :uploadRefId, LINE_NO = :lineNo, DUE_OR_VALUE_DATE = :dueOrValueDate, BL_DATE = :blDate, SHIPMENT_DATE = :shipmentDate, COMMR_INV_DATE = :commrInvDate, BOE_DATE = :boeDate, HAWB_DATE = :hawbDate, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FILE_NAME = :fileName WHERE ID = :id")
    public int update(@BindBean FgChetakKonet fgchetakkonet);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CHETAK_KONET WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_CHETAK_KONET")
    public long countAll();

    /**
     * Bulk insert multiple FgChetakKonet entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_CHETAK_KONET (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CRN_NO, OPERATIVE_ACC, BUY_SUPLR_NAME, COMMR_INV_NO, COMMR_INV_CURRENCY, COMMR_INV_AMOUNT, MISC_FREIGHT_CHARGE, GOOD_DESCR, PAYMENT_TERM, COUNTRY_OF_ORIGIN, BOE_NO, AD_CODE, PORT_OF_DISCHARGE, PORT_OF_LOADING, BL_NUM, FLIGHT_NAME, CUST_REF_NO, PAYMENT_DETAILS, FX_CONTRACT_REF_NO, UPLOAD_REF_ID, LINE_NO, DUE_OR_VALUE_DATE, BL_DATE, SHIPMENT_DATE, COMMR_INV_DATE, BOE_DATE, HAWB_DATE, AUTH_EQUIVALENT_AMOUNT, AUTH_EQUIVALENT_CURRENCY, DISPLAY_EQUIVALENT_AMOUNT, DISPLAY_EQUIVALENT_CURRENCY, AUTH_FX_BASE_RATE, DISPLAY_FX_BASE_RATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, FILE_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :crnNo, :operativeAcc, :buySuplrName, :commrInvNo, :commrInvCurrency, :commrInvAmount, :miscFreightCharge, :goodDescr, :paymentTerm, :countryOfOrigin, :boeNo, :adCode, :portOfDischarge, :portOfLoading, :blNum, :flightName, :custRefNo, :paymentDetails, :fxContractRefNo, :uploadRefId, :lineNo, :dueOrValueDate, :blDate, :shipmentDate, :commrInvDate, :boeDate, :hawbDate, :authEquivalentAmount, :authEquivalentCurrency, :displayEquivalentAmount, :displayEquivalentCurrency, :authFxBaseRate, :displayFxBaseRate, :applicantPartyCode, :issuingPartyCode, :fileName)")
    public int[] bulkInsert(@BindBean List<FgChetakKonet> fgchetakkonets);

    /**
     * Bulk update multiple FgChetakKonet entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_CHETAK_KONET SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CRN_NO = :crnNo, OPERATIVE_ACC = :operativeAcc, BUY_SUPLR_NAME = :buySuplrName, COMMR_INV_NO = :commrInvNo, COMMR_INV_CURRENCY = :commrInvCurrency, COMMR_INV_AMOUNT = :commrInvAmount, MISC_FREIGHT_CHARGE = :miscFreightCharge, GOOD_DESCR = :goodDescr, PAYMENT_TERM = :paymentTerm, COUNTRY_OF_ORIGIN = :countryOfOrigin, BOE_NO = :boeNo, AD_CODE = :adCode, PORT_OF_DISCHARGE = :portOfDischarge, PORT_OF_LOADING = :portOfLoading, BL_NUM = :blNum, FLIGHT_NAME = :flightName, CUST_REF_NO = :custRefNo, PAYMENT_DETAILS = :paymentDetails, FX_CONTRACT_REF_NO = :fxContractRefNo, UPLOAD_REF_ID = :uploadRefId, LINE_NO = :lineNo, DUE_OR_VALUE_DATE = :dueOrValueDate, BL_DATE = :blDate, SHIPMENT_DATE = :shipmentDate, COMMR_INV_DATE = :commrInvDate, BOE_DATE = :boeDate, HAWB_DATE = :hawbDate, AUTH_EQUIVALENT_AMOUNT = :authEquivalentAmount, AUTH_EQUIVALENT_CURRENCY = :authEquivalentCurrency, DISPLAY_EQUIVALENT_AMOUNT = :displayEquivalentAmount, DISPLAY_EQUIVALENT_CURRENCY = :displayEquivalentCurrency, AUTH_FX_BASE_RATE = :authFxBaseRate, DISPLAY_FX_BASE_RATE = :displayFxBaseRate, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, FILE_NAME = :fileName WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgChetakKonet> fgchetakkonets);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CHETAK_KONET WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_CHETAK_KONET WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgChetakKonet records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_CHETAK_KONET WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgChetakKonet.class)
    public List<FgChetakKonet> findByIds(@BindList("ids") Collection<String> ids);
}
