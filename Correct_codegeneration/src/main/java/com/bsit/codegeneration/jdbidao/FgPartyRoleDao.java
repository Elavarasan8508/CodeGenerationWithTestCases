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
import com.bsit.codegeneration.entity.FgPartyRole;

public interface FgPartyRoleDao {

    /**
     * Inserts a new FgPartyRole and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_ROLE (ID, PARTY_ID, PARTY_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :partyId, :partyVersionId, :roleId, :roleVersionId, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int insert(@BindBean FgPartyRole fgpartyrole);

    /**
     * Finds a FgPartyRole by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ROLE WHERE ID = :id")
    @RegisterBeanMapper(FgPartyRole.class)
    public Optional<FgPartyRole> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ROLE")
    @RegisterBeanMapper(FgPartyRole.class)
    public List<FgPartyRole> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ROLE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyRole.class)
    public List<FgPartyRole> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyRole and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_ROLE SET PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, ROLE_ID = :roleId, ROLE_VERSION_ID = :roleVersionId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE ID = :id")
    public int update(@BindBean FgPartyRole fgpartyrole);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ROLE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_ROLE")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyRole entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_ROLE (ID, PARTY_ID, PARTY_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :partyId, :partyVersionId, :roleId, :roleVersionId, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int[] bulkInsert(@BindBean List<FgPartyRole> fgpartyroles);

    /**
     * Bulk update multiple FgPartyRole entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_ROLE SET PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, ROLE_ID = :roleId, ROLE_VERSION_ID = :roleVersionId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPartyRole> fgpartyroles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ROLE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_ROLE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPartyRole records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ROLE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPartyRole.class)
    public List<FgPartyRole> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgPartyRole records by partyVersionId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ROLE WHERE PARTY_VERSION_ID = :partyVersionId")
    @RegisterBeanMapper(FgPartyRole.class)
    public List<FgPartyRole> findByPartyVersionId(@Bind("partyVersionId") int partyVersionId);

    /**
     * Finds all FgPartyRole records by roleVersionId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ROLE WHERE ROLE_VERSION_ID = :roleVersionId")
    @RegisterBeanMapper(FgPartyRole.class)
    public List<FgPartyRole> findByRoleVersionId(@Bind("roleVersionId") int roleVersionId);

    /**
     * Finds all FgPartyRole records by roleId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ROLE WHERE ROLE_ID = :roleId")
    @RegisterBeanMapper(FgPartyRole.class)
    public List<FgPartyRole> findByRoleId(@Bind("roleId") int roleId);

    /**
     * Finds all FgPartyRole records by partyId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ROLE WHERE PARTY_ID = :partyId")
    @RegisterBeanMapper(FgPartyRole.class)
    public List<FgPartyRole> findByPartyId(@Bind("partyId") int partyId);
}
