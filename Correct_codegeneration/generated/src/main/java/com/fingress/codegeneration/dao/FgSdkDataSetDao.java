package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSdkDataSet;
import com.bsit.codegeneration.mapper.FgSdkDataSetMapper;
import java.util.*;

@RegisterRowMapper(FgSdkDataSetMapper.class)
public interface FgSdkDataSetDao {

    @SqlQuery("SELECT * FROM FG_SDK_DATA_SET")
    public List<FgSdkDataSet> findAll();

    @SqlQuery("SELECT * FROM FG_SDK_DATA_SET WHERE id = :id")
    public Optional<FgSdkDataSet> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SDK_DATA_SET(ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, DATASOURCE_ID, MODEL_CODE, DESCRIPTION, DATASOURCE_NAME) VALUES (:ID, :REFERENCE_ID, :APPLICANT_PARTY_CODE, :APPLICANT_REF_ID, :ISSUING_PARTY_CODE, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :NAME, :DATASOURCE_ID, :MODEL_CODE, :DESCRIPTION, :DATASOURCE_NAME)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSdkDataSet entity);

    @SqlQuery("UPDATE FG_SDK_DATA_SET SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, APPLICANT_REF_ID = :APPLICANT_REF_ID, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, NAME = :NAME, DATASOURCE_ID = :DATASOURCE_ID, MODEL_CODE = :MODEL_CODE, DESCRIPTION = :DESCRIPTION, DATASOURCE_NAME = :DATASOURCE_NAME WHERE id = :id")
    public int update(@BindBean() FgSdkDataSet entity);

    @SqlQuery("DELETE FROM FG_SDK_DATA_SET WHERE id = :id")
    public int delete(@Bind("id") String id);
}
