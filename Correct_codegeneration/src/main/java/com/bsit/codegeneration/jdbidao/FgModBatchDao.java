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
import com.bsit.codegeneration.entity.FgModBatch;

public interface FgModBatchDao {

    /**
     * Inserts a new FgModBatch and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_BATCH (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, PROCESS_ID, COMMENTS, PURPOSE_CODE, TOTAL_AMOUNT, TOTAL_COUNT, SOURCE_REF_ID, APPLICANT_PARTY_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :versionId, :isMasterVersion, :processId, :comments, :purposeCode, :totalAmount, :totalCount, :sourceRefId, :applicantPartyCode, :financeDisplayStatus, :programCode)")
    public int insert(@BindBean FgModBatch fgmodbatch);

    /**
     * Finds a FgModBatch by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BATCH WHERE FG_MOD_BATCH_id = :id")
    @RegisterBeanMapper(FgModBatch.class)
    public Optional<FgModBatch> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BATCH")
    @RegisterBeanMapper(FgModBatch.class)
    public List<FgModBatch> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BATCH ORDER BY FG_MOD_BATCH_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModBatch.class)
    public List<FgModBatch> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModBatch and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_BATCH SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, PROCESS_ID = :processId, COMMENTS = :comments, PURPOSE_CODE = :purposeCode, TOTAL_AMOUNT = :totalAmount, TOTAL_COUNT = :totalCount, SOURCE_REF_ID = :sourceRefId, APPLICANT_PARTY_CODE = :applicantPartyCode, FINANCE_DISPLAY_STATUS = :financeDisplayStatus, PROGRAM_CODE = :programCode WHERE FG_MOD_BATCH_id = :fgModBatchId")
    public int update(@BindBean FgModBatch fgmodbatch);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_BATCH WHERE FG_MOD_BATCH_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_BATCH")
    public long countAll();

    /**
     * Bulk insert multiple FgModBatch entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_BATCH (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, VERSION_ID, IS_MASTER_VERSION, PROCESS_ID, COMMENTS, PURPOSE_CODE, TOTAL_AMOUNT, TOTAL_COUNT, SOURCE_REF_ID, APPLICANT_PARTY_CODE, FINANCE_DISPLAY_STATUS, PROGRAM_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :versionId, :isMasterVersion, :processId, :comments, :purposeCode, :totalAmount, :totalCount, :sourceRefId, :applicantPartyCode, :financeDisplayStatus, :programCode)")
    public int[] bulkInsert(@BindBean List<FgModBatch> fgmodbatchs);

    /**
     * Bulk update multiple FgModBatch entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_BATCH SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, PROCESS_ID = :processId, COMMENTS = :comments, PURPOSE_CODE = :purposeCode, TOTAL_AMOUNT = :totalAmount, TOTAL_COUNT = :totalCount, SOURCE_REF_ID = :sourceRefId, APPLICANT_PARTY_CODE = :applicantPartyCode, FINANCE_DISPLAY_STATUS = :financeDisplayStatus, PROGRAM_CODE = :programCode WHERE FG_MOD_BATCH_id = :fgModBatchId")
    public int[] bulkUpdate(@BindBean List<FgModBatch> fgmodbatchs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_BATCH WHERE FG_MOD_BATCH_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_BATCH WHERE FG_MOD_BATCH_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgModBatch records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BATCH WHERE FG_MOD_BATCH_id IN (<ids>)")
    @RegisterBeanMapper(FgModBatch.class)
    public List<FgModBatch> findByIds(@BindList("ids") Collection<Integer> ids);
}
