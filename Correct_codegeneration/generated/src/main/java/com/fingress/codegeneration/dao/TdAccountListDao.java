package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.TdAccountList;
import com.bsit.codegeneration.mapper.TdAccountListMapper;
import java.util.*;

@RegisterRowMapper(TdAccountListMapper.class)
public interface TdAccountListDao {

    @SqlQuery("SELECT * FROM TD_ACCOUNT_LIST")
    public List<TdAccountList> findAll();

    @SqlQuery("SELECT * FROM TD_ACCOUNT_LIST WHERE id = :id")
    public Optional<TdAccountList> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO TD_ACCOUNT_LIST(APPLICANT_PARTY, ACCOUNT_NAME, TD_ACCOUNT, ACCOUNT_NO, LIQ_DEPOSIT_AMOUNT, MATURITY_AMOUNT, ACCOUNT_SCHEME_CODE, START_DATE, LIQ_MATURITY_DATE, START_DATE_DISPLAY, LIQ_MATURITY_DATE_DISPLAY, AVAILABLE_BALANCE, END_DATE, FREEZEED_ACCOUNT, LIEN_AMOUNT, LIQ_INTEREST_RATE) VALUES (:APPLICANT_PARTY, :ACCOUNT_NAME, :TD_ACCOUNT, :ACCOUNT_NO, :LIQ_DEPOSIT_AMOUNT, :MATURITY_AMOUNT, :ACCOUNT_SCHEME_CODE, :START_DATE, :LIQ_MATURITY_DATE, :START_DATE_DISPLAY, :LIQ_MATURITY_DATE_DISPLAY, :AVAILABLE_BALANCE, :END_DATE, :FREEZEED_ACCOUNT, :LIEN_AMOUNT, :LIQ_INTEREST_RATE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() TdAccountList entity);

    @SqlQuery("UPDATE TD_ACCOUNT_LIST SET APPLICANT_PARTY = :APPLICANT_PARTY, ACCOUNT_NAME = :ACCOUNT_NAME, TD_ACCOUNT = :TD_ACCOUNT, ACCOUNT_NO = :ACCOUNT_NO, LIQ_DEPOSIT_AMOUNT = :LIQ_DEPOSIT_AMOUNT, MATURITY_AMOUNT = :MATURITY_AMOUNT, ACCOUNT_SCHEME_CODE = :ACCOUNT_SCHEME_CODE, START_DATE = :START_DATE, LIQ_MATURITY_DATE = :LIQ_MATURITY_DATE, START_DATE_DISPLAY = :START_DATE_DISPLAY, LIQ_MATURITY_DATE_DISPLAY = :LIQ_MATURITY_DATE_DISPLAY, AVAILABLE_BALANCE = :AVAILABLE_BALANCE, END_DATE = :END_DATE, FREEZEED_ACCOUNT = :FREEZEED_ACCOUNT, LIEN_AMOUNT = :LIEN_AMOUNT, LIQ_INTEREST_RATE = :LIQ_INTEREST_RATE WHERE id = :id")
    public int update(@BindBean() TdAccountList entity);

    @SqlQuery("DELETE FROM TD_ACCOUNT_LIST WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
