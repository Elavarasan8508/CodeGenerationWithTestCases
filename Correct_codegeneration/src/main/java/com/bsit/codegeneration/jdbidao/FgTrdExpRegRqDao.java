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
import com.bsit.codegeneration.entity.FgTrdExpRegRq;

public interface FgTrdExpRegRqDao {

    /**
     * Inserts a new FgTrdExpRegRq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_EXP_REG_RQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PORT_CODE, EXP_TYPE, SB_NO, SB_DATE, FORM_NO, IE_CODE, REQ_TYPE, IRM_NO, IRM_AD, IRM_AMT, OS_AMT_IRM, IRM_CCY, APPLICANT_PARTY, ISSUING_PARTY, PRODUCT_STATUS, PROCESS_ID, DMS_EVENT_ID, EXP_AGENCY, DEBIT_ACC_NUM) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :portCode, :expType, :sbNo, :sbDate, :formNo, :ieCode, :reqType, :irmNo, :irmAd, :irmAmt, :osAmtIrm, :irmCcy, :applicantParty, :issuingParty, :productStatus, :processId, :dmsEventId, :expAgency, :debitAccNum)")
    public int insert(@BindBean FgTrdExpRegRq fgtrdexpregrq);

    /**
     * Finds a FgTrdExpRegRq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_EXP_REG_RQ WHERE ID = :id")
    @RegisterBeanMapper(FgTrdExpRegRq.class)
    public Optional<FgTrdExpRegRq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_EXP_REG_RQ")
    @RegisterBeanMapper(FgTrdExpRegRq.class)
    public List<FgTrdExpRegRq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_EXP_REG_RQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdExpRegRq.class)
    public List<FgTrdExpRegRq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdExpRegRq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_EXP_REG_RQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PORT_CODE = :portCode, EXP_TYPE = :expType, SB_NO = :sbNo, SB_DATE = :sbDate, FORM_NO = :formNo, IE_CODE = :ieCode, REQ_TYPE = :reqType, IRM_NO = :irmNo, IRM_AD = :irmAd, IRM_AMT = :irmAmt, OS_AMT_IRM = :osAmtIrm, IRM_CCY = :irmCcy, APPLICANT_PARTY = :applicantParty, ISSUING_PARTY = :issuingParty, PRODUCT_STATUS = :productStatus, PROCESS_ID = :processId, DMS_EVENT_ID = :dmsEventId, EXP_AGENCY = :expAgency, DEBIT_ACC_NUM = :debitAccNum WHERE ID = :id")
    public int update(@BindBean FgTrdExpRegRq fgtrdexpregrq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_EXP_REG_RQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_EXP_REG_RQ")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdExpRegRq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_EXP_REG_RQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PORT_CODE, EXP_TYPE, SB_NO, SB_DATE, FORM_NO, IE_CODE, REQ_TYPE, IRM_NO, IRM_AD, IRM_AMT, OS_AMT_IRM, IRM_CCY, APPLICANT_PARTY, ISSUING_PARTY, PRODUCT_STATUS, PROCESS_ID, DMS_EVENT_ID, EXP_AGENCY, DEBIT_ACC_NUM) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :portCode, :expType, :sbNo, :sbDate, :formNo, :ieCode, :reqType, :irmNo, :irmAd, :irmAmt, :osAmtIrm, :irmCcy, :applicantParty, :issuingParty, :productStatus, :processId, :dmsEventId, :expAgency, :debitAccNum)")
    public int[] bulkInsert(@BindBean List<FgTrdExpRegRq> fgtrdexpregrqs);

    /**
     * Bulk update multiple FgTrdExpRegRq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_EXP_REG_RQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PORT_CODE = :portCode, EXP_TYPE = :expType, SB_NO = :sbNo, SB_DATE = :sbDate, FORM_NO = :formNo, IE_CODE = :ieCode, REQ_TYPE = :reqType, IRM_NO = :irmNo, IRM_AD = :irmAd, IRM_AMT = :irmAmt, OS_AMT_IRM = :osAmtIrm, IRM_CCY = :irmCcy, APPLICANT_PARTY = :applicantParty, ISSUING_PARTY = :issuingParty, PRODUCT_STATUS = :productStatus, PROCESS_ID = :processId, DMS_EVENT_ID = :dmsEventId, EXP_AGENCY = :expAgency, DEBIT_ACC_NUM = :debitAccNum WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdExpRegRq> fgtrdexpregrqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_EXP_REG_RQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_EXP_REG_RQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdExpRegRq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_EXP_REG_RQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdExpRegRq.class)
    public List<FgTrdExpRegRq> findByIds(@BindList("ids") Collection<String> ids);
}
