package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiJobLog;
import com.bsit.codegeneration.mapper.FgActHiJobLogMapper;
import java.util.*;

@RegisterRowMapper(FgActHiJobLogMapper.class)
public interface FgActHiJobLogDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_JOB_LOG")
    public List<FgActHiJobLog> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_JOB_LOG WHERE id = :id")
    public Optional<FgActHiJobLog> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_JOB_LOG(ID_, TIMESTAMP_, JOB_ID_, JOB_DUEDATE_, JOB_RETRIES_, JOB_PRIORITY_, JOB_EXCEPTION_MSG_, JOB_EXCEPTION_STACK_ID_, JOB_STATE_, JOB_DEF_ID_, JOB_DEF_TYPE_, JOB_DEF_CONFIGURATION_, ACT_ID_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, DEPLOYMENT_ID_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, HOSTNAME_, FAILED_ACT_ID_) VALUES (:ID_, :TIMESTAMP_, :JOB_ID_, :JOB_DUEDATE_, :JOB_RETRIES_, :JOB_PRIORITY_, :JOB_EXCEPTION_MSG_, :JOB_EXCEPTION_STACK_ID_, :JOB_STATE_, :JOB_DEF_ID_, :JOB_DEF_TYPE_, :JOB_DEF_CONFIGURATION_, :ACT_ID_, :EXECUTION_ID_, :PROCESS_INSTANCE_ID_, :PROCESS_DEF_ID_, :PROCESS_DEF_KEY_, :DEPLOYMENT_ID_, :SEQUENCE_COUNTER_, :TENANT_ID_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_, :HOSTNAME_, :FAILED_ACT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiJobLog entity);

    @SqlQuery("UPDATE FG_ACT_HI_JOB_LOG SET ID_ = :ID_, TIMESTAMP_ = :TIMESTAMP_, JOB_ID_ = :JOB_ID_, JOB_DUEDATE_ = :JOB_DUEDATE_, JOB_RETRIES_ = :JOB_RETRIES_, JOB_PRIORITY_ = :JOB_PRIORITY_, JOB_EXCEPTION_MSG_ = :JOB_EXCEPTION_MSG_, JOB_EXCEPTION_STACK_ID_ = :JOB_EXCEPTION_STACK_ID_, JOB_STATE_ = :JOB_STATE_, JOB_DEF_ID_ = :JOB_DEF_ID_, JOB_DEF_TYPE_ = :JOB_DEF_TYPE_, JOB_DEF_CONFIGURATION_ = :JOB_DEF_CONFIGURATION_, ACT_ID_ = :ACT_ID_, EXECUTION_ID_ = :EXECUTION_ID_, PROCESS_INSTANCE_ID_ = :PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_ = :PROCESS_DEF_ID_, PROCESS_DEF_KEY_ = :PROCESS_DEF_KEY_, DEPLOYMENT_ID_ = :DEPLOYMENT_ID_, SEQUENCE_COUNTER_ = :SEQUENCE_COUNTER_, TENANT_ID_ = :TENANT_ID_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_, HOSTNAME_ = :HOSTNAME_, FAILED_ACT_ID_ = :FAILED_ACT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActHiJobLog entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_JOB_LOG WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
