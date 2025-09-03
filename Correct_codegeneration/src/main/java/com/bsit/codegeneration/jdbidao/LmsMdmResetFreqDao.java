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
import com.bsit.codegeneration.entity.LmsMdmResetFreq;

public interface LmsMdmResetFreqDao {

    /**
     * Inserts a new LmsMdmResetFreq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LMS_MDM_RESET_FREQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, MIN_TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, RESET_VALUE, RESET_PERIOD_UOM_CODE, RESET_DESCRIPTION, UPLOAD_REF_ID, RESET_STATUS_CODE, RULE_TYPE, SEGMENT_CODE, PRODUCT_CODE, SUB_PRODUCT_CODE, MAX_TENOR_UOM_CODE, SEGMENT_TEAMS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :tenorStartSlab, :tenorEndSlab, :minTenorUomCode, :tenorSlabRuleExpression, :resetValue, :resetPeriodUomCode, :resetDescription, :uploadRefId, :resetStatusCode, :ruleType, :segmentCode, :productCode, :subProductCode, :maxTenorUomCode, :segmentTeams)")
    public int insert(@BindBean LmsMdmResetFreq lmsmdmresetfreq);

    /**
     * Finds a LmsMdmResetFreq by its ID.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_RESET_FREQ WHERE ID = :id")
    @RegisterBeanMapper(LmsMdmResetFreq.class)
    public Optional<LmsMdmResetFreq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_RESET_FREQ")
    @RegisterBeanMapper(LmsMdmResetFreq.class)
    public List<LmsMdmResetFreq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_RESET_FREQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LmsMdmResetFreq.class)
    public List<LmsMdmResetFreq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LmsMdmResetFreq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LMS_MDM_RESET_FREQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TENOR_START_SLAB = :tenorStartSlab, TENOR_END_SLAB = :tenorEndSlab, MIN_TENOR_UOM_CODE = :minTenorUomCode, TENOR_SLAB_RULE_EXPRESSION = :tenorSlabRuleExpression, RESET_VALUE = :resetValue, RESET_PERIOD_UOM_CODE = :resetPeriodUomCode, RESET_DESCRIPTION = :resetDescription, UPLOAD_REF_ID = :uploadRefId, RESET_STATUS_CODE = :resetStatusCode, RULE_TYPE = :ruleType, SEGMENT_CODE = :segmentCode, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode, MAX_TENOR_UOM_CODE = :maxTenorUomCode, SEGMENT_TEAMS = :segmentTeams WHERE ID = :id")
    public int update(@BindBean LmsMdmResetFreq lmsmdmresetfreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_RESET_FREQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LMS_MDM_RESET_FREQ")
    public long countAll();

    /**
     * Bulk insert multiple LmsMdmResetFreq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LMS_MDM_RESET_FREQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, MIN_TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, RESET_VALUE, RESET_PERIOD_UOM_CODE, RESET_DESCRIPTION, UPLOAD_REF_ID, RESET_STATUS_CODE, RULE_TYPE, SEGMENT_CODE, PRODUCT_CODE, SUB_PRODUCT_CODE, MAX_TENOR_UOM_CODE, SEGMENT_TEAMS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :tenorStartSlab, :tenorEndSlab, :minTenorUomCode, :tenorSlabRuleExpression, :resetValue, :resetPeriodUomCode, :resetDescription, :uploadRefId, :resetStatusCode, :ruleType, :segmentCode, :productCode, :subProductCode, :maxTenorUomCode, :segmentTeams)")
    public int[] bulkInsert(@BindBean List<LmsMdmResetFreq> lmsmdmresetfreqs);

    /**
     * Bulk update multiple LmsMdmResetFreq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LMS_MDM_RESET_FREQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TENOR_START_SLAB = :tenorStartSlab, TENOR_END_SLAB = :tenorEndSlab, MIN_TENOR_UOM_CODE = :minTenorUomCode, TENOR_SLAB_RULE_EXPRESSION = :tenorSlabRuleExpression, RESET_VALUE = :resetValue, RESET_PERIOD_UOM_CODE = :resetPeriodUomCode, RESET_DESCRIPTION = :resetDescription, UPLOAD_REF_ID = :uploadRefId, RESET_STATUS_CODE = :resetStatusCode, RULE_TYPE = :ruleType, SEGMENT_CODE = :segmentCode, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode, MAX_TENOR_UOM_CODE = :maxTenorUomCode, SEGMENT_TEAMS = :segmentTeams WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<LmsMdmResetFreq> lmsmdmresetfreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_RESET_FREQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LMS_MDM_RESET_FREQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple LmsMdmResetFreq records by their IDs.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_RESET_FREQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(LmsMdmResetFreq.class)
    public List<LmsMdmResetFreq> findByIds(@BindList("ids") Collection<String> ids);
}
