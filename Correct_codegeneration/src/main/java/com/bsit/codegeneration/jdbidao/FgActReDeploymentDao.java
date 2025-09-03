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
import com.bsit.codegeneration.entity.FgActReDeployment;

public interface FgActReDeploymentDao {

    /**
     * Inserts a new FgActReDeployment and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RE_DEPLOYMENT (ID_, NAME_, DEPLOY_TIME_, SOURCE_, TENANT_ID_) VALUES (:id, :name, :deployTime, :source, :tenantId)")
    public int insert(@BindBean FgActReDeployment fgactredeployment);

    /**
     * Finds a FgActReDeployment by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DEPLOYMENT WHERE ID_ = :id")
    @RegisterBeanMapper(FgActReDeployment.class)
    public Optional<FgActReDeployment> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DEPLOYMENT")
    @RegisterBeanMapper(FgActReDeployment.class)
    public List<FgActReDeployment> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DEPLOYMENT ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActReDeployment.class)
    public List<FgActReDeployment> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActReDeployment and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RE_DEPLOYMENT SET NAME_ = :name, DEPLOY_TIME_ = :deployTime, SOURCE_ = :source, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int update(@BindBean FgActReDeployment fgactredeployment);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RE_DEPLOYMENT WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RE_DEPLOYMENT")
    public long countAll();

    /**
     * Bulk insert multiple FgActReDeployment entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RE_DEPLOYMENT (ID_, NAME_, DEPLOY_TIME_, SOURCE_, TENANT_ID_) VALUES (:id, :name, :deployTime, :source, :tenantId)")
    public int[] bulkInsert(@BindBean List<FgActReDeployment> fgactredeployments);

    /**
     * Bulk update multiple FgActReDeployment entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RE_DEPLOYMENT SET NAME_ = :name, DEPLOY_TIME_ = :deployTime, SOURCE_ = :source, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActReDeployment> fgactredeployments);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RE_DEPLOYMENT WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RE_DEPLOYMENT WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActReDeployment records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RE_DEPLOYMENT WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActReDeployment.class)
    public List<FgActReDeployment> findByIds(@BindList("ids") Collection<String> ids);
}
