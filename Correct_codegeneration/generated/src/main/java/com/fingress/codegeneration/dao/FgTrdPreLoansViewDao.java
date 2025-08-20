package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTrdPreLoansView;
import com.bsit.codegeneration.mapper.FgTrdPreLoansViewMapper;
import java.util.*;

@RegisterRowMapper(FgTrdPreLoansViewMapper.class)
public interface FgTrdPreLoansViewDao {

    @SqlQuery("SELECT * FROM FG_TRD_PRE_LOANS_VIEW")
    public List<FgTrdPreLoansView> findAll();

    @SqlQuery("SELECT * FROM FG_TRD_PRE_LOANS_VIEW WHERE id = :id")
    public Optional<FgTrdPreLoansView> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TRD_PRE_LOANS_VIEW(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PRE_LOAN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, IN_LOAN_CUR, DSP_AMT, EQU_DSP_AMT, APPLICANT_PARTY, DISB_DATE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :PRE_LOAN_REF_ID, :LOAN_REF_ID, :CUR_CODE, :PRINCIPAL_OUTSTANDING, :IN_LOAN_CUR, :DSP_AMT, :EQU_DSP_AMT, :APPLICANT_PARTY, :DISB_DATE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTrdPreLoansView entity);

    @SqlQuery("UPDATE FG_TRD_PRE_LOANS_VIEW SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, PRE_LOAN_REF_ID = :PRE_LOAN_REF_ID, LOAN_REF_ID = :LOAN_REF_ID, CUR_CODE = :CUR_CODE, PRINCIPAL_OUTSTANDING = :PRINCIPAL_OUTSTANDING, IN_LOAN_CUR = :IN_LOAN_CUR, DSP_AMT = :DSP_AMT, EQU_DSP_AMT = :EQU_DSP_AMT, APPLICANT_PARTY = :APPLICANT_PARTY, DISB_DATE = :DISB_DATE WHERE id = :id")
    public int update(@BindBean() FgTrdPreLoansView entity);

    @SqlQuery("DELETE FROM FG_TRD_PRE_LOANS_VIEW WHERE id = :id")
    public int delete(@Bind("id") String id);
}
