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
import com.bsit.codegeneration.entity.FgModEiEvent;

public interface FgModEiEventDao {

    /**
     * Inserts a new FgModEiEvent and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_EI_EVENT (ID, FILE_REF_ID, EVENT_CODE, EVENT_DIRECTION_CODE, EVENT_STATUS_CODE, SOURCE_ENDPOINT_CODE, TARGET_ENDPOINT_CODE, EVENT_REQ_FILE_NAME, EVENT_REQUEST_DATE, EVENT_REQUEST, EVENT_RES_FILE_NAME, EVENT_RESPONSE_DATE, EVENT_RESPONSE, EVENT_ERROR_FILE_NAME, EVENT_ERROR_DATE, EVENT_ERROR, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, MOD_EI_FILE_ID) VALUES (:id, :fileRefId, :eventCode, :eventDirectionCode, :eventStatusCode, :sourceEndpointCode, :targetEndpointCode, :eventReqFileName, :eventRequestDate, :eventRequest, :eventResFileName, :eventResponseDate, :eventResponse, :eventErrorFileName, :eventErrorDate, :eventError, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :modEiFileId)")
    public int insert(@BindBean FgModEiEvent fgmodeievent);

    /**
     * Finds a FgModEiEvent by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_EI_EVENT WHERE ID = :id")
    @RegisterBeanMapper(FgModEiEvent.class)
    public Optional<FgModEiEvent> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_EI_EVENT")
    @RegisterBeanMapper(FgModEiEvent.class)
    public List<FgModEiEvent> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_EI_EVENT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModEiEvent.class)
    public List<FgModEiEvent> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModEiEvent and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_EI_EVENT SET FILE_REF_ID = :fileRefId, EVENT_CODE = :eventCode, EVENT_DIRECTION_CODE = :eventDirectionCode, EVENT_STATUS_CODE = :eventStatusCode, SOURCE_ENDPOINT_CODE = :sourceEndpointCode, TARGET_ENDPOINT_CODE = :targetEndpointCode, EVENT_REQ_FILE_NAME = :eventReqFileName, EVENT_REQUEST_DATE = :eventRequestDate, EVENT_REQUEST = :eventRequest, EVENT_RES_FILE_NAME = :eventResFileName, EVENT_RESPONSE_DATE = :eventResponseDate, EVENT_RESPONSE = :eventResponse, EVENT_ERROR_FILE_NAME = :eventErrorFileName, EVENT_ERROR_DATE = :eventErrorDate, EVENT_ERROR = :eventError, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, MOD_EI_FILE_ID = :modEiFileId WHERE ID = :id")
    public int update(@BindBean FgModEiEvent fgmodeievent);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_EI_EVENT WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_EI_EVENT")
    public long countAll();

    /**
     * Bulk insert multiple FgModEiEvent entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_EI_EVENT (ID, FILE_REF_ID, EVENT_CODE, EVENT_DIRECTION_CODE, EVENT_STATUS_CODE, SOURCE_ENDPOINT_CODE, TARGET_ENDPOINT_CODE, EVENT_REQ_FILE_NAME, EVENT_REQUEST_DATE, EVENT_REQUEST, EVENT_RES_FILE_NAME, EVENT_RESPONSE_DATE, EVENT_RESPONSE, EVENT_ERROR_FILE_NAME, EVENT_ERROR_DATE, EVENT_ERROR, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, MOD_EI_FILE_ID) VALUES (:id, :fileRefId, :eventCode, :eventDirectionCode, :eventStatusCode, :sourceEndpointCode, :targetEndpointCode, :eventReqFileName, :eventRequestDate, :eventRequest, :eventResFileName, :eventResponseDate, :eventResponse, :eventErrorFileName, :eventErrorDate, :eventError, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :modEiFileId)")
    public int[] bulkInsert(@BindBean List<FgModEiEvent> fgmodeievents);

    /**
     * Bulk update multiple FgModEiEvent entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_EI_EVENT SET FILE_REF_ID = :fileRefId, EVENT_CODE = :eventCode, EVENT_DIRECTION_CODE = :eventDirectionCode, EVENT_STATUS_CODE = :eventStatusCode, SOURCE_ENDPOINT_CODE = :sourceEndpointCode, TARGET_ENDPOINT_CODE = :targetEndpointCode, EVENT_REQ_FILE_NAME = :eventReqFileName, EVENT_REQUEST_DATE = :eventRequestDate, EVENT_REQUEST = :eventRequest, EVENT_RES_FILE_NAME = :eventResFileName, EVENT_RESPONSE_DATE = :eventResponseDate, EVENT_RESPONSE = :eventResponse, EVENT_ERROR_FILE_NAME = :eventErrorFileName, EVENT_ERROR_DATE = :eventErrorDate, EVENT_ERROR = :eventError, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, MOD_EI_FILE_ID = :modEiFileId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgModEiEvent> fgmodeievents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_EI_EVENT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_EI_EVENT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgModEiEvent records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_EI_EVENT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgModEiEvent.class)
    public List<FgModEiEvent> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
