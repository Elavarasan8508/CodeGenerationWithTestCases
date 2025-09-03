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
import com.bsit.codegeneration.entity.FgActRuAuthorization;

public interface FgActRuAuthorizationDao {

    /**
     * Inserts a new FgActRuAuthorization and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ACT_RU_AUTHORIZATION (ID_, REV_, TYPE_, GROUP_ID_, USER_ID_, RESOURCE_TYPE_, RESOURCE_ID_, PERMS_, REMOVAL_TIME_, ROOT_PROC_INST_ID_) VALUES (:id, :rev, :type, :groupId, :userId, :resourceType, :resourceId, :perms, :removalTime, :rootProcInstId)")
    public int insert(@BindBean FgActRuAuthorization fgactruauthorization);

    /**
     * Finds a FgActRuAuthorization by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_AUTHORIZATION WHERE ID_ = :id")
    @RegisterBeanMapper(FgActRuAuthorization.class)
    public Optional<FgActRuAuthorization> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_AUTHORIZATION")
    @RegisterBeanMapper(FgActRuAuthorization.class)
    public List<FgActRuAuthorization> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_AUTHORIZATION ORDER BY ID_ LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgActRuAuthorization.class)
    public List<FgActRuAuthorization> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgActRuAuthorization and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ACT_RU_AUTHORIZATION SET REV_ = :rev, TYPE_ = :type, GROUP_ID_ = :groupId, USER_ID_ = :userId, RESOURCE_TYPE_ = :resourceType, RESOURCE_ID_ = :resourceId, PERMS_ = :perms, REMOVAL_TIME_ = :removalTime, ROOT_PROC_INST_ID_ = :rootProcInstId WHERE ID_ = :id")
    public int update(@BindBean FgActRuAuthorization fgactruauthorization);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_AUTHORIZATION WHERE ID_ = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ACT_RU_AUTHORIZATION")
    public long countAll();

    /**
     * Bulk insert multiple FgActRuAuthorization entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ACT_RU_AUTHORIZATION (ID_, REV_, TYPE_, GROUP_ID_, USER_ID_, RESOURCE_TYPE_, RESOURCE_ID_, PERMS_, REMOVAL_TIME_, ROOT_PROC_INST_ID_) VALUES (:id, :rev, :type, :groupId, :userId, :resourceType, :resourceId, :perms, :removalTime, :rootProcInstId)")
    public int[] bulkInsert(@BindBean List<FgActRuAuthorization> fgactruauthorizations);

    /**
     * Bulk update multiple FgActRuAuthorization entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ACT_RU_AUTHORIZATION SET REV_ = :rev, TYPE_ = :type, GROUP_ID_ = :groupId, USER_ID_ = :userId, RESOURCE_TYPE_ = :resourceType, RESOURCE_ID_ = :resourceId, PERMS_ = :perms, REMOVAL_TIME_ = :removalTime, ROOT_PROC_INST_ID_ = :rootProcInstId WHERE ID_ = :id")
    public int[] bulkUpdate(@BindBean List<FgActRuAuthorization> fgactruauthorizations);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ACT_RU_AUTHORIZATION WHERE ID_ IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ACT_RU_AUTHORIZATION WHERE ID_ = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgActRuAuthorization records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ACT_RU_AUTHORIZATION WHERE ID_ IN (<ids>)")
    @RegisterBeanMapper(FgActRuAuthorization.class)
    public List<FgActRuAuthorization> findByIds(@BindList("ids") Collection<String> ids);
}
