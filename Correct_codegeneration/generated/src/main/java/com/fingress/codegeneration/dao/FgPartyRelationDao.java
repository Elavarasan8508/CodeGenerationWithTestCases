package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyRelation;
import com.bsit.codegeneration.mapper.FgPartyRelationMapper;
import java.util.*;

@RegisterRowMapper(FgPartyRelationMapper.class)
public interface FgPartyRelationDao {

    @SqlQuery("SELECT * FROM FG_PARTY_RELATION")
    public List<FgPartyRelation> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_RELATION WHERE id = :id")
    public Optional<FgPartyRelation> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_RELATION(ID, PARTY_FROM_ROLE_CODE, PARTY_TO_ROLE_CODE, FROM_PARTY_ID, FROM_PARTY_VERSION_ID, TO_PARTY_ID, TO_PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, FROM_PARTY_USER_CODE, FROM_PARTY_USER_ID, FROM_PARTY_USER_VERSION_ID) VALUES (:ID, :PARTY_FROM_ROLE_CODE, :PARTY_TO_ROLE_CODE, :FROM_PARTY_ID, :FROM_PARTY_VERSION_ID, :TO_PARTY_ID, :TO_PARTY_VERSION_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :FROM_PARTY_USER_CODE, :FROM_PARTY_USER_ID, :FROM_PARTY_USER_VERSION_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyRelation entity);

    @SqlQuery("UPDATE FG_PARTY_RELATION SET ID = :ID, PARTY_FROM_ROLE_CODE = :PARTY_FROM_ROLE_CODE, PARTY_TO_ROLE_CODE = :PARTY_TO_ROLE_CODE, FROM_PARTY_ID = :FROM_PARTY_ID, FROM_PARTY_VERSION_ID = :FROM_PARTY_VERSION_ID, TO_PARTY_ID = :TO_PARTY_ID, TO_PARTY_VERSION_ID = :TO_PARTY_VERSION_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, FROM_PARTY_USER_CODE = :FROM_PARTY_USER_CODE, FROM_PARTY_USER_ID = :FROM_PARTY_USER_ID, FROM_PARTY_USER_VERSION_ID = :FROM_PARTY_USER_VERSION_ID WHERE id = :id")
    public int update(@BindBean() FgPartyRelation entity);

    @SqlQuery("DELETE FROM FG_PARTY_RELATION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
