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
import com.bsit.codegeneration.entity.FgLiquidationReq;

public interface FgLiquidationReqDao {

    /**
     * Inserts a new FgLiquidationReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LIQUIDATION_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TD_ACCOUNT, ACCOUNT_NAME, PRINCIPAL_AMOUNT, LIQ_INTEREST_RATE, CURRENT_BALANCE, START_DATE, LIQ_MATURITY_DATE, MATURITY_AMOUNT, INTEREST_ACCOUNT, PRINCIPAL_ACCOUNT, LIQUID_TYPE, LIQ_WITHDRAWN_AMOUNT, REMARKS, TERMS, AVAILABLE_BALANCE, LIQ_DEBIT_ACC_NO, LIQ_DEPOSIT_ACC_NO, LIQ_DEPOSIT_AMOUNT, LIEN_MARKED, NAME_OF_ACC, LIEN_AMOUNT, TRANSFER_TO, TASK_REASON, SCHEME_CODE, USER_TYPE, MAX_BOOKING_LIMIT, OTP_COUNT, OTP_RESENT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, OTP_FAILED_COUNT, UTILIZED_BOOKING_LIMIT, AVAILABLE_BOOKING_LIMIT, PENDING_UTILISED_LIMIT, PRODUCT_STATUS, FINACLE_STATUS, FINACLE_ERROR_CODE, FINACLE_ERROR_DESC, LIQ_WITHDRAWAL_INTEREST, ORIGIN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :tdAccount, :accountName, :principalAmount, :liqInterestRate, :currentBalance, :startDate, :liqMaturityDate, :maturityAmount, :interestAccount, :principalAccount, :liquidType, :liqWithdrawnAmount, :remarks, :terms, :availableBalance, :liqDebitAccNo, :liqDepositAccNo, :liqDepositAmount, :lienMarked, :nameOfAcc, :lienAmount, :transferTo, :taskReason, :schemeCode, :userType, :maxBookingLimit, :otpCount, :otpResent, :otpSentTime, :otpLockedTime, :otpUnlockTime, :otpFailedCount, :utilizedBookingLimit, :availableBookingLimit, :pendingUtilisedLimit, :productStatus, :finacleStatus, :finacleErrorCode, :finacleErrorDesc, :liqWithdrawalInterest, :origin)")
    public int insert(@BindBean FgLiquidationReq fgliquidationreq);

    /**
     * Finds a FgLiquidationReq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LIQUIDATION_REQ WHERE ID = :id")
    @RegisterBeanMapper(FgLiquidationReq.class)
    public Optional<FgLiquidationReq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LIQUIDATION_REQ")
    @RegisterBeanMapper(FgLiquidationReq.class)
    public List<FgLiquidationReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LIQUIDATION_REQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLiquidationReq.class)
    public List<FgLiquidationReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLiquidationReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LIQUIDATION_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, TD_ACCOUNT = :tdAccount, ACCOUNT_NAME = :accountName, PRINCIPAL_AMOUNT = :principalAmount, LIQ_INTEREST_RATE = :liqInterestRate, CURRENT_BALANCE = :currentBalance, START_DATE = :startDate, LIQ_MATURITY_DATE = :liqMaturityDate, MATURITY_AMOUNT = :maturityAmount, INTEREST_ACCOUNT = :interestAccount, PRINCIPAL_ACCOUNT = :principalAccount, LIQUID_TYPE = :liquidType, LIQ_WITHDRAWN_AMOUNT = :liqWithdrawnAmount, REMARKS = :remarks, TERMS = :terms, AVAILABLE_BALANCE = :availableBalance, LIQ_DEBIT_ACC_NO = :liqDebitAccNo, LIQ_DEPOSIT_ACC_NO = :liqDepositAccNo, LIQ_DEPOSIT_AMOUNT = :liqDepositAmount, LIEN_MARKED = :lienMarked, NAME_OF_ACC = :nameOfAcc, LIEN_AMOUNT = :lienAmount, TRANSFER_TO = :transferTo, TASK_REASON = :taskReason, SCHEME_CODE = :schemeCode, USER_TYPE = :userType, MAX_BOOKING_LIMIT = :maxBookingLimit, OTP_COUNT = :otpCount, OTP_RESENT = :otpResent, OTP_SENT_TIME = :otpSentTime, OTP_LOCKED_TIME = :otpLockedTime, OTP_UNLOCK_TIME = :otpUnlockTime, OTP_FAILED_COUNT = :otpFailedCount, UTILIZED_BOOKING_LIMIT = :utilizedBookingLimit, AVAILABLE_BOOKING_LIMIT = :availableBookingLimit, PENDING_UTILISED_LIMIT = :pendingUtilisedLimit, PRODUCT_STATUS = :productStatus, FINACLE_STATUS = :finacleStatus, FINACLE_ERROR_CODE = :finacleErrorCode, FINACLE_ERROR_DESC = :finacleErrorDesc, LIQ_WITHDRAWAL_INTEREST = :liqWithdrawalInterest, ORIGIN = :origin WHERE ID = :id")
    public int update(@BindBean FgLiquidationReq fgliquidationreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LIQUIDATION_REQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LIQUIDATION_REQ")
    public long countAll();

    /**
     * Bulk insert multiple FgLiquidationReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LIQUIDATION_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TD_ACCOUNT, ACCOUNT_NAME, PRINCIPAL_AMOUNT, LIQ_INTEREST_RATE, CURRENT_BALANCE, START_DATE, LIQ_MATURITY_DATE, MATURITY_AMOUNT, INTEREST_ACCOUNT, PRINCIPAL_ACCOUNT, LIQUID_TYPE, LIQ_WITHDRAWN_AMOUNT, REMARKS, TERMS, AVAILABLE_BALANCE, LIQ_DEBIT_ACC_NO, LIQ_DEPOSIT_ACC_NO, LIQ_DEPOSIT_AMOUNT, LIEN_MARKED, NAME_OF_ACC, LIEN_AMOUNT, TRANSFER_TO, TASK_REASON, SCHEME_CODE, USER_TYPE, MAX_BOOKING_LIMIT, OTP_COUNT, OTP_RESENT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, OTP_FAILED_COUNT, UTILIZED_BOOKING_LIMIT, AVAILABLE_BOOKING_LIMIT, PENDING_UTILISED_LIMIT, PRODUCT_STATUS, FINACLE_STATUS, FINACLE_ERROR_CODE, FINACLE_ERROR_DESC, LIQ_WITHDRAWAL_INTEREST, ORIGIN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :tdAccount, :accountName, :principalAmount, :liqInterestRate, :currentBalance, :startDate, :liqMaturityDate, :maturityAmount, :interestAccount, :principalAccount, :liquidType, :liqWithdrawnAmount, :remarks, :terms, :availableBalance, :liqDebitAccNo, :liqDepositAccNo, :liqDepositAmount, :lienMarked, :nameOfAcc, :lienAmount, :transferTo, :taskReason, :schemeCode, :userType, :maxBookingLimit, :otpCount, :otpResent, :otpSentTime, :otpLockedTime, :otpUnlockTime, :otpFailedCount, :utilizedBookingLimit, :availableBookingLimit, :pendingUtilisedLimit, :productStatus, :finacleStatus, :finacleErrorCode, :finacleErrorDesc, :liqWithdrawalInterest, :origin)")
    public int[] bulkInsert(@BindBean List<FgLiquidationReq> fgliquidationreqs);

    /**
     * Bulk update multiple FgLiquidationReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LIQUIDATION_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, TD_ACCOUNT = :tdAccount, ACCOUNT_NAME = :accountName, PRINCIPAL_AMOUNT = :principalAmount, LIQ_INTEREST_RATE = :liqInterestRate, CURRENT_BALANCE = :currentBalance, START_DATE = :startDate, LIQ_MATURITY_DATE = :liqMaturityDate, MATURITY_AMOUNT = :maturityAmount, INTEREST_ACCOUNT = :interestAccount, PRINCIPAL_ACCOUNT = :principalAccount, LIQUID_TYPE = :liquidType, LIQ_WITHDRAWN_AMOUNT = :liqWithdrawnAmount, REMARKS = :remarks, TERMS = :terms, AVAILABLE_BALANCE = :availableBalance, LIQ_DEBIT_ACC_NO = :liqDebitAccNo, LIQ_DEPOSIT_ACC_NO = :liqDepositAccNo, LIQ_DEPOSIT_AMOUNT = :liqDepositAmount, LIEN_MARKED = :lienMarked, NAME_OF_ACC = :nameOfAcc, LIEN_AMOUNT = :lienAmount, TRANSFER_TO = :transferTo, TASK_REASON = :taskReason, SCHEME_CODE = :schemeCode, USER_TYPE = :userType, MAX_BOOKING_LIMIT = :maxBookingLimit, OTP_COUNT = :otpCount, OTP_RESENT = :otpResent, OTP_SENT_TIME = :otpSentTime, OTP_LOCKED_TIME = :otpLockedTime, OTP_UNLOCK_TIME = :otpUnlockTime, OTP_FAILED_COUNT = :otpFailedCount, UTILIZED_BOOKING_LIMIT = :utilizedBookingLimit, AVAILABLE_BOOKING_LIMIT = :availableBookingLimit, PENDING_UTILISED_LIMIT = :pendingUtilisedLimit, PRODUCT_STATUS = :productStatus, FINACLE_STATUS = :finacleStatus, FINACLE_ERROR_CODE = :finacleErrorCode, FINACLE_ERROR_DESC = :finacleErrorDesc, LIQ_WITHDRAWAL_INTEREST = :liqWithdrawalInterest, ORIGIN = :origin WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgLiquidationReq> fgliquidationreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LIQUIDATION_REQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LIQUIDATION_REQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgLiquidationReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LIQUIDATION_REQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgLiquidationReq.class)
    public List<FgLiquidationReq> findByIds(@BindList("ids") Collection<String> ids);
}
