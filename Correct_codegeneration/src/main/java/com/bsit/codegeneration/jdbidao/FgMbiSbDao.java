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
import com.bsit.codegeneration.entity.FgMbiSb;

public interface FgMbiSbDao {

    /**
     * Inserts a new FgMbiSb and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MBI_SB (BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, BILL_NO, FORMNO, SHIPBILLDATE, LEODATE, ADCODE, PORTCODE, EXPORT_AGENCY, EXP_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INV_NO, INV_DATE, INV_SL_NO, FOBCURRCODE, FRIEGHTCURRCODE, INSCURRCODE, FOB_AMT, UTIL_FOB_AMT, FRIEGHT_AMT, UTIL_FRIEGHT_AMT, INS_AMT, UTIL_INS_AMT, LEO_DATE) VALUES (:billId, :invoiceId, :shippingBillStatus, :billNo, :formno, :shipbilldate, :leodate, :adcode, :portcode, :exportAgency, :expType, :ieCode, :adBillNumber, :invoiceStatus, :invNo, :invDate, :invSlNo, :fobcurrcode, :frieghtcurrcode, :inscurrcode, :fobAmt, :utilFobAmt, :frieghtAmt, :utilFrieghtAmt, :insAmt, :utilInsAmt, :leoDate)")
    public int insert(@BindBean FgMbiSb fgmbisb);

    /**
     * Finds a FgMbiSb by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MBI_SB WHERE FG_MBI_SB_id = :id")
    @RegisterBeanMapper(FgMbiSb.class)
    public Optional<FgMbiSb> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MBI_SB")
    @RegisterBeanMapper(FgMbiSb.class)
    public List<FgMbiSb> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MBI_SB ORDER BY FG_MBI_SB_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgMbiSb.class)
    public List<FgMbiSb> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgMbiSb and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MBI_SB SET BILL_ID = :billId, INVOICE_ID = :invoiceId, SHIPPING_BILL_STATUS = :shippingBillStatus, BILL_NO = :billNo, FORMNO = :formno, SHIPBILLDATE = :shipbilldate, LEODATE = :leodate, ADCODE = :adcode, PORTCODE = :portcode, EXPORT_AGENCY = :exportAgency, EXP_TYPE = :expType, IE_CODE = :ieCode, AD_BILL_NUMBER = :adBillNumber, INVOICE_STATUS = :invoiceStatus, INV_NO = :invNo, INV_DATE = :invDate, INV_SL_NO = :invSlNo, FOBCURRCODE = :fobcurrcode, FRIEGHTCURRCODE = :frieghtcurrcode, INSCURRCODE = :inscurrcode, FOB_AMT = :fobAmt, UTIL_FOB_AMT = :utilFobAmt, FRIEGHT_AMT = :frieghtAmt, UTIL_FRIEGHT_AMT = :utilFrieghtAmt, INS_AMT = :insAmt, UTIL_INS_AMT = :utilInsAmt, LEO_DATE = :leoDate WHERE FG_MBI_SB_id = :fgMbiSbId")
    public int update(@BindBean FgMbiSb fgmbisb);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MBI_SB WHERE FG_MBI_SB_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MBI_SB")
    public long countAll();

    /**
     * Bulk insert multiple FgMbiSb entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MBI_SB (BILL_ID, INVOICE_ID, SHIPPING_BILL_STATUS, BILL_NO, FORMNO, SHIPBILLDATE, LEODATE, ADCODE, PORTCODE, EXPORT_AGENCY, EXP_TYPE, IE_CODE, AD_BILL_NUMBER, INVOICE_STATUS, INV_NO, INV_DATE, INV_SL_NO, FOBCURRCODE, FRIEGHTCURRCODE, INSCURRCODE, FOB_AMT, UTIL_FOB_AMT, FRIEGHT_AMT, UTIL_FRIEGHT_AMT, INS_AMT, UTIL_INS_AMT, LEO_DATE) VALUES (:billId, :invoiceId, :shippingBillStatus, :billNo, :formno, :shipbilldate, :leodate, :adcode, :portcode, :exportAgency, :expType, :ieCode, :adBillNumber, :invoiceStatus, :invNo, :invDate, :invSlNo, :fobcurrcode, :frieghtcurrcode, :inscurrcode, :fobAmt, :utilFobAmt, :frieghtAmt, :utilFrieghtAmt, :insAmt, :utilInsAmt, :leoDate)")
    public int[] bulkInsert(@BindBean List<FgMbiSb> fgmbisbs);

    /**
     * Bulk update multiple FgMbiSb entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MBI_SB SET BILL_ID = :billId, INVOICE_ID = :invoiceId, SHIPPING_BILL_STATUS = :shippingBillStatus, BILL_NO = :billNo, FORMNO = :formno, SHIPBILLDATE = :shipbilldate, LEODATE = :leodate, ADCODE = :adcode, PORTCODE = :portcode, EXPORT_AGENCY = :exportAgency, EXP_TYPE = :expType, IE_CODE = :ieCode, AD_BILL_NUMBER = :adBillNumber, INVOICE_STATUS = :invoiceStatus, INV_NO = :invNo, INV_DATE = :invDate, INV_SL_NO = :invSlNo, FOBCURRCODE = :fobcurrcode, FRIEGHTCURRCODE = :frieghtcurrcode, INSCURRCODE = :inscurrcode, FOB_AMT = :fobAmt, UTIL_FOB_AMT = :utilFobAmt, FRIEGHT_AMT = :frieghtAmt, UTIL_FRIEGHT_AMT = :utilFrieghtAmt, INS_AMT = :insAmt, UTIL_INS_AMT = :utilInsAmt, LEO_DATE = :leoDate WHERE FG_MBI_SB_id = :fgMbiSbId")
    public int[] bulkUpdate(@BindBean List<FgMbiSb> fgmbisbs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MBI_SB WHERE FG_MBI_SB_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MBI_SB WHERE FG_MBI_SB_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgMbiSb records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MBI_SB WHERE FG_MBI_SB_id IN (<ids>)")
    @RegisterBeanMapper(FgMbiSb.class)
    public List<FgMbiSb> findByIds(@BindList("ids") Collection<Integer> ids);
}
