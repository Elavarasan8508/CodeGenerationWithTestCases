package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgGroupRole;
import com.bsit.codegeneration.mapper.FgGroupRoleMapper;
import java.util.*;

@RegisterRowMapper(FgGroupRoleMapper.class)
public interface FgGroupRoleDao {

    @SqlQuery("SELECT * FROM FG_GROUP_ROLE")
    public List<FgGroupRole> findAll();

    @SqlQuery("SELECT * FROM FG_GROUP_ROLE WHERE id = :id")
    public Optional<FgGroupRole> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_GROUP_ROLE(ID, GROUP_ID, GROUP_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :GROUP_ID, :GROUP_VERSION_ID, :ROLE_ID, :ROLE_VERSION_ID, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgGroupRole entity);

    @SqlQuery("UPDATE FG_GROUP_ROLE SET ID = :ID, GROUP_ID = :GROUP_ID, GROUP_VERSION_ID = :GROUP_VERSION_ID, ROLE_ID = :ROLE_ID, ROLE_VERSION_ID = :ROLE_VERSION_ID, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgGroupRole entity);

    @SqlQuery("DELETE FROM FG_GROUP_ROLE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
