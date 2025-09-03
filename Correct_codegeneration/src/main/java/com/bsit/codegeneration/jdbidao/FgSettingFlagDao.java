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
import com.bsit.codegeneration.entity.FgSettingFlag;

public interface FgSettingFlagDao {

    /**
     * Inserts a new FgSettingFlag and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SETTING_FLAG (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SETTING_NAME, SETTING_KEY, SETTING_CODE, SETTING_DESCRIPTION, SETTING_TAG, OWNER_PARTY_CODE, ENTITY_SUB_TYPE, SETTING_ENVIRONMENT, APPLICATION_TYPE, PROPERTY_TYPE, SETTING_STATUS, SETTING_VALUE, SETTING_DEFAULT_VALUE, ENCRYPTIONFLAG, PROCESS_ID, DEPLOYMENT_STATUS, PROGRAM_SELECT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :settingName, :settingKey, :settingCode, :settingDescription, :settingTag, :ownerPartyCode, :entitySubType, :settingEnvironment, :applicationType, :propertyType, :settingStatus, :settingValue, :settingDefaultValue, :encryptionflag, :processId, :deploymentStatus, :programSelect)")
    public int insert(@BindBean FgSettingFlag fgsettingflag);

    /**
     * Finds a FgSettingFlag by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_FLAG WHERE ID = :id")
    @RegisterBeanMapper(FgSettingFlag.class)
    public Optional<FgSettingFlag> findById(@Bind("id") String id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_FLAG")
    @RegisterBeanMapper(FgSettingFlag.class)
    public List<FgSettingFlag> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_FLAG ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSettingFlag.class)
    public List<FgSettingFlag> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSettingFlag and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SETTING_FLAG SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SETTING_NAME = :settingName, SETTING_KEY = :settingKey, SETTING_CODE = :settingCode, SETTING_DESCRIPTION = :settingDescription, SETTING_TAG = :settingTag, OWNER_PARTY_CODE = :ownerPartyCode, ENTITY_SUB_TYPE = :entitySubType, SETTING_ENVIRONMENT = :settingEnvironment, APPLICATION_TYPE = :applicationType, PROPERTY_TYPE = :propertyType, SETTING_STATUS = :settingStatus, SETTING_VALUE = :settingValue, SETTING_DEFAULT_VALUE = :settingDefaultValue, ENCRYPTIONFLAG = :encryptionflag, PROCESS_ID = :processId, DEPLOYMENT_STATUS = :deploymentStatus, PROGRAM_SELECT = :programSelect WHERE ID = :id")
    public int update(@BindBean FgSettingFlag fgsettingflag);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SETTING_FLAG WHERE ID = :id")
    public int deleteById(@Bind("id") String id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SETTING_FLAG")
    public long countAll();

    /**
     * Bulk insert multiple FgSettingFlag entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SETTING_FLAG (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, SETTING_NAME, SETTING_KEY, SETTING_CODE, SETTING_DESCRIPTION, SETTING_TAG, OWNER_PARTY_CODE, ENTITY_SUB_TYPE, SETTING_ENVIRONMENT, APPLICATION_TYPE, PROPERTY_TYPE, SETTING_STATUS, SETTING_VALUE, SETTING_DEFAULT_VALUE, ENCRYPTIONFLAG, PROCESS_ID, DEPLOYMENT_STATUS, PROGRAM_SELECT) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :settingName, :settingKey, :settingCode, :settingDescription, :settingTag, :ownerPartyCode, :entitySubType, :settingEnvironment, :applicationType, :propertyType, :settingStatus, :settingValue, :settingDefaultValue, :encryptionflag, :processId, :deploymentStatus, :programSelect)")
    public int[] bulkInsert(@BindBean List<FgSettingFlag> fgsettingflags);

    /**
     * Bulk update multiple FgSettingFlag entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SETTING_FLAG SET REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, SETTING_NAME = :settingName, SETTING_KEY = :settingKey, SETTING_CODE = :settingCode, SETTING_DESCRIPTION = :settingDescription, SETTING_TAG = :settingTag, OWNER_PARTY_CODE = :ownerPartyCode, ENTITY_SUB_TYPE = :entitySubType, SETTING_ENVIRONMENT = :settingEnvironment, APPLICATION_TYPE = :applicationType, PROPERTY_TYPE = :propertyType, SETTING_STATUS = :settingStatus, SETTING_VALUE = :settingValue, SETTING_DEFAULT_VALUE = :settingDefaultValue, ENCRYPTIONFLAG = :encryptionflag, PROCESS_ID = :processId, DEPLOYMENT_STATUS = :deploymentStatus, PROGRAM_SELECT = :programSelect WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgSettingFlag> fgsettingflags);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SETTING_FLAG WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<String> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SETTING_FLAG WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<String> ids);

    /**
     * Finds multiple FgSettingFlag records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SETTING_FLAG WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgSettingFlag.class)
    public List<FgSettingFlag> findByIds(@BindList("ids") Collection<String> ids);
}
