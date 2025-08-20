package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgBusinessCodeTypeBkp;
import com.bsit.codegeneration.mapper.FgBusinessCodeTypeBkpMapper;
import java.util.*;

@RegisterRowMapper(FgBusinessCodeTypeBkpMapper.class)
public interface FgBusinessCodeTypeBkpDao {

    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_TYPE_BKP")
    public List<FgBusinessCodeTypeBkp> findAll();

    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_TYPE_BKP WHERE id = :id")
    public Optional<FgBusinessCodeTypeBkp> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_BUSINESS_CODE_TYPE_BKP(ID, PARTY_ID, PARTY_VERSION_ID, CODE_TYPE, NAME, DESCRIPTION, ACTIVE_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TAGS) VALUES (:ID, :PARTY_ID, :PARTY_VERSION_ID, :CODE_TYPE, :NAME, :DESCRIPTION, :ACTIVE_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TAGS)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgBusinessCodeTypeBkp entity);

    @SqlQuery("UPDATE FG_BUSINESS_CODE_TYPE_BKP SET ID = :ID, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, CODE_TYPE = :CODE_TYPE, NAME = :NAME, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TAGS = :TAGS WHERE id = :id")
    public int update(@BindBean() FgBusinessCodeTypeBkp entity);

    @SqlQuery("DELETE FROM FG_BUSINESS_CODE_TYPE_BKP WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
