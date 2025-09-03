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
import com.bsit.codegeneration.entity.FgTrdPostings;

public interface FgTrdPostingsDao {

    /**
     * Inserts a new FgTrdPostings and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_POSTINGS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER, NOSTRO_REFERENCE, PORTAL_REFERENCE, POSTING_REQUEST, STATUS, POSTING_RESPONSE, TI_MASTER_REF, TI_PRODUCT_CODE, THEIR_REFERENCE, PRODUCT, TI_STATUS, EVENT_SERIAL, EVENT_PREFIX, BILL_NO) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :customer, :nostroReference, :portalReference, :postingRequest, :status, :postingResponse, :tiMasterRef, :tiProductCode, :theirReference, :product, :tiStatus, :eventSerial, :eventPrefix, :billNo)")
    public int insert(@BindBean FgTrdPostings fgtrdpostings);

    /**
     * Finds a FgTrdPostings by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_POSTINGS WHERE ID = :id")
    @RegisterBeanMapper(FgTrdPostings.class)
    public Optional<FgTrdPostings> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_POSTINGS")
    @RegisterBeanMapper(FgTrdPostings.class)
    public List<FgTrdPostings> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_POSTINGS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdPostings.class)
    public List<FgTrdPostings> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdPostings and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_POSTINGS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUSTOMER = :customer, NOSTRO_REFERENCE = :nostroReference, PORTAL_REFERENCE = :portalReference, POSTING_REQUEST = :postingRequest, STATUS = :status, POSTING_RESPONSE = :postingResponse, TI_MASTER_REF = :tiMasterRef, TI_PRODUCT_CODE = :tiProductCode, THEIR_REFERENCE = :theirReference, PRODUCT = :product, TI_STATUS = :tiStatus, EVENT_SERIAL = :eventSerial, EVENT_PREFIX = :eventPrefix, BILL_NO = :billNo WHERE ID = :id")
    public int update(@BindBean FgTrdPostings fgtrdpostings);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_POSTINGS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_POSTINGS")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdPostings entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_POSTINGS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER, NOSTRO_REFERENCE, PORTAL_REFERENCE, POSTING_REQUEST, STATUS, POSTING_RESPONSE, TI_MASTER_REF, TI_PRODUCT_CODE, THEIR_REFERENCE, PRODUCT, TI_STATUS, EVENT_SERIAL, EVENT_PREFIX, BILL_NO) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :customer, :nostroReference, :portalReference, :postingRequest, :status, :postingResponse, :tiMasterRef, :tiProductCode, :theirReference, :product, :tiStatus, :eventSerial, :eventPrefix, :billNo)")
    public int[] bulkInsert(@BindBean List<FgTrdPostings> fgtrdpostingss);

    /**
     * Bulk update multiple FgTrdPostings entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_POSTINGS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUSTOMER = :customer, NOSTRO_REFERENCE = :nostroReference, PORTAL_REFERENCE = :portalReference, POSTING_REQUEST = :postingRequest, STATUS = :status, POSTING_RESPONSE = :postingResponse, TI_MASTER_REF = :tiMasterRef, TI_PRODUCT_CODE = :tiProductCode, THEIR_REFERENCE = :theirReference, PRODUCT = :product, TI_STATUS = :tiStatus, EVENT_SERIAL = :eventSerial, EVENT_PREFIX = :eventPrefix, BILL_NO = :billNo WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdPostings> fgtrdpostingss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_POSTINGS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_POSTINGS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdPostings records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_POSTINGS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdPostings.class)
    public List<FgTrdPostings> findByIds(@BindList("ids") Collection<String> ids);
}
