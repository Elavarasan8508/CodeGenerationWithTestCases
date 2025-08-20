package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuFilter;
import com.bsit.codegeneration.mapper.FgActRuFilterMapper;
import java.util.*;

@RegisterRowMapper(FgActRuFilterMapper.class)
public interface FgActRuFilterDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_FILTER")
    public List<FgActRuFilter> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_FILTER WHERE id = :id")
    public Optional<FgActRuFilter> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_FILTER(ID_, REV_, RESOURCE_TYPE_, NAME_, OWNER_, QUERY_, PROPERTIES_) VALUES (:ID_, :REV_, :RESOURCE_TYPE_, :NAME_, :OWNER_, :QUERY_, :PROPERTIES_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuFilter entity);

    @SqlQuery("UPDATE FG_ACT_RU_FILTER SET ID_ = :ID_, REV_ = :REV_, RESOURCE_TYPE_ = :RESOURCE_TYPE_, NAME_ = :NAME_, OWNER_ = :OWNER_, QUERY_ = :QUERY_, PROPERTIES_ = :PROPERTIES_ WHERE id = :id")
    public int update(@BindBean() FgActRuFilter entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_FILTER WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
