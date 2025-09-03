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
import com.bsit.codegeneration.entity.FgTdAccountMaster;

public interface FgTdAccountMasterDao {

    /**
     * Inserts a new FgTdAccountMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_ACCOUNT_MASTER (DEBIT_ACC_NUM, ACC_USER_NAME, USER_TYPE, AVAIL_BALANCE, ACCT_TYPE, ACCT_NAME, SCHEME_CODE, CCY) VALUES (:debitAccNum, :accUserName, :userType, :availBalance, :acctType, :acctName, :schemeCode, :ccy)")
    public int insert(@BindBean FgTdAccountMaster fgtdaccountmaster);

    /**
     * Finds a FgTdAccountMaster by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_ACCOUNT_MASTER WHERE FG_TD_ACCOUNT_MASTER_id = :id")
    @RegisterBeanMapper(FgTdAccountMaster.class)
    public Optional<FgTdAccountMaster> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_ACCOUNT_MASTER")
    @RegisterBeanMapper(FgTdAccountMaster.class)
    public List<FgTdAccountMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_ACCOUNT_MASTER ORDER BY FG_TD_ACCOUNT_MASTER_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdAccountMaster.class)
    public List<FgTdAccountMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdAccountMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_ACCOUNT_MASTER SET DEBIT_ACC_NUM = :debitAccNum, ACC_USER_NAME = :accUserName, USER_TYPE = :userType, AVAIL_BALANCE = :availBalance, ACCT_TYPE = :acctType, ACCT_NAME = :acctName, SCHEME_CODE = :schemeCode, CCY = :ccy WHERE FG_TD_ACCOUNT_MASTER_id = :fgTdAccountMasterId")
    public int update(@BindBean FgTdAccountMaster fgtdaccountmaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_ACCOUNT_MASTER WHERE FG_TD_ACCOUNT_MASTER_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_ACCOUNT_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple FgTdAccountMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_ACCOUNT_MASTER (DEBIT_ACC_NUM, ACC_USER_NAME, USER_TYPE, AVAIL_BALANCE, ACCT_TYPE, ACCT_NAME, SCHEME_CODE, CCY) VALUES (:debitAccNum, :accUserName, :userType, :availBalance, :acctType, :acctName, :schemeCode, :ccy)")
    public int[] bulkInsert(@BindBean List<FgTdAccountMaster> fgtdaccountmasters);

    /**
     * Bulk update multiple FgTdAccountMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_ACCOUNT_MASTER SET DEBIT_ACC_NUM = :debitAccNum, ACC_USER_NAME = :accUserName, USER_TYPE = :userType, AVAIL_BALANCE = :availBalance, ACCT_TYPE = :acctType, ACCT_NAME = :acctName, SCHEME_CODE = :schemeCode, CCY = :ccy WHERE FG_TD_ACCOUNT_MASTER_id = :fgTdAccountMasterId")
    public int[] bulkUpdate(@BindBean List<FgTdAccountMaster> fgtdaccountmasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_ACCOUNT_MASTER WHERE FG_TD_ACCOUNT_MASTER_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_ACCOUNT_MASTER WHERE FG_TD_ACCOUNT_MASTER_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgTdAccountMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_ACCOUNT_MASTER WHERE FG_TD_ACCOUNT_MASTER_id IN (<ids>)")
    @RegisterBeanMapper(FgTdAccountMaster.class)
    public List<FgTdAccountMaster> findByIds(@BindList("ids") Collection<Integer> ids);
}
