package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.NonLongTable;
import com.bsit.codegeneration.mapper.NonLongTableMapper;
import java.util.*;

@RegisterRowMapper(NonLongTableMapper.class)
public interface NonLongTableDao {

    @SqlQuery("SELECT * FROM NON_LONG_TABLE")
    public List<NonLongTable> findAll();

    @SqlQuery("SELECT * FROM NON_LONG_TABLE WHERE id = :id")
    public Optional<NonLongTable> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO NON_LONG_TABLE(ID, PRICE) VALUES (:ID, :PRICE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() NonLongTable entity);

    @SqlQuery("UPDATE NON_LONG_TABLE SET ID = :ID, PRICE = :PRICE WHERE id = :id")
    public int update(@BindBean() NonLongTable entity);

    @SqlQuery("DELETE FROM NON_LONG_TABLE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
