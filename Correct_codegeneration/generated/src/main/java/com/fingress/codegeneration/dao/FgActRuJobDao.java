package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuJob;
import com.bsit.codegeneration.mapper.FgActRuJobMapper;
import java.util.*;

@RegisterRowMapper(FgActRuJobMapper.class)
public interface FgActRuJobDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_JOB")
    public List<FgActRuJob> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_JOB WHERE id = :id")
    public Optional<FgActRuJob> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_JOB(ID_, REV_, TYPE_, LOCK_EXP_TIME_, LOCK_OWNER_, EXCLUSIVE_, EXECUTION_ID_, PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_, PROCESS_DEF_KEY_, RETRIES_, EXCEPTION_STACK_ID_, EXCEPTION_MSG_, DUEDATE_, REPEAT_, HANDLER_TYPE_, HANDLER_CFG_, DEPLOYMENT_ID_, SUSPENSION_STATE_, JOB_DEF_ID_, PRIORITY_, SEQUENCE_COUNTER_, TENANT_ID_, CREATE_TIME_, REPEAT_OFFSET_, FAILED_ACT_ID_) VALUES (:ID_, :REV_, :TYPE_, :LOCK_EXP_TIME_, :LOCK_OWNER_, :EXCLUSIVE_, :EXECUTION_ID_, :PROCESS_INSTANCE_ID_, :PROCESS_DEF_ID_, :PROCESS_DEF_KEY_, :RETRIES_, :EXCEPTION_STACK_ID_, :EXCEPTION_MSG_, :DUEDATE_, :REPEAT_, :HANDLER_TYPE_, :HANDLER_CFG_, :DEPLOYMENT_ID_, :SUSPENSION_STATE_, :JOB_DEF_ID_, :PRIORITY_, :SEQUENCE_COUNTER_, :TENANT_ID_, :CREATE_TIME_, :REPEAT_OFFSET_, :FAILED_ACT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuJob entity);

    @SqlQuery("UPDATE FG_ACT_RU_JOB SET ID_ = :ID_, REV_ = :REV_, TYPE_ = :TYPE_, LOCK_EXP_TIME_ = :LOCK_EXP_TIME_, LOCK_OWNER_ = :LOCK_OWNER_, EXCLUSIVE_ = :EXCLUSIVE_, EXECUTION_ID_ = :EXECUTION_ID_, PROCESS_INSTANCE_ID_ = :PROCESS_INSTANCE_ID_, PROCESS_DEF_ID_ = :PROCESS_DEF_ID_, PROCESS_DEF_KEY_ = :PROCESS_DEF_KEY_, RETRIES_ = :RETRIES_, EXCEPTION_STACK_ID_ = :EXCEPTION_STACK_ID_, EXCEPTION_MSG_ = :EXCEPTION_MSG_, DUEDATE_ = :DUEDATE_, REPEAT_ = :REPEAT_, HANDLER_TYPE_ = :HANDLER_TYPE_, HANDLER_CFG_ = :HANDLER_CFG_, DEPLOYMENT_ID_ = :DEPLOYMENT_ID_, SUSPENSION_STATE_ = :SUSPENSION_STATE_, JOB_DEF_ID_ = :JOB_DEF_ID_, PRIORITY_ = :PRIORITY_, SEQUENCE_COUNTER_ = :SEQUENCE_COUNTER_, TENANT_ID_ = :TENANT_ID_, CREATE_TIME_ = :CREATE_TIME_, REPEAT_OFFSET_ = :REPEAT_OFFSET_, FAILED_ACT_ID_ = :FAILED_ACT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuJob entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_JOB WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
