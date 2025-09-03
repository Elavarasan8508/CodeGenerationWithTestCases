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
import com.bsit.codegeneration.entity.FgActRuIdentitylink;

public interface FgActRuIdentitylinkDao {

    /**
     * Inserts a new FgActRuIdentitylink and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_IDENTITYLINK (ID_, REV_, GROUP_ID_, TYPE_, USER_ID_, TASK_ID_, PROC_DEF_ID_, TENANT_ID_) VALUES (:id, :rev, :groupId, :type, :userId, :taskId, :procDefId, :tenantId)")
    public int insert(@BindBean FgActRuIdentitylink fgactruidentitylink);

    /**
     * Finds a FgActRuIdentitylink by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_IDENTITYLINK WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuIdentitylink.class)
    public Optional<FgActRuIdentitylink> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_IDENTITYLINK")
    @RegisterBeanMapper(FgActRuIdentitylink.class)
    public List<FgActRuIdentitylink> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_IDENTITYLINK ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuIdentitylink.class)
    public List<FgActRuIdentitylink> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuIdentitylink and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_IDENTITYLINK SET REV_ = :rev, GROUP_ID_ = :groupId, TYPE_ = :type, USER_ID_ = :userId, TASK_ID_ = :taskId, PROC_DEF_ID_ = :procDefId, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int update(@BindBean FgActRuIdentitylink fgactruidentitylink);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_IDENTITYLINK WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_IDENTITYLINK")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuIdentitylink entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_IDENTITYLINK (ID_, REV_, GROUP_ID_, TYPE_, USER_ID_, TASK_ID_, PROC_DEF_ID_, TENANT_ID_) VALUES (:id, :rev, :groupId, :type, :userId, :taskId, :procDefId, :tenantId)")
    public int[] bulkInsert(@BindBean List<FgActRuIdentitylink> fgactruidentitylinks);

    /**
     * Bulk update multiple FgActRuIdentitylink entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_IDENTITYLINK SET REV_ = :rev, GROUP_ID_ = :groupId, TYPE_ = :type, USER_ID_ = :userId, TASK_ID_ = :taskId, PROC_DEF_ID_ = :procDefId, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuIdentitylink> fgactruidentitylinks);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_IDENTITYLINK WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_IDENTITYLINK WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuIdentitylink records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_IDENTITYLINK WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuIdentitylink.class)
    public List<FgActRuIdentitylink> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActRuIdentitylink records by taskId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_IDENTITYLINK WHERE TASK_ID_ = :taskId")
    @RegisterBeanMapper(FgActRuIdentitylink.class)
    public List<FgActRuIdentitylink> findByTaskId(@Bind("taskId") int taskId);
}
