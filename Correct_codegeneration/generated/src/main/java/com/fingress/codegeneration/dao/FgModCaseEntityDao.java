package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgModCaseEntity;
import com.bsit.codegeneration.mapper.FgModCaseEntityMapper;
import java.util.*;

@RegisterRowMapper(FgModCaseEntityMapper.class)
public interface FgModCaseEntityDao {

    @SqlQuery("SELECT * FROM FG_MOD_CASE_ENTITY")
    public List<FgModCaseEntity> findAll();

    @SqlQuery("SELECT * FROM FG_MOD_CASE_ENTITY WHERE id = :id")
    public Optional<FgModCaseEntity> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MOD_CASE_ENTITY(ID, VERSION_ID, REFERENCE_ID, APPLICANT_PARTY_CODE, APPLICANT_REF_ID, ISSUING_PARTY_CODE, TYPE_CODE, SUB_TYPE_CODE, PROCESS_ID, TEMPLATE_JSON, ACTIVE_CODE, STATUS_CODE, STAGE_CODE, IS_MASTER_VERSION, CREATED_BY, CREATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, ATTACHMENT_ID) VALUES (:ID, :VERSION_ID, :REFERENCE_ID, :APPLICANT_PARTY_CODE, :APPLICANT_REF_ID, :ISSUING_PARTY_CODE, :TYPE_CODE, :SUB_TYPE_CODE, :PROCESS_ID, :TEMPLATE_JSON, :ACTIVE_CODE, :STATUS_CODE, :STAGE_CODE, :IS_MASTER_VERSION, :CREATED_BY, :CREATED_ON, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON, :LAST_UPDATED_BY, :LAST_UPDATED_ON, :ATTACHMENT_ID)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgModCaseEntity entity);

    @SqlQuery("UPDATE FG_MOD_CASE_ENTITY SET ID = :ID, VERSION_ID = :VERSION_ID, REFERENCE_ID = :REFERENCE_ID, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE, APPLICANT_REF_ID = :APPLICANT_REF_ID, ISSUING_PARTY_CODE = :ISSUING_PARTY_CODE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, PROCESS_ID = :PROCESS_ID, TEMPLATE_JSON = :TEMPLATE_JSON, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, STAGE_CODE = :STAGE_CODE, IS_MASTER_VERSION = :IS_MASTER_VERSION, CREATED_BY = :CREATED_BY, CREATED_ON = :CREATED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, ATTACHMENT_ID = :ATTACHMENT_ID WHERE id = :id")
    public int update(@BindBean() FgModCaseEntity entity);

    @SqlQuery("DELETE FROM FG_MOD_CASE_ENTITY WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
