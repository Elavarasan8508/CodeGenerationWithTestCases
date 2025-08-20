package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgNavigation;
import com.bsit.codegeneration.mapper.FgNavigationMapper;
import java.util.*;

@RegisterRowMapper(FgNavigationMapper.class)
public interface FgNavigationDao {

    @SqlQuery("SELECT * FROM FG_NAVIGATION")
    public List<FgNavigation> findAll();

    @SqlQuery("SELECT * FROM FG_NAVIGATION WHERE id = :id")
    public Optional<FgNavigation> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_NAVIGATION(ID, APPLIED_DATE, TYPE_CODE, SUB_TYPE_CODE, NAVIGATION_CONTENT, CREATED_BY, CREATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON) VALUES (:ID, :APPLIED_DATE, :TYPE_CODE, :SUB_TYPE_CODE, :NAVIGATION_CONTENT, :CREATED_BY, :CREATED_ON, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON, :LAST_UPDATED_BY, :LAST_UPDATED_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgNavigation entity);

    @SqlQuery("UPDATE FG_NAVIGATION SET ID = :ID, APPLIED_DATE = :APPLIED_DATE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, NAVIGATION_CONTENT = :NAVIGATION_CONTENT, CREATED_BY = :CREATED_BY, CREATED_ON = :CREATED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON WHERE id = :id")
    public int update(@BindBean() FgNavigation entity);

    @SqlQuery("DELETE FROM FG_NAVIGATION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
