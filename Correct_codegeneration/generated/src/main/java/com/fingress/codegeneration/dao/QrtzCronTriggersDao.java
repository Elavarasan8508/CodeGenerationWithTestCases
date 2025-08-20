package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzCronTriggers;
import com.bsit.codegeneration.mapper.QrtzCronTriggersMapper;
import java.util.*;

@RegisterRowMapper(QrtzCronTriggersMapper.class)
public interface QrtzCronTriggersDao {

    @SqlQuery("SELECT * FROM QRTZ_CRON_TRIGGERS")
    public List<QrtzCronTriggers> findAll();

    @SqlQuery("SELECT * FROM QRTZ_CRON_TRIGGERS WHERE id = :id")
    public Optional<QrtzCronTriggers> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_CRON_TRIGGERS(SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, CRON_EXPRESSION, TIME_ZONE_ID) VALUES (:SCHED_NAME, :TRIGGER_NAME, :TRIGGER_GROUP, :CRON_EXPRESSION, :TIME_ZONE_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzCronTriggers entity);

    @SqlQuery("UPDATE QRTZ_CRON_TRIGGERS SET SCHED_NAME = :SCHED_NAME, TRIGGER_NAME = :TRIGGER_NAME, TRIGGER_GROUP = :TRIGGER_GROUP, CRON_EXPRESSION = :CRON_EXPRESSION, TIME_ZONE_ID = :TIME_ZONE_ID WHERE id = :id")
    public int update(@BindBean() QrtzCronTriggers entity);

    @SqlQuery("DELETE FROM QRTZ_CRON_TRIGGERS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
