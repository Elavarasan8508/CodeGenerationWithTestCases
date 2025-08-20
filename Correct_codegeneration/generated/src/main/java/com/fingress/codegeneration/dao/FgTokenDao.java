package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgToken;
import com.bsit.codegeneration.mapper.FgTokenMapper;
import java.util.*;

@RegisterRowMapper(FgTokenMapper.class)
public interface FgTokenDao {

    @SqlQuery("SELECT * FROM FG_TOKEN")
    public List<FgToken> findAll();

    @SqlQuery("SELECT * FROM FG_TOKEN WHERE id = :id")
    public Optional<FgToken> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TOKEN(ID, DOMAIN_CODE, USER_NAME, LOGIN_ID, TOKEN_NAME, STATUS, REQ_SYSTEM, ISSUED_ON, ACCESSED_ON, VAL_DURATION, REQ_TIME, EXPIRES_ON, CREATED_DATE, CREATED_BY, LAST_UPDATED_BY, LAST_AUTHORISED_BY, CREATED_ON, LAST_UPDATED_ON, LAST_AUTHORISED_ON, TOKEN_VALUE, CHANNEL, CHANNEL_TYPE, EXTERNAL_TOKEN) VALUES (:ID, :DOMAIN_CODE, :USER_NAME, :LOGIN_ID, :TOKEN_NAME, :STATUS, :REQ_SYSTEM, :ISSUED_ON, :ACCESSED_ON, :VAL_DURATION, :REQ_TIME, :EXPIRES_ON, :CREATED_DATE, :CREATED_BY, :LAST_UPDATED_BY, :LAST_AUTHORISED_BY, :CREATED_ON, :LAST_UPDATED_ON, :LAST_AUTHORISED_ON, :TOKEN_VALUE, :CHANNEL, :CHANNEL_TYPE, :EXTERNAL_TOKEN)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgToken entity);

    @SqlQuery("UPDATE FG_TOKEN SET ID = :ID, DOMAIN_CODE = :DOMAIN_CODE, USER_NAME = :USER_NAME, LOGIN_ID = :LOGIN_ID, TOKEN_NAME = :TOKEN_NAME, STATUS = :STATUS, REQ_SYSTEM = :REQ_SYSTEM, ISSUED_ON = :ISSUED_ON, ACCESSED_ON = :ACCESSED_ON, VAL_DURATION = :VAL_DURATION, REQ_TIME = :REQ_TIME, EXPIRES_ON = :EXPIRES_ON, CREATED_DATE = :CREATED_DATE, CREATED_BY = :CREATED_BY, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, CREATED_ON = :CREATED_ON, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, TOKEN_VALUE = :TOKEN_VALUE, CHANNEL = :CHANNEL, CHANNEL_TYPE = :CHANNEL_TYPE, EXTERNAL_TOKEN = :EXTERNAL_TOKEN WHERE id = :id")
    public int update(@BindBean() FgToken entity);

    @SqlQuery("DELETE FROM FG_TOKEN WHERE id = :id")
    public int delete(@Bind("id") String id);
}
