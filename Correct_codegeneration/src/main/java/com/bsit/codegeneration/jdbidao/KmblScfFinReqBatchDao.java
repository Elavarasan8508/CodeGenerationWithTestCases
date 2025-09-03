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
import com.bsit.codegeneration.entity.KmblScfFinReqBatch;

public interface KmblScfFinReqBatchDao {

    /**
     * Inserts a new KmblScfFinReqBatch and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO KMBL_SCF_FIN_REQ_BATCH (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARTY_TYPE, CUSTOMER_CRN, PROGRAM_LAYOUT, BATCH_VALUE_DATE, LOAN_REF_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, CCY, RETURN_TEXT, BATCH_AMOUNT, LIMIT_NODE_REFERENCE, SNAPSHOT_LIMIT, REMARKS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :partyType, :customerCrn, :programLayout, :batchValueDate, :loanRefId, :loanDueDate, :requestAmount, :ccy, :returnText, :batchAmount, :limitNodeReference, :snapshotLimit, :remarks)")
    public int insert(@BindBean KmblScfFinReqBatch kmblscffinreqbatch);

    /**
     * Finds a KmblScfFinReqBatch by its ID.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_FIN_REQ_BATCH WHERE ID = :id")
    @RegisterBeanMapper(KmblScfFinReqBatch.class)
    public Optional<KmblScfFinReqBatch> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_FIN_REQ_BATCH")
    @RegisterBeanMapper(KmblScfFinReqBatch.class)
    public List<KmblScfFinReqBatch> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_FIN_REQ_BATCH ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(KmblScfFinReqBatch.class)
    public List<KmblScfFinReqBatch> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a KmblScfFinReqBatch and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE KMBL_SCF_FIN_REQ_BATCH SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, PARTY_TYPE = :partyType, CUSTOMER_CRN = :customerCrn, PROGRAM_LAYOUT = :programLayout, BATCH_VALUE_DATE = :batchValueDate, LOAN_REF_ID = :loanRefId, LOAN_DUE_DATE = :loanDueDate, REQUEST_AMOUNT = :requestAmount, CCY = :ccy, RETURN_TEXT = :returnText, BATCH_AMOUNT = :batchAmount, LIMIT_NODE_REFERENCE = :limitNodeReference, SNAPSHOT_LIMIT = :snapshotLimit, REMARKS = :remarks WHERE ID = :id")
    public int update(@BindBean KmblScfFinReqBatch kmblscffinreqbatch);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM KMBL_SCF_FIN_REQ_BATCH WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM KMBL_SCF_FIN_REQ_BATCH")
    public long countAll();

    /**
     * Bulk insert multiple KmblScfFinReqBatch entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO KMBL_SCF_FIN_REQ_BATCH (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARTY_TYPE, CUSTOMER_CRN, PROGRAM_LAYOUT, BATCH_VALUE_DATE, LOAN_REF_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, CCY, RETURN_TEXT, BATCH_AMOUNT, LIMIT_NODE_REFERENCE, SNAPSHOT_LIMIT, REMARKS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :partyType, :customerCrn, :programLayout, :batchValueDate, :loanRefId, :loanDueDate, :requestAmount, :ccy, :returnText, :batchAmount, :limitNodeReference, :snapshotLimit, :remarks)")
    public int[] bulkInsert(@BindBean List<KmblScfFinReqBatch> kmblscffinreqbatchs);

    /**
     * Bulk update multiple KmblScfFinReqBatch entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE KMBL_SCF_FIN_REQ_BATCH SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, PARTY_TYPE = :partyType, CUSTOMER_CRN = :customerCrn, PROGRAM_LAYOUT = :programLayout, BATCH_VALUE_DATE = :batchValueDate, LOAN_REF_ID = :loanRefId, LOAN_DUE_DATE = :loanDueDate, REQUEST_AMOUNT = :requestAmount, CCY = :ccy, RETURN_TEXT = :returnText, BATCH_AMOUNT = :batchAmount, LIMIT_NODE_REFERENCE = :limitNodeReference, SNAPSHOT_LIMIT = :snapshotLimit, REMARKS = :remarks WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<KmblScfFinReqBatch> kmblscffinreqbatchs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM KMBL_SCF_FIN_REQ_BATCH WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM KMBL_SCF_FIN_REQ_BATCH WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple KmblScfFinReqBatch records by their IDs.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_FIN_REQ_BATCH WHERE ID IN (<ids>)")
    @RegisterBeanMapper(KmblScfFinReqBatch.class)
    public List<KmblScfFinReqBatch> findByIds(@BindList("ids") Collection<String> ids);
}
