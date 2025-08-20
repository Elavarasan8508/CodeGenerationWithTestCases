package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgGroupPermission;
import com.bsit.codegeneration.mapper.FgGroupPermissionMapper;
import java.util.*;

@RegisterRowMapper(FgGroupPermissionMapper.class)
public interface FgGroupPermissionDao {

    @SqlQuery("SELECT * FROM FG_GROUP_PERMISSION")
    public List<FgGroupPermission> findAll();

    @SqlQuery("SELECT * FROM FG_GROUP_PERMISSION WHERE id = :id")
    public Optional<FgGroupPermission> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_GROUP_PERMISSION(ID, PERMISSION_ID, GROUP_ID, GROUP_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :PERMISSION_ID, :GROUP_ID, :GROUP_VERSION_ID, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_BY, :LAST_UPDATED_ON, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgGroupPermission entity);

    @SqlQuery("UPDATE FG_GROUP_PERMISSION SET ID = :ID, PERMISSION_ID = :PERMISSION_ID, GROUP_ID = :GROUP_ID, GROUP_VERSION_ID = :GROUP_VERSION_ID, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgGroupPermission entity);

    @SqlQuery("DELETE FROM FG_GROUP_PERMISSION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
