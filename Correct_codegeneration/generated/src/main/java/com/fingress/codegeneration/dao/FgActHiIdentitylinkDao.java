package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiIdentitylink;
import com.bsit.codegeneration.mapper.FgActHiIdentitylinkMapper;
import java.util.*;

@RegisterRowMapper(FgActHiIdentitylinkMapper.class)
public interface FgActHiIdentitylinkDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_IDENTITYLINK")
    public List<FgActHiIdentitylink> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_IDENTITYLINK WHERE id = :id")
    public Optional<FgActHiIdentitylink> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_IDENTITYLINK(ID_, TIMESTAMP_, TYPE_, USER_ID_, GROUP_ID_, TASK_ID_, PROC_DEF_ID_, OPERATION_TYPE_, ASSIGNER_ID_, PROC_DEF_KEY_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :TIMESTAMP_, :TYPE_, :USER_ID_, :GROUP_ID_, :TASK_ID_, :PROC_DEF_ID_, :OPERATION_TYPE_, :ASSIGNER_ID_, :PROC_DEF_KEY_, :TENANT_ID_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiIdentitylink entity);

    @SqlQuery("UPDATE FG_ACT_HI_IDENTITYLINK SET ID_ = :ID_, TIMESTAMP_ = :TIMESTAMP_, TYPE_ = :TYPE_, USER_ID_ = :USER_ID_, GROUP_ID_ = :GROUP_ID_, TASK_ID_ = :TASK_ID_, PROC_DEF_ID_ = :PROC_DEF_ID_, OPERATION_TYPE_ = :OPERATION_TYPE_, ASSIGNER_ID_ = :ASSIGNER_ID_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, TENANT_ID_ = :TENANT_ID_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiIdentitylink entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_IDENTITYLINK WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
