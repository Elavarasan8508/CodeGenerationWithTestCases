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
import com.bsit.codegeneration.entity.City;

public interface CityDao {

    /**
     * Inserts a new City and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO city (city, country_id) VALUES (:city, :countryId)")
    @GetGeneratedKeys
    public int insert(@Bind("city") String city, @Bind("countryId") int countryId);

    /**
     * Finds a City by its ID.
     */
    @SqlQuery("SELECT * FROM city WHERE city_id = :id")
    @RegisterBeanMapper(City.class)
    public Optional<City> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM city")
    @RegisterBeanMapper(City.class)
    public List<City> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM city ORDER BY city_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(City.class)
    public List<City> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a City and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE city SET city = :city, country_id = :countryId WHERE city_id = :cityId")
    public int update(@BindBean City city);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM city WHERE city_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM city")
    public long countAll();

    /**
     * Bulk insert multiple City entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO city (city, country_id) VALUES (:city, :countryId)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<City> citys);

    /**
     * Bulk insert with individual parameter lists and returns generated IDs.
     */
    @SqlBatch("INSERT INTO city (city, country_id) VALUES (:city, :countryId)")
    @GetGeneratedKeys
    public int[] bulkInsertParams(@Bind("city") List<String> citys, @Bind("countryId") List<Integer> countryIds);

    /**
     * Bulk update multiple City entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE city SET city = :city, country_id = :countryId WHERE city_id = :cityId")
    public int[] bulkUpdate(@BindBean List<City> citys);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE city SET city = :city, country_id = :countryId WHERE city_id = :cityId")
    public int[] bulkUpdateParams(@Bind("city") List<String> citys, @Bind("countryId") List<Integer> countryIds, @Bind("cityId") List<Integer> cityIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM city WHERE city_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM city WHERE city_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple City records by their IDs.
     */
    @SqlQuery("SELECT * FROM city WHERE city_id IN (<ids>)")
    @RegisterBeanMapper(City.class)
    public List<City> findByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Finds all City records by countryId.
     */
    @SqlQuery("SELECT * FROM city WHERE country_id = :countryId")
    @RegisterBeanMapper(City.class)
    public List<City> findByCountryId(@Bind("countryId") int countryId);
}
