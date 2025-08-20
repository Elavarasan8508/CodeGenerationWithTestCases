package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgDmsTag;
import com.bsit.codegeneration.mapper.FgDmsTagMapper;
import java.util.*;

@RegisterRowMapper(FgDmsTagMapper.class)
public interface FgDmsTagDao {

    @SqlQuery("SELECT * FROM FG_DMS_TAG")
    public List<FgDmsTag> findAll();

    @SqlQuery("SELECT * FROM FG_DMS_TAG WHERE id = :id")
    public Optional<FgDmsTag> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_DMS_TAG(ID, TAG_NAME, DMS_CONTENT_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :TAG_NAME, :DMS_CONTENT_ID, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgDmsTag entity);

    @SqlQuery("UPDATE FG_DMS_TAG SET ID = :ID, TAG_NAME = :TAG_NAME, DMS_CONTENT_ID = :DMS_CONTENT_ID, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgDmsTag entity);

    @SqlQuery("DELETE FROM FG_DMS_TAG WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
