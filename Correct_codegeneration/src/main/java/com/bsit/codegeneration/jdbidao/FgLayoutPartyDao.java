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
import com.bsit.codegeneration.entity.FgLayoutParty;

public interface FgLayoutPartyDao {

    /**
     * Inserts a new FgLayoutParty and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LAYOUT_PARTY (ID, PARTY_ID, PARTY_VERSION_ID, LAYOUT_ID, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, LAYOUT_VERSION_ID) VALUES (:id, :partyId, :partyVersionId, :layoutId, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :layoutVersionId)")
    public int insert(@BindBean FgLayoutParty fglayoutparty);

    /**
     * Finds a FgLayoutParty by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_PARTY WHERE ID = :id")
    @RegisterBeanMapper(FgLayoutParty.class)
    public Optional<FgLayoutParty> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_PARTY")
    @RegisterBeanMapper(FgLayoutParty.class)
    public List<FgLayoutParty> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_PARTY ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLayoutParty.class)
    public List<FgLayoutParty> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLayoutParty and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LAYOUT_PARTY SET PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, LAYOUT_ID = :layoutId, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, LAYOUT_VERSION_ID = :layoutVersionId WHERE ID = :id")
    public int update(@BindBean FgLayoutParty fglayoutparty);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_PARTY WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LAYOUT_PARTY")
    public long countAll();

    /**
     * Bulk insert multiple FgLayoutParty entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LAYOUT_PARTY (ID, PARTY_ID, PARTY_VERSION_ID, LAYOUT_ID, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, LAYOUT_VERSION_ID) VALUES (:id, :partyId, :partyVersionId, :layoutId, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :layoutVersionId)")
    public int[] bulkInsert(@BindBean List<FgLayoutParty> fglayoutpartys);

    /**
     * Bulk update multiple FgLayoutParty entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LAYOUT_PARTY SET PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, LAYOUT_ID = :layoutId, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, LAYOUT_VERSION_ID = :layoutVersionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgLayoutParty> fglayoutpartys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LAYOUT_PARTY WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LAYOUT_PARTY WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgLayoutParty records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_PARTY WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgLayoutParty.class)
    public List<FgLayoutParty> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgLayoutParty records by layoutVersionId.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_PARTY WHERE LAYOUT_VERSION_ID = :layoutVersionId")
    @RegisterBeanMapper(FgLayoutParty.class)
    public List<FgLayoutParty> findByLayoutVersionId(@Bind("layoutVersionId") int layoutVersionId);

    /**
     * Finds all FgLayoutParty records by layoutId.
     */
    @SqlQuery("SELECT * FROM FG_LAYOUT_PARTY WHERE LAYOUT_ID = :layoutId")
    @RegisterBeanMapper(FgLayoutParty.class)
    public List<FgLayoutParty> findByLayoutId(@Bind("layoutId") int layoutId);
}
