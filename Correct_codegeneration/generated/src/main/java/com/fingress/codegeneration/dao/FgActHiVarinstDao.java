package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiVarinst;
import com.bsit.codegeneration.mapper.FgActHiVarinstMapper;
import java.util.*;

@RegisterRowMapper(FgActHiVarinstMapper.class)
public interface FgActHiVarinstDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_VARINST")
    public List<FgActHiVarinst> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_VARINST WHERE id = :id")
    public Optional<FgActHiVarinst> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_VARINST(ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, ACT_INST_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, NAME_, VAR_TYPE_, REV_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, TENANT_ID_, STATE_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :PROC_DEF_KEY_, :PROC_DEF_ID_, :PROC_INST_ID_, :EXECUTION_ID_, :ACT_INST_ID_, :CASE_DEF_KEY_, :CASE_DEF_ID_, :CASE_INST_ID_, :CASE_EXECUTION_ID_, :TASK_ID_, :NAME_, :VAR_TYPE_, :REV_, :BYTEARRAY_ID_, :DOUBLE_, :LONG_, :TEXT_, :TEXT2_, :TENANT_ID_, :STATE_, :CREATE_TIME_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiVarinst entity);

    @SqlQuery("UPDATE FG_ACT_HI_VARINST SET ID_ = :ID_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, PROC_DEF_ID_ = :PROC_DEF_ID_, PROC_INST_ID_ = :PROC_INST_ID_, EXECUTION_ID_ = :EXECUTION_ID_, ACT_INST_ID_ = :ACT_INST_ID_, CASE_DEF_KEY_ = :CASE_DEF_KEY_, CASE_DEF_ID_ = :CASE_DEF_ID_, CASE_INST_ID_ = :CASE_INST_ID_, CASE_EXECUTION_ID_ = :CASE_EXECUTION_ID_, TASK_ID_ = :TASK_ID_, NAME_ = :NAME_, VAR_TYPE_ = :VAR_TYPE_, REV_ = :REV_, BYTEARRAY_ID_ = :BYTEARRAY_ID_, DOUBLE_ = :DOUBLE_, LONG_ = :LONG_, TEXT_ = :TEXT_, TEXT2_ = :TEXT2_, TENANT_ID_ = :TENANT_ID_, STATE_ = :STATE_, CREATE_TIME_ = :CREATE_TIME_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiVarinst entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_VARINST WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
