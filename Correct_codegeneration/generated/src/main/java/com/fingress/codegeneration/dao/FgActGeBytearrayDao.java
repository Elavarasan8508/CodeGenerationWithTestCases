package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActGeBytearray;
import com.bsit.codegeneration.mapper.FgActGeBytearrayMapper;
import java.util.*;

@RegisterRowMapper(FgActGeBytearrayMapper.class)
public interface FgActGeBytearrayDao {

    @SqlQuery("SELECT * FROM FG_ACT_GE_BYTEARRAY")
    public List<FgActGeBytearray> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_GE_BYTEARRAY WHERE id = :id")
    public Optional<FgActGeBytearray> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_GE_BYTEARRAY(ID_, REV_, NAME_, DEPLOYMENT_ID_, BYTES_, GENERATED_, TENANT_ID_, TYPE_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:ID_, :REV_, :NAME_, :DEPLOYMENT_ID_, :BYTES_, :GENERATED_, :TENANT_ID_, :TYPE_, :CREATE_TIME_, :ROOT_PROC_INST_ID_, :REMOVAL_TIME_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActGeBytearray entity);

    @SqlQuery("UPDATE FG_ACT_GE_BYTEARRAY SET ID_ = :ID_, REV_ = :REV_, NAME_ = :NAME_, DEPLOYMENT_ID_ = :DEPLOYMENT_ID_, BYTES_ = :BYTES_, GENERATED_ = :GENERATED_, TENANT_ID_ = :TENANT_ID_, TYPE_ = :TYPE_, CREATE_TIME_ = :CREATE_TIME_, ROOT_PROC_INST_ID_ = :ROOT_PROC_INST_ID_, REMOVAL_TIME_ = :REMOVAL_TIME_ WHERE id = :id")
    public int update(@BindBean() FgActGeBytearray entity);

    @SqlQuery("DELETE FROM FG_ACT_GE_BYTEARRAY WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
