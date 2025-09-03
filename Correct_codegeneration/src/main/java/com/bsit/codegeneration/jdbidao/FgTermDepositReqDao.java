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
import com.bsit.codegeneration.entity.FgTermDepositReq;

public interface FgTermDepositReqDao {

    /**
     * Inserts a new FgTermDepositReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TERM_DEPOSIT_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, USER_CRN, USER_NAME, USER_EMAIL, USER_MOBILE, DEPOSIT_AMOUNT, CCY, ACCOUNT_NAME, ACCOUNT_TYPE, TENURE_DAYS, CUSTOM_TENURE, INTEREST_RATE, MATURITY_DATE, PRODUCT_STATUS, TASK_REASON, DEBIT_ACC_NUM, INTEREST_ACCOUNT, PRINCIPAL_ACCOUNT, LIEN_AMOUNT, LIEN_MARKED, ACC_BALANCE, PRINCIPAL_AMOUNT, MATURITY_AMOUNT, INTEREST_AMOUNT, INTEREST_PAY_PLAN, INTEREST_DESCRIPTION, MATURITY_INSTRUCTION, SCHEME_CODE, USER_TYPE, TERMS, IT_TYPE, OTP_COUNT, OTP_RESENT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, OTP_FAILED_COUNT, TD_MIN_AMOUNT, TD_MAX_AMOUNT, MAX_BOOKING_LIMIT, UTILISED_BOOKING_LIMIT, AVAILABLE_BOOKING_LIMIT, PENDING_UTILISED_LIMIT, YEAR, MONTH, DAYS, TD_ACCOUNT_NUMBER, FINACLE_STATUS, OPTIONAL_RANGE, ORIGIN, TD_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :userCrn, :userName, :userEmail, :userMobile, :depositAmount, :ccy, :accountName, :accountType, :tenureDays, :customTenure, :interestRate, :maturityDate, :productStatus, :taskReason, :debitAccNum, :interestAccount, :principalAccount, :lienAmount, :lienMarked, :accBalance, :principalAmount, :maturityAmount, :interestAmount, :interestPayPlan, :interestDescription, :maturityInstruction, :schemeCode, :userType, :terms, :itType, :otpCount, :otpResent, :otpSentTime, :otpLockedTime, :otpUnlockTime, :otpFailedCount, :tdMinAmount, :tdMaxAmount, :maxBookingLimit, :utilisedBookingLimit, :availableBookingLimit, :pendingUtilisedLimit, :year, :month, :days, :tdAccountNumber, :finacleStatus, :optionalRange, :origin, :tdType)")
    public int insert(@BindBean FgTermDepositReq fgtermdepositreq);

    /**
     * Finds a FgTermDepositReq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TERM_DEPOSIT_REQ WHERE ID = :id")
    @RegisterBeanMapper(FgTermDepositReq.class)
    public Optional<FgTermDepositReq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TERM_DEPOSIT_REQ")
    @RegisterBeanMapper(FgTermDepositReq.class)
    public List<FgTermDepositReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TERM_DEPOSIT_REQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTermDepositReq.class)
    public List<FgTermDepositReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTermDepositReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TERM_DEPOSIT_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, USER_CRN = :userCrn, USER_NAME = :userName, USER_EMAIL = :userEmail, USER_MOBILE = :userMobile, DEPOSIT_AMOUNT = :depositAmount, CCY = :ccy, ACCOUNT_NAME = :accountName, ACCOUNT_TYPE = :accountType, TENURE_DAYS = :tenureDays, CUSTOM_TENURE = :customTenure, INTEREST_RATE = :interestRate, MATURITY_DATE = :maturityDate, PRODUCT_STATUS = :productStatus, TASK_REASON = :taskReason, DEBIT_ACC_NUM = :debitAccNum, INTEREST_ACCOUNT = :interestAccount, PRINCIPAL_ACCOUNT = :principalAccount, LIEN_AMOUNT = :lienAmount, LIEN_MARKED = :lienMarked, ACC_BALANCE = :accBalance, PRINCIPAL_AMOUNT = :principalAmount, MATURITY_AMOUNT = :maturityAmount, INTEREST_AMOUNT = :interestAmount, INTEREST_PAY_PLAN = :interestPayPlan, INTEREST_DESCRIPTION = :interestDescription, MATURITY_INSTRUCTION = :maturityInstruction, SCHEME_CODE = :schemeCode, USER_TYPE = :userType, TERMS = :terms, IT_TYPE = :itType, OTP_COUNT = :otpCount, OTP_RESENT = :otpResent, OTP_SENT_TIME = :otpSentTime, OTP_LOCKED_TIME = :otpLockedTime, OTP_UNLOCK_TIME = :otpUnlockTime, OTP_FAILED_COUNT = :otpFailedCount, TD_MIN_AMOUNT = :tdMinAmount, TD_MAX_AMOUNT = :tdMaxAmount, MAX_BOOKING_LIMIT = :maxBookingLimit, UTILISED_BOOKING_LIMIT = :utilisedBookingLimit, AVAILABLE_BOOKING_LIMIT = :availableBookingLimit, PENDING_UTILISED_LIMIT = :pendingUtilisedLimit, YEAR = :year, MONTH = :month, DAYS = :days, TD_ACCOUNT_NUMBER = :tdAccountNumber, FINACLE_STATUS = :finacleStatus, OPTIONAL_RANGE = :optionalRange, ORIGIN = :origin, TD_TYPE = :tdType WHERE ID = :id")
    public int update(@BindBean FgTermDepositReq fgtermdepositreq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TERM_DEPOSIT_REQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TERM_DEPOSIT_REQ")
    public long countAll();

    /**
     * Bulk insert multiple FgTermDepositReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TERM_DEPOSIT_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, USER_CRN, USER_NAME, USER_EMAIL, USER_MOBILE, DEPOSIT_AMOUNT, CCY, ACCOUNT_NAME, ACCOUNT_TYPE, TENURE_DAYS, CUSTOM_TENURE, INTEREST_RATE, MATURITY_DATE, PRODUCT_STATUS, TASK_REASON, DEBIT_ACC_NUM, INTEREST_ACCOUNT, PRINCIPAL_ACCOUNT, LIEN_AMOUNT, LIEN_MARKED, ACC_BALANCE, PRINCIPAL_AMOUNT, MATURITY_AMOUNT, INTEREST_AMOUNT, INTEREST_PAY_PLAN, INTEREST_DESCRIPTION, MATURITY_INSTRUCTION, SCHEME_CODE, USER_TYPE, TERMS, IT_TYPE, OTP_COUNT, OTP_RESENT, OTP_SENT_TIME, OTP_LOCKED_TIME, OTP_UNLOCK_TIME, OTP_FAILED_COUNT, TD_MIN_AMOUNT, TD_MAX_AMOUNT, MAX_BOOKING_LIMIT, UTILISED_BOOKING_LIMIT, AVAILABLE_BOOKING_LIMIT, PENDING_UTILISED_LIMIT, YEAR, MONTH, DAYS, TD_ACCOUNT_NUMBER, FINACLE_STATUS, OPTIONAL_RANGE, ORIGIN, TD_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :userCrn, :userName, :userEmail, :userMobile, :depositAmount, :ccy, :accountName, :accountType, :tenureDays, :customTenure, :interestRate, :maturityDate, :productStatus, :taskReason, :debitAccNum, :interestAccount, :principalAccount, :lienAmount, :lienMarked, :accBalance, :principalAmount, :maturityAmount, :interestAmount, :interestPayPlan, :interestDescription, :maturityInstruction, :schemeCode, :userType, :terms, :itType, :otpCount, :otpResent, :otpSentTime, :otpLockedTime, :otpUnlockTime, :otpFailedCount, :tdMinAmount, :tdMaxAmount, :maxBookingLimit, :utilisedBookingLimit, :availableBookingLimit, :pendingUtilisedLimit, :year, :month, :days, :tdAccountNumber, :finacleStatus, :optionalRange, :origin, :tdType)")
    public int[] bulkInsert(@BindBean List<FgTermDepositReq> fgtermdepositreqs);

    /**
     * Bulk update multiple FgTermDepositReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TERM_DEPOSIT_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, USER_CRN = :userCrn, USER_NAME = :userName, USER_EMAIL = :userEmail, USER_MOBILE = :userMobile, DEPOSIT_AMOUNT = :depositAmount, CCY = :ccy, ACCOUNT_NAME = :accountName, ACCOUNT_TYPE = :accountType, TENURE_DAYS = :tenureDays, CUSTOM_TENURE = :customTenure, INTEREST_RATE = :interestRate, MATURITY_DATE = :maturityDate, PRODUCT_STATUS = :productStatus, TASK_REASON = :taskReason, DEBIT_ACC_NUM = :debitAccNum, INTEREST_ACCOUNT = :interestAccount, PRINCIPAL_ACCOUNT = :principalAccount, LIEN_AMOUNT = :lienAmount, LIEN_MARKED = :lienMarked, ACC_BALANCE = :accBalance, PRINCIPAL_AMOUNT = :principalAmount, MATURITY_AMOUNT = :maturityAmount, INTEREST_AMOUNT = :interestAmount, INTEREST_PAY_PLAN = :interestPayPlan, INTEREST_DESCRIPTION = :interestDescription, MATURITY_INSTRUCTION = :maturityInstruction, SCHEME_CODE = :schemeCode, USER_TYPE = :userType, TERMS = :terms, IT_TYPE = :itType, OTP_COUNT = :otpCount, OTP_RESENT = :otpResent, OTP_SENT_TIME = :otpSentTime, OTP_LOCKED_TIME = :otpLockedTime, OTP_UNLOCK_TIME = :otpUnlockTime, OTP_FAILED_COUNT = :otpFailedCount, TD_MIN_AMOUNT = :tdMinAmount, TD_MAX_AMOUNT = :tdMaxAmount, MAX_BOOKING_LIMIT = :maxBookingLimit, UTILISED_BOOKING_LIMIT = :utilisedBookingLimit, AVAILABLE_BOOKING_LIMIT = :availableBookingLimit, PENDING_UTILISED_LIMIT = :pendingUtilisedLimit, YEAR = :year, MONTH = :month, DAYS = :days, TD_ACCOUNT_NUMBER = :tdAccountNumber, FINACLE_STATUS = :finacleStatus, OPTIONAL_RANGE = :optionalRange, ORIGIN = :origin, TD_TYPE = :tdType WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTermDepositReq> fgtermdepositreqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TERM_DEPOSIT_REQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TERM_DEPOSIT_REQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTermDepositReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TERM_DEPOSIT_REQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTermDepositReq.class)
    public List<FgTermDepositReq> findByIds(@BindList("ids") Collection<String> ids);
}
