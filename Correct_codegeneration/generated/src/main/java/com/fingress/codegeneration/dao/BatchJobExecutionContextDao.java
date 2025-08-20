package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.BatchJobExecutionContext;
import com.bsit.codegeneration.mapper.BatchJobExecutionContextMapper;
import java.util.*;

@RegisterRowMapper(BatchJobExecutionContextMapper.class)
public interface BatchJobExecutionContextDao {

    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_CONTEXT")
    public List<BatchJobExecutionContext> findAll();

    @SqlQuery("SELECT * FROM BATCH_JOB_EXECUTION_CONTEXT WHERE id = :id")
    public Optional<BatchJobExecutionContext> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO BATCH_JOB_EXECUTION_CONTEXT(JOB_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT) VALUES (:JOB_EXECUTION_ID, :SHORT_CONTEXT, :SERIALIZED_CONTEXT)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() BatchJobExecutionContext entity);

    @SqlQuery("UPDATE BATCH_JOB_EXECUTION_CONTEXT SET JOB_EXECUTION_ID = :JOB_EXECUTION_ID, SHORT_CONTEXT = :SHORT_CONTEXT, SERIALIZED_CONTEXT = :SERIALIZED_CONTEXT WHERE id = :id")
    public int update(@BindBean() BatchJobExecutionContext entity);

    @SqlQuery("DELETE FROM BATCH_JOB_EXECUTION_CONTEXT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
