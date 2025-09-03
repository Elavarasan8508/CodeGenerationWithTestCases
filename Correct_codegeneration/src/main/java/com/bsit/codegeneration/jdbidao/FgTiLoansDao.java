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
import com.bsit.codegeneration.entity.FgTiLoans;

public interface FgTiLoansDao {

    /**
     * Inserts a new FgTiLoans and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TI_LOANS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUST_MNM, DISB_DATE, INTEREST_REPAYMENT_AMOUNT, MASTER_REF, MATURITY_DATE, OVERDUE_Y_N, STATUS, VERSION_ID, IS_MASTER_VERSION, TOTAL_REPAYMENT_AMOUNT, PRINCIPLE_REPAYMENT_AMOUNT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :custMnm, :disbDate, :interestRepaymentAmount, :masterRef, :maturityDate, :overdueYN, :status, :versionId, :isMasterVersion, :totalRepaymentAmount, :principleRepaymentAmount)")
    public int insert(@BindBean FgTiLoans fgtiloans);

    /**
     * Finds a FgTiLoans by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TI_LOANS WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgTiLoans.class)
    public Optional<FgTiLoans> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TI_LOANS")
    @RegisterBeanMapper(FgTiLoans.class)
    public List<FgTiLoans> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TI_LOANS ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTiLoans.class)
    public List<FgTiLoans> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTiLoans and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TI_LOANS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, CUST_MNM = :custMnm, DISB_DATE = :disbDate, INTEREST_REPAYMENT_AMOUNT = :interestRepaymentAmount, MASTER_REF = :masterRef, MATURITY_DATE = :maturityDate, OVERDUE_Y_N = :overdueYN, STATUS = :status, IS_MASTER_VERSION = :isMasterVersion, TOTAL_REPAYMENT_AMOUNT = :totalRepaymentAmount, PRINCIPLE_REPAYMENT_AMOUNT = :principleRepaymentAmount WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgTiLoans fgtiloans);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TI_LOANS WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TI_LOANS")
    public long countAll();

    /**
     * Bulk insert multiple FgTiLoans entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TI_LOANS (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, CUST_MNM, DISB_DATE, INTEREST_REPAYMENT_AMOUNT, MASTER_REF, MATURITY_DATE, OVERDUE_Y_N, STATUS, VERSION_ID, IS_MASTER_VERSION, TOTAL_REPAYMENT_AMOUNT, PRINCIPLE_REPAYMENT_AMOUNT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :custMnm, :disbDate, :interestRepaymentAmount, :masterRef, :maturityDate, :overdueYN, :status, :versionId, :isMasterVersion, :totalRepaymentAmount, :principleRepaymentAmount)")
    public int[] bulkInsert(@BindBean List<FgTiLoans> fgtiloanss);

    /**
     * Bulk update multiple FgTiLoans entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TI_LOANS SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, CUST_MNM = :custMnm, DISB_DATE = :disbDate, INTEREST_REPAYMENT_AMOUNT = :interestRepaymentAmount, MASTER_REF = :masterRef, MATURITY_DATE = :maturityDate, OVERDUE_Y_N = :overdueYN, STATUS = :status, IS_MASTER_VERSION = :isMasterVersion, TOTAL_REPAYMENT_AMOUNT = :totalRepaymentAmount, PRINCIPLE_REPAYMENT_AMOUNT = :principleRepaymentAmount WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgTiLoans> fgtiloanss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TI_LOANS WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TI_LOANS WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTiLoans records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TI_LOANS WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgTiLoans.class)
    public List<FgTiLoans> findByIds(@BindList("ids") Collection<String> ids);
}
