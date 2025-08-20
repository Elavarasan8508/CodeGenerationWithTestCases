package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgModBiDashboardRepos;
import com.bsit.codegeneration.mapper.FgModBiDashboardReposMapper;
import java.util.*;

@RegisterRowMapper(FgModBiDashboardReposMapper.class)
public interface FgModBiDashboardReposDao {

    @SqlQuery("SELECT * FROM FG_MOD_BI_DASHBOARD_REPOS")
    public List<FgModBiDashboardRepos> findAll();

    @SqlQuery("SELECT * FROM FG_MOD_BI_DASHBOARD_REPOS WHERE id = :id")
    public Optional<FgModBiDashboardRepos> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MOD_BI_DASHBOARD_REPOS(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, VERSION_ID, BOARD_ID, BOARD_NAME, CATEGORY_NAME, PARTY_TYPE, PARTY_CODE, PARTY_USER_TYPE, PARTY_USER_CODE, IS_MASTER_VERSION, LAYOUT_JSON, COMPANY_ID, USER_ID, IS_DEFAULT) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON, :VERSION_ID, :BOARD_ID, :BOARD_NAME, :CATEGORY_NAME, :PARTY_TYPE, :PARTY_CODE, :PARTY_USER_TYPE, :PARTY_USER_CODE, :IS_MASTER_VERSION, :LAYOUT_JSON, :COMPANY_ID, :USER_ID, :IS_DEFAULT)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgModBiDashboardRepos entity);

    @SqlQuery("UPDATE FG_MOD_BI_DASHBOARD_REPOS SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, VERSION_ID = :VERSION_ID, BOARD_ID = :BOARD_ID, BOARD_NAME = :BOARD_NAME, CATEGORY_NAME = :CATEGORY_NAME, PARTY_TYPE = :PARTY_TYPE, PARTY_CODE = :PARTY_CODE, PARTY_USER_TYPE = :PARTY_USER_TYPE, PARTY_USER_CODE = :PARTY_USER_CODE, IS_MASTER_VERSION = :IS_MASTER_VERSION, LAYOUT_JSON = :LAYOUT_JSON, COMPANY_ID = :COMPANY_ID, USER_ID = :USER_ID, IS_DEFAULT = :IS_DEFAULT WHERE id = :id")
    public int update(@BindBean() FgModBiDashboardRepos entity);

    @SqlQuery("DELETE FROM FG_MOD_BI_DASHBOARD_REPOS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
