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
import com.bsit.codegeneration.entity.FgActHiComment;

public interface FgActHiCommentDao {

    /**
     * Inserts a new FgActHiComment and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_COMMENT (ID_, TYPE_, TIME_, USER_ID_, TASK_ID_, PROC_INST_ID_, ACTION_, MESSAGE_, FULL_MSG_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :type, :time, :userId, :taskId, :procInstId, :action, :message, :fullMsg, :tenantId, :rootProcInstId, :removalTime)")
    public int insert(@BindBean FgActHiComment fgacthicomment);

    /**
     * Finds a FgActHiComment by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_COMMENT WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiComment.class)
    public Optional<FgActHiComment> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_COMMENT")
    @RegisterBeanMapper(FgActHiComment.class)
    public List<FgActHiComment> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_COMMENT ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiComment.class)
    public List<FgActHiComment> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiComment and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_COMMENT SET TYPE_ = :type, TIME_ = :time, USER_ID_ = :userId, TASK_ID_ = :taskId, PROC_INST_ID_ = :procInstId, ACTION_ = :action, MESSAGE_ = :message, FULL_MSG_ = :fullMsg, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActHiComment fgacthicomment);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_COMMENT WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_COMMENT")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiComment entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_COMMENT (ID_, TYPE_, TIME_, USER_ID_, TASK_ID_, PROC_INST_ID_, ACTION_, MESSAGE_, FULL_MSG_, TENANT_ID_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :type, :time, :userId, :taskId, :procInstId, :action, :message, :fullMsg, :tenantId, :rootProcInstId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActHiComment> fgacthicomments);

    /**
     * Bulk update multiple FgActHiComment entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_COMMENT SET TYPE_ = :type, TIME_ = :time, USER_ID_ = :userId, TASK_ID_ = :taskId, PROC_INST_ID_ = :procInstId, ACTION_ = :action, MESSAGE_ = :message, FULL_MSG_ = :fullMsg, TENANT_ID_ = :tenantId, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiComment> fgacthicomments);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_COMMENT WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_COMMENT WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiComment records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_COMMENT WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiComment.class)
    public List<FgActHiComment> findByIds(@BindList("ids") Collection<String> ids);
}
