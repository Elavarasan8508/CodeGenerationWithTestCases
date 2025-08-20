package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgRole;
import com.bsit.codegeneration.mapper.FgRoleMapper;
import java.util.*;

@RegisterRowMapper(FgRoleMapper.class)
public interface FgRoleDao {

    @SqlQuery("SELECT * FROM FG_ROLE")
    public List<FgRole> findAll();

    @SqlQuery("SELECT * FROM FG_ROLE WHERE id = :id")
    public Optional<FgRole> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ROLE(ID, VERSION_ID, IS_MASTER_VERSION, CODE, NAME, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TYPE_CODE, SUB_TYPE_CODE, TYPE) VALUES (:ID, :VERSION_ID, :IS_MASTER_VERSION, :CODE, :NAME, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TYPE_CODE, :SUB_TYPE_CODE, :TYPE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgRole entity);

    @SqlQuery("UPDATE FG_ROLE SET ID = :ID, VERSION_ID = :VERSION_ID, IS_MASTER_VERSION = :IS_MASTER_VERSION, CODE = :CODE, NAME = :NAME, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, TYPE = :TYPE WHERE id = :id")
    public int update(@BindBean() FgRole entity);

    @SqlQuery("DELETE FROM FG_ROLE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
