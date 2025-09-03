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
import com.bsit.codegeneration.entity.FgMbiEfirc;

public interface FgMbiEfircDao {

    /**
     * Inserts a new FgMbiEfirc and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MBI_EFIRC (FIRC_NUMBER, AD_CODE, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, FIRC_CCY, FIRC_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY) VALUES (:fircNumber, :adCode, :fircAmt, :fircUtilAmt, :fircOsAmt, :fircCcy, :fircDate, :ieCode, :remitterName, :remitterCountry, :remitBankCountry)")
    public int insert(@BindBean FgMbiEfirc fgmbiefirc);

    /**
     * Finds a FgMbiEfirc by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MBI_EFIRC WHERE FG_MBI_EFIRC_id = :id")
    @RegisterBeanMapper(FgMbiEfirc.class)
    public Optional<FgMbiEfirc> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MBI_EFIRC")
    @RegisterBeanMapper(FgMbiEfirc.class)
    public List<FgMbiEfirc> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MBI_EFIRC ORDER BY FG_MBI_EFIRC_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgMbiEfirc.class)
    public List<FgMbiEfirc> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgMbiEfirc and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MBI_EFIRC SET FIRC_NUMBER = :fircNumber, AD_CODE = :adCode, FIRC_AMT = :fircAmt, FIRC_UTIL_AMT = :fircUtilAmt, FIRC_OS_AMT = :fircOsAmt, FIRC_CCY = :fircCcy, FIRC_DATE = :fircDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry WHERE FG_MBI_EFIRC_id = :fgMbiEfircId")
    public int update(@BindBean FgMbiEfirc fgmbiefirc);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MBI_EFIRC WHERE FG_MBI_EFIRC_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MBI_EFIRC")
    public long countAll();

    /**
     * Bulk insert multiple FgMbiEfirc entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MBI_EFIRC (FIRC_NUMBER, AD_CODE, FIRC_AMT, FIRC_UTIL_AMT, FIRC_OS_AMT, FIRC_CCY, FIRC_DATE, IE_CODE, REMITTER_NAME, REMITTER_COUNTRY, REMIT_BANK_COUNTRY) VALUES (:fircNumber, :adCode, :fircAmt, :fircUtilAmt, :fircOsAmt, :fircCcy, :fircDate, :ieCode, :remitterName, :remitterCountry, :remitBankCountry)")
    public int[] bulkInsert(@BindBean List<FgMbiEfirc> fgmbiefircs);

    /**
     * Bulk update multiple FgMbiEfirc entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MBI_EFIRC SET FIRC_NUMBER = :fircNumber, AD_CODE = :adCode, FIRC_AMT = :fircAmt, FIRC_UTIL_AMT = :fircUtilAmt, FIRC_OS_AMT = :fircOsAmt, FIRC_CCY = :fircCcy, FIRC_DATE = :fircDate, IE_CODE = :ieCode, REMITTER_NAME = :remitterName, REMITTER_COUNTRY = :remitterCountry, REMIT_BANK_COUNTRY = :remitBankCountry WHERE FG_MBI_EFIRC_id = :fgMbiEfircId")
    public int[] bulkUpdate(@BindBean List<FgMbiEfirc> fgmbiefircs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MBI_EFIRC WHERE FG_MBI_EFIRC_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MBI_EFIRC WHERE FG_MBI_EFIRC_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgMbiEfirc records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MBI_EFIRC WHERE FG_MBI_EFIRC_id IN (<ids>)")
    @RegisterBeanMapper(FgMbiEfirc.class)
    public List<FgMbiEfirc> findByIds(@BindList("ids") Collection<Integer> ids);
}
