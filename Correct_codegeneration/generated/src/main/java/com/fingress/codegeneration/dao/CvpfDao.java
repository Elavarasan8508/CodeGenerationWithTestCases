package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.Cvpf;
import com.bsit.codegeneration.mapper.CvpfMapper;
import java.util.*;

@RegisterRowMapper(CvpfMapper.class)
public interface CvpfDao {

    @SqlQuery("SELECT * FROM CVPF")
    public List<Cvpf> findAll();

    @SqlQuery("SELECT * FROM CVPF WHERE id = :id")
    public Optional<Cvpf> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO CVPF(CVYOC, CVCCY, CVCNA, CVCLD, CVDIW, CVDIY, CVDOO, MNT_IN_BO) VALUES (:CVYOC, :CVCCY, :CVCNA, :CVCLD, :CVDIW, :CVDIY, :CVDOO, :MNT_IN_BO)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() Cvpf entity);

    @SqlQuery("UPDATE CVPF SET CVYOC = :CVYOC, CVCCY = :CVCCY, CVCNA = :CVCNA, CVCLD = :CVCLD, CVDIW = :CVDIW, CVDIY = :CVDIY, CVDOO = :CVDOO, MNT_IN_BO = :MNT_IN_BO WHERE id = :id")
    public int update(@BindBean() Cvpf entity);

    @SqlQuery("DELETE FROM CVPF WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
