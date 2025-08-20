package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.SpringSessionAttributes;
import com.bsit.codegeneration.mapper.SpringSessionAttributesMapper;
import java.util.*;

@RegisterRowMapper(SpringSessionAttributesMapper.class)
public interface SpringSessionAttributesDao {

    @SqlQuery("SELECT * FROM SPRING_SESSION_ATTRIBUTES")
    public List<SpringSessionAttributes> findAll();

    @SqlQuery("SELECT * FROM SPRING_SESSION_ATTRIBUTES WHERE id = :id")
    public Optional<SpringSessionAttributes> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO SPRING_SESSION_ATTRIBUTES(SESSION_PRIMARY_ID, ATTRIBUTE_NAME, ATTRIBUTE_BYTES) VALUES (:SESSION_PRIMARY_ID, :ATTRIBUTE_NAME, :ATTRIBUTE_BYTES)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() SpringSessionAttributes entity);

    @SqlQuery("UPDATE SPRING_SESSION_ATTRIBUTES SET SESSION_PRIMARY_ID = :SESSION_PRIMARY_ID, ATTRIBUTE_NAME = :ATTRIBUTE_NAME, ATTRIBUTE_BYTES = :ATTRIBUTE_BYTES WHERE id = :id")
    public int update(@BindBean() SpringSessionAttributes entity);

    @SqlQuery("DELETE FROM SPRING_SESSION_ATTRIBUTES WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
