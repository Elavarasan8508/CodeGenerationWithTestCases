package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuIncident;
import com.bsit.codegeneration.mapper.FgActRuIncidentMapper;
import java.util.*;

@RegisterRowMapper(FgActRuIncidentMapper.class)
public interface FgActRuIncidentDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_INCIDENT")
    public List<FgActRuIncident> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_INCIDENT WHERE id = :id")
    public Optional<FgActRuIncident> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_INCIDENT(ID_, REV_, INCIDENT_TIMESTAMP_, INCIDENT_MSG_, INCIDENT_TYPE_, EXECUTION_ID_, ACTIVITY_ID_, PROC_INST_ID_, PROC_DEF_ID_, CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_, TENANT_ID_, JOB_DEF_ID_, FAILED_ACTIVITY_ID_) VALUES (:ID_, :REV_, :INCIDENT_TIMESTAMP_, :INCIDENT_MSG_, :INCIDENT_TYPE_, :EXECUTION_ID_, :ACTIVITY_ID_, :PROC_INST_ID_, :PROC_DEF_ID_, :CAUSE_INCIDENT_ID_, :ROOT_CAUSE_INCIDENT_ID_, :CONFIGURATION_, :TENANT_ID_, :JOB_DEF_ID_, :FAILED_ACTIVITY_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuIncident entity);

    @SqlQuery("UPDATE FG_ACT_RU_INCIDENT SET ID_ = :ID_, REV_ = :REV_, INCIDENT_TIMESTAMP_ = :INCIDENT_TIMESTAMP_, INCIDENT_MSG_ = :INCIDENT_MSG_, INCIDENT_TYPE_ = :INCIDENT_TYPE_, EXECUTION_ID_ = :EXECUTION_ID_, ACTIVITY_ID_ = :ACTIVITY_ID_, PROC_INST_ID_ = :PROC_INST_ID_, PROC_DEF_ID_ = :PROC_DEF_ID_, CAUSE_INCIDENT_ID_ = :CAUSE_INCIDENT_ID_, ROOT_CAUSE_INCIDENT_ID_ = :ROOT_CAUSE_INCIDENT_ID_, CONFIGURATION_ = :CONFIGURATION_, TENANT_ID_ = :TENANT_ID_, JOB_DEF_ID_ = :JOB_DEF_ID_, FAILED_ACTIVITY_ID_ = :FAILED_ACTIVITY_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuIncident entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_INCIDENT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
