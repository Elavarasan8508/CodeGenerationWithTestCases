package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSites;
import com.bsit.codegeneration.mapper.FgSitesMapper;
import java.util.*;

@RegisterRowMapper(FgSitesMapper.class)
public interface FgSitesDao {

    @SqlQuery("SELECT * FROM FG_SITES")
    public List<FgSites> findAll();

    @SqlQuery("SELECT * FROM FG_SITES WHERE id = :id")
    public Optional<FgSites> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SITES(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, CODE, DESCRIPTION, IDENTIFICATION, THEME, SITE_STATUS) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :NAME, :CODE, :DESCRIPTION, :IDENTIFICATION, :THEME, :SITE_STATUS)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSites entity);

    @SqlQuery("UPDATE FG_SITES SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, NAME = :NAME, CODE = :CODE, DESCRIPTION = :DESCRIPTION, IDENTIFICATION = :IDENTIFICATION, THEME = :THEME, SITE_STATUS = :SITE_STATUS WHERE id = :id")
    public int update(@BindBean() FgSites entity);

    @SqlQuery("DELETE FROM FG_SITES WHERE id = :id")
    public int delete(@Bind("id") String id);
}
