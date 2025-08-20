package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiDetail;
import com.bsit.codegeneration.mapper.FgActHiDetailMapper;
import java.util.*;

@RegisterRowMapper(FgActHiDetailMapper.class)
public interface FgActHiDetailDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_DETAIL")
    public List<FgActHiDetail> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_DETAIL WHERE id = :id")
    public Optional<FgActHiDetail> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_DETAIL(ID_, TYPE_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, CASE_EXECUTION_ID_, TASK_ID_, ACT_INST_ID_, VAR_INST_ID_, NAME_, VAR_TYPE_, REV_, TIME_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, SEQUENCE_COUNTER_, TENANT_ID_, OPERATION_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, INITIAL_) VALUES (:ID_, :TYPE_, :PROC_DEF_KEY_, :PROC_DEF_ID_, :PROC_INST_ID_, :EXECUTION_ID_, :CASE_DEF_KEY_, :CASE_DEF_ID_, :CASE_INST_ID_, :CASE_EXECUTION_ID_, :TASK_ID_, :ACT_INST_ID_, :VAR_INST_ID_, :NAME_, :VAR_TYPE_, :REV_, :TIME_, :BYTEARRAY_ID_, :DOUBLE_, :LONG_, :TEXT_, :TEXT2_, :SEQUENCE_COUNTER_, :TENANT_ID_, :OPERATION_ID_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_, :INITIAL_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiDetail entity);

    @SqlQuery("UPDATE FG_ACT_HI_DETAIL SET ID_ = :ID_, TYPE_ = :TYPE_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, PROC_DEF_ID_ = :PROC_DEF_ID_, PROC_INST_ID_ = :PROC_INST_ID_, EXECUTION_ID_ = :EXECUTION_ID_, CASE_DEF_KEY_ = :CASE_DEF_KEY_, CASE_DEF_ID_ = :CASE_DEF_ID_, CASE_INST_ID_ = :CASE_INST_ID_, CASE_EXECUTION_ID_ = :CASE_EXECUTION_ID_, TASK_ID_ = :TASK_ID_, ACT_INST_ID_ = :ACT_INST_ID_, VAR_INST_ID_ = :VAR_INST_ID_, NAME_ = :NAME_, VAR_TYPE_ = :VAR_TYPE_, REV_ = :REV_, TIME_ = :TIME_, BYTEARRAY_ID_ = :BYTEARRAY_ID_, DOUBLE_ = :DOUBLE_, LONG_ = :LONG_, TEXT_ = :TEXT_, TEXT2_ = :TEXT2_, SEQUENCE_COUNTER_ = :SEQUENCE_COUNTER_, TENANT_ID_ = :TENANT_ID_, OPERATION_ID_ = :OPERATION_ID_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_, INITIAL_ = :INITIAL_ WHERE id = :id")
    public int update(@BindBean() FgActHiDetail entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_DETAIL WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
