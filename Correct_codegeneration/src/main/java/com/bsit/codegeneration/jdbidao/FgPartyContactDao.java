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
import com.bsit.codegeneration.entity.FgPartyContact;

public interface FgPartyContactDao {

    /**
     * Inserts a new FgPartyContact and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_CONTACT (ID, PARTY_ID, PURPOSE_CODE, REFERENCE, TYPE_CODE, PARTY_VERSION_ID, DESCRIPTION, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE, SYS_DEFINED) VALUES (:id, :partyId, :purposeCode, :reference, :typeCode, :partyVersionId, :description, :lastAuthorisedOn, :lastAuthorisedBy, :systemSourceCode, :sysDefined)")
    public int insert(@BindBean FgPartyContact fgpartycontact);

    /**
     * Finds a FgPartyContact by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CONTACT WHERE ID = :id")
    @RegisterBeanMapper(FgPartyContact.class)
    public Optional<FgPartyContact> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CONTACT")
    @RegisterBeanMapper(FgPartyContact.class)
    public List<FgPartyContact> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CONTACT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyContact.class)
    public List<FgPartyContact> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyContact and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_CONTACT SET PARTY_ID = :partyId, PURPOSE_CODE = :purposeCode, REFERENCE = :reference, TYPE_CODE = :typeCode, PARTY_VERSION_ID = :partyVersionId, DESCRIPTION = :description, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, SYSTEM_SOURCE_CODE = :systemSourceCode, SYS_DEFINED = :sysDefined WHERE ID = :id")
    public int update(@BindBean FgPartyContact fgpartycontact);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_CONTACT WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_CONTACT")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyContact entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_CONTACT (ID, PARTY_ID, PURPOSE_CODE, REFERENCE, TYPE_CODE, PARTY_VERSION_ID, DESCRIPTION, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYSTEM_SOURCE_CODE, SYS_DEFINED) VALUES (:id, :partyId, :purposeCode, :reference, :typeCode, :partyVersionId, :description, :lastAuthorisedOn, :lastAuthorisedBy, :systemSourceCode, :sysDefined)")
    public int[] bulkInsert(@BindBean List<FgPartyContact> fgpartycontacts);

    /**
     * Bulk update multiple FgPartyContact entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_CONTACT SET PARTY_ID = :partyId, PURPOSE_CODE = :purposeCode, REFERENCE = :reference, TYPE_CODE = :typeCode, PARTY_VERSION_ID = :partyVersionId, DESCRIPTION = :description, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, SYSTEM_SOURCE_CODE = :systemSourceCode, SYS_DEFINED = :sysDefined WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgPartyContact> fgpartycontacts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_CONTACT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_CONTACT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgPartyContact records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CONTACT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgPartyContact.class)
    public List<FgPartyContact> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Finds all FgPartyContact records by partyVersionId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CONTACT WHERE PARTY_VERSION_ID = :partyVersionId")
    @RegisterBeanMapper(FgPartyContact.class)
    public List<FgPartyContact> findByPartyVersionId(@Bind("partyVersionId") int partyVersionId);

    /**
     * Finds all FgPartyContact records by partyId.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CONTACT WHERE PARTY_ID = :partyId")
    @RegisterBeanMapper(FgPartyContact.class)
    public List<FgPartyContact> findByPartyId(@Bind("partyId") int partyId);
}
