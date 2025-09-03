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
import com.bsit.codegeneration.entity.FgTdSchemeLimit;

public interface FgTdSchemeLimitDao {

    /**
     * Inserts a new FgTdSchemeLimit and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_SCHEME_LIMIT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, TENOR_START_DAYS, TENOR_END_DAYS, TENOR_MIN_AMOUNT, TENOR_MAX_AMOUNT, VALUE_DATE, PARENT_REF_ID, PARENT_VERSION_ID, VERSION_ID, IS_MASTER_VERSION, TASK_REASON) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :tenorStartDays, :tenorEndDays, :tenorMinAmount, :tenorMaxAmount, :valueDate, :parentRefId, :parentVersionId, :versionId, :isMasterVersion, :taskReason)")
    public int insert(@BindBean FgTdSchemeLimit fgtdschemelimit);

    /**
     * Finds a FgTdSchemeLimit by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_SCHEME_LIMIT WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgTdSchemeLimit.class)
    public Optional<FgTdSchemeLimit> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_SCHEME_LIMIT")
    @RegisterBeanMapper(FgTdSchemeLimit.class)
    public List<FgTdSchemeLimit> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_SCHEME_LIMIT ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdSchemeLimit.class)
    public List<FgTdSchemeLimit> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdSchemeLimit and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_SCHEME_LIMIT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, TENOR_START_DAYS = :tenorStartDays, TENOR_END_DAYS = :tenorEndDays, TENOR_MIN_AMOUNT = :tenorMinAmount, TENOR_MAX_AMOUNT = :tenorMaxAmount, VALUE_DATE = :valueDate, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_MASTER_VERSION = :isMasterVersion, TASK_REASON = :taskReason WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgTdSchemeLimit fgtdschemelimit);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_SCHEME_LIMIT WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_SCHEME_LIMIT")
    public long countAll();

    /**
     * Bulk insert multiple FgTdSchemeLimit entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_SCHEME_LIMIT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, TENOR_START_DAYS, TENOR_END_DAYS, TENOR_MIN_AMOUNT, TENOR_MAX_AMOUNT, VALUE_DATE, PARENT_REF_ID, PARENT_VERSION_ID, VERSION_ID, IS_MASTER_VERSION, TASK_REASON) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :tenorStartDays, :tenorEndDays, :tenorMinAmount, :tenorMaxAmount, :valueDate, :parentRefId, :parentVersionId, :versionId, :isMasterVersion, :taskReason)")
    public int[] bulkInsert(@BindBean List<FgTdSchemeLimit> fgtdschemelimits);

    /**
     * Bulk update multiple FgTdSchemeLimit entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_SCHEME_LIMIT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, TENOR_START_DAYS = :tenorStartDays, TENOR_END_DAYS = :tenorEndDays, TENOR_MIN_AMOUNT = :tenorMinAmount, TENOR_MAX_AMOUNT = :tenorMaxAmount, VALUE_DATE = :valueDate, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, IS_MASTER_VERSION = :isMasterVersion, TASK_REASON = :taskReason WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgTdSchemeLimit> fgtdschemelimits);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_SCHEME_LIMIT WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_SCHEME_LIMIT WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTdSchemeLimit records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_SCHEME_LIMIT WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgTdSchemeLimit.class)
    public List<FgTdSchemeLimit> findByIds(@BindList("ids") Collection<String> ids);
}
