package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuExecution;
import com.bsit.codegeneration.mapper.FgActRuExecutionMapper;
import java.util.*;

@RegisterRowMapper(FgActRuExecutionMapper.class)
public interface FgActRuExecutionDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_EXECUTION")
    public List<FgActRuExecution> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_EXECUTION WHERE id = :id")
    public Optional<FgActRuExecution> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_EXECUTION(ID_, REV_, PROC_INST_ID_, BUSINESS_KEY_, PARENT_ID_, PROC_DEF_ID_, SUPER_EXEC_, SUPER_CASE_EXEC_, CASE_INST_ID_, ACT_ID_, ACT_INST_ID_, IS_ACTIVE_, IS_CONCURRENT_, IS_SCOPE_, IS_EVENT_SCOPE_, SUSPENSION_STATE_, CACHED_ENT_STATE_, SEQUENCE_COUNTER_, TENANT_ID_, ROOT_PROC_INST_ID_) VALUES (:ID_, :REV_, :PROC_INST_ID_, :BUSINESS_KEY_, :PARENT_ID_, :PROC_DEF_ID_, :SUPER_EXEC_, :SUPER_CASE_EXEC_, :CASE_INST_ID_, :ACT_ID_, :ACT_INST_ID_, :IS_ACTIVE_, :IS_CONCURRENT_, :IS_SCOPE_, :IS_EVENT_SCOPE_, :SUSPENSION_STATE_, :CACHED_ENT_STATE_, :SEQUENCE_COUNTER_, :TENANT_ID_, :ROOT_PROC_INST_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuExecution entity);

    @SqlQuery("UPDATE FG_ACT_RU_EXECUTION SET ID_ = :ID_, REV_ = :REV_, PROC_INST_ID_ = :PROC_INST_ID_, BUSINESS_KEY_ = :BUSINESS_KEY_, PARENT_ID_ = :PARENT_ID_, PROC_DEF_ID_ = :PROC_DEF_ID_, SUPER_EXEC_ = :SUPER_EXEC_, SUPER_CASE_EXEC_ = :SUPER_CASE_EXEC_, CASE_INST_ID_ = :CASE_INST_ID_, ACT_ID_ = :ACT_ID_, ACT_INST_ID_ = :ACT_INST_ID_, IS_ACTIVE_ = :IS_ACTIVE_, IS_CONCURRENT_ = :IS_CONCURRENT_, IS_SCOPE_ = :IS_SCOPE_, IS_EVENT_SCOPE_ = :IS_EVENT_SCOPE_, SUSPENSION_STATE_ = :SUSPENSION_STATE_, CACHED_ENT_STATE_ = :CACHED_ENT_STATE_, SEQUENCE_COUNTER_ = :SEQUENCE_COUNTER_, TENANT_ID_ = :TENANT_ID_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuExecution entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_EXECUTION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
