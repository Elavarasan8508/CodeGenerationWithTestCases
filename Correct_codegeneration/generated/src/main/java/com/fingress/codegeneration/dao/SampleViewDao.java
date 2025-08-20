package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.SampleView;
import com.bsit.codegeneration.mapper.SampleViewMapper;
import java.util.*;

@RegisterRowMapper(SampleViewMapper.class)
public interface SampleViewDao {

    @SqlQuery("SELECT * FROM SAMPLE_VIEW")
    public List<SampleView> findAll();

    @SqlQuery("SELECT * FROM SAMPLE_VIEW WHERE id = :id")
    public Optional<SampleView> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO SAMPLE_VIEW(NAME, AGE) VALUES (:NAME, :AGE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() SampleView entity);

    @SqlQuery("UPDATE SAMPLE_VIEW SET NAME = :NAME, AGE = :AGE WHERE id = :id")
    public int update(@BindBean() SampleView entity);

    @SqlQuery("DELETE FROM SAMPLE_VIEW WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
