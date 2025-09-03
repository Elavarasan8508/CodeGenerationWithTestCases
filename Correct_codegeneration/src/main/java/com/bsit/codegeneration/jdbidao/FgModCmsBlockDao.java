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
import com.bsit.codegeneration.entity.FgModCmsBlock;

public interface FgModCmsBlockDao {

    /**
     * Inserts a new FgModCmsBlock and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_CMS_BLOCK (ID, VERSION_ID, OWNER_PARTY_CODE, PARTY_TYPE_CODE, BLOCK_REF_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, NAME, TITLE, SUB_TITLE, DESCRIPTION, BLOCK_DATA, IS_MASTER_VERSION, PUBLISH_DATE, EXPIRE_DATE, STAGE_CODE, STATUS_CODE, ACTIVE_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :versionId, :ownerPartyCode, :partyTypeCode, :blockRefNo, :entityTypeCode, :entitySubTypeCode, :name, :title, :subTitle, :description, :blockData, :isMasterVersion, :publishDate, :expireDate, :stageCode, :statusCode, :activeCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int insert(@BindBean FgModCmsBlock fgmodcmsblock);

    /**
     * Finds a FgModCmsBlock by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_BLOCK WHERE FG_MOD_CMS_BLOCK_id = :id")
    @RegisterBeanMapper(FgModCmsBlock.class)
    public Optional<FgModCmsBlock> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_BLOCK")
    @RegisterBeanMapper(FgModCmsBlock.class)
    public List<FgModCmsBlock> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_BLOCK ORDER BY FG_MOD_CMS_BLOCK_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModCmsBlock.class)
    public List<FgModCmsBlock> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModCmsBlock and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_CMS_BLOCK SET ID = :id, VERSION_ID = :versionId, OWNER_PARTY_CODE = :ownerPartyCode, PARTY_TYPE_CODE = :partyTypeCode, BLOCK_REF_NO = :blockRefNo, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, NAME = :name, TITLE = :title, SUB_TITLE = :subTitle, DESCRIPTION = :description, BLOCK_DATA = :blockData, IS_MASTER_VERSION = :isMasterVersion, PUBLISH_DATE = :publishDate, EXPIRE_DATE = :expireDate, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_MOD_CMS_BLOCK_id = :fgModCmsBlockId")
    public int update(@BindBean FgModCmsBlock fgmodcmsblock);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CMS_BLOCK WHERE FG_MOD_CMS_BLOCK_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_CMS_BLOCK")
    public long countAll();

    /**
     * Bulk insert multiple FgModCmsBlock entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_CMS_BLOCK (ID, VERSION_ID, OWNER_PARTY_CODE, PARTY_TYPE_CODE, BLOCK_REF_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, NAME, TITLE, SUB_TITLE, DESCRIPTION, BLOCK_DATA, IS_MASTER_VERSION, PUBLISH_DATE, EXPIRE_DATE, STAGE_CODE, STATUS_CODE, ACTIVE_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:id, :versionId, :ownerPartyCode, :partyTypeCode, :blockRefNo, :entityTypeCode, :entitySubTypeCode, :name, :title, :subTitle, :description, :blockData, :isMasterVersion, :publishDate, :expireDate, :stageCode, :statusCode, :activeCode, :lastAuthorisedBy, :lastAuthorisedOn)")
    public int[] bulkInsert(@BindBean List<FgModCmsBlock> fgmodcmsblocks);

    /**
     * Bulk update multiple FgModCmsBlock entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_CMS_BLOCK SET ID = :id, VERSION_ID = :versionId, OWNER_PARTY_CODE = :ownerPartyCode, PARTY_TYPE_CODE = :partyTypeCode, BLOCK_REF_NO = :blockRefNo, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, NAME = :name, TITLE = :title, SUB_TITLE = :subTitle, DESCRIPTION = :description, BLOCK_DATA = :blockData, IS_MASTER_VERSION = :isMasterVersion, PUBLISH_DATE = :publishDate, EXPIRE_DATE = :expireDate, STAGE_CODE = :stageCode, STATUS_CODE = :statusCode, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn WHERE FG_MOD_CMS_BLOCK_id = :fgModCmsBlockId")
    public int[] bulkUpdate(@BindBean List<FgModCmsBlock> fgmodcmsblocks);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CMS_BLOCK WHERE FG_MOD_CMS_BLOCK_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_CMS_BLOCK WHERE FG_MOD_CMS_BLOCK_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgModCmsBlock records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_BLOCK WHERE FG_MOD_CMS_BLOCK_id IN (<ids>)")
    @RegisterBeanMapper(FgModCmsBlock.class)
    public List<FgModCmsBlock> findByIds(@BindList("ids") Collection<Integer> ids);
}
