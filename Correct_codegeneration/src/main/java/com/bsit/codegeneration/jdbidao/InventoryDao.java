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
import com.bsit.codegeneration.entity.Inventory;

public interface InventoryDao {

    /**
     * Inserts a new Inventory and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO inventory (film_id, store_id) VALUES (:filmId, :storeId)")
    @GetGeneratedKeys
    public int insert(@Bind("filmId") int filmId, @Bind("storeId") int storeId);

    /**
     * Finds a Inventory by its ID.
     */
    @SqlQuery("SELECT * FROM inventory WHERE inventory_id = :id")
    @RegisterBeanMapper(Inventory.class)
    public Optional<Inventory> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM inventory")
    @RegisterBeanMapper(Inventory.class)
    public List<Inventory> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM inventory ORDER BY inventory_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Inventory.class)
    public List<Inventory> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Inventory and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE inventory SET film_id = :filmId, store_id = :storeId WHERE inventory_id = :inventoryId")
    public int update(@BindBean Inventory inventory);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM inventory WHERE inventory_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM inventory")
    public long countAll();

    /**
     * Bulk insert multiple Inventory entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO inventory (film_id, store_id) VALUES (:filmId, :storeId)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Inventory> inventorys);

    /**
     * Bulk insert with individual parameter lists and returns generated IDs.
     */
    @SqlBatch("INSERT INTO inventory (film_id, store_id) VALUES (:filmId, :storeId)")
    @GetGeneratedKeys
    public int[] bulkInsertParams(@Bind("filmId") List<Integer> filmIds, @Bind("storeId") List<Integer> storeIds);

    /**
     * Bulk update multiple Inventory entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE inventory SET film_id = :filmId, store_id = :storeId WHERE inventory_id = :inventoryId")
    public int[] bulkUpdate(@BindBean List<Inventory> inventorys);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE inventory SET film_id = :filmId, store_id = :storeId WHERE inventory_id = :inventoryId")
    public int[] bulkUpdateParams(@Bind("filmId") List<Integer> filmIds, @Bind("storeId") List<Integer> storeIds, @Bind("inventoryId") List<Integer> inventoryIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM inventory WHERE inventory_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM inventory WHERE inventory_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Inventory records by their IDs.
     */
    @SqlQuery("SELECT * FROM inventory WHERE inventory_id IN (<ids>)")
    @RegisterBeanMapper(Inventory.class)
    public List<Inventory> findByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Finds all Inventory records by storeId.
     */
    @SqlQuery("SELECT * FROM inventory WHERE store_id = :storeId")
    @RegisterBeanMapper(Inventory.class)
    public List<Inventory> findByStoreId(@Bind("storeId") int storeId);

    /**
     * Finds all Inventory records by filmId.
     */
    @SqlQuery("SELECT * FROM inventory WHERE film_id = :filmId")
    @RegisterBeanMapper(Inventory.class)
    public List<Inventory> findByFilmId(@Bind("filmId") int filmId);
}
