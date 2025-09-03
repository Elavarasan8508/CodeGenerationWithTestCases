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
import com.bsit.codegeneration.entity.FgActRuJobdef;

public interface FgActRuJobdefDao {

    /**
     * Inserts a new FgActRuJobdef and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_JOBDEF (ID_, REV_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, JOB_TYPE_, JOB_CONFIGURATION_, SUSPENSION_STATE_, JOB_PRIORITY_, TENANT_ID_, DEPLOYMENT_ID_) VALUES (:id, :rev, :procDefId, :procDefKey, :actId, :jobType, :jobConfiguration, :suspensionState, :jobPriority, :tenantId, :deploymentId)")
    public int insert(@BindBean FgActRuJobdef fgactrujobdef);

    /**
     * Finds a FgActRuJobdef by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_JOBDEF WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuJobdef.class)
    public Optional<FgActRuJobdef> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_JOBDEF")
    @RegisterBeanMapper(FgActRuJobdef.class)
    public List<FgActRuJobdef> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_JOBDEF ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuJobdef.class)
    public List<FgActRuJobdef> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuJobdef and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_JOBDEF SET REV_ = :rev, PROC_DEF_ID_ = :procDefId, PROC_DEF_KEY_ = :procDefKey, ACT_ID_ = :actId, JOB_TYPE_ = :jobType, JOB_CONFIGURATION_ = :jobConfiguration, SUSPENSION_STATE_ = :suspensionState, JOB_PRIORITY_ = :jobPriority, TENANT_ID_ = :tenantId, DEPLOYMENT_ID_ = :deploymentId WHERE ID_ = :id")
    public int update(@BindBean FgActRuJobdef fgactrujobdef);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_JOBDEF WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_JOBDEF")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuJobdef entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_JOBDEF (ID_, REV_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, JOB_TYPE_, JOB_CONFIGURATION_, SUSPENSION_STATE_, JOB_PRIORITY_, TENANT_ID_, DEPLOYMENT_ID_) VALUES (:id, :rev, :procDefId, :procDefKey, :actId, :jobType, :jobConfiguration, :suspensionState, :jobPriority, :tenantId, :deploymentId)")
    public int[] bulkInsert(@BindBean List<FgActRuJobdef> fgactrujobdefs);

    /**
     * Bulk update multiple FgActRuJobdef entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_JOBDEF SET REV_ = :rev, PROC_DEF_ID_ = :procDefId, PROC_DEF_KEY_ = :procDefKey, ACT_ID_ = :actId, JOB_TYPE_ = :jobType, JOB_CONFIGURATION_ = :jobConfiguration, SUSPENSION_STATE_ = :suspensionState, JOB_PRIORITY_ = :jobPriority, TENANT_ID_ = :tenantId, DEPLOYMENT_ID_ = :deploymentId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuJobdef> fgactrujobdefs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_JOBDEF WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_JOBDEF WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuJobdef records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_JOBDEF WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuJobdef.class)
    public List<FgActRuJobdef> findByIds(@BindList("ids") Collection<String> ids);
}
