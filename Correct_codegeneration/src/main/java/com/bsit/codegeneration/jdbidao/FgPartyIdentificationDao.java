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
import com.bsit.codegeneration.entity.FgPartyIdentification;

public interface FgPartyIdentificationDao {

    /**
     * Inserts a new FgPartyIdentification and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_IDENTIFICATION (ID, PARTY_ID, PARTY_VERSION_ID, PARTY_CODE, PARTY_SUB_TYPE_CODE, IDENTIFIER_TYPE_CODE, IDENTITY_NO, ISSUER_CODE, ISSUER_NAME, VALID_FROM, VALID_TO, COMMENTS, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYS_DEFINED, SYSTEM_SOURCE_CODE, IDENTIFIER_SUB_TYPE_CODE) VALUES (:id, :partyId, :partyVersionId, :partyCode, :partySubTypeCode, :identifierTypeCode, :identityNo, :issuerCode, :issuerName, :validFrom, :validTo, :comments, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :sysDefined, :systemSourceCode, :identifierSubTypeCode)")
    public int insert(@BindBean FgPartyIdentification fgpartyidentification);

    /**
     * Finds a FgPartyIdentification by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_IDENTIFICATION WHERE FG_PARTY_IDENTIFICATION_id = :id")
    @RegisterBeanMapper(FgPartyIdentification.class)
    public Optional<FgPartyIdentification> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_IDENTIFICATION")
    @RegisterBeanMapper(FgPartyIdentification.class)
    public List<FgPartyIdentification> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_IDENTIFICATION ORDER BY FG_PARTY_IDENTIFICATION_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyIdentification.class)
    public List<FgPartyIdentification> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyIdentification and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_IDENTIFICATION SET ID = :id, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, PARTY_CODE = :partyCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, IDENTIFIER_TYPE_CODE = :identifierTypeCode, IDENTITY_NO = :identityNo, ISSUER_CODE = :issuerCode, ISSUER_NAME = :issuerName, VALID_FROM = :validFrom, VALID_TO = :validTo, COMMENTS = :comments, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, SYS_DEFINED = :sysDefined, SYSTEM_SOURCE_CODE = :systemSourceCode, IDENTIFIER_SUB_TYPE_CODE = :identifierSubTypeCode WHERE FG_PARTY_IDENTIFICATION_id = :fgPartyIdentificationId")
    public int update(@BindBean FgPartyIdentification fgpartyidentification);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_IDENTIFICATION WHERE FG_PARTY_IDENTIFICATION_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_IDENTIFICATION")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyIdentification entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_IDENTIFICATION (ID, PARTY_ID, PARTY_VERSION_ID, PARTY_CODE, PARTY_SUB_TYPE_CODE, IDENTIFIER_TYPE_CODE, IDENTITY_NO, ISSUER_CODE, ISSUER_NAME, VALID_FROM, VALID_TO, COMMENTS, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, SYS_DEFINED, SYSTEM_SOURCE_CODE, IDENTIFIER_SUB_TYPE_CODE) VALUES (:id, :partyId, :partyVersionId, :partyCode, :partySubTypeCode, :identifierTypeCode, :identityNo, :issuerCode, :issuerName, :validFrom, :validTo, :comments, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :sysDefined, :systemSourceCode, :identifierSubTypeCode)")
    public int[] bulkInsert(@BindBean List<FgPartyIdentification> fgpartyidentifications);

    /**
     * Bulk update multiple FgPartyIdentification entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_IDENTIFICATION SET ID = :id, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, PARTY_CODE = :partyCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, IDENTIFIER_TYPE_CODE = :identifierTypeCode, IDENTITY_NO = :identityNo, ISSUER_CODE = :issuerCode, ISSUER_NAME = :issuerName, VALID_FROM = :validFrom, VALID_TO = :validTo, COMMENTS = :comments, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, SYS_DEFINED = :sysDefined, SYSTEM_SOURCE_CODE = :systemSourceCode, IDENTIFIER_SUB_TYPE_CODE = :identifierSubTypeCode WHERE FG_PARTY_IDENTIFICATION_id = :fgPartyIdentificationId")
    public int[] bulkUpdate(@BindBean List<FgPartyIdentification> fgpartyidentifications);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_IDENTIFICATION WHERE FG_PARTY_IDENTIFICATION_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_IDENTIFICATION WHERE FG_PARTY_IDENTIFICATION_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgPartyIdentification records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_IDENTIFICATION WHERE FG_PARTY_IDENTIFICATION_id IN (<ids>)")
    @RegisterBeanMapper(FgPartyIdentification.class)
    public List<FgPartyIdentification> findByIds(@BindList("ids") Collection<Integer> ids);
}
