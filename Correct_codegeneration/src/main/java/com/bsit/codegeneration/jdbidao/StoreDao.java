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
import com.bsit.codegeneration.entity.Store;

public interface StoreDao {

    /**
     * Inserts a new Store and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO store (manager_staff_id, address_id) VALUES (:managerStaffId, :addressId)")
    @GetGeneratedKeys
    public int insert(@Bind("managerStaffId") int managerStaffId, @Bind("addressId") int addressId);

    /**
     * Finds a Store by its ID.
     */
    @SqlQuery("SELECT * FROM store WHERE store_id = :id")
    @RegisterBeanMapper(Store.class)
    public Optional<Store> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM store")
    @RegisterBeanMapper(Store.class)
    public List<Store> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM store ORDER BY store_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Store.class)
    public List<Store> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Store and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE store SET manager_staff_id = :managerStaffId, address_id = :addressId WHERE store_id = :storeId")
    public int update(@BindBean Store store);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM store WHERE store_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM store")
    public long countAll();

    /**
     * Bulk insert multiple Store entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO store (manager_staff_id, address_id) VALUES (:managerStaffId, :addressId)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Store> stores);

    /**
     * Bulk insert with individual parameter lists and returns generated IDs.
     */
    @SqlBatch("INSERT INTO store (manager_staff_id, address_id) VALUES (:managerStaffId, :addressId)")
    @GetGeneratedKeys
    public int[] bulkInsertParams(@Bind("managerStaffId") List<Integer> managerStaffIds, @Bind("addressId") List<Integer> addressIds);

    /**
     * Bulk update multiple Store entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE store SET manager_staff_id = :managerStaffId, address_id = :addressId WHERE store_id = :storeId")
    public int[] bulkUpdate(@BindBean List<Store> stores);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE store SET manager_staff_id = :managerStaffId, address_id = :addressId WHERE store_id = :storeId")
    public int[] bulkUpdateParams(@Bind("managerStaffId") List<Integer> managerStaffIds, @Bind("addressId") List<Integer> addressIds, @Bind("storeId") List<Integer> storeIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM store WHERE store_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM store WHERE store_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Store records by their IDs.
     */
    @SqlQuery("SELECT * FROM store WHERE store_id IN (<ids>)")
    @RegisterBeanMapper(Store.class)
    public List<Store> findByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Finds all Store records by managerStaffId.
     */
    @SqlQuery("SELECT * FROM store WHERE manager_staff_id = :managerStaffId")
    @RegisterBeanMapper(Store.class)
    public List<Store> findByManagerStaffId(@Bind("managerStaffId") int managerStaffId);

    /**
     * Finds all Store records by addressId.
     */
    @SqlQuery("SELECT * FROM store WHERE address_id = :addressId")
    @RegisterBeanMapper(Store.class)
    public List<Store> findByAddressId(@Bind("addressId") int addressId);
}
