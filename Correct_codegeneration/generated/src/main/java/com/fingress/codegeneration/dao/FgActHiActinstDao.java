package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiActinst;
import com.bsit.codegeneration.mapper.FgActHiActinstMapper;
import java.util.*;

@RegisterRowMapper(FgActHiActinstMapper.class)
public interface FgActHiActinstDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_ACTINST")
    public List<FgActHiActinst> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_ACTINST WHERE id = :id")
    public Optional<FgActHiActinst> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_ACTINST(ID_, PARENT_ACT_INST_ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, CALL_CASE_INST_ID_, ACT_NAME_, ACT_TYPE_, ASSIGNEE_, START_TIME_, END_TIME_, DURATION_, ACT_INST_STATE_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :PARENT_ACT_INST_ID_, :PROC_DEF_KEY_, :PROC_DEF_ID_, :PROC_INST_ID_, :EXECUTION_ID_, :ACT_ID_, :TASK_ID_, :CALL_PROC_INST_ID_, :CALL_CASE_INST_ID_, :ACT_NAME_, :ACT_TYPE_, :ASSIGNEE_, :START_TIME_, :END_TIME_, :DURATION_, :ACT_INST_STATE_, :SEQUENCE_COUNTER_, :TENANT_ID_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiActinst entity);

    @SqlQuery("UPDATE FG_ACT_HI_ACTINST SET ID_ = :ID_, PARENT_ACT_INST_ID_ = :PARENT_ACT_INST_ID_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, PROC_DEF_ID_ = :PROC_DEF_ID_, PROC_INST_ID_ = :PROC_INST_ID_, EXECUTION_ID_ = :EXECUTION_ID_, ACT_ID_ = :ACT_ID_, TASK_ID_ = :TASK_ID_, CALL_PROC_INST_ID_ = :CALL_PROC_INST_ID_, CALL_CASE_INST_ID_ = :CALL_CASE_INST_ID_, ACT_NAME_ = :ACT_NAME_, ACT_TYPE_ = :ACT_TYPE_, ASSIGNEE_ = :ASSIGNEE_, START_TIME_ = :START_TIME_, END_TIME_ = :END_TIME_, DURATION_ = :DURATION_, ACT_INST_STATE_ = :ACT_INST_STATE_, SEQUENCE_COUNTER_ = :SEQUENCE_COUNTER_, TENANT_ID_ = :TENANT_ID_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiActinst entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_ACTINST WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
