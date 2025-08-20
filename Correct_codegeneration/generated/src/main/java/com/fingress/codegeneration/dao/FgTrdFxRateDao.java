package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTrdFxRate;
import com.bsit.codegeneration.mapper.FgTrdFxRateMapper;
import java.util.*;

@RegisterRowMapper(FgTrdFxRateMapper.class)
public interface FgTrdFxRateDao {

    @SqlQuery("SELECT * FROM FG_TRD_FX_RATE")
    public List<FgTrdFxRate> findAll();

    @SqlQuery("SELECT * FROM FG_TRD_FX_RATE WHERE id = :id")
    public Optional<FgTrdFxRate> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TRD_FX_RATE(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, DEAL_REFERENCE, BUYING_CUR, BUYING_AMT, SELLING_CUR, SELLING_AMT, FX_RATE, PARENT_REF_ID, PARENT_VERSION_ID, FX_AMT, IR_REFERENCE_ID, DEAL_TYPE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :DEAL_REFERENCE, :BUYING_CUR, :BUYING_AMT, :SELLING_CUR, :SELLING_AMT, :FX_RATE, :PARENT_REF_ID, :PARENT_VERSION_ID, :FX_AMT, :IR_REFERENCE_ID, :DEAL_TYPE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTrdFxRate entity);

    @SqlQuery("UPDATE FG_TRD_FX_RATE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, DEAL_REFERENCE = :DEAL_REFERENCE, BUYING_CUR = :BUYING_CUR, BUYING_AMT = :BUYING_AMT, SELLING_CUR = :SELLING_CUR, SELLING_AMT = :SELLING_AMT, FX_RATE = :FX_RATE, PARENT_REF_ID = :PARENT_REF_ID, PARENT_VERSION_ID = :PARENT_VERSION_ID, FX_AMT = :FX_AMT, IR_REFERENCE_ID = :IR_REFERENCE_ID, DEAL_TYPE = :DEAL_TYPE WHERE id = :id")
    public int update(@BindBean() FgTrdFxRate entity);

    @SqlQuery("DELETE FROM FG_TRD_FX_RATE WHERE id = :id")
    public int delete(@Bind("id") String id);
}
