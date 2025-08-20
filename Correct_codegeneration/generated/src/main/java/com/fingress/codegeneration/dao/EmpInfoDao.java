package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.EmpInfo;
import com.bsit.codegeneration.mapper.EmpInfoMapper;
import java.util.*;

@RegisterRowMapper(EmpInfoMapper.class)
public interface EmpInfoDao {

    @SqlQuery("SELECT * FROM EMP_INFO")
    public List<EmpInfo> findAll();

    @SqlQuery("SELECT * FROM EMP_INFO WHERE id = :id")
    public Optional<EmpInfo> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO EMP_INFO(ID, NAME) VALUES (:ID, :NAME)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() EmpInfo entity);

    @SqlQuery("UPDATE EMP_INFO SET ID = :ID, NAME = :NAME WHERE id = :id")
    public int update(@BindBean() EmpInfo entity);

    @SqlQuery("DELETE FROM EMP_INFO WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
