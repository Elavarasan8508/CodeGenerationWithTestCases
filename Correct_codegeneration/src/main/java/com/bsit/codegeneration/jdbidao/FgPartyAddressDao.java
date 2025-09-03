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
import com.bsit.codegeneration.entity.FgPartyAddress;

public interface FgPartyAddressDao {

    /**
     * Inserts a new FgPartyAddress and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_ADDRESS (ID, PURPOSE_CODE, ADDRESS_ID, PARTY_ID, PARTY_VERSION_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :purposeCode, :addressId, :partyId, :partyVersionId, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgPartyAddress fgpartyaddress);

    /**
     * Finds a FgPartyAddress by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ADDRESS WHERE ID = :id")
    @RegisterBeanMapper(FgPartyAddress.class)
    public Optional<FgPartyAddress> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ADDRESS")
    @RegisterBeanMapper(FgPartyAddress.class)
    public List<FgPartyAddress> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ADDRESS ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyAddress.class)
    public List<FgPartyAddress> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyAddress and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_ADDRESS SET PURPOSE_CODE = :purposeCode, ADDRESS_ID = :addressId, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgPartyAddress fgpartyaddress);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ADDRESS WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_ADDRESS")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyAddress entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_ADDRESS (ID, PURPOSE_CODE, ADDRESS_ID, PARTY_ID, PARTY_VERSION_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :purposeCode, :addressId, :partyId, :partyVersionId, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgPartyAddress> fgpartyaddresss);

    /**
     * Bulk update multiple FgPartyAddress entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_ADDRESS SET PURPOSE_CODE = :purposeCode, ADDRESS_ID = :addressId, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPartyAddress> fgpartyaddresss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ADDRESS WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_ADDRESS WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPartyAddress records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ADDRESS WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPartyAddress.class)
    public List<FgPartyAddress> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgPartyAddress records by partyVersionId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ADDRESS WHERE PARTY_VERSION_ID = :partyVersionId")
    @RegisterBeanMapper(FgPartyAddress.class)
    public List<FgPartyAddress> findByPartyVersionId(@Bind("partyVersionId") int partyVersionId);

    /**
     * Finds all FgPartyAddress records by partyId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ADDRESS WHERE PARTY_ID = :partyId")
    @RegisterBeanMapper(FgPartyAddress.class)
    public List<FgPartyAddress> findByPartyId(@Bind("partyId") int partyId);

    /**
     * Finds all FgPartyAddress records by addressId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ADDRESS WHERE ADDRESS_ID = :addressId")
    @RegisterBeanMapper(FgPartyAddress.class)
    public List<FgPartyAddress> findByAddressId(@Bind("addressId") int addressId);
}
