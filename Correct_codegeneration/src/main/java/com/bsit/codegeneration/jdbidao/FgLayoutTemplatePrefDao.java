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
import com.bsit.codegeneration.entity.FgLayoutTemplatePref;

public interface FgLayoutTemplatePrefDao {

    /**
     * Inserts a new FgLayoutTemplatePref and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LAYOUT_TEMPLATE_PREF (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, USER_CODE, PARTY_CODE, PAGE_ID, COMPONENT_ID, ENTITY_TYPE_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :userCode, :partyCode, :pageId, :componentId, :entityTypeCode)")
    public int insert(@BindBean FgLayoutTemplatePref fglayouttemplatepref);

    /**
     * Finds a FgLayoutTemplatePref by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_PREF WHERE ID = :id")
    @RegisterBeanMapper(FgLayoutTemplatePref.class)
    public Optional<FgLayoutTemplatePref> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_PREF")
    @RegisterBeanMapper(FgLayoutTemplatePref.class)
    public List<FgLayoutTemplatePref> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_PREF ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLayoutTemplatePref.class)
    public List<FgLayoutTemplatePref> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLayoutTemplatePref and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LAYOUT_TEMPLATE_PREF SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, USER_CODE = :userCode, PARTY_CODE = :partyCode, PAGE_ID = :pageId, COMPONENT_ID = :componentId, ENTITY_TYPE_CODE = :entityTypeCode WHERE ID = :id")
    public int update(@BindBean FgLayoutTemplatePref fglayouttemplatepref);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_TEMPLATE_PREF WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LAYOUT_TEMPLATE_PREF")
    public long countAll();

    /**
     * Bulk insert multiple FgLayoutTemplatePref entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LAYOUT_TEMPLATE_PREF (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, UPLOAD_REF_ID, ATTACHMENT_ID, PARENT_ID, PARENT_REF_ID, PARENT_VERSION_ID, IS_TEMPLATE, USER_CODE, PARTY_CODE, PAGE_ID, COMPONENT_ID, ENTITY_TYPE_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :uploadRefId, :attachmentId, :parentId, :parentRefId, :parentVersionId, :isTemplate, :userCode, :partyCode, :pageId, :componentId, :entityTypeCode)")
    public int[] bulkInsert(@BindBean List<FgLayoutTemplatePref> fglayouttemplateprefs);

    /**
     * Bulk update multiple FgLayoutTemplatePref entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LAYOUT_TEMPLATE_PREF SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, UPLOAD_REF_ID = :uploadRefId, ATTACHMENT_ID = :attachmentId, PARENT_ID = :parentId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, USER_CODE = :userCode, PARTY_CODE = :partyCode, PAGE_ID = :pageId, COMPONENT_ID = :componentId, ENTITY_TYPE_CODE = :entityTypeCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgLayoutTemplatePref> fglayouttemplateprefs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_TEMPLATE_PREF WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LAYOUT_TEMPLATE_PREF WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgLayoutTemplatePref records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_TEMPLATE_PREF WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgLayoutTemplatePref.class)
    public List<FgLayoutTemplatePref> findByIds(@BindList("ids") Collection<String> ids);
}
