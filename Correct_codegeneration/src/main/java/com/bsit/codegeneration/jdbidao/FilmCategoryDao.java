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
import com.bsit.codegeneration.entity.FilmCategory;

public interface FilmCategoryDao {

    /**
     * Inserts a new join record and returns the number of affected rows.
     */
    @SqlUpdate("INSERT INTO film_category (category_id, film_id) VALUES (:categoryId, :filmId)")
    public int insert(@Bind("categoryId") int categoryId, @Bind("filmId") int filmId);

    /**
     * Finds join records by categoryId.
     */
    @SqlQuery("SELECT * FROM film_category WHERE category_id = :categoryId")
    @RegisterBeanMapper(FilmCategory.class)
    public List<FilmCategory> findByCategoryId(@Bind("categoryId") int categoryId);

    /**
     * Finds join records by filmId.
     */
    @SqlQuery("SELECT * FROM film_category WHERE film_id = :filmId")
    @RegisterBeanMapper(FilmCategory.class)
    public List<FilmCategory> findByFilmId(@Bind("filmId") int filmId);

    /**
     * Deletes a join record and returns the number of affected rows.
     */
    @SqlUpdate("DELETE FROM film_category WHERE category_id = :categoryId AND film_id = :filmId")
    public int delete(@Bind("categoryId") int categoryId, @Bind("filmId") int filmId);

    /**
     * Bulk insert join records and returns affected row counts for each.
     */
    @SqlBatch("INSERT INTO film_category (category_id, film_id) VALUES (:categoryId, :filmId)")
    public int[] bulkInsert(@Bind("categoryId") List<Integer> categoryIds, @Bind("filmId") List<Integer> filmIds);

    /**
     * Bulk delete join records and returns affected row counts for each.
     */
    @SqlBatch("DELETE FROM film_category WHERE category_id = :categoryId AND film_id = :filmId")
    public int[] bulkDelete(@Bind("categoryId") List<Integer> categoryIds, @Bind("filmId") List<Integer> filmIds);
}
