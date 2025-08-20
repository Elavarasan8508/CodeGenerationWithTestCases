package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.BatchStepExecutionContext;
import com.bsit.codegeneration.mapper.BatchStepExecutionContextMapper;
import java.util.*;

@RegisterRowMapper(BatchStepExecutionContextMapper.class)
public interface BatchStepExecutionContextDao {

    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION_CONTEXT")
    public List<BatchStepExecutionContext> findAll();

    @SqlQuery("SELECT * FROM BATCH_STEP_EXECUTION_CONTEXT WHERE id = :id")
    public Optional<BatchStepExecutionContext> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO BATCH_STEP_EXECUTION_CONTEXT(STEP_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT) VALUES (:STEP_EXECUTION_ID, :SHORT_CONTEXT, :SERIALIZED_CONTEXT)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() BatchStepExecutionContext entity);

    @SqlQuery("UPDATE BATCH_STEP_EXECUTION_CONTEXT SET STEP_EXECUTION_ID = :STEP_EXECUTION_ID, SHORT_CONTEXT = :SHORT_CONTEXT, SERIALIZED_CONTEXT = :SERIALIZED_CONTEXT WHERE id = :id")
    public int update(@BindBean() BatchStepExecutionContext entity);

    @SqlQuery("DELETE FROM BATCH_STEP_EXECUTION_CONTEXT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
