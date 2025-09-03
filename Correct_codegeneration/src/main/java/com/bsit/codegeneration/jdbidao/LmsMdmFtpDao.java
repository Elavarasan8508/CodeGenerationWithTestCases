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
import com.bsit.codegeneration.entity.LmsMdmFtp;

public interface LmsMdmFtpDao {

    /**
     * Inserts a new LmsMdmFtp and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LMS_MDM_FTP (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, RATE_OF_INTEREST, UPLOAD_REF_ID, FTP_STATUS_CODE, RULE_TYPE, SEGMENT_CODE, PRODUCT_CODE, SUB_PRODUCT_CODE, EFFECTIVE_START_DATE, EFFECTIVE_END_DATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :tenorStartSlab, :tenorEndSlab, :tenorUomCode, :tenorSlabRuleExpression, :rateOfInterest, :uploadRefId, :ftpStatusCode, :ruleType, :segmentCode, :productCode, :subProductCode, :effectiveStartDate, :effectiveEndDate)")
    public int insert(@BindBean LmsMdmFtp lmsmdmftp);

    /**
     * Finds a LmsMdmFtp by its ID.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_FTP WHERE ID = :id")
    @RegisterBeanMapper(LmsMdmFtp.class)
    public Optional<LmsMdmFtp> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_FTP")
    @RegisterBeanMapper(LmsMdmFtp.class)
    public List<LmsMdmFtp> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_FTP ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LmsMdmFtp.class)
    public List<LmsMdmFtp> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LmsMdmFtp and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LMS_MDM_FTP SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TENOR_START_SLAB = :tenorStartSlab, TENOR_END_SLAB = :tenorEndSlab, TENOR_UOM_CODE = :tenorUomCode, TENOR_SLAB_RULE_EXPRESSION = :tenorSlabRuleExpression, RATE_OF_INTEREST = :rateOfInterest, UPLOAD_REF_ID = :uploadRefId, FTP_STATUS_CODE = :ftpStatusCode, RULE_TYPE = :ruleType, SEGMENT_CODE = :segmentCode, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode, EFFECTIVE_START_DATE = :effectiveStartDate, EFFECTIVE_END_DATE = :effectiveEndDate WHERE ID = :id")
    public int update(@BindBean LmsMdmFtp lmsmdmftp);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_FTP WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LMS_MDM_FTP")
    public long countAll();

    /**
     * Bulk insert multiple LmsMdmFtp entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LMS_MDM_FTP (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TENOR_START_SLAB, TENOR_END_SLAB, TENOR_UOM_CODE, TENOR_SLAB_RULE_EXPRESSION, RATE_OF_INTEREST, UPLOAD_REF_ID, FTP_STATUS_CODE, RULE_TYPE, SEGMENT_CODE, PRODUCT_CODE, SUB_PRODUCT_CODE, EFFECTIVE_START_DATE, EFFECTIVE_END_DATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :tenorStartSlab, :tenorEndSlab, :tenorUomCode, :tenorSlabRuleExpression, :rateOfInterest, :uploadRefId, :ftpStatusCode, :ruleType, :segmentCode, :productCode, :subProductCode, :effectiveStartDate, :effectiveEndDate)")
    public int[] bulkInsert(@BindBean List<LmsMdmFtp> lmsmdmftps);

    /**
     * Bulk update multiple LmsMdmFtp entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LMS_MDM_FTP SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TENOR_START_SLAB = :tenorStartSlab, TENOR_END_SLAB = :tenorEndSlab, TENOR_UOM_CODE = :tenorUomCode, TENOR_SLAB_RULE_EXPRESSION = :tenorSlabRuleExpression, RATE_OF_INTEREST = :rateOfInterest, UPLOAD_REF_ID = :uploadRefId, FTP_STATUS_CODE = :ftpStatusCode, RULE_TYPE = :ruleType, SEGMENT_CODE = :segmentCode, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode, EFFECTIVE_START_DATE = :effectiveStartDate, EFFECTIVE_END_DATE = :effectiveEndDate WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<LmsMdmFtp> lmsmdmftps);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_FTP WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LMS_MDM_FTP WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple LmsMdmFtp records by their IDs.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_FTP WHERE ID IN (<ids>)")
    @RegisterBeanMapper(LmsMdmFtp.class)
    public List<LmsMdmFtp> findByIds(@BindList("ids") Collection<String> ids);
}
