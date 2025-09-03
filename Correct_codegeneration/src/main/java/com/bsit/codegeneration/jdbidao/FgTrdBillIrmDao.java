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
import com.bsit.codegeneration.entity.FgTrdBillIrm;

public interface FgTrdBillIrmDao {

    /**
     * Inserts a new FgTrdBillIrm and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_BILL_IRM (IRM_NUMBER, AD_CODE, IRM_AMT, IRM_OS_AMT, IRM_CCY, REMITTANCE_DATE, IE_CODE, REMITTER_NAME) VALUES (:irmNumber, :adCode, :irmAmt, :irmOsAmt, :irmCcy, :remittanceDate, :ieCode, :remitterName)")
    public int insert(@BindBean FgTrdBillIrm fgtrdbillirm);

    /**
     * Finds a FgTrdBillIrm by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_IRM WHERE FG_TRD_BILL_IRM_id = :id")
    @RegisterBeanMapper(FgTrdBillIrm.class)
    public Optional<FgTrdBillIrm> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_IRM")
    @RegisterBeanMapper(FgTrdBillIrm.class)
    public List<FgTrdBillIrm> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_IRM ORDER BY FG_TRD_BILL_IRM_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdBillIrm.class)
    public List<FgTrdBillIrm> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdBillIrm and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_BILL_IRM SET IRM_NUMBER = :irmNumber, AD_CODE = :adCode, IRM_AMT = :irmAmt, IRM_OS_AMT = :irmOsAmt, IRM_CCY = :irmCcy, REMITTANCE_DATE = :remittanceDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName WHERE FG_TRD_BILL_IRM_id = :fgTrdBillIrmId")
    public int update(@BindBean FgTrdBillIrm fgtrdbillirm);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_BILL_IRM WHERE FG_TRD_BILL_IRM_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_BILL_IRM")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdBillIrm entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_BILL_IRM (IRM_NUMBER, AD_CODE, IRM_AMT, IRM_OS_AMT, IRM_CCY, REMITTANCE_DATE, IE_CODE, REMITTER_NAME) VALUES (:irmNumber, :adCode, :irmAmt, :irmOsAmt, :irmCcy, :remittanceDate, :ieCode, :remitterName)")
    public int[] bulkInsert(@BindBean List<FgTrdBillIrm> fgtrdbillirms);

    /**
     * Bulk update multiple FgTrdBillIrm entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_BILL_IRM SET IRM_NUMBER = :irmNumber, AD_CODE = :adCode, IRM_AMT = :irmAmt, IRM_OS_AMT = :irmOsAmt, IRM_CCY = :irmCcy, REMITTANCE_DATE = :remittanceDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName WHERE FG_TRD_BILL_IRM_id = :fgTrdBillIrmId")
    public int[] bulkUpdate(@BindBean List<FgTrdBillIrm> fgtrdbillirms);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_BILL_IRM WHERE FG_TRD_BILL_IRM_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_BILL_IRM WHERE FG_TRD_BILL_IRM_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgTrdBillIrm records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_BILL_IRM WHERE FG_TRD_BILL_IRM_id IN (<ids>)")
    @RegisterBeanMapper(FgTrdBillIrm.class)
    public List<FgTrdBillIrm> findByIds(@BindList("ids") Collection<Integer> ids);
}
