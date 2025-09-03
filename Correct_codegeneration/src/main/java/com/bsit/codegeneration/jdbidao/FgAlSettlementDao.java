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
import com.bsit.codegeneration.entity.FgAlSettlement;

public interface FgAlSettlementDao {

    /**
     * Inserts a new FgAlSettlement and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_AL_SETTLEMENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER_CRN, ACCOUNT_NUMBER, PROCESS_ID, IS_MASTER_VERSION, VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :customerCrn, :accountNumber, :processId, :isMasterVersion, :versionId)")
    public int insert(@BindBean FgAlSettlement fgalsettlement);

    /**
     * Finds a FgAlSettlement by its ID.
     */
    @SqlQuery("SELECT * FROM FG_AL_SETTLEMENT WHERE FG_AL_SETTLEMENT_id = :id")
    @RegisterBeanMapper(FgAlSettlement.class)
    public Optional<FgAlSettlement> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_AL_SETTLEMENT")
    @RegisterBeanMapper(FgAlSettlement.class)
    public List<FgAlSettlement> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_AL_SETTLEMENT ORDER BY FG_AL_SETTLEMENT_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAlSettlement.class)
    public List<FgAlSettlement> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAlSettlement and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_AL_SETTLEMENT SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUSTOMER_CRN = :customerCrn, ACCOUNT_NUMBER = :accountNumber, PROCESS_ID = :processId, IS_MASTER_VERSION = :isMasterVersion, VERSION_ID = :versionId WHERE FG_AL_SETTLEMENT_id = :fgAlSettlementId")
    public int update(@BindBean FgAlSettlement fgalsettlement);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AL_SETTLEMENT WHERE FG_AL_SETTLEMENT_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_AL_SETTLEMENT")
    public long countAll();

    /**
     * Bulk insert multiple FgAlSettlement entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_AL_SETTLEMENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CUSTOMER_CRN, ACCOUNT_NUMBER, PROCESS_ID, IS_MASTER_VERSION, VERSION_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :customerCrn, :accountNumber, :processId, :isMasterVersion, :versionId)")
    public int[] bulkInsert(@BindBean List<FgAlSettlement> fgalsettlements);

    /**
     * Bulk update multiple FgAlSettlement entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_AL_SETTLEMENT SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, CUSTOMER_CRN = :customerCrn, ACCOUNT_NUMBER = :accountNumber, PROCESS_ID = :processId, IS_MASTER_VERSION = :isMasterVersion, VERSION_ID = :versionId WHERE FG_AL_SETTLEMENT_id = :fgAlSettlementId")
    public int[] bulkUpdate(@BindBean List<FgAlSettlement> fgalsettlements);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AL_SETTLEMENT WHERE FG_AL_SETTLEMENT_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_AL_SETTLEMENT WHERE FG_AL_SETTLEMENT_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgAlSettlement records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_AL_SETTLEMENT WHERE FG_AL_SETTLEMENT_id IN (<ids>)")
    @RegisterBeanMapper(FgAlSettlement.class)
    public List<FgAlSettlement> findByIds(@BindList("ids") Collection<Integer> ids);
}
