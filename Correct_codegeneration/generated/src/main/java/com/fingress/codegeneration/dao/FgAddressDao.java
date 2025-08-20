package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgAddress;
import com.bsit.codegeneration.mapper.FgAddressMapper;
import java.util.*;

@RegisterRowMapper(FgAddressMapper.class)
public interface FgAddressDao {

    @SqlQuery("SELECT * FROM FG_ADDRESS")
    public List<FgAddress> findAll();

    @SqlQuery("SELECT * FROM FG_ADDRESS WHERE id = :id")
    public Optional<FgAddress> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ADDRESS(ID, ADDRESS_LINE1, ADDRESS_LINE2, ADDRESS_LINE3, COUNTRY_CODE, STATE_CODE, CITY_CODE, LAND_MARK, POST_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, LATITUDE, LONGITUDE, SYS_DEFINED, SYSTEM_SOURCE_CODE) VALUES (:ID, :ADDRESS_LINE1, :ADDRESS_LINE2, :ADDRESS_LINE3, :COUNTRY_CODE, :STATE_CODE, :CITY_CODE, :LAND_MARK, :POST_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :LATITUDE, :LONGITUDE, :SYS_DEFINED, :SYSTEM_SOURCE_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgAddress entity);

    @SqlQuery("UPDATE FG_ADDRESS SET ID = :ID, ADDRESS_LINE1 = :ADDRESS_LINE1, ADDRESS_LINE2 = :ADDRESS_LINE2, ADDRESS_LINE3 = :ADDRESS_LINE3, COUNTRY_CODE = :COUNTRY_CODE, STATE_CODE = :STATE_CODE, CITY_CODE = :CITY_CODE, LAND_MARK = :LAND_MARK, POST_CODE = :POST_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LATITUDE = :LATITUDE, LONGITUDE = :LONGITUDE, SYS_DEFINED = :SYS_DEFINED, SYSTEM_SOURCE_CODE = :SYSTEM_SOURCE_CODE WHERE id = :id")
    public int update(@BindBean() FgAddress entity);

    @SqlQuery("DELETE FROM FG_ADDRESS WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
