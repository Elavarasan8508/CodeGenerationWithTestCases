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
import com.bsit.codegeneration.entity.FgProductStage;

public interface FgProductStageDao {

    /**
     * Inserts a new FgProductStage and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PRODUCT_STAGE (ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, STAGE_CODE, PERF_PTY_SUBTYP_CODE, PERF_PTY_TYP_CODE, PERF_PTY_ROLE_CODE, STP, STAGE_ORDER_IDX, AUTO_SUBMIT, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_REF_ID, AUTH_STATUS_CODE, TNX_STATUS_CODE, AUTHORIZATION, ENTITY_VERSION_ID, AUTO_AUTHORISE, PERF_PTY_FIELD_CODE, UPLOAD_REF_ID, ID) VALUES (:entityTypeCode, :entitySubTypeCode, :stageCode, :perfPtySubtypCode, :perfPtyTypCode, :perfPtyRoleCode, :stp, :stageOrderIdx, :autoSubmit, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :entityRefId, :authStatusCode, :tnxStatusCode, :authorization, :entityVersionId, :autoAuthorise, :perfPtyFieldCode, :uploadRefId, :id)")
    public int insert(@BindBean FgProductStage fgproductstage);

    /**
     * Finds a FgProductStage by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_STAGE WHERE FG_PRODUCT_STAGE_id = :id")
    @RegisterBeanMapper(FgProductStage.class)
    public Optional<FgProductStage> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_STAGE")
    @RegisterBeanMapper(FgProductStage.class)
    public List<FgProductStage> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_STAGE ORDER BY FG_PRODUCT_STAGE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProductStage.class)
    public List<FgProductStage> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProductStage and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PRODUCT_STAGE SET ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, STAGE_CODE = :stageCode, PERF_PTY_SUBTYP_CODE = :perfPtySubtypCode, PERF_PTY_TYP_CODE = :perfPtyTypCode, PERF_PTY_ROLE_CODE = :perfPtyRoleCode, STP = :stp, STAGE_ORDER_IDX = :stageOrderIdx, AUTO_SUBMIT = :autoSubmit, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ENTITY_REF_ID = :entityRefId, AUTH_STATUS_CODE = :authStatusCode, TNX_STATUS_CODE = :tnxStatusCode, AUTHORIZATION = :authorization, ENTITY_VERSION_ID = :entityVersionId, AUTO_AUTHORISE = :autoAuthorise, PERF_PTY_FIELD_CODE = :perfPtyFieldCode, UPLOAD_REF_ID = :uploadRefId, ID = :id WHERE FG_PRODUCT_STAGE_id = :fgProductStageId")
    public int update(@BindBean FgProductStage fgproductstage);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_STAGE WHERE FG_PRODUCT_STAGE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PRODUCT_STAGE")
    public long countAll();

    /**
     * Bulk insert multiple FgProductStage entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PRODUCT_STAGE (ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, STAGE_CODE, PERF_PTY_SUBTYP_CODE, PERF_PTY_TYP_CODE, PERF_PTY_ROLE_CODE, STP, STAGE_ORDER_IDX, AUTO_SUBMIT, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_REF_ID, AUTH_STATUS_CODE, TNX_STATUS_CODE, AUTHORIZATION, ENTITY_VERSION_ID, AUTO_AUTHORISE, PERF_PTY_FIELD_CODE, UPLOAD_REF_ID, ID) VALUES (:entityTypeCode, :entitySubTypeCode, :stageCode, :perfPtySubtypCode, :perfPtyTypCode, :perfPtyRoleCode, :stp, :stageOrderIdx, :autoSubmit, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :entityRefId, :authStatusCode, :tnxStatusCode, :authorization, :entityVersionId, :autoAuthorise, :perfPtyFieldCode, :uploadRefId, :id)")
    public int[] bulkInsert(@BindBean List<FgProductStage> fgproductstages);

    /**
     * Bulk update multiple FgProductStage entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PRODUCT_STAGE SET ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, STAGE_CODE = :stageCode, PERF_PTY_SUBTYP_CODE = :perfPtySubtypCode, PERF_PTY_TYP_CODE = :perfPtyTypCode, PERF_PTY_ROLE_CODE = :perfPtyRoleCode, STP = :stp, STAGE_ORDER_IDX = :stageOrderIdx, AUTO_SUBMIT = :autoSubmit, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ENTITY_REF_ID = :entityRefId, AUTH_STATUS_CODE = :authStatusCode, TNX_STATUS_CODE = :tnxStatusCode, AUTHORIZATION = :authorization, ENTITY_VERSION_ID = :entityVersionId, AUTO_AUTHORISE = :autoAuthorise, PERF_PTY_FIELD_CODE = :perfPtyFieldCode, UPLOAD_REF_ID = :uploadRefId, ID = :id WHERE FG_PRODUCT_STAGE_id = :fgProductStageId")
    public int[] bulkUpdate(@BindBean List<FgProductStage> fgproductstages);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_STAGE WHERE FG_PRODUCT_STAGE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PRODUCT_STAGE WHERE FG_PRODUCT_STAGE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgProductStage records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_STAGE WHERE FG_PRODUCT_STAGE_id IN (<ids>)")
    @RegisterBeanMapper(FgProductStage.class)
    public List<FgProductStage> findByIds(@BindList("ids") Collection<Integer> ids);
}
