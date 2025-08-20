package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.BoeMaster;
import com.bsit.codegeneration.mapper.BoeMasterMapper;
import java.util.*;

@RegisterRowMapper(BoeMasterMapper.class)
public interface BoeMasterDao {

    @SqlQuery("SELECT * FROM BOE_MASTER")
    public List<BoeMaster> findAll();

    @SqlQuery("SELECT * FROM BOE_MASTER WHERE id = :id")
    public Optional<BoeMaster> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO BOE_MASTER(BOE_NUMBER, AD_CODE_ID) VALUES (:BOE_NUMBER, :AD_CODE_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() BoeMaster entity);

    @SqlQuery("UPDATE BOE_MASTER SET BOE_NUMBER = :BOE_NUMBER, AD_CODE_ID = :AD_CODE_ID WHERE id = :id")
    public int update(@BindBean() BoeMaster entity);

    @SqlQuery("DELETE FROM BOE_MASTER WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
