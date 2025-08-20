package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPermission;
import com.bsit.codegeneration.mapper.FgPermissionMapper;
import java.util.*;

@RegisterRowMapper(FgPermissionMapper.class)
public interface FgPermissionDao {

    @SqlQuery("SELECT * FROM FG_PERMISSION")
    public List<FgPermission> findAll();

    @SqlQuery("SELECT * FROM FG_PERMISSION WHERE id = :id")
    public Optional<FgPermission> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PERMISSION(ID, CLASS_CODE, FIELD_CODE, TYPE_CODE, CATEGORY_CODE, SUB_TYPE_CODE, OPERATION_CODE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :CLASS_CODE, :FIELD_CODE, :TYPE_CODE, :CATEGORY_CODE, :SUB_TYPE_CODE, :OPERATION_CODE, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPermission entity);

    @SqlQuery("UPDATE FG_PERMISSION SET ID = :ID, CLASS_CODE = :CLASS_CODE, FIELD_CODE = :FIELD_CODE, TYPE_CODE = :TYPE_CODE, CATEGORY_CODE = :CATEGORY_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, OPERATION_CODE = :OPERATION_CODE, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgPermission entity);

    @SqlQuery("DELETE FROM FG_PERMISSION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
