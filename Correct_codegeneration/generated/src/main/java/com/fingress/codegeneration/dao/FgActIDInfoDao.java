package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActIDInfo;
import com.bsit.codegeneration.mapper.FgActIDInfoMapper;
import java.util.*;

@RegisterRowMapper(FgActIDInfoMapper.class)
public interface FgActIDInfoDao {

    @SqlQuery("SELECT * FROM FG_ACT_ID_INFO")
    public List<FgActIDInfo> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_ID_INFO WHERE id = :id")
    public Optional<FgActIDInfo> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_ID_INFO(ID_, REV_, USER_ID_, TYPE_, KEY_, VALUE_, PASSWORD_, PARENT_ID_) VALUES (:ID_, :REV_, :USER_ID_, :TYPE_, :KEY_, :VALUE_, :PASSWORD_, :PARENT_ID_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActIDInfo entity);

    @SqlQuery("UPDATE FG_ACT_ID_INFO SET ID_ = :ID_, REV_ = :REV_, USER_ID_ = :USER_ID_, TYPE_ = :TYPE_, KEY_ = :KEY_, VALUE_ = :VALUE_, PASSWORD_ = :PASSWORD_, PARENT_ID_ = :PARENT_ID_ WHERE id = :id")
    public int update(@BindBean() FgActIDInfo entity);

    @SqlQuery("DELETE FROM FG_ACT_ID_INFO WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
