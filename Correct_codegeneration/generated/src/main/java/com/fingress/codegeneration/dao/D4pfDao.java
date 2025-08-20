package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.D4pf;
import com.bsit.codegeneration.mapper.D4pfMapper;
import java.util.*;

@RegisterRowMapper(D4pfMapper.class)
public interface D4pfDao {

    @SqlQuery("SELECT * FROM D4PF")
    public List<D4pf> findAll();

    @SqlQuery("SELECT * FROM D4PF WHERE id = :id")
    public Optional<D4pf> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO D4PF(D4BRANCH, D4BRR, D4DFLG, D4DTEH, D4DTE, D4BRAR, D4DLM, MNT_IN_BO) VALUES (:D4BRANCH, :D4BRR, :D4DFLG, :D4DTEH, :D4DTE, :D4BRAR, :D4DLM, :MNT_IN_BO)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() D4pf entity);

    @SqlQuery("UPDATE D4PF SET D4BRANCH = :D4BRANCH, D4BRR = :D4BRR, D4DFLG = :D4DFLG, D4DTEH = :D4DTEH, D4DTE = :D4DTE, D4BRAR = :D4BRAR, D4DLM = :D4DLM, MNT_IN_BO = :MNT_IN_BO WHERE id = :id")
    public int update(@BindBean() D4pf entity);

    @SqlQuery("DELETE FROM D4PF WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
