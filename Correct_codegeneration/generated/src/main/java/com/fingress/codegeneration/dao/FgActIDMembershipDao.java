package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActIDMembership;
import com.bsit.codegeneration.mapper.FgActIDMembershipMapper;
import java.util.*;

@RegisterRowMapper(FgActIDMembershipMapper.class)
public interface FgActIDMembershipDao {

    @SqlQuery("SELECT * FROM FG_ACT_ID_MEMBERSHIP")
    public List<FgActIDMembership> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_ID_MEMBERSHIP WHERE id = :id")
    public Optional<FgActIDMembership> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_ID_MEMBERSHIP(USER_ID_, GROUP_ID_) VALUES (:USER_ID_, :GROUP_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActIDMembership entity);

    @SqlQuery("UPDATE FG_ACT_ID_MEMBERSHIP SET USER_ID_ = :USER_ID_, GROUP_ID_ = :GROUP_ID_ WHERE id = :id")
    public int update(@BindBean() FgActIDMembership entity);

    @SqlQuery("DELETE FROM FG_ACT_ID_MEMBERSHIP WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
