package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuEventSubscr;
import com.bsit.codegeneration.mapper.FgActRuEventSubscrMapper;
import java.util.*;

@RegisterRowMapper(FgActRuEventSubscrMapper.class)
public interface FgActRuEventSubscrDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_EVENT_SUBSCR")
    public List<FgActRuEventSubscr> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_EVENT_SUBSCR WHERE id = :id")
    public Optional<FgActRuEventSubscr> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_EVENT_SUBSCR(ID_, REV_, EVENT_TYPE_, EVENT_NAME_, EXECUTION_ID_, PROC_INST_ID_, ACTIVITY_ID_, CONFIGURATION_, CREATED_, TENANT_ID_) VALUES (:ID_, :REV_, :EVENT_TYPE_, :EVENT_NAME_, :EXECUTION_ID_, :PROC_INST_ID_, :ACTIVITY_ID_, :CONFIGURATION_, :CREATED_, :TENANT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuEventSubscr entity);

    @SqlQuery("UPDATE FG_ACT_RU_EVENT_SUBSCR SET ID_ = :ID_, REV_ = :REV_, EVENT_TYPE_ = :EVENT_TYPE_, EVENT_NAME_ = :EVENT_NAME_, EXECUTION_ID_ = :EXECUTION_ID_, PROC_INST_ID_ = :PROC_INST_ID_, ACTIVITY_ID_ = :ACTIVITY_ID_, CONFIGURATION_ = :CONFIGURATION_, CREATED_ = :CREATED_, TENANT_ID_ = :TENANT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuEventSubscr entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_EVENT_SUBSCR WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
