package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzPausedTriggerGrps;
import com.bsit.codegeneration.mapper.QrtzPausedTriggerGrpsMapper;
import java.util.*;

@RegisterRowMapper(QrtzPausedTriggerGrpsMapper.class)
public interface QrtzPausedTriggerGrpsDao {

    @SqlQuery("SELECT * FROM QRTZ_PAUSED_TRIGGER_GRPS")
    public List<QrtzPausedTriggerGrps> findAll();

    @SqlQuery("SELECT * FROM QRTZ_PAUSED_TRIGGER_GRPS WHERE id = :id")
    public Optional<QrtzPausedTriggerGrps> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_PAUSED_TRIGGER_GRPS(SCHED_NAME, TRIGGER_GROUP) VALUES (:SCHED_NAME, :TRIGGER_GROUP)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzPausedTriggerGrps entity);

    @SqlQuery("UPDATE QRTZ_PAUSED_TRIGGER_GRPS SET SCHED_NAME = :SCHED_NAME, TRIGGER_GROUP = :TRIGGER_GROUP WHERE id = :id")
    public int update(@BindBean() QrtzPausedTriggerGrps entity);

    @SqlQuery("DELETE FROM QRTZ_PAUSED_TRIGGER_GRPS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
