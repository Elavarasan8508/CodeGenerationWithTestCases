package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.LmsMdmUploadError;
import com.bsit.codegeneration.mapper.LmsMdmUploadErrorMapper;
import java.util.*;

@RegisterRowMapper(LmsMdmUploadErrorMapper.class)
public interface LmsMdmUploadErrorDao {

    @SqlQuery("SELECT * FROM LMS_MDM_UPLOAD_ERROR")
    public List<LmsMdmUploadError> findAll();

    @SqlQuery("SELECT * FROM LMS_MDM_UPLOAD_ERROR WHERE id = :id")
    public Optional<LmsMdmUploadError> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO LMS_MDM_UPLOAD_ERROR(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO, UPLOAD_VERSION_ID, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :UPLOAD_ID, :ERROR_CODE, :GRAVITY, :ERROR_VALUE, :LINE_NO, :COLUMN_NO, :UPLOAD_VERSION_ID, :PARENT_REF_ID, :PARENT_VERSION_ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() LmsMdmUploadError entity);

    @SqlQuery("UPDATE LMS_MDM_UPLOAD_ERROR SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, UPLOAD_ID = :UPLOAD_ID, ERROR_CODE = :ERROR_CODE, GRAVITY = :GRAVITY, ERROR_VALUE = :ERROR_VALUE, LINE_NO = :LINE_NO, COLUMN_NO = :COLUMN_NO, UPLOAD_VERSION_ID = :UPLOAD_VERSION_ID, PARENT_REF_ID = :PARENT_REF_ID, PARENT_VERSION_ID = :PARENT_VERSION_ID WHERE id = :id")
    public int update(@BindBean() LmsMdmUploadError entity);

    @SqlQuery("DELETE FROM LMS_MDM_UPLOAD_ERROR WHERE id = :id")
    public int delete(@Bind("id") String id);
}
