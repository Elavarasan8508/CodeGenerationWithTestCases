package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgLocalization;
import com.bsit.codegeneration.mapper.FgLocalizationMapper;
import java.util.*;

@RegisterRowMapper(FgLocalizationMapper.class)
public interface FgLocalizationDao {

    @SqlQuery("SELECT * FROM FG_LOCALIZATION")
    public List<FgLocalization> findAll();

    @SqlQuery("SELECT * FROM FG_LOCALIZATION WHERE id = :id")
    public Optional<FgLocalization> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_LOCALIZATION(LOC_TYPE, LOC_KEY, LOCALE, LOC_VALUE, ID) VALUES (:LOC_TYPE, :LOC_KEY, :LOCALE, :LOC_VALUE, :ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgLocalization entity);

    @SqlQuery("UPDATE FG_LOCALIZATION SET LOC_TYPE = :LOC_TYPE, LOC_KEY = :LOC_KEY, LOCALE = :LOCALE, LOC_VALUE = :LOC_VALUE, ID = :ID WHERE id = :id")
    public int update(@BindBean() FgLocalization entity);

    @SqlQuery("DELETE FROM FG_LOCALIZATION WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
