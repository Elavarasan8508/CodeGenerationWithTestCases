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
import com.bsit.codegeneration.entity.FgTrdFtView;

public interface FgTrdFtViewDao {

    /**
     * Inserts a new FgTrdFtView and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_FT_VIEW (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUR_CODE, LODGE_DATE, DRAWEE, OUTSTANDING_AMT, OUTSTANDING_AMT_SETTLED, DSP_AMT, DEDUCTION, REASON, OCF_REF_ID, APPLICANT_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :curCode, :lodgeDate, :drawee, :outstandingAmt, :outstandingAmtSettled, :dspAmt, :deduction, :reason, :ocfRefId, :applicantParty)")
    public int insert(@BindBean FgTrdFtView fgtrdftview);

    /**
     * Finds a FgTrdFtView by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FT_VIEW WHERE FG_TRD_FT_VIEW_id = :id")
    @RegisterBeanMapper(FgTrdFtView.class)
    public Optional<FgTrdFtView> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FT_VIEW")
    @RegisterBeanMapper(FgTrdFtView.class)
    public List<FgTrdFtView> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FT_VIEW ORDER BY FG_TRD_FT_VIEW_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdFtView.class)
    public List<FgTrdFtView> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdFtView and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_FT_VIEW SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUR_CODE = :curCode, LODGE_DATE = :lodgeDate, DRAWEE = :drawee, OUTSTANDING_AMT = :outstandingAmt, OUTSTANDING_AMT_SETTLED = :outstandingAmtSettled, DSP_AMT = :dspAmt, DEDUCTION = :deduction, REASON = :reason, OCF_REF_ID = :ocfRefId, APPLICANT_PARTY = :applicantParty WHERE FG_TRD_FT_VIEW_id = :fgTrdFtViewId")
    public int update(@BindBean FgTrdFtView fgtrdftview);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_FT_VIEW WHERE FG_TRD_FT_VIEW_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_FT_VIEW")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdFtView entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_FT_VIEW (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUR_CODE, LODGE_DATE, DRAWEE, OUTSTANDING_AMT, OUTSTANDING_AMT_SETTLED, DSP_AMT, DEDUCTION, REASON, OCF_REF_ID, APPLICANT_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :curCode, :lodgeDate, :drawee, :outstandingAmt, :outstandingAmtSettled, :dspAmt, :deduction, :reason, :ocfRefId, :applicantParty)")
    public int[] bulkInsert(@BindBean List<FgTrdFtView> fgtrdftviews);

    /**
     * Bulk update multiple FgTrdFtView entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_FT_VIEW SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUR_CODE = :curCode, LODGE_DATE = :lodgeDate, DRAWEE = :drawee, OUTSTANDING_AMT = :outstandingAmt, OUTSTANDING_AMT_SETTLED = :outstandingAmtSettled, DSP_AMT = :dspAmt, DEDUCTION = :deduction, REASON = :reason, OCF_REF_ID = :ocfRefId, APPLICANT_PARTY = :applicantParty WHERE FG_TRD_FT_VIEW_id = :fgTrdFtViewId")
    public int[] bulkUpdate(@BindBean List<FgTrdFtView> fgtrdftviews);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_FT_VIEW WHERE FG_TRD_FT_VIEW_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_FT_VIEW WHERE FG_TRD_FT_VIEW_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgTrdFtView records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FT_VIEW WHERE FG_TRD_FT_VIEW_id IN (<ids>)")
    @RegisterBeanMapper(FgTrdFtView.class)
    public List<FgTrdFtView> findByIds(@BindList("ids") Collection<Integer> ids);
}
