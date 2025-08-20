package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTrdElcView;
import com.bsit.codegeneration.mapper.FgTrdElcViewMapper;
import java.util.*;

@RegisterRowMapper(FgTrdElcViewMapper.class)
public interface FgTrdElcViewDao {

    @SqlQuery("SELECT * FROM FG_TRD_ELC_VIEW")
    public List<FgTrdElcView> findAll();

    @SqlQuery("SELECT * FROM FG_TRD_ELC_VIEW WHERE id = :id")
    public Optional<FgTrdElcView> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TRD_ELC_VIEW(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, KOTAK_BILL_REF_ID, ISS_BANK_LC_REF_ID, TENOR, CUR_CODE, LODGE_DATE, OUTSTANDING_AMT, DSP_AMT, DEDUCTION, REASON, APPLICANT_NAME, APPLICANT_PARTY) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :KOTAK_BILL_REF_ID, :ISS_BANK_LC_REF_ID, :TENOR, :CUR_CODE, :LODGE_DATE, :OUTSTANDING_AMT, :DSP_AMT, :DEDUCTION, :REASON, :APPLICANT_NAME, :APPLICANT_PARTY)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTrdElcView entity);

    @SqlQuery("UPDATE FG_TRD_ELC_VIEW SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, KOTAK_BILL_REF_ID = :KOTAK_BILL_REF_ID, ISS_BANK_LC_REF_ID = :ISS_BANK_LC_REF_ID, TENOR = :TENOR, CUR_CODE = :CUR_CODE, LODGE_DATE = :LODGE_DATE, OUTSTANDING_AMT = :OUTSTANDING_AMT, DSP_AMT = :DSP_AMT, DEDUCTION = :DEDUCTION, REASON = :REASON, APPLICANT_NAME = :APPLICANT_NAME, APPLICANT_PARTY = :APPLICANT_PARTY WHERE id = :id")
    public int update(@BindBean() FgTrdElcView entity);

    @SqlQuery("DELETE FROM FG_TRD_ELC_VIEW WHERE id = :id")
    public int delete(@Bind("id") String id);
}
