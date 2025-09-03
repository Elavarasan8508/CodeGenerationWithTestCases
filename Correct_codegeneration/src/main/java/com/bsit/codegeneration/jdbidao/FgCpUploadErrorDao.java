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
import com.bsit.codegeneration.entity.FgCpUploadError;

public interface FgCpUploadErrorDao {

    /**
     * Inserts a new FgCpUploadError and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_CP_UPLOAD_ERROR (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :uploadId, :errorCode, :gravity, :errorValue, :lineNo, :columnNo, :parentRefId, :parentVersionId)")
    public int insert(@BindBean FgCpUploadError fgcpuploaderror);

    /**
     * Finds a FgCpUploadError by its ID.
     */
    @SqlQuery("SELECT * FROM FG_CP_UPLOAD_ERROR WHERE ID = :id")
    @RegisterBeanMapper(FgCpUploadError.class)
    public Optional<FgCpUploadError> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_CP_UPLOAD_ERROR")
    @RegisterBeanMapper(FgCpUploadError.class)
    public List<FgCpUploadError> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_CP_UPLOAD_ERROR ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgCpUploadError.class)
    public List<FgCpUploadError> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgCpUploadError and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_CP_UPLOAD_ERROR SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, UPLOAD_ID = :uploadId, ERROR_CODE = :errorCode, GRAVITY = :gravity, ERROR_VALUE = :errorValue, LINE_NO = :lineNo, COLUMN_NO = :columnNo, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE ID = :id")
    public int update(@BindBean FgCpUploadError fgcpuploaderror);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CP_UPLOAD_ERROR WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_CP_UPLOAD_ERROR")
    public long countAll();

    /**
     * Bulk insert multiple FgCpUploadError entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_CP_UPLOAD_ERROR (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :uploadId, :errorCode, :gravity, :errorValue, :lineNo, :columnNo, :parentRefId, :parentVersionId)")
    public int[] bulkInsert(@BindBean List<FgCpUploadError> fgcpuploaderrors);

    /**
     * Bulk update multiple FgCpUploadError entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_CP_UPLOAD_ERROR SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, UPLOAD_ID = :uploadId, ERROR_CODE = :errorCode, GRAVITY = :gravity, ERROR_VALUE = :errorValue, LINE_NO = :lineNo, COLUMN_NO = :columnNo, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgCpUploadError> fgcpuploaderrors);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CP_UPLOAD_ERROR WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_CP_UPLOAD_ERROR WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgCpUploadError records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_CP_UPLOAD_ERROR WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgCpUploadError.class)
    public List<FgCpUploadError> findByIds(@BindList("ids") Collection<String> ids);
}
