package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.GtpXchRates;
import com.bsit.codegeneration.mapper.GtpXchRatesMapper;
import java.util.*;

@RegisterRowMapper(GtpXchRatesMapper.class)
public interface GtpXchRatesDao {

    @SqlQuery("SELECT * FROM GTP_XCH_RATES")
    public List<GtpXchRates> findAll();

    @SqlQuery("SELECT * FROM GTP_XCH_RATES WHERE id = :id")
    public Optional<GtpXchRates> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO GTP_XCH_RATES(BANK_ABBV_NAME, ISO_CODE, BASE_ISO_CODE, BRCH_CODE, BUY_TT_RATE, EURO_IN_CURRENCY, EURO_RATE, MID_TT_RATE, PATY_VAL, SELL_TT_RATE, UPDATE_DATE, START_VALUE_DATE, END_VALUE_DATE) VALUES (:BANK_ABBV_NAME, :ISO_CODE, :BASE_ISO_CODE, :BRCH_CODE, :BUY_TT_RATE, :EURO_IN_CURRENCY, :EURO_RATE, :MID_TT_RATE, :PATY_VAL, :SELL_TT_RATE, :UPDATE_DATE, :START_VALUE_DATE, :END_VALUE_DATE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() GtpXchRates entity);

    @SqlQuery("UPDATE GTP_XCH_RATES SET BANK_ABBV_NAME = :BANK_ABBV_NAME, ISO_CODE = :ISO_CODE, BASE_ISO_CODE = :BASE_ISO_CODE, BRCH_CODE = :BRCH_CODE, BUY_TT_RATE = :BUY_TT_RATE, EURO_IN_CURRENCY = :EURO_IN_CURRENCY, EURO_RATE = :EURO_RATE, MID_TT_RATE = :MID_TT_RATE, PATY_VAL = :PATY_VAL, SELL_TT_RATE = :SELL_TT_RATE, UPDATE_DATE = :UPDATE_DATE, START_VALUE_DATE = :START_VALUE_DATE, END_VALUE_DATE = :END_VALUE_DATE WHERE id = :id")
    public int update(@BindBean() GtpXchRates entity);

    @SqlQuery("DELETE FROM GTP_XCH_RATES WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
