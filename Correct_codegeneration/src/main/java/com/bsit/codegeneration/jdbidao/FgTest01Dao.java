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
import com.bsit.codegeneration.entity.FgTest01;

public interface FgTest01Dao {

    /**
     * Inserts a new FgTest01 and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TEST_01 (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROCESS_ID, TASK_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :processId, :taskId)")
    public int insert(@BindBean FgTest01 fgtest01);

    /**
     * Finds a FgTest01 by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TEST_01 WHERE ID = :id")
    @RegisterBeanMapper(FgTest01.class)
    public Optional<FgTest01> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TEST_01")
    @RegisterBeanMapper(FgTest01.class)
    public List<FgTest01> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TEST_01 ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTest01.class)
    public List<FgTest01> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTest01 and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TEST_01 SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PROCESS_ID = :processId, TASK_ID = :taskId WHERE ID = :id")
    public int update(@BindBean FgTest01 fgtest01);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TEST_01 WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TEST_01")
    public long countAll();

    /**
     * Bulk insert multiple FgTest01 entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TEST_01 (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROCESS_ID, TASK_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :processId, :taskId)")
    public int[] bulkInsert(@BindBean List<FgTest01> fgtest01s);

    /**
     * Bulk update multiple FgTest01 entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TEST_01 SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, PROCESS_ID = :processId, TASK_ID = :taskId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTest01> fgtest01s);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TEST_01 WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TEST_01 WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTest01 records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TEST_01 WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTest01.class)
    public List<FgTest01> findByIds(@BindList("ids") Collection<String> ids);
}
