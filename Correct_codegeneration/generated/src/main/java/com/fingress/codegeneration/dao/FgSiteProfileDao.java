package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSiteProfile;
import com.bsit.codegeneration.mapper.FgSiteProfileMapper;
import java.util.*;

@RegisterRowMapper(FgSiteProfileMapper.class)
public interface FgSiteProfileDao {

    @SqlQuery("SELECT * FROM FG_SITE_PROFILE")
    public List<FgSiteProfile> findAll();

    @SqlQuery("SELECT * FROM FG_SITE_PROFILE WHERE id = :id")
    public Optional<FgSiteProfile> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SITE_PROFILE(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SITE_NAME, ORGANIZATION_CODE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :SITE_NAME, :ORGANIZATION_CODE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSiteProfile entity);

    @SqlQuery("UPDATE FG_SITE_PROFILE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, SITE_NAME = :SITE_NAME, ORGANIZATION_CODE = :ORGANIZATION_CODE WHERE id = :id")
    public int update(@BindBean() FgSiteProfile entity);

    @SqlQuery("DELETE FROM FG_SITE_PROFILE WHERE id = :id")
    public int delete(@Bind("id") String id);
}
