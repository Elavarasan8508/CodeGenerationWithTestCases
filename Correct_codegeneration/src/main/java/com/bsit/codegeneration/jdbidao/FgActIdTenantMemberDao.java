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
import com.bsit.codegeneration.entity.FgActIdTenantMember;

public interface FgActIdTenantMemberDao {

    /**
     * Inserts a new FgActIdTenantMember and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_ID_TENANT_MEMBER (ID_, TENANT_ID_, USER_ID_, GROUP_ID_) VALUES (:id, :tenantId, :userId, :groupId)")
    public int insert(@BindBean FgActIdTenantMember fgactidtenantmember);

    /**
     * Finds a FgActIdTenantMember by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT_MEMBER WHERE ID_ = :id")
    @RegisterBeanMapper(FgActIdTenantMember.class)
    public Optional<FgActIdTenantMember> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT_MEMBER")
    @RegisterBeanMapper(FgActIdTenantMember.class)
    public List<FgActIdTenantMember> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT_MEMBER ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActIdTenantMember.class)
    public List<FgActIdTenantMember> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActIdTenantMember and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_ID_TENANT_MEMBER SET TENANT_ID_ = :tenantId, USER_ID_ = :userId, GROUP_ID_ = :groupId WHERE ID_ = :id")
    public int update(@BindBean FgActIdTenantMember fgactidtenantmember);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_TENANT_MEMBER WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_ID_TENANT_MEMBER")
    public long countAll();

    /**
     * Bulk insert multiple FgActIdTenantMember entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_ID_TENANT_MEMBER (ID_, TENANT_ID_, USER_ID_, GROUP_ID_) VALUES (:id, :tenantId, :userId, :groupId)")
    public int[] bulkInsert(@BindBean List<FgActIdTenantMember> fgactidtenantmembers);

    /**
     * Bulk update multiple FgActIdTenantMember entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_ID_TENANT_MEMBER SET TENANT_ID_ = :tenantId, USER_ID_ = :userId, GROUP_ID_ = :groupId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActIdTenantMember> fgactidtenantmembers);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_ID_TENANT_MEMBER SET TENANT_ID_ = :tenantId, USER_ID_ = :userId, GROUP_ID_ = :groupId WHERE ID_ = :id")
    public int[] bulkUpdateParams(@Bind("tenantId") List<Integer> tenantIds, @Bind("userId") List<Integer> userIds, @Bind("groupId") List<Integer> groupIds, @Bind("id") List<String> ids);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_ID_TENANT_MEMBER WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_ID_TENANT_MEMBER WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActIdTenantMember records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT_MEMBER WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActIdTenantMember.class)
    public List<FgActIdTenantMember> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgActIdTenantMember records by groupId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT_MEMBER WHERE GROUP_ID_ = :groupId")
    @RegisterBeanMapper(FgActIdTenantMember.class)
    public List<FgActIdTenantMember> findByGroupId(@Bind("groupId") int groupId);

    /**
     * Finds all FgActIdTenantMember records by userId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT_MEMBER WHERE USER_ID_ = :userId")
    @RegisterBeanMapper(FgActIdTenantMember.class)
    public List<FgActIdTenantMember> findByUserId(@Bind("userId") int userId);

    /**
     * Finds all FgActIdTenantMember records by tenantId.
     */
    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT_MEMBER WHERE TENANT_ID_ = :tenantId")
    @RegisterBeanMapper(FgActIdTenantMember.class)
    public List<FgActIdTenantMember> findByTenantId(@Bind("tenantId") int tenantId);
}
