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
import com.bsit.codegeneration.entity.FgProductWfActHistory;

public interface FgProductWfActHistoryDao {

    /**
     * Inserts a new FgProductWfActHistory and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PRODUCT_WF_ACT_HISTORY (WF_PROCESS_ID, WF_DEFINITION_ID, WF_ACTIVITY_ID, WF_ACTIVITY_TYPE_CODE, PERF_PARTY_CODE, PERF_PARTY_USER_CODE, WF_ACTIVITY_START_DATE, WF_ACTIVITY_END_DATE, WF_ACTIVITY_RESULT_CODE, WF_ACTIVITY_ACTION_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, STAGE_CODE, MESSAGE, WF_TASK_NAME, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ID, TASK_CONSENT, IS_TASK_CONSENT) VALUES (:wfProcessId, :wfDefinitionId, :wfActivityId, :wfActivityTypeCode, :perfPartyCode, :perfPartyUserCode, :wfActivityStartDate, :wfActivityEndDate, :wfActivityResultCode, :wfActivityActionCode, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn, :stageCode, :message, :wfTaskName, :entityRefId, :entityVersionId, :entityTypeCode, :entitySubTypeCode, :id, :taskConsent, :isTaskConsent)")
    public int insert(@BindBean FgProductWfActHistory fgproductwfacthistory);

    /**
     * Finds a FgProductWfActHistory by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_WF_ACT_HISTORY WHERE ID = :id")
    @RegisterBeanMapper(FgProductWfActHistory.class)
    public Optional<FgProductWfActHistory> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_WF_ACT_HISTORY")
    @RegisterBeanMapper(FgProductWfActHistory.class)
    public List<FgProductWfActHistory> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_WF_ACT_HISTORY ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProductWfActHistory.class)
    public List<FgProductWfActHistory> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProductWfActHistory and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PRODUCT_WF_ACT_HISTORY SET WF_PROCESS_ID = :wfProcessId, WF_DEFINITION_ID = :wfDefinitionId, WF_ACTIVITY_ID = :wfActivityId, WF_ACTIVITY_TYPE_CODE = :wfActivityTypeCode, PERF_PARTY_CODE = :perfPartyCode, PERF_PARTY_USER_CODE = :perfPartyUserCode, WF_ACTIVITY_START_DATE = :wfActivityStartDate, WF_ACTIVITY_END_DATE = :wfActivityEndDate, WF_ACTIVITY_RESULT_CODE = :wfActivityResultCode, WF_ACTIVITY_ACTION_CODE = :wfActivityActionCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, STAGE_CODE = :stageCode, MESSAGE = :message, WF_TASK_NAME = :wfTaskName, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_ID = :entityVersionId, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, TASK_CONSENT = :taskConsent, IS_TASK_CONSENT = :isTaskConsent WHERE ID = :id")
    public int update(@BindBean FgProductWfActHistory fgproductwfacthistory);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_WF_ACT_HISTORY WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PRODUCT_WF_ACT_HISTORY")
    public long countAll();

    /**
     * Bulk insert multiple FgProductWfActHistory entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PRODUCT_WF_ACT_HISTORY (WF_PROCESS_ID, WF_DEFINITION_ID, WF_ACTIVITY_ID, WF_ACTIVITY_TYPE_CODE, PERF_PARTY_CODE, PERF_PARTY_USER_CODE, WF_ACTIVITY_START_DATE, WF_ACTIVITY_END_DATE, WF_ACTIVITY_RESULT_CODE, WF_ACTIVITY_ACTION_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, STAGE_CODE, MESSAGE, WF_TASK_NAME, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ID, TASK_CONSENT, IS_TASK_CONSENT) VALUES (:wfProcessId, :wfDefinitionId, :wfActivityId, :wfActivityTypeCode, :perfPartyCode, :perfPartyUserCode, :wfActivityStartDate, :wfActivityEndDate, :wfActivityResultCode, :wfActivityActionCode, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn, :stageCode, :message, :wfTaskName, :entityRefId, :entityVersionId, :entityTypeCode, :entitySubTypeCode, :id, :taskConsent, :isTaskConsent)")
    public int[] bulkInsert(@BindBean List<FgProductWfActHistory> fgproductwfacthistorys);

    /**
     * Bulk update multiple FgProductWfActHistory entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PRODUCT_WF_ACT_HISTORY SET WF_PROCESS_ID = :wfProcessId, WF_DEFINITION_ID = :wfDefinitionId, WF_ACTIVITY_ID = :wfActivityId, WF_ACTIVITY_TYPE_CODE = :wfActivityTypeCode, PERF_PARTY_CODE = :perfPartyCode, PERF_PARTY_USER_CODE = :perfPartyUserCode, WF_ACTIVITY_START_DATE = :wfActivityStartDate, WF_ACTIVITY_END_DATE = :wfActivityEndDate, WF_ACTIVITY_RESULT_CODE = :wfActivityResultCode, WF_ACTIVITY_ACTION_CODE = :wfActivityActionCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, STAGE_CODE = :stageCode, MESSAGE = :message, WF_TASK_NAME = :wfTaskName, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_ID = :entityVersionId, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, TASK_CONSENT = :taskConsent, IS_TASK_CONSENT = :isTaskConsent WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgProductWfActHistory> fgproductwfacthistorys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_WF_ACT_HISTORY WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PRODUCT_WF_ACT_HISTORY WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgProductWfActHistory records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_WF_ACT_HISTORY WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgProductWfActHistory.class)
    public List<FgProductWfActHistory> findByIds(@BindList("ids") Collection<String> ids);
}
