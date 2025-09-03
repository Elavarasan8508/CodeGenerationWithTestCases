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
import com.bsit.codegeneration.entity.FgTdConfiguration;

public interface FgTdConfigurationDao {

    /**
     * Inserts a new FgTdConfiguration and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_CONFIGURATION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CONFIG_NAME, VERSION_ID, IS_MASTER_VERSION, CONFIG_NAME_DISPLAY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :configName, :versionId, :isMasterVersion, :configNameDisplay)")
    public int insert(@BindBean FgTdConfiguration fgtdconfiguration);

    /**
     * Finds a FgTdConfiguration by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_CONFIGURATION WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgTdConfiguration.class)
    public Optional<FgTdConfiguration> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_CONFIGURATION")
    @RegisterBeanMapper(FgTdConfiguration.class)
    public List<FgTdConfiguration> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_CONFIGURATION ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdConfiguration.class)
    public List<FgTdConfiguration> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdConfiguration and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_CONFIGURATION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CONFIG_NAME = :configName, IS_MASTER_VERSION = :isMasterVersion, CONFIG_NAME_DISPLAY = :configNameDisplay WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgTdConfiguration fgtdconfiguration);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_CONFIGURATION WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_CONFIGURATION")
    public long countAll();

    /**
     * Bulk insert multiple FgTdConfiguration entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_CONFIGURATION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CONFIG_NAME, VERSION_ID, IS_MASTER_VERSION, CONFIG_NAME_DISPLAY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :configName, :versionId, :isMasterVersion, :configNameDisplay)")
    public int[] bulkInsert(@BindBean List<FgTdConfiguration> fgtdconfigurations);

    /**
     * Bulk update multiple FgTdConfiguration entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_CONFIGURATION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CONFIG_NAME = :configName, IS_MASTER_VERSION = :isMasterVersion, CONFIG_NAME_DISPLAY = :configNameDisplay WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgTdConfiguration> fgtdconfigurations);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_CONFIGURATION WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_CONFIGURATION WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTdConfiguration records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_CONFIGURATION WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgTdConfiguration.class)
    public List<FgTdConfiguration> findByIds(@BindList("ids") Collection<String> ids);
}
