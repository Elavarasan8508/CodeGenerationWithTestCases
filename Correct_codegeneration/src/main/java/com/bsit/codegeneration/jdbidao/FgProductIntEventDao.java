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
import com.bsit.codegeneration.entity.FgProductIntEvent;

public interface FgProductIntEventDao {

    /**
     * Inserts a new FgProductIntEvent and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PRODUCT_INT_EVENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SOURCE_SYSTEM, SOURCE_PRODUCT, SOURCE_EVENT, TARGET_SYSTEM, TARGET_PRODUCT, TARGET_EVENT, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, TEST, TEST1, TEST2, ENTITY_SUB_TYPE_CODE, BO_REF_NO, BO_STATUS, BO_COMMENTS, TRANSLATOR_CODE, STAGING_TYPE, INT_STATUS_CODE, STAGING_STATUS_CODE, STAGING_REQUEST, STAGING_RESPONSE, EVENT_TYPE, EVENT_STATUS, SERVER_DETAILS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :sourceSystem, :sourceProduct, :sourceEvent, :targetSystem, :targetProduct, :targetEvent, :entityRefId, :entityVersionId, :entityTypeCode, :test, :test1, :test2, :entitySubTypeCode, :boRefNo, :boStatus, :boComments, :translatorCode, :stagingType, :intStatusCode, :stagingStatusCode, :stagingRequest, :stagingResponse, :eventType, :eventStatus, :serverDetails)")
    public int insert(@BindBean FgProductIntEvent fgproductintevent);

    /**
     * Finds a FgProductIntEvent by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_INT_EVENT WHERE ID = :id")
    @RegisterBeanMapper(FgProductIntEvent.class)
    public Optional<FgProductIntEvent> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_INT_EVENT")
    @RegisterBeanMapper(FgProductIntEvent.class)
    public List<FgProductIntEvent> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_INT_EVENT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProductIntEvent.class)
    public List<FgProductIntEvent> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProductIntEvent and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PRODUCT_INT_EVENT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SOURCE_SYSTEM = :sourceSystem, SOURCE_PRODUCT = :sourceProduct, SOURCE_EVENT = :sourceEvent, TARGET_SYSTEM = :targetSystem, TARGET_PRODUCT = :targetProduct, TARGET_EVENT = :targetEvent, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_ID = :entityVersionId, ENTITY_TYPE_CODE = :entityTypeCode, TEST = :test, TEST1 = :test1, TEST2 = :test2, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, BO_REF_NO = :boRefNo, BO_STATUS = :boStatus, BO_COMMENTS = :boComments, TRANSLATOR_CODE = :translatorCode, STAGING_TYPE = :stagingType, INT_STATUS_CODE = :intStatusCode, STAGING_STATUS_CODE = :stagingStatusCode, STAGING_REQUEST = :stagingRequest, STAGING_RESPONSE = :stagingResponse, EVENT_TYPE = :eventType, EVENT_STATUS = :eventStatus, SERVER_DETAILS = :serverDetails WHERE ID = :id")
    public int update(@BindBean FgProductIntEvent fgproductintevent);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_INT_EVENT WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PRODUCT_INT_EVENT")
    public long countAll();

    /**
     * Bulk insert multiple FgProductIntEvent entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PRODUCT_INT_EVENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SOURCE_SYSTEM, SOURCE_PRODUCT, SOURCE_EVENT, TARGET_SYSTEM, TARGET_PRODUCT, TARGET_EVENT, ENTITY_REF_ID, ENTITY_VERSION_ID, ENTITY_TYPE_CODE, TEST, TEST1, TEST2, ENTITY_SUB_TYPE_CODE, BO_REF_NO, BO_STATUS, BO_COMMENTS, TRANSLATOR_CODE, STAGING_TYPE, INT_STATUS_CODE, STAGING_STATUS_CODE, STAGING_REQUEST, STAGING_RESPONSE, EVENT_TYPE, EVENT_STATUS, SERVER_DETAILS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :sourceSystem, :sourceProduct, :sourceEvent, :targetSystem, :targetProduct, :targetEvent, :entityRefId, :entityVersionId, :entityTypeCode, :test, :test1, :test2, :entitySubTypeCode, :boRefNo, :boStatus, :boComments, :translatorCode, :stagingType, :intStatusCode, :stagingStatusCode, :stagingRequest, :stagingResponse, :eventType, :eventStatus, :serverDetails)")
    public int[] bulkInsert(@BindBean List<FgProductIntEvent> fgproductintevents);

    /**
     * Bulk update multiple FgProductIntEvent entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PRODUCT_INT_EVENT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SOURCE_SYSTEM = :sourceSystem, SOURCE_PRODUCT = :sourceProduct, SOURCE_EVENT = :sourceEvent, TARGET_SYSTEM = :targetSystem, TARGET_PRODUCT = :targetProduct, TARGET_EVENT = :targetEvent, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_ID = :entityVersionId, ENTITY_TYPE_CODE = :entityTypeCode, TEST = :test, TEST1 = :test1, TEST2 = :test2, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, BO_REF_NO = :boRefNo, BO_STATUS = :boStatus, BO_COMMENTS = :boComments, TRANSLATOR_CODE = :translatorCode, STAGING_TYPE = :stagingType, INT_STATUS_CODE = :intStatusCode, STAGING_STATUS_CODE = :stagingStatusCode, STAGING_REQUEST = :stagingRequest, STAGING_RESPONSE = :stagingResponse, EVENT_TYPE = :eventType, EVENT_STATUS = :eventStatus, SERVER_DETAILS = :serverDetails WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgProductIntEvent> fgproductintevents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_INT_EVENT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PRODUCT_INT_EVENT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgProductIntEvent records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_INT_EVENT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgProductIntEvent.class)
    public List<FgProductIntEvent> findByIds(@BindList("ids") Collection<String> ids);
}
