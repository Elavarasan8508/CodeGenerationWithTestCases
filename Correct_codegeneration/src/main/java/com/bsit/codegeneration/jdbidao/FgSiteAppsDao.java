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
import com.bsit.codegeneration.entity.FgSiteApps;

public interface FgSiteAppsDao {

    /**
     * Inserts a new FgSiteApps and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SITE_APPS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, APPLICATION_ID, SITE_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :applicationId, :siteId)")
    public int insert(@BindBean FgSiteApps fgsiteapps);

    /**
     * Finds a FgSiteApps by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SITE_APPS WHERE ID = :id")
    @RegisterBeanMapper(FgSiteApps.class)
    public Optional<FgSiteApps> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SITE_APPS")
    @RegisterBeanMapper(FgSiteApps.class)
    public List<FgSiteApps> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SITE_APPS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSiteApps.class)
    public List<FgSiteApps> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSiteApps and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SITE_APPS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, APPLICATION_ID = :applicationId, SITE_ID = :siteId WHERE ID = :id")
    public int update(@BindBean FgSiteApps fgsiteapps);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SITE_APPS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SITE_APPS")
    public long countAll();

    /**
     * Bulk insert multiple FgSiteApps entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SITE_APPS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, APPLICATION_ID, SITE_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :applicationId, :siteId)")
    public int[] bulkInsert(@BindBean List<FgSiteApps> fgsiteappss);

    /**
     * Bulk update multiple FgSiteApps entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SITE_APPS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, APPLICATION_ID = :applicationId, SITE_ID = :siteId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgSiteApps> fgsiteappss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SITE_APPS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SITE_APPS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgSiteApps records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SITE_APPS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgSiteApps.class)
    public List<FgSiteApps> findByIds(@BindList("ids") Collection<String> ids);
}
