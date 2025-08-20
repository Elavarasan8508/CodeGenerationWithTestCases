package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuCaseExecution;
import com.bsit.codegeneration.mapper.FgActRuCaseExecutionMapper;
import java.util.*;

@RegisterRowMapper(FgActRuCaseExecutionMapper.class)
public interface FgActRuCaseExecutionDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_EXECUTION")
    public List<FgActRuCaseExecution> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_CASE_EXECUTION WHERE id = :id")
    public Optional<FgActRuCaseExecution> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_CASE_EXECUTION(ID_, REV_, CASE_INST_ID_, SUPER_CASE_EXEC_, SUPER_EXEC_, BUSINESS_KEY_, PARENT_ID_, CASE_DEF_ID_, ACT_ID_, PREV_STATE_, CURRENT_STATE_, REQUIRED_, TENANT_ID_) VALUES (:ID_, :REV_, :CASE_INST_ID_, :SUPER_CASE_EXEC_, :SUPER_EXEC_, :BUSINESS_KEY_, :PARENT_ID_, :CASE_DEF_ID_, :ACT_ID_, :PREV_STATE_, :CURRENT_STATE_, :REQUIRED_, :TENANT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuCaseExecution entity);

    @SqlQuery("UPDATE FG_ACT_RU_CASE_EXECUTION SET ID_ = :ID_, REV_ = :REV_, CASE_INST_ID_ = :CASE_INST_ID_, SUPER_CASE_EXEC_ = :SUPER_CASE_EXEC_, SUPER_EXEC_ = :SUPER_EXEC_, BUSINESS_KEY_ = :BUSINESS_KEY_, PARENT_ID_ = :PARENT_ID_, CASE_DEF_ID_ = :CASE_DEF_ID_, ACT_ID_ = :ACT_ID_, PREV_STATE_ = :PREV_STATE_, CURRENT_STATE_ = :CURRENT_STATE_, REQUIRED_ = :REQUIRED_, TENANT_ID_ = :TENANT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuCaseExecution entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_CASE_EXECUTION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
