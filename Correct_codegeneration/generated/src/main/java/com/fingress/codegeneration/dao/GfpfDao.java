package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.Gfpf;
import com.bsit.codegeneration.mapper.GfpfMapper;
import java.util.*;

@RegisterRowMapper(GfpfMapper.class)
public interface GfpfDao {

    @SqlQuery("SELECT * FROM GFPF")
    public List<Gfpf> findAll();

    @SqlQuery("SELECT * FROM GFPF WHERE id = :id")
    public Optional<Gfpf> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO GFPF(IE_CODE, CIF) VALUES (:IE_CODE, :CIF)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() Gfpf entity);

    @SqlQuery("UPDATE GFPF SET IE_CODE = :IE_CODE, CIF = :CIF WHERE id = :id")
    public int update(@BindBean() Gfpf entity);

    @SqlQuery("DELETE FROM GFPF WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
