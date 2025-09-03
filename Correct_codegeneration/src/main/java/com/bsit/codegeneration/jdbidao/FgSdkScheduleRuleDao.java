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
import com.bsit.codegeneration.entity.FgSdkScheduleRule;

public interface FgSdkScheduleRuleDao {

    /**
     * Inserts a new FgSdkScheduleRule and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SDK_SCHEDULE_RULE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEDULE_TYPE, SUBSCRIPTION_NAME, OWNER_ORG_TYPE_CODE, OWNER_ORG_CODE, SUBSCRIBER_ORG_TYPE_CODE, SUBSCRIBER_ORG_CODE, CRON_EXPRESSION, SCHEDULE_CHANNEL_CODE, ALERT_TEMPLATE_ID, EXTERNAL_EMAIL, CHANNEL_EMAIL_TITLE, CHANNEL_EMAIL_CONTENT, SCHEDULE_START_DATE, SCHEDULE_END_DATE, H2H_DATASOURCE_ID, H2H_DATASET_ID, ENTITY_SUB_TYPE_CODE, SOURCE_REF_ID, VERSION_ID, IS_MASTER_VERSION, CRON_OBJ) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :scheduleType, :subscriptionName, :ownerOrgTypeCode, :ownerOrgCode, :subscriberOrgTypeCode, :subscriberOrgCode, :cronExpression, :scheduleChannelCode, :alertTemplateId, :externalEmail, :channelEmailTitle, :channelEmailContent, :scheduleStartDate, :scheduleEndDate, :h2hDatasourceId, :h2hDatasetId, :entitySubTypeCode, :sourceRefId, :versionId, :isMasterVersion, :cronObj)")
    public int insert(@BindBean FgSdkScheduleRule fgsdkschedulerule);

    /**
     * Finds a FgSdkScheduleRule by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SDK_SCHEDULE_RULE WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgSdkScheduleRule.class)
    public Optional<FgSdkScheduleRule> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SDK_SCHEDULE_RULE")
    @RegisterBeanMapper(FgSdkScheduleRule.class)
    public List<FgSdkScheduleRule> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SDK_SCHEDULE_RULE ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSdkScheduleRule.class)
    public List<FgSdkScheduleRule> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSdkScheduleRule and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SDK_SCHEDULE_RULE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, SCHEDULE_TYPE = :scheduleType, SUBSCRIPTION_NAME = :subscriptionName, OWNER_ORG_TYPE_CODE = :ownerOrgTypeCode, OWNER_ORG_CODE = :ownerOrgCode, SUBSCRIBER_ORG_TYPE_CODE = :subscriberOrgTypeCode, SUBSCRIBER_ORG_CODE = :subscriberOrgCode, CRON_EXPRESSION = :cronExpression, SCHEDULE_CHANNEL_CODE = :scheduleChannelCode, ALERT_TEMPLATE_ID = :alertTemplateId, EXTERNAL_EMAIL = :externalEmail, CHANNEL_EMAIL_TITLE = :channelEmailTitle, CHANNEL_EMAIL_CONTENT = :channelEmailContent, SCHEDULE_START_DATE = :scheduleStartDate, SCHEDULE_END_DATE = :scheduleEndDate, H2H_DATASOURCE_ID = :h2hDatasourceId, H2H_DATASET_ID = :h2hDatasetId, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, SOURCE_REF_ID = :sourceRefId, IS_MASTER_VERSION = :isMasterVersion, CRON_OBJ = :cronObj WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgSdkScheduleRule fgsdkschedulerule);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_SCHEDULE_RULE WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SDK_SCHEDULE_RULE")
    public long countAll();

    /**
     * Bulk insert multiple FgSdkScheduleRule entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SDK_SCHEDULE_RULE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEDULE_TYPE, SUBSCRIPTION_NAME, OWNER_ORG_TYPE_CODE, OWNER_ORG_CODE, SUBSCRIBER_ORG_TYPE_CODE, SUBSCRIBER_ORG_CODE, CRON_EXPRESSION, SCHEDULE_CHANNEL_CODE, ALERT_TEMPLATE_ID, EXTERNAL_EMAIL, CHANNEL_EMAIL_TITLE, CHANNEL_EMAIL_CONTENT, SCHEDULE_START_DATE, SCHEDULE_END_DATE, H2H_DATASOURCE_ID, H2H_DATASET_ID, ENTITY_SUB_TYPE_CODE, SOURCE_REF_ID, VERSION_ID, IS_MASTER_VERSION, CRON_OBJ) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :scheduleType, :subscriptionName, :ownerOrgTypeCode, :ownerOrgCode, :subscriberOrgTypeCode, :subscriberOrgCode, :cronExpression, :scheduleChannelCode, :alertTemplateId, :externalEmail, :channelEmailTitle, :channelEmailContent, :scheduleStartDate, :scheduleEndDate, :h2hDatasourceId, :h2hDatasetId, :entitySubTypeCode, :sourceRefId, :versionId, :isMasterVersion, :cronObj)")
    public int[] bulkInsert(@BindBean List<FgSdkScheduleRule> fgsdkschedulerules);

    /**
     * Bulk update multiple FgSdkScheduleRule entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SDK_SCHEDULE_RULE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, SCHEDULE_TYPE = :scheduleType, SUBSCRIPTION_NAME = :subscriptionName, OWNER_ORG_TYPE_CODE = :ownerOrgTypeCode, OWNER_ORG_CODE = :ownerOrgCode, SUBSCRIBER_ORG_TYPE_CODE = :subscriberOrgTypeCode, SUBSCRIBER_ORG_CODE = :subscriberOrgCode, CRON_EXPRESSION = :cronExpression, SCHEDULE_CHANNEL_CODE = :scheduleChannelCode, ALERT_TEMPLATE_ID = :alertTemplateId, EXTERNAL_EMAIL = :externalEmail, CHANNEL_EMAIL_TITLE = :channelEmailTitle, CHANNEL_EMAIL_CONTENT = :channelEmailContent, SCHEDULE_START_DATE = :scheduleStartDate, SCHEDULE_END_DATE = :scheduleEndDate, H2H_DATASOURCE_ID = :h2hDatasourceId, H2H_DATASET_ID = :h2hDatasetId, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, SOURCE_REF_ID = :sourceRefId, IS_MASTER_VERSION = :isMasterVersion, CRON_OBJ = :cronObj WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgSdkScheduleRule> fgsdkschedulerules);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_SCHEDULE_RULE WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SDK_SCHEDULE_RULE WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgSdkScheduleRule records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SDK_SCHEDULE_RULE WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgSdkScheduleRule.class)
    public List<FgSdkScheduleRule> findByIds(@BindList("ids") Collection<String> ids);
}
