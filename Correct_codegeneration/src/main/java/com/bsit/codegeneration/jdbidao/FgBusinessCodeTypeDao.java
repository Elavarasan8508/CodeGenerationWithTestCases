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
import com.bsit.codegeneration.entity.FgBusinessCodeType;

public interface FgBusinessCodeTypeDao {

    /**
     * Inserts a new FgBusinessCodeType and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_BUSINESS_CODE_TYPE (ID, PARTY_ID, PARTY_VERSION_ID, CODE_TYPE, NAME, DESCRIPTION, ACTIVE_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TAGS) VALUES (:id, :partyId, :partyVersionId, :codeType, :name, :description, :activeCode, :lastAuthorisedOn, :lastAuthorisedBy, :tags)")
    public int insert(@BindBean FgBusinessCodeType fgbusinesscodetype);

    /**
     * Finds a FgBusinessCodeType by its ID.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_TYPE WHERE ID = :id")
    @RegisterBeanMapper(FgBusinessCodeType.class)
    public Optional<FgBusinessCodeType> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_TYPE")
    @RegisterBeanMapper(FgBusinessCodeType.class)
    public List<FgBusinessCodeType> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_TYPE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgBusinessCodeType.class)
    public List<FgBusinessCodeType> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgBusinessCodeType and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_BUSINESS_CODE_TYPE SET PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, CODE_TYPE = :codeType, NAME = :name, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TAGS = :tags WHERE ID = :id")
    public int update(@BindBean FgBusinessCodeType fgbusinesscodetype);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_BUSINESS_CODE_TYPE WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_BUSINESS_CODE_TYPE")
    public long countAll();

    /**
     * Bulk insert multiple FgBusinessCodeType entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_BUSINESS_CODE_TYPE (ID, PARTY_ID, PARTY_VERSION_ID, CODE_TYPE, NAME, DESCRIPTION, ACTIVE_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TAGS) VALUES (:id, :partyId, :partyVersionId, :codeType, :name, :description, :activeCode, :lastAuthorisedOn, :lastAuthorisedBy, :tags)")
    public int[] bulkInsert(@BindBean List<FgBusinessCodeType> fgbusinesscodetypes);

    /**
     * Bulk update multiple FgBusinessCodeType entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_BUSINESS_CODE_TYPE SET PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, CODE_TYPE = :codeType, NAME = :name, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TAGS = :tags WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgBusinessCodeType> fgbusinesscodetypes);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_BUSINESS_CODE_TYPE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_BUSINESS_CODE_TYPE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgBusinessCodeType records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_BUSINESS_CODE_TYPE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgBusinessCodeType.class)
    public List<FgBusinessCodeType> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
