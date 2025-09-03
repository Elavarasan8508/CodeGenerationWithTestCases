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
import com.bsit.codegeneration.entity.IdxFgLayoutPartyStatus;

public interface IdxFgLayoutPartyStatusDao {

    /**
     * Inserts a new IdxFgLayoutPartyStatus and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO IDX_FG_LAYOUT_PARTY_STATUS (ID, PARTY_ID, PARTY_VERSION_ID, LAYOUT_ID, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, LAYOUT_VERSION_ID) VALUES (:id, :partyId, :partyVersionId, :layoutId, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :layoutVersionId)")
    public int insert(@BindBean IdxFgLayoutPartyStatus idxfglayoutpartystatus);

    /**
     * Finds a IdxFgLayoutPartyStatus by its ID.
     */
    @SqlQuery("SELECT * FROM IDX_FG_LAYOUT_PARTY_STATUS WHERE ID = :id")
    @RegisterBeanMapper(IdxFgLayoutPartyStatus.class)
    public Optional<IdxFgLayoutPartyStatus> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM IDX_FG_LAYOUT_PARTY_STATUS")
    @RegisterBeanMapper(IdxFgLayoutPartyStatus.class)
    public List<IdxFgLayoutPartyStatus> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM IDX_FG_LAYOUT_PARTY_STATUS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(IdxFgLayoutPartyStatus.class)
    public List<IdxFgLayoutPartyStatus> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a IdxFgLayoutPartyStatus and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE IDX_FG_LAYOUT_PARTY_STATUS SET PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, LAYOUT_ID = :layoutId, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, LAYOUT_VERSION_ID = :layoutVersionId WHERE ID = :id")
    public int update(@BindBean IdxFgLayoutPartyStatus idxfglayoutpartystatus);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM IDX_FG_LAYOUT_PARTY_STATUS WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM IDX_FG_LAYOUT_PARTY_STATUS")
    public long countAll();

    /**
     * Bulk insert multiple IdxFgLayoutPartyStatus entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO IDX_FG_LAYOUT_PARTY_STATUS (ID, PARTY_ID, PARTY_VERSION_ID, LAYOUT_ID, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, LAYOUT_VERSION_ID) VALUES (:id, :partyId, :partyVersionId, :layoutId, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :layoutVersionId)")
    public int[] bulkInsert(@BindBean List<IdxFgLayoutPartyStatus> idxfglayoutpartystatuss);

    /**
     * Bulk update multiple IdxFgLayoutPartyStatus entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE IDX_FG_LAYOUT_PARTY_STATUS SET PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, LAYOUT_ID = :layoutId, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, LAYOUT_VERSION_ID = :layoutVersionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<IdxFgLayoutPartyStatus> idxfglayoutpartystatuss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM IDX_FG_LAYOUT_PARTY_STATUS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM IDX_FG_LAYOUT_PARTY_STATUS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple IdxFgLayoutPartyStatus records by their IDs.
     */
    @SqlQuery("SELECT * FROM IDX_FG_LAYOUT_PARTY_STATUS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(IdxFgLayoutPartyStatus.class)
    public List<IdxFgLayoutPartyStatus> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all IdxFgLayoutPartyStatus records by layoutVersionId.
     */
    @SqlQuery("SELECT * FROM IDX_FG_LAYOUT_PARTY_STATUS WHERE LAYOUT_VERSION_ID = :layoutVersionId")
    @RegisterBeanMapper(IdxFgLayoutPartyStatus.class)
    public List<IdxFgLayoutPartyStatus> findByLayoutVersionId(@Bind("layoutVersionId") int layoutVersionId);

    /**
     * Finds all IdxFgLayoutPartyStatus records by layoutId.
     */
    @SqlQuery("SELECT * FROM IDX_FG_LAYOUT_PARTY_STATUS WHERE LAYOUT_ID = :layoutId")
    @RegisterBeanMapper(IdxFgLayoutPartyStatus.class)
    public List<IdxFgLayoutPartyStatus> findByLayoutId(@Bind("layoutId") int layoutId);
}
