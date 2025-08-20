package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgUserGroup;
import com.bsit.codegeneration.mapper.FgUserGroupMapper;
import java.util.*;

@RegisterRowMapper(FgUserGroupMapper.class)
public interface FgUserGroupDao {

    @SqlQuery("SELECT * FROM FG_USER_GROUP")
    public List<FgUserGroup> findAll();

    @SqlQuery("SELECT * FROM FG_USER_GROUP WHERE id = :id")
    public Optional<FgUserGroup> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_USER_GROUP(ID, PARTY_CODE, USER_ID, GROUP_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :PARTY_CODE, :USER_ID, :GROUP_ID, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgUserGroup entity);

    @SqlQuery("UPDATE FG_USER_GROUP SET ID = :ID, PARTY_CODE = :PARTY_CODE, USER_ID = :USER_ID, GROUP_ID = :GROUP_ID, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgUserGroup entity);

    @SqlQuery("DELETE FROM FG_USER_GROUP WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
