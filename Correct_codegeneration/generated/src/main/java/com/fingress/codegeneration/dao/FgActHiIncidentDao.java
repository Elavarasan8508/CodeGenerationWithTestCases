package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiIncident;
import com.bsit.codegeneration.mapper.FgActHiIncidentMapper;
import java.util.*;

@RegisterRowMapper(FgActHiIncidentMapper.class)
public interface FgActHiIncidentDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_INCIDENT")
    public List<FgActHiIncident> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_INCIDENT WHERE id = :id")
    public Optional<FgActHiIncident> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_INCIDENT(ID_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, EXECUTION_ID_, CREATE_TIME_, END_TIME_, INCIDENT_MSG_, INCIDENT_TYPE_, ACTIVITY_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, INCIDENT_STATE_, TENANT_ID_, JOB_DEF_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_, HISTORY_CONFIGURATION_, FAILED_ACTIVITY_ID_) VALUES (:ID_, :PROC_DEF_KEY_, :PROC_DEF_ID_, :PROC_INST_ID_, :EXECUTION_ID_, :CREATE_TIME_, :END_TIME_, :INCIDENT_MSG_, :INCIDENT_TYPE_, :ACTIVITY_ID_, :CAUSE_INCIDENT_ID_, :ROOT_CAUSE_INCIDENT_ID_, :CONFIGURATION_, :INCIDENT_STATE_, :TENANT_ID_, :JOB_DEF_ID_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_, :HISTORY_CONFIGURATION_, :FAILED_ACTIVITY_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiIncident entity);

    @SqlQuery("UPDATE FG_ACT_HI_INCIDENT SET ID_ = :ID_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, PROC_DEF_ID_ = :PROC_DEF_ID_, PROC_INST_ID_ = :PROC_INST_ID_, EXECUTION_ID_ = :EXECUTION_ID_, CREATE_TIME_ = :CREATE_TIME_, END_TIME_ = :END_TIME_, INCIDENT_MSG_ = :INCIDENT_MSG_, INCIDENT_TYPE_ = :INCIDENT_TYPE_, ACTIVITY_ID_ = :ACTIVITY_ID_, CAUSE_INCIDENT_ID_ = :CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_ = :ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_ = :CONFIGURATION_, INCIDENT_STATE_ = :INCIDENT_STATE_, TENANT_ID_ = :TENANT_ID_, JOB_DEF_ID_ = :JOB_DEF_ID_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_, HISTORY_CONFIGURATION_ = :HISTORY_CONFIGURATION_, FAILED_ACTIVITY_ID_ = :FAILED_ACTIVITY_ID_ WHERE id = :id")
    public int update(@BindBean() FgActHiIncident entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_INCIDENT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
