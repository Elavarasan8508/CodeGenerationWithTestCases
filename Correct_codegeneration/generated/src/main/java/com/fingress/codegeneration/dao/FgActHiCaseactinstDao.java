package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiCaseactinst;
import com.bsit.codegeneration.mapper.FgActHiCaseactinstMapper;
import java.util.*;

@RegisterRowMapper(FgActHiCaseactinstMapper.class)
public interface FgActHiCaseactinstDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEACTINST")
    public List<FgActHiCaseactinst> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEACTINST WHERE id = :id")
    public Optional<FgActHiCaseactinst> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_CASEACTINST(ID_, PARENT_ACT_INST_ID_, CASE_DEF_ID_, CASE_INST_ID_, CASE_ACT_ID_, TASK_ID_, CALL_PROC_INST_ID_, CALL_CASE_INST_ID_, CASE_ACT_NAME_, CASE_ACT_TYPE_, CREATE_TIME_, END_TIME_, DURATION_, STATE_, REQUIRED_, TENANT_ID_) VALUES (:ID_, :PARENT_ACT_INST_ID_, :CASE_DEF_ID_, :CASE_INST_ID_, :CASE_ACT_ID_, :TASK_ID_, :CALL_PROC_INST_ID_, :CALL_CASE_INST_ID_, :CASE_ACT_NAME_, :CASE_ACT_TYPE_, :CREATE_TIME_, :END_TIME_, :DURATION_, :STATE_, :REQUIRED_, :TENANT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiCaseactinst entity);

    @SqlQuery("UPDATE FG_ACT_HI_CASEACTINST SET ID_ = :ID_, PARENT_ACT_INST_ID_ = :PARENT_ACT_INST_ID_, CASE_DEF_ID_ = :CASE_DEF_ID_, CASE_INST_ID_ = :CASE_INST_ID_, CASE_ACT_ID_ = :CASE_ACT_ID_, TASK_ID_ = :TASK_ID_, CALL_PROC_INST_ID_ = :CALL_PROC_INST_ID_, CALL_CASE_INST_ID_ = :CALL_CASE_INST_ID_, CASE_ACT_NAME_ = :CASE_ACT_NAME_, CASE_ACT_TYPE_ = :CASE_ACT_TYPE_, CREATE_TIME_ = :CREATE_TIME_, END_TIME_ = :END_TIME_, DURATION_ = :DURATION_, STATE_ = :STATE_, REQUIRED_ = :REQUIRED_, TENANT_ID_ = :TENANT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActHiCaseactinst entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_CASEACTINST WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
