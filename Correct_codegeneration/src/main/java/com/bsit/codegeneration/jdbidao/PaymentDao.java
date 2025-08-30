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
import com.bsit.codegeneration.entity.Payment;

public interface PaymentDao {

    /**
     * Inserts a new Payment and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO payment (customer_id, staff_id, rental_id, amount, payment_date) VALUES (:customerId, :staffId, :rentalId, :amount, :paymentDate)")
    @GetGeneratedKeys
    public int insert(@BindBean Payment payment);

    /**
     * Finds a Payment by its ID.
     */
    @SqlQuery("SELECT * FROM payment WHERE payment_id = :id")
    @RegisterBeanMapper(Payment.class)
    public Optional<Payment> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM payment")
    @RegisterBeanMapper(Payment.class)
    public List<Payment> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM payment ORDER BY payment_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Payment.class)
    public List<Payment> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Payment and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE payment SET customer_id = :customerId, staff_id = :staffId, rental_id = :rentalId, amount = :amount, payment_date = :paymentDate WHERE payment_id = :paymentId")
    public int update(@BindBean Payment payment);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM payment WHERE payment_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM payment")
    public long countAll();

    /**
     * Bulk insert multiple Payment entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO payment (customer_id, staff_id, rental_id, amount, payment_date) VALUES (:customerId, :staffId, :rentalId, :amount, :paymentDate)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Payment> payments);

    /**
     * Bulk update multiple Payment entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE payment SET customer_id = :customerId, staff_id = :staffId, rental_id = :rentalId, amount = :amount, payment_date = :paymentDate WHERE payment_id = :paymentId")
    public int[] bulkUpdate(@BindBean List<Payment> payments);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM payment WHERE payment_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM payment WHERE payment_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Payment records by their IDs.
     */
    @SqlQuery("SELECT * FROM payment WHERE payment_id IN (<ids>)")
    @RegisterBeanMapper(Payment.class)
    public List<Payment> findByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Finds all Payment records by staffId.
     */
    @SqlQuery("SELECT * FROM payment WHERE staff_id = :staffId")
    @RegisterBeanMapper(Payment.class)
    public List<Payment> findByStaffId(@Bind("staffId") int staffId);

    /**
     * Finds all Payment records by customerId.
     */
    @SqlQuery("SELECT * FROM payment WHERE customer_id = :customerId")
    @RegisterBeanMapper(Payment.class)
    public List<Payment> findByCustomerId(@Bind("customerId") int customerId);

    /**
     * Finds all Payment records by rentalId.
     */
    @SqlQuery("SELECT * FROM payment WHERE rental_id = :rentalId")
    @RegisterBeanMapper(Payment.class)
    public List<Payment> findByRentalId(@Bind("rentalId") int rentalId);
}
