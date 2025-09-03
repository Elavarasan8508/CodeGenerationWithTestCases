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
import com.bsit.codegeneration.entity.FgPartyEntityType;

public interface FgPartyEntityTypeDao {

    /**
     * Inserts a new FgPartyEntityType and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_ENTITY_TYPE (ID, IS_ENABLED, PARTY_REFERENCE_ID, ENTITY_CATEGORY_CODE, ENTITY_TYPE_CODE, USER_OBJECT_TYPE, USER_OBJECT_REFERENCE_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_TYPE_NAME, PARTY_ID, PARTY_VERSION_ID, USER_OBJECT_ID, USER_OBJECT_VERSION_ID, TEMPLATE, ENTITY_ACTION) VALUES (:id, :isEnabled, :partyReferenceId, :entityCategoryCode, :entityTypeCode, :userObjectType, :userObjectReferenceId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :entityTypeName, :partyId, :partyVersionId, :userObjectId, :userObjectVersionId, :template, :entityAction)")
    public int insert(@BindBean FgPartyEntityType fgpartyentitytype);

    /**
     * Finds a FgPartyEntityType by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY_TYPE WHERE ID = :id")
    @RegisterBeanMapper(FgPartyEntityType.class)
    public Optional<FgPartyEntityType> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY_TYPE")
    @RegisterBeanMapper(FgPartyEntityType.class)
    public List<FgPartyEntityType> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY_TYPE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyEntityType.class)
    public List<FgPartyEntityType> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyEntityType and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_ENTITY_TYPE SET IS_ENABLED = :isEnabled, PARTY_REFERENCE_ID = :partyReferenceId, ENTITY_CATEGORY_CODE = :entityCategoryCode, ENTITY_TYPE_CODE = :entityTypeCode, USER_OBJECT_TYPE = :userObjectType, USER_OBJECT_REFERENCE_ID = :userObjectReferenceId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ENTITY_TYPE_NAME = :entityTypeName, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, USER_OBJECT_ID = :userObjectId, USER_OBJECT_VERSION_ID = :userObjectVersionId, TEMPLATE = :template, ENTITY_ACTION = :entityAction WHERE ID = :id")
    public int update(@BindBean FgPartyEntityType fgpartyentitytype);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ENTITY_TYPE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_ENTITY_TYPE")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyEntityType entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_ENTITY_TYPE (ID, IS_ENABLED, PARTY_REFERENCE_ID, ENTITY_CATEGORY_CODE, ENTITY_TYPE_CODE, USER_OBJECT_TYPE, USER_OBJECT_REFERENCE_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_TYPE_NAME, PARTY_ID, PARTY_VERSION_ID, USER_OBJECT_ID, USER_OBJECT_VERSION_ID, TEMPLATE, ENTITY_ACTION) VALUES (:id, :isEnabled, :partyReferenceId, :entityCategoryCode, :entityTypeCode, :userObjectType, :userObjectReferenceId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :entityTypeName, :partyId, :partyVersionId, :userObjectId, :userObjectVersionId, :template, :entityAction)")
    public int[] bulkInsert(@BindBean List<FgPartyEntityType> fgpartyentitytypes);

    /**
     * Bulk update multiple FgPartyEntityType entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_ENTITY_TYPE SET IS_ENABLED = :isEnabled, PARTY_REFERENCE_ID = :partyReferenceId, ENTITY_CATEGORY_CODE = :entityCategoryCode, ENTITY_TYPE_CODE = :entityTypeCode, USER_OBJECT_TYPE = :userObjectType, USER_OBJECT_REFERENCE_ID = :userObjectReferenceId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ENTITY_TYPE_NAME = :entityTypeName, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, USER_OBJECT_ID = :userObjectId, USER_OBJECT_VERSION_ID = :userObjectVersionId, TEMPLATE = :template, ENTITY_ACTION = :entityAction WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPartyEntityType> fgpartyentitytypes);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ENTITY_TYPE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_ENTITY_TYPE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPartyEntityType records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY_TYPE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPartyEntityType.class)
    public List<FgPartyEntityType> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
