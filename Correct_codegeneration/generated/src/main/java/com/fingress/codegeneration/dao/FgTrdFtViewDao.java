package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTrdFtView;
import com.bsit.codegeneration.mapper.FgTrdFtViewMapper;
import java.util.*;

@RegisterRowMapper(FgTrdFtViewMapper.class)
public interface FgTrdFtViewDao {

    @SqlQuery("SELECT * FROM FG_TRD_FT_VIEW")
    public List<FgTrdFtView> findAll();

    @SqlQuery("SELECT * FROM FG_TRD_FT_VIEW WHERE id = :id")
    public Optional<FgTrdFtView> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TRD_FT_VIEW(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUR_CODE, LODGE_DATE, DRAWEE, OUTSTANDING_AMT, OUTSTANDING_AMT_SETTLED, DSP_AMT, DEDUCTION, REASON, OCF_REF_ID, APPLICANT_PARTY) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :CUR_CODE, :LODGE_DATE, :DRAWEE, :OUTSTANDING_AMT, :OUTSTANDING_AMT_SETTLED, :DSP_AMT, :DEDUCTION, :REASON, :OCF_REF_ID, :APPLICANT_PARTY)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTrdFtView entity);

    @SqlQuery("UPDATE FG_TRD_FT_VIEW SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, CUR_CODE = :CUR_CODE, LODGE_DATE = :LODGE_DATE, DRAWEE = :DRAWEE, OUTSTANDING_AMT = :OUTSTANDING_AMT, OUTSTANDING_AMT_SETTLED = :OUTSTANDING_AMT_SETTLED, DSP_AMT = :DSP_AMT, DEDUCTION = :DEDUCTION, REASON = :REASON, OCF_REF_ID = :OCF_REF_ID, APPLICANT_PARTY = :APPLICANT_PARTY WHERE id = :id")
    public int update(@BindBean() FgTrdFtView entity);

    @SqlQuery("DELETE FROM FG_TRD_FT_VIEW WHERE id = :id")
    public int delete(@Bind("id") String id);
}
