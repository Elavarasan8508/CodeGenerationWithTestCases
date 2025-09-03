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
import com.bsit.codegeneration.entity.FgTdLiqView;

public interface FgTdLiqViewDao {

    /**
     * Inserts a new FgTdLiqView and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_LIQ_VIEW (REFERENCE_ID, PRODUCT_STATUS, STATUS_CODE, STAGE_CODE, SUB_TYPE_CODE, TYPE_CODE, PROCESS_ID) VALUES (:referenceId, :productStatus, :statusCode, :stageCode, :subTypeCode, :typeCode, :processId)")
    public int insert(@BindBean FgTdLiqView fgtdliqview);

    /**
     * Finds a FgTdLiqView by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_LIQ_VIEW WHERE FG_TD_LIQ_VIEW_id = :id")
    @RegisterBeanMapper(FgTdLiqView.class)
    public Optional<FgTdLiqView> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_LIQ_VIEW")
    @RegisterBeanMapper(FgTdLiqView.class)
    public List<FgTdLiqView> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_LIQ_VIEW ORDER BY FG_TD_LIQ_VIEW_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdLiqView.class)
    public List<FgTdLiqView> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdLiqView and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_LIQ_VIEW SET REFERENCE_ID = :referenceId, PRODUCT_STATUS = :productStatus, STATUS_CODE = :statusCode, STAGE_CODE = :stageCode, SUB_TYPE_CODE = :subTypeCode, TYPE_CODE = :typeCode, PROCESS_ID = :processId WHERE FG_TD_LIQ_VIEW_id = :fgTdLiqViewId")
    public int update(@BindBean FgTdLiqView fgtdliqview);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_LIQ_VIEW WHERE FG_TD_LIQ_VIEW_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_LIQ_VIEW")
    public long countAll();

    /**
     * Bulk insert multiple FgTdLiqView entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_LIQ_VIEW (REFERENCE_ID, PRODUCT_STATUS, STATUS_CODE, STAGE_CODE, SUB_TYPE_CODE, TYPE_CODE, PROCESS_ID) VALUES (:referenceId, :productStatus, :statusCode, :stageCode, :subTypeCode, :typeCode, :processId)")
    public int[] bulkInsert(@BindBean List<FgTdLiqView> fgtdliqviews);

    /**
     * Bulk update multiple FgTdLiqView entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_LIQ_VIEW SET REFERENCE_ID = :referenceId, PRODUCT_STATUS = :productStatus, STATUS_CODE = :statusCode, STAGE_CODE = :stageCode, SUB_TYPE_CODE = :subTypeCode, TYPE_CODE = :typeCode, PROCESS_ID = :processId WHERE FG_TD_LIQ_VIEW_id = :fgTdLiqViewId")
    public int[] bulkUpdate(@BindBean List<FgTdLiqView> fgtdliqviews);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_LIQ_VIEW WHERE FG_TD_LIQ_VIEW_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_LIQ_VIEW WHERE FG_TD_LIQ_VIEW_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgTdLiqView records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_LIQ_VIEW WHERE FG_TD_LIQ_VIEW_id IN (<ids>)")
    @RegisterBeanMapper(FgTdLiqView.class)
    public List<FgTdLiqView> findByIds(@BindList("ids") Collection<Integer> ids);
}
