package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuBatch;
import com.bsit.codegeneration.mapper.FgActRuBatchMapper;
import java.util.*;

@RegisterRowMapper(FgActRuBatchMapper.class)
public interface FgActRuBatchDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_BATCH")
    public List<FgActRuBatch> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_BATCH WHERE id = :id")
    public Optional<FgActRuBatch> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_BATCH(ID_, REV_, TYPE_, TOTAL_JOBS_, JOBS_CREATED_, JOBS_PER_SEED_, INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_, BATCH_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_, SUSPENSION_STATE_, CONFIGURATION_, TENANT_ID_, CREATE_USER_ID_) VALUES (:ID_, :REV_, :TYPE_, :TOTAL_JOBS_, :JOBS_CREATED_, :JOBS_PER_SEED_, :INVOCATIONS_PER_JOB_, :SEED_JOB_DEF_ID_, :BATCH_JOB_DEF_ID_, :MONITOR_JOB_DEF_ID_, :SUSPENSION_STATE_, :CONFIGURATION_, :TENANT_ID_, :CREATE_USER_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuBatch entity);

    @SqlQuery("UPDATE FG_ACT_RU_BATCH SET ID_ = :ID_, REV_ = :REV_, TYPE_ = :TYPE_, TOTAL_JOBS_ = :TOTAL_JOBS_, JOBS_CREATED_ = :JOBS_CREATED_, JOBS_PER_SEED_ = :JOBS_PER_SEED_, INVOCATIONS_PER_JOB_ = :INVOCATIONS_PER_JOB_, SEED_JOB_DEF_ID_ = :SEED_JOB_DEF_ID_, BATCH_JOB_DEF_ID_ = :BATCH_JOB_DEF_ID_, MONITOR_JOB_DEF_ID_ = :MONITOR_JOB_DEF_ID_, SUSPENSION_STATE_ = :SUSPENSION_STATE_, CONFIGURATION_ = :CONFIGURATION_, TENANT_ID_ = :TENANT_ID_, CREATE_USER_ID_ = :CREATE_USER_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuBatch entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_BATCH WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
