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
import com.bsit.codegeneration.entity.FgFileEvents;

public interface FgFileEventsDao {

    /**
     * Inserts a new FgFileEvents and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_FILE_EVENTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, EVENT_TYPE, EVENT_CODE, EVENT_NAME, EVENT_SOURCE, EVENT_TARGET, ENTITY_NAME, RECORD_COUNT, FILE_ATTACH_REF_NO, EVENT_STATUS, EVENT_REMARKS, FILE_NAME, FILE_MASTER_REF_NO, EVENT_BATCH_ID, DISPLAY_SOURCE, DISPLAY_TARGET, LAYOUT_NAME, LAYOUT_TEMPLATE_ID, LAYOUT_TEMPLATE_VERSION_ID, UPLOAD_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :anchorCrn, :eventType, :eventCode, :eventName, :eventSource, :eventTarget, :entityName, :recordCount, :fileAttachRefNo, :eventStatus, :eventRemarks, :fileName, :fileMasterRefNo, :eventBatchId, :displaySource, :displayTarget, :layoutName, :layoutTemplateId, :layoutTemplateVersionId, :uploadRefId, :entitySubTypeCode, :entityTypeCode)")
    public int insert(@BindBean FgFileEvents fgfileevents);

    /**
     * Finds a FgFileEvents by its ID.
     */
    @SqlQuery("SELECT * FROM FG_FILE_EVENTS WHERE ID = :id")
    @RegisterBeanMapper(FgFileEvents.class)
    public Optional<FgFileEvents> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_FILE_EVENTS")
    @RegisterBeanMapper(FgFileEvents.class)
    public List<FgFileEvents> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_FILE_EVENTS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgFileEvents.class)
    public List<FgFileEvents> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgFileEvents and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_FILE_EVENTS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ANCHOR_CRN = :anchorCrn, EVENT_TYPE = :eventType, EVENT_CODE = :eventCode, EVENT_NAME = :eventName, EVENT_SOURCE = :eventSource, EVENT_TARGET = :eventTarget, ENTITY_NAME = :entityName, RECORD_COUNT = :recordCount, FILE_ATTACH_REF_NO = :fileAttachRefNo, EVENT_STATUS = :eventStatus, EVENT_REMARKS = :eventRemarks, FILE_NAME = :fileName, FILE_MASTER_REF_NO = :fileMasterRefNo, EVENT_BATCH_ID = :eventBatchId, DISPLAY_SOURCE = :displaySource, DISPLAY_TARGET = :displayTarget, LAYOUT_NAME = :layoutName, LAYOUT_TEMPLATE_ID = :layoutTemplateId, LAYOUT_TEMPLATE_VERSION_ID = :layoutTemplateVersionId, UPLOAD_REF_ID = :uploadRefId, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_TYPE_CODE = :entityTypeCode WHERE ID = :id")
    public int update(@BindBean FgFileEvents fgfileevents);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FILE_EVENTS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_FILE_EVENTS")
    public long countAll();

    /**
     * Bulk insert multiple FgFileEvents entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_FILE_EVENTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, EVENT_TYPE, EVENT_CODE, EVENT_NAME, EVENT_SOURCE, EVENT_TARGET, ENTITY_NAME, RECORD_COUNT, FILE_ATTACH_REF_NO, EVENT_STATUS, EVENT_REMARKS, FILE_NAME, FILE_MASTER_REF_NO, EVENT_BATCH_ID, DISPLAY_SOURCE, DISPLAY_TARGET, LAYOUT_NAME, LAYOUT_TEMPLATE_ID, LAYOUT_TEMPLATE_VERSION_ID, UPLOAD_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :anchorCrn, :eventType, :eventCode, :eventName, :eventSource, :eventTarget, :entityName, :recordCount, :fileAttachRefNo, :eventStatus, :eventRemarks, :fileName, :fileMasterRefNo, :eventBatchId, :displaySource, :displayTarget, :layoutName, :layoutTemplateId, :layoutTemplateVersionId, :uploadRefId, :entitySubTypeCode, :entityTypeCode)")
    public int[] bulkInsert(@BindBean List<FgFileEvents> fgfileeventss);

    /**
     * Bulk update multiple FgFileEvents entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_FILE_EVENTS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ANCHOR_CRN = :anchorCrn, EVENT_TYPE = :eventType, EVENT_CODE = :eventCode, EVENT_NAME = :eventName, EVENT_SOURCE = :eventSource, EVENT_TARGET = :eventTarget, ENTITY_NAME = :entityName, RECORD_COUNT = :recordCount, FILE_ATTACH_REF_NO = :fileAttachRefNo, EVENT_STATUS = :eventStatus, EVENT_REMARKS = :eventRemarks, FILE_NAME = :fileName, FILE_MASTER_REF_NO = :fileMasterRefNo, EVENT_BATCH_ID = :eventBatchId, DISPLAY_SOURCE = :displaySource, DISPLAY_TARGET = :displayTarget, LAYOUT_NAME = :layoutName, LAYOUT_TEMPLATE_ID = :layoutTemplateId, LAYOUT_TEMPLATE_VERSION_ID = :layoutTemplateVersionId, UPLOAD_REF_ID = :uploadRefId, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_TYPE_CODE = :entityTypeCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgFileEvents> fgfileeventss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FILE_EVENTS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_FILE_EVENTS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgFileEvents records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_FILE_EVENTS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgFileEvents.class)
    public List<FgFileEvents> findByIds(@BindList("ids") Collection<String> ids);
}
