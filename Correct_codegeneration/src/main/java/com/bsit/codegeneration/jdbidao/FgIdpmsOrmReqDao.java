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
import com.bsit.codegeneration.entity.FgIdpmsOrmReq;

public interface FgIdpmsOrmReqDao {

    /**
     * Inserts a new FgIdpmsOrmReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_IDPMS_ORM_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_OS_AMT, ORM_CCY, ORM_DATE, IE_NAME, IE_CODE_ORM, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT, ADJ_AMT_ORM, REASON_INDICATOR, REMARKS_ORM, PAYMENT_TERMS, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DESC, REQ_TYPE, NAME_MATCH, UTIL_AMT, APPROVED_BY, PAYMENT_PARTY, PORT_CODE, BOE_NUMBER, BOE_DATE, AD_CODE_BOE, INVOICE_SL_NO, INV_NUM, DOC_NO, DOC_DATE, CLOSURE_INDICATOR, ENDORSED_AMT, FINAL_ERROR_DESC, FINAL_STATUS, FINAL_ERROR_CODE, LETTER_NO, RBI_STATUS, RBI_ERROR_DESC, RBI_ERROR_CODE, LETTER_DATE, IE_CODE, REMITTANCE_CURRENCY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :ormNumber, :adCode, :ormAmount, :ormUtilizedAmt, :ormOsAmt, :ormCcy, :ormDate, :ieName, :ieCodeOrm, :beneName, :beneCountry, :remitterBankName, :purOfRemit, :adjAmtOrm, :reasonIndicator, :remarksOrm, :paymentTerms, :parentRefId, :parentVersionId, :trracsStatus, :trracsErrorCode, :trracsErrorDesc, :reqType, :nameMatch, :utilAmt, :approvedBy, :paymentParty, :portCode, :boeNumber, :boeDate, :adCodeBoe, :invoiceSlNo, :invNum, :docNo, :docDate, :closureIndicator, :endorsedAmt, :finalErrorDesc, :finalStatus, :finalErrorCode, :letterNo, :rbiStatus, :rbiErrorDesc, :rbiErrorCode, :letterDate, :ieCode, :remittanceCurrency)")
    public int insert(@BindBean FgIdpmsOrmReq fgidpmsormreq);

    /**
     * Finds a FgIdpmsOrmReq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_ORM_REQ WHERE ID = :id")
    @RegisterBeanMapper(FgIdpmsOrmReq.class)
    public Optional<FgIdpmsOrmReq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_ORM_REQ")
    @RegisterBeanMapper(FgIdpmsOrmReq.class)
    public List<FgIdpmsOrmReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_ORM_REQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgIdpmsOrmReq.class)
    public List<FgIdpmsOrmReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgIdpmsOrmReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_IDPMS_ORM_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ORM_NUMBER = :ormNumber, AD_CODE = :adCode, ORM_AMOUNT = :ormAmount, ORM_UTILIZED_AMT = :ormUtilizedAmt, ORM_OS_AMT = :ormOsAmt, ORM_CCY = :ormCcy, ORM_DATE = :ormDate, IE_NAME = :ieName, IE_CODE_ORM = :ieCodeOrm, BENE_NAME = :beneName, BENE_COUNTRY = :beneCountry, REMITTER_BANK_NAME = :remitterBankName, PUR_OF_REMIT = :purOfRemit, ADJ_AMT_ORM = :adjAmtOrm, REASON_INDICATOR = :reasonIndicator, REMARKS_ORM = :remarksOrm, PAYMENT_TERMS = :paymentTerms, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, TRRACS_STATUS = :trracsStatus, TRRACS_ERROR_CODE = :trracsErrorCode, TRRACS_ERROR_DESC = :trracsErrorDesc, REQ_TYPE = :reqType, NAME_MATCH = :nameMatch, UTIL_AMT = :utilAmt, APPROVED_BY = :approvedBy, PAYMENT_PARTY = :paymentParty, PORT_CODE = :portCode, BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, AD_CODE_BOE = :adCodeBoe, INVOICE_SL_NO = :invoiceSlNo, INV_NUM = :invNum, DOC_NO = :docNo, DOC_DATE = :docDate, CLOSURE_INDICATOR = :closureIndicator, ENDORSED_AMT = :endorsedAmt, FINAL_ERROR_DESC = :finalErrorDesc, FINAL_STATUS = :finalStatus, FINAL_ERROR_CODE = :finalErrorCode, LETTER_NO = :letterNo, RBI_STATUS = :rbiStatus, RBI_ERROR_DESC = :rbiErrorDesc, RBI_ERROR_CODE = :rbiErrorCode, LETTER_DATE = :letterDate, IE_CODE = :ieCode, REMITTANCE_CURRENCY = :remittanceCurrency WHERE ID = :id")
    public int update(@BindBean FgIdpmsOrmReq fgidpmsormreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_IDPMS_ORM_REQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_IDPMS_ORM_REQ")
    public long countAll();

    /**
     * Bulk insert multiple FgIdpmsOrmReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_IDPMS_ORM_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ORM_NUMBER, AD_CODE, ORM_AMOUNT, ORM_UTILIZED_AMT, ORM_OS_AMT, ORM_CCY, ORM_DATE, IE_NAME, IE_CODE_ORM, BENE_NAME, BENE_COUNTRY, REMITTER_BANK_NAME, PUR_OF_REMIT, ADJ_AMT_ORM, REASON_INDICATOR, REMARKS_ORM, PAYMENT_TERMS, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DESC, REQ_TYPE, NAME_MATCH, UTIL_AMT, APPROVED_BY, PAYMENT_PARTY, PORT_CODE, BOE_NUMBER, BOE_DATE, AD_CODE_BOE, INVOICE_SL_NO, INV_NUM, DOC_NO, DOC_DATE, CLOSURE_INDICATOR, ENDORSED_AMT, FINAL_ERROR_DESC, FINAL_STATUS, FINAL_ERROR_CODE, LETTER_NO, RBI_STATUS, RBI_ERROR_DESC, RBI_ERROR_CODE, LETTER_DATE, IE_CODE, REMITTANCE_CURRENCY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :ormNumber, :adCode, :ormAmount, :ormUtilizedAmt, :ormOsAmt, :ormCcy, :ormDate, :ieName, :ieCodeOrm, :beneName, :beneCountry, :remitterBankName, :purOfRemit, :adjAmtOrm, :reasonIndicator, :remarksOrm, :paymentTerms, :parentRefId, :parentVersionId, :trracsStatus, :trracsErrorCode, :trracsErrorDesc, :reqType, :nameMatch, :utilAmt, :approvedBy, :paymentParty, :portCode, :boeNumber, :boeDate, :adCodeBoe, :invoiceSlNo, :invNum, :docNo, :docDate, :closureIndicator, :endorsedAmt, :finalErrorDesc, :finalStatus, :finalErrorCode, :letterNo, :rbiStatus, :rbiErrorDesc, :rbiErrorCode, :letterDate, :ieCode, :remittanceCurrency)")
    public int[] bulkInsert(@BindBean List<FgIdpmsOrmReq> fgidpmsormreqs);

    /**
     * Bulk update multiple FgIdpmsOrmReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_IDPMS_ORM_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ORM_NUMBER = :ormNumber, AD_CODE = :adCode, ORM_AMOUNT = :ormAmount, ORM_UTILIZED_AMT = :ormUtilizedAmt, ORM_OS_AMT = :ormOsAmt, ORM_CCY = :ormCcy, ORM_DATE = :ormDate, IE_NAME = :ieName, IE_CODE_ORM = :ieCodeOrm, BENE_NAME = :beneName, BENE_COUNTRY = :beneCountry, REMITTER_BANK_NAME = :remitterBankName, PUR_OF_REMIT = :purOfRemit, ADJ_AMT_ORM = :adjAmtOrm, REASON_INDICATOR = :reasonIndicator, REMARKS_ORM = :remarksOrm, PAYMENT_TERMS = :paymentTerms, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, TRRACS_STATUS = :trracsStatus, TRRACS_ERROR_CODE = :trracsErrorCode, TRRACS_ERROR_DESC = :trracsErrorDesc, REQ_TYPE = :reqType, NAME_MATCH = :nameMatch, UTIL_AMT = :utilAmt, APPROVED_BY = :approvedBy, PAYMENT_PARTY = :paymentParty, PORT_CODE = :portCode, BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, AD_CODE_BOE = :adCodeBoe, INVOICE_SL_NO = :invoiceSlNo, INV_NUM = :invNum, DOC_NO = :docNo, DOC_DATE = :docDate, CLOSURE_INDICATOR = :closureIndicator, ENDORSED_AMT = :endorsedAmt, FINAL_ERROR_DESC = :finalErrorDesc, FINAL_STATUS = :finalStatus, FINAL_ERROR_CODE = :finalErrorCode, LETTER_NO = :letterNo, RBI_STATUS = :rbiStatus, RBI_ERROR_DESC = :rbiErrorDesc, RBI_ERROR_CODE = :rbiErrorCode, LETTER_DATE = :letterDate, IE_CODE = :ieCode, REMITTANCE_CURRENCY = :remittanceCurrency WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgIdpmsOrmReq> fgidpmsormreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_IDPMS_ORM_REQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_IDPMS_ORM_REQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgIdpmsOrmReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_ORM_REQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgIdpmsOrmReq.class)
    public List<FgIdpmsOrmReq> findByIds(@BindList("ids") Collection<String> ids);
}
