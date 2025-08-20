package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.Ivs;
import com.bsit.codegeneration.mapper.IvsMapper;
import java.util.*;

@RegisterRowMapper(IvsMapper.class)
public interface IvsDao {

    @SqlQuery("SELECT * FROM IVS")
    public List<Ivs> findAll();

    @SqlQuery("SELECT * FROM IVS WHERE id = :id")
    public Optional<Ivs> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO IVS(ID, SCHEMECODE, DEBITINTEREST) VALUES (:ID, :SCHEMECODE, :DEBITINTEREST)")
    @GetGeneratedKeys()
    public String insert(@BindBean() Ivs entity);

    @SqlQuery("UPDATE IVS SET ID = :ID, SCHEMECODE = :SCHEMECODE, DEBITINTEREST = :DEBITINTEREST WHERE id = :id")
    public int update(@BindBean() Ivs entity);

    @SqlQuery("DELETE FROM IVS WHERE id = :id")
    public int delete(@Bind("id") String id);
}
