package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPartyClassification;
import com.bsit.codegeneration.mapper.FgPartyClassificationMapper;
import java.util.*;

@RegisterRowMapper(FgPartyClassificationMapper.class)
public interface FgPartyClassificationDao {

    @SqlQuery("SELECT * FROM FG_PARTY_CLASSIFICATION")
    public List<FgPartyClassification> findAll();

    @SqlQuery("SELECT * FROM FG_PARTY_CLASSIFICATION WHERE id = :id")
    public Optional<FgPartyClassification> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_PARTY_CLASSIFICATION(ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, CLASS_TYPE_CODE, CLASS_SUB_TYPE_CODE, VALID_FROM, VALID_TO, COMMENTS, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, DEMOGRAPHIC_TYPE_CODE, DEMOGRAPHIC_SUB_TYPE_CODE, SYS_DEFINED, SYSTEM_SOURCE_CODE) VALUES (:ID, :PARTY_ID, :PARTY_VERSION_ID, :PARTY_SUB_TYPE_CODE, :PARTY_CODE, :CLASS_TYPE_CODE, :CLASS_SUB_TYPE_CODE, :VALID_FROM, :VALID_TO, :COMMENTS, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :DEMOGRAPHIC_TYPE_CODE, :DEMOGRAPHIC_SUB_TYPE_CODE, :SYS_DEFINED, :SYSTEM_SOURCE_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgPartyClassification entity);

    @SqlQuery("UPDATE FG_PARTY_CLASSIFICATION SET ID = :ID, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, PARTY_SUB_TYPE_CODE = :PARTY_SUB_TYPE_CODE, PARTY_CODE = :PARTY_CODE, CLASS_TYPE_CODE = :CLASS_TYPE_CODE, CLASS_SUB_TYPE_CODE = :CLASS_SUB_TYPE_CODE, VALID_FROM = :VALID_FROM, VALID_TO = :VALID_TO, COMMENTS = :COMMENTS, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, DEMOGRAPHIC_TYPE_CODE = :DEMOGRAPHIC_TYPE_CODE, DEMOGRAPHIC_SUB_TYPE_CODE = :DEMOGRAPHIC_SUB_TYPE_CODE, SYS_DEFINED = :SYS_DEFINED, SYSTEM_SOURCE_CODE = :SYSTEM_SOURCE_CODE WHERE id = :id")
    public int update(@BindBean() FgPartyClassification entity);

    @SqlQuery("DELETE FROM FG_PARTY_CLASSIFICATION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
