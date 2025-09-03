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
import com.bsit.codegeneration.entity.FgLmsAssetSchemes;

public interface FgLmsAssetSchemesDao {

    /**
     * Inserts a new FgLmsAssetSchemes and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LMS_ASSET_SCHEMES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, EFFECTIVE_DATE, EXPIRY_DATE, ASSET_SCHEME_CODE, ASSET_SCHEME_NAME, ASSET_CLASSIFICATION_BASED_ON, FORWARD_MOVEMENT, BACKWARD_MOVEMENT, PAST_DUE_DAYS_FROM, PAST_DUE_DAYS_TO, DELINQUENCY_STAGE_NAME, DELINQUENCY_STAGE_CODE, STOP_ACCRUAL, DERECOGNIZE_INCOME, PROVISION, EROSION_FROM, EROSION_TO, IS_INCOME_DERECOGNIZED, SCHEME_NAME, SCHEME_DESCRIPTION, PRODUCT_CODE, PRODUCT_DESCRIPTION, PRODUCT, VERSION_ID, IS_MASTER_VERSION, EFFECTIVE_DATE_CHARGE, EXPIRY_DATE_CHARGE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :effectiveDate, :expiryDate, :assetSchemeCode, :assetSchemeName, :assetClassificationBasedOn, :forwardMovement, :backwardMovement, :pastDueDaysFrom, :pastDueDaysTo, :delinquencyStageName, :delinquencyStageCode, :stopAccrual, :derecognizeIncome, :provision, :erosionFrom, :erosionTo, :isIncomeDerecognized, :schemeName, :schemeDescription, :productCode, :productDescription, :product, :versionId, :isMasterVersion, :effectiveDateCharge, :expiryDateCharge)")
    public int insert(@BindBean FgLmsAssetSchemes fglmsassetschemes);

    /**
     * Finds a FgLmsAssetSchemes by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LMS_ASSET_SCHEMES WHERE FG_LMS_ASSET_SCHEMES_id = :id")
    @RegisterBeanMapper(FgLmsAssetSchemes.class)
    public Optional<FgLmsAssetSchemes> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LMS_ASSET_SCHEMES")
    @RegisterBeanMapper(FgLmsAssetSchemes.class)
    public List<FgLmsAssetSchemes> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LMS_ASSET_SCHEMES ORDER BY FG_LMS_ASSET_SCHEMES_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLmsAssetSchemes.class)
    public List<FgLmsAssetSchemes> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLmsAssetSchemes and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LMS_ASSET_SCHEMES SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, EFFECTIVE_DATE = :effectiveDate, EXPIRY_DATE = :expiryDate, ASSET_SCHEME_CODE = :assetSchemeCode, ASSET_SCHEME_NAME = :assetSchemeName, ASSET_CLASSIFICATION_BASED_ON = :assetClassificationBasedOn, FORWARD_MOVEMENT = :forwardMovement, BACKWARD_MOVEMENT = :backwardMovement, PAST_DUE_DAYS_FROM = :pastDueDaysFrom, PAST_DUE_DAYS_TO = :pastDueDaysTo, DELINQUENCY_STAGE_NAME = :delinquencyStageName, DELINQUENCY_STAGE_CODE = :delinquencyStageCode, STOP_ACCRUAL = :stopAccrual, DERECOGNIZE_INCOME = :derecognizeIncome, PROVISION = :provision, EROSION_FROM = :erosionFrom, EROSION_TO = :erosionTo, IS_INCOME_DERECOGNIZED = :isIncomeDerecognized, SCHEME_NAME = :schemeName, SCHEME_DESCRIPTION = :schemeDescription, PRODUCT_CODE = :productCode, PRODUCT_DESCRIPTION = :productDescription, PRODUCT = :product, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, EFFECTIVE_DATE_CHARGE = :effectiveDateCharge, EXPIRY_DATE_CHARGE = :expiryDateCharge WHERE FG_LMS_ASSET_SCHEMES_id = :fgLmsAssetSchemesId")
    public int update(@BindBean FgLmsAssetSchemes fglmsassetschemes);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LMS_ASSET_SCHEMES WHERE FG_LMS_ASSET_SCHEMES_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LMS_ASSET_SCHEMES")
    public long countAll();

    /**
     * Bulk insert multiple FgLmsAssetSchemes entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LMS_ASSET_SCHEMES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, EFFECTIVE_DATE, EXPIRY_DATE, ASSET_SCHEME_CODE, ASSET_SCHEME_NAME, ASSET_CLASSIFICATION_BASED_ON, FORWARD_MOVEMENT, BACKWARD_MOVEMENT, PAST_DUE_DAYS_FROM, PAST_DUE_DAYS_TO, DELINQUENCY_STAGE_NAME, DELINQUENCY_STAGE_CODE, STOP_ACCRUAL, DERECOGNIZE_INCOME, PROVISION, EROSION_FROM, EROSION_TO, IS_INCOME_DERECOGNIZED, SCHEME_NAME, SCHEME_DESCRIPTION, PRODUCT_CODE, PRODUCT_DESCRIPTION, PRODUCT, VERSION_ID, IS_MASTER_VERSION, EFFECTIVE_DATE_CHARGE, EXPIRY_DATE_CHARGE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :effectiveDate, :expiryDate, :assetSchemeCode, :assetSchemeName, :assetClassificationBasedOn, :forwardMovement, :backwardMovement, :pastDueDaysFrom, :pastDueDaysTo, :delinquencyStageName, :delinquencyStageCode, :stopAccrual, :derecognizeIncome, :provision, :erosionFrom, :erosionTo, :isIncomeDerecognized, :schemeName, :schemeDescription, :productCode, :productDescription, :product, :versionId, :isMasterVersion, :effectiveDateCharge, :expiryDateCharge)")
    public int[] bulkInsert(@BindBean List<FgLmsAssetSchemes> fglmsassetschemess);

    /**
     * Bulk update multiple FgLmsAssetSchemes entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LMS_ASSET_SCHEMES SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, EFFECTIVE_DATE = :effectiveDate, EXPIRY_DATE = :expiryDate, ASSET_SCHEME_CODE = :assetSchemeCode, ASSET_SCHEME_NAME = :assetSchemeName, ASSET_CLASSIFICATION_BASED_ON = :assetClassificationBasedOn, FORWARD_MOVEMENT = :forwardMovement, BACKWARD_MOVEMENT = :backwardMovement, PAST_DUE_DAYS_FROM = :pastDueDaysFrom, PAST_DUE_DAYS_TO = :pastDueDaysTo, DELINQUENCY_STAGE_NAME = :delinquencyStageName, DELINQUENCY_STAGE_CODE = :delinquencyStageCode, STOP_ACCRUAL = :stopAccrual, DERECOGNIZE_INCOME = :derecognizeIncome, PROVISION = :provision, EROSION_FROM = :erosionFrom, EROSION_TO = :erosionTo, IS_INCOME_DERECOGNIZED = :isIncomeDerecognized, SCHEME_NAME = :schemeName, SCHEME_DESCRIPTION = :schemeDescription, PRODUCT_CODE = :productCode, PRODUCT_DESCRIPTION = :productDescription, PRODUCT = :product, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, EFFECTIVE_DATE_CHARGE = :effectiveDateCharge, EXPIRY_DATE_CHARGE = :expiryDateCharge WHERE FG_LMS_ASSET_SCHEMES_id = :fgLmsAssetSchemesId")
    public int[] bulkUpdate(@BindBean List<FgLmsAssetSchemes> fglmsassetschemess);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LMS_ASSET_SCHEMES WHERE FG_LMS_ASSET_SCHEMES_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LMS_ASSET_SCHEMES WHERE FG_LMS_ASSET_SCHEMES_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgLmsAssetSchemes records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LMS_ASSET_SCHEMES WHERE FG_LMS_ASSET_SCHEMES_id IN (<ids>)")
    @RegisterBeanMapper(FgLmsAssetSchemes.class)
    public List<FgLmsAssetSchemes> findByIds(@BindList("ids") Collection<Integer> ids);
}
