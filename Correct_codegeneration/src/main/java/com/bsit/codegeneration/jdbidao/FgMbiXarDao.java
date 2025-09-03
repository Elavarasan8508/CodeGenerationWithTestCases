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
import com.bsit.codegeneration.entity.FgMbiXar;

public interface FgMbiXarDao {

    /**
     * Inserts a new FgMbiXar and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MBI_XAR (IRM_NO, IRM_DATE, AD_CODE, IRM_CCY, IRM_AMT, IRM_OS_AMT, IRM_UTIL_AMT, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, PURPOSE_OF_REMITTANCE) VALUES (:irmNo, :irmDate, :adCode, :irmCcy, :irmAmt, :irmOsAmt, :irmUtilAmt, :ieCode, :remitterName, :remitterCountry, :remitBankCountry, :purposeOfRemittance)")
    public int insert(@BindBean FgMbiXar fgmbixar);

    /**
     * Finds a FgMbiXar by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MBI_XAR WHERE FG_MBI_XAR_id = :id")
    @RegisterBeanMapper(FgMbiXar.class)
    public Optional<FgMbiXar> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MBI_XAR")
    @RegisterBeanMapper(FgMbiXar.class)
    public List<FgMbiXar> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MBI_XAR ORDER BY FG_MBI_XAR_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgMbiXar.class)
    public List<FgMbiXar> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgMbiXar and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MBI_XAR SET IRM_NO = :irmNo, IRM_DATE = :irmDate, AD_CODE = :adCode, IRM_CCY = :irmCcy, IRM_AMT = :irmAmt, IRM_OS_AMT = :irmOsAmt, IRM_UTIL_AMT = :irmUtilAmt, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry, PURPOSE_OF_REMITTANCE = :purposeOfRemittance WHERE FG_MBI_XAR_id = :fgMbiXarId")
    public int update(@BindBean FgMbiXar fgmbixar);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MBI_XAR WHERE FG_MBI_XAR_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MBI_XAR")
    public long countAll();

    /**
     * Bulk insert multiple FgMbiXar entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MBI_XAR (IRM_NO, IRM_DATE, AD_CODE, IRM_CCY, IRM_AMT, IRM_OS_AMT, IRM_UTIL_AMT, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY, PURPOSE_OF_REMITTANCE) VALUES (:irmNo, :irmDate, :adCode, :irmCcy, :irmAmt, :irmOsAmt, :irmUtilAmt, :ieCode, :remitterName, :remitterCountry, :remitBankCountry, :purposeOfRemittance)")
    public int[] bulkInsert(@BindBean List<FgMbiXar> fgmbixars);

    /**
     * Bulk update multiple FgMbiXar entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MBI_XAR SET IRM_NO = :irmNo, IRM_DATE = :irmDate, AD_CODE = :adCode, IRM_CCY = :irmCcy, IRM_AMT = :irmAmt, IRM_OS_AMT = :irmOsAmt, IRM_UTIL_AMT = :irmUtilAmt, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry, PURPOSE_OF_REMITTANCE = :purposeOfRemittance WHERE FG_MBI_XAR_id = :fgMbiXarId")
    public int[] bulkUpdate(@BindBean List<FgMbiXar> fgmbixars);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MBI_XAR WHERE FG_MBI_XAR_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MBI_XAR WHERE FG_MBI_XAR_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgMbiXar records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MBI_XAR WHERE FG_MBI_XAR_id IN (<ids>)")
    @RegisterBeanMapper(FgMbiXar.class)
    public List<FgMbiXar> findByIds(@BindList("ids") Collection<Integer> ids);
}
