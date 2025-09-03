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
import com.bsit.codegeneration.entity.FgMfaToken;

public interface FgMfaTokenDao {

    /**
     * Inserts a new FgMfaToken and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MFA_TOKEN (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, UUID, ORG_CODE, USER_CODE, EVENT_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_TYPE_REFERENCE, CHANNEL, PRIMARY, SECONDARY, FACTOR_STAGE, FAILURE_REASON, CONTENT, PRIMARY_TRIGGERED_ON, PRIMARY_EXPIRE_ON, SECONDARY_TRIGGERED_ON, SECONDARY_EXPIRE_ON, LOCKED_ON, RELEASE_ON, ATTEMPT_COUNT, IS_LOCKED, AUTHENTICATION_CODE, DELIVERY_CHANNEL) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :uuid, :orgCode, :userCode, :eventTypeCode, :entityTypeCode, :entityTypeReference, :channel, :primary, :secondary, :factorStage, :failureReason, :content, :primaryTriggeredOn, :primaryExpireOn, :secondaryTriggeredOn, :secondaryExpireOn, :lockedOn, :releaseOn, :attemptCount, :isLocked, :authenticationCode, :deliveryChannel)")
    public int insert(@BindBean FgMfaToken fgmfatoken);

    /**
     * Finds a FgMfaToken by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MFA_TOKEN WHERE ID = :id")
    @RegisterBeanMapper(FgMfaToken.class)
    public Optional<FgMfaToken> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MFA_TOKEN")
    @RegisterBeanMapper(FgMfaToken.class)
    public List<FgMfaToken> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MFA_TOKEN ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgMfaToken.class)
    public List<FgMfaToken> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgMfaToken and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MFA_TOKEN SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, UUID = :uuid, ORG_CODE = :orgCode, USER_CODE = :userCode, EVENT_TYPE_CODE = :eventTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_TYPE_REFERENCE = :entityTypeReference, CHANNEL = :channel, PRIMARY = :primary, SECONDARY = :secondary, FACTOR_STAGE = :factorStage, FAILURE_REASON = :failureReason, CONTENT = :content, PRIMARY_TRIGGERED_ON = :primaryTriggeredOn, PRIMARY_EXPIRE_ON = :primaryExpireOn, SECONDARY_TRIGGERED_ON = :secondaryTriggeredOn, SECONDARY_EXPIRE_ON = :secondaryExpireOn, LOCKED_ON = :lockedOn, RELEASE_ON = :releaseOn, ATTEMPT_COUNT = :attemptCount, IS_LOCKED = :isLocked, AUTHENTICATION_CODE = :authenticationCode, DELIVERY_CHANNEL = :deliveryChannel WHERE ID = :id")
    public int update(@BindBean FgMfaToken fgmfatoken);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MFA_TOKEN WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MFA_TOKEN")
    public long countAll();

    /**
     * Bulk insert multiple FgMfaToken entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MFA_TOKEN (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, UUID, ORG_CODE, USER_CODE, EVENT_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_TYPE_REFERENCE, CHANNEL, PRIMARY, SECONDARY, FACTOR_STAGE, FAILURE_REASON, CONTENT, PRIMARY_TRIGGERED_ON, PRIMARY_EXPIRE_ON, SECONDARY_TRIGGERED_ON, SECONDARY_EXPIRE_ON, LOCKED_ON, RELEASE_ON, ATTEMPT_COUNT, IS_LOCKED, AUTHENTICATION_CODE, DELIVERY_CHANNEL) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :uuid, :orgCode, :userCode, :eventTypeCode, :entityTypeCode, :entityTypeReference, :channel, :primary, :secondary, :factorStage, :failureReason, :content, :primaryTriggeredOn, :primaryExpireOn, :secondaryTriggeredOn, :secondaryExpireOn, :lockedOn, :releaseOn, :attemptCount, :isLocked, :authenticationCode, :deliveryChannel)")
    public int[] bulkInsert(@BindBean List<FgMfaToken> fgmfatokens);

    /**
     * Bulk update multiple FgMfaToken entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MFA_TOKEN SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, UUID = :uuid, ORG_CODE = :orgCode, USER_CODE = :userCode, EVENT_TYPE_CODE = :eventTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_TYPE_REFERENCE = :entityTypeReference, CHANNEL = :channel, PRIMARY = :primary, SECONDARY = :secondary, FACTOR_STAGE = :factorStage, FAILURE_REASON = :failureReason, CONTENT = :content, PRIMARY_TRIGGERED_ON = :primaryTriggeredOn, PRIMARY_EXPIRE_ON = :primaryExpireOn, SECONDARY_TRIGGERED_ON = :secondaryTriggeredOn, SECONDARY_EXPIRE_ON = :secondaryExpireOn, LOCKED_ON = :lockedOn, RELEASE_ON = :releaseOn, ATTEMPT_COUNT = :attemptCount, IS_LOCKED = :isLocked, AUTHENTICATION_CODE = :authenticationCode, DELIVERY_CHANNEL = :deliveryChannel WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgMfaToken> fgmfatokens);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MFA_TOKEN WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MFA_TOKEN WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgMfaToken records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MFA_TOKEN WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgMfaToken.class)
    public List<FgMfaToken> findByIds(@BindList("ids") Collection<String> ids);
}
