package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActGeSchemaLog;
import com.bsit.codegeneration.mapper.FgActGeSchemaLogMapper;
import java.util.*;

@RegisterRowMapper(FgActGeSchemaLogMapper.class)
public interface FgActGeSchemaLogDao {

    @SqlQuery("SELECT * FROM FG_ACT_GE_SCHEMA_LOG")
    public List<FgActGeSchemaLog> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_GE_SCHEMA_LOG WHERE id = :id")
    public Optional<FgActGeSchemaLog> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_GE_SCHEMA_LOG(ID_, TIMESTAMP_, VERSION_) VALUES (:ID_, :TIMESTAMP_, :VERSION_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActGeSchemaLog entity);

    @SqlQuery("UPDATE FG_ACT_GE_SCHEMA_LOG SET ID_ = :ID_, TIMESTAMP_ = :TIMESTAMP_, VERSION_ = :VERSION_ WHERE id = :id")
    public int update(@BindBean() FgActGeSchemaLog entity);

    @SqlQuery("DELETE FROM FG_ACT_GE_SCHEMA_LOG WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
