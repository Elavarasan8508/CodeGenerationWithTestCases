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
import com.bsit.codegeneration.entity.FgModCmsContent;

public interface FgModCmsContentDao {

    /**
     * Inserts a new FgModCmsContent and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_CMS_CONTENT (ID, VERSION_ID, OWNER_PARTY_CODE, OWNER_TYPE_CODE, SPACE_CODE, CONTENT_REF_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, NAME, TITLE, SUB_TITLE, DESCRIPTION, CONTENT_DATA, IS_MASTER_VERSION, PUBLISH_DATE, EXPIRE_DATE, STAGE_CODE, STATUS_CODE, ACTIVE_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :versionId, :ownerPartyCode, :ownerTypeCode, :spaceCode, :contentRefNo, :entityTypeCode, :entitySubTypeCode, :name, :title, :subTitle, :description, :contentData, :isMasterVersion, :publishDate, :expireDate, :stageCode, :statusCode, :activeCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int insert(@BindBean FgModCmsContent fgmodcmscontent);

    /**
     * Finds a FgModCmsContent by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_CONTENT WHERE FG_MOD_CMS_CONTENT_id = :id")
    @RegisterBeanMapper(FgModCmsContent.class)
    public Optional<FgModCmsContent> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_CONTENT")
    @RegisterBeanMapper(FgModCmsContent.class)
    public List<FgModCmsContent> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_CONTENT ORDER BY FG_MOD_CMS_CONTENT_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModCmsContent.class)
    public List<FgModCmsContent> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModCmsContent and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_CMS_CONTENT SET ID = :id, VERSION_ID = :versionId, OWNER_PARTY_CODE = :ownerPartyCode, OWNER_TYPE_CODE = :ownerTypeCode, SPACE_CODE = :spaceCode, CONTENT_REF_NO = :contentRefNo, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, NAME = :name, TITLE = :title, SUB_TITLE = :subTitle, DESCRIPTION = :description, CONTENT_DATA = :contentData, IS_MASTER_VERSION = :isMasterVersion, PUBLISH_DATE = :publishDate, EXPIRE_DATE = :expireDate, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_MOD_CMS_CONTENT_id = :fgModCmsContentId")
    public int update(@BindBean FgModCmsContent fgmodcmscontent);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CMS_CONTENT WHERE FG_MOD_CMS_CONTENT_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_CMS_CONTENT")
    public long countAll();

    /**
     * Bulk insert multiple FgModCmsContent entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_CMS_CONTENT (ID, VERSION_ID, OWNER_PARTY_CODE, OWNER_TYPE_CODE, SPACE_CODE, CONTENT_REF_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, NAME, TITLE, SUB_TITLE, DESCRIPTION, CONTENT_DATA, IS_MASTER_VERSION, PUBLISH_DATE, EXPIRE_DATE, STAGE_CODE, STATUS_CODE, ACTIVE_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :versionId, :ownerPartyCode, :ownerTypeCode, :spaceCode, :contentRefNo, :entityTypeCode, :entitySubTypeCode, :name, :title, :subTitle, :description, :contentData, :isMasterVersion, :publishDate, :expireDate, :stageCode, :statusCode, :activeCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int[] bulkInsert(@BindBean List<FgModCmsContent> fgmodcmscontents);

    /**
     * Bulk update multiple FgModCmsContent entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_CMS_CONTENT SET ID = :id, VERSION_ID = :versionId, OWNER_PARTY_CODE = :ownerPartyCode, OWNER_TYPE_CODE = :ownerTypeCode, SPACE_CODE = :spaceCode, CONTENT_REF_NO = :contentRefNo, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, NAME = :name, TITLE = :title, SUB_TITLE = :subTitle, DESCRIPTION = :description, CONTENT_DATA = :contentData, IS_MASTER_VERSION = :isMasterVersion, PUBLISH_DATE = :publishDate, EXPIRE_DATE = :expireDate, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_MOD_CMS_CONTENT_id = :fgModCmsContentId")
    public int[] bulkUpdate(@BindBean List<FgModCmsContent> fgmodcmscontents);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CMS_CONTENT WHERE FG_MOD_CMS_CONTENT_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_CMS_CONTENT WHERE FG_MOD_CMS_CONTENT_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgModCmsContent records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_CONTENT WHERE FG_MOD_CMS_CONTENT_id IN (<ids>)")
    @RegisterBeanMapper(FgModCmsContent.class)
    public List<FgModCmsContent> findByIds(@BindList("ids") Collection<Integer> ids);
}
