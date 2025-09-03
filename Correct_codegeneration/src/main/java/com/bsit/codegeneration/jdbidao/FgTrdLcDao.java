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
import com.bsit.codegeneration.entity.FgTrdLc;

public interface FgTrdLcDao {

    /**
     * Inserts a new FgTrdLc and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_LC (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, KOTAK_BILL_REF_ID, ISS_BANK_LC_REF_ID, TENOR, CUR_CODE, LODGE_DATE, OUTSTANDING_AMT, DSP_AMT, DEDUCTION, REASON, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_NAME, ELC_REF_ID, APPLICANT_PARTY, BILL_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :kotakBillRefId, :issBankLcRefId, :tenor, :curCode, :lodgeDate, :outstandingAmt, :dspAmt, :deduction, :reason, :parentRefId, :parentVersionId, :irReferenceId, :applicantName, :elcRefId, :applicantParty, :billRefId)")
    public int insert(@BindBean FgTrdLc fgtrdlc);

    /**
     * Finds a FgTrdLc by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_LC WHERE ID = :id")
    @RegisterBeanMapper(FgTrdLc.class)
    public Optional<FgTrdLc> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_LC")
    @RegisterBeanMapper(FgTrdLc.class)
    public List<FgTrdLc> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_LC ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdLc.class)
    public List<FgTrdLc> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdLc and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_LC SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, KOTAK_BILL_REF_ID = :kotakBillRefId, ISS_BANK_LC_REF_ID = :issBankLcRefId, TENOR = :tenor, CUR_CODE = :curCode, LODGE_DATE = :lodgeDate, OUTSTANDING_AMT = :outstandingAmt, DSP_AMT = :dspAmt, DEDUCTION = :deduction, REASON = :reason, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IR_REFERENCE_ID = :irReferenceId, APPLICANT_NAME = :applicantName, ELC_REF_ID = :elcRefId, APPLICANT_PARTY = :applicantParty, BILL_REF_ID = :billRefId WHERE ID = :id")
    public int update(@BindBean FgTrdLc fgtrdlc);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_LC WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_LC")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdLc entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_LC (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, KOTAK_BILL_REF_ID, ISS_BANK_LC_REF_ID, TENOR, CUR_CODE, LODGE_DATE, OUTSTANDING_AMT, DSP_AMT, DEDUCTION, REASON, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_NAME, ELC_REF_ID, APPLICANT_PARTY, BILL_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :kotakBillRefId, :issBankLcRefId, :tenor, :curCode, :lodgeDate, :outstandingAmt, :dspAmt, :deduction, :reason, :parentRefId, :parentVersionId, :irReferenceId, :applicantName, :elcRefId, :applicantParty, :billRefId)")
    public int[] bulkInsert(@BindBean List<FgTrdLc> fgtrdlcs);

    /**
     * Bulk update multiple FgTrdLc entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_LC SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, KOTAK_BILL_REF_ID = :kotakBillRefId, ISS_BANK_LC_REF_ID = :issBankLcRefId, TENOR = :tenor, CUR_CODE = :curCode, LODGE_DATE = :lodgeDate, OUTSTANDING_AMT = :outstandingAmt, DSP_AMT = :dspAmt, DEDUCTION = :deduction, REASON = :reason, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IR_REFERENCE_ID = :irReferenceId, APPLICANT_NAME = :applicantName, ELC_REF_ID = :elcRefId, APPLICANT_PARTY = :applicantParty, BILL_REF_ID = :billRefId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdLc> fgtrdlcs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_LC WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_LC WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdLc records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_LC WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdLc.class)
    public List<FgTrdLc> findByIds(@BindList("ids") Collection<String> ids);
}
