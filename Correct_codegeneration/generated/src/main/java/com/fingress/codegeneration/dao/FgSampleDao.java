package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSample;
import com.bsit.codegeneration.mapper.FgSampleMapper;
import java.util.*;

@RegisterRowMapper(FgSampleMapper.class)
public interface FgSampleDao {

    @SqlQuery("SELECT * FROM FG_SAMPLE")
    public List<FgSample> findAll();

    @SqlQuery("SELECT * FROM FG_SAMPLE WHERE id = :id")
    public Optional<FgSample> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SAMPLE(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, FG_SAMPLE_APP) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :FG_SAMPLE_APP)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSample entity);

    @SqlQuery("UPDATE FG_SAMPLE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, FG_SAMPLE_APP = :FG_SAMPLE_APP WHERE id = :id")
    public int update(@BindBean() FgSample entity);

    @SqlQuery("DELETE FROM FG_SAMPLE WHERE id = :id")
    public int delete(@Bind("id") String id);
}
