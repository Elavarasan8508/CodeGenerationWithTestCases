package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgTest01;
import com.bsit.codegeneration.mapper.FgTest01Mapper;
import java.util.*;

@RegisterRowMapper(FgTest01Mapper.class)
public interface FgTest01Dao {

    @SqlQuery("SELECT * FROM FG_TEST_01")
    public List<FgTest01> findAll();

    @SqlQuery("SELECT * FROM FG_TEST_01 WHERE id = :id")
    public Optional<FgTest01> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_TEST_01(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROCESS_ID, TASK_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :PROCESS_ID, :TASK_ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgTest01 entity);

    @SqlQuery("UPDATE FG_TEST_01 SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, PROCESS_ID = :PROCESS_ID, TASK_ID = :TASK_ID WHERE id = :id")
    public int update(@BindBean() FgTest01 entity);

    @SqlQuery("DELETE FROM FG_TEST_01 WHERE id = :id")
    public int delete(@Bind("id") String id);
}
