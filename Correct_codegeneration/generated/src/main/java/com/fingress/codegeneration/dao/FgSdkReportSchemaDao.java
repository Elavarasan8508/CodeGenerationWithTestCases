package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSdkReportSchema;
import com.bsit.codegeneration.mapper.FgSdkReportSchemaMapper;
import java.util.*;

@RegisterRowMapper(FgSdkReportSchemaMapper.class)
public interface FgSdkReportSchemaDao {

    @SqlQuery("SELECT * FROM FG_SDK_REPORT_SCHEMA")
    public List<FgSdkReportSchema> findAll();

    @SqlQuery("SELECT * FROM FG_SDK_REPORT_SCHEMA WHERE id = :id")
    public Optional<FgSdkReportSchema> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SDK_REPORT_SCHEMA(ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PROCESS_ID, MODEL_PROPERTIES, NAME, DESCRIPTION, TYPE, ENTITY_SUB_TYPE_CODE) VALUES (:ID, :REFERENCE_ID, :APPLICANT_PARTY_CODE, :APPLICANT_REF_ID, :ISSUING_PARTY_CODE, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :PROCESS_ID, :MODEL_PROPERTIES, :NAME, :DESCRIPTION, :TYPE, :ENTITY_SUB_TYPE_CODE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSdkReportSchema entity);

    @SqlQuery("UPDATE FG_SDK_REPORT_SCHEMA SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, APPLICANT_REF_ID = :APPLICANT_REF_ID, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, PROCESS_ID = :PROCESS_ID, MODEL_PROPERTIES = :MODEL_PROPERTIES, NAME = :NAME, DESCRIPTION = :DESCRIPTION, TYPE = :TYPE, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE WHERE id = :id")
    public int update(@BindBean() FgSdkReportSchema entity);

    @SqlQuery("DELETE FROM FG_SDK_REPORT_SCHEMA WHERE id = :id")
    public int delete(@Bind("id") String id);
}
