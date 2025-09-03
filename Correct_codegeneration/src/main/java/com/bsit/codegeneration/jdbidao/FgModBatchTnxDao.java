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
import com.bsit.codegeneration.entity.FgModBatchTnx;

public interface FgModBatchTnxDao {

    /**
     * Inserts a new FgModBatchTnx and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_BATCH_TNX (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, PARENT_REF_ID, PARENT_REF_VERSION_ID, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_VERSION_ID, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :parentRefId, :parentRefVersionId, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :parentVersionId, :isTemplate, :entityRefId, :entitySubTypeCode, :entityTypeCode, :entityVersionId)")
    public int insert(@BindBean FgModBatchTnx fgmodbatchtnx);

    /**
     * Finds a FgModBatchTnx by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BATCH_TNX WHERE FG_MOD_BATCH_TNX_id = :id")
    @RegisterBeanMapper(FgModBatchTnx.class)
    public Optional<FgModBatchTnx> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BATCH_TNX")
    @RegisterBeanMapper(FgModBatchTnx.class)
    public List<FgModBatchTnx> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BATCH_TNX ORDER BY FG_MOD_BATCH_TNX_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModBatchTnx.class)
    public List<FgModBatchTnx> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModBatchTnx and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_BATCH_TNX SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PARENT_REF_ID = :parentRefId, PARENT_REF_VERSION_ID = :parentRefVersionId, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, ENTITY_REF_ID = :entityRefId, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_VERSION_ID = :entityVersionId WHERE FG_MOD_BATCH_TNX_id = :fgModBatchTnxId")
    public int update(@BindBean FgModBatchTnx fgmodbatchtnx);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_BATCH_TNX WHERE FG_MOD_BATCH_TNX_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_BATCH_TNX")
    public long countAll();

    /**
     * Bulk insert multiple FgModBatchTnx entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_BATCH_TNX (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, PARENT_REF_ID, PARENT_REF_VERSION_ID, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, PARENT_VERSION_ID, IS_TEMPLATE, ENTITY_REF_ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :parentRefId, :parentRefVersionId, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :parentVersionId, :isTemplate, :entityRefId, :entitySubTypeCode, :entityTypeCode, :entityVersionId)")
    public int[] bulkInsert(@BindBean List<FgModBatchTnx> fgmodbatchtnxs);

    /**
     * Bulk update multiple FgModBatchTnx entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_BATCH_TNX SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PARENT_REF_ID = :parentRefId, PARENT_REF_VERSION_ID = :parentRefVersionId, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, PARENT_VERSION_ID = :parentVersionId, IS_TEMPLATE = :isTemplate, ENTITY_REF_ID = :entityRefId, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_VERSION_ID = :entityVersionId WHERE FG_MOD_BATCH_TNX_id = :fgModBatchTnxId")
    public int[] bulkUpdate(@BindBean List<FgModBatchTnx> fgmodbatchtnxs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_BATCH_TNX WHERE FG_MOD_BATCH_TNX_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_BATCH_TNX WHERE FG_MOD_BATCH_TNX_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgModBatchTnx records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_BATCH_TNX WHERE FG_MOD_BATCH_TNX_id IN (<ids>)")
    @RegisterBeanMapper(FgModBatchTnx.class)
    public List<FgModBatchTnx> findByIds(@BindList("ids") Collection<Integer> ids);
}
