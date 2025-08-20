package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyIdentification;
import com.bsit.codegeneration.mapper.FgPartyIdentificationMapper;
import java.util.*;

@RegisterRowMapper(FgPartyIdentificationMapper.class)
public interface FgPartyIdentificationDao {

    @SqlQuery("SELECT * FROM FG_PARTY_IDENTIFICATION")
    public List<FgPartyIdentification> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_IDENTIFICATION WHERE id = :id")
    public Optional<FgPartyIdentification> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_IDENTIFICATION(ID, PARTY_ID, PARTY_VERSION_ID, PARTY_CODE, PARTY_SUB_TYPE_CODE, IDENTIFIER_TYPE_CODE, IDENTITY_NO, ISSUER_CODE, ISSUER_NAME, VALID_FROM, VALID_TO, COMMENTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYS_DEFINED, SYSTEM_SOURCE_CODE, IDENTIFIER_SUB_TYPE_CODE) VALUES (:ID, :PARTY_ID, :PARTY_VERSION_ID, :PARTY_CODE, :PARTY_SUB_TYPE_CODE, :IDENTIFIER_TYPE_CODE, :IDENTITY_NO, :ISSUER_CODE, :ISSUER_NAME, :VALID_FROM, :VALID_TO, :COMMENTS, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :SYS_DEFINED, :SYSTEM_SOURCE_CODE, :IDENTIFIER_SUB_TYPE_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyIdentification entity);

    @SqlQuery("UPDATE FG_PARTY_IDENTIFICATION SET ID = :ID, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, PARTY_CODE = :PARTY_CODE, PARTY_SUB_TYPE_CODE = :PARTY_SUB_TYPE_CODE, IDENTIFIER_TYPE_CODE = :IDENTIFIER_TYPE_CODE, IDENTITY_NO = :IDENTITY_NO, ISSUER_CODE = :ISSUER_CODE, ISSUER_NAME = :ISSUER_NAME, VALID_FROM = :VALID_FROM, VALID_TO = :VALID_TO, COMMENTS = :COMMENTS, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, SYS_DEFINED = :SYS_DEFINED, SYSTEM_SOURCE_CODE = :SYSTEM_SOURCE_CODE, IDENTIFIER_SUB_TYPE_CODE = :IDENTIFIER_SUB_TYPE_CODE WHERE id = :id")
    public int update(@BindBean() FgPartyIdentification entity);

    @SqlQuery("DELETE FROM FG_PARTY_IDENTIFICATION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
