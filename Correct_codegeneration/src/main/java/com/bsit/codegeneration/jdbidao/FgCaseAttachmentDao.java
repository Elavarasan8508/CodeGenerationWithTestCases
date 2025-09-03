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
import com.bsit.codegeneration.entity.FgCaseAttachment;

public interface FgCaseAttachmentDao {

    /**
     * Inserts a new FgCaseAttachment and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_CASE_ATTACHMENT (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, PROCESS_ID, UPLOAD_REF_ID, FG_FILE_TITLE, FG_DOC_PURPOSE, FG_FILENAME, FG_FILETYPE, FG_FILESIZE) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :versionId, :isMasterVersion, :processId, :uploadRefId, :fgFileTitle, :fgDocPurpose, :fgFilename, :fgFiletype, :fgFilesize)")
    public int insert(@BindBean FgCaseAttachment fgcaseattachment);

    /**
     * Finds a FgCaseAttachment by its ID.
     */
    @SqlQuery("SELECT * FROM FG_CASE_ATTACHMENT WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgCaseAttachment.class)
    public Optional<FgCaseAttachment> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_CASE_ATTACHMENT")
    @RegisterBeanMapper(FgCaseAttachment.class)
    public List<FgCaseAttachment> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_CASE_ATTACHMENT ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgCaseAttachment.class)
    public List<FgCaseAttachment> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgCaseAttachment and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_CASE_ATTACHMENT SET REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IS_MASTER_VERSION = :isMasterVersion, PROCESS_ID = :processId, UPLOAD_REF_ID = :uploadRefId, FG_FILE_TITLE = :fgFileTitle, FG_DOC_PURPOSE = :fgDocPurpose, FG_FILENAME = :fgFilename, FG_FILETYPE = :fgFiletype, FG_FILESIZE = :fgFilesize WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgCaseAttachment fgcaseattachment);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CASE_ATTACHMENT WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_CASE_ATTACHMENT")
    public long countAll();

    /**
     * Bulk insert multiple FgCaseAttachment entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_CASE_ATTACHMENT (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, PROCESS_ID, UPLOAD_REF_ID, FG_FILE_TITLE, FG_DOC_PURPOSE, FG_FILENAME, FG_FILETYPE, FG_FILESIZE) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :versionId, :isMasterVersion, :processId, :uploadRefId, :fgFileTitle, :fgDocPurpose, :fgFilename, :fgFiletype, :fgFilesize)")
    public int[] bulkInsert(@BindBean List<FgCaseAttachment> fgcaseattachments);

    /**
     * Bulk update multiple FgCaseAttachment entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_CASE_ATTACHMENT SET REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IS_MASTER_VERSION = :isMasterVersion, PROCESS_ID = :processId, UPLOAD_REF_ID = :uploadRefId, FG_FILE_TITLE = :fgFileTitle, FG_DOC_PURPOSE = :fgDocPurpose, FG_FILENAME = :fgFilename, FG_FILETYPE = :fgFiletype, FG_FILESIZE = :fgFilesize WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgCaseAttachment> fgcaseattachments);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CASE_ATTACHMENT WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_CASE_ATTACHMENT WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgCaseAttachment records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_CASE_ATTACHMENT WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgCaseAttachment.class)
    public List<FgCaseAttachment> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
