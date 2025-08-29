package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Language;

public interface LanguageDao {

    @SqlUpdate("INSERT INTO language (name) VALUES (:name)")
    @GetGeneratedKeys
    public int insert(@Bind("name") String name);

    @SqlQuery("SELECT * FROM language WHERE language_id = :id")
    public Language findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM language")
    public List<Language> findAll();

    @SqlUpdate("UPDATE language SET name = :name WHERE language_id = :languageId")
    public void update(@BindBean Language language);

    @SqlUpdate("DELETE FROM language WHERE language_id = :id")
    public void deleteById(@Bind("id") int id);
}
