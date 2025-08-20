package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTokenBk;
import com.bsit.codegeneration.mapper.FgTokenBkMapper;
import java.util.*;

@RegisterRowMapper(FgTokenBkMapper.class)
public interface FgTokenBkDao {

    @SqlQuery("SELECT * FROM FG_TOKEN_BK")
    public List<FgTokenBk> findAll();

    @SqlQuery("SELECT * FROM FG_TOKEN_BK WHERE id = :id")
    public Optional<FgTokenBk> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TOKEN_BK(ID, DOMAIN_CODE, USER_NAME, LOGIN_ID, TOKEN_NAME, STATUS, REQ_SYSTEM, ISSUED_ON, ACCESSED_ON, VAL_DURATION, REQ_TIME, EXPIRES_ON, CREATED_DATE, CREATED_BY, LAST_UPDATED_BY, LAST_AUTHORISED_BY, CREATED_ON, LAST_UPDATED_ON, LAST_AUTHORISED_ON, TOKEN_VALUE, CHANNEL, CHANNEL_TYPE) VALUES (:ID, :DOMAIN_CODE, :USER_NAME, :LOGIN_ID, :TOKEN_NAME, :STATUS, :REQ_SYSTEM, :ISSUED_ON, :ACCESSED_ON, :VAL_DURATION, :REQ_TIME, :EXPIRES_ON, :CREATED_DATE, :CREATED_BY, :LAST_UPDATED_BY, :LAST_AUTHORISED_BY, :CREATED_ON, :LAST_UPDATED_ON, :LAST_AUTHORISED_ON, :TOKEN_VALUE, :CHANNEL, :CHANNEL_TYPE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTokenBk entity);

    @SqlQuery("UPDATE FG_TOKEN_BK SET ID = :ID, DOMAIN_CODE = :DOMAIN_CODE, USER_NAME = :USER_NAME, LOGIN_ID = :LOGIN_ID, TOKEN_NAME = :TOKEN_NAME, STATUS = :STATUS, REQ_SYSTEM = :REQ_SYSTEM, ISSUED_ON = :ISSUED_ON, ACCESSED_ON = :ACCESSED_ON, VAL_DURATION = :VAL_DURATION, REQ_TIME = :REQ_TIME, EXPIRES_ON = :EXPIRES_ON, CREATED_DATE = :CREATED_DATE, CREATED_BY = :CREATED_BY, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, CREATED_ON = :CREATED_ON, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, TOKEN_VALUE = :TOKEN_VALUE, CHANNEL = :CHANNEL, CHANNEL_TYPE = :CHANNEL_TYPE WHERE id = :id")
    public int update(@BindBean() FgTokenBk entity);

    @SqlQuery("DELETE FROM FG_TOKEN_BK WHERE id = :id")
    public int delete(@Bind("id") String id);
}
