package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Category;

public interface CategoryDao {

    @SqlUpdate("INSERT INTO category (name) VALUES (:name)")
    @GetGeneratedKeys
    public int insert(@Bind("name") String name);

    @SqlQuery("SELECT * FROM category WHERE category_id = :id")
    public Category findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM category")
    public List<Category> findAll();

    @SqlUpdate("UPDATE category SET name = :name WHERE category_id = :categoryId")
    public void update(@BindBean Category category);

    @SqlUpdate("DELETE FROM category WHERE category_id = :id")
    public void deleteById(@Bind("id") int id);
}
