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
import com.bsit.codegeneration.entity.FgTrdElcView;

public interface FgTrdElcViewDao {

    /**
     * Inserts a new FgTrdElcView and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_ELC_VIEW (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, KOTAK_BILL_REF_ID, ISS_BANK_LC_REF_ID, TENOR, CUR_CODE, LODGE_DATE, OUTSTANDING_AMT, DSP_AMT, DEDUCTION, REASON, APPLICANT_NAME, APPLICANT_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :kotakBillRefId, :issBankLcRefId, :tenor, :curCode, :lodgeDate, :outstandingAmt, :dspAmt, :deduction, :reason, :applicantName, :applicantParty)")
    public int insert(@BindBean FgTrdElcView fgtrdelcview);

    /**
     * Finds a FgTrdElcView by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ELC_VIEW WHERE FG_TRD_ELC_VIEW_id = :id")
    @RegisterBeanMapper(FgTrdElcView.class)
    public Optional<FgTrdElcView> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ELC_VIEW")
    @RegisterBeanMapper(FgTrdElcView.class)
    public List<FgTrdElcView> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ELC_VIEW ORDER BY FG_TRD_ELC_VIEW_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdElcView.class)
    public List<FgTrdElcView> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdElcView and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_ELC_VIEW SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, KOTAK_BILL_REF_ID = :kotakBillRefId, ISS_BANK_LC_REF_ID = :issBankLcRefId, TENOR = :tenor, CUR_CODE = :curCode, LODGE_DATE = :lodgeDate, OUTSTANDING_AMT = :outstandingAmt, DSP_AMT = :dspAmt, DEDUCTION = :deduction, REASON = :reason, APPLICANT_NAME = :applicantName, APPLICANT_PARTY = :applicantParty WHERE FG_TRD_ELC_VIEW_id = :fgTrdElcViewId")
    public int update(@BindBean FgTrdElcView fgtrdelcview);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_ELC_VIEW WHERE FG_TRD_ELC_VIEW_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_ELC_VIEW")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdElcView entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_ELC_VIEW (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, KOTAK_BILL_REF_ID, ISS_BANK_LC_REF_ID, TENOR, CUR_CODE, LODGE_DATE, OUTSTANDING_AMT, DSP_AMT, DEDUCTION, REASON, APPLICANT_NAME, APPLICANT_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :kotakBillRefId, :issBankLcRefId, :tenor, :curCode, :lodgeDate, :outstandingAmt, :dspAmt, :deduction, :reason, :applicantName, :applicantParty)")
    public int[] bulkInsert(@BindBean List<FgTrdElcView> fgtrdelcviews);

    /**
     * Bulk update multiple FgTrdElcView entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_ELC_VIEW SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, KOTAK_BILL_REF_ID = :kotakBillRefId, ISS_BANK_LC_REF_ID = :issBankLcRefId, TENOR = :tenor, CUR_CODE = :curCode, LODGE_DATE = :lodgeDate, OUTSTANDING_AMT = :outstandingAmt, DSP_AMT = :dspAmt, DEDUCTION = :deduction, REASON = :reason, APPLICANT_NAME = :applicantName, APPLICANT_PARTY = :applicantParty WHERE FG_TRD_ELC_VIEW_id = :fgTrdElcViewId")
    public int[] bulkUpdate(@BindBean List<FgTrdElcView> fgtrdelcviews);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_ELC_VIEW WHERE FG_TRD_ELC_VIEW_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_ELC_VIEW WHERE FG_TRD_ELC_VIEW_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgTrdElcView records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ELC_VIEW WHERE FG_TRD_ELC_VIEW_id IN (<ids>)")
    @RegisterBeanMapper(FgTrdElcView.class)
    public List<FgTrdElcView> findByIds(@BindList("ids") Collection<Integer> ids);
}
