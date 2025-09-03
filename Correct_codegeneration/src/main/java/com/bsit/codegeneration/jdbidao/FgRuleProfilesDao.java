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
import com.bsit.codegeneration.entity.FgRuleProfiles;

public interface FgRuleProfilesDao {

    /**
     * Inserts a new FgRuleProfiles and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_RULE_PROFILES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, NAME, RULE_SET_REF_ID, RULE_SET_NAME, RULE_NAME, CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :name, :ruleSetRefId, :ruleSetName, :ruleName, :code)")
    public int insert(@BindBean FgRuleProfiles fgruleprofiles);

    /**
     * Finds a FgRuleProfiles by its ID.
     */
    @SqlQuery("SELECT * FROM FG_RULE_PROFILES WHERE ID = :id")
    @RegisterBeanMapper(FgRuleProfiles.class)
    public Optional<FgRuleProfiles> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_RULE_PROFILES")
    @RegisterBeanMapper(FgRuleProfiles.class)
    public List<FgRuleProfiles> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_RULE_PROFILES ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgRuleProfiles.class)
    public List<FgRuleProfiles> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgRuleProfiles and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_RULE_PROFILES SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, NAME = :name, RULE_SET_REF_ID = :ruleSetRefId, RULE_SET_NAME = :ruleSetName, RULE_NAME = :ruleName, CODE = :code WHERE ID = :id")
    public int update(@BindBean FgRuleProfiles fgruleprofiles);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_RULE_PROFILES WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_RULE_PROFILES")
    public long countAll();

    /**
     * Bulk insert multiple FgRuleProfiles entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_RULE_PROFILES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, NAME, RULE_SET_REF_ID, RULE_SET_NAME, RULE_NAME, CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :name, :ruleSetRefId, :ruleSetName, :ruleName, :code)")
    public int[] bulkInsert(@BindBean List<FgRuleProfiles> fgruleprofiless);

    /**
     * Bulk update multiple FgRuleProfiles entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_RULE_PROFILES SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, NAME = :name, RULE_SET_REF_ID = :ruleSetRefId, RULE_SET_NAME = :ruleSetName, RULE_NAME = :ruleName, CODE = :code WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgRuleProfiles> fgruleprofiless);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_RULE_PROFILES WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_RULE_PROFILES WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgRuleProfiles records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_RULE_PROFILES WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgRuleProfiles.class)
    public List<FgRuleProfiles> findByIds(@BindList("ids") Collection<String> ids);
}
