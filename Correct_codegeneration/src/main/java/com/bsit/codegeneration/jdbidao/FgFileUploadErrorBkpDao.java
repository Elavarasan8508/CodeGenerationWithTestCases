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
import com.bsit.codegeneration.entity.FgFileUploadErrorBkp;

public interface FgFileUploadErrorBkpDao {

    /**
     * Inserts a new FgFileUploadErrorBkp and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_FILE_UPLOAD_ERROR_BKP (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :uploadId, :errorCode, :gravity, :errorValue, :lineNo, :columnNo)")
    public int insert(@BindBean FgFileUploadErrorBkp fgfileuploaderrorbkp);

    /**
     * Finds a FgFileUploadErrorBkp by its ID.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD_ERROR_BKP WHERE FG_FILE_UPLOAD_ERROR_BKP_id = :id")
    @RegisterBeanMapper(FgFileUploadErrorBkp.class)
    public Optional<FgFileUploadErrorBkp> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD_ERROR_BKP")
    @RegisterBeanMapper(FgFileUploadErrorBkp.class)
    public List<FgFileUploadErrorBkp> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD_ERROR_BKP ORDER BY FG_FILE_UPLOAD_ERROR_BKP_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgFileUploadErrorBkp.class)
    public List<FgFileUploadErrorBkp> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgFileUploadErrorBkp and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_FILE_UPLOAD_ERROR_BKP SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, UPLOAD_ID = :uploadId, ERROR_CODE = :errorCode, GRAVITY = :gravity, ERROR_VALUE = :errorValue, LINE_NO = :lineNo, COLUMN_NO = :columnNo WHERE FG_FILE_UPLOAD_ERROR_BKP_id = :fgFileUploadErrorBkpId")
    public int update(@BindBean FgFileUploadErrorBkp fgfileuploaderrorbkp);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FILE_UPLOAD_ERROR_BKP WHERE FG_FILE_UPLOAD_ERROR_BKP_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_FILE_UPLOAD_ERROR_BKP")
    public long countAll();

    /**
     * Bulk insert multiple FgFileUploadErrorBkp entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_FILE_UPLOAD_ERROR_BKP (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, UPLOAD_ID, ERROR_CODE, GRAVITY, ERROR_VALUE, LINE_NO, COLUMN_NO) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :uploadId, :errorCode, :gravity, :errorValue, :lineNo, :columnNo)")
    public int[] bulkInsert(@BindBean List<FgFileUploadErrorBkp> fgfileuploaderrorbkps);

    /**
     * Bulk update multiple FgFileUploadErrorBkp entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_FILE_UPLOAD_ERROR_BKP SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, UPLOAD_ID = :uploadId, ERROR_CODE = :errorCode, GRAVITY = :gravity, ERROR_VALUE = :errorValue, LINE_NO = :lineNo, COLUMN_NO = :columnNo WHERE FG_FILE_UPLOAD_ERROR_BKP_id = :fgFileUploadErrorBkpId")
    public int[] bulkUpdate(@BindBean List<FgFileUploadErrorBkp> fgfileuploaderrorbkps);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FILE_UPLOAD_ERROR_BKP WHERE FG_FILE_UPLOAD_ERROR_BKP_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_FILE_UPLOAD_ERROR_BKP WHERE FG_FILE_UPLOAD_ERROR_BKP_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgFileUploadErrorBkp records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_FILE_UPLOAD_ERROR_BKP WHERE FG_FILE_UPLOAD_ERROR_BKP_id IN (<ids>)")
    @RegisterBeanMapper(FgFileUploadErrorBkp.class)
    public List<FgFileUploadErrorBkp> findByIds(@BindList("ids") Collection<Integer> ids);
}
