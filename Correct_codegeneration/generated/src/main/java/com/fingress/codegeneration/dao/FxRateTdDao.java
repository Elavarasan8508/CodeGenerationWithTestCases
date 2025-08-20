package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FxRateTd;
import com.bsit.codegeneration.mapper.FxRateTdMapper;
import java.util.*;

@RegisterRowMapper(FxRateTdMapper.class)
public interface FxRateTdDao {

    @SqlQuery("SELECT * FROM FX_RATE_TD")
    public List<FxRateTd> findAll();

    @SqlQuery("SELECT * FROM FX_RATE_TD WHERE id = :id")
    public Optional<FxRateTd> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FX_RATE_TD(INT_TBL_CODE, CRNCY_CODE, INT_SLAB_SRL_NUM, MAX_PERIOD_RUN_MTHS, MAX_PERIOD_RUN_DAYS, BEGIN_SLAB_AMOUNT, MAX_SLAB_AMOUNT, NRML_INT_PCNT) VALUES (:INT_TBL_CODE, :CRNCY_CODE, :INT_SLAB_SRL_NUM, :MAX_PERIOD_RUN_MTHS, :MAX_PERIOD_RUN_DAYS, :BEGIN_SLAB_AMOUNT, :MAX_SLAB_AMOUNT, :NRML_INT_PCNT)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FxRateTd entity);

    @SqlQuery("UPDATE FX_RATE_TD SET INT_TBL_CODE = :INT_TBL_CODE, CRNCY_CODE = :CRNCY_CODE, INT_SLAB_SRL_NUM = :INT_SLAB_SRL_NUM, MAX_PERIOD_RUN_MTHS = :MAX_PERIOD_RUN_MTHS, MAX_PERIOD_RUN_DAYS = :MAX_PERIOD_RUN_DAYS, BEGIN_SLAB_AMOUNT = :BEGIN_SLAB_AMOUNT, MAX_SLAB_AMOUNT = :MAX_SLAB_AMOUNT, NRML_INT_PCNT = :NRML_INT_PCNT WHERE id = :id")
    public int update(@BindBean() FxRateTd entity);

    @SqlQuery("DELETE FROM FX_RATE_TD WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
