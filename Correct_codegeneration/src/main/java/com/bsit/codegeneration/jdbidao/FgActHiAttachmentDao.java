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
import com.bsit.codegeneration.entity.FgActHiAttachment;

public interface FgActHiAttachmentDao {

    /**
     * Inserts a new FgActHiAttachment and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_HI_ATTACHMENT (ID_, REV_, USER_ID_, NAME_, DESCRIPTION_, TYPE_, TASK_ID_, PROC_INST_ID_, URL_, CONTENT_ID_, TENANT_ID_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :rev, :userId, :name, :description, :type, :taskId, :procInstId, :URL, :contentId, :tenantId, :createTime, :rootProcInstId, :removalTime)")
    public int insert(@BindBean FgActHiAttachment fgacthiattachment);

    /**
     * Finds a FgActHiAttachment by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_ATTACHMENT WHERE ID_ = :id")
    @RegisterBeanMapper(FgActHiAttachment.class)
    public Optional<FgActHiAttachment> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_ATTACHMENT")
    @RegisterBeanMapper(FgActHiAttachment.class)
    public List<FgActHiAttachment> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_ATTACHMENT ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActHiAttachment.class)
    public List<FgActHiAttachment> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActHiAttachment and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_HI_ATTACHMENT SET REV_ = :rev, USER_ID_ = :userId, NAME_ = :name, DESCRIPTION_ = :description, TYPE_ = :type, TASK_ID_ = :taskId, PROC_INST_ID_ = :procInstId, URL_ = :URL, CONTENT_ID_ = :contentId, TENANT_ID_ = :tenantId, CREATE_TIME_ = :createTime, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int update(@BindBean FgActHiAttachment fgacthiattachment);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_ATTACHMENT WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_HI_ATTACHMENT")
    public long countAll();

    /**
     * Bulk insert multiple FgActHiAttachment entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_HI_ATTACHMENT (ID_, REV_, USER_ID_, NAME_, DESCRIPTION_, TYPE_, TASK_ID_, PROC_INST_ID_, URL_, CONTENT_ID_, TENANT_ID_, CREATE_TIME_, ROOT_PROC_INST_ID_, REMOVAL_TIME_) VALUES (:id, :rev, :userId, :name, :description, :type, :taskId, :procInstId, :URL, :contentId, :tenantId, :createTime, :rootProcInstId, :removalTime)")
    public int[] bulkInsert(@BindBean List<FgActHiAttachment> fgacthiattachments);

    /**
     * Bulk update multiple FgActHiAttachment entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_HI_ATTACHMENT SET REV_ = :rev, USER_ID_ = :userId, NAME_ = :name, DESCRIPTION_ = :description, TYPE_ = :type, TASK_ID_ = :taskId, PROC_INST_ID_ = :procInstId, URL_ = :URL, CONTENT_ID_ = :contentId, TENANT_ID_ = :tenantId, CREATE_TIME_ = :createTime, ROOT_PROC_INST_ID_ = :rootProcInstId, REMOVAL_TIME_ = :removalTime WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActHiAttachment> fgacthiattachments);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_HI_ATTACHMENT WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_HI_ATTACHMENT WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActHiAttachment records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_HI_ATTACHMENT WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActHiAttachment.class)
    public List<FgActHiAttachment> findByIds(@BindList("ids") Collection<String> ids);
}
