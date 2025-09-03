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
import com.bsit.codegeneration.entity.FgTdLimitConfig;

public interface FgTdLimitConfigDao {

    /**
     * Inserts a new FgTdLimitConfig and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_LIMIT_CONFIG (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, LIQ_MAX_LIMIT, MIN_BOOK_LIMIT, MAX_BOOK_LIMIT, DAILY_BOOKING_LIMIT, TENOR_MAX_AMOUNT, TENOR_MIN_DAYS, TENOR_MAX_DAYS, SCHEME_CODES, ABOVE_AMT, BELOW_AMT, A_START_NUMBER, A_START_TYPE, A_END_NUMBER, A_END_TYPE, B_START_NUMBER, B_START_TYPE, B_END_NUMBER, B_END_TYPE, VERSION_ID, IS_MASTER_VERSION, PARENT_REF_ID, PARENT_ID, PARENT_VERSION_ID, ABOVE_RANGE, BELOW_RANGE, TASK_REASON, MIN_TENOR, MAX_TENOR, MIN_TENOR_TYPE, MAX_TENOR_TYPE, ORIGIN, TD_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :liqMaxLimit, :minBookLimit, :maxBookLimit, :dailyBookingLimit, :tenorMaxAmount, :tenorMinDays, :tenorMaxDays, :schemeCodes, :aboveAmt, :belowAmt, :aStartNumber, :aStartType, :aEndNumber, :aEndType, :bStartNumber, :bStartType, :bEndNumber, :bEndType, :versionId, :isMasterVersion, :parentRefId, :parentId, :parentVersionId, :aboveRange, :belowRange, :taskReason, :minTenor, :maxTenor, :minTenorType, :maxTenorType, :origin, :tdType)")
    public int insert(@BindBean FgTdLimitConfig fgtdlimitconfig);

    /**
     * Finds a FgTdLimitConfig by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_LIMIT_CONFIG WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgTdLimitConfig.class)
    public Optional<FgTdLimitConfig> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_LIMIT_CONFIG")
    @RegisterBeanMapper(FgTdLimitConfig.class)
    public List<FgTdLimitConfig> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_LIMIT_CONFIG ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdLimitConfig.class)
    public List<FgTdLimitConfig> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdLimitConfig and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_LIMIT_CONFIG SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, LIQ_MAX_LIMIT = :liqMaxLimit, MIN_BOOK_LIMIT = :minBookLimit, MAX_BOOK_LIMIT = :maxBookLimit, DAILY_BOOKING_LIMIT = :dailyBookingLimit, TENOR_MAX_AMOUNT = :tenorMaxAmount, TENOR_MIN_DAYS = :tenorMinDays, TENOR_MAX_DAYS = :tenorMaxDays, SCHEME_CODES = :schemeCodes, ABOVE_AMT = :aboveAmt, BELOW_AMT = :belowAmt, A_START_NUMBER = :aStartNumber, A_START_TYPE = :aStartType, A_END_NUMBER = :aEndNumber, A_END_TYPE = :aEndType, B_START_NUMBER = :bStartNumber, B_START_TYPE = :bStartType, B_END_NUMBER = :bEndNumber, B_END_TYPE = :bEndType, IS_MASTER_VERSION = :isMasterVersion, PARENT_REF_ID = :parentRefId, PARENT_ID = :parentId, PARENT_VERSION_ID = :parentVersionId, ABOVE_RANGE = :aboveRange, BELOW_RANGE = :belowRange, TASK_REASON = :taskReason, MIN_TENOR = :minTenor, MAX_TENOR = :maxTenor, MIN_TENOR_TYPE = :minTenorType, MAX_TENOR_TYPE = :maxTenorType, ORIGIN = :origin, TD_TYPE = :tdType WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgTdLimitConfig fgtdlimitconfig);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_LIMIT_CONFIG WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_LIMIT_CONFIG")
    public long countAll();

    /**
     * Bulk insert multiple FgTdLimitConfig entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_LIMIT_CONFIG (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, LIQ_MAX_LIMIT, MIN_BOOK_LIMIT, MAX_BOOK_LIMIT, DAILY_BOOKING_LIMIT, TENOR_MAX_AMOUNT, TENOR_MIN_DAYS, TENOR_MAX_DAYS, SCHEME_CODES, ABOVE_AMT, BELOW_AMT, A_START_NUMBER, A_START_TYPE, A_END_NUMBER, A_END_TYPE, B_START_NUMBER, B_START_TYPE, B_END_NUMBER, B_END_TYPE, VERSION_ID, IS_MASTER_VERSION, PARENT_REF_ID, PARENT_ID, PARENT_VERSION_ID, ABOVE_RANGE, BELOW_RANGE, TASK_REASON, MIN_TENOR, MAX_TENOR, MIN_TENOR_TYPE, MAX_TENOR_TYPE, ORIGIN, TD_TYPE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :liqMaxLimit, :minBookLimit, :maxBookLimit, :dailyBookingLimit, :tenorMaxAmount, :tenorMinDays, :tenorMaxDays, :schemeCodes, :aboveAmt, :belowAmt, :aStartNumber, :aStartType, :aEndNumber, :aEndType, :bStartNumber, :bStartType, :bEndNumber, :bEndType, :versionId, :isMasterVersion, :parentRefId, :parentId, :parentVersionId, :aboveRange, :belowRange, :taskReason, :minTenor, :maxTenor, :minTenorType, :maxTenorType, :origin, :tdType)")
    public int[] bulkInsert(@BindBean List<FgTdLimitConfig> fgtdlimitconfigs);

    /**
     * Bulk update multiple FgTdLimitConfig entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_LIMIT_CONFIG SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, LIQ_MAX_LIMIT = :liqMaxLimit, MIN_BOOK_LIMIT = :minBookLimit, MAX_BOOK_LIMIT = :maxBookLimit, DAILY_BOOKING_LIMIT = :dailyBookingLimit, TENOR_MAX_AMOUNT = :tenorMaxAmount, TENOR_MIN_DAYS = :tenorMinDays, TENOR_MAX_DAYS = :tenorMaxDays, SCHEME_CODES = :schemeCodes, ABOVE_AMT = :aboveAmt, BELOW_AMT = :belowAmt, A_START_NUMBER = :aStartNumber, A_START_TYPE = :aStartType, A_END_NUMBER = :aEndNumber, A_END_TYPE = :aEndType, B_START_NUMBER = :bStartNumber, B_START_TYPE = :bStartType, B_END_NUMBER = :bEndNumber, B_END_TYPE = :bEndType, IS_MASTER_VERSION = :isMasterVersion, PARENT_REF_ID = :parentRefId, PARENT_ID = :parentId, PARENT_VERSION_ID = :parentVersionId, ABOVE_RANGE = :aboveRange, BELOW_RANGE = :belowRange, TASK_REASON = :taskReason, MIN_TENOR = :minTenor, MAX_TENOR = :maxTenor, MIN_TENOR_TYPE = :minTenorType, MAX_TENOR_TYPE = :maxTenorType, ORIGIN = :origin, TD_TYPE = :tdType WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgTdLimitConfig> fgtdlimitconfigs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_LIMIT_CONFIG WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_LIMIT_CONFIG WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTdLimitConfig records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_LIMIT_CONFIG WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgTdLimitConfig.class)
    public List<FgTdLimitConfig> findByIds(@BindList("ids") Collection<String> ids);
}
