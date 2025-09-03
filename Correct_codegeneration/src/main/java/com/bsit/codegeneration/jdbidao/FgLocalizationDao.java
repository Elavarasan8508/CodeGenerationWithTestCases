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
import com.bsit.codegeneration.entity.FgLocalization;

public interface FgLocalizationDao {

    /**
     * Inserts a new FgLocalization and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LOCALIZATION (LOC_TYPE, LOC_KEY, LOCALE, LOC_VALUE, ID) VALUES (:locType, :locKey, :locale, :locValue, :id)")
    public int insert(@BindBean FgLocalization fglocalization);

    /**
     * Finds a FgLocalization by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LOCALIZATION WHERE ID = :id")
    @RegisterBeanMapper(FgLocalization.class)
    public Optional<FgLocalization> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LOCALIZATION")
    @RegisterBeanMapper(FgLocalization.class)
    public List<FgLocalization> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LOCALIZATION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLocalization.class)
    public List<FgLocalization> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLocalization and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LOCALIZATION SET LOC_TYPE = :locType, LOC_KEY = :locKey, LOCALE = :locale, LOC_VALUE = :locValue WHERE ID = :id")
    public int update(@BindBean FgLocalization fglocalization);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LOCALIZATION WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LOCALIZATION")
    public long countAll();

    /**
     * Bulk insert multiple FgLocalization entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LOCALIZATION (LOC_TYPE, LOC_KEY, LOCALE, LOC_VALUE, ID) VALUES (:locType, :locKey, :locale, :locValue, :id)")
    public int[] bulkInsert(@BindBean List<FgLocalization> fglocalizations);

    /**
     * Bulk update multiple FgLocalization entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LOCALIZATION SET LOC_TYPE = :locType, LOC_KEY = :locKey, LOCALE = :locale, LOC_VALUE = :locValue WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgLocalization> fglocalizations);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LOCALIZATION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LOCALIZATION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgLocalization records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LOCALIZATION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgLocalization.class)
    public List<FgLocalization> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
