package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPreferencesMaster;
import com.bsit.codegeneration.mapper.FgPreferencesMasterMapper;
import java.util.*;

@RegisterRowMapper(FgPreferencesMasterMapper.class)
public interface FgPreferencesMasterDao {

    @SqlQuery("SELECT * FROM FG_PREFERENCES_MASTER")
    public List<FgPreferencesMaster> findAll();

    @SqlQuery("SELECT * FROM FG_PREFERENCES_MASTER WHERE id = :id")
    public Optional<FgPreferencesMaster> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PREFERENCES_MASTER(ID, CATEGORY_CODE, TYPE_CODE, CODE, NAME, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:ID, :CATEGORY_CODE, :TYPE_CODE, :CODE, :NAME, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPreferencesMaster entity);

    @SqlQuery("UPDATE FG_PREFERENCES_MASTER SET ID = :ID, CATEGORY_CODE = :CATEGORY_CODE, TYPE_CODE = :TYPE_CODE, CODE = :CODE, NAME = :NAME, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON WHERE id = :id")
    public int update(@BindBean() FgPreferencesMaster entity);

    @SqlQuery("DELETE FROM FG_PREFERENCES_MASTER WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
