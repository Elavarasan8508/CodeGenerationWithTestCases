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
import com.bsit.codegeneration.entity.FgPartyProfile;

public interface FgPartyProfileDao {

    /**
     * Inserts a new FgPartyProfile and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_PROFILE (ID, ORG_ID, ORG_VERSION_ID, ORG_CODE, PROFILE_TYPE_CODE, PROFILE_TEXT, TEMPLATE, USER_ID, USER_VERSION_ID, STATUS_CODE, AUTH_STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :orgId, :orgVersionId, :orgCode, :profileTypeCode, :profileText, :template, :userId, :userVersionId, :statusCode, :authStatusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgPartyProfile fgpartyprofile);

    /**
     * Finds a FgPartyProfile by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_PROFILE WHERE ID = :id")
    @RegisterBeanMapper(FgPartyProfile.class)
    public Optional<FgPartyProfile> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_PROFILE")
    @RegisterBeanMapper(FgPartyProfile.class)
    public List<FgPartyProfile> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_PROFILE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyProfile.class)
    public List<FgPartyProfile> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyProfile and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_PROFILE SET ORG_ID = :orgId, ORG_VERSION_ID = :orgVersionId, ORG_CODE = :orgCode, PROFILE_TYPE_CODE = :profileTypeCode, PROFILE_TEXT = :profileText, TEMPLATE = :template, USER_ID = :userId, USER_VERSION_ID = :userVersionId, STATUS_CODE = :statusCode, AUTH_STATUS_CODE = :authStatusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgPartyProfile fgpartyprofile);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_PROFILE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_PROFILE")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyProfile entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_PROFILE (ID, ORG_ID, ORG_VERSION_ID, ORG_CODE, PROFILE_TYPE_CODE, PROFILE_TEXT, TEMPLATE, USER_ID, USER_VERSION_ID, STATUS_CODE, AUTH_STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :orgId, :orgVersionId, :orgCode, :profileTypeCode, :profileText, :template, :userId, :userVersionId, :statusCode, :authStatusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgPartyProfile> fgpartyprofiles);

    /**
     * Bulk update multiple FgPartyProfile entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_PROFILE SET ORG_ID = :orgId, ORG_VERSION_ID = :orgVersionId, ORG_CODE = :orgCode, PROFILE_TYPE_CODE = :profileTypeCode, PROFILE_TEXT = :profileText, TEMPLATE = :template, USER_ID = :userId, USER_VERSION_ID = :userVersionId, STATUS_CODE = :statusCode, AUTH_STATUS_CODE = :authStatusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPartyProfile> fgpartyprofiles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_PROFILE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_PROFILE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPartyProfile records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_PROFILE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPartyProfile.class)
    public List<FgPartyProfile> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgPartyProfile records by orgId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_PROFILE WHERE ORG_ID = :orgId")
    @RegisterBeanMapper(FgPartyProfile.class)
    public List<FgPartyProfile> findByOrgId(@Bind("orgId") int orgId);

    /**
     * Finds all FgPartyProfile records by orgVersionId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_PROFILE WHERE ORG_VERSION_ID = :orgVersionId")
    @RegisterBeanMapper(FgPartyProfile.class)
    public List<FgPartyProfile> findByOrgVersionId(@Bind("orgVersionId") int orgVersionId);
}
