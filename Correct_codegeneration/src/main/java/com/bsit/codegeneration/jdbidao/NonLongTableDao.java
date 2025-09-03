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
import com.bsit.codegeneration.entity.NonLongTable;

public interface NonLongTableDao {

    /**
     * Inserts a new NonLongTable and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO NON_LONG_TABLE (ID, PRICE) VALUES (:id, :price)")
    public int insert(@Bind("id") java.math.BigDecimal id, @Bind("price") String price);

    /**
     * Finds a NonLongTable by its ID.
     */
    @SqlQuery("SELECT * FROM NON_LONG_TABLE WHERE NON_LONG_TABLE_id = :id")
    @RegisterBeanMapper(NonLongTable.class)
    public Optional<NonLongTable> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM NON_LONG_TABLE")
    @RegisterBeanMapper(NonLongTable.class)
    public List<NonLongTable> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM NON_LONG_TABLE ORDER BY NON_LONG_TABLE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(NonLongTable.class)
    public List<NonLongTable> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a NonLongTable and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE NON_LONG_TABLE SET ID = :id, PRICE = :price WHERE NON_LONG_TABLE_id = :nonLongTableId")
    public int update(@BindBean NonLongTable nonlongtable);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM NON_LONG_TABLE WHERE NON_LONG_TABLE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM NON_LONG_TABLE")
    public long countAll();

    /**
     * Bulk insert multiple NonLongTable entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO NON_LONG_TABLE (ID, PRICE) VALUES (:id, :price)")
    public int[] bulkInsert(@BindBean List<NonLongTable> nonlongtables);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO NON_LONG_TABLE (ID, PRICE) VALUES (:id, :price)")
    public int[] bulkInsertParams(@Bind("id") List<java.math.BigDecimal> ids, @Bind("price") List<String> prices);

    /**
     * Bulk update multiple NonLongTable entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE NON_LONG_TABLE SET ID = :id, PRICE = :price WHERE NON_LONG_TABLE_id = :nonLongTableId")
    public int[] bulkUpdate(@BindBean List<NonLongTable> nonlongtables);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE NON_LONG_TABLE SET ID = :id, PRICE = :price WHERE NON_LONG_TABLE_id = :nonLongTableId")
    public int[] bulkUpdateParams(@Bind("id") List<java.math.BigDecimal> ids, @Bind("price") List<String> prices, @Bind("nonLongTableId") List<Integer> nonLongTableIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM NON_LONG_TABLE WHERE NON_LONG_TABLE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM NON_LONG_TABLE WHERE NON_LONG_TABLE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple NonLongTable records by their IDs.
     */
    @SqlQuery("SELECT * FROM NON_LONG_TABLE WHERE NON_LONG_TABLE_id IN (<ids>)")
    @RegisterBeanMapper(NonLongTable.class)
    public List<NonLongTable> findByIds(@BindList("ids") Collection<Integer> ids);
}
