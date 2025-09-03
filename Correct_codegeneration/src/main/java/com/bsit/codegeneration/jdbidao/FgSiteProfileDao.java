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
import com.bsit.codegeneration.entity.FgSiteProfile;

public interface FgSiteProfileDao {

    /**
     * Inserts a new FgSiteProfile and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SITE_PROFILE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SITE_NAME, ORGANIZATION_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :siteName, :organizationCode)")
    public int insert(@BindBean FgSiteProfile fgsiteprofile);

    /**
     * Finds a FgSiteProfile by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SITE_PROFILE WHERE ID = :id")
    @RegisterBeanMapper(FgSiteProfile.class)
    public Optional<FgSiteProfile> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SITE_PROFILE")
    @RegisterBeanMapper(FgSiteProfile.class)
    public List<FgSiteProfile> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SITE_PROFILE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSiteProfile.class)
    public List<FgSiteProfile> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSiteProfile and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SITE_PROFILE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SITE_NAME = :siteName, ORGANIZATION_CODE = :organizationCode WHERE ID = :id")
    public int update(@BindBean FgSiteProfile fgsiteprofile);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SITE_PROFILE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SITE_PROFILE")
    public long countAll();

    /**
     * Bulk insert multiple FgSiteProfile entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SITE_PROFILE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SITE_NAME, ORGANIZATION_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :siteName, :organizationCode)")
    public int[] bulkInsert(@BindBean List<FgSiteProfile> fgsiteprofiles);

    /**
     * Bulk update multiple FgSiteProfile entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SITE_PROFILE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SITE_NAME = :siteName, ORGANIZATION_CODE = :organizationCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgSiteProfile> fgsiteprofiles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SITE_PROFILE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SITE_PROFILE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgSiteProfile records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SITE_PROFILE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgSiteProfile.class)
    public List<FgSiteProfile> findByIds(@BindList("ids") Collection<String> ids);
}
