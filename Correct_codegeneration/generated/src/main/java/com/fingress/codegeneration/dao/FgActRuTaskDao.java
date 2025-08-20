package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuTask;
import com.bsit.codegeneration.mapper.FgActRuTaskMapper;
import java.util.*;

@RegisterRowMapper(FgActRuTaskMapper.class)
public interface FgActRuTaskDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_TASK")
    public List<FgActRuTask> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_TASK WHERE id = :id")
    public Optional<FgActRuTask> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_TASK(ID_, REV_, EXECUTION_ID_, PROC_INST_ID_, PROC_DEF_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, CASE_DEF_ID_, NAME_, PARENT_TASK_ID_, DESCRIPTION_, TASK_DEF_KEY_, OWNER_, ASSIGNEE_, DELEGATION_, PRIORITY_, CREATE_TIME_, DUE_DATE_, FOLLOW_UP_DATE_, SUSPENSION_STATE_, TENANT_ID_) VALUES (:ID_, :REV_, :EXECUTION_ID_, :PROC_INST_ID_, :PROC_DEF_ID_, :CASE_EXECUTION_ID_, :CASE_INST_ID_, :CASE_DEF_ID_, :NAME_, :PARENT_TASK_ID_, :DESCRIPTION_, :TASK_DEF_KEY_, :OWNER_, :ASSIGNEE_, :DELEGATION_, :PRIORITY_, :CREATE_TIME_, :DUE_DATE_, :FOLLOW_UP_DATE_, :SUSPENSION_STATE_, :TENANT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuTask entity);

    @SqlQuery("UPDATE FG_ACT_RU_TASK SET ID_ = :ID_, REV_ = :REV_, EXECUTION_ID_ = :EXECUTION_ID_, PROC_INST_ID_ = :PROC_INST_ID_, PROC_DEF_ID_ = :PROC_DEF_ID_, CASE_EXECUTION_ID_ = :CASE_EXECUTION_ID_, CASE_INST_ID_ = :CASE_INST_ID_, CASE_DEF_ID_ = :CASE_DEF_ID_, NAME_ = :NAME_, PARENT_TASK_ID_ = :PARENT_TASK_ID_, DESCRIPTION_ = :DESCRIPTION_, TASK_DEF_KEY_ = :TASK_DEF_KEY_, OWNER_ = :OWNER_, ASSIGNEE_ = :ASSIGNEE_, DELEGATION_ = :DELEGATION_, PRIORITY_ = :PRIORITY_, CREATE_TIME_ = :CREATE_TIME_, DUE_DATE_ = :DUE_DATE_, FOLLOW_UP_DATE_ = :FOLLOW_UP_DATE_, SUSPENSION_STATE_ = :SUSPENSION_STATE_, TENANT_ID_ = :TENANT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuTask entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_TASK WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
