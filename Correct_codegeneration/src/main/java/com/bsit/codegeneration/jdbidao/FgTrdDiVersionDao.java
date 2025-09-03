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
import com.bsit.codegeneration.entity.FgTrdDiVersion;

public interface FgTrdDiVersionDao {

    /**
     * Inserts a new FgTrdDiVersion and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_DI_VERSION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IR_NOSTRO_NUMBER, IR_VALUE_DATE, IR_CUR_CODE, IR_AMT, CUR_CODE, AMT, TRADE_DSP_AMT, FUNDS_DSP_AMT, TO_BE_DISPOSED_AMT, BANK_TO_BE_BOOK, BOOK_NEW_DEAL, PROVIDED_TRD_DSP_AMT, TO_BE_DSP_TRD_AMT, OFC_MAX_DSP_AMT, OFC_DSP_AMT, ELC_MAX_DSP_AMT, ELC_DSP_AMT, PROVIDED_FUND_DSP_AMT, TO_BE_DSP_FUND_AMT, POST_SHIP_DSP_AMT, PRE_SHIP_MAX_DSP_AMT, PRE_SHIP_DSP_AMT, PRE_REM_AMT_ACC_NO, ACC_MAX_DSP_AMT, ACC_DSP_AMT, REM_AMT_ACC_NO, APPLICANT_PARTY, ISSUING_PARTY, IR_REFERENCE_ID, CUST_REF_ID, DETAILS_CHARGE, IR_REM_INFO, REMITTER_NAME, BENEFICIARY_NAME, SWIFT_MSG_TYPE, PROCESS_ID, STAGE_CODE, CHECKBOX_8, REMITTER_ADDRESS_LINE_2, REMITTER_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, BO_REF_ID, PRODUCT_STATUS, TASK_ID, DMS_EVENT_ID, STEPPER_COMPLETION_PERCENTAGE, LTEA_INDICATOR, GENERAL_DETAILS, DISPOSAL_INSTRUCTION, TRADE_DISPOSAL, FUNDS_DISPOSAL, DECLARATION, ATTACHMENTS, PREVIEW, IR_ORDR_INSTITUTION, COPY_FROM, DEBIT_ACC_NO, MIS_PRODUCT, XAR_PRODUCT, PRE_REM_AMT_ACC_NO_CB, SENDER, ORD_ACCNO, ORD_NAME, ORD_ADDR1, ORD_ADDR2, ORD_ADDR3, BENEF_NO, BENEF_NAME, BENEF_ADDR1, BENEF_ADDR2, BENEF_ADDR3, SWIFT_MESSAGE_DATA, TI_MASTER_REF, PRE_REMT_ACC_NO_CUR, REMT_ACC_NO_CUR, DEBIT_ACC_NO_CUR, ACK_MESSAGE, ACK_STATUS, FG_TRD_PURPOSE_CODE, FG_TRD_ACCOUNTS, FG_TRD_FX_RATE, FG_TRD_POST_LOANS, FG_TRD_PRE_LOANS, FG_TRD_LC, FG_TRD_APPL_FX_RATE, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :irNostroNumber, :irValueDate, :irCurCode, :irAmt, :curCode, :amt, :tradeDspAmt, :fundsDspAmt, :toBeDisposedAmt, :bankToBeBook, :bookNewDeal, :providedTrdDspAmt, :toBeDspTrdAmt, :ofcMaxDspAmt, :ofcDspAmt, :elcMaxDspAmt, :elcDspAmt, :providedFundDspAmt, :toBeDspFundAmt, :postShipDspAmt, :preShipMaxDspAmt, :preShipDspAmt, :preRemAmtAccNo, :accMaxDspAmt, :accDspAmt, :remAmtAccNo, :applicantParty, :issuingParty, :irReferenceId, :custRefId, :detailsCharge, :irRemInfo, :remitterName, :beneficiaryName, :swiftMsgType, :processId, :stageCode, :checkbox8, :remitterAddressLine2, :remitterAddressLine1, :beneficiaryAddressLine1, :beneficiaryAddressLine2, :boRefId, :productStatus, :taskId, :dmsEventId, :stepperCompletionPercentage, :lteaIndicator, :generalDetails, :disposalInstruction, :tradeDisposal, :fundsDisposal, :declaration, :attachments, :preview, :irOrdrInstitution, :copyFrom, :debitAccNo, :misProduct, :xarProduct, :preRemAmtAccNoCb, :sender, :ordAccno, :ordName, :ordAddr1, :ordAddr2, :ordAddr3, :benefNo, :benefName, :benefAddr1, :benefAddr2, :benefAddr3, :swiftMessageData, :tiMasterRef, :preRemtAccNoCur, :remtAccNoCur, :debitAccNoCur, :ackMessage, :ackStatus, :fgTrdPurposeCode, :fgTrdAccounts, :fgTrdFxRate, :fgTrdPostLoans, :fgTrdPreLoans, :fgTrdLc, :fgTrdApplFxRate, :versionId, :isMasterVersion)")
    public int insert(@BindBean FgTrdDiVersion fgtrddiversion);

    /**
     * Finds a FgTrdDiVersion by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_DI_VERSION WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgTrdDiVersion.class)
    public Optional<FgTrdDiVersion> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_DI_VERSION")
    @RegisterBeanMapper(FgTrdDiVersion.class)
    public List<FgTrdDiVersion> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_DI_VERSION ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdDiVersion.class)
    public List<FgTrdDiVersion> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdDiVersion and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_DI_VERSION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IR_NOSTRO_NUMBER = :irNostroNumber, IR_VALUE_DATE = :irValueDate, IR_CUR_CODE = :irCurCode, IR_AMT = :irAmt, CUR_CODE = :curCode, AMT = :amt, TRADE_DSP_AMT = :tradeDspAmt, FUNDS_DSP_AMT = :fundsDspAmt, TO_BE_DISPOSED_AMT = :toBeDisposedAmt, BANK_TO_BE_BOOK = :bankToBeBook, BOOK_NEW_DEAL = :bookNewDeal, PROVIDED_TRD_DSP_AMT = :providedTrdDspAmt, TO_BE_DSP_TRD_AMT = :toBeDspTrdAmt, OFC_MAX_DSP_AMT = :ofcMaxDspAmt, OFC_DSP_AMT = :ofcDspAmt, ELC_MAX_DSP_AMT = :elcMaxDspAmt, ELC_DSP_AMT = :elcDspAmt, PROVIDED_FUND_DSP_AMT = :providedFundDspAmt, TO_BE_DSP_FUND_AMT = :toBeDspFundAmt, POST_SHIP_DSP_AMT = :postShipDspAmt, PRE_SHIP_MAX_DSP_AMT = :preShipMaxDspAmt, PRE_SHIP_DSP_AMT = :preShipDspAmt, PRE_REM_AMT_ACC_NO = :preRemAmtAccNo, ACC_MAX_DSP_AMT = :accMaxDspAmt, ACC_DSP_AMT = :accDspAmt, REM_AMT_ACC_NO = :remAmtAccNo, APPLICANT_PARTY = :applicantParty, ISSUING_PARTY = :issuingParty, IR_REFERENCE_ID = :irReferenceId, CUST_REF_ID = :custRefId, DETAILS_CHARGE = :detailsCharge, IR_REM_INFO = :irRemInfo, REMITTER_NAME = :remitterName, BENEFICIARY_NAME = :beneficiaryName, SWIFT_MSG_TYPE = :swiftMsgType, PROCESS_ID = :processId, STAGE_CODE = :stageCode, CHECKBOX_8 = :checkbox8, REMITTER_ADDRESS_LINE_2 = :remitterAddressLine2, REMITTER_ADDRESS_LINE_1 = :remitterAddressLine1, BENEFICIARY_ADDRESS_LINE_1 = :beneficiaryAddressLine1, BENEFICIARY_ADDRESS_LINE_2 = :beneficiaryAddressLine2, BO_REF_ID = :boRefId, PRODUCT_STATUS = :productStatus, TASK_ID = :taskId, DMS_EVENT_ID = :dmsEventId, STEPPER_COMPLETION_PERCENTAGE = :stepperCompletionPercentage, LTEA_INDICATOR = :lteaIndicator, GENERAL_DETAILS = :generalDetails, DISPOSAL_INSTRUCTION = :disposalInstruction, TRADE_DISPOSAL = :tradeDisposal, FUNDS_DISPOSAL = :fundsDisposal, DECLARATION = :declaration, ATTACHMENTS = :attachments, PREVIEW = :preview, IR_ORDR_INSTITUTION = :irOrdrInstitution, COPY_FROM = :copyFrom, DEBIT_ACC_NO = :debitAccNo, MIS_PRODUCT = :misProduct, XAR_PRODUCT = :xarProduct, PRE_REM_AMT_ACC_NO_CB = :preRemAmtAccNoCb, SENDER = :sender, ORD_ACCNO = :ordAccno, ORD_NAME = :ordName, ORD_ADDR1 = :ordAddr1, ORD_ADDR2 = :ordAddr2, ORD_ADDR3 = :ordAddr3, BENEF_NO = :benefNo, BENEF_NAME = :benefName, BENEF_ADDR1 = :benefAddr1, BENEF_ADDR2 = :benefAddr2, BENEF_ADDR3 = :benefAddr3, SWIFT_MESSAGE_DATA = :swiftMessageData, TI_MASTER_REF = :tiMasterRef, PRE_REMT_ACC_NO_CUR = :preRemtAccNoCur, REMT_ACC_NO_CUR = :remtAccNoCur, DEBIT_ACC_NO_CUR = :debitAccNoCur, ACK_MESSAGE = :ackMessage, ACK_STATUS = :ackStatus, FG_TRD_PURPOSE_CODE = :fgTrdPurposeCode, FG_TRD_ACCOUNTS = :fgTrdAccounts, FG_TRD_FX_RATE = :fgTrdFxRate, FG_TRD_POST_LOANS = :fgTrdPostLoans, FG_TRD_PRE_LOANS = :fgTrdPreLoans, FG_TRD_LC = :fgTrdLc, FG_TRD_APPL_FX_RATE = :fgTrdApplFxRate, IS_MASTER_VERSION = :isMasterVersion WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgTrdDiVersion fgtrddiversion);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_DI_VERSION WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_DI_VERSION")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdDiVersion entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_DI_VERSION (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, IR_NOSTRO_NUMBER, IR_VALUE_DATE, IR_CUR_CODE, IR_AMT, CUR_CODE, AMT, TRADE_DSP_AMT, FUNDS_DSP_AMT, TO_BE_DISPOSED_AMT, BANK_TO_BE_BOOK, BOOK_NEW_DEAL, PROVIDED_TRD_DSP_AMT, TO_BE_DSP_TRD_AMT, OFC_MAX_DSP_AMT, OFC_DSP_AMT, ELC_MAX_DSP_AMT, ELC_DSP_AMT, PROVIDED_FUND_DSP_AMT, TO_BE_DSP_FUND_AMT, POST_SHIP_DSP_AMT, PRE_SHIP_MAX_DSP_AMT, PRE_SHIP_DSP_AMT, PRE_REM_AMT_ACC_NO, ACC_MAX_DSP_AMT, ACC_DSP_AMT, REM_AMT_ACC_NO, APPLICANT_PARTY, ISSUING_PARTY, IR_REFERENCE_ID, CUST_REF_ID, DETAILS_CHARGE, IR_REM_INFO, REMITTER_NAME, BENEFICIARY_NAME, SWIFT_MSG_TYPE, PROCESS_ID, STAGE_CODE, CHECKBOX_8, REMITTER_ADDRESS_LINE_2, REMITTER_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_1, BENEFICIARY_ADDRESS_LINE_2, BO_REF_ID, PRODUCT_STATUS, TASK_ID, DMS_EVENT_ID, STEPPER_COMPLETION_PERCENTAGE, LTEA_INDICATOR, GENERAL_DETAILS, DISPOSAL_INSTRUCTION, TRADE_DISPOSAL, FUNDS_DISPOSAL, DECLARATION, ATTACHMENTS, PREVIEW, IR_ORDR_INSTITUTION, COPY_FROM, DEBIT_ACC_NO, MIS_PRODUCT, XAR_PRODUCT, PRE_REM_AMT_ACC_NO_CB, SENDER, ORD_ACCNO, ORD_NAME, ORD_ADDR1, ORD_ADDR2, ORD_ADDR3, BENEF_NO, BENEF_NAME, BENEF_ADDR1, BENEF_ADDR2, BENEF_ADDR3, SWIFT_MESSAGE_DATA, TI_MASTER_REF, PRE_REMT_ACC_NO_CUR, REMT_ACC_NO_CUR, DEBIT_ACC_NO_CUR, ACK_MESSAGE, ACK_STATUS, FG_TRD_PURPOSE_CODE, FG_TRD_ACCOUNTS, FG_TRD_FX_RATE, FG_TRD_POST_LOANS, FG_TRD_PRE_LOANS, FG_TRD_LC, FG_TRD_APPL_FX_RATE, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :irNostroNumber, :irValueDate, :irCurCode, :irAmt, :curCode, :amt, :tradeDspAmt, :fundsDspAmt, :toBeDisposedAmt, :bankToBeBook, :bookNewDeal, :providedTrdDspAmt, :toBeDspTrdAmt, :ofcMaxDspAmt, :ofcDspAmt, :elcMaxDspAmt, :elcDspAmt, :providedFundDspAmt, :toBeDspFundAmt, :postShipDspAmt, :preShipMaxDspAmt, :preShipDspAmt, :preRemAmtAccNo, :accMaxDspAmt, :accDspAmt, :remAmtAccNo, :applicantParty, :issuingParty, :irReferenceId, :custRefId, :detailsCharge, :irRemInfo, :remitterName, :beneficiaryName, :swiftMsgType, :processId, :stageCode, :checkbox8, :remitterAddressLine2, :remitterAddressLine1, :beneficiaryAddressLine1, :beneficiaryAddressLine2, :boRefId, :productStatus, :taskId, :dmsEventId, :stepperCompletionPercentage, :lteaIndicator, :generalDetails, :disposalInstruction, :tradeDisposal, :fundsDisposal, :declaration, :attachments, :preview, :irOrdrInstitution, :copyFrom, :debitAccNo, :misProduct, :xarProduct, :preRemAmtAccNoCb, :sender, :ordAccno, :ordName, :ordAddr1, :ordAddr2, :ordAddr3, :benefNo, :benefName, :benefAddr1, :benefAddr2, :benefAddr3, :swiftMessageData, :tiMasterRef, :preRemtAccNoCur, :remtAccNoCur, :debitAccNoCur, :ackMessage, :ackStatus, :fgTrdPurposeCode, :fgTrdAccounts, :fgTrdFxRate, :fgTrdPostLoans, :fgTrdPreLoans, :fgTrdLc, :fgTrdApplFxRate, :versionId, :isMasterVersion)")
    public int[] bulkInsert(@BindBean List<FgTrdDiVersion> fgtrddiversions);

    /**
     * Bulk update multiple FgTrdDiVersion entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_DI_VERSION SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, IR_NOSTRO_NUMBER = :irNostroNumber, IR_VALUE_DATE = :irValueDate, IR_CUR_CODE = :irCurCode, IR_AMT = :irAmt, CUR_CODE = :curCode, AMT = :amt, TRADE_DSP_AMT = :tradeDspAmt, FUNDS_DSP_AMT = :fundsDspAmt, TO_BE_DISPOSED_AMT = :toBeDisposedAmt, BANK_TO_BE_BOOK = :bankToBeBook, BOOK_NEW_DEAL = :bookNewDeal, PROVIDED_TRD_DSP_AMT = :providedTrdDspAmt, TO_BE_DSP_TRD_AMT = :toBeDspTrdAmt, OFC_MAX_DSP_AMT = :ofcMaxDspAmt, OFC_DSP_AMT = :ofcDspAmt, ELC_MAX_DSP_AMT = :elcMaxDspAmt, ELC_DSP_AMT = :elcDspAmt, PROVIDED_FUND_DSP_AMT = :providedFundDspAmt, TO_BE_DSP_FUND_AMT = :toBeDspFundAmt, POST_SHIP_DSP_AMT = :postShipDspAmt, PRE_SHIP_MAX_DSP_AMT = :preShipMaxDspAmt, PRE_SHIP_DSP_AMT = :preShipDspAmt, PRE_REM_AMT_ACC_NO = :preRemAmtAccNo, ACC_MAX_DSP_AMT = :accMaxDspAmt, ACC_DSP_AMT = :accDspAmt, REM_AMT_ACC_NO = :remAmtAccNo, APPLICANT_PARTY = :applicantParty, ISSUING_PARTY = :issuingParty, IR_REFERENCE_ID = :irReferenceId, CUST_REF_ID = :custRefId, DETAILS_CHARGE = :detailsCharge, IR_REM_INFO = :irRemInfo, REMITTER_NAME = :remitterName, BENEFICIARY_NAME = :beneficiaryName, SWIFT_MSG_TYPE = :swiftMsgType, PROCESS_ID = :processId, STAGE_CODE = :stageCode, CHECKBOX_8 = :checkbox8, REMITTER_ADDRESS_LINE_2 = :remitterAddressLine2, REMITTER_ADDRESS_LINE_1 = :remitterAddressLine1, BENEFICIARY_ADDRESS_LINE_1 = :beneficiaryAddressLine1, BENEFICIARY_ADDRESS_LINE_2 = :beneficiaryAddressLine2, BO_REF_ID = :boRefId, PRODUCT_STATUS = :productStatus, TASK_ID = :taskId, DMS_EVENT_ID = :dmsEventId, STEPPER_COMPLETION_PERCENTAGE = :stepperCompletionPercentage, LTEA_INDICATOR = :lteaIndicator, GENERAL_DETAILS = :generalDetails, DISPOSAL_INSTRUCTION = :disposalInstruction, TRADE_DISPOSAL = :tradeDisposal, FUNDS_DISPOSAL = :fundsDisposal, DECLARATION = :declaration, ATTACHMENTS = :attachments, PREVIEW = :preview, IR_ORDR_INSTITUTION = :irOrdrInstitution, COPY_FROM = :copyFrom, DEBIT_ACC_NO = :debitAccNo, MIS_PRODUCT = :misProduct, XAR_PRODUCT = :xarProduct, PRE_REM_AMT_ACC_NO_CB = :preRemAmtAccNoCb, SENDER = :sender, ORD_ACCNO = :ordAccno, ORD_NAME = :ordName, ORD_ADDR1 = :ordAddr1, ORD_ADDR2 = :ordAddr2, ORD_ADDR3 = :ordAddr3, BENEF_NO = :benefNo, BENEF_NAME = :benefName, BENEF_ADDR1 = :benefAddr1, BENEF_ADDR2 = :benefAddr2, BENEF_ADDR3 = :benefAddr3, SWIFT_MESSAGE_DATA = :swiftMessageData, TI_MASTER_REF = :tiMasterRef, PRE_REMT_ACC_NO_CUR = :preRemtAccNoCur, REMT_ACC_NO_CUR = :remtAccNoCur, DEBIT_ACC_NO_CUR = :debitAccNoCur, ACK_MESSAGE = :ackMessage, ACK_STATUS = :ackStatus, FG_TRD_PURPOSE_CODE = :fgTrdPurposeCode, FG_TRD_ACCOUNTS = :fgTrdAccounts, FG_TRD_FX_RATE = :fgTrdFxRate, FG_TRD_POST_LOANS = :fgTrdPostLoans, FG_TRD_PRE_LOANS = :fgTrdPreLoans, FG_TRD_LC = :fgTrdLc, FG_TRD_APPL_FX_RATE = :fgTrdApplFxRate, IS_MASTER_VERSION = :isMasterVersion WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgTrdDiVersion> fgtrddiversions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_DI_VERSION WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_DI_VERSION WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdDiVersion records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_DI_VERSION WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdDiVersion.class)
    public List<FgTrdDiVersion> findByIds(@BindList("ids") Collection<String> ids);
}
