package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Film;

public interface FilmDao {

    @SqlUpdate("INSERT INTO film (title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) VALUES (:title, :description, :releaseYear, :languageId, :originalLanguageId, :rentalDuration, :rentalRate, :length, :replacementCost, :rating, :specialFeatures)")
    @GetGeneratedKeys
    public int insert(@BindBean Film film);

    @SqlQuery("SELECT * FROM film WHERE film_id = :id")
    public Film findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM film")
    public List<Film> findAll();

    @SqlUpdate("UPDATE film SET title = :title, description = :description, release_year = :releaseYear, language_id = :languageId, original_language_id = :originalLanguageId, rental_duration = :rentalDuration, rental_rate = :rentalRate, length = :length, replacement_cost = :replacementCost, rating = :rating, special_features = :specialFeatures WHERE film_id = :filmId")
    public void update(@BindBean Film film);

    @SqlUpdate("DELETE FROM film WHERE film_id = :id")
    public void deleteById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM film WHERE language_id = :languageId")
    public List<Film> findByLanguageId(@Bind("languageId") int languageId);

    @SqlQuery("SELECT * FROM film WHERE original_language_id = :originalLanguageId")
    public List<Film> findByOriginalLanguageId(@Bind("originalLanguageId") int originalLanguageId);
}
