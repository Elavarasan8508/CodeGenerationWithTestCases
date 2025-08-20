package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyProfile;
import com.bsit.codegeneration.mapper.FgPartyProfileMapper;
import java.util.*;

@RegisterRowMapper(FgPartyProfileMapper.class)
public interface FgPartyProfileDao {

    @SqlQuery("SELECT * FROM FG_PARTY_PROFILE")
    public List<FgPartyProfile> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_PROFILE WHERE id = :id")
    public Optional<FgPartyProfile> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_PROFILE(ID, ORG_ID, ORG_VERSION_ID, ORG_CODE, PROFILE_TYPE_CODE, PROFILE_TEXT, TEMPLATE, USER_ID, USER_VERSION_ID, STATUS_CODE, AUTH_STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :ORG_ID, :ORG_VERSION_ID, :ORG_CODE, :PROFILE_TYPE_CODE, :PROFILE_TEXT, :TEMPLATE, :USER_ID, :USER_VERSION_ID, :STATUS_CODE, :AUTH_STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyProfile entity);

    @SqlQuery("UPDATE FG_PARTY_PROFILE SET ID = :ID, ORG_ID = :ORG_ID, ORG_VERSION_ID = :ORG_VERSION_ID, ORG_CODE = :ORG_CODE, PROFILE_TYPE_CODE = :PROFILE_TYPE_CODE, PROFILE_TEXT = :PROFILE_TEXT, TEMPLATE = :TEMPLATE, USER_ID = :USER_ID, USER_VERSION_ID = :USER_VERSION_ID, STATUS_CODE = :STATUS_CODE, AUTH_STATUS_CODE = :AUTH_STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgPartyProfile entity);

    @SqlQuery("DELETE FROM FG_PARTY_PROFILE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
