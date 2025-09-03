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
import com.bsit.codegeneration.entity.FgPartyRelation;

public interface FgPartyRelationDao {

    /**
     * Inserts a new FgPartyRelation and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_RELATION (ID, PARTY_FROM_ROLE_CODE, PARTY_TO_ROLE_CODE, FROM_PARTY_ID, FROM_PARTY_VERSION_ID, TO_PARTY_ID, TO_PARTY_VERSION_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, FROM_PARTY_USER_CODE, FROM_PARTY_USER_ID, FROM_PARTY_USER_VERSION_ID) VALUES (:id, :partyFromRoleCode, :partyToRoleCode, :fromPartyId, :fromPartyVersionId, :toPartyId, :toPartyVersionId, :lastAuthorisedOn, :lastAuthorisedBy, :fromPartyUserCode, :fromPartyUserId, :fromPartyUserVersionId)")
    public int insert(@BindBean FgPartyRelation fgpartyrelation);

    /**
     * Finds a FgPartyRelation by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_RELATION WHERE ID = :id")
    @RegisterBeanMapper(FgPartyRelation.class)
    public Optional<FgPartyRelation> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_RELATION")
    @RegisterBeanMapper(FgPartyRelation.class)
    public List<FgPartyRelation> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_RELATION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyRelation.class)
    public List<FgPartyRelation> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyRelation and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_RELATION SET PARTY_FROM_ROLE_CODE = :partyFromRoleCode, PARTY_TO_ROLE_CODE = :partyToRoleCode, FROM_PARTY_ID = :fromPartyId, FROM_PARTY_VERSION_ID = :fromPartyVersionId, TO_PARTY_ID = :toPartyId, TO_PARTY_VERSION_ID = :toPartyVersionId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, FROM_PARTY_USER_CODE = :fromPartyUserCode, FROM_PARTY_USER_ID = :fromPartyUserId, FROM_PARTY_USER_VERSION_ID = :fromPartyUserVersionId WHERE ID = :id")
    public int update(@BindBean FgPartyRelation fgpartyrelation);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_RELATION WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_RELATION")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyRelation entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_RELATION (ID, PARTY_FROM_ROLE_CODE, PARTY_TO_ROLE_CODE, FROM_PARTY_ID, FROM_PARTY_VERSION_ID, TO_PARTY_ID, TO_PARTY_VERSION_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, FROM_PARTY_USER_CODE, FROM_PARTY_USER_ID, FROM_PARTY_USER_VERSION_ID) VALUES (:id, :partyFromRoleCode, :partyToRoleCode, :fromPartyId, :fromPartyVersionId, :toPartyId, :toPartyVersionId, :lastAuthorisedOn, :lastAuthorisedBy, :fromPartyUserCode, :fromPartyUserId, :fromPartyUserVersionId)")
    public int[] bulkInsert(@BindBean List<FgPartyRelation> fgpartyrelations);

    /**
     * Bulk update multiple FgPartyRelation entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_RELATION SET PARTY_FROM_ROLE_CODE = :partyFromRoleCode, PARTY_TO_ROLE_CODE = :partyToRoleCode, FROM_PARTY_ID = :fromPartyId, FROM_PARTY_VERSION_ID = :fromPartyVersionId, TO_PARTY_ID = :toPartyId, TO_PARTY_VERSION_ID = :toPartyVersionId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, FROM_PARTY_USER_CODE = :fromPartyUserCode, FROM_PARTY_USER_ID = :fromPartyUserId, FROM_PARTY_USER_VERSION_ID = :fromPartyUserVersionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPartyRelation> fgpartyrelations);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_RELATION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_RELATION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPartyRelation records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_RELATION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPartyRelation.class)
    public List<FgPartyRelation> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgPartyRelation records by fromPartyVersionId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_RELATION WHERE FROM_PARTY_VERSION_ID = :fromPartyVersionId")
    @RegisterBeanMapper(FgPartyRelation.class)
    public List<FgPartyRelation> findByFromPartyVersionId(@Bind("fromPartyVersionId") int fromPartyVersionId);

    /**
     * Finds all FgPartyRelation records by toPartyVersionId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_RELATION WHERE TO_PARTY_VERSION_ID = :toPartyVersionId")
    @RegisterBeanMapper(FgPartyRelation.class)
    public List<FgPartyRelation> findByToPartyVersionId(@Bind("toPartyVersionId") int toPartyVersionId);

    /**
     * Finds all FgPartyRelation records by toPartyId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_RELATION WHERE TO_PARTY_ID = :toPartyId")
    @RegisterBeanMapper(FgPartyRelation.class)
    public List<FgPartyRelation> findByToPartyId(@Bind("toPartyId") int toPartyId);

    /**
     * Finds all FgPartyRelation records by fromPartyId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_RELATION WHERE FROM_PARTY_ID = :fromPartyId")
    @RegisterBeanMapper(FgPartyRelation.class)
    public List<FgPartyRelation> findByFromPartyId(@Bind("fromPartyId") int fromPartyId);
}
