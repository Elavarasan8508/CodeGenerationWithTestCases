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
import com.bsit.codegeneration.entity.FgEntityCategory;

public interface FgEntityCategoryDao {

    /**
     * Inserts a new FgEntityCategory and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO FG_ENTITY_CATEGORY (ID, CODE, CONFIG_STATUS_CODE, NAME, PARENT_CATEGORY_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :code, :configStatusCode, :name, :parentCategoryCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int insert(@BindBean FgEntityCategory fgentitycategory);

    /**
     * Finds a FgEntityCategory by its ID.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_CATEGORY WHERE ID = :id")
    @RegisterBeanMapper(FgEntityCategory.class)
    public Optional<FgEntityCategory> findById(@Bind("id") java.math.BigDecimal id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_CATEGORY")
    @RegisterBeanMapper(FgEntityCategory.class)
    public List<FgEntityCategory> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_CATEGORY ORDER BY ID LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(FgEntityCategory.class)
    public List<FgEntityCategory> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a FgEntityCategory and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE FG_ENTITY_CATEGORY SET CODE = :code, CONFIG_STATUS_CODE = :configStatusCode, NAME = :name, PARENT_CATEGORY_CODE = :parentCategoryCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int update(@BindBean FgEntityCategory fgentitycategory);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ENTITY_CATEGORY WHERE ID = :id")
    public int deleteById(@Bind("id") java.math.BigDecimal id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM FG_ENTITY_CATEGORY")
    public long countAll();

    /**
     * Bulk insert multiple FgEntityCategory entities and returns affected row counts.
     */
    @SqlBatch("INSERT INTO FG_ENTITY_CATEGORY (ID, CODE, CONFIG_STATUS_CODE, NAME, PARENT_CATEGORY_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY) VALUES (:id, :code, :configStatusCode, :name, :parentCategoryCode, :description, :activeCode, :statusCode, :lastAuthorisedOn, :lastAuthorisedBy)")
    public int[] bulkInsert(@BindBean List<FgEntityCategory> fgentitycategorys);

    /**
     * Bulk update multiple FgEntityCategory entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE FG_ENTITY_CATEGORY SET CODE = :code, CONFIG_STATUS_CODE = :configStatusCode, NAME = :name, PARENT_CATEGORY_CODE = :parentCategoryCode, DESCRIPTION = :description, ACTIVE_CODE = :activeCode, STATUS_CODE = :statusCode, LAST_AUTHORISED_ON = :lastAuthorisedOn, LAST_AUTHORISED_BY = :lastAuthorisedBy WHERE ID = :id")
    public int[] bulkUpdate(@BindBean List<FgEntityCategory> fgentitycategorys);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM FG_ENTITY_CATEGORY WHERE ID IN (<ids>)")
    public int bulkDeleteByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM FG_ENTITY_CATEGORY WHERE ID = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<java.math.BigDecimal> ids);

    /**
     * Finds multiple FgEntityCategory records by their IDs.
     */
    @SqlQuery("SELECT * FROM FG_ENTITY_CATEGORY WHERE ID IN (<ids>)")
    @RegisterBeanMapper(FgEntityCategory.class)
    public List<FgEntityCategory> findByIds(@BindList("ids") Collection<java.math.BigDecimal> ids);
}
