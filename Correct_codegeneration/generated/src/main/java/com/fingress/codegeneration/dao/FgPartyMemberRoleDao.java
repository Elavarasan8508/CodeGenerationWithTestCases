package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyMemberRole;
import com.bsit.codegeneration.mapper.FgPartyMemberRoleMapper;
import java.util.*;

@RegisterRowMapper(FgPartyMemberRoleMapper.class)
public interface FgPartyMemberRoleDao {

    @SqlQuery("SELECT * FROM FG_PARTY_MEMBER_ROLE")
    public List<FgPartyMemberRole> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_MEMBER_ROLE WHERE id = :id")
    public Optional<FgPartyMemberRole> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_MEMBER_ROLE(ID, PARTY_TYPE_CODE, PARTY_CODE, PARTY_REF_ID, PARTY_VERSION_ID, ROLE_CODE, EFFECTIVE_FROM, EFFECTIVE_TO, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE) VALUES (:ID, :PARTY_TYPE_CODE, :PARTY_CODE, :PARTY_REF_ID, :PARTY_VERSION_ID, :ROLE_CODE, :EFFECTIVE_FROM, :EFFECTIVE_TO, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :SYSTEM_SOURCE_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyMemberRole entity);

    @SqlQuery("UPDATE FG_PARTY_MEMBER_ROLE SET ID = :ID, PARTY_TYPE_CODE = :PARTY_TYPE_CODE, PARTY_CODE = :PARTY_CODE, PARTY_REF_ID = :PARTY_REF_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, ROLE_CODE = :ROLE_CODE, EFFECTIVE_FROM = :EFFECTIVE_FROM, EFFECTIVE_TO = :EFFECTIVE_TO, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE = :SYSTEM_SOURCE_CODE WHERE id = :id")
    public int update(@BindBean() FgPartyMemberRole entity);

    @SqlQuery("DELETE FROM FG_PARTY_MEMBER_ROLE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
