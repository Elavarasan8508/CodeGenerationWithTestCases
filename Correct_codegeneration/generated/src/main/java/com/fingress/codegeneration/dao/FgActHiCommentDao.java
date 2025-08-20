package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiComment;
import com.bsit.codegeneration.mapper.FgActHiCommentMapper;
import java.util.*;

@RegisterRowMapper(FgActHiCommentMapper.class)
public interface FgActHiCommentDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_COMMENT")
    public List<FgActHiComment> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_COMMENT WHERE id = :id")
    public Optional<FgActHiComment> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_COMMENT(ID_, TYPE_, TIME_, USER_ID_, TASK_ID_, PROC_INST_ID_, ACTION_, MESSAGE_, FULL_MSG_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :TYPE_, :TIME_, :USER_ID_, :TASK_ID_, :PROC_INST_ID_, :ACTION_, :MESSAGE_, :FULL_MSG_, :TENANT_ID_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiComment entity);

    @SqlQuery("UPDATE FG_ACT_HI_COMMENT SET ID_ = :ID_, TYPE_ = :TYPE_, TIME_ = :TIME_, USER_ID_ = :USER_ID_, TASK_ID_ = :TASK_ID_, PROC_INST_ID_ = :PROC_INST_ID_, ACTION_ = :ACTION_, MESSAGE_ = :MESSAGE_, FULL_MSG_ = :FULL_MSG_, TENANT_ID_ = :TENANT_ID_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiComment entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_COMMENT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
