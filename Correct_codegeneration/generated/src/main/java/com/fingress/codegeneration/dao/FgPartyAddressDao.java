package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyAddress;
import com.bsit.codegeneration.mapper.FgPartyAddressMapper;
import java.util.*;

@RegisterRowMapper(FgPartyAddressMapper.class)
public interface FgPartyAddressDao {

    @SqlQuery("SELECT * FROM FG_PARTY_ADDRESS")
    public List<FgPartyAddress> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_ADDRESS WHERE id = :id")
    public Optional<FgPartyAddress> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_ADDRESS(ID, PURPOSE_CODE, ADDRESS_ID, PARTY_ID, PARTY_VERSION_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:ID, :PURPOSE_CODE, :ADDRESS_ID, :PARTY_ID, :PARTY_VERSION_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyAddress entity);

    @SqlQuery("UPDATE FG_PARTY_ADDRESS SET ID = :ID, PURPOSE_CODE = :PURPOSE_CODE, ADDRESS_ID = :ADDRESS_ID, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY WHERE id = :id")
    public int update(@BindBean() FgPartyAddress entity);

    @SqlQuery("DELETE FROM FG_PARTY_ADDRESS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
