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
import com.bsit.codegeneration.entity.FgSdkReportSchema;

public interface FgSdkReportSchemaDao {

    /**
     * Inserts a new FgSdkReportSchema and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SDK_REPORT_SCHEMA (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROCESS_ID, MODEL_PROPERTIES, NAME, DESCRIPTION, TYPE, ENTITY_SUB_TYPE_CODE) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :processId, :modelProperties, :name, :description, :type, :entitySubTypeCode)")
    public int insert(@BindBean FgSdkReportSchema fgsdkreportschema);

    /**
     * Finds a FgSdkReportSchema by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SDK_REPORT_SCHEMA WHERE FG_SDK_REPORT_SCHEMA_id = :id")
    @RegisterBeanMapper(FgSdkReportSchema.class)
    public Optional<FgSdkReportSchema> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SDK_REPORT_SCHEMA")
    @RegisterBeanMapper(FgSdkReportSchema.class)
    public List<FgSdkReportSchema> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SDK_REPORT_SCHEMA ORDER BY FG_SDK_REPORT_SCHEMA_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSdkReportSchema.class)
    public List<FgSdkReportSchema> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSdkReportSchema and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SDK_REPORT_SCHEMA SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PROCESS_ID = :processId, MODEL_PROPERTIES = :modelProperties, NAME = :name, DESCRIPTION = :description, TYPE = :type, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode WHERE FG_SDK_REPORT_SCHEMA_id = :fgSdkReportSchemaId")
    public int update(@BindBean FgSdkReportSchema fgsdkreportschema);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_REPORT_SCHEMA WHERE FG_SDK_REPORT_SCHEMA_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SDK_REPORT_SCHEMA")
    public long countAll();

    /**
     * Bulk insert multiple FgSdkReportSchema entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SDK_REPORT_SCHEMA (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROCESS_ID, MODEL_PROPERTIES, NAME, DESCRIPTION, TYPE, ENTITY_SUB_TYPE_CODE) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :processId, :modelProperties, :name, :description, :type, :entitySubTypeCode)")
    public int[] bulkInsert(@BindBean List<FgSdkReportSchema> fgsdkreportschemas);

    /**
     * Bulk update multiple FgSdkReportSchema entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SDK_REPORT_SCHEMA SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PROCESS_ID = :processId, MODEL_PROPERTIES = :modelProperties, NAME = :name, DESCRIPTION = :description, TYPE = :type, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode WHERE FG_SDK_REPORT_SCHEMA_id = :fgSdkReportSchemaId")
    public int[] bulkUpdate(@BindBean List<FgSdkReportSchema> fgsdkreportschemas);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_REPORT_SCHEMA WHERE FG_SDK_REPORT_SCHEMA_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SDK_REPORT_SCHEMA WHERE FG_SDK_REPORT_SCHEMA_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgSdkReportSchema records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SDK_REPORT_SCHEMA WHERE FG_SDK_REPORT_SCHEMA_id IN (<ids>)")
    @RegisterBeanMapper(FgSdkReportSchema.class)
    public List<FgSdkReportSchema> findByIds(@BindList("ids") Collection<Integer> ids);
}
