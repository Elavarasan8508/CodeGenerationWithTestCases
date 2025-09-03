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
import com.bsit.codegeneration.entity.TdAccountList;

public interface TdAccountListDao {

    /**
     * Inserts a new TdAccountList and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO TD_ACCOUNT_LIST (APPLICANT_PARTY, ACCOUNT_NAME, TD_ACCOUNT, ACCOUNT_NO, LIQ_DEPOSIT_AMOUNT, MATURITY_AMOUNT, ACCOUNT_SCHEME_CODE, START_DATE, LIQ_MATURITY_DATE, START_DATE_DISPLAY, LIQ_MATURITY_DATE_DISPLAY, AVAILABLE_BALANCE, END_DATE, FREEZEED_ACCOUNT, LIEN_AMOUNT, LIQ_INTEREST_RATE) VALUES (:applicantParty, :accountName, :tdAccount, :accountNo, :liqDepositAmount, :maturityAmount, :accountSchemeCode, :startDate, :liqMaturityDate, :startDateDisplay, :liqMaturityDateDisplay, :availableBalance, :endDate, :freezeedAccount, :lienAmount, :liqInterestRate)")
    public int insert(@BindBean TdAccountList tdaccountlist);

    /**
     * Finds a TdAccountList by its ID.
     */
    @SqlQuery("SELECT * FROM TD_ACCOUNT_LIST WHERE TD_ACCOUNT_LIST_id = :id")
    @RegisterBeanMapper(TdAccountList.class)
    public Optional<TdAccountList> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM TD_ACCOUNT_LIST")
    @RegisterBeanMapper(TdAccountList.class)
    public List<TdAccountList> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM TD_ACCOUNT_LIST ORDER BY TD_ACCOUNT_LIST_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(TdAccountList.class)
    public List<TdAccountList> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a TdAccountList and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE TD_ACCOUNT_LIST SET APPLICANT_PARTY = :applicantParty, ACCOUNT_NAME = :accountName, TD_ACCOUNT = :tdAccount, ACCOUNT_NO = :accountNo, LIQ_DEPOSIT_AMOUNT = :liqDepositAmount, MATURITY_AMOUNT = :maturityAmount, ACCOUNT_SCHEME_CODE = :accountSchemeCode, START_DATE = :startDate, LIQ_MATURITY_DATE = :liqMaturityDate, START_DATE_DISPLAY = :startDateDisplay, LIQ_MATURITY_DATE_DISPLAY = :liqMaturityDateDisplay, AVAILABLE_BALANCE = :availableBalance, END_DATE = :endDate, FREEZEED_ACCOUNT = :freezeedAccount, LIEN_AMOUNT = :lienAmount, LIQ_INTEREST_RATE = :liqInterestRate WHERE TD_ACCOUNT_LIST_id = :tdAccountListId")
    public int update(@BindBean TdAccountList tdaccountlist);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM TD_ACCOUNT_LIST WHERE TD_ACCOUNT_LIST_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM TD_ACCOUNT_LIST")
    public long countAll();

    /**
     * Bulk insert multiple TdAccountList entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO TD_ACCOUNT_LIST (APPLICANT_PARTY, ACCOUNT_NAME, TD_ACCOUNT, ACCOUNT_NO, LIQ_DEPOSIT_AMOUNT, MATURITY_AMOUNT, ACCOUNT_SCHEME_CODE, START_DATE, LIQ_MATURITY_DATE, START_DATE_DISPLAY, LIQ_MATURITY_DATE_DISPLAY, AVAILABLE_BALANCE, END_DATE, FREEZEED_ACCOUNT, LIEN_AMOUNT, LIQ_INTEREST_RATE) VALUES (:applicantParty, :accountName, :tdAccount, :accountNo, :liqDepositAmount, :maturityAmount, :accountSchemeCode, :startDate, :liqMaturityDate, :startDateDisplay, :liqMaturityDateDisplay, :availableBalance, :endDate, :freezeedAccount, :lienAmount, :liqInterestRate)")
    public int[] bulkInsert(@BindBean List<TdAccountList> tdaccountlists);

    /**
     * Bulk update multiple TdAccountList entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE TD_ACCOUNT_LIST SET APPLICANT_PARTY = :applicantParty, ACCOUNT_NAME = :accountName, TD_ACCOUNT = :tdAccount, ACCOUNT_NO = :accountNo, LIQ_DEPOSIT_AMOUNT = :liqDepositAmount, MATURITY_AMOUNT = :maturityAmount, ACCOUNT_SCHEME_CODE = :accountSchemeCode, START_DATE = :startDate, LIQ_MATURITY_DATE = :liqMaturityDate, START_DATE_DISPLAY = :startDateDisplay, LIQ_MATURITY_DATE_DISPLAY = :liqMaturityDateDisplay, AVAILABLE_BALANCE = :availableBalance, END_DATE = :endDate, FREEZEED_ACCOUNT = :freezeedAccount, LIEN_AMOUNT = :lienAmount, LIQ_INTEREST_RATE = :liqInterestRate WHERE TD_ACCOUNT_LIST_id = :tdAccountListId")
    public int[] bulkUpdate(@BindBean List<TdAccountList> tdaccountlists);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM TD_ACCOUNT_LIST WHERE TD_ACCOUNT_LIST_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM TD_ACCOUNT_LIST WHERE TD_ACCOUNT_LIST_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple TdAccountList records by their IDs.
     */
    @SqlQuery("SELECT * FROM TD_ACCOUNT_LIST WHERE TD_ACCOUNT_LIST_id IN (<ids>)")
    @RegisterBeanMapper(TdAccountList.class)
    public List<TdAccountList> findByIds(@BindList("ids") Collection<Integer> ids);
}
