package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Store;

public interface StoreDao {

    @SqlUpdate("INSERT INTO store (manager_staff_id, address_id) VALUES (:managerStaffId, :addressId)")
    @GetGeneratedKeys
    public int insert(@Bind("managerStaffId") int managerStaffId, @Bind("addressId") int addressId);

    @SqlQuery("SELECT * FROM store WHERE store_id = :id")
    public Store findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM store")
    public List<Store> findAll();

    @SqlUpdate("UPDATE store SET manager_staff_id = :managerStaffId, address_id = :addressId WHERE store_id = :storeId")
    public void update(@BindBean Store store);

    @SqlUpdate("DELETE FROM store WHERE store_id = :id")
    public void deleteById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM store WHERE manager_staff_id = :managerStaffId")
    public List<Store> findByManagerStaffId(@Bind("managerStaffId") int managerStaffId);

    @SqlQuery("SELECT * FROM store WHERE address_id = :addressId")
    public List<Store> findByAddressId(@Bind("addressId") int addressId);
}
