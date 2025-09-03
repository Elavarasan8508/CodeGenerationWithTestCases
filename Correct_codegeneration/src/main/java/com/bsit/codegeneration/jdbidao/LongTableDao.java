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
import com.bsit.codegeneration.entity.LongTable;

public interface LongTableDao {

    /**
     * Inserts a new LongTable and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO LONG_TABLE (ID, LONG_COLUMN) VALUES (:id, :longColumn)")
    public int insert(@Bind("id") java.math.BigDecimal id, @Bind("longColumn") String longColumn);

    /**
     * Finds a LongTable by its ID.
     */
    @SqlQuery("SELECT * FROM LONG_TABLE WHERE LONG_TABLE_id = :id")
    @RegisterBeanMapper(LongTable.class)
    public Optional<LongTable> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM LONG_TABLE")
    @RegisterBeanMapper(LongTable.class)
    public List<LongTable> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM LONG_TABLE ORDER BY LONG_TABLE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(LongTable.class)
    public List<LongTable> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a LongTable and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE LONG_TABLE SET ID = :id, LONG_COLUMN = :longColumn WHERE LONG_TABLE_id = :longTableId")
    public int update(@BindBean LongTable longtable);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM LONG_TABLE WHERE LONG_TABLE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM LONG_TABLE")
    public long countAll();

    /**
     * Bulk insert multiple LongTable entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LONG_TABLE (ID, LONG_COLUMN) VALUES (:id, :longColumn)")
    public int[] bulkInsert(@BindBean List<LongTable> longtables);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO LONG_TABLE (ID, LONG_COLUMN) VALUES (:id, :longColumn)")
    public int[] bulkInsertParams(@Bind("id") List<java.math.BigDecimal> ids, @Bind("longColumn") List<String> longColumns);

    /**
     * Bulk update multiple LongTable entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LONG_TABLE SET ID = :id, LONG_COLUMN = :longColumn WHERE LONG_TABLE_id = :longTableId")
    public int[] bulkUpdate(@BindBean List<LongTable> longtables);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE LONG_TABLE SET ID = :id, LONG_COLUMN = :longColumn WHERE LONG_TABLE_id = :longTableId")
    public int[] bulkUpdateParams(@Bind("id") List<java.math.BigDecimal> ids, @Bind("longColumn") List<String> longColumns, @Bind("longTableId") List<Integer> longTableIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM LONG_TABLE WHERE LONG_TABLE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM LONG_TABLE WHERE LONG_TABLE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple LongTable records by their IDs.
     */
    @SqlQuery("SELECT * FROM LONG_TABLE WHERE LONG_TABLE_id IN (<ids>)")
    @RegisterBeanMapper(LongTable.class)
    public List<LongTable> findByIds(@BindList("ids") Collection<Integer> ids);
}
