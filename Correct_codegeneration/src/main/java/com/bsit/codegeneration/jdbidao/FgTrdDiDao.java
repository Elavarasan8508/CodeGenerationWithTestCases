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
import com.bsit.codegeneration.entity.FgTrdDi;

public interface FgTrdDiDao {

    /**
     * Inserts a new FgTrdDi and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_DI (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IR_NOSTRO_NUMBER, IR_VALUE_DATE, IR_CUR_CODE, IR_AMT, CUR_CODE, AMT, TRADE_DSP_AMT, FUNDS_DSP_AMT, TO_BE_DISPOSED_AMT, BANK_TO_BE_BOOK, BOOK_NEW_DEAL, PROVIDED_TRD_DSP_AMT, TO_BE_DSP_TRD_AMT, OFC_MAX_DSP_AMT, OFC_DSP_AMT, ELC_MAX_DSP_AMT, ELC_DSP_AMT, PROVIDED_FUND_DSP_AMT, TO_BE_DSP_FUND_AMT, POST_SHIP_DSP_AMT, PRE_SHIP_MAX_DSP_AMT, PRE_SHIP_DSP_AMT, PRE_REM_AMT_ACC_NO, ACC_MAX_DSP_AMT, ACC_DSP_AMT, REM_AMT_ACC_NO, PROCESS_ID, STAGE_CODE, APPLICANT_PARTY, ISSUING_PARTY, IR_REFERENCE_ID, CHECKBOX_1, CHECKBOX_2, CHECKBOX_3, CHECKBOX_4, CHECKBOX_5, CHECKBOX_6, CHECKBOX_7, CHECKBOX_8, SWIFT_MSG_TYPE, DETAILS_CHARGE, CUST_REF_ID, IR_REM_INFO, BENEFICIARY_NAME, REMITTER_NAME, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, REMITTER_ADDRESS_LINE_1, REMITTER_ADDRESS_LINE_2, BO_REF_ID, PRODUCT_STATUS, TASK_ID, DEBIT_ACC_NO, LTEA_INDICATOR, COPY_FROM, IR_ORDR_INSTITUTION, DMS_EVENT_ID, EVENT, ENTITY, PRE_REM_AMT_ACC_NO_CB, TI_MASTER_REF, SWIFT_MESSAGE_DATA, BENEF_ADDR3, BENEF_ADDR2, BENEF_ADDR1, BENEF_NAME, BENEF_NO, ORD_ADDR3, ORD_ADDR2, ORD_ADDR1, ORD_NAME, ORD_ACCNO, SENDER) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :irNostroNumber, :irValueDate, :irCurCode, :irAmt, :curCode, :amt, :tradeDspAmt, :fundsDspAmt, :toBeDisposedAmt, :bankToBeBook, :bookNewDeal, :providedTrdDspAmt, :toBeDspTrdAmt, :ofcMaxDspAmt, :ofcDspAmt, :elcMaxDspAmt, :elcDspAmt, :providedFundDspAmt, :toBeDspFundAmt, :postShipDspAmt, :preShipMaxDspAmt, :preShipDspAmt, :preRemAmtAccNo, :accMaxDspAmt, :accDspAmt, :remAmtAccNo, :processId, :stageCode, :applicantParty, :issuingParty, :irReferenceId, :checkbox1, :checkbox2, :checkbox3, :checkbox4, :checkbox5, :checkbox6, :checkbox7, :checkbox8, :swiftMsgType, :detailsCharge, :custRefId, :irRemInfo, :beneficiaryName, :remitterName, :beneficiaryAddressLine1, :beneficiaryAddressLine2, :remitterAddressLine1, :remitterAddressLine2, :boRefId, :productStatus, :taskId, :debitAccNo, :lteaIndicator, :copyFrom, :irOrdrInstitution, :dmsEventId, :event, :entity, :preRemAmtAccNoCb, :tiMasterRef, :swiftMessageData, :benefAddr3, :benefAddr2, :benefAddr1, :benefName, :benefNo, :ordAddr3, :ordAddr2, :ordAddr1, :ordName, :ordAccno, :sender)")
    public int insert(@BindBean FgTrdDi fgtrddi);

    /**
     * Finds a FgTrdDi by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_DI WHERE ID = :id")
    @RegisterBeanMapper(FgTrdDi.class)
    public Optional<FgTrdDi> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_DI")
    @RegisterBeanMapper(FgTrdDi.class)
    public List<FgTrdDi> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_DI ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdDi.class)
    public List<FgTrdDi> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdDi and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_DI SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IR_NOSTRO_NUMBER = :irNostroNumber, IR_VALUE_DATE = :irValueDate, IR_CUR_CODE = :irCurCode, IR_AMT = :irAmt, CUR_CODE = :curCode, AMT = :amt, TRADE_DSP_AMT = :tradeDspAmt, FUNDS_DSP_AMT = :fundsDspAmt, TO_BE_DISPOSED_AMT = :toBeDisposedAmt, BANK_TO_BE_BOOK = :bankToBeBook, BOOK_NEW_DEAL = :bookNewDeal, PROVIDED_TRD_DSP_AMT = :providedTrdDspAmt, TO_BE_DSP_TRD_AMT = :toBeDspTrdAmt, OFC_MAX_DSP_AMT = :ofcMaxDspAmt, OFC_DSP_AMT = :ofcDspAmt, ELC_MAX_DSP_AMT = :elcMaxDspAmt, ELC_DSP_AMT = :elcDspAmt, PROVIDED_FUND_DSP_AMT = :providedFundDspAmt, TO_BE_DSP_FUND_AMT = :toBeDspFundAmt, POST_SHIP_DSP_AMT = :postShipDspAmt, PRE_SHIP_MAX_DSP_AMT = :preShipMaxDspAmt, PRE_SHIP_DSP_AMT = :preShipDspAmt, PRE_REM_AMT_ACC_NO = :preRemAmtAccNo, ACC_MAX_DSP_AMT = :accMaxDspAmt, ACC_DSP_AMT = :accDspAmt, REM_AMT_ACC_NO = :remAmtAccNo, PROCESS_ID = :processId, STAGE_CODE = :stageCode, APPLICANT_PARTY = :applicantParty, ISSUING_PARTY = :issuingParty, IR_REFERENCE_ID = :irReferenceId, CHECKBOX_1 = :checkbox1, CHECKBOX_2 = :checkbox2, CHECKBOX_3 = :checkbox3, CHECKBOX_4 = :checkbox4, CHECKBOX_5 = :checkbox5, CHECKBOX_6 = :checkbox6, CHECKBOX_7 = :checkbox7, CHECKBOX_8 = :checkbox8, SWIFT_MSG_TYPE = :swiftMsgType, DETAILS_CHARGE = :detailsCharge, CUST_REF_ID = :custRefId, IR_REM_INFO = :irRemInfo, BENEFICIARY_NAME = :beneficiaryName, REMITTER_NAME = :remitterName, BENEFICIARY_ADDRESS_LINE_1 = :beneficiaryAddressLine1, BENEFICIARY_ADDRESS_LINE_2 = :beneficiaryAddressLine2, REMITTER_ADDRESS_LINE_1 = :remitterAddressLine1, REMITTER_ADDRESS_LINE_2 = :remitterAddressLine2, BO_REF_ID = :boRefId, PRODUCT_STATUS = :productStatus, TASK_ID = :taskId, DEBIT_ACC_NO = :debitAccNo, LTEA_INDICATOR = :lteaIndicator, COPY_FROM = :copyFrom, IR_ORDR_INSTITUTION = :irOrdrInstitution, DMS_EVENT_ID = :dmsEventId, EVENT = :event, ENTITY = :entity, PRE_REM_AMT_ACC_NO_CB = :preRemAmtAccNoCb, TI_MASTER_REF = :tiMasterRef, SWIFT_MESSAGE_DATA = :swiftMessageData, BENEF_ADDR3 = :benefAddr3, BENEF_ADDR2 = :benefAddr2, BENEF_ADDR1 = :benefAddr1, BENEF_NAME = :benefName, BENEF_NO = :benefNo, ORD_ADDR3 = :ordAddr3, ORD_ADDR2 = :ordAddr2, ORD_ADDR1 = :ordAddr1, ORD_NAME = :ordName, ORD_ACCNO = :ordAccno, SENDER = :sender WHERE ID = :id")
    public int update(@BindBean FgTrdDi fgtrddi);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_DI WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_DI")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdDi entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_DI (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IR_NOSTRO_NUMBER, IR_VALUE_DATE, IR_CUR_CODE, IR_AMT, CUR_CODE, AMT, TRADE_DSP_AMT, FUNDS_DSP_AMT, TO_BE_DISPOSED_AMT, BANK_TO_BE_BOOK, BOOK_NEW_DEAL, PROVIDED_TRD_DSP_AMT, TO_BE_DSP_TRD_AMT, OFC_MAX_DSP_AMT, OFC_DSP_AMT, ELC_MAX_DSP_AMT, ELC_DSP_AMT, PROVIDED_FUND_DSP_AMT, TO_BE_DSP_FUND_AMT, POST_SHIP_DSP_AMT, PRE_SHIP_MAX_DSP_AMT, PRE_SHIP_DSP_AMT, PRE_REM_AMT_ACC_NO, ACC_MAX_DSP_AMT, ACC_DSP_AMT, REM_AMT_ACC_NO, PROCESS_ID, STAGE_CODE, APPLICANT_PARTY, ISSUING_PARTY, IR_REFERENCE_ID, CHECKBOX_1, CHECKBOX_2, CHECKBOX_3, CHECKBOX_4, CHECKBOX_5, CHECKBOX_6, CHECKBOX_7, CHECKBOX_8, SWIFT_MSG_TYPE, DETAILS_CHARGE, CUST_REF_ID, IR_REM_INFO, BENEFICIARY_NAME, REMITTER_NAME, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, REMITTER_ADDRESS_LINE_1, REMITTER_ADDRESS_LINE_2, BO_REF_ID, PRODUCT_STATUS, TASK_ID, DEBIT_ACC_NO, LTEA_INDICATOR, COPY_FROM, IR_ORDR_INSTITUTION, DMS_EVENT_ID, EVENT, ENTITY, PRE_REM_AMT_ACC_NO_CB, TI_MASTER_REF, SWIFT_MESSAGE_DATA, BENEF_ADDR3, BENEF_ADDR2, BENEF_ADDR1, BENEF_NAME, BENEF_NO, ORD_ADDR3, ORD_ADDR2, ORD_ADDR1, ORD_NAME, ORD_ACCNO, SENDER) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :irNostroNumber, :irValueDate, :irCurCode, :irAmt, :curCode, :amt, :tradeDspAmt, :fundsDspAmt, :toBeDisposedAmt, :bankToBeBook, :bookNewDeal, :providedTrdDspAmt, :toBeDspTrdAmt, :ofcMaxDspAmt, :ofcDspAmt, :elcMaxDspAmt, :elcDspAmt, :providedFundDspAmt, :toBeDspFundAmt, :postShipDspAmt, :preShipMaxDspAmt, :preShipDspAmt, :preRemAmtAccNo, :accMaxDspAmt, :accDspAmt, :remAmtAccNo, :processId, :stageCode, :applicantParty, :issuingParty, :irReferenceId, :checkbox1, :checkbox2, :checkbox3, :checkbox4, :checkbox5, :checkbox6, :checkbox7, :checkbox8, :swiftMsgType, :detailsCharge, :custRefId, :irRemInfo, :beneficiaryName, :remitterName, :beneficiaryAddressLine1, :beneficiaryAddressLine2, :remitterAddressLine1, :remitterAddressLine2, :boRefId, :productStatus, :taskId, :debitAccNo, :lteaIndicator, :copyFrom, :irOrdrInstitution, :dmsEventId, :event, :entity, :preRemAmtAccNoCb, :tiMasterRef, :swiftMessageData, :benefAddr3, :benefAddr2, :benefAddr1, :benefName, :benefNo, :ordAddr3, :ordAddr2, :ordAddr1, :ordName, :ordAccno, :sender)")
    public int[] bulkInsert(@BindBean List<FgTrdDi> fgtrddis);

    /**
     * Bulk update multiple FgTrdDi entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_DI SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IR_NOSTRO_NUMBER = :irNostroNumber, IR_VALUE_DATE = :irValueDate, IR_CUR_CODE = :irCurCode, IR_AMT = :irAmt, CUR_CODE = :curCode, AMT = :amt, TRADE_DSP_AMT = :tradeDspAmt, FUNDS_DSP_AMT = :fundsDspAmt, TO_BE_DISPOSED_AMT = :toBeDisposedAmt, BANK_TO_BE_BOOK = :bankToBeBook, BOOK_NEW_DEAL = :bookNewDeal, PROVIDED_TRD_DSP_AMT = :providedTrdDspAmt, TO_BE_DSP_TRD_AMT = :toBeDspTrdAmt, OFC_MAX_DSP_AMT = :ofcMaxDspAmt, OFC_DSP_AMT = :ofcDspAmt, ELC_MAX_DSP_AMT = :elcMaxDspAmt, ELC_DSP_AMT = :elcDspAmt, PROVIDED_FUND_DSP_AMT = :providedFundDspAmt, TO_BE_DSP_FUND_AMT = :toBeDspFundAmt, POST_SHIP_DSP_AMT = :postShipDspAmt, PRE_SHIP_MAX_DSP_AMT = :preShipMaxDspAmt, PRE_SHIP_DSP_AMT = :preShipDspAmt, PRE_REM_AMT_ACC_NO = :preRemAmtAccNo, ACC_MAX_DSP_AMT = :accMaxDspAmt, ACC_DSP_AMT = :accDspAmt, REM_AMT_ACC_NO = :remAmtAccNo, PROCESS_ID = :processId, STAGE_CODE = :stageCode, APPLICANT_PARTY = :applicantParty, ISSUING_PARTY = :issuingParty, IR_REFERENCE_ID = :irReferenceId, CHECKBOX_1 = :checkbox1, CHECKBOX_2 = :checkbox2, CHECKBOX_3 = :checkbox3, CHECKBOX_4 = :checkbox4, CHECKBOX_5 = :checkbox5, CHECKBOX_6 = :checkbox6, CHECKBOX_7 = :checkbox7, CHECKBOX_8 = :checkbox8, SWIFT_MSG_TYPE = :swiftMsgType, DETAILS_CHARGE = :detailsCharge, CUST_REF_ID = :custRefId, IR_REM_INFO = :irRemInfo, BENEFICIARY_NAME = :beneficiaryName, REMITTER_NAME = :remitterName, BENEFICIARY_ADDRESS_LINE_1 = :beneficiaryAddressLine1, BENEFICIARY_ADDRESS_LINE_2 = :beneficiaryAddressLine2, REMITTER_ADDRESS_LINE_1 = :remitterAddressLine1, REMITTER_ADDRESS_LINE_2 = :remitterAddressLine2, BO_REF_ID = :boRefId, PRODUCT_STATUS = :productStatus, TASK_ID = :taskId, DEBIT_ACC_NO = :debitAccNo, LTEA_INDICATOR = :lteaIndicator, COPY_FROM = :copyFrom, IR_ORDR_INSTITUTION = :irOrdrInstitution, DMS_EVENT_ID = :dmsEventId, EVENT = :event, ENTITY = :entity, PRE_REM_AMT_ACC_NO_CB = :preRemAmtAccNoCb, TI_MASTER_REF = :tiMasterRef, SWIFT_MESSAGE_DATA = :swiftMessageData, BENEF_ADDR3 = :benefAddr3, BENEF_ADDR2 = :benefAddr2, BENEF_ADDR1 = :benefAddr1, BENEF_NAME = :benefName, BENEF_NO = :benefNo, ORD_ADDR3 = :ordAddr3, ORD_ADDR2 = :ordAddr2, ORD_ADDR1 = :ordAddr1, ORD_NAME = :ordName, ORD_ACCNO = :ordAccno, SENDER = :sender WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdDi> fgtrddis);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_DI WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_DI WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdDi records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_DI WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdDi.class)
    public List<FgTrdDi> findByIds(@BindList("ids") Collection<String> ids);
}
