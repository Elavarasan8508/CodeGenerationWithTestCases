package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzSchedulerState;
import com.bsit.codegeneration.mapper.QrtzSchedulerStateMapper;
import java.util.*;

@RegisterRowMapper(QrtzSchedulerStateMapper.class)
public interface QrtzSchedulerStateDao {

    @SqlQuery("SELECT * FROM QRTZ_SCHEDULER_STATE")
    public List<QrtzSchedulerState> findAll();

    @SqlQuery("SELECT * FROM QRTZ_SCHEDULER_STATE WHERE id = :id")
    public Optional<QrtzSchedulerState> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_SCHEDULER_STATE(SCHED_NAME, INSTANCE_NAME, LAST_CHECKIN_TIME, CHECKIN_INTERVAL) VALUES (:SCHED_NAME, :INSTANCE_NAME, :LAST_CHECKIN_TIME, :CHECKIN_INTERVAL)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzSchedulerState entity);

    @SqlQuery("UPDATE QRTZ_SCHEDULER_STATE SET SCHED_NAME = :SCHED_NAME, INSTANCE_NAME = :INSTANCE_NAME, LAST_CHECKIN_TIME = :LAST_CHECKIN_TIME, CHECKIN_INTERVAL = :CHECKIN_INTERVAL WHERE id = :id")
    public int update(@BindBean() QrtzSchedulerState entity);

    @SqlQuery("DELETE FROM QRTZ_SCHEDULER_STATE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
