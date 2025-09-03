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
import com.bsit.codegeneration.entity.FgTrdAccounts;

public interface FgTrdAccountsDao {

    /**
     * Inserts a new FgTrdAccounts and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_ACCOUNTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACC_NO, CUR_CODE, IN_ACC_CUR, DSP_AMT, EQU_DSP_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :accNo, :curCode, :inAccCur, :dspAmt, :equDspAmt, :parentRefId, :parentVersionId, :irReferenceId, :applicantParty)")
    public int insert(@BindBean FgTrdAccounts fgtrdaccounts);

    /**
     * Finds a FgTrdAccounts by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ACCOUNTS WHERE ID = :id")
    @RegisterBeanMapper(FgTrdAccounts.class)
    public Optional<FgTrdAccounts> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ACCOUNTS")
    @RegisterBeanMapper(FgTrdAccounts.class)
    public List<FgTrdAccounts> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ACCOUNTS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdAccounts.class)
    public List<FgTrdAccounts> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdAccounts and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_ACCOUNTS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ACC_NO = :accNo, CUR_CODE = :curCode, IN_ACC_CUR = :inAccCur, DSP_AMT = :dspAmt, EQU_DSP_AMT = :equDspAmt, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IR_REFERENCE_ID = :irReferenceId, APPLICANT_PARTY = :applicantParty WHERE ID = :id")
    public int update(@BindBean FgTrdAccounts fgtrdaccounts);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_ACCOUNTS WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_ACCOUNTS")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdAccounts entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_ACCOUNTS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACC_NO, CUR_CODE, IN_ACC_CUR, DSP_AMT, EQU_DSP_AMT, PARENT_REF_ID, PARENT_VERSION_ID, IR_REFERENCE_ID, APPLICANT_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :accNo, :curCode, :inAccCur, :dspAmt, :equDspAmt, :parentRefId, :parentVersionId, :irReferenceId, :applicantParty)")
    public int[] bulkInsert(@BindBean List<FgTrdAccounts> fgtrdaccountss);

    /**
     * Bulk update multiple FgTrdAccounts entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_ACCOUNTS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ACC_NO = :accNo, CUR_CODE = :curCode, IN_ACC_CUR = :inAccCur, DSP_AMT = :dspAmt, EQU_DSP_AMT = :equDspAmt, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IR_REFERENCE_ID = :irReferenceId, APPLICANT_PARTY = :applicantParty WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdAccounts> fgtrdaccountss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_ACCOUNTS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_ACCOUNTS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdAccounts records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ACCOUNTS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdAccounts.class)
    public List<FgTrdAccounts> findByIds(@BindList("ids") Collection<String> ids);
}
