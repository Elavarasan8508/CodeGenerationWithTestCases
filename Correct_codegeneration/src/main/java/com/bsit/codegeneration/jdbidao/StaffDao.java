package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Staff;

public interface StaffDao {

    @SqlUpdate("INSERT INTO staff (first_name, last_name, address_id, email, store_id, active, username, password, picture) VALUES (:firstName, :lastName, :addressId, :email, :storeId, :active, :username, :password, :picture)")
    @GetGeneratedKeys
    public int insert(@BindBean Staff staff);

    @SqlQuery("SELECT * FROM staff WHERE staff_id = :id")
    public Staff findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM staff")
    public List<Staff> findAll();

    @SqlUpdate("UPDATE staff SET first_name = :firstName, last_name = :lastName, address_id = :addressId, email = :email, store_id = :storeId, active = :active, username = :username, password = :password, picture = :picture WHERE staff_id = :staffId")
    public void update(@BindBean Staff staff);

    @SqlUpdate("DELETE FROM staff WHERE staff_id = :id")
    public void deleteById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM staff WHERE store_id = :storeId")
    public List<Staff> findByStoreId(@Bind("storeId") int storeId);

    @SqlQuery("SELECT * FROM staff WHERE address_id = :addressId")
    public List<Staff> findByAddressId(@Bind("addressId") int addressId);
}
