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
import com.bsit.codegeneration.entity.FgPartyOrgMembership;

public interface FgPartyOrgMembershipDao {

    /**
     * Inserts a new FgPartyOrgMembership and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_ORG_MEMBERSHIP (ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, MEMBER_CAT_CODE, MEMBER_TYPE_CODE, MEMBER_SUB_TYPE_CODE, PARTY_USER_ID, PARTY_USER_VERSION_ID, USER_LOGIN_ID, NAME, AGE, ADDRESS, QUALIFICATION, DESIGNATION_CODE, TITLE_CODE, NET_WORTH, RELATIONSHIP_CODE, SHARE_HOLDING_CODE, SHARE_PERCENTAGE, COMMENTS, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, USER_SUB_TYPE_CODE, EMAIL_ID, PHONE_NO) VALUES (:id, :partyId, :partyVersionId, :partySubTypeCode, :partyCode, :memberCatCode, :memberTypeCode, :memberSubTypeCode, :partyUserId, :partyUserVersionId, :userLoginId, :name, :age, :address, :qualification, :designationCode, :titleCode, :netWorth, :relationshipCode, :shareHoldingCode, :sharePercentage, :comments, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :userSubTypeCode, :emailId, :phoneNo)")
    public int insert(@BindBean FgPartyOrgMembership fgpartyorgmembership);

    /**
     * Finds a FgPartyOrgMembership by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ORG_MEMBERSHIP WHERE FG_PARTY_ORG_MEMBERSHIP_id = :id")
    @RegisterBeanMapper(FgPartyOrgMembership.class)
    public Optional<FgPartyOrgMembership> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ORG_MEMBERSHIP")
    @RegisterBeanMapper(FgPartyOrgMembership.class)
    public List<FgPartyOrgMembership> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ORG_MEMBERSHIP ORDER BY FG_PARTY_ORG_MEMBERSHIP_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyOrgMembership.class)
    public List<FgPartyOrgMembership> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyOrgMembership and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_ORG_MEMBERSHIP SET ID = :id, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PARTY_CODE = :partyCode, MEMBER_CAT_CODE = :memberCatCode, MEMBER_TYPE_CODE = :memberTypeCode, MEMBER_SUB_TYPE_CODE = :memberSubTypeCode, PARTY_USER_ID = :partyUserId, PARTY_USER_VERSION_ID = :partyUserVersionId, USER_LOGIN_ID = :userLoginId, NAME = :name, AGE = :age, ADDRESS = :address, QUALIFICATION = :qualification, DESIGNATION_CODE = :designationCode, TITLE_CODE = :titleCode, NET_WORTH = :netWorth, RELATIONSHIP_CODE = :relationshipCode, SHARE_HOLDING_CODE = :shareHoldingCode, SHARE_PERCENTAGE = :sharePercentage, COMMENTS = :comments, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, USER_SUB_TYPE_CODE = :userSubTypeCode, EMAIL_ID = :emailId, PHONE_NO = :phoneNo WHERE FG_PARTY_ORG_MEMBERSHIP_id = :fgPartyOrgMembershipId")
    public int update(@BindBean FgPartyOrgMembership fgpartyorgmembership);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ORG_MEMBERSHIP WHERE FG_PARTY_ORG_MEMBERSHIP_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_ORG_MEMBERSHIP")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyOrgMembership entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_ORG_MEMBERSHIP (ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, MEMBER_CAT_CODE, MEMBER_TYPE_CODE, MEMBER_SUB_TYPE_CODE, PARTY_USER_ID, PARTY_USER_VERSION_ID, USER_LOGIN_ID, NAME, AGE, ADDRESS, QUALIFICATION, DESIGNATION_CODE, TITLE_CODE, NET_WORTH, RELATIONSHIP_CODE, SHARE_HOLDING_CODE, SHARE_PERCENTAGE, COMMENTS, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, USER_SUB_TYPE_CODE, EMAIL_ID, PHONE_NO) VALUES (:id, :partyId, :partyVersionId, :partySubTypeCode, :partyCode, :memberCatCode, :memberTypeCode, :memberSubTypeCode, :partyUserId, :partyUserVersionId, :userLoginId, :name, :age, :address, :qualification, :designationCode, :titleCode, :netWorth, :relationshipCode, :shareHoldingCode, :sharePercentage, :comments, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :userSubTypeCode, :emailId, :phoneNo)")
    public int[] bulkInsert(@BindBean List<FgPartyOrgMembership> fgpartyorgmemberships);

    /**
     * Bulk update multiple FgPartyOrgMembership entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_ORG_MEMBERSHIP SET ID = :id, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PARTY_CODE = :partyCode, MEMBER_CAT_CODE = :memberCatCode, MEMBER_TYPE_CODE = :memberTypeCode, MEMBER_SUB_TYPE_CODE = :memberSubTypeCode, PARTY_USER_ID = :partyUserId, PARTY_USER_VERSION_ID = :partyUserVersionId, USER_LOGIN_ID = :userLoginId, NAME = :name, AGE = :age, ADDRESS = :address, QUALIFICATION = :qualification, DESIGNATION_CODE = :designationCode, TITLE_CODE = :titleCode, NET_WORTH = :netWorth, RELATIONSHIP_CODE = :relationshipCode, SHARE_HOLDING_CODE = :shareHoldingCode, SHARE_PERCENTAGE = :sharePercentage, COMMENTS = :comments, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, USER_SUB_TYPE_CODE = :userSubTypeCode, EMAIL_ID = :emailId, PHONE_NO = :phoneNo WHERE FG_PARTY_ORG_MEMBERSHIP_id = :fgPartyOrgMembershipId")
    public int[] bulkUpdate(@BindBean List<FgPartyOrgMembership> fgpartyorgmemberships);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ORG_MEMBERSHIP WHERE FG_PARTY_ORG_MEMBERSHIP_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_ORG_MEMBERSHIP WHERE FG_PARTY_ORG_MEMBERSHIP_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgPartyOrgMembership records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ORG_MEMBERSHIP WHERE FG_PARTY_ORG_MEMBERSHIP_id IN (<ids>)")
    @RegisterBeanMapper(FgPartyOrgMembership.class)
    public List<FgPartyOrgMembership> findByIds(@BindList("ids") Collection<Integer> ids);
}
