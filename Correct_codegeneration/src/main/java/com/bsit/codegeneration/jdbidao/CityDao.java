package com.bsit.codegeneration.jdbidao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import java.util.List;
import com.jdbi.codegeneration.entity.City;

public interface CityDao {

    @SqlUpdate("INSERT INTO city (city, country_id) VALUES (:city, :countryId)")
    @GetGeneratedKeys
    public int insert(@Bind("city") String city, @Bind("countryId") int countryId);

    @SqlQuery("SELECT * FROM city WHERE city_id = :id")
    public City findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM city")
    public List<City> findAll();

    @SqlUpdate("UPDATE city SET city = :city, country_id = :countryId WHERE city_id = :cityId")
    public void update(@BindBean City city);

    @SqlUpdate("DELETE FROM city WHERE city_id = :id")
    public void deleteById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM city WHERE country_id = :countryId")
    public List<City> findByCountryId(@Bind("countryId") int countryId);
}
