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
import com.bsit.codegeneration.entity.LmsMdmMinSpread;

public interface LmsMdmMinSpreadDao {

    /**
     * Inserts a new LmsMdmMinSpread and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LMS_MDM_MIN_SPREAD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, SEGMENT_CODE, INTERNAL_RATING_CODE, EXTERNAL_RATING_CODE, SHORT_TERM_SPREAD_PERCENT, LONG_TERM_SPREAD_PERCENT, MIN_SPREAD_STATUS_CODE, PRODUCT_CODE, SUB_PRODUCT_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :segmentCode, :internalRatingCode, :externalRatingCode, :shortTermSpreadPercent, :longTermSpreadPercent, :minSpreadStatusCode, :productCode, :subProductCode)")
    public int insert(@BindBean LmsMdmMinSpread lmsmdmminspread);

    /**
     * Finds a LmsMdmMinSpread by its ID.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_MIN_SPREAD WHERE ID = :id")
    @RegisterBeanMapper(LmsMdmMinSpread.class)
    public Optional<LmsMdmMinSpread> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_MIN_SPREAD")
    @RegisterBeanMapper(LmsMdmMinSpread.class)
    public List<LmsMdmMinSpread> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_MIN_SPREAD ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LmsMdmMinSpread.class)
    public List<LmsMdmMinSpread> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LmsMdmMinSpread and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LMS_MDM_MIN_SPREAD SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, SEGMENT_CODE = :segmentCode, INTERNAL_RATING_CODE = :internalRatingCode, EXTERNAL_RATING_CODE = :externalRatingCode, SHORT_TERM_SPREAD_PERCENT = :shortTermSpreadPercent, LONG_TERM_SPREAD_PERCENT = :longTermSpreadPercent, MIN_SPREAD_STATUS_CODE = :minSpreadStatusCode, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode WHERE ID = :id")
    public int update(@BindBean LmsMdmMinSpread lmsmdmminspread);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_MIN_SPREAD WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LMS_MDM_MIN_SPREAD")
    public long countAll();

    /**
     * Bulk insert multiple LmsMdmMinSpread entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LMS_MDM_MIN_SPREAD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, SEGMENT_CODE, INTERNAL_RATING_CODE, EXTERNAL_RATING_CODE, SHORT_TERM_SPREAD_PERCENT, LONG_TERM_SPREAD_PERCENT, MIN_SPREAD_STATUS_CODE, PRODUCT_CODE, SUB_PRODUCT_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :segmentCode, :internalRatingCode, :externalRatingCode, :shortTermSpreadPercent, :longTermSpreadPercent, :minSpreadStatusCode, :productCode, :subProductCode)")
    public int[] bulkInsert(@BindBean List<LmsMdmMinSpread> lmsmdmminspreads);

    /**
     * Bulk update multiple LmsMdmMinSpread entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LMS_MDM_MIN_SPREAD SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, SEGMENT_CODE = :segmentCode, INTERNAL_RATING_CODE = :internalRatingCode, EXTERNAL_RATING_CODE = :externalRatingCode, SHORT_TERM_SPREAD_PERCENT = :shortTermSpreadPercent, LONG_TERM_SPREAD_PERCENT = :longTermSpreadPercent, MIN_SPREAD_STATUS_CODE = :minSpreadStatusCode, PRODUCT_CODE = :productCode, SUB_PRODUCT_CODE = :subProductCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<LmsMdmMinSpread> lmsmdmminspreads);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LMS_MDM_MIN_SPREAD WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LMS_MDM_MIN_SPREAD WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple LmsMdmMinSpread records by their IDs.
     */
    @SqlQuery("SELECT * FROM LMS_MDM_MIN_SPREAD WHERE ID IN (<ids>)")
    @RegisterBeanMapper(LmsMdmMinSpread.class)
    public List<LmsMdmMinSpread> findByIds(@BindList("ids") Collection<String> ids);
}
