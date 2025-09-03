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
import com.bsit.codegeneration.entity.FgModRuleBkp;

public interface FgModRuleBkpDao {

    /**
     * Inserts a new FgModRuleBkp and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_RULE_BKP (ID, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, RULE_TYPE_CODE, PARTY_CODE, NAME, REFERENCE_ID, RULE_OBJECT, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, DEPLOYMENT_ID, DEPLOYMENT_TIME, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TYPE_CODE, SUB_TYPE_CODE, CODE, STAGE_CODE, AUTHORISED_RULE, IS_SYNC, SYNC_TARGET_SUB_TYPE_CODE, SYNC_SOURCE_SUB_TYPE_CODE, LAST_SYNCED_ON, APPLICANT_PARTY, OWNER_PARTY_CODE) VALUES (:id, :partyTypeCode, :partySubTypeCode, :ruleTypeCode, :partyCode, :name, :referenceId, :ruleObject, :description, :activeCode, :statusCode, :deploymentId, :deploymentTime, :lastAuthorisedOn, :lastAuthorisedBy, :typeCode, :subTypeCode, :code, :stageCode, :authorisedRule, :isSync, :syncTargetSubTypeCode, :syncSourceSubTypeCode, :lastSyncedOn, :applicantParty, :ownerPartyCode)")
    public int insert(@BindBean FgModRuleBkp fgmodrulebkp);

    /**
     * Finds a FgModRuleBkp by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_RULE_BKP WHERE FG_MOD_RULE_BKP_id = :id")
    @RegisterBeanMapper(FgModRuleBkp.class)
    public Optional<FgModRuleBkp> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_RULE_BKP")
    @RegisterBeanMapper(FgModRuleBkp.class)
    public List<FgModRuleBkp> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_RULE_BKP ORDER BY FG_MOD_RULE_BKP_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModRuleBkp.class)
    public List<FgModRuleBkp> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModRuleBkp and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_RULE_BKP SET ID = :id, PARTY_TYPE_CODE = :partyTypeCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, RULE_TYPE_CODE = :ruleTypeCode, PARTY_CODE = :partyCode, NAME = :name, REFERENCE_ID = :referenceId, RULE_OBJECT = :ruleObject, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, DEPLOYMENT_ID = :deploymentId, DEPLOYMENT_TIME = :deploymentTime, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, CODE = :code, STAGE_CODE = :stageCode, AUTHORISED_RULE = :authorisedRule, IS_SYNC = :isSync, SYNC_TARGET_SUB_TYPE_CODE = :syncTargetSubTypeCode, SYNC_SOURCE_SUB_TYPE_CODE = :syncSourceSubTypeCode, LAST_SYNCED_ON = :lastSyncedOn, APPLICANT_PARTY = :applicantParty, OWNER_PARTY_CODE = :ownerPartyCode WHERE FG_MOD_RULE_BKP_id = :fgModRuleBkpId")
    public int update(@BindBean FgModRuleBkp fgmodrulebkp);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_RULE_BKP WHERE FG_MOD_RULE_BKP_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_RULE_BKP")
    public long countAll();

    /**
     * Bulk insert multiple FgModRuleBkp entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_RULE_BKP (ID, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, RULE_TYPE_CODE, PARTY_CODE, NAME, REFERENCE_ID, RULE_OBJECT, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, DEPLOYMENT_ID, DEPLOYMENT_TIME, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TYPE_CODE, SUB_TYPE_CODE, CODE, STAGE_CODE, AUTHORISED_RULE, IS_SYNC, SYNC_TARGET_SUB_TYPE_CODE, SYNC_SOURCE_SUB_TYPE_CODE, LAST_SYNCED_ON, APPLICANT_PARTY, OWNER_PARTY_CODE) VALUES (:id, :partyTypeCode, :partySubTypeCode, :ruleTypeCode, :partyCode, :name, :referenceId, :ruleObject, :description, :activeCode, :statusCode, :deploymentId, :deploymentTime, :lastAuthorisedOn, :lastAuthorisedBy, :typeCode, :subTypeCode, :code, :stageCode, :authorisedRule, :isSync, :syncTargetSubTypeCode, :syncSourceSubTypeCode, :lastSyncedOn, :applicantParty, :ownerPartyCode)")
    public int[] bulkInsert(@BindBean List<FgModRuleBkp> fgmodrulebkps);

    /**
     * Bulk update multiple FgModRuleBkp entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_RULE_BKP SET ID = :id, PARTY_TYPE_CODE = :partyTypeCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, RULE_TYPE_CODE = :ruleTypeCode, PARTY_CODE = :partyCode, NAME = :name, REFERENCE_ID = :referenceId, RULE_OBJECT = :ruleObject, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, DEPLOYMENT_ID = :deploymentId, DEPLOYMENT_TIME = :deploymentTime, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, CODE = :code, STAGE_CODE = :stageCode, AUTHORISED_RULE = :authorisedRule, IS_SYNC = :isSync, SYNC_TARGET_SUB_TYPE_CODE = :syncTargetSubTypeCode, SYNC_SOURCE_SUB_TYPE_CODE = :syncSourceSubTypeCode, LAST_SYNCED_ON = :lastSyncedOn, APPLICANT_PARTY = :applicantParty, OWNER_PARTY_CODE = :ownerPartyCode WHERE FG_MOD_RULE_BKP_id = :fgModRuleBkpId")
    public int[] bulkUpdate(@BindBean List<FgModRuleBkp> fgmodrulebkps);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_RULE_BKP WHERE FG_MOD_RULE_BKP_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_RULE_BKP WHERE FG_MOD_RULE_BKP_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgModRuleBkp records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_RULE_BKP WHERE FG_MOD_RULE_BKP_id IN (<ids>)")
    @RegisterBeanMapper(FgModRuleBkp.class)
    public List<FgModRuleBkp> findByIds(@BindList("ids") Collection<Integer> ids);
}
