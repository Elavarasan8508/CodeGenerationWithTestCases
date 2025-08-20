package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActReDecisionDef;
import com.bsit.codegeneration.mapper.FgActReDecisionDefMapper;
import java.util.*;

@RegisterRowMapper(FgActReDecisionDefMapper.class)
public interface FgActReDecisionDefDao {

    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_DEF")
    public List<FgActReDecisionDef> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_DEF WHERE id = :id")
    public Optional<FgActReDecisionDef> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RE_DECISION_DEF(ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, HISTORY_TTL_, VERSION_TAG_) VALUES (:ID_, :REV_, :CATEGORY_, :NAME_, :KEY_, :VERSION_, :DEPLOYMENT_ID_, :RESOURCE_NAME_, :DGRM_RESOURCE_NAME_, :DEC_REQ_ID_, :DEC_REQ_KEY_, :TENANT_ID_, :HISTORY_TTL_, :VERSION_TAG_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActReDecisionDef entity);

    @SqlQuery("UPDATE FG_ACT_RE_DECISION_DEF SET ID_ = :ID_, REV_ = :REV_, CATEGORY_ = :CATEGORY_, NAME_ = :NAME_, KEY_ = :KEY_, VERSION_ = :VERSION_, DEPLOYMENT_ID_ = :DEPLOYMENT_ID_, RESOURCE_NAME_ = :RESOURCE_NAME_, DGRM_RESOURCE_NAME_ = :DGRM_RESOURCE_NAME_, DEC_REQ_ID_ = :DEC_REQ_ID_, DEC_REQ_KEY_ = :DEC_REQ_KEY_, TENANT_ID_ = :TENANT_ID_, HISTORY_TTL_ = :HISTORY_TTL_, VERSION_TAG_ = :VERSION_TAG_ WHERE id = :id")
    public int update(@BindBean() FgActReDecisionDef entity);

    @SqlQuery("DELETE FROM FG_ACT_RE_DECISION_DEF WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
