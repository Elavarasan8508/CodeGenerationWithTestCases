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
import com.bsit.codegeneration.entity.TestPostProcessor;

public interface TestPostProcessorDao {

    /**
     * Inserts a new TestPostProcessor and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO TEST_POST_PROCESSOR (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, VALUE1, VALUE2, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :value1, :value2, :entityTypeCode, :entitySubTypeCode, :entityReferenceId)")
    public int insert(@BindBean TestPostProcessor testpostprocessor);

    /**
     * Finds a TestPostProcessor by its ID.
     */
    @SqlQuery("SELECT * FROM TEST_POST_PROCESSOR WHERE ID = :id")
    @RegisterBeanMapper(TestPostProcessor.class)
    public Optional<TestPostProcessor> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM TEST_POST_PROCESSOR")
    @RegisterBeanMapper(TestPostProcessor.class)
    public List<TestPostProcessor> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM TEST_POST_PROCESSOR ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(TestPostProcessor.class)
    public List<TestPostProcessor> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a TestPostProcessor and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE TEST_POST_PROCESSOR SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, VALUE1 = :value1, VALUE2 = :value2, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_REFERENCE_ID = :entityReferenceId WHERE ID = :id")
    public int update(@BindBean TestPostProcessor testpostprocessor);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM TEST_POST_PROCESSOR WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM TEST_POST_PROCESSOR")
    public long countAll();

    /**
     * Bulk insert multiple TestPostProcessor entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO TEST_POST_PROCESSOR (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, VALUE1, VALUE2, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :value1, :value2, :entityTypeCode, :entitySubTypeCode, :entityReferenceId)")
    public int[] bulkInsert(@BindBean List<TestPostProcessor> testpostprocessors);

    /**
     * Bulk update multiple TestPostProcessor entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE TEST_POST_PROCESSOR SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, VALUE1 = :value1, VALUE2 = :value2, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, ENTITY_REFERENCE_ID = :entityReferenceId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<TestPostProcessor> testpostprocessors);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM TEST_POST_PROCESSOR WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM TEST_POST_PROCESSOR WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple TestPostProcessor records by their IDs.
     */
    @SqlQuery("SELECT * FROM TEST_POST_PROCESSOR WHERE ID IN (<ids>)")
    @RegisterBeanMapper(TestPostProcessor.class)
    public List<TestPostProcessor> findByIds(@BindList("ids") Collection<String> ids);
}
