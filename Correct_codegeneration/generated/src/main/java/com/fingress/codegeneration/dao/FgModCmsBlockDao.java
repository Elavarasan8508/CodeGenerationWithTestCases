package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgModCmsBlock;
import com.bsit.codegeneration.mapper.FgModCmsBlockMapper;
import java.util.*;

@RegisterRowMapper(FgModCmsBlockMapper.class)
public interface FgModCmsBlockDao {

    @SqlQuery("SELECT * FROM FG_MOD_CMS_BLOCK")
    public List<FgModCmsBlock> findAll();

    @SqlQuery("SELECT * FROM FG_MOD_CMS_BLOCK WHERE id = :id")
    public Optional<FgModCmsBlock> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MOD_CMS_BLOCK(ID, VERSION_ID, OWNER_PARTY_CODE, PARTY_TYPE_CODE, BLOCK_REF_NO, ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE, NAME, TITLE, SUB_TITLE, DESCRIPTION, BLOCK_DATA, IS_MASTER_VERSION, PUBLISH_DATE, EXPIRE_DATE, STAGE_CODE, STATUS_CODE, ACTIVE_CODE, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:ID, :VERSION_ID, :OWNER_PARTY_CODE, :PARTY_TYPE_CODE, :BLOCK_REF_NO, :ENTITY_TYPE_CODE, :ENTITY_SUB_TYPE_CODE, :NAME, :TITLE, :SUB_TITLE, :DESCRIPTION, :BLOCK_DATA, :IS_MASTER_VERSION, :PUBLISH_DATE, :EXPIRE_DATE, :STAGE_CODE, :STATUS_CODE, :ACTIVE_CODE, :CREATED_BY, :CREATED_ON, :LAST_UPDATED_BY, :LAST_UPDATED_ON, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgModCmsBlock entity);

    @SqlQuery("UPDATE FG_MOD_CMS_BLOCK SET ID = :ID, VERSION_ID = :VERSION_ID, OWNER_PARTY_CODE = :OWNER_PARTY_CODE, PARTY_TYPE_CODE = :PARTY_TYPE_CODE, BLOCK_REF_NO = :BLOCK_REF_NO, ENTITY_TYPE_CODE = :ENTITY_TYPE_CODE, ENTITY_SUB_TYPE_CODE = :ENTITY_SUB_TYPE_CODE, NAME = :NAME, TITLE = :TITLE, SUB_TITLE = :SUB_TITLE, DESCRIPTION = :DESCRIPTION, BLOCK_DATA = :BLOCK_DATA, IS_MASTER_VERSION = :IS_MASTER_VERSION, PUBLISH_DATE = :PUBLISH_DATE, EXPIRE_DATE = :EXPIRE_DATE, STAGE_CODE = :STAGE_CODE, STATUS_CODE = :STATUS_CODE, ACTIVE_CODE = :ACTIVE_CODE, CREATED_BY = :CREATED_BY, CREATED_ON = :CREATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON WHERE id = :id")
    public int update(@BindBean() FgModCmsBlock entity);

    @SqlQuery("DELETE FROM FG_MOD_CMS_BLOCK WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
