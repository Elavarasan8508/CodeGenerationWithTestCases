package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActIDUser;
import com.bsit.codegeneration.mapper.FgActIDUserMapper;
import java.util.*;

@RegisterRowMapper(FgActIDUserMapper.class)
public interface FgActIDUserDao {

    @SqlQuery("SELECT * FROM FG_ACT_ID_USER")
    public List<FgActIDUser> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_ID_USER WHERE id = :id")
    public Optional<FgActIDUser> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_ID_USER(ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, SALT_, PICTURE_ID_, LOCK_EXP_TIME_, ATTEMPTS_) VALUES (:ID_, :REV_, :FIRST_, :LAST_, :EMAIL_, :PWD_, :SALT_, :PICTURE_ID_, :LOCK_EXP_TIME_, :ATTEMPTS_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActIDUser entity);

    @SqlQuery("UPDATE FG_ACT_ID_USER SET ID_ = :ID_, REV_ = :REV_, FIRST_ = :FIRST_, LAST_ = :LAST_, EMAIL_ = :EMAIL_, PWD_ = :PWD_, SALT_ = :SALT_, PICTURE_ID_ = :PICTURE_ID_, LOCK_EXP_TIME_ = :LOCK_EXP_TIME_, ATTEMPTS_ = :ATTEMPTS_ WHERE id = :id")
    public int update(@BindBean() FgActIDUser entity);

    @SqlQuery("DELETE FROM FG_ACT_ID_USER WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
