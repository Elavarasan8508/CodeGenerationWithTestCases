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
import com.bsit.codegeneration.entity.FgTdOptionalLimit;

public interface FgTdOptionalLimitDao {

    /**
     * Inserts a new FgTdOptionalLimit and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_OPTIONAL_LIMIT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SCHEME_CODE, TENOR_START_DAYS, TENOR_END_DAYS, TENOR_MIN_AMOUNT, TENOR_MAX_AMOUNT, VALUE_DATE, PARENT_REF_ID, PARENT_VERSION_ID, VERSION_ID, IS_MASTER_VERSION, TASK_REASON, START_DATE, END_DATE, ORIGIN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :schemeCode, :tenorStartDays, :tenorEndDays, :tenorMinAmount, :tenorMaxAmount, :valueDate, :parentRefId, :parentVersionId, :versionId, :isMasterVersion, :taskReason, :startDate, :endDate, :origin)")
    public int insert(@BindBean FgTdOptionalLimit fgtdoptionallimit);

    /**
     * Finds a FgTdOptionalLimit by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_OPTIONAL_LIMIT WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgTdOptionalLimit.class)
    public Optional<FgTdOptionalLimit> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_OPTIONAL_LIMIT")
    @RegisterBeanMapper(FgTdOptionalLimit.class)
    public List<FgTdOptionalLimit> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_OPTIONAL_LIMIT ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdOptionalLimit.class)
    public List<FgTdOptionalLimit> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdOptionalLimit and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_OPTIONAL_LIMIT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SCHEME_CODE = :schemeCode, TENOR_START_DAYS = :tenorStartDays, TENOR_END_DAYS = :tenorEndDays, TENOR_MIN_AMOUNT = :tenorMinAmount, TENOR_MAX_AMOUNT = :tenorMaxAmount, VALUE_DATE = :valueDate, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_MASTER_VERSION = :isMasterVersion, TASK_REASON = :taskReason, START_DATE = :startDate, END_DATE = :endDate, ORIGIN = :origin WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgTdOptionalLimit fgtdoptionallimit);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_OPTIONAL_LIMIT WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_OPTIONAL_LIMIT")
    public long countAll();

    /**
     * Bulk insert multiple FgTdOptionalLimit entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_OPTIONAL_LIMIT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SCHEME_CODE, TENOR_START_DAYS, TENOR_END_DAYS, TENOR_MIN_AMOUNT, TENOR_MAX_AMOUNT, VALUE_DATE, PARENT_REF_ID, PARENT_VERSION_ID, VERSION_ID, IS_MASTER_VERSION, TASK_REASON, START_DATE, END_DATE, ORIGIN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :schemeCode, :tenorStartDays, :tenorEndDays, :tenorMinAmount, :tenorMaxAmount, :valueDate, :parentRefId, :parentVersionId, :versionId, :isMasterVersion, :taskReason, :startDate, :endDate, :origin)")
    public int[] bulkInsert(@BindBean List<FgTdOptionalLimit> fgtdoptionallimits);

    /**
     * Bulk update multiple FgTdOptionalLimit entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_OPTIONAL_LIMIT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SCHEME_CODE = :schemeCode, TENOR_START_DAYS = :tenorStartDays, TENOR_END_DAYS = :tenorEndDays, TENOR_MIN_AMOUNT = :tenorMinAmount, TENOR_MAX_AMOUNT = :tenorMaxAmount, VALUE_DATE = :valueDate, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_MASTER_VERSION = :isMasterVersion, TASK_REASON = :taskReason, START_DATE = :startDate, END_DATE = :endDate, ORIGIN = :origin WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgTdOptionalLimit> fgtdoptionallimits);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_OPTIONAL_LIMIT WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_OPTIONAL_LIMIT WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTdOptionalLimit records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_OPTIONAL_LIMIT WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgTdOptionalLimit.class)
    public List<FgTdOptionalLimit> findByIds(@BindList("ids") Collection<String> ids);
}
