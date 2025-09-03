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
import com.bsit.codegeneration.entity.FgDmsTag;

public interface FgDmsTagDao {

    /**
     * Inserts a new FgDmsTag and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_DMS_TAG (ID, TAG_NAME, DMS_CONTENT_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :tagName, :dmsContentId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgDmsTag fgdmstag);

    /**
     * Finds a FgDmsTag by its ID.
     */
    @SqlQuery("SELECT * FROM FG_DMS_TAG WHERE ID = :id")
    @RegisterBeanMapper(FgDmsTag.class)
    public Optional<FgDmsTag> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_DMS_TAG")
    @RegisterBeanMapper(FgDmsTag.class)
    public List<FgDmsTag> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_DMS_TAG ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgDmsTag.class)
    public List<FgDmsTag> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgDmsTag and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_DMS_TAG SET TAG_NAME = :tagName, DMS_CONTENT_ID = :dmsContentId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgDmsTag fgdmstag);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DMS_TAG WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_DMS_TAG")
    public long countAll();

    /**
     * Bulk insert multiple FgDmsTag entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_DMS_TAG (ID, TAG_NAME, DMS_CONTENT_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :tagName, :dmsContentId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgDmsTag> fgdmstags);

    /**
     * Bulk update multiple FgDmsTag entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_DMS_TAG SET TAG_NAME = :tagName, DMS_CONTENT_ID = :dmsContentId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgDmsTag> fgdmstags);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DMS_TAG WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_DMS_TAG WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgDmsTag records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_DMS_TAG WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgDmsTag.class)
    public List<FgDmsTag> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgDmsTag records by dmsContentId.
     */
    @SqlQuery("SELECT * FROM FG_DMS_TAG WHERE DMS_CONTENT_ID = :dmsContentId")
    @RegisterBeanMapper(FgDmsTag.class)
    public List<FgDmsTag> findByDmsContentId(@Bind("dmsContentId") int dmsContentId);
}
