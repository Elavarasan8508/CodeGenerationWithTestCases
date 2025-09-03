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
import com.bsit.codegeneration.entity.FgPermission;

public interface FgPermissionDao {

    /**
     * Inserts a new FgPermission and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PERMISSION (ID, CLASS_CODE, FIELD_CODE, TYPE_CODE, CATEGORY_CODE, SUB_TYPE_CODE, OPERATION_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :classCode, :fieldCode, :typeCode, :categoryCode, :subTypeCode, :operationCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgPermission fgpermission);

    /**
     * Finds a FgPermission by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PERMISSION WHERE ID = :id")
    @RegisterBeanMapper(FgPermission.class)
    public Optional<FgPermission> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PERMISSION")
    @RegisterBeanMapper(FgPermission.class)
    public List<FgPermission> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PERMISSION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPermission.class)
    public List<FgPermission> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPermission and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PERMISSION SET CLASS_CODE = :classCode, FIELD_CODE = :fieldCode, TYPE_CODE = :typeCode, CATEGORY_CODE = :categoryCode, SUB_TYPE_CODE = :subTypeCode, OPERATION_CODE = :operationCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgPermission fgpermission);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PERMISSION WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PERMISSION")
    public long countAll();

    /**
     * Bulk insert multiple FgPermission entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PERMISSION (ID, CLASS_CODE, FIELD_CODE, TYPE_CODE, CATEGORY_CODE, SUB_TYPE_CODE, OPERATION_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :classCode, :fieldCode, :typeCode, :categoryCode, :subTypeCode, :operationCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgPermission> fgpermissions);

    /**
     * Bulk update multiple FgPermission entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PERMISSION SET CLASS_CODE = :classCode, FIELD_CODE = :fieldCode, TYPE_CODE = :typeCode, CATEGORY_CODE = :categoryCode, SUB_TYPE_CODE = :subTypeCode, OPERATION_CODE = :operationCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPermission> fgpermissions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PERMISSION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PERMISSION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPermission records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PERMISSION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPermission.class)
    public List<FgPermission> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
