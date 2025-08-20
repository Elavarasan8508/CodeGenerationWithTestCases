package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.IntChannelMessage;
import com.bsit.codegeneration.mapper.IntChannelMessageMapper;
import java.util.*;

@RegisterRowMapper(IntChannelMessageMapper.class)
public interface IntChannelMessageDao {

    @SqlQuery("SELECT * FROM INT_CHANNEL_MESSAGE")
    public List<IntChannelMessage> findAll();

    @SqlQuery("SELECT * FROM INT_CHANNEL_MESSAGE WHERE id = :id")
    public Optional<IntChannelMessage> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO INT_CHANNEL_MESSAGE(MESSAGE_ID, GROUP_KEY, CREATED_DATE, MESSAGE_PRIORITY, MESSAGE_SEQUENCE, MESSAGE_BYTES, REGION) VALUES (:MESSAGE_ID, :GROUP_KEY, :CREATED_DATE, :MESSAGE_PRIORITY, :MESSAGE_SEQUENCE, :MESSAGE_BYTES, :REGION)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() IntChannelMessage entity);

    @SqlQuery("UPDATE INT_CHANNEL_MESSAGE SET MESSAGE_ID = :MESSAGE_ID, GROUP_KEY = :GROUP_KEY, CREATED_DATE = :CREATED_DATE, MESSAGE_PRIORITY = :MESSAGE_PRIORITY, MESSAGE_SEQUENCE = :MESSAGE_SEQUENCE, MESSAGE_BYTES = :MESSAGE_BYTES, REGION = :REGION WHERE id = :id")
    public int update(@BindBean() IntChannelMessage entity);

    @SqlQuery("DELETE FROM INT_CHANNEL_MESSAGE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
