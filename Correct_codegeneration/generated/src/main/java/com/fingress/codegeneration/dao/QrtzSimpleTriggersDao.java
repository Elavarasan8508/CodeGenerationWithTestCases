package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzSimpleTriggers;
import com.bsit.codegeneration.mapper.QrtzSimpleTriggersMapper;
import java.util.*;

@RegisterRowMapper(QrtzSimpleTriggersMapper.class)
public interface QrtzSimpleTriggersDao {

    @SqlQuery("SELECT * FROM QRTZ_SIMPLE_TRIGGERS")
    public List<QrtzSimpleTriggers> findAll();

    @SqlQuery("SELECT * FROM QRTZ_SIMPLE_TRIGGERS WHERE id = :id")
    public Optional<QrtzSimpleTriggers> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_SIMPLE_TRIGGERS(SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, REPEAT_COUNT, REPEAT_INTERVAL, TIMES_TRIGGERED) VALUES (:SCHED_NAME, :TRIGGER_NAME, :TRIGGER_GROUP, :REPEAT_COUNT, :REPEAT_INTERVAL, :TIMES_TRIGGERED)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzSimpleTriggers entity);

    @SqlQuery("UPDATE QRTZ_SIMPLE_TRIGGERS SET SCHED_NAME = :SCHED_NAME, TRIGGER_NAME = :TRIGGER_NAME, TRIGGER_GROUP = :TRIGGER_GROUP, REPEAT_COUNT = :REPEAT_COUNT, REPEAT_INTERVAL = :REPEAT_INTERVAL, TIMES_TRIGGERED = :TIMES_TRIGGERED WHERE id = :id")
    public int update(@BindBean() QrtzSimpleTriggers entity);

    @SqlQuery("DELETE FROM QRTZ_SIMPLE_TRIGGERS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
