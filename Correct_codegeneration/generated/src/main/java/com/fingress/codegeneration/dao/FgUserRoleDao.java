package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgUserRole;
import com.bsit.codegeneration.mapper.FgUserRoleMapper;
import java.util.*;

@RegisterRowMapper(FgUserRoleMapper.class)
public interface FgUserRoleDao {

    @SqlQuery("SELECT * FROM FG_USER_ROLE")
    public List<FgUserRole> findAll();

    @SqlQuery("SELECT * FROM FG_USER_ROLE WHERE id = :id")
    public Optional<FgUserRole> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_USER_ROLE(ID, ROLE_ID, ROLE_VERSION_ID, USER_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :ROLE_ID, :ROLE_VERSION_ID, :USER_ID, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgUserRole entity);

    @SqlQuery("UPDATE FG_USER_ROLE SET ID = :ID, ROLE_ID = :ROLE_ID, ROLE_VERSION_ID = :ROLE_VERSION_ID, USER_ID = :USER_ID, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgUserRole entity);

    @SqlQuery("DELETE FROM FG_USER_ROLE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
