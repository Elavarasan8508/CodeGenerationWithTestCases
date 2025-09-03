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
import com.bsit.codegeneration.entity.CoreMdmProduct;

public interface CoreMdmProductDao {

    /**
     * Inserts a new CoreMdmProduct and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO CORE_MDM_PRODUCT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PRODUCT_CODE, PRODUCT_NAME, PRODUCT_STATUS_CODE, PRODUCT_DESCRIPTION, BORROWER_PARTY, ASSET_LIABILITY_APPLICABLE, CREDIT_LINE_APPLICABLE, EXPOSURE_MAINTENANCE_REQ, INVOICE_RAISED_BY, FINANCE_REQUEST_BY, INTEREST_CALCULATION, ACCRUAL_AMORTIZE, ANCHOR_PARTY, FINANCE_DEBIT_PARTY, FINANCE_TO_PARTY, SEGMENT_CODE, CUTOFF_APPLICABLE, CHARGES_APPLICABLE, HOLIDAY_APPLICABLE, ALLOW_PAYMENT, ALLOW_COLLECTION, BA_SHORT_NAME, PRODUCT_GROUP_CODE, PRODUCT_SUBGROUP_CODE, CLASSIFICATION, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :productCode, :productName, :productStatusCode, :productDescription, :borrowerParty, :assetLiabilityApplicable, :creditLineApplicable, :exposureMaintenanceReq, :invoiceRaisedBy, :financeRequestBy, :interestCalculation, :accrualAmortize, :anchorParty, :financeDebitParty, :financeToParty, :segmentCode, :cutoffApplicable, :chargesApplicable, :holidayApplicable, :allowPayment, :allowCollection, :baShortName, :productGroupCode, :productSubgroupCode, :classification, :versionId, :isMasterVersion, :uploadRefId)")
    public int insert(@BindBean CoreMdmProduct coremdmproduct);

    /**
     * Finds a CoreMdmProduct by its ID.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_PRODUCT WHERE VERSION_ID = :id")
    @RegisterBeanMapper(CoreMdmProduct.class)
    public Optional<CoreMdmProduct> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_PRODUCT")
    @RegisterBeanMapper(CoreMdmProduct.class)
    public List<CoreMdmProduct> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_PRODUCT ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(CoreMdmProduct.class)
    public List<CoreMdmProduct> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a CoreMdmProduct and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE CORE_MDM_PRODUCT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, PRODUCT_CODE = :productCode, PRODUCT_NAME = :productName, PRODUCT_STATUS_CODE = :productStatusCode, PRODUCT_DESCRIPTION = :productDescription, BORROWER_PARTY = :borrowerParty, ASSET_LIABILITY_APPLICABLE = :assetLiabilityApplicable, CREDIT_LINE_APPLICABLE = :creditLineApplicable, EXPOSURE_MAINTENANCE_REQ = :exposureMaintenanceReq, INVOICE_RAISED_BY = :invoiceRaisedBy, FINANCE_REQUEST_BY = :financeRequestBy, INTEREST_CALCULATION = :interestCalculation, ACCRUAL_AMORTIZE = :accrualAmortize, ANCHOR_PARTY = :anchorParty, FINANCE_DEBIT_PARTY = :financeDebitParty, FINANCE_TO_PARTY = :financeToParty, SEGMENT_CODE = :segmentCode, CUTOFF_APPLICABLE = :cutoffApplicable, CHARGES_APPLICABLE = :chargesApplicable, HOLIDAY_APPLICABLE = :holidayApplicable, ALLOW_PAYMENT = :allowPayment, ALLOW_COLLECTION = :allowCollection, BA_SHORT_NAME = :baShortName, PRODUCT_GROUP_CODE = :productGroupCode, PRODUCT_SUBGROUP_CODE = :productSubgroupCode, CLASSIFICATION = :classification, IS_MASTER_VERSION = :isMasterVersion, UPLOAD_REF_ID = :uploadRefId WHERE VERSION_ID = :versionId")
    public int update(@BindBean CoreMdmProduct coremdmproduct);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM CORE_MDM_PRODUCT WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM CORE_MDM_PRODUCT")
    public long countAll();

    /**
     * Bulk insert multiple CoreMdmProduct entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO CORE_MDM_PRODUCT (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, PRODUCT_CODE, PRODUCT_NAME, PRODUCT_STATUS_CODE, PRODUCT_DESCRIPTION, BORROWER_PARTY, ASSET_LIABILITY_APPLICABLE, CREDIT_LINE_APPLICABLE, EXPOSURE_MAINTENANCE_REQ, INVOICE_RAISED_BY, FINANCE_REQUEST_BY, INTEREST_CALCULATION, ACCRUAL_AMORTIZE, ANCHOR_PARTY, FINANCE_DEBIT_PARTY, FINANCE_TO_PARTY, SEGMENT_CODE, CUTOFF_APPLICABLE, CHARGES_APPLICABLE, HOLIDAY_APPLICABLE, ALLOW_PAYMENT, ALLOW_COLLECTION, BA_SHORT_NAME, PRODUCT_GROUP_CODE, PRODUCT_SUBGROUP_CODE, CLASSIFICATION, VERSION_ID, IS_MASTER_VERSION, UPLOAD_REF_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :productCode, :productName, :productStatusCode, :productDescription, :borrowerParty, :assetLiabilityApplicable, :creditLineApplicable, :exposureMaintenanceReq, :invoiceRaisedBy, :financeRequestBy, :interestCalculation, :accrualAmortize, :anchorParty, :financeDebitParty, :financeToParty, :segmentCode, :cutoffApplicable, :chargesApplicable, :holidayApplicable, :allowPayment, :allowCollection, :baShortName, :productGroupCode, :productSubgroupCode, :classification, :versionId, :isMasterVersion, :uploadRefId)")
    public int[] bulkInsert(@BindBean List<CoreMdmProduct> coremdmproducts);

    /**
     * Bulk update multiple CoreMdmProduct entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE CORE_MDM_PRODUCT SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, PRODUCT_CODE = :productCode, PRODUCT_NAME = :productName, PRODUCT_STATUS_CODE = :productStatusCode, PRODUCT_DESCRIPTION = :productDescription, BORROWER_PARTY = :borrowerParty, ASSET_LIABILITY_APPLICABLE = :assetLiabilityApplicable, CREDIT_LINE_APPLICABLE = :creditLineApplicable, EXPOSURE_MAINTENANCE_REQ = :exposureMaintenanceReq, INVOICE_RAISED_BY = :invoiceRaisedBy, FINANCE_REQUEST_BY = :financeRequestBy, INTEREST_CALCULATION = :interestCalculation, ACCRUAL_AMORTIZE = :accrualAmortize, ANCHOR_PARTY = :anchorParty, FINANCE_DEBIT_PARTY = :financeDebitParty, FINANCE_TO_PARTY = :financeToParty, SEGMENT_CODE = :segmentCode, CUTOFF_APPLICABLE = :cutoffApplicable, CHARGES_APPLICABLE = :chargesApplicable, HOLIDAY_APPLICABLE = :holidayApplicable, ALLOW_PAYMENT = :allowPayment, ALLOW_COLLECTION = :allowCollection, BA_SHORT_NAME = :baShortName, PRODUCT_GROUP_CODE = :productGroupCode, PRODUCT_SUBGROUP_CODE = :productSubgroupCode, CLASSIFICATION = :classification, IS_MASTER_VERSION = :isMasterVersion, UPLOAD_REF_ID = :uploadRefId WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<CoreMdmProduct> coremdmproducts);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM CORE_MDM_PRODUCT WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM CORE_MDM_PRODUCT WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple CoreMdmProduct records by their IDs.
     */
    @SqlQuery("SELECT * FROM CORE_MDM_PRODUCT WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(CoreMdmProduct.class)
    public List<CoreMdmProduct> findByIds(@BindList("ids") Collection<String> ids);
}
