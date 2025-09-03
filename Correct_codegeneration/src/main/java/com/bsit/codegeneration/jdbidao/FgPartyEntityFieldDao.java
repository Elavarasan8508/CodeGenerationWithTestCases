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
import com.bsit.codegeneration.entity.FgPartyEntityField;

public interface FgPartyEntityFieldDao {

    /**
     * Inserts a new FgPartyEntityField and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_ENTITY_FIELD (ID, MODEL_CODE, PARTY_ID, PARTY_VERSION_ID, NAME, IS_DENY, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :modelCode, :partyId, :partyVersionId, :name, :isDeny, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgPartyEntityField fgpartyentityfield);

    /**
     * Finds a FgPartyEntityField by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY_FIELD WHERE ID = :id")
    @RegisterBeanMapper(FgPartyEntityField.class)
    public Optional<FgPartyEntityField> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY_FIELD")
    @RegisterBeanMapper(FgPartyEntityField.class)
    public List<FgPartyEntityField> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY_FIELD ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyEntityField.class)
    public List<FgPartyEntityField> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyEntityField and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_ENTITY_FIELD SET MODEL_CODE = :modelCode, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, NAME = :name, IS_DENY = :isDeny, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgPartyEntityField fgpartyentityfield);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ENTITY_FIELD WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_ENTITY_FIELD")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyEntityField entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_ENTITY_FIELD (ID, MODEL_CODE, PARTY_ID, PARTY_VERSION_ID, NAME, IS_DENY, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :modelCode, :partyId, :partyVersionId, :name, :isDeny, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgPartyEntityField> fgpartyentityfields);

    /**
     * Bulk update multiple FgPartyEntityField entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_ENTITY_FIELD SET MODEL_CODE = :modelCode, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, NAME = :name, IS_DENY = :isDeny, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPartyEntityField> fgpartyentityfields);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ENTITY_FIELD WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_ENTITY_FIELD WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPartyEntityField records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ENTITY_FIELD WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPartyEntityField.class)
    public List<FgPartyEntityField> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
