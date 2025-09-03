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
import com.bsit.codegeneration.entity.FgAlsAccStatement;

public interface FgAlsAccStatementDao {

    /**
     * Inserts a new FgAlsAccStatement and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ALS_ACC_STATEMENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TXN_TYPE, TRANSACTION_DATE, VIRTUAL_ACCOUNT_NUMBER, VALUE_DATE, REMARKS, PARTICULARS, CURRENCY, DEBIT_AMOUNT, CREDIT_AMOUNT, BALANCE, TXN_STATUS, LEDGER_TYPE, TI_THEIR_REFERENCE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :txnType, :transactionDate, :virtualAccountNumber, :valueDate, :remarks, :particulars, :currency, :debitAmount, :creditAmount, :balance, :txnStatus, :ledgerType, :tiTheirReference)")
    public int insert(@BindBean FgAlsAccStatement fgalsaccstatement);

    /**
     * Finds a FgAlsAccStatement by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ALS_ACC_STATEMENT WHERE ID = :id")
    @RegisterBeanMapper(FgAlsAccStatement.class)
    public Optional<FgAlsAccStatement> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ALS_ACC_STATEMENT")
    @RegisterBeanMapper(FgAlsAccStatement.class)
    public List<FgAlsAccStatement> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ALS_ACC_STATEMENT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAlsAccStatement.class)
    public List<FgAlsAccStatement> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAlsAccStatement and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ALS_ACC_STATEMENT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, TXN_TYPE = :txnType, TRANSACTION_DATE = :transactionDate, VIRTUAL_ACCOUNT_NUMBER = :virtualAccountNumber, VALUE_DATE = :valueDate, REMARKS = :remarks, PARTICULARS = :particulars, CURRENCY = :currency, DEBIT_AMOUNT = :debitAmount, CREDIT_AMOUNT = :creditAmount, BALANCE = :balance, TXN_STATUS = :txnStatus, LEDGER_TYPE = :ledgerType, TI_THEIR_REFERENCE = :tiTheirReference WHERE ID = :id")
    public int update(@BindBean FgAlsAccStatement fgalsaccstatement);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALS_ACC_STATEMENT WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ALS_ACC_STATEMENT")
    public long countAll();

    /**
     * Bulk insert multiple FgAlsAccStatement entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ALS_ACC_STATEMENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TXN_TYPE, TRANSACTION_DATE, VIRTUAL_ACCOUNT_NUMBER, VALUE_DATE, REMARKS, PARTICULARS, CURRENCY, DEBIT_AMOUNT, CREDIT_AMOUNT, BALANCE, TXN_STATUS, LEDGER_TYPE, TI_THEIR_REFERENCE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :txnType, :transactionDate, :virtualAccountNumber, :valueDate, :remarks, :particulars, :currency, :debitAmount, :creditAmount, :balance, :txnStatus, :ledgerType, :tiTheirReference)")
    public int[] bulkInsert(@BindBean List<FgAlsAccStatement> fgalsaccstatements);

    /**
     * Bulk update multiple FgAlsAccStatement entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ALS_ACC_STATEMENT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, TXN_TYPE = :txnType, TRANSACTION_DATE = :transactionDate, VIRTUAL_ACCOUNT_NUMBER = :virtualAccountNumber, VALUE_DATE = :valueDate, REMARKS = :remarks, PARTICULARS = :particulars, CURRENCY = :currency, DEBIT_AMOUNT = :debitAmount, CREDIT_AMOUNT = :creditAmount, BALANCE = :balance, TXN_STATUS = :txnStatus, LEDGER_TYPE = :ledgerType, TI_THEIR_REFERENCE = :tiTheirReference WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgAlsAccStatement> fgalsaccstatements);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALS_ACC_STATEMENT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ALS_ACC_STATEMENT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgAlsAccStatement records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ALS_ACC_STATEMENT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgAlsAccStatement.class)
    public List<FgAlsAccStatement> findByIds(@BindList("ids") Collection<String> ids);
}
