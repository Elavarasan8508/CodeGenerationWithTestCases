package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActGeProperty;
import com.bsit.codegeneration.mapper.FgActGePropertyMapper;
import java.util.*;

@RegisterRowMapper(FgActGePropertyMapper.class)
public interface FgActGePropertyDao {

    @SqlQuery("SELECT * FROM FG_ACT_GE_PROPERTY")
    public List<FgActGeProperty> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_GE_PROPERTY WHERE id = :id")
    public Optional<FgActGeProperty> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_GE_PROPERTY(NAME_, VALUE_, REV_) VALUES (:NAME_, :VALUE_, :REV_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActGeProperty entity);

    @SqlQuery("UPDATE FG_ACT_GE_PROPERTY SET NAME_ = :NAME_, VALUE_ = :VALUE_, REV_ = :REV_ WHERE id = :id")
    public int update(@BindBean() FgActGeProperty entity);

    @SqlQuery("DELETE FROM FG_ACT_GE_PROPERTY WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
