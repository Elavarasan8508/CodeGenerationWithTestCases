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
import com.bsit.codegeneration.entity.FgToken;

public interface FgTokenDao {

    /**
     * Inserts a new FgToken and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TOKEN (ID, DOMAIN_CODE, USER_NAME, LOGIN_ID, TOKEN_NAME, STATUS, REQ_SYSTEM, ISSUED_ON, ACCESSED_ON, VAL_DURATION, REQ_TIME, EXPIRES_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, TOKEN_VALUE, CHANNEL, CHANNEL_TYPE, EXTERNAL_TOKEN) VALUES (:id, :domainCode, :userName, :loginId, :tokenName, :status, :reqSystem, :issuedOn, :accessedOn, :valDuration, :reqTime, :expiresOn, :lastAuthorisedBy, :lastAuthorisedOn, :tokenValue, :channel, :channelType, :externalToken)")
    public int insert(@BindBean FgToken fgtoken);

    /**
     * Finds a FgToken by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TOKEN WHERE FG_TOKEN_id = :id")
    @RegisterBeanMapper(FgToken.class)
    public Optional<FgToken> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TOKEN")
    @RegisterBeanMapper(FgToken.class)
    public List<FgToken> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TOKEN ORDER BY FG_TOKEN_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgToken.class)
    public List<FgToken> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgToken and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TOKEN SET ID = :id, DOMAIN_CODE = :domainCode, USER_NAME = :userName, LOGIN_ID = :loginId, TOKEN_NAME = :tokenName, STATUS = :status, REQ_SYSTEM = :reqSystem, ISSUED_ON = :issuedOn, ACCESSED_ON = :accessedOn, VAL_DURATION = :valDuration, REQ_TIME = :reqTime, EXPIRES_ON = :expiresOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, TOKEN_VALUE = :tokenValue, CHANNEL = :channel, CHANNEL_TYPE = :channelType, EXTERNAL_TOKEN = :externalToken WHERE FG_TOKEN_id = :fgTokenId")
    public int update(@BindBean FgToken fgtoken);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TOKEN WHERE FG_TOKEN_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TOKEN")
    public long countAll();

    /**
     * Bulk insert multiple FgToken entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TOKEN (ID, DOMAIN_CODE, USER_NAME, LOGIN_ID, TOKEN_NAME, STATUS, REQ_SYSTEM, ISSUED_ON, ACCESSED_ON, VAL_DURATION, REQ_TIME, EXPIRES_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, TOKEN_VALUE, CHANNEL, CHANNEL_TYPE, EXTERNAL_TOKEN) VALUES (:id, :domainCode, :userName, :loginId, :tokenName, :status, :reqSystem, :issuedOn, :accessedOn, :valDuration, :reqTime, :expiresOn, :lastAuthorisedBy, :lastAuthorisedOn, :tokenValue, :channel, :channelType, :externalToken)")
    public int[] bulkInsert(@BindBean List<FgToken> fgtokens);

    /**
     * Bulk update multiple FgToken entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TOKEN SET ID = :id, DOMAIN_CODE = :domainCode, USER_NAME = :userName, LOGIN_ID = :loginId, TOKEN_NAME = :tokenName, STATUS = :status, REQ_SYSTEM = :reqSystem, ISSUED_ON = :issuedOn, ACCESSED_ON = :accessedOn, VAL_DURATION = :valDuration, REQ_TIME = :reqTime, EXPIRES_ON = :expiresOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, TOKEN_VALUE = :tokenValue, CHANNEL = :channel, CHANNEL_TYPE = :channelType, EXTERNAL_TOKEN = :externalToken WHERE FG_TOKEN_id = :fgTokenId")
    public int[] bulkUpdate(@BindBean List<FgToken> fgtokens);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TOKEN WHERE FG_TOKEN_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TOKEN WHERE FG_TOKEN_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgToken records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TOKEN WHERE FG_TOKEN_id IN (<ids>)")
    @RegisterBeanMapper(FgToken.class)
    public List<FgToken> findByIds(@BindList("ids") Collection<Integer> ids);
}
