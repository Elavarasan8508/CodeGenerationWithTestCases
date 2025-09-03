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
import com.bsit.codegeneration.entity.FgUserGroup;

public interface FgUserGroupDao {

    /**
     * Inserts a new FgUserGroup and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_USER_GROUP (ID, PARTY_CODE, USER_ID, GROUP_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :partyCode, :userId, :groupId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgUserGroup fgusergroup);

    /**
     * Finds a FgUserGroup by its ID.
     */
    @SqlQuery("SELECT * FROM FG_USER_GROUP WHERE FG_USER_GROUP_id = :id")
    @RegisterBeanMapper(FgUserGroup.class)
    public Optional<FgUserGroup> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_USER_GROUP")
    @RegisterBeanMapper(FgUserGroup.class)
    public List<FgUserGroup> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_USER_GROUP ORDER BY FG_USER_GROUP_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgUserGroup.class)
    public List<FgUserGroup> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgUserGroup and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_USER_GROUP SET ID = :id, PARTY_CODE = :partyCode, USER_ID = :userId, GROUP_ID = :groupId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_USER_GROUP_id = :fgUserGroupId")
    public int update(@BindBean FgUserGroup fgusergroup);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_USER_GROUP WHERE FG_USER_GROUP_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_USER_GROUP")
    public long countAll();

    /**
     * Bulk insert multiple FgUserGroup entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_USER_GROUP (ID, PARTY_CODE, USER_ID, GROUP_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :partyCode, :userId, :groupId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgUserGroup> fgusergroups);

    /**
     * Bulk update multiple FgUserGroup entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_USER_GROUP SET ID = :id, PARTY_CODE = :partyCode, USER_ID = :userId, GROUP_ID = :groupId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE FG_USER_GROUP_id = :fgUserGroupId")
    public int[] bulkUpdate(@BindBean List<FgUserGroup> fgusergroups);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_USER_GROUP WHERE FG_USER_GROUP_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_USER_GROUP WHERE FG_USER_GROUP_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgUserGroup records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_USER_GROUP WHERE FG_USER_GROUP_id IN (<ids>)")
    @RegisterBeanMapper(FgUserGroup.class)
    public List<FgUserGroup> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all FgUserGroup records by groupId.
     */
    @SqlQuery("SELECT * FROM FG_USER_GROUP WHERE GROUP_ID = :groupId")
    @RegisterBeanMapper(FgUserGroup.class)
    public List<FgUserGroup> findByGroupId(@Bind("groupId") int groupId);
}
