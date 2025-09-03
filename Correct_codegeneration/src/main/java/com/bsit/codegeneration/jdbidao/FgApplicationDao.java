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
import com.bsit.codegeneration.entity.FgApplication;

public interface FgApplicationDao {

    /**
     * Inserts a new FgApplication and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_APPLICATION (ID, CODE, NAME, SUB_TITLE, ICON, DESCRIPTION, NAVIGATION_SCHEMA, IS_SECURED, ACTIVE_CODE, APPLICATION_TYPE, UUID, TAGS, APP_TITLE, DEVICE_CHANNEL, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID) VALUES (:id, :code, :name, :subTitle, :icon, :description, :navigationSchema, :isSecured, :activeCode, :applicationType, :uuid, :tags, :appTitle, :deviceChannel, :lastAuthorisedOn, :lastAuthorisedBy, :masterTemplate, :masterContentHash, :isMasterVersion, :versionId)")
    public int insert(@BindBean FgApplication fgapplication);

    /**
     * Finds a FgApplication by its ID.
     */
    @SqlQuery("SELECT * FROM FG_APPLICATION WHERE ID = :id")
    @RegisterBeanMapper(FgApplication.class)
    public Optional<FgApplication> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_APPLICATION")
    @RegisterBeanMapper(FgApplication.class)
    public List<FgApplication> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_APPLICATION ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgApplication.class)
    public List<FgApplication> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgApplication and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_APPLICATION SET CODE = :code, NAME = :name, SUB_TITLE = :subTitle, ICON = :icon, DESCRIPTION = :description, NAVIGATION_SCHEMA = :navigationSchema, IS_SECURED = :isSecured, ACTIVE_CODE = :activeCode, APPLICATION_TYPE = :applicationType, UUID = :uuid, TAGS = :tags, APP_TITLE = :appTitle, DEVICE_CHANNEL = :deviceChannel, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, MASTER_TEMPLATE = :masterTemplate, MASTER_CONTENT_HASH = :masterContentHash, IS_MASTER_VERSION = :isMasterVersion, VERSION_ID = :versionId WHERE ID = :id")
    public int update(@BindBean FgApplication fgapplication);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_APPLICATION WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_APPLICATION")
    public long countAll();

    /**
     * Bulk insert multiple FgApplication entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_APPLICATION (ID, CODE, NAME, SUB_TITLE, ICON, DESCRIPTION, NAVIGATION_SCHEMA, IS_SECURED, ACTIVE_CODE, APPLICATION_TYPE, UUID, TAGS, APP_TITLE, DEVICE_CHANNEL, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, MASTER_TEMPLATE, MASTER_CONTENT_HASH, IS_MASTER_VERSION, VERSION_ID) VALUES (:id, :code, :name, :subTitle, :icon, :description, :navigationSchema, :isSecured, :activeCode, :applicationType, :uuid, :tags, :appTitle, :deviceChannel, :lastAuthorisedOn, :lastAuthorisedBy, :masterTemplate, :masterContentHash, :isMasterVersion, :versionId)")
    public int[] bulkInsert(@BindBean List<FgApplication> fgapplications);

    /**
     * Bulk update multiple FgApplication entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_APPLICATION SET CODE = :code, NAME = :name, SUB_TITLE = :subTitle, ICON = :icon, DESCRIPTION = :description, NAVIGATION_SCHEMA = :navigationSchema, IS_SECURED = :isSecured, ACTIVE_CODE = :activeCode, APPLICATION_TYPE = :applicationType, UUID = :uuid, TAGS = :tags, APP_TITLE = :appTitle, DEVICE_CHANNEL = :deviceChannel, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, MASTER_TEMPLATE = :masterTemplate, MASTER_CONTENT_HASH = :masterContentHash, IS_MASTER_VERSION = :isMasterVersion, VERSION_ID = :versionId WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgApplication> fgapplications);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_APPLICATION WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_APPLICATION WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgApplication records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_APPLICATION WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgApplication.class)
    public List<FgApplication> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
