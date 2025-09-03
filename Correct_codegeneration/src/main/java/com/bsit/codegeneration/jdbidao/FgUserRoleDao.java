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
import com.bsit.codegeneration.entity.FgUserRole;

public interface FgUserRoleDao {

    /**
     * Inserts a new FgUserRole and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_USER_ROLE (ID, ROLE_ID, ROLE_VERSION_ID, USER_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :roleId, :roleVersionId, :userId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgUserRole fguserrole);

    /**
     * Finds a FgUserRole by its ID.
     */
    @SqlQuery("SELECT * FROM FG_USER_ROLE WHERE ID = :id")
    @RegisterBeanMapper(FgUserRole.class)
    public Optional<FgUserRole> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_USER_ROLE")
    @RegisterBeanMapper(FgUserRole.class)
    public List<FgUserRole> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_USER_ROLE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgUserRole.class)
    public List<FgUserRole> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgUserRole and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_USER_ROLE SET ROLE_ID = :roleId, ROLE_VERSION_ID = :roleVersionId, USER_ID = :userId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgUserRole fguserrole);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_USER_ROLE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_USER_ROLE")
    public long countAll();

    /**
     * Bulk insert multiple FgUserRole entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_USER_ROLE (ID, ROLE_ID, ROLE_VERSION_ID, USER_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :roleId, :roleVersionId, :userId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgUserRole> fguserroles);

    /**
     * Bulk update multiple FgUserRole entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_USER_ROLE SET ROLE_ID = :roleId, ROLE_VERSION_ID = :roleVersionId, USER_ID = :userId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgUserRole> fguserroles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_USER_ROLE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_USER_ROLE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgUserRole records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_USER_ROLE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgUserRole.class)
    public List<FgUserRole> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgUserRole records by userId.
     */
    @SqlQuery("SELECT * FROM FG_USER_ROLE WHERE USER_ID = :userId")
    @RegisterBeanMapper(FgUserRole.class)
    public List<FgUserRole> findByUserId(@Bind("userId") int userId);
}
