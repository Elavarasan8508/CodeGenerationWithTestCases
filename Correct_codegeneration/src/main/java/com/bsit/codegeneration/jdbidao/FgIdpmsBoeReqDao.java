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
import com.bsit.codegeneration.entity.FgIdpmsBoeReq;

public interface FgIdpmsBoeReqDao {

    /**
     * Inserts a new FgIdpmsBoeReq and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_IDPMS_BOE_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, IE_CODE, OVERDUE_PERIOD, INVOICE_SL_NO, INV_NUM, TERMS_OF_INV, INV_CCY, INV_AMT, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, UTILIZED_INV_AMT, OS_INV_AMT, ENDORSED_AMT, CLOSURE_INDICATOR, ADJ_AMT, ADJ_REASON, EXTENDED_DATE, EXTENDED_BY, REMARKS, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DESC, REQ_TYPE, FINAL_ERROR_DESC, FINAL_ERROR_CODE, FINAL_STATUS, AD_CODE, DOC_NO, DOC_DATE, LETTER_DATE, LETTER_NO, APPROVED_BY, CHECKBOX, RBI_STATUS, RBI_ERROR_DESC, RBI_ERROR_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :boeNumber, :boeDate, :portOfDis, :importAgency, :ieCode, :overduePeriod, :invoiceSlNo, :invNum, :termsOfInv, :invCcy, :invAmt, :supplierName, :supplierAddr, :supplierCountry, :sellerName, :sellerAddr, :sellerCountry, :utilizedInvAmt, :osInvAmt, :endorsedAmt, :closureIndicator, :adjAmt, :adjReason, :extendedDate, :extendedBy, :remarks, :parentRefId, :parentVersionId, :trracsStatus, :trracsErrorCode, :trracsErrorDesc, :reqType, :finalErrorDesc, :finalErrorCode, :finalStatus, :adCode, :docNo, :docDate, :letterDate, :letterNo, :approvedBy, :checkbox, :rbiStatus, :rbiErrorDesc, :rbiErrorCode)")
    public int insert(@BindBean FgIdpmsBoeReq fgidpmsboereq);

    /**
     * Finds a FgIdpmsBoeReq by its ID.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_BOE_REQ WHERE ID = :id")
    @RegisterBeanMapper(FgIdpmsBoeReq.class)
    public Optional<FgIdpmsBoeReq> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_BOE_REQ")
    @RegisterBeanMapper(FgIdpmsBoeReq.class)
    public List<FgIdpmsBoeReq> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_BOE_REQ ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgIdpmsBoeReq.class)
    public List<FgIdpmsBoeReq> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgIdpmsBoeReq and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_IDPMS_BOE_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, PORT_OF_DIS = :portOfDis, IMPORT_AGENCY = :importAgency, IE_CODE = :ieCode, OVERDUE_PERIOD = :overduePeriod, INVOICE_SL_NO = :invoiceSlNo, INV_NUM = :invNum, TERMS_OF_INV = :termsOfInv, INV_CCY = :invCcy, INV_AMT = :invAmt, SUPPLIER_NAME = :supplierName, SUPPLIER_ADDR = :supplierAddr, SUPPLIER_COUNTRY = :supplierCountry, SELLER_NAME = :sellerName, SELLER_ADDR = :sellerAddr, SELLER_COUNTRY = :sellerCountry, UTILIZED_INV_AMT = :utilizedInvAmt, OS_INV_AMT = :osInvAmt, ENDORSED_AMT = :endorsedAmt, CLOSURE_INDICATOR = :closureIndicator, ADJ_AMT = :adjAmt, ADJ_REASON = :adjReason, EXTENDED_DATE = :extendedDate, EXTENDED_BY = :extendedBy, REMARKS = :remarks, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, TRRACS_STATUS = :trracsStatus, TRRACS_ERROR_CODE = :trracsErrorCode, TRRACS_ERROR_DESC = :trracsErrorDesc, REQ_TYPE = :reqType, FINAL_ERROR_DESC = :finalErrorDesc, FINAL_ERROR_CODE = :finalErrorCode, FINAL_STATUS = :finalStatus, AD_CODE = :adCode, DOC_NO = :docNo, DOC_DATE = :docDate, LETTER_DATE = :letterDate, LETTER_NO = :letterNo, APPROVED_BY = :approvedBy, CHECKBOX = :checkbox, RBI_STATUS = :rbiStatus, RBI_ERROR_DESC = :rbiErrorDesc, RBI_ERROR_CODE = :rbiErrorCode WHERE ID = :id")
    public int update(@BindBean FgIdpmsBoeReq fgidpmsboereq);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_IDPMS_BOE_REQ WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_IDPMS_BOE_REQ")
    public long countAll();

    /**
     * Bulk insert multiple FgIdpmsBoeReq entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_IDPMS_BOE_REQ (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BOE_NUMBER, BOE_DATE, PORT_OF_DIS, IMPORT_AGENCY, IE_CODE, OVERDUE_PERIOD, INVOICE_SL_NO, INV_NUM, TERMS_OF_INV, INV_CCY, INV_AMT, SUPPLIER_NAME, SUPPLIER_ADDR, SUPPLIER_COUNTRY, SELLER_NAME, SELLER_ADDR, SELLER_COUNTRY, UTILIZED_INV_AMT, OS_INV_AMT, ENDORSED_AMT, CLOSURE_INDICATOR, ADJ_AMT, ADJ_REASON, EXTENDED_DATE, EXTENDED_BY, REMARKS, PARENT_REF_ID, PARENT_VERSION_ID, TRRACS_STATUS, TRRACS_ERROR_CODE, TRRACS_ERROR_DESC, REQ_TYPE, FINAL_ERROR_DESC, FINAL_ERROR_CODE, FINAL_STATUS, AD_CODE, DOC_NO, DOC_DATE, LETTER_DATE, LETTER_NO, APPROVED_BY, CHECKBOX, RBI_STATUS, RBI_ERROR_DESC, RBI_ERROR_CODE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :boeNumber, :boeDate, :portOfDis, :importAgency, :ieCode, :overduePeriod, :invoiceSlNo, :invNum, :termsOfInv, :invCcy, :invAmt, :supplierName, :supplierAddr, :supplierCountry, :sellerName, :sellerAddr, :sellerCountry, :utilizedInvAmt, :osInvAmt, :endorsedAmt, :closureIndicator, :adjAmt, :adjReason, :extendedDate, :extendedBy, :remarks, :parentRefId, :parentVersionId, :trracsStatus, :trracsErrorCode, :trracsErrorDesc, :reqType, :finalErrorDesc, :finalErrorCode, :finalStatus, :adCode, :docNo, :docDate, :letterDate, :letterNo, :approvedBy, :checkbox, :rbiStatus, :rbiErrorDesc, :rbiErrorCode)")
    public int[] bulkInsert(@BindBean List<FgIdpmsBoeReq> fgidpmsboereqs);

    /**
     * Bulk update multiple FgIdpmsBoeReq entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_IDPMS_BOE_REQ SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BOE_NUMBER = :boeNumber, BOE_DATE = :boeDate, PORT_OF_DIS = :portOfDis, IMPORT_AGENCY = :importAgency, IE_CODE = :ieCode, OVERDUE_PERIOD = :overduePeriod, INVOICE_SL_NO = :invoiceSlNo, INV_NUM = :invNum, TERMS_OF_INV = :termsOfInv, INV_CCY = :invCcy, INV_AMT = :invAmt, SUPPLIER_NAME = :supplierName, SUPPLIER_ADDR = :supplierAddr, SUPPLIER_COUNTRY = :supplierCountry, SELLER_NAME = :sellerName, SELLER_ADDR = :sellerAddr, SELLER_COUNTRY = :sellerCountry, UTILIZED_INV_AMT = :utilizedInvAmt, OS_INV_AMT = :osInvAmt, ENDORSED_AMT = :endorsedAmt, CLOSURE_INDICATOR = :closureIndicator, ADJ_AMT = :adjAmt, ADJ_REASON = :adjReason, EXTENDED_DATE = :extendedDate, EXTENDED_BY = :extendedBy, REMARKS = :remarks, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId, TRRACS_STATUS = :trracsStatus, TRRACS_ERROR_CODE = :trracsErrorCode, TRRACS_ERROR_DESC = :trracsErrorDesc, REQ_TYPE = :reqType, FINAL_ERROR_DESC = :finalErrorDesc, FINAL_ERROR_CODE = :finalErrorCode, FINAL_STATUS = :finalStatus, AD_CODE = :adCode, DOC_NO = :docNo, DOC_DATE = :docDate, LETTER_DATE = :letterDate, LETTER_NO = :letterNo, APPROVED_BY = :approvedBy, CHECKBOX = :checkbox, RBI_STATUS = :rbiStatus, RBI_ERROR_DESC = :rbiErrorDesc, RBI_ERROR_CODE = :rbiErrorCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgIdpmsBoeReq> fgidpmsboereqs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_IDPMS_BOE_REQ WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_IDPMS_BOE_REQ WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgIdpmsBoeReq records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_IDPMS_BOE_REQ WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgIdpmsBoeReq.class)
    public List<FgIdpmsBoeReq> findByIds(@BindList("ids") Collection<String> ids);
}
