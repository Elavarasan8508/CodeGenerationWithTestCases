package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.TestPostProcessor;
import com.bsit.codegeneration.mapper.TestPostProcessorMapper;
import java.util.*;

@RegisterRowMapper(TestPostProcessorMapper.class)
public interface TestPostProcessorDao {

    @SqlQuery("SELECT * FROM TEST_POST_PROCESSOR")
    public List<TestPostProcessor> findAll();

    @SqlQuery("SELECT * FROM TEST_POST_PROCESSOR WHERE id = :id")
    public Optional<TestPostProcessor> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO TEST_POST_PROCESSOR(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, VALUE1, VALUE2, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :VALUE1, :VALUE2, :ENTITY_TYPE_CODE, :ENTITY_SUB_TYPE_CODE, :ENTITY_REFERENCE_ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() TestPostProcessor entity);

    @SqlQuery("UPDATE TEST_POST_PROCESSOR SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, VALUE1 = :VALUE1, VALUE2 = :VALUE2, ENTITY_TYPE_CODE = :ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE, ENTITY_REFERENCE_ID = :ENTITY_REFERENCE_ID WHERE id = :id")
    public int update(@BindBean() TestPostProcessor entity);

    @SqlQuery("DELETE FROM TEST_POST_PROCESSOR WHERE id = :id")
    public int delete(@Bind("id") String id);
}
