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
import com.bsit.codegeneration.entity.FgNavigation;

public interface FgNavigationDao {

    /**
     * Inserts a new FgNavigation and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_NAVIGATION (ID, APPLIED_DATE, TYPE_CODE, SUB_TYPE_CODE, NAVIGATION_CONTENT, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :appliedDate, :typeCode, :subTypeCode, :navigationContent, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int insert(@BindBean FgNavigation fgnavigation);

    /**
     * Finds a FgNavigation by its ID.
     */
    @SqlQuery("SELECT * FROM FG_NAVIGATION WHERE ID = :id")
    @RegisterBeanMapper(FgNavigation.class)
    public Optional<FgNavigation> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_NAVIGATION")
    @RegisterBeanMapper(FgNavigation.class)
    public List<FgNavigation> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_NAVIGATION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgNavigation.class)
    public List<FgNavigation> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgNavigation and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_NAVIGATION SET APPLIED_DATE = :appliedDate, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, NAVIGATION_CONTENT = :navigationContent, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE ID = :id")
    public int update(@BindBean FgNavigation fgnavigation);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_NAVIGATION WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_NAVIGATION")
    public long countAll();

    /**
     * Bulk insert multiple FgNavigation entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_NAVIGATION (ID, APPLIED_DATE, TYPE_CODE, SUB_TYPE_CODE, NAVIGATION_CONTENT, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :appliedDate, :typeCode, :subTypeCode, :navigationContent, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int[] bulkInsert(@BindBean List<FgNavigation> fgnavigations);

    /**
     * Bulk update multiple FgNavigation entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_NAVIGATION SET APPLIED_DATE = :appliedDate, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, NAVIGATION_CONTENT = :navigationContent, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgNavigation> fgnavigations);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_NAVIGATION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_NAVIGATION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgNavigation records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_NAVIGATION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgNavigation.class)
    public List<FgNavigation> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
