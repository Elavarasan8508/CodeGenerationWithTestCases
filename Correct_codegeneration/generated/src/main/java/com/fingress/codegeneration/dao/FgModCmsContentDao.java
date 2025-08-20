package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgModCmsContent;
import com.bsit.codegeneration.mapper.FgModCmsContentMapper;
import java.util.*;

@RegisterRowMapper(FgModCmsContentMapper.class)
public interface FgModCmsContentDao {

    @SqlQuery("SELECT * FROM FG_MOD_CMS_CONTENT")
    public List<FgModCmsContent> findAll();

    @SqlQuery("SELECT * FROM FG_MOD_CMS_CONTENT WHERE id = :id")
    public Optional<FgModCmsContent> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MOD_CMS_CONTENT(ID, VERSION_ID, OWNER_PARTY_CODE, OWNER_TYPE_CODE, SPACE_CODE, CONTENT_REF_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, NAME, TITLE, SUB_TITLE, DESCRIPTION, CONTENT_DATA, IS_MASTER_VERSION, PUBLISH_DATE, EXPIRE_DATE, STAGE_CODE, STATUS_CODE, ACTIVE_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:ID, :VERSION_ID, :OWNER_PARTY_CODE, :OWNER_TYPE_CODE, :SPACE_CODE, :CONTENT_REF_NO, :ENTITY_TYPE_CODE, :ENTITY_SUB_TYPE_CODE, :NAME, :TITLE, :SUB_TITLE, :DESCRIPTION, :CONTENT_DATA, :IS_MASTER_VERSION, :PUBLISH_DATE, :EXPIRE_DATE, :STAGE_CODE, :STATUS_CODE, :ACTIVE_CODE, :CREATED_BY, :CREATED_ON, :LAST_UPDATED_BY, :LAST_UPDATED_ON, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgModCmsContent entity);

    @SqlQuery("UPDATE FG_MOD_CMS_CONTENT SET ID = :ID, VERSION_ID = :VERSION_ID, OWNER_PARTY_CODE = :OWNER_PARTY_CODE, OWNER_TYPE_CODE = :OWNER_TYPE_CODE, SPACE_CODE = :SPACE_CODE, CONTENT_REF_NO = :CONTENT_REF_NO, ENTITY_TYPE_CODE = :ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE, NAME = :NAME, TITLE = :TITLE, SUB_TITLE = :SUB_TITLE, DESCRIPTION = :DESCRIPTION, CONTENT_DATA = :CONTENT_DATA, IS_MASTER_VERSION = :IS_MASTER_VERSION, PUBLISH_DATE = :PUBLISH_DATE, EXPIRE_DATE = :EXPIRE_DATE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, ACTIVE_CODE = :ACTIVE_CODE, CREATED_BY = :CREATED_BY, CREATED_ON = :CREATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON WHERE id = :id")
    public int update(@BindBean() FgModCmsContent entity);

    @SqlQuery("DELETE FROM FG_MOD_CMS_CONTENT WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
