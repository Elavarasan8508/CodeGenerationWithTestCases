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
import com.bsit.codegeneration.entity.FgPartyGroup;

public interface FgPartyGroupDao {

    /**
     * Inserts a new FgPartyGroup and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_GROUP (ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, GROUP_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PARENT_PARTY_CODE, REFERENCE_ID, SUB_TYPE_CODE, TYPE_CODE) VALUES (:id, :partySubTypeCode, :partyCode, :groupId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :parentPartyCode, :referenceId, :subTypeCode, :typeCode)")
    public int insert(@BindBean FgPartyGroup fgpartygroup);

    /**
     * Finds a FgPartyGroup by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_GROUP WHERE FG_PARTY_GROUP_id = :id")
    @RegisterBeanMapper(FgPartyGroup.class)
    public Optional<FgPartyGroup> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_GROUP")
    @RegisterBeanMapper(FgPartyGroup.class)
    public List<FgPartyGroup> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_GROUP ORDER BY FG_PARTY_GROUP_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyGroup.class)
    public List<FgPartyGroup> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyGroup and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_GROUP SET ID = :id, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PARTY_CODE = :partyCode, GROUP_ID = :groupId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PARENT_PARTY_CODE = :parentPartyCode, REFERENCE_ID = :referenceId, SUB_TYPE_CODE = :subTypeCode, TYPE_CODE = :typeCode WHERE FG_PARTY_GROUP_id = :fgPartyGroupId")
    public int update(@BindBean FgPartyGroup fgpartygroup);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_GROUP WHERE FG_PARTY_GROUP_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_GROUP")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyGroup entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_GROUP (ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, GROUP_ID, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PARENT_PARTY_CODE, REFERENCE_ID, SUB_TYPE_CODE, TYPE_CODE) VALUES (:id, :partySubTypeCode, :partyCode, :groupId, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :parentPartyCode, :referenceId, :subTypeCode, :typeCode)")
    public int[] bulkInsert(@BindBean List<FgPartyGroup> fgpartygroups);

    /**
     * Bulk update multiple FgPartyGroup entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_GROUP SET ID = :id, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PARTY_CODE = :partyCode, GROUP_ID = :groupId, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, PARENT_PARTY_CODE = :parentPartyCode, REFERENCE_ID = :referenceId, SUB_TYPE_CODE = :subTypeCode, TYPE_CODE = :typeCode WHERE FG_PARTY_GROUP_id = :fgPartyGroupId")
    public int[] bulkUpdate(@BindBean List<FgPartyGroup> fgpartygroups);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_GROUP WHERE FG_PARTY_GROUP_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_GROUP WHERE FG_PARTY_GROUP_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgPartyGroup records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_GROUP WHERE FG_PARTY_GROUP_id IN (<ids>)")
    @RegisterBeanMapper(FgPartyGroup.class)
    public List<FgPartyGroup> findByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Finds all FgPartyGroup records by groupId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_GROUP WHERE GROUP_ID = :groupId")
    @RegisterBeanMapper(FgPartyGroup.class)
    public List<FgPartyGroup> findByGroupId(@Bind("groupId") int groupId);
}
