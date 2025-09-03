package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.batch.SqlBatch;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindList;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import com.bsit.codegeneration.entity.FgProcessDecisionAudit;

public interface FgProcessDecisionAuditDao {

    /**
     * Inserts a new FgProcessDecisionAudit and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PROCESS_DECISION_AUDIT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, DECISION_DEF_ID, DECISION_OUTPUT_HASH, DECISION_OUTPUT_RULE, LAST_EVALUATION_TIME, PERF_PARTY_CODE, WF_PROCESS_DEF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :decisionDefId, :decisionOutputHash, :decisionOutputRule, :lastEvaluationTime, :perfPartyCode, :wfProcessDefId)")
    public int insert(@BindBean FgProcessDecisionAudit fgprocessdecisionaudit);

    /**
     * Finds a FgProcessDecisionAudit by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PROCESS_DECISION_AUDIT WHERE ID = :id")
    @RegisterBeanMapper(FgProcessDecisionAudit.class)
    public Optional<FgProcessDecisionAudit> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PROCESS_DECISION_AUDIT")
    @RegisterBeanMapper(FgProcessDecisionAudit.class)
    public List<FgProcessDecisionAudit> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PROCESS_DECISION_AUDIT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProcessDecisionAudit.class)
    public List<FgProcessDecisionAudit> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProcessDecisionAudit and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PROCESS_DECISION_AUDIT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, DECISION_DEF_ID = :decisionDefId, DECISION_OUTPUT_HASH = :decisionOutputHash, DECISION_OUTPUT_RULE = :decisionOutputRule, LAST_EVALUATION_TIME = :lastEvaluationTime, PERF_PARTY_CODE = :perfPartyCode, WF_PROCESS_DEF_ID = :wfProcessDefId WHERE ID = :id")
    public int update(@BindBean FgProcessDecisionAudit fgprocessdecisionaudit);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PROCESS_DECISION_AUDIT WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PROCESS_DECISION_AUDIT")
    public long countAll();

    /**
     * Bulk insert multiple FgProcessDecisionAudit entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PROCESS_DECISION_AUDIT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, DECISION_DEF_ID, DECISION_OUTPUT_HASH, DECISION_OUTPUT_RULE, LAST_EVALUATION_TIME, PERF_PARTY_CODE, WF_PROCESS_DEF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :decisionDefId, :decisionOutputHash, :decisionOutputRule, :lastEvaluationTime, :perfPartyCode, :wfProcessDefId)")
    public int[] bulkInsert(@BindBean List<FgProcessDecisionAudit> fgprocessdecisionaudits);

    /**
     * Bulk update multiple FgProcessDecisionAudit entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PROCESS_DECISION_AUDIT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, DECISION_DEF_ID = :decisionDefId, DECISION_OUTPUT_HASH = :decisionOutputHash, DECISION_OUTPUT_RULE = :decisionOutputRule, LAST_EVALUATION_TIME = :lastEvaluationTime, PERF_PARTY_CODE = :perfPartyCode, WF_PROCESS_DEF_ID = :wfProcessDefId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgProcessDecisionAudit> fgprocessdecisionaudits);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PROCESS_DECISION_AUDIT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PROCESS_DECISION_AUDIT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgProcessDecisionAudit records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PROCESS_DECISION_AUDIT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgProcessDecisionAudit.class)
    public List<FgProcessDecisionAudit> findByIds(@BindList("ids") Collection<String> ids);
}
