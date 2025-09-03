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
import com.bsit.codegeneration.entity.FgRuleExecutionResults;

public interface FgRuleExecutionResultsDao {

    /**
     * Inserts a new FgRuleExecutionResults and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_RULE_EXECUTION_RESULTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARENT_REF_ID, STATUS, GUIDANCE, SEVERITY, MESSAGE, OBJECT_REFERENCE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :parentRefId, :status, :guidance, :severity, :message, :objectReference)")
    public int insert(@BindBean FgRuleExecutionResults fgruleexecutionresults);

    /**
     * Finds a FgRuleExecutionResults by its ID.
     */
    @SqlQuery("SELECT * FROM FG_RULE_EXECUTION_RESULTS WHERE ID = :id")
    @RegisterBeanMapper(FgRuleExecutionResults.class)
    public Optional<FgRuleExecutionResults> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_RULE_EXECUTION_RESULTS")
    @RegisterBeanMapper(FgRuleExecutionResults.class)
    public List<FgRuleExecutionResults> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_RULE_EXECUTION_RESULTS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgRuleExecutionResults.class)
    public List<FgRuleExecutionResults> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgRuleExecutionResults and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_RULE_EXECUTION_RESULTS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, PARENT_REF_ID = :parentRefId, STATUS = :status, GUIDANCE = :guidance, SEVERITY = :severity, MESSAGE = :message, OBJECT_REFERENCE = :objectReference WHERE ID = :id")
    public int update(@BindBean FgRuleExecutionResults fgruleexecutionresults);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_RULE_EXECUTION_RESULTS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_RULE_EXECUTION_RESULTS")
    public long countAll();

    /**
     * Bulk insert multiple FgRuleExecutionResults entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_RULE_EXECUTION_RESULTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARENT_REF_ID, STATUS, GUIDANCE, SEVERITY, MESSAGE, OBJECT_REFERENCE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :parentRefId, :status, :guidance, :severity, :message, :objectReference)")
    public int[] bulkInsert(@BindBean List<FgRuleExecutionResults> fgruleexecutionresultss);

    /**
     * Bulk update multiple FgRuleExecutionResults entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_RULE_EXECUTION_RESULTS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, PARENT_REF_ID = :parentRefId, STATUS = :status, GUIDANCE = :guidance, SEVERITY = :severity, MESSAGE = :message, OBJECT_REFERENCE = :objectReference WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgRuleExecutionResults> fgruleexecutionresultss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_RULE_EXECUTION_RESULTS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_RULE_EXECUTION_RESULTS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgRuleExecutionResults records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_RULE_EXECUTION_RESULTS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgRuleExecutionResults.class)
    public List<FgRuleExecutionResults> findByIds(@BindList("ids") Collection<String> ids);
}
