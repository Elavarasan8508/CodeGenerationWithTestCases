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
import com.bsit.codegeneration.entity.FgTdSchemeCodesMaster;

public interface FgTdSchemeCodesMasterDao {

    /**
     * Inserts a new FgTdSchemeCodesMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_SCHEME_CODES_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TENOR, INTEREST_VALUE, FIN_SCHEME_CODE, INTEREST_CALCULATION, START_TENOR, END_TENOR, VERSION_ID, IS_MASTER_VERSION, TASK_REASON, PARENT_VERSION_ID, PARENT_REF_ID, ORIGIN, ACCOUNT_SCHEME_CODE, TD_TYPE, MIN_AMOUNT, MAX_AMOUNT, TD_REQUEST) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :tenor, :interestValue, :finSchemeCode, :interestCalculation, :startTenor, :endTenor, :versionId, :isMasterVersion, :taskReason, :parentVersionId, :parentRefId, :origin, :accountSchemeCode, :tdType, :minAmount, :maxAmount, :tdRequest)")
    public int insert(@BindBean FgTdSchemeCodesMaster fgtdschemecodesmaster);

    /**
     * Finds a FgTdSchemeCodesMaster by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_SCHEME_CODES_MASTER WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgTdSchemeCodesMaster.class)
    public Optional<FgTdSchemeCodesMaster> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_SCHEME_CODES_MASTER")
    @RegisterBeanMapper(FgTdSchemeCodesMaster.class)
    public List<FgTdSchemeCodesMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_SCHEME_CODES_MASTER ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdSchemeCodesMaster.class)
    public List<FgTdSchemeCodesMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdSchemeCodesMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_SCHEME_CODES_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, TENOR = :tenor, INTEREST_VALUE = :interestValue, FIN_SCHEME_CODE = :finSchemeCode, INTEREST_CALCULATION = :interestCalculation, START_TENOR = :startTenor, END_TENOR = :endTenor, IS_MASTER_VERSION = :isMasterVersion, TASK_REASON = :taskReason, PARENT_VERSION_ID = :parentVersionId, PARENT_REF_ID = :parentRefId, ORIGIN = :origin, ACCOUNT_SCHEME_CODE = :accountSchemeCode, TD_TYPE = :tdType, MIN_AMOUNT = :minAmount, MAX_AMOUNT = :maxAmount, TD_REQUEST = :tdRequest WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgTdSchemeCodesMaster fgtdschemecodesmaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_SCHEME_CODES_MASTER WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_SCHEME_CODES_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple FgTdSchemeCodesMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_SCHEME_CODES_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, TENOR, INTEREST_VALUE, FIN_SCHEME_CODE, INTEREST_CALCULATION, START_TENOR, END_TENOR, VERSION_ID, IS_MASTER_VERSION, TASK_REASON, PARENT_VERSION_ID, PARENT_REF_ID, ORIGIN, ACCOUNT_SCHEME_CODE, TD_TYPE, MIN_AMOUNT, MAX_AMOUNT, TD_REQUEST) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :tenor, :interestValue, :finSchemeCode, :interestCalculation, :startTenor, :endTenor, :versionId, :isMasterVersion, :taskReason, :parentVersionId, :parentRefId, :origin, :accountSchemeCode, :tdType, :minAmount, :maxAmount, :tdRequest)")
    public int[] bulkInsert(@BindBean List<FgTdSchemeCodesMaster> fgtdschemecodesmasters);

    /**
     * Bulk update multiple FgTdSchemeCodesMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_SCHEME_CODES_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, TENOR = :tenor, INTEREST_VALUE = :interestValue, FIN_SCHEME_CODE = :finSchemeCode, INTEREST_CALCULATION = :interestCalculation, START_TENOR = :startTenor, END_TENOR = :endTenor, IS_MASTER_VERSION = :isMasterVersion, TASK_REASON = :taskReason, PARENT_VERSION_ID = :parentVersionId, PARENT_REF_ID = :parentRefId, ORIGIN = :origin, ACCOUNT_SCHEME_CODE = :accountSchemeCode, TD_TYPE = :tdType, MIN_AMOUNT = :minAmount, MAX_AMOUNT = :maxAmount, TD_REQUEST = :tdRequest WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgTdSchemeCodesMaster> fgtdschemecodesmasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_SCHEME_CODES_MASTER WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_SCHEME_CODES_MASTER WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTdSchemeCodesMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_SCHEME_CODES_MASTER WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgTdSchemeCodesMaster.class)
    public List<FgTdSchemeCodesMaster> findByIds(@BindList("ids") Collection<String> ids);
}
