package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgAppVersion;
import com.bsit.codegeneration.mapper.FgAppVersionMapper;
import java.util.*;

@RegisterRowMapper(FgAppVersionMapper.class)
public interface FgAppVersionDao {

    @SqlQuery("SELECT * FROM FG_APP_VERSION")
    public List<FgAppVersion> findAll();

    @SqlQuery("SELECT * FROM FG_APP_VERSION WHERE id = :id")
    public Optional<FgAppVersion> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_APP_VERSION(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, TYPE, CATEGORY_CODE, CATEGORY_KEY, CATEGORY_VERSION, ENVIRONMENT, APPLICANT_PARTY) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :TYPE, :CATEGORY_CODE, :CATEGORY_KEY, :CATEGORY_VERSION, :ENVIRONMENT, :APPLICANT_PARTY)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgAppVersion entity);

    @SqlQuery("UPDATE FG_APP_VERSION SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, TYPE = :TYPE, CATEGORY_CODE = :CATEGORY_CODE, CATEGORY_KEY = :CATEGORY_KEY, CATEGORY_VERSION = :CATEGORY_VERSION, ENVIRONMENT = :ENVIRONMENT, APPLICANT_PARTY = :APPLICANT_PARTY WHERE id = :id")
    public int update(@BindBean() FgAppVersion entity);

    @SqlQuery("DELETE FROM FG_APP_VERSION WHERE id = :id")
    public int delete(@Bind("id") String id);
}
