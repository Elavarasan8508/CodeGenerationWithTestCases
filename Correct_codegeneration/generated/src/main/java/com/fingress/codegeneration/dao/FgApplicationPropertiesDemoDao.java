package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgApplicationPropertiesDemo;
import com.bsit.codegeneration.mapper.FgApplicationPropertiesDemoMapper;
import java.util.*;

@RegisterRowMapper(FgApplicationPropertiesDemoMapper.class)
public interface FgApplicationPropertiesDemoDao {

    @SqlQuery("SELECT * FROM FG_APPLICATION_PROPERTIES_DEMO")
    public List<FgApplicationPropertiesDemo> findAll();

    @SqlQuery("SELECT * FROM FG_APPLICATION_PROPERTIES_DEMO WHERE id = :id")
    public Optional<FgApplicationPropertiesDemo> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_APPLICATION_PROPERTIES_DEMO(KEY, VALUE) VALUES (:KEY, :VALUE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgApplicationPropertiesDemo entity);

    @SqlQuery("UPDATE FG_APPLICATION_PROPERTIES_DEMO SET KEY = :KEY, VALUE = :VALUE WHERE id = :id")
    public int update(@BindBean() FgApplicationPropertiesDemo entity);

    @SqlQuery("DELETE FROM FG_APPLICATION_PROPERTIES_DEMO WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
