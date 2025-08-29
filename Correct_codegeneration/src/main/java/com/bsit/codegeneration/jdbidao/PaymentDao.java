package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Payment;

public interface PaymentDao {

    @SqlUpdate("INSERT INTO payment (customer_id, staff_id, rental_id, amount, payment_date) VALUES (:customerId, :staffId, :rentalId, :amount, :paymentDate)")
    @GetGeneratedKeys
    public int insert(@BindBean Payment payment);

    @SqlQuery("SELECT * FROM payment WHERE payment_id = :id")
    public Payment findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM payment")
    public List<Payment> findAll();

    @SqlUpdate("UPDATE payment SET customer_id = :customerId, staff_id = :staffId, rental_id = :rentalId, amount = :amount, payment_date = :paymentDate WHERE payment_id = :paymentId")
    public void update(@BindBean Payment payment);

    @SqlUpdate("DELETE FROM payment WHERE payment_id = :id")
    public void deleteById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM payment WHERE staff_id = :staffId")
    public List<Payment> findByStaffId(@Bind("staffId") int staffId);

    @SqlQuery("SELECT * FROM payment WHERE customer_id = :customerId")
    public List<Payment> findByCustomerId(@Bind("customerId") int customerId);

    @SqlQuery("SELECT * FROM payment WHERE rental_id = :rentalId")
    public List<Payment> findByRentalId(@Bind("rentalId") int rentalId);
}
