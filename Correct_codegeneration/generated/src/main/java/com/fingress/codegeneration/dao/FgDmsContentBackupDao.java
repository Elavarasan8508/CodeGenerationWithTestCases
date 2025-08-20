package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDmsContentBackup;
import com.bsit.codegeneration.mapper.FgDmsContentBackupMapper;
import java.util.*;

@RegisterRowMapper(FgDmsContentBackupMapper.class)
public interface FgDmsContentBackupDao {

    @SqlQuery("SELECT * FROM FG_DMS_CONTENT_BACKUP")
    public List<FgDmsContentBackup> findAll();

    @SqlQuery("SELECT * FROM FG_DMS_CONTENT_BACKUP WHERE id = :id")
    public Optional<FgDmsContentBackup> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_DMS_CONTENT_BACKUP(ID, DMS_DOC_PATH, DMS_DOC_REFERENCE_ID, FILE_CONTENT, FILE_NAME, FILE_SIZE, FILE_TYPE, TITLE, DMS_EVENT_ID, DESCRIPTION, FILE_PURPOSE_CODE, DMS_REFERENCE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :DMS_DOC_PATH, :DMS_DOC_REFERENCE_ID, :FILE_CONTENT, :FILE_NAME, :FILE_SIZE, :FILE_TYPE, :TITLE, :DMS_EVENT_ID, :DESCRIPTION, :FILE_PURPOSE_CODE, :DMS_REFERENCE, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgDmsContentBackup entity);

    @SqlQuery("UPDATE FG_DMS_CONTENT_BACKUP SET ID = :ID, DMS_DOC_PATH = :DMS_DOC_PATH, DMS_DOC_REFERENCE_ID = :DMS_DOC_REFERENCE_ID, FILE_CONTENT = :FILE_CONTENT, FILE_NAME = :FILE_NAME, FILE_SIZE = :FILE_SIZE, FILE_TYPE = :FILE_TYPE, TITLE = :TITLE, DMS_EVENT_ID = :DMS_EVENT_ID, DESCRIPTION = :DESCRIPTION, FILE_PURPOSE_CODE = :FILE_PURPOSE_CODE, DMS_REFERENCE = :DMS_REFERENCE, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgDmsContentBackup entity);

    @SqlQuery("DELETE FROM FG_DMS_CONTENT_BACKUP WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
