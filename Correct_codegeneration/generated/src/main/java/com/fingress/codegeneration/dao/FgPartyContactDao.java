package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyContact;
import com.bsit.codegeneration.mapper.FgPartyContactMapper;
import java.util.*;

@RegisterRowMapper(FgPartyContactMapper.class)
public interface FgPartyContactDao {

    @SqlQuery("SELECT * FROM FG_PARTY_CONTACT")
    public List<FgPartyContact> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_CONTACT WHERE id = :id")
    public Optional<FgPartyContact> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_CONTACT(ID, PARTY_ID, PURPOSE_CODE, REFERENCE, TYPE_CODE, PARTY_VERSION_ID, DESCRIPTION, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE, SYS_DEFINED) VALUES (:ID, :PARTY_ID, :PURPOSE_CODE, :REFERENCE, :TYPE_CODE, :PARTY_VERSION_ID, :DESCRIPTION, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :SYSTEM_SOURCE_CODE, :SYS_DEFINED)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyContact entity);

    @SqlQuery("UPDATE FG_PARTY_CONTACT SET ID = :ID, PARTY_ID = :PARTY_ID, PURPOSE_CODE = :PURPOSE_CODE, REFERENCE = :REFERENCE, TYPE_CODE = :TYPE_CODE, PARTY_VERSION_ID = :PARTY_VERSION_ID, DESCRIPTION = :DESCRIPTION, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE = :SYSTEM_SOURCE_CODE, SYS_DEFINED = :SYS_DEFINED WHERE id = :id")
    public int update(@BindBean() FgPartyContact entity);

    @SqlQuery("DELETE FROM FG_PARTY_CONTACT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
