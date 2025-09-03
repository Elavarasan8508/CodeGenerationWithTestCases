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
import com.bsit.codegeneration.entity.FgModCampaign;

public interface FgModCampaignDao {

    /**
     * Inserts a new FgModCampaign and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_CAMPAIGN (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_TEMPLATE, PROCESS_ID, BO_RESPONSE, BO_STATUS, STATUS_ID, COMMENTS, DESCRIPTION, TEMPLATE_REF_ID, PURPOSE_CODE, TITLE, APPLICATION_DATE, EFFECTIVE_FROM, EFFECTIVE_TO, TEMPLATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :isTemplate, :processId, :boResponse, :boStatus, :statusId, :comments, :description, :templateRefId, :purposeCode, :title, :applicationDate, :effectiveFrom, :effectiveTo, :template)")
    public int insert(@BindBean FgModCampaign fgmodcampaign);

    /**
     * Finds a FgModCampaign by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CAMPAIGN WHERE FG_MOD_CAMPAIGN_id = :id")
    @RegisterBeanMapper(FgModCampaign.class)
    public Optional<FgModCampaign> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CAMPAIGN")
    @RegisterBeanMapper(FgModCampaign.class)
    public List<FgModCampaign> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CAMPAIGN ORDER BY FG_MOD_CAMPAIGN_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModCampaign.class)
    public List<FgModCampaign> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModCampaign and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_CAMPAIGN SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, IS_TEMPLATE = :isTemplate, PROCESS_ID = :processId, BO_RESPONSE = :boResponse, BO_STATUS = :boStatus, STATUS_ID = :statusId, COMMENTS = :comments, DESCRIPTION = :description, TEMPLATE_REF_ID = :templateRefId, PURPOSE_CODE = :purposeCode, TITLE = :title, APPLICATION_DATE = :applicationDate, EFFECTIVE_FROM = :effectiveFrom, EFFECTIVE_TO = :effectiveTo, TEMPLATE = :template WHERE FG_MOD_CAMPAIGN_id = :fgModCampaignId")
    public int update(@BindBean FgModCampaign fgmodcampaign);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CAMPAIGN WHERE FG_MOD_CAMPAIGN_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_CAMPAIGN")
    public long countAll();

    /**
     * Bulk insert multiple FgModCampaign entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_CAMPAIGN (ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, IS_TEMPLATE, PROCESS_ID, BO_RESPONSE, BO_STATUS, STATUS_ID, COMMENTS, DESCRIPTION, TEMPLATE_REF_ID, PURPOSE_CODE, TITLE, APPLICATION_DATE, EFFECTIVE_FROM, EFFECTIVE_TO, TEMPLATE) VALUES (:id, :referenceId, :typeCode, :subTypeCode, :activeCode, :stageCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :isTemplate, :processId, :boResponse, :boStatus, :statusId, :comments, :description, :templateRefId, :purposeCode, :title, :applicationDate, :effectiveFrom, :effectiveTo, :template)")
    public int[] bulkInsert(@BindBean List<FgModCampaign> fgmodcampaigns);

    /**
     * Bulk update multiple FgModCampaign entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_CAMPAIGN SET ID = :id, REFERENCE_ID = :referenceId, TYPE_CODE = :typeCode, SUB_TYPE_CODE = :subTypeCode, ACTIVE_CODE = :activeCode, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, IS_TEMPLATE = :isTemplate, PROCESS_ID = :processId, BO_RESPONSE = :boResponse, BO_STATUS = :boStatus, STATUS_ID = :statusId, COMMENTS = :comments, DESCRIPTION = :description, TEMPLATE_REF_ID = :templateRefId, PURPOSE_CODE = :purposeCode, TITLE = :title, APPLICATION_DATE = :applicationDate, EFFECTIVE_FROM = :effectiveFrom, EFFECTIVE_TO = :effectiveTo, TEMPLATE = :template WHERE FG_MOD_CAMPAIGN_id = :fgModCampaignId")
    public int[] bulkUpdate(@BindBean List<FgModCampaign> fgmodcampaigns);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CAMPAIGN WHERE FG_MOD_CAMPAIGN_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_CAMPAIGN WHERE FG_MOD_CAMPAIGN_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgModCampaign records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CAMPAIGN WHERE FG_MOD_CAMPAIGN_id IN (<ids>)")
    @RegisterBeanMapper(FgModCampaign.class)
    public List<FgModCampaign> findByIds(@BindList("ids") Collection<Integer> ids);
}
