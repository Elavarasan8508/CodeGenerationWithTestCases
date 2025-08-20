package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuIdentitylink;
import com.bsit.codegeneration.mapper.FgActRuIdentitylinkMapper;
import java.util.*;

@RegisterRowMapper(FgActRuIdentitylinkMapper.class)
public interface FgActRuIdentitylinkDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_IDENTITYLINK")
    public List<FgActRuIdentitylink> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_IDENTITYLINK WHERE id = :id")
    public Optional<FgActRuIdentitylink> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_IDENTITYLINK(ID_, REV_, GROUP_ID_, TYPE_, USER_ID_, TASK_ID_, PROC_DEF_ID_, TENANT_ID_) VALUES (:ID_, :REV_, :GROUP_ID_, :TYPE_, :USER_ID_, :TASK_ID_, :PROC_DEF_ID_, :TENANT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuIdentitylink entity);

    @SqlQuery("UPDATE FG_ACT_RU_IDENTITYLINK SET ID_ = :ID_, REV_ = :REV_, GROUP_ID_ = :GROUP_ID_, TYPE_ = :TYPE_, USER_ID_ = :USER_ID_, TASK_ID_ = :TASK_ID_, PROC_DEF_ID_ = :PROC_DEF_ID_, TENANT_ID_ = :TENANT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActRuIdentitylink entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_IDENTITYLINK WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
