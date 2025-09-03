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
import com.bsit.codegeneration.entity.ScfFileLines;

public interface ScfFileLinesDao {

    /**
     * Inserts a new ScfFileLines and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SCF_FILE_LINES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_MASTER_REF_NO, LINE_NO, LINE_CONTENT, LINE_CONTENT_HASH_VALUE, LINE_RECORD_TYPE, LINE_STATUS, LINE_STATUS_REMARKS, LINE_HASH_VAL_STATUS, LINE_HASH_VAL_REMARKS, FILE_EVENT_REF_NO) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :anchorCrn, :fileMasterRefNo, :lineNo, :lineContent, :lineContentHashValue, :lineRecordType, :lineStatus, :lineStatusRemarks, :lineHashValStatus, :lineHashValRemarks, :fileEventRefNo)")
    public int insert(@BindBean ScfFileLines scffilelines);

    /**
     * Finds a ScfFileLines by its ID.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_LINES WHERE SCF_FILE_LINES_id = :id")
    @RegisterBeanMapper(ScfFileLines.class)
    public Optional<ScfFileLines> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_LINES")
    @RegisterBeanMapper(ScfFileLines.class)
    public List<ScfFileLines> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_LINES ORDER BY SCF_FILE_LINES_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(ScfFileLines.class)
    public List<ScfFileLines> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a ScfFileLines and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SCF_FILE_LINES SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ANCHOR_CRN = :anchorCrn, FILE_MASTER_REF_NO = :fileMasterRefNo, LINE_NO = :lineNo, LINE_CONTENT = :lineContent, LINE_CONTENT_HASH_VALUE = :lineContentHashValue, LINE_RECORD_TYPE = :lineRecordType, LINE_STATUS = :lineStatus, LINE_STATUS_REMARKS = :lineStatusRemarks, LINE_HASH_VAL_STATUS = :lineHashValStatus, LINE_HASH_VAL_REMARKS = :lineHashValRemarks, FILE_EVENT_REF_NO = :fileEventRefNo WHERE SCF_FILE_LINES_id = :scfFileLinesId")
    public int update(@BindBean ScfFileLines scffilelines);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SCF_FILE_LINES WHERE SCF_FILE_LINES_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SCF_FILE_LINES")
    public long countAll();

    /**
     * Bulk insert multiple ScfFileLines entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SCF_FILE_LINES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_MASTER_REF_NO, LINE_NO, LINE_CONTENT, LINE_CONTENT_HASH_VALUE, LINE_RECORD_TYPE, LINE_STATUS, LINE_STATUS_REMARKS, LINE_HASH_VAL_STATUS, LINE_HASH_VAL_REMARKS, FILE_EVENT_REF_NO) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :anchorCrn, :fileMasterRefNo, :lineNo, :lineContent, :lineContentHashValue, :lineRecordType, :lineStatus, :lineStatusRemarks, :lineHashValStatus, :lineHashValRemarks, :fileEventRefNo)")
    public int[] bulkInsert(@BindBean List<ScfFileLines> scffileliness);

    /**
     * Bulk update multiple ScfFileLines entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SCF_FILE_LINES SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ANCHOR_CRN = :anchorCrn, FILE_MASTER_REF_NO = :fileMasterRefNo, LINE_NO = :lineNo, LINE_CONTENT = :lineContent, LINE_CONTENT_HASH_VALUE = :lineContentHashValue, LINE_RECORD_TYPE = :lineRecordType, LINE_STATUS = :lineStatus, LINE_STATUS_REMARKS = :lineStatusRemarks, LINE_HASH_VAL_STATUS = :lineHashValStatus, LINE_HASH_VAL_REMARKS = :lineHashValRemarks, FILE_EVENT_REF_NO = :fileEventRefNo WHERE SCF_FILE_LINES_id = :scfFileLinesId")
    public int[] bulkUpdate(@BindBean List<ScfFileLines> scffileliness);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SCF_FILE_LINES WHERE SCF_FILE_LINES_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SCF_FILE_LINES WHERE SCF_FILE_LINES_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple ScfFileLines records by their IDs.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_LINES WHERE SCF_FILE_LINES_id IN (<ids>)")
    @RegisterBeanMapper(ScfFileLines.class)
    public List<ScfFileLines> findByIds(@BindList("ids") Collection<Integer> ids);
}
