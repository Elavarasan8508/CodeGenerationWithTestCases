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
import com.bsit.codegeneration.entity.FgAgentRepository;

public interface FgAgentRepositoryDao {

    /**
     * Inserts a new FgAgentRepository and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_AGENT_REPOSITORY (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, AGENT_CATEGORY, AGENT_TYPE, AGENT_SCOPE, AGENT_POOL_CODE, OWNER_ORG_TYPE, OWNER_ORG_CODE, SCOPE_ORG_TYPE, SCOPE_ORG_CODE, START_TIME, LAST_RUN_TIME, LAST_RUN_STATUS, LAST_HEALTH_TIME, LAST_HEALTH_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :purposeCode, :agentCategory, :agentType, :agentScope, :agentPoolCode, :ownerOrgType, :ownerOrgCode, :scopeOrgType, :scopeOrgCode, :startTime, :lastRunTime, :lastRunStatus, :lastHealthTime, :lastHealthStatus)")
    public int insert(@BindBean FgAgentRepository fgagentrepository);

    /**
     * Finds a FgAgentRepository by its ID.
     */
    @SqlQuery("SELECT * FROM FG_AGENT_REPOSITORY WHERE FG_AGENT_REPOSITORY_id = :id")
    @RegisterBeanMapper(FgAgentRepository.class)
    public Optional<FgAgentRepository> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_AGENT_REPOSITORY")
    @RegisterBeanMapper(FgAgentRepository.class)
    public List<FgAgentRepository> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_AGENT_REPOSITORY ORDER BY FG_AGENT_REPOSITORY_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAgentRepository.class)
    public List<FgAgentRepository> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAgentRepository and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_AGENT_REPOSITORY SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PURPOSE_CODE = :purposeCode, AGENT_CATEGORY = :agentCategory, AGENT_TYPE = :agentType, AGENT_SCOPE = :agentScope, AGENT_POOL_CODE = :agentPoolCode, OWNER_ORG_TYPE = :ownerOrgType, OWNER_ORG_CODE = :ownerOrgCode, SCOPE_ORG_TYPE = :scopeOrgType, SCOPE_ORG_CODE = :scopeOrgCode, START_TIME = :startTime, LAST_RUN_TIME = :lastRunTime, LAST_RUN_STATUS = :lastRunStatus, LAST_HEALTH_TIME = :lastHealthTime, LAST_HEALTH_STATUS = :lastHealthStatus WHERE FG_AGENT_REPOSITORY_id = :fgAgentRepositoryId")
    public int update(@BindBean FgAgentRepository fgagentrepository);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AGENT_REPOSITORY WHERE FG_AGENT_REPOSITORY_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_AGENT_REPOSITORY")
    public long countAll();

    /**
     * Bulk insert multiple FgAgentRepository entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_AGENT_REPOSITORY (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PURPOSE_CODE, AGENT_CATEGORY, AGENT_TYPE, AGENT_SCOPE, AGENT_POOL_CODE, OWNER_ORG_TYPE, OWNER_ORG_CODE, SCOPE_ORG_TYPE, SCOPE_ORG_CODE, START_TIME, LAST_RUN_TIME, LAST_RUN_STATUS, LAST_HEALTH_TIME, LAST_HEALTH_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :purposeCode, :agentCategory, :agentType, :agentScope, :agentPoolCode, :ownerOrgType, :ownerOrgCode, :scopeOrgType, :scopeOrgCode, :startTime, :lastRunTime, :lastRunStatus, :lastHealthTime, :lastHealthStatus)")
    public int[] bulkInsert(@BindBean List<FgAgentRepository> fgagentrepositorys);

    /**
     * Bulk update multiple FgAgentRepository entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_AGENT_REPOSITORY SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PURPOSE_CODE = :purposeCode, AGENT_CATEGORY = :agentCategory, AGENT_TYPE = :agentType, AGENT_SCOPE = :agentScope, AGENT_POOL_CODE = :agentPoolCode, OWNER_ORG_TYPE = :ownerOrgType, OWNER_ORG_CODE = :ownerOrgCode, SCOPE_ORG_TYPE = :scopeOrgType, SCOPE_ORG_CODE = :scopeOrgCode, START_TIME = :startTime, LAST_RUN_TIME = :lastRunTime, LAST_RUN_STATUS = :lastRunStatus, LAST_HEALTH_TIME = :lastHealthTime, LAST_HEALTH_STATUS = :lastHealthStatus WHERE FG_AGENT_REPOSITORY_id = :fgAgentRepositoryId")
    public int[] bulkUpdate(@BindBean List<FgAgentRepository> fgagentrepositorys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AGENT_REPOSITORY WHERE FG_AGENT_REPOSITORY_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_AGENT_REPOSITORY WHERE FG_AGENT_REPOSITORY_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgAgentRepository records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_AGENT_REPOSITORY WHERE FG_AGENT_REPOSITORY_id IN (<ids>)")
    @RegisterBeanMapper(FgAgentRepository.class)
    public List<FgAgentRepository> findByIds(@BindList("ids") Collection<Integer> ids);
}
