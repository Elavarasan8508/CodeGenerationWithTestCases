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
import com.bsit.codegeneration.entity.IntMessageGroup;

public interface IntMessageGroupDao {

    /**
     * Inserts a new IntMessageGroup and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO INT_MESSAGE_GROUP (GROUP_KEY, REGION, MARKED, COMPLETE, LAST_RELEASED_SEQUENCE) VALUES (:groupKey, :region, :marked, :complete, :lastReleasedSequence)")
    public int insert(@BindBean IntMessageGroup intmessagegroup);

    /**
     * Finds a IntMessageGroup by its ID.
     */
    @SqlQuery("SELECT * FROM INT_MESSAGE_GROUP WHERE GROUP_KEY = :id")
    @RegisterBeanMapper(IntMessageGroup.class)
    public Optional<IntMessageGroup> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM INT_MESSAGE_GROUP")
    @RegisterBeanMapper(IntMessageGroup.class)
    public List<IntMessageGroup> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM INT_MESSAGE_GROUP ORDER BY GROUP_KEY LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(IntMessageGroup.class)
    public List<IntMessageGroup> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a IntMessageGroup and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE INT_MESSAGE_GROUP SET MARKED = :marked, COMPLETE = :complete, LAST_RELEASED_SEQUENCE = :lastReleasedSequence WHERE GROUP_KEY = :groupKey")
    public int update(@BindBean IntMessageGroup intmessagegroup);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM INT_MESSAGE_GROUP WHERE GROUP_KEY = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM INT_MESSAGE_GROUP")
    public long countAll();

    /**
     * Bulk insert multiple IntMessageGroup entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO INT_MESSAGE_GROUP (GROUP_KEY, REGION, MARKED, COMPLETE, LAST_RELEASED_SEQUENCE) VALUES (:groupKey, :region, :marked, :complete, :lastReleasedSequence)")
    public int[] bulkInsert(@BindBean List<IntMessageGroup> intmessagegroups);

    /**
     * Bulk update multiple IntMessageGroup entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE INT_MESSAGE_GROUP SET MARKED = :marked, COMPLETE = :complete, LAST_RELEASED_SEQUENCE = :lastReleasedSequence WHERE GROUP_KEY = :groupKey")
    public int[] bulkUpdate(@BindBean List<IntMessageGroup> intmessagegroups);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE INT_MESSAGE_GROUP SET MARKED = :marked, COMPLETE = :complete, LAST_RELEASED_SEQUENCE = :lastReleasedSequence WHERE GROUP_KEY = :groupKey")
    public int[] bulkUpdateParams(@Bind("marked") List<java.math.BigDecimal> markeds, @Bind("complete") List<java.math.BigDecimal> completes, @Bind("lastReleasedSequence") List<java.math.BigDecimal> lastReleasedSequences, @Bind("groupKey") List<String> groupKeys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM INT_MESSAGE_GROUP WHERE GROUP_KEY IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM INT_MESSAGE_GROUP WHERE GROUP_KEY = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple IntMessageGroup records by their IDs.
     */
    @SqlQuery("SELECT * FROM INT_MESSAGE_GROUP WHERE GROUP_KEY IN (<ids>)")
    @RegisterBeanMapper(IntMessageGroup.class)
    public List<IntMessageGroup> findByIds(@BindList("ids") Collection<String> ids);
}
