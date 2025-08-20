package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgReportTemplate;
import com.bsit.codegeneration.mapper.FgReportTemplateMapper;
import java.util.*;

@RegisterRowMapper(FgReportTemplateMapper.class)
public interface FgReportTemplateDao {

    @SqlQuery("SELECT * FROM FG_REPORT_TEMPLATE")
    public List<FgReportTemplate> findAll();

    @SqlQuery("SELECT * FROM FG_REPORT_TEMPLATE WHERE id = :id")
    public Optional<FgReportTemplate> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_REPORT_TEMPLATE(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, PARTY_CODE, TEMPLATE_TYPE, REPORT_TYPE, FILE_NAME, FILE_TYPE, FILE_SIZE, TEMPLATE_VALUE, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, NAME, ATTACHMENT_ID) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :PARTY_CODE, :TEMPLATE_TYPE, :REPORT_TYPE, :FILE_NAME, :FILE_TYPE, :FILE_SIZE, :TEMPLATE_VALUE, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :NAME, :ATTACHMENT_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgReportTemplate entity);

    @SqlQuery("UPDATE FG_REPORT_TEMPLATE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, PARTY_CODE = :PARTY_CODE, TEMPLATE_TYPE = :TEMPLATE_TYPE, REPORT_TYPE = :REPORT_TYPE, FILE_NAME = :FILE_NAME, FILE_TYPE = :FILE_TYPE, FILE_SIZE = :FILE_SIZE, TEMPLATE_VALUE = :TEMPLATE_VALUE, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, NAME = :NAME, ATTACHMENT_ID = :ATTACHMENT_ID WHERE id = :id")
    public int update(@BindBean() FgReportTemplate entity);

    @SqlQuery("DELETE FROM FG_REPORT_TEMPLATE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
