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
import com.bsit.codegeneration.entity.ScfTxnBatchItem;

public interface ScfTxnBatchItemDao {

    /**
     * Inserts a new ScfTxnBatchItem and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SCF_TXN_BATCH_ITEM (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BATCH_REF_ID, TXN_REF_ID, ANCHOR_CRN, TXN_TYPE_CODE, TXN_SUB_TYPE_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :batchRefId, :txnRefId, :anchorCrn, :txnTypeCode, :txnSubTypeCode)")
    public int insert(@BindBean ScfTxnBatchItem scftxnbatchitem);

    /**
     * Finds a ScfTxnBatchItem by its ID.
     */
    @SqlQuery("SELECT * FROM SCF_TXN_BATCH_ITEM WHERE ID = :id")
    @RegisterBeanMapper(ScfTxnBatchItem.class)
    public Optional<ScfTxnBatchItem> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SCF_TXN_BATCH_ITEM")
    @RegisterBeanMapper(ScfTxnBatchItem.class)
    public List<ScfTxnBatchItem> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SCF_TXN_BATCH_ITEM ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(ScfTxnBatchItem.class)
    public List<ScfTxnBatchItem> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a ScfTxnBatchItem and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SCF_TXN_BATCH_ITEM SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BATCH_REF_ID = :batchRefId, TXN_REF_ID = :txnRefId, ANCHOR_CRN = :anchorCrn, TXN_TYPE_CODE = :txnTypeCode, TXN_SUB_TYPE_CODE = :txnSubTypeCode WHERE ID = :id")
    public int update(@BindBean ScfTxnBatchItem scftxnbatchitem);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SCF_TXN_BATCH_ITEM WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SCF_TXN_BATCH_ITEM")
    public long countAll();

    /**
     * Bulk insert multiple ScfTxnBatchItem entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SCF_TXN_BATCH_ITEM (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BATCH_REF_ID, TXN_REF_ID, ANCHOR_CRN, TXN_TYPE_CODE, TXN_SUB_TYPE_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :batchRefId, :txnRefId, :anchorCrn, :txnTypeCode, :txnSubTypeCode)")
    public int[] bulkInsert(@BindBean List<ScfTxnBatchItem> scftxnbatchitems);

    /**
     * Bulk update multiple ScfTxnBatchItem entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SCF_TXN_BATCH_ITEM SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BATCH_REF_ID = :batchRefId, TXN_REF_ID = :txnRefId, ANCHOR_CRN = :anchorCrn, TXN_TYPE_CODE = :txnTypeCode, TXN_SUB_TYPE_CODE = :txnSubTypeCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<ScfTxnBatchItem> scftxnbatchitems);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SCF_TXN_BATCH_ITEM WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SCF_TXN_BATCH_ITEM WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple ScfTxnBatchItem records by their IDs.
     */
    @SqlQuery("SELECT * FROM SCF_TXN_BATCH_ITEM WHERE ID IN (<ids>)")
    @RegisterBeanMapper(ScfTxnBatchItem.class)
    public List<ScfTxnBatchItem> findByIds(@BindList("ids") Collection<String> ids);
}
