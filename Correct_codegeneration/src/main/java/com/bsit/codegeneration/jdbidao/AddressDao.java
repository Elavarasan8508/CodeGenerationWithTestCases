package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Address;

public interface AddressDao {

    @SqlUpdate("INSERT INTO address (address, address2, district, city_id, postal_code, phone) VALUES (:address, :address2, :district, :cityId, :postalCode, :phone)")
    @GetGeneratedKeys
    public int insert(@BindBean Address address);

    @SqlQuery("SELECT * FROM address WHERE address_id = :id")
    public Address findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM address")
    public List<Address> findAll();

    @SqlUpdate("UPDATE address SET address = :address, address2 = :address2, district = :district, city_id = :cityId, postal_code = :postalCode, phone = :phone WHERE address_id = :addressId")
    public void update(@BindBean Address address);

    @SqlUpdate("DELETE FROM address WHERE address_id = :id")
    public void deleteById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM address WHERE city_id = :cityId")
    public List<Address> findByCityId(@Bind("cityId") int cityId);
}
