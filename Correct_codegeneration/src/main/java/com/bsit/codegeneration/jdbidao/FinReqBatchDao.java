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
import com.bsit.codegeneration.entity.FinReqBatch;

public interface FinReqBatchDao {

    /**
     * Inserts a new FinReqBatch and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FIN_REQ_BATCH (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARTY_TYPE, CUSTOMER_CRN, PROGRAM_LAYOUT, LAYOUT_NAME, BATCH_VALUE_DATE, LOAN_REF_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, CCY, RETURN_TEXT, BATCH_AMOUNT, LIMIT_NODE_REFERENCE, SNAPSHOT_LIMIT, TASK_REASON, PRODUCT_TYPE, FINANCE_AMOUNT, FINANCING_AMOUNT, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, CONTRACT_PERIOD, TNX_DISPLAY_REMARKS, TNX_DISPLAY_STATUS, MATURITY_DATE, LIMIT_NODE_REFERENCE2, BATCH_DISPLAY_STATUS, BATCH_DISPLAY_REMARKS, REQUEST_INITIATION_TYPE, LOAN_REQUEST_TYPE, LAYOUT_UUID, BATCH_STATUS, PRODUCT_STATUS, TOTAL_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, VERSION_ID, IS_MASTER_VERSION, LAYOUT_ID, CUSTOMER_ROLE, CP_CODE, BATCH_ACTION, UPLOAD_REF_ID, OWNER_PARTY, APPLICANT_NAME, FILE_NAME, FINANCE_PARTY, CP_NAME, ANCHOR_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :partyType, :customerCrn, :programLayout, :layoutName, :batchValueDate, :loanRefId, :loanDueDate, :requestAmount, :ccy, :returnText, :batchAmount, :limitNodeReference, :snapshotLimit, :taskReason, :productType, :financeAmount, :financingAmount, :tenorInDays, :intPeriodInDays, :contractPeriod, :tnxDisplayRemarks, :tnxDisplayStatus, :maturityDate, :limitNodeReference2, :batchDisplayStatus, :batchDisplayRemarks, :requestInitiationType, :loanRequestType, :layoutUuid, :batchStatus, :productStatus, :totalCount, :entityTypeCode, :entitySubTypeCode, :versionId, :isMasterVersion, :layoutId, :customerRole, :cpCode, :batchAction, :uploadRefId, :ownerParty, :applicantName, :fileName, :financeParty, :cpName, :anchorName)")
    public int insert(@BindBean FinReqBatch finreqbatch);

    /**
     * Finds a FinReqBatch by its ID.
     */
    @SqlQuery("SELECT * FROM FIN_REQ_BATCH WHERE ID = :id")
    @RegisterBeanMapper(FinReqBatch.class)
    public Optional<FinReqBatch> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FIN_REQ_BATCH")
    @RegisterBeanMapper(FinReqBatch.class)
    public List<FinReqBatch> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FIN_REQ_BATCH ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FinReqBatch.class)
    public List<FinReqBatch> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FinReqBatch and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FIN_REQ_BATCH SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, PARTY_TYPE = :partyType, CUSTOMER_CRN = :customerCrn, PROGRAM_LAYOUT = :programLayout, LAYOUT_NAME = :layoutName, BATCH_VALUE_DATE = :batchValueDate, LOAN_REF_ID = :loanRefId, LOAN_DUE_DATE = :loanDueDate, REQUEST_AMOUNT = :requestAmount, CCY = :ccy, RETURN_TEXT = :returnText, BATCH_AMOUNT = :batchAmount, LIMIT_NODE_REFERENCE = :limitNodeReference, SNAPSHOT_LIMIT = :snapshotLimit, TASK_REASON = :taskReason, PRODUCT_TYPE = :productType, FINANCE_AMOUNT = :financeAmount, FINANCING_AMOUNT = :financingAmount, TENOR_IN_DAYS = :tenorInDays, INT_PERIOD_IN_DAYS = :intPeriodInDays, CONTRACT_PERIOD = :contractPeriod, TNX_DISPLAY_REMARKS = :tnxDisplayRemarks, TNX_DISPLAY_STATUS = :tnxDisplayStatus, MATURITY_DATE = :maturityDate, LIMIT_NODE_REFERENCE2 = :limitNodeReference2, BATCH_DISPLAY_STATUS = :batchDisplayStatus, BATCH_DISPLAY_REMARKS = :batchDisplayRemarks, REQUEST_INITIATION_TYPE = :requestInitiationType, LOAN_REQUEST_TYPE = :loanRequestType, LAYOUT_UUID = :layoutUuid, BATCH_STATUS = :batchStatus, PRODUCT_STATUS = :productStatus, TOTAL_COUNT = :totalCount, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, LAYOUT_ID = :layoutId, CUSTOMER_ROLE = :customerRole, CP_CODE = :cpCode, BATCH_ACTION = :batchAction, UPLOAD_REF_ID = :uploadRefId, OWNER_PARTY = :ownerParty, APPLICANT_NAME = :applicantName, FILE_NAME = :fileName, FINANCE_PARTY = :financeParty, CP_NAME = :cpName, ANCHOR_NAME = :anchorName WHERE ID = :id")
    public int update(@BindBean FinReqBatch finreqbatch);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FIN_REQ_BATCH WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FIN_REQ_BATCH")
    public long countAll();

    /**
     * Bulk insert multiple FinReqBatch entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FIN_REQ_BATCH (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PARTY_TYPE, CUSTOMER_CRN, PROGRAM_LAYOUT, LAYOUT_NAME, BATCH_VALUE_DATE, LOAN_REF_ID, LOAN_DUE_DATE, REQUEST_AMOUNT, CCY, RETURN_TEXT, BATCH_AMOUNT, LIMIT_NODE_REFERENCE, SNAPSHOT_LIMIT, TASK_REASON, PRODUCT_TYPE, FINANCE_AMOUNT, FINANCING_AMOUNT, TENOR_IN_DAYS, INT_PERIOD_IN_DAYS, CONTRACT_PERIOD, TNX_DISPLAY_REMARKS, TNX_DISPLAY_STATUS, MATURITY_DATE, LIMIT_NODE_REFERENCE2, BATCH_DISPLAY_STATUS, BATCH_DISPLAY_REMARKS, REQUEST_INITIATION_TYPE, LOAN_REQUEST_TYPE, LAYOUT_UUID, BATCH_STATUS, PRODUCT_STATUS, TOTAL_COUNT, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, VERSION_ID, IS_MASTER_VERSION, LAYOUT_ID, CUSTOMER_ROLE, CP_CODE, BATCH_ACTION, UPLOAD_REF_ID, OWNER_PARTY, APPLICANT_NAME, FILE_NAME, FINANCE_PARTY, CP_NAME, ANCHOR_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :partyType, :customerCrn, :programLayout, :layoutName, :batchValueDate, :loanRefId, :loanDueDate, :requestAmount, :ccy, :returnText, :batchAmount, :limitNodeReference, :snapshotLimit, :taskReason, :productType, :financeAmount, :financingAmount, :tenorInDays, :intPeriodInDays, :contractPeriod, :tnxDisplayRemarks, :tnxDisplayStatus, :maturityDate, :limitNodeReference2, :batchDisplayStatus, :batchDisplayRemarks, :requestInitiationType, :loanRequestType, :layoutUuid, :batchStatus, :productStatus, :totalCount, :entityTypeCode, :entitySubTypeCode, :versionId, :isMasterVersion, :layoutId, :customerRole, :cpCode, :batchAction, :uploadRefId, :ownerParty, :applicantName, :fileName, :financeParty, :cpName, :anchorName)")
    public int[] bulkInsert(@BindBean List<FinReqBatch> finreqbatchs);

    /**
     * Bulk update multiple FinReqBatch entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FIN_REQ_BATCH SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, PARTY_TYPE = :partyType, CUSTOMER_CRN = :customerCrn, PROGRAM_LAYOUT = :programLayout, LAYOUT_NAME = :layoutName, BATCH_VALUE_DATE = :batchValueDate, LOAN_REF_ID = :loanRefId, LOAN_DUE_DATE = :loanDueDate, REQUEST_AMOUNT = :requestAmount, CCY = :ccy, RETURN_TEXT = :returnText, BATCH_AMOUNT = :batchAmount, LIMIT_NODE_REFERENCE = :limitNodeReference, SNAPSHOT_LIMIT = :snapshotLimit, TASK_REASON = :taskReason, PRODUCT_TYPE = :productType, FINANCE_AMOUNT = :financeAmount, FINANCING_AMOUNT = :financingAmount, TENOR_IN_DAYS = :tenorInDays, INT_PERIOD_IN_DAYS = :intPeriodInDays, CONTRACT_PERIOD = :contractPeriod, TNX_DISPLAY_REMARKS = :tnxDisplayRemarks, TNX_DISPLAY_STATUS = :tnxDisplayStatus, MATURITY_DATE = :maturityDate, LIMIT_NODE_REFERENCE2 = :limitNodeReference2, BATCH_DISPLAY_STATUS = :batchDisplayStatus, BATCH_DISPLAY_REMARKS = :batchDisplayRemarks, REQUEST_INITIATION_TYPE = :requestInitiationType, LOAN_REQUEST_TYPE = :loanRequestType, LAYOUT_UUID = :layoutUuid, BATCH_STATUS = :batchStatus, PRODUCT_STATUS = :productStatus, TOTAL_COUNT = :totalCount, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, LAYOUT_ID = :layoutId, CUSTOMER_ROLE = :customerRole, CP_CODE = :cpCode, BATCH_ACTION = :batchAction, UPLOAD_REF_ID = :uploadRefId, OWNER_PARTY = :ownerParty, APPLICANT_NAME = :applicantName, FILE_NAME = :fileName, FINANCE_PARTY = :financeParty, CP_NAME = :cpName, ANCHOR_NAME = :anchorName WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FinReqBatch> finreqbatchs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FIN_REQ_BATCH WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FIN_REQ_BATCH WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FinReqBatch records by their IDs.
     */
    @SqlQuery("SELECT * FROM FIN_REQ_BATCH WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FinReqBatch.class)
    public List<FinReqBatch> findByIds(@BindList("ids") Collection<String> ids);
}
