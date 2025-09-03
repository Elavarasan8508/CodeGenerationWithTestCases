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
import com.bsit.codegeneration.entity.FgTrdImpRegRq;

public interface FgTrdImpRegRqDao {

    /**
     * Inserts a new FgTrdImpRegRq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_TRD_IMP_REG_RQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, IE_CODE, INVOICE_NUMBER, PORT_CODE, PRODUCT_STATUS, BANK_CODE, BANK_NAME, TRAN_REQ, REQ_TYPE, PROCESS_ID, APPLICANT_PARTY, ISSUING_PARTY, DMS_EVENT_ID, TASK_REASON, NAME_MATCH, CHECKBOX, BANK_USER_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :boeNumber, :boeDate, :ieCode, :invoiceNumber, :portCode, :productStatus, :bankCode, :bankName, :tranReq, :reqType, :processId, :applicantParty, :issuingParty, :dmsEventId, :taskReason, :nameMatch, :checkbox, :bankUserId)")
    public int insert(@BindBean FgTrdImpRegRq fgtrdimpregrq);

    /**
     * Finds a FgTrdImpRegRq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_TRD_IMP_REG_RQ WHERE ID = :id")
    @RegisterBeanMapper(FgTrdImpRegRq.class)
    public Optional<FgTrdImpRegRq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_TRD_IMP_REG_RQ")
    @RegisterBeanMapper(FgTrdImpRegRq.class)
    public List<FgTrdImpRegRq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_TRD_IMP_REG_RQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgTrdImpRegRq.class)
    public List<FgTrdImpRegRq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgTrdImpRegRq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_TRD_IMP_REG_RQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, IE_CODE = :ieCode, INVOICE_NUMBER = :invoiceNumber, PORT_CODE = :portCode, PRODUCT_STATUS = :productStatus, BANK_CODE = :bankCode, BANK_NAME = :bankName, TRAN_REQ = :tranReq, REQ_TYPE = :reqType, PROCESS_ID = :processId, APPLICANT_PARTY = :applicantParty, ISSUING_PARTY = :issuingParty, DMS_EVENT_ID = :dmsEventId, TASK_REASON = :taskReason, NAME_MATCH = :nameMatch, CHECKBOX = :checkbox, BANK_USER_ID = :bankUserId WHERE ID = :id")
    public int update(@BindBean FgTrdImpRegRq fgtrdimpregrq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_IMP_REG_RQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_TRD_IMP_REG_RQ")
    public long countAll();

    /**
     * Bulk insert multiple FgTrdImpRegRq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_TRD_IMP_REG_RQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, IE_CODE, INVOICE_NUMBER, PORT_CODE, PRODUCT_STATUS, BANK_CODE, BANK_NAME, TRAN_REQ, REQ_TYPE, PROCESS_ID, APPLICANT_PARTY, ISSUING_PARTY, DMS_EVENT_ID, TASK_REASON, NAME_MATCH, CHECKBOX, BANK_USER_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :boeNumber, :boeDate, :ieCode, :invoiceNumber, :portCode, :productStatus, :bankCode, :bankName, :tranReq, :reqType, :processId, :applicantParty, :issuingParty, :dmsEventId, :taskReason, :nameMatch, :checkbox, :bankUserId)")
    public int[] bulkInsert(@BindBean List<FgTrdImpRegRq> fgtrdimpregrqs);

    /**
     * Bulk update multiple FgTrdImpRegRq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_TRD_IMP_REG_RQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, IE_CODE = :ieCode, INVOICE_NUMBER = :invoiceNumber, PORT_CODE = :portCode, PRODUCT_STATUS = :productStatus, BANK_CODE = :bankCode, BANK_NAME = :bankName, TRAN_REQ = :tranReq, REQ_TYPE = :reqType, PROCESS_ID = :processId, APPLICANT_PARTY = :applicantParty, ISSUING_PARTY = :issuingParty, DMS_EVENT_ID = :dmsEventId, TASK_REASON = :taskReason, NAME_MATCH = :nameMatch, CHECKBOX = :checkbox, BANK_USER_ID = :bankUserId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgTrdImpRegRq> fgtrdimpregrqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_TRD_IMP_REG_RQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_TRD_IMP_REG_RQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgTrdImpRegRq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_TRD_IMP_REG_RQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgTrdImpRegRq.class)
    public List<FgTrdImpRegRq> findByIds(@BindList("ids") Collection<String> ids);
}
