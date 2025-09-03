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
import com.bsit.codegeneration.entity.FgTdTenure;

public interface FgTdTenureDao {

    /**
     * Inserts a new FgTdTenure and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_TENURE (TENURE, INTEREST_RATES, RECOMMENDED, INTEREST, DAYS) VALUES (:tenure, :interestRates, :recommended, :interest, :days)")
    public int insert(@BindBean FgTdTenure fgtdtenure);

    /**
     * Finds a FgTdTenure by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_TENURE WHERE FG_TD_TENURE_id = :id")
    @RegisterBeanMapper(FgTdTenure.class)
    public Optional<FgTdTenure> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_TENURE")
    @RegisterBeanMapper(FgTdTenure.class)
    public List<FgTdTenure> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_TENURE ORDER BY FG_TD_TENURE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdTenure.class)
    public List<FgTdTenure> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdTenure and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_TENURE SET TENURE = :tenure, INTEREST_RATES = :interestRates, RECOMMENDED = :recommended, INTEREST = :interest, DAYS = :days WHERE FG_TD_TENURE_id = :fgTdTenureId")
    public int update(@BindBean FgTdTenure fgtdtenure);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_TENURE WHERE FG_TD_TENURE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_TENURE")
    public long countAll();

    /**
     * Bulk insert multiple FgTdTenure entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_TENURE (TENURE, INTEREST_RATES, RECOMMENDED, INTEREST, DAYS) VALUES (:tenure, :interestRates, :recommended, :interest, :days)")
    public int[] bulkInsert(@BindBean List<FgTdTenure> fgtdtenures);

    /**
     * Bulk update multiple FgTdTenure entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_TENURE SET TENURE = :tenure, INTEREST_RATES = :interestRates, RECOMMENDED = :recommended, INTEREST = :interest, DAYS = :days WHERE FG_TD_TENURE_id = :fgTdTenureId")
    public int[] bulkUpdate(@BindBean List<FgTdTenure> fgtdtenures);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_TENURE WHERE FG_TD_TENURE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_TENURE WHERE FG_TD_TENURE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgTdTenure records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_TENURE WHERE FG_TD_TENURE_id IN (<ids>)")
    @RegisterBeanMapper(FgTdTenure.class)
    public List<FgTdTenure> findByIds(@BindList("ids") Collection<Integer> ids);
}
