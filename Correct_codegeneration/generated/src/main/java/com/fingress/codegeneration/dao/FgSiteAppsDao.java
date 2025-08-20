package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSiteApps;
import com.bsit.codegeneration.mapper.FgSiteAppsMapper;
import java.util.*;

@RegisterRowMapper(FgSiteAppsMapper.class)
public interface FgSiteAppsDao {

    @SqlQuery("SELECT * FROM FG_SITE_APPS")
    public List<FgSiteApps> findAll();

    @SqlQuery("SELECT * FROM FG_SITE_APPS WHERE id = :id")
    public Optional<FgSiteApps> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SITE_APPS(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, APPLICATION_ID, SITE_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :APPLICATION_ID, :SITE_ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSiteApps entity);

    @SqlQuery("UPDATE FG_SITE_APPS SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, APPLICATION_ID = :APPLICATION_ID, SITE_ID = :SITE_ID WHERE id = :id")
    public int update(@BindBean() FgSiteApps entity);

    @SqlQuery("DELETE FROM FG_SITE_APPS WHERE id = :id")
    public int delete(@Bind("id") String id);
}
