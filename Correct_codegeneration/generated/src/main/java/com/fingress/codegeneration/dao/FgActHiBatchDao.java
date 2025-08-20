package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiBatch;
import com.bsit.codegeneration.mapper.FgActHiBatchMapper;
import java.util.*;

@RegisterRowMapper(FgActHiBatchMapper.class)
public interface FgActHiBatchDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_BATCH")
    public List<FgActHiBatch> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_BATCH WHERE id = :id")
    public Optional<FgActHiBatch> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_BATCH(ID_, TYPE_, TOTAL_JOBS_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, TENANT_ID_, START_TIME_, END_TIME_, CREATE_USER_ID_, REMOVAL_TIME_) VALUES (:ID_, :TYPE_, :TOTAL_JOBS_, :JOBS_PER_SEED_, :INVOCATIONS_PER_JOB_, :SEED_JOB_DEF_ID_, :MONITOR_JOB_DEF_ID_, :BATCH_JOB_DEF_ID_, :TENANT_ID_, :START_TIME_, :END_TIME_, :CREATE_USER_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiBatch entity);

    @SqlQuery("UPDATE FG_ACT_HI_BATCH SET ID_ = :ID_, TYPE_ = :TYPE_, TOTAL_JOBS_ = :TOTAL_JOBS_, JOBS_PER_SEED_ = :JOBS_PER_SEED_, INVOCATIONS_PER_JOB_ = :INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_ = :SEED_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_ = :MONITOR_JOB_DEF_ID_, BATCH_JOB_DEF_ID_ = :BATCH_JOB_DEF_ID_, TENANT_ID_ = :TENANT_ID_, START_TIME_ = :START_TIME_, END_TIME_ = :END_TIME_, CREATE_USER_ID_ = :CREATE_USER_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiBatch entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_BATCH WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
