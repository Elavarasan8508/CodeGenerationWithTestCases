package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiDecinst;
import com.bsit.codegeneration.mapper.FgActHiDecinstMapper;
import java.util.*;

@RegisterRowMapper(FgActHiDecinstMapper.class)
public interface FgActHiDecinstDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_DECINST")
    public List<FgActHiDecinst> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_DECINST WHERE id = :id")
    public Optional<FgActHiDecinst> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_DECINST(ID_, DEC_DEF_ID_, DEC_DEF_KEY_, DEC_DEF_NAME_, PROC_DEF_KEY_, PROC_DEF_ID_, PROC_INST_ID_, CASE_DEF_KEY_, CASE_DEF_ID_, CASE_INST_ID_, ACT_INST_ID_, ACT_ID_, EVAL_TIME_, COLLECT_VALUE_, USER_ID_, ROOT_DEC_INST_ID_, DEC_REQ_ID_, DEC_REQ_KEY_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :DEC_DEF_ID_, :DEC_DEF_KEY_, :DEC_DEF_NAME_, :PROC_DEF_KEY_, :PROC_DEF_ID_, :PROC_INST_ID_, :CASE_DEF_KEY_, :CASE_DEF_ID_, :CASE_INST_ID_, :ACT_INST_ID_, :ACT_ID_, :EVAL_TIME_, :COLLECT_VALUE_, :USER_ID_, :ROOT_DEC_INST_ID_, :DEC_REQ_ID_, :DEC_REQ_KEY_, :TENANT_ID_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiDecinst entity);

    @SqlQuery("UPDATE FG_ACT_HI_DECINST SET ID_ = :ID_, DEC_DEF_ID_ = :DEC_DEF_ID_, DEC_DEF_KEY_ = :DEC_DEF_KEY_, DEC_DEF_NAME_ = :DEC_DEF_NAME_, PROC_DEF_KEY_ = :PROC_DEF_KEY_, PROC_DEF_ID_ = :PROC_DEF_ID_, PROC_INST_ID_ = :PROC_INST_ID_, CASE_DEF_KEY_ = :CASE_DEF_KEY_, CASE_DEF_ID_ = :CASE_DEF_ID_, CASE_INST_ID_ = :CASE_INST_ID_, ACT_INST_ID_ = :ACT_INST_ID_, ACT_ID_ = :ACT_ID_, EVAL_TIME_ = :EVAL_TIME_, COLLECT_VALUE_ = :COLLECT_VALUE_, USER_ID_ = :USER_ID_, ROOT_DEC_INST_ID_ = :ROOT_DEC_INST_ID_, DEC_REQ_ID_ = :DEC_REQ_ID_, DEC_REQ_KEY_ = :DEC_REQ_KEY_, TENANT_ID_ = :TENANT_ID_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiDecinst entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_DECINST WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
