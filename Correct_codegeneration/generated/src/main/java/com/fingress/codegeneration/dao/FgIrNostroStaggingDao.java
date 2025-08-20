package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgIrNostroStagging;
import com.bsit.codegeneration.mapper.FgIrNostroStaggingMapper;
import java.util.*;

@RegisterRowMapper(FgIrNostroStaggingMapper.class)
public interface FgIrNostroStaggingDao {

    @SqlQuery("SELECT * FROM FG_IR_NOSTRO_STAGGING")
    public List<FgIrNostroStagging> findAll();

    @SqlQuery("SELECT * FROM FG_IR_NOSTRO_STAGGING WHERE id = :id")
    public Optional<FgIrNostroStagging> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_IR_NOSTRO_STAGGING(ID, NOSTRO_NUMBER, NOSTRO_XML, INSERTED_ON, STATUS, NODE) VALUES (:ID, :NOSTRO_NUMBER, :NOSTRO_XML, :INSERTED_ON, :STATUS, :NODE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgIrNostroStagging entity);

    @SqlQuery("UPDATE FG_IR_NOSTRO_STAGGING SET ID = :ID, NOSTRO_NUMBER = :NOSTRO_NUMBER, NOSTRO_XML = :NOSTRO_XML, INSERTED_ON = :INSERTED_ON, STATUS = :STATUS, NODE = :NODE WHERE id = :id")
    public int update(@BindBean() FgIrNostroStagging entity);

    @SqlQuery("DELETE FROM FG_IR_NOSTRO_STAGGING WHERE id = :id")
    public int delete(@Bind("id") String id);
}
