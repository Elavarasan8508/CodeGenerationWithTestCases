package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActReDecisionReqDef;
import com.bsit.codegeneration.mapper.FgActReDecisionReqDefMapper;
import java.util.*;

@RegisterRowMapper(FgActReDecisionReqDefMapper.class)
public interface FgActReDecisionReqDefDao {

    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_REQ_DEF")
    public List<FgActReDecisionReqDef> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RE_DECISION_REQ_DEF WHERE id = :id")
    public Optional<FgActReDecisionReqDef> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RE_DECISION_REQ_DEF(ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, TENANT_ID_) VALUES (:ID_, :REV_, :CATEGORY_, :NAME_, :KEY_, :VERSION_, :DEPLOYMENT_ID_, :RESOURCE_NAME_, :DGRM_RESOURCE_NAME_, :TENANT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActReDecisionReqDef entity);

    @SqlQuery("UPDATE FG_ACT_RE_DECISION_REQ_DEF SET ID_ = :ID_, REV_ = :REV_, CATEGORY_ = :CATEGORY_, NAME_ = :NAME_, KEY_ = :KEY_, VERSION_ = :VERSION_, DEPLOYMENT_ID_ = :DEPLOYMENT_ID_, RESOURCE_NAME_ = :RESOURCE_NAME_, DGRM_RESOURCE_NAME_ = :DGRM_RESOURCE_NAME_, TENANT_ID_ = :TENANT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActReDecisionReqDef entity);

    @SqlQuery("DELETE FROM FG_ACT_RE_DECISION_REQ_DEF WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
