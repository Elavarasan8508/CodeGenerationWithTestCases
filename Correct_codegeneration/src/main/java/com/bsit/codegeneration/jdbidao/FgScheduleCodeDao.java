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
import com.bsit.codegeneration.entity.FgScheduleCode;

public interface FgScheduleCodeDao {

    /**
     * Inserts a new FgScheduleCode and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SCHEDULE_CODE (ID, END_DATE, NAME, PROCESSING_TYPE, START_DATE, TEMPLATE, TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, DESCRIPTION, APPLICANT_PARTY_CODE, CONFIG_REF_ID, CATEGORY_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PROCESS_ID, REFERENCE_ID, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE) VALUES (:id, :endDate, :name, :processingType, :startDate, :template, :typeCode, :partyId, :partyVersionId, :description, :applicantPartyCode, :configRefId, :categoryCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :subTypeCode, :entityTypeCode, :entitySubTypeCode, :processId, :referenceId, :versionId, :isMasterVersion, :stageCode)")
    public int insert(@BindBean FgScheduleCode fgschedulecode);

    /**
     * Finds a FgScheduleCode by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SCHEDULE_CODE WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgScheduleCode.class)
    public Optional<FgScheduleCode> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SCHEDULE_CODE")
    @RegisterBeanMapper(FgScheduleCode.class)
    public List<FgScheduleCode> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SCHEDULE_CODE ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgScheduleCode.class)
    public List<FgScheduleCode> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgScheduleCode and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SCHEDULE_CODE SET END_DATE = :endDate, NAME = :name, PROCESSING_TYPE = :processingType, START_DATE = :startDate, TEMPLATE = :template, TYPE_CODE = :typeCode, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, DESCRIPTION = :description, APPLICANT_PARTY_CODE = :applicantPartyCode, CONFIG_REF_ID = :configRefId, CATEGORY_CODE = :categoryCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, SUB_TYPE_CODE = :subTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, PROCESS_ID = :processId, REFERENCE_ID = :referenceId, IS_MASTER_VERSION = :isMasterVersion, STAGE_CODE = :stageCode WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgScheduleCode fgschedulecode);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SCHEDULE_CODE WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SCHEDULE_CODE")
    public long countAll();

    /**
     * Bulk insert multiple FgScheduleCode entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SCHEDULE_CODE (ID, END_DATE, NAME, PROCESSING_TYPE, START_DATE, TEMPLATE, TYPE_CODE, PARTY_ID, PARTY_VERSION_ID, DESCRIPTION, APPLICANT_PARTY_CODE, CONFIG_REF_ID, CATEGORY_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PROCESS_ID, REFERENCE_ID, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE) VALUES (:id, :endDate, :name, :processingType, :startDate, :template, :typeCode, :partyId, :partyVersionId, :description, :applicantPartyCode, :configRefId, :categoryCode, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :subTypeCode, :entityTypeCode, :entitySubTypeCode, :processId, :referenceId, :versionId, :isMasterVersion, :stageCode)")
    public int[] bulkInsert(@BindBean List<FgScheduleCode> fgschedulecodes);

    /**
     * Bulk update multiple FgScheduleCode entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SCHEDULE_CODE SET END_DATE = :endDate, NAME = :name, PROCESSING_TYPE = :processingType, START_DATE = :startDate, TEMPLATE = :template, TYPE_CODE = :typeCode, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, DESCRIPTION = :description, APPLICANT_PARTY_CODE = :applicantPartyCode, CONFIG_REF_ID = :configRefId, CATEGORY_CODE = :categoryCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, SUB_TYPE_CODE = :subTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, PROCESS_ID = :processId, REFERENCE_ID = :referenceId, IS_MASTER_VERSION = :isMasterVersion, STAGE_CODE = :stageCode WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgScheduleCode> fgschedulecodes);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SCHEDULE_CODE WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SCHEDULE_CODE WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgScheduleCode records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SCHEDULE_CODE WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgScheduleCode.class)
    public List<FgScheduleCode> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgScheduleCode records by partyVersionId.
     */
    @SqlQuery("SELECT * FROM FG_SCHEDULE_CODE WHERE PARTY_VERSION_ID = :partyVersionId")
    @RegisterBeanMapper(FgScheduleCode.class)
    public List<FgScheduleCode> findByPartyVersionId(@Bind("partyVersionId") int partyVersionId);

    /**
     * Finds all FgScheduleCode records by partyId.
     */
    @SqlQuery("SELECT * FROM FG_SCHEDULE_CODE WHERE PARTY_ID = :partyId")
    @RegisterBeanMapper(FgScheduleCode.class)
    public List<FgScheduleCode> findByPartyId(@Bind("partyId") int partyId);
}
