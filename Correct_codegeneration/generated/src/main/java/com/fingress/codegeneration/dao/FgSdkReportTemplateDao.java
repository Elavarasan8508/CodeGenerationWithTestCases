package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSdkReportTemplate;
import com.bsit.codegeneration.mapper.FgSdkReportTemplateMapper;
import java.util.*;

@RegisterRowMapper(FgSdkReportTemplateMapper.class)
public interface FgSdkReportTemplateDao {

    @SqlQuery("SELECT * FROM FG_SDK_REPORT_TEMPLATE")
    public List<FgSdkReportTemplate> findAll();

    @SqlQuery("SELECT * FROM FG_SDK_REPORT_TEMPLATE WHERE id = :id")
    public Optional<FgSdkReportTemplate> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SDK_REPORT_TEMPLATE(ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, PARTY_CODE, REPORT_TYPE, STATUS, ENTITY_SUB_TYPE_CODE, REPORT_ENGINE, FILE_TEMPLATE, NAME) VALUES (:ID, :REFERENCE_ID, :APPLICANT_PARTY_CODE, :APPLICANT_REF_ID, :ISSUING_PARTY_CODE, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :PARTY_CODE, :REPORT_TYPE, :STATUS, :ENTITY_SUB_TYPE_CODE, :REPORT_ENGINE, :FILE_TEMPLATE, :NAME)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSdkReportTemplate entity);

    @SqlQuery("UPDATE FG_SDK_REPORT_TEMPLATE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, APPLICANT_REF_ID = :APPLICANT_REF_ID, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, PARTY_CODE = :PARTY_CODE, REPORT_TYPE = :REPORT_TYPE, STATUS = :STATUS, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE, REPORT_ENGINE = :REPORT_ENGINE, FILE_TEMPLATE = :FILE_TEMPLATE, NAME = :NAME WHERE id = :id")
    public int update(@BindBean() FgSdkReportTemplate entity);

    @SqlQuery("DELETE FROM FG_SDK_REPORT_TEMPLATE WHERE id = :id")
    public int delete(@Bind("id") String id);
}
