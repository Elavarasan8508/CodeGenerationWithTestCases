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
import com.bsit.codegeneration.entity.FgEventNotification;

public interface FgEventNotificationDao {

    /**
     * Inserts a new FgEventNotification and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_EVENT_NOTIFICATION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, EVENT_TYPE, EVENT_STATUS, CHANNEL, NOTIFICATION_PURPOSE, STAGES, EVENT_TEMPLATE_ID, RECIPIENT_MOBILE_NUMBER, RECIPIENT_EMAIL_ADDRESS, SENDERS_EMAIL_ADDRESS, SUBJECT, CONTENT, ATTACHMENTS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :entityRefId, :entityVersionId, :entityTypeCode, :entitySubTypeCode, :eventType, :eventStatus, :channel, :notificationPurpose, :stages, :eventTemplateId, :recipientMobileNumber, :recipientEmailAddress, :sendersEmailAddress, :subject, :content, :attachments)")
    public int insert(@BindBean FgEventNotification fgeventnotification);

    /**
     * Finds a FgEventNotification by its ID.
     */
    @SqlQuery("SELECT * FROM FG_EVENT_NOTIFICATION WHERE ID = :id")
    @RegisterBeanMapper(FgEventNotification.class)
    public Optional<FgEventNotification> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_EVENT_NOTIFICATION")
    @RegisterBeanMapper(FgEventNotification.class)
    public List<FgEventNotification> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_EVENT_NOTIFICATION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgEventNotification.class)
    public List<FgEventNotification> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgEventNotification and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_EVENT_NOTIFICATION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_ID = :entityVersionId, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, EVENT_TYPE = :eventType, EVENT_STATUS = :eventStatus, CHANNEL = :channel, NOTIFICATION_PURPOSE = :notificationPurpose, STAGES = :stages, EVENT_TEMPLATE_ID = :eventTemplateId, RECIPIENT_MOBILE_NUMBER = :recipientMobileNumber, RECIPIENT_EMAIL_ADDRESS = :recipientEmailAddress, SENDERS_EMAIL_ADDRESS = :sendersEmailAddress, SUBJECT = :subject, CONTENT = :content, ATTACHMENTS = :attachments WHERE ID = :id")
    public int update(@BindBean FgEventNotification fgeventnotification);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EVENT_NOTIFICATION WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_EVENT_NOTIFICATION")
    public long countAll();

    /**
     * Bulk insert multiple FgEventNotification entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_EVENT_NOTIFICATION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, EVENT_TYPE, EVENT_STATUS, CHANNEL, NOTIFICATION_PURPOSE, STAGES, EVENT_TEMPLATE_ID, RECIPIENT_MOBILE_NUMBER, RECIPIENT_EMAIL_ADDRESS, SENDERS_EMAIL_ADDRESS, SUBJECT, CONTENT, ATTACHMENTS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :entityRefId, :entityVersionId, :entityTypeCode, :entitySubTypeCode, :eventType, :eventStatus, :channel, :notificationPurpose, :stages, :eventTemplateId, :recipientMobileNumber, :recipientEmailAddress, :sendersEmailAddress, :subject, :content, :attachments)")
    public int[] bulkInsert(@BindBean List<FgEventNotification> fgeventnotifications);

    /**
     * Bulk update multiple FgEventNotification entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_EVENT_NOTIFICATION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_ID = :entityVersionId, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, EVENT_TYPE = :eventType, EVENT_STATUS = :eventStatus, CHANNEL = :channel, NOTIFICATION_PURPOSE = :notificationPurpose, STAGES = :stages, EVENT_TEMPLATE_ID = :eventTemplateId, RECIPIENT_MOBILE_NUMBER = :recipientMobileNumber, RECIPIENT_EMAIL_ADDRESS = :recipientEmailAddress, SENDERS_EMAIL_ADDRESS = :sendersEmailAddress, SUBJECT = :subject, CONTENT = :content, ATTACHMENTS = :attachments WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgEventNotification> fgeventnotifications);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_EVENT_NOTIFICATION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_EVENT_NOTIFICATION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgEventNotification records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_EVENT_NOTIFICATION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgEventNotification.class)
    public List<FgEventNotification> findByIds(@BindList("ids") Collection<String> ids);
}
