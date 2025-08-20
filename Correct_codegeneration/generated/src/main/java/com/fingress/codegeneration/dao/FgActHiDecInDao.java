package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActHiDecIn;
import com.bsit.codegeneration.mapper.FgActHiDecInMapper;
import java.util.*;

@RegisterRowMapper(FgActHiDecInMapper.class)
public interface FgActHiDecInDao {

    @SqlQuery("SELECT * FROM FG_ACT_HI_DEC_IN")
    public List<FgActHiDecIn> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_HI_DEC_IN WHERE id = :id")
    public Optional<FgActHiDecIn> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_HI_DEC_IN(ID_, DEC_INST_ID_, CLAUSE_ID_, CLAUSE_NAME_, VAR_TYPE_, BYTEARRAY_ID_, DOUBLE_, LONG_, TEXT_, TEXT2_, TENANT_ID_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :DEC_INST_ID_, :CLAUSE_ID_, :CLAUSE_NAME_, :VAR_TYPE_, :BYTEARRAY_ID_, :DOUBLE_, :LONG_, :TEXT_, :TEXT2_, :TENANT_ID_, :CREATE_TIME_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActHiDecIn entity);

    @SqlQuery("UPDATE FG_ACT_HI_DEC_IN SET ID_ = :ID_, DEC_INST_ID_ = :DEC_INST_ID_, CLAUSE_ID_ = :CLAUSE_ID_, CLAUSE_NAME_ = :CLAUSE_NAME_, VAR_TYPE_ = :VAR_TYPE_, BYTEARRAY_ID_ = :BYTEARRAY_ID_, DOUBLE_ = :DOUBLE_, LONG_ = :LONG_, TEXT_ = :TEXT_, TEXT2_ = :TEXT2_, TENANT_ID_ = :TENANT_ID_, CREATE_TIME_ = :CREATE_TIME_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActHiDecIn entity);

    @SqlQuery("DELETE FROM FG_ACT_HI_DEC_IN WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
