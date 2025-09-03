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
import com.bsit.codegeneration.entity.FxRateTd;

public interface FxRateTdDao {

    /**
     * Inserts a new FxRateTd and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FX_RATE_TD (INT_TBL_CODE, CRNCY_CODE, INT_SLAB_SRL_NUM, MAX_PERIOD_RUN_MTHS, MAX_PERIOD_RUN_DAYS, BEGIN_SLAB_AMOUNT, MAX_SLAB_AMOUNT, NRML_INT_PCNT) VALUES (:intTblCode, :crncyCode, :intSlabSrlNum, :maxPeriodRunMths, :maxPeriodRunDays, :beginSlabAmount, :maxSlabAmount, :nrmlIntPcnt)")
    public int insert(@BindBean FxRateTd fxratetd);

    /**
     * Finds a FxRateTd by its ID.
     */
    @SqlQuery("SELECT * FROM FX_RATE_TD WHERE FX_RATE_TD_id = :id")
    @RegisterBeanMapper(FxRateTd.class)
    public Optional<FxRateTd> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FX_RATE_TD")
    @RegisterBeanMapper(FxRateTd.class)
    public List<FxRateTd> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FX_RATE_TD ORDER BY FX_RATE_TD_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FxRateTd.class)
    public List<FxRateTd> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FxRateTd and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FX_RATE_TD SET INT_TBL_CODE = :intTblCode, CRNCY_CODE = :crncyCode, INT_SLAB_SRL_NUM = :intSlabSrlNum, MAX_PERIOD_RUN_MTHS = :maxPeriodRunMths, MAX_PERIOD_RUN_DAYS = :maxPeriodRunDays, BEGIN_SLAB_AMOUNT = :beginSlabAmount, MAX_SLAB_AMOUNT = :maxSlabAmount, NRML_INT_PCNT = :nrmlIntPcnt WHERE FX_RATE_TD_id = :fxRateTdId")
    public int update(@BindBean FxRateTd fxratetd);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FX_RATE_TD WHERE FX_RATE_TD_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FX_RATE_TD")
    public long countAll();

    /**
     * Bulk insert multiple FxRateTd entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FX_RATE_TD (INT_TBL_CODE, CRNCY_CODE, INT_SLAB_SRL_NUM, MAX_PERIOD_RUN_MTHS, MAX_PERIOD_RUN_DAYS, BEGIN_SLAB_AMOUNT, MAX_SLAB_AMOUNT, NRML_INT_PCNT) VALUES (:intTblCode, :crncyCode, :intSlabSrlNum, :maxPeriodRunMths, :maxPeriodRunDays, :beginSlabAmount, :maxSlabAmount, :nrmlIntPcnt)")
    public int[] bulkInsert(@BindBean List<FxRateTd> fxratetds);

    /**
     * Bulk update multiple FxRateTd entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FX_RATE_TD SET INT_TBL_CODE = :intTblCode, CRNCY_CODE = :crncyCode, INT_SLAB_SRL_NUM = :intSlabSrlNum, MAX_PERIOD_RUN_MTHS = :maxPeriodRunMths, MAX_PERIOD_RUN_DAYS = :maxPeriodRunDays, BEGIN_SLAB_AMOUNT = :beginSlabAmount, MAX_SLAB_AMOUNT = :maxSlabAmount, NRML_INT_PCNT = :nrmlIntPcnt WHERE FX_RATE_TD_id = :fxRateTdId")
    public int[] bulkUpdate(@BindBean List<FxRateTd> fxratetds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FX_RATE_TD WHERE FX_RATE_TD_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FX_RATE_TD WHERE FX_RATE_TD_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FxRateTd records by their IDs.
     */
    @SqlQuery("SELECT * FROM FX_RATE_TD WHERE FX_RATE_TD_id IN (<ids>)")
    @RegisterBeanMapper(FxRateTd.class)
    public List<FxRateTd> findByIds(@BindList("ids") Collection<Integer> ids);
}
