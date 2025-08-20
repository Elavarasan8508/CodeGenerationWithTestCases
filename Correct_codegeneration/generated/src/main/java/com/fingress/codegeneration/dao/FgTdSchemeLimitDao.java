package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTdSchemeLimit;
import com.bsit.codegeneration.mapper.FgTdSchemeLimitMapper;
import java.util.*;

@RegisterRowMapper(FgTdSchemeLimitMapper.class)
public interface FgTdSchemeLimitDao {

    @SqlQuery("SELECT * FROM FG_TD_SCHEME_LIMIT")
    public List<FgTdSchemeLimit> findAll();

    @SqlQuery("SELECT * FROM FG_TD_SCHEME_LIMIT WHERE id = :id")
    public Optional<FgTdSchemeLimit> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TD_SCHEME_LIMIT(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, TENOR_START_DAYS, TENOR_END_DAYS, TENOR_MIN_AMOUNT, TENOR_MAX_AMOUNT, VALUE_DATE, PARENT_REF_ID, PARENT_VERSION_ID, VERSION_ID, IS_MASTER_VERSION, TASK_REASON) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :TENOR_START_DAYS, :TENOR_END_DAYS, :TENOR_MIN_AMOUNT, :TENOR_MAX_AMOUNT, :VALUE_DATE, :PARENT_REF_ID, :PARENT_VERSION_ID, :VERSION_ID, :IS_MASTER_VERSION, :TASK_REASON)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTdSchemeLimit entity);

    @SqlQuery("UPDATE FG_TD_SCHEME_LIMIT SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, TENOR_START_DAYS = :TENOR_START_DAYS, TENOR_END_DAYS = :TENOR_END_DAYS, TENOR_MIN_AMOUNT = :TENOR_MIN_AMOUNT, TENOR_MAX_AMOUNT = :TENOR_MAX_AMOUNT, VALUE_DATE = :VALUE_DATE, PARENT_REF_ID = :PARENT_REF_ID, PARENT_VERSION_ID = :PARENT_VERSION_ID, VERSION_ID = :VERSION_ID, IS_MASTER_VERSION = :IS_MASTER_VERSION, TASK_REASON = :TASK_REASON WHERE id = :id")
    public int update(@BindBean() FgTdSchemeLimit entity);

    @SqlQuery("DELETE FROM FG_TD_SCHEME_LIMIT WHERE id = :id")
    public int delete(@Bind("id") String id);
}
