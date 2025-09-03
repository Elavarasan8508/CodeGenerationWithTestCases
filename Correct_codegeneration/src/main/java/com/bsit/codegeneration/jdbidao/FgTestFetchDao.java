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
import com.bsit.codegeneration.entity.FgTestFetch;

public interface FgTestFetchDao {

    /**
     * Inserts a new FgTestFetch and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TEST_FETCH (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FIRST_NAME, LAST_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :firstName, :lastName)")
    public int insert(@BindBean FgTestFetch fgtestfetch);

    /**
     * Finds a FgTestFetch by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TEST_FETCH WHERE ID = :id")
    @RegisterBeanMapper(FgTestFetch.class)
    public Optional<FgTestFetch> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TEST_FETCH")
    @RegisterBeanMapper(FgTestFetch.class)
    public List<FgTestFetch> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TEST_FETCH ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTestFetch.class)
    public List<FgTestFetch> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTestFetch and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TEST_FETCH SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, FIRST_NAME = :firstName, LAST_NAME = :lastName WHERE ID = :id")
    public int update(@BindBean FgTestFetch fgtestfetch);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TEST_FETCH WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TEST_FETCH")
    public long countAll();

    /**
     * Bulk insert multiple FgTestFetch entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TEST_FETCH (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FIRST_NAME, LAST_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :firstName, :lastName)")
    public int[] bulkInsert(@BindBean List<FgTestFetch> fgtestfetchs);

    /**
     * Bulk update multiple FgTestFetch entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TEST_FETCH SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, FIRST_NAME = :firstName, LAST_NAME = :lastName WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTestFetch> fgtestfetchs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TEST_FETCH WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TEST_FETCH WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTestFetch records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TEST_FETCH WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTestFetch.class)
    public List<FgTestFetch> findByIds(@BindList("ids") Collection<String> ids);
}
