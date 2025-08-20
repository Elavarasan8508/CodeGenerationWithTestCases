package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTdTenure;
import com.bsit.codegeneration.mapper.FgTdTenureMapper;
import java.util.*;

@RegisterRowMapper(FgTdTenureMapper.class)
public interface FgTdTenureDao {

    @SqlQuery("SELECT * FROM FG_TD_TENURE")
    public List<FgTdTenure> findAll();

    @SqlQuery("SELECT * FROM FG_TD_TENURE WHERE id = :id")
    public Optional<FgTdTenure> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_TD_TENURE(TENURE, INTEREST_RATES, RECOMMENDED, INTEREST, DAYS) VALUES (:TENURE, :INTEREST_RATES, :RECOMMENDED, :INTEREST, :DAYS)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgTdTenure entity);

    @SqlQuery("UPDATE FG_TD_TENURE SET TENURE = :TENURE, INTEREST_RATES = :INTEREST_RATES, RECOMMENDED = :RECOMMENDED, INTEREST = :INTEREST, DAYS = :DAYS WHERE id = :id")
    public int update(@BindBean() FgTdTenure entity);

    @SqlQuery("DELETE FROM FG_TD_TENURE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
