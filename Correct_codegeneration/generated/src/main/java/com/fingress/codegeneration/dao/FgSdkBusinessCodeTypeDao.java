package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSdkBusinessCodeType;
import com.bsit.codegeneration.mapper.FgSdkBusinessCodeTypeMapper;
import java.util.*;

@RegisterRowMapper(FgSdkBusinessCodeTypeMapper.class)
public interface FgSdkBusinessCodeTypeDao {

    @SqlQuery("SELECT * FROM FG_SDK_BUSINESS_CODE_TYPE")
    public List<FgSdkBusinessCodeType> findAll();

    @SqlQuery("SELECT * FROM FG_SDK_BUSINESS_CODE_TYPE WHERE id = :id")
    public Optional<FgSdkBusinessCodeType> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SDK_BUSINESS_CODE_TYPE(ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CODE_TYPE, NAME, DESCRIPTION) VALUES (:ID, :REFERENCE_ID, :APPLICANT_PARTY_CODE, :APPLICANT_REF_ID, :ISSUING_PARTY_CODE, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :CODE_TYPE, :NAME, :DESCRIPTION)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSdkBusinessCodeType entity);

    @SqlQuery("UPDATE FG_SDK_BUSINESS_CODE_TYPE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, APPLICANT_REF_ID = :APPLICANT_REF_ID, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, CODE_TYPE = :CODE_TYPE, NAME = :NAME, DESCRIPTION = :DESCRIPTION WHERE id = :id")
    public int update(@BindBean() FgSdkBusinessCodeType entity);

    @SqlQuery("DELETE FROM FG_SDK_BUSINESS_CODE_TYPE WHERE id = :id")
    public int delete(@Bind("id") String id);
}
