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
import com.bsit.codegeneration.entity.FgFintechUpload;

public interface FgFintechUploadDao {

    /**
     * Inserts a new FgFintechUpload and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_FINTECH_UPLOAD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, CHANNELS, TRANSFER_STATUS, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, FILECONTENT, UPLOAD_REF_ID, FILE_NAME, DMS_EVENT_ID, REMARKS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantPartyCode, :issuingPartyCode, :isTemplate, :channels, :transferStatus, :layoutTemplateId, :layoutName, :filecontent, :uploadRefId, :fileName, :dmsEventId, :remarks)")
    public int insert(@BindBean FgFintechUpload fgfintechupload);

    /**
     * Finds a FgFintechUpload by its ID.
     */
    @SqlQuery("SELECT * FROM FG_FINTECH_UPLOAD WHERE ID = :id")
    @RegisterBeanMapper(FgFintechUpload.class)
    public Optional<FgFintechUpload> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_FINTECH_UPLOAD")
    @RegisterBeanMapper(FgFintechUpload.class)
    public List<FgFintechUpload> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_FINTECH_UPLOAD ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgFintechUpload.class)
    public List<FgFintechUpload> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgFintechUpload and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_FINTECH_UPLOAD SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, IS_TEMPLATE = :isTemplate, CHANNELS = :channels, TRANSFER_STATUS = :transferStatus, LAYOUT_TEMPLATE_ID = :layoutTemplateId, LAYOUT_NAME = :layoutName, FILECONTENT = :filecontent, UPLOAD_REF_ID = :uploadRefId, FILE_NAME = :fileName, DMS_EVENT_ID = :dmsEventId, REMARKS = :remarks WHERE ID = :id")
    public int update(@BindBean FgFintechUpload fgfintechupload);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FINTECH_UPLOAD WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_FINTECH_UPLOAD")
    public long countAll();

    /**
     * Bulk insert multiple FgFintechUpload entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_FINTECH_UPLOAD (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, CHANNELS, TRANSFER_STATUS, LAYOUT_TEMPLATE_ID, LAYOUT_NAME, FILECONTENT, UPLOAD_REF_ID, FILE_NAME, DMS_EVENT_ID, REMARKS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantPartyCode, :issuingPartyCode, :isTemplate, :channels, :transferStatus, :layoutTemplateId, :layoutName, :filecontent, :uploadRefId, :fileName, :dmsEventId, :remarks)")
    public int[] bulkInsert(@BindBean List<FgFintechUpload> fgfintechuploads);

    /**
     * Bulk update multiple FgFintechUpload entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_FINTECH_UPLOAD SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, IS_TEMPLATE = :isTemplate, CHANNELS = :channels, TRANSFER_STATUS = :transferStatus, LAYOUT_TEMPLATE_ID = :layoutTemplateId, LAYOUT_NAME = :layoutName, FILECONTENT = :filecontent, UPLOAD_REF_ID = :uploadRefId, FILE_NAME = :fileName, DMS_EVENT_ID = :dmsEventId, REMARKS = :remarks WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgFintechUpload> fgfintechuploads);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FINTECH_UPLOAD WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_FINTECH_UPLOAD WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgFintechUpload records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_FINTECH_UPLOAD WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgFintechUpload.class)
    public List<FgFintechUpload> findByIds(@BindList("ids") Collection<String> ids);
}
