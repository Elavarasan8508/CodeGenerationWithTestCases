package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzSimpropTriggers;
import com.bsit.codegeneration.mapper.QrtzSimpropTriggersMapper;
import java.util.*;

@RegisterRowMapper(QrtzSimpropTriggersMapper.class)
public interface QrtzSimpropTriggersDao {

    @SqlQuery("SELECT * FROM QRTZ_SIMPROP_TRIGGERS")
    public List<QrtzSimpropTriggers> findAll();

    @SqlQuery("SELECT * FROM QRTZ_SIMPROP_TRIGGERS WHERE id = :id")
    public Optional<QrtzSimpropTriggers> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_SIMPROP_TRIGGERS(SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, STR_PROP_1, STR_PROP_2, STR_PROP_3, INT_PROP_1, INT_PROP_2, LONG_PROP_1, LONG_PROP_2, DEC_PROP_1, DEC_PROP_2, BOOL_PROP_1, BOOL_PROP_2, TIME_ZONE_ID) VALUES (:SCHED_NAME, :TRIGGER_NAME, :TRIGGER_GROUP, :STR_PROP_1, :STR_PROP_2, :STR_PROP_3, :INT_PROP_1, :INT_PROP_2, :LONG_PROP_1, :LONG_PROP_2, :DEC_PROP_1, :DEC_PROP_2, :BOOL_PROP_1, :BOOL_PROP_2, :TIME_ZONE_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzSimpropTriggers entity);

    @SqlQuery("UPDATE QRTZ_SIMPROP_TRIGGERS SET SCHED_NAME = :SCHED_NAME, TRIGGER_NAME = :TRIGGER_NAME, TRIGGER_GROUP = :TRIGGER_GROUP, STR_PROP_1 = :STR_PROP_1, STR_PROP_2 = :STR_PROP_2, STR_PROP_3 = :STR_PROP_3, INT_PROP_1 = :INT_PROP_1, INT_PROP_2 = :INT_PROP_2, LONG_PROP_1 = :LONG_PROP_1, LONG_PROP_2 = :LONG_PROP_2, DEC_PROP_1 = :DEC_PROP_1, DEC_PROP_2 = :DEC_PROP_2, BOOL_PROP_1 = :BOOL_PROP_1, BOOL_PROP_2 = :BOOL_PROP_2, TIME_ZONE_ID = :TIME_ZONE_ID WHERE id = :id")
    public int update(@BindBean() QrtzSimpropTriggers entity);

    @SqlQuery("DELETE FROM QRTZ_SIMPROP_TRIGGERS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
