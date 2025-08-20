package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgRuleExecutionResults;
import com.bsit.codegeneration.mapper.FgRuleExecutionResultsMapper;
import java.util.*;

@RegisterRowMapper(FgRuleExecutionResultsMapper.class)
public interface FgRuleExecutionResultsDao {

    @SqlQuery("SELECT * FROM FG_RULE_EXECUTION_RESULTS")
    public List<FgRuleExecutionResults> findAll();

    @SqlQuery("SELECT * FROM FG_RULE_EXECUTION_RESULTS WHERE id = :id")
    public Optional<FgRuleExecutionResults> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_RULE_EXECUTION_RESULTS(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARENT_REF_ID, STATUS, GUIDANCE, SEVERITY, MESSAGE, OBJECT_REFERENCE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :PARENT_REF_ID, :STATUS, :GUIDANCE, :SEVERITY, :MESSAGE, :OBJECT_REFERENCE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgRuleExecutionResults entity);

    @SqlQuery("UPDATE FG_RULE_EXECUTION_RESULTS SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, PARENT_REF_ID = :PARENT_REF_ID, STATUS = :STATUS, GUIDANCE = :GUIDANCE, SEVERITY = :SEVERITY, MESSAGE = :MESSAGE, OBJECT_REFERENCE = :OBJECT_REFERENCE WHERE id = :id")
    public int update(@BindBean() FgRuleExecutionResults entity);

    @SqlQuery("DELETE FROM FG_RULE_EXECUTION_RESULTS WHERE id = :id")
    public int delete(@Bind("id") String id);
}
