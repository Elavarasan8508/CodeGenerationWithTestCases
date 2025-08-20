package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTrdAccounts;
import com.bsit.codegeneration.mapper.FgTrdAccountsMapper;
import java.util.*;

@RegisterRowMapper(FgTrdAccountsMapper.class)
public interface FgTrdAccountsDao {

    @SqlQuery("SELECT * FROM FG_TRD_ACCOUNTS")
    public List<FgTrdAccounts> findAll();

    @SqlQuery("SELECT * FROM FG_TRD_ACCOUNTS WHERE id = :id")
    public Optional<FgTrdAccounts> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TRD_ACCOUNTS(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACC_NO, CUR_CODE, IN_ACC_CUR, DSP_AMT, EQU_DSP_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_PARTY) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :ACC_NO, :CUR_CODE, :IN_ACC_CUR, :DSP_AMT, :EQU_DSP_AMT, :PARENT_REF_ID, :PARENT_VERSION_ID, :IR_REFERENCE_ID, :APPLICANT_PARTY)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTrdAccounts entity);

    @SqlQuery("UPDATE FG_TRD_ACCOUNTS SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, ACC_NO = :ACC_NO, CUR_CODE = :CUR_CODE, IN_ACC_CUR = :IN_ACC_CUR, DSP_AMT = :DSP_AMT, EQU_DSP_AMT = :EQU_DSP_AMT, PARENT_REF_ID = :PARENT_REF_ID, PARENT_VERSION_ID = :PARENT_VERSION_ID, IR_REFERENCE_ID = :IR_REFERENCE_ID, APPLICANT_PARTY = :APPLICANT_PARTY WHERE id = :id")
    public int update(@BindBean() FgTrdAccounts entity);

    @SqlQuery("DELETE FROM FG_TRD_ACCOUNTS WHERE id = :id")
    public int delete(@Bind("id") String id);
}
