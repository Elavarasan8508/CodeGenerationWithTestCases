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
import com.bsit.codegeneration.entity.FgAlsRepaymentHistory;

public interface FgAlsRepaymentHistoryDao {

    /**
     * Inserts a new FgAlsRepaymentHistory and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ALS_REPAYMENT_HISTORY (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUSTOMER_CRN, SETTLEMENT_AMT, ACCOUNT_NO, WEIGHT, STATUS, MATURITY_DATE, DISB_DATE, OVERDUE_Y_N, MASTER_REF, LOGIC_OF_SETTLEMENT, AVAILABLE_BALANCE, TOTAL_BALANCE, TOTAL_REPAYMENT_AMOUNT, PRINCIPLE_REPAYMENT_AMOUNT, INTEREST_REPAYMENT_AMOUNT, ACCOUNT_BALANCE, CUSTOMER_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :customerCrn, :settlementAmt, :accountNo, :weight, :status, :maturityDate, :disbDate, :overdueYN, :masterRef, :logicOfSettlement, :availableBalance, :totalBalance, :totalRepaymentAmount, :principleRepaymentAmount, :interestRepaymentAmount, :accountBalance, :customerName)")
    public int insert(@BindBean FgAlsRepaymentHistory fgalsrepaymenthistory);

    /**
     * Finds a FgAlsRepaymentHistory by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ALS_REPAYMENT_HISTORY WHERE ID = :id")
    @RegisterBeanMapper(FgAlsRepaymentHistory.class)
    public Optional<FgAlsRepaymentHistory> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ALS_REPAYMENT_HISTORY")
    @RegisterBeanMapper(FgAlsRepaymentHistory.class)
    public List<FgAlsRepaymentHistory> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ALS_REPAYMENT_HISTORY ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAlsRepaymentHistory.class)
    public List<FgAlsRepaymentHistory> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAlsRepaymentHistory and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ALS_REPAYMENT_HISTORY SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, CUSTOMER_CRN = :customerCrn, SETTLEMENT_AMT = :settlementAmt, ACCOUNT_NO = :accountNo, WEIGHT = :weight, STATUS = :status, MATURITY_DATE = :maturityDate, DISB_DATE = :disbDate, OVERDUE_Y_N = :overdueYN, MASTER_REF = :masterRef, LOGIC_OF_SETTLEMENT = :logicOfSettlement, AVAILABLE_BALANCE = :availableBalance, TOTAL_BALANCE = :totalBalance, TOTAL_REPAYMENT_AMOUNT = :totalRepaymentAmount, PRINCIPLE_REPAYMENT_AMOUNT = :principleRepaymentAmount, INTEREST_REPAYMENT_AMOUNT = :interestRepaymentAmount, ACCOUNT_BALANCE = :accountBalance, CUSTOMER_NAME = :customerName WHERE ID = :id")
    public int update(@BindBean FgAlsRepaymentHistory fgalsrepaymenthistory);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALS_REPAYMENT_HISTORY WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ALS_REPAYMENT_HISTORY")
    public long countAll();

    /**
     * Bulk insert multiple FgAlsRepaymentHistory entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ALS_REPAYMENT_HISTORY (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUSTOMER_CRN, SETTLEMENT_AMT, ACCOUNT_NO, WEIGHT, STATUS, MATURITY_DATE, DISB_DATE, OVERDUE_Y_N, MASTER_REF, LOGIC_OF_SETTLEMENT, AVAILABLE_BALANCE, TOTAL_BALANCE, TOTAL_REPAYMENT_AMOUNT, PRINCIPLE_REPAYMENT_AMOUNT, INTEREST_REPAYMENT_AMOUNT, ACCOUNT_BALANCE, CUSTOMER_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :customerCrn, :settlementAmt, :accountNo, :weight, :status, :maturityDate, :disbDate, :overdueYN, :masterRef, :logicOfSettlement, :availableBalance, :totalBalance, :totalRepaymentAmount, :principleRepaymentAmount, :interestRepaymentAmount, :accountBalance, :customerName)")
    public int[] bulkInsert(@BindBean List<FgAlsRepaymentHistory> fgalsrepaymenthistorys);

    /**
     * Bulk update multiple FgAlsRepaymentHistory entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ALS_REPAYMENT_HISTORY SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, CUSTOMER_CRN = :customerCrn, SETTLEMENT_AMT = :settlementAmt, ACCOUNT_NO = :accountNo, WEIGHT = :weight, STATUS = :status, MATURITY_DATE = :maturityDate, DISB_DATE = :disbDate, OVERDUE_Y_N = :overdueYN, MASTER_REF = :masterRef, LOGIC_OF_SETTLEMENT = :logicOfSettlement, AVAILABLE_BALANCE = :availableBalance, TOTAL_BALANCE = :totalBalance, TOTAL_REPAYMENT_AMOUNT = :totalRepaymentAmount, PRINCIPLE_REPAYMENT_AMOUNT = :principleRepaymentAmount, INTEREST_REPAYMENT_AMOUNT = :interestRepaymentAmount, ACCOUNT_BALANCE = :accountBalance, CUSTOMER_NAME = :customerName WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgAlsRepaymentHistory> fgalsrepaymenthistorys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALS_REPAYMENT_HISTORY WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ALS_REPAYMENT_HISTORY WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgAlsRepaymentHistory records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ALS_REPAYMENT_HISTORY WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgAlsRepaymentHistory.class)
    public List<FgAlsRepaymentHistory> findByIds(@BindList("ids") Collection<String> ids);
}
