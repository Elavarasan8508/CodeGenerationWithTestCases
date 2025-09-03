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
import com.bsit.codegeneration.entity.FgTrdBillSb;

public interface FgTrdBillSbDao {

    /**
     * Inserts a new FgTrdBillSb and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_BILL_SB (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SHIPPINGBILL_NO, SB_DATE, FORM_NO, PORT_CODE, FOB_AMT, FOB_CCY, IE_CODE, UTIL_FOB_AMT, INV_SL_NO, INV_NO, EXP_AGENCY, AD_CODE, LEO_DATE, OS_PERIOD, AD_BILL_NO, SB_STATUS, EXP_TYPE, INV_DATE, INV_STATUS, FREIGHT_AMT, FREIGHT_CCY, UTIL_FREIGHT_AMT, INS_AMT, INS_CCY, UTIL_INS_AMT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :shippingbillNo, :sbDate, :formNo, :portCode, :fobAmt, :fobCcy, :ieCode, :utilFobAmt, :invSlNo, :invNo, :expAgency, :adCode, :leoDate, :osPeriod, :adBillNo, :sbStatus, :expType, :invDate, :invStatus, :freightAmt, :freightCcy, :utilFreightAmt, :insAmt, :insCcy, :utilInsAmt)")
    public int insert(@BindBean FgTrdBillSb fgtrdbillsb);

    /**
     * Finds a FgTrdBillSb by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_SB WHERE ID = :id")
    @RegisterBeanMapper(FgTrdBillSb.class)
    public Optional<FgTrdBillSb> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_SB")
    @RegisterBeanMapper(FgTrdBillSb.class)
    public List<FgTrdBillSb> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_SB ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdBillSb.class)
    public List<FgTrdBillSb> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdBillSb and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_BILL_SB SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SHIPPINGBILL_NO = :shippingbillNo, SB_DATE = :sbDate, FORM_NO = :formNo, PORT_CODE = :portCode, FOB_AMT = :fobAmt, FOB_CCY = :fobCcy, IE_CODE = :ieCode, UTIL_FOB_AMT = :utilFobAmt, INV_SL_NO = :invSlNo, INV_NO = :invNo, EXP_AGENCY = :expAgency, AD_CODE = :adCode, LEO_DATE = :leoDate, OS_PERIOD = :osPeriod, AD_BILL_NO = :adBillNo, SB_STATUS = :sbStatus, EXP_TYPE = :expType, INV_DATE = :invDate, INV_STATUS = :invStatus, FREIGHT_AMT = :freightAmt, FREIGHT_CCY = :freightCcy, UTIL_FREIGHT_AMT = :utilFreightAmt, INS_AMT = :insAmt, INS_CCY = :insCcy, UTIL_INS_AMT = :utilInsAmt WHERE ID = :id")
    public int update(@BindBean FgTrdBillSb fgtrdbillsb);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_BILL_SB WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_BILL_SB")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdBillSb entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_BILL_SB (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SHIPPINGBILL_NO, SB_DATE, FORM_NO, PORT_CODE, FOB_AMT, FOB_CCY, IE_CODE, UTIL_FOB_AMT, INV_SL_NO, INV_NO, EXP_AGENCY, AD_CODE, LEO_DATE, OS_PERIOD, AD_BILL_NO, SB_STATUS, EXP_TYPE, INV_DATE, INV_STATUS, FREIGHT_AMT, FREIGHT_CCY, UTIL_FREIGHT_AMT, INS_AMT, INS_CCY, UTIL_INS_AMT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :shippingbillNo, :sbDate, :formNo, :portCode, :fobAmt, :fobCcy, :ieCode, :utilFobAmt, :invSlNo, :invNo, :expAgency, :adCode, :leoDate, :osPeriod, :adBillNo, :sbStatus, :expType, :invDate, :invStatus, :freightAmt, :freightCcy, :utilFreightAmt, :insAmt, :insCcy, :utilInsAmt)")
    public int[] bulkInsert(@BindBean List<FgTrdBillSb> fgtrdbillsbs);

    /**
     * Bulk update multiple FgTrdBillSb entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_BILL_SB SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SHIPPINGBILL_NO = :shippingbillNo, SB_DATE = :sbDate, FORM_NO = :formNo, PORT_CODE = :portCode, FOB_AMT = :fobAmt, FOB_CCY = :fobCcy, IE_CODE = :ieCode, UTIL_FOB_AMT = :utilFobAmt, INV_SL_NO = :invSlNo, INV_NO = :invNo, EXP_AGENCY = :expAgency, AD_CODE = :adCode, LEO_DATE = :leoDate, OS_PERIOD = :osPeriod, AD_BILL_NO = :adBillNo, SB_STATUS = :sbStatus, EXP_TYPE = :expType, INV_DATE = :invDate, INV_STATUS = :invStatus, FREIGHT_AMT = :freightAmt, FREIGHT_CCY = :freightCcy, UTIL_FREIGHT_AMT = :utilFreightAmt, INS_AMT = :insAmt, INS_CCY = :insCcy, UTIL_INS_AMT = :utilInsAmt WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdBillSb> fgtrdbillsbs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_BILL_SB WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_BILL_SB WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdBillSb records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_SB WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdBillSb.class)
    public List<FgTrdBillSb> findByIds(@BindList("ids") Collection<String> ids);
}
