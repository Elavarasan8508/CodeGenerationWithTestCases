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
import com.bsit.codegeneration.entity.CoreMdmProductScheme;

public interface CoreMdmProductSchemeDao {

    /**
     * Inserts a new CoreMdmProductScheme and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO CORE_MDM_PRODUCT_SCHEME (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_TYPE, SCHEME_NAME, SCHEME_CODE, SCHEME_DESCRIPTION, EFFECTIVE_DATE, EXPIRY_DATE, UPLOAD_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :schemeType, :schemeName, :schemeCode, :schemeDescription, :effectiveDate, :expiryDate, :uploadRefId)")
    public int insert(@BindBean CoreMdmProductScheme coremdmproductscheme);

    /**
     * Finds a CoreMdmProductScheme by its ID.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_PRODUCT_SCHEME WHERE CORE_MDM_PRODUCT_SCHEME_id = :id")
    @RegisterBeanMapper(CoreMdmProductScheme.class)
    public Optional<CoreMdmProductScheme> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_PRODUCT_SCHEME")
    @RegisterBeanMapper(CoreMdmProductScheme.class)
    public List<CoreMdmProductScheme> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_PRODUCT_SCHEME ORDER BY CORE_MDM_PRODUCT_SCHEME_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(CoreMdmProductScheme.class)
    public List<CoreMdmProductScheme> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a CoreMdmProductScheme and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE CORE_MDM_PRODUCT_SCHEME SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, SCHEME_TYPE = :schemeType, SCHEME_NAME = :schemeName, SCHEME_CODE = :schemeCode, SCHEME_DESCRIPTION = :schemeDescription, EFFECTIVE_DATE = :effectiveDate, EXPIRY_DATE = :expiryDate, UPLOAD_REF_ID = :uploadRefId WHERE CORE_MDM_PRODUCT_SCHEME_id = :coreMdmProductSchemeId")
    public int update(@BindBean CoreMdmProductScheme coremdmproductscheme);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM CORE_MDM_PRODUCT_SCHEME WHERE CORE_MDM_PRODUCT_SCHEME_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM CORE_MDM_PRODUCT_SCHEME")
    public long countAll();

    /**
     * Bulk insert multiple CoreMdmProductScheme entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO CORE_MDM_PRODUCT_SCHEME (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_TYPE, SCHEME_NAME, SCHEME_CODE, SCHEME_DESCRIPTION, EFFECTIVE_DATE, EXPIRY_DATE, UPLOAD_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :schemeType, :schemeName, :schemeCode, :schemeDescription, :effectiveDate, :expiryDate, :uploadRefId)")
    public int[] bulkInsert(@BindBean List<CoreMdmProductScheme> coremdmproductschemes);

    /**
     * Bulk update multiple CoreMdmProductScheme entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE CORE_MDM_PRODUCT_SCHEME SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, SCHEME_TYPE = :schemeType, SCHEME_NAME = :schemeName, SCHEME_CODE = :schemeCode, SCHEME_DESCRIPTION = :schemeDescription, EFFECTIVE_DATE = :effectiveDate, EXPIRY_DATE = :expiryDate, UPLOAD_REF_ID = :uploadRefId WHERE CORE_MDM_PRODUCT_SCHEME_id = :coreMdmProductSchemeId")
    public int[] bulkUpdate(@BindBean List<CoreMdmProductScheme> coremdmproductschemes);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM CORE_MDM_PRODUCT_SCHEME WHERE CORE_MDM_PRODUCT_SCHEME_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM CORE_MDM_PRODUCT_SCHEME WHERE CORE_MDM_PRODUCT_SCHEME_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple CoreMdmProductScheme records by their IDs.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_PRODUCT_SCHEME WHERE CORE_MDM_PRODUCT_SCHEME_id IN (<ids>)")
    @RegisterBeanMapper(CoreMdmProductScheme.class)
    public List<CoreMdmProductScheme> findByIds(@BindList("ids") Collection<Integer> ids);
}
