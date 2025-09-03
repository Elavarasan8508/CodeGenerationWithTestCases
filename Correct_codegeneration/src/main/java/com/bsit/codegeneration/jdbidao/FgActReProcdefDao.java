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
import com.bsit.codegeneration.entity.FgActReProcdef;

public interface FgActReProcdefDao {

    /**
     * Inserts a new FgActReProcdef and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RE_PROCDEF (ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, HAS_START_FORM_KEY_, SUSPENSION_STATE_, TENANT_ID_, VERSION_TAG_, HISTORY_TTL_, STARTABLE_) VALUES (:id, :rev, :category, :name, :key, :version, :deploymentId, :resourceName, :dgrmResourceName, :hasStartFormKey, :suspensionState, :tenantId, :versionTag, :historyTtl, :startable)")
    public int insert(@BindBean FgActReProcdef fgactreprocdef);

    /**
     * Finds a FgActReProcdef by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_PROCDEF WHERE FG_ACT_RE_PROCDEF_id = :id")
    @RegisterBeanMapper(FgActReProcdef.class)
    public Optional<FgActReProcdef> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_PROCDEF")
    @RegisterBeanMapper(FgActReProcdef.class)
    public List<FgActReProcdef> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_PROCDEF ORDER BY FG_ACT_RE_PROCDEF_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActReProcdef.class)
    public List<FgActReProcdef> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActReProcdef and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RE_PROCDEF SET ID_ = :id, REV_ = :rev, CATEGORY_ = :category, NAME_ = :name, KEY_ = :key, VERSION_ = :version, DEPLOYMENT_ID_ = :deploymentId, RESOURCE_NAME_ = :resourceName, DGRM_RESOURCE_NAME_ = :dgrmResourceName, HAS_START_FORM_KEY_ = :hasStartFormKey, SUSPENSION_STATE_ = :suspensionState, TENANT_ID_ = :tenantId, VERSION_TAG_ = :versionTag, HISTORY_TTL_ = :historyTtl, STARTABLE_ = :startable WHERE FG_ACT_RE_PROCDEF_id = :fgActReProcdefId")
    public int update(@BindBean FgActReProcdef fgactreprocdef);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RE_PROCDEF WHERE FG_ACT_RE_PROCDEF_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RE_PROCDEF")
    public long countAll();

    /**
     * Bulk insert multiple FgActReProcdef entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RE_PROCDEF (ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, HAS_START_FORM_KEY_, SUSPENSION_STATE_, TENANT_ID_, VERSION_TAG_, HISTORY_TTL_, STARTABLE_) VALUES (:id, :rev, :category, :name, :key, :version, :deploymentId, :resourceName, :dgrmResourceName, :hasStartFormKey, :suspensionState, :tenantId, :versionTag, :historyTtl, :startable)")
    public int[] bulkInsert(@BindBean List<FgActReProcdef> fgactreprocdefs);

    /**
     * Bulk update multiple FgActReProcdef entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RE_PROCDEF SET ID_ = :id, REV_ = :rev, CATEGORY_ = :category, NAME_ = :name, KEY_ = :key, VERSION_ = :version, DEPLOYMENT_ID_ = :deploymentId, RESOURCE_NAME_ = :resourceName, DGRM_RESOURCE_NAME_ = :dgrmResourceName, HAS_START_FORM_KEY_ = :hasStartFormKey, SUSPENSION_STATE_ = :suspensionState, TENANT_ID_ = :tenantId, VERSION_TAG_ = :versionTag, HISTORY_TTL_ = :historyTtl, STARTABLE_ = :startable WHERE FG_ACT_RE_PROCDEF_id = :fgActReProcdefId")
    public int[] bulkUpdate(@BindBean List<FgActReProcdef> fgactreprocdefs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RE_PROCDEF WHERE FG_ACT_RE_PROCDEF_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RE_PROCDEF WHERE FG_ACT_RE_PROCDEF_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgActReProcdef records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_PROCDEF WHERE FG_ACT_RE_PROCDEF_id IN (<ids>)")
    @RegisterBeanMapper(FgActReProcdef.class)
    public List<FgActReProcdef> findByIds(@BindList("ids") Collection<Integer> ids);
}
