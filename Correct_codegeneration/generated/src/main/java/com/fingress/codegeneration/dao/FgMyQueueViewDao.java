package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgMyQueueView;
import com.bsit.codegeneration.mapper.FgMyQueueViewMapper;
import java.util.*;

@RegisterRowMapper(FgMyQueueViewMapper.class)
public interface FgMyQueueViewDao {

    @SqlQuery("SELECT * FROM FG_MY_QUEUE_VIEW")
    public List<FgMyQueueView> findAll();

    @SqlQuery("SELECT * FROM FG_MY_QUEUE_VIEW WHERE id = :id")
    public Optional<FgMyQueueView> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MY_QUEUE_VIEW(ID_, PROC_INST_ID_, NAME_, GROUP_ID_, TENANT_ID_, PROC_DEF_ID_) VALUES (:ID_, :PROC_INST_ID_, :NAME_, :GROUP_ID_, :TENANT_ID_, :PROC_DEF_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgMyQueueView entity);

    @SqlQuery("UPDATE FG_MY_QUEUE_VIEW SET ID_ = :ID_, PROC_INST_ID_ = :PROC_INST_ID_, NAME_ = :NAME_, GROUP_ID_ = :GROUP_ID_, TENANT_ID_ = :TENANT_ID_, PROC_DEF_ID_ = :PROC_DEF_ID_ WHERE id = :id")
    public int update(@BindBean() FgMyQueueView entity);

    @SqlQuery("DELETE FROM FG_MY_QUEUE_VIEW WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
