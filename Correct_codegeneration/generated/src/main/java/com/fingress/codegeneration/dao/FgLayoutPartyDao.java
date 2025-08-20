package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgLayoutParty;
import com.bsit.codegeneration.mapper.FgLayoutPartyMapper;
import java.util.*;

@RegisterRowMapper(FgLayoutPartyMapper.class)
public interface FgLayoutPartyDao {

    @SqlQuery("SELECT * FROM FG_LAYOUT_PARTY")
    public List<FgLayoutParty> findAll();

    @SqlQuery("SELECT * FROM FG_LAYOUT_PARTY WHERE id = :id")
    public Optional<FgLayoutParty> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_LAYOUT_PARTY(ID, PARTY_ID, PARTY_VERSION_ID, LAYOUT_ID, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, LAYOUT_VERSION_ID) VALUES (:ID, :PARTY_ID, :PARTY_VERSION_ID, :LAYOUT_ID, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :LAYOUT_VERSION_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgLayoutParty entity);

    @SqlQuery("UPDATE FG_LAYOUT_PARTY SET ID = :ID, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, LAYOUT_ID = :LAYOUT_ID, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, LAYOUT_VERSION_ID = :LAYOUT_VERSION_ID WHERE id = :id")
    public int update(@BindBean() FgLayoutParty entity);

    @SqlQuery("DELETE FROM FG_LAYOUT_PARTY WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
