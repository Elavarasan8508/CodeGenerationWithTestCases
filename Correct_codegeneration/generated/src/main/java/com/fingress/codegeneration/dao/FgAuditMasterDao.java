package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgAuditMaster;
import com.bsit.codegeneration.mapper.FgAuditMasterMapper;
import java.util.*;

@RegisterRowMapper(FgAuditMasterMapper.class)
public interface FgAuditMasterDao {

    @SqlQuery("SELECT * FROM FG_AUDIT_MASTER")
    public List<FgAuditMaster> findAll();

    @SqlQuery("SELECT * FROM FG_AUDIT_MASTER WHERE id = :id")
    public Optional<FgAuditMaster> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_AUDIT_MASTER(UUID, PARTY_CODE, USER_CODE, CATEGORY_CODE, TYPE_CODE, SOURCE, ENDPOINT_CODE, ENTITY_CODE, EVENT_CODE, SERVERITY_CODE, STATUS_CODE, OCCURED_ON, SESSION_ID, SESSION_ADDRESS, ENTITY_REF_ID, REL_ORG_CODE, REL_ORG_SUB_TYPE_CODE, REL_ORG_TYPE_CODE, REL_ORG_PARENT_CODE, TOKEN_VALUE, ENDS_ON) VALUES (:UUID, :PARTY_CODE, :USER_CODE, :CATEGORY_CODE, :TYPE_CODE, :SOURCE, :ENDPOINT_CODE, :ENTITY_CODE, :EVENT_CODE, :SERVERITY_CODE, :STATUS_CODE, :OCCURED_ON, :SESSION_ID, :SESSION_ADDRESS, :ENTITY_REF_ID, :REL_ORG_CODE, :REL_ORG_SUB_TYPE_CODE, :REL_ORG_TYPE_CODE, :REL_ORG_PARENT_CODE, :TOKEN_VALUE, :ENDS_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgAuditMaster entity);

    @SqlQuery("UPDATE FG_AUDIT_MASTER SET UUID = :UUID, PARTY_CODE = :PARTY_CODE, USER_CODE = :USER_CODE, CATEGORY_CODE = :CATEGORY_CODE, TYPE_CODE = :TYPE_CODE, SOURCE = :SOURCE, ENDPOINT_CODE = :ENDPOINT_CODE, ENTITY_CODE = :ENTITY_CODE, EVENT_CODE = :EVENT_CODE, SERVERITY_CODE = :SERVERITY_CODE, STATUS_CODE = :STATUS_CODE, OCCURED_ON = :OCCURED_ON, SESSION_ID = :SESSION_ID, SESSION_ADDRESS = :SESSION_ADDRESS, ENTITY_REF_ID = :ENTITY_REF_ID, REL_ORG_CODE = :REL_ORG_CODE, REL_ORG_SUB_TYPE_CODE = :REL_ORG_SUB_TYPE_CODE, REL_ORG_TYPE_CODE = :REL_ORG_TYPE_CODE, REL_ORG_PARENT_CODE = :REL_ORG_PARENT_CODE, TOKEN_VALUE = :TOKEN_VALUE, ENDS_ON = :ENDS_ON WHERE id = :id")
    public int update(@BindBean() FgAuditMaster entity);

    @SqlQuery("DELETE FROM FG_AUDIT_MASTER WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
