package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuExtTask;
import com.bsit.codegeneration.mapper.FgActRuExtTaskMapper;
import java.util.*;

@RegisterRowMapper(FgActRuExtTaskMapper.class)
public interface FgActRuExtTaskDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_EXT_TASK")
    public List<FgActRuExtTask> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_EXT_TASK WHERE id = :id")
    public Optional<FgActRuExtTask> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_EXT_TASK(ID_, REV_, WORKER_ID_, TOPIC_NAME_, RETRIES_, ERROR_MSG_, ERROR_DETAILS_ID_, LOCK_EXP_TIME_, SUSPENSION_STATE_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, ACT_INST_ID_, TENANT_ID_, PRIORITY_) VALUES (:ID_, :REV_, :WORKER_ID_, :TOPIC_NAME_, :RETRIES_, :ERROR_MSG_, :ERROR_DETAILS_ID_, :LOCK_EXP_TIME_, :SUSPENSION_STATE_, :EXECUTION_ID_, :PROC_INST_ID_, :PROC_DEF_ID_, :PROC_DEF_KEY_, :ACT_ID_, :ACT_INST_ID_, :TENANT_ID_, :PRIORITY_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuExtTask entity);

    @SqlQuery("UPDATE FG_ACT_RU_EXT_TASK SET ID_ = :ID_, REV_ = :REV_, WORKER_ID_ = :WORKER_ID_, TOPIC_NAME_ = :TOPIC_NAME_, RETRIES_ = :RETRIES_, ERROR_MSG_ = :ERROR_MSG_, ERROR_DETAILS_ID_ = :ERROR_DETAILS_ID_, LOCK_EXP_TIME_ = :LOCK_EXP_TIME_, SUSPENSION_STATE_ = :SUSPENSION_STATE_, EXECUTION_ID_ = :EXECUTION_ID_, PROC_INST_ID_ = :PROC_INST_ID_, PROC_DEF_ID_ = :PROC_DEF_ID_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, ACT_ID_ = :ACT_ID_, ACT_INST_ID_ = :ACT_INST_ID_, TENANT_ID_ = :TENANT_ID_, PRIORITY_ = :PRIORITY_ WHERE id = :id")
    public int update(@BindBean() FgActRuExtTask entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_EXT_TASK WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
