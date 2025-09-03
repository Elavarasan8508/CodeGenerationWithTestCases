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
import com.bsit.codegeneration.entity.FgEdpmsSbReq;

public interface FgEdpmsSbReqDao {

    /**
     * Inserts a new FgEdpmsSbReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_EDPMS_SB_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, EXIST_AD, NEW_AD, ADJ_REF_NO, INV_SL_NO, INV_NO, ADJ_IND, ADJ_AMT, BILL_CL_IND, EXT_REF_NO, EXT_BY, EXT_DATE_SB, REMARKS_SB, BANK_REF_NO, AMT_UTIL, PORTCODE, EXP_TYPE, SHIPBILLNO, SHIPBILLDATE, FORMNO, AD_CODE, IE_CODE, EXP_AGENCY, LEO_DATE, OS_PERIOD, AD_BILL_NO, STATUS, INV_DATE, INV_STATUS, FOB_AMT, FOB_CCY, UTIL_FOB_AMT, FREIGHT_AMT, FREIGHT_CCY, UTIL_FREIGHT_AMT, INS_AMT, INS_CCY, UTIL_INS_AMT, MASTER_ID, DETAIL_ID, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DECS, COUNTER_PARTY, WRITE_OFF_BY, WRITE_OFF_REASON, SB_AMOUNT, SB_CCY, SB_UTIL_AMT, SB_OS_AMT, BILLREFNO, BILL_NO, REQ_TYPE, REMARKS, FINAL_ERROR_DESC, FINAL_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :existAd, :newAd, :adjRefNo, :invSlNo, :invNo, :adjInd, :adjAmt, :billClInd, :extRefNo, :extBy, :extDateSb, :remarksSb, :bankRefNo, :amtUtil, :portcode, :expType, :shipbillno, :shipbilldate, :formno, :adCode, :ieCode, :expAgency, :leoDate, :osPeriod, :adBillNo, :status, :invDate, :invStatus, :fobAmt, :fobCcy, :utilFobAmt, :freightAmt, :freightCcy, :utilFreightAmt, :insAmt, :insCcy, :utilInsAmt, :masterId, :detailId, :parentRefId, :parentVersionId, :trracsStatus, :trracsErrorCode, :trracsErrorDecs, :counterParty, :writeOffBy, :writeOffReason, :sbAmount, :sbCcy, :sbUtilAmt, :sbOsAmt, :billrefno, :billNo, :reqType, :remarks, :finalErrorDesc, :finalStatus)")
    public int insert(@BindBean FgEdpmsSbReq fgedpmssbreq);

    /**
     * Finds a FgEdpmsSbReq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_SB_REQ WHERE ID = :id")
    @RegisterBeanMapper(FgEdpmsSbReq.class)
    public Optional<FgEdpmsSbReq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_SB_REQ")
    @RegisterBeanMapper(FgEdpmsSbReq.class)
    public List<FgEdpmsSbReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_SB_REQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgEdpmsSbReq.class)
    public List<FgEdpmsSbReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgEdpmsSbReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_EDPMS_SB_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, EXIST_AD = :existAd, NEW_AD = :newAd, ADJ_REF_NO = :adjRefNo, INV_SL_NO = :invSlNo, INV_NO = :invNo, ADJ_IND = :adjInd, ADJ_AMT = :adjAmt, BILL_CL_IND = :billClInd, EXT_REF_NO = :extRefNo, EXT_BY = :extBy, EXT_DATE_SB = :extDateSb, REMARKS_SB = :remarksSb, BANK_REF_NO = :bankRefNo, AMT_UTIL = :amtUtil, PORTCODE = :portcode, EXP_TYPE = :expType, SHIPBILLNO = :shipbillno, SHIPBILLDATE = :shipbilldate, FORMNO = :formno, AD_CODE = :adCode, IE_CODE = :ieCode, EXP_AGENCY = :expAgency, LEO_DATE = :leoDate, OS_PERIOD = :osPeriod, AD_BILL_NO = :adBillNo, STATUS = :status, INV_DATE = :invDate, INV_STATUS = :invStatus, FOB_AMT = :fobAmt, FOB_CCY = :fobCcy, UTIL_FOB_AMT = :utilFobAmt, FREIGHT_AMT = :freightAmt, FREIGHT_CCY = :freightCcy, UTIL_FREIGHT_AMT = :utilFreightAmt, INS_AMT = :insAmt, INS_CCY = :insCcy, UTIL_INS_AMT = :utilInsAmt, MASTER_ID = :masterId, DETAIL_ID = :detailId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, TRRACS_STATUS = :trracsStatus, TRRACS_ERROR_CODE = :trracsErrorCode, TRRACS_ERROR_DECS = :trracsErrorDecs, COUNTER_PARTY = :counterParty, WRITE_OFF_BY = :writeOffBy, WRITE_OFF_REASON = :writeOffReason, SB_AMOUNT = :sbAmount, SB_CCY = :sbCcy, SB_UTIL_AMT = :sbUtilAmt, SB_OS_AMT = :sbOsAmt, BILLREFNO = :billrefno, BILL_NO = :billNo, REQ_TYPE = :reqType, REMARKS = :remarks, FINAL_ERROR_DESC = :finalErrorDesc, FINAL_STATUS = :finalStatus WHERE ID = :id")
    public int update(@BindBean FgEdpmsSbReq fgedpmssbreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EDPMS_SB_REQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_EDPMS_SB_REQ")
    public long countAll();

    /**
     * Bulk insert multiple FgEdpmsSbReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_EDPMS_SB_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, EXIST_AD, NEW_AD, ADJ_REF_NO, INV_SL_NO, INV_NO, ADJ_IND, ADJ_AMT, BILL_CL_IND, EXT_REF_NO, EXT_BY, EXT_DATE_SB, REMARKS_SB, BANK_REF_NO, AMT_UTIL, PORTCODE, EXP_TYPE, SHIPBILLNO, SHIPBILLDATE, FORMNO, AD_CODE, IE_CODE, EXP_AGENCY, LEO_DATE, OS_PERIOD, AD_BILL_NO, STATUS, INV_DATE, INV_STATUS, FOB_AMT, FOB_CCY, UTIL_FOB_AMT, FREIGHT_AMT, FREIGHT_CCY, UTIL_FREIGHT_AMT, INS_AMT, INS_CCY, UTIL_INS_AMT, MASTER_ID, DETAIL_ID, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DECS, COUNTER_PARTY, WRITE_OFF_BY, WRITE_OFF_REASON, SB_AMOUNT, SB_CCY, SB_UTIL_AMT, SB_OS_AMT, BILLREFNO, BILL_NO, REQ_TYPE, REMARKS, FINAL_ERROR_DESC, FINAL_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :existAd, :newAd, :adjRefNo, :invSlNo, :invNo, :adjInd, :adjAmt, :billClInd, :extRefNo, :extBy, :extDateSb, :remarksSb, :bankRefNo, :amtUtil, :portcode, :expType, :shipbillno, :shipbilldate, :formno, :adCode, :ieCode, :expAgency, :leoDate, :osPeriod, :adBillNo, :status, :invDate, :invStatus, :fobAmt, :fobCcy, :utilFobAmt, :freightAmt, :freightCcy, :utilFreightAmt, :insAmt, :insCcy, :utilInsAmt, :masterId, :detailId, :parentRefId, :parentVersionId, :trracsStatus, :trracsErrorCode, :trracsErrorDecs, :counterParty, :writeOffBy, :writeOffReason, :sbAmount, :sbCcy, :sbUtilAmt, :sbOsAmt, :billrefno, :billNo, :reqType, :remarks, :finalErrorDesc, :finalStatus)")
    public int[] bulkInsert(@BindBean List<FgEdpmsSbReq> fgedpmssbreqs);

    /**
     * Bulk update multiple FgEdpmsSbReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_EDPMS_SB_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, EXIST_AD = :existAd, NEW_AD = :newAd, ADJ_REF_NO = :adjRefNo, INV_SL_NO = :invSlNo, INV_NO = :invNo, ADJ_IND = :adjInd, ADJ_AMT = :adjAmt, BILL_CL_IND = :billClInd, EXT_REF_NO = :extRefNo, EXT_BY = :extBy, EXT_DATE_SB = :extDateSb, REMARKS_SB = :remarksSb, BANK_REF_NO = :bankRefNo, AMT_UTIL = :amtUtil, PORTCODE = :portcode, EXP_TYPE = :expType, SHIPBILLNO = :shipbillno, SHIPBILLDATE = :shipbilldate, FORMNO = :formno, AD_CODE = :adCode, IE_CODE = :ieCode, EXP_AGENCY = :expAgency, LEO_DATE = :leoDate, OS_PERIOD = :osPeriod, AD_BILL_NO = :adBillNo, STATUS = :status, INV_DATE = :invDate, INV_STATUS = :invStatus, FOB_AMT = :fobAmt, FOB_CCY = :fobCcy, UTIL_FOB_AMT = :utilFobAmt, FREIGHT_AMT = :freightAmt, FREIGHT_CCY = :freightCcy, UTIL_FREIGHT_AMT = :utilFreightAmt, INS_AMT = :insAmt, INS_CCY = :insCcy, UTIL_INS_AMT = :utilInsAmt, MASTER_ID = :masterId, DETAIL_ID = :detailId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, TRRACS_STATUS = :trracsStatus, TRRACS_ERROR_CODE = :trracsErrorCode, TRRACS_ERROR_DECS = :trracsErrorDecs, COUNTER_PARTY = :counterParty, WRITE_OFF_BY = :writeOffBy, WRITE_OFF_REASON = :writeOffReason, SB_AMOUNT = :sbAmount, SB_CCY = :sbCcy, SB_UTIL_AMT = :sbUtilAmt, SB_OS_AMT = :sbOsAmt, BILLREFNO = :billrefno, BILL_NO = :billNo, REQ_TYPE = :reqType, REMARKS = :remarks, FINAL_ERROR_DESC = :finalErrorDesc, FINAL_STATUS = :finalStatus WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgEdpmsSbReq> fgedpmssbreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EDPMS_SB_REQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_EDPMS_SB_REQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgEdpmsSbReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_EDPMS_SB_REQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgEdpmsSbReq.class)
    public List<FgEdpmsSbReq> findByIds(@BindList("ids") Collection<String> ids);
}
