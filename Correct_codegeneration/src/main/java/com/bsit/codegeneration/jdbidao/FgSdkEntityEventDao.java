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
import com.bsit.codegeneration.entity.FgSdkEntityEvent;

public interface FgSdkEntityEventDao {

    /**
     * Inserts a new FgSdkEntityEvent and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SDK_ENTITY_EVENT (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name)")
    public int insert(@BindBean FgSdkEntityEvent fgsdkentityevent);

    /**
     * Finds a FgSdkEntityEvent by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SDK_ENTITY_EVENT WHERE FG_SDK_ENTITY_EVENT_id = :id")
    @RegisterBeanMapper(FgSdkEntityEvent.class)
    public Optional<FgSdkEntityEvent> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SDK_ENTITY_EVENT")
    @RegisterBeanMapper(FgSdkEntityEvent.class)
    public List<FgSdkEntityEvent> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SDK_ENTITY_EVENT ORDER BY FG_SDK_ENTITY_EVENT_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSdkEntityEvent.class)
    public List<FgSdkEntityEvent> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSdkEntityEvent and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SDK_ENTITY_EVENT SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name WHERE FG_SDK_ENTITY_EVENT_id = :fgSdkEntityEventId")
    public int update(@BindBean FgSdkEntityEvent fgsdkentityevent);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_ENTITY_EVENT WHERE FG_SDK_ENTITY_EVENT_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SDK_ENTITY_EVENT")
    public long countAll();

    /**
     * Bulk insert multiple FgSdkEntityEvent entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SDK_ENTITY_EVENT (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name)")
    public int[] bulkInsert(@BindBean List<FgSdkEntityEvent> fgsdkentityevents);

    /**
     * Bulk update multiple FgSdkEntityEvent entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SDK_ENTITY_EVENT SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name WHERE FG_SDK_ENTITY_EVENT_id = :fgSdkEntityEventId")
    public int[] bulkUpdate(@BindBean List<FgSdkEntityEvent> fgsdkentityevents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_ENTITY_EVENT WHERE FG_SDK_ENTITY_EVENT_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SDK_ENTITY_EVENT WHERE FG_SDK_ENTITY_EVENT_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgSdkEntityEvent records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SDK_ENTITY_EVENT WHERE FG_SDK_ENTITY_EVENT_id IN (<ids>)")
    @RegisterBeanMapper(FgSdkEntityEvent.class)
    public List<FgSdkEntityEvent> findByIds(@BindList("ids") Collection<Integer> ids);
}
