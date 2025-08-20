package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.BatchJobExecution;
import com.bsit.codegeneration.mapper.BatchJobExecutionMapper;
import java.util.*;

@RegisterRowMapper(BatchJobExecutionMapper.class)
public interface BatchJobExecutionDao {

    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION")
    public List<BatchJobExecution> findAll();

    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION WHERE id = :id")
    public Optional<BatchJobExecution> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO BATCH_JOB_EXECUTION(JOB_EXECUTION_ID, VERSION, JOB_INSTANCE_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED, JOB_CONFIGURATION_LOCATION) VALUES (:JOB_EXECUTION_ID, :VERSION, :JOB_INSTANCE_ID, :CREATE_TIME, :START_TIME, :END_TIME, :STATUS, :EXIT_CODE, :EXIT_MESSAGE, :LAST_UPDATED, :JOB_CONFIGURATION_LOCATION)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() BatchJobExecution entity);

    @SqlQuery("UPDATE BATCH_JOB_EXECUTION SET JOB_EXECUTION_ID = :JOB_EXECUTION_ID, VERSION = :VERSION, JOB_INSTANCE_ID = :JOB_INSTANCE_ID, CREATE_TIME = :CREATE_TIME, START_TIME = :START_TIME, END_TIME = :END_TIME, STATUS = :STATUS, EXIT_CODE = :EXIT_CODE, EXIT_MESSAGE = :EXIT_MESSAGE, LAST_UPDATED = :LAST_UPDATED, JOB_CONFIGURATION_LOCATION = :JOB_CONFIGURATION_LOCATION WHERE id = :id")
    public int update(@BindBean() BatchJobExecution entity);

    @SqlQuery("DELETE FROM BATCH_JOB_EXECUTION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
