package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActReProcdef;
import com.bsit.codegeneration.mapper.FgActReProcdefMapper;
import java.util.*;

@RegisterRowMapper(FgActReProcdefMapper.class)
public interface FgActReProcdefDao {

    @SqlQuery("SELECT * FROM FG_ACT_RE_PROCDEF")
    public List<FgActReProcdef> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RE_PROCDEF WHERE id = :id")
    public Optional<FgActReProcdef> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RE_PROCDEF(ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, HAS_START_FORM_KEY_, SUSPENSION_STATE_, TENANT_ID_, VERSION_TAG_, HISTORY_TTL_, STARTABLE_) VALUES (:ID_, :REV_, :CATEGORY_, :NAME_, :KEY_, :VERSION_, :DEPLOYMENT_ID_, :RESOURCE_NAME_, :DGRM_RESOURCE_NAME_, :HAS_START_FORM_KEY_, :SUSPENSION_STATE_, :TENANT_ID_, :VERSION_TAG_, :HISTORY_TTL_, :STARTABLE_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActReProcdef entity);

    @SqlQuery("UPDATE FG_ACT_RE_PROCDEF SET ID_ = :ID_, REV_ = :REV_, CATEGORY_ = :CATEGORY_, NAME_ = :NAME_, KEY_ = :KEY_, VERSION_ = :VERSION_, DEPLOYMENT_ID_ = :DEPLOYMENT_ID_, RESOURCE_NAME_ = :RESOURCE_NAME_, DGRM_RESOURCE_NAME_ = :DGRM_RESOURCE_NAME_, HAS_START_FORM_KEY_ = :HAS_START_FORM_KEY_, SUSPENSION_STATE_ = :SUSPENSION_STATE_, TENANT_ID_ = :TENANT_ID_, VERSION_TAG_ = :VERSION_TAG_, HISTORY_TTL_ = :HISTORY_TTL_, STARTABLE_ = :STARTABLE_ WHERE id = :id")
    public int update(@BindBean() FgActReProcdef entity);

    @SqlQuery("DELETE FROM FG_ACT_RE_PROCDEF WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
