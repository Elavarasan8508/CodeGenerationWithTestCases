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
import com.bsit.codegeneration.entity.Rental;

public interface RentalDao {

    /**
     * Inserts a new Rental and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO rental (rental_date, inventory_id, customer_id, return_date, staff_id) VALUES (:rentalDate, :inventoryId, :customerId, :returnDate, :staffId)")
    @GetGeneratedKeys
    public int insert(@BindBean Rental rental);

    /**
     * Finds a Rental by its ID.
     */
    @SqlQuery("SELECT * FROM rental WHERE rental_id = :id")
    @RegisterBeanMapper(Rental.class)
    public Optional<Rental> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM rental")
    @RegisterBeanMapper(Rental.class)
    public List<Rental> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM rental ORDER BY rental_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Rental.class)
    public List<Rental> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Rental and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE rental SET rental_date = :rentalDate, inventory_id = :inventoryId, customer_id = :customerId, return_date = :returnDate, staff_id = :staffId WHERE rental_id = :rentalId")
    public int update(@BindBean Rental rental);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM rental WHERE rental_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM rental")
    public long countAll();

    /**
     * Bulk insert multiple Rental entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO rental (rental_date, inventory_id, customer_id, return_date, staff_id) VALUES (:rentalDate, :inventoryId, :customerId, :returnDate, :staffId)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Rental> rentals);

    /**
     * Bulk update multiple Rental entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE rental SET rental_date = :rentalDate, inventory_id = :inventoryId, customer_id = :customerId, return_date = :returnDate, staff_id = :staffId WHERE rental_id = :rentalId")
    public int[] bulkUpdate(@BindBean List<Rental> rentals);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM rental WHERE rental_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM rental WHERE rental_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Rental records by their IDs.
     */
    @SqlQuery("SELECT * FROM rental WHERE rental_id IN (<ids>)")
    @RegisterBeanMapper(Rental.class)
    public List<Rental> findByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Finds all Rental records by inventoryId.
     */
    @SqlQuery("SELECT * FROM rental WHERE inventory_id = :inventoryId")
    @RegisterBeanMapper(Rental.class)
    public List<Rental> findByInventoryId(@Bind("inventoryId") int inventoryId);

    /**
     * Finds all Rental records by staffId.
     */
    @SqlQuery("SELECT * FROM rental WHERE staff_id = :staffId")
    @RegisterBeanMapper(Rental.class)
    public List<Rental> findByStaffId(@Bind("staffId") int staffId);

    /**
     * Finds all Rental records by customerId.
     */
    @SqlQuery("SELECT * FROM rental WHERE customer_id = :customerId")
    @RegisterBeanMapper(Rental.class)
    public List<Rental> findByCustomerId(@Bind("customerId") int customerId);
}
