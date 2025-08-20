package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.SpringSession;
import com.bsit.codegeneration.mapper.SpringSessionMapper;
import java.util.*;

@RegisterRowMapper(SpringSessionMapper.class)
public interface SpringSessionDao {

    @SqlQuery("SELECT * FROM SPRING_SESSION")
    public List<SpringSession> findAll();

    @SqlQuery("SELECT * FROM SPRING_SESSION WHERE id = :id")
    public Optional<SpringSession> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO SPRING_SESSION(PRIMARY_ID, SESSION_ID, CREATION_TIME, LAST_ACCESS_TIME, MAX_INACTIVE_INTERVAL, EXPIRY_TIME, PRINCIPAL_NAME) VALUES (:PRIMARY_ID, :SESSION_ID, :CREATION_TIME, :LAST_ACCESS_TIME, :MAX_INACTIVE_INTERVAL, :EXPIRY_TIME, :PRINCIPAL_NAME)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() SpringSession entity);

    @SqlQuery("UPDATE SPRING_SESSION SET PRIMARY_ID = :PRIMARY_ID, SESSION_ID = :SESSION_ID, CREATION_TIME = :CREATION_TIME, LAST_ACCESS_TIME = :LAST_ACCESS_TIME, MAX_INACTIVE_INTERVAL = :MAX_INACTIVE_INTERVAL, EXPIRY_TIME = :EXPIRY_TIME, PRINCIPAL_NAME = :PRINCIPAL_NAME WHERE id = :id")
    public int update(@BindBean() SpringSession entity);

    @SqlQuery("DELETE FROM SPRING_SESSION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
