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
import com.bsit.codegeneration.entity.FgProductWfTaskQueue;

public interface FgProductWfTaskQueueDao {

    /**
     * Inserts a new FgProductWfTaskQueue and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PRODUCT_WF_TASK_QUEUE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_VERSION_ID, ENTITY_CODE, ENTITY_NAME, ACTION_CODE, ACTION_REASON_CODE, APPLICANT_PARTY, PERF_PARTY_CODE, PERF_USER_CODE, CATEGORY_CODE, CONFIG_STATUS_CODE, ENTITY_ID, ENTITY_ACTION_CODE, PROCESS_ID, TASK_ID, TASK_NAME, LAYOUT_NAME, GROUP_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :entityRefId, :entityTypeCode, :entitySubTypeCode, :entityVersionId, :entityCode, :entityName, :actionCode, :actionReasonCode, :applicantParty, :perfPartyCode, :perfUserCode, :categoryCode, :configStatusCode, :entityId, :entityActionCode, :processId, :taskId, :taskName, :layoutName, :groupId)")
    public int insert(@BindBean FgProductWfTaskQueue fgproductwftaskqueue);

    /**
     * Finds a FgProductWfTaskQueue by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_WF_TASK_QUEUE WHERE ID = :id")
    @RegisterBeanMapper(FgProductWfTaskQueue.class)
    public Optional<FgProductWfTaskQueue> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_WF_TASK_QUEUE")
    @RegisterBeanMapper(FgProductWfTaskQueue.class)
    public List<FgProductWfTaskQueue> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_WF_TASK_QUEUE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProductWfTaskQueue.class)
    public List<FgProductWfTaskQueue> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProductWfTaskQueue and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PRODUCT_WF_TASK_QUEUE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ENTITY_REF_ID = :entityRefId, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_VERSION_ID = :entityVersionId, ENTITY_CODE = :entityCode, ENTITY_NAME = :entityName, ACTION_CODE = :actionCode, ACTION_REASON_CODE = :actionReasonCode, APPLICANT_PARTY = :applicantParty, PERF_PARTY_CODE = :perfPartyCode, PERF_USER_CODE = :perfUserCode, CATEGORY_CODE = :categoryCode, CONFIG_STATUS_CODE = :configStatusCode, ENTITY_ID = :entityId, ENTITY_ACTION_CODE = :entityActionCode, PROCESS_ID = :processId, TASK_ID = :taskId, TASK_NAME = :taskName, LAYOUT_NAME = :layoutName, GROUP_ID = :groupId WHERE ID = :id")
    public int update(@BindBean FgProductWfTaskQueue fgproductwftaskqueue);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_WF_TASK_QUEUE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PRODUCT_WF_TASK_QUEUE")
    public long countAll();

    /**
     * Bulk insert multiple FgProductWfTaskQueue entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PRODUCT_WF_TASK_QUEUE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_VERSION_ID, ENTITY_CODE, ENTITY_NAME, ACTION_CODE, ACTION_REASON_CODE, APPLICANT_PARTY, PERF_PARTY_CODE, PERF_USER_CODE, CATEGORY_CODE, CONFIG_STATUS_CODE, ENTITY_ID, ENTITY_ACTION_CODE, PROCESS_ID, TASK_ID, TASK_NAME, LAYOUT_NAME, GROUP_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :entityRefId, :entityTypeCode, :entitySubTypeCode, :entityVersionId, :entityCode, :entityName, :actionCode, :actionReasonCode, :applicantParty, :perfPartyCode, :perfUserCode, :categoryCode, :configStatusCode, :entityId, :entityActionCode, :processId, :taskId, :taskName, :layoutName, :groupId)")
    public int[] bulkInsert(@BindBean List<FgProductWfTaskQueue> fgproductwftaskqueues);

    /**
     * Bulk update multiple FgProductWfTaskQueue entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PRODUCT_WF_TASK_QUEUE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ENTITY_REF_ID = :entityRefId, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_VERSION_ID = :entityVersionId, ENTITY_CODE = :entityCode, ENTITY_NAME = :entityName, ACTION_CODE = :actionCode, ACTION_REASON_CODE = :actionReasonCode, APPLICANT_PARTY = :applicantParty, PERF_PARTY_CODE = :perfPartyCode, PERF_USER_CODE = :perfUserCode, CATEGORY_CODE = :categoryCode, CONFIG_STATUS_CODE = :configStatusCode, ENTITY_ID = :entityId, ENTITY_ACTION_CODE = :entityActionCode, PROCESS_ID = :processId, TASK_ID = :taskId, TASK_NAME = :taskName, LAYOUT_NAME = :layoutName, GROUP_ID = :groupId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgProductWfTaskQueue> fgproductwftaskqueues);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_WF_TASK_QUEUE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PRODUCT_WF_TASK_QUEUE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgProductWfTaskQueue records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_WF_TASK_QUEUE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgProductWfTaskQueue.class)
    public List<FgProductWfTaskQueue> findByIds(@BindList("ids") Collection<String> ids);
}
