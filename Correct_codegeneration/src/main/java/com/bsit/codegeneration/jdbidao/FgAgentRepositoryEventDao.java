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
import com.bsit.codegeneration.entity.FgAgentRepositoryEvent;

public interface FgAgentRepositoryEventDao {

    /**
     * Inserts a new FgAgentRepositoryEvent and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_AGENT_REPOSITORY_EVENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, AGENT_REF_ID, PURPOSE_CODE, AGENT_CATEGORY, AGENT_TYPE, AGENT_SCOPE, AGENT_POOL_CODE, OWNER_ORG_TYPE, OWNER_ORG_CODE, SCOPE_ORG_TYPE, SCOPE_ORG_CODE, START_TIME, LAST_RUN_TIME, LAST_RUN_STATUS, LAST_HEALTH_TIME, LAST_HEALTH_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :agentRefId, :purposeCode, :agentCategory, :agentType, :agentScope, :agentPoolCode, :ownerOrgType, :ownerOrgCode, :scopeOrgType, :scopeOrgCode, :startTime, :lastRunTime, :lastRunStatus, :lastHealthTime, :lastHealthStatus)")
    public int insert(@BindBean FgAgentRepositoryEvent fgagentrepositoryevent);

    /**
     * Finds a FgAgentRepositoryEvent by its ID.
     */
    @SqlQuery("SELECT * FROM FG_AGENT_REPOSITORY_EVENT WHERE FG_AGENT_REPOSITORY_EVENT_id = :id")
    @RegisterBeanMapper(FgAgentRepositoryEvent.class)
    public Optional<FgAgentRepositoryEvent> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_AGENT_REPOSITORY_EVENT")
    @RegisterBeanMapper(FgAgentRepositoryEvent.class)
    public List<FgAgentRepositoryEvent> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_AGENT_REPOSITORY_EVENT ORDER BY FG_AGENT_REPOSITORY_EVENT_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAgentRepositoryEvent.class)
    public List<FgAgentRepositoryEvent> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAgentRepositoryEvent and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_AGENT_REPOSITORY_EVENT SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, AGENT_REF_ID = :agentRefId, PURPOSE_CODE = :purposeCode, AGENT_CATEGORY = :agentCategory, AGENT_TYPE = :agentType, AGENT_SCOPE = :agentScope, AGENT_POOL_CODE = :agentPoolCode, OWNER_ORG_TYPE = :ownerOrgType, OWNER_ORG_CODE = :ownerOrgCode, SCOPE_ORG_TYPE = :scopeOrgType, SCOPE_ORG_CODE = :scopeOrgCode, START_TIME = :startTime, LAST_RUN_TIME = :lastRunTime, LAST_RUN_STATUS = :lastRunStatus, LAST_HEALTH_TIME = :lastHealthTime, LAST_HEALTH_STATUS = :lastHealthStatus WHERE FG_AGENT_REPOSITORY_EVENT_id = :fgAgentRepositoryEventId")
    public int update(@BindBean FgAgentRepositoryEvent fgagentrepositoryevent);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AGENT_REPOSITORY_EVENT WHERE FG_AGENT_REPOSITORY_EVENT_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_AGENT_REPOSITORY_EVENT")
    public long countAll();

    /**
     * Bulk insert multiple FgAgentRepositoryEvent entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_AGENT_REPOSITORY_EVENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, AGENT_REF_ID, PURPOSE_CODE, AGENT_CATEGORY, AGENT_TYPE, AGENT_SCOPE, AGENT_POOL_CODE, OWNER_ORG_TYPE, OWNER_ORG_CODE, SCOPE_ORG_TYPE, SCOPE_ORG_CODE, START_TIME, LAST_RUN_TIME, LAST_RUN_STATUS, LAST_HEALTH_TIME, LAST_HEALTH_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :agentRefId, :purposeCode, :agentCategory, :agentType, :agentScope, :agentPoolCode, :ownerOrgType, :ownerOrgCode, :scopeOrgType, :scopeOrgCode, :startTime, :lastRunTime, :lastRunStatus, :lastHealthTime, :lastHealthStatus)")
    public int[] bulkInsert(@BindBean List<FgAgentRepositoryEvent> fgagentrepositoryevents);

    /**
     * Bulk update multiple FgAgentRepositoryEvent entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_AGENT_REPOSITORY_EVENT SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, AGENT_REF_ID = :agentRefId, PURPOSE_CODE = :purposeCode, AGENT_CATEGORY = :agentCategory, AGENT_TYPE = :agentType, AGENT_SCOPE = :agentScope, AGENT_POOL_CODE = :agentPoolCode, OWNER_ORG_TYPE = :ownerOrgType, OWNER_ORG_CODE = :ownerOrgCode, SCOPE_ORG_TYPE = :scopeOrgType, SCOPE_ORG_CODE = :scopeOrgCode, START_TIME = :startTime, LAST_RUN_TIME = :lastRunTime, LAST_RUN_STATUS = :lastRunStatus, LAST_HEALTH_TIME = :lastHealthTime, LAST_HEALTH_STATUS = :lastHealthStatus WHERE FG_AGENT_REPOSITORY_EVENT_id = :fgAgentRepositoryEventId")
    public int[] bulkUpdate(@BindBean List<FgAgentRepositoryEvent> fgagentrepositoryevents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AGENT_REPOSITORY_EVENT WHERE FG_AGENT_REPOSITORY_EVENT_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_AGENT_REPOSITORY_EVENT WHERE FG_AGENT_REPOSITORY_EVENT_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgAgentRepositoryEvent records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_AGENT_REPOSITORY_EVENT WHERE FG_AGENT_REPOSITORY_EVENT_id IN (<ids>)")
    @RegisterBeanMapper(FgAgentRepositoryEvent.class)
    public List<FgAgentRepositoryEvent> findByIds(@BindList("ids") Collection<Integer> ids);
}
