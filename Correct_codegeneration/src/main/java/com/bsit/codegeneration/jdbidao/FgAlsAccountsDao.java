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
import com.bsit.codegeneration.entity.FgAlsAccounts;

public interface FgAlsAccountsDao {

    /**
     * Inserts a new FgAlsAccounts and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ALS_ACCOUNTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACCOUNT_NUMBER, PRODUCT_CODE, LOGIC_OF_SETTLEMENT, MAX_SETTLEMENT_PERCENTAGE, MAX_SETTLEMENT_AMOUNT, REPAYMENT_ACTION, PARENT_REF_ID, PARENT_VERSION_ID, PROCESS_ID, IS_MASTER_VERSION, VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :accountNumber, :productCode, :logicOfSettlement, :maxSettlementPercentage, :maxSettlementAmount, :repaymentAction, :parentRefId, :parentVersionId, :processId, :isMasterVersion, :versionId)")
    public int insert(@BindBean FgAlsAccounts fgalsaccounts);

    /**
     * Finds a FgAlsAccounts by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ALS_ACCOUNTS WHERE FG_ALS_ACCOUNTS_id = :id")
    @RegisterBeanMapper(FgAlsAccounts.class)
    public Optional<FgAlsAccounts> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ALS_ACCOUNTS")
    @RegisterBeanMapper(FgAlsAccounts.class)
    public List<FgAlsAccounts> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ALS_ACCOUNTS ORDER BY FG_ALS_ACCOUNTS_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAlsAccounts.class)
    public List<FgAlsAccounts> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAlsAccounts and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ALS_ACCOUNTS SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ACCOUNT_NUMBER = :accountNumber, PRODUCT_CODE = :productCode, LOGIC_OF_SETTLEMENT = :logicOfSettlement, MAX_SETTLEMENT_PERCENTAGE = :maxSettlementPercentage, MAX_SETTLEMENT_AMOUNT = :maxSettlementAmount, REPAYMENT_ACTION = :repaymentAction, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, PROCESS_ID = :processId, IS_MASTER_VERSION = :isMasterVersion, VERSION_ID = :versionId WHERE FG_ALS_ACCOUNTS_id = :fgAlsAccountsId")
    public int update(@BindBean FgAlsAccounts fgalsaccounts);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALS_ACCOUNTS WHERE FG_ALS_ACCOUNTS_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ALS_ACCOUNTS")
    public long countAll();

    /**
     * Bulk insert multiple FgAlsAccounts entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ALS_ACCOUNTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACCOUNT_NUMBER, PRODUCT_CODE, LOGIC_OF_SETTLEMENT, MAX_SETTLEMENT_PERCENTAGE, MAX_SETTLEMENT_AMOUNT, REPAYMENT_ACTION, PARENT_REF_ID, PARENT_VERSION_ID, PROCESS_ID, IS_MASTER_VERSION, VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :accountNumber, :productCode, :logicOfSettlement, :maxSettlementPercentage, :maxSettlementAmount, :repaymentAction, :parentRefId, :parentVersionId, :processId, :isMasterVersion, :versionId)")
    public int[] bulkInsert(@BindBean List<FgAlsAccounts> fgalsaccountss);

    /**
     * Bulk update multiple FgAlsAccounts entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ALS_ACCOUNTS SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ACCOUNT_NUMBER = :accountNumber, PRODUCT_CODE = :productCode, LOGIC_OF_SETTLEMENT = :logicOfSettlement, MAX_SETTLEMENT_PERCENTAGE = :maxSettlementPercentage, MAX_SETTLEMENT_AMOUNT = :maxSettlementAmount, REPAYMENT_ACTION = :repaymentAction, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, PROCESS_ID = :processId, IS_MASTER_VERSION = :isMasterVersion, VERSION_ID = :versionId WHERE FG_ALS_ACCOUNTS_id = :fgAlsAccountsId")
    public int[] bulkUpdate(@BindBean List<FgAlsAccounts> fgalsaccountss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALS_ACCOUNTS WHERE FG_ALS_ACCOUNTS_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ALS_ACCOUNTS WHERE FG_ALS_ACCOUNTS_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgAlsAccounts records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ALS_ACCOUNTS WHERE FG_ALS_ACCOUNTS_id IN (<ids>)")
    @RegisterBeanMapper(FgAlsAccounts.class)
    public List<FgAlsAccounts> findByIds(@BindList("ids") Collection<Integer> ids);
}
