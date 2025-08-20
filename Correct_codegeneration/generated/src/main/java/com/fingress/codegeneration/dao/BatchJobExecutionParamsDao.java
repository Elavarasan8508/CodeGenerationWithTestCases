package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.BatchJobExecutionParams;
import com.bsit.codegeneration.mapper.BatchJobExecutionParamsMapper;
import java.util.*;

@RegisterRowMapper(BatchJobExecutionParamsMapper.class)
public interface BatchJobExecutionParamsDao {

    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_PARAMS")
    public List<BatchJobExecutionParams> findAll();

    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_PARAMS WHERE id = :id")
    public Optional<BatchJobExecutionParams> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO BATCH_JOB_EXECUTION_PARAMS(JOB_EXECUTION_ID, PARAMETER_NAME, PARAMETER_TYPE, PARAMETER_VALUE, IDENTIFYING, DOUBLE_VAL, LONG_VAL, DATE_VAL, KEY_NAME, STRING_VAL, TYPE_CD) VALUES (:JOB_EXECUTION_ID, :PARAMETER_NAME, :PARAMETER_TYPE, :PARAMETER_VALUE, :IDENTIFYING, :DOUBLE_VAL, :LONG_VAL, :DATE_VAL, :KEY_NAME, :STRING_VAL, :TYPE_CD)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() BatchJobExecutionParams entity);

    @SqlQuery("UPDATE BATCH_JOB_EXECUTION_PARAMS SET JOB_EXECUTION_ID = :JOB_EXECUTION_ID, PARAMETER_NAME = :PARAMETER_NAME, PARAMETER_TYPE = :PARAMETER_TYPE, PARAMETER_VALUE = :PARAMETER_VALUE, IDENTIFYING = :IDENTIFYING, DOUBLE_VAL = :DOUBLE_VAL, LONG_VAL = :LONG_VAL, DATE_VAL = :DATE_VAL, KEY_NAME = :KEY_NAME, STRING_VAL = :STRING_VAL, TYPE_CD = :TYPE_CD WHERE id = :id")
    public int update(@BindBean() BatchJobExecutionParams entity);

    @SqlQuery("DELETE FROM BATCH_JOB_EXECUTION_PARAMS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
