package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzFiredTriggers;
import com.bsit.codegeneration.mapper.QrtzFiredTriggersMapper;
import java.util.*;

@RegisterRowMapper(QrtzFiredTriggersMapper.class)
public interface QrtzFiredTriggersDao {

    @SqlQuery("SELECT * FROM QRTZ_FIRED_TRIGGERS")
    public List<QrtzFiredTriggers> findAll();

    @SqlQuery("SELECT * FROM QRTZ_FIRED_TRIGGERS WHERE id = :id")
    public Optional<QrtzFiredTriggers> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_FIRED_TRIGGERS(SCHED_NAME, ENTRY_ID, TRIGGER_NAME, TRIGGER_GROUP, INSTANCE_NAME, FIRED_TIME, SCHED_TIME, PRIORITY, STATE, JOB_NAME, JOB_GROUP, IS_NONCONCURRENT, REQUESTS_RECOVERY) VALUES (:SCHED_NAME, :ENTRY_ID, :TRIGGER_NAME, :TRIGGER_GROUP, :INSTANCE_NAME, :FIRED_TIME, :SCHED_TIME, :PRIORITY, :STATE, :JOB_NAME, :JOB_GROUP, :IS_NONCONCURRENT, :REQUESTS_RECOVERY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzFiredTriggers entity);

    @SqlQuery("UPDATE QRTZ_FIRED_TRIGGERS SET SCHED_NAME = :SCHED_NAME, ENTRY_ID = :ENTRY_ID, TRIGGER_NAME = :TRIGGER_NAME, TRIGGER_GROUP = :TRIGGER_GROUP, INSTANCE_NAME = :INSTANCE_NAME, FIRED_TIME = :FIRED_TIME, SCHED_TIME = :SCHED_TIME, PRIORITY = :PRIORITY, STATE = :STATE, JOB_NAME = :JOB_NAME, JOB_GROUP = :JOB_GROUP, IS_NONCONCURRENT = :IS_NONCONCURRENT, REQUESTS_RECOVERY = :REQUESTS_RECOVERY WHERE id = :id")
    public int update(@BindBean() QrtzFiredTriggers entity);

    @SqlQuery("DELETE FROM QRTZ_FIRED_TRIGGERS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
