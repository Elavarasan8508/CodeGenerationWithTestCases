package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTrdExpRegRq;
import com.bsit.codegeneration.mapper.FgTrdExpRegRqMapper;
import java.util.*;

@RegisterRowMapper(FgTrdExpRegRqMapper.class)
public interface FgTrdExpRegRqDao {

    @SqlQuery("SELECT * FROM FG_TRD_EXP_REG_RQ")
    public List<FgTrdExpRegRq> findAll();

    @SqlQuery("SELECT * FROM FG_TRD_EXP_REG_RQ WHERE id = :id")
    public Optional<FgTrdExpRegRq> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TRD_EXP_REG_RQ(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PORT_CODE, EXP_TYPE, SB_NO, SB_DATE, FORM_NO, IE_CODE, REQ_TYPE, IRM_NO, IRM_AD, IRM_AMT, OS_AMT_IRM, IRM_CCY, APPLICANT_PARTY, ISSUING_PARTY, PRODUCT_STATUS, PROCESS_ID, DMS_EVENT_ID, EXP_AGENCY, DEBIT_ACC_NUM) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :PORT_CODE, :EXP_TYPE, :SB_NO, :SB_DATE, :FORM_NO, :IE_CODE, :REQ_TYPE, :IRM_NO, :IRM_AD, :IRM_AMT, :OS_AMT_IRM, :IRM_CCY, :APPLICANT_PARTY, :ISSUING_PARTY, :PRODUCT_STATUS, :PROCESS_ID, :DMS_EVENT_ID, :EXP_AGENCY, :DEBIT_ACC_NUM)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTrdExpRegRq entity);

    @SqlQuery("UPDATE FG_TRD_EXP_REG_RQ SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, PORT_CODE = :PORT_CODE, EXP_TYPE = :EXP_TYPE, SB_NO = :SB_NO, SB_DATE = :SB_DATE, FORM_NO = :FORM_NO, IE_CODE = :IE_CODE, REQ_TYPE = :REQ_TYPE, IRM_NO = :IRM_NO, IRM_AD = :IRM_AD, IRM_AMT = :IRM_AMT, OS_AMT_IRM = :OS_AMT_IRM, IRM_CCY = :IRM_CCY, APPLICANT_PARTY = :APPLICANT_PARTY, ISSUING_PARTY = :ISSUING_PARTY, PRODUCT_STATUS = :PRODUCT_STATUS, PROCESS_ID = :PROCESS_ID, DMS_EVENT_ID = :DMS_EVENT_ID, EXP_AGENCY = :EXP_AGENCY, DEBIT_ACC_NUM = :DEBIT_ACC_NUM WHERE id = :id")
    public int update(@BindBean() FgTrdExpRegRq entity);

    @SqlQuery("DELETE FROM FG_TRD_EXP_REG_RQ WHERE id = :id")
    public int delete(@Bind("id") String id);
}
