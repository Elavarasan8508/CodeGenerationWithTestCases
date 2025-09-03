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
import com.bsit.codegeneration.entity.ActiveTd;

public interface ActiveTdDao {

    /**
     * Inserts a new ActiveTd and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO ACTIVE_TD (EFFECTIVE_DATE, AVAILABLE_AMOUNT, END_DATE, MATURITY_DATE, ACCOUNT_NAME, MATURITY_AMOUNT, TD_ACCOUNT_NO, INTEREST_RATE, LINKED_ACCOUNT, RN, DEPOSIT_AMOUNT) VALUES (:effectiveDate, :availableAmount, :endDate, :maturityDate, :accountName, :maturityAmount, :tdAccountNo, :interestRate, :linkedAccount, :rn, :depositAmount)")
    public int insert(@BindBean ActiveTd activetd);

    /**
     * Finds a ActiveTd by its ID.
     */
    @SqlQuery("SELECT * FROM ACTIVE_TD WHERE ACTIVE_TD_id = :id")
    @RegisterBeanMapper(ActiveTd.class)
    public Optional<ActiveTd> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM ACTIVE_TD")
    @RegisterBeanMapper(ActiveTd.class)
    public List<ActiveTd> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM ACTIVE_TD ORDER BY ACTIVE_TD_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(ActiveTd.class)
    public List<ActiveTd> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a ActiveTd and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE ACTIVE_TD SET EFFECTIVE_DATE = :effectiveDate, AVAILABLE_AMOUNT = :availableAmount, END_DATE = :endDate, MATURITY_DATE = :maturityDate, ACCOUNT_NAME = :accountName, MATURITY_AMOUNT = :maturityAmount, TD_ACCOUNT_NO = :tdAccountNo, INTEREST_RATE = :interestRate, LINKED_ACCOUNT = :linkedAccount, RN = :rn, DEPOSIT_AMOUNT = :depositAmount WHERE ACTIVE_TD_id = :activeTdId")
    public int update(@BindBean ActiveTd activetd);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM ACTIVE_TD WHERE ACTIVE_TD_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM ACTIVE_TD")
    public long countAll();

    /**
     * Bulk insert multiple ActiveTd entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO ACTIVE_TD (EFFECTIVE_DATE, AVAILABLE_AMOUNT, END_DATE, MATURITY_DATE, ACCOUNT_NAME, MATURITY_AMOUNT, TD_ACCOUNT_NO, INTEREST_RATE, LINKED_ACCOUNT, RN, DEPOSIT_AMOUNT) VALUES (:effectiveDate, :availableAmount, :endDate, :maturityDate, :accountName, :maturityAmount, :tdAccountNo, :interestRate, :linkedAccount, :rn, :depositAmount)")
    public int[] bulkInsert(@BindBean List<ActiveTd> activetds);

    /**
     * Bulk update multiple ActiveTd entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE ACTIVE_TD SET EFFECTIVE_DATE = :effectiveDate, AVAILABLE_AMOUNT = :availableAmount, END_DATE = :endDate, MATURITY_DATE = :maturityDate, ACCOUNT_NAME = :accountName, MATURITY_AMOUNT = :maturityAmount, TD_ACCOUNT_NO = :tdAccountNo, INTEREST_RATE = :interestRate, LINKED_ACCOUNT = :linkedAccount, RN = :rn, DEPOSIT_AMOUNT = :depositAmount WHERE ACTIVE_TD_id = :activeTdId")
    public int[] bulkUpdate(@BindBean List<ActiveTd> activetds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM ACTIVE_TD WHERE ACTIVE_TD_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM ACTIVE_TD WHERE ACTIVE_TD_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple ActiveTd records by their IDs.
     */
    @SqlQuery("SELECT * FROM ACTIVE_TD WHERE ACTIVE_TD_id IN (<ids>)")
    @RegisterBeanMapper(ActiveTd.class)
    public List<ActiveTd> findByIds(@BindList("ids") Collection<Integer> ids);
}
