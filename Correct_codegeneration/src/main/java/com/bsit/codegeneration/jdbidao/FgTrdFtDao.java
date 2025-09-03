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
import com.bsit.codegeneration.entity.FgTrdFt;

public interface FgTrdFtDao {

    /**
     * Inserts a new FgTrdFt and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_FT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUR_CODE, LODGE_DATE, DRAWEE, OUTSTANDING_AMT, OUTSTANDING_AMT_SETTLED, DSP_AMT, DEDUCTION, REASON, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, OCF_REF_ID, APPLICANT_PARTY, BILL_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :curCode, :lodgeDate, :drawee, :outstandingAmt, :outstandingAmtSettled, :dspAmt, :deduction, :reason, :parentRefId, :parentVersionId, :irReferenceId, :ocfRefId, :applicantParty, :billRefId)")
    public int insert(@BindBean FgTrdFt fgtrdft);

    /**
     * Finds a FgTrdFt by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FT WHERE ID = :id")
    @RegisterBeanMapper(FgTrdFt.class)
    public Optional<FgTrdFt> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FT")
    @RegisterBeanMapper(FgTrdFt.class)
    public List<FgTrdFt> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdFt.class)
    public List<FgTrdFt> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdFt and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_FT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUR_CODE = :curCode, LODGE_DATE = :lodgeDate, DRAWEE = :drawee, OUTSTANDING_AMT = :outstandingAmt, OUTSTANDING_AMT_SETTLED = :outstandingAmtSettled, DSP_AMT = :dspAmt, DEDUCTION = :deduction, REASON = :reason, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IR_REFERENCE_ID = :irReferenceId, OCF_REF_ID = :ocfRefId, APPLICANT_PARTY = :applicantParty, BILL_REF_ID = :billRefId WHERE ID = :id")
    public int update(@BindBean FgTrdFt fgtrdft);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_FT WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_FT")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdFt entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_FT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUR_CODE, LODGE_DATE, DRAWEE, OUTSTANDING_AMT, OUTSTANDING_AMT_SETTLED, DSP_AMT, DEDUCTION, REASON, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, OCF_REF_ID, APPLICANT_PARTY, BILL_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :curCode, :lodgeDate, :drawee, :outstandingAmt, :outstandingAmtSettled, :dspAmt, :deduction, :reason, :parentRefId, :parentVersionId, :irReferenceId, :ocfRefId, :applicantParty, :billRefId)")
    public int[] bulkInsert(@BindBean List<FgTrdFt> fgtrdfts);

    /**
     * Bulk update multiple FgTrdFt entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_FT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUR_CODE = :curCode, LODGE_DATE = :lodgeDate, DRAWEE = :drawee, OUTSTANDING_AMT = :outstandingAmt, OUTSTANDING_AMT_SETTLED = :outstandingAmtSettled, DSP_AMT = :dspAmt, DEDUCTION = :deduction, REASON = :reason, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IR_REFERENCE_ID = :irReferenceId, OCF_REF_ID = :ocfRefId, APPLICANT_PARTY = :applicantParty, BILL_REF_ID = :billRefId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdFt> fgtrdfts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_FT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_FT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdFt records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_FT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdFt.class)
    public List<FgTrdFt> findByIds(@BindList("ids") Collection<String> ids);
}
