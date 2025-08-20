package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgModCmsPtyRole;
import com.bsit.codegeneration.mapper.FgModCmsPtyRoleMapper;
import java.util.*;

@RegisterRowMapper(FgModCmsPtyRoleMapper.class)
public interface FgModCmsPtyRoleDao {

    @SqlQuery("SELECT * FROM FG_MOD_CMS_PTY_ROLE")
    public List<FgModCmsPtyRole> findAll();

    @SqlQuery("SELECT * FROM FG_MOD_CMS_PTY_ROLE WHERE id = :id")
    public Optional<FgModCmsPtyRole> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MOD_CMS_PTY_ROLE(ID, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, PARTY_REF_NO, PARTY_VERSION_ID, PARTY_ROLE, SPACE_REF_NO, SPACE_VERSION_ID, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:ID, :PARTY_TYPE_CODE, :PARTY_SUB_TYPE_CODE, :PARTY_REF_NO, :PARTY_VERSION_ID, :PARTY_ROLE, :SPACE_REF_NO, :SPACE_VERSION_ID, :CREATED_BY, :CREATED_ON, :LAST_UPDATED_BY, :LAST_UPDATED_ON, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgModCmsPtyRole entity);

    @SqlQuery("UPDATE FG_MOD_CMS_PTY_ROLE SET ID = :ID, PARTY_TYPE_CODE = :PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE = :PARTY_SUB_TYPE_CODE, PARTY_REF_NO = :PARTY_REF_NO, PARTY_VERSION_ID = :PARTY_VERSION_ID, PARTY_ROLE = :PARTY_ROLE, SPACE_REF_NO = :SPACE_REF_NO, SPACE_VERSION_ID = :SPACE_VERSION_ID, CREATED_BY = :CREATED_BY, CREATED_ON = :CREATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON WHERE id = :id")
    public int update(@BindBean() FgModCmsPtyRole entity);

    @SqlQuery("DELETE FROM FG_MOD_CMS_PTY_ROLE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
