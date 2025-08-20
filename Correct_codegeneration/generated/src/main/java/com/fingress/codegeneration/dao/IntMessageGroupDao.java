package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.IntMessageGroup;
import com.bsit.codegeneration.mapper.IntMessageGroupMapper;
import java.util.*;

@RegisterRowMapper(IntMessageGroupMapper.class)
public interface IntMessageGroupDao {

    @SqlQuery("SELECT * FROM INT_MESSAGE_GROUP")
    public List<IntMessageGroup> findAll();

    @SqlQuery("SELECT * FROM INT_MESSAGE_GROUP WHERE id = :id")
    public Optional<IntMessageGroup> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO INT_MESSAGE_GROUP(GROUP_KEY, REGION, MARKED, COMPLETE, LAST_RELEASED_SEQUENCE, CREATED_DATE, UPDATED_DATE) VALUES (:GROUP_KEY, :REGION, :MARKED, :COMPLETE, :LAST_RELEASED_SEQUENCE, :CREATED_DATE, :UPDATED_DATE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() IntMessageGroup entity);

    @SqlQuery("UPDATE INT_MESSAGE_GROUP SET GROUP_KEY = :GROUP_KEY, REGION = :REGION, MARKED = :MARKED, COMPLETE = :COMPLETE, LAST_RELEASED_SEQUENCE = :LAST_RELEASED_SEQUENCE, CREATED_DATE = :CREATED_DATE, UPDATED_DATE = :UPDATED_DATE WHERE id = :id")
    public int update(@BindBean() IntMessageGroup entity);

    @SqlQuery("DELETE FROM INT_MESSAGE_GROUP WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
