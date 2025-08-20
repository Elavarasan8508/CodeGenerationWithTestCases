package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgProductRole;
import com.bsit.codegeneration.mapper.FgProductRoleMapper;
import java.util.*;

@RegisterRowMapper(FgProductRoleMapper.class)
public interface FgProductRoleDao {

    @SqlQuery("SELECT * FROM FG_PRODUCT_ROLE")
    public List<FgProductRole> findAll();

    @SqlQuery("SELECT * FROM FG_PRODUCT_ROLE WHERE id = :id")
    public Optional<FgProductRole> findById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO FG_PRODUCT_ROLE(ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, PARTY_ROLE_CODE, ENTITY_REF_ID, ENTITY_VERSION_NO, PARTY_CODE, VALID_FROM, VALID_TO, ACTIVE_CODE, STATUS_CODE, CREATED_ON, CREATED_BY, LAST_UPDATED_ON, LAST_UPDATED_BY, LAST_AUTHORISED_ON, LAST_AUTHORISED_BY, UPLOAD_REF_ID, ID) VALUES (:ENTITY_TYPE_CODE, :ENTITY_SUB_TYPE_CODE, :PARTY_TYPE_CODE, :PARTY_SUB_TYPE_CODE, :PARTY_ROLE_CODE, :ENTITY_REF_ID, :ENTITY_VERSION_NO, :PARTY_CODE, :VALID_FROM, :VALID_TO, :ACTIVE_CODE, :STATUS_CODE, :CREATED_ON, :CREATED_BY, :LAST_UPDATED_ON, :LAST_UPDATED_BY, :LAST_AUTHORISED_ON, :LAST_AUTHORISED_BY, :UPLOAD_REF_ID, :ID)")
    @GetGeneratedKeys()
    public String insert(@BindBean() FgProductRole entity);

    @SqlQuery("UPDATE FG_PRODUCT_ROLE SET ENTITY_TYPE_CODE = :ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE, PARTY_TYPE_CODE = :PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE = :PARTY_SUB_TYPE_CODE, PARTY_ROLE_CODE = :PARTY_ROLE_CODE, ENTITY_REF_ID = :ENTITY_REF_ID, ENTITY_VERSION_NO = :ENTITY_VERSION_NO, PARTY_CODE = :PARTY_CODE, VALID_FROM = :VALID_FROM, VALID_TO = :VALID_TO, ACTIVE_CODE = :ACTIVE_CODE, STATUS_CODE = :STATUS_CODE, CREATED_ON = :CREATED_ON, CREATED_BY = :CREATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, UPLOAD_REF_ID = :UPLOAD_REF_ID, ID = :ID WHERE id = :id")
    public int update(@BindBean() FgProductRole entity);

    @SqlQuery("DELETE FROM FG_PRODUCT_ROLE WHERE id = :id")
    public int delete(@Bind("id") String id);
}
