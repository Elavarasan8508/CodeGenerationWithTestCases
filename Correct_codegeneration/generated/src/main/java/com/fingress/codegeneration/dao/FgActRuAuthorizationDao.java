package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuAuthorization;
import com.bsit.codegeneration.mapper.FgActRuAuthorizationMapper;
import java.util.*;

@RegisterRowMapper(FgActRuAuthorizationMapper.class)
public interface FgActRuAuthorizationDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_AUTHORIZATION")
    public List<FgActRuAuthorization> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_AUTHORIZATION WHERE id = :id")
    public Optional<FgActRuAuthorization> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_AUTHORIZATION(ID_, REV_, TYPE_, GROUP_ID_, USER_ID_, RESOURCE_TYPE_, RESOURCE_ID_, PERMS_, REMOVAL_TIME_, ROOT_PROC_INST_ID_) VALUES (:ID_, :REV_, :TYPE_, :GROUP_ID_, :USER_ID_, :RESOURCE_TYPE_, :RESOURCE_ID_, :PERMS_, :REMOVAL_TIME_, :ROOT_PROC_INST_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuAuthorization entity);

    @SqlQuery("UPDATE FG_ACT_RU_AUTHORIZATION SET ID_ = :ID_, REV_ = :REV_, TYPE_ = :TYPE_, GROUP_ID_ = :GROUP_ID_, USER_ID_ = :USER_ID_, RESOURCE_TYPE_ = :RESOURCE_TYPE_, RESOURCE_ID_ = :RESOURCE_ID_, PERMS_ = :PERMS_, REMOVAL_TIME_ = :REMOVAL_TIME_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuAuthorization entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_AUTHORIZATION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
