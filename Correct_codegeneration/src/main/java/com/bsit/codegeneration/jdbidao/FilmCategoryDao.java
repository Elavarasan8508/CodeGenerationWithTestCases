package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.FilmCategory;

public interface FilmCategoryDao {

    @SqlUpdate("INSERT INTO film_category (category_id, film_id) VALUES (:categoryId, :filmId)")
    public void insert(@Bind("categoryId") int categoryId, @Bind("filmId") int filmId);

    @SqlQuery("SELECT * FROM film_category WHERE category_id = :categoryId AND film_id = :filmId")
    public FilmCategory findByCategoryAndFilm(@Bind("categoryId") int categoryId, @Bind("filmId") int filmId);

    @SqlQuery("SELECT * FROM film_category WHERE category_id = :categoryId")
    public List<FilmCategory> findByCategoryId(@Bind("categoryId") int categoryId);

    @SqlQuery("SELECT * FROM film_category WHERE film_id = :filmId")
    public List<FilmCategory> findByFilmId(@Bind("filmId") int filmId);

    @SqlUpdate("DELETE FROM film_category WHERE category_id = :categoryId AND film_id = :filmId")
    public void delete(@Bind("categoryId") int categoryId, @Bind("filmId") int filmId);
}
