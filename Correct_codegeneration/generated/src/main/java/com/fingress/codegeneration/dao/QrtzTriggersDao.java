package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzTriggers;
import com.bsit.codegeneration.mapper.QrtzTriggersMapper;
import java.util.*;

@RegisterRowMapper(QrtzTriggersMapper.class)
public interface QrtzTriggersDao {

    @SqlQuery("SELECT * FROM QRTZ_TRIGGERS")
    public List<QrtzTriggers> findAll();

    @SqlQuery("SELECT * FROM QRTZ_TRIGGERS WHERE id = :id")
    public Optional<QrtzTriggers> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_TRIGGERS(SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, JOB_NAME, JOB_GROUP, DESCRIPTION, NEXT_FIRE_TIME, PREV_FIRE_TIME, PRIORITY, TRIGGER_STATE, TRIGGER_TYPE, START_TIME, END_TIME, CALENDAR_NAME, MISFIRE_INSTR, JOB_DATA) VALUES (:SCHED_NAME, :TRIGGER_NAME, :TRIGGER_GROUP, :JOB_NAME, :JOB_GROUP, :DESCRIPTION, :NEXT_FIRE_TIME, :PREV_FIRE_TIME, :PRIORITY, :TRIGGER_STATE, :TRIGGER_TYPE, :START_TIME, :END_TIME, :CALENDAR_NAME, :MISFIRE_INSTR, :JOB_DATA)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzTriggers entity);

    @SqlQuery("UPDATE QRTZ_TRIGGERS SET SCHED_NAME = :SCHED_NAME, TRIGGER_NAME = :TRIGGER_NAME, TRIGGER_GROUP = :TRIGGER_GROUP, JOB_NAME = :JOB_NAME, JOB_GROUP = :JOB_GROUP, DESCRIPTION = :DESCRIPTION, NEXT_FIRE_TIME = :NEXT_FIRE_TIME, PREV_FIRE_TIME = :PREV_FIRE_TIME, PRIORITY = :PRIORITY, TRIGGER_STATE = :TRIGGER_STATE, TRIGGER_TYPE = :TRIGGER_TYPE, START_TIME = :START_TIME, END_TIME = :END_TIME, CALENDAR_NAME = :CALENDAR_NAME, MISFIRE_INSTR = :MISFIRE_INSTR, JOB_DATA = :JOB_DATA WHERE id = :id")
    public int update(@BindBean() QrtzTriggers entity);

    @SqlQuery("DELETE FROM QRTZ_TRIGGERS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
