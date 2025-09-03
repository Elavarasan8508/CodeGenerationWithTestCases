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
import com.bsit.codegeneration.entity.FgTempDataHolder;

public interface FgTempDataHolderDao {

    /**
     * Inserts a new FgTempDataHolder and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TEMP_DATA_HOLDER (REFERENCE_ID, TABLE_NAME) VALUES (:referenceId, :tableName)")
    public int insert(@Bind("referenceId") int referenceId, @Bind("tableName") String tableName);

    /**
     * Finds a FgTempDataHolder by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TEMP_DATA_HOLDER WHERE FG_TEMP_DATA_HOLDER_id = :id")
    @RegisterBeanMapper(FgTempDataHolder.class)
    public Optional<FgTempDataHolder> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TEMP_DATA_HOLDER")
    @RegisterBeanMapper(FgTempDataHolder.class)
    public List<FgTempDataHolder> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TEMP_DATA_HOLDER ORDER BY FG_TEMP_DATA_HOLDER_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTempDataHolder.class)
    public List<FgTempDataHolder> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTempDataHolder and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TEMP_DATA_HOLDER SET REFERENCE_ID = :referenceId, TABLE_NAME = :tableName WHERE FG_TEMP_DATA_HOLDER_id = :fgTempDataHolderId")
    public int update(@BindBean FgTempDataHolder fgtempdataholder);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TEMP_DATA_HOLDER WHERE FG_TEMP_DATA_HOLDER_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TEMP_DATA_HOLDER")
    public long countAll();

    /**
     * Bulk insert multiple FgTempDataHolder entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TEMP_DATA_HOLDER (REFERENCE_ID, TABLE_NAME) VALUES (:referenceId, :tableName)")
    public int[] bulkInsert(@BindBean List<FgTempDataHolder> fgtempdataholders);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TEMP_DATA_HOLDER (REFERENCE_ID, TABLE_NAME) VALUES (:referenceId, :tableName)")
    public int[] bulkInsertParams(@Bind("referenceId") List<Integer> referenceIds, @Bind("tableName") List<String> tableNames);

    /**
     * Bulk update multiple FgTempDataHolder entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TEMP_DATA_HOLDER SET REFERENCE_ID = :referenceId, TABLE_NAME = :tableName WHERE FG_TEMP_DATA_HOLDER_id = :fgTempDataHolderId")
    public int[] bulkUpdate(@BindBean List<FgTempDataHolder> fgtempdataholders);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TEMP_DATA_HOLDER SET REFERENCE_ID = :referenceId, TABLE_NAME = :tableName WHERE FG_TEMP_DATA_HOLDER_id = :fgTempDataHolderId")
    public int[] bulkUpdateParams(@Bind("referenceId") List<Integer> referenceIds, @Bind("tableName") List<String> tableNames, @Bind("fgTempDataHolderId") List<Integer> fgTempDataHolderIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TEMP_DATA_HOLDER WHERE FG_TEMP_DATA_HOLDER_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TEMP_DATA_HOLDER WHERE FG_TEMP_DATA_HOLDER_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgTempDataHolder records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TEMP_DATA_HOLDER WHERE FG_TEMP_DATA_HOLDER_id IN (<ids>)")
    @RegisterBeanMapper(FgTempDataHolder.class)
    public List<FgTempDataHolder> findByIds(@BindList("ids") Collection<Integer> ids);
}
