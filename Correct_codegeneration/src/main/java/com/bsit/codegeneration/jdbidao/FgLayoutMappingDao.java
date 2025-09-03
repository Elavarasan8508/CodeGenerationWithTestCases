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
import com.bsit.codegeneration.entity.FgLayoutMapping;

public interface FgLayoutMappingDao {

    /**
     * Inserts a new FgLayoutMapping and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LAYOUT_MAPPING (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LAYOUT_MAPPING, LIST_MAPPING, LAYOUT_ID, LIST_ID, LAYOUT_UUID, LIST_UUID, TYPE, FORM_ID, FORM_MAPPING, FORM_UUID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :layoutMapping, :listMapping, :layoutId, :listId, :layoutUuid, :listUuid, :type, :formId, :formMapping, :formUuid)")
    public int insert(@BindBean FgLayoutMapping fglayoutmapping);

    /**
     * Finds a FgLayoutMapping by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_MAPPING WHERE ID = :id")
    @RegisterBeanMapper(FgLayoutMapping.class)
    public Optional<FgLayoutMapping> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_MAPPING")
    @RegisterBeanMapper(FgLayoutMapping.class)
    public List<FgLayoutMapping> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_MAPPING ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLayoutMapping.class)
    public List<FgLayoutMapping> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLayoutMapping and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LAYOUT_MAPPING SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, LAYOUT_MAPPING = :layoutMapping, LIST_MAPPING = :listMapping, LAYOUT_ID = :layoutId, LIST_ID = :listId, LAYOUT_UUID = :layoutUuid, LIST_UUID = :listUuid, TYPE = :type, FORM_ID = :formId, FORM_MAPPING = :formMapping, FORM_UUID = :formUuid WHERE ID = :id")
    public int update(@BindBean FgLayoutMapping fglayoutmapping);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_MAPPING WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LAYOUT_MAPPING")
    public long countAll();

    /**
     * Bulk insert multiple FgLayoutMapping entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LAYOUT_MAPPING (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, LAYOUT_MAPPING, LIST_MAPPING, LAYOUT_ID, LIST_ID, LAYOUT_UUID, LIST_UUID, TYPE, FORM_ID, FORM_MAPPING, FORM_UUID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :layoutMapping, :listMapping, :layoutId, :listId, :layoutUuid, :listUuid, :type, :formId, :formMapping, :formUuid)")
    public int[] bulkInsert(@BindBean List<FgLayoutMapping> fglayoutmappings);

    /**
     * Bulk update multiple FgLayoutMapping entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LAYOUT_MAPPING SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, LAYOUT_MAPPING = :layoutMapping, LIST_MAPPING = :listMapping, LAYOUT_ID = :layoutId, LIST_ID = :listId, LAYOUT_UUID = :layoutUuid, LIST_UUID = :listUuid, TYPE = :type, FORM_ID = :formId, FORM_MAPPING = :formMapping, FORM_UUID = :formUuid WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgLayoutMapping> fglayoutmappings);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_MAPPING WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LAYOUT_MAPPING WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgLayoutMapping records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_MAPPING WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgLayoutMapping.class)
    public List<FgLayoutMapping> findByIds(@BindList("ids") Collection<String> ids);
}
