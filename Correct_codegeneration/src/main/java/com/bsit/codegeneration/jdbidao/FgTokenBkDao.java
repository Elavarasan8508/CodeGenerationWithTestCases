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
import com.bsit.codegeneration.entity.FgTokenBk;

public interface FgTokenBkDao {

    /**
     * Inserts a new FgTokenBk and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TOKEN_BK (ID, DOMAIN_CODE, USER_NAME, LOGIN_ID, TOKEN_NAME, STATUS, REQ_SYSTEM, ISSUED_ON, ACCESSED_ON, VAL_DURATION, REQ_TIME, EXPIRES_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, TOKEN_VALUE, CHANNEL, CHANNEL_TYPE) VALUES (:id, :domainCode, :userName, :loginId, :tokenName, :status, :reqSystem, :issuedOn, :accessedOn, :valDuration, :reqTime, :expiresOn, :lastAuthorisedBy, :lastAuthorisedOn, :tokenValue, :channel, :channelType)")
    public int insert(@BindBean FgTokenBk fgtokenbk);

    /**
     * Finds a FgTokenBk by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TOKEN_BK WHERE FG_TOKEN_BK_id = :id")
    @RegisterBeanMapper(FgTokenBk.class)
    public Optional<FgTokenBk> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TOKEN_BK")
    @RegisterBeanMapper(FgTokenBk.class)
    public List<FgTokenBk> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TOKEN_BK ORDER BY FG_TOKEN_BK_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTokenBk.class)
    public List<FgTokenBk> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTokenBk and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TOKEN_BK SET ID = :id, DOMAIN_CODE = :domainCode, USER_NAME = :userName, LOGIN_ID = :loginId, TOKEN_NAME = :tokenName, STATUS = :status, REQ_SYSTEM = :reqSystem, ISSUED_ON = :issuedOn, ACCESSED_ON = :accessedOn, VAL_DURATION = :valDuration, REQ_TIME = :reqTime, EXPIRES_ON = :expiresOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, TOKEN_VALUE = :tokenValue, CHANNEL = :channel, CHANNEL_TYPE = :channelType WHERE FG_TOKEN_BK_id = :fgTokenBkId")
    public int update(@BindBean FgTokenBk fgtokenbk);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TOKEN_BK WHERE FG_TOKEN_BK_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TOKEN_BK")
    public long countAll();

    /**
     * Bulk insert multiple FgTokenBk entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TOKEN_BK (ID, DOMAIN_CODE, USER_NAME, LOGIN_ID, TOKEN_NAME, STATUS, REQ_SYSTEM, ISSUED_ON, ACCESSED_ON, VAL_DURATION, REQ_TIME, EXPIRES_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, TOKEN_VALUE, CHANNEL, CHANNEL_TYPE) VALUES (:id, :domainCode, :userName, :loginId, :tokenName, :status, :reqSystem, :issuedOn, :accessedOn, :valDuration, :reqTime, :expiresOn, :lastAuthorisedBy, :lastAuthorisedOn, :tokenValue, :channel, :channelType)")
    public int[] bulkInsert(@BindBean List<FgTokenBk> fgtokenbks);

    /**
     * Bulk update multiple FgTokenBk entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TOKEN_BK SET ID = :id, DOMAIN_CODE = :domainCode, USER_NAME = :userName, LOGIN_ID = :loginId, TOKEN_NAME = :tokenName, STATUS = :status, REQ_SYSTEM = :reqSystem, ISSUED_ON = :issuedOn, ACCESSED_ON = :accessedOn, VAL_DURATION = :valDuration, REQ_TIME = :reqTime, EXPIRES_ON = :expiresOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, TOKEN_VALUE = :tokenValue, CHANNEL = :channel, CHANNEL_TYPE = :channelType WHERE FG_TOKEN_BK_id = :fgTokenBkId")
    public int[] bulkUpdate(@BindBean List<FgTokenBk> fgtokenbks);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TOKEN_BK WHERE FG_TOKEN_BK_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TOKEN_BK WHERE FG_TOKEN_BK_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgTokenBk records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TOKEN_BK WHERE FG_TOKEN_BK_id IN (<ids>)")
    @RegisterBeanMapper(FgTokenBk.class)
    public List<FgTokenBk> findByIds(@BindList("ids") Collection<Integer> ids);
}
