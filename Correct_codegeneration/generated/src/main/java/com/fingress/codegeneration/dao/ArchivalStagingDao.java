package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.ArchivalStaging;
import com.bsit.codegeneration.mapper.ArchivalStagingMapper;
import java.util.*;

@RegisterRowMapper(ArchivalStagingMapper.class)
public interface ArchivalStagingDao {

    @SqlQuery("SELECT * FROM ARCHIVAL_STAGING")
    public List<ArchivalStaging> findAll();

    @SqlQuery("SELECT * FROM ARCHIVAL_STAGING WHERE id = :id")
    public Optional<ArchivalStaging> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO ARCHIVAL_STAGING(ARCHIVE_ROWID, TABLE_NAME, PURGE_STATUS) VALUES (:ARCHIVE_ROWID, :TABLE_NAME, :PURGE_STATUS)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() ArchivalStaging entity);

    @SqlQuery("UPDATE ARCHIVAL_STAGING SET ARCHIVE_ROWID = :ARCHIVE_ROWID, TABLE_NAME = :TABLE_NAME, PURGE_STATUS = :PURGE_STATUS WHERE id = :id")
    public int update(@BindBean() ArchivalStaging entity);

    @SqlQuery("DELETE FROM ARCHIVAL_STAGING WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
