package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.TestTable;
import com.bsit.codegeneration.mapper.TestTableMapper;
import java.util.*;

@RegisterRowMapper(TestTableMapper.class)
public interface TestTableDao {

    @SqlQuery("SELECT * FROM TEST_TABLE")
    public List<TestTable> findAll();

    @SqlQuery("SELECT * FROM TEST_TABLE WHERE id = :id")
    public Optional<TestTable> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO TEST_TABLE(ID, LONG_DATA) VALUES (:ID, :LONG_DATA)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() TestTable entity);

    @SqlQuery("UPDATE TEST_TABLE SET ID = :ID, LONG_DATA = :LONG_DATA WHERE id = :id")
    public int update(@BindBean() TestTable entity);

    @SqlQuery("DELETE FROM TEST_TABLE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
