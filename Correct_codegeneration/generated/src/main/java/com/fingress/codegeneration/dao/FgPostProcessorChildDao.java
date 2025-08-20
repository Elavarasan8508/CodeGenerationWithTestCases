package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgPostProcessorChild;
import com.bsit.codegeneration.mapper.FgPostProcessorChildMapper;
import java.util.*;

@RegisterRowMapper(FgPostProcessorChildMapper.class)
public interface FgPostProcessorChildDao {

    @SqlQuery("SELECT * FROM FG_POST_PROCESSOR_CHILD")
    public List<FgPostProcessorChild> findAll();

    @SqlQuery("SELECT * FROM FG_POST_PROCESSOR_CHILD WHERE id = :id")
    public Optional<FgPostProcessorChild> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_POST_PROCESSOR_CHILD(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, VALUE1, VALUE2) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :VALUE1, :VALUE2)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgPostProcessorChild entity);

    @SqlQuery("UPDATE FG_POST_PROCESSOR_CHILD SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, VALUE1 = :VALUE1, VALUE2 = :VALUE2 WHERE id = :id")
    public int update(@BindBean() FgPostProcessorChild entity);

    @SqlQuery("DELETE FROM FG_POST_PROCESSOR_CHILD WHERE id = :id")
    public int delete(@Bind("id") String id);
}
