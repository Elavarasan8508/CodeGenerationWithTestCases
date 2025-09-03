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
import com.bsit.codegeneration.entity.FgRolePermission;

public interface FgRolePermissionDao {

    /**
     * Inserts a new FgRolePermission and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ROLE_PERMISSION (ID, PERMISSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :permissionId, :roleId, :roleVersionId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgRolePermission fgrolepermission);

    /**
     * Finds a FgRolePermission by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ROLE_PERMISSION WHERE ID = :id")
    @RegisterBeanMapper(FgRolePermission.class)
    public Optional<FgRolePermission> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ROLE_PERMISSION")
    @RegisterBeanMapper(FgRolePermission.class)
    public List<FgRolePermission> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ROLE_PERMISSION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgRolePermission.class)
    public List<FgRolePermission> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgRolePermission and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ROLE_PERMISSION SET PERMISSION_ID = :permissionId, ROLE_ID = :roleId, ROLE_VERSION_ID = :roleVersionId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgRolePermission fgrolepermission);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ROLE_PERMISSION WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ROLE_PERMISSION")
    public long countAll();

    /**
     * Bulk insert multiple FgRolePermission entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ROLE_PERMISSION (ID, PERMISSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :permissionId, :roleId, :roleVersionId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgRolePermission> fgrolepermissions);

    /**
     * Bulk update multiple FgRolePermission entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ROLE_PERMISSION SET PERMISSION_ID = :permissionId, ROLE_ID = :roleId, ROLE_VERSION_ID = :roleVersionId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgRolePermission> fgrolepermissions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ROLE_PERMISSION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ROLE_PERMISSION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgRolePermission records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ROLE_PERMISSION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgRolePermission.class)
    public List<FgRolePermission> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgRolePermission records by permissionId.
     */
    @SqlQuery("SELECT * FROM FG_ROLE_PERMISSION WHERE PERMISSION_ID = :permissionId")
    @RegisterBeanMapper(FgRolePermission.class)
    public List<FgRolePermission> findByPermissionId(@Bind("permissionId") int permissionId);
}
