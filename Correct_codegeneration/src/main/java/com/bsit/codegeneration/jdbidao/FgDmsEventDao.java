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
import com.bsit.codegeneration.entity.FgDmsEvent;

public interface FgDmsEventDao {

    /**
     * Inserts a new FgDmsEvent and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_DMS_EVENT (ID, ACTION_CODE, ENTITY_REFERENCE_ID, ENTITY_VERSION_ID, PARTY_ID, PARTY_VERSION_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE) VALUES (:id, :actionCode, :entityReferenceId, :entityVersionId, :partyId, :partyVersionId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :entityTypeCode, :entitySubTypeCode)")
    public int insert(@BindBean FgDmsEvent fgdmsevent);

    /**
     * Finds a FgDmsEvent by its ID.
     */
    @SqlQuery("SELECT * FROM FG_DMS_EVENT WHERE ID = :id")
    @RegisterBeanMapper(FgDmsEvent.class)
    public Optional<FgDmsEvent> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_DMS_EVENT")
    @RegisterBeanMapper(FgDmsEvent.class)
    public List<FgDmsEvent> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_DMS_EVENT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgDmsEvent.class)
    public List<FgDmsEvent> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgDmsEvent and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_DMS_EVENT SET ACTION_CODE = :actionCode, ENTITY_REFERENCE_ID = :entityReferenceId, ENTITY_VERSION_ID = :entityVersionId, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode WHERE ID = :id")
    public int update(@BindBean FgDmsEvent fgdmsevent);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DMS_EVENT WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_DMS_EVENT")
    public long countAll();

    /**
     * Bulk insert multiple FgDmsEvent entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_DMS_EVENT (ID, ACTION_CODE, ENTITY_REFERENCE_ID, ENTITY_VERSION_ID, PARTY_ID, PARTY_VERSION_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE) VALUES (:id, :actionCode, :entityReferenceId, :entityVersionId, :partyId, :partyVersionId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :entityTypeCode, :entitySubTypeCode)")
    public int[] bulkInsert(@BindBean List<FgDmsEvent> fgdmsevents);

    /**
     * Bulk update multiple FgDmsEvent entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_DMS_EVENT SET ACTION_CODE = :actionCode, ENTITY_REFERENCE_ID = :entityReferenceId, ENTITY_VERSION_ID = :entityVersionId, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgDmsEvent> fgdmsevents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DMS_EVENT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_DMS_EVENT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgDmsEvent records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_DMS_EVENT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgDmsEvent.class)
    public List<FgDmsEvent> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
