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
import com.bsit.codegeneration.entity.FgActGeSchemaLog;

public interface FgActGeSchemaLogDao {

    /**
     * Inserts a new FgActGeSchemaLog and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_GE_SCHEMA_LOG (ID_, TIMESTAMP_, VERSION_) VALUES (:id, :timestamp, :version)")
    public int insert(@Bind("id") String id, @Bind("timestamp") String timestamp, @Bind("version") String version);

    /**
     * Finds a FgActGeSchemaLog by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_SCHEMA_LOG WHERE ID_ = :id")
    @RegisterBeanMapper(FgActGeSchemaLog.class)
    public Optional<FgActGeSchemaLog> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_SCHEMA_LOG")
    @RegisterBeanMapper(FgActGeSchemaLog.class)
    public List<FgActGeSchemaLog> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_SCHEMA_LOG ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActGeSchemaLog.class)
    public List<FgActGeSchemaLog> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActGeSchemaLog and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_GE_SCHEMA_LOG SET TIMESTAMP_ = :timestamp, VERSION_ = :version WHERE ID_ = :id")
    public int update(@BindBean FgActGeSchemaLog fgactgeschemalog);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_GE_SCHEMA_LOG WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_GE_SCHEMA_LOG")
    public long countAll();

    /**
     * Bulk insert multiple FgActGeSchemaLog entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_GE_SCHEMA_LOG (ID_, TIMESTAMP_, VERSION_) VALUES (:id, :timestamp, :version)")
    public int[] bulkInsert(@BindBean List<FgActGeSchemaLog> fgactgeschemalogs);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_GE_SCHEMA_LOG (ID_, TIMESTAMP_, VERSION_) VALUES (:id, :timestamp, :version)")
    public int[] bulkInsertParams(@Bind("id") List<String> ids, @Bind("timestamp") List<String> timestamps, @Bind("version") List<String> versions);

    /**
     * Bulk update multiple FgActGeSchemaLog entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_GE_SCHEMA_LOG SET TIMESTAMP_ = :timestamp, VERSION_ = :version WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActGeSchemaLog> fgactgeschemalogs);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_GE_SCHEMA_LOG SET TIMESTAMP_ = :timestamp, VERSION_ = :version WHERE ID_ = :id")
    public int[] bulkUpdateParams(@Bind("timestamp") List<String> timestamps, @Bind("version") List<String> versions, @Bind("id") List<String> ids);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_GE_SCHEMA_LOG WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_GE_SCHEMA_LOG WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActGeSchemaLog records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_SCHEMA_LOG WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActGeSchemaLog.class)
    public List<FgActGeSchemaLog> findByIds(@BindList("ids") Collection<String> ids);
}
