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
import com.bsit.codegeneration.entity.TestTable;

public interface TestTableDao {

    /**
     * Inserts a new TestTable and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO TEST_TABLE (ID, LONG_DATA) VALUES (:id, :longData)")
    public int insert(@Bind("id") java.math.BigDecimal id, @Bind("longData") String longData);

    /**
     * Finds a TestTable by its ID.
     */
    @SqlQuery("SELECT * FROM TEST_TABLE WHERE ID = :id")
    @RegisterBeanMapper(TestTable.class)
    public Optional<TestTable> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM TEST_TABLE")
    @RegisterBeanMapper(TestTable.class)
    public List<TestTable> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM TEST_TABLE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(TestTable.class)
    public List<TestTable> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a TestTable and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE TEST_TABLE SET LONG_DATA = :longData WHERE ID = :id")
    public int update(@BindBean TestTable testtable);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM TEST_TABLE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM TEST_TABLE")
    public long countAll();

    /**
     * Bulk insert multiple TestTable entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO TEST_TABLE (ID, LONG_DATA) VALUES (:id, :longData)")
    public int[] bulkInsert(@BindBean List<TestTable> testtables);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO TEST_TABLE (ID, LONG_DATA) VALUES (:id, :longData)")
    public int[] bulkInsertParams(@Bind("id") List<java.math.BigDecimal> ids, @Bind("longData") List<String> longDatas);

    /**
     * Bulk update multiple TestTable entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE TEST_TABLE SET LONG_DATA = :longData WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<TestTable> testtables);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE TEST_TABLE SET LONG_DATA = :longData WHERE ID = :id")
    public int[] bulkUpdateParams(@Bind("longData") List<String> longDatas, @Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM TEST_TABLE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM TEST_TABLE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple TestTable records by their IDs.
     */
    @SqlQuery("SELECT * FROM TEST_TABLE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(TestTable.class)
    public List<TestTable> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
