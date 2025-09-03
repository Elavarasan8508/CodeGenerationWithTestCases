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
import com.bsit.codegeneration.entity.FgActHiIncident;

public interface FgActHiIncidentDao {

    /**
     * Inserts a new FgActHiIncident and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_INCIDENT (ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CREATE_TIME_, END_TIME_, INCIDENT_MSG_, INCIDENT_TYPE_, ACTIVITY_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, INCIDENT_STATE_, TENANT_ID_, JOB_DEF_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, HISTORY_CONFIGURATION_, FAILED_ACTIVITY_ID_) VALUES (:id, :procDefKey, :procDefId, :procInstId, :executionId, :createTime, :endTime, :incidentMsg, :incidentType, :activityId, :causeIncidentId, :rootCauseIncidentId, :configuration, :incidentState, :tenantId, :jobDefId, :rootProcInstId, :removalTime, :historyConfiguration, :failedActivityId)")
    public int insert(@BindBean FgActHiIncident fgacthiincident);

    /**
     * Finds a FgActHiIncident by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_INCIDENT WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiIncident.class)
    public Optional<FgActHiIncident> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_INCIDENT")
    @RegisterBeanMapper(FgActHiIncident.class)
    public List<FgActHiIncident> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_INCIDENT ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiIncident.class)
    public List<FgActHiIncident> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiIncident and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_INCIDENT SET PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, CREATE_TIME_ = :createTime, END_TIME_ = :endTime, INCIDENT_MSG_ = :incidentMsg, INCIDENT_TYPE_ = :incidentType, ACTIVITY_ID_ = :activityId, CAUSE_INCIDENT_ID_ = :causeIncidentId, ROOT_CAUSE_INCIDENT_ID_ = :rootCauseIncidentId, CONFIGURATION_ = :configuration, INCIDENT_STATE_ = :incidentState, TENANT_ID_ = :tenantId, JOB_DEF_ID_ = :jobDefId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime, HISTORY_CONFIGURATION_ = :historyConfiguration, FAILED_ACTIVITY_ID_ = :failedActivityId WHERE ID_ = :id")
    public int update(@BindBean FgActHiIncident fgacthiincident);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_INCIDENT WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_INCIDENT")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiIncident entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_INCIDENT (ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CREATE_TIME_, END_TIME_, INCIDENT_MSG_, INCIDENT_TYPE_, ACTIVITY_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, INCIDENT_STATE_, TENANT_ID_, JOB_DEF_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, HISTORY_CONFIGURATION_, FAILED_ACTIVITY_ID_) VALUES (:id, :procDefKey, :procDefId, :procInstId, :executionId, :createTime, :endTime, :incidentMsg, :incidentType, :activityId, :causeIncidentId, :rootCauseIncidentId, :configuration, :incidentState, :tenantId, :jobDefId, :rootProcInstId, :removalTime, :historyConfiguration, :failedActivityId)")
    public int[] bulkInsert(@BindBean List<FgActHiIncident> fgacthiincidents);

    /**
     * Bulk update multiple FgActHiIncident entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_INCIDENT SET PROC_DEF_KEY_ = :procDefKey, PROC_DEF_ID_ = :procDefId, PROC_INST_ID_ = :procInstId, EXECUTION_ID_ = :executionId, CREATE_TIME_ = :createTime, END_TIME_ = :endTime, INCIDENT_MSG_ = :incidentMsg, INCIDENT_TYPE_ = :incidentType, ACTIVITY_ID_ = :activityId, CAUSE_INCIDENT_ID_ = :causeIncidentId, ROOT_CAUSE_INCIDENT_ID_ = :rootCauseIncidentId, CONFIGURATION_ = :configuration, INCIDENT_STATE_ = :incidentState, TENANT_ID_ = :tenantId, JOB_DEF_ID_ = :jobDefId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime, HISTORY_CONFIGURATION_ = :historyConfiguration, FAILED_ACTIVITY_ID_ = :failedActivityId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiIncident> fgacthiincidents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_INCIDENT WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_INCIDENT WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiIncident records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_INCIDENT WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiIncident.class)
    public List<FgActHiIncident> findByIds(@BindList("ids") Collection<String> ids);
}
