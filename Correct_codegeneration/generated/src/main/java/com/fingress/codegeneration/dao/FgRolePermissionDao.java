package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgRolePermission;
import com.bsit.codegeneration.mapper.FgRolePermissionMapper;
import java.util.*;

@RegisterRowMapper(FgRolePermissionMapper.class)
public interface FgRolePermissionDao {

    @SqlQuery("SELECT * FROM FG_ROLE_PERMISSION")
    public List<FgRolePermission> findAll();

    @SqlQuery("SELECT * FROM FG_ROLE_PERMISSION WHERE id = :id")
    public Optional<FgRolePermission> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ROLE_PERMISSION(ID, PERMISSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :PERMISSION_ID, :ROLE_ID, :ROLE_VERSION_ID, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_BY, :LAST_UPDATED_ON, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgRolePermission entity);

    @SqlQuery("UPDATE FG_ROLE_PERMISSION SET ID = :ID, PERMISSION_ID = :PERMISSION_ID, ROLE_ID = :ROLE_ID, ROLE_VERSION_ID = :ROLE_VERSION_ID, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgRolePermission entity);

    @SqlQuery("DELETE FROM FG_ROLE_PERMISSION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
