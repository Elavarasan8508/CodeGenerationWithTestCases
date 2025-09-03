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
import com.bsit.codegeneration.entity.FgProvisioningRule;

public interface FgProvisioningRuleDao {

    /**
     * Inserts a new FgProvisioningRule and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PROVISIONING_RULE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TARGET_ORG_TYPE, TARGET_ORG_PARTY_CODE, RULE_TYPE, TARGET_ORG_ENTITY_CODE, MODEL_SUBTYPE_CODE, RULE_INHERITANCE_FLAG, INHERITANCE_TARGET_SUBTYPE, MOD_RULE_TEMPLATE, PROVISIONING_STATUS, PROVISIONING_DATE, PROVISIONING_ERROR, PROVISIOINING_REMARKS, ACTION_CODE, DEPLOYMENT_ID, VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :targetOrgType, :targetOrgPartyCode, :ruleType, :targetOrgEntityCode, :modelSubtypeCode, :ruleInheritanceFlag, :inheritanceTargetSubtype, :modRuleTemplate, :provisioningStatus, :provisioningDate, :provisioningError, :provisioiningRemarks, :actionCode, :deploymentId, :version)")
    public int insert(@BindBean FgProvisioningRule fgprovisioningrule);

    /**
     * Finds a FgProvisioningRule by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PROVISIONING_RULE WHERE ID = :id")
    @RegisterBeanMapper(FgProvisioningRule.class)
    public Optional<FgProvisioningRule> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PROVISIONING_RULE")
    @RegisterBeanMapper(FgProvisioningRule.class)
    public List<FgProvisioningRule> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PROVISIONING_RULE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProvisioningRule.class)
    public List<FgProvisioningRule> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProvisioningRule and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PROVISIONING_RULE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TARGET_ORG_TYPE = :targetOrgType, TARGET_ORG_PARTY_CODE = :targetOrgPartyCode, RULE_TYPE = :ruleType, TARGET_ORG_ENTITY_CODE = :targetOrgEntityCode, MODEL_SUBTYPE_CODE = :modelSubtypeCode, RULE_INHERITANCE_FLAG = :ruleInheritanceFlag, INHERITANCE_TARGET_SUBTYPE = :inheritanceTargetSubtype, MOD_RULE_TEMPLATE = :modRuleTemplate, PROVISIONING_STATUS = :provisioningStatus, PROVISIONING_DATE = :provisioningDate, PROVISIONING_ERROR = :provisioningError, PROVISIOINING_REMARKS = :provisioiningRemarks, ACTION_CODE = :actionCode, DEPLOYMENT_ID = :deploymentId, VERSION = :version WHERE ID = :id")
    public int update(@BindBean FgProvisioningRule fgprovisioningrule);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PROVISIONING_RULE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PROVISIONING_RULE")
    public long countAll();

    /**
     * Bulk insert multiple FgProvisioningRule entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PROVISIONING_RULE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TARGET_ORG_TYPE, TARGET_ORG_PARTY_CODE, RULE_TYPE, TARGET_ORG_ENTITY_CODE, MODEL_SUBTYPE_CODE, RULE_INHERITANCE_FLAG, INHERITANCE_TARGET_SUBTYPE, MOD_RULE_TEMPLATE, PROVISIONING_STATUS, PROVISIONING_DATE, PROVISIONING_ERROR, PROVISIOINING_REMARKS, ACTION_CODE, DEPLOYMENT_ID, VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :targetOrgType, :targetOrgPartyCode, :ruleType, :targetOrgEntityCode, :modelSubtypeCode, :ruleInheritanceFlag, :inheritanceTargetSubtype, :modRuleTemplate, :provisioningStatus, :provisioningDate, :provisioningError, :provisioiningRemarks, :actionCode, :deploymentId, :version)")
    public int[] bulkInsert(@BindBean List<FgProvisioningRule> fgprovisioningrules);

    /**
     * Bulk update multiple FgProvisioningRule entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PROVISIONING_RULE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TARGET_ORG_TYPE = :targetOrgType, TARGET_ORG_PARTY_CODE = :targetOrgPartyCode, RULE_TYPE = :ruleType, TARGET_ORG_ENTITY_CODE = :targetOrgEntityCode, MODEL_SUBTYPE_CODE = :modelSubtypeCode, RULE_INHERITANCE_FLAG = :ruleInheritanceFlag, INHERITANCE_TARGET_SUBTYPE = :inheritanceTargetSubtype, MOD_RULE_TEMPLATE = :modRuleTemplate, PROVISIONING_STATUS = :provisioningStatus, PROVISIONING_DATE = :provisioningDate, PROVISIONING_ERROR = :provisioningError, PROVISIOINING_REMARKS = :provisioiningRemarks, ACTION_CODE = :actionCode, DEPLOYMENT_ID = :deploymentId, VERSION = :version WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgProvisioningRule> fgprovisioningrules);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PROVISIONING_RULE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PROVISIONING_RULE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgProvisioningRule records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PROVISIONING_RULE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgProvisioningRule.class)
    public List<FgProvisioningRule> findByIds(@BindList("ids") Collection<String> ids);
}
