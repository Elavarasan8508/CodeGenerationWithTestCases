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
import com.bsit.codegeneration.entity.FgTdConfig;

public interface FgTdConfigDao {

    /**
     * Inserts a new FgTdConfig and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_CONFIG (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, MAKER_ID, CHECKER_ID, CONFIG_CODE, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :makerId, :checkerId, :configCode, :versionId, :isMasterVersion)")
    public int insert(@BindBean FgTdConfig fgtdconfig);

    /**
     * Finds a FgTdConfig by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_CONFIG WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgTdConfig.class)
    public Optional<FgTdConfig> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_CONFIG")
    @RegisterBeanMapper(FgTdConfig.class)
    public List<FgTdConfig> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_CONFIG ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdConfig.class)
    public List<FgTdConfig> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdConfig and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_CONFIG SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, MAKER_ID = :makerId, CHECKER_ID = :checkerId, CONFIG_CODE = :configCode, IS_MASTER_VERSION = :isMasterVersion WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgTdConfig fgtdconfig);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_CONFIG WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_CONFIG")
    public long countAll();

    /**
     * Bulk insert multiple FgTdConfig entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_CONFIG (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, MAKER_ID, CHECKER_ID, CONFIG_CODE, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :makerId, :checkerId, :configCode, :versionId, :isMasterVersion)")
    public int[] bulkInsert(@BindBean List<FgTdConfig> fgtdconfigs);

    /**
     * Bulk update multiple FgTdConfig entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_CONFIG SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, MAKER_ID = :makerId, CHECKER_ID = :checkerId, CONFIG_CODE = :configCode, IS_MASTER_VERSION = :isMasterVersion WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgTdConfig> fgtdconfigs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_CONFIG WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_CONFIG WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTdConfig records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_CONFIG WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgTdConfig.class)
    public List<FgTdConfig> findByIds(@BindList("ids") Collection<String> ids);
}
