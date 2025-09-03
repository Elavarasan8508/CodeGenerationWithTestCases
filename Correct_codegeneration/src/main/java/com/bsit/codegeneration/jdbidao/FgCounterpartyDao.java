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
import com.bsit.codegeneration.entity.FgCounterparty;

public interface FgCounterpartyDao {

    /**
     * Inserts a new FgCounterparty and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_COUNTERPARTY (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, FULFILLMENT_PARTY, IS_TEMPLATE, ABBV_NAME, NAME, CUSTOMER_ROLE, INPUT_BRANCH, BEHALF_OF_BRANCH, ACCOUNT_NUMBER, IFSC_CODE, BANK_NAME, LIMIT_NODE_1, PAYMENT_TYPE, INT_BEARING_PARTY, DEBIT_PARTY, INT_TYPE, BASE_CODE, PENEL_SPREAD, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE_2, MARGIN_RATE, SPREAD_RATE, UPLOAD_REF_ID, INTEREST_RATE, RATE_TYPE, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, BUYER_ID, SELLER_ID, CP_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantPartyCode, :fulfillmentParty, :isTemplate, :abbvName, :name, :customerRole, :inputBranch, :behalfOfBranch, :accountNumber, :ifscCode, :bankName, :limitNode1, :paymentType, :intBearingParty, :debitParty, :intType, :baseCode, :penelSpread, :cpAbbvName, :cpName, :cpCode, :cpRole, :productType, :gracePeriod, :limitNode2, :marginRate, :spreadRate, :uploadRefId, :interestRate, :rateType, :debitPartyCrn, :creditPartyCrn, :creditPartyName, :buyerId, :sellerId, :cpStatus)")
    public int insert(@BindBean FgCounterparty fgcounterparty);

    /**
     * Finds a FgCounterparty by its ID.
     */
    @SqlQuery("SELECT * FROM FG_COUNTERPARTY WHERE ID = :id")
    @RegisterBeanMapper(FgCounterparty.class)
    public Optional<FgCounterparty> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_COUNTERPARTY")
    @RegisterBeanMapper(FgCounterparty.class)
    public List<FgCounterparty> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_COUNTERPARTY ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgCounterparty.class)
    public List<FgCounterparty> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgCounterparty and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_COUNTERPARTY SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY_CODE = :applicantPartyCode, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, ABBV_NAME = :abbvName, NAME = :name, CUSTOMER_ROLE = :customerRole, INPUT_BRANCH = :inputBranch, BEHALF_OF_BRANCH = :behalfOfBranch, ACCOUNT_NUMBER = :accountNumber, IFSC_CODE = :ifscCode, BANK_NAME = :bankName, LIMIT_NODE_1 = :limitNode1, PAYMENT_TYPE = :paymentType, INT_BEARING_PARTY = :intBearingParty, DEBIT_PARTY = :debitParty, INT_TYPE = :intType, BASE_CODE = :baseCode, PENEL_SPREAD = :penelSpread, CP_ABBV_NAME = :cpAbbvName, CP_NAME = :cpName, CP_CODE = :cpCode, CP_ROLE = :cpRole, PRODUCT_TYPE = :productType, GRACE_PERIOD = :gracePeriod, LIMIT_NODE_2 = :limitNode2, MARGIN_RATE = :marginRate, SPREAD_RATE = :spreadRate, UPLOAD_REF_ID = :uploadRefId, INTEREST_RATE = :interestRate, RATE_TYPE = :rateType, DEBIT_PARTY_CRN = :debitPartyCrn, CREDIT_PARTY_CRN = :creditPartyCrn, CREDIT_PARTY_NAME = :creditPartyName, BUYER_ID = :buyerId, SELLER_ID = :sellerId, CP_STATUS = :cpStatus WHERE ID = :id")
    public int update(@BindBean FgCounterparty fgcounterparty);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_COUNTERPARTY WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_COUNTERPARTY")
    public long countAll();

    /**
     * Bulk insert multiple FgCounterparty entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_COUNTERPARTY (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, FULFILLMENT_PARTY, IS_TEMPLATE, ABBV_NAME, NAME, CUSTOMER_ROLE, INPUT_BRANCH, BEHALF_OF_BRANCH, ACCOUNT_NUMBER, IFSC_CODE, BANK_NAME, LIMIT_NODE_1, PAYMENT_TYPE, INT_BEARING_PARTY, DEBIT_PARTY, INT_TYPE, BASE_CODE, PENEL_SPREAD, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, PRODUCT_TYPE, GRACE_PERIOD, LIMIT_NODE_2, MARGIN_RATE, SPREAD_RATE, UPLOAD_REF_ID, INTEREST_RATE, RATE_TYPE, DEBIT_PARTY_CRN, CREDIT_PARTY_CRN, CREDIT_PARTY_NAME, BUYER_ID, SELLER_ID, CP_STATUS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantPartyCode, :fulfillmentParty, :isTemplate, :abbvName, :name, :customerRole, :inputBranch, :behalfOfBranch, :accountNumber, :ifscCode, :bankName, :limitNode1, :paymentType, :intBearingParty, :debitParty, :intType, :baseCode, :penelSpread, :cpAbbvName, :cpName, :cpCode, :cpRole, :productType, :gracePeriod, :limitNode2, :marginRate, :spreadRate, :uploadRefId, :interestRate, :rateType, :debitPartyCrn, :creditPartyCrn, :creditPartyName, :buyerId, :sellerId, :cpStatus)")
    public int[] bulkInsert(@BindBean List<FgCounterparty> fgcounterpartys);

    /**
     * Bulk update multiple FgCounterparty entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_COUNTERPARTY SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY_CODE = :applicantPartyCode, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, ABBV_NAME = :abbvName, NAME = :name, CUSTOMER_ROLE = :customerRole, INPUT_BRANCH = :inputBranch, BEHALF_OF_BRANCH = :behalfOfBranch, ACCOUNT_NUMBER = :accountNumber, IFSC_CODE = :ifscCode, BANK_NAME = :bankName, LIMIT_NODE_1 = :limitNode1, PAYMENT_TYPE = :paymentType, INT_BEARING_PARTY = :intBearingParty, DEBIT_PARTY = :debitParty, INT_TYPE = :intType, BASE_CODE = :baseCode, PENEL_SPREAD = :penelSpread, CP_ABBV_NAME = :cpAbbvName, CP_NAME = :cpName, CP_CODE = :cpCode, CP_ROLE = :cpRole, PRODUCT_TYPE = :productType, GRACE_PERIOD = :gracePeriod, LIMIT_NODE_2 = :limitNode2, MARGIN_RATE = :marginRate, SPREAD_RATE = :spreadRate, UPLOAD_REF_ID = :uploadRefId, INTEREST_RATE = :interestRate, RATE_TYPE = :rateType, DEBIT_PARTY_CRN = :debitPartyCrn, CREDIT_PARTY_CRN = :creditPartyCrn, CREDIT_PARTY_NAME = :creditPartyName, BUYER_ID = :buyerId, SELLER_ID = :sellerId, CP_STATUS = :cpStatus WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgCounterparty> fgcounterpartys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_COUNTERPARTY WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_COUNTERPARTY WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgCounterparty records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_COUNTERPARTY WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgCounterparty.class)
    public List<FgCounterparty> findByIds(@BindList("ids") Collection<String> ids);
}
