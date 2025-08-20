package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyGroup;
import com.bsit.codegeneration.mapper.FgPartyGroupMapper;
import java.util.*;

@RegisterRowMapper(FgPartyGroupMapper.class)
public interface FgPartyGroupDao {

    @SqlQuery("SELECT * FROM FG_PARTY_GROUP")
    public List<FgPartyGroup> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_GROUP WHERE id = :id")
    public Optional<FgPartyGroup> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_GROUP(ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, GROUP_ID, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PARENT_PARTY_CODE, REFERENCE_ID, SUB_TYPE_CODE, TYPE_CODE) VALUES (:ID, :PARTY_SUB_TYPE_CODE, :PARTY_CODE, :GROUP_ID, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :PARENT_PARTY_CODE, :REFERENCE_ID, :SUB_TYPE_CODE, :TYPE_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyGroup entity);

    @SqlQuery("UPDATE FG_PARTY_GROUP SET ID = :ID, PARTY_SUB_TYPE_CODE = :PARTY_SUB_TYPE_CODE, PARTY_CODE = :PARTY_CODE, GROUP_ID = :GROUP_ID, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, PARENT_PARTY_CODE = :PARENT_PARTY_CODE, REFERENCE_ID = :REFERENCE_ID, SUB_TYPE_CODE = :SUB_TYPE_CODE, TYPE_CODE = :TYPE_CODE WHERE id = :id")
    public int update(@BindBean() FgPartyGroup entity);

    @SqlQuery("DELETE FROM FG_PARTY_GROUP WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
