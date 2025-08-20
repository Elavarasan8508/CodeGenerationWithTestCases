package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgFinanceReverseUpdate;
import com.bsit.codegeneration.mapper.FgFinanceReverseUpdateMapper;
import java.util.*;

@RegisterRowMapper(FgFinanceReverseUpdateMapper.class)
public interface FgFinanceReverseUpdateDao {

    @SqlQuery("SELECT * FROM FG_FINANCE_REVERSE_UPDATE")
    public List<FgFinanceReverseUpdate> findAll();

    @SqlQuery("SELECT * FROM FG_FINANCE_REVERSE_UPDATE WHERE id = :id")
    public Optional<FgFinanceReverseUpdate> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_FINANCE_REVERSE_UPDATE(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, PROCESS_ID, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE, IS_TEMPLATE, FIN_FILE_CONTENT, UPLOAD_REF_ID, FINANCE_FILE_NAME, BATCH_REF_ID, EVENT_NAME) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :PROCESS_ID, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :APPLICANT_PARTY_CODE, :ISSUING_PARTY_CODE, :IS_TEMPLATE, :FIN_FILE_CONTENT, :UPLOAD_REF_ID, :FINANCE_FILE_NAME, :BATCH_REF_ID, :EVENT_NAME)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgFinanceReverseUpdate entity);

    @SqlQuery("UPDATE FG_FINANCE_REVERSE_UPDATE SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, PROCESS_ID = :PROCESS_ID, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, IS_TEMPLATE = :IS_TEMPLATE, FIN_FILE_CONTENT = :FIN_FILE_CONTENT, UPLOAD_REF_ID = :UPLOAD_REF_ID, FINANCE_FILE_NAME = :FINANCE_FILE_NAME, BATCH_REF_ID = :BATCH_REF_ID, EVENT_NAME = :EVENT_NAME WHERE id = :id")
    public int update(@BindBean() FgFinanceReverseUpdate entity);

    @SqlQuery("DELETE FROM FG_FINANCE_REVERSE_UPDATE WHERE id = :id")
    public int delete(@Bind("id") String id);
}
