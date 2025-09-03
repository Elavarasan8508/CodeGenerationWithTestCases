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
import com.bsit.codegeneration.entity.FgAlsExecution;

public interface FgAlsExecutionDao {

    /**
     * Inserts a new FgAlsExecution and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ALS_EXECUTION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUSTOMER_CRN, ACCOUNT_NO, LAST_EXECUTION, STATUS, TOTAL_LOANS, PROCESSED_LOANS, ERROR_DESC, ACCOUNT_BALANCE, TOTAL_BALANCE, REASON, EXECUTION_START_TIME, EXECUTION_END_TIME, FINACLE_STATUS, ACCOUNT_STATUS, DEBIT_LOCK, CUSTOMER_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :customerCrn, :accountNo, :lastExecution, :status, :totalLoans, :processedLoans, :errorDesc, :accountBalance, :totalBalance, :reason, :executionStartTime, :executionEndTime, :finacleStatus, :accountStatus, :debitLock, :customerName)")
    public int insert(@BindBean FgAlsExecution fgalsexecution);

    /**
     * Finds a FgAlsExecution by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ALS_EXECUTION WHERE ID = :id")
    @RegisterBeanMapper(FgAlsExecution.class)
    public Optional<FgAlsExecution> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ALS_EXECUTION")
    @RegisterBeanMapper(FgAlsExecution.class)
    public List<FgAlsExecution> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ALS_EXECUTION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAlsExecution.class)
    public List<FgAlsExecution> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAlsExecution and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ALS_EXECUTION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, CUSTOMER_CRN = :customerCrn, ACCOUNT_NO = :accountNo, LAST_EXECUTION = :lastExecution, STATUS = :status, TOTAL_LOANS = :totalLoans, PROCESSED_LOANS = :processedLoans, ERROR_DESC = :errorDesc, ACCOUNT_BALANCE = :accountBalance, TOTAL_BALANCE = :totalBalance, REASON = :reason, EXECUTION_START_TIME = :executionStartTime, EXECUTION_END_TIME = :executionEndTime, FINACLE_STATUS = :finacleStatus, ACCOUNT_STATUS = :accountStatus, DEBIT_LOCK = :debitLock, CUSTOMER_NAME = :customerName WHERE ID = :id")
    public int update(@BindBean FgAlsExecution fgalsexecution);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALS_EXECUTION WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ALS_EXECUTION")
    public long countAll();

    /**
     * Bulk insert multiple FgAlsExecution entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ALS_EXECUTION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUSTOMER_CRN, ACCOUNT_NO, LAST_EXECUTION, STATUS, TOTAL_LOANS, PROCESSED_LOANS, ERROR_DESC, ACCOUNT_BALANCE, TOTAL_BALANCE, REASON, EXECUTION_START_TIME, EXECUTION_END_TIME, FINACLE_STATUS, ACCOUNT_STATUS, DEBIT_LOCK, CUSTOMER_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :customerCrn, :accountNo, :lastExecution, :status, :totalLoans, :processedLoans, :errorDesc, :accountBalance, :totalBalance, :reason, :executionStartTime, :executionEndTime, :finacleStatus, :accountStatus, :debitLock, :customerName)")
    public int[] bulkInsert(@BindBean List<FgAlsExecution> fgalsexecutions);

    /**
     * Bulk update multiple FgAlsExecution entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ALS_EXECUTION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, CUSTOMER_CRN = :customerCrn, ACCOUNT_NO = :accountNo, LAST_EXECUTION = :lastExecution, STATUS = :status, TOTAL_LOANS = :totalLoans, PROCESSED_LOANS = :processedLoans, ERROR_DESC = :errorDesc, ACCOUNT_BALANCE = :accountBalance, TOTAL_BALANCE = :totalBalance, REASON = :reason, EXECUTION_START_TIME = :executionStartTime, EXECUTION_END_TIME = :executionEndTime, FINACLE_STATUS = :finacleStatus, ACCOUNT_STATUS = :accountStatus, DEBIT_LOCK = :debitLock, CUSTOMER_NAME = :customerName WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgAlsExecution> fgalsexecutions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ALS_EXECUTION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ALS_EXECUTION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgAlsExecution records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ALS_EXECUTION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgAlsExecution.class)
    public List<FgAlsExecution> findByIds(@BindList("ids") Collection<String> ids);
}
