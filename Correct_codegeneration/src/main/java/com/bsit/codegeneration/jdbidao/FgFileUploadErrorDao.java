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
import com.bsit.codegeneration.entity.FgFileUploadError;

public interface FgFileUploadErrorDao {

    /**
     * Inserts a new FgFileUploadError and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_FILE_UPLOAD_ERROR (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO, PARENT_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :uploadId, :errorCode, :gravity, :errorValue, :lineNo, :columnNo, :parentRefId)")
    public int insert(@BindBean FgFileUploadError fgfileuploaderror);

    /**
     * Finds a FgFileUploadError by its ID.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD_ERROR WHERE ID = :id")
    @RegisterBeanMapper(FgFileUploadError.class)
    public Optional<FgFileUploadError> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD_ERROR")
    @RegisterBeanMapper(FgFileUploadError.class)
    public List<FgFileUploadError> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD_ERROR ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgFileUploadError.class)
    public List<FgFileUploadError> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgFileUploadError and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_FILE_UPLOAD_ERROR SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, UPLOAD_ID = :uploadId, ERROR_CODE = :errorCode, GRAVITY = :gravity, ERROR_VALUE = :errorValue, LINE_NO = :lineNo, COLUMN_NO = :columnNo, PARENT_REF_ID = :parentRefId WHERE ID = :id")
    public int update(@BindBean FgFileUploadError fgfileuploaderror);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FILE_UPLOAD_ERROR WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_FILE_UPLOAD_ERROR")
    public long countAll();

    /**
     * Bulk insert multiple FgFileUploadError entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_FILE_UPLOAD_ERROR (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO, PARENT_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :uploadId, :errorCode, :gravity, :errorValue, :lineNo, :columnNo, :parentRefId)")
    public int[] bulkInsert(@BindBean List<FgFileUploadError> fgfileuploaderrors);

    /**
     * Bulk update multiple FgFileUploadError entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_FILE_UPLOAD_ERROR SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, UPLOAD_ID = :uploadId, ERROR_CODE = :errorCode, GRAVITY = :gravity, ERROR_VALUE = :errorValue, LINE_NO = :lineNo, COLUMN_NO = :columnNo, PARENT_REF_ID = :parentRefId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgFileUploadError> fgfileuploaderrors);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FILE_UPLOAD_ERROR WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_FILE_UPLOAD_ERROR WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgFileUploadError records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD_ERROR WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgFileUploadError.class)
    public List<FgFileUploadError> findByIds(@BindList("ids") Collection<String> ids);
}
