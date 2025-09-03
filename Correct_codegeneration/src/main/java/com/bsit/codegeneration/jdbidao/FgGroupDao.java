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
import com.bsit.codegeneration.entity.FgGroup;

public interface FgGroupDao {

    /**
     * Inserts a new FgGroup and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_GROUP (ID, NAME, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CODE, TYPE_CODE, SUB_TYPE_CODE, PARTY_TYPE_CODE, REFERENCE_ID, CONFIG_STATUS_CODE, ORG_TYPE_CODE, ORG_CODE) VALUES (:id, :name, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :code, :typeCode, :subTypeCode, :partyTypeCode, :referenceId, :configStatusCode, :orgTypeCode, :orgCode)")
    public int insert(@BindBean FgGroup fggroup);

    /**
     * Finds a FgGroup by its ID.
     */
    @SqlQuery("SELECT * FROM FG_GROUP WHERE ID = :id")
    @RegisterBeanMapper(FgGroup.class)
    public Optional<FgGroup> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_GROUP")
    @RegisterBeanMapper(FgGroup.class)
    public List<FgGroup> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_GROUP ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgGroup.class)
    public List<FgGroup> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgGroup and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_GROUP SET NAME = :name, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, CODE = :code, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PARTY_TYPE_CODE = :partyTypeCode, REFERENCE_ID = :referenceId, CONFIG_STATUS_CODE = :configStatusCode, ORG_TYPE_CODE = :orgTypeCode, ORG_CODE = :orgCode WHERE ID = :id")
    public int update(@BindBean FgGroup fggroup);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_GROUP WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_GROUP")
    public long countAll();

    /**
     * Bulk insert multiple FgGroup entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_GROUP (ID, NAME, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CODE, TYPE_CODE, SUB_TYPE_CODE, PARTY_TYPE_CODE, REFERENCE_ID, CONFIG_STATUS_CODE, ORG_TYPE_CODE, ORG_CODE) VALUES (:id, :name, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :code, :typeCode, :subTypeCode, :partyTypeCode, :referenceId, :configStatusCode, :orgTypeCode, :orgCode)")
    public int[] bulkInsert(@BindBean List<FgGroup> fggroups);

    /**
     * Bulk update multiple FgGroup entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_GROUP SET NAME = :name, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, CODE = :code, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PARTY_TYPE_CODE = :partyTypeCode, REFERENCE_ID = :referenceId, CONFIG_STATUS_CODE = :configStatusCode, ORG_TYPE_CODE = :orgTypeCode, ORG_CODE = :orgCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgGroup> fggroups);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_GROUP WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_GROUP WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgGroup records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_GROUP WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgGroup.class)
    public List<FgGroup> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
