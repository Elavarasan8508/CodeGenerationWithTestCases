package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgRules;
import com.bsit.codegeneration.mapper.FgRulesMapper;
import java.util.*;

@RegisterRowMapper(FgRulesMapper.class)
public interface FgRulesDao {

    @SqlQuery("SELECT * FROM FG_RULES")
    public List<FgRules> findAll();

    @SqlQuery("SELECT * FROM FG_RULES WHERE id = :id")
    public Optional<FgRules> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_RULES(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, NAME, DESCRIPTION, TYPE, GUIDANCE, SEVERITY, CONDITION, CONFIG_KEY, KEY_VALUE, COUNT, COLUMN_DATA, DATA_SOURCE, DATA_SET) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :NAME, :DESCRIPTION, :TYPE, :GUIDANCE, :SEVERITY, :CONDITION, :CONFIG_KEY, :KEY_VALUE, :COUNT, :COLUMN_DATA, :DATA_SOURCE, :DATA_SET)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgRules entity);

    @SqlQuery("UPDATE FG_RULES SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, NAME = :NAME, DESCRIPTION = :DESCRIPTION, TYPE = :TYPE, GUIDANCE = :GUIDANCE, SEVERITY = :SEVERITY, CONDITION = :CONDITION, CONFIG_KEY = :CONFIG_KEY, KEY_VALUE = :KEY_VALUE, COUNT = :COUNT, COLUMN_DATA = :COLUMN_DATA, DATA_SOURCE = :DATA_SOURCE, DATA_SET = :DATA_SET WHERE id = :id")
    public int update(@BindBean() FgRules entity);

    @SqlQuery("DELETE FROM FG_RULES WHERE id = :id")
    public int delete(@Bind("id") String id);
}
