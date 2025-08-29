package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.Country;

public interface CountryDao {

    @SqlUpdate("INSERT INTO country (country) VALUES (:country)")
    @GetGeneratedKeys
    public int insert(@Bind("country") String country);

    @SqlQuery("SELECT * FROM country WHERE country_id = :id")
    public Country findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM country")
    public List<Country> findAll();

    @SqlUpdate("UPDATE country SET country = :country WHERE country_id = :countryId")
    public void update(@BindBean Country country);

    @SqlUpdate("DELETE FROM country WHERE country_id = :id")
    public void deleteById(@Bind("id") int id);
}
