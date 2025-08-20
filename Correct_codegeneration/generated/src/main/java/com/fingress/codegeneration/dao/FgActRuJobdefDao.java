package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuJobdef;
import com.bsit.codegeneration.mapper.FgActRuJobdefMapper;
import java.util.*;

@RegisterRowMapper(FgActRuJobdefMapper.class)
public interface FgActRuJobdefDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_JOBDEF")
    public List<FgActRuJobdef> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_JOBDEF WHERE id = :id")
    public Optional<FgActRuJobdef> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_JOBDEF(ID_, REV_, PROC_DEF_ID_, PROC_DEF_KEY_, ACT_ID_, JOB_TYPE_, JOB_CONFIGURATION_, SUSPENSION_STATE_, JOB_PRIORITY_, TENANT_ID_, DEPLOYMENT_ID_) VALUES (:ID_, :REV_, :PROC_DEF_ID_, :PROC_DEF_KEY_, :ACT_ID_, :JOB_TYPE_, :JOB_CONFIGURATION_, :SUSPENSION_STATE_, :JOB_PRIORITY_, :TENANT_ID_, :DEPLOYMENT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuJobdef entity);

    @SqlQuery("UPDATE FG_ACT_RU_JOBDEF SET ID_ = :ID_, REV_ = :REV_, PROC_DEF_ID_ = :PROC_DEF_ID_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, ACT_ID_ = :ACT_ID_, JOB_TYPE_ = :JOB_TYPE_, JOB_CONFIGURATION_ = :JOB_CONFIGURATION_, SUSPENSION_STATE_ = :SUSPENSION_STATE_, JOB_PRIORITY_ = :JOB_PRIORITY_, TENANT_ID_ = :TENANT_ID_, DEPLOYMENT_ID_ = :DEPLOYMENT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuJobdef entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_JOBDEF WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
