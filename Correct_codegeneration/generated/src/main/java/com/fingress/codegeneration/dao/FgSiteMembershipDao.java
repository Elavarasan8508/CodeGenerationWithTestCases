package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgSiteMembership;
import com.bsit.codegeneration.mapper.FgSiteMembershipMapper;
import java.util.*;

@RegisterRowMapper(FgSiteMembershipMapper.class)
public interface FgSiteMembershipDao {

    @SqlQuery("SELECT * FROM FG_SITE_MEMBERSHIP")
    public List<FgSiteMembership> findAll();

    @SqlQuery("SELECT * FROM FG_SITE_MEMBERSHIP WHERE id = :id")
    public Optional<FgSiteMembership> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_SITE_MEMBERSHIP(ID, REFERENCE_ID, TYPE_CODE, SUB_TYPE_CODE, ACTIVE_CODE, STAGE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, TEMPLATE, IS_TEMPLATE, ORGANIZATION_CODE, SITE_CODE, ROLE) VALUES (:ID, :REFERENCE_ID, :TYPE_CODE, :SUB_TYPE_CODE, :ACTIVE_CODE, :STAGE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :TEMPLATE, :IS_TEMPLATE, :ORGANIZATION_CODE, :SITE_CODE, :ROLE)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgSiteMembership entity);

    @SqlQuery("UPDATE FG_SITE_MEMBERSHIP SET ID = :ID, REFERENCE_ID = :REFERENCE_ID, TYPE_CODE = :TYPE_CODE, SUB_TYPE_CODE = :SUB_TYPE_CODE, ACTIVE_CODE = :ACTIVE_CODE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, TEMPLATE = :TEMPLATE, IS_TEMPLATE = :IS_TEMPLATE, ORGANIZATION_CODE = :ORGANIZATION_CODE, SITE_CODE = :SITE_CODE, ROLE = :ROLE WHERE id = :id")
    public int update(@BindBean() FgSiteMembership entity);

    @SqlQuery("DELETE FROM FG_SITE_MEMBERSHIP WHERE id = :id")
    public int delete(@Bind("id") String id);
}
