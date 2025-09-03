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
import com.bsit.codegeneration.entity.KmblScfCounterpartyRel;

public interface KmblScfCounterpartyRelDao {

    /**
     * Inserts a new KmblScfCounterpartyRel and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO KMBL_SCF_COUNTERPARTY_REL (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, CP_RATE_TYPE, CP_LIMIT_NODE_2, CP_ACCOUNT_NUMBER, CP_IFSC_CODE, CP_BANK_NAME, CP_PAYMENT_TYPE, CP_INT_TYPE, CP_PENAL_SPREAD, CP_BASE_CODE, VERSION_ID, IS_MASTER_VERSION, DISPLAY_STATUS, INT_BEARING_PARTY, ABBV_NAME, CUSTOMER_ROLE, PRODUCT_TYPE, LAYOUT_NAME, PORTAL_REF_ID, TASK_REASON, CP_GRACE_PERIOD, CP_SPREAD_RATE, CP_MARGIN_RATE, UPLOAD_REF_ID, DMS_EVENT_ID, CP_BENE_LEI, REQUEST_INITIATION_TYPE, PROGRAM_LAYOUT_NAME, LAYOUT_ID, LAYOUT_UUID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :cpAbbvName, :cpName, :cpCode, :cpRole, :cpRateType, :cpLimitNode2, :cpAccountNumber, :cpIfscCode, :cpBankName, :cpPaymentType, :cpIntType, :cpPenalSpread, :cpBaseCode, :versionId, :isMasterVersion, :displayStatus, :intBearingParty, :abbvName, :customerRole, :productType, :layoutName, :portalRefId, :taskReason, :cpGracePeriod, :cpSpreadRate, :cpMarginRate, :uploadRefId, :dmsEventId, :cpBeneLei, :requestInitiationType, :programLayoutName, :layoutId, :layoutUuid)")
    public int insert(@BindBean KmblScfCounterpartyRel kmblscfcounterpartyrel);

    /**
     * Finds a KmblScfCounterpartyRel by its ID.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_COUNTERPARTY_REL WHERE VERSION_ID = :id")
    @RegisterBeanMapper(KmblScfCounterpartyRel.class)
    public Optional<KmblScfCounterpartyRel> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_COUNTERPARTY_REL")
    @RegisterBeanMapper(KmblScfCounterpartyRel.class)
    public List<KmblScfCounterpartyRel> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_COUNTERPARTY_REL ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(KmblScfCounterpartyRel.class)
    public List<KmblScfCounterpartyRel> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a KmblScfCounterpartyRel and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE KMBL_SCF_COUNTERPARTY_REL SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CP_ABBV_NAME = :cpAbbvName, CP_NAME = :cpName, CP_CODE = :cpCode, CP_ROLE = :cpRole, CP_RATE_TYPE = :cpRateType, CP_LIMIT_NODE_2 = :cpLimitNode2, CP_ACCOUNT_NUMBER = :cpAccountNumber, CP_IFSC_CODE = :cpIfscCode, CP_BANK_NAME = :cpBankName, CP_PAYMENT_TYPE = :cpPaymentType, CP_INT_TYPE = :cpIntType, CP_PENAL_SPREAD = :cpPenalSpread, CP_BASE_CODE = :cpBaseCode, IS_MASTER_VERSION = :isMasterVersion, DISPLAY_STATUS = :displayStatus, INT_BEARING_PARTY = :intBearingParty, ABBV_NAME = :abbvName, CUSTOMER_ROLE = :customerRole, PRODUCT_TYPE = :productType, LAYOUT_NAME = :layoutName, PORTAL_REF_ID = :portalRefId, TASK_REASON = :taskReason, CP_GRACE_PERIOD = :cpGracePeriod, CP_SPREAD_RATE = :cpSpreadRate, CP_MARGIN_RATE = :cpMarginRate, UPLOAD_REF_ID = :uploadRefId, DMS_EVENT_ID = :dmsEventId, CP_BENE_LEI = :cpBeneLei, REQUEST_INITIATION_TYPE = :requestInitiationType, PROGRAM_LAYOUT_NAME = :programLayoutName, LAYOUT_ID = :layoutId, LAYOUT_UUID = :layoutUuid WHERE VERSION_ID = :versionId")
    public int update(@BindBean KmblScfCounterpartyRel kmblscfcounterpartyrel);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM KMBL_SCF_COUNTERPARTY_REL WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM KMBL_SCF_COUNTERPARTY_REL")
    public long countAll();

    /**
     * Bulk insert multiple KmblScfCounterpartyRel entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO KMBL_SCF_COUNTERPARTY_REL (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CP_ABBV_NAME, CP_NAME, CP_CODE, CP_ROLE, CP_RATE_TYPE, CP_LIMIT_NODE_2, CP_ACCOUNT_NUMBER, CP_IFSC_CODE, CP_BANK_NAME, CP_PAYMENT_TYPE, CP_INT_TYPE, CP_PENAL_SPREAD, CP_BASE_CODE, VERSION_ID, IS_MASTER_VERSION, DISPLAY_STATUS, INT_BEARING_PARTY, ABBV_NAME, CUSTOMER_ROLE, PRODUCT_TYPE, LAYOUT_NAME, PORTAL_REF_ID, TASK_REASON, CP_GRACE_PERIOD, CP_SPREAD_RATE, CP_MARGIN_RATE, UPLOAD_REF_ID, DMS_EVENT_ID, CP_BENE_LEI, REQUEST_INITIATION_TYPE, PROGRAM_LAYOUT_NAME, LAYOUT_ID, LAYOUT_UUID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :cpAbbvName, :cpName, :cpCode, :cpRole, :cpRateType, :cpLimitNode2, :cpAccountNumber, :cpIfscCode, :cpBankName, :cpPaymentType, :cpIntType, :cpPenalSpread, :cpBaseCode, :versionId, :isMasterVersion, :displayStatus, :intBearingParty, :abbvName, :customerRole, :productType, :layoutName, :portalRefId, :taskReason, :cpGracePeriod, :cpSpreadRate, :cpMarginRate, :uploadRefId, :dmsEventId, :cpBeneLei, :requestInitiationType, :programLayoutName, :layoutId, :layoutUuid)")
    public int[] bulkInsert(@BindBean List<KmblScfCounterpartyRel> kmblscfcounterpartyrels);

    /**
     * Bulk update multiple KmblScfCounterpartyRel entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE KMBL_SCF_COUNTERPARTY_REL SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CP_ABBV_NAME = :cpAbbvName, CP_NAME = :cpName, CP_CODE = :cpCode, CP_ROLE = :cpRole, CP_RATE_TYPE = :cpRateType, CP_LIMIT_NODE_2 = :cpLimitNode2, CP_ACCOUNT_NUMBER = :cpAccountNumber, CP_IFSC_CODE = :cpIfscCode, CP_BANK_NAME = :cpBankName, CP_PAYMENT_TYPE = :cpPaymentType, CP_INT_TYPE = :cpIntType, CP_PENAL_SPREAD = :cpPenalSpread, CP_BASE_CODE = :cpBaseCode, IS_MASTER_VERSION = :isMasterVersion, DISPLAY_STATUS = :displayStatus, INT_BEARING_PARTY = :intBearingParty, ABBV_NAME = :abbvName, CUSTOMER_ROLE = :customerRole, PRODUCT_TYPE = :productType, LAYOUT_NAME = :layoutName, PORTAL_REF_ID = :portalRefId, TASK_REASON = :taskReason, CP_GRACE_PERIOD = :cpGracePeriod, CP_SPREAD_RATE = :cpSpreadRate, CP_MARGIN_RATE = :cpMarginRate, UPLOAD_REF_ID = :uploadRefId, DMS_EVENT_ID = :dmsEventId, CP_BENE_LEI = :cpBeneLei, REQUEST_INITIATION_TYPE = :requestInitiationType, PROGRAM_LAYOUT_NAME = :programLayoutName, LAYOUT_ID = :layoutId, LAYOUT_UUID = :layoutUuid WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<KmblScfCounterpartyRel> kmblscfcounterpartyrels);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM KMBL_SCF_COUNTERPARTY_REL WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM KMBL_SCF_COUNTERPARTY_REL WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple KmblScfCounterpartyRel records by their IDs.
     */
    @SqlQuery("SELECT * FROM KMBL_SCF_COUNTERPARTY_REL WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(KmblScfCounterpartyRel.class)
    public List<KmblScfCounterpartyRel> findByIds(@BindList("ids") Collection<String> ids);
}
