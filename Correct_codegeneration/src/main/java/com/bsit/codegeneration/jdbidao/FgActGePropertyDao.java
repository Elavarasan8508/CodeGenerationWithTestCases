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
import com.bsit.codegeneration.entity.FgActGeProperty;

public interface FgActGePropertyDao {

    /**
     * Inserts a new FgActGeProperty and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_GE_PROPERTY (NAME_, VALUE_, REV_) VALUES (:name, :value, :rev)")
    public int insert(@Bind("name") String name, @Bind("value") String value, @Bind("rev") java.math.BigDecimal rev);

    /**
     * Finds a FgActGeProperty by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_PROPERTY WHERE NAME_ = :id")
    @RegisterBeanMapper(FgActGeProperty.class)
    public Optional<FgActGeProperty> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_PROPERTY")
    @RegisterBeanMapper(FgActGeProperty.class)
    public List<FgActGeProperty> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_PROPERTY ORDER BY NAME_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActGeProperty.class)
    public List<FgActGeProperty> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActGeProperty and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_GE_PROPERTY SET VALUE_ = :value, REV_ = :rev WHERE NAME_ = :name")
    public int update(@BindBean FgActGeProperty fgactgeproperty);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_GE_PROPERTY WHERE NAME_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_GE_PROPERTY")
    public long countAll();

    /**
     * Bulk insert multiple FgActGeProperty entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_GE_PROPERTY (NAME_, VALUE_, REV_) VALUES (:name, :value, :rev)")
    public int[] bulkInsert(@BindBean List<FgActGeProperty> fgactgepropertys);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_GE_PROPERTY (NAME_, VALUE_, REV_) VALUES (:name, :value, :rev)")
    public int[] bulkInsertParams(@Bind("name") List<String> names, @Bind("value") List<String> values, @Bind("rev") List<java.math.BigDecimal> revs);

    /**
     * Bulk update multiple FgActGeProperty entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_GE_PROPERTY SET VALUE_ = :value, REV_ = :rev WHERE NAME_ = :name")
    public int[] bulkUpdate(@BindBean List<FgActGeProperty> fgactgepropertys);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_GE_PROPERTY SET VALUE_ = :value, REV_ = :rev WHERE NAME_ = :name")
    public int[] bulkUpdateParams(@Bind("value") List<String> values, @Bind("rev") List<java.math.BigDecimal> revs, @Bind("name") List<String> names);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_GE_PROPERTY WHERE NAME_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_GE_PROPERTY WHERE NAME_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActGeProperty records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_GE_PROPERTY WHERE NAME_ IN (<ids>)")
    @RegisterBeanMapper(FgActGeProperty.class)
    public List<FgActGeProperty> findByIds(@BindList("ids") Collection<String> ids);
}
