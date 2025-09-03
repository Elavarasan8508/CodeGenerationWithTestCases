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
import com.bsit.codegeneration.entity.FgAuditItem;

public interface FgAuditItemDao {

    /**
     * Inserts a new FgAuditItem and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_AUDIT_ITEM (UUID, AUDIT_MASTER_ID, OUTPUT_CONTEXT, ERROR_CONTEXT) VALUES (:uuid, :auditMasterId, :outputContext, :errorContext)")
    public int insert(@BindBean FgAuditItem fgaudititem);

    /**
     * Finds a FgAuditItem by its ID.
     */
    @SqlQuery("SELECT * FROM FG_AUDIT_ITEM WHERE UUID = :id")
    @RegisterBeanMapper(FgAuditItem.class)
    public Optional<FgAuditItem> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_AUDIT_ITEM")
    @RegisterBeanMapper(FgAuditItem.class)
    public List<FgAuditItem> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_AUDIT_ITEM ORDER BY UUID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAuditItem.class)
    public List<FgAuditItem> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAuditItem and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_AUDIT_ITEM SET AUDIT_MASTER_ID = :auditMasterId, OUTPUT_CONTEXT = :outputContext, ERROR_CONTEXT = :errorContext WHERE UUID = :uuid")
    public int update(@BindBean FgAuditItem fgaudititem);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AUDIT_ITEM WHERE UUID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_AUDIT_ITEM")
    public long countAll();

    /**
     * Bulk insert multiple FgAuditItem entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_AUDIT_ITEM (UUID, AUDIT_MASTER_ID, OUTPUT_CONTEXT, ERROR_CONTEXT) VALUES (:uuid, :auditMasterId, :outputContext, :errorContext)")
    public int[] bulkInsert(@BindBean List<FgAuditItem> fgaudititems);

    /**
     * Bulk update multiple FgAuditItem entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_AUDIT_ITEM SET AUDIT_MASTER_ID = :auditMasterId, OUTPUT_CONTEXT = :outputContext, ERROR_CONTEXT = :errorContext WHERE UUID = :uuid")
    public int[] bulkUpdate(@BindBean List<FgAuditItem> fgaudititems);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_AUDIT_ITEM SET AUDIT_MASTER_ID = :auditMasterId, OUTPUT_CONTEXT = :outputContext, ERROR_CONTEXT = :errorContext WHERE UUID = :uuid")
    public int[] bulkUpdateParams(@Bind("auditMasterId") List<Integer> auditMasterIds, @Bind("outputContext") List<String> outputContexts, @Bind("errorContext") List<String> errorContexts, @Bind("uuid") List<String> uuids);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AUDIT_ITEM WHERE UUID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_AUDIT_ITEM WHERE UUID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgAuditItem records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_AUDIT_ITEM WHERE UUID IN (<ids>)")
    @RegisterBeanMapper(FgAuditItem.class)
    public List<FgAuditItem> findByIds(@BindList("ids") Collection<String> ids);

    /**
     * Finds all FgAuditItem records by auditMasterId.
     */
    @SqlQuery("SELECT * FROM FG_AUDIT_ITEM WHERE AUDIT_MASTER_ID = :auditMasterId")
    @RegisterBeanMapper(FgAuditItem.class)
    public List<FgAuditItem> findByAuditMasterId(@Bind("auditMasterId") int auditMasterId);
}
