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
import com.bsit.codegeneration.entity.Address;

public interface AddressDao {

    /**
     * Inserts a new Address and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO address (address, address2, district, city_id, postal_code, phone) VALUES (:address, :address2, :district, :cityId, :postalCode, :phone)")
    @GetGeneratedKeys
    public int insert(@BindBean Address address);

    /**
     * Finds a Address by its ID.
     */
    @SqlQuery("SELECT * FROM address WHERE address_id = :id")
    @RegisterBeanMapper(Address.class)
    public Optional<Address> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM address")
    @RegisterBeanMapper(Address.class)
    public List<Address> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM address ORDER BY address_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Address.class)
    public List<Address> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Address and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE address SET address = :address, address2 = :address2, district = :district, city_id = :cityId, postal_code = :postalCode, phone = :phone WHERE address_id = :addressId")
    public int update(@BindBean Address address);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM address WHERE address_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM address")
    public long countAll();

    /**
     * Bulk insert multiple Address entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO address (address, address2, district, city_id, postal_code, phone) VALUES (:address, :address2, :district, :cityId, :postalCode, :phone)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Address> addresss);

    /**
     * Bulk update multiple Address entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE address SET address = :address, address2 = :address2, district = :district, city_id = :cityId, postal_code = :postalCode, phone = :phone WHERE address_id = :addressId")
    public int[] bulkUpdate(@BindBean List<Address> addresss);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM address WHERE address_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM address WHERE address_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Address records by their IDs.
     */
    @SqlQuery("SELECT * FROM address WHERE address_id IN (<ids>)")
    @RegisterBeanMapper(Address.class)
    public List<Address> findByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Finds all Address records by cityId.
     */
    @SqlQuery("SELECT * FROM address WHERE city_id = :cityId")
    @RegisterBeanMapper(Address.class)
    public List<Address> findByCityId(@Bind("cityId") int cityId);
}
