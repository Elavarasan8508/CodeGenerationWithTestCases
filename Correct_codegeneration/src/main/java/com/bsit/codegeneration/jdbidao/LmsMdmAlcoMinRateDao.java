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
import com.bsit.codegeneration.entity.LmsMdmAlcoMinRate;

public interface LmsMdmAlcoMinRateDao {

    /**
     * Inserts a new LmsMdmAlcoMinRate and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LMS_MDM_ALCO_MIN_RATE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, BENCHMARK_CODE, RATE_OF_INTEREST, ALCO_RATE_STATUS_CODE, RATE_TYPE, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE, RULE_TYPE_CODE, RESET_PERIOD_UOM_CODE, RESET_VALUE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :tenorStartSlab, :tenorEndSlab, :tenorUomCode, :tenorSlabRuleExpression, :benchmarkCode, :rateOfInterest, :alcoRateStatusCode, :rateType, :productCode, :subProductCode, :segmentCode, :ruleTypeCode, :resetPeriodUomCode, :resetValue)")
    public int insert(@BindBean LmsMdmAlcoMinRate lmsmdmalcominrate);

    /**
     * Finds a LmsMdmAlcoMinRate by its ID.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_ALCO_MIN_RATE WHERE ID = :id")
    @RegisterBeanMapper(LmsMdmAlcoMinRate.class)
    public Optional<LmsMdmAlcoMinRate> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_ALCO_MIN_RATE")
    @RegisterBeanMapper(LmsMdmAlcoMinRate.class)
    public List<LmsMdmAlcoMinRate> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_ALCO_MIN_RATE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LmsMdmAlcoMinRate.class)
    public List<LmsMdmAlcoMinRate> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LmsMdmAlcoMinRate and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LMS_MDM_ALCO_MIN_RATE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TENOR_START_SLAB = :tenorStartSlab, TENOR_END_SLAB = :tenorEndSlab, TENOR_UOM_CODE = :tenorUomCode, TENOR_SLAB_RULE_EXPRESSION = :tenorSlabRuleExpression, BENCHMARK_CODE = :benchmarkCode, RATE_OF_INTEREST = :rateOfInterest, ALCO_RATE_STATUS_CODE = :alcoRateStatusCode, RATE_TYPE = :rateType, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode, SEGMENT_CODE = :segmentCode, RULE_TYPE_CODE = :ruleTypeCode, RESET_PERIOD_UOM_CODE = :resetPeriodUomCode, RESET_VALUE = :resetValue WHERE ID = :id")
    public int update(@BindBean LmsMdmAlcoMinRate lmsmdmalcominrate);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_ALCO_MIN_RATE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LMS_MDM_ALCO_MIN_RATE")
    public long countAll();

    /**
     * Bulk insert multiple LmsMdmAlcoMinRate entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LMS_MDM_ALCO_MIN_RATE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, BENCHMARK_CODE, RATE_OF_INTEREST, ALCO_RATE_STATUS_CODE, RATE_TYPE, PRODUCT_CODE, SUB_PRODUCT_CODE, SEGMENT_CODE, RULE_TYPE_CODE, RESET_PERIOD_UOM_CODE, RESET_VALUE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :tenorStartSlab, :tenorEndSlab, :tenorUomCode, :tenorSlabRuleExpression, :benchmarkCode, :rateOfInterest, :alcoRateStatusCode, :rateType, :productCode, :subProductCode, :segmentCode, :ruleTypeCode, :resetPeriodUomCode, :resetValue)")
    public int[] bulkInsert(@BindBean List<LmsMdmAlcoMinRate> lmsmdmalcominrates);

    /**
     * Bulk update multiple LmsMdmAlcoMinRate entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LMS_MDM_ALCO_MIN_RATE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TENOR_START_SLAB = :tenorStartSlab, TENOR_END_SLAB = :tenorEndSlab, TENOR_UOM_CODE = :tenorUomCode, TENOR_SLAB_RULE_EXPRESSION = :tenorSlabRuleExpression, BENCHMARK_CODE = :benchmarkCode, RATE_OF_INTEREST = :rateOfInterest, ALCO_RATE_STATUS_CODE = :alcoRateStatusCode, RATE_TYPE = :rateType, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode, SEGMENT_CODE = :segmentCode, RULE_TYPE_CODE = :ruleTypeCode, RESET_PERIOD_UOM_CODE = :resetPeriodUomCode, RESET_VALUE = :resetValue WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<LmsMdmAlcoMinRate> lmsmdmalcominrates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_ALCO_MIN_RATE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LMS_MDM_ALCO_MIN_RATE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple LmsMdmAlcoMinRate records by their IDs.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_ALCO_MIN_RATE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(LmsMdmAlcoMinRate.class)
    public List<LmsMdmAlcoMinRate> findByIds(@BindList("ids") Collection<String> ids);
}
