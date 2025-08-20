package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.BatchStepExecution;
import com.bsit.codegeneration.mapper.BatchStepExecutionMapper;
import java.util.*;

@RegisterRowMapper(BatchStepExecutionMapper.class)
public interface BatchStepExecutionDao {

    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION")
    public List<BatchStepExecution> findAll();

    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION WHERE id = :id")
    public Optional<BatchStepExecution> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO BATCH_STEP_EXECUTION(STEP_EXECUTION_ID, VERSION, STEP_NAME, JOB_EXECUTION_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, COMMIT_COUNT, READ_COUNT, FILTER_COUNT, WRITE_COUNT, READ_SKIP_COUNT, WRITE_SKIP_COUNT, PROCESS_SKIP_COUNT, ROLLBACK_COUNT, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED) VALUES (:STEP_EXECUTION_ID, :VERSION, :STEP_NAME, :JOB_EXECUTION_ID, :CREATE_TIME, :START_TIME, :END_TIME, :STATUS, :COMMIT_COUNT, :READ_COUNT, :FILTER_COUNT, :WRITE_COUNT, :READ_SKIP_COUNT, :WRITE_SKIP_COUNT, :PROCESS_SKIP_COUNT, :ROLLBACK_COUNT, :EXIT_CODE, :EXIT_MESSAGE, :LAST_UPDATED)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() BatchStepExecution entity);

    @SqlQuery("UPDATE BATCH_STEP_EXECUTION SET STEP_EXECUTION_ID = :STEP_EXECUTION_ID, VERSION = :VERSION, STEP_NAME = :STEP_NAME, JOB_EXECUTION_ID = :JOB_EXECUTION_ID, CREATE_TIME = :CREATE_TIME, START_TIME = :START_TIME, END_TIME = :END_TIME, STATUS = :STATUS, COMMIT_COUNT = :COMMIT_COUNT, READ_COUNT = :READ_COUNT, FILTER_COUNT = :FILTER_COUNT, WRITE_COUNT = :WRITE_COUNT, READ_SKIP_COUNT = :READ_SKIP_COUNT, WRITE_SKIP_COUNT = :WRITE_SKIP_COUNT, PROCESS_SKIP_COUNT = :PROCESS_SKIP_COUNT, ROLLBACK_COUNT = :ROLLBACK_COUNT, EXIT_CODE = :EXIT_CODE, EXIT_MESSAGE = :EXIT_MESSAGE, LAST_UPDATED = :LAST_UPDATED WHERE id = :id")
    public int update(@BindBean() BatchStepExecution entity);

    @SqlQuery("DELETE FROM BATCH_STEP_EXECUTION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
