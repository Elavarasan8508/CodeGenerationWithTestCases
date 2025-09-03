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
import com.bsit.codegeneration.entity.FgApplicationPropertiesDemo;

public interface FgApplicationPropertiesDemoDao {

    /**
     * Inserts a new FgApplicationPropertiesDemo and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_APPLICATION_PROPERTIES_DEMO (KEY, VALUE) VALUES (:key, :value)")
    public int insert(@Bind("key") String key, @Bind("value") String value);

    /**
     * Finds a FgApplicationPropertiesDemo by its ID.
     */
    @SqlQuery("SELECT * FROM FG_APPLICATION_PROPERTIES_DEMO WHERE FG_APPLICATION_PROPERTIES_DEMO_id = :id")
    @RegisterBeanMapper(FgApplicationPropertiesDemo.class)
    public Optional<FgApplicationPropertiesDemo> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_APPLICATION_PROPERTIES_DEMO")
    @RegisterBeanMapper(FgApplicationPropertiesDemo.class)
    public List<FgApplicationPropertiesDemo> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_APPLICATION_PROPERTIES_DEMO ORDER BY FG_APPLICATION_PROPERTIES_DEMO_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgApplicationPropertiesDemo.class)
    public List<FgApplicationPropertiesDemo> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgApplicationPropertiesDemo and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_APPLICATION_PROPERTIES_DEMO SET KEY = :key, VALUE = :value WHERE FG_APPLICATION_PROPERTIES_DEMO_id = :fgApplicationPropertiesDemoId")
    public int update(@BindBean FgApplicationPropertiesDemo fgapplicationpropertiesdemo);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_APPLICATION_PROPERTIES_DEMO WHERE FG_APPLICATION_PROPERTIES_DEMO_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_APPLICATION_PROPERTIES_DEMO")
    public long countAll();

    /**
     * Bulk insert multiple FgApplicationPropertiesDemo entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_APPLICATION_PROPERTIES_DEMO (KEY, VALUE) VALUES (:key, :value)")
    public int[] bulkInsert(@BindBean List<FgApplicationPropertiesDemo> fgapplicationpropertiesdemos);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_APPLICATION_PROPERTIES_DEMO (KEY, VALUE) VALUES (:key, :value)")
    public int[] bulkInsertParams(@Bind("key") List<String> keys, @Bind("value") List<String> values);

    /**
     * Bulk update multiple FgApplicationPropertiesDemo entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_APPLICATION_PROPERTIES_DEMO SET KEY = :key, VALUE = :value WHERE FG_APPLICATION_PROPERTIES_DEMO_id = :fgApplicationPropertiesDemoId")
    public int[] bulkUpdate(@BindBean List<FgApplicationPropertiesDemo> fgapplicationpropertiesdemos);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_APPLICATION_PROPERTIES_DEMO SET KEY = :key, VALUE = :value WHERE FG_APPLICATION_PROPERTIES_DEMO_id = :fgApplicationPropertiesDemoId")
    public int[] bulkUpdateParams(@Bind("key") List<String> keys, @Bind("value") List<String> values, @Bind("fgApplicationPropertiesDemoId") List<Integer> fgApplicationPropertiesDemoIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_APPLICATION_PROPERTIES_DEMO WHERE FG_APPLICATION_PROPERTIES_DEMO_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_APPLICATION_PROPERTIES_DEMO WHERE FG_APPLICATION_PROPERTIES_DEMO_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgApplicationPropertiesDemo records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_APPLICATION_PROPERTIES_DEMO WHERE FG_APPLICATION_PROPERTIES_DEMO_id IN (<ids>)")
    @RegisterBeanMapper(FgApplicationPropertiesDemo.class)
    public List<FgApplicationPropertiesDemo> findByIds(@BindList("ids") Collection<Integer> ids);
}
