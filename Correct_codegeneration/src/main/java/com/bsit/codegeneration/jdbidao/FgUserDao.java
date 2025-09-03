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
import com.bsit.codegeneration.entity.FgUser;

public interface FgUserDao {

    /**
     * Inserts a new FgUser and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_USER (ID, USER_PASSWORD, USER_SECRET, USER_TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, IS_USING_2FA, FIRST_TIME_LOGIN, LOGIN_ATTEMPTS, ACTIVE_CODE, STATUS_CODE, USER_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_AUTHORISE_OWN_TNX, LAST_LOGIN_TIME, CURRENT_LOGIN_TIME, LAST_LOGOUT_TIME, CURR_SESSION_ID, LAST_SESSION_ID) VALUES (:id, :userPassword, :userSecret, :userTypeCode, :partyId, :partyVersionId, :isUsing2fa, :firstTimeLogin, :loginAttempts, :activeCode, :statusCode, :userId, :lastAuthorisedOn, :lastAuthorisedBy, :isAuthoriseOwnTnx, :lastLoginTime, :currentLoginTime, :lastLogoutTime, :currSessionId, :lastSessionId)")
    public int insert(@BindBean FgUser fguser);

    /**
     * Finds a FgUser by its ID.
     */
    @SqlQuery("SELECT * FROM FG_USER WHERE ID = :id")
    @RegisterBeanMapper(FgUser.class)
    public Optional<FgUser> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_USER")
    @RegisterBeanMapper(FgUser.class)
    public List<FgUser> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_USER ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgUser.class)
    public List<FgUser> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgUser and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_USER SET USER_PASSWORD = :userPassword, USER_SECRET = :userSecret, USER_TYPE_CODE = :userTypeCode, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, IS_USING_2FA = :isUsing2fa, FIRST_TIME_LOGIN = :firstTimeLogin, LOGIN_ATTEMPTS = :loginAttempts, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, USER_ID = :userId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, IS_AUTHORISE_OWN_TNX = :isAuthoriseOwnTnx, LAST_LOGIN_TIME = :lastLoginTime, CURRENT_LOGIN_TIME = :currentLoginTime, LAST_LOGOUT_TIME = :lastLogoutTime, CURR_SESSION_ID = :currSessionId, LAST_SESSION_ID = :lastSessionId WHERE ID = :id")
    public int update(@BindBean FgUser fguser);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_USER WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_USER")
    public long countAll();

    /**
     * Bulk insert multiple FgUser entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_USER (ID, USER_PASSWORD, USER_SECRET, USER_TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, IS_USING_2FA, FIRST_TIME_LOGIN, LOGIN_ATTEMPTS, ACTIVE_CODE, STATUS_CODE, USER_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_AUTHORISE_OWN_TNX, LAST_LOGIN_TIME, CURRENT_LOGIN_TIME, LAST_LOGOUT_TIME, CURR_SESSION_ID, LAST_SESSION_ID) VALUES (:id, :userPassword, :userSecret, :userTypeCode, :partyId, :partyVersionId, :isUsing2fa, :firstTimeLogin, :loginAttempts, :activeCode, :statusCode, :userId, :lastAuthorisedOn, :lastAuthorisedBy, :isAuthoriseOwnTnx, :lastLoginTime, :currentLoginTime, :lastLogoutTime, :currSessionId, :lastSessionId)")
    public int[] bulkInsert(@BindBean List<FgUser> fgusers);

    /**
     * Bulk update multiple FgUser entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_USER SET USER_PASSWORD = :userPassword, USER_SECRET = :userSecret, USER_TYPE_CODE = :userTypeCode, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, IS_USING_2FA = :isUsing2fa, FIRST_TIME_LOGIN = :firstTimeLogin, LOGIN_ATTEMPTS = :loginAttempts, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, USER_ID = :userId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, IS_AUTHORISE_OWN_TNX = :isAuthoriseOwnTnx, LAST_LOGIN_TIME = :lastLoginTime, CURRENT_LOGIN_TIME = :currentLoginTime, LAST_LOGOUT_TIME = :lastLogoutTime, CURR_SESSION_ID = :currSessionId, LAST_SESSION_ID = :lastSessionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgUser> fgusers);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_USER WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_USER WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgUser records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_USER WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgUser.class)
    public List<FgUser> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgUser records by partyVersionId.
     */
    @SqlQuery("SELECT * FROM FG_USER WHERE PARTY_VERSION_ID = :partyVersionId")
    @RegisterBeanMapper(FgUser.class)
    public List<FgUser> findByPartyVersionId(@Bind("partyVersionId") int partyVersionId);

    /**
     * Finds all FgUser records by partyId.
     */
    @SqlQuery("SELECT * FROM FG_USER WHERE PARTY_ID = :partyId")
    @RegisterBeanMapper(FgUser.class)
    public List<FgUser> findByPartyId(@Bind("partyId") int partyId);
}
