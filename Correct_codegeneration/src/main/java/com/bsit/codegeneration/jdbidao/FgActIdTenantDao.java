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
import com.bsit.codegeneration.entity.FgActIdTenant;

public interface FgActIdTenantDao {

    /**
     * Inserts a new FgActIdTenant and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_ID_TENANT (ID_, REV_, NAME_) VALUES (:id, :rev, :name)")
    public int insert(@Bind("id") String id, @Bind("rev") java.math.BigDecimal rev, @Bind("name") String name);

    /**
     * Finds a FgActIdTenant by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT WHERE ID_ = :id")
    @RegisterBeanMapper(FgActIdTenant.class)
    public Optional<FgActIdTenant> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT")
    @RegisterBeanMapper(FgActIdTenant.class)
    public List<FgActIdTenant> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActIdTenant.class)
    public List<FgActIdTenant> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActIdTenant and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_ID_TENANT SET REV_ = :rev, NAME_ = :name WHERE ID_ = :id")
    public int update(@BindBean FgActIdTenant fgactidtenant);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_TENANT WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_ID_TENANT")
    public long countAll();

    /**
     * Bulk insert multiple FgActIdTenant entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_ID_TENANT (ID_, REV_, NAME_) VALUES (:id, :rev, :name)")
    public int[] bulkInsert(@BindBean List<FgActIdTenant> fgactidtenants);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_ID_TENANT (ID_, REV_, NAME_) VALUES (:id, :rev, :name)")
    public int[] bulkInsertParams(@Bind("id") List<String> ids, @Bind("rev") List<java.math.BigDecimal> revs, @Bind("name") List<String> names);

    /**
     * Bulk update multiple FgActIdTenant entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_ID_TENANT SET REV_ = :rev, NAME_ = :name WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActIdTenant> fgactidtenants);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_ID_TENANT SET REV_ = :rev, NAME_ = :name WHERE ID_ = :id")
    public int[] bulkUpdateParams(@Bind("rev") List<java.math.BigDecimal> revs, @Bind("name") List<String> names, @Bind("id") List<String> ids);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_TENANT WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_ID_TENANT WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActIdTenant records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActIdTenant.class)
    public List<FgActIdTenant> findByIds(@BindList("ids") Collection<String> ids);
}
