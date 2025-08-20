package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPreferencesRelation;
import com.bsit.codegeneration.mapper.FgPreferencesRelationMapper;
import java.util.*;

@RegisterRowMapper(FgPreferencesRelationMapper.class)
public interface FgPreferencesRelationDao {

    @SqlQuery("SELECT * FROM FG_PREFERENCES_RELATION")
    public List<FgPreferencesRelation> findAll();

    @SqlQuery("SELECT * FROM FG_PREFERENCES_RELATION WHERE id = :id")
    public Optional<FgPreferencesRelation> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PREFERENCES_RELATION(ID, PREF_CATEGORY_CODE, PREF_TYPE_CODE, PREF_CODE, SCOPE_CODE, SCOPE_VALUE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:ID, :PREF_CATEGORY_CODE, :PREF_TYPE_CODE, :PREF_CODE, :SCOPE_CODE, :SCOPE_VALUE, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPreferencesRelation entity);

    @SqlQuery("UPDATE FG_PREFERENCES_RELATION SET ID = :ID, PREF_CATEGORY_CODE = :PREF_CATEGORY_CODE, PREF_TYPE_CODE = :PREF_TYPE_CODE, PREF_CODE = :PREF_CODE, SCOPE_CODE = :SCOPE_CODE, SCOPE_VALUE = :SCOPE_VALUE, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON WHERE id = :id")
    public int update(@BindBean() FgPreferencesRelation entity);

    @SqlQuery("DELETE FROM FG_PREFERENCES_RELATION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
