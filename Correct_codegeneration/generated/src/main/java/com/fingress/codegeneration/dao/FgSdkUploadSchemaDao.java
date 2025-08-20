package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSdkUploadSchema;
import com.bsit.codegeneration.mapper.FgSdkUploadSchemaMapper;
import java.util.*;

@RegisterRowMapper(FgSdkUploadSchemaMapper.class)
public interface FgSdkUploadSchemaDao {

    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD_SCHEMA")
    public List<FgSdkUploadSchema> findAll();

    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD_SCHEMA WHERE id = :id")
    public Optional<FgSdkUploadSchema> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_SDK_UPLOAD_SCHEMA(ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, LAYOUT_TEMPLATE_ID) VALUES (:ID, :REFERENCE_ID, :APPLICANT_PARTY_CODE, :APPLICANT_REF_ID, :ISSUING_PARTY_CODE, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :LAYOUT_TEMPLATE_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgSdkUploadSchema entity);

    @SqlQuery("UPDATE FG_SDK_UPLOAD_SCHEMA SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, APPLICANT_REF_ID = :APPLICANT_REF_ID, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, LAYOUT_TEMPLATE_ID = :LAYOUT_TEMPLATE_ID WHERE id = :id")
    public int update(@BindBean() FgSdkUploadSchema entity);

    @SqlQuery("DELETE FROM FG_SDK_UPLOAD_SCHEMA WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
