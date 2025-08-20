package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuVariable;
import com.bsit.codegeneration.mapper.FgActRuVariableMapper;
import java.util.*;

@RegisterRowMapper(FgActRuVariableMapper.class)
public interface FgActRuVariableDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_VARIABLE")
    public List<FgActRuVariable> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_VARIABLE WHERE id = :id")
    public Optional<FgActRuVariable> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_VARIABLE(ID_, REV_, TYPE_, NAME_, EXECUTION_ID_, PROC_INST_ID_, CASE_EXECUTION_ID_, CASE_INST_ID_, TASK_ID_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, VAR_SCOPE_, SEQUENCE_COUNTER_, IS_CONCURRENT_LOCAL_, TENANT_ID_, PROC_DEF_ID_, BATCH_ID_) VALUES (:ID_, :REV_, :TYPE_, :NAME_, :EXECUTION_ID_, :PROC_INST_ID_, :CASE_EXECUTION_ID_, :CASE_INST_ID_, :TASK_ID_, :BYTEARRAY_ID_, :DOUBLE_, :LONG_, :TEXT_, :TEXT2_, :VAR_SCOPE_, :SEQUENCE_COUNTER_, :IS_CONCURRENT_LOCAL_, :TENANT_ID_, :PROC_DEF_ID_, :BATCH_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuVariable entity);

    @SqlQuery("UPDATE FG_ACT_RU_VARIABLE SET ID_ = :ID_, REV_ = :REV_, TYPE_ = :TYPE_, NAME_ = :NAME_, EXECUTION_ID_ = :EXECUTION_ID_, PROC_INST_ID_ = :PROC_INST_ID_, CASE_EXECUTION_ID_ = :CASE_EXECUTION_ID_, CASE_INST_ID_ = :CASE_INST_ID_, TASK_ID_ = :TASK_ID_, BYTEARRAY_ID_ = :BYTEARRAY_ID_, DOUBLE_ = :DOUBLE_, LONG_ = :LONG_, TEXT_ = :TEXT_, TEXT2_ = :TEXT2_, VAR_SCOPE_ = :VAR_SCOPE_, SEQUENCE_COUNTER_ = :SEQUENCE_COUNTER_, IS_CONCURRENT_LOCAL_ = :IS_CONCURRENT_LOCAL_, TENANT_ID_ = :TENANT_ID_, PROC_DEF_ID_ = :PROC_DEF_ID_, BATCH_ID_ = :BATCH_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuVariable entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_VARIABLE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
