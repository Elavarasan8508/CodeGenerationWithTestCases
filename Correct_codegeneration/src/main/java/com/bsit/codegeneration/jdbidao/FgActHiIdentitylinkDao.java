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
import com.bsit.codegeneration.entity.FgActHiIdentitylink;

public interface FgActHiIdentitylinkDao {

    /**
     * Inserts a new FgActHiIdentitylink and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_IDENTITYLINK (ID_, TIMESTAMP_, TYPE_, USER_ID_, GROUP_ID_, TASK_ID_, PROC_DEF_ID_, OPERATION_TYPE_, ASSIGNER_ID_, PROC_DEF_KEY_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :timestamp, :type, :userId, :groupId, :taskId, :procDefId, :operationType, :assignerId, :procDefKey, :tenantId, :rootProcInstId, :removalTime)")
    public int insert(@BindBean FgActHiIdentitylink fgacthiidentitylink);

    /**
     * Finds a FgActHiIdentitylink by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_IDENTITYLINK WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiIdentitylink.class)
    public Optional<FgActHiIdentitylink> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_IDENTITYLINK")
    @RegisterBeanMapper(FgActHiIdentitylink.class)
    public List<FgActHiIdentitylink> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_IDENTITYLINK ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiIdentitylink.class)
    public List<FgActHiIdentitylink> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiIdentitylink and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_IDENTITYLINK SET TIMESTAMP_ = :timestamp, TYPE_ = :type, USER_ID_ = :userId, GROUP_ID_ = :groupId, TASK_ID_ = :taskId, PROC_DEF_ID_ = :procDefId, OPERATION_TYPE_ = :operationType, ASSIGNER_ID_ = :assignerId, PROC_DEF_KEY_ = :procDefKey, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActHiIdentitylink fgacthiidentitylink);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_IDENTITYLINK WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_IDENTITYLINK")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiIdentitylink entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_IDENTITYLINK (ID_, TIMESTAMP_, TYPE_, USER_ID_, GROUP_ID_, TASK_ID_, PROC_DEF_ID_, OPERATION_TYPE_, ASSIGNER_ID_, PROC_DEF_KEY_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :timestamp, :type, :userId, :groupId, :taskId, :procDefId, :operationType, :assignerId, :procDefKey, :tenantId, :rootProcInstId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActHiIdentitylink> fgacthiidentitylinks);

    /**
     * Bulk update multiple FgActHiIdentitylink entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_IDENTITYLINK SET TIMESTAMP_ = :timestamp, TYPE_ = :type, USER_ID_ = :userId, GROUP_ID_ = :groupId, TASK_ID_ = :taskId, PROC_DEF_ID_ = :procDefId, OPERATION_TYPE_ = :operationType, ASSIGNER_ID_ = :assignerId, PROC_DEF_KEY_ = :procDefKey, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiIdentitylink> fgacthiidentitylinks);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_IDENTITYLINK WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_IDENTITYLINK WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiIdentitylink records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_IDENTITYLINK WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiIdentitylink.class)
    public List<FgActHiIdentitylink> findByIds(@BindList("ids") Collection<String> ids);
}
