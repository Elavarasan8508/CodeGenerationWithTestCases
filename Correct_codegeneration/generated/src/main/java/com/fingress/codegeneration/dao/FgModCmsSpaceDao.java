package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgModCmsSpace;
import com.bsit.codegeneration.mapper.FgModCmsSpaceMapper;
import java.util.*;

@RegisterRowMapper(FgModCmsSpaceMapper.class)
public interface FgModCmsSpaceDao {

    @SqlQuery("SELECT * FROM FG_MOD_CMS_SPACE")
    public List<FgModCmsSpace> findAll();

    @SqlQuery("SELECT * FROM FG_MOD_CMS_SPACE WHERE id = :id")
    public Optional<FgModCmsSpace> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MOD_CMS_SPACE(ID, VERSION_ID, SPACE_CODE, PARENT_SPACE_CODE, PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, VISIBILITY_CODE, NAME, DESCRIPTION, PUBLISH_DATE, EXPIRE_DATE, STATUS_CODE, ACTIVE_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON, IS_MASTER_VERSION) VALUES (:ID, :VERSION_ID, :SPACE_CODE, :PARENT_SPACE_CODE, :PARTY_TYPE_CODE, :PARTY_SUB_TYPE_CODE, :ENTITY_TYPE_CODE, :ENTITY_SUB_TYPE_CODE, :VISIBILITY_CODE, :NAME, :DESCRIPTION, :PUBLISH_DATE, :EXPIRE_DATE, :STATUS_CODE, :ACTIVE_CODE, :CREATED_BY, :CREATED_ON, :LAST_UPDATED_BY, :LAST_UPDATED_ON, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON, :IS_MASTER_VERSION)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgModCmsSpace entity);

    @SqlQuery("UPDATE FG_MOD_CMS_SPACE SET ID = :ID, VERSION_ID = :VERSION_ID, SPACE_CODE = :SPACE_CODE, PARENT_SPACE_CODE = :PARENT_SPACE_CODE, PARTY_TYPE_CODE = :PARTY_TYPE_CODE, PARTY_SUB_TYPE_CODE = :PARTY_SUB_TYPE_CODE, ENTITY_TYPE_CODE = :ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE, VISIBILITY_CODE = :VISIBILITY_CODE, NAME = :NAME, DESCRIPTION = :DESCRIPTION, PUBLISH_DATE = :PUBLISH_DATE, EXPIRE_DATE = :EXPIRE_DATE, STATUS_CODE = :STATUS_CODE, ACTIVE_CODE = :ACTIVE_CODE, CREATED_BY = :CREATED_BY, CREATED_ON = :CREATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON, IS_MASTER_VERSION = :IS_MASTER_VERSION WHERE id = :id")
    public int update(@BindBean() FgModCmsSpace entity);

    @SqlQuery("DELETE FROM FG_MOD_CMS_SPACE WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
