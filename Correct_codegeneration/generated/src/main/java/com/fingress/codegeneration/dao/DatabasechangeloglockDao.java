package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.Databasechangeloglock;
import com.bsit.codegeneration.mapper.DatabasechangeloglockMapper;
import java.util.*;

@RegisterRowMapper(DatabasechangeloglockMapper.class)
public interface DatabasechangeloglockDao {

    @SqlQuery("SELECT * FROM DATABASECHANGELOGLOCK")
    public List<Databasechangeloglock> findAll();

    @SqlQuery("SELECT * FROM DATABASECHANGELOGLOCK WHERE id = :id")
    public Optional<Databasechangeloglock> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO DATABASECHANGELOGLOCK(ID, LOCKED, LOCKGRANTED, LOCKEDBY) VALUES (:ID, :LOCKED, :LOCKGRANTED, :LOCKEDBY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() Databasechangeloglock entity);

    @SqlQuery("UPDATE DATABASECHANGELOGLOCK SET ID = :ID, LOCKED = :LOCKED, LOCKGRANTED = :LOCKGRANTED, LOCKEDBY = :LOCKEDBY WHERE id = :id")
    public int update(@BindBean() Databasechangeloglock entity);

    @SqlQuery("DELETE FROM DATABASECHANGELOGLOCK WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
