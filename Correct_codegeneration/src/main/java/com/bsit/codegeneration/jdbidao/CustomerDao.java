package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Customer;

public interface CustomerDao {

    @SqlUpdate("INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, create_date) VALUES (:storeId, :firstName, :lastName, :email, :addressId, :active, :createDate)")
    @GetGeneratedKeys
    public int insert(@BindBean Customer customer);

    @SqlQuery("SELECT * FROM customer WHERE customer_id = :id")
    public Customer findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM customer")
    public List<Customer> findAll();

    @SqlUpdate("UPDATE customer SET store_id = :storeId, first_name = :firstName, last_name = :lastName, email = :email, address_id = :addressId, active = :active, create_date = :createDate WHERE customer_id = :customerId")
    public void update(@BindBean Customer customer);

    @SqlUpdate("DELETE FROM customer WHERE customer_id = :id")
    public void deleteById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM customer WHERE store_id = :storeId")
    public List<Customer> findByStoreId(@Bind("storeId") int storeId);

    @SqlQuery("SELECT * FROM customer WHERE address_id = :addressId")
    public List<Customer> findByAddressId(@Bind("addressId") int addressId);
}
