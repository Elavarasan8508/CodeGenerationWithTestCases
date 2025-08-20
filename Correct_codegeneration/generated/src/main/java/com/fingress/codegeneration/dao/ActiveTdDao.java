package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.ActiveTd;
import com.bsit.codegeneration.mapper.ActiveTdMapper;
import java.util.*;

@RegisterRowMapper(ActiveTdMapper.class)
public interface ActiveTdDao {

    @SqlQuery("SELECT * FROM ACTIVE_TD")
    public List<ActiveTd> findAll();

    @SqlQuery("SELECT * FROM ACTIVE_TD WHERE id = :id")
    public Optional<ActiveTd> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO ACTIVE_TD(EFFECTIVE_DATE, AVAILABLE_AMOUNT, END_DATE, MATURITY_DATE, ACCOUNT_NAME, MATURITY_AMOUNT, TD_ACCOUNT_NO, INTEREST_RATE, LINKED_ACCOUNT, RN, DEPOSIT_AMOUNT) VALUES (:EFFECTIVE_DATE, :AVAILABLE_AMOUNT, :END_DATE, :MATURITY_DATE, :ACCOUNT_NAME, :MATURITY_AMOUNT, :TD_ACCOUNT_NO, :INTEREST_RATE, :LINKED_ACCOUNT, :RN, :DEPOSIT_AMOUNT)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() ActiveTd entity);

    @SqlQuery("UPDATE ACTIVE_TD SET EFFECTIVE_DATE = :EFFECTIVE_DATE, AVAILABLE_AMOUNT = :AVAILABLE_AMOUNT, END_DATE = :END_DATE, MATURITY_DATE = :MATURITY_DATE, ACCOUNT_NAME = :ACCOUNT_NAME, MATURITY_AMOUNT = :MATURITY_AMOUNT, TD_ACCOUNT_NO = :TD_ACCOUNT_NO, INTEREST_RATE = :INTEREST_RATE, LINKED_ACCOUNT = :LINKED_ACCOUNT, RN = :RN, DEPOSIT_AMOUNT = :DEPOSIT_AMOUNT WHERE id = :id")
    public int update(@BindBean() ActiveTd entity);

    @SqlQuery("DELETE FROM ACTIVE_TD WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
