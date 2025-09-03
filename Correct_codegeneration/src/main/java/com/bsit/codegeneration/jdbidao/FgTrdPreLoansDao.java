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
import com.bsit.codegeneration.entity.FgTrdPreLoans;

public interface FgTrdPreLoansDao {

    /**
     * Inserts a new FgTrdPreLoans and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_PRE_LOANS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PRE_LOAN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, IN_LOAN_CUR, DSP_AMT, EQU_DSP_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, DISB_DATE, APPLICANT_PARTY, BILL_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :preLoanRefId, :loanRefId, :curCode, :principalOutstanding, :inLoanCur, :dspAmt, :equDspAmt, :parentRefId, :parentVersionId, :irReferenceId, :disbDate, :applicantParty, :billRefId)")
    public int insert(@BindBean FgTrdPreLoans fgtrdpreloans);

    /**
     * Finds a FgTrdPreLoans by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_PRE_LOANS WHERE ID = :id")
    @RegisterBeanMapper(FgTrdPreLoans.class)
    public Optional<FgTrdPreLoans> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_PRE_LOANS")
    @RegisterBeanMapper(FgTrdPreLoans.class)
    public List<FgTrdPreLoans> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_PRE_LOANS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdPreLoans.class)
    public List<FgTrdPreLoans> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdPreLoans and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_PRE_LOANS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PRE_LOAN_REF_ID = :preLoanRefId, LOAN_REF_ID = :loanRefId, CUR_CODE = :curCode, PRINCIPAL_OUTSTANDING = :principalOutstanding, IN_LOAN_CUR = :inLoanCur, DSP_AMT = :dspAmt, EQU_DSP_AMT = :equDspAmt, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IR_REFERENCE_ID = :irReferenceId, DISB_DATE = :disbDate, APPLICANT_PARTY = :applicantParty, BILL_REF_ID = :billRefId WHERE ID = :id")
    public int update(@BindBean FgTrdPreLoans fgtrdpreloans);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_PRE_LOANS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_PRE_LOANS")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdPreLoans entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_PRE_LOANS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PRE_LOAN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, IN_LOAN_CUR, DSP_AMT, EQU_DSP_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, DISB_DATE, APPLICANT_PARTY, BILL_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :preLoanRefId, :loanRefId, :curCode, :principalOutstanding, :inLoanCur, :dspAmt, :equDspAmt, :parentRefId, :parentVersionId, :irReferenceId, :disbDate, :applicantParty, :billRefId)")
    public int[] bulkInsert(@BindBean List<FgTrdPreLoans> fgtrdpreloanss);

    /**
     * Bulk update multiple FgTrdPreLoans entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_PRE_LOANS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PRE_LOAN_REF_ID = :preLoanRefId, LOAN_REF_ID = :loanRefId, CUR_CODE = :curCode, PRINCIPAL_OUTSTANDING = :principalOutstanding, IN_LOAN_CUR = :inLoanCur, DSP_AMT = :dspAmt, EQU_DSP_AMT = :equDspAmt, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IR_REFERENCE_ID = :irReferenceId, DISB_DATE = :disbDate, APPLICANT_PARTY = :applicantParty, BILL_REF_ID = :billRefId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdPreLoans> fgtrdpreloanss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_PRE_LOANS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_PRE_LOANS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdPreLoans records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_PRE_LOANS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdPreLoans.class)
    public List<FgTrdPreLoans> findByIds(@BindList("ids") Collection<String> ids);
}
