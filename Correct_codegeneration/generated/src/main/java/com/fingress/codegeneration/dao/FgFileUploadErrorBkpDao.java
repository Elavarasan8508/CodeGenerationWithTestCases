package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgFileUploadErrorBkp;
import com.bsit.codegeneration.mapper.FgFileUploadErrorBkpMapper;
import java.util.*;

@RegisterRowMapper(FgFileUploadErrorBkpMapper.class)
public interface FgFileUploadErrorBkpDao {

    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD_ERROR_BKP")
    public List<FgFileUploadErrorBkp> findAll();

    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD_ERROR_BKP WHERE id = :id")
    public Optional<FgFileUploadErrorBkp> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_FILE_UPLOAD_ERROR_BKP(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :UPLOAD_ID, :ERROR_CODE, :GRAVITY, :ERROR_VALUE, :LINE_NO, :COLUMN_NO)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgFileUploadErrorBkp entity);

    @SqlQuery("UPDATE FG_FILE_UPLOAD_ERROR_BKP SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, UPLOAD_ID = :UPLOAD_ID, ERROR_CODE = :ERROR_CODE, GRAVITY = :GRAVITY, ERROR_VALUE = :ERROR_VALUE, LINE_NO = :LINE_NO, COLUMN_NO = :COLUMN_NO WHERE id = :id")
    public int update(@BindBean() FgFileUploadErrorBkp entity);

    @SqlQuery("DELETE FROM FG_FILE_UPLOAD_ERROR_BKP WHERE id = :id")
    public int delete(@Bind("id") String id);
}
