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
import com.bsit.codegeneration.entity.FgDeductReasonMaster;

public interface FgDeductReasonMasterDao {

    /**
     * Inserts a new FgDeductReasonMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_DEDUCT_REASON_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, REASON) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :reason)")
    public int insert(@BindBean FgDeductReasonMaster fgdeductreasonmaster);

    /**
     * Finds a FgDeductReasonMaster by its ID.
     */
    @SqlQuery("SELECT * FROM FG_DEDUCT_REASON_MASTER WHERE ID = :id")
    @RegisterBeanMapper(FgDeductReasonMaster.class)
    public Optional<FgDeductReasonMaster> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_DEDUCT_REASON_MASTER")
    @RegisterBeanMapper(FgDeductReasonMaster.class)
    public List<FgDeductReasonMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_DEDUCT_REASON_MASTER ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgDeductReasonMaster.class)
    public List<FgDeductReasonMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgDeductReasonMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_DEDUCT_REASON_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, REASON = :reason WHERE ID = :id")
    public int update(@BindBean FgDeductReasonMaster fgdeductreasonmaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DEDUCT_REASON_MASTER WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_DEDUCT_REASON_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple FgDeductReasonMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_DEDUCT_REASON_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, REASON) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :reason)")
    public int[] bulkInsert(@BindBean List<FgDeductReasonMaster> fgdeductreasonmasters);

    /**
     * Bulk update multiple FgDeductReasonMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_DEDUCT_REASON_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, REASON = :reason WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgDeductReasonMaster> fgdeductreasonmasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_DEDUCT_REASON_MASTER WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_DEDUCT_REASON_MASTER WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgDeductReasonMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_DEDUCT_REASON_MASTER WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgDeductReasonMaster.class)
    public List<FgDeductReasonMaster> findByIds(@BindList("ids") Collection<String> ids);
}
