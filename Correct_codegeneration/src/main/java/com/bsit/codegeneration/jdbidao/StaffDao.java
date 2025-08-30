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
import com.bsit.codegeneration.entity.Staff;

public interface StaffDao {

    /**
     * Inserts a new Staff and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO staff (first_name, last_name, address_id, email, store_id, active, username, password, picture) VALUES (:firstName, :lastName, :addressId, :email, :storeId, :active, :username, :password, :picture)")
    @GetGeneratedKeys
    public int insert(@BindBean Staff staff);

    /**
     * Finds a Staff by its ID.
     */
    @SqlQuery("SELECT * FROM staff WHERE staff_id = :id")
    @RegisterBeanMapper(Staff.class)
    public Optional<Staff> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM staff")
    @RegisterBeanMapper(Staff.class)
    public List<Staff> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM staff ORDER BY staff_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Staff.class)
    public List<Staff> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Staff and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE staff SET first_name = :firstName, last_name = :lastName, address_id = :addressId, email = :email, store_id = :storeId, active = :active, username = :username, password = :password, picture = :picture WHERE staff_id = :staffId")
    public int update(@BindBean Staff staff);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM staff WHERE staff_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM staff")
    public long countAll();

    /**
     * Bulk insert multiple Staff entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO staff (first_name, last_name, address_id, email, store_id, active, username, password, picture) VALUES (:firstName, :lastName, :addressId, :email, :storeId, :active, :username, :password, :picture)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Staff> staffs);

    /**
     * Bulk update multiple Staff entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE staff SET first_name = :firstName, last_name = :lastName, address_id = :addressId, email = :email, store_id = :storeId, active = :active, username = :username, password = :password, picture = :picture WHERE staff_id = :staffId")
    public int[] bulkUpdate(@BindBean List<Staff> staffs);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM staff WHERE staff_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM staff WHERE staff_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Staff records by their IDs.
     */
    @SqlQuery("SELECT * FROM staff WHERE staff_id IN (<ids>)")
    @RegisterBeanMapper(Staff.class)
    public List<Staff> findByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Finds all Staff records by storeId.
     */
    @SqlQuery("SELECT * FROM staff WHERE store_id = :storeId")
    @RegisterBeanMapper(Staff.class)
    public List<Staff> findByStoreId(@Bind("storeId") int storeId);

    /**
     * Finds all Staff records by addressId.
     */
    @SqlQuery("SELECT * FROM staff WHERE address_id = :addressId")
    @RegisterBeanMapper(Staff.class)
    public List<Staff> findByAddressId(@Bind("addressId") int addressId);
}
