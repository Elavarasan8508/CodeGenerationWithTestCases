package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSdkActionSchema;
import com.bsit.codegeneration.mapper.FgSdkActionSchemaMapper;
import java.util.*;

@RegisterRowMapper(FgSdkActionSchemaMapper.class)
public interface FgSdkActionSchemaDao {

    @SqlQuery("SELECT * FROM FG_SDK_ACTION_SCHEMA")
    public List<FgSdkActionSchema> findAll();

    @SqlQuery("SELECT * FROM FG_SDK_ACTION_SCHEMA WHERE id = :id")
    public Optional<FgSdkActionSchema> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_SDK_ACTION_SCHEMA(REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, SOURCE_PRODUCT, TAGS, DESCRIPTION, DATASETID) VALUES (:REFERENCE_ID, :APPLICANT_PARTY_CODE, :APPLICANT_REF_ID, :ISSUING_PARTY_CODE, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :NAME, :SOURCE_PRODUCT, :TAGS, :DESCRIPTION, :DATASETID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgSdkActionSchema entity);

    @SqlQuery("UPDATE FG_SDK_ACTION_SCHEMA SET REFERENCE_ID = :REFERENCE_ID, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, APPLICANT_REF_ID = :APPLICANT_REF_ID, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, NAME = :NAME, SOURCE_PRODUCT = :SOURCE_PRODUCT, TAGS = :TAGS, DESCRIPTION = :DESCRIPTION, DATASETID = :DATASETID WHERE id = :id")
    public int update(@BindBean() FgSdkActionSchema entity);

    @SqlQuery("DELETE FROM FG_SDK_ACTION_SCHEMA WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
