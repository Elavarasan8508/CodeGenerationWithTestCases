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
import com.bsit.codegeneration.entity.FgGroupRole;

public interface FgGroupRoleDao {

    /**
     * Inserts a new FgGroupRole and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_GROUP_ROLE (ID, GROUP_ID, GROUP_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :groupId, :groupVersionId, :roleId, :roleVersionId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgGroupRole fggrouprole);

    /**
     * Finds a FgGroupRole by its ID.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_ROLE WHERE ID = :id")
    @RegisterBeanMapper(FgGroupRole.class)
    public Optional<FgGroupRole> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_ROLE")
    @RegisterBeanMapper(FgGroupRole.class)
    public List<FgGroupRole> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_ROLE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgGroupRole.class)
    public List<FgGroupRole> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgGroupRole and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_GROUP_ROLE SET GROUP_ID = :groupId, GROUP_VERSION_ID = :groupVersionId, ROLE_ID = :roleId, ROLE_VERSION_ID = :roleVersionId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgGroupRole fggrouprole);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_GROUP_ROLE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_GROUP_ROLE")
    public long countAll();

    /**
     * Bulk insert multiple FgGroupRole entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_GROUP_ROLE (ID, GROUP_ID, GROUP_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :groupId, :groupVersionId, :roleId, :roleVersionId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgGroupRole> fggrouproles);

    /**
     * Bulk update multiple FgGroupRole entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_GROUP_ROLE SET GROUP_ID = :groupId, GROUP_VERSION_ID = :groupVersionId, ROLE_ID = :roleId, ROLE_VERSION_ID = :roleVersionId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgGroupRole> fggrouproles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_GROUP_ROLE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_GROUP_ROLE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgGroupRole records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_ROLE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgGroupRole.class)
    public List<FgGroupRole> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgGroupRole records by roleId.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_ROLE WHERE ROLE_ID = :roleId")
    @RegisterBeanMapper(FgGroupRole.class)
    public List<FgGroupRole> findByRoleId(@Bind("roleId") int roleId);

    /**
     * Finds all FgGroupRole records by roleVersionId.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_ROLE WHERE ROLE_VERSION_ID = :roleVersionId")
    @RegisterBeanMapper(FgGroupRole.class)
    public List<FgGroupRole> findByRoleVersionId(@Bind("roleVersionId") int roleVersionId);

    /**
     * Finds all FgGroupRole records by groupId.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_ROLE WHERE GROUP_ID = :groupId")
    @RegisterBeanMapper(FgGroupRole.class)
    public List<FgGroupRole> findByGroupId(@Bind("groupId") int groupId);
}
