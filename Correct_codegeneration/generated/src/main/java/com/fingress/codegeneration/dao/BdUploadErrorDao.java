package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.BdUploadError;
import com.bsit.codegeneration.mapper.BdUploadErrorMapper;
import java.util.*;

@RegisterRowMapper(BdUploadErrorMapper.class)
public interface BdUploadErrorDao {

    @SqlQuery("SELECT * FROM BD_UPLOAD_ERROR")
    public List<BdUploadError> findAll();

    @SqlQuery("SELECT * FROM BD_UPLOAD_ERROR WHERE id = :id")
    public Optional<BdUploadError> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO BD_UPLOAD_ERROR(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :UPLOAD_ID, :ERROR_CODE, :GRAVITY, :ERROR_VALUE, :LINE_NO, :COLUMN_NO, :PARENT_REF_ID, :PARENT_VERSION_ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() BdUploadError entity);

    @SqlQuery("UPDATE BD_UPLOAD_ERROR SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, UPLOAD_ID = :UPLOAD_ID, ERROR_CODE = :ERROR_CODE, GRAVITY = :GRAVITY, ERROR_VALUE = :ERROR_VALUE, LINE_NO = :LINE_NO, COLUMN_NO = :COLUMN_NO, PARENT_REF_ID = :PARENT_REF_ID, PARENT_VERSION_ID = :PARENT_VERSION_ID WHERE id = :id")
    public int update(@BindBean() BdUploadError entity);

    @SqlQuery("DELETE FROM BD_UPLOAD_ERROR WHERE id = :id")
    public int delete(@Bind("id") String id);
}
