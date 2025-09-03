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
import com.bsit.codegeneration.entity.FgAppVersion;

public interface FgAppVersionDao {

    /**
     * Inserts a new FgAppVersion and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_APP_VERSION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, TYPE, CATEGORY_CODE, CATEGORY_KEY, CATEGORY_VERSION, ENVIRONMENT, APPLICANT_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :type, :categoryCode, :categoryKey, :categoryVersion, :environment, :applicantParty)")
    public int insert(@BindBean FgAppVersion fgappversion);

    /**
     * Finds a FgAppVersion by its ID.
     */
    @SqlQuery("SELECT * FROM FG_APP_VERSION WHERE ID = :id")
    @RegisterBeanMapper(FgAppVersion.class)
    public Optional<FgAppVersion> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_APP_VERSION")
    @RegisterBeanMapper(FgAppVersion.class)
    public List<FgAppVersion> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_APP_VERSION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAppVersion.class)
    public List<FgAppVersion> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAppVersion and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_APP_VERSION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, TYPE = :type, CATEGORY_CODE = :categoryCode, CATEGORY_KEY = :categoryKey, CATEGORY_VERSION = :categoryVersion, ENVIRONMENT = :environment, APPLICANT_PARTY = :applicantParty WHERE ID = :id")
    public int update(@BindBean FgAppVersion fgappversion);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_APP_VERSION WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_APP_VERSION")
    public long countAll();

    /**
     * Bulk insert multiple FgAppVersion entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_APP_VERSION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, TYPE, CATEGORY_CODE, CATEGORY_KEY, CATEGORY_VERSION, ENVIRONMENT, APPLICANT_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :type, :categoryCode, :categoryKey, :categoryVersion, :environment, :applicantParty)")
    public int[] bulkInsert(@BindBean List<FgAppVersion> fgappversions);

    /**
     * Bulk update multiple FgAppVersion entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_APP_VERSION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, TYPE = :type, CATEGORY_CODE = :categoryCode, CATEGORY_KEY = :categoryKey, CATEGORY_VERSION = :categoryVersion, ENVIRONMENT = :environment, APPLICANT_PARTY = :applicantParty WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgAppVersion> fgappversions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_APP_VERSION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_APP_VERSION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgAppVersion records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_APP_VERSION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgAppVersion.class)
    public List<FgAppVersion> findByIds(@BindList("ids") Collection<String> ids);
}
