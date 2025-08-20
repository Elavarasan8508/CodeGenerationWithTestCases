package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyRole;
import com.bsit.codegeneration.mapper.FgPartyRoleMapper;
import java.util.*;

@RegisterRowMapper(FgPartyRoleMapper.class)
public interface FgPartyRoleDao {

    @SqlQuery("SELECT * FROM FG_PARTY_ROLE")
    public List<FgPartyRole> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_ROLE WHERE id = :id")
    public Optional<FgPartyRole> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_ROLE(ID, PARTY_ID, PARTY_VERSION_ID, ROLE_ID, ROLE_VERSION_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:ID, :PARTY_ID, :PARTY_VERSION_ID, :ROLE_ID, :ROLE_VERSION_ID, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyRole entity);

    @SqlQuery("UPDATE FG_PARTY_ROLE SET ID = :ID, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, ROLE_ID = :ROLE_ID, ROLE_VERSION_ID = :ROLE_VERSION_ID, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON WHERE id = :id")
    public int update(@BindBean() FgPartyRole entity);

    @SqlQuery("DELETE FROM FG_PARTY_ROLE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
