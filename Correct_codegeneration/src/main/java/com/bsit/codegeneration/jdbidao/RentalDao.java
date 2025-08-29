package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Rental;

public interface RentalDao {

    @SqlUpdate("INSERT INTO rental (rental_date, inventory_id, customer_id, return_date, staff_id) VALUES (:rentalDate, :inventoryId, :customerId, :returnDate, :staffId)")
    @GetGeneratedKeys
    public int insert(@BindBean Rental rental);

    @SqlQuery("SELECT * FROM rental WHERE rental_id = :id")
    public Rental findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM rental")
    public List<Rental> findAll();

    @SqlUpdate("UPDATE rental SET rental_date = :rentalDate, inventory_id = :inventoryId, customer_id = :customerId, return_date = :returnDate, staff_id = :staffId WHERE rental_id = :rentalId")
    public void update(@BindBean Rental rental);

    @SqlUpdate("DELETE FROM rental WHERE rental_id = :id")
    public void deleteById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM rental WHERE inventory_id = :inventoryId")
    public List<Rental> findByInventoryId(@Bind("inventoryId") int inventoryId);

    @SqlQuery("SELECT * FROM rental WHERE staff_id = :staffId")
    public List<Rental> findByStaffId(@Bind("staffId") int staffId);

    @SqlQuery("SELECT * FROM rental WHERE customer_id = :customerId")
    public List<Rental> findByCustomerId(@Bind("customerId") int customerId);
}
