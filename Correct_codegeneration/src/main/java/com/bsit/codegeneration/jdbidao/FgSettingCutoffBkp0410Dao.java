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
import com.bsit.codegeneration.entity.FgSettingCutoffBkp0410;

public interface FgSettingCutoffBkp0410Dao {

    /**
     * Inserts a new FgSettingCutoffBkp0410 and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SETTING_CUTOFF_BKP0410 (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCOPE_TYPE, PRODUCT_CODE, SCOPE_LEVEL, SCOPE_VALUE, SUB_PRODUCT_CODE, VERSION_ID, IS_MASTER_VERSION, RATE_TYPE, ENTITY_CODE, UPLOAD_REF_ID, FG_GROUP_SCOPE, FG_ROLE_SCOPE, CORPORATE_CRN, ENTITY_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :scopeType, :productCode, :scopeLevel, :scopeValue, :subProductCode, :versionId, :isMasterVersion, :rateType, :entityCode, :uploadRefId, :fgGroupScope, :fgRoleScope, :corporateCrn, :entityName)")
    public int insert(@BindBean FgSettingCutoffBkp0410 fgsettingcutoffbkp0410);

    /**
     * Finds a FgSettingCutoffBkp0410 by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_CUTOFF_BKP0410 WHERE FG_SETTING_CUTOFF_BKP0410_id = :id")
    @RegisterBeanMapper(FgSettingCutoffBkp0410.class)
    public Optional<FgSettingCutoffBkp0410> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_CUTOFF_BKP0410")
    @RegisterBeanMapper(FgSettingCutoffBkp0410.class)
    public List<FgSettingCutoffBkp0410> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_CUTOFF_BKP0410 ORDER BY FG_SETTING_CUTOFF_BKP0410_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSettingCutoffBkp0410.class)
    public List<FgSettingCutoffBkp0410> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSettingCutoffBkp0410 and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SETTING_CUTOFF_BKP0410 SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, SCOPE_TYPE = :scopeType, PRODUCT_CODE = :productCode, SCOPE_LEVEL = :scopeLevel, SCOPE_VALUE = :scopeValue, SUB_PRODUCT_CODE = :subProductCode, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, RATE_TYPE = :rateType, ENTITY_CODE = :entityCode, UPLOAD_REF_ID = :uploadRefId, FG_GROUP_SCOPE = :fgGroupScope, FG_ROLE_SCOPE = :fgRoleScope, CORPORATE_CRN = :corporateCrn, ENTITY_NAME = :entityName WHERE FG_SETTING_CUTOFF_BKP0410_id = :fgSettingCutoffBkp0410Id")
    public int update(@BindBean FgSettingCutoffBkp0410 fgsettingcutoffbkp0410);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SETTING_CUTOFF_BKP0410 WHERE FG_SETTING_CUTOFF_BKP0410_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SETTING_CUTOFF_BKP0410")
    public long countAll();

    /**
     * Bulk insert multiple FgSettingCutoffBkp0410 entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SETTING_CUTOFF_BKP0410 (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, SCOPE_TYPE, PRODUCT_CODE, SCOPE_LEVEL, SCOPE_VALUE, SUB_PRODUCT_CODE, VERSION_ID, IS_MASTER_VERSION, RATE_TYPE, ENTITY_CODE, UPLOAD_REF_ID, FG_GROUP_SCOPE, FG_ROLE_SCOPE, CORPORATE_CRN, ENTITY_NAME) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :processId, :lastAuthorisedOn, :lastAuthorisedBy, :template, :applicantParty, :fulfillmentParty, :isTemplate, :scopeType, :productCode, :scopeLevel, :scopeValue, :subProductCode, :versionId, :isMasterVersion, :rateType, :entityCode, :uploadRefId, :fgGroupScope, :fgRoleScope, :corporateCrn, :entityName)")
    public int[] bulkInsert(@BindBean List<FgSettingCutoffBkp0410> fgsettingcutoffbkp0410s);

    /**
     * Bulk update multiple FgSettingCutoffBkp0410 entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SETTING_CUTOFF_BKP0410 SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, PROCESS_ID = :processId, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, APPLICANT_PARTY = :applicantParty, FULFILLMENT_PARTY = :fulfillmentParty, IS_TEMPLATE = :isTemplate, SCOPE_TYPE = :scopeType, PRODUCT_CODE = :productCode, SCOPE_LEVEL = :scopeLevel, SCOPE_VALUE = :scopeValue, SUB_PRODUCT_CODE = :subProductCode, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion, RATE_TYPE = :rateType, ENTITY_CODE = :entityCode, UPLOAD_REF_ID = :uploadRefId, FG_GROUP_SCOPE = :fgGroupScope, FG_ROLE_SCOPE = :fgRoleScope, CORPORATE_CRN = :corporateCrn, ENTITY_NAME = :entityName WHERE FG_SETTING_CUTOFF_BKP0410_id = :fgSettingCutoffBkp0410Id")
    public int[] bulkUpdate(@BindBean List<FgSettingCutoffBkp0410> fgsettingcutoffbkp0410s);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SETTING_CUTOFF_BKP0410 WHERE FG_SETTING_CUTOFF_BKP0410_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SETTING_CUTOFF_BKP0410 WHERE FG_SETTING_CUTOFF_BKP0410_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgSettingCutoffBkp0410 records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_CUTOFF_BKP0410 WHERE FG_SETTING_CUTOFF_BKP0410_id IN (<ids>)")
    @RegisterBeanMapper(FgSettingCutoffBkp0410.class)
    public List<FgSettingCutoffBkp0410> findByIds(@BindList("ids") Collection<Integer> ids);
}
