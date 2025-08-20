package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.LongTable;
import com.bsit.codegeneration.mapper.LongTableMapper;
import java.util.*;

@RegisterRowMapper(LongTableMapper.class)
public interface LongTableDao {

    @SqlQuery("SELECT * FROM LONG_TABLE")
    public List<LongTable> findAll();

    @SqlQuery("SELECT * FROM LONG_TABLE WHERE id = :id")
    public Optional<LongTable> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO LONG_TABLE(ID, LONG_COLUMN) VALUES (:ID, :LONG_COLUMN)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() LongTable entity);

    @SqlQuery("UPDATE LONG_TABLE SET ID = :ID, LONG_COLUMN = :LONG_COLUMN WHERE id = :id")
    public int update(@BindBean() LongTable entity);

    @SqlQuery("DELETE FROM LONG_TABLE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
