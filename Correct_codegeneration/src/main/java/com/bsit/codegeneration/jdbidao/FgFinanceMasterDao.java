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
import com.bsit.codegeneration.entity.FgFinanceMaster;

public interface FgFinanceMasterDao {

    /**
     * Inserts a new FgFinanceMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_FINANCE_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FILE_CONTENT, RETRIGGER_COUNT, UPLOAD_REF_ID, FINANCE_FILE_NAME, APPLICANT_PARTY_CODE, SEND_FINANCE_FILE, IS_FINANCE_SENT, FILE_NAME, REMARKS, CUTOFF_TIME, BATCH_REF_ID, BATCH_ACTION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :fileContent, :retriggerCount, :uploadRefId, :financeFileName, :applicantPartyCode, :sendFinanceFile, :isFinanceSent, :fileName, :remarks, :cutoffTime, :batchRefId, :batchAction)")
    public int insert(@BindBean FgFinanceMaster fgfinancemaster);

    /**
     * Finds a FgFinanceMaster by its ID.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_MASTER WHERE ID = :id")
    @RegisterBeanMapper(FgFinanceMaster.class)
    public Optional<FgFinanceMaster> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_MASTER")
    @RegisterBeanMapper(FgFinanceMaster.class)
    public List<FgFinanceMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_MASTER ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgFinanceMaster.class)
    public List<FgFinanceMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgFinanceMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_FINANCE_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, FILE_CONTENT = :fileContent, RETRIGGER_COUNT = :retriggerCount, UPLOAD_REF_ID = :uploadRefId, FINANCE_FILE_NAME = :financeFileName, APPLICANT_PARTY_CODE = :applicantPartyCode, SEND_FINANCE_FILE = :sendFinanceFile, IS_FINANCE_SENT = :isFinanceSent, FILE_NAME = :fileName, REMARKS = :remarks, CUTOFF_TIME = :cutoffTime, BATCH_REF_ID = :batchRefId, BATCH_ACTION = :batchAction WHERE ID = :id")
    public int update(@BindBean FgFinanceMaster fgfinancemaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FINANCE_MASTER WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_FINANCE_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple FgFinanceMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_FINANCE_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FILE_CONTENT, RETRIGGER_COUNT, UPLOAD_REF_ID, FINANCE_FILE_NAME, APPLICANT_PARTY_CODE, SEND_FINANCE_FILE, IS_FINANCE_SENT, FILE_NAME, REMARKS, CUTOFF_TIME, BATCH_REF_ID, BATCH_ACTION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :fileContent, :retriggerCount, :uploadRefId, :financeFileName, :applicantPartyCode, :sendFinanceFile, :isFinanceSent, :fileName, :remarks, :cutoffTime, :batchRefId, :batchAction)")
    public int[] bulkInsert(@BindBean List<FgFinanceMaster> fgfinancemasters);

    /**
     * Bulk update multiple FgFinanceMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_FINANCE_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, FILE_CONTENT = :fileContent, RETRIGGER_COUNT = :retriggerCount, UPLOAD_REF_ID = :uploadRefId, FINANCE_FILE_NAME = :financeFileName, APPLICANT_PARTY_CODE = :applicantPartyCode, SEND_FINANCE_FILE = :sendFinanceFile, IS_FINANCE_SENT = :isFinanceSent, FILE_NAME = :fileName, REMARKS = :remarks, CUTOFF_TIME = :cutoffTime, BATCH_REF_ID = :batchRefId, BATCH_ACTION = :batchAction WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgFinanceMaster> fgfinancemasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FINANCE_MASTER WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_FINANCE_MASTER WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgFinanceMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_MASTER WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgFinanceMaster.class)
    public List<FgFinanceMaster> findByIds(@BindList("ids") Collection<String> ids);
}
