package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgActRuMeterLog;
import com.bsit.codegeneration.mapper.FgActRuMeterLogMapper;
import java.util.*;

@RegisterRowMapper(FgActRuMeterLogMapper.class)
public interface FgActRuMeterLogDao {

    @SqlQuery("SELECT * FROM FG_ACT_RU_METER_LOG")
    public List<FgActRuMeterLog> findAll();

    @SqlQuery("SELECT * FROM FG_ACT_RU_METER_LOG WHERE id = :id")
    public Optional<FgActRuMeterLog> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ACT_RU_METER_LOG(ID_, NAME_, REPORTER_, VALUE_, TIMESTAMP_, MILLISECONDS_) VALUES (:ID_, :NAME_, :REPORTER_, :VALUE_, :TIMESTAMP_, :MILLISECONDS_)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgActRuMeterLog entity);

    @SqlQuery("UPDATE FG_ACT_RU_METER_LOG SET ID_ = :ID_, NAME_ = :NAME_, REPORTER_ = :REPORTER_, VALUE_ = :VALUE_, TIMESTAMP_ = :TIMESTAMP_, MILLISECONDS_ = :MILLISECONDS_ WHERE id = :id")
    public int update(@BindBean() FgActRuMeterLog entity);

    @SqlQuery("DELETE FROM FG_ACT_RU_METER_LOG WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
