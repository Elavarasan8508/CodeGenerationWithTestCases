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
import com.bsit.codegeneration.entity.FgLmsDelinquencyScheme;

public interface FgLmsDelinquencySchemeDao {

    /**
     * Inserts a new FgLmsDelinquencyScheme and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LMS_DELINQUENCY_SCHEME (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, DELINQUENCY_SCHEME_CODE, DELINQUENCY_NAME, ASSET_CLASSIFICATION, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :delinquencySchemeCode, :delinquencyName, :assetClassification, :versionId, :isMasterVersion)")
    public int insert(@BindBean FgLmsDelinquencyScheme fglmsdelinquencyscheme);

    /**
     * Finds a FgLmsDelinquencyScheme by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LMS_DELINQUENCY_SCHEME WHERE FG_LMS_DELINQUENCY_SCHEME_id = :id")
    @RegisterBeanMapper(FgLmsDelinquencyScheme.class)
    public Optional<FgLmsDelinquencyScheme> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LMS_DELINQUENCY_SCHEME")
    @RegisterBeanMapper(FgLmsDelinquencyScheme.class)
    public List<FgLmsDelinquencyScheme> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LMS_DELINQUENCY_SCHEME ORDER BY FG_LMS_DELINQUENCY_SCHEME_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLmsDelinquencyScheme.class)
    public List<FgLmsDelinquencyScheme> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLmsDelinquencyScheme and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LMS_DELINQUENCY_SCHEME SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, DELINQUENCY_SCHEME_CODE = :delinquencySchemeCode, DELINQUENCY_NAME = :delinquencyName, ASSET_CLASSIFICATION = :assetClassification, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion WHERE FG_LMS_DELINQUENCY_SCHEME_id = :fgLmsDelinquencySchemeId")
    public int update(@BindBean FgLmsDelinquencyScheme fglmsdelinquencyscheme);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LMS_DELINQUENCY_SCHEME WHERE FG_LMS_DELINQUENCY_SCHEME_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LMS_DELINQUENCY_SCHEME")
    public long countAll();

    /**
     * Bulk insert multiple FgLmsDelinquencyScheme entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LMS_DELINQUENCY_SCHEME (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, DELINQUENCY_SCHEME_CODE, DELINQUENCY_NAME, ASSET_CLASSIFICATION, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :delinquencySchemeCode, :delinquencyName, :assetClassification, :versionId, :isMasterVersion)")
    public int[] bulkInsert(@BindBean List<FgLmsDelinquencyScheme> fglmsdelinquencyschemes);

    /**
     * Bulk update multiple FgLmsDelinquencyScheme entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LMS_DELINQUENCY_SCHEME SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, DELINQUENCY_SCHEME_CODE = :delinquencySchemeCode, DELINQUENCY_NAME = :delinquencyName, ASSET_CLASSIFICATION = :assetClassification, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion WHERE FG_LMS_DELINQUENCY_SCHEME_id = :fgLmsDelinquencySchemeId")
    public int[] bulkUpdate(@BindBean List<FgLmsDelinquencyScheme> fglmsdelinquencyschemes);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LMS_DELINQUENCY_SCHEME WHERE FG_LMS_DELINQUENCY_SCHEME_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LMS_DELINQUENCY_SCHEME WHERE FG_LMS_DELINQUENCY_SCHEME_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgLmsDelinquencyScheme records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LMS_DELINQUENCY_SCHEME WHERE FG_LMS_DELINQUENCY_SCHEME_id IN (<ids>)")
    @RegisterBeanMapper(FgLmsDelinquencyScheme.class)
    public List<FgLmsDelinquencyScheme> findByIds(@BindList("ids") Collection<Integer> ids);
}
