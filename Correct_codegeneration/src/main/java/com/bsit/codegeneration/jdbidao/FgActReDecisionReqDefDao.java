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
import com.bsit.codegeneration.entity.FgActReDecisionReqDef;

public interface FgActReDecisionReqDefDao {

    /**
     * Inserts a new FgActReDecisionReqDef and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RE_DECISION_REQ_DEF (ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, TENANT_ID_) VALUES (:id, :rev, :category, :name, :key, :version, :deploymentId, :resourceName, :dgrmResourceName, :tenantId)")
    public int insert(@BindBean FgActReDecisionReqDef fgactredecisionreqdef);

    /**
     * Finds a FgActReDecisionReqDef by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_REQ_DEF WHERE ID_ = :id")
    @RegisterBeanMapper(FgActReDecisionReqDef.class)
    public Optional<FgActReDecisionReqDef> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_REQ_DEF")
    @RegisterBeanMapper(FgActReDecisionReqDef.class)
    public List<FgActReDecisionReqDef> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_REQ_DEF ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActReDecisionReqDef.class)
    public List<FgActReDecisionReqDef> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActReDecisionReqDef and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RE_DECISION_REQ_DEF SET REV_ = :rev, CATEGORY_ = :category, NAME_ = :name, KEY_ = :key, VERSION_ = :version, DEPLOYMENT_ID_ = :deploymentId, RESOURCE_NAME_ = :resourceName, DGRM_RESOURCE_NAME_ = :dgrmResourceName, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int update(@BindBean FgActReDecisionReqDef fgactredecisionreqdef);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RE_DECISION_REQ_DEF WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RE_DECISION_REQ_DEF")
    public long countAll();

    /**
     * Bulk insert multiple FgActReDecisionReqDef entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RE_DECISION_REQ_DEF (ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, TENANT_ID_) VALUES (:id, :rev, :category, :name, :key, :version, :deploymentId, :resourceName, :dgrmResourceName, :tenantId)")
    public int[] bulkInsert(@BindBean List<FgActReDecisionReqDef> fgactredecisionreqdefs);

    /**
     * Bulk update multiple FgActReDecisionReqDef entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RE_DECISION_REQ_DEF SET REV_ = :rev, CATEGORY_ = :category, NAME_ = :name, KEY_ = :key, VERSION_ = :version, DEPLOYMENT_ID_ = :deploymentId, RESOURCE_NAME_ = :resourceName, DGRM_RESOURCE_NAME_ = :dgrmResourceName, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActReDecisionReqDef> fgactredecisionreqdefs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RE_DECISION_REQ_DEF WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RE_DECISION_REQ_DEF WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActReDecisionReqDef records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_REQ_DEF WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActReDecisionReqDef.class)
    public List<FgActReDecisionReqDef> findByIds(@BindList("ids") Collection<String> ids);
}
