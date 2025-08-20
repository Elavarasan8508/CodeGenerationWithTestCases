package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgRuleSets;
import com.bsit.codegeneration.mapper.FgRuleSetsMapper;
import java.util.*;

@RegisterRowMapper(FgRuleSetsMapper.class)
public interface FgRuleSetsDao {

    @SqlQuery("SELECT * FROM FG_RULE_SETS")
    public List<FgRuleSets> findAll();

    @SqlQuery("SELECT * FROM FG_RULE_SETS WHERE id = :id")
    public Optional<FgRuleSets> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_RULE_SETS(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, NAME, ATTACHMENT_ID, RULE_NAME, ACTION_TYPE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :NAME, :ATTACHMENT_ID, :RULE_NAME, :ACTION_TYPE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgRuleSets entity);

    @SqlQuery("UPDATE FG_RULE_SETS SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, NAME = :NAME, ATTACHMENT_ID = :ATTACHMENT_ID, RULE_NAME = :RULE_NAME, ACTION_TYPE = :ACTION_TYPE WHERE id = :id")
    public int update(@BindBean() FgRuleSets entity);

    @SqlQuery("DELETE FROM FG_RULE_SETS WHERE id = :id")
    public int delete(@Bind("id") String id);
}
