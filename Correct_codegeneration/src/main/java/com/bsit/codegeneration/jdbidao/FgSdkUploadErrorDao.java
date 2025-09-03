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
import com.bsit.codegeneration.entity.FgSdkUploadError;

public interface FgSdkUploadErrorDao {

    /**
     * Inserts a new FgSdkUploadError and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SDK_UPLOAD_ERROR (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ERROR_CODE, PROCESS, GRAVITY, LINE_NO, COLUMN_NO, ERROR_VALUE, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :errorCode, :process, :gravity, :lineNo, :columnNo, :errorValue, :parentRefId, :parentVersionId)")
    public int insert(@BindBean FgSdkUploadError fgsdkuploaderror);

    /**
     * Finds a FgSdkUploadError by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD_ERROR WHERE FG_SDK_UPLOAD_ERROR_id = :id")
    @RegisterBeanMapper(FgSdkUploadError.class)
    public Optional<FgSdkUploadError> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD_ERROR")
    @RegisterBeanMapper(FgSdkUploadError.class)
    public List<FgSdkUploadError> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD_ERROR ORDER BY FG_SDK_UPLOAD_ERROR_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSdkUploadError.class)
    public List<FgSdkUploadError> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSdkUploadError and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SDK_UPLOAD_ERROR SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ERROR_CODE = :errorCode, PROCESS = :process, GRAVITY = :gravity, LINE_NO = :lineNo, COLUMN_NO = :columnNo, ERROR_VALUE = :errorValue, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE FG_SDK_UPLOAD_ERROR_id = :fgSdkUploadErrorId")
    public int update(@BindBean FgSdkUploadError fgsdkuploaderror);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_UPLOAD_ERROR WHERE FG_SDK_UPLOAD_ERROR_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SDK_UPLOAD_ERROR")
    public long countAll();

    /**
     * Bulk insert multiple FgSdkUploadError entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SDK_UPLOAD_ERROR (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ERROR_CODE, PROCESS, GRAVITY, LINE_NO, COLUMN_NO, ERROR_VALUE, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :errorCode, :process, :gravity, :lineNo, :columnNo, :errorValue, :parentRefId, :parentVersionId)")
    public int[] bulkInsert(@BindBean List<FgSdkUploadError> fgsdkuploaderrors);

    /**
     * Bulk update multiple FgSdkUploadError entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SDK_UPLOAD_ERROR SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ERROR_CODE = :errorCode, PROCESS = :process, GRAVITY = :gravity, LINE_NO = :lineNo, COLUMN_NO = :columnNo, ERROR_VALUE = :errorValue, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE FG_SDK_UPLOAD_ERROR_id = :fgSdkUploadErrorId")
    public int[] bulkUpdate(@BindBean List<FgSdkUploadError> fgsdkuploaderrors);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_UPLOAD_ERROR WHERE FG_SDK_UPLOAD_ERROR_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SDK_UPLOAD_ERROR WHERE FG_SDK_UPLOAD_ERROR_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgSdkUploadError records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SDK_UPLOAD_ERROR WHERE FG_SDK_UPLOAD_ERROR_id IN (<ids>)")
    @RegisterBeanMapper(FgSdkUploadError.class)
    public List<FgSdkUploadError> findByIds(@BindList("ids") Collection<Integer> ids);
}
