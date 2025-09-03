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
import com.bsit.codegeneration.entity.FgEntityTypeRole;

public interface FgEntityTypeRoleDao {

    /**
     * Inserts a new FgEntityTypeRole and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ENTITY_TYPE_ROLE (ID, ENTITY_TYPE_CODE, PARTY_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_SCOPE_CODE) VALUES (:id, :entityTypeCode, :partyTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :entityScopeCode)")
    public int insert(@BindBean FgEntityTypeRole fgentitytyperole);

    /**
     * Finds a FgEntityTypeRole by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_TYPE_ROLE WHERE ID = :id")
    @RegisterBeanMapper(FgEntityTypeRole.class)
    public Optional<FgEntityTypeRole> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_TYPE_ROLE")
    @RegisterBeanMapper(FgEntityTypeRole.class)
    public List<FgEntityTypeRole> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_TYPE_ROLE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgEntityTypeRole.class)
    public List<FgEntityTypeRole> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgEntityTypeRole and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ENTITY_TYPE_ROLE SET ENTITY_TYPE_CODE = :entityTypeCode, PARTY_TYPE_CODE = :partyTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ENTITY_SCOPE_CODE = :entityScopeCode WHERE ID = :id")
    public int update(@BindBean FgEntityTypeRole fgentitytyperole);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ENTITY_TYPE_ROLE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ENTITY_TYPE_ROLE")
    public long countAll();

    /**
     * Bulk insert multiple FgEntityTypeRole entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ENTITY_TYPE_ROLE (ID, ENTITY_TYPE_CODE, PARTY_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, ENTITY_SCOPE_CODE) VALUES (:id, :entityTypeCode, :partyTypeCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :entityScopeCode)")
    public int[] bulkInsert(@BindBean List<FgEntityTypeRole> fgentitytyperoles);

    /**
     * Bulk update multiple FgEntityTypeRole entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ENTITY_TYPE_ROLE SET ENTITY_TYPE_CODE = :entityTypeCode, PARTY_TYPE_CODE = :partyTypeCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, ENTITY_SCOPE_CODE = :entityScopeCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgEntityTypeRole> fgentitytyperoles);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ENTITY_TYPE_ROLE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ENTITY_TYPE_ROLE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgEntityTypeRole records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_TYPE_ROLE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgEntityTypeRole.class)
    public List<FgEntityTypeRole> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
