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
import com.bsit.codegeneration.entity.FgSdkReportTemplate;

public interface FgSdkReportTemplateDao {

    /**
     * Inserts a new FgSdkReportTemplate and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SDK_REPORT_TEMPLATE (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PARTY_CODE, REPORT_TYPE, STATUS, ENTITY_SUB_TYPE_CODE, REPORT_ENGINE, FILE_TEMPLATE, NAME) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :partyCode, :reportType, :status, :entitySubTypeCode, :reportEngine, :fileTemplate, :name)")
    public int insert(@BindBean FgSdkReportTemplate fgsdkreporttemplate);

    /**
     * Finds a FgSdkReportTemplate by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SDK_REPORT_TEMPLATE WHERE FG_SDK_REPORT_TEMPLATE_id = :id")
    @RegisterBeanMapper(FgSdkReportTemplate.class)
    public Optional<FgSdkReportTemplate> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SDK_REPORT_TEMPLATE")
    @RegisterBeanMapper(FgSdkReportTemplate.class)
    public List<FgSdkReportTemplate> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SDK_REPORT_TEMPLATE ORDER BY FG_SDK_REPORT_TEMPLATE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSdkReportTemplate.class)
    public List<FgSdkReportTemplate> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSdkReportTemplate and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SDK_REPORT_TEMPLATE SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PARTY_CODE = :partyCode, REPORT_TYPE = :reportType, STATUS = :status, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, REPORT_ENGINE = :reportEngine, FILE_TEMPLATE = :fileTemplate, NAME = :name WHERE FG_SDK_REPORT_TEMPLATE_id = :fgSdkReportTemplateId")
    public int update(@BindBean FgSdkReportTemplate fgsdkreporttemplate);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_REPORT_TEMPLATE WHERE FG_SDK_REPORT_TEMPLATE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SDK_REPORT_TEMPLATE")
    public long countAll();

    /**
     * Bulk insert multiple FgSdkReportTemplate entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SDK_REPORT_TEMPLATE (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PARTY_CODE, REPORT_TYPE, STATUS, ENTITY_SUB_TYPE_CODE, REPORT_ENGINE, FILE_TEMPLATE, NAME) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :partyCode, :reportType, :status, :entitySubTypeCode, :reportEngine, :fileTemplate, :name)")
    public int[] bulkInsert(@BindBean List<FgSdkReportTemplate> fgsdkreporttemplates);

    /**
     * Bulk update multiple FgSdkReportTemplate entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SDK_REPORT_TEMPLATE SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PARTY_CODE = :partyCode, REPORT_TYPE = :reportType, STATUS = :status, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, REPORT_ENGINE = :reportEngine, FILE_TEMPLATE = :fileTemplate, NAME = :name WHERE FG_SDK_REPORT_TEMPLATE_id = :fgSdkReportTemplateId")
    public int[] bulkUpdate(@BindBean List<FgSdkReportTemplate> fgsdkreporttemplates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_REPORT_TEMPLATE WHERE FG_SDK_REPORT_TEMPLATE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SDK_REPORT_TEMPLATE WHERE FG_SDK_REPORT_TEMPLATE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgSdkReportTemplate records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SDK_REPORT_TEMPLATE WHERE FG_SDK_REPORT_TEMPLATE_id IN (<ids>)")
    @RegisterBeanMapper(FgSdkReportTemplate.class)
    public List<FgSdkReportTemplate> findByIds(@BindList("ids") Collection<Integer> ids);
}
