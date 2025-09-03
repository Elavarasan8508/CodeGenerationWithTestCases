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
import com.bsit.codegeneration.entity.FgFinanceReverseUpdate;

public interface FgFinanceReverseUpdateDao {

    /**
     * Inserts a new FgFinanceReverseUpdate and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_FINANCE_REVERSE_UPDATE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, FIN_FILE_CONTENT, UPLOAD_REF_ID, FINANCE_FILE_NAME, BATCH_REF_ID, EVENT_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantPartyCode, :issuingPartyCode, :isTemplate, :finFileContent, :uploadRefId, :financeFileName, :batchRefId, :eventName)")
    public int insert(@BindBean FgFinanceReverseUpdate fgfinancereverseupdate);

    /**
     * Finds a FgFinanceReverseUpdate by its ID.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_REVERSE_UPDATE WHERE ID = :id")
    @RegisterBeanMapper(FgFinanceReverseUpdate.class)
    public Optional<FgFinanceReverseUpdate> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_REVERSE_UPDATE")
    @RegisterBeanMapper(FgFinanceReverseUpdate.class)
    public List<FgFinanceReverseUpdate> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_REVERSE_UPDATE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgFinanceReverseUpdate.class)
    public List<FgFinanceReverseUpdate> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgFinanceReverseUpdate and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_FINANCE_REVERSE_UPDATE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, IS_TEMPLATE = :isTemplate, FIN_FILE_CONTENT = :finFileContent, UPLOAD_REF_ID = :uploadRefId, FINANCE_FILE_NAME = :financeFileName, BATCH_REF_ID = :batchRefId, EVENT_NAME = :eventName WHERE ID = :id")
    public int update(@BindBean FgFinanceReverseUpdate fgfinancereverseupdate);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FINANCE_REVERSE_UPDATE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_FINANCE_REVERSE_UPDATE")
    public long countAll();

    /**
     * Bulk insert multiple FgFinanceReverseUpdate entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_FINANCE_REVERSE_UPDATE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, FIN_FILE_CONTENT, UPLOAD_REF_ID, FINANCE_FILE_NAME, BATCH_REF_ID, EVENT_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantPartyCode, :issuingPartyCode, :isTemplate, :finFileContent, :uploadRefId, :financeFileName, :batchRefId, :eventName)")
    public int[] bulkInsert(@BindBean List<FgFinanceReverseUpdate> fgfinancereverseupdates);

    /**
     * Bulk update multiple FgFinanceReverseUpdate entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_FINANCE_REVERSE_UPDATE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY_CODE = :applicantPartyCode, ISSUING_PARTY_CODE = :issuingPartyCode, IS_TEMPLATE = :isTemplate, FIN_FILE_CONTENT = :finFileContent, UPLOAD_REF_ID = :uploadRefId, FINANCE_FILE_NAME = :financeFileName, BATCH_REF_ID = :batchRefId, EVENT_NAME = :eventName WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgFinanceReverseUpdate> fgfinancereverseupdates);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_FINANCE_REVERSE_UPDATE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_FINANCE_REVERSE_UPDATE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgFinanceReverseUpdate records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_FINANCE_REVERSE_UPDATE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgFinanceReverseUpdate.class)
    public List<FgFinanceReverseUpdate> findByIds(@BindList("ids") Collection<String> ids);
}
