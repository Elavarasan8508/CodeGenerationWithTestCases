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
import com.bsit.codegeneration.entity.Customer;

public interface CustomerDao {

    /**
     * Inserts a new Customer and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date) VALUES (:storeId, :firstName, :lastName, :email, :addressId, :active, :createDate)")
    @GetGeneratedKeys
    public int insert(@BindBean Customer customer);

    /**
     * Finds a Customer by its ID.
     */
    @SqlQuery("SELECT * FROM customer WHERE customer_id = :id")
    @RegisterBeanMapper(Customer.class)
    public Optional<Customer> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM customer")
    @RegisterBeanMapper(Customer.class)
    public List<Customer> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM customer ORDER BY customer_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Customer.class)
    public List<Customer> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Customer and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE customer SET store_id = :storeId, first_name = :firstName, last_name = :lastName, email = :email, address_id = :addressId, active = :active, create_date = :createDate WHERE customer_id = :customerId")
    public int update(@BindBean Customer customer);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM customer WHERE customer_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM customer")
    public long countAll();

    /**
     * Bulk insert multiple Customer entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date) VALUES (:storeId, :firstName, :lastName, :email, :addressId, :active, :createDate)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Customer> customers);

    /**
     * Bulk update multiple Customer entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE customer SET store_id = :storeId, first_name = :firstName, last_name = :lastName, email = :email, address_id = :addressId, active = :active, create_date = :createDate WHERE customer_id = :customerId")
    public int[] bulkUpdate(@BindBean List<Customer> customers);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM customer WHERE customer_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM customer WHERE customer_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Customer records by their IDs.
     */
    @SqlQuery("SELECT * FROM customer WHERE customer_id IN (<ids>)")
    @RegisterBeanMapper(Customer.class)
    public List<Customer> findByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Finds all Customer records by storeId.
     */
    @SqlQuery("SELECT * FROM customer WHERE store_id = :storeId")
    @RegisterBeanMapper(Customer.class)
    public List<Customer> findByStoreId(@Bind("storeId") int storeId);

    /**
     * Finds all Customer records by addressId.
     */
    @SqlQuery("SELECT * FROM customer WHERE address_id = :addressId")
    @RegisterBeanMapper(Customer.class)
    public List<Customer> findByAddressId(@Bind("addressId") int addressId);
}
