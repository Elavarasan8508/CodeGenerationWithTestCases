package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.QrtzLocks;
import com.bsit.codegeneration.mapper.QrtzLocksMapper;
import java.util.*;

@RegisterRowMapper(QrtzLocksMapper.class)
public interface QrtzLocksDao {

    @SqlQuery("SELECT * FROM QRTZ_LOCKS")
    public List<QrtzLocks> findAll();

    @SqlQuery("SELECT * FROM QRTZ_LOCKS WHERE id = :id")
    public Optional<QrtzLocks> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO QRTZ_LOCKS(SCHED_NAME, LOCK_NAME) VALUES (:SCHED_NAME, :LOCK_NAME)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() QrtzLocks entity);

    @SqlQuery("UPDATE QRTZ_LOCKS SET SCHED_NAME = :SCHED_NAME, LOCK_NAME = :LOCK_NAME WHERE id = :id")
    public int update(@BindBean() QrtzLocks entity);

    @SqlQuery("DELETE FROM QRTZ_LOCKS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
