package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.batch.SqlBatch;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import java.util.List;
import java.util.Optional;
import java.util.Collection;
import com.bsit.codegeneration.entity.Category;

public interface CategoryDao {

    /**
     * Inserts a new Category and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO category (name) VALUES (:name)")
    @GetGeneratedKeys
    public int insert(@Bind("name") String name);

    /**
     * Finds a Category by its ID.
     */
    @SqlQuery("SELECT * FROM category WHERE category_id = :id")
    @RegisterBeanMapper(Category.class)
    public Optional<Category> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM category")
    @RegisterBeanMapper(Category.class)
    public List<Category> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM category ORDER BY category_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Category.class)
    public List<Category> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Category and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE category SET name = :name WHERE category_id = :categoryId")
    public int update(@BindBean Category category);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM category WHERE category_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM category")
    public long countAll();

    /**
     * Bulk insert multiple Category entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO category (name) VALUES (:name)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Category> categorys);

    /**
     * Bulk insert with individual parameter lists and returns generated IDs.
     */
    @SqlBatch("INSERT INTO category (name) VALUES (:name)")
    @GetGeneratedKeys
    public int[] bulkInsertParams(@Bind("name") List<String> names);

    /**
     * Bulk update multiple Category entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE category SET name = :name WHERE category_id = :categoryId")
    public int[] bulkUpdate(@BindBean List<Category> categorys);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE category SET name = :name WHERE category_id = :categoryId")
    public int[] bulkUpdateParams(@Bind("name") List<String> names, @Bind("categoryId") List<Integer> categoryIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM category WHERE category_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM category WHERE category_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Category records by their IDs.
     */
    @SqlQuery("SELECT * FROM category WHERE category_id IN (<ids>)")
    @RegisterBeanMapper(Category.class)
    public List<Category> findByIds(@Bind("ids") Collection<Integer> ids);
}
