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
import com.bsit.codegeneration.entity.FgTrdRemittance;

public interface FgTrdRemittanceDao {

    /**
     * Inserts a new FgTrdRemittance and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_REMITTANCE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUST_REF_ID, TNX_TYPE, PROD_STAT_CODE, TNX_STAT_CODE, PRODUCT_CODE, APPL_DATE, IR_TYPE_CODE, TNX_VALUE_DATE, IR_CUR_CODE, IR_AMT, TNX_CUR_CODE, TNX_AMT, ACT_NO, BENEFICIARY_NAME, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, BENEFICIARY_REFERENCE, REMITTER_NAME, REMITTER_ADDRESS_LINE_1, REMITTER_ADDRESS_LINE_2, NOSTRO_NUMBER, SUB_PRODUCT_CODE, IR_VALUE_DATE, SWIFT_MSG_TYPE, IR_ORDR_INSTITUTION, IR_REM_INFO, IR_DTL_CHRGS, PROCESS_ID, APPLICANT_PARTY, BO_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :custRefId, :tnxType, :prodStatCode, :tnxStatCode, :productCode, :applDate, :irTypeCode, :tnxValueDate, :irCurCode, :irAmt, :tnxCurCode, :tnxAmt, :actNo, :beneficiaryName, :beneficiaryAddressLine1, :beneficiaryAddressLine2, :beneficiaryReference, :remitterName, :remitterAddressLine1, :remitterAddressLine2, :nostroNumber, :subProductCode, :irValueDate, :swiftMsgType, :irOrdrInstitution, :irRemInfo, :irDtlChrgs, :processId, :applicantParty, :boRefId)")
    public int insert(@BindBean FgTrdRemittance fgtrdremittance);

    /**
     * Finds a FgTrdRemittance by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_REMITTANCE WHERE ID = :id")
    @RegisterBeanMapper(FgTrdRemittance.class)
    public Optional<FgTrdRemittance> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_REMITTANCE")
    @RegisterBeanMapper(FgTrdRemittance.class)
    public List<FgTrdRemittance> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_REMITTANCE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdRemittance.class)
    public List<FgTrdRemittance> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdRemittance and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_REMITTANCE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUST_REF_ID = :custRefId, TNX_TYPE = :tnxType, PROD_STAT_CODE = :prodStatCode, TNX_STAT_CODE = :tnxStatCode, PRODUCT_CODE = :productCode, APPL_DATE = :applDate, IR_TYPE_CODE = :irTypeCode, TNX_VALUE_DATE = :tnxValueDate, IR_CUR_CODE = :irCurCode, IR_AMT = :irAmt, TNX_CUR_CODE = :tnxCurCode, TNX_AMT = :tnxAmt, ACT_NO = :actNo, BENEFICIARY_NAME = :beneficiaryName, BENEFICIARY_ADDRESS_LINE_1 = :beneficiaryAddressLine1, BENEFICIARY_ADDRESS_LINE_2 = :beneficiaryAddressLine2, BENEFICIARY_REFERENCE = :beneficiaryReference, REMITTER_NAME = :remitterName, REMITTER_ADDRESS_LINE_1 = :remitterAddressLine1, REMITTER_ADDRESS_LINE_2 = :remitterAddressLine2, NOSTRO_NUMBER = :nostroNumber, SUB_PRODUCT_CODE = :subProductCode, IR_VALUE_DATE = :irValueDate, SWIFT_MSG_TYPE = :swiftMsgType, IR_ORDR_INSTITUTION = :irOrdrInstitution, IR_REM_INFO = :irRemInfo, IR_DTL_CHRGS = :irDtlChrgs, PROCESS_ID = :processId, APPLICANT_PARTY = :applicantParty, BO_REF_ID = :boRefId WHERE ID = :id")
    public int update(@BindBean FgTrdRemittance fgtrdremittance);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_REMITTANCE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_REMITTANCE")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdRemittance entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_REMITTANCE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUST_REF_ID, TNX_TYPE, PROD_STAT_CODE, TNX_STAT_CODE, PRODUCT_CODE, APPL_DATE, IR_TYPE_CODE, TNX_VALUE_DATE, IR_CUR_CODE, IR_AMT, TNX_CUR_CODE, TNX_AMT, ACT_NO, BENEFICIARY_NAME, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, BENEFICIARY_REFERENCE, REMITTER_NAME, REMITTER_ADDRESS_LINE_1, REMITTER_ADDRESS_LINE_2, NOSTRO_NUMBER, SUB_PRODUCT_CODE, IR_VALUE_DATE, SWIFT_MSG_TYPE, IR_ORDR_INSTITUTION, IR_REM_INFO, IR_DTL_CHRGS, PROCESS_ID, APPLICANT_PARTY, BO_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :custRefId, :tnxType, :prodStatCode, :tnxStatCode, :productCode, :applDate, :irTypeCode, :tnxValueDate, :irCurCode, :irAmt, :tnxCurCode, :tnxAmt, :actNo, :beneficiaryName, :beneficiaryAddressLine1, :beneficiaryAddressLine2, :beneficiaryReference, :remitterName, :remitterAddressLine1, :remitterAddressLine2, :nostroNumber, :subProductCode, :irValueDate, :swiftMsgType, :irOrdrInstitution, :irRemInfo, :irDtlChrgs, :processId, :applicantParty, :boRefId)")
    public int[] bulkInsert(@BindBean List<FgTrdRemittance> fgtrdremittances);

    /**
     * Bulk update multiple FgTrdRemittance entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_REMITTANCE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUST_REF_ID = :custRefId, TNX_TYPE = :tnxType, PROD_STAT_CODE = :prodStatCode, TNX_STAT_CODE = :tnxStatCode, PRODUCT_CODE = :productCode, APPL_DATE = :applDate, IR_TYPE_CODE = :irTypeCode, TNX_VALUE_DATE = :tnxValueDate, IR_CUR_CODE = :irCurCode, IR_AMT = :irAmt, TNX_CUR_CODE = :tnxCurCode, TNX_AMT = :tnxAmt, ACT_NO = :actNo, BENEFICIARY_NAME = :beneficiaryName, BENEFICIARY_ADDRESS_LINE_1 = :beneficiaryAddressLine1, BENEFICIARY_ADDRESS_LINE_2 = :beneficiaryAddressLine2, BENEFICIARY_REFERENCE = :beneficiaryReference, REMITTER_NAME = :remitterName, REMITTER_ADDRESS_LINE_1 = :remitterAddressLine1, REMITTER_ADDRESS_LINE_2 = :remitterAddressLine2, NOSTRO_NUMBER = :nostroNumber, SUB_PRODUCT_CODE = :subProductCode, IR_VALUE_DATE = :irValueDate, SWIFT_MSG_TYPE = :swiftMsgType, IR_ORDR_INSTITUTION = :irOrdrInstitution, IR_REM_INFO = :irRemInfo, IR_DTL_CHRGS = :irDtlChrgs, PROCESS_ID = :processId, APPLICANT_PARTY = :applicantParty, BO_REF_ID = :boRefId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdRemittance> fgtrdremittances);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_REMITTANCE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_REMITTANCE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdRemittance records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_REMITTANCE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdRemittance.class)
    public List<FgTrdRemittance> findByIds(@BindList("ids") Collection<String> ids);
}
