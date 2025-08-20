package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiOpLog;
import com.bsit.codegeneration.mapper.FgActHiOpLogMapper;
import java.util.*;

@RegisterRowMapper(FgActHiOpLogMapper.class)
public interface FgActHiOpLogDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_OP_LOG")
    public List<FgActHiOpLog> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_OP_LOG WHERE id = :id")
    public Optional<FgActHiOpLog> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_OP_LOG(ID_, DEPLOYMENT_ID_, PROC_DEF_ID_, PROC_DEF_KEY_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, JOB_ID_, JOB_DEF_ID_, BATCH_ID_, USER_ID_, TIMESTAMP_, OPERATION_TYPE_, OPERATION_ID_, ENTITY_TYPE_, PROPERTY_, ORG_VALUE_, NEW_VALUE_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, CATEGORY_, EXTERNAL_TASK_ID_, ANNOTATION_) VALUES (:ID_, :DEPLOYMENT_ID_, :PROC_DEF_ID_, :PROC_DEF_KEY_, :PROC_INST_ID_, :EXECUTION_ID_, :CASE_DEF_ID_, :CASE_INST_ID_, :CASE_EXECUTION_ID_, :TASK_ID_, :JOB_ID_, :JOB_DEF_ID_, :BATCH_ID_, :USER_ID_, :TIMESTAMP_, :OPERATION_TYPE_, :OPERATION_ID_, :ENTITY_TYPE_, :PROPERTY_, :ORG_VALUE_, :NEW_VALUE_, :TENANT_ID_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_, :CATEGORY_, :EXTERNAL_TASK_ID_, :ANNOTATION_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiOpLog entity);

    @SqlQuery("UPDATE FG_ACT_HI_OP_LOG SET ID_ = :ID_, DEPLOYMENT_ID_ = :DEPLOYMENT_ID_, PROC_DEF_ID_ = :PROC_DEF_ID_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, PROC_INST_ID_ = :PROC_INST_ID_, EXECUTION_ID_ = :EXECUTION_ID_, CASE_DEF_ID_ = :CASE_DEF_ID_, CASE_INST_ID_ = :CASE_INST_ID_, CASE_EXECUTION_ID_ = :CASE_EXECUTION_ID_, TASK_ID_ = :TASK_ID_, JOB_ID_ = :JOB_ID_, JOB_DEF_ID_ = :JOB_DEF_ID_, BATCH_ID_ = :BATCH_ID_, USER_ID_ = :USER_ID_, TIMESTAMP_ = :TIMESTAMP_, OPERATION_TYPE_ = :OPERATION_TYPE_, OPERATION_ID_ = :OPERATION_ID_, ENTITY_TYPE_ = :ENTITY_TYPE_, PROPERTY_ = :PROPERTY_, ORG_VALUE_ = :ORG_VALUE_, NEW_VALUE_ = :NEW_VALUE_, TENANT_ID_ = :TENANT_ID_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_, CATEGORY_ = :CATEGORY_, EXTERNAL_TASK_ID_ = :EXTERNAL_TASK_ID_, ANNOTATION_ = :ANNOTATION_ WHERE id = :id")
    public int update(@BindBean() FgActHiOpLog entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_OP_LOG WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
