package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActIDTenant;
import com.bsit.codegeneration.mapper.FgActIDTenantMapper;
import java.util.*;

@RegisterRowMapper(FgActIDTenantMapper.class)
public interface FgActIDTenantDao {

    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT")
    public List<FgActIDTenant> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT WHERE id = :id")
    public Optional<FgActIDTenant> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_ID_TENANT(ID_, REV_, NAME_) VALUES (:ID_, :REV_, :NAME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActIDTenant entity);

    @SqlQuery("UPDATE FG_ACT_ID_TENANT SET ID_ = :ID_, REV_ = :REV_, NAME_ = :NAME_ WHERE id = :id")
    public int update(@BindBean() FgActIDTenant entity);

    @SqlQuery("DELETE FROM FG_ACT_ID_TENANT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
