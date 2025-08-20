package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDmsContent;
import com.bsit.codegeneration.mapper.FgDmsContentMapper;
import java.util.*;

@RegisterRowMapper(FgDmsContentMapper.class)
public interface FgDmsContentDao {

    @SqlQuery("SELECT * FROM FG_DMS_CONTENT")
    public List<FgDmsContent> findAll();

    @SqlQuery("SELECT * FROM FG_DMS_CONTENT WHERE id = :id")
    public Optional<FgDmsContent> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_DMS_CONTENT(ID, DMS_DOC_PATH, DMS_DOC_REFERENCE_ID, FILE_CONTENT, FILE_NAME, FILE_SIZE, FILE_TYPE, TITLE, DMS_EVENT_ID, DESCRIPTION, FILE_PURPOSE_CODE, DMS_REFERENCE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :DMS_DOC_PATH, :DMS_DOC_REFERENCE_ID, :FILE_CONTENT, :FILE_NAME, :FILE_SIZE, :FILE_TYPE, :TITLE, :DMS_EVENT_ID, :DESCRIPTION, :FILE_PURPOSE_CODE, :DMS_REFERENCE, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgDmsContent entity);

    @SqlQuery("UPDATE FG_DMS_CONTENT SET ID = :ID, DMS_DOC_PATH = :DMS_DOC_PATH, DMS_DOC_REFERENCE_ID = :DMS_DOC_REFERENCE_ID, FILE_CONTENT = :FILE_CONTENT, FILE_NAME = :FILE_NAME, FILE_SIZE = :FILE_SIZE, FILE_TYPE = :FILE_TYPE, TITLE = :TITLE, DMS_EVENT_ID = :DMS_EVENT_ID, DESCRIPTION = :DESCRIPTION, FILE_PURPOSE_CODE = :FILE_PURPOSE_CODE, DMS_REFERENCE = :DMS_REFERENCE, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgDmsContent entity);

    @SqlQuery("DELETE FROM FG_DMS_CONTENT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
