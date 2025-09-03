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
import com.bsit.codegeneration.entity.FgModProductEvent;

public interface FgModProductEventDao {

    /**
     * Inserts a new FgModProductEvent and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_PRODUCT_EVENT (ID, VERSION_ID, IS_MASTER_VERSION, REFERENCE_ID, PARENT_REF_ID, PARENT_VERSION_ID, TYPE_CODE, SUB_TYPE_CODE, EVENT_CODE, EVENT_STAGE_CODE, EVENT_FORM_ID, EVENT_BO_REF_NO, EVENT_BO_CODE, ENTITY_REF_ID, ENTITY_VERSION_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_BO_REF_NO, ENTITY_BO_CODE, TEMPLATE, STAGE_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, EVENT_STATUS_CODE, EVENT_TYPE_CODE, EVENT_SUB_TYPE_CODE) VALUES (:id, :versionId, :isMasterVersion, :referenceId, :parentRefId, :parentVersionId, :typeCode, :subTypeCode, :eventCode, :eventStageCode, :eventFormId, :eventBoRefNo, :eventBoCode, :entityRefId, :entityVersionNo, :entityTypeCode, :entitySubTypeCode, :entityBoRefNo, :entityBoCode, :template, :stageCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :eventStatusCode, :eventTypeCode, :eventSubTypeCode)")
    public int insert(@BindBean FgModProductEvent fgmodproductevent);

    /**
     * Finds a FgModProductEvent by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_EVENT WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgModProductEvent.class)
    public Optional<FgModProductEvent> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_EVENT")
    @RegisterBeanMapper(FgModProductEvent.class)
    public List<FgModProductEvent> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_EVENT ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModProductEvent.class)
    public List<FgModProductEvent> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModProductEvent and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_PRODUCT_EVENT SET IS_MASTER_VERSION = :isMasterVersion, REFERENCE_ID = :referenceId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, EVENT_CODE = :eventCode, EVENT_STAGE_CODE = :eventStageCode, EVENT_FORM_ID = :eventFormId, EVENT_BO_REF_NO = :eventBoRefNo, EVENT_BO_CODE = :eventBoCode, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_NO = :entityVersionNo, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_BO_REF_NO = :entityBoRefNo, ENTITY_BO_CODE = :entityBoCode, TEMPLATE = :template, STAGE_CODE = :stageCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, EVENT_STATUS_CODE = :eventStatusCode, EVENT_TYPE_CODE = :eventTypeCode, EVENT_SUB_TYPE_CODE = :eventSubTypeCode WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgModProductEvent fgmodproductevent);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_PRODUCT_EVENT WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_PRODUCT_EVENT")
    public long countAll();

    /**
     * Bulk insert multiple FgModProductEvent entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_PRODUCT_EVENT (ID, VERSION_ID, IS_MASTER_VERSION, REFERENCE_ID, PARENT_REF_ID, PARENT_VERSION_ID, TYPE_CODE, SUB_TYPE_CODE, EVENT_CODE, EVENT_STAGE_CODE, EVENT_FORM_ID, EVENT_BO_REF_NO, EVENT_BO_CODE, ENTITY_REF_ID, ENTITY_VERSION_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_BO_REF_NO, ENTITY_BO_CODE, TEMPLATE, STAGE_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, EVENT_STATUS_CODE, EVENT_TYPE_CODE, EVENT_SUB_TYPE_CODE) VALUES (:id, :versionId, :isMasterVersion, :referenceId, :parentRefId, :parentVersionId, :typeCode, :subTypeCode, :eventCode, :eventStageCode, :eventFormId, :eventBoRefNo, :eventBoCode, :entityRefId, :entityVersionNo, :entityTypeCode, :entitySubTypeCode, :entityBoRefNo, :entityBoCode, :template, :stageCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :processId, :eventStatusCode, :eventTypeCode, :eventSubTypeCode)")
    public int[] bulkInsert(@BindBean List<FgModProductEvent> fgmodproductevents);

    /**
     * Bulk update multiple FgModProductEvent entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_PRODUCT_EVENT SET IS_MASTER_VERSION = :isMasterVersion, REFERENCE_ID = :referenceId, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, EVENT_CODE = :eventCode, EVENT_STAGE_CODE = :eventStageCode, EVENT_FORM_ID = :eventFormId, EVENT_BO_REF_NO = :eventBoRefNo, EVENT_BO_CODE = :eventBoCode, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_NO = :entityVersionNo, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_BO_REF_NO = :entityBoRefNo, ENTITY_BO_CODE = :entityBoCode, TEMPLATE = :template, STAGE_CODE = :stageCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PROCESS_ID = :processId, EVENT_STATUS_CODE = :eventStatusCode, EVENT_TYPE_CODE = :eventTypeCode, EVENT_SUB_TYPE_CODE = :eventSubTypeCode WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgModProductEvent> fgmodproductevents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_PRODUCT_EVENT WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_PRODUCT_EVENT WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgModProductEvent records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_PRODUCT_EVENT WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgModProductEvent.class)
    public List<FgModProductEvent> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
