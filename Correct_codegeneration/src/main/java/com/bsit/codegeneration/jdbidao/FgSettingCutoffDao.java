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
import com.bsit.codegeneration.entity.FgSettingCutoff;

public interface FgSettingCutoffDao {

    /**
     * Inserts a new FgSettingCutoff and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SETTING_CUTOFF (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCOPE_TYPE, PRODUCT_CODE, SCOPE_LEVEL, SCOPE_VALUE, SUB_PRODUCT_CODE, VERSION_ID, IS_MASTER_VERSION, RATE_TYPE, ENTITY_CODE, UPLOAD_REF_ID, FG_GROUP_SCOPE, FG_ROLE_SCOPE, CORPORATE_CRN, ENTITY_NAME, BANK) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :scopeType, :productCode, :scopeLevel, :scopeValue, :subProductCode, :versionId, :isMasterVersion, :rateType, :entityCode, :uploadRefId, :fgGroupScope, :fgRoleScope, :corporateCrn, :entityName, :bank)")
    public int insert(@BindBean FgSettingCutoff fgsettingcutoff);

    /**
     * Finds a FgSettingCutoff by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_CUTOFF WHERE VERSION_ID = :id")
    @RegisterBeanMapper(FgSettingCutoff.class)
    public Optional<FgSettingCutoff> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_CUTOFF")
    @RegisterBeanMapper(FgSettingCutoff.class)
    public List<FgSettingCutoff> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_CUTOFF ORDER BY VERSION_ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSettingCutoff.class)
    public List<FgSettingCutoff> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSettingCutoff and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SETTING_CUTOFF SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, SCOPE_TYPE = :scopeType, PRODUCT_CODE = :productCode, SCOPE_LEVEL = :scopeLevel, SCOPE_VALUE = :scopeValue, SUB_PRODUCT_CODE = :subProductCode, IS_MASTER_VERSION = :isMasterVersion, RATE_TYPE = :rateType, ENTITY_CODE = :entityCode, UPLOAD_REF_ID = :uploadRefId, FG_GROUP_SCOPE = :fgGroupScope, FG_ROLE_SCOPE = :fgRoleScope, CORPORATE_CRN = :corporateCrn, ENTITY_NAME = :entityName, BANK = :bank WHERE VERSION_ID = :versionId")
    public int update(@BindBean FgSettingCutoff fgsettingcutoff);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SETTING_CUTOFF WHERE VERSION_ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SETTING_CUTOFF")
    public long countAll();

    /**
     * Bulk insert multiple FgSettingCutoff entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SETTING_CUTOFF (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCOPE_TYPE, PRODUCT_CODE, SCOPE_LEVEL, SCOPE_VALUE, SUB_PRODUCT_CODE, VERSION_ID, IS_MASTER_VERSION, RATE_TYPE, ENTITY_CODE, UPLOAD_REF_ID, FG_GROUP_SCOPE, FG_ROLE_SCOPE, CORPORATE_CRN, ENTITY_NAME, BANK) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :scopeType, :productCode, :scopeLevel, :scopeValue, :subProductCode, :versionId, :isMasterVersion, :rateType, :entityCode, :uploadRefId, :fgGroupScope, :fgRoleScope, :corporateCrn, :entityName, :bank)")
    public int[] bulkInsert(@BindBean List<FgSettingCutoff> fgsettingcutoffs);

    /**
     * Bulk update multiple FgSettingCutoff entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SETTING_CUTOFF SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, SCOPE_TYPE = :scopeType, PRODUCT_CODE = :productCode, SCOPE_LEVEL = :scopeLevel, SCOPE_VALUE = :scopeValue, SUB_PRODUCT_CODE = :subProductCode, IS_MASTER_VERSION = :isMasterVersion, RATE_TYPE = :rateType, ENTITY_CODE = :entityCode, UPLOAD_REF_ID = :uploadRefId, FG_GROUP_SCOPE = :fgGroupScope, FG_ROLE_SCOPE = :fgRoleScope, CORPORATE_CRN = :corporateCrn, ENTITY_NAME = :entityName, BANK = :bank WHERE VERSION_ID = :versionId")
    public int[] bulkUpdate(@BindBean List<FgSettingCutoff> fgsettingcutoffs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SETTING_CUTOFF WHERE VERSION_ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SETTING_CUTOFF WHERE VERSION_ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgSettingCutoff records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_CUTOFF WHERE VERSION_ID IN (<ids>)")
    @RegisterBeanMapper(FgSettingCutoff.class)
    public List<FgSettingCutoff> findByIds(@BindList("ids") Collection<String> ids);
}
