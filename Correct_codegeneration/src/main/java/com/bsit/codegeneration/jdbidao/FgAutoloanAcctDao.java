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
import com.bsit.codegeneration.entity.FgAutoloanAcct;

public interface FgAutoloanAcctDao {

    /**
     * Inserts a new FgAutoloanAcct and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_AUTOLOAN_ACCT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, ACCT_NUM, PRODUCT_CODE, MAX_SET_PERCENT, MAX_SET_AMOUNT, PARENT_REF_ID, PARENT_VERSION_ID, LOGIC_SETTLE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :acctNum, :productCode, :maxSetPercent, :maxSetAmount, :parentRefId, :parentVersionId, :logicSettle)")
    public int insert(@BindBean FgAutoloanAcct fgautoloanacct);

    /**
     * Finds a FgAutoloanAcct by its ID.
     */
    @SqlQuery("SELECT * FROM FG_AUTOLOAN_ACCT WHERE ID = :id")
    @RegisterBeanMapper(FgAutoloanAcct.class)
    public Optional<FgAutoloanAcct> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_AUTOLOAN_ACCT")
    @RegisterBeanMapper(FgAutoloanAcct.class)
    public List<FgAutoloanAcct> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_AUTOLOAN_ACCT ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgAutoloanAcct.class)
    public List<FgAutoloanAcct> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgAutoloanAcct and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_AUTOLOAN_ACCT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, ACCT_NUM = :acctNum, PRODUCT_CODE = :productCode, MAX_SET_PERCENT = :maxSetPercent, MAX_SET_AMOUNT = :maxSetAmount, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, LOGIC_SETTLE = :logicSettle WHERE ID = :id")
    public int update(@BindBean FgAutoloanAcct fgautoloanacct);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AUTOLOAN_ACCT WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_AUTOLOAN_ACCT")
    public long countAll();

    /**
     * Bulk insert multiple FgAutoloanAcct entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_AUTOLOAN_ACCT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, ACCT_NUM, PRODUCT_CODE, MAX_SET_PERCENT, MAX_SET_AMOUNT, PARENT_REF_ID, PARENT_VERSION_ID, LOGIC_SETTLE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :acctNum, :productCode, :maxSetPercent, :maxSetAmount, :parentRefId, :parentVersionId, :logicSettle)")
    public int[] bulkInsert(@BindBean List<FgAutoloanAcct> fgautoloanaccts);

    /**
     * Bulk update multiple FgAutoloanAcct entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_AUTOLOAN_ACCT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, ACCT_NUM = :acctNum, PRODUCT_CODE = :productCode, MAX_SET_PERCENT = :maxSetPercent, MAX_SET_AMOUNT = :maxSetAmount, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, LOGIC_SETTLE = :logicSettle WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgAutoloanAcct> fgautoloanaccts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_AUTOLOAN_ACCT WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_AUTOLOAN_ACCT WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgAutoloanAcct records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_AUTOLOAN_ACCT WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgAutoloanAcct.class)
    public List<FgAutoloanAcct> findByIds(@BindList("ids") Collection<String> ids);
}
