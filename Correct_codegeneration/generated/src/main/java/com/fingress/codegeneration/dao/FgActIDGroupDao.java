package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActIDGroup;
import com.bsit.codegeneration.mapper.FgActIDGroupMapper;
import java.util.*;

@RegisterRowMapper(FgActIDGroupMapper.class)
public interface FgActIDGroupDao {

    @SqlQuery("SELECT * FROM FG_ACT_ID_GROUP")
    public List<FgActIDGroup> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_ID_GROUP WHERE id = :id")
    public Optional<FgActIDGroup> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_ID_GROUP(ID_, REV_, NAME_, TYPE_) VALUES (:ID_, :REV_, :NAME_, :TYPE_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActIDGroup entity);

    @SqlQuery("UPDATE FG_ACT_ID_GROUP SET ID_ = :ID_, REV_ = :REV_, NAME_ = :NAME_, TYPE_ = :TYPE_ WHERE id = :id")
    public int update(@BindBean() FgActIDGroup entity);

    @SqlQuery("DELETE FROM FG_ACT_ID_GROUP WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
