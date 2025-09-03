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
import com.bsit.codegeneration.entity.FgEntityTypeBkp191224;

public interface FgEntityTypeBkp191224Dao {

    /**
     * Inserts a new FgEntityTypeBkp191224 and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ENTITY_TYPE_BKP191224 (ID, CATEGORY_CODE, CODE, NAME, PARENT_TYPE_CODE, IS_MASTER, IS_PRODUCT, ENTITY_CLASS_CODE, CONFIG_STATUS_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE_SCHEMA, IS_ANALYTICS_ENABLED, IS_REPORT_ENABLED, TAGS, IS_PUBLIC, MASTER_TEMPLATE, MASTER_CONTENT_HASH, TEMPLATE_HASH, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :categoryCode, :code, :name, :parentTypeCode, :isMaster, :isProduct, :entityClassCode, :configStatusCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :templateSchema, :isAnalyticsEnabled, :isReportEnabled, :tags, :isPublic, :masterTemplate, :masterContentHash, :templateHash, :versionId, :isMasterVersion)")
    public int insert(@BindBean FgEntityTypeBkp191224 fgentitytypebkp191224);

    /**
     * Finds a FgEntityTypeBkp191224 by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_TYPE_BKP191224 WHERE FG_ENTITY_TYPE_BKP191224_id = :id")
    @RegisterBeanMapper(FgEntityTypeBkp191224.class)
    public Optional<FgEntityTypeBkp191224> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_TYPE_BKP191224")
    @RegisterBeanMapper(FgEntityTypeBkp191224.class)
    public List<FgEntityTypeBkp191224> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_TYPE_BKP191224 ORDER BY FG_ENTITY_TYPE_BKP191224_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgEntityTypeBkp191224.class)
    public List<FgEntityTypeBkp191224> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgEntityTypeBkp191224 and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ENTITY_TYPE_BKP191224 SET ID = :id, CATEGORY_CODE = :categoryCode, CODE = :code, NAME = :name, PARENT_TYPE_CODE = :parentTypeCode, IS_MASTER = :isMaster, IS_PRODUCT = :isProduct, ENTITY_CLASS_CODE = :entityClassCode, CONFIG_STATUS_CODE = :configStatusCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE_SCHEMA = :templateSchema, IS_ANALYTICS_ENABLED = :isAnalyticsEnabled, IS_REPORT_ENABLED = :isReportEnabled, TAGS = :tags, IS_PUBLIC = :isPublic, MASTER_TEMPLATE = :masterTemplate, MASTER_CONTENT_HASH = :masterContentHash, TEMPLATE_HASH = :templateHash, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion WHERE FG_ENTITY_TYPE_BKP191224_id = :fgEntityTypeBkp191224Id")
    public int update(@BindBean FgEntityTypeBkp191224 fgentitytypebkp191224);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ENTITY_TYPE_BKP191224 WHERE FG_ENTITY_TYPE_BKP191224_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ENTITY_TYPE_BKP191224")
    public long countAll();

    /**
     * Bulk insert multiple FgEntityTypeBkp191224 entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ENTITY_TYPE_BKP191224 (ID, CATEGORY_CODE, CODE, NAME, PARENT_TYPE_CODE, IS_MASTER, IS_PRODUCT, ENTITY_CLASS_CODE, CONFIG_STATUS_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE_SCHEMA, IS_ANALYTICS_ENABLED, IS_REPORT_ENABLED, TAGS, IS_PUBLIC, MASTER_TEMPLATE, MASTER_CONTENT_HASH, TEMPLATE_HASH, VERSION_ID, IS_MASTER_VERSION) VALUES (:id, :categoryCode, :code, :name, :parentTypeCode, :isMaster, :isProduct, :entityClassCode, :configStatusCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :templateSchema, :isAnalyticsEnabled, :isReportEnabled, :tags, :isPublic, :masterTemplate, :masterContentHash, :templateHash, :versionId, :isMasterVersion)")
    public int[] bulkInsert(@BindBean List<FgEntityTypeBkp191224> fgentitytypebkp191224s);

    /**
     * Bulk update multiple FgEntityTypeBkp191224 entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ENTITY_TYPE_BKP191224 SET ID = :id, CATEGORY_CODE = :categoryCode, CODE = :code, NAME = :name, PARENT_TYPE_CODE = :parentTypeCode, IS_MASTER = :isMaster, IS_PRODUCT = :isProduct, ENTITY_CLASS_CODE = :entityClassCode, CONFIG_STATUS_CODE = :configStatusCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, TEMPLATE_SCHEMA = :templateSchema, IS_ANALYTICS_ENABLED = :isAnalyticsEnabled, IS_REPORT_ENABLED = :isReportEnabled, TAGS = :tags, IS_PUBLIC = :isPublic, MASTER_TEMPLATE = :masterTemplate, MASTER_CONTENT_HASH = :masterContentHash, TEMPLATE_HASH = :templateHash, VERSION_ID = :versionId, IS_MASTER_VERSION = :isMasterVersion WHERE FG_ENTITY_TYPE_BKP191224_id = :fgEntityTypeBkp191224Id")
    public int[] bulkUpdate(@BindBean List<FgEntityTypeBkp191224> fgentitytypebkp191224s);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ENTITY_TYPE_BKP191224 WHERE FG_ENTITY_TYPE_BKP191224_id IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ENTITY_TYPE_BKP191224 WHERE FG_ENTITY_TYPE_BKP191224_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple FgEntityTypeBkp191224 records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_TYPE_BKP191224 WHERE FG_ENTITY_TYPE_BKP191224_id IN (<ids>)")
    @RegisterBeanMapper(FgEntityTypeBkp191224.class)
    public List<FgEntityTypeBkp191224> findByIds(@BindList("ids") Collection<Integer> ids);
}
