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
import com.bsit.codegeneration.entity.Film;

public interface FilmDao {

    /**
     * Inserts a new Film and returns the generated ID.
     */
    @SqlUpdate("INSERT INTO film (title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) VALUES (:title, :description, :releaseYear, :languageId, :originalLanguageId, :rentalDuration, :rentalRate, :length, :replacementCost, :rating, :specialFeatures)")
    @GetGeneratedKeys
    public int insert(@BindBean Film film);

    /**
     * Finds a Film by its ID.
     */
    @SqlQuery("SELECT * FROM film WHERE film_id = :id")
    @RegisterBeanMapper(Film.class)
    public Optional<Film> findById(@Bind("id") int id);

    /**
     * Retrieves all records from the table. Use with caution for large tables.
     */
    @SqlQuery("SELECT * FROM film")
    @RegisterBeanMapper(Film.class)
    public List<Film> findAll();

    /**
     * Retrieves paginated records from the table.
     */
    @SqlQuery("SELECT * FROM film ORDER BY film_id LIMIT :limit OFFSET :offset")
    @RegisterBeanMapper(Film.class)
    public List<Film> findAllPaged(@Bind("limit") int limit, @Bind("offset") int offset);

    /**
     * Updates a Film and returns the number of affected rows.
     */
    @SqlUpdate("UPDATE film SET title = :title, description = :description, release_year = :releaseYear, language_id = :languageId, original_language_id = :originalLanguageId, rental_duration = :rentalDuration, rental_rate = :rentalRate, length = :length, replacement_cost = :replacementCost, rating = :rating, special_features = :specialFeatures WHERE film_id = :filmId")
    public int update(@BindBean Film film);

    /**
     * Deletes a record by ID and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM film WHERE film_id = :id")
    public int deleteById(@Bind("id") int id);

    /**
     * Returns the total count of records in the table.
     */
    @SqlQuery("SELECT COUNT(*) FROM film")
    public long countAll();

    /**
     * Bulk insert multiple Film entities and returns generated IDs.
     */
    @SqlBatch("INSERT INTO film (title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) VALUES (:title, :description, :releaseYear, :languageId, :originalLanguageId, :rentalDuration, :rentalRate, :length, :replacementCost, :rating, :specialFeatures)")
    @GetGeneratedKeys
    public int[] bulkInsert(@BindBean List<Film> films);

    /**
     * Bulk update multiple Film entities and returns affected row counts for each.
     */
    @SqlBatch("UPDATE film SET title = :title, description = :description, release_year = :releaseYear, language_id = :languageId, original_language_id = :originalLanguageId, rental_duration = :rentalDuration, rental_rate = :rentalRate, length = :length, replacement_cost = :replacementCost, rating = :rating, special_features = :specialFeatures WHERE film_id = :filmId")
    public int[] bulkUpdate(@BindBean List<Film> films);

    /**
     * Bulk delete multiple records by IDs using IN clause and returns total affected rows.
     */
    @SqlUpdate("DELETE FROM film WHERE film_id IN (<ids>)")
    public int bulkDeleteByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Bulk delete multiple records using batch processing and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM film WHERE film_id = :id")
    public int[] bulkDeleteBatch(@Bind("id") List<Integer> ids);

    /**
     * Finds multiple Film records by their IDs.
     */
    @SqlQuery("SELECT * FROM film WHERE film_id IN (<ids>)")
    @RegisterBeanMapper(Film.class)
    public List<Film> findByIds(@Bind("ids") Collection<Integer> ids);

    /**
     * Finds all Film records by languageId.
     */
    @SqlQuery("SELECT * FROM film WHERE language_id = :languageId")
    @RegisterBeanMapper(Film.class)
    public List<Film> findByLanguageId(@Bind("languageId") int languageId);

    /**
     * Finds all Film records by originalLanguageId.
     */
    @SqlQuery("SELECT * FROM film WHERE original_language_id = :originalLanguageId")
    @RegisterBeanMapper(Film.class)
    public List<Film> findByOriginalLanguageId(@Bind("originalLanguageId") int originalLanguageId);
}
