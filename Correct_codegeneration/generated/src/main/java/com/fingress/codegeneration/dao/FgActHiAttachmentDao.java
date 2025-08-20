package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiAttachment;
import com.bsit.codegeneration.mapper.FgActHiAttachmentMapper;
import java.util.*;

@RegisterRowMapper(FgActHiAttachmentMapper.class)
public interface FgActHiAttachmentDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_ATTACHMENT")
    public List<FgActHiAttachment> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_ATTACHMENT WHERE id = :id")
    public Optional<FgActHiAttachment> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_ATTACHMENT(ID_, REV_, USER_ID_, NAME_, DESCRIPTION_, TYPE_, TASK_ID_, PROC_INST_ID_, URL_, CONTENT_ID_, TENANT_ID_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :REV_, :USER_ID_, :NAME_, :DESCRIPTION_, :TYPE_, :TASK_ID_, :PROC_INST_ID_, :URL_, :CONTENT_ID_, :TENANT_ID_, :CREATE_TIME_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiAttachment entity);

    @SqlQuery("UPDATE FG_ACT_HI_ATTACHMENT SET ID_ = :ID_, REV_ = :REV_, USER_ID_ = :USER_ID_, NAME_ = :NAME_, DESCRIPTION_ = :DESCRIPTION_, TYPE_ = :TYPE_, TASK_ID_ = :TASK_ID_, PROC_INST_ID_ = :PROC_INST_ID_, URL_ = :URL_, CONTENT_ID_ = :CONTENT_ID_, TENANT_ID_ = :TENANT_ID_, CREATE_TIME_ = :CREATE_TIME_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiAttachment entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_ATTACHMENT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
