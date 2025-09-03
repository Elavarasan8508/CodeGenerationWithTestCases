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
import com.bsit.codegeneration.entity.TestModel;

public interface TestModelDao {

    /**
     * Inserts a new TestModel and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO TEST_MODEL (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, ADDRESS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name, :address)")
    public int insert(@BindBean TestModel testmodel);

    /**
     * Finds a TestModel by its ID.
     */
    @SqlQuery("SELECT * FROM TEST_MODEL WHERE ID = :id")
    @RegisterBeanMapper(TestModel.class)
    public Optional<TestModel> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM TEST_MODEL")
    @RegisterBeanMapper(TestModel.class)
    public List<TestModel> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM TEST_MODEL ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(TestModel.class)
    public List<TestModel> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a TestModel and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE TEST_MODEL SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name, ADDRESS = :address WHERE ID = :id")
    public int update(@BindBean TestModel testmodel);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM TEST_MODEL WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM TEST_MODEL")
    public long countAll();

    /**
     * Bulk insert multiple TestModel entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO TEST_MODEL (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, ADDRESS) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :name, :address)")
    public int[] bulkInsert(@BindBean List<TestModel> testmodels);

    /**
     * Bulk update multiple TestModel entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE TEST_MODEL SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, NAME = :name, ADDRESS = :address WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<TestModel> testmodels);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM TEST_MODEL WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM TEST_MODEL WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple TestModel records by their IDs.
     */
    @SqlQuery("SELECT * FROM TEST_MODEL WHERE ID IN (<ids>)")
    @RegisterBeanMapper(TestModel.class)
    public List<TestModel> findByIds(@BindList("ids") Collection<String> ids);
}
