package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgLmsDelinquencyScheme;
import com.bsit.codegeneration.mapper.FgLmsDelinquencySchemeMapper;
import java.util.*;

@RegisterRowMapper(FgLmsDelinquencySchemeMapper.class)
public interface FgLmsDelinquencySchemeDao {

    @SqlQuery("SELECT * FROM FG_LMS_DELINQUENCY_SCHEME")
    public List<FgLmsDelinquencyScheme> findAll();

    @SqlQuery("SELECT * FROM FG_LMS_DELINQUENCY_SCHEME WHERE id = :id")
    public Optional<FgLmsDelinquencyScheme> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_LMS_DELINQUENCY_SCHEME(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY, FULFILLMENT_PARTY, IS_TEMPLATE, DELINQUENCY_SCHEME_CODE, DELINQUENCY_NAME, ASSET_CLASSIFICATION, VERSION_ID, IS_MASTER_VERSION) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY, :FULFILLMENT_PARTY, :IS_TEMPLATE, :DELINQUENCY_SCHEME_CODE, :DELINQUENCY_NAME, :ASSET_CLASSIFICATION, :VERSION_ID, :IS_MASTER_VERSION)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgLmsDelinquencyScheme entity);

    @SqlQuery("UPDATE FG_LMS_DELINQUENCY_SCHEME SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY = :APPLICANT_PARTY, FULFILLMENT_PARTY = :FULFILLMENT_PARTY, IS_TEMPLATE = :IS_TEMPLATE, DELINQUENCY_SCHEME_CODE = :DELINQUENCY_SCHEME_CODE, DELINQUENCY_NAME = :DELINQUENCY_NAME, ASSET_CLASSIFICATION = :ASSET_CLASSIFICATION, VERSION_ID = :VERSION_ID, IS_MASTER_VERSION = :IS_MASTER_VERSION WHERE id = :id")
    public int update(@BindBean() FgLmsDelinquencyScheme entity);

    @SqlQuery("DELETE FROM FG_LMS_DELINQUENCY_SCHEME WHERE id = :id")
    public int delete(@Bind("id") String id);
}
