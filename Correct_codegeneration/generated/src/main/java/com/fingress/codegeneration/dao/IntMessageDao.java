package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.IntMessage;
import com.bsit.codegeneration.mapper.IntMessageMapper;
import java.util.*;

@RegisterRowMapper(IntMessageMapper.class)
public interface IntMessageDao {

    @SqlQuery("SELECT * FROM INT_MESSAGE")
    public List<IntMessage> findAll();

    @SqlQuery("SELECT * FROM INT_MESSAGE WHERE id = :id")
    public Optional<IntMessage> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO INT_MESSAGE(MESSAGE_ID, REGION, CREATED_DATE, MESSAGE_BYTES) VALUES (:MESSAGE_ID, :REGION, :CREATED_DATE, :MESSAGE_BYTES)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() IntMessage entity);

    @SqlQuery("UPDATE INT_MESSAGE SET MESSAGE_ID = :MESSAGE_ID, REGION = :REGION, CREATED_DATE = :CREATED_DATE, MESSAGE_BYTES = :MESSAGE_BYTES WHERE id = :id")
    public int update(@BindBean() IntMessage entity);

    @SqlQuery("DELETE FROM INT_MESSAGE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
