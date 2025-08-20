package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzBlobTriggers;
import com.bsit.codegeneration.mapper.QrtzBlobTriggersMapper;
import java.util.*;

@RegisterRowMapper(QrtzBlobTriggersMapper.class)
public interface QrtzBlobTriggersDao {

    @SqlQuery("SELECT * FROM QRTZ_BLOB_TRIGGERS")
    public List<QrtzBlobTriggers> findAll();

    @SqlQuery("SELECT * FROM QRTZ_BLOB_TRIGGERS WHERE id = :id")
    public Optional<QrtzBlobTriggers> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_BLOB_TRIGGERS(SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, BLOB_DATA) VALUES (:SCHED_NAME, :TRIGGER_NAME, :TRIGGER_GROUP, :BLOB_DATA)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzBlobTriggers entity);

    @SqlQuery("UPDATE QRTZ_BLOB_TRIGGERS SET SCHED_NAME = :SCHED_NAME, TRIGGER_NAME = :TRIGGER_NAME, TRIGGER_GROUP = :TRIGGER_GROUP, BLOB_DATA = :BLOB_DATA WHERE id = :id")
    public int update(@BindBean() QrtzBlobTriggers entity);

    @SqlQuery("DELETE FROM QRTZ_BLOB_TRIGGERS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
