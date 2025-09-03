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
import com.bsit.codegeneration.entity.FgTdMaturityMaster;

public interface FgTdMaturityMasterDao {

    /**
     * Inserts a new FgTdMaturityMaster and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TD_MATURITY_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, MATURITY_CODE, MATURITY_VALUE, MATURITY_DESCRIPTION, ORIGIN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :maturityCode, :maturityValue, :maturityDescription, :origin)")
    public int insert(@BindBean FgTdMaturityMaster fgtdmaturitymaster);

    /**
     * Finds a FgTdMaturityMaster by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TD_MATURITY_MASTER WHERE ID = :id")
    @RegisterBeanMapper(FgTdMaturityMaster.class)
    public Optional<FgTdMaturityMaster> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TD_MATURITY_MASTER")
    @RegisterBeanMapper(FgTdMaturityMaster.class)
    public List<FgTdMaturityMaster> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TD_MATURITY_MASTER ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTdMaturityMaster.class)
    public List<FgTdMaturityMaster> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTdMaturityMaster and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TD_MATURITY_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, MATURITY_CODE = :maturityCode, MATURITY_VALUE = :maturityValue, MATURITY_DESCRIPTION = :maturityDescription, ORIGIN = :origin WHERE ID = :id")
    public int update(@BindBean FgTdMaturityMaster fgtdmaturitymaster);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_MATURITY_MASTER WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TD_MATURITY_MASTER")
    public long countAll();

    /**
     * Bulk insert multiple FgTdMaturityMaster entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TD_MATURITY_MASTER (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, MATURITY_CODE, MATURITY_VALUE, MATURITY_DESCRIPTION, ORIGIN) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :maturityCode, :maturityValue, :maturityDescription, :origin)")
    public int[] bulkInsert(@BindBean List<FgTdMaturityMaster> fgtdmaturitymasters);

    /**
     * Bulk update multiple FgTdMaturityMaster entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TD_MATURITY_MASTER SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, MATURITY_CODE = :maturityCode, MATURITY_VALUE = :maturityValue, MATURITY_DESCRIPTION = :maturityDescription, ORIGIN = :origin WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTdMaturityMaster> fgtdmaturitymasters);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TD_MATURITY_MASTER WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TD_MATURITY_MASTER WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTdMaturityMaster records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TD_MATURITY_MASTER WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTdMaturityMaster.class)
    public List<FgTdMaturityMaster> findByIds(@BindList("ids") Collection<String> ids);
}
