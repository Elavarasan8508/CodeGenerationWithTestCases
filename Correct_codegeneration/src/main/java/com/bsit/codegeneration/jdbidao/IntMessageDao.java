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
import com.bsit.codegeneration.entity.IntMessage;

public interface IntMessageDao {

    /**
     * Inserts a new IntMessage and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO INT_MESSAGE (MESSAGE_ID, REGION, MESSAGE_BYTES) VALUES (:messageId, :region, :messageBytes)")
    public int insert(@Bind("messageId") int messageId, @Bind("region") String region, @Bind("messageBytes") byte[] messageBytes);

    /**
     * Finds a IntMessage by its ID.
     */
    @SqlQuery("SELECT * FROM INT_MESSAGE WHERE MESSAGE_ID = :id")
    @RegisterBeanMapper(IntMessage.class)
    public Optional<IntMessage> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM INT_MESSAGE")
    @RegisterBeanMapper(IntMessage.class)
    public List<IntMessage> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM INT_MESSAGE ORDER BY MESSAGE_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(IntMessage.class)
    public List<IntMessage> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a IntMessage and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE INT_MESSAGE SET MESSAGE_BYTES = :messageBytes WHERE MESSAGE_ID = :messageId")
    public int update(@BindBean IntMessage intmessage);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM INT_MESSAGE WHERE MESSAGE_ID = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM INT_MESSAGE")
    public long countAll();

    /**
     * Bulk insert multiple IntMessage entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO INT_MESSAGE (MESSAGE_ID, REGION, MESSAGE_BYTES) VALUES (:messageId, :region, :messageBytes)")
    public int[] bulkInsert(@BindBean List<IntMessage> intmessages);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO INT_MESSAGE (MESSAGE_ID, REGION, MESSAGE_BYTES) VALUES (:messageId, :region, :messageBytes)")
    public int[] bulkInsertParams(@Bind("messageId") List<Integer> messageIds, @Bind("region") List<String> regions, @Bind("messageBytes") List<byte[]> messageBytess);

    /**
     * Bulk update multiple IntMessage entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE INT_MESSAGE SET MESSAGE_BYTES = :messageBytes WHERE MESSAGE_ID = :messageId")
    public int[] bulkUpdate(@BindBean List<IntMessage> intmessages);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE INT_MESSAGE SET MESSAGE_BYTES = :messageBytes WHERE MESSAGE_ID = :messageId")
    public int[] bulkUpdateParams(@Bind("messageBytes") List<byte[]> messageBytess, @Bind("messageId") List<Integer> messageIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM INT_MESSAGE WHERE MESSAGE_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM INT_MESSAGE WHERE MESSAGE_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple IntMessage records by their IDs.
     */
    @SqlQuery("SELECT * FROM INT_MESSAGE WHERE MESSAGE_ID IN (<ids>)")
    @RegisterBeanMapper(IntMessage.class)
    public List<IntMessage> findByIds(@BindList("ids") Collection<Integer> ids);
}
