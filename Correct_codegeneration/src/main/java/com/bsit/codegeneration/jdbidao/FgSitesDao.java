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
import com.bsit.codegeneration.entity.FgSites;

public interface FgSitesDao {

    /**
     * Inserts a new FgSites and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SITES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, CODE, DESCRIPTION, IDENTIFICATION, THEME, SITE_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name, :code, :description, :identification, :theme, :siteStatus)")
    public int insert(@BindBean FgSites fgsites);

    /**
     * Finds a FgSites by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SITES WHERE ID = :id")
    @RegisterBeanMapper(FgSites.class)
    public Optional<FgSites> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SITES")
    @RegisterBeanMapper(FgSites.class)
    public List<FgSites> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SITES ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSites.class)
    public List<FgSites> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSites and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SITES SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name, CODE = :code, DESCRIPTION = :description, IDENTIFICATION = :identification, THEME = :theme, SITE_STATUS = :siteStatus WHERE ID = :id")
    public int update(@BindBean FgSites fgsites);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SITES WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SITES")
    public long countAll();

    /**
     * Bulk insert multiple FgSites entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SITES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, CODE, DESCRIPTION, IDENTIFICATION, THEME, SITE_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name, :code, :description, :identification, :theme, :siteStatus)")
    public int[] bulkInsert(@BindBean List<FgSites> fgsitess);

    /**
     * Bulk update multiple FgSites entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SITES SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name, CODE = :code, DESCRIPTION = :description, IDENTIFICATION = :identification, THEME = :theme, SITE_STATUS = :siteStatus WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgSites> fgsitess);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SITES WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SITES WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgSites records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SITES WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgSites.class)
    public List<FgSites> findByIds(@BindList("ids") Collection<String> ids);
}
