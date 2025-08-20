package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiCaseinst;
import com.bsit.codegeneration.mapper.FgActHiCaseinstMapper;
import java.util.*;

@RegisterRowMapper(FgActHiCaseinstMapper.class)
public interface FgActHiCaseinstDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEINST")
    public List<FgActHiCaseinst> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_CASEINST WHERE id = :id")
    public Optional<FgActHiCaseinst> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_CASEINST(ID_, CASE_INST_ID_, BUSINESS_KEY_, CASE_DEF_ID_, CREATE_TIME_, CLOSE_TIME_, DURATION_, STATE_, CREATE_USER_ID_, SUPER_CASE_INSTANCE_ID_, SUPER_PROCESS_INSTANCE_ID_, TENANT_ID_) VALUES (:ID_, :CASE_INST_ID_, :BUSINESS_KEY_, :CASE_DEF_ID_, :CREATE_TIME_, :CLOSE_TIME_, :DURATION_, :STATE_, :CREATE_USER_ID_, :SUPER_CASE_INSTANCE_ID_, :SUPER_PROCESS_INSTANCE_ID_, :TENANT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiCaseinst entity);

    @SqlQuery("UPDATE FG_ACT_HI_CASEINST SET ID_ = :ID_, CASE_INST_ID_ = :CASE_INST_ID_, BUSINESS_KEY_ = :BUSINESS_KEY_, CASE_DEF_ID_ = :CASE_DEF_ID_, CREATE_TIME_ = :CREATE_TIME_, CLOSE_TIME_ = :CLOSE_TIME_, DURATION_ = :DURATION_, STATE_ = :STATE_, CREATE_USER_ID_ = :CREATE_USER_ID_, SUPER_CASE_INSTANCE_ID_ = :SUPER_CASE_INSTANCE_ID_, SUPER_PROCESS_INSTANCE_ID_ = :SUPER_PROCESS_INSTANCE_ID_, TENANT_ID_ = :TENANT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActHiCaseinst entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_CASEINST WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
