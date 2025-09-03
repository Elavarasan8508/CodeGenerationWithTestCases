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
import com.bsit.codegeneration.entity.FgPartyError;

public interface FgPartyErrorDao {

    /**
     * Inserts a new FgPartyError and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_PARTY_ERROR (IGNORE, CATEGORY, SEVERITY, TYPE_CODE, SUB_TYPE_CODE, PARTY_REFERENCE_ID, PARTY_CODE, MESSAGE, DETAILS, PARENT_PARTY_CODE) VALUES (:ignore, :category, :severity, :typeCode, :subTypeCode, :partyReferenceId, :partyCode, :message, :details, :parentPartyCode)")
    public int insert(@BindBean FgPartyError fgpartyerror);

    /**
     * Finds a FgPartyError by its ID.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ERROR WHERE FG_PARTY_ERROR_id = :id")
    @RegisterBeanMapper(FgPartyError.class)
    public Optional<FgPartyError> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ERROR")
    @RegisterBeanMapper(FgPartyError.class)
    public List<FgPartyError> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ERROR ORDER BY FG_PARTY_ERROR_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgPartyError.class)
    public List<FgPartyError> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgPartyError and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_PARTY_ERROR SET IGNORE = :ignore, CATEGORY = :category, SEVERITY = :severity, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PARTY_REFERENCE_ID = :partyReferenceId, PARTY_CODE = :partyCode, MESSAGE = :message, DETAILS = :details, PARENT_PARTY_CODE = :parentPartyCode WHERE FG_PARTY_ERROR_id = :fgPartyErrorId")
    public int update(@BindBean FgPartyError fgpartyerror);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ERROR WHERE FG_PARTY_ERROR_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_PARTY_ERROR")
    public long countAll();

    /**
     * Bulk insert multiple FgPartyError entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_PARTY_ERROR (IGNORE, CATEGORY, SEVERITY, TYPE_CODE, SUB_TYPE_CODE, PARTY_REFERENCE_ID, PARTY_CODE, MESSAGE, DETAILS, PARENT_PARTY_CODE) VALUES (:ignore, :category, :severity, :typeCode, :subTypeCode, :partyReferenceId, :partyCode, :message, :details, :parentPartyCode)")
    public int[] bulkInsert(@BindBean List<FgPartyError> fgpartyerrors);

    /**
     * Bulk update multiple FgPartyError entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_PARTY_ERROR SET IGNORE = :ignore, CATEGORY = :category, SEVERITY = :severity, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, PARTY_REFERENCE_ID = :partyReferenceId, PARTY_CODE = :partyCode, MESSAGE = :message, DETAILS = :details, PARENT_PARTY_CODE = :parentPartyCode WHERE FG_PARTY_ERROR_id = :fgPartyErrorId")
    public int[] bulkUpdate(@BindBean List<FgPartyError> fgpartyerrors);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_PARTY_ERROR WHERE FG_PARTY_ERROR_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_PARTY_ERROR WHERE FG_PARTY_ERROR_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgPartyError records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_PARTY_ERROR WHERE FG_PARTY_ERROR_id IN (<ids>)")
    @RegisterBeanMapper(FgPartyError.class)
    public List<FgPartyError> findByIds(@BindList("ids") Collection<Integer> ids);
}
