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
import com.bsit.codegeneration.entity.FgActRuEventSubscr;

public interface FgActRuEventSubscrDao {

    /**
     * Inserts a new FgActRuEventSubscr and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_EVENT_SUBSCR (ID_, REV_, EVENT_TYPE_, EVENT_NAME_, EXECUTION_ID_, PROC_INST_ID_, ACTIVITY_ID_, CONFIGURATION_, TENANT_ID_) VALUES (:id, :rev, :eventType, :eventName, :executionId, :procInstId, :activityId, :configuration, :tenantId)")
    public int insert(@BindBean FgActRuEventSubscr fgactrueventsubscr);

    /**
     * Finds a FgActRuEventSubscr by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EVENT_SUBSCR WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuEventSubscr.class)
    public Optional<FgActRuEventSubscr> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EVENT_SUBSCR")
    @RegisterBeanMapper(FgActRuEventSubscr.class)
    public List<FgActRuEventSubscr> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EVENT_SUBSCR ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuEventSubscr.class)
    public List<FgActRuEventSubscr> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuEventSubscr and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_EVENT_SUBSCR SET REV_ = :rev, EVENT_TYPE_ = :eventType, EVENT_NAME_ = :eventName, EXECUTION_ID_ = :executionId, PROC_INST_ID_ = :procInstId, ACTIVITY_ID_ = :activityId, CONFIGURATION_ = :configuration, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int update(@BindBean FgActRuEventSubscr fgactrueventsubscr);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_EVENT_SUBSCR WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_EVENT_SUBSCR")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuEventSubscr entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_EVENT_SUBSCR (ID_, REV_, EVENT_TYPE_, EVENT_NAME_, EXECUTION_ID_, PROC_INST_ID_, ACTIVITY_ID_, CONFIGURATION_, TENANT_ID_) VALUES (:id, :rev, :eventType, :eventName, :executionId, :procInstId, :activityId, :configuration, :tenantId)")
    public int[] bulkInsert(@BindBean List<FgActRuEventSubscr> fgactrueventsubscrs);

    /**
     * Bulk update multiple FgActRuEventSubscr entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_EVENT_SUBSCR SET REV_ = :rev, EVENT_TYPE_ = :eventType, EVENT_NAME_ = :eventName, EXECUTION_ID_ = :executionId, PROC_INST_ID_ = :procInstId, ACTIVITY_ID_ = :activityId, CONFIGURATION_ = :configuration, TENANT_ID_ = :tenantId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuEventSubscr> fgactrueventsubscrs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_EVENT_SUBSCR WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_EVENT_SUBSCR WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuEventSubscr records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_EVENT_SUBSCR WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuEventSubscr.class)
    public List<FgActRuEventSubscr> findByIds(@BindList("ids") Collection<String> ids);
}
