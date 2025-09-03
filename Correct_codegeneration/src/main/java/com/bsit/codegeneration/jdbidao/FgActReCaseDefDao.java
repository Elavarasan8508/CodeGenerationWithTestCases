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
import com.bsit.codegeneration.entity.FgActReCaseDef;

public interface FgActReCaseDefDao {

    /**
     * Inserts a new FgActReCaseDef and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RE_CASE_DEF (ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, TENANT_ID_, HISTORY_TTL_) VALUES (:id, :rev, :category, :name, :key, :version, :deploymentId, :resourceName, :dgrmResourceName, :tenantId, :historyTtl)")
    public int insert(@BindBean FgActReCaseDef fgactrecasedef);

    /**
     * Finds a FgActReCaseDef by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_CASE_DEF WHERE ID_ = :id")
    @RegisterBeanMapper(FgActReCaseDef.class)
    public Optional<FgActReCaseDef> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_CASE_DEF")
    @RegisterBeanMapper(FgActReCaseDef.class)
    public List<FgActReCaseDef> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_CASE_DEF ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActReCaseDef.class)
    public List<FgActReCaseDef> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActReCaseDef and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RE_CASE_DEF SET REV_ = :rev, CATEGORY_ = :category, NAME_ = :name, KEY_ = :key, VERSION_ = :version, DEPLOYMENT_ID_ = :deploymentId, RESOURCE_NAME_ = :resourceName, DGRM_RESOURCE_NAME_ = :dgrmResourceName, TENANT_ID_ = :tenantId, HISTORY_TTL_ = :historyTtl WHERE ID_ = :id")
    public int update(@BindBean FgActReCaseDef fgactrecasedef);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RE_CASE_DEF WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RE_CASE_DEF")
    public long countAll();

    /**
     * Bulk insert multiple FgActReCaseDef entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RE_CASE_DEF (ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, TENANT_ID_, HISTORY_TTL_) VALUES (:id, :rev, :category, :name, :key, :version, :deploymentId, :resourceName, :dgrmResourceName, :tenantId, :historyTtl)")
    public int[] bulkInsert(@BindBean List<FgActReCaseDef> fgactrecasedefs);

    /**
     * Bulk update multiple FgActReCaseDef entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RE_CASE_DEF SET REV_ = :rev, CATEGORY_ = :category, NAME_ = :name, KEY_ = :key, VERSION_ = :version, DEPLOYMENT_ID_ = :deploymentId, RESOURCE_NAME_ = :resourceName, DGRM_RESOURCE_NAME_ = :dgrmResourceName, TENANT_ID_ = :tenantId, HISTORY_TTL_ = :historyTtl WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActReCaseDef> fgactrecasedefs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RE_CASE_DEF WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RE_CASE_DEF WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActReCaseDef records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_CASE_DEF WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActReCaseDef.class)
    public List<FgActReCaseDef> findByIds(@BindList("ids") Collection<String> ids);
}
