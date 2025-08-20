package com.bsit.codegeneration.dao;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.bsit.codegeneration.record.FgModTagRel;
import com.bsit.codegeneration.mapper.FgModTagRelMapper;
import java.util.*;

@RegisterRowMapper(FgModTagRelMapper.class)
public interface FgModTagRelDao {

    @SqlQuery("SELECT * FROM FG_MOD_TAG_REL")
    public List<FgModTagRel> findAll();

    @SqlQuery("SELECT * FROM FG_MOD_TAG_REL WHERE id = :id")
    public Optional<FgModTagRel> findById(@Bind("id") Long id);

    @SqlUpdate("INSERT INTO FG_MOD_TAG_REL(ID, TAG_REFERENCE_NO, TARGET_ENTITY_TYPE_CODE, TARGET_ENTITY_SUB_TYPE_CODE, TARGET_ENTITY_REF_NO, TARGET_ENTITY_VERSIONID, CREATED_BY, CREATED_ON, LAST_UPDATED_BY, LAST_UPDATED_ON, LAST_AUTHORISED_BY, LAST_AUTHORISED_ON) VALUES (:ID, :TAG_REFERENCE_NO, :TARGET_ENTITY_TYPE_CODE, :TARGET_ENTITY_SUB_TYPE_CODE, :TARGET_ENTITY_REF_NO, :TARGET_ENTITY_VERSIONID, :CREATED_BY, :CREATED_ON, :LAST_UPDATED_BY, :LAST_UPDATED_ON, :LAST_AUTHORISED_BY, :LAST_AUTHORISED_ON)")
    @GetGeneratedKeys()
    public Long insert(@BindBean() FgModTagRel entity);

    @SqlQuery("UPDATE FG_MOD_TAG_REL SET ID = :ID, TAG_REFERENCE_NO = :TAG_REFERENCE_NO, TARGET_ENTITY_TYPE_CODE = :TARGET_ENTITY_TYPE_CODE, TARGET_ENTITY_SUB_TYPE_CODE = :TARGET_ENTITY_SUB_TYPE_CODE, TARGET_ENTITY_REF_NO = :TARGET_ENTITY_REF_NO, TARGET_ENTITY_VERSIONID = :TARGET_ENTITY_VERSIONID, CREATED_BY = :CREATED_BY, CREATED_ON = :CREATED_ON, LAST_UPDATED_BY = :LAST_UPDATED_BY, LAST_UPDATED_ON = :LAST_UPDATED_ON, LAST_AUTHORISED_BY = :LAST_AUTHORISED_BY, LAST_AUTHORISED_ON = :LAST_AUTHORISED_ON WHERE id = :id")
    public int update(@BindBean() FgModTagRel entity);

    @SqlQuery("DELETE FROM FG_MOD_TAG_REL WHERE id = :id")
    public int delete(@Bind("id") Long id);
}
