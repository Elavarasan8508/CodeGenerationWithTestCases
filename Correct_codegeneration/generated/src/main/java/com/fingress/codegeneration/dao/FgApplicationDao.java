package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgApplication;
import com.bsit.codegeneration.mapper.FgApplicationMapper;
import java.util.*;

@RegisterRowMapper(FgApplicationMapper.class)
public interface FgApplicationDao {

    @SqlQuery("SELECT * FROM FG_APPLICATION")
    public List<FgApplication> findAll();

    @SqlQuery("SELECT * FROM FG_APPLICATION WHERE id = :id")
    public Optional<FgApplication> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_APPLICATION(ID, CODE, NAME, SUB_TITLE, ICON, DESCRIPTION, NAVIGATION_SCHEMA, IS_SECURED, ACTIVE_CODE, APPLICATION_TYPE, UUID, TAGS, APP_TITLE, DEVICE_CHANNEL, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID) VALUES (:ID, :CODE, :NAME, :SUB_TITLE, :ICON, :DESCRIPTION, :NAVIGATION_SCHEMA, :IS_SECURED, :ACTIVE_CODE, :APPLICATION_TYPE, :UUID, :TAGS, :APP_TITLE, :DEVICE_CHANNEL, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :MASTER_TEMPLATE, :MASTER_CONTENT_HASH, :IS_MASTER_VERSION, :VERSION_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgApplication entity);

    @SqlQuery("UPDATE FG_APPLICATION SET ID = :ID, CODE = :CODE, NAME = :NAME, SUB_TITLE = :SUB_TITLE, ICON = :ICON, DESCRIPTION = :DESCRIPTION, NAVIGATION_SCHEMA = :NAVIGATION_SCHEMA, IS_SECURED = :IS_SECURED, ACTIVE_CODE = :ACTIVE_CODE, APPLICATION_TYPE = :APPLICATION_TYPE, UUID = :UUID, TAGS = :TAGS, APP_TITLE = :APP_TITLE, DEVICE_CHANNEL = :DEVICE_CHANNEL, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, MASTER_TEMPLATE = :MASTER_TEMPLATE, MASTER_CONTENT_HASH = :MASTER_CONTENT_HASH, IS_MASTER_VERSION = :IS_MASTER_VERSION, VERSION_ID = :VERSION_ID WHERE id = :id")
    public int update(@BindBean() FgApplication entity);

    @SqlQuery("DELETE FROM FG_APPLICATION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
