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
import com.bsit.codegeneration.entity.FgGroupPermission;

public interface FgGroupPermissionDao {

    /**
     * Inserts a new FgGroupPermission and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_GROUP_PERMISSION (ID, PERMISSION_ID, GROUP_ID, GROUP_VERSION_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :permissionId, :groupId, :groupVersionId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgGroupPermission fggrouppermission);

    /**
     * Finds a FgGroupPermission by its ID.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_PERMISSION WHERE FG_GROUP_PERMISSION_id = :id")
    @RegisterBeanMapper(FgGroupPermission.class)
    public Optional<FgGroupPermission> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_PERMISSION")
    @RegisterBeanMapper(FgGroupPermission.class)
    public List<FgGroupPermission> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_PERMISSION ORDER BY FG_GROUP_PERMISSION_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgGroupPermission.class)
    public List<FgGroupPermission> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgGroupPermission and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_GROUP_PERMISSION SET ID = :id, PERMISSION_ID = :permissionId, GROUP_ID = :groupId, GROUP_VERSION_ID = :groupVersionId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_GROUP_PERMISSION_id = :fgGroupPermissionId")
    public int update(@BindBean FgGroupPermission fggrouppermission);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_GROUP_PERMISSION WHERE FG_GROUP_PERMISSION_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_GROUP_PERMISSION")
    public long countAll();

    /**
     * Bulk insert multiple FgGroupPermission entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_GROUP_PERMISSION (ID, PERMISSION_ID, GROUP_ID, GROUP_VERSION_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :permissionId, :groupId, :groupVersionId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgGroupPermission> fggrouppermissions);

    /**
     * Bulk update multiple FgGroupPermission entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_GROUP_PERMISSION SET ID = :id, PERMISSION_ID = :permissionId, GROUP_ID = :groupId, GROUP_VERSION_ID = :groupVersionId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_GROUP_PERMISSION_id = :fgGroupPermissionId")
    public int[] bulkUpdate(@BindBean List<FgGroupPermission> fggrouppermissions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_GROUP_PERMISSION WHERE FG_GROUP_PERMISSION_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_GROUP_PERMISSION WHERE FG_GROUP_PERMISSION_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgGroupPermission records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_PERMISSION WHERE FG_GROUP_PERMISSION_id IN (<ids>)")
    @RegisterBeanMapper(FgGroupPermission.class)
    public List<FgGroupPermission> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all FgGroupPermission records by permissionId.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_PERMISSION WHERE PERMISSION_ID = :permissionId")
    @RegisterBeanMapper(FgGroupPermission.class)
    public List<FgGroupPermission> findByPermissionId(@Bind("permissionId") int permissionId);

    /**
     * Finds all FgGroupPermission records by groupId.
     */
    @SqlQuery("SELECT * FROM FG_GROUP_PERMISSION WHERE GROUP_ID = :groupId")
    @RegisterBeanMapper(FgGroupPermission.class)
    public List<FgGroupPermission> findByGroupId(@Bind("groupId") int groupId);
}
