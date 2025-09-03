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
import com.bsit.codegeneration.entity.FgProductStageHistory;

public interface FgProductStageHistoryDao {

    /**
     * Inserts a new FgProductStageHistory and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PRODUCT_STAGE_HISTORY (ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, WF_PROCESS_ID, WF_DEFINITION_ID, ENTITY_REF_ID, ENTITY_VERSION_NO, STAGE_CODE, PERF_PTY_SUBTYP_CODE, PERF_PTY_TYP_CODE, PARTY_CODE, PERF_PTY_ROLE_CODE, STP, STAGE_ORDER_IDX, STAGE_START_TIME, STAGE_END_TIME, WF_PROCESS_STATUS_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, PERF_PTY_FIELD_CODE, UPLOAD_REF_ID, ID) VALUES (:entityTypeCode, :entitySubTypeCode, :wfProcessId, :wfDefinitionId, :entityRefId, :entityVersionNo, :stageCode, :perfPtySubtypCode, :perfPtyTypCode, :partyCode, :perfPtyRoleCode, :stp, :stageOrderIdx, :stageStartTime, :stageEndTime, :wfProcessStatusCode, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn, :perfPtyFieldCode, :uploadRefId, :id)")
    public int insert(@BindBean FgProductStageHistory fgproductstagehistory);

    /**
     * Finds a FgProductStageHistory by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_STAGE_HISTORY WHERE FG_PRODUCT_STAGE_HISTORY_id = :id")
    @RegisterBeanMapper(FgProductStageHistory.class)
    public Optional<FgProductStageHistory> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_STAGE_HISTORY")
    @RegisterBeanMapper(FgProductStageHistory.class)
    public List<FgProductStageHistory> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_STAGE_HISTORY ORDER BY FG_PRODUCT_STAGE_HISTORY_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgProductStageHistory.class)
    public List<FgProductStageHistory> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgProductStageHistory and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PRODUCT_STAGE_HISTORY SET ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, WF_PROCESS_ID = :wfProcessId, WF_DEFINITION_ID = :wfDefinitionId, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_NO = :entityVersionNo, STAGE_CODE = :stageCode, PERF_PTY_SUBTYP_CODE = :perfPtySubtypCode, PERF_PTY_TYP_CODE = :perfPtyTypCode, PARTY_CODE = :partyCode, PERF_PTY_ROLE_CODE = :perfPtyRoleCode, STP = :stp, STAGE_ORDER_IDX = :stageOrderIdx, STAGE_START_TIME = :stageStartTime, STAGE_END_TIME = :stageEndTime, WF_PROCESS_STATUS_CODE = :wfProcessStatusCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, PERF_PTY_FIELD_CODE = :perfPtyFieldCode, UPLOAD_REF_ID = :uploadRefId, ID = :id WHERE FG_PRODUCT_STAGE_HISTORY_id = :fgProductStageHistoryId")
    public int update(@BindBean FgProductStageHistory fgproductstagehistory);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_STAGE_HISTORY WHERE FG_PRODUCT_STAGE_HISTORY_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PRODUCT_STAGE_HISTORY")
    public long countAll();

    /**
     * Bulk insert multiple FgProductStageHistory entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PRODUCT_STAGE_HISTORY (ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, WF_PROCESS_ID, WF_DEFINITION_ID, ENTITY_REF_ID, ENTITY_VERSION_NO, STAGE_CODE, PERF_PTY_SUBTYP_CODE, PERF_PTY_TYP_CODE, PARTY_CODE, PERF_PTY_ROLE_CODE, STP, STAGE_ORDER_IDX, STAGE_START_TIME, STAGE_END_TIME, WF_PROCESS_STATUS_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, PERF_PTY_FIELD_CODE, UPLOAD_REF_ID, ID) VALUES (:entityTypeCode, :entitySubTypeCode, :wfProcessId, :wfDefinitionId, :entityRefId, :entityVersionNo, :stageCode, :perfPtySubtypCode, :perfPtyTypCode, :partyCode, :perfPtyRoleCode, :stp, :stageOrderIdx, :stageStartTime, :stageEndTime, :wfProcessStatusCode, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn, :perfPtyFieldCode, :uploadRefId, :id)")
    public int[] bulkInsert(@BindBean List<FgProductStageHistory> fgproductstagehistorys);

    /**
     * Bulk update multiple FgProductStageHistory entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PRODUCT_STAGE_HISTORY SET ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, WF_PROCESS_ID = :wfProcessId, WF_DEFINITION_ID = :wfDefinitionId, ENTITY_REF_ID = :entityRefId, ENTITY_VERSION_NO = :entityVersionNo, STAGE_CODE = :stageCode, PERF_PTY_SUBTYP_CODE = :perfPtySubtypCode, PERF_PTY_TYP_CODE = :perfPtyTypCode, PARTY_CODE = :partyCode, PERF_PTY_ROLE_CODE = :perfPtyRoleCode, STP = :stp, STAGE_ORDER_IDX = :stageOrderIdx, STAGE_START_TIME = :stageStartTime, STAGE_END_TIME = :stageEndTime, WF_PROCESS_STATUS_CODE = :wfProcessStatusCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, PERF_PTY_FIELD_CODE = :perfPtyFieldCode, UPLOAD_REF_ID = :uploadRefId, ID = :id WHERE FG_PRODUCT_STAGE_HISTORY_id = :fgProductStageHistoryId")
    public int[] bulkUpdate(@BindBean List<FgProductStageHistory> fgproductstagehistorys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PRODUCT_STAGE_HISTORY WHERE FG_PRODUCT_STAGE_HISTORY_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PRODUCT_STAGE_HISTORY WHERE FG_PRODUCT_STAGE_HISTORY_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgProductStageHistory records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PRODUCT_STAGE_HISTORY WHERE FG_PRODUCT_STAGE_HISTORY_id IN (<ids>)")
    @RegisterBeanMapper(FgProductStageHistory.class)
    public List<FgProductStageHistory> findByIds(@BindList("ids") Collection<Integer> ids);
}
