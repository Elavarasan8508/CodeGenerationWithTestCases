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
import com.bsit.codegeneration.entity.FgExpMbiSb;

public interface FgExpMbiSbDao {

    /**
     * Inserts a new FgExpMbiSb and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_EXP_MBI_SB (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SHIPBILLNO, SHIPBILLDATE, FORMNO, IE_CODE, EXP_AGENCY, ADCODE, LEODATE, OS_PERIOD, AD_BILL_NO, SB_STATUS, INV_SL_NO, INV_NO, PORTCODE, EXP_TYPE, INV_DATE, INV_STATUS, FOB_AMT, FOBCURRCODE, UTIL_FOB_AMT, FRIEGHT_AMT, FRIEGHTCURRCODE, UTIL_FRIEGHT_AMT, INS_AMT, INSCURRCODE, UTIL_INS_AMT, HS_CODE, GOOD_DESC, PORT_OF_DEST, TRANSPORT_DOC_NO, BILL_NO, SB_AMOUNT, SB_OS_AMT, TOTAL_SETTLED_AMT, BILL_UTIL_AMT, BILL_AMT, PARENT_REF_ID, PARENT_VERSION_ID, SB_SHORTFALL, SB_REASON, ENDORSED_AMT, BILL_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :shipbillno, :shipbilldate, :formno, :ieCode, :expAgency, :adcode, :leodate, :osPeriod, :adBillNo, :sbStatus, :invSlNo, :invNo, :portcode, :expType, :invDate, :invStatus, :fobAmt, :fobcurrcode, :utilFobAmt, :frieghtAmt, :frieghtcurrcode, :utilFrieghtAmt, :insAmt, :inscurrcode, :utilInsAmt, :hsCode, :goodDesc, :portOfDest, :transportDocNo, :billNo, :sbAmount, :sbOsAmt, :totalSettledAmt, :billUtilAmt, :billAmt, :parentRefId, :parentVersionId, :sbShortfall, :sbReason, :endorsedAmt, :billType)")
    public int insert(@BindBean FgExpMbiSb fgexpmbisb);

    /**
     * Finds a FgExpMbiSb by its ID.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_SB WHERE FG_EXP_MBI_SB_id = :id")
    @RegisterBeanMapper(FgExpMbiSb.class)
    public Optional<FgExpMbiSb> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_SB")
    @RegisterBeanMapper(FgExpMbiSb.class)
    public List<FgExpMbiSb> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_SB ORDER BY FG_EXP_MBI_SB_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgExpMbiSb.class)
    public List<FgExpMbiSb> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgExpMbiSb and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_EXP_MBI_SB SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SHIPBILLNO = :shipbillno, SHIPBILLDATE = :shipbilldate, FORMNO = :formno, IE_CODE = :ieCode, EXP_AGENCY = :expAgency, ADCODE = :adcode, LEODATE = :leodate, OS_PERIOD = :osPeriod, AD_BILL_NO = :adBillNo, SB_STATUS = :sbStatus, INV_SL_NO = :invSlNo, INV_NO = :invNo, PORTCODE = :portcode, EXP_TYPE = :expType, INV_DATE = :invDate, INV_STATUS = :invStatus, FOB_AMT = :fobAmt, FOBCURRCODE = :fobcurrcode, UTIL_FOB_AMT = :utilFobAmt, FRIEGHT_AMT = :frieghtAmt, FRIEGHTCURRCODE = :frieghtcurrcode, UTIL_FRIEGHT_AMT = :utilFrieghtAmt, INS_AMT = :insAmt, INSCURRCODE = :inscurrcode, UTIL_INS_AMT = :utilInsAmt, HS_CODE = :hsCode, GOOD_DESC = :goodDesc, PORT_OF_DEST = :portOfDest, TRANSPORT_DOC_NO = :transportDocNo, BILL_NO = :billNo, SB_AMOUNT = :sbAmount, SB_OS_AMT = :sbOsAmt, TOTAL_SETTLED_AMT = :totalSettledAmt, BILL_UTIL_AMT = :billUtilAmt, BILL_AMT = :billAmt, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, SB_SHORTFALL = :sbShortfall, SB_REASON = :sbReason, ENDORSED_AMT = :endorsedAmt, BILL_TYPE = :billType WHERE FG_EXP_MBI_SB_id = :fgExpMbiSbId")
    public int update(@BindBean FgExpMbiSb fgexpmbisb);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EXP_MBI_SB WHERE FG_EXP_MBI_SB_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_EXP_MBI_SB")
    public long countAll();

    /**
     * Bulk insert multiple FgExpMbiSb entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_EXP_MBI_SB (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SHIPBILLNO, SHIPBILLDATE, FORMNO, IE_CODE, EXP_AGENCY, ADCODE, LEODATE, OS_PERIOD, AD_BILL_NO, SB_STATUS, INV_SL_NO, INV_NO, PORTCODE, EXP_TYPE, INV_DATE, INV_STATUS, FOB_AMT, FOBCURRCODE, UTIL_FOB_AMT, FRIEGHT_AMT, FRIEGHTCURRCODE, UTIL_FRIEGHT_AMT, INS_AMT, INSCURRCODE, UTIL_INS_AMT, HS_CODE, GOOD_DESC, PORT_OF_DEST, TRANSPORT_DOC_NO, BILL_NO, SB_AMOUNT, SB_OS_AMT, TOTAL_SETTLED_AMT, BILL_UTIL_AMT, BILL_AMT, PARENT_REF_ID, PARENT_VERSION_ID, SB_SHORTFALL, SB_REASON, ENDORSED_AMT, BILL_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :shipbillno, :shipbilldate, :formno, :ieCode, :expAgency, :adcode, :leodate, :osPeriod, :adBillNo, :sbStatus, :invSlNo, :invNo, :portcode, :expType, :invDate, :invStatus, :fobAmt, :fobcurrcode, :utilFobAmt, :frieghtAmt, :frieghtcurrcode, :utilFrieghtAmt, :insAmt, :inscurrcode, :utilInsAmt, :hsCode, :goodDesc, :portOfDest, :transportDocNo, :billNo, :sbAmount, :sbOsAmt, :totalSettledAmt, :billUtilAmt, :billAmt, :parentRefId, :parentVersionId, :sbShortfall, :sbReason, :endorsedAmt, :billType)")
    public int[] bulkInsert(@BindBean List<FgExpMbiSb> fgexpmbisbs);

    /**
     * Bulk update multiple FgExpMbiSb entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_EXP_MBI_SB SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SHIPBILLNO = :shipbillno, SHIPBILLDATE = :shipbilldate, FORMNO = :formno, IE_CODE = :ieCode, EXP_AGENCY = :expAgency, ADCODE = :adcode, LEODATE = :leodate, OS_PERIOD = :osPeriod, AD_BILL_NO = :adBillNo, SB_STATUS = :sbStatus, INV_SL_NO = :invSlNo, INV_NO = :invNo, PORTCODE = :portcode, EXP_TYPE = :expType, INV_DATE = :invDate, INV_STATUS = :invStatus, FOB_AMT = :fobAmt, FOBCURRCODE = :fobcurrcode, UTIL_FOB_AMT = :utilFobAmt, FRIEGHT_AMT = :frieghtAmt, FRIEGHTCURRCODE = :frieghtcurrcode, UTIL_FRIEGHT_AMT = :utilFrieghtAmt, INS_AMT = :insAmt, INSCURRCODE = :inscurrcode, UTIL_INS_AMT = :utilInsAmt, HS_CODE = :hsCode, GOOD_DESC = :goodDesc, PORT_OF_DEST = :portOfDest, TRANSPORT_DOC_NO = :transportDocNo, BILL_NO = :billNo, SB_AMOUNT = :sbAmount, SB_OS_AMT = :sbOsAmt, TOTAL_SETTLED_AMT = :totalSettledAmt, BILL_UTIL_AMT = :billUtilAmt, BILL_AMT = :billAmt, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, SB_SHORTFALL = :sbShortfall, SB_REASON = :sbReason, ENDORSED_AMT = :endorsedAmt, BILL_TYPE = :billType WHERE FG_EXP_MBI_SB_id = :fgExpMbiSbId")
    public int[] bulkUpdate(@BindBean List<FgExpMbiSb> fgexpmbisbs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EXP_MBI_SB WHERE FG_EXP_MBI_SB_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_EXP_MBI_SB WHERE FG_EXP_MBI_SB_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgExpMbiSb records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_EXP_MBI_SB WHERE FG_EXP_MBI_SB_id IN (<ids>)")
    @RegisterBeanMapper(FgExpMbiSb.class)
    public List<FgExpMbiSb> findByIds(@BindList("ids") Collection<Integer> ids);
}
