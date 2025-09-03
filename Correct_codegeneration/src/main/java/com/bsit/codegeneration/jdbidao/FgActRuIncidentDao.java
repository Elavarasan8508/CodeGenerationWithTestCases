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
import com.bsit.codegeneration.entity.FgActRuIncident;

public interface FgActRuIncidentDao {

    /**
     * Inserts a new FgActRuIncident and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_INCIDENT (ID_, REV_, INCIDENT_TIMESTAMP_, INCIDENT_MSG_, INCIDENT_TYPE_, EXECUTION_ID_, ACTIVITY_ID_, PROC_INST_ID_, PROC_DEF_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, TENANT_ID_, JOB_DEF_ID_, FAILED_ACTIVITY_ID_) VALUES (:id, :rev, :incidentTimestamp, :incidentMsg, :incidentType, :executionId, :activityId, :procInstId, :procDefId, :causeIncidentId, :rootCauseIncidentId, :configuration, :tenantId, :jobDefId, :failedActivityId)")
    public int insert(@BindBean FgActRuIncident fgactruincident);

    /**
     * Finds a FgActRuIncident by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_INCIDENT WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuIncident.class)
    public Optional<FgActRuIncident> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_INCIDENT")
    @RegisterBeanMapper(FgActRuIncident.class)
    public List<FgActRuIncident> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_INCIDENT ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuIncident.class)
    public List<FgActRuIncident> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuIncident and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_INCIDENT SET REV_ = :rev, INCIDENT_TIMESTAMP_ = :incidentTimestamp, INCIDENT_MSG_ = :incidentMsg, INCIDENT_TYPE_ = :incidentType, EXECUTION_ID_ = :executionId, ACTIVITY_ID_ = :activityId, PROC_INST_ID_ = :procInstId, PROC_DEF_ID_ = :procDefId, CAUSE_INCIDENT_ID_ = :causeIncidentId, ROOT_CAUSE_INCIDENT_ID_ = :rootCauseIncidentId, CONFIGURATION_ = :configuration, TENANT_ID_ = :tenantId, JOB_DEF_ID_ = :jobDefId, FAILED_ACTIVITY_ID_ = :failedActivityId WHERE ID_ = :id")
    public int update(@BindBean FgActRuIncident fgactruincident);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_INCIDENT WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_INCIDENT")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuIncident entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_INCIDENT (ID_, REV_, INCIDENT_TIMESTAMP_, INCIDENT_MSG_, INCIDENT_TYPE_, EXECUTION_ID_, ACTIVITY_ID_, PROC_INST_ID_, PROC_DEF_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, TENANT_ID_, JOB_DEF_ID_, FAILED_ACTIVITY_ID_) VALUES (:id, :rev, :incidentTimestamp, :incidentMsg, :incidentType, :executionId, :activityId, :procInstId, :procDefId, :causeIncidentId, :rootCauseIncidentId, :configuration, :tenantId, :jobDefId, :failedActivityId)")
    public int[] bulkInsert(@BindBean List<FgActRuIncident> fgactruincidents);

    /**
     * Bulk update multiple FgActRuIncident entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_INCIDENT SET REV_ = :rev, INCIDENT_TIMESTAMP_ = :incidentTimestamp, INCIDENT_MSG_ = :incidentMsg, INCIDENT_TYPE_ = :incidentType, EXECUTION_ID_ = :executionId, ACTIVITY_ID_ = :activityId, PROC_INST_ID_ = :procInstId, PROC_DEF_ID_ = :procDefId, CAUSE_INCIDENT_ID_ = :causeIncidentId, ROOT_CAUSE_INCIDENT_ID_ = :rootCauseIncidentId, CONFIGURATION_ = :configuration, TENANT_ID_ = :tenantId, JOB_DEF_ID_ = :jobDefId, FAILED_ACTIVITY_ID_ = :failedActivityId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuIncident> fgactruincidents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_INCIDENT WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_INCIDENT WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuIncident records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_INCIDENT WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuIncident.class)
    public List<FgActRuIncident> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActRuIncident records by causeIncidentId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_INCIDENT WHERE CAUSE_INCIDENT_ID_ = :causeIncidentId")
    @RegisterBeanMapper(FgActRuIncident.class)
    public List<FgActRuIncident> findByCauseIncidentId(@Bind("causeIncidentId") int causeIncidentId);

    /**
     * Finds all FgActRuIncident records by rootCauseIncidentId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_INCIDENT WHERE ROOT_CAUSE_INCIDENT_ID_ = :rootCauseIncidentId")
    @RegisterBeanMapper(FgActRuIncident.class)
    public List<FgActRuIncident> findByRootCauseIncidentId(@Bind("rootCauseIncidentId") int rootCauseIncidentId);

    /**
     * Finds all FgActRuIncident records by jobDefId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_INCIDENT WHERE JOB_DEF_ID_ = :jobDefId")
    @RegisterBeanMapper(FgActRuIncident.class)
    public List<FgActRuIncident> findByJobDefId(@Bind("jobDefId") int jobDefId);
}
