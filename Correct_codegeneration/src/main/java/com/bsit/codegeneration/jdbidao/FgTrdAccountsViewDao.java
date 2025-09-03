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
import com.bsit.codegeneration.entity.FgTrdAccountsView;

public interface FgTrdAccountsViewDao {

    /**
     * Inserts a new FgTrdAccountsView and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_ACCOUNTS_VIEW (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACC_NO, CUR_CODE, IN_ACC_CUR, DSP_AMT, EQU_DSP_AMT, APPLICANT_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :accNo, :curCode, :inAccCur, :dspAmt, :equDspAmt, :applicantParty)")
    public int insert(@BindBean FgTrdAccountsView fgtrdaccountsview);

    /**
     * Finds a FgTrdAccountsView by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ACCOUNTS_VIEW WHERE ID = :id")
    @RegisterBeanMapper(FgTrdAccountsView.class)
    public Optional<FgTrdAccountsView> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ACCOUNTS_VIEW")
    @RegisterBeanMapper(FgTrdAccountsView.class)
    public List<FgTrdAccountsView> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ACCOUNTS_VIEW ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdAccountsView.class)
    public List<FgTrdAccountsView> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdAccountsView and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_ACCOUNTS_VIEW SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ACC_NO = :accNo, CUR_CODE = :curCode, IN_ACC_CUR = :inAccCur, DSP_AMT = :dspAmt, EQU_DSP_AMT = :equDspAmt, APPLICANT_PARTY = :applicantParty WHERE ID = :id")
    public int update(@BindBean FgTrdAccountsView fgtrdaccountsview);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_ACCOUNTS_VIEW WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_ACCOUNTS_VIEW")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdAccountsView entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_ACCOUNTS_VIEW (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ACC_NO, CUR_CODE, IN_ACC_CUR, DSP_AMT, EQU_DSP_AMT, APPLICANT_PARTY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :accNo, :curCode, :inAccCur, :dspAmt, :equDspAmt, :applicantParty)")
    public int[] bulkInsert(@BindBean List<FgTrdAccountsView> fgtrdaccountsviews);

    /**
     * Bulk update multiple FgTrdAccountsView entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_ACCOUNTS_VIEW SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, ACC_NO = :accNo, CUR_CODE = :curCode, IN_ACC_CUR = :inAccCur, DSP_AMT = :dspAmt, EQU_DSP_AMT = :equDspAmt, APPLICANT_PARTY = :applicantParty WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdAccountsView> fgtrdaccountsviews);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_ACCOUNTS_VIEW WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_ACCOUNTS_VIEW WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdAccountsView records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_ACCOUNTS_VIEW WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdAccountsView.class)
    public List<FgTrdAccountsView> findByIds(@BindList("ids") Collection<String> ids);
}
