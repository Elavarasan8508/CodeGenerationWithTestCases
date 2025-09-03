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
import com.bsit.codegeneration.entity.ScfTxnBatch;

public interface ScfTxnBatchDao {

    /**
     * Inserts a new ScfTxnBatch and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO SCF_TXN_BATCH (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_MASTER_REF_NO, SCF_REQ_REF_NO, TXN_BATCH_COUNT, PRODUCT_TYPE, UTR_REF_NO, FINANCE_REF_NO, STATUS, REMARKS, EVENTS_PAY_RES_REF_NO, CMS_REF_NO, PURPOSE_CODE, TOTAL_COUNT, TOTAL_AMOUNT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :anchorCrn, :fileMasterRefNo, :scfReqRefNo, :txnBatchCount, :productType, :utrRefNo, :financeRefNo, :status, :remarks, :eventsPayResRefNo, :cmsRefNo, :purposeCode, :totalCount, :totalAmount)")
    public int insert(@BindBean ScfTxnBatch scftxnbatch);

    /**
     * Finds a ScfTxnBatch by its ID.
     */
    @SqlQuery("SELECT * FROM SCF_TXN_BATCH WHERE ID = :id")
    @RegisterBeanMapper(ScfTxnBatch.class)
    public Optional<ScfTxnBatch> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM SCF_TXN_BATCH")
    @RegisterBeanMapper(ScfTxnBatch.class)
    public List<ScfTxnBatch> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM SCF_TXN_BATCH ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(ScfTxnBatch.class)
    public List<ScfTxnBatch> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a ScfTxnBatch and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE SCF_TXN_BATCH SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ANCHOR_CRN = :anchorCrn, FILE_MASTER_REF_NO = :fileMasterRefNo, SCF_REQ_REF_NO = :scfReqRefNo, TXN_BATCH_COUNT = :txnBatchCount, PRODUCT_TYPE = :productType, UTR_REF_NO = :utrRefNo, FINANCE_REF_NO = :financeRefNo, STATUS = :status, REMARKS = :remarks, EVENTS_PAY_RES_REF_NO = :eventsPayResRefNo, CMS_REF_NO = :cmsRefNo, PURPOSE_CODE = :purposeCode, TOTAL_COUNT = :totalCount, TOTAL_AMOUNT = :totalAmount WHERE ID = :id")
    public int update(@BindBean ScfTxnBatch scftxnbatch);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM SCF_TXN_BATCH WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM SCF_TXN_BATCH")
    public long countAll();

    /**
     * Bulk insert multiple ScfTxnBatch entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO SCF_TXN_BATCH (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ANCHOR_CRN, FILE_MASTER_REF_NO, SCF_REQ_REF_NO, TXN_BATCH_COUNT, PRODUCT_TYPE, UTR_REF_NO, FINANCE_REF_NO, STATUS, REMARKS, EVENTS_PAY_RES_REF_NO, CMS_REF_NO, PURPOSE_CODE, TOTAL_COUNT, TOTAL_AMOUNT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :anchorCrn, :fileMasterRefNo, :scfReqRefNo, :txnBatchCount, :productType, :utrRefNo, :financeRefNo, :status, :remarks, :eventsPayResRefNo, :cmsRefNo, :purposeCode, :totalCount, :totalAmount)")
    public int[] bulkInsert(@BindBean List<ScfTxnBatch> scftxnbatchs);

    /**
     * Bulk update multiple ScfTxnBatch entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE SCF_TXN_BATCH SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ANCHOR_CRN = :anchorCrn, FILE_MASTER_REF_NO = :fileMasterRefNo, SCF_REQ_REF_NO = :scfReqRefNo, TXN_BATCH_COUNT = :txnBatchCount, PRODUCT_TYPE = :productType, UTR_REF_NO = :utrRefNo, FINANCE_REF_NO = :financeRefNo, STATUS = :status, REMARKS = :remarks, EVENTS_PAY_RES_REF_NO = :eventsPayResRefNo, CMS_REF_NO = :cmsRefNo, PURPOSE_CODE = :purposeCode, TOTAL_COUNT = :totalCount, TOTAL_AMOUNT = :totalAmount WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<ScfTxnBatch> scftxnbatchs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM SCF_TXN_BATCH WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM SCF_TXN_BATCH WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple ScfTxnBatch records by their IDs.
     */
    @SqlQuery("SELECT * FROM SCF_TXN_BATCH WHERE ID IN (<ids>)")
    @RegisterBeanMapper(ScfTxnBatch.class)
    public List<ScfTxnBatch> findByIds(@BindList("ids") Collection<String> ids);
}
