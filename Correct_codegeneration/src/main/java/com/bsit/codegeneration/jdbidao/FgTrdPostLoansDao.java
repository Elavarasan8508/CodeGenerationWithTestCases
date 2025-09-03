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
import com.bsit.codegeneration.entity.FgTrdPostLoans;

public interface FgTrdPostLoansDao {

    /**
     * Inserts a new FgTrdPostLoans and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_POST_LOANS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, POST_LOAN_REF_ID, TXN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, DSP_AMT, EQU_DSP_AMT, COLLECT_SHORT, ACC_NO, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_PARTY, BILL_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :postLoanRefId, :txnRefId, :loanRefId, :curCode, :principalOutstanding, :dspAmt, :equDspAmt, :collectShort, :accNo, :parentRefId, :parentVersionId, :irReferenceId, :applicantParty, :billRefId)")
    public int insert(@BindBean FgTrdPostLoans fgtrdpostloans);

    /**
     * Finds a FgTrdPostLoans by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_POST_LOANS WHERE ID = :id")
    @RegisterBeanMapper(FgTrdPostLoans.class)
    public Optional<FgTrdPostLoans> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_POST_LOANS")
    @RegisterBeanMapper(FgTrdPostLoans.class)
    public List<FgTrdPostLoans> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_POST_LOANS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdPostLoans.class)
    public List<FgTrdPostLoans> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdPostLoans and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_POST_LOANS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, POST_LOAN_REF_ID = :postLoanRefId, TXN_REF_ID = :txnRefId, LOAN_REF_ID = :loanRefId, CUR_CODE = :curCode, PRINCIPAL_OUTSTANDING = :principalOutstanding, DSP_AMT = :dspAmt, EQU_DSP_AMT = :equDspAmt, COLLECT_SHORT = :collectShort, ACC_NO = :accNo, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IR_REFERENCE_ID = :irReferenceId, APPLICANT_PARTY = :applicantParty, BILL_REF_ID = :billRefId WHERE ID = :id")
    public int update(@BindBean FgTrdPostLoans fgtrdpostloans);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_POST_LOANS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_POST_LOANS")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdPostLoans entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_POST_LOANS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, POST_LOAN_REF_ID, TXN_REF_ID, LOAN_REF_ID, CUR_CODE, PRINCIPAL_OUTSTANDING, DSP_AMT, EQU_DSP_AMT, COLLECT_SHORT, ACC_NO, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_PARTY, BILL_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :postLoanRefId, :txnRefId, :loanRefId, :curCode, :principalOutstanding, :dspAmt, :equDspAmt, :collectShort, :accNo, :parentRefId, :parentVersionId, :irReferenceId, :applicantParty, :billRefId)")
    public int[] bulkInsert(@BindBean List<FgTrdPostLoans> fgtrdpostloanss);

    /**
     * Bulk update multiple FgTrdPostLoans entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_POST_LOANS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, POST_LOAN_REF_ID = :postLoanRefId, TXN_REF_ID = :txnRefId, LOAN_REF_ID = :loanRefId, CUR_CODE = :curCode, PRINCIPAL_OUTSTANDING = :principalOutstanding, DSP_AMT = :dspAmt, EQU_DSP_AMT = :equDspAmt, COLLECT_SHORT = :collectShort, ACC_NO = :accNo, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IR_REFERENCE_ID = :irReferenceId, APPLICANT_PARTY = :applicantParty, BILL_REF_ID = :billRefId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdPostLoans> fgtrdpostloanss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_POST_LOANS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_POST_LOANS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdPostLoans records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_POST_LOANS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdPostLoans.class)
    public List<FgTrdPostLoans> findByIds(@BindList("ids") Collection<String> ids);
}
