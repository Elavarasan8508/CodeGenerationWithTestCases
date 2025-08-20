package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.IntGroupToMessage;
import com.bsit.codegeneration.mapper.IntGroupToMessageMapper;
import java.util.*;

@RegisterRowMapper(IntGroupToMessageMapper.class)
public interface IntGroupToMessageDao {

    @SqlQuery("SELECT * FROM INT_GROUP_TO_MESSAGE")
    public List<IntGroupToMessage> findAll();

    @SqlQuery("SELECT * FROM INT_GROUP_TO_MESSAGE WHERE id = :id")
    public Optional<IntGroupToMessage> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO INT_GROUP_TO_MESSAGE(GROUP_KEY, MESSAGE_ID, REGION) VALUES (:GROUP_KEY, :MESSAGE_ID, :REGION)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() IntGroupToMessage entity);

    @SqlQuery("UPDATE INT_GROUP_TO_MESSAGE SET GROUP_KEY = :GROUP_KEY, MESSAGE_ID = :MESSAGE_ID, REGION = :REGION WHERE id = :id")
    public int update(@BindBean() IntGroupToMessage entity);

    @SqlQuery("DELETE FROM INT_GROUP_TO_MESSAGE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
