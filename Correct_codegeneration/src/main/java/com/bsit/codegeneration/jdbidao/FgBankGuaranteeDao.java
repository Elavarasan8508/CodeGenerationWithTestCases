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
import com.bsit.codegeneration.entity.FgBankGuarantee;

public interface FgBankGuaranteeDao {

    /**
     * Inserts a new FgBankGuarantee and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_BANK_GUARANTEE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BANK_GUARANTEE_NUMBER, ISSUING_BANK_NAME, ISSUING_BANK_IFSC_OR_BIC, ISSUING_BANK_ADDRESS, APPLICANT_CODE, APPLICANT_NAME, APPLICANT_ADDRESS, APPLICANT_PAN, APPLICANT_GSTIN, APPLICANT_AADHAAR, DATE_OF_ISSUANCE, EFFECTIVE_DATE, FACE_VALUE, EXPIRY_DATE, CLAIM_EXPIRY_DATE, IFIN760COVER_REFERENCE, UPLOAD_REF_ID, DMS_EVENT_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :bankGuaranteeNumber, :issuingBankName, :issuingBankIfscOrBic, :issuingBankAddress, :applicantCode, :applicantName, :applicantAddress, :applicantPan, :applicantGstin, :applicantAadhaar, :dateOfIssuance, :effectiveDate, :faceValue, :expiryDate, :claimExpiryDate, :ifin760coverReference, :uploadRefId, :dmsEventId)")
    public int insert(@BindBean FgBankGuarantee fgbankguarantee);

    /**
     * Finds a FgBankGuarantee by its ID.
     */
    @SqlQuery("SELECT * FROM FG_BANK_GUARANTEE WHERE ID = :id")
    @RegisterBeanMapper(FgBankGuarantee.class)
    public Optional<FgBankGuarantee> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_BANK_GUARANTEE")
    @RegisterBeanMapper(FgBankGuarantee.class)
    public List<FgBankGuarantee> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_BANK_GUARANTEE ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgBankGuarantee.class)
    public List<FgBankGuarantee> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgBankGuarantee and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_BANK_GUARANTEE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BANK_GUARANTEE_NUMBER = :bankGuaranteeNumber, ISSUING_BANK_NAME = :issuingBankName, ISSUING_BANK_IFSC_OR_BIC = :issuingBankIfscOrBic, ISSUING_BANK_ADDRESS = :issuingBankAddress, APPLICANT_CODE = :applicantCode, APPLICANT_NAME = :applicantName, APPLICANT_ADDRESS = :applicantAddress, APPLICANT_PAN = :applicantPan, APPLICANT_GSTIN = :applicantGstin, APPLICANT_AADHAAR = :applicantAadhaar, DATE_OF_ISSUANCE = :dateOfIssuance, EFFECTIVE_DATE = :effectiveDate, FACE_VALUE = :faceValue, EXPIRY_DATE = :expiryDate, CLAIM_EXPIRY_DATE = :claimExpiryDate, IFIN760COVER_REFERENCE = :ifin760coverReference, UPLOAD_REF_ID = :uploadRefId, DMS_EVENT_ID = :dmsEventId WHERE ID = :id")
    public int update(@BindBean FgBankGuarantee fgbankguarantee);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_BANK_GUARANTEE WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_BANK_GUARANTEE")
    public long countAll();

    /**
     * Bulk insert multiple FgBankGuarantee entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_BANK_GUARANTEE (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, BANK_GUARANTEE_NUMBER, ISSUING_BANK_NAME, ISSUING_BANK_IFSC_OR_BIC, ISSUING_BANK_ADDRESS, APPLICANT_CODE, APPLICANT_NAME, APPLICANT_ADDRESS, APPLICANT_PAN, APPLICANT_GSTIN, APPLICANT_AADHAAR, DATE_OF_ISSUANCE, EFFECTIVE_DATE, FACE_VALUE, EXPIRY_DATE, CLAIM_EXPIRY_DATE, IFIN760COVER_REFERENCE, UPLOAD_REF_ID, DMS_EVENT_ID) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :bankGuaranteeNumber, :issuingBankName, :issuingBankIfscOrBic, :issuingBankAddress, :applicantCode, :applicantName, :applicantAddress, :applicantPan, :applicantGstin, :applicantAadhaar, :dateOfIssuance, :effectiveDate, :faceValue, :expiryDate, :claimExpiryDate, :ifin760coverReference, :uploadRefId, :dmsEventId)")
    public int[] bulkInsert(@BindBean List<FgBankGuarantee> fgbankguarantees);

    /**
     * Bulk update multiple FgBankGuarantee entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_BANK_GUARANTEE SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, BANK_GUARANTEE_NUMBER = :bankGuaranteeNumber, ISSUING_BANK_NAME = :issuingBankName, ISSUING_BANK_IFSC_OR_BIC = :issuingBankIfscOrBic, ISSUING_BANK_ADDRESS = :issuingBankAddress, APPLICANT_CODE = :applicantCode, APPLICANT_NAME = :applicantName, APPLICANT_ADDRESS = :applicantAddress, APPLICANT_PAN = :applicantPan, APPLICANT_GSTIN = :applicantGstin, APPLICANT_AADHAAR = :applicantAadhaar, DATE_OF_ISSUANCE = :dateOfIssuance, EFFECTIVE_DATE = :effectiveDate, FACE_VALUE = :faceValue, EXPIRY_DATE = :expiryDate, CLAIM_EXPIRY_DATE = :claimExpiryDate, IFIN760COVER_REFERENCE = :ifin760coverReference, UPLOAD_REF_ID = :uploadRefId, DMS_EVENT_ID = :dmsEventId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgBankGuarantee> fgbankguarantees);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_BANK_GUARANTEE WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_BANK_GUARANTEE WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgBankGuarantee records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_BANK_GUARANTEE WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgBankGuarantee.class)
    public List<FgBankGuarantee> findByIds(@BindList("ids") Collection<String> ids);
}
