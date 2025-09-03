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
import com.bsit.codegeneration.entity.FgSdkBotIntent;

public interface FgSdkBotIntentDao {

    /**
     * Inserts a new FgSdkBotIntent and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_SDK_BOT_INTENT (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INTENT_MODEL, INTENT_NAME, PARENT_INTENT, DATASET, INTENT_TYPE, AUTHORIZATION, SHOW, PROMPT, PHRASE_NAME, PHRASE_STATUS, PARAMETER_FIELD, PARAMETER_DATATYPE, PARAMETER, PARAMETER_STATUS, INPUT, REQUIRED, API_METHOD, CONTENT, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :intentModel, :intentName, :parentIntent, :dataset, :intentType, :authorization, :show, :prompt, :phraseName, :phraseStatus, :parameterField, :parameterDatatype, :parameter, :parameterStatus, :input, :required, :APIMethod, :content, :parentRefId, :parentVersionId)")
    public int insert(@BindBean FgSdkBotIntent fgsdkbotintent);

    /**
     * Finds a FgSdkBotIntent by its ID.
     */
    @SqlQuery("SELECT * FROM FG_SDK_BOT_INTENT WHERE FG_SDK_BOT_INTENT_id = :id")
    @RegisterBeanMapper(FgSdkBotIntent.class)
    public Optional<FgSdkBotIntent> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_SDK_BOT_INTENT")
    @RegisterBeanMapper(FgSdkBotIntent.class)
    public List<FgSdkBotIntent> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_SDK_BOT_INTENT ORDER BY FG_SDK_BOT_INTENT_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgSdkBotIntent.class)
    public List<FgSdkBotIntent> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgSdkBotIntent and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_SDK_BOT_INTENT SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, INTENT_MODEL = :intentModel, INTENT_NAME = :intentName, PARENT_INTENT = :parentIntent, DATASET = :dataset, INTENT_TYPE = :intentType, AUTHORIZATION = :authorization, SHOW = :show, PROMPT = :prompt, PHRASE_NAME = :phraseName, PHRASE_STATUS = :phraseStatus, PARAMETER_FIELD = :parameterField, PARAMETER_DATATYPE = :parameterDatatype, PARAMETER = :parameter, PARAMETER_STATUS = :parameterStatus, INPUT = :input, REQUIRED = :required, API_METHOD = :APIMethod, CONTENT = :content, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE FG_SDK_BOT_INTENT_id = :fgSdkBotIntentId")
    public int update(@BindBean FgSdkBotIntent fgsdkbotintent);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_BOT_INTENT WHERE FG_SDK_BOT_INTENT_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_SDK_BOT_INTENT")
    public long countAll();

    /**
     * Bulk insert multiple FgSdkBotIntent entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_SDK_BOT_INTENT (ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, INTENT_MODEL, INTENT_NAME, PARENT_INTENT, DATASET, INTENT_TYPE, AUTHORIZATION, SHOW, PROMPT, PHRASE_NAME, PHRASE_STATUS, PARAMETER_FIELD, PARAMETER_DATATYPE, PARAMETER, PARAMETER_STATUS, INPUT, REQUIRED, API_METHOD, CONTENT, PARENT_REF_ID, PARENT_VERSION_ID) VALUES (:id, :referenceId, :applicantPartyCode, :applicantRefId, :issuingPartyCode, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :template, :isTemplate, :intentModel, :intentName, :parentIntent, :dataset, :intentType, :authorization, :show, :prompt, :phraseName, :phraseStatus, :parameterField, :parameterDatatype, :parameter, :parameterStatus, :input, :required, :APIMethod, :content, :parentRefId, :parentVersionId)")
    public int[] bulkInsert(@BindBean List<FgSdkBotIntent> fgsdkbotintents);

    /**
     * Bulk update multiple FgSdkBotIntent entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_SDK_BOT_INTENT SET ID = :id, REFERENCE_ID = :referenceId, APPLICANT_PARTY_CODE = :applicantPartyCode, APPLICANT_REF_ID = :applicantRefId, ISSUING_PARTY_CODE = :issuingPartyCode, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE = :template, IS_TEMPLATE = :isTemplate, INTENT_MODEL = :intentModel, INTENT_NAME = :intentName, PARENT_INTENT = :parentIntent, DATASET = :dataset, INTENT_TYPE = :intentType, AUTHORIZATION = :authorization, SHOW = :show, PROMPT = :prompt, PHRASE_NAME = :phraseName, PHRASE_STATUS = :phraseStatus, PARAMETER_FIELD = :parameterField, PARAMETER_DATATYPE = :parameterDatatype, PARAMETER = :parameter, PARAMETER_STATUS = :parameterStatus, INPUT = :input, REQUIRED = :required, API_METHOD = :APIMethod, CONTENT = :content, PARENT_REF_ID = :parentRefId, PARENT_VERSION_ID = :parentVersionId WHERE FG_SDK_BOT_INTENT_id = :fgSdkBotIntentId")
    public int[] bulkUpdate(@BindBean List<FgSdkBotIntent> fgsdkbotintents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_SDK_BOT_INTENT WHERE FG_SDK_BOT_INTENT_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_SDK_BOT_INTENT WHERE FG_SDK_BOT_INTENT_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgSdkBotIntent records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_SDK_BOT_INTENT WHERE FG_SDK_BOT_INTENT_id IN (<ids>)")
    @RegisterBeanMapper(FgSdkBotIntent.class)
    public List<FgSdkBotIntent> findByIds(@BindList("ids") Collection<Integer> ids);
}
