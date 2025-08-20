package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.TdMockData;
import com.bsit.codegeneration.mapper.TdMockDataMapper;
import java.util.*;

@RegisterRowMapper(TdMockDataMapper.class)
public interface TdMockDataDao {

    @SqlQuery("SELECT * FROM TD_MOCK_DATA")
    public List<TdMockData> findAll();

    @SqlQuery("SELECT * FROM TD_MOCK_DATA WHERE id = :id")
    public Optional<TdMockData> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO TD_MOCK_DATA(BANK_ID, ACCOUNT_NAME, TD_ACCOUNT_NO, TD_ACC_TEMP, CIF_ID, DEPOSIT_AMOUNT, MATURITY_AMOUNT, EFFECTIVE_DATE, MATURITY_DATE, AVAILABLE_AMOUNT, END_DATE, INTEREST_RATE, LINKED_ACCOUNT, BRANCH) VALUES (:BANK_ID, :ACCOUNT_NAME, :TD_ACCOUNT_NO, :TD_ACC_TEMP, :CIF_ID, :DEPOSIT_AMOUNT, :MATURITY_AMOUNT, :EFFECTIVE_DATE, :MATURITY_DATE, :AVAILABLE_AMOUNT, :END_DATE, :INTEREST_RATE, :LINKED_ACCOUNT, :BRANCH)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() TdMockData entity);

    @SqlQuery("UPDATE TD_MOCK_DATA SET BANK_ID = :BANK_ID, ACCOUNT_NAME = :ACCOUNT_NAME, TD_ACCOUNT_NO = :TD_ACCOUNT_NO, TD_ACC_TEMP = :TD_ACC_TEMP, CIF_ID = :CIF_ID, DEPOSIT_AMOUNT = :DEPOSIT_AMOUNT, MATURITY_AMOUNT = :MATURITY_AMOUNT, EFFECTIVE_DATE = :EFFECTIVE_DATE, MATURITY_DATE = :MATURITY_DATE, AVAILABLE_AMOUNT = :AVAILABLE_AMOUNT, END_DATE = :END_DATE, INTEREST_RATE = :INTEREST_RATE, LINKED_ACCOUNT = :LINKED_ACCOUNT, BRANCH = :BRANCH WHERE id = :id")
    public int update(@BindBean() TdMockData entity);

    @SqlQuery("DELETE FROM TD_MOCK_DATA WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
