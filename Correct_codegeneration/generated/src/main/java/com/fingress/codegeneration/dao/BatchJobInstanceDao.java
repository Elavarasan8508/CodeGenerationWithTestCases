package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.BatchJobInstance;
import com.bsit.codegeneration.mapper.BatchJobInstanceMapper;
import java.util.*;

@RegisterRowMapper(BatchJobInstanceMapper.class)
public interface BatchJobInstanceDao {

    @SqlQuery("SELECT * FROM BATCH_JOB_INSTANCE")
    public List<BatchJobInstance> findAll();

    @SqlQuery("SELECT * FROM BATCH_JOB_INSTANCE WHERE id = :id")
    public Optional<BatchJobInstance> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO BATCH_JOB_INSTANCE(JOB_INSTANCE_ID, VERSION, JOB_NAME, JOB_KEY) VALUES (:JOB_INSTANCE_ID, :VERSION, :JOB_NAME, :JOB_KEY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() BatchJobInstance entity);

    @SqlQuery("UPDATE BATCH_JOB_INSTANCE SET JOB_INSTANCE_ID = :JOB_INSTANCE_ID, VERSION = :VERSION, JOB_NAME = :JOB_NAME, JOB_KEY = :JOB_KEY WHERE id = :id")
    public int update(@BindBean() BatchJobInstance entity);

    @SqlQuery("DELETE FROM BATCH_JOB_INSTANCE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
