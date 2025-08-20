package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiProcinst;
import com.bsit.codegeneration.mapper.FgActHiProcinstMapper;
import java.util.*;

@RegisterRowMapper(FgActHiProcinstMapper.class)
public interface FgActHiProcinstDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_PROCINST")
    public List<FgActHiProcinst> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_PROCINST WHERE id = :id")
    public Optional<FgActHiProcinst> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_PROCINST(ID_, PROC_INST_ID_, BUSINESS_KEY_, PROC_DEF_KEY_, PROC_DEF_ID_, START_TIME_, END_TIME_, DURATION_, START_USER_ID_, START_ACT_ID_, END_ACT_ID_, SUPER_PROCESS_INSTANCE_ID_, SUPER_CASE_INSTANCE_ID_, CASE_INST_ID_, DELETE_REASON_, TENANT_ID_, STATE_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :PROC_INST_ID_, :BUSINESS_KEY_, :PROC_DEF_KEY_, :PROC_DEF_ID_, :START_TIME_, :END_TIME_, :DURATION_, :START_USER_ID_, :START_ACT_ID_, :END_ACT_ID_, :SUPER_PROCESS_INSTANCE_ID_, :SUPER_CASE_INSTANCE_ID_, :CASE_INST_ID_, :DELETE_REASON_, :TENANT_ID_, :STATE_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiProcinst entity);

    @SqlQuery("UPDATE FG_ACT_HI_PROCINST SET ID_ = :ID_, PROC_INST_ID_ = :PROC_INST_ID_, BUSINESS_KEY_ = :BUSINESS_KEY_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, PROC_DEF_ID_ = :PROC_DEF_ID_, START_TIME_ = :START_TIME_, END_TIME_ = :END_TIME_, DURATION_ = :DURATION_, START_USER_ID_ = :START_USER_ID_, START_ACT_ID_ = :START_ACT_ID_, END_ACT_ID_ = :END_ACT_ID_, SUPER_PROCESS_INSTANCE_ID_ = :SUPER_PROCESS_INSTANCE_ID_, SUPER_CASE_INSTANCE_ID_ = :SUPER_CASE_INSTANCE_ID_, CASE_INST_ID_ = :CASE_INST_ID_, DELETE_REASON_ = :DELETE_REASON_, TENANT_ID_ = :TENANT_ID_, STATE_ = :STATE_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiProcinst entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_PROCINST WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
