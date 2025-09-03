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
import com.bsit.codegeneration.entity.LmsMdmProductGroup;

public interface LmsMdmProductGroupDao {

    /**
     * Inserts a new LmsMdmProductGroup and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LMS_MDM_PRODUCT_GROUP (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, GROUPING_NAME, DESCRIPTION, SOURCE_SYSTEM_PRODUCT_TYPE, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :groupingName, :description, :sourceSystemProductType, :versionId, :isMasterVersion)")
    public int insert(@BindBean LmsMdmProductGroup lmsmdmproductgroup);

    /**
     * Finds a LmsMdmProductGroup by its ID.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_PRODUCT_GROUP WHERE VERSION_ID = :id")
    @RegisterBeanMapper(LmsMdmProductGroup.class)
    public Optional<LmsMdmProductGroup> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_PRODUCT_GROUP")
    @RegisterBeanMapper(LmsMdmProductGroup.class)
    public List<LmsMdmProductGroup> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_PRODUCT_GROUP ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LmsMdmProductGroup.class)
    public List<LmsMdmProductGroup> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LmsMdmProductGroup and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LMS_MDM_PRODUCT_GROUP SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, GROUPING_NAME = :groupingName, DESCRIPTION = :description, SOURCE_SYSTEM_PRODUCT_TYPE = :sourceSystemProductType, IS_MASTER_VERSION = :isMasterVersion WHERE VERSION_ID = :versionId")
    public int update(@BindBean LmsMdmProductGroup lmsmdmproductgroup);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_PRODUCT_GROUP WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LMS_MDM_PRODUCT_GROUP")
    public long countAll();

    /**
     * Bulk insert multiple LmsMdmProductGroup entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LMS_MDM_PRODUCT_GROUP (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, GROUPING_NAME, DESCRIPTION, SOURCE_SYSTEM_PRODUCT_TYPE, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :groupingName, :description, :sourceSystemProductType, :versionId, :isMasterVersion)")
    public int[] bulkInsert(@BindBean List<LmsMdmProductGroup> lmsmdmproductgroups);

    /**
     * Bulk update multiple LmsMdmProductGroup entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LMS_MDM_PRODUCT_GROUP SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, GROUPING_NAME = :groupingName, DESCRIPTION = :description, SOURCE_SYSTEM_PRODUCT_TYPE = :sourceSystemProductType, IS_MASTER_VERSION = :isMasterVersion WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<LmsMdmProductGroup> lmsmdmproductgroups);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_PRODUCT_GROUP WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LMS_MDM_PRODUCT_GROUP WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple LmsMdmProductGroup records by their IDs.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_PRODUCT_GROUP WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(LmsMdmProductGroup.class)
    public List<LmsMdmProductGroup> findByIds(@BindList("ids") Collection<String> ids);
}
