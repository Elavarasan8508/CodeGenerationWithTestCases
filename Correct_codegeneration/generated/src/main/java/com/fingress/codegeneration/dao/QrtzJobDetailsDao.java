package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzJobDetails;
import com.bsit.codegeneration.mapper.QrtzJobDetailsMapper;
import java.util.*;

@RegisterRowMapper(QrtzJobDetailsMapper.class)
public interface QrtzJobDetailsDao {

    @SqlQuery("SELECT * FROM QRTZ_JOB_DETAILS")
    public List<QrtzJobDetails> findAll();

    @SqlQuery("SELECT * FROM QRTZ_JOB_DETAILS WHERE id = :id")
    public Optional<QrtzJobDetails> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_JOB_DETAILS(SCHED_NAME, JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_NONCONCURRENT, IS_UPDATE_DATA, REQUESTS_RECOVERY, JOB_DATA) VALUES (:SCHED_NAME, :JOB_NAME, :JOB_GROUP, :DESCRIPTION, :JOB_CLASS_NAME, :IS_DURABLE, :IS_NONCONCURRENT, :IS_UPDATE_DATA, :REQUESTS_RECOVERY, :JOB_DATA)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzJobDetails entity);

    @SqlQuery("UPDATE QRTZ_JOB_DETAILS SET SCHED_NAME = :SCHED_NAME, JOB_NAME = :JOB_NAME, JOB_GROUP = :JOB_GROUP, DESCRIPTION = :DESCRIPTION, JOB_CLASS_NAME = :JOB_CLASS_NAME, IS_DURABLE = :IS_DURABLE, IS_NONCONCURRENT = :IS_NONCONCURRENT, IS_UPDATE_DATA = :IS_UPDATE_DATA, REQUESTS_RECOVERY = :REQUESTS_RECOVERY, JOB_DATA = :JOB_DATA WHERE id = :id")
    public int update(@BindBean() QrtzJobDetails entity);

    @SqlQuery("DELETE FROM QRTZ_JOB_DETAILS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
