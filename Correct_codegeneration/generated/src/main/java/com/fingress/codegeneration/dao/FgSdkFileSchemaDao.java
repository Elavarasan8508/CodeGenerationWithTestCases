package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSdkFileSchema;
import com.bsit.codegeneration.mapper.FgSdkFileSchemaMapper;
import java.util.*;

@RegisterRowMapper(FgSdkFileSchemaMapper.class)
public interface FgSdkFileSchemaDao {

    @SqlQuery("SELECT * FROM FG_SDK_FILE_SCHEMA")
    public List<FgSdkFileSchema> findAll();

    @SqlQuery("SELECT * FROM FG_SDK_FILE_SCHEMA WHERE id = :id")
    public Optional<FgSdkFileSchema> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SDK_FILE_SCHEMA(ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, ENTITY_SUB_TYPE_CODE) VALUES (:ID, :REFERENCE_ID, :APPLICANT_PARTY_CODE, :APPLICANT_REF_ID, :ISSUING_PARTY_CODE, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :NAME, :ENTITY_SUB_TYPE_CODE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSdkFileSchema entity);

    @SqlQuery("UPDATE FG_SDK_FILE_SCHEMA SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, APPLICANT_REF_ID = :APPLICANT_REF_ID, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, NAME = :NAME, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE WHERE id = :id")
    public int update(@BindBean() FgSdkFileSchema entity);

    @SqlQuery("DELETE FROM FG_SDK_FILE_SCHEMA WHERE id = :id")
    public int delete(@Bind("id") String id);
}
