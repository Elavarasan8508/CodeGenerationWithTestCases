package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.AddInfo;
import com.bsit.codegeneration.mapper.AddInfoMapper;
import java.util.*;

@RegisterRowMapper(AddInfoMapper.class)
public interface AddInfoDao {

    @SqlQuery("SELECT * FROM ADD_INFO")
    public List<AddInfo> findAll();

    @SqlQuery("SELECT * FROM ADD_INFO WHERE id = :id")
    public Optional<AddInfo> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO ADD_INFO(ID, ADDRESS, EMPLOYEE_ID) VALUES (:ID, :ADDRESS, :EMPLOYEE_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() AddInfo entity);

    @SqlQuery("UPDATE ADD_INFO SET ID = :ID, ADDRESS = :ADDRESS, EMPLOYEE_ID = :EMPLOYEE_ID WHERE id = :id")
    public int update(@BindBean() AddInfo entity);

    @SqlQuery("DELETE FROM ADD_INFO WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
