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
import com.bsit.codegeneration.entity.FgAutoloanSettlement;

public interface FgAutoloanSettlementDao {

    /**
     * Inserts a new FgAutoloanSettlement and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_AUTOLOAN_SETTLEMENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CRN, PARTY_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :crn, :partyName)")
    public int insert(@BindBean FgAutoloanSettlement fgautoloansettlement);

    /**
     * Finds a FgAutoloanSettlement by its ID.
     */
    @SqlQuery("SELECT * FROM FG_AUTOLOAN_SETTLEMENT WHERE ID = :id")
    @RegisterBeanMapper(FgAutoloanSettlement.class)
    public Optional<FgAutoloanSettlement> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_AUTOLOAN_SETTLEMENT")
    @RegisterBeanMapper(FgAutoloanSettlement.class)
    public List<FgAutoloanSettlement> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_AUTOLOAN_SETTLEMENT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAutoloanSettlement.class)
    public List<FgAutoloanSettlement> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAutoloanSettlement and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_AUTOLOAN_SETTLEMENT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, CRN = :crn, PARTY_NAME = :partyName WHERE ID = :id")
    public int update(@BindBean FgAutoloanSettlement fgautoloansettlement);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AUTOLOAN_SETTLEMENT WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_AUTOLOAN_SETTLEMENT")
    public long countAll();

    /**
     * Bulk insert multiple FgAutoloanSettlement entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_AUTOLOAN_SETTLEMENT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CRN, PARTY_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :crn, :partyName)")
    public int[] bulkInsert(@BindBean List<FgAutoloanSettlement> fgautoloansettlements);

    /**
     * Bulk update multiple FgAutoloanSettlement entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_AUTOLOAN_SETTLEMENT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, CRN = :crn, PARTY_NAME = :partyName WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgAutoloanSettlement> fgautoloansettlements);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AUTOLOAN_SETTLEMENT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_AUTOLOAN_SETTLEMENT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgAutoloanSettlement records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_AUTOLOAN_SETTLEMENT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgAutoloanSettlement.class)
    public List<FgAutoloanSettlement> findByIds(@BindList("ids") Collection<String> ids);
}
