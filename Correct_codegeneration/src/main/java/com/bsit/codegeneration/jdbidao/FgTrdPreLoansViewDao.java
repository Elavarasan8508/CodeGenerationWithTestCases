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
import com.bsit.codegeneration.entity.FgTrdPreLoansView;

public interface FgTrdPreLoansViewDao {

    /**
     * Inserts a new FgTrdPreLoansView and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_PRE_LOANS_VIEW (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PRE_LOAN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, IN_LOAN_CUR, DSP_AMT, EQU_DSP_AMT, APPLICANT_PARTY, DISB_DATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :preLoanRefId, :loanRefId, :curCode, :principalOutstanding, :inLoanCur, :dspAmt, :equDspAmt, :applicantParty, :disbDate)")
    public int insert(@BindBean FgTrdPreLoansView fgtrdpreloansview);

    /**
     * Finds a FgTrdPreLoansView by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_PRE_LOANS_VIEW WHERE FG_TRD_PRE_LOANS_VIEW_id = :id")
    @RegisterBeanMapper(FgTrdPreLoansView.class)
    public Optional<FgTrdPreLoansView> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_PRE_LOANS_VIEW")
    @RegisterBeanMapper(FgTrdPreLoansView.class)
    public List<FgTrdPreLoansView> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_PRE_LOANS_VIEW ORDER BY FG_TRD_PRE_LOANS_VIEW_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdPreLoansView.class)
    public List<FgTrdPreLoansView> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdPreLoansView and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_PRE_LOANS_VIEW SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PRE_LOAN_REF_ID = :preLoanRefId, LOAN_REF_ID = :loanRefId, CUR_CODE = :curCode, PRINCIPAL_OUTSTANDING = :principalOutstanding, IN_LOAN_CUR = :inLoanCur, DSP_AMT = :dspAmt, EQU_DSP_AMT = :equDspAmt, APPLICANT_PARTY = :applicantParty, DISB_DATE = :disbDate WHERE FG_TRD_PRE_LOANS_VIEW_id = :fgTrdPreLoansViewId")
    public int update(@BindBean FgTrdPreLoansView fgtrdpreloansview);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_PRE_LOANS_VIEW WHERE FG_TRD_PRE_LOANS_VIEW_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_PRE_LOANS_VIEW")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdPreLoansView entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_PRE_LOANS_VIEW (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PRE_LOAN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, IN_LOAN_CUR, DSP_AMT, EQU_DSP_AMT, APPLICANT_PARTY, DISB_DATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :preLoanRefId, :loanRefId, :curCode, :principalOutstanding, :inLoanCur, :dspAmt, :equDspAmt, :applicantParty, :disbDate)")
    public int[] bulkInsert(@BindBean List<FgTrdPreLoansView> fgtrdpreloansviews);

    /**
     * Bulk update multiple FgTrdPreLoansView entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_PRE_LOANS_VIEW SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PRE_LOAN_REF_ID = :preLoanRefId, LOAN_REF_ID = :loanRefId, CUR_CODE = :curCode, PRINCIPAL_OUTSTANDING = :principalOutstanding, IN_LOAN_CUR = :inLoanCur, DSP_AMT = :dspAmt, EQU_DSP_AMT = :equDspAmt, APPLICANT_PARTY = :applicantParty, DISB_DATE = :disbDate WHERE FG_TRD_PRE_LOANS_VIEW_id = :fgTrdPreLoansViewId")
    public int[] bulkUpdate(@BindBean List<FgTrdPreLoansView> fgtrdpreloansviews);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_PRE_LOANS_VIEW WHERE FG_TRD_PRE_LOANS_VIEW_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_PRE_LOANS_VIEW WHERE FG_TRD_PRE_LOANS_VIEW_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgTrdPreLoansView records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_PRE_LOANS_VIEW WHERE FG_TRD_PRE_LOANS_VIEW_id IN (<ids>)")
    @RegisterBeanMapper(FgTrdPreLoansView.class)
    public List<FgTrdPreLoansView> findByIds(@BindList("ids") Collection<Integer> ids);
}
