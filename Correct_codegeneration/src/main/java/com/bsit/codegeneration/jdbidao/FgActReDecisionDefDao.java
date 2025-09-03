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
import com.bsit.codegeneration.entity.FgActReDecisionDef;

public interface FgActReDecisionDefDao {

    /**
     * Inserts a new FgActReDecisionDef and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RE_DECISION_DEF (ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, HISTORY_TTL_, VERSION_TAG_) VALUES (:id, :rev, :category, :name, :key, :version, :deploymentId, :resourceName, :dgrmResourceName, :decReqId, :decReqKey, :tenantId, :historyTtl, :versionTag)")
    public int insert(@BindBean FgActReDecisionDef fgactredecisiondef);

    /**
     * Finds a FgActReDecisionDef by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_DEF WHERE ID_ = :id")
    @RegisterBeanMapper(FgActReDecisionDef.class)
    public Optional<FgActReDecisionDef> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_DEF")
    @RegisterBeanMapper(FgActReDecisionDef.class)
    public List<FgActReDecisionDef> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_DEF ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActReDecisionDef.class)
    public List<FgActReDecisionDef> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActReDecisionDef and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RE_DECISION_DEF SET REV_ = :rev, CATEGORY_ = :category, NAME_ = :name, KEY_ = :key, VERSION_ = :version, DEPLOYMENT_ID_ = :deploymentId, RESOURCE_NAME_ = :resourceName, DGRM_RESOURCE_NAME_ = :dgrmResourceName, DEC_REQ_ID_ = :decReqId, DEC_REQ_KEY_ = :decReqKey, TENANT_ID_ = :tenantId, HISTORY_TTL_ = :historyTtl, VERSION_TAG_ = :versionTag WHERE ID_ = :id")
    public int update(@BindBean FgActReDecisionDef fgactredecisiondef);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RE_DECISION_DEF WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RE_DECISION_DEF")
    public long countAll();

    /**
     * Bulk insert multiple FgActReDecisionDef entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RE_DECISION_DEF (ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, HISTORY_TTL_, VERSION_TAG_) VALUES (:id, :rev, :category, :name, :key, :version, :deploymentId, :resourceName, :dgrmResourceName, :decReqId, :decReqKey, :tenantId, :historyTtl, :versionTag)")
    public int[] bulkInsert(@BindBean List<FgActReDecisionDef> fgactredecisiondefs);

    /**
     * Bulk update multiple FgActReDecisionDef entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RE_DECISION_DEF SET REV_ = :rev, CATEGORY_ = :category, NAME_ = :name, KEY_ = :key, VERSION_ = :version, DEPLOYMENT_ID_ = :deploymentId, RESOURCE_NAME_ = :resourceName, DGRM_RESOURCE_NAME_ = :dgrmResourceName, DEC_REQ_ID_ = :decReqId, DEC_REQ_KEY_ = :decReqKey, TENANT_ID_ = :tenantId, HISTORY_TTL_ = :historyTtl, VERSION_TAG_ = :versionTag WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActReDecisionDef> fgactredecisiondefs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RE_DECISION_DEF WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RE_DECISION_DEF WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActReDecisionDef records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_DEF WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActReDecisionDef.class)
    public List<FgActReDecisionDef> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActReDecisionDef records by decReqId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_DEF WHERE DEC_REQ_ID_ = :decReqId")
    @RegisterBeanMapper(FgActReDecisionDef.class)
    public List<FgActReDecisionDef> findByDecReqId(@Bind("decReqId") int decReqId);
}
