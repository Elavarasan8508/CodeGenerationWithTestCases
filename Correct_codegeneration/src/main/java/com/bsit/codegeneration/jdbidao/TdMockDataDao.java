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
import com.bsit.codegeneration.entity.TdMockData;

public interface TdMockDataDao {

    /**
     * Inserts a new TdMockData and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO TD_MOCK_DATA (BANK_ID, ACCOUNT_NAME, TD_ACCOUNT_NO, TD_ACC_TEMP, CIF_ID, DEPOSIT_AMOUNT, MATURITY_AMOUNT, EFFECTIVE_DATE, MATURITY_DATE, AVAILABLE_AMOUNT, END_DATE, INTEREST_RATE, LINKED_ACCOUNT, BRANCH) VALUES (:bankId, :accountName, :tdAccountNo, :tdAccTemp, :cifId, :depositAmount, :maturityAmount, :effectiveDate, :maturityDate, :availableAmount, :endDate, :interestRate, :linkedAccount, :branch)")
    public int insert(@BindBean TdMockData tdmockdata);

    /**
     * Finds a TdMockData by its ID.
     */
    @SqlQuery("SELECT * FROM TD_MOCK_DATA WHERE TD_MOCK_DATA_id = :id")
    @RegisterBeanMapper(TdMockData.class)
    public Optional<TdMockData> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM TD_MOCK_DATA")
    @RegisterBeanMapper(TdMockData.class)
    public List<TdMockData> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM TD_MOCK_DATA ORDER BY TD_MOCK_DATA_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(TdMockData.class)
    public List<TdMockData> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a TdMockData and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE TD_MOCK_DATA SET BANK_ID = :bankId, ACCOUNT_NAME = :accountName, TD_ACCOUNT_NO = :tdAccountNo, TD_ACC_TEMP = :tdAccTemp, CIF_ID = :cifId, DEPOSIT_AMOUNT = :depositAmount, MATURITY_AMOUNT = :maturityAmount, EFFECTIVE_DATE = :effectiveDate, MATURITY_DATE = :maturityDate, AVAILABLE_AMOUNT = :availableAmount, END_DATE = :endDate, INTEREST_RATE = :interestRate, LINKED_ACCOUNT = :linkedAccount, BRANCH = :branch WHERE TD_MOCK_DATA_id = :tdMockDataId")
    public int update(@BindBean TdMockData tdmockdata);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM TD_MOCK_DATA WHERE TD_MOCK_DATA_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM TD_MOCK_DATA")
    public long countAll();

    /**
     * Bulk insert multiple TdMockData entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO TD_MOCK_DATA (BANK_ID, ACCOUNT_NAME, TD_ACCOUNT_NO, TD_ACC_TEMP, CIF_ID, DEPOSIT_AMOUNT, MATURITY_AMOUNT, EFFECTIVE_DATE, MATURITY_DATE, AVAILABLE_AMOUNT, END_DATE, INTEREST_RATE, LINKED_ACCOUNT, BRANCH) VALUES (:bankId, :accountName, :tdAccountNo, :tdAccTemp, :cifId, :depositAmount, :maturityAmount, :effectiveDate, :maturityDate, :availableAmount, :endDate, :interestRate, :linkedAccount, :branch)")
    public int[] bulkInsert(@BindBean List<TdMockData> tdmockdatas);

    /**
     * Bulk update multiple TdMockData entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE TD_MOCK_DATA SET BANK_ID = :bankId, ACCOUNT_NAME = :accountName, TD_ACCOUNT_NO = :tdAccountNo, TD_ACC_TEMP = :tdAccTemp, CIF_ID = :cifId, DEPOSIT_AMOUNT = :depositAmount, MATURITY_AMOUNT = :maturityAmount, EFFECTIVE_DATE = :effectiveDate, MATURITY_DATE = :maturityDate, AVAILABLE_AMOUNT = :availableAmount, END_DATE = :endDate, INTEREST_RATE = :interestRate, LINKED_ACCOUNT = :linkedAccount, BRANCH = :branch WHERE TD_MOCK_DATA_id = :tdMockDataId")
    public int[] bulkUpdate(@BindBean List<TdMockData> tdmockdatas);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM TD_MOCK_DATA WHERE TD_MOCK_DATA_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM TD_MOCK_DATA WHERE TD_MOCK_DATA_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple TdMockData records by their IDs.
     */
    @SqlQuery("SELECT * FROM TD_MOCK_DATA WHERE TD_MOCK_DATA_id IN (<ids>)")
    @RegisterBeanMapper(TdMockData.class)
    public List<TdMockData> findByIds(@BindList("ids") Collection<Integer> ids);
}
