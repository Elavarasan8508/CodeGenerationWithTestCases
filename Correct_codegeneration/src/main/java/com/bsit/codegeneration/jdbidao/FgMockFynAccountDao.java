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
import com.bsit.codegeneration.entity.FgMockFynAccount;

public interface FgMockFynAccountDao {

    /**
     * Inserts a new FgMockFynAccount and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOCK_FYN_ACCOUNT (CUST_MNM, ACCOUNT_NO, TEMPLATE, VERSION_ID, IS_MASTER_VERSION, ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_TEMPLATE, ACCOUNT_STATUS) VALUES (:custMnm, :accountNo, :template, :versionId, :isMasterVersion, :id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :isTemplate, :accountStatus)")
    public int insert(@BindBean FgMockFynAccount fgmockfynaccount);

    /**
     * Finds a FgMockFynAccount by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOCK_FYN_ACCOUNT WHERE FG_MOCK_FYN_ACCOUNT_id = :id")
    @RegisterBeanMapper(FgMockFynAccount.class)
    public Optional<FgMockFynAccount> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOCK_FYN_ACCOUNT")
    @RegisterBeanMapper(FgMockFynAccount.class)
    public List<FgMockFynAccount> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOCK_FYN_ACCOUNT ORDER BY FG_MOCK_FYN_ACCOUNT_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgMockFynAccount.class)
    public List<FgMockFynAccount> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgMockFynAccount and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOCK_FYN_ACCOUNT SET CUST_MNM = :custMnm, ACCOUNT_NO = :accountNo, TEMPLATE = :template, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, IS_TEMPLATE = :isTemplate, ACCOUNT_STATUS = :accountStatus WHERE FG_MOCK_FYN_ACCOUNT_id = :fgMockFynAccountId")
    public int update(@BindBean FgMockFynAccount fgmockfynaccount);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOCK_FYN_ACCOUNT WHERE FG_MOCK_FYN_ACCOUNT_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOCK_FYN_ACCOUNT")
    public long countAll();

    /**
     * Bulk insert multiple FgMockFynAccount entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOCK_FYN_ACCOUNT (CUST_MNM, ACCOUNT_NO, TEMPLATE, VERSION_ID, IS_MASTER_VERSION, ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_TEMPLATE, ACCOUNT_STATUS) VALUES (:custMnm, :accountNo, :template, :versionId, :isMasterVersion, :id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :isTemplate, :accountStatus)")
    public int[] bulkInsert(@BindBean List<FgMockFynAccount> fgmockfynaccounts);

    /**
     * Bulk update multiple FgMockFynAccount entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOCK_FYN_ACCOUNT SET CUST_MNM = :custMnm, ACCOUNT_NO = :accountNo, TEMPLATE = :template, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, IS_TEMPLATE = :isTemplate, ACCOUNT_STATUS = :accountStatus WHERE FG_MOCK_FYN_ACCOUNT_id = :fgMockFynAccountId")
    public int[] bulkUpdate(@BindBean List<FgMockFynAccount> fgmockfynaccounts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOCK_FYN_ACCOUNT WHERE FG_MOCK_FYN_ACCOUNT_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOCK_FYN_ACCOUNT WHERE FG_MOCK_FYN_ACCOUNT_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgMockFynAccount records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOCK_FYN_ACCOUNT WHERE FG_MOCK_FYN_ACCOUNT_id IN (<ids>)")
    @RegisterBeanMapper(FgMockFynAccount.class)
    public List<FgMockFynAccount> findByIds(@BindList("ids") Collection<Integer> ids);
}
