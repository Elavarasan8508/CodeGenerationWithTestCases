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
import com.bsit.codegeneration.entity.IntChannelMessage;

public interface IntChannelMessageDao {

    /**
     * Inserts a new IntChannelMessage and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO INT_CHANNEL_MESSAGE (MESSAGE_ID, GROUP_KEY, MESSAGE_PRIORITY, MESSAGE_SEQUENCE, MESSAGE_BYTES, REGION) VALUES (:messageId, :groupKey, :messagePriority, :messageSequence, :messageBytes, :region)")
    public int insert(@BindBean IntChannelMessage intchannelmessage);

    /**
     * Finds a IntChannelMessage by its ID.
     */
    @SqlQuery("SELECT * FROM INT_CHANNEL_MESSAGE WHERE CREATED_DATE = :id")
    @RegisterBeanMapper(IntChannelMessage.class)
    public Optional<IntChannelMessage> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM INT_CHANNEL_MESSAGE")
    @RegisterBeanMapper(IntChannelMessage.class)
    public List<IntChannelMessage> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM INT_CHANNEL_MESSAGE ORDER BY CREATED_DATE LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(IntChannelMessage.class)
    public List<IntChannelMessage> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a IntChannelMessage and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE INT_CHANNEL_MESSAGE SET MESSAGE_ID = :messageId, MESSAGE_PRIORITY = :messagePriority, MESSAGE_BYTES = :messageBytes WHERE CREATED_DATE = :createdDate")
    public int update(@BindBean IntChannelMessage intchannelmessage);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM INT_CHANNEL_MESSAGE WHERE CREATED_DATE = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM INT_CHANNEL_MESSAGE")
    public long countAll();

    /**
     * Bulk insert multiple IntChannelMessage entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO INT_CHANNEL_MESSAGE (MESSAGE_ID, GROUP_KEY, MESSAGE_PRIORITY, MESSAGE_SEQUENCE, MESSAGE_BYTES, REGION) VALUES (:messageId, :groupKey, :messagePriority, :messageSequence, :messageBytes, :region)")
    public int[] bulkInsert(@BindBean List<IntChannelMessage> intchannelmessages);

    /**
     * Bulk update multiple IntChannelMessage entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE INT_CHANNEL_MESSAGE SET MESSAGE_ID = :messageId, MESSAGE_PRIORITY = :messagePriority, MESSAGE_BYTES = :messageBytes WHERE CREATED_DATE = :createdDate")
    public int[] bulkUpdate(@BindBean List<IntChannelMessage> intchannelmessages);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE INT_CHANNEL_MESSAGE SET MESSAGE_ID = :messageId, MESSAGE_PRIORITY = :messagePriority, MESSAGE_BYTES = :messageBytes WHERE CREATED_DATE = :createdDate")
    public int[] bulkUpdateParams(@Bind("messageId") List<Integer> messageIds, @Bind("messagePriority") List<java.math.BigDecimal> messagePrioritys, @Bind("messageBytes") List<byte[]> messageBytess, @Bind("createdDate") List<String> createdDates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM INT_CHANNEL_MESSAGE WHERE CREATED_DATE IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM INT_CHANNEL_MESSAGE WHERE CREATED_DATE = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple IntChannelMessage records by their IDs.
     */
    @SqlQuery("SELECT * FROM INT_CHANNEL_MESSAGE WHERE CREATED_DATE IN (<ids>)")
    @RegisterBeanMapper(IntChannelMessage.class)
    public List<IntChannelMessage> findByIds(@BindList("ids") Collection<String> ids);
}
