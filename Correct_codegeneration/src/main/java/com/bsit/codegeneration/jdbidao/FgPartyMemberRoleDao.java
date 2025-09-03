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
import com.bsit.codegeneration.entity.FgPartyMemberRole;

public interface FgPartyMemberRoleDao {

    /**
     * Inserts a new FgPartyMemberRole and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_MEMBER_ROLE (ID, PARTY_TYPE_CODE, PARTY_CODE, PARTY_REF_ID, PARTY_VERSION_ID, ROLE_CODE, EFFECTIVE_FROM, EFFECTIVE_TO, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE) VALUES (:id, :partyTypeCode, :partyCode, :partyRefId, :partyVersionId, :roleCode, :effectiveFrom, :effectiveTo, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :systemSourceCode)")
    public int insert(@BindBean FgPartyMemberRole fgpartymemberrole);

    /**
     * Finds a FgPartyMemberRole by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_MEMBER_ROLE WHERE ID = :id")
    @RegisterBeanMapper(FgPartyMemberRole.class)
    public Optional<FgPartyMemberRole> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_MEMBER_ROLE")
    @RegisterBeanMapper(FgPartyMemberRole.class)
    public List<FgPartyMemberRole> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_MEMBER_ROLE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyMemberRole.class)
    public List<FgPartyMemberRole> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyMemberRole and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_MEMBER_ROLE SET PARTY_TYPE_CODE = :partyTypeCode, PARTY_CODE = :partyCode, PARTY_REF_ID = :partyRefId, PARTY_VERSION_ID = :partyVersionId, ROLE_CODE = :roleCode, EFFECTIVE_FROM = :effectiveFrom, EFFECTIVE_TO = :effectiveTo, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, SYSTEM_SOURCE_CODE = :systemSourceCode WHERE ID = :id")
    public int update(@BindBean FgPartyMemberRole fgpartymemberrole);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_MEMBER_ROLE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_MEMBER_ROLE")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyMemberRole entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_MEMBER_ROLE (ID, PARTY_TYPE_CODE, PARTY_CODE, PARTY_REF_ID, PARTY_VERSION_ID, ROLE_CODE, EFFECTIVE_FROM, EFFECTIVE_TO, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE) VALUES (:id, :partyTypeCode, :partyCode, :partyRefId, :partyVersionId, :roleCode, :effectiveFrom, :effectiveTo, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :systemSourceCode)")
    public int[] bulkInsert(@BindBean List<FgPartyMemberRole> fgpartymemberroles);

    /**
     * Bulk update multiple FgPartyMemberRole entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_MEMBER_ROLE SET PARTY_TYPE_CODE = :partyTypeCode, PARTY_CODE = :partyCode, PARTY_REF_ID = :partyRefId, PARTY_VERSION_ID = :partyVersionId, ROLE_CODE = :roleCode, EFFECTIVE_FROM = :effectiveFrom, EFFECTIVE_TO = :effectiveTo, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, SYSTEM_SOURCE_CODE = :systemSourceCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPartyMemberRole> fgpartymemberroles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_MEMBER_ROLE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_MEMBER_ROLE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPartyMemberRole records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_MEMBER_ROLE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPartyMemberRole.class)
    public List<FgPartyMemberRole> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
