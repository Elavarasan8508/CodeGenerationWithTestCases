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
import com.bsit.codegeneration.entity.FgRuleAls;

public interface FgRuleAlsDao {

    /**
     * Inserts a new FgRuleAls and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_RULE_ALS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, CUSTOMER_CRN, ACCOUNT_NUMBER, PRODUCT_CODE, LOGIC_OF_SETTLEMENT, MAX_SETTLEMENT_PERCENTAGE, MAX_SETTLEMENT_AMOUNT, REPAYMENT_ACTION, STATUS, DEBIT_LOCK, PROCESS_ID, SLOT_REFERENCE, CUSTOMER_NAME, MONTHEND_SLOT, VIRTUAL_ACCOUNT_NUMBER, ACCOUNT_TYPE, COUNTERPARTY_CRN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :versionId, :isMasterVersion, :customerCrn, :accountNumber, :productCode, :logicOfSettlement, :maxSettlementPercentage, :maxSettlementAmount, :repaymentAction, :status, :debitLock, :processId, :slotReference, :customerName, :monthendSlot, :virtualAccountNumber, :accountType, :counterpartyCrn)")
    public int insert(@BindBean FgRuleAls fgruleals);

    /**
     * Finds a FgRuleAls by its ID.
     */
    @SqlQuery("SELECT * FROM FG_RULE_ALS WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgRuleAls.class)
    public Optional<FgRuleAls> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_RULE_ALS")
    @RegisterBeanMapper(FgRuleAls.class)
    public List<FgRuleAls> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_RULE_ALS ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgRuleAls.class)
    public List<FgRuleAls> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgRuleAls and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_RULE_ALS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IS_MASTER_VERSION = :isMasterVersion, CUSTOMER_CRN = :customerCrn, ACCOUNT_NUMBER = :accountNumber, PRODUCT_CODE = :productCode, LOGIC_OF_SETTLEMENT = :logicOfSettlement, MAX_SETTLEMENT_PERCENTAGE = :maxSettlementPercentage, MAX_SETTLEMENT_AMOUNT = :maxSettlementAmount, REPAYMENT_ACTION = :repaymentAction, STATUS = :status, DEBIT_LOCK = :debitLock, PROCESS_ID = :processId, SLOT_REFERENCE = :slotReference, CUSTOMER_NAME = :customerName, MONTHEND_SLOT = :monthendSlot, VIRTUAL_ACCOUNT_NUMBER = :virtualAccountNumber, ACCOUNT_TYPE = :accountType, COUNTERPARTY_CRN = :counterpartyCrn WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgRuleAls fgruleals);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_RULE_ALS WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_RULE_ALS")
    public long countAll();

    /**
     * Bulk insert multiple FgRuleAls entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_RULE_ALS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, CUSTOMER_CRN, ACCOUNT_NUMBER, PRODUCT_CODE, LOGIC_OF_SETTLEMENT, MAX_SETTLEMENT_PERCENTAGE, MAX_SETTLEMENT_AMOUNT, REPAYMENT_ACTION, STATUS, DEBIT_LOCK, PROCESS_ID, SLOT_REFERENCE, CUSTOMER_NAME, MONTHEND_SLOT, VIRTUAL_ACCOUNT_NUMBER, ACCOUNT_TYPE, COUNTERPARTY_CRN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :versionId, :isMasterVersion, :customerCrn, :accountNumber, :productCode, :logicOfSettlement, :maxSettlementPercentage, :maxSettlementAmount, :repaymentAction, :status, :debitLock, :processId, :slotReference, :customerName, :monthendSlot, :virtualAccountNumber, :accountType, :counterpartyCrn)")
    public int[] bulkInsert(@BindBean List<FgRuleAls> fgrulealss);

    /**
     * Bulk update multiple FgRuleAls entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_RULE_ALS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IS_MASTER_VERSION = :isMasterVersion, CUSTOMER_CRN = :customerCrn, ACCOUNT_NUMBER = :accountNumber, PRODUCT_CODE = :productCode, LOGIC_OF_SETTLEMENT = :logicOfSettlement, MAX_SETTLEMENT_PERCENTAGE = :maxSettlementPercentage, MAX_SETTLEMENT_AMOUNT = :maxSettlementAmount, REPAYMENT_ACTION = :repaymentAction, STATUS = :status, DEBIT_LOCK = :debitLock, PROCESS_ID = :processId, SLOT_REFERENCE = :slotReference, CUSTOMER_NAME = :customerName, MONTHEND_SLOT = :monthendSlot, VIRTUAL_ACCOUNT_NUMBER = :virtualAccountNumber, ACCOUNT_TYPE = :accountType, COUNTERPARTY_CRN = :counterpartyCrn WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgRuleAls> fgrulealss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_RULE_ALS WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_RULE_ALS WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgRuleAls records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_RULE_ALS WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgRuleAls.class)
    public List<FgRuleAls> findByIds(@BindList("ids") Collection<String> ids);
}
