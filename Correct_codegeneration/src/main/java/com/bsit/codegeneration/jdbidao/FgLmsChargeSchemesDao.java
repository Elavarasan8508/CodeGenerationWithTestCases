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
import com.bsit.codegeneration.entity.FgLmsChargeSchemes;

public interface FgLmsChargeSchemesDao {

    /**
     * Inserts a new FgLmsChargeSchemes and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_LMS_CHARGE_SCHEMES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_NAME, SCHEME_DESCRIPTION, PRODUCT_CODE, PRODUCT_DESCRIPTION, EFFECTIVE_DATE, EXPIRY_DATE, VERSION_ID, IS_MASTER_VERSION, PRODUCT, SUB_PRODUCT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :schemeName, :schemeDescription, :productCode, :productDescription, :effectiveDate, :expiryDate, :versionId, :isMasterVersion, :product, :subProduct)")
    public int insert(@BindBean FgLmsChargeSchemes fglmschargeschemes);

    /**
     * Finds a FgLmsChargeSchemes by its ID.
     */
    @SqlQuery("SELECT * FROM FG_LMS_CHARGE_SCHEMES WHERE FG_LMS_CHARGE_SCHEMES_id = :id")
    @RegisterBeanMapper(FgLmsChargeSchemes.class)
    public Optional<FgLmsChargeSchemes> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_LMS_CHARGE_SCHEMES")
    @RegisterBeanMapper(FgLmsChargeSchemes.class)
    public List<FgLmsChargeSchemes> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_LMS_CHARGE_SCHEMES ORDER BY FG_LMS_CHARGE_SCHEMES_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgLmsChargeSchemes.class)
    public List<FgLmsChargeSchemes> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgLmsChargeSchemes and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_LMS_CHARGE_SCHEMES SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, SCHEME_NAME = :schemeName, SCHEME_DESCRIPTION = :schemeDescription, PRODUCT_CODE = :productCode, PRODUCT_DESCRIPTION = :productDescription, EFFECTIVE_DATE = :effectiveDate, EXPIRY_DATE = :expiryDate, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, PRODUCT = :product, SUB_PRODUCT = :subProduct WHERE FG_LMS_CHARGE_SCHEMES_id = :fgLmsChargeSchemesId")
    public int update(@BindBean FgLmsChargeSchemes fglmschargeschemes);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LMS_CHARGE_SCHEMES WHERE FG_LMS_CHARGE_SCHEMES_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_LMS_CHARGE_SCHEMES")
    public long countAll();

    /**
     * Bulk insert multiple FgLmsChargeSchemes entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_LMS_CHARGE_SCHEMES (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCHEME_NAME, SCHEME_DESCRIPTION, PRODUCT_CODE, PRODUCT_DESCRIPTION, EFFECTIVE_DATE, EXPIRY_DATE, VERSION_ID, IS_MASTER_VERSION, PRODUCT, SUB_PRODUCT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :schemeName, :schemeDescription, :productCode, :productDescription, :effectiveDate, :expiryDate, :versionId, :isMasterVersion, :product, :subProduct)")
    public int[] bulkInsert(@BindBean List<FgLmsChargeSchemes> fglmschargeschemess);

    /**
     * Bulk update multiple FgLmsChargeSchemes entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_LMS_CHARGE_SCHEMES SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, SCHEME_NAME = :schemeName, SCHEME_DESCRIPTION = :schemeDescription, PRODUCT_CODE = :productCode, PRODUCT_DESCRIPTION = :productDescription, EFFECTIVE_DATE = :effectiveDate, EXPIRY_DATE = :expiryDate, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, PRODUCT = :product, SUB_PRODUCT = :subProduct WHERE FG_LMS_CHARGE_SCHEMES_id = :fgLmsChargeSchemesId")
    public int[] bulkUpdate(@BindBean List<FgLmsChargeSchemes> fglmschargeschemess);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_LMS_CHARGE_SCHEMES WHERE FG_LMS_CHARGE_SCHEMES_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_LMS_CHARGE_SCHEMES WHERE FG_LMS_CHARGE_SCHEMES_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgLmsChargeSchemes records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_LMS_CHARGE_SCHEMES WHERE FG_LMS_CHARGE_SCHEMES_id IN (<ids>)")
    @RegisterBeanMapper(FgLmsChargeSchemes.class)
    public List<FgLmsChargeSchemes> findByIds(@BindList("ids") Collection<Integer> ids);
}
