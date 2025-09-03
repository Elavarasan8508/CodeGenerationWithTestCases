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
import com.bsit.codegeneration.entity.SampleView;

public interface SampleViewDao {

    /**
     * Inserts a new SampleView and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SAMPLE_VIEW (NAME, AGE) VALUES (:name, :age)")
    public int insert(@Bind("name") String name, @Bind("age") String age);

    /**
     * Finds a SampleView by its ID.
     */
    @SqlQuery("SELECT * FROM SAMPLE_VIEW WHERE SAMPLE_VIEW_id = :id")
    @RegisterBeanMapper(SampleView.class)
    public Optional<SampleView> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SAMPLE_VIEW")
    @RegisterBeanMapper(SampleView.class)
    public List<SampleView> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SAMPLE_VIEW ORDER BY SAMPLE_VIEW_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(SampleView.class)
    public List<SampleView> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a SampleView and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SAMPLE_VIEW SET NAME = :name, AGE = :age WHERE SAMPLE_VIEW_id = :sampleViewId")
    public int update(@BindBean SampleView sampleview);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SAMPLE_VIEW WHERE SAMPLE_VIEW_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SAMPLE_VIEW")
    public long countAll();

    /**
     * Bulk insert multiple SampleView entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SAMPLE_VIEW (NAME, AGE) VALUES (:name, :age)")
    public int[] bulkInsert(@BindBean List<SampleView> sampleviews);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SAMPLE_VIEW (NAME, AGE) VALUES (:name, :age)")
    public int[] bulkInsertParams(@Bind("name") List<String> names, @Bind("age") List<String> ages);

    /**
     * Bulk update multiple SampleView entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SAMPLE_VIEW SET NAME = :name, AGE = :age WHERE SAMPLE_VIEW_id = :sampleViewId")
    public int[] bulkUpdate(@BindBean List<SampleView> sampleviews);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SAMPLE_VIEW SET NAME = :name, AGE = :age WHERE SAMPLE_VIEW_id = :sampleViewId")
    public int[] bulkUpdateParams(@Bind("name") List<String> names, @Bind("age") List<String> ages, @Bind("sampleViewId") List<Integer> sampleViewIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SAMPLE_VIEW WHERE SAMPLE_VIEW_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SAMPLE_VIEW WHERE SAMPLE_VIEW_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple SampleView records by their IDs.
     */
    @SqlQuery("SELECT * FROM SAMPLE_VIEW WHERE SAMPLE_VIEW_id IN (<ids>)")
    @RegisterBeanMapper(SampleView.class)
    public List<SampleView> findByIds(@BindList("ids") Collection<Integer> ids);
}
