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
import com.bsit.codegeneration.entity.LmsMdmConfig;

public interface LmsMdmConfigDao {

    /**
     * Inserts a new LmsMdmConfig and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LMS_MDM_CONFIG (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, ENTITY_TYPE, ROLE_TYPE, NO_OF_DAYS, REJECT_HOUR, REJECT_MINUTE, DESCRIPTION, REJECT_TIME, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :entityType, :roleType, :noOfDays, :rejectHour, :rejectMinute, :description, :rejectTime, :versionId, :isMasterVersion)")
    public int insert(@BindBean LmsMdmConfig lmsmdmconfig);

    /**
     * Finds a LmsMdmConfig by its ID.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_CONFIG WHERE VERSION_ID = :id")
    @RegisterBeanMapper(LmsMdmConfig.class)
    public Optional<LmsMdmConfig> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_CONFIG")
    @RegisterBeanMapper(LmsMdmConfig.class)
    public List<LmsMdmConfig> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_CONFIG ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LmsMdmConfig.class)
    public List<LmsMdmConfig> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LmsMdmConfig and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LMS_MDM_CONFIG SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, ENTITY_TYPE = :entityType, ROLE_TYPE = :roleType, NO_OF_DAYS = :noOfDays, REJECT_HOUR = :rejectHour, REJECT_MINUTE = :rejectMinute, DESCRIPTION = :description, REJECT_TIME = :rejectTime, IS_MASTER_VERSION = :isMasterVersion WHERE VERSION_ID = :versionId")
    public int update(@BindBean LmsMdmConfig lmsmdmconfig);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_CONFIG WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LMS_MDM_CONFIG")
    public long countAll();

    /**
     * Bulk insert multiple LmsMdmConfig entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LMS_MDM_CONFIG (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, ENTITY_TYPE, ROLE_TYPE, NO_OF_DAYS, REJECT_HOUR, REJECT_MINUTE, DESCRIPTION, REJECT_TIME, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :entityType, :roleType, :noOfDays, :rejectHour, :rejectMinute, :description, :rejectTime, :versionId, :isMasterVersion)")
    public int[] bulkInsert(@BindBean List<LmsMdmConfig> lmsmdmconfigs);

    /**
     * Bulk update multiple LmsMdmConfig entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LMS_MDM_CONFIG SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, ENTITY_TYPE = :entityType, ROLE_TYPE = :roleType, NO_OF_DAYS = :noOfDays, REJECT_HOUR = :rejectHour, REJECT_MINUTE = :rejectMinute, DESCRIPTION = :description, REJECT_TIME = :rejectTime, IS_MASTER_VERSION = :isMasterVersion WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<LmsMdmConfig> lmsmdmconfigs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_CONFIG WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LMS_MDM_CONFIG WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple LmsMdmConfig records by their IDs.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_CONFIG WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(LmsMdmConfig.class)
    public List<LmsMdmConfig> findByIds(@BindList("ids") Collection<String> ids);
}
