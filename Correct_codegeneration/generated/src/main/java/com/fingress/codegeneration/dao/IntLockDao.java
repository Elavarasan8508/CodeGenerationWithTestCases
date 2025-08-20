package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.IntLock;
import com.bsit.codegeneration.mapper.IntLockMapper;
import java.util.*;

@RegisterRowMapper(IntLockMapper.class)
public interface IntLockDao {

    @SqlQuery("SELECT * FROM INT_LOCK")
    public List<IntLock> findAll();

    @SqlQuery("SELECT * FROM INT_LOCK WHERE id = :id")
    public Optional<IntLock> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO INT_LOCK(LOCK_KEY, REGION, CLIENT_ID, CREATED_DATE) VALUES (:LOCK_KEY, :REGION, :CLIENT_ID, :CREATED_DATE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() IntLock entity);

    @SqlQuery("UPDATE INT_LOCK SET LOCK_KEY = :LOCK_KEY, REGION = :REGION, CLIENT_ID = :CLIENT_ID, CREATED_DATE = :CREATED_DATE WHERE id = :id")
    public int update(@BindBean() IntLock entity);

    @SqlQuery("DELETE FROM INT_LOCK WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
