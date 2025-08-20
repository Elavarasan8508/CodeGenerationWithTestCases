package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActIDTenantMember;
import com.bsit.codegeneration.mapper.FgActIDTenantMemberMapper;
import java.util.*;

@RegisterRowMapper(FgActIDTenantMemberMapper.class)
public interface FgActIDTenantMemberDao {

    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT_MEMBER")
    public List<FgActIDTenantMember> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_ID_TENANT_MEMBER WHERE id = :id")
    public Optional<FgActIDTenantMember> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_ID_TENANT_MEMBER(ID_, TENANT_ID_, USER_ID_, GROUP_ID_) VALUES (:ID_, :TENANT_ID_, :USER_ID_, :GROUP_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActIDTenantMember entity);

    @SqlQuery("UPDATE FG_ACT_ID_TENANT_MEMBER SET ID_ = :ID_, TENANT_ID_ = :TENANT_ID_, USER_ID_ = :USER_ID_, GROUP_ID_ = :GROUP_ID_ WHERE id = :id")
    public int update(@BindBean() FgActIDTenantMember entity);

    @SqlQuery("DELETE FROM FG_ACT_ID_TENANT_MEMBER WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
