package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActReCaseDef;
import com.bsit.codegeneration.mapper.FgActReCaseDefMapper;
import java.util.*;

@RegisterRowMapper(FgActReCaseDefMapper.class)
public interface FgActReCaseDefDao {

    @SqlQuery("SELECT * FROM FG_ACT_RE_CASE_DEF")
    public List<FgActReCaseDef> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RE_CASE_DEF WHERE id = :id")
    public Optional<FgActReCaseDef> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RE_CASE_DEF(ID_, REV_, CATEGORY_, NAME_, KEY_, VERSION_, DEPLOYMENT_ID_, RESOURCE_NAME_, DGRM_RESOURCE_NAME_, TENANT_ID_, HISTORY_TTL_) VALUES (:ID_, :REV_, :CATEGORY_, :NAME_, :KEY_, :VERSION_, :DEPLOYMENT_ID_, :RESOURCE_NAME_, :DGRM_RESOURCE_NAME_, :TENANT_ID_, :HISTORY_TTL_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActReCaseDef entity);

    @SqlQuery("UPDATE FG_ACT_RE_CASE_DEF SET ID_ = :ID_, REV_ = :REV_, CATEGORY_ = :CATEGORY_, NAME_ = :NAME_, KEY_ = :KEY_, VERSION_ = :VERSION_, DEPLOYMENT_ID_ = :DEPLOYMENT_ID_, RESOURCE_NAME_ = :RESOURCE_NAME_, DGRM_RESOURCE_NAME_ = :DGRM_RESOURCE_NAME_, TENANT_ID_ = :TENANT_ID_, HISTORY_TTL_ = :HISTORY_TTL_ WHERE id = :id")
    public int update(@BindBean() FgActReCaseDef entity);

    @SqlQuery("DELETE FROM FG_ACT_RE_CASE_DEF WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
