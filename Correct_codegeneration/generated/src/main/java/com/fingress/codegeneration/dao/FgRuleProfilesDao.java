package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgRuleProfiles;
import com.bsit.codegeneration.mapper.FgRuleProfilesMapper;
import java.util.*;

@RegisterRowMapper(FgRuleProfilesMapper.class)
public interface FgRuleProfilesDao {

    @SqlQuery("SELECT * FROM FG_RULE_PROFILES")
    public List<FgRuleProfiles> findAll();

    @SqlQuery("SELECT * FROM FG_RULE_PROFILES WHERE id = :id")
    public Optional<FgRuleProfiles> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_RULE_PROFILES(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, NAME, RULE_SET_REF_ID, RULE_SET_NAME, RULE_NAME, CODE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :NAME, :RULE_SET_REF_ID, :RULE_SET_NAME, :RULE_NAME, :CODE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgRuleProfiles entity);

    @SqlQuery("UPDATE FG_RULE_PROFILES SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, NAME = :NAME, RULE_SET_REF_ID = :RULE_SET_REF_ID, RULE_SET_NAME = :RULE_SET_NAME, RULE_NAME = :RULE_NAME, CODE = :CODE WHERE id = :id")
    public int update(@BindBean() FgRuleProfiles entity);

    @SqlQuery("DELETE FROM FG_RULE_PROFILES WHERE id = :id")
    public int delete(@Bind("id") String id);
}
