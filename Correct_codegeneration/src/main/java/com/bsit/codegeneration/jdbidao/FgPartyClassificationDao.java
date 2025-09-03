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
import com.bsit.codegeneration.entity.FgPartyClassification;

public interface FgPartyClassificationDao {

    /**
     * Inserts a new FgPartyClassification and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_CLASSIFICATION (ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, CLASS_TYPE_CODE, CLASS_SUB_TYPE_CODE, VALID_FROM, VALID_TO, COMMENTS, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, DEMOGRAPHIC_TYPE_CODE, DEMOGRAPHIC_SUB_TYPE_CODE, SYS_DEFINED, SYSTEM_SOURCE_CODE) VALUES (:id, :partyId, :partyVersionId, :partySubTypeCode, :partyCode, :classTypeCode, :classSubTypeCode, :validFrom, :validTo, :comments, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :demographicTypeCode, :demographicSubTypeCode, :sysDefined, :systemSourceCode)")
    public int insert(@BindBean FgPartyClassification fgpartyclassification);

    /**
     * Finds a FgPartyClassification by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CLASSIFICATION WHERE FG_PARTY_CLASSIFICATION_id = :id")
    @RegisterBeanMapper(FgPartyClassification.class)
    public Optional<FgPartyClassification> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CLASSIFICATION")
    @RegisterBeanMapper(FgPartyClassification.class)
    public List<FgPartyClassification> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CLASSIFICATION ORDER BY FG_PARTY_CLASSIFICATION_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyClassification.class)
    public List<FgPartyClassification> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyClassification and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_CLASSIFICATION SET ID = :id, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PARTY_CODE = :partyCode, CLASS_TYPE_CODE = :classTypeCode, CLASS_SUB_TYPE_CODE = :classSubTypeCode, VALID_FROM = :validFrom, VALID_TO = :validTo, COMMENTS = :comments, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, DEMOGRAPHIC_TYPE_CODE = :demographicTypeCode, DEMOGRAPHIC_SUB_TYPE_CODE = :demographicSubTypeCode, SYS_DEFINED = :sysDefined, SYSTEM_SOURCE_CODE = :systemSourceCode WHERE FG_PARTY_CLASSIFICATION_id = :fgPartyClassificationId")
    public int update(@BindBean FgPartyClassification fgpartyclassification);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_CLASSIFICATION WHERE FG_PARTY_CLASSIFICATION_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_CLASSIFICATION")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyClassification entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_CLASSIFICATION (ID, PARTY_ID, PARTY_VERSION_ID, PARTY_SUB_TYPE_CODE, PARTY_CODE, CLASS_TYPE_CODE, CLASS_SUB_TYPE_CODE, VALID_FROM, VALID_TO, COMMENTS, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, DEMOGRAPHIC_TYPE_CODE, DEMOGRAPHIC_SUB_TYPE_CODE, SYS_DEFINED, SYSTEM_SOURCE_CODE) VALUES (:id, :partyId, :partyVersionId, :partySubTypeCode, :partyCode, :classTypeCode, :classSubTypeCode, :validFrom, :validTo, :comments, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :demographicTypeCode, :demographicSubTypeCode, :sysDefined, :systemSourceCode)")
    public int[] bulkInsert(@BindBean List<FgPartyClassification> fgpartyclassifications);

    /**
     * Bulk update multiple FgPartyClassification entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_CLASSIFICATION SET ID = :id, PARTY_ID = :partyId, PARTY_VERSION_ID = :partyVersionId, PARTY_SUB_TYPE_CODE = :partySubTypeCode, PARTY_CODE = :partyCode, CLASS_TYPE_CODE = :classTypeCode, CLASS_SUB_TYPE_CODE = :classSubTypeCode, VALID_FROM = :validFrom, VALID_TO = :validTo, COMMENTS = :comments, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, DEMOGRAPHIC_TYPE_CODE = :demographicTypeCode, DEMOGRAPHIC_SUB_TYPE_CODE = :demographicSubTypeCode, SYS_DEFINED = :sysDefined, SYSTEM_SOURCE_CODE = :systemSourceCode WHERE FG_PARTY_CLASSIFICATION_id = :fgPartyClassificationId")
    public int[] bulkUpdate(@BindBean List<FgPartyClassification> fgpartyclassifications);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_CLASSIFICATION WHERE FG_PARTY_CLASSIFICATION_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_CLASSIFICATION WHERE FG_PARTY_CLASSIFICATION_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgPartyClassification records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_CLASSIFICATION WHERE FG_PARTY_CLASSIFICATION_id IN (<ids>)")
    @RegisterBeanMapper(FgPartyClassification.class)
    public List<FgPartyClassification> findByIds(@BindList("ids") Collection<Integer> ids);
}
