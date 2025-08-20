package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTdConfiguration;
import com.bsit.codegeneration.mapper.FgTdConfigurationMapper;
import java.util.*;

@RegisterRowMapper(FgTdConfigurationMapper.class)
public interface FgTdConfigurationDao {

    @SqlQuery("SELECT * FROM FG_TD_CONFIGURATION")
    public List<FgTdConfiguration> findAll();

    @SqlQuery("SELECT * FROM FG_TD_CONFIGURATION WHERE id = :id")
    public Optional<FgTdConfiguration> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TD_CONFIGURATION(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, CONFIG_NAME, VERSION_ID, IS_MASTER_VERSION, CONFIG_NAME_DISPLAY) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :CONFIG_NAME, :VERSION_ID, :IS_MASTER_VERSION, :CONFIG_NAME_DISPLAY)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTdConfiguration entity);

    @SqlQuery("UPDATE FG_TD_CONFIGURATION SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, CONFIG_NAME = :CONFIG_NAME, VERSION_ID = :VERSION_ID, IS_MASTER_VERSION = :IS_MASTER_VERSION, CONFIG_NAME_DISPLAY = :CONFIG_NAME_DISPLAY WHERE id = :id")
    public int update(@BindBean() FgTdConfiguration entity);

    @SqlQuery("DELETE FROM FG_TD_CONFIGURATION WHERE id = :id")
    public int delete(@Bind("id") String id);
}
