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
import com.bsit.codegeneration.entity.ScfFileEvents;

public interface ScfFileEventsDao {

    /**
     * Inserts a new ScfFileEvents and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SCF_FILE_EVENTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, EVENT_TYPE, EVENT_CODE, EVENT_NAME, EVENT_SOURCE, EVENT_TARGET, ENTITY_NAME, RECORD_COUNT, FILE_ATTACH_REF_NO, EVENT_STATUS, EVENT_REMARKS, FILE_NAME, FILE_MASTER_REF_NO, EVENT_BATCH_ID, DISPLAY_SOURCE, DISPLAY_TARGET, RETRIGGER_COUNT, EVENT_FINPAY_ID, FINTECH_SOURCE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :anchorCrn, :eventType, :eventCode, :eventName, :eventSource, :eventTarget, :entityName, :recordCount, :fileAttachRefNo, :eventStatus, :eventRemarks, :fileName, :fileMasterRefNo, :eventBatchId, :displaySource, :displayTarget, :retriggerCount, :eventFinpayId, :fintechSource)")
    public int insert(@BindBean ScfFileEvents scffileevents);

    /**
     * Finds a ScfFileEvents by its ID.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_EVENTS WHERE ID = :id")
    @RegisterBeanMapper(ScfFileEvents.class)
    public Optional<ScfFileEvents> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_EVENTS")
    @RegisterBeanMapper(ScfFileEvents.class)
    public List<ScfFileEvents> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_EVENTS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(ScfFileEvents.class)
    public List<ScfFileEvents> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a ScfFileEvents and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SCF_FILE_EVENTS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ANCHOR_CRN = :anchorCrn, EVENT_TYPE = :eventType, EVENT_CODE = :eventCode, EVENT_NAME = :eventName, EVENT_SOURCE = :eventSource, EVENT_TARGET = :eventTarget, ENTITY_NAME = :entityName, RECORD_COUNT = :recordCount, FILE_ATTACH_REF_NO = :fileAttachRefNo, EVENT_STATUS = :eventStatus, EVENT_REMARKS = :eventRemarks, FILE_NAME = :fileName, FILE_MASTER_REF_NO = :fileMasterRefNo, EVENT_BATCH_ID = :eventBatchId, DISPLAY_SOURCE = :displaySource, DISPLAY_TARGET = :displayTarget, RETRIGGER_COUNT = :retriggerCount, EVENT_FINPAY_ID = :eventFinpayId, FINTECH_SOURCE = :fintechSource WHERE ID = :id")
    public int update(@BindBean ScfFileEvents scffileevents);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SCF_FILE_EVENTS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SCF_FILE_EVENTS")
    public long countAll();

    /**
     * Bulk insert multiple ScfFileEvents entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SCF_FILE_EVENTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, EVENT_TYPE, EVENT_CODE, EVENT_NAME, EVENT_SOURCE, EVENT_TARGET, ENTITY_NAME, RECORD_COUNT, FILE_ATTACH_REF_NO, EVENT_STATUS, EVENT_REMARKS, FILE_NAME, FILE_MASTER_REF_NO, EVENT_BATCH_ID, DISPLAY_SOURCE, DISPLAY_TARGET, RETRIGGER_COUNT, EVENT_FINPAY_ID, FINTECH_SOURCE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :anchorCrn, :eventType, :eventCode, :eventName, :eventSource, :eventTarget, :entityName, :recordCount, :fileAttachRefNo, :eventStatus, :eventRemarks, :fileName, :fileMasterRefNo, :eventBatchId, :displaySource, :displayTarget, :retriggerCount, :eventFinpayId, :fintechSource)")
    public int[] bulkInsert(@BindBean List<ScfFileEvents> scffileeventss);

    /**
     * Bulk update multiple ScfFileEvents entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SCF_FILE_EVENTS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ANCHOR_CRN = :anchorCrn, EVENT_TYPE = :eventType, EVENT_CODE = :eventCode, EVENT_NAME = :eventName, EVENT_SOURCE = :eventSource, EVENT_TARGET = :eventTarget, ENTITY_NAME = :entityName, RECORD_COUNT = :recordCount, FILE_ATTACH_REF_NO = :fileAttachRefNo, EVENT_STATUS = :eventStatus, EVENT_REMARKS = :eventRemarks, FILE_NAME = :fileName, FILE_MASTER_REF_NO = :fileMasterRefNo, EVENT_BATCH_ID = :eventBatchId, DISPLAY_SOURCE = :displaySource, DISPLAY_TARGET = :displayTarget, RETRIGGER_COUNT = :retriggerCount, EVENT_FINPAY_ID = :eventFinpayId, FINTECH_SOURCE = :fintechSource WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<ScfFileEvents> scffileeventss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SCF_FILE_EVENTS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SCF_FILE_EVENTS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple ScfFileEvents records by their IDs.
     */
    @SqlQuery("SELECT * FROM SCF_FILE_EVENTS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(ScfFileEvents.class)
    public List<ScfFileEvents> findByIds(@BindList("ids") Collection<String> ids);
}
