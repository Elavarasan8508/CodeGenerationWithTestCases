package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTdAccountMaster;
import com.bsit.codegeneration.mapper.FgTdAccountMasterMapper;
import java.util.*;

@RegisterRowMapper(FgTdAccountMasterMapper.class)
public interface FgTdAccountMasterDao {

    @SqlQuery("SELECT * FROM FG_TD_ACCOUNT_MASTER")
    public List<FgTdAccountMaster> findAll();

    @SqlQuery("SELECT * FROM FG_TD_ACCOUNT_MASTER WHERE id = :id")
    public Optional<FgTdAccountMaster> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_TD_ACCOUNT_MASTER(DEBIT_ACC_NUM, ACC_USER_NAME, USER_TYPE, AVAIL_BALANCE, ACCT_TYPE, ACCT_NAME, SCHEME_CODE, CCY) VALUES (:DEBIT_ACC_NUM, :ACC_USER_NAME, :USER_TYPE, :AVAIL_BALANCE, :ACCT_TYPE, :ACCT_NAME, :SCHEME_CODE, :CCY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgTdAccountMaster entity);

    @SqlQuery("UPDATE FG_TD_ACCOUNT_MASTER SET DEBIT_ACC_NUM = :DEBIT_ACC_NUM, ACC_USER_NAME = :ACC_USER_NAME, USER_TYPE = :USER_TYPE, AVAIL_BALANCE = :AVAIL_BALANCE, ACCT_TYPE = :ACCT_TYPE, ACCT_NAME = :ACCT_NAME, SCHEME_CODE = :SCHEME_CODE, CCY = :CCY WHERE id = :id")
    public int update(@BindBean() FgTdAccountMaster entity);

    @SqlQuery("DELETE FROM FG_TD_ACCOUNT_MASTER WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
