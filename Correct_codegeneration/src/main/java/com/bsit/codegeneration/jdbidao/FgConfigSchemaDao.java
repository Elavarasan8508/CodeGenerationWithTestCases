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
import com.bsit.codegeneration.entity.FgConfigSchema;

public interface FgConfigSchemaDao {

    /**
     * Inserts a new FgConfigSchema and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_CONFIG_SCHEMA (ID, CONFIG_CODE, NAME, PARENT_CODE, FIELD_DATA, FORM_DATA, AUTH_FORM_DATA, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CATEGORY_CODE, TYPE_CODE) VALUES (:id, :configCode, :name, :parentCode, :fieldData, :formData, :authFormData, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :categoryCode, :typeCode)")
    public int insert(@BindBean FgConfigSchema fgconfigschema);

    /**
     * Finds a FgConfigSchema by its ID.
     */
    @SqlQuery("SELECT * FROM FG_CONFIG_SCHEMA WHERE ID = :id")
    @RegisterBeanMapper(FgConfigSchema.class)
    public Optional<FgConfigSchema> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_CONFIG_SCHEMA")
    @RegisterBeanMapper(FgConfigSchema.class)
    public List<FgConfigSchema> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_CONFIG_SCHEMA ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgConfigSchema.class)
    public List<FgConfigSchema> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgConfigSchema and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_CONFIG_SCHEMA SET CONFIG_CODE = :configCode, NAME = :name, PARENT_CODE = :parentCode, FIELD_DATA = :fieldData, FORM_DATA = :formData, AUTH_FORM_DATA = :authFormData, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, CATEGORY_CODE = :categoryCode, TYPE_CODE = :typeCode WHERE ID = :id")
    public int update(@BindBean FgConfigSchema fgconfigschema);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CONFIG_SCHEMA WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_CONFIG_SCHEMA")
    public long countAll();

    /**
     * Bulk insert multiple FgConfigSchema entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_CONFIG_SCHEMA (ID, CONFIG_CODE, NAME, PARENT_CODE, FIELD_DATA, FORM_DATA, AUTH_FORM_DATA, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, CATEGORY_CODE, TYPE_CODE) VALUES (:id, :configCode, :name, :parentCode, :fieldData, :formData, :authFormData, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy, :categoryCode, :typeCode)")
    public int[] bulkInsert(@BindBean List<FgConfigSchema> fgconfigschemas);

    /**
     * Bulk update multiple FgConfigSchema entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_CONFIG_SCHEMA SET CONFIG_CODE = :configCode, NAME = :name, PARENT_CODE = :parentCode, FIELD_DATA = :fieldData, FORM_DATA = :formData, AUTH_FORM_DATA = :authFormData, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy, CATEGORY_CODE = :categoryCode, TYPE_CODE = :typeCode WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgConfigSchema> fgconfigschemas);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_CONFIG_SCHEMA WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_CONFIG_SCHEMA WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgConfigSchema records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_CONFIG_SCHEMA WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgConfigSchema.class)
    public List<FgConfigSchema> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
