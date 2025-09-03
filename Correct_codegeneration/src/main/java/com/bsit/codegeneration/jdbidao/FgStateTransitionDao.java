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
import com.bsit.codegeneration.entity.FgStateTransition;

public interface FgStateTransitionDao {

    /**
     * Inserts a new FgStateTransition and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_STATE_TRANSITION (ID, ACTION_CODE, ACTION_NAME, START_STATE_CODE, TARGET_STATE_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :actionCode, :actionName, :startStateCode, :targetStateCode, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int insert(@BindBean FgStateTransition fgstatetransition);

    /**
     * Finds a FgStateTransition by its ID.
     */
    @SqlQuery("SELECT * FROM FG_STATE_TRANSITION WHERE ID = :id")
    @RegisterBeanMapper(FgStateTransition.class)
    public Optional<FgStateTransition> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_STATE_TRANSITION")
    @RegisterBeanMapper(FgStateTransition.class)
    public List<FgStateTransition> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_STATE_TRANSITION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgStateTransition.class)
    public List<FgStateTransition> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgStateTransition and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_STATE_TRANSITION SET ACTION_CODE = :actionCode, ACTION_NAME = :actionName, START_STATE_CODE = :startStateCode, TARGET_STATE_CODE = :targetStateCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE ID = :id")
    public int update(@BindBean FgStateTransition fgstatetransition);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_STATE_TRANSITION WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_STATE_TRANSITION")
    public long countAll();

    /**
     * Bulk insert multiple FgStateTransition entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_STATE_TRANSITION (ID, ACTION_CODE, ACTION_NAME, START_STATE_CODE, TARGET_STATE_CODE, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :actionCode, :actionName, :startStateCode, :targetStateCode, :activeCode, :statusCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int[] bulkInsert(@BindBean List<FgStateTransition> fgstatetransitions);

    /**
     * Bulk update multiple FgStateTransition entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_STATE_TRANSITION SET ACTION_CODE = :actionCode, ACTION_NAME = :actionName, START_STATE_CODE = :startStateCode, TARGET_STATE_CODE = :targetStateCode, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgStateTransition> fgstatetransitions);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_STATE_TRANSITION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_STATE_TRANSITION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgStateTransition records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_STATE_TRANSITION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgStateTransition.class)
    public List<FgStateTransition> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
