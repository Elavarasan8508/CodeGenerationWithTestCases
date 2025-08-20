package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSdkUploadError;
import com.bsit.codegeneration.mapper.FgSdkUploadErrorMapper;
import java.util.*;

@RegisterRowMapper(FgSdkUploadErrorMapper.class)
public interface FgSdkUploadErrorDao {

    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD_ERROR")
    public List<FgSdkUploadError> findAll();

    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD_ERROR WHERE id = :id")
    public Optional<FgSdkUploadError> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_SDK_UPLOAD_ERROR(ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ERROR_CODE, PROCESS, GRAVITY, LINE_NO, COLUMN_NO, ERROR_VALUE, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:ID, :REFERENCE_ID, :APPLICANT_PARTY_CODE, :APPLICANT_REF_ID, :ISSUING_PARTY_CODE, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :ERROR_CODE, :PROCESS, :GRAVITY, :LINE_NO, :COLUMN_NO, :ERROR_VALUE, :PARENT_REF_ID, :PARENT_VERSION_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgSdkUploadError entity);

    @SqlQuery("UPDATE FG_SDK_UPLOAD_ERROR SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, APPLICANT_REF_ID = :APPLICANT_REF_ID, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, ERROR_CODE = :ERROR_CODE, PROCESS = :PROCESS, GRAVITY = :GRAVITY, LINE_NO = :LINE_NO, COLUMN_NO = :COLUMN_NO, ERROR_VALUE = :ERROR_VALUE, PARENT_REF_ID = :PARENT_REF_ID, PARENT_VERSION_ID = :PARENT_VERSION_ID WHERE id = :id")
    public int update(@BindBean() FgSdkUploadError entity);

    @SqlQuery("DELETE FROM FG_SDK_UPLOAD_ERROR WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
