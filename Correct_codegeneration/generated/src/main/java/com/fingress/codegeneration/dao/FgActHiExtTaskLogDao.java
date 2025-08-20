package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiExtTaskLog;
import com.bsit.codegeneration.mapper.FgActHiExtTaskLogMapper;
import java.util.*;

@RegisterRowMapper(FgActHiExtTaskLogMapper.class)
public interface FgActHiExtTaskLogDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_EXT_TASK_LOG")
    public List<FgActHiExtTaskLog> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_EXT_TASK_LOG WHERE id = :id")
    public Optional<FgActHiExtTaskLog> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_EXT_TASK_LOG(ID_, TIMESTAMP_, EXT_TASK_ID_, RETRIES_, TOPIC_NAME_, WORKER_ID_, PRIORITY_, ERROR_MSG_, ERROR_DETAILS_ID_, ACT_ID_, ACT_INST_ID_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, TENANT_ID_, STATE_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :TIMESTAMP_, :EXT_TASK_ID_, :RETRIES_, :TOPIC_NAME_, :WORKER_ID_, :PRIORITY_, :ERROR_MSG_, :ERROR_DETAILS_ID_, :ACT_ID_, :ACT_INST_ID_, :EXECUTION_ID_, :PROC_INST_ID_, :PROC_DEF_ID_, :PROC_DEF_KEY_, :TENANT_ID_, :STATE_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiExtTaskLog entity);

    @SqlQuery("UPDATE FG_ACT_HI_EXT_TASK_LOG SET ID_ = :ID_, TIMESTAMP_ = :TIMESTAMP_, EXT_TASK_ID_ = :EXT_TASK_ID_, RETRIES_ = :RETRIES_, TOPIC_NAME_ = :TOPIC_NAME_, WORKER_ID_ = :WORKER_ID_, PRIORITY_ = :PRIORITY_, ERROR_MSG_ = :ERROR_MSG_, ERROR_DETAILS_ID_ = :ERROR_DETAILS_ID_, ACT_ID_ = :ACT_ID_, ACT_INST_ID_ = :ACT_INST_ID_, EXECUTION_ID_ = :EXECUTION_ID_, PROC_INST_ID_ = :PROC_INST_ID_, PROC_DEF_ID_ = :PROC_DEF_ID_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, TENANT_ID_ = :TENANT_ID_, STATE_ = :STATE_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiExtTaskLog entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_EXT_TASK_LOG WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
