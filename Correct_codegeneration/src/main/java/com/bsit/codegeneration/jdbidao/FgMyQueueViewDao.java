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
import com.bsit.codegeneration.entity.FgMyQueueView;

public interface FgMyQueueViewDao {

    /**
     * Inserts a new FgMyQueueView and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MY_QUEUE_VIEW (ID_, PROC_INST_ID_, NAME_, GROUP_ID_, TENANT_ID_, PROC_DEF_ID_) VALUES (:id, :procInstId, :name, :groupId, :tenantId, :procDefId)")
    public int insert(@BindBean FgMyQueueView fgmyqueueview);

    /**
     * Finds a FgMyQueueView by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MY_QUEUE_VIEW WHERE FG_MY_QUEUE_VIEW_id = :id")
    @RegisterBeanMapper(FgMyQueueView.class)
    public Optional<FgMyQueueView> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MY_QUEUE_VIEW")
    @RegisterBeanMapper(FgMyQueueView.class)
    public List<FgMyQueueView> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MY_QUEUE_VIEW ORDER BY FG_MY_QUEUE_VIEW_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgMyQueueView.class)
    public List<FgMyQueueView> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgMyQueueView and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MY_QUEUE_VIEW SET ID_ = :id, PROC_INST_ID_ = :procInstId, NAME_ = :name, GROUP_ID_ = :groupId, TENANT_ID_ = :tenantId, PROC_DEF_ID_ = :procDefId WHERE FG_MY_QUEUE_VIEW_id = :fgMyQueueViewId")
    public int update(@BindBean FgMyQueueView fgmyqueueview);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MY_QUEUE_VIEW WHERE FG_MY_QUEUE_VIEW_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MY_QUEUE_VIEW")
    public long countAll();

    /**
     * Bulk insert multiple FgMyQueueView entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MY_QUEUE_VIEW (ID_, PROC_INST_ID_, NAME_, GROUP_ID_, TENANT_ID_, PROC_DEF_ID_) VALUES (:id, :procInstId, :name, :groupId, :tenantId, :procDefId)")
    public int[] bulkInsert(@BindBean List<FgMyQueueView> fgmyqueueviews);

    /**
     * Bulk update multiple FgMyQueueView entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MY_QUEUE_VIEW SET ID_ = :id, PROC_INST_ID_ = :procInstId, NAME_ = :name, GROUP_ID_ = :groupId, TENANT_ID_ = :tenantId, PROC_DEF_ID_ = :procDefId WHERE FG_MY_QUEUE_VIEW_id = :fgMyQueueViewId")
    public int[] bulkUpdate(@BindBean List<FgMyQueueView> fgmyqueueviews);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MY_QUEUE_VIEW WHERE FG_MY_QUEUE_VIEW_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MY_QUEUE_VIEW WHERE FG_MY_QUEUE_VIEW_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgMyQueueView records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MY_QUEUE_VIEW WHERE FG_MY_QUEUE_VIEW_id IN (<ids>)")
    @RegisterBeanMapper(FgMyQueueView.class)
    public List<FgMyQueueView> findByIds(@BindList("ids") Collection<Integer> ids);
}
