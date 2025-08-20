package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiTaskinst;
import com.bsit.codegeneration.mapper.FgActHiTaskinstMapper;
import java.util.*;

@RegisterRowMapper(FgActHiTaskinstMapper.class)
public interface FgActHiTaskinstDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_TASKINST")
    public List<FgActHiTaskinst> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_TASKINST WHERE id = :id")
    public Optional<FgActHiTaskinst> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_TASKINST(ID_, TASK_DEF_KEY_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, ACT_INST_ID_, PARENT_TASK_ID_, NAME_, DESCRIPTION_, OWNER_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, DELETE_REASON_, PRIORITY_, DUE_DATE_, FOLLOW_UP_DATE_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :TASK_DEF_KEY_, :PROC_DEF_KEY_, :PROC_DEF_ID_, :PROC_INST_ID_, :EXECUTION_ID_, :CASE_DEF_KEY_, :CASE_DEF_ID_, :CASE_INST_ID_, :CASE_EXECUTION_ID_, :ACT_INST_ID_, :PARENT_TASK_ID_, :NAME_, :DESCRIPTION_, :OWNER_, :ASSIGNEE_, :START_TIME_, :END_TIME_, :DURATION_, :DELETE_REASON_, :PRIORITY_, :DUE_DATE_, :FOLLOW_UP_DATE_, :TENANT_ID_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiTaskinst entity);

    @SqlQuery("UPDATE FG_ACT_HI_TASKINST SET ID_ = :ID_, TASK_DEF_KEY_ = :TASK_DEF_KEY_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, PROC_DEF_ID_ = :PROC_DEF_ID_, PROC_INST_ID_ = :PROC_INST_ID_, EXECUTION_ID_ = :EXECUTION_ID_, CASE_DEF_KEY_ = :CASE_DEF_KEY_, CASE_DEF_ID_ = :CASE_DEF_ID_, CASE_INST_ID_ = :CASE_INST_ID_, CASE_EXECUTION_ID_ = :CASE_EXECUTION_ID_, ACT_INST_ID_ = :ACT_INST_ID_, PARENT_TASK_ID_ = :PARENT_TASK_ID_, NAME_ = :NAME_, DESCRIPTION_ = :DESCRIPTION_, OWNER_ = :OWNER_, ASSIGNEE_ = :ASSIGNEE_, START_TIME_ = :START_TIME_, END_TIME_ = :END_TIME_, DURATION_ = :DURATION_, DELETE_REASON_ = :DELETE_REASON_, PRIORITY_ = :PRIORITY_, DUE_DATE_ = :DUE_DATE_, FOLLOW_UP_DATE_ = :FOLLOW_UP_DATE_, TENANT_ID_ = :TENANT_ID_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiTaskinst entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_TASKINST WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
