package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.JobLog;
import com.bsit.codegeneration.mapper.JobLogMapper;
import java.util.*;

@RegisterRowMapper(JobLogMapper.class)
public interface JobLogDao {

    @SqlQuery("SELECT * FROM JOB_LOG")
    public List<JobLog> findAll();

    @SqlQuery("SELECT * FROM JOB_LOG WHERE id = :id")
    public Optional<JobLog> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO JOB_LOG(LOG_TIME, MESSAGE) VALUES (:LOG_TIME, :MESSAGE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() JobLog entity);

    @SqlQuery("UPDATE JOB_LOG SET LOG_TIME = :LOG_TIME, MESSAGE = :MESSAGE WHERE id = :id")
    public int update(@BindBean() JobLog entity);

    @SqlQuery("DELETE FROM JOB_LOG WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
