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
import com.bsit.codegeneration.entity.IntGroupToMessage;

public interface IntGroupToMessageDao {

    /**
     * Inserts a new IntGroupToMessage and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO INT_GROUP_TO_MESSAGE (GROUP_KEY, MESSAGE_ID, REGION) VALUES (:groupKey, :messageId, :region)")
    public int insert(@Bind("groupKey") String groupKey, @Bind("messageId") int messageId, @Bind("region") String region);

    /**
     * Finds a IntGroupToMessage by its ID.
     */
    @SqlQuery("SELECT * FROM INT_GROUP_TO_MESSAGE WHERE MESSAGE_ID = :id")
    @RegisterBeanMapper(IntGroupToMessage.class)
    public Optional<IntGroupToMessage> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM INT_GROUP_TO_MESSAGE")
    @RegisterBeanMapper(IntGroupToMessage.class)
    public List<IntGroupToMessage> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM INT_GROUP_TO_MESSAGE ORDER BY MESSAGE_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(IntGroupToMessage.class)
    public List<IntGroupToMessage> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM INT_GROUP_TO_MESSAGE WHERE MESSAGE_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM INT_GROUP_TO_MESSAGE")
    public long countAll();

    /**
     * Bulk insert multiple IntGroupToMessage entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO INT_GROUP_TO_MESSAGE (GROUP_KEY, MESSAGE_ID, REGION) VALUES (:groupKey, :messageId, :region)")
    public int[] bulkInsert(@BindBean List<IntGroupToMessage> intgrouptomessages);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO INT_GROUP_TO_MESSAGE (GROUP_KEY, MESSAGE_ID, REGION) VALUES (:groupKey, :messageId, :region)")
    public int[] bulkInsertParams(@Bind("groupKey") List<String> groupKeys, @Bind("messageId") List<Integer> messageIds, @Bind("region") List<String> regions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM INT_GROUP_TO_MESSAGE WHERE MESSAGE_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM INT_GROUP_TO_MESSAGE WHERE MESSAGE_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple IntGroupToMessage records by their IDs.
     */
    @SqlQuery("SELECT * FROM INT_GROUP_TO_MESSAGE WHERE MESSAGE_ID IN (<ids>)")
    @RegisterBeanMapper(IntGroupToMessage.class)
    public List<IntGroupToMessage> findByIds(@BindList("ids") Collection<String> ids);
}
