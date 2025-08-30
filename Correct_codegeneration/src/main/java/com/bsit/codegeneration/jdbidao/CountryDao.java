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
import com.bsit.codegeneration.entity.Country;

public interface CountryDao {

    /**
     * Inserts a new Country and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO country (country) VALUES (:country)")
    @GetGeneratedKeys
    public int insert(@Bind("country") String country);

    /**
     * Finds a Country by its ID.
     */
    @SqlQuery("SELECT * FROM country WHERE country_id = :id")
    @RegisterBeanMapper(Country.class)
    public Optional<Country> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM country")
    @RegisterBeanMapper(Country.class)
    public List<Country> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM country ORDER BY country_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Country.class)
    public List<Country> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Country and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE country SET country = :country WHERE country_id = :countryId")
    public int update(@BindBean Country country);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM country WHERE country_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM country")
    public long countAll();

    /**
     * Bulk insert multiple Country entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO country (country) VALUES (:country)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Country> countrys);

    /**
     * Bulk insert with individual parameter lists and returns generated IDs.
     */
    @SqlBatch("INSERT INTO country (country) VALUES (:country)")
    @GetGeneratedKeys
    public int[] bulkInsertParams(@Bind("country") List<String> countrys);

    /**
     * Bulk update multiple Country entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE country SET country = :country WHERE country_id = :countryId")
    public int[] bulkUpdate(@BindBean List<Country> countrys);

    /**
     * Bulk update with individual parameter lists and returns affected row counts for each.
     */
    @SqlBatch("UPDATE country SET country = :country WHERE country_id = :countryId")
    public int[] bulkUpdateParams(@Bind("country") List<String> countrys, @Bind("countryId") List<Integer> countryIds);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM country WHERE country_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM country WHERE country_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Country records by their IDs.
     */
    @SqlQuery("SELECT * FROM country WHERE country_id IN (<ids>)")
    @RegisterBeanMapper(Country.class)
    public List<Country> findByIds(@Bind("ids") Collection<Integer> ids);
}
