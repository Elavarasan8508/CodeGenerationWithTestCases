package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActReDeployment;
import com.bsit.codegeneration.mapper.FgActReDeploymentMapper;
import java.util.*;

@RegisterRowMapper(FgActReDeploymentMapper.class)
public interface FgActReDeploymentDao {

    @SqlQuery("SELECT * FROM FG_ACT_RE_DEPLOYMENT")
    public List<FgActReDeployment> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RE_DEPLOYMENT WHERE id = :id")
    public Optional<FgActReDeployment> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RE_DEPLOYMENT(ID_, NAME_, DEPLOY_TIME_, SOURCE_, TENANT_ID_) VALUES (:ID_, :NAME_, :DEPLOY_TIME_, :SOURCE_, :TENANT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActReDeployment entity);

    @SqlQuery("UPDATE FG_ACT_RE_DEPLOYMENT SET ID_ = :ID_, NAME_ = :NAME_, DEPLOY_TIME_ = :DEPLOY_TIME_, SOURCE_ = :SOURCE_, TENANT_ID_ = :TENANT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActReDeployment entity);

    @SqlQuery("DELETE FROM FG_ACT_RE_DEPLOYMENT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
