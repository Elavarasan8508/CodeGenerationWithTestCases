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
import com.bsit.codegeneration.entity.KmblScfCounterparty;

public interface KmblScfCounterpartyDao {

    /**
     * Inserts a new KmblScfCounterparty and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO KMBL_SCF_COUNTERPARTY (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, FULFILLMENT_PARTY, IS_TEMPLATE, ABBV_NAME, NAME, CUSTOMER_ROLE, INPUT_BRANCH, BEHALF_OF_BRANCH, ACCOUNT_NUMBER, IFSC_CODE, BANK_NAME, LIMIT_NODE_1, PAYMENT_TYPE, INT_BEARING_PARTY, DEBIT_PARTY, INT_TYPE, BASE_CODE, PENEL_SPREAD, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE_2, MARGIN_RATE, SPREAD_RATE, UPLOAD_REF_ID, INTEREST_RATE, RATE_TYPE, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SELLER_ID_CRN, CP_STATUS, DISPLAY_STATUS, LINE_NO, ANC_ACCOUNT_NUMBER, ANC_IFSC_CODE, ANC_BANK_NAME, ANC_PAYMENT_TYPE, ANC_INT_TYPE, ANC_PENAL_SPREAD, ANC_BASE_CODE, ANC_SPREAD_RATE, VERSION_ID, IS_MASTER_VERSION, BUYER_ID_CRN, LAYOUT_NAME, TASK_REASON, BASE_RATE, MIGRATION_STATUS, MIGRATION_DATE, DMS_EVENT_ID, ANC_BENE_LEI, ACTIVE_PERIOD_UOM, ACTIVE_PERIOD, ACTV_DATE_FIELD, LOAN_REPAYMENT_DATE, LOAN_TENOR, LOAN_TENOR_UOM, PROGRAM_LAYOUT_NAME, LAYOUT_ID, LAYOUT_UUID, ACTV_DATE_DISPLAY, LOAN_TENOR_DAYS, LOAN_TENOR_DISPLAY, LOAN_REPAYMENT_DATE_DISPLAY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantPartyCode, :fulfillmentParty, :isTemplate, :abbvName, :name, :customerRole, :inputBranch, :behalfOfBranch, :accountNumber, :ifscCode, :bankName, :limitNode1, :paymentType, :intBearingParty, :debitParty, :intType, :baseCode, :penelSpread, :cpAbbvName, :cpName, :cpCode, :cpRole, :productType, :gracePeriod, :limitNode2, :marginRate, :spreadRate, :uploadRefId, :interestRate, :rateType, :debitPartyCrn, :creditPartyCrn, :creditPartyName, :sellerIdCrn, :cpStatus, :displayStatus, :lineNo, :ancAccountNumber, :ancIfscCode, :ancBankName, :ancPaymentType, :ancIntType, :ancPenalSpread, :ancBaseCode, :ancSpreadRate, :versionId, :isMasterVersion, :buyerIdCrn, :layoutName, :taskReason, :baseRate, :migrationStatus, :migrationDate, :dmsEventId, :ancBeneLei, :activePeriodUom, :activePeriod, :actvDateField, :loanRepaymentDate, :loanTenor, :loanTenorUom, :programLayoutName, :layoutId, :layoutUuid, :actvDateDisplay, :loanTenorDays, :loanTenorDisplay, :loanRepaymentDateDisplay)")
    public int insert(@BindBean KmblScfCounterparty kmblscfcounterparty);

    /**
     * Finds a KmblScfCounterparty by its ID.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_COUNTERPARTY WHERE VERSION_ID = :id")
    @RegisterBeanMapper(KmblScfCounterparty.class)
    public Optional<KmblScfCounterparty> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_COUNTERPARTY")
    @RegisterBeanMapper(KmblScfCounterparty.class)
    public List<KmblScfCounterparty> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_COUNTERPARTY ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(KmblScfCounterparty.class)
    public List<KmblScfCounterparty> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a KmblScfCounterparty and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE KMBL_SCF_COUNTERPARTY SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY_CODE = :applicantPartyCode, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, ABBV_NAME = :abbvName, NAME = :name, CUSTOMER_ROLE = :customerRole, INPUT_BRANCH = :inputBranch, BEHALF_OF_BRANCH = :behalfOfBranch, ACCOUNT_NUMBER = :accountNumber, IFSC_CODE = :ifscCode, BANK_NAME = :bankName, LIMIT_NODE_1 = :limitNode1, PAYMENT_TYPE = :paymentType, INT_BEARING_PARTY = :intBearingParty, DEBIT_PARTY = :debitParty, INT_TYPE = :intType, BASE_CODE = :baseCode, PENEL_SPREAD = :penelSpread, CP_ABBV_NAME = :cpAbbvName, CP_NAME = :cpName, CP_CODE = :cpCode, CP_ROLE = :cpRole, PRODUCT_TYPE = :productType, GRACE_PERIOD = :gracePeriod, LIMIT_NODE_2 = :limitNode2, MARGIN_RATE = :marginRate, SPREAD_RATE = :spreadRate, UPLOAD_REF_ID = :uploadRefId, INTEREST_RATE = :interestRate, RATE_TYPE = :rateType, DEBIT_PARTY_CRN = :debitPartyCrn, CREDIT_PARTY_CRN = :creditPartyCrn, CREDIT_PARTY_NAME = :creditPartyName, SELLER_ID_CRN = :sellerIdCrn, CP_STATUS = :cpStatus, DISPLAY_STATUS = :displayStatus, LINE_NO = :lineNo, ANC_ACCOUNT_NUMBER = :ancAccountNumber, ANC_IFSC_CODE = :ancIfscCode, ANC_BANK_NAME = :ancBankName, ANC_PAYMENT_TYPE = :ancPaymentType, ANC_INT_TYPE = :ancIntType, ANC_PENAL_SPREAD = :ancPenalSpread, ANC_BASE_CODE = :ancBaseCode, ANC_SPREAD_RATE = :ancSpreadRate, IS_MASTER_VERSION = :isMasterVersion, BUYER_ID_CRN = :buyerIdCrn, LAYOUT_NAME = :layoutName, TASK_REASON = :taskReason, BASE_RATE = :baseRate, MIGRATION_STATUS = :migrationStatus, MIGRATION_DATE = :migrationDate, DMS_EVENT_ID = :dmsEventId, ANC_BENE_LEI = :ancBeneLei, ACTIVE_PERIOD_UOM = :activePeriodUom, ACTIVE_PERIOD = :activePeriod, ACTV_DATE_FIELD = :actvDateField, LOAN_REPAYMENT_DATE = :loanRepaymentDate, LOAN_TENOR = :loanTenor, LOAN_TENOR_UOM = :loanTenorUom, PROGRAM_LAYOUT_NAME = :programLayoutName, LAYOUT_ID = :layoutId, LAYOUT_UUID = :layoutUuid, ACTV_DATE_DISPLAY = :actvDateDisplay, LOAN_TENOR_DAYS = :loanTenorDays, LOAN_TENOR_DISPLAY = :loanTenorDisplay, LOAN_REPAYMENT_DATE_DISPLAY = :loanRepaymentDateDisplay WHERE VERSION_ID = :versionId")
    public int update(@BindBean KmblScfCounterparty kmblscfcounterparty);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM KMBL_SCF_COUNTERPARTY WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM KMBL_SCF_COUNTERPARTY")
    public long countAll();

    /**
     * Bulk insert multiple KmblScfCounterparty entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO KMBL_SCF_COUNTERPARTY (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, FULFILLMENT_PARTY, IS_TEMPLATE, ABBV_NAME, NAME, CUSTOMER_ROLE, INPUT_BRANCH, BEHALF_OF_BRANCH, ACCOUNT_NUMBER, IFSC_CODE, BANK_NAME, LIMIT_NODE_1, PAYMENT_TYPE, INT_BEARING_PARTY, DEBIT_PARTY, INT_TYPE, BASE_CODE, PENEL_SPREAD, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE_2, MARGIN_RATE, SPREAD_RATE, UPLOAD_REF_ID, INTEREST_RATE, RATE_TYPE, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, SELLER_ID_CRN, CP_STATUS, DISPLAY_STATUS, LINE_NO, ANC_ACCOUNT_NUMBER, ANC_IFSC_CODE, ANC_BANK_NAME, ANC_PAYMENT_TYPE, ANC_INT_TYPE, ANC_PENAL_SPREAD, ANC_BASE_CODE, ANC_SPREAD_RATE, VERSION_ID, IS_MASTER_VERSION, BUYER_ID_CRN, LAYOUT_NAME, TASK_REASON, BASE_RATE, MIGRATION_STATUS, MIGRATION_DATE, DMS_EVENT_ID, ANC_BENE_LEI, ACTIVE_PERIOD_UOM, ACTIVE_PERIOD, ACTV_DATE_FIELD, LOAN_REPAYMENT_DATE, LOAN_TENOR, LOAN_TENOR_UOM, PROGRAM_LAYOUT_NAME, LAYOUT_ID, LAYOUT_UUID, ACTV_DATE_DISPLAY, LOAN_TENOR_DAYS, LOAN_TENOR_DISPLAY, LOAN_REPAYMENT_DATE_DISPLAY) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantPartyCode, :fulfillmentParty, :isTemplate, :abbvName, :name, :customerRole, :inputBranch, :behalfOfBranch, :accountNumber, :ifscCode, :bankName, :limitNode1, :paymentType, :intBearingParty, :debitParty, :intType, :baseCode, :penelSpread, :cpAbbvName, :cpName, :cpCode, :cpRole, :productType, :gracePeriod, :limitNode2, :marginRate, :spreadRate, :uploadRefId, :interestRate, :rateType, :debitPartyCrn, :creditPartyCrn, :creditPartyName, :sellerIdCrn, :cpStatus, :displayStatus, :lineNo, :ancAccountNumber, :ancIfscCode, :ancBankName, :ancPaymentType, :ancIntType, :ancPenalSpread, :ancBaseCode, :ancSpreadRate, :versionId, :isMasterVersion, :buyerIdCrn, :layoutName, :taskReason, :baseRate, :migrationStatus, :migrationDate, :dmsEventId, :ancBeneLei, :activePeriodUom, :activePeriod, :actvDateField, :loanRepaymentDate, :loanTenor, :loanTenorUom, :programLayoutName, :layoutId, :layoutUuid, :actvDateDisplay, :loanTenorDays, :loanTenorDisplay, :loanRepaymentDateDisplay)")
    public int[] bulkInsert(@BindBean List<KmblScfCounterparty> kmblscfcounterpartys);

    /**
     * Bulk update multiple KmblScfCounterparty entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE KMBL_SCF_COUNTERPARTY SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY_CODE = :applicantPartyCode, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, ABBV_NAME = :abbvName, NAME = :name, CUSTOMER_ROLE = :customerRole, INPUT_BRANCH = :inputBranch, BEHALF_OF_BRANCH = :behalfOfBranch, ACCOUNT_NUMBER = :accountNumber, IFSC_CODE = :ifscCode, BANK_NAME = :bankName, LIMIT_NODE_1 = :limitNode1, PAYMENT_TYPE = :paymentType, INT_BEARING_PARTY = :intBearingParty, DEBIT_PARTY = :debitParty, INT_TYPE = :intType, BASE_CODE = :baseCode, PENEL_SPREAD = :penelSpread, CP_ABBV_NAME = :cpAbbvName, CP_NAME = :cpName, CP_CODE = :cpCode, CP_ROLE = :cpRole, PRODUCT_TYPE = :productType, GRACE_PERIOD = :gracePeriod, LIMIT_NODE_2 = :limitNode2, MARGIN_RATE = :marginRate, SPREAD_RATE = :spreadRate, UPLOAD_REF_ID = :uploadRefId, INTEREST_RATE = :interestRate, RATE_TYPE = :rateType, DEBIT_PARTY_CRN = :debitPartyCrn, CREDIT_PARTY_CRN = :creditPartyCrn, CREDIT_PARTY_NAME = :creditPartyName, SELLER_ID_CRN = :sellerIdCrn, CP_STATUS = :cpStatus, DISPLAY_STATUS = :displayStatus, LINE_NO = :lineNo, ANC_ACCOUNT_NUMBER = :ancAccountNumber, ANC_IFSC_CODE = :ancIfscCode, ANC_BANK_NAME = :ancBankName, ANC_PAYMENT_TYPE = :ancPaymentType, ANC_INT_TYPE = :ancIntType, ANC_PENAL_SPREAD = :ancPenalSpread, ANC_BASE_CODE = :ancBaseCode, ANC_SPREAD_RATE = :ancSpreadRate, IS_MASTER_VERSION = :isMasterVersion, BUYER_ID_CRN = :buyerIdCrn, LAYOUT_NAME = :layoutName, TASK_REASON = :taskReason, BASE_RATE = :baseRate, MIGRATION_STATUS = :migrationStatus, MIGRATION_DATE = :migrationDate, DMS_EVENT_ID = :dmsEventId, ANC_BENE_LEI = :ancBeneLei, ACTIVE_PERIOD_UOM = :activePeriodUom, ACTIVE_PERIOD = :activePeriod, ACTV_DATE_FIELD = :actvDateField, LOAN_REPAYMENT_DATE = :loanRepaymentDate, LOAN_TENOR = :loanTenor, LOAN_TENOR_UOM = :loanTenorUom, PROGRAM_LAYOUT_NAME = :programLayoutName, LAYOUT_ID = :layoutId, LAYOUT_UUID = :layoutUuid, ACTV_DATE_DISPLAY = :actvDateDisplay, LOAN_TENOR_DAYS = :loanTenorDays, LOAN_TENOR_DISPLAY = :loanTenorDisplay, LOAN_REPAYMENT_DATE_DISPLAY = :loanRepaymentDateDisplay WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<KmblScfCounterparty> kmblscfcounterpartys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM KMBL_SCF_COUNTERPARTY WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM KMBL_SCF_COUNTERPARTY WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple KmblScfCounterparty records by their IDs.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_COUNTERPARTY WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(KmblScfCounterparty.class)
    public List<KmblScfCounterparty> findByIds(@BindList("ids") Collection<String> ids);
}
