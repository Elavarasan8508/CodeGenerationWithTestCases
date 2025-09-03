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
import com.bsit.codegeneration.entity.FgSdkProvisioningTemplate;

public interface FgSdkProvisioningTemplateDao {

    /**
     * Inserts a new FgSdkProvisioningTemplate and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SDK_PROVISIONING_TEMPLATE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TEMPLATE_NAME, TEMPLATE_CODE, TEMPLATE_DESCRIPTION, TEMPLATE_TYPE, RULE_TEMPLATE, MODEL_SUBTYPE_CODE, ACTION_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :templateName, :templateCode, :templateDescription, :templateType, :ruleTemplate, :modelSubtypeCode, :actionType)")
    public int insert(@BindBean FgSdkProvisioningTemplate fgsdkprovisioningtemplate);

    /**
     * Finds a FgSdkProvisioningTemplate by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SDK_PROVISIONING_TEMPLATE WHERE ID = :id")
    @RegisterBeanMapper(FgSdkProvisioningTemplate.class)
    public Optional<FgSdkProvisioningTemplate> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SDK_PROVISIONING_TEMPLATE")
    @RegisterBeanMapper(FgSdkProvisioningTemplate.class)
    public List<FgSdkProvisioningTemplate> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SDK_PROVISIONING_TEMPLATE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSdkProvisioningTemplate.class)
    public List<FgSdkProvisioningTemplate> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSdkProvisioningTemplate and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SDK_PROVISIONING_TEMPLATE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TEMPLATE_NAME = :templateName, TEMPLATE_CODE = :templateCode, TEMPLATE_DESCRIPTION = :templateDescription, TEMPLATE_TYPE = :templateType, RULE_TEMPLATE = :ruleTemplate, MODEL_SUBTYPE_CODE = :modelSubtypeCode, ACTION_TYPE = :actionType WHERE ID = :id")
    public int update(@BindBean FgSdkProvisioningTemplate fgsdkprovisioningtemplate);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_PROVISIONING_TEMPLATE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SDK_PROVISIONING_TEMPLATE")
    public long countAll();

    /**
     * Bulk insert multiple FgSdkProvisioningTemplate entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SDK_PROVISIONING_TEMPLATE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, TEMPLATE_NAME, TEMPLATE_CODE, TEMPLATE_DESCRIPTION, TEMPLATE_TYPE, RULE_TEMPLATE, MODEL_SUBTYPE_CODE, ACTION_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :templateName, :templateCode, :templateDescription, :templateType, :ruleTemplate, :modelSubtypeCode, :actionType)")
    public int[] bulkInsert(@BindBean List<FgSdkProvisioningTemplate> fgsdkprovisioningtemplates);

    /**
     * Bulk update multiple FgSdkProvisioningTemplate entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SDK_PROVISIONING_TEMPLATE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, TEMPLATE_NAME = :templateName, TEMPLATE_CODE = :templateCode, TEMPLATE_DESCRIPTION = :templateDescription, TEMPLATE_TYPE = :templateType, RULE_TEMPLATE = :ruleTemplate, MODEL_SUBTYPE_CODE = :modelSubtypeCode, ACTION_TYPE = :actionType WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgSdkProvisioningTemplate> fgsdkprovisioningtemplates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_PROVISIONING_TEMPLATE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SDK_PROVISIONING_TEMPLATE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgSdkProvisioningTemplate records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SDK_PROVISIONING_TEMPLATE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgSdkProvisioningTemplate.class)
    public List<FgSdkProvisioningTemplate> findByIds(@BindList("ids") Collection<String> ids);
}
