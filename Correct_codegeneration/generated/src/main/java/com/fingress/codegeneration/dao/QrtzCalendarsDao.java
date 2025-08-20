package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzCalendars;
import com.bsit.codegeneration.mapper.QrtzCalendarsMapper;
import java.util.*;

@RegisterRowMapper(QrtzCalendarsMapper.class)
public interface QrtzCalendarsDao {

    @SqlQuery("SELECT * FROM QRTZ_CALENDARS")
    public List<QrtzCalendars> findAll();

    @SqlQuery("SELECT * FROM QRTZ_CALENDARS WHERE id = :id")
    public Optional<QrtzCalendars> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_CALENDARS(SCHED_NAME, CALENDAR_NAME, CALENDAR) VALUES (:SCHED_NAME, :CALENDAR_NAME, :CALENDAR)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzCalendars entity);

    @SqlQuery("UPDATE QRTZ_CALENDARS SET SCHED_NAME = :SCHED_NAME, CALENDAR_NAME = :CALENDAR_NAME, CALENDAR = :CALENDAR WHERE id = :id")
    public int update(@BindBean() QrtzCalendars entity);

    @SqlQuery("DELETE FROM QRTZ_CALENDARS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
