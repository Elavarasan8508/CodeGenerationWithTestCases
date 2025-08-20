package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgAlertCode;
import com.bsit.codegeneration.mapper.FgAlertCodeMapper;
import java.util.*;

@RegisterRowMapper(FgAlertCodeMapper.class)
public interface FgAlertCodeDao {

    @SqlQuery("SELECT * FROM FG_ALERT_CODE")
    public List<FgAlertCode> findAll();

    @SqlQuery("SELECT * FROM FG_ALERT_CODE WHERE id = :id")
    public Optional<FgAlertCode> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_ALERT_CODE(ID, ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, NAME, TEMPLATE, TYPE_CODE, SUB_TYPE_CODE, DESCRIPTION, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, PROCESS_ID, REFERENCE_ID, PARTY_ID, PARTY_VERSION_ID, VERSION_ID, IS_MASTER_VERSION, STAGE_CODE, APPLICANT_PARTY_CODE) VALUES (:ID, :ENTITY_SUB_TYPE_CODE, :ENTITY_TYPE_CODE, :NAME, :TEMPLATE, :TYPE_CODE, :SUB_TYPE_CODE, :DESCRIPTION, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :PROCESS_ID, :REFERENCE_ID, :PARTY_ID, :PARTY_VERSION_ID, :VERSION_ID, :IS_MASTER_VERSION, :STAGE_CODE, :APPLICANT_PARTY_CODE)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgAlertCode entity);

    @SqlQuery("UPDATE FG_ALERT_CODE SET ID = :ID, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE, ENTITY_TYPE_CODE = :ENTITY_TYPE_CODE, NAME = :NAME, TEMPLATE = :TEMPLATE, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, DESCRIPTION = :DESCRIPTION, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, PROCESS_ID = :PROCESS_ID, REFERENCE_ID = :REFERENCE_ID, PARTY_ID = :PARTY_ID, PARTY_VERSION_ID = :PARTY_VERSION_ID, VERSION_ID = :VERSION_ID, IS_MASTER_VERSION = :IS_MASTER_VERSION, STAGE_CODE = :STAGE_CODE, APPLICANT_PARTY_CODE = :APPLICANT_PARTY_CODE WHERE id = :id")
    public int update(@BindBean() FgAlertCode entity);

    @SqlQuery("DELETE FROM FG_ALERT_CODE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
