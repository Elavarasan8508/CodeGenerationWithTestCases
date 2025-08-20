package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyEntityField;
import com.bsit.codegeneration.mapper.FgPartyEntityFieldMapper;
import java.util.*;

@RegisterRowMapper(FgPartyEntityFieldMapper.class)
public interface FgPartyEntityFieldDao {

    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY_FIELD")
    public List<FgPartyEntityField> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY_FIELD WHERE id = :id")
    public Optional<FgPartyEntityField> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_ENTITY_FIELD(ID, MODEL_CODE, PARTY_ID, PARTY_VERSION_ID, NAME, IS_DENY, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :MODEL_CODE, :PARTY_ID, :PARTY_VERSION_ID, :NAME, :IS_DENY, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyEntityField entity);

    @SqlQuery("UPDATE FG_PARTY_ENTITY_FIELD SET ID = :ID, MODEL_CODE = :MODEL_CODE, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, NAME = :NAME, IS_DENY = :IS_DENY, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgPartyEntityField entity);

    @SqlQuery("DELETE FROM FG_PARTY_ENTITY_FIELD WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
