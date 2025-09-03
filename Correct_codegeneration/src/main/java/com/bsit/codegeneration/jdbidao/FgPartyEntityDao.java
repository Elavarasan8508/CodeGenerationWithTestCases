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
import com.bsit.codegeneration.entity.FgPartyEntity;

public interface FgPartyEntityDao {

    /**
     * Inserts a new FgPartyEntity and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_ENTITY (ID, PARENT_PARTY_CODE, PARTY_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, ENTITY_REF_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, MASK, GRANTING, IS_MASTER, VERSION_NO, INITIATE_BY, IS_TRANSACTION, IS_VIEW, ACTIVE_CODE, STATUS_CODE, AUTH_STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PARENT_PARTY_ID, PARENT_PARTY_VERSION_ID, PARTY_ID, PARTY_VERSION_ID, ENTITY_ID, ENTITY_VERSION_ID) VALUES (:id, :parentPartyCode, :partyCode, :partyTypeCode, :partySubTypeCode, :entityRefCode, :entityTypeCode, :entitySubTypeCode, :mask, :granting, :isMaster, :versionNo, :initiateBy, :isTransaction, :isView, :activeCode, :statusCode, :authStatusCode, :lastAuthorisedOn, :lastAuthorisedBy, :parentPartyId, :parentPartyVersionId, :partyId, :partyVersionId, :entityId, :entityVersionId)")
    public int insert(@BindBean FgPartyEntity fgpartyentity);

    /**
     * Finds a FgPartyEntity by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY WHERE ID = :id")
    @RegisterBeanMapper(FgPartyEntity.class)
    public Optional<FgPartyEntity> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY")
    @RegisterBeanMapper(FgPartyEntity.class)
    public List<FgPartyEntity> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyEntity.class)
    public List<FgPartyEntity> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyEntity and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_ENTITY SET PARENT_PARTY_CODE = :parentPartyCode, PARTY_CODE = :partyCode, PARTY_TYPE_CODE = :partyTypeCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, ENTITY_REF_CODE = :entityRefCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, MASK = :mask, GRANTING = :granting, IS_MASTER = :isMaster, VERSION_NO = :versionNo, INITIATE_BY = :initiateBy, IS_TRANSACTION = :isTransaction, IS_VIEW = :isView, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, AUTH_STATUS_CODE = :authStatusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PARENT_PARTY_ID = :parentPartyId, PARENT_PARTY_VERSION_ID = :parentPartyVersionId, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, ENTITY_ID = :entityId, ENTITY_VERSION_ID = :entityVersionId WHERE ID = :id")
    public int update(@BindBean FgPartyEntity fgpartyentity);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ENTITY WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_ENTITY")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyEntity entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_ENTITY (ID, PARENT_PARTY_CODE, PARTY_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, ENTITY_REF_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, MASK, GRANTING, IS_MASTER, VERSION_NO, INITIATE_BY, IS_TRANSACTION, IS_VIEW, ACTIVE_CODE, STATUS_CODE, AUTH_STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PARENT_PARTY_ID, PARENT_PARTY_VERSION_ID, PARTY_ID, PARTY_VERSION_ID, ENTITY_ID, ENTITY_VERSION_ID) VALUES (:id, :parentPartyCode, :partyCode, :partyTypeCode, :partySubTypeCode, :entityRefCode, :entityTypeCode, :entitySubTypeCode, :mask, :granting, :isMaster, :versionNo, :initiateBy, :isTransaction, :isView, :activeCode, :statusCode, :authStatusCode, :lastAuthorisedOn, :lastAuthorisedBy, :parentPartyId, :parentPartyVersionId, :partyId, :partyVersionId, :entityId, :entityVersionId)")
    public int[] bulkInsert(@BindBean List<FgPartyEntity> fgpartyentitys);

    /**
     * Bulk update multiple FgPartyEntity entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_ENTITY SET PARENT_PARTY_CODE = :parentPartyCode, PARTY_CODE = :partyCode, PARTY_TYPE_CODE = :partyTypeCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, ENTITY_REF_CODE = :entityRefCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, MASK = :mask, GRANTING = :granting, IS_MASTER = :isMaster, VERSION_NO = :versionNo, INITIATE_BY = :initiateBy, IS_TRANSACTION = :isTransaction, IS_VIEW = :isView, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, AUTH_STATUS_CODE = :authStatusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PARENT_PARTY_ID = :parentPartyId, PARENT_PARTY_VERSION_ID = :parentPartyVersionId, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, ENTITY_ID = :entityId, ENTITY_VERSION_ID = :entityVersionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPartyEntity> fgpartyentitys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ENTITY WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_ENTITY WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPartyEntity records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPartyEntity.class)
    public List<FgPartyEntity> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
