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
import com.bsit.codegeneration.entity.FgModCmsSpace;

public interface FgModCmsSpaceDao {

    /**
     * Inserts a new FgModCmsSpace and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_MOD_CMS_SPACE (ID, VERSION_ID, SPACE_CODE, PARENT_SPACE_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, VISIBILITY_CODE, NAME, DESCRIPTION, PUBLISH_DATE, EXPIRE_DATE, STATUS_CODE, ACTIVE_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, IS_MASTER_VERSION) VALUES (:id, :versionId, :spaceCode, :parentSpaceCode, :partyTypeCode, :partySubTypeCode, :entityTypeCode, :entitySubTypeCode, :visibilityCode, :name, :description, :publishDate, :expireDate, :statusCode, :activeCode, :lastAuthorisedBy, :lastAuthorisedOn, :isMasterVersion)")
    public int insert(@BindBean FgModCmsSpace fgmodcmsspace);

    /**
     * Finds a FgModCmsSpace by its ID.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_SPACE WHERE FG_MOD_CMS_SPACE_id = :id")
    @RegisterBeanMapper(FgModCmsSpace.class)
    public Optional<FgModCmsSpace> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_SPACE")
    @RegisterBeanMapper(FgModCmsSpace.class)
    public List<FgModCmsSpace> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_SPACE ORDER BY FG_MOD_CMS_SPACE_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgModCmsSpace.class)
    public List<FgModCmsSpace> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgModCmsSpace and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_MOD_CMS_SPACE SET ID = :id, VERSION_ID = :versionId, SPACE_CODE = :spaceCode, PARENT_SPACE_CODE = :parentSpaceCode, PARTY_TYPE_CODE = :partyTypeCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, VISIBILITY_CODE = :visibilityCode, NAME = :name, DESCRIPTION = :description, PUBLISH_DATE = :publishDate, EXPIRE_DATE = :expireDate, STATUS_CODE = :statusCode, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, IS_MASTER_VERSION = :isMasterVersion WHERE FG_MOD_CMS_SPACE_id = :fgModCmsSpaceId")
    public int update(@BindBean FgModCmsSpace fgmodcmsspace);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CMS_SPACE WHERE FG_MOD_CMS_SPACE_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_MOD_CMS_SPACE")
    public long countAll();

    /**
     * Bulk insert multiple FgModCmsSpace entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_MOD_CMS_SPACE (ID, VERSION_ID, SPACE_CODE, PARENT_SPACE_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, VISIBILITY_CODE, NAME, DESCRIPTION, PUBLISH_DATE, EXPIRE_DATE, STATUS_CODE, ACTIVE_CODE, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, IS_MASTER_VERSION) VALUES (:id, :versionId, :spaceCode, :parentSpaceCode, :partyTypeCode, :partySubTypeCode, :entityTypeCode, :entitySubTypeCode, :visibilityCode, :name, :description, :publishDate, :expireDate, :statusCode, :activeCode, :lastAuthorisedBy, :lastAuthorisedOn, :isMasterVersion)")
    public int[] bulkInsert(@BindBean List<FgModCmsSpace> fgmodcmsspaces);

    /**
     * Bulk update multiple FgModCmsSpace entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_MOD_CMS_SPACE SET ID = :id, VERSION_ID = :versionId, SPACE_CODE = :spaceCode, PARENT_SPACE_CODE = :parentSpaceCode, PARTY_TYPE_CODE = :partyTypeCode, PARTY_SUB_TYPE_CODE = :partySubTypeCode, ENTITY_TYPE_CODE = :entityTypeCode, ENTITY_SUB_TYPE_CODE = :entitySubTypeCode, VISIBILITY_CODE = :visibilityCode, NAME = :name, DESCRIPTION = :description, PUBLISH_DATE = :publishDate, EXPIRE_DATE = :expireDate, STATUS_CODE = :statusCode, ACTIVE_CODE = :activeCode, LAST_AUTHORISED_BY = :lastAuthorisedBy, LAST_AUTHORISED_ON = :lastAuthorisedOn, IS_MASTER_VERSION = :isMasterVersion WHERE FG_MOD_CMS_SPACE_id = :fgModCmsSpaceId")
    public int[] bulkUpdate(@BindBean List<FgModCmsSpace> fgmodcmsspaces);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_MOD_CMS_SPACE WHERE FG_MOD_CMS_SPACE_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_MOD_CMS_SPACE WHERE FG_MOD_CMS_SPACE_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgModCmsSpace records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_MOD_CMS_SPACE WHERE FG_MOD_CMS_SPACE_id IN (<ids>)")
    @RegisterBeanMapper(FgModCmsSpace.class)
    public List<FgModCmsSpace> findByIds(@BindList("ids") Collection<Integer> ids);
}
