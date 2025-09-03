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
import com.bsit.codegeneration.entity.SpringSessionAttributes;

public interface SpringSessionAttributesDao {

    /**
     * Inserts a new SpringSessionAttributes and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SPRING_SESSION_ATTRIBUTES (SESSION_PRIMARY_ID, ATTRIBUTE_NAME, ATTRIBUTE_BYTES) VALUES (:sessionPrimaryId, :attributeName, :attributeBytes)")
    public int insert(@Bind("sessionPrimaryId") int sessionPrimaryId, @Bind("attributeName") String attributeName, @Bind("attributeBytes") byte[] attributeBytes);

    /**
     * Finds a SpringSessionAttributes by its ID.
     */
    @SqlQuery("SELECT * FROM SPRING_SESSION_ATTRIBUTES WHERE ATTRIBUTE_NAME = :id")
    @RegisterBeanMapper(SpringSessionAttributes.class)
    public Optional<SpringSessionAttributes> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SPRING_SESSION_ATTRIBUTES")
    @RegisterBeanMapper(SpringSessionAttributes.class)
    public List<SpringSessionAttributes> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SPRING_SESSION_ATTRIBUTES ORDER BY ATTRIBUTE_NAME LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(SpringSessionAttributes.class)
    public List<SpringSessionAttributes> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a SpringSessionAttributes and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SPRING_SESSION_ATTRIBUTES SET ATTRIBUTE_BYTES = :attributeBytes WHERE ATTRIBUTE_NAME = :attributeName")
    public int update(@BindBean SpringSessionAttributes springsessionattributes);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SPRING_SESSION_ATTRIBUTES WHERE ATTRIBUTE_NAME = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SPRING_SESSION_ATTRIBUTES")
    public long countAll();

    /**
     * Bulk insert multiple SpringSessionAttributes entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SPRING_SESSION_ATTRIBUTES (SESSION_PRIMARY_ID, ATTRIBUTE_NAME, ATTRIBUTE_BYTES) VALUES (:sessionPrimaryId, :attributeName, :attributeBytes)")
    public int[] bulkInsert(@BindBean List<SpringSessionAttributes> springsessionattributess);

    /**
     * Bulk insert with individual parameter lists and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SPRING_SESSION_ATTRIBUTES (SESSION_PRIMARY_ID, ATTRIBUTE_NAME, ATTRIBUTE_BYTES) VALUES (:sessionPrimaryId, :attributeName, :attributeBytes)")
    public int[] bulkInsertParams(@Bind("sessionPrimaryId") List<Integer> sessionPrimaryIds, @Bind("attributeName") List<String> attributeNames, @Bind("attributeBytes") List<byte[]> attributeBytess);

    /**
     * Bulk update multiple SpringSessionAttributes entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SPRING_SESSION_ATTRIBUTES SET ATTRIBUTE_BYTES = :attributeBytes WHERE ATTRIBUTE_NAME = :attributeName")
    public int[] bulkUpdate(@BindBean List<SpringSessionAttributes> springsessionattributess);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SPRING_SESSION_ATTRIBUTES SET ATTRIBUTE_BYTES = :attributeBytes WHERE ATTRIBUTE_NAME = :attributeName")
    public int[] bulkUpdateParams(@Bind("attributeBytes") List<byte[]> attributeBytess, @Bind("attributeName") List<Integer> attributeNames);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SPRING_SESSION_ATTRIBUTES WHERE ATTRIBUTE_NAME IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SPRING_SESSION_ATTRIBUTES WHERE ATTRIBUTE_NAME = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple SpringSessionAttributes records by their IDs.
     */
    @SqlQuery("SELECT * FROM SPRING_SESSION_ATTRIBUTES WHERE ATTRIBUTE_NAME IN (<ids>)")
    @RegisterBeanMapper(SpringSessionAttributes.class)
    public List<SpringSessionAttributes> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all SpringSessionAttributes records by sessionPrimaryId.
     */
    @SqlQuery("SELECT * FROM SPRING_SESSION_ATTRIBUTES WHERE SESSION_PRIMARY_ID = :sessionPrimaryId")
    @RegisterBeanMapper(SpringSessionAttributes.class)
    public List<SpringSessionAttributes> findBySessionPrimaryId(@Bind("sessionPrimaryId") int sessionPrimaryId);
}
