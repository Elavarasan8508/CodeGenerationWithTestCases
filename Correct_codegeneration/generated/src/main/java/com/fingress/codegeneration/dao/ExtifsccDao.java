package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.Extifscc;
import com.bsit.codegeneration.mapper.ExtifsccMapper;
import java.util.*;

@RegisterRowMapper(ExtifsccMapper.class)
public interface ExtifsccDao {

    @SqlQuery("SELECT * FROM EXTIFSCC")
    public List<Extifscc> findAll();

    @SqlQuery("SELECT * FROM EXTIFSCC WHERE id = :id")
    public Optional<Extifscc> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO EXTIFSCC(IFSCSN, IFSC, BANK, BRANCH, BRAADD, CITY, STATE, RTGS) VALUES (:IFSCSN, :IFSC, :BANK, :BRANCH, :BRAADD, :CITY, :STATE, :RTGS)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() Extifscc entity);

    @SqlQuery("UPDATE EXTIFSCC SET IFSCSN = :IFSCSN, IFSC = :IFSC, BANK = :BANK, BRANCH = :BRANCH, BRAADD = :BRAADD, CITY = :CITY, STATE = :STATE, RTGS = :RTGS WHERE id = :id")
    public int update(@BindBean() Extifscc entity);

    @SqlQuery("DELETE FROM EXTIFSCC WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
