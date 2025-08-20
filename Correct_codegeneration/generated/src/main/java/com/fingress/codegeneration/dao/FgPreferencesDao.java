package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPreferences;
import com.bsit.codegeneration.mapper.FgPreferencesMapper;
import java.util.*;

@RegisterRowMapper(FgPreferencesMapper.class)
public interface FgPreferencesDao {

    @SqlQuery("SELECT * FROM FG_PREFERENCES")
    public List<FgPreferences> findAll();

    @SqlQuery("SELECT * FROM FG_PREFERENCES WHERE id = :id")
    public Optional<FgPreferences> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PREFERENCES(ID, VERSION_ID, TYPE_CODE, SUB_TYPE_CODE, PREF_CATEGORY_CODE, PREF_TYPE_CODE, PREF_CODE, ORG_PARTY_CODE, ORG_PARTY_SUB_TYPE_CODE, USER_PARTY_CODE, USER_PARTY_SUB_TYPE_CODE, NAME, DESCRIPTION, TEMPLATE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:ID, :VERSION_ID, :TYPE_CODE, :SUB_TYPE_CODE, :PREF_CATEGORY_CODE, :PREF_TYPE_CODE, :PREF_CODE, :ORG_PARTY_CODE, :ORG_PARTY_SUB_TYPE_CODE, :USER_PARTY_CODE, :USER_PARTY_SUB_TYPE_CODE, :NAME, :DESCRIPTION, :TEMPLATE, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPreferences entity);

    @SqlQuery("UPDATE FG_PREFERENCES SET ID = :ID, VERSION_ID = :VERSION_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, PREF_CATEGORY_CODE = :PREF_CATEGORY_CODE, PREF_TYPE_CODE = :PREF_TYPE_CODE, PREF_CODE = :PREF_CODE, ORG_PARTY_CODE = :ORG_PARTY_CODE, ORG_PARTY_SUB_TYPE_CODE = :ORG_PARTY_SUB_TYPE_CODE, USER_PARTY_CODE = :USER_PARTY_CODE, USER_PARTY_SUB_TYPE_CODE = :USER_PARTY_SUB_TYPE_CODE, NAME = :NAME, DESCRIPTION = :DESCRIPTION, TEMPLATE = :TEMPLATE, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON WHERE id = :id")
    public int update(@BindBean() FgPreferences entity);

    @SqlQuery("DELETE FROM FG_PREFERENCES WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
